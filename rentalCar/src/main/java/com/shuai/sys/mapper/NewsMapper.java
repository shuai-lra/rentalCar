package com.shuai.sys.mapper;

import com.shuai.sys.domain.News;
import com.shuai.sys.vo.NewsVo;

import java.util.List;

public interface NewsMapper {
    List<News> queryAllNews(NewsVo newsVo);

    void insertSelective(NewsVo newsVo);

    void deleteByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(NewsVo newsVo);
}
