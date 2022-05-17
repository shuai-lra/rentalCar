package com.shuai.sys.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.vo.LogInfoVo;

public interface LogInfoService {
    DataGridView queryAllLogInfo(LogInfoVo logInfoVo);

    void deleteLogInfo(Integer id);

    void deleteBatchLogInfo(Integer[] ids);
}
