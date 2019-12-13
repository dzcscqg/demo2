package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.entity.Permis;
import com.example.demo.mapper.PermisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Permis> selectByCid(int id){
        return permisMapper.selectByCid(id);
    }

    public  List<Order> selectUnite(int id){
        return permisMapper.selectUnite(id);
    }
}
