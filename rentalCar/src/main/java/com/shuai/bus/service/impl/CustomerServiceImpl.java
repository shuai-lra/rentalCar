package com.shuai.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.domain.Customer;
import com.shuai.bus.mapper.CustomerMapper;
import com.shuai.bus.service.CustomerService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
        List<Customer> data = customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.insertSelective(customerVo);
    }

    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteByPrimaryKey(identity);
    }

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateByPrimaryKey(customerVo);
    }

    @Override
    public void deleteBatchCustomer(String[] ids) {
        for (String identity : ids) {
            customerMapper.deleteByPrimaryKey(identity);
        }
    }

    @Override
    public Customer queryCustomerByIdentity(String identity) {
        return customerMapper.selectByPrimaryKey(identity);
    }

}
