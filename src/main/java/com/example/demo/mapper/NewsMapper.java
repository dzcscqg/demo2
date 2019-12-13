package com.example.demo.mapper;

import com.example.demo.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    /**
     * 全选
     */
    List<News> selectAll(@Param("nTitle") String nTitle, String sortFlag);

    /**
     * 全选（不带参数）
     */
    List<News> selectAll2();

    /**
     * 按主键选择
     */
    News selectByPrimaryKey(Integer nId);

    /**
     * 按主键删除
     */
    int deleteByPrimaryKey(Integer nId);

    /**
     * 按主键批量删除
     */
    int deleteByBatch(@Param("nIds") String[] nIds);

    /**
     * 插入
     */
    int insert(News record);

    /**
     * 按主键更新
     */
    int updateByPrimaryKey(News news);


    /*以下方法未用到*/
    int insertSelective(News record);

    int updateByPrimaryKeySelective(News record);

    List<News> selectTitleAndDate();

    int updateByPrimaryKeyWithBLOBs();

}