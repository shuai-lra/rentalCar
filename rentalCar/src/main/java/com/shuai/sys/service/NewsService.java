package com.shuai.sys.service;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.vo.NewsVo;

public interface NewsService {
    DataGridView queryAllNews(NewsVo newsVo);

    void addNews(NewsVo newsVo);

    void deleteNews(Integer id);

    void updateNews(NewsVo newsVo);

    void deleteBatchNews(Integer[] ids);
}
