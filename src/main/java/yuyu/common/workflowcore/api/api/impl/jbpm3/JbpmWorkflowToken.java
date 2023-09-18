package yuyu.common.workflowcore.api.api.impl.jbpm3;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jbpm.JbpmException;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

/**
 * ワークフロートークンインターフェースのJbpm具象クラス
 */
public class JbpmWorkflowToken implements IWorkflowToken {
    private JbpmWorkflowProcessDef workflowProcessDef;

    private ProcessInstance processInstance;

    private ContextInstance contextInstance = null;

    private Token token;

    private String id;

    public static JbpmWorkflowToken newJbpmWorkflowToken(JbpmWorkflowProcessDef pProcessDef) {
        return new JbpmWorkflowToken(pProcessDef);
    }
    private JbpmWorkflowToken(JbpmWorkflowProcessDef pProcessDef) {
        this.workflowProcessDef = pProcessDef;
        ProcessDefinition processDefinition = ((JbpmWorkflowContext)pProcessDef.getWorkflowContext()).getJbpmProcessDef(pProcessDef.getProcessDefName());
        this.processInstance = new ProcessInstance(processDefinition);
        this.contextInstance = this.processInstance.getContextInstance();
        this.token = this.processInstance.getRootToken();
        this.id = new Long(this.token.getId()).toString();
    }

    protected static  JbpmWorkflowToken convertJbpmWorkflowToken(JbpmWorkflowProcessDef processDef, Token pJbpmToken) throws WorkflowRuntimeException{
        return new JbpmWorkflowToken(processDef, pJbpmToken);
    }
    private JbpmWorkflowToken(JbpmWorkflowProcessDef processDef, Token pJbpmToken) throws WorkflowRuntimeException {

        this.workflowProcessDef = processDef;
        if(pJbpmToken == null) {
            throw new NullPointerException("トークンが未設定です。");
        }
        this.processInstance = pJbpmToken.getProcessInstance();
        this.contextInstance = this.processInstance.getContextInstance();
        this.token = pJbpmToken;
        this.id = new Long(this.token.getId()).toString();
    }

    @Override
    public void deleteVariable(String variableName) {
        this.contextInstance.deleteVariable(variableName);
    }

    @Override
    public Object getVariable(String variableName) {
        return this.contextInstance.getVariable(variableName);
    }

    @Override
    public String getStringVariable(String variableName) {
        if(this.contextInstance.getVariable(variableName) == null){
            return null;
        } else {
            return this.contextInstance.getVariable(variableName).toString();
        }
    }

    @Override
    public void setVariable(String variableName, Object value) {

        contextInstance.setVariable(variableName, value);
    }

    @Override
    public void setStringVariable(String variableName, String value) {

        contextInstance.setVariable(variableName, value);
    }

    @Override
    public void next() throws WorkflowRuntimeException {

        if(this.token.hasEnded()) {
            throw new WorkflowRuntimeException("トークンは終了しています。");
        }

        List<IWorkflowTask> tasks = this.getTasks();

        if(!tasks.isEmpty()) {
            for(IWorkflowTask task : tasks) {
                task.end();
            }

        } else {

            if(this.getParent() == null) {
                this.token.getProcessInstance().signal();

            } else {
                this.token.signal();
            }
        }
    }

    @Override
    public String getDestTransionName(String srcNodeName, String destNodeName) {

        String destTransitionName = StringUtils.EMPTY;


        if (StringUtils.isEmpty(srcNodeName)) {
            throw new NullPointerException("遷移元ノード名が未設定です。");
        }


        if (StringUtils.isEmpty(destNodeName)) {
            throw new NullPointerException("遷移先ノード名が未設定です。");
        }


        @SuppressWarnings("unchecked")
        List<Transition> transitions = workflowProcessDef.getNode(srcNodeName).getLeavingTransitions();

        if (null == transitions || 0 == transitions.size()) {
            throw new WorkflowRuntimeException("指定された遷移先のトランジションが存在しません。");
        }

        for (Transition trans : transitions) {
            String nodeName = trans.getTo().getName();

            if (destNodeName.equals(nodeName)) {
                destTransitionName = trans.getName();
            }
        }

        return destTransitionName;
    }

