package yuyu.common.workflowcore.api.api.impl.jbpm3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jbpm.taskmgmt.exe.TaskInstance;

import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowTaskFilter;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

public class JbpmWorkflowTaskFilter implements IWorkflowTaskFilter {

    private String processDefinitionName = null;
    private JbpmWorkflowToken token = null;
    private String nodeName = null;
    private long nodeId = -1;

    @Override
    public List<IWorkflowTask> filter (List<IWorkflowTask> pTasks) throws WorkflowRuntimeException {
        if(processDefinitionName == null && token == null && nodeName == null && nodeId == -1){
            throw new WorkflowRuntimeException("フィルタリング条件が設定されていません。");
        }
        if(pTasks.size() == 0) {
            throw new WorkflowRuntimeException("フィルタリング対象タスクが存在しません。");
        }
        List<TaskInstance> jbpmTasks = JbpmWorkflowUtils.convertWorkflowTaskToJbpmTask(pTasks);
        ArrayList<TaskInstance> tasks = new ArrayList<TaskInstance>();
        tasks.addAll(executeProc(jbpmTasks));

        return JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(tasks, pTasks.get(0).getProcessDef());
    }

    @SuppressWarnings("unchecked")
    private Collection<TaskInstance> executeProc (List<TaskInstance> pTasks) throws WorkflowRuntimeException{
        Collection<TaskInstance> tasks = pTasks;
        if(processDefinitionName != null) {
            tasks = Collections2.filter(tasks, filterByProcessDefinitionName(tasks));
        }
        if(token != null) {
            tasks = Collections2.filter(tasks, filterByToken(tasks));
        }
        if(nodeName != null) {
            tasks = Collections2.filter(tasks, filterByNodeName(tasks));
        }
        if(nodeId != -1) {
            tasks = Collections2.filter(tasks, filterByNodeId(tasks));
        }
        return tasks;
    }

    @SuppressWarnings("rawtypes")
    private Predicate filterByProcessDefinitionName(final Collection<TaskInstance> tasks) throws WorkflowRuntimeException {
        return   new Predicate<TaskInstance>(){
            @Override
            public boolean apply(TaskInstance task) {
                if (processDefinitionName.equals(task.getTask().getProcessDefinition().getName())) {
                    return true;
                }
                return false;
            }
        };
    }

    @SuppressWarnings("rawtypes")
    private Predicate filterByToken(final Collection<TaskInstance> tasks) throws WorkflowRuntimeException {
        return   new Predicate<TaskInstance>(){
            @Override
            public boolean apply(TaskInstance task) {
                if (token.getJbpmToken().equals(task.getToken())) {
                    return true;
                }
                return false;
            }
        };
    }

    @SuppressWarnings("rawtypes")
    private Predicate filterByNodeName(final Collection<TaskInstance> tasks) throws WorkflowRuntimeException {
        return   new Predicate<TaskInstance>(){
            @Override
            public boolean apply(TaskInstance task) {
                if (nodeName.equals(task.getTask().getTaskNode().getName())) {
                    return true;
                }
                return false;
            }
        };
    }

    @SuppressWarnings("rawtypes")
    private Predicate filterByNodeId(final Collection<TaskInstance> tasks) throws WorkflowRuntimeException {
        return   new Predicate<TaskInstance>(){
            @Override
            public boolean apply(TaskInstance task) {
                if (nodeId == task.getTask().getTaskNode().getId()) {
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public String getProcessDefinitionId() {
        return processDefinitionName;
    }
    @Override
    public void setProcessDefinitionId(String processDefinitionName) {
        this.processDefinitionName = processDefinitionName;
    }
    @Override
    public JbpmWorkflowToken getToken() {
        return token;
    }
    @Override
    public void setToken(IWorkflowToken token) {
        this.token = (JbpmWorkflowToken)token;
    }
    @Override
    public String getNodeId() {
        return new Long(nodeId).toString();
    }

    @Override
    public void setNodeId(String nodeId) throws WorkflowRuntimeException {
        try {
            this.nodeId =  new Long(nodeId);
        } catch (NumberFormatException e) {
            throw new WorkflowRuntimeException("ノードIDの値が無効です。", e);
        }
    }

    @Override
    public String getNodeName() {
        return nodeName;
    }

    @Override
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
