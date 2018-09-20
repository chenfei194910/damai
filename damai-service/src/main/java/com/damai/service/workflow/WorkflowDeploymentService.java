package com.damai.service.workflow;

import java.util.List;

import org.activiti.engine.repository.Deployment;

public interface WorkflowDeploymentService {
	/**
	 * 查询部署的流程
	 * @return
	 */
	public List<Deployment> queryAllDeployment();
}
