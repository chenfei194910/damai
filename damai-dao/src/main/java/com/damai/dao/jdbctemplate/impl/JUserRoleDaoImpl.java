package com.damai.dao.jdbctemplate.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.damai.dao.jdbctemplate.JUserRoleDao;
import com.damai.datasource.RoutingDataSource;
import com.damai.datasource.RoutingStrategy;
import com.damai.system.entity.UserRole;

@Repository
public class JUserRoleDaoImpl implements JUserRoleDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@RoutingDataSource(RoutingStrategy.WRITE)
	@Override
	public int insert(UserRole record) {
		String sql = "INSERT INTO s_user_role(id, userID, roleID, createTime, updateTime, operatingUser) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, UUID.randomUUID().toString(),"1","1",new Date(),new Date(),"111");
	}

	@RoutingDataSource(RoutingStrategy.READ)
	@Override
	public List<UserRole> selectUserRoles() {
		return jdbcTemplate.query("SELECT * FROM s_user_role", new RowMapper<UserRole>() {
            @Override
            public UserRole mapRow(ResultSet rs, int i) throws SQLException {
            	UserRole userRole = new UserRole();
            	userRole.setId(rs.getString("id"));
            	userRole.setOperatingUser(rs.getString("operatingUser"));
                return userRole;
            }
        });
	}
	
	@Override
	public int insertSelective(UserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserRole selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
