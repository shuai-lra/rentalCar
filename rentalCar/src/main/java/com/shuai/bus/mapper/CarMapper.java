package com.shuai.bus.mapper;

import com.shuai.bus.domain.Car;
import com.shuai.bus.vo.CarVo;

import java.util.List;

public interface CarMapper {
    List<Car> queryAllCar(CarVo carVo);

    void insertSelective(CarVo carVo);

    Car selectByPrimaryKey(String carnumber);

    void deleteByPrimaryKey(String carnumber);

    void updateByPrimaryKeySelective(CarVo carVo);
}
