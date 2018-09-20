package workflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * 连线
 * @author fei
 *
 */
public class GateWayTest {
	

	// 创建核心引擎对象
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
	
	/**部署流程定义+启动流程实例*/  
	@Test  
	public void deployementAndStartProcess(){  
	    ProcessInstance pi = processEngine.getRuntimeService()//  
	                        .startProcessInstanceByKey("exclusiveGateWay");//使用流程定义的key的最新版本启动流程  
	    System.out.println("流程实例ID："+pi.getId());  
	    System.out.println("流程定义的ID："+pi.getProcessDefinitionId());  
	}  
}	
