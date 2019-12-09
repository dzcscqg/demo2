package com.example.demo.mapper;

import com.example.demo.entity.Campus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CampusMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(Integer mId);

    List<Campus> selectAll();

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);
}