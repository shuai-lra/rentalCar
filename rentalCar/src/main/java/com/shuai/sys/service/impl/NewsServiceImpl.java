package com.shuai.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.domain.News;
import com.shuai.sys.mapper.NewsMapper;
import com.shuai.sys.service.NewsService;
import com.shuai.sys.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {
        Page<Object> page = PageHelper.startPage(newsVo.getPage(), newsVo.getLimit());
        List<News> data = newsMapper.queryAllNews(newsVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addNews(NewsVo newsVo) {
        newsMapper.insertSelective(newsVo);
    }

    @Override
    public void deleteNews(Integer id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateNews(NewsVo newsVo) {
        newsMapper.updateByPrimaryKeySelective(newsVo);
    }

    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer id : ids) {
            deleteNews(id);
        }
    }
}
