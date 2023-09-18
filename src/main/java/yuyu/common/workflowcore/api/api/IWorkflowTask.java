package yuyu.common.workflowcore.api.api;

import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * ワークフロータスクです。
 *
 * <pre>
 * ワークフロータスクは、事務手続き（フロー）内で発生したタスクを表すインターフェースです。
 * ワークフロータスクは、そのタスクが発生したワークフロートークン・割り当てユーザID・
 * 割当ユーザグループの情報を持ちます。
 * 割り当て方法には、グループ割当と個人割当という2種類が存在します。
 * それぞれの割り当て方法の詳細については、{@link #assign(String userId)}または
 * {@link #assignGroup(String[] userGroup)}を参照してください。
 * </pre>
 */
public interface IWorkflowTask {

    public void assign(String userId);

    public boolean assigned();

    public String getUserId();

    public String[] getUserGroup();

    public void assignGroup(String[] userGroup);

    public void release();

    public void releaseGroup();

    public void start(String userId) throws WorkflowRuntimeException;

    public void end() throws WorkflowRuntimeException;

    public void end(String transitionId) throws WorkflowRuntimeException;

    public String getName();

    public Long getRootTokenId();

    public String getTaskNodeName();

    public String getTaskNodeLocalName();

    public IWorkflowProcessDef getProcessDef();

    public void clearStart();
}
