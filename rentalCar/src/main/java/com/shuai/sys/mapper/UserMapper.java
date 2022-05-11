package com.shuai.sys.mapper;

import com.shuai.sys.domain.User;
import com.shuai.sys.vo.UserVo;

public interface UserMapper {
    User login(UserVo userVo);
}
