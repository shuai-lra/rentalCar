package com.shuai.sys.controller;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.service.UserService;
import com.shuai.sys.utils.ResultObj;
import com.shuai.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo){
        return userService.queryAllUser(userVo);
    }

    @RequestMapping("addUser")
    public ResultObj addUser(UserVo userVo){
        try {
            userService.addUser(userVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("updateUser")
    public ResultObj updateUser(UserVo userVo){
        try {
            userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @RequestMapping("deleteUser")
    public ResultObj deleteUser(UserVo userVo){
        try {
            userService.deleteUser(userVo.getUserid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("deleteBatchUser")
    public ResultObj deleteBatchUser(UserVo userVo){
        try {
            userService.deleteBatchUser(userVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(UserVo userVo){
        try {
            userService.resetUserPwd(userVo);
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }

    @RequestMapping("initUserRole")
    public DataGridView initUserRole(UserVo userVo){
        return userService.queryUserRole(userVo.getUserid());
    }

    @RequestMapping("saveUserRole")
    public ResultObj saveUserRole(UserVo userVo){
        try {
            userService.saveUserRole(userVo);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }
}
