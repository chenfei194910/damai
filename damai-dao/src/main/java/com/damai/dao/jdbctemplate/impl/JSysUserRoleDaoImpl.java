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

import com.damai.dao.jdbctemplate.JSysUserRoleDao;
import com.damai.datasource.RoutingDataSource;
import com.damai.datasource.RoutingStrategy;
import com.damai.system.entity.SysUserRole;

@Repository
public class JSysUserRoleDaoImpl implements JSysUserRoleDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@RoutingDataSource(RoutingStrategy.WRITE)
	@Override
	public int insert(SysUserRole record) {
		String sql = "INSERT INTO s_user_role(id, userID, roleID, createTime, updateTime, operatingUser) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, UUID.randomUUID().toString(),"1","1",new Date(),new Date(),"111");
	}

	@RoutingDataSource(RoutingStrategy.READ)
	@Override
	public List<SysUserRole> selectUserRoles() {
		return jdbcTemplate.query("SELECT * FROM s_user_role", new RowMapper<SysUserRole>() {
            @Override
            public SysUserRole mapRow(ResultSet rs, int i) throws SQLException {
            	SysUserRole sysUserRole = new SysUserRole();
            	sysUserRole.setId(rs.getString("id"));
            	sysUserRole.setOperatingUser(rs.getString("operatingUser"));
                return sysUserRole;
            }
        });
	}
	
	@Override
	public int insertSelective(SysUserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUserRole selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysUserRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
