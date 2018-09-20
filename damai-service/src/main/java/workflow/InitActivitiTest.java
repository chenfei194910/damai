package workflow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class InitActivitiTest {

	// 创建核心引擎对象
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			
	// 方式2：使用配置文件来创建activiti的表
	@Test
	public void createTable_2() {
		// 通过让工作流引擎的全部配置对象来执行配置文件中的内容来创建流程引擎对象
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("Activiti.cfg.xml").buildProcessEngine();
		System.out.println("processEngine" + processEngine);
	}

	// 方法1：使用代码来创建activiti工作流的表

	// 使用代码创建工作流需要的23张表
	 @Test
	 public void createTable() {
	 // 工作流引擎的全部配置
	 ProcessEngineConfiguration processEngineConfiguration =
	 ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
	
	 // 链接数据的配置
	 processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
	 processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/damai?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8");
	 processEngineConfiguration.setJdbcUsername("root");
	 processEngineConfiguration.setJdbcPassword("123456");
	
	 /*
	 * public static final String DB_SCHEMA_UPDATE_FALSE = "false";
	 * 不能自动创建表，需要表存在 public static final String DB_SCHEMA_UPDATE_CREATE_DROP
	 * = "create-drop"; 先删除表再创建表 public static final String
	 * DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
	 */
	 //如果表不存在，自动创建表
	 processEngineConfiguration.setDatabaseSchemaUpdate(processEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
	 // 工作流的核心对象，ProcessEnginee对象
	 ProcessEngine processEngine = processEngineConfiguration
	 .buildProcessEngine();
	 System.out.println(processEngine);
	 }

	// 第二步部署流程定义
	@Test
	public void deploymentProcessDefinition() {
		// 创建核心引擎对象
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
				.createDeployment()// 创建一个部署对象
				.name("MyProcess")// 添加部署的名称
				.addClasspathResource("MyProcess.bpmn")// classpath的资源中加载，一次只能加载
														// 一个文件
				.addClasspathResource("diagrams/MyProcess.png")// classpath的资源中加载，一次只能加载
																// 一个文件
				.deploy();// 完成部署
		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称：" + deployment.getName());
	}

	/** 
	 * 查询所有的流程定义 
	 */  
//	@Test  
//	public void findProcessDefinition() {  
//		// 创建核心引擎对象
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//	    List<ProcessDefinition> list = processEngine.getRepositoryService()// 与流程定义和部署对象先相关的service  
//	            .createProcessDefinitionQuery()// 创建一个流程定义的查询  
//	            /** 指定查询条件，where条件 */  
//	            // .deploymentId(deploymentId) //使用部署对象ID查询  
//	            // .processDefinitionId(processDefinitionId)//使用流程定义ID查询  
//	            // .processDefinitionNameLike(processDefinitionNameLike)//使用流程定义的名称模糊查询  
//	  
//	            /* 排序 */  
//	            .orderByProcessDefinitionVersion().asc()  
//	            // .orderByProcessDefinitionVersion().desc()  
//	  
//	            /* 返回的结果集 */  
//	            .list();// 返回一个集合列表，封装流程定义  
//	    // .singleResult();//返回惟一结果集  
//	    // .count();//返回结果集数量  
//	    // .listPage(firstResult, maxResults);//分页查询  
//	  
//	    if (list != null && list.size() > 0) {  
//	        for (ProcessDefinition pd : list) {  
//	            System.out.println("流程定义ID:" + pd.getId());// 流程定义的key+版本+随机生成数  
//	            System.out.println("流程定义的名称:" + pd.getName());// 对应helloworld.bpmn文件中的name属性值  
//	            System.out.println("流程定义的key:" + pd.getKey());// 对应helloworld.bpmn文件中的id属性值  
//	            System.out.println("流程定义的版本:" + pd.getVersion());// 当流程定义的key值相同的相同下，版本升级，默认1  
//	            System.out.println("资源名称bpmn文件:" + pd.getResourceName());  
//	            System.out.println("资源名称png文件:" + pd.getDiagramResourceName());  
//	            System.out.println("部署对象ID：" + pd.getDeploymentId());  
//	            System.out.println("#########################################################");  
//	        }  
//	    }  
//	}  
	
	
//	查看最新版本的流程定义：  
	/** 
	 * 附加功能，查询最新版本的流程定义 
	 */  
	@Test  
	public void findLastVersionProcessDefinition() {  
		// 创建核心引擎对象
				ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	    List<ProcessDefinition> list = processEngine.getRepositoryService()  
	            .createProcessDefinitionQuery()  
	            .orderByProcessDefinitionVersion().asc() // 使用流程定义的版本升序排列  
	            .list();  
	  
	    /** 
	     * Map<String,ProcessDefinition> map集合的key：流程定义的key map集合的value：流程定义的对象 
	     * map集合的特点：当map集合key值相同的情况下，后一次的值将替换前一次的值 
	     */  
	    Map<String, ProcessDefinition> map = new LinkedHashMap<String, ProcessDefinition>();  
	    if (list != null && list.size() > 0) {  
	        for (ProcessDefinition pd : list) {  
	            map.put(pd.getKey(), pd);  
	        }  
	    }  
	  
	    List<ProcessDefinition> pdList = new ArrayList<ProcessDefinition>(  
	            map.values());  
	    if (pdList != null && pdList.size() > 0) {  
	        for (ProcessDefinition pd : pdList) {  
	            System.out.println("流程定义ID:" + pd.getId());// 流程定义的key+版本+随机生成数  
	            System.out.println("流程定义的名称:" + pd.getName());// 对应helloworld.bpmn文件中的name属性值  
	            System.out.println("流程定义的key:" + pd.getKey());// 对应helloworld.bpmn文件中的id属性值  
	            System.out.println("流程定义的版本:" + pd.getVersion());// 当流程定义的key值相同的相同下，版本升级，默认1  
	            System.out.println("资源名称bpmn文件:" + pd.getResourceName());  
	            System.out.println("资源名称png文件:" + pd.getDiagramResourceName());  
	            System.out.println("部署对象ID：" + pd.getDeploymentId());  
	            System.out  
	                    .println("#########################################################");  
	        }  
	    }  
	  
	} 
	
	 public static void main(String[] args) {
			// 创建核心引擎对象
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的service
					.createDeployment()// 创建一个部署对象
					.name("MyProcess")// 添加部署的名称
					.addClasspathResource("MyProcess.bpmn")// classpath的资源中加载，一次只能加载
															// 一个文件
					.addClasspathResource("diagrams/MyProcess.png")// classpath的资源中加载，一次只能加载
																	// 一个文件
					.deploy();// 完成部署
			System.out.println("部署ID:" + deployment.getId());
			System.out.println("部署名称：" + deployment.getName());
	 }
	
	/** 
	 * 查看流程图 
	 */  
	@Test  
	public void viewPic() throws IOException {  
		// 创建核心引擎对象
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	    // 将生产的图片放到文件夹下  
	    String deploymentId = "201";// TODO  
	    // 获取图片资源名称  
	    List<String> list = processEngine.getRepositoryService()  
	            .getDeploymentResourceNames(deploymentId);  
	  
	    // 定义图片资源名称  
	    String resourceName = "";  
	    if (list != null && list.size() > 0) {  
	        for (String name : list) {  
	            if (name.indexOf(".png") >= 0) {  
	                resourceName = name;  
	            }  
	        }  
	    }  
	  
	    // 将输入流的图片写到D盘下  
//	    FileUtils.copyInputStreamToFile(in, file);  
	}  

	
	// 第三步 启动流程实例
//	@Test
//	public void startProcessInstance() {
//		// 创建核心引擎对象
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//		// 流程定义的key
//		String processDefinitionKey = "MyProcess22";
//		ProcessInstance pi = processEngine.getRuntimeService()// 于正在执行的流程实例和执行对象相关的Service
//				.startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应hellworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
//		System.out.println("流程实例ID:" + pi.getId());// 流程实例ID 101
//		System.out.println("流程定义ID:" + pi.getProcessDefinitionId()); // 流程定义ID
//	}

	/**
	 * 查询当前人的个人任务
	 */
	@Test
	public void findMyPersonTask() {
		// 创建核心引擎对象
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//		List<Task> list = processEngine.getTaskService()// 与正在执行的认为管理相关的Service
//				.createTaskQuery()// 创建任务查询对象
//				.taskAssignee(assignee)// 指定个人认为查询，指定办理人
//				.list();

		
		List<Task> list = processEngine.getTaskService()// 与正在执行的认为管理相关的Service
				.createTaskQuery()// 创建任务查询对象
//				.taskAssignee(assignee)// 指定个人认为查询，指定办理人
				.list();
		
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务ID:" + task.getId());
				System.out.println("任务名称:" + task.getName());
				System.out.println("任务的创建时间" + task);
				System.out.println("任务的办理人:" + task.getAssignee());
				System.out.println("流程实例ID:" + task.getProcessInstanceId());
				System.out.println("执行对象ID:" + task.getExecutionId());
				System.out.println("流程定义ID:" + task.getProcessDefinitionId());
				System.out.println("#################################");
			}
		}
	}

