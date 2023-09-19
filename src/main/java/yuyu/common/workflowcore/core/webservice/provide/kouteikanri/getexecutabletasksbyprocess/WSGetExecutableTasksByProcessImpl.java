package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.ExDBResults;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.ExecutableTaskBean;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.ExecutableTaskDao;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.CommonGetExecutableTasksByProcess.TaskCount;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.CommonGetExecutableTasksByProcess.TaskInfo;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.CommonGetExecutableTasksByProcess.WSTaskCount;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.JBPM_PROCESSDEFINITION;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 実行可能タスク情報取得サービスのメインクラス<br />
 */
public class WSGetExecutableTasksByProcessImpl implements WSGetExecutableTasksByProcess{


    private final static Logger LOGGER = LoggerFactory.getLogger(WSGetExecutableTasksByProcessImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;
    @Inject
    private ExecutableTaskDao executableTaskDao;

    public WSGetExecutableTasksByProcessImpl () {
        super();
    }

    public WSGetExecutableTasksByProcessResponse validate(
        WSGetExecutableTasksByProcessRequest request) throws Exception {

        LOGGER.debug("│バリデーションチェック処理・・・");

        WSGetExecutableTasksByProcessResponse oResponse = new WSGetExecutableTasksByProcessResponse();

        String sAccountId = request.getAccountid();
        String sKouteiKaisiYmdFrom = request.getKouteikaisiYmdFrom();
        String sKouteiKaisiYmdTo = request.getKouteikaisiYmdTo();
        String sKouteiKanryouYmdFrom = request.getKouteikanryouYmdFrom();
        String sKouteiKanryouYmdTo = request.getKouteikanryouYmdTo();

        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントID");
            return oResponse;
        }

        if (StringUtils.isNotEmpty(sKouteiKaisiYmdTo)) {
            if (StringUtils.isEmpty(sKouteiKaisiYmdFrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF4024);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteiKaisiYmdFrom)) {
            if (StringUtils.isEmpty(sKouteiKaisiYmdTo)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF4024);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteiKanryouYmdTo)) {
            if (StringUtils.isEmpty(sKouteiKanryouYmdFrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF4025);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteiKanryouYmdFrom)) {
            if (StringUtils.isEmpty(sKouteiKanryouYmdTo)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF4025);
                return oResponse;
            }
        }

        return oResponse;
    }


    public String getServiceName() {
        return WSGetExecutableTasksByProcessRequest.sSERVICE_NAME;
    }


    public void initialize(WSGetExecutableTasksByProcessRequest request) throws Exception {
    }

    @Override
    public WSGetExecutableTasksByProcessResponse executeBizMain(
        WSGetExecutableTasksByProcessRequest request) throws Exception {

        WSGetExecutableTasksByProcessResponse oWSResponse = new WSGetExecutableTasksByProcessResponse();

        oWSResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sAccountId = request.getAccountid();
        String sRequestId = request.getRequestid();
        String[] sSyoriStatus = request.getSyoriStatus();
        String[] sFlowIds = request.getFlowIds();
        String sKouteiKaisiYmdFrom = request.getKouteikaisiYmdFrom();
        String sKouteiKaisiYmdTo = request.getKouteikaisiYmdTo();
        String sKouteiKanryouYmdFrom = request.getKouteikanryouYmdFrom();
        String sKouteiKanryouYmdTo = request.getKouteikanryouYmdTo();

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        try {

            List<TaskInfo> authTasks = new ArrayList<>();

            Set<List<String>> auths = SWAKInjector.getInstance(WorkflowAuthInfo.class).getProcessAuthByUserId(sAccountId);
            if (auths.isEmpty()) {
                IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF2070);
                LOGGER.debug("[ReqId=" + sRequestId + "]工程権限情報が取得できませんでした。");
                return oWSResponse;
            }

            for (List<String> auth : auths) {
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setFlowid(auth.get(0));
                taskInfo.setNodename(auth.get(1));
                authTasks.add(taskInfo);
            }

            List<JBPM_PROCESSDEFINITION> latestProcessDefList = getLatestProcessDefList(sFlowIds);

            List<Object[]> taskNodes = iwfCoreDomManager.getTaskNodeInfo();

            Map<String, TaskCount> map = Maps.newHashMap();
            List<TaskCount> taskWariateList = null;

            Map<String, List<String>> flowNodeList = Maps.newHashMap();
            for (TaskInfo info : authTasks) {
                String flowId = info.getFlowid();
                if (flowNodeList.containsKey(flowId)) {
                    List<String> nodeList = flowNodeList.get(info.getFlowid());
                    nodeList.add(info.getNodename());
                } else {
                    List<String> nodeList = Lists.newArrayList();
                    nodeList.add(info.getNodename());
                    flowNodeList.put(flowId, nodeList);
                }
            }
            for (String flowId : flowNodeList.keySet()) {
                List<String> nodeList = flowNodeList.get(flowId);
                try (ExDBResults<ExecutableTaskBean> taskBeans =
                    executableTaskDao.getExecutableTasksByCond(
                        sSyoriStatus,
                        flowId,
                        nodeList.toArray(new String[nodeList.size()]),
                        sKouteiKaisiYmdFrom,
                        sKouteiKaisiYmdTo,
                        sKouteiKanryouYmdFrom,
                        sKouteiKanryouYmdTo,
                        extParamMap)) {

                    for (ExecutableTaskBean taskBean : taskBeans) {

                        String actorId = taskBean.getActorId_();
                        Long procInsId = taskBean.getProcInst_();

                        String procNm = taskBean.getName_();
                        Long procVer = taskBean.getVersion_();

                        for (JBPM_PROCESSDEFINITION latestProcDef : latestProcessDefList) {
                            if (procNm.equals(latestProcDef.getName_()) && procVer.compareTo(latestProcDef.getVersion_()) == 0) {

                                for (Object[] objects : taskNodes) {
                                    if (procInsId.compareTo((Long) objects[0]) == 0) {
                                        String nodeName = (String) objects[1];
                                        String key = procNm + "::::" + nodeName;

                                        map = setWariate(map, key, sAccountId, actorId, procNm, nodeName);

                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
            taskWariateList = Lists.newArrayList(map.values());


            Map<String,WSTaskCount> taskCountMap = new HashMap<>();

            for (TaskCount taskCount : taskWariateList) {
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setFlowid(taskCount.getFlowId());
                taskInfo.setNodename(taskCount.getTaskName());

                for (TaskInfo authTask : authTasks){
                    if(taskInfo.getFlowid().equals(authTask.getFlowid()) && taskInfo.getNodename().equals(authTask.getNodename())){
                        WSTaskCount wsTaskCount = new WSTaskCount();
                        wsTaskCount.setKojin(taskCount.getMyTaskCount());
                        wsTaskCount.setKyouyuu(taskCount.getMiwariateTaskCount());
                        taskCountMap.put(taskInfo.getName(), wsTaskCount);
                    }
                }
            }

            oWSResponse = setTaskCount(oWSResponse, taskCountMap, authTasks, latestProcessDefList);

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "実行可能タスク情報取得サービス");

        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "実行可能タスク");
        }

        return oWSResponse;
    }

    @SuppressWarnings("null")
    private List<JBPM_PROCESSDEFINITION> getLatestProcessDefList(String[] flowIds) {

        List<JBPM_PROCESSDEFINITION> latestProcessDefList = new ArrayList<>();

        List<JBPM_PROCESSDEFINITION> allProcessDefList = iwfCoreDomManager.getAllProcessDef();

        List<Object[]> processDefList = iwfCoreDomManager.getLatestProcessDefs();

        boolean isSetFlowIds = (null == flowIds || 0 == flowIds.length) ? false : true;

        for (JBPM_PROCESSDEFINITION procDef : allProcessDefList) {
            String procName = procDef.getName_();
            Long procVer = procDef.getVersion_();

            boolean isInFlowIds = false;
            if (isSetFlowIds) {
                for (String flowId : flowIds) {
                    if (flowId.equals(procName)) {
                        isInFlowIds = true;
                        break;
                    }
                }
            }
            if (isSetFlowIds && !isInFlowIds) {
                continue;
            }

            for (int i = 0; i < processDefList.size(); i++) {
                Object[] latestProc = processDefList.get(i);
                if (procName.equals(latestProc[0]) && procVer.compareTo((Long) latestProc[1]) == 0) {
                    latestProcessDefList.add(procDef);
                    break;
                }
            }
        }

        return latestProcessDefList;
    }

    private List<TaskInfo> getAllTaskInfoList(List<JBPM_PROCESSDEFINITION> latestProcDefs) {

        List<TaskInfo> allTaskInfoList = new ArrayList<>();

        for (JBPM_PROCESSDEFINITION procDef : latestProcDefs) {
            Long procDefId = procDef.getId_();

            List<String> taskNms = iwfCoreDomManager.getNodesByProcDefId(procDefId);

            for (String taskName : taskNms) {
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setFlowid(procDef.getName_());
                taskInfo.setNodename(taskName);
                allTaskInfoList.add(taskInfo);
            }
        }

        return allTaskInfoList;
    }

    private WSGetExecutableTasksByProcessResponse setTaskCount(WSGetExecutableTasksByProcessResponse response,
        Map<String, WSTaskCount> taskCountMap, List<TaskInfo> authTasks,
        List<JBPM_PROCESSDEFINITION> latestProcessDefList) {

        List<String> flowIds = new ArrayList<>();
        List<String> taskNames = new ArrayList<>();
        List<String> taskCountKojin = new ArrayList<>();
        List<String> taskCountKyouyuu = new ArrayList<>();

        List<TaskInfo> allTaskInfoList = getAllTaskInfoList(latestProcessDefList);

        for (TaskInfo taskInfo : allTaskInfoList) {

            String flowId = taskInfo.getFlowid();
            String taskName = taskInfo.getNodename();

            boolean isHasKengen = false;
            for (TaskInfo authTask : authTasks) {
                if (flowId.equals(authTask.getFlowid()) && taskName.equals(authTask.getNodename())) {
                    isHasKengen = true;
                    break;
                }
            }

            if (!isHasKengen) {
                continue;
            }

            flowIds.add(flowId);
            taskNames.add(taskName);

            if (taskCountMap.containsKey(taskInfo.getName())) {
                WSTaskCount taskcount = taskCountMap.get(taskInfo.getName());
                LOGGER.trace("既に含んでいるノード名のため、追加する。フローID=" + taskInfo.getFlowid() + ", ノード名=" + taskInfo.getNodename()
                    + ", kojin=" + taskcount.getKojin() + ", kyouyuu=" + taskcount.getKyouyuu());

                taskCountKojin.add(Long.toString(taskcount.getKojin()));
                taskCountKyouyuu.add(Long.toString(taskcount.getKyouyuu()));
            }
            else {
                LOGGER.trace("初のノード名のため、個人も共有も0で初期化。フローID=" + taskInfo.getFlowid() + ", ノード名=" + taskInfo.getNodename()
                    + "]");

                taskCountKojin.add("0");
                taskCountKyouyuu.add("0");
            }
        }

        response.setFlowids(flowIds.toArray(new String[] {}));
        response.setNodename(taskNames.toArray(new String[] {}));
        response.setTaskcountkojin(taskCountKojin.toArray(new String[] {}));
        response.setTaskcountkyouyuu(taskCountKyouyuu.toArray(new String[] {}));

        return response;
    }

    private Map<String, TaskCount> setWariate(Map<String, TaskCount> map, String currentKey, String accountId,
        String actorId, String procName, String nodeName) {

        if (StringUtils.isNotEmpty(actorId)) {

            if (accountId.equals(actorId)) {
                if (map.containsKey(currentKey)) {
                    TaskCount taskCount = map.get(currentKey);
                    taskCount.setWariatezumiTaskCount(taskCount.getWariatezumiTaskCount() + 1);
                    taskCount.setMyTaskCount(taskCount.getMyTaskCount() + 1);
                } else {
                    TaskCount taskCount = new TaskCount();
                    taskCount.setFlowId(procName);
                    taskCount.setTaskName(nodeName);
                    taskCount.setMiwariateTaskCount(0);
                    taskCount.setWariatezumiTaskCount(1);
                    taskCount.setMyTaskCount(1);
                    map.put(currentKey, taskCount);
                }
            } else {
                if (map.containsKey(currentKey)) {
                    TaskCount taskCount = map.get(currentKey);
                    taskCount.setWariatezumiTaskCount(taskCount.getWariatezumiTaskCount() + 1);
                } else {
                    TaskCount taskCount = new TaskCount();
                    taskCount.setFlowId(procName);
                    taskCount.setTaskName(nodeName);
                    taskCount.setMiwariateTaskCount(0);
                    taskCount.setWariatezumiTaskCount(1);
                    taskCount.setMyTaskCount(0);
                    map.put(currentKey, taskCount);
                }
            }
        } else {
            if (map.containsKey(currentKey)) {
                TaskCount taskCount = map.get(currentKey);
                taskCount.setMiwariateTaskCount(taskCount.getMiwariateTaskCount() + 1);
            } else {
                TaskCount taskCount = new TaskCount();
                taskCount.setFlowId(procName);
                taskCount.setTaskName(nodeName);
                taskCount.setMiwariateTaskCount(1);
                taskCount.setWariatezumiTaskCount(0);
                taskCount.setMyTaskCount(0);
                map.put(currentKey, taskCount);
            }
        }

        return map;
    }

    public WSGetExecutableTasksByProcessResponse getStubResult(
        WSGetExecutableTasksByProcessRequest request) throws Exception {

        return null;
    }

    public WSGetExecutableTasksByProcessResponse getBootErrResponse() {
        WSGetExecutableTasksByProcessResponse res = new WSGetExecutableTasksByProcessResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}
