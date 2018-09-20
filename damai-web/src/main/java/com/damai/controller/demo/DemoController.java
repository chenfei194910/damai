package com.damai.controller.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/demo")
public class DemoController {

	private static String PATH = "demo/";

	@RequestMapping("/")
	public String queryDeployment(Map<String, Object> map) {
		return PATH + "hello";
	}
	
	@RequestMapping("/table")
	public String list(Map<String, Object> map) {
		return PATH + "layuiTable";
	}
}
