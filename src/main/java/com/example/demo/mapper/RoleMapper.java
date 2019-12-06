package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rId);

    Role selctByAccount(String account);

    Role selectByLimited(int limited);

    List<Role> selectAll(@Param("search") String search);
    List<Role> selectAll2();
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}