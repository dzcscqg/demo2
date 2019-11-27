package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public  Role getInfo(int limited){
        return roleMapper.selectByLimited(limited);
    }

    public List<Role> selectAll(String search){

        return roleMapper.selectAll(search);
    }
    public int updateSelect(Role role){

        return roleMapper.updateByPrimaryKeySelective(role);
    }
    public int del(int id){
        return roleMapper.deleteByPrimaryKey(id);
    }
    public int add(Role role){
        return roleMapper.insertSelective(role);
    }

    public List<Role> selectAll2(){
        return roleMapper.selectAll2();
    }


}
