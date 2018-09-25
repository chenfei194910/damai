package com.damai.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damai.service.system.ISysUserRoleService;
import com.damai.system.entity.SysUserRole;


@Controller
@RequestMapping("/userRole")
public class SysUserRoleController {

	@Autowired
	private ISysUserRoleService iUserRoleService;
	
	private static String PATH = "main/";

	@RequestMapping("/")
	public String queryDeployment(Map<String, Object> map) {
		SysUserRole sysUserRole = iUserRoleService.findById("1");
		System.out.println(sysUserRole.getId());
		System.out.println(sysUserRole.getCreateTime());
		return PATH + "layuiMain";
	}
	
	@RequestMapping("/table")
	public String list(Map<String, Object> map) {
		return PATH + "layuiTable";
	}
}
