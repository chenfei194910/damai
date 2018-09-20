package com.damai.service.user;

import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.UserEntity;

import com.damai.system.entity.UserRole;
import com.github.pagehelper.PageInfo;

public interface IUserService {

    PageInfo<UserEntity> query(Map<String, Object> condition, int pageNo,
            int pageSize);

    UserEntity findById(Long id);

    UserEntity save(UserEntity entity);

    UserEntity update(UserEntity entity);

    void delete(Long id);

    
	void insert();
	
	
	List<UserRole> selectUserRoles();

//	UserRole selectUserRole();
}
