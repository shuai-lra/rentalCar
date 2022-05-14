package com.shuai.bus.service;

import com.shuai.bus.domain.Rent;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.RentVo;

public interface RentService {
    void addRent(RentVo rentVo);

    DataGridView queryAllRent(RentVo rentVo);

    void updateRent(RentVo rentVo);

    void deleteRent(String rentid);

    Rent queryRentByRentId(String rentid);
}
