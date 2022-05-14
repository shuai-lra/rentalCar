package com.shuai.bus.mapper;

import com.shuai.bus.domain.Rent;
import com.shuai.bus.vo.RentVo;

import java.util.List;

public interface RentMapper {
    void insertSelective(RentVo rentVo);

    List<Rent> queryAllRent(RentVo rentVo);

    void updateByPrimaryKeySelective(Rent rentVo);

    Rent selectByPrimaryKey(String rentid);

    void deleteByPrimaryKey(String rentid);

}
