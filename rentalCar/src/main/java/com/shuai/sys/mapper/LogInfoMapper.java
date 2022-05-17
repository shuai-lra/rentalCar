package com.shuai.sys.mapper;

import com.shuai.sys.domain.LogInfo;
import com.shuai.sys.vo.LogInfoVo;

import java.util.List;

public interface LogInfoMapper {
    List<LogInfo> queryAllLogInfo(LogInfoVo logInfoVo);

    void deleteByPrimaryKey(Integer id);
}
