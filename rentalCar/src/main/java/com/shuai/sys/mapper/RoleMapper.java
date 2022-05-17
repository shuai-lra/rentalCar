package com.shuai.sys.mapper;

import com.shuai.sys.domain.Role;
import com.shuai.sys.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> queryAllRole(RoleVo roleVo);

    void insertSelective(RoleVo roleVo);

    void updateByPrimaryKeySelective(RoleVo roleVo);

    void deleteByPrimaryKey(Integer roleid);

    void deleteRoleMenuByRid(Integer roleid);

    void deleteRoleUserByRid(Integer roleid);

    void insertRoleMenu(@Param("rid") Integer rid, @Param("mid") Integer mid);

    void deleteRoleUserByUid(Integer userid);

    List<Role> queryRoleByUid(@Param("available") Integer availableTrue, @Param("uid") Integer userid);

    void dedeleteRoleUserByUid(Integer userid);
}
