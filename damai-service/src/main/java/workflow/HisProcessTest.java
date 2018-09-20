package workflow;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.junit.Test;

public class HisProcessTest {
	
	// 创建核心引擎对象
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
		
	/**查询历史流程实例*/  
	@Test  
	public void findHisProcessInstance(){     
	    List<HistoricProcessInstance> list = processEngine.getHistoryService()  
	            .createHistoricProcessInstanceQuery()  
	            .processDefinitionId("MyProcess22:4:305")//流程定义ID  
	            .list();  
	      
	    if(list != null && list.size()>0){  
	        for(HistoricProcessInstance hi:list){  
	            System.out.println(hi.getId()+"   "+hi.getStartTime()+"   "+hi.getEndTime());  
	        }  
	    }  
	}  
	
	
	/**查询历史活动 
	 * 问题：HistoricActivityInstance对应哪个表 
	 * 问题：HistoricActivityInstance和HistoricTaskInstance有什么区别*/  
	@Test   
	public void findHisActivitiList(){  
		System.out.println("-----------------------");  
	    String processInstanceId = "709";  
	    List<HistoricActivityInstance> list = processEngine.getHistoryService()  
	            .createHistoricActivityInstanceQuery()  
	            .processInstanceId(processInstanceId)  
	            .list();  
	    if(list != null && list.size()>0){  
	        for(HistoricActivityInstance hai : list){  
	            System.out.println(hai.getId()+"  "+hai.getActivityName());  
	        }  
	    }  
	}  
}