//	---------------------查询任务
//	/** 
//	 * 查询任务通过流程实例id 
//	 */  
//	@Test  
//	public void findTask(){  
//		// 创建核心引擎对象
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//	    String processInstanceId="801";  
//	    List<HistoricTaskInstance> list = processEngine.getHistoryService()//与历史数据（历史表）相关的service  
//	            .createHistoricTaskInstanceQuery()//创建历史任务实例查询  
//	            .processInstanceId(processInstanceId)  
//	            .list();  
//	    if(list!=null && list.size()>0){  
//	        for(HistoricTaskInstance hti:list){  
//	            System.out.println(hti.getId()+"    "+hti.getName()+"    "+hti.getProcessInstanceId()+"   "+hti.getStartTime()+"   "+hti.getEndTime()+"   "+hti.getDurationInMillis());  
//	            System.out.println("################################");  
//	        }  
//	    }     
//	}  
//	
////	-----------------设置流程变量
//	/** 
//	 * 设置流程变量 
//	 */  
//	@Test  
//	public void setVariables() {  
//	    // 与任务相关的service,正在执行的service  
//	    TaskService taskService = processEngine.getTaskService();  
//	  
//	    // 任务ID  
//	    String taskId = "709";  
//	  
//	    // 1.设置流程变量，使用基本数据类型  
//	    taskService.setVariable(taskId, "请假天数", 7);// 与任务ID
//	    taskService.setVariable(taskId, "请假日期", new Date());  
//	    taskService.setVariableLocal(taskId, "请假原因", "回去探亲，一起吃个饭123");  
//	      
//	    System.out.println("设置流程变量成功！");  
//	  
//	}  
	
	/** 
	 * 获取流程变量 
	 */  
