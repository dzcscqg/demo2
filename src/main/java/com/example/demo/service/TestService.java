package com.example.demo.service;

import com.example.demo.entity.Test;
import com.example.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    public List<Test> selectkcdz(String kcdz){
        return testMapper.selectkcdz(kcdz);
    }
    public List<Test> selecttest() {
        return testMapper.selecttest();
    }
    public List<Test> selectmid( int mid) {
        return testMapper.selectmid(mid);
    }
    public List<Test> selectmid2( int mid) {
        return testMapper.selectmid2(mid);
    }
    public int delectsession(Integer tId) {
        return testMapper.deleteByPrimaryKey(tId);
    }

    public Test selectkch(Integer kch) {
        return testMapper.selectkch(kch);
    }

    public Test selectid(Integer id) {
        return testMapper.selectid(id);
    }

    public int insert(Test test) {
        return testMapper.insertSelective(test);
    }
    public int changemid(Test test){
        return  testMapper.changemid(test);
    }
    public int updatesession(Test test) {
        return testMapper.updateByPrimaryKey(test);
    }
}