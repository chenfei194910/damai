package com.damai.service.system.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damai.dao.mybatis.IUserRoleDao;
import com.damai.service.system.IUserRoleService;
import com.damai.system.entity.UserRole;
import com.github.pagehelper.PageInfo;

@Service
public class IUserRoleServiceImpl implements IUserRoleService {
	
	@Autowired
    private IUserRoleDao iUserRoleDao;
	
	
	@Override
	public PageInfo<UserRole> query(Map<String, Object> condition, int pageNo, int pageSize) {
		return null;
	}

	@Override
	public UserRole findById(String id) {
		UserRole userRole = iUserRoleDao.selectByPrimaryKey(id);
		return userRole;
	}

	@Override
	public UserRole save(UserRole entity) {
		iUserRoleDao.insert(entity);
		return entity;
	}

	@Override
	public UserRole update(UserRole entity) {
		iUserRoleDao.updateByPrimaryKey(entity);
		return entity;
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public void insert() {
		System.out.println("保存角色");
	}

}
