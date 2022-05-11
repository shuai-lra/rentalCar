package com.shuai.sys.service;

import com.shuai.sys.domain.User;
import com.shuai.sys.vo.UserVo;

public interface UserService {
    User login(UserVo userVo);
}