    @Override
    public void next(String transitionName) throws WorkflowRuntimeException {

        if(transitionName == null) {
            throw new NullPointerException("transitionNameが未設定です。");
        }

        if(!workflowProcessDef.getTransitions(this.getNodeName()).contains(transitionName)) {
            throw new WorkflowRuntimeException("指定された遷移先は存在しません。");
        }

        if(this.token.hasEnded()) {
            throw new WorkflowRuntimeException("トークンは終了しています。");
        }

        List<IWorkflowTask> tasks = this.getTasks();

        if(!tasks.isEmpty()) {
            for(IWorkflowTask task : tasks) {
                task.end(transitionName);
            }

        } else {
            try {

                if(this.getParent() == null) {
                    this.token.getProcessInstance().signal(transitionName);

                } else {
                    this.token.signal(transitionName);
                }
            } catch (Exception e) {
                throw new WorkflowRuntimeException("トークン遷移の実行中にエラーが発生しました。", e);
            }
        }
    }

    @Override
    public void transfer(String srcNodeName, String destNodeName) throws WorkflowRuntimeException {

        try {

            if(srcNodeName == null || destNodeName == null) {
                throw new NullPointerException("遷移元ノード名または遷移先ノード名が未設定です。");
            }

            Node srcNode  = this.workflowProcessDef.getNode(srcNodeName);
            Node destNode = this.workflowProcessDef.getNode(destNodeName);


            boolean isErr = false;
            StringBuilder sb = new StringBuilder();
            if(srcNode == null){
                sb.append("指定された遷移元ノードが存在しません。指定ノード名 = ");
                sb.append(srcNodeName);
                sb.append("。");
                sb.append("\n");
                isErr = true;
            }
            if(destNode == null) {
                sb.append("指定された遷移先ノードが存在しません。指定ノード名 = ");
                sb.append(destNodeName);
                sb.append("。");
                sb.append("\n");
                isErr = true;
            }
            if(isErr) {
                throw new WorkflowRuntimeException(sb.toString());
            }


            if(!srcNodeName.equals(this.token.getNode().getName())){
                throw new WorkflowRuntimeException("設定された開始ノード名が実際の開始ノード名と異なります。");
            }


            Date date = new Date();
            String newTransitionName = "warp" + date.toString();
            Transition transition = new Transition(newTransitionName);
            transition.setFrom(srcNode);
            transition.setTo(destNode);

            srcNode.addLeavingTransition(transition);


            List<IWorkflowTask> tasks = this.getTasks();


            this.token.signal(transition);


            if(!tasks.isEmpty()) {

                for(IWorkflowTask task : tasks) {
                    task.end();
                }
            }


            srcNode.removeLeavingTransition(transition);
        } catch (Exception e) {
            throw new WorkflowRuntimeException(e);
        }
    }

    protected Token getJbpmToken() {
        return this.token;
    }

    protected void setJbpmToken(Token pToken) {
        this.token = pToken;
    }

    @Override
    public JbpmWorkflowToken getChild(String tokenName) throws WorkflowRuntimeException {

        if(tokenName == null) {
            throw new WorkflowRuntimeException("トークン名が未設定です。");
        }
        Token childJbpmToken = null;
        childJbpmToken = this.token.getChild(tokenName);

        JbpmWorkflowToken childToken = null;
        if (childJbpmToken != null) {

            childToken = new JbpmWorkflowToken((JbpmWorkflowProcessDef)getProcessDef(), childJbpmToken);
        }

        return childToken;
    }