//	@Test  
//	public void getVariables() {  
//	    // 与任务（正在执行的service）  
//	    TaskService taskService = processEngine.getTaskService();  
//	    // 任务Id  
//	    String taskId = "709";  
//	    // 1.获取流程变量，使用基本数据类型  
//	    Integer days = (Integer) taskService.getVariable(taskId, "请假天数");  
//	    Date date = (Date) taskService.getVariable(taskId, "请假日期");  
//	    String reason = (String) taskService.getVariable(taskId, "请假原因");  
//	  
//	    System.out.println("请假天数：" + days);  
//	    System.out.println("请假日期：" + date);  
//	    System.out.println("请假原因：" + reason);  
//	  
//	} 
	
	
	/** 
	 * 设置流程变量 
	 */  
//	@Test  
//	public void setVariables2() {  
//	    // 与任务相关的service,正在执行的service  
//	    TaskService taskService = processEngine.getTaskService();  
//	  
//	    // 任务ID  
//	    String taskId = "709";  
//	  
//	    // 设置流程变量，使用javaBean方法  
//	    /** 
//	     * 当一个javaBean(实现序列号)放置到流程变量中，要求javabean的属性不能在发生变化 如果发生变化，再获取时，抛出异常 
//	     *  
//	     * 解决方案：在person对象中添加： private static final long 
//	     * serialVersionUID="6757393795687480331L"; 同时实现序列号接口 
//	     *  
//	     */  
//	    Person p = new Person();  
//	    p.setName("翠花");  
//	    p.setId(20);  
//	    p.setDate();;  
//	    p.setNote("回去探亲，一起吃个饭123");  
//	    taskService.setVariable(taskId, "人员信息(添加固定版本)", p);  
//	      
//	    System.out.println("设置流程变量成功！");  
//	  
//	}  
	
	
	/** 
	 * 获取流程变量 
	 */  
