package com.damai.controller.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damai.service.user.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	private static String PATH = "main/";

	@RequestMapping("/")
	public String queryDeployment(Map<String, Object> map) {
		userService.insert();
		return PATH + "layuiMain";
	}
	
	@RequestMapping("/table")
	public String list(Map<String, Object> map) {
		return PATH + "layuiTable";
	}
}