    @Override
    public JbpmWorkflowToken getParent() {

        Token parentJbpmToken = null;
        parentJbpmToken = this.token.getParent();

        JbpmWorkflowToken parentToken = null;
        if (parentJbpmToken != null) {
            parentToken = new JbpmWorkflowToken((JbpmWorkflowProcessDef)getProcessDef(), parentJbpmToken);
        }

        return parentToken;

    }
    @Override
    public boolean isRootToken(){
        return !hasParent();
    }
    @Override
    public boolean hasParent(){
        if(this.token.getParent() == null){
            return false;
        }
        return true;
    }

    @Override
    public JbpmWorkflowToken getRootToken(){
        if(isRootToken()){
            return this;
        }
        JbpmWorkflowToken token = this;
        int i=0;
        while(true){
            JbpmWorkflowToken parent = token.getParent();
            if(parent.isRootToken()){
                return parent;
            }
            token = parent;
            i++;
            if(i>100){
                throw new WorkflowRuntimeException("存在するはずのルートトークンが見つかりません。[id=" + this.getId() + ",  NodeId=" + this.getNodeId() + "]");
            }
        }
    }

    @Override
    public Map<String, IWorkflowToken> getChildren() {

        Map<String, IWorkflowToken> children = new HashMap<String, IWorkflowToken>();
        @SuppressWarnings("unchecked")
        Map<String, Token> jbpmChildren = this.token.getChildren();
        if (jbpmChildren != null) {
            for (Object token : jbpmChildren.values()) {
                JbpmWorkflowToken child = new JbpmWorkflowToken(
                    (JbpmWorkflowProcessDef) getProcessDef(), (Token) token);
                children.put(child.getId(), child);
            }
        }
        return children;
    }

    @Override
    public Map<String, IWorkflowToken> getDescendants() {
        Map<String, IWorkflowToken> descendants = new HashMap<String, IWorkflowToken>();

        Map<String, IWorkflowToken> children = getChildren();
        if(!children.isEmpty()){
            for(String key : children.keySet()){
                descendants.putAll(children.get(key).getDescendants());
            }
        }
        return descendants;
    }

    ProcessInstance getProcessInstance() {

        return this.processInstance;
    }
    void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Token getToken() {
        return this.token;
    }

    @Override
    public void end() {
        if(!this.token.hasParent()) {
            this.processInstance.end();
        }
        else {
            this.token.end();
        }
        List<IWorkflowTask> tasks = this.getTasks();

        if(!tasks.isEmpty()) {
            for(IWorkflowTask task : tasks) {
                task.end();
            }
        }
    }

    @Override
    public String getNodeName() {
        return this.token.getNode().getName();
    }

    @Override
    public String getNodeId() {
        return new Long(this.token.getNode().getId()).toString();
    }

    @Override
    public IWorkflowProcessDef getProcessDef() {
        return this.workflowProcessDef;
    }

    @Override
    public long getProcessInstanceId() {
        return this.token.getProcessInstance().getId();
    }

    @Override
    public List<IWorkflowTask> getTasks() {
        ArrayList<TaskInstance> tokenTasks = new ArrayList<TaskInstance>();
        try {
            JbpmWorkflowContext jbpmWorkflowContext = (JbpmWorkflowContext)this.workflowProcessDef.getWorkflowContext();

            @SuppressWarnings("unchecked")
            List<TaskInstance> tasks = jbpmWorkflowContext.getJbpmContext().getTaskMgmtSession().findTaskInstancesByToken(new Long(token.getId()));
            tokenTasks.addAll(tasks);
        } catch (JbpmException je) {
            throw new WorkflowRuntimeException("トークンタスク取得中にエラーが発生しました。", je);
        }
        return JbpmWorkflowUtils.convertJbpmTaskToWorkflowTask(tokenTasks, workflowProcessDef);
    }

    @Override
    public boolean hasEnded(){
        return this.getJbpmToken().hasEnded();
    }

    @Override
    public void setVariables(Map<String, Object> variables) {
        for (Map.Entry<String, Object> e : variables.entrySet()) {
            setVariable(e.getKey(), e.getValue());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getVariables() {
        return this.getJbpmToken().getProcessInstance().getContextInstance().getVariables();
    }
}
