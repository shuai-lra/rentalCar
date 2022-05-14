package com.shuai.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.domain.Car;
import com.shuai.bus.domain.Check;
import com.shuai.bus.domain.Customer;
import com.shuai.bus.domain.Rent;
import com.shuai.bus.mapper.CarMapper;
import com.shuai.bus.mapper.CheckMapper;
import com.shuai.bus.mapper.CustomerMapper;
import com.shuai.bus.mapper.RentMapper;
import com.shuai.bus.service.CheckService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CheckVo;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.domain.User;
import com.shuai.sys.utils.RandomUtils;
import com.shuai.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public Map<String, Object> initCheckFormData(String rentid) {
        Rent rent = rentMapper.selectByPrimaryKey(rentid);
        Customer customer = customerMapper.selectByPrimaryKey(rent.getIdentity());
        Car car = carMapper.selectByPrimaryKey(rent.getCarnumber());
        Check check = new Check();
        check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_JC));
        check.setRentid(rentid);
        check.setCreatetime(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        HashMap<String, Object> map = new HashMap<>();
        map.put("rent",rent);
        map.put("customer",customer);
        map.put("car",car);
        map.put("check",check);
        return map;
    }

    @Override
    public void addCheck(CheckVo checkVo) {
        checkMapper.insertSelective(checkVo);
        Rent rent = rentMapper.selectByPrimaryKey(checkVo.getRentid());
        rent.setRentflag(SysConstant.RENT_BACK_TRUE);
        rentMapper.updateByPrimaryKeySelective(rent);
        Car car = carMapper.selectByPrimaryKey(rent.getCarnumber());
        car.setIsrenting(SysConstant.RENT_BACK_FALSE);
        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public DataGridView queryAllCheck(CheckVo checkVo) {

        Page<Object> page = PageHelper.startPage(checkVo.getPage(), checkVo.getLimit());
        List<Check> data = checkMapper.queryAllCheck(checkVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void updateCheck(CheckVo checkVo) {
        checkMapper.updateByPrimaryKeySelective(checkVo);
    }

    @Override
    public void deleteCheck(CheckVo checkVo) {
        checkMapper.deleteByPrimaryKey(checkVo.getCheckid());
    }

    @Override
    public void deleteBatchCheck(String[] ids) {
        for (String id : ids) {
            checkMapper.deleteByPrimaryKey(id);
        }
    }

}
