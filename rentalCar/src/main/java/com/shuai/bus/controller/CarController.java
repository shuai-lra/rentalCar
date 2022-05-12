package com.shuai.bus.controller;

import com.shuai.bus.service.CarService;
import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CarVo;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.utils.AppFileUtils;
import com.shuai.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("loadAllCar")
    public DataGridView loadAllCar(CarVo carVo){
        return carService.queryAllCar(carVo);
    }

    @RequestMapping("addCar")
    public ResultObj addCar(CarVo carVo){
        try {
            carVo.setCreatetime(new Date());
            if (carVo.getCarimg().equals(SysConstant.DEFAULT_CAR_IMG)){
                String filePath = AppFileUtils.updateFileName(carVo.getCarimg(), SysConstant.FILE_UPLOAD_TEMP);
                carVo.setCarimg(filePath);
            }
            carService.addCar(carVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
