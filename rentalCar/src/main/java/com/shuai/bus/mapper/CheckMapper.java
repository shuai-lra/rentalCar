package com.shuai.bus.mapper;

import com.shuai.bus.domain.Check;
import com.shuai.bus.vo.CheckVo;

import java.util.List;

public interface CheckMapper {
    void insertSelective(CheckVo checkVo);

    List<Check> queryAllCheck(CheckVo checkVo);

    void updateByPrimaryKeySelective(CheckVo checkVo);

    void deleteByPrimaryKey(String checkid);
}
