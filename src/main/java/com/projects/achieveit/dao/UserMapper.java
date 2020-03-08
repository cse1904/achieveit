package com.projects.achieveit.dao;

import com.projects.achieveit.po.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

}