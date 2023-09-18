package yuyu.common.workflowcore.api.api;

import java.sql.Connection;
import java.util.List;

import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * ワークフローコンテキストです。 タスク取得処理を単純化したバージョン
 *
 * <p>
 * ワークフローコンテキストは、ワークフロー制御の起点となるクラスです。
 * ワークフローコンテキストでは、ワークフローエンジンへの永続化機能へのアクセス手段を提供します。
 * また、ワークフローコンテキストの利用者は、プロセス定義などの
 * ワークフロー全体に関係する情報に対するアクセスを意識することなくプロセス定義IDを指定することで、
 * トークン情報他ワークフロー制御用のオブジェクトを得ることができます。
 *
 * ※ゆうゆうワークフローでは、一つの事務手続きは、ワークフローではプロセス定義として表現されます。
 * ※プロセス定義は、プロセス定義IDによって一意に識別されます。
 * </p>
 */
public interface IWorkflowContext {

    public void open() throws WorkflowRuntimeException;

    public boolean isOpen() throws WorkflowRuntimeException;

    public List<TaskCount> getTaskCounts(String userId) throws WorkflowRuntimeException;

    public List<IWorkflowTask> getTasks(String pFlowId, String pNodename) throws WorkflowRuntimeException;

    //    public void save(Token token) throws WorkflowRuntimeException;

    public void saveAndClose() throws WorkflowRuntimeException;

    public void close() throws WorkflowRuntimeException;

    public IWorkflowProcessDef getProcessDef(String processDefName) throws WorkflowRuntimeException;

    public IWorkflowProcessDef getPreviousProcessDef(String processDefName) throws WorkflowRuntimeException;

    public List<IWorkflowProcessDef> getAllProcessDefs() throws WorkflowRuntimeException;

    public IWorkflowTaskFilter newTaskFilter();

    @Deprecated
    void commitAndClose();

    @Deprecated
    void rollbackAndClose();

    public void deleteProcessInstance(long processInstanceId);

    public void flushAndClear();

    @Deprecated
    public void setConnection(Connection con);

}
