package com.damai.service.system.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damai.dao.mybatis.ISysUserRoleDao;
import com.damai.service.system.ISysUserRoleService;
import com.damai.system.entity.SysUserRole;
import com.github.pagehelper.PageInfo;

@Service
public class ISysUserRoleServiceImpl implements ISysUserRoleService {
	
	@Autowired
    private ISysUserRoleDao iUserRoleDao;
	
	
	@Override
	public PageInfo<SysUserRole> query(Map<String, Object> condition, int pageNo, int pageSize) {
		return null;
	}

	@Override
	public SysUserRole findById(String id) {
		SysUserRole sysUserRole = iUserRoleDao.selectByPrimaryKey(id);
		return sysUserRole;
	}

	@Override
	public SysUserRole save(SysUserRole entity) {
		iUserRoleDao.insert(entity);
		return entity;
	}

	@Override
	public SysUserRole update(SysUserRole entity) {
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
