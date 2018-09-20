package workflow;

import java.util.Date;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class VarTest {

	// 创建核心引擎对象
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**设置流程变量*/  
	@Test  
	public void setProcessVariables(){  
	    String processInstanceId = "709";//流程实例ID  
	    String assignee = "张三";//任务办理人  
	    TaskService taskService = processEngine.getTaskService();//获取任务的Service，设置和获取流程变量  
	      
	    //查询当前办理人的任务ID  
	    Task task = taskService.createTaskQuery()  
	            .processInstanceId(processInstanceId)//使用流程实例ID  
	            .taskAssignee(assignee)//任务办理人  
	            .singleResult();  
	      
	    //设置流程变量【基本类型】  
	    taskService.setVariable(task.getId(), "请假人", assignee);  
	    taskService.setVariableLocal(task.getId(), "请假天数",3);  
	    taskService.setVariable(task.getId(), "请假日期", new Date());  
	      
	      
	}  
}
