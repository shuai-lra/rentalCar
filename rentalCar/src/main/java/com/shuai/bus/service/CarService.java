package com.shuai.bus.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CarVo;

public interface CarService {
    DataGridView queryAllCar(CarVo carVo);

    void addCar(CarVo carVo);
}
