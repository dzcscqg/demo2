package com.example.demo.mapper;

import com.example.demo.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    int deleteByPrimaryKey(Integer tId);

    int changemid(Test test);
    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(@Param("test") Test test);

    int updateByPrimaryKey(Test record);

    Test selectkch(Integer kch);
    Test selectid(Integer id);
    List<Test>selectmid2(int mid);
    List<Test> selectmid(int mid);
    List<Test> selectkcdz(String kcdz);
    List<Test> selecttest();
}