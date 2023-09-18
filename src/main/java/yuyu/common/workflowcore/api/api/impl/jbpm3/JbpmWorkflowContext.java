package yuyu.common.workflowcore.api.api.impl.jbpm3;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.db.GraphSession;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.util.Clock;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowTaskFilter;
import yuyu.common.workflowcore.api.api.TaskCount;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * ワークフローコンテクストインターフェースのjBPM具象クラス
 */
public class JbpmWorkflowContext implements IWorkflowContext {

    @Inject
    private static Logger LOGGER;

    private JbpmContext jbpmContext = null;

    private boolean isOpen = false;

    private Map<String, IWorkflowProcessDef> processDefMap = null;

    public JbpmContext getJbpmContext() {
        if (jbpmContext == null) {
            Clock.dateGenerator = new Clock.DateGenerator() {
                @Override
                public Date getCurrentTime() {
                    return BizDate.getSystemDate().getTime();
                }
            };
            jbpmContext = SWAKInjector.getInstance(JbpmContext.class);
        }
        return jbpmContext;
    }

    @Override
    public void close() throws WorkflowRuntimeException {
        if (!isOpen) {
            throw new WorkflowRuntimeException("ワークフローコンテキストが開始していません。");
        }
        processDefMap = null;
        isOpen = false;
    }

    @Override
    public void open() throws WorkflowRuntimeException {
        if (isOpen) {
            throw new WorkflowRuntimeException("ワークフローコンテキストが既に開始しています。");
        }
        processDefMap = new HashMap<>();
        isOpen = true;
    }

    //    @Override
    //    public void save(Token token) throws WorkflowRuntimeException {
    //        if (!isOpen) {
    //            throw new WorkflowRuntimeException("ワークフローコンテキストが開始していません。");
    //        }
    //        getJbpmContext().save(token);
    //    }

    @Override
    public void saveAndClose() throws WorkflowRuntimeException {
        if (!isOpen) {
            throw new WorkflowRuntimeException("ワークフローコンテキストが開始していません。");
        }
        processDefMap = null;
        isOpen = false;
    }

