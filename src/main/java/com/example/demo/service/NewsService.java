package com.example.demo.service;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public News getNews(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    public List<News> getTitleAndDate() {
        return newsMapper.selectTitleAndDate();
    }

    /**
     * 全选
     */
    public List<News> selectAll(String n_title, String sortFlag) {
        return newsMapper.selectAll(n_title, sortFlag);
    }

    /**
     * 全选（不带参数）
     */
    public List<News> selectAll2() {
        return newsMapper.selectAll2();
    }

    /**
     * 按主键选择
     */
    public News selectByPrimaryKey(int n_id) {
        return newsMapper.selectByPrimaryKey(n_id);
    }

    /**
     * 按主键删除
     */
    public int deleteByPrimaryKey(int n_id) {
        return newsMapper.deleteByPrimaryKey(n_id);
    }

    /**
     * 按主键批量删除
     */
    public int deleteByBatch(String[] n_ids) {
        return newsMapper.deleteByBatch(n_ids);
    }

    /**
     * 插入
     */
    public int insert(News news) {
        return newsMapper.insert(news);
    }

    /**
     * 按主键更新
     */
    public int update(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }
}
