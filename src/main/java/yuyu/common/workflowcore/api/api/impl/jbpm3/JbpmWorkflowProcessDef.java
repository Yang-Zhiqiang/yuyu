package yuyu.common.workflowcore.api.api.impl.jbpm3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jbpm.JbpmException;
import org.jbpm.db.GraphSession;
import org.jbpm.db.TaskMgmtSession;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowTaskFilter;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

import com.google.common.base.Objects;

/**
 * ワークフロープロセスインターフェースのjBPM具象クラスです。
 */
public class JbpmWorkflowProcessDef implements IWorkflowProcessDef {

    Logger LOGGER = LoggerFactory.getLogger(JbpmWorkflowProcessDef.class);

    private JbpmWorkflowContext jbpmContext_ = null;

    private GraphSession graphSession = null;
    private ProcessDefinition processDefinition = null;

    private String processDefinitionName = null;

    public static JbpmWorkflowProcessDef getInstance(String processDefName, JbpmWorkflowContext ctx){

        if (processDefName == null){
            throw new NullPointerException("processDefNameが未設定です。");
        }
        if (ctx == null) {
            throw new NullPointerException("ctxが未設定です。");
        }

        return new JbpmWorkflowProcessDef(processDefName, ctx);
    }

    public static JbpmWorkflowProcessDef getInstance(ProcessDefinition jbpmProcessDef, JbpmWorkflowContext ctx){

        if (jbpmProcessDef == null){
            throw new NullPointerException("jbpmProcessDefが未設定です。");
        }
        if (ctx == null) {
            throw new NullPointerException("ctxが未設定です。");
        }

        return new JbpmWorkflowProcessDef(jbpmProcessDef, ctx);
    }

    private JbpmWorkflowProcessDef(String processDefName, JbpmWorkflowContext jbpmContext){

        jbpmContext_ = jbpmContext;
        graphSession = jbpmContext.getJbpmContext().getGraphSession();
        processDefinitionName = processDefName;
        processDefinition = graphSession.findLatestProcessDefinition(processDefName);
        if(processDefinition == null) {
            throw new WorkflowRuntimeException("プロセス定義の生成に失敗しました。");
        }
    }

    private JbpmWorkflowProcessDef(ProcessDefinition processDef, JbpmWorkflowContext jbpmContext) {
        jbpmContext_ = jbpmContext;
        graphSession = jbpmContext.getJbpmContext().getGraphSession();
        processDefinitionName = processDef.getName();
        processDefinition = processDef;
    }


    @Override
    public List<IWorkflowTask> getPersonaltasks(String userId) throws WorkflowRuntimeException {

        return getPersonaltasks(userId, null);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IWorkflowTask> getPersonaltasks(String userId, IWorkflowTaskFilter filter) throws WorkflowRuntimeException {

        LOGGER.debug(Objects.toStringHelper(this)
            .add("userId"          , userId)
            .add("filter is null ?", filter == null)
            .toString()
            );

        List<TaskInstance> returnTasks = new ArrayList<TaskInstance>();
        if(StringUtils.isEmpty(userId)){
            LOGGER.warn("ユーザIDがnullです。");
            return filter.filter(JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(returnTasks, this));
        }

        try {

            List<IWorkflowToken> iTokens = getAllTokens();
            LOGGER.debug("全トークン数 tilken.size = " + iTokens.size());
            TaskMgmtSession taskMgmtSession = jbpmContext_.getJbpmContext().getTaskMgmtSession();

            List<TaskInstance> tasks = taskMgmtSession.findTaskInstances(userId);
            for(TaskInstance task : tasks) {
                for(IWorkflowToken iToken : iTokens) {
                    JbpmWorkflowToken token = (JbpmWorkflowToken)iToken;
                    if(token.getJbpmToken().getId() == task.getToken().getId()){
                        LOGGER.debug("アクターIDが一致したため、個人タスクとみなす。");
                        returnTasks.add(task);
                    }
                }
            }

        } catch (JbpmException je) {
            LOGGER.info("タスクが存在しませんでした。");
        }

        if(filter == null){
            LOGGER.info("filterの指定がありません。フィルターせずに返却します。");
            return JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(returnTasks, this);
        }

        return filter.filter(JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(returnTasks, this));
    }

    @Override
    public List<IWorkflowTask> getAllGrouptasks() throws WorkflowRuntimeException {
        return getGrouptasks(null);
    }

    @Override
    public List<IWorkflowTask> getGrouptasks(IWorkflowTaskFilter filter) throws WorkflowRuntimeException {

        List<TaskInstance> returnTasks = new ArrayList<TaskInstance>();
        try {

            List<IWorkflowToken> iTokens = getAllTokens();
            LOGGER.debug("全トークン数 tilken.size = " + iTokens.size());


            Session session = SessionFactoryUtils.getSessionFactory().openSession();
            Query query = session.createQuery("select TaskInstance from org.jbpm.taskmgmt.exe.TaskInstance as TaskInstance Where ACTORID_ IS NULL");
            List<TaskInstance> tasks = query.list();

            for(IWorkflowToken iToken : iTokens) {
                JbpmWorkflowToken token = (JbpmWorkflowToken)iToken;


                for(TaskInstance task : tasks) {
                    if(token.getJbpmToken().getId() == task.getToken().getId()){
                        String actorid = task.getActorId();
                        LOGGER.debug("アクターID未設定のため、共通タスクとみなす。");
                        returnTasks.add(task);
                    }
                }
            }

        } catch (JbpmException je) {
            LOGGER.info("タスクが存在しませんでした。");
        }

        if(filter == null){
            LOGGER.info("filterの指定がありません。フィルターせずに返却します。");
            return JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(returnTasks, this);
        }

        return filter.filter(JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(returnTasks, this));

    }

    @Override
    public IWorkflowToken getToken(String tokenId) throws WorkflowRuntimeException {
        JbpmWorkflowToken token = null;

        if(tokenId == null) {
            throw new NullPointerException("トークンIDが未設定です。");
        }
        if(!StringUtils.isNumeric(tokenId)){
            throw new NumberFormatException("tokenId");
        }
        try {
            Token jbpmToken = graphSession.getToken(Long.parseLong(tokenId));

            if (jbpmToken == null) {
                return token;
            }


            if(!jbpmToken.getProcessInstance().getProcessDefinition().getName().equals(processDefinitionName)) {
                throw new WorkflowRuntimeException("トークンが存在するプロセス定義名が、このプロセス定義と異なります。" +
                    "[tokenId]" + tokenId + " [expected]" + processDefinitionName + " [actual]" + jbpmToken.getProcessInstance().getProcessDefinition().getName());
            }
            token = JbpmWorkflowToken.convertJbpmWorkflowToken(this, jbpmToken);

        } catch (JbpmException je) {
            throw new WorkflowRuntimeException("トークン取得処理でエラーが発生", je);
        }

        return token;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IWorkflowToken> getAllTokens() throws WorkflowRuntimeException {

        List<IWorkflowToken> tokens = new ArrayList<IWorkflowToken>();
        try {
            Long processDefId = processDefinition.getId();
            LOGGER.debug("プロセス定義IDを指定して、プロセスインスタンスを取得する。 ProcessDefId=" + processDefId);
            List<ProcessInstance> processInstances = graphSession.findProcessInstances(processDefId);
            LOGGER.debug("└結果件数： processInstances.size = " + processInstances.size());
            for (ProcessInstance processInstance : processInstances) {
                if(processInstance.hasEnded()){
                    continue;
                }
                LOGGER.debug("プロセスインスタンス中の全てのトークンを取得する。 processInstance.id = " + processInstance.getId());
                List<Token> jbpmTokens = processInstance.findAllTokens();
                LOGGER.debug("└結果件数： jbpmTokens.size = " + jbpmTokens.size());
                for (Token jbpmToken : jbpmTokens) {
                    if(!jbpmToken.hasEnded()){
                        tokens.add(getToken(String.valueOf(jbpmToken.getId())));
                        LOGGER.trace("　└トークン追加： jbpmToken.id = " + jbpmToken.getId());
                    }
                }
            }
        } catch (JbpmException je) {
            throw new WorkflowRuntimeException("トークン取得中に例外が発生しました。", je);
        }
        LOGGER.trace("getAllTokens[終了]");
        return tokens;
    }

    @Override
    public List<IWorkflowToken> getTokensByNodeName(String nodeName) throws WorkflowRuntimeException {

        List<IWorkflowToken> tokens = new ArrayList<IWorkflowToken>();
        for (IWorkflowToken jbpmToken : getAllTokens()) {
            if(jbpmToken.getNodeName().equals(nodeName)){
                tokens.add(jbpmToken);
            }
        }
        return tokens;
    }

    @Override
    public List<IWorkflowToken> getTokensByNodeId(String nodeId) throws WorkflowRuntimeException {

        List<IWorkflowToken> tokens = new ArrayList<IWorkflowToken>();
        for (IWorkflowToken jbpmToken : getAllTokens()) {
            if(jbpmToken.getNodeId().equals(nodeId)){
                tokens.add(jbpmToken);
            }
        }
        return tokens;

    }

    @Override
    public IWorkflowToken newToken() throws WorkflowRuntimeException {
        return JbpmWorkflowToken.newJbpmWorkflowToken(this);
    }

    @Override
    public String getProcessDefName() {
        return processDefinitionName;
    }

    @Override
    public IWorkflowContext getWorkflowContext() {
        return jbpmContext_;
    }

    @Override
    public String[] getNodeNames() {
        @SuppressWarnings("unchecked")
        Set<String> nodeNames = processDefinition.getNodesMap().keySet();
        return nodeNames.toArray(new String[]{}) ;
    }

    @Override
    public List<String> getTransitions(String nodeName) throws WorkflowRuntimeException{

        if(nodeName == null){
            return new ArrayList<String>();
        }
        List<String> retTransitions = new ArrayList<String>();
        for(Object element : this.processDefinition.getNode(nodeName).getLeavingTransitions()){
            Transition transition = (Transition)element;
            retTransitions.add(transition.getName());
        }

        if(retTransitions.size() == 0) {
            throw new WorkflowRuntimeException("指定ノードがエンドノードであるか、プロセス定義が壊れています。ノード名 = " + nodeName);
        }
        return retTransitions;
    }

    @Override
    public List<Map<String, String>> getTaskDefs() {
        List<Map<String, String>> taskDefs = new ArrayList<Map<String,String>>();
        String[] taskNodeNames = getTaskNodeNames();
        for(String tasknodeName : taskNodeNames) {
            Map<String, String> taskDef = new HashMap<String, String>();
            taskDef.put(TaskDefMapKey.sFLOWID, processDefinitionName);
            taskDef.put(TaskDefMapKey.sFLOWLOCALNAME, getLocalName(getDescription()));
            taskDef.put(TaskDefMapKey.sFLOWSORTORDER, getSortOrder(getDescription()));
            taskDef.put(TaskDefMapKey.sTASKNAME, tasknodeName);
            taskDef.put(TaskDefMapKey.sTASKLOCALNAME, getLocalName(getTaskDescription(tasknodeName)));
            taskDef.put(TaskDefMapKey.sTASKSORTORDER, getSortOrder(getTaskDescription(tasknodeName)));
            taskDefs.add(taskDef);
        }
        return taskDefs;
    }

    @Override
    public String getLocalName() {
        return getLocalName(getDescription());
    }

    @Override
    public String getTasknodeLocalName(String tasknodeName) {
        return getLocalName(getTaskDescription(tasknodeName));
    }

    protected Node getNode(String nodeName) {

        if(nodeName == null) {
            throw new NullPointerException("ノード名が未設定です。");
        }
        return processDefinition.getNode(nodeName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String[] getTaskNodeNames() {
        return (String[])processDefinition.getTaskMgmtDefinition().getTasks().keySet().toArray(new String[0]);
    }

    private String getDescription() {
        processDefinition.getTaskMgmtDefinition().getTasks();
        return processDefinition.getDescription();
    }

    private String getTaskDescription(String nodeName) {
        if(getNode(nodeName) != null) {
            return getNode(nodeName).getDescription();
        }

        return null;
    }

    private String getSortOrder(String description) {
        if(description == null) {
            return "-1";
        }
        String[] descriptionSplit = description.split(",");
        String sortOrder = descriptionSplit[0];


        try {
            Integer.parseInt(descriptionSplit[0]);
        } catch (NumberFormatException e) {
            return "-1";
        }

        return sortOrder;
    }

    private String getLocalName(String description) {
        if(description == null) {
            return "";
        }
        String localName = null;

        String[] descriptionSplit = description.split(",");
        try {
            localName = descriptionSplit[1];
        } catch (Exception e) {
            return "";
        }
        return localName;
    }

}
