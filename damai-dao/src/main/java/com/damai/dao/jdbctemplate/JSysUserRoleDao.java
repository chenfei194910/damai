package com.damai.dao.jdbctemplate;

import java.util.List;

import com.damai.system.entity.SysUserRole;

public interface JSysUserRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
    
    List<SysUserRole> selectUserRoles();
}