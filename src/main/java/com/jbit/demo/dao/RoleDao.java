package com.jbit.demo.dao;
import	java.security.Provider.Service;
import	java.util.Map;

import com.jbit.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {
    Role selectByPrimaryKey(Integer id);

    public List<Role> getRolesByUserName(String userName);
}