package com.example.demo.service;

import com.example.demo.entity.Permis;
import com.example.demo.mapper.PermisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermisService {
    @Autowired
    private PermisMapper permisMapper;
    public int insert(Permis permis){
        return permisMapper.insertSelective(permis);
    }
    public int selectByThreeId(int eid,int cid){
        return permisMapper.selectByTwoId(eid,cid);
    }

    public int update(Permis permis){
        return permisMapper.updateByPrimaryKeySelective(permis);
    }
}
