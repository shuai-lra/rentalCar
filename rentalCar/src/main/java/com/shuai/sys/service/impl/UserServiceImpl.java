package com.shuai.sys.service.impl;

import com.shuai.sys.domain.User;
import com.shuai.sys.mapper.UserMapper;
import com.shuai.sys.service.UserService;
import com.shuai.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserVo userVo) {
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        User user = userMapper.login(userVo);
        return user;
    }
}
