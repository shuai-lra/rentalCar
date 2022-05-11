package com.shuai.sys.controller;

import com.shuai.sys.service.AccountService;
import com.shuai.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer")
    @ResponseBody
    public ResultObj accountTransfer(String inName,String outName,Double money){

        int status = accountService.updateTransfer(inName,outName,money);
        if (status == 0) {
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }
}
