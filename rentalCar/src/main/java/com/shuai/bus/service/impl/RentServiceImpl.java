package com.shuai.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.domain.Car;
import com.shuai.bus.domain.Rent;
import com.shuai.bus.mapper.CarMapper;
import com.shuai.bus.mapper.RentMapper;
import com.shuai.bus.service.RentService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CarVo;
import com.shuai.bus.vo.RentVo;
import com.shuai.sys.constant.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addRent(RentVo rentVo) {
        rentMapper.insertSelective(rentVo);
        CarVo carVo = new CarVo();
        carVo.setCarnumber(rentVo.getCarnumber());
        carVo.setIsrenting(SysConstant.RENT_BACK_TRUE);
        carMapper.updateByPrimaryKeySelective(carVo);
    }

    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Object> page = PageHelper.startPage(rentVo.getPage(), rentVo.getLimit());
        List<Rent> data = rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void updateRent(RentVo rentVo) {
        rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public void deleteRent(String rentid) {
        Rent rent = rentMapper.selectByPrimaryKey(rentid);
        CarVo carVo = new CarVo();
        carVo.setCarnumber(rent.getCarnumber());
        carVo.setIsrenting(SysConstant.RENT_CAR_FALSE);
        carMapper.updateByPrimaryKeySelective(carVo);
        rentMapper.deleteByPrimaryKey(rentid);
    }

    @Override
    public Rent queryRentByRentId(String rentid) {
        return rentMapper.selectByPrimaryKey(rentid);
    }
}
