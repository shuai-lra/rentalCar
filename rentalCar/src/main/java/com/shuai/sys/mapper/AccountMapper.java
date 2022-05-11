package com.shuai.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    public void transferIn(@Param("name") String inName, @Param("money") Double money);

    public void transferOut(@Param("name") String outName, @Param("money") Double money);
}
