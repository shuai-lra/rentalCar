package com.shuai.stat.service;

import com.shuai.stat.domain.BaseEntity;

import java.util.List;

public interface StatService {
    List<BaseEntity> loadCustomerAreaStatList();

    List<Double> loadCompanyYearGradeStatList(String year);

    List<BaseEntity> loadOpernameYearGradeStatList(String year);
}
