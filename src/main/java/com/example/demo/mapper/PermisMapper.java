package com.example.demo.mapper;

import com.example.demo.entity.Permis;
import com.example.demo.entity.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisMapper {
    int deleteByPrimaryKey(Integer pId);
    List<Permis> selectpermis();
    List<Permis> selectpermis2(String mname);
    int insert(Permis record);

    int insertSelective(Permis record);

    Permis selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Permis record);

    int updateByPrimaryKey(Permis record);
}