package com.shuai.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.domain.Car;
import com.shuai.bus.mapper.CarMapper;
import com.shuai.bus.service.CarService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        Page<Object> page = PageHelper.startPage(carVo.getPage(), carVo.getLimit());
        List<Car> data = carMapper.queryAllCar(carVo);
        DataGridView dataGridView = new DataGridView(page.getTotal(), data);
        return dataGridView;
    }

    @Override
    public void addCar(CarVo carVo) {
        carMapper.insertSelective(carVo);
    }
}
