package com.damai.service.user.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damai.dao.jdbctemplate.JUserRoleDao;
import com.damai.service.user.IUserService;
import com.damai.system.entity.UserRole;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
    private JUserRoleDao jUserRoleDao;
	
	public void insert() {
		jUserRoleDao.insert(null);
	}
	
	
	public List<UserRole> selectUserRoles() {
		return jUserRoleDao.selectUserRoles();
	}
	
	
//	public UserRole selectUserRole() {
//		return iUserRoleDao.selectByPrimaryKey("1");
//	}
	
	    @Override
    public PageInfo<UserEntity> query(Map<String, Object> condition,
            int pageNo, int pageSize) {
//        return userRepository.query(condition, pageNo, pageSize);
        return null;
    }

    @Override
    public UserEntity findById(Long id) {
//        return userRepository.findById(id);
    	return null;
    }

    @Override
    public UserEntity save(UserEntity entity) {
//        return userRepository.save(entity);
    	return null;
    }

    @Override
    public UserEntity update(UserEntity entity) {
//        return userRepository.update(entity);
    	return null;
    }

    @Override
    public void delete(Long id) {
//        userRepository.delete(id);
    }
	
}
