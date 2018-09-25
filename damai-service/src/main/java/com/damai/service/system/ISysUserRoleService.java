package com.damai.service.system;

import java.util.Map;

import com.damai.system.entity.SysUserRole;
import com.github.pagehelper.PageInfo;

public interface ISysUserRoleService {

    PageInfo<SysUserRole> query(Map<String, Object> condition, int pageNo,
            int pageSize);

    SysUserRole findById(String id);

    SysUserRole save(SysUserRole entity);

    SysUserRole update(SysUserRole entity);

    void delete(Long id);

	void insert();
	
}
