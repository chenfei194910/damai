package workflow;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class AssigneeTest {
    //流程引擎对象  
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();  
      
    /**部署流程定义+启动流程实例*/  
    @Test  
    public void deployementAndStartProcess(){  
        InputStream inputStreamBpmn = this.getClass().getResourceAsStream("task.bpmn");  
        InputStream inputStreampng = this.getClass().getResourceAsStream("task.png");  
        //部署流程定义  
        Deployment deployment = processEngine.getRepositoryService()//  
                        .createDeployment()//创建部署对象  
                        .addInputStream("task.bpmn", inputStreamBpmn)//部署加载资源文件  
                        .addInputStream("task.png", inputStreampng)//  
                        .deploy();  
        System.out.println("部署ID："+deployment.getId());  
        //启动流程实例  
        ProcessInstance pi = processEngine.getRuntimeService()//  
                    .startProcessInstanceByKey("task");//使用流程定义的key的最新版本启动流程  
        System.out.println("流程实例ID："+pi.getId());  
        System.out.println("流程定义的ID："+pi.getProcessDefinitionId());  
    }  
      
    /**查询我的个人任务*/  
    @Test  
    public void findPersonalTaskList(){  
        //任务办理人  
        String assignee = "郭靖";  
        List<Task> list = processEngine.getTaskService()//  
                    .createTaskQuery()//  
                    .taskAssignee(assignee)//个人任务的查询  
                        .list();  
        if(list!=null && list.size()>0){  
            for(Task task:list){  
                System.out.println("任务ID："+task.getId());  
                System.out.println("任务的办理人："+task.getAssignee());  
                System.out.println("任务名称："+task.getName());  
                System.out.println("任务的创建时间："+task.getCreateTime());  
                System.out.println("流程实例ID："+task.getProcessInstanceId());  
                System.out.println("#######################################");  
            }  
        }  
    }  
      
    /**完成任务*/  
    @Test  
    public void completeTask(){  
        //任务ID  
        String taskId = "5408";  
        processEngine.getTaskService().complete(taskId);  
        System.out.println("完成任务："+taskId);  
    }  
      
    /**将个人任务从一个人分配给另一个人*/  
    @Test  
    public void setAssignee(){  
        //指定任务的办理人  
        String userId = "黄蓉";  
        //任务ID  
        String taskId = "5408";  
        processEngine.getTaskService()//  
                .setAssignee(taskId, userId);  
    }  
}
