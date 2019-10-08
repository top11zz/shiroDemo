package com.jbit.demo.dao;

import com.jbit.demo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao {
    UserRole selectByPrimaryKey(Integer id);
}