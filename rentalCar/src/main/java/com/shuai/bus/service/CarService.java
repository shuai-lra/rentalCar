package com.shuai.bus.service;

import com.shuai.bus.domain.Car;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CarVo;

public interface CarService {
    DataGridView queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);

    void deleteCar(String carnumber);

    Car queryCarByCarNumber(String carnumber);

    void updateCar(CarVo carVo);

    void deleteBatchCar(String[] ids);
}
