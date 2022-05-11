package com.shuai.sys.service.impl;

import com.shuai.sys.mapper.AccountMapper;
import com.shuai.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int updateTransfer(String inName, String outName, Double money) {
        try {
            accountMapper.transferIn(inName,money);
            accountMapper.transferOut(outName,money);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return -1;
    }
}
