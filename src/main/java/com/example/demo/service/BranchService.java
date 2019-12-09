package com.example.demo.service;

import com.example.demo.entity.Branch;
import com.example.demo.mapper.BranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchMapper branchMapper;

    public List<Branch> selectByEid(int id){
       return branchMapper.selectByEid(id) ;
    }
    public Branch selectByPrimaryKey(int id){
        return branchMapper.selectByPrimaryKey(id);
    }
}
