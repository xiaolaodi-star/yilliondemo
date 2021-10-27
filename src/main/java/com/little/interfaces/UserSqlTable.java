package com.little.interfaces;

import com.little.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface UserSqlTable {
    List<User> getUser();
}
