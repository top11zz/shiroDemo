package com.jbit.demo.dao;

import com.jbit.demo.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PermissionDao {
    Permission selectByPrimaryKey(Integer id);

    public List<Permission> getPermissionsByUserName(String userName);
}