package com.example.demo.service;

import com.example.demo.entity.Campus;
import com.example.demo.mapper.CampusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusService {
    @Autowired
    private CampusMapper campusMapper;
    public List<Campus> selectcampuses(){
        return campusMapper.selectcampuses();
    }
}
