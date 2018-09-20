package com.damai.service.workflow.impl;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damai.service.workflow.WorkflowDeploymentService;


@Service
public class WorkflowDeploymentServiceImpl implements WorkflowDeploymentService {
	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private RepositoryService repositoryService;
	
	/**
	 * 查询部署的流程
	 * @return
	 */
	public List<Deployment> queryAllDeployment(){
		System.out.println("查询service");
		return repositoryService.createDeploymentQuery().list();
	}
}
