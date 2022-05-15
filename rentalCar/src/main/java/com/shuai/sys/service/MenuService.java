package com.shuai.sys.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.domain.Menu;
import com.shuai.sys.vo.MenuVo;

import java.util.List;

public interface MenuService {
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    DataGridView queryAllMenu(MenuVo menuVo);

    void addMenu(MenuVo menuVo);

    void updateMenu(MenuVo menuVo);

    void deleteMenu(MenuVo menuVo);

    Integer queryMenuByPid(Integer id);
}
