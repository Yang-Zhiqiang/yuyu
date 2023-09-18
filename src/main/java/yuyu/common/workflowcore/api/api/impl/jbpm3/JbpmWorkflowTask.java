package yuyu.common.workflowcore.api.api.impl.jbpm3;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;

import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * ワークフロータスクインターフェースのJbpm具象クラス
 */
public class JbpmWorkflowTask implements IWorkflowTask {

    private TaskInstance taskInstance;

    private Long rootTokenId;

    private String nodeName;

    private String nodeLocalName;

    private IWorkflowProcessDef workflowProcessDef;

    @Override
    public String getTaskNodeName() {
        return nodeName;
    }

    @Override
    public Long getRootTokenId() {
        return rootTokenId;
    }

    public TaskInstance getJbpmTaskInstance() {
        return taskInstance;
    }

    public JbpmWorkflowTask(TaskInstance pTaskInstance, IWorkflowProcessDef pWorkflowProcessDef) {

        rootTokenId   = pTaskInstance.getProcessInstance().getRootToken().getId();
        nodeName      = pTaskInstance.getTask().getTaskNode().getName();
        nodeLocalName = pTaskInstance.getTask().getTaskNode().getDescription();
        taskInstance  = pTaskInstance;
        workflowProcessDef = pWorkflowProcessDef;

    }

    @Override
    public void end() throws WorkflowRuntimeException {
        if(taskInstance.hasEnded()) {
            throw new WorkflowRuntimeException("タスクは既に終了しています。");
        }
        taskInstance.end();
    }

    @Override
    public void end(String transitionId) throws WorkflowRuntimeException {
        if(taskInstance.hasEnded()) {
            throw new WorkflowRuntimeException("タスクは既に終了しています。");
        }

        List<String> transitionNames = workflowProcessDef.getTransitions(this.taskInstance.getToken().getNode().getName());
        if(!transitionNames.contains(transitionId)) {
            throw new WorkflowRuntimeException("指定された遷移先は存在しません。");
        }

        taskInstance.end(transitionId);
    }

    @Override
    public String[] getUserGroup() {
        Object[] userGroup = taskInstance.getPooledActors().toArray();
        ArrayList<String> userGroupList = new ArrayList<String>();

        for(Object user : userGroup) {
            PooledActor pooledActor = (PooledActor)user;
            userGroupList.add(pooledActor.getActorId());
        }
        String[] userGroupArray = userGroupList.toArray(new String[0]);

        return userGroupArray;
    }

    @Override
    public String getUserId() {
        String userId = taskInstance.getActorId();
        return userId;
    }

    @Override
    public void assignGroup(String[] userGroup) {
        taskInstance.setPooledActors(userGroup);
    }

    @Override
    public void assign(String userId) {
        taskInstance.setActorId(userId);
    }

    @Override
    public boolean assigned() {
        if(getUserId() == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getName() {
        return taskInstance.getName();
    }

    @Override
    public void release() {
        taskInstance.setActorId(null);
    }

    @Override
    public void releaseGroup() {
        String[] nullArray = new String[0];
        taskInstance.setPooledActors(nullArray);
    }

    @Override
    public IWorkflowProcessDef getProcessDef() {
        return workflowProcessDef;
    }

    @Override
    public String getTaskNodeLocalName() {
        return nodeLocalName;
    }

    @Override
    public void start(String userId) throws WorkflowRuntimeException {
        if(taskInstance.hasEnded()) {
            throw new WorkflowRuntimeException("タスクは既に終了しています。");
        }
        taskInstance.start(userId);
    }

    @Override
    public void clearStart() throws WorkflowRuntimeException {
        taskInstance.setStart(null);
    }

}
