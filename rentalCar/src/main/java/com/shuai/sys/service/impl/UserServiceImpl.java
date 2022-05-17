package com.shuai.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.domain.Role;
import com.shuai.sys.domain.User;
import com.shuai.sys.mapper.RoleMapper;
import com.shuai.sys.mapper.UserMapper;
import com.shuai.sys.service.UserService;
import com.shuai.sys.vo.RoleVo;
import com.shuai.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(UserVo userVo) {
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        User user = userMapper.login(userVo);
        return user;
    }

    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
        List<User> data = userMapper.queryAllUser(userVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addUser(UserVo userVo) {
        userVo.setType(SysConstant.USER_TYPE_NORMAL);
        userMapper.insertSelective(userVo);
    }

    @Override
    public void updateUser(UserVo userVo) {
        userMapper.updateByPrimaryKeySelective(userVo);
    }

    @Override
    public void deleteUser(Integer userid) {
        userMapper.deleteByPrimaryKey(userid);
        roleMapper.deleteRoleUserByUid(userid);
    }

    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer userid : ids) {
            deleteUser(userid);
        }
    }

    @Override
    public void resetUserPwd(UserVo userVo) {
        userVo.setUserid(userVo.getUserid());
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        userMapper.updateByPrimaryKeySelective(userVo);
    }

    @Override
    public DataGridView queryUserRole(Integer userid) {
        RoleVo role = new RoleVo();
        role.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Role> allRole = roleMapper.queryAllRole(role);
        List<Role> userRole = roleMapper.queryRoleByUid(SysConstant.AVAILABLE_TRUE,userid);
        ArrayList<Map<String,Object>> data = new ArrayList<>();
        for (Role r1 : allRole) {
            Boolean LAY_CHECKED=false;
            for (Role r2 : userRole) {
                if (r1.getRoleid() == r2.getRoleid()){
                    LAY_CHECKED = true;
                }
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("roleid",r1.getRoleid());
            map.put("rolename",r1.getRolename());
            map.put("roledesc",r1.getRoledesc());
            map.put("LAY_CHECKED",LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }

    @Override
    public void saveUserRole(UserVo userVo) {
        Integer userid = userVo.getUserid();
        Integer[] roleIds = userVo.getIds();
        roleMapper.dedeleteRoleUserByUid(userid);
        if (roleIds != null && roleIds.length > 0) {
            for (Integer rid : roleIds) {
                userMapper.insertUserRole(userid,rid);
            }
        }
    }
}
