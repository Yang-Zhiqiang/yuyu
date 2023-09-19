package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSON;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.TaskCount;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.CommonGetExecutableTasks.WSTaskCount;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;


/**
 * 実行可能タスク情報取得サービスのメインクラス<br />
 */
public class WSGetExecutableTasksImpl implements WSGetExecutableTasks{


    private final static Logger LOGGER = LoggerFactory.getLogger(WSGetExecutableTasksImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSGetExecutableTasksImpl () {
        super();
    }

    public WSGetExecutableTasksResponse validate(
        WSGetExecutableTasksRequest request) throws Exception {

        LOGGER.debug("│バリデーションチェック処理・・・");

        WSGetExecutableTasksResponse oResponse = new WSGetExecutableTasksResponse();

        String sAccountId = request.getAccountid();
        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントID");
        }
        return oResponse;
    }


    public String getServiceName() {
        return WSGetExecutableTasksRequest.sSERVICE_NAME;
    }


    public void initialize(WSGetExecutableTasksRequest request) throws Exception {

    }



    @Override
    public WSGetExecutableTasksResponse executeBizMain(
        WSGetExecutableTasksRequest request) throws Exception {

        LOGGER.debug("|主処理開始・・・");

        LOGGER.debug("処理1");
        WSGetExecutableTasksResponse oResponse = new WSGetExecutableTasksResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sRequestId = request.getRequestid();
        String sAccountId = request.getAccountid();
        String sKensuuSyutokuYouhi = request.getKensuuSyutokuYouhi();

        LOGGER.debug("処理2");
        IWorkflowContext oWfCon = WorkflowContextFactory.newInstance();

        LOGGER.debug("処理3");

        try {
            LOGGER.debug("処理4");
            oWfCon.open();
            LOGGER.debug("処理5");

            List<String> flowids          = new ArrayList<String>();
            List<String> taskNames        = new ArrayList<String>();
            List<String> taskCountKojin   = new ArrayList<String>();
            List<String> taskCountKyouyuu = new ArrayList<String>();

            LOGGER.debug("処理6");


            Set<List<String>> kengenKouteiSet = SWAKInjector.getInstance(WorkflowAuthInfo.class).getProcessAuthByUserId(sAccountId);

            if(kengenKouteiSet.isEmpty()) {
                if(oWfCon.isOpen()){
                    oWfCon.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2070);
                return oResponse;
            }

            List<TaskInfo> authTasks = new ArrayList<TaskInfo>();
            for(List<String> kengenKoutei : kengenKouteiSet) {
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setFlowid(kengenKoutei.get(0));
                taskInfo.setNodename(kengenKoutei.get(1));
                if(!authTasks.contains(taskInfo)) {
                    authTasks.add(taskInfo);
                    LOGGER.trace("以下の権限を取得しました。Flowid=" + taskInfo.getFlowid() + " Nodename=" + taskInfo.getNodename());
                }
            }

            LOGGER.debug("処理9");

            List<TaskInfo> allTaskInfoList = new ArrayList<TaskInfo>();
            for (IWorkflowProcessDef process : oWfCon.getAllProcessDefs()) {
                for (String taskNodeName : process.getTaskNodeNames()) {
                    TaskInfo taskInfo = new TaskInfo();
                    taskInfo.setFlowid(process.getProcessDefName());
                    taskInfo.setNodename(taskNodeName);
                    allTaskInfoList.add(taskInfo);
                }
            }

            LOGGER.debug("処理8");

            if(Strings.isNullOrEmpty(sKensuuSyutokuYouhi) || C_YouhiKbn.YOU.getValue().equals(sKensuuSyutokuYouhi)){

                Map<String,WSTaskCount> map = new HashMap<String, WSTaskCount>();
                List<TaskCount> taskCountList = oWfCon.getTaskCounts(sAccountId);
                LOGGER.debug("処理8.1");
                for(TaskCount taskCount : taskCountList) {
                    TaskInfo taskInfo = new TaskInfo();
                    taskInfo.setFlowid(taskCount.getFlowId());
                    taskInfo.setNodename(taskCount.getTaskName());
                    if(!authTasks.contains(taskInfo)) {
                        LOGGER.trace("以下のデータをタスク数マップに追加します。");
                        LOGGER.trace("[flowId = " + taskCount.getFlowId() + ", taskName = " + taskCount.getTaskName() + ", kojin = " + taskCount.getMyTaskCount() + ", kyouyuu = " + taskCount.getMiwariateTaskCount() + "]");
                        WSTaskCount wsTaskCount = new WSTaskCount();
                        wsTaskCount.setKojin(taskCount.getMyTaskCount());
                        wsTaskCount.setKyouyuu(taskCount.getMiwariateTaskCount());
                        map.put(taskInfo.getName(), wsTaskCount);
                    }
                }

                LOGGER.debug("処理10");
                LOGGER.trace("編集中のタスク数マップ : "+ JSON.encode(map, true));
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

                    flowids.add(flowId);
                    taskNames.add(taskName);

                    if(map.containsKey(taskInfo.getName())) {
                        WSTaskCount taskcount = map.get(taskInfo.getName());
                        LOGGER.trace("既に含んでいるノード名のため、追加する。フローID=" + taskInfo.getFlowid() + ", ノード名=" + taskInfo.getNodename() + ", kojin=" + taskcount.getKojin() + ", kyouyuu=" + taskcount.getKyouyuu());
                        taskCountKojin.add(Long.toString(taskcount.getKojin()));
                        taskCountKyouyuu.add(Long.toString(taskcount.getKyouyuu()));
                    }
                    else {
                        LOGGER.trace("初のノード名のため、個人も共有も0で初期化。フローID=" + taskInfo.getFlowid() + ", ノード名=" + taskInfo.getNodename() + "]");

                        taskCountKojin.add("0");
                        taskCountKyouyuu.add("0");
                    }
                }
                LOGGER.debug("処理11");

                oResponse.setFlowids(flowids.toArray(new String[]{}));
                oResponse.setNodename(taskNames.toArray(new String[]{}));
                oResponse.setTaskcountkojin(taskCountKojin.toArray(new String[]{}));
                oResponse.setTaskcountkyouyuu(taskCountKyouyuu.toArray(new String[]{}));

            } else {

                LOGGER.debug("処理9-2");

                for (TaskInfo taskInfo : authTasks) {
                    for(TaskInfo allTaskInfo : allTaskInfoList){
                        if(allTaskInfo.getFlowid().equals(taskInfo.getFlowid()) && allTaskInfo.getNodename().equals(taskInfo.getNodename())){
                            flowids.add(taskInfo.getFlowid());
                            taskNames.add(taskInfo.getNodename());
                        }
                    }
                }
                LOGGER.debug("処理10-2");

                int arrayLength = authTasks.size();
                oResponse.setFlowids(flowids.toArray(new String[]{}));
                oResponse.setNodename(taskNames.toArray(new String[]{}));
                oResponse.setTaskcountkojin(new String[arrayLength]);
                oResponse.setTaskcountkyouyuu(taskCountKyouyuu.toArray(new String[arrayLength]));

            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "実行可能タスク情報取得");
            LOGGER.debug( IwfMessageUtil.getMessage(IwfMessageCd.IWF0000, "実行可能タスク情報取得"));

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "実行可能タスク情報取得");
        } finally {
            if(oWfCon.isOpen()){
                oWfCon.close();
            }
        }
        return oResponse;
    }


    public WSGetExecutableTasksResponse getStubResult(
        WSGetExecutableTasksRequest request) throws Exception {

        return null;
    }


    public WSGetExecutableTasksResponse getBootErrResponse() {
        WSGetExecutableTasksResponse res = new WSGetExecutableTasksResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    private class TaskInfo {
        private String sFlowid_;
        private String sNodename_;

        public String getFlowid() {
            return sFlowid_;
        }

        public void setFlowid(String psFlowid) {
            sFlowid_ = psFlowid;
        }

        public String getNodename() {
            return sNodename_;
        }

        public void setNodename(String psNodename) {
            sNodename_ = psNodename;
        }

        public String getName() {
            return sFlowid_ + "-" + sNodename_;
        }
    }
}
