package com.shuai.bus.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CustomerVo;

public interface CustomerService {
    DataGridView queryAllCustomer(CustomerVo customerVo);

    void addCustomer(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    void deleteBatchCustomer(String[] ids);
}
