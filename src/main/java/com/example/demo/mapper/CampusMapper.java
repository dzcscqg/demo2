package com.example.demo.mapper;

import com.example.demo.entity.Campus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusMapper {
    int deleteByPrimaryKey(Integer mId);
    List<Campus> selectcampuses();
    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);
}