package yuyu.common.workflowcore.api.api;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * ワークフロープロセス
 *
 * <p>
 * ワークフロープロセスは、ワークフロー制御の起点となるクラスです。
 * ワークフローコンテキストでは、ワークフローエンジンへの永続化機能へのアクセス手段を提供します。
 * また、ワークフローコンテキストの利用者は、プロセス定義などの
 * ワークフロー全体に関係する情報に対するアクセスを意識することなくプロセス定義IDを指定することで、
 * トークン情報他ワークフロー制御用のオブジェクトを得ることができます。
 *
 * ※ゆうゆうワークフローでは、一つの事務手続きは、ワークフローではプロセス定義として表現されます。
 * ※プロセス定義は、プロセス定義IDによって一意に識別されます。
 * </p>
 */
public interface IWorkflowProcessDef {

    public List<IWorkflowTask> getAllGrouptasks() throws WorkflowRuntimeException;

    public List<IWorkflowTask> getGrouptasks(IWorkflowTaskFilter filter) throws WorkflowRuntimeException;

    interface TaskDefMapKey{
        public static final String sFLOWID             = "flowid";
        public static final String sFLOWLOCALNAME      = "flowlocalname";
        public static final String sFLOWSORTORDER      = "flowsortorder";
        public static final String sTASKNAME           = "taskname";
        public static final String sTASKLOCALNAME      = "tasklocalname";
        public static final String sTASKSORTORDER      = "tasksortorder";

    }

    public List<IWorkflowTask> getPersonaltasks(String userId) throws WorkflowRuntimeException;

    public List<IWorkflowTask> getPersonaltasks(String userId, IWorkflowTaskFilter filter) throws WorkflowRuntimeException;

    public List<IWorkflowToken> getAllTokens() throws WorkflowRuntimeException;

    public List<IWorkflowToken> getTokensByNodeName(String nodeName) throws WorkflowRuntimeException;

    public List<IWorkflowToken> getTokensByNodeId(String nodeId) throws WorkflowRuntimeException;

    public IWorkflowToken getToken(String tokenId) throws WorkflowRuntimeException;

    public IWorkflowToken newToken() throws WorkflowRuntimeException;

    public String getProcessDefName();

    public IWorkflowContext getWorkflowContext();

    public String[] getNodeNames();

    public String[] getTaskNodeNames();

    public List<String> getTransitions(String nodeName) throws WorkflowRuntimeException;

    public List<Map<String, String>> getTaskDefs();

    public String getLocalName();

    public String getTasknodeLocalName(String tasknodeName);

}