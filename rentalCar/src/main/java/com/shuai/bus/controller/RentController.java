package com.shuai.bus.controller;

import com.shuai.bus.domain.Customer;
import com.shuai.bus.service.CustomerService;
import com.shuai.bus.service.RentService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.RentVo;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.domain.User;
import com.shuai.sys.utils.RandomUtils;
import com.shuai.sys.utils.ResultObj;
import com.shuai.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("checkCustomerExist")
    public ResultObj checkCustomerExist(RentVo rentVo){
        Customer customer = customerService.queryCustomerByIdentity(rentVo.getIdentity());
        if (customer != null) {
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }

    @RequestMapping("initRentFrom")
    public RentVo initRentFrom(RentVo rentVo){
        rentVo.setRentid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_CZ));
        rentVo.setBegindate(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        rentVo.setOpername(user.getRealname());
        return rentVo;
    }

    @RequestMapping("saveRent")
    public ResultObj saveRent(RentVo rentVo){
        try {
            rentVo.setCreatetime(new Date());
            rentVo.setRentflag(SysConstant.RENT_BACK_FALSE);
            rentService.addRent(rentVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("loadAllRent")
    public DataGridView loadAllRent(RentVo rentVo){
        return rentService.queryAllRent(rentVo);
    }

    @RequestMapping("updateRent")
    public ResultObj updateRent(RentVo rentVo){
        try {
            rentService.updateRent(rentVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @RequestMapping("deleteRent")
    public ResultObj deleteRent(String rentid){
        try {
            rentService.deleteRent(rentid);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
