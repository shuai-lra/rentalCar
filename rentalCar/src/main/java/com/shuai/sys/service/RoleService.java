package com.shuai.sys.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.vo.RoleVo;

public interface RoleService {
    DataGridView queryAllRole(RoleVo roleVo);

    void addRole(RoleVo roleVo);

    void updateRole(RoleVo roleVo);

    void deleteRole(Integer roleid);

    void deleteBatchRole(Integer[] ids);

    DataGridView initRoleMenuTreeJson(Integer roleid);

    void saveRoleMenu(RoleVo roleVo);
}
