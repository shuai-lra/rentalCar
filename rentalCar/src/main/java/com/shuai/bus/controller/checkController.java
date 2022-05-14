package com.shuai.bus.controller;

import com.shuai.bus.domain.Rent;
import com.shuai.bus.service.CheckService;
import com.shuai.bus.service.RentService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CheckVo;
import com.shuai.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("check")
public class checkController {

    @Autowired
    private RentService rentService;

    @Autowired
    private CheckService checkService;

    @RequestMapping("checkRentExist")
    public Rent checkRentExist(String rentid){
        return rentService.queryRentByRentId(rentid);
    }

    @RequestMapping("initCheckFormData")
    public Map<String,Object> initCheckFormData(String rentid){
        return checkService.initCheckFormData(rentid);
    }

    @RequestMapping("saveCheck")
    public ResultObj saveCheck(CheckVo checkVo){
        try {
            checkVo.setCreatetime(new Date());
            checkService.addCheck(checkVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("loadAllCheck")
    public DataGridView loadAllCheck(CheckVo checkVo){
        return checkService.queryAllCheck(checkVo);
    }

    @RequestMapping("updateCheck")
    public ResultObj updateCheck(CheckVo checkVo){
        try {
            checkService.updateCheck(checkVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @RequestMapping("deleteCheck")
    public ResultObj deleteCheck(CheckVo checkVo){
        try {
            checkService.deleteCheck(checkVo);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("deleteBatchCheck")
    public ResultObj deleteBatchCheck(CheckVo checkVo){
        try {
            checkService.deleteBatchCheck(checkVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
