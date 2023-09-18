package yuyu.common.workflowcore.api.api.impl.jbpm3;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.taskmgmt.exe.TaskInstance;

import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * jBPM具象クラスのユーティリティクラスです。
 */
public class JbpmWorkflowUtils {

    static protected List<IWorkflowTask> convertJbpmTaskToWorkflowTask(List<TaskInstance> jbpmTasks, IWorkflowProcessDef workflowProcessDef) throws WorkflowRuntimeException {
        if (jbpmTasks == null){
            throw new WorkflowRuntimeException("jBPMタスクが未設定です。");
        }
        ArrayList<IWorkflowTask> workflowTasks = new ArrayList<IWorkflowTask>();
        for (Object task : jbpmTasks) {
            TaskInstance taskInstance = (TaskInstance) task;
            workflowTasks.add(new JbpmWorkflowTask(taskInstance, workflowProcessDef));
        }
        return workflowTasks;
    }

    public static List<TaskInstance> convertWorkflowTaskToJbpmTask(List<IWorkflowTask> workflowTasks) throws WorkflowRuntimeException {
        if(workflowTasks == null) {
            throw new WorkflowRuntimeException("jBPMタスクが未設定です。");
        }
        ArrayList<TaskInstance> jbpmTasks = new ArrayList<TaskInstance>();
        for (IWorkflowTask workflowTask : workflowTasks) {
            JbpmWorkflowTask jbpmWorkflowTask = (JbpmWorkflowTask)workflowTask;

            jbpmTasks.add(jbpmWorkflowTask.getJbpmTaskInstance());
        }
        return jbpmTasks;
    }

}
