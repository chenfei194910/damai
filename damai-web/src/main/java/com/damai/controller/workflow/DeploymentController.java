package com.damai.controller.workflow;

import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damai.service.workflow.WorkflowDeploymentService;


@Controller
@RequestMapping("/deployment")
public class DeploymentController {

	@Autowired
	private WorkflowDeploymentService workflowDeploymentService;

	private static String PATH = "workflow/";

	@RequestMapping("/queryDeployment")
	public String queryDeployment(Map<String, Object> map) {
		List<Deployment> deploymentList = workflowDeploymentService.queryAllDeployment();
//		map.put("dataList", deploymentList);
		return PATH + "deployment";
	}
}
