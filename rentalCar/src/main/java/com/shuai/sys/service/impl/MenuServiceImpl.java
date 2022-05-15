package com.shuai.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.domain.Menu;
import com.shuai.sys.mapper.MenuMapper;
import com.shuai.sys.service.MenuService;
import com.shuai.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page = PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
        List<Menu> data = menuMapper.queryAllMenu(menuVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addMenu(MenuVo menuVo) {
        menuMapper.insertSelective(menuVo);
    }

    @Override
    public void updateMenu(MenuVo menuVo) {
        menuMapper.updateByPrimaryKeySelective(menuVo);
    }

    @Override
    public void deleteMenu(MenuVo menuVo) {
        menuMapper.deleteByPrimaryKey(menuVo.getId());
    }

    @Override
    public Integer queryMenuByPid(Integer id) {
        return menuMapper.queryMenuByPid(id);
    }

}
