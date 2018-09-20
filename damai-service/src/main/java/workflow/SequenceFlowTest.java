package workflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * 连线
 * @author fei
 *
 */
public class SequenceFlowTest {
	

	// 创建核心引擎对象
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
	
	/**查询我的个人任务*/  
	@Test
	public void findPersonalTaskList() {
		// 任务办理人
		String assignee = "赵六";
		List<Task> list = processEngine.getTaskService()//
				.createTaskQuery()//
				.taskAssignee(assignee)// 个人任务的查询
				.list();
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID：" + task.getId());
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务名称：" + task.getName());
				System.out.println("任务的创建时间：" + task.getCreateTime());
				System.out.println("流程实例ID：" + task.getProcessInstanceId());
				System.out.println("#######################################");
			}
		}
	}
	
	/**完成任务*/  
	@Test  
	public void completeTask(){  
	    //任务ID  
	    String taskId = "1109";  
	    //完成任务的同时，设置流程变量，让流程变量判断连线该如何执行  
	    Map<String, Object> variables = new HashMap<String, Object>();  
	    //其中message对应sequenceFlow.bpmn中的${message=='不重要'}，不重要对应流程变量的值  
	    variables.put("message", "重要");  
	    processEngine.getTaskService()//  
	                    .complete(taskId,variables);  
	    System.out.println("完成任务："+taskId);  
	}  

}
