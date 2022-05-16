package com.shuai.sys.mapper;

import com.shuai.sys.domain.Menu;
import com.shuai.sys.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<Menu> queryAllMenu(MenuVo menuVo);

    void insertSelective(MenuVo menuVo);

    void updateByPrimaryKeySelective(MenuVo menuVo);

    void deleteByPrimaryKey(Integer id);

    Integer queryMenuByPid(Integer pid);

    List<Menu> queryMenuByRoleId(@Param("available") Integer availableTrue, @Param("rid") Integer roleid);
}
