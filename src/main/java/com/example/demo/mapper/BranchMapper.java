package com.example.demo.mapper;

import com.example.demo.entity.Branch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Integer bId);

    List<Branch> selectByEid(int eId);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);
}