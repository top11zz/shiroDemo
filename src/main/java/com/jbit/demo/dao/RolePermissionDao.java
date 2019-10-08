package com.jbit.demo.dao;
import	java.util.Map;

import com.jbit.demo.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionDao {
    RolePermission selectByPrimaryKey(Integer id);
}