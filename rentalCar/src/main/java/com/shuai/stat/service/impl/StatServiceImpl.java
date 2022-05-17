package com.shuai.stat.service.impl;

import com.shuai.stat.domain.BaseEntity;
import com.shuai.stat.mapper.StatMapper;
import com.shuai.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadCustomerAreaStatList() {
        return statMapper.queryCustomerAreaStat();
    }

    @Override
    public List<Double> loadCompanyYearGradeStatList(String year) {
        return statMapper.queryCompanyYearGradeStat(year);
    }

    @Override
    public List<BaseEntity> loadOpernameYearGradeStatList(String year) {
        return statMapper.queryOpernameYearGradeStat(year);
    }
}
