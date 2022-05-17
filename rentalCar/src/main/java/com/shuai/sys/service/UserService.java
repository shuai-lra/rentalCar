package com.shuai.sys.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.domain.User;
import com.shuai.sys.vo.UserVo;

public interface UserService {
    User login(UserVo userVo);

    DataGridView queryAllUser(UserVo userVo);

    void addUser(UserVo userVo);

    void updateUser(UserVo userVo);

    void deleteUser(Integer userid);

    void deleteBatchUser(Integer[] ids);

    void resetUserPwd(UserVo userVo);

    DataGridView queryUserRole(Integer userid);

    void saveUserRole(UserVo userVo);
}
