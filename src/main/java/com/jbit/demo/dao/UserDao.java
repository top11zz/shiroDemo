package com.jbit.demo.dao;

import com.jbit.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectByPrimaryKey(Integer id);

    User getUserByUserName(String userName);
}