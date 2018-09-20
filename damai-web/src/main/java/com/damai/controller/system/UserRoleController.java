package com.damai.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damai.service.system.IUserRoleService;
import com.damai.system.entity.UserRole;


@Controller
@RequestMapping("/userRole")
public class UserRoleController {

	@Autowired
	private IUserRoleService iUserRoleService;
	
	private static String PATH = "main/";

	@RequestMapping("/")
	public String queryDeployment(Map<String, Object> map) {
		UserRole userRole = iUserRoleService.findById("1");
		System.out.println(userRole.getId());
		System.out.println(userRole.getCreateTime());
		return PATH + "layuiMain";
	}
	
	@RequestMapping("/table")
	public String list(Map<String, Object> map) {
		return PATH + "layuiTable";
	}
}
