package com.example.demo.mapper;

import com.example.demo.entity.Permis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Permis record);

    int insertSelective(Permis record);

    Permis selectByPrimaryKey(Integer pId);

   int  selectByTwoId(@Param("eid") int eid,@Param("cid")int cid);

    List<Permis> selectByCid(int id);


    int updateByPrimaryKeySelective(Permis record);

    int updateByPrimaryKey(Permis record);
}