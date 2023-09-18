package yuyu.common.workflowcore.api.api;

import java.util.List;

import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * ワークフロータスクのフィルタリングを実行するワークフロータスクフィルターです。
 *
 * <pre>
 * ワークフロータスクフィルターは、タスクの存在するプロセス定義、プロセス定義上の位置（ノード）、
 * トークンなどの、タスクの属性によって、タスクリストの絞込みを行います。
 * ワークフローコンテキストによって取得されたタスクリストを、このタスクフィルターによって絞込みを
 * 行うことによって、用途に応じたタスクリストを取得することができます。
 * </pre>
 */
public interface IWorkflowTaskFilter {

    public List<IWorkflowTask> filter(List<IWorkflowTask> pTasks) throws WorkflowRuntimeException;

    public String getProcessDefinitionId();

    public void setProcessDefinitionId(String processDefinitionId);

    public IWorkflowToken getToken();

    public void setToken(IWorkflowToken token);

    public String getNodeId();

    public void setNodeId(String nodeId);

    public String getNodeName();

    public void setNodeName(String nodeName);

}