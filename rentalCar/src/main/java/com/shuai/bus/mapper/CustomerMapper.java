package com.shuai.bus.mapper;

import com.shuai.bus.domain.Customer;
import com.shuai.bus.vo.CustomerVo;

import java.util.List;

public interface CustomerMapper {
    List<Customer> queryAllCustomer(CustomerVo customerVo);

    int insertSelective(CustomerVo customerVo);

    void deleteByPrimaryKey(String identity);

    void updateByPrimaryKey(CustomerVo customerVo);

    Customer selectByPrimaryKey(String identity);
}
