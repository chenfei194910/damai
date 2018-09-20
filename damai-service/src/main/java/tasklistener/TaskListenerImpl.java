package tasklistener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

@SuppressWarnings("serial")
public class TaskListenerImpl implements TaskListener {

	/**设置任务的办理人（个人任务和组任务）*/  
	@Override
	public void notify(DelegateTask delegateTask) {
		//指定个人任务  
        delegateTask.setAssignee("郭靖");  
	}

}