//	@Test  
//	public void getVariables2() {  
//	    // 与任务（正在执行的service）  
//	    TaskService taskService = processEngine.getTaskService();  
//	    // 任务Id  
//	    String taskId = "709";  
//	  
//	    // 2.获取流程变量，使用javaBean类型  
//	    Person p = (Person)taskService.getVariable(taskId, "人员信息(添加固定版本)");  
//	    System.out.println(" 请假人：  "+p.getName()+"  请假天数：  "+p.getId()+"   请假时间："+ p.getDate()+ "   请假原因： "+p.getNote());  
//	  
//	}  
	
	
//	--------------------查询历史流程变量
	
	/**
	 * 可以根据变量名称查询该变量的所有历史信息  
	 */
	/** 
	 * 查询流程变量的历史表 
	 */  
	@Test  
	public void findHistoryProcessVariables(){  
	    List<HistoricVariableInstance> list = processEngine.getHistoryService()  
	            .createHistoricVariableInstanceQuery()//创建一个历史的流程变量查询对象  
	            .variableName("请假原因")  
	            .list();  
	    if (list!=null &&list.size()>0) {  
	        for (HistoricVariableInstance hvi : list) {  
	            System.out.println(hvi.getId()+"     "+hvi.getProcessInstanceId()+"   "+hvi.getVariableName()  
	                    +"   "+hvi.getVariableTypeName()+"    "+hvi.getValue());  
	            System.out.println("########################################");  
	        }  
	    }  
	  
	}  
	
	
	
//	/**
//	 * 完成我的任务
//	 */
//	@Test
//	public void completeMyPersonTask() {
//		// 创建核心引擎对象
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//		// 任务Id
//		String taskId = "9";
//		processEngine.getTaskService()// 与正在执行的认为管理相关的Service
//				.complete(taskId);
//		System.out.println("完成任务:任务ID:" + taskId);
//
//	}
//	
//	
//	/** 
//	 * 删除流程定义(删除key相同的所有不同版本的流程定义) 
//	 */  
//	@Test  
//	public void delteProcessDefinitionByKey() { 
//		// 创建核心引擎对象
//				ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//	    // 流程定义的Key  
//	    String processDefinitionKey = "MyProcessKey";  
//	    // 先使用流程定义的key查询流程定义，查询出所有的版本  
//	    List<ProcessDefinition> list = processEngine.getRepositoryService()  
//	            .createProcessDefinitionQuery()  
//	            .processDefinitionKey(processDefinitionKey)// 使用流程定义的key查询  
//	            .list();  
//	    // 遍历，获取每个流程定义的部署ID  
//	    if (list != null && list.size() > 0) {  
//	        for (ProcessDefinition pd : list) {  
//	            // 获取部署ID  
//	            String deploymentId = pd.getDeploymentId();  
//	            //      /*  
//	            //       * 不带级联的删除， 只能删除没有启动的流程，如果流程启动，就会抛出异常  
//	            //       */  
//	                   processEngine.getRepositoryService().deleteDeployment(deploymentId);  
//	              
//	            /** 
//	             * 级联删除 不管流程是否启动，都可以删除 
//	             */  
//	            processEngine.getRepositoryService().deleteDeployment(  
//	                    deploymentId, true);  
//	  
//	        }  
//	  
//	    }  
//	}  
}