    protected ProcessDefinition getJbpmProcessDef(String name) throws WorkflowRuntimeException {
        if (!isOpen) {
            throw new WorkflowRuntimeException("ワークフローコンテキストが開始していません。");
        }

        GraphSession graphSession = getJbpmContext().getGraphSession();
        ProcessDefinition processDefinition;

        try {
            processDefinition = graphSession.findLatestProcessDefinition(name);
        } catch (JbpmException je) {
            throw new WorkflowRuntimeException("JBPMプロセス定義取得処理でエラーが発生しました。", je);
        }
        return processDefinition;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public IWorkflowProcessDef getProcessDef(String processDefName) throws yuyu.common.workflowcore.api.exception.WorkflowRuntimeException {

        if(processDefMap.containsKey(processDefName)){
            return processDefMap.get(processDefName);
        }
        IWorkflowProcessDef processDef = JbpmWorkflowProcessDef.getInstance(processDefName, this);
        processDefMap.put(processDefName, processDef);
        return processDef;

    }

    @Override
    public IWorkflowProcessDef getPreviousProcessDef(String processDefName) throws yuyu.common.workflowcore.api.exception.WorkflowRuntimeException {
        int currentVersion = getJbpmProcessDef(processDefName).getVersion();
        ProcessDefinition previousJbpmProcessDef = getJbpmContext().getGraphSession().findProcessDefinition(processDefName, currentVersion - 1);
        return JbpmWorkflowProcessDef.getInstance(previousJbpmProcessDef, this);
    }

    @Override
    public List<IWorkflowProcessDef> getAllProcessDefs() throws WorkflowRuntimeException {

        List<IWorkflowProcessDef> list = new ArrayList<>();
        for(Object pdef : getJbpmContext().getGraphSession().findLatestProcessDefinitions()){
            IWorkflowProcessDef processDef = JbpmWorkflowProcessDef.getInstance(((ProcessDefinition)pdef).getName(), this);
            list.add(processDef);
            processDefMap.put(processDef.getProcessDefName(), processDef);
        }
        return list;
    }

    @Override
    public IWorkflowTaskFilter newTaskFilter() {
        return new JbpmWorkflowTaskFilter();
    }

    @Override
    public List<TaskCount> getTaskCounts(String userId) throws WorkflowRuntimeException {

        if(userId == null){
            throw new NullPointerException("userIdがNullです。");
        }

        Map<String, TaskCount> map = Maps.newHashMap();

        Session session = null;

        List<TaskCount> results = null;

        try {
            session = SessionFactoryUtils.getSessionFactory().openSession();

            Query query = session.createQuery(
                "select " +
                    "  new list(" +
                    "      processDefinition," +
                    "      taskInstance," +
                    "      taskInstance.token.node" +
                    "  )" +
                    "from" +
                    "  org.jbpm.taskmgmt.exe.TaskInstance as taskInstance ," +
                    "  org.jbpm.graph.def.ProcessDefinition as processDefinition " +
                    "where" +
                    "  taskInstance.isSuspended != true and" +
                    "  taskInstance.isOpen = true and" +
                    "  taskInstance.token.processInstance.processDefinition = processDefinition"
                );

            Query subQuery = session.createQuery(
                "select prodessDef_sub.name, MAX(prodessDef_sub.version) as ver " +
                    "from org.jbpm.graph.def.ProcessDefinition as prodessDef_sub "    +
                    "group by prodessDef_sub.name"
                );

            // select pd.*, ti.*
            // from jBPM_ProcessDefinition as pd,
            //      jBPM_ProcessInstance   as pi,
            //      jBPM_TaskInstance      as ti,
            //      jBPM_Token             as tk,
            //       (select   pd.NAME_               as NAME_,
            //                 max(pd.VERSION_)       as VERSION_
            //        from     jBPM_ProcessDefinition as pd
            //        group by pd.NAME_
            //       )                     as sq
            // where ti.ISSUSPENDED_      <> 1          and
            //       ti.ISOPEN_            = 1          and
            //       ti.TOKEN_             = tk.ID_     and
            //       tk.PROCESSINSTANCE_   = pi.ID_     and
            //       pi.PROCESSDEFINITION_ = pd.ID_     and
            //       pd.NAME_              = sq.NAME_   and
            //       pd.VERSION_           = sq.VERSION_;

            @SuppressWarnings("unchecked")
            List<Object[]> subResults = subQuery.list();

            @SuppressWarnings("unchecked")
            List<List<?>> list = query.list();
            for(List<?> elm : list){
                ProcessDefinition processDefinition  = (ProcessDefinition)elm.get(0);
                TaskInstance taskInstance            = (TaskInstance)elm.get(1);
                Node node                            = (Node)elm.get(2);

                boolean isMatch = false;
                for (Object[] li : subResults) {
                    if (li.length != 2) {
                        break;
                    }
                    String procName = li[0].toString();
                    String maxVer = li[1].toString();

                    if (procName.equals(processDefinition.getName())
                        && maxVer.equals(String.valueOf(processDefinition.getVersion()))) {
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    continue;
                }

                String key = processDefinition.getName() + "::::" + node.getName();
                if(StringUtils.isNotEmpty(taskInstance.getActorId())){

                    if(userId.equals(taskInstance.getActorId())){
                        if(map.containsKey(key)){
                            TaskCount taskCount = map.get(key);
                            taskCount.setWariatezumiTaskCount(taskCount.getWariatezumiTaskCount() + 1);
                            taskCount.setMyTaskCount(taskCount.getMyTaskCount() + 1);
                        }
                        else{
                            TaskCount taskCount = new TaskCount();
                            taskCount.setFlowId(processDefinition.getName());
                            taskCount.setTaskName(node.getName());
                            taskCount.setMiwariateTaskCount(0);
                            taskCount.setWariatezumiTaskCount(1);
                            taskCount.setMyTaskCount(1);
                            LOGGER.debug("key=" + key);
                            map.put(key, taskCount);
                        }
                    }
                    else{
                        if(map.containsKey(key)){
                            TaskCount taskCount = map.get(key);
                            taskCount.setWariatezumiTaskCount(taskCount.getWariatezumiTaskCount() + 1);
                        }
                        else{
                            TaskCount taskCount = new TaskCount();
                            taskCount.setFlowId(processDefinition.getName());
                            taskCount.setTaskName(node.getName());
                            taskCount.setMiwariateTaskCount(0);
                            taskCount.setWariatezumiTaskCount(1);
                            taskCount.setMyTaskCount(0);
                            LOGGER.debug("key=" + key);
                            map.put(key, taskCount);
                        }
                    }
                }
                else{
                    if(map.containsKey(key)){
                        TaskCount taskCount = map.get(key);
                        taskCount.setMiwariateTaskCount(taskCount.getMiwariateTaskCount() + 1);
                    }
                    else{
                        TaskCount taskCount = new TaskCount();
                        taskCount.setFlowId(processDefinition.getName());
                        taskCount.setTaskName(node.getName());
                        taskCount.setMiwariateTaskCount(1);
                        taskCount.setWariatezumiTaskCount(0);
                        taskCount.setMyTaskCount(0);
                        LOGGER.debug("key=" + key);
                        map.put(key, taskCount);
                    }
                }
            }
            LOGGER.debug("map.size = " + map.size());
            results = Lists.newArrayList(map.values());
            for(TaskCount taskCount : results){
                LOGGER.debug(
                    Objects.toStringHelper(this)
                    .add("FlowId"         , taskCount.getFlowId())
                    .add("TaskName"       , taskCount.getTaskName())
                    .add("MyTask"         , taskCount.getMyTaskCount())
                    .add("MiWariateTask"  , taskCount.getMiwariateTaskCount())
                    .add("WariateZumiTask", taskCount.getWariatezumiTaskCount())
                    .toString()
                    );
            }
        } finally {
            if(session != null){
                session.close();
            }
        }
        return results;

    }

    @Override
    public List<IWorkflowTask> getTasks(String pFlowId, String pNodename)
        throws WorkflowRuntimeException {
        List<IWorkflowTask> iworkflowTasks = Lists.newArrayList();

        Session session = null;

        try {
            session = SessionFactoryUtils.getSessionFactory().openSession();

            Query query = session.createQuery(
                " select " +
                    "  new list(" +
                    "      processDefinition," +
                    "      taskInstance" +
                    "  )" +
                    " from" +
                    "   org.jbpm.taskmgmt.exe.TaskInstance as taskInstance ," +
                    "   org.jbpm.graph.def.ProcessDefinition as processDefinition " +
                    " where " +
                    "   taskInstance.isSuspended != true and " +
                    "   taskInstance.isOpen = true and " +
                    "   taskInstance.token.processInstance.processDefinition = processDefinition and " +
                    "   taskInstance.token.node.name = :nodeName and" +
                    "   processDefinition.name = :flowId"
                );

            @SuppressWarnings("unchecked")
            List<List<?>> list = query.setString("nodeName", pNodename).setString("flowId", pFlowId).list();

            Query subQuery = session.createQuery(" select prodessDef_sub.name, MAX(prodessDef_sub.version) as ver from org.jbpm.graph.def.ProcessDefinition as prodessDef_sub group by prodessDef_sub.name");
            @SuppressWarnings("unchecked")
            List<Object[]> subResults = subQuery.list();

            for(List<?> elm : list){
                ProcessDefinition processDefinition  = (ProcessDefinition)elm.get(0);
                TaskInstance taskInstance            = (TaskInstance)elm.get(1);

                boolean isMatch = false;
                for (Object[] li : subResults) {
                    if (li.length != 2) {
                        break;
                    }
                    String procName = li[0].toString();
                    String maxVer = li[1].toString();

                    if (procName.equals(processDefinition.getName())
                        && maxVer.equals(String.valueOf(processDefinition.getVersion()))) {
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    continue;
                }

                iworkflowTasks.add(new JbpmWorkflowTask(taskInstance, this.getProcessDef(pFlowId)));
            }
        } finally {
            if(session != null){
                session.close();
            }
        }
        return iworkflowTasks;
    }
    static class Sqls{
        public static String quote(String pVal) {

            String sValStr = pVal;
            StringBuilder sb = new StringBuilder("");
            int iPrev = 0;
            for (int iPos = sValStr.indexOf("'"); iPos != -1; iPos = sValStr
                .indexOf("'", iPos)) {
                sb.append(sValStr.substring(iPrev, ++iPos));
                sb.append("'");
                iPrev = iPos;
            }
            sb.append(sValStr.substring(iPrev));
            sValStr = "'" + sb.toString() + "'";
            return sValStr;

        }

    }

    private boolean isJbpmContextExists() {
        return jbpmContext != null;
    }

    private void closeJbpmContext() {
        if (! isJbpmContextExists()) {
            return;
        }
        try {
            getJbpmContext().close();
        } finally {
            jbpmContext = null;
        }
    }

    @Deprecated
    @Override
    public void commitAndClose() {
        if (! isJbpmContextExists()) {
            return;
        }
        closeJbpmContext();
    }

    @Deprecated
    @Override
    public void rollbackAndClose() {
        if (! isJbpmContextExists()) {
            return;
        }
        getJbpmContext().setRollbackOnly();
        closeJbpmContext();
    }

    @Override
    public void deleteProcessInstance(long processInstanceId) {
        ProcessInstance pInstance = jbpmContext.loadProcessInstance(processInstanceId);
        jbpmContext.getGraphSession().deleteProcessInstance(pInstance);
    }

    @Override
    public void flushAndClear() {
        jbpmContext.getSession().flush();
        jbpmContext.getSession().clear();
    }

    @Override
    public void setConnection(Connection con) {
        getJbpmContext().setConnection(con);
    }

}
