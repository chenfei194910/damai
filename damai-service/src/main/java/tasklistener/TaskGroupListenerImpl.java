package tasklistener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

@SuppressWarnings("serial")
public class TaskGroupListenerImpl implements TaskListener {

	/** 
     * 可以设置任务的办理人（个人组人和组任务） 
     */  
	@Override
	public void notify(DelegateTask delegateTask) {
		//指定组任务  
        delegateTask.addCandidateUser("孙悟空");  
        delegateTask.addCandidateUser("猪八戒");  
	}

}
