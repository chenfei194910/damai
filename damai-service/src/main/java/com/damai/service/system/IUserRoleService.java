package com.damai.service.system;

import java.util.Map;

import com.damai.system.entity.UserRole;
import com.github.pagehelper.PageInfo;

public interface IUserRoleService {

    PageInfo<UserRole> query(Map<String, Object> condition, int pageNo,
            int pageSize);

    UserRole findById(String id);

    UserRole save(UserRole entity);

    UserRole update(UserRole entity);

    void delete(Long id);

	void insert();
	
}
