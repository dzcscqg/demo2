package com.example.demo.service;

import com.example.demo.entity.Permis;
import com.example.demo.entity.Test;
import com.example.demo.mapper.PermisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisService {
    @Autowired
    private PermisMapper permisMapper;
    public List<Permis> selectpermis(){
        return permisMapper.selectpermis();
    }
    public List<Permis> selectpermis2(String mname){
        return permisMapper.selectpermis2(mname);
    }
    public int updategrade(Permis permis){
        return 0;
       // return permisMapper.updategrade(permis);
    }
}
