package com.shuai.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.domain.Car;
import com.shuai.bus.mapper.CarMapper;
import com.shuai.bus.service.CarService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CarVo;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.utils.AppFileUtils;
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

    @Override
    public void deleteCar(String carnumber) {
        Car car = carMapper.selectByPrimaryKey(carnumber);
        if (!SysConstant.DEFAULT_CAR_IMG.equals(car.getCarimg())){
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        carMapper.deleteByPrimaryKey(carnumber);
    }

    @Override
    public Car queryCarByCarNumber(String carnumber) {
        Car car = carMapper.selectByPrimaryKey(carnumber);
        return car;
    }

    @Override
    public void updateCar(CarVo carVo) {
        carMapper.updateByPrimaryKeySelective(carVo);
    }

    @Override
    public void deleteBatchCar(String[] ids) {
        for (String carnumber : ids) {
            this.deleteCar(carnumber);
        }
    }
}
