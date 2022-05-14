package com.shuai.bus.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.bus.vo.CheckVo;

import java.util.Map;

public interface CheckService {
    Map<String, Object> initCheckFormData(String rentid);

    void addCheck(CheckVo checkVo);

    DataGridView queryAllCheck(CheckVo checkVo);

    void updateCheck(CheckVo checkVo);

    void deleteCheck(CheckVo checkVo);

    void deleteBatchCheck(String[] ids);
}
