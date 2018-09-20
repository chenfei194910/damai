package com.damai.dao.jdbctemplate;

import java.util.List;

import com.damai.system.entity.UserRole;

public interface JUserRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    List<UserRole> selectUserRoles();
}