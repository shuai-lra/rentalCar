package com.shuai.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.domain.Menu;
import com.shuai.sys.domain.Role;
import com.shuai.sys.domain.TreeNode;
import com.shuai.sys.mapper.MenuMapper;
import com.shuai.sys.mapper.RoleMapper;
import com.shuai.sys.service.RoleService;
import com.shuai.sys.vo.MenuVo;
import com.shuai.sys.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
        List<Role> data = roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addRole(RoleVo roleVo) {
        roleMapper.insertSelective(roleVo);
    }

    @Override
    public void updateRole(RoleVo roleVo) {
        roleMapper.updateByPrimaryKeySelective(roleVo);
    }

    @Override
    public void deleteRole(Integer roleid) {
        roleMapper.deleteByPrimaryKey(roleid);
        roleMapper.deleteRoleMenuByRid(roleid);
        roleMapper.deleteRoleUserByRid(roleid);
    }

    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer rid : ids) {
            deleteRole(rid);
        }
    }

    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        MenuVo menuVo = new MenuVo();
        menuVo.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> allMenu = menuMapper.queryAllMenu(menuVo);
        List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstant.AVAILABLE_TRUE,roleid);
        List<TreeNode> data = new ArrayList<>();
        for (Menu m1 : allMenu) {
            String checkArr = SysConstant.CODE_ZERO+"";
            for (Menu m2 : roleMenu) {
                if (m1.getId() == m2.getId()){
                    checkArr = SysConstant.CODE_ONE+"";
                    break;
                }
            }
            Integer id = m1.getId();
            Integer pid = m1.getPid();
            String title = m1.getTitle();
            Boolean spread = m1.getSpread() == SysConstant.SPREAD_TRUE?true:false;
            data.add(new TreeNode(id,pid,title,spread,checkArr));
        }
        return new DataGridView(data);
    }

    @Override
    public void saveRoleMenu(RoleVo roleVo) {
        Integer rid = roleVo.getRoleid();
        Integer[] mids = roleVo.getIds();
        roleMapper.deleteRoleMenuByRid(rid);
        for (Integer mid : mids) {
            roleMapper.insertRoleMenu(rid,mid);
        }
    }

}
