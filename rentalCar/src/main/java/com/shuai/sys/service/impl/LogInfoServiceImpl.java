package com.shuai.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.domain.LogInfo;
import com.shuai.sys.mapper.LogInfoMapper;
import com.shuai.sys.service.LogInfoService;
import com.shuai.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {
        Page<Object> page = PageHelper.startPage(logInfoVo.getPage(), logInfoVo.getLimit());
        List<LogInfo> data = logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void deleteLogInfo(Integer id) {
        logInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatchLogInfo(Integer[] ids) {
        for (Integer id : ids) {
            deleteLogInfo(id);
        }
    }
}
