package com.damai.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damai.service.user.ISysUserService;


@Controller
@RequestMapping("/user")
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;
	
	private static String PATH = "main/";

	@RequestMapping("/")
	public String queryDeployment(Map<String, Object> map) {
		sysUserService.insert();
		return PATH + "layuiMain";
	}
	
	@RequestMapping("/table")
	public String list(Map<String, Object> map) {
		return PATH + "layuiTable";
	}
}
