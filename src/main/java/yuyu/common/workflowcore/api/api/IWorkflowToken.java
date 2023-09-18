package yuyu.common.workflowcore.api.api;

import java.util.List;
import java.util.Map;

import org.jbpm.graph.exe.Token;

import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;


/**
 * ワークフロートークンです。
 *
 * <pre>
 * ワークフロートークンは、事務手続き（フロー）の主体となる対象です。
 * ある事務手続き（フロー）が開始されるとワークフロートークンが生成されます。
 * ワークフロートークンは、その手続き（フロー）上のどこに存在するか
 * どういった属性を持つかなどの状態を保持します。
 * ワークフロートークンはワークフローコンテキスト({@link IGkWorkflowContext})の
 * 永続化機能を利用することで、オブジェクトの状態を永続化することができます。
 * </pre>
 */
public interface IWorkflowToken {

    public void next() throws WorkflowRuntimeException;

    public String getDestTransionName(String srcNodeName, String destNodeName) throws WorkflowRuntimeException;

    public void next(String transitionId) throws WorkflowRuntimeException;

    public void transfer(String srcNodeName, String destNodeName) throws WorkflowRuntimeException;

    public void setVariable(String variableName, Object value);

    public void setStringVariable(String variableName, String value);

    public Object getVariable(String variableName);

    public String getStringVariable(String variableName);

    public void deleteVariable(String variableName);

    public IWorkflowToken getChild(String tokenName);

    public Map<String, IWorkflowToken> getChildren();

    public Map<String, IWorkflowToken>getDescendants();
    public IWorkflowToken getParent();
    public boolean isRootToken();
    public boolean hasParent();

    public IWorkflowToken getRootToken();
    public String getId();

    public Token getToken();

    public void end();

    public String getNodeName();

    public String getNodeId();

    public IWorkflowProcessDef getProcessDef();

    public long getProcessInstanceId();

    public List<IWorkflowTask> getTasks();

    public boolean hasEnded();

    public void setVariables(Map<String, Object> variables);

    public Map<String, Object> getVariables();


}
