package com.example.demo.mapper;

import com.example.demo.entity.Rj;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RjMapper {
    int deleteByPrimaryKey(Integer rjId);

    int insert(Rj record);

    int insertSelective(Rj record);

    Rj selectByPrimaryKey(Integer rjId);
    List<Rj> selectByRid(int rid);
    int updateByPrimaryKeySelective(Rj record);

    int updateByPrimaryKeySelective2(Rj record);

    int updateByPrimaryKey(Rj record);
}