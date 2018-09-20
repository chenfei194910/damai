package com.damai.controller.index;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class IndexController {

	private static String PATH = "main/";

	@RequestMapping("/")
	public String queryDeployment(Map<String, Object> map) {
		return PATH + "layuiMain";
	}
	
	@RequestMapping("/table")
	public String list(Map<String, Object> map) {
		return PATH + "layuiTable";
	}
}
