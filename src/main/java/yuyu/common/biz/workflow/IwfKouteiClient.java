package yuyu.common.biz.workflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import net.arnx.jsonic.JSON;

import org.apache.commons.lang.StringUtils;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordByKinouInBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordByKinouOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetLastRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoInBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordAndSummaryByUserInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordAndSummaryByUserOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskDefsInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskDefsOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetTasksOutBean;
import yuyu.common.biz.workflow.io.koutei.IkkatuProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.IkkatuProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateOutBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskOutBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskOutBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExtParamBean;
import yuyu.common.biz.workflow.io.koutei.sub.LockInfoBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessForwardForBatchBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessUpdateForBatchBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskDefBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfCompressUtils;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess.WSContinueLockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execforceprocessforward.WSExecForceProcessForwardResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward.WSExecProcessForwardResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.ProcessForwardBeanForBatch;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch.WSExecProcessForwardForBatchResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdate.WSExecProcessUpdateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.ProcessUpdateBeanForBatch;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart.WSExecTaskStartResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getTaskKensuu.WSGetTaskKensuuResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks.WSGetExecutableTasksResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess.WSGetExecutableTasksByProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser.WSGetKouteiRirekiAndSummaryByUserResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.IWSGetKouteiRirekiSummaryIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.IWSGetKouteiRirekiSyousaiIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.IWSGetLockInfoIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.IWSGetTaskDefsIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskdefs.WSGetTaskDefsResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettaskkensuubyactor.WSGetTaskKensuuByActorResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks.WSGetTasksResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.IWSGetTaskSummaryIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary.WSGetTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.IWSGetTaskSummaryByActorIOKey;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummarybyactor.WSGetTaskSummaryByActorResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate.WSIkkatuProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess.WSUnlockProcessResponse;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.thoughtworks.xstream.XStream;


/**
 * イメージワークフローイメージ管理サービスのクライアントクラスです。</ br>
 * Injectして使用して下さい</ br>
 */
public class IwfKouteiClient {

    @Inject
    IwfCommonClient client;

    @Inject
    UniqueKeyGenerator uniqueKey;

    @Inject
    private BaseUserInfo baseUserInfo;

    public ProcessCreateOutBean execProcessCreate(ProcessCreateInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessCreateInBean.class.getSimpleName());

            WSExecProcessCreateRequest request = new WSExecProcessCreateRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setAccountid(inBean.getAccountid());
            request.setFlowid(inBean.getFlowid());
            request.setProcessgroup(inBean.getProcessgroup());
            if(null != inBean.getExtInfo()){
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }
            if(null != inBean.getRirekiTaskName()){
                request.setRirekiTaskName(IwfBase64Urls.encodeFromString(inBean.getRirekiTaskName()));
            }

            WSExecProcessCreateResponse response = client.execProcessCreate(request);

            ProcessCreateOutBean outBean = new ProcessCreateOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public IkkatuProcessCreateOutBean execIkkatuProcessCreate(IkkatuProcessCreateInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, IkkatuProcessCreateInBean.class.getSimpleName());

            WSIkkatuProcessCreateRequest request = new WSIkkatuProcessCreateRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            List<ProcessCreateInBean> processCreateInBeanList = inBean.getProcessCreateInBeanList();
            List<Map<String, String>> oInMapList = new ArrayList<Map<String,String>>();

            for (int i = 0; i < processCreateInBeanList.size(); i++) {
                ProcessCreateInBean processCreateInBean = processCreateInBeanList.get(i);

                Map<String, String> inMap = new HashMap<String, String>();
                inMap.put("gyoumukey", processCreateInBean.getGyoumukey());
                inMap.put("flowid", processCreateInBean.getFlowid());
                inMap.put("accountid", processCreateInBean.getAccountid());
                inMap.put("processgroup", processCreateInBean.getProcessgroup());
                if (null != processCreateInBean.getExtInfo()) {
                    inMap.put("extinfo", JSON.encode(processCreateInBean.getExtInfo()));
                }

                oInMapList.add(inMap);
            }
            if(!oInMapList.isEmpty()){
                request.setMaplistXml(IwfBase64Urls.encode(IwfCompressUtils.compress(new XStream().toXML(oInMapList))));
            }

            WSIkkatuProcessCreateResponse response = client.execIkkatuProcessCreate(request);

            IkkatuProcessCreateOutBean outBean = new IkkatuProcessCreateOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProcessForwardOutBean execProcessForward(ProcessForwardInBean inBean, Object... contditions) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessForwardInBean.class.getSimpleName());

            WSExecProcessForwardRequest request = new WSExecProcessForwardRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            if (contditions.length > 0) {
                request.setRuleConditionName(IwfBase64Urls.encodeFromString(contditions[0].getClass().getName()));
                request.setRuleCondition(IwfBase64Urls.encodeFromString(JSON.encode(contditions[0])));
            }

            request.setGyoumukey(inBean.getGyoumukey());
            request.setAccountid(inBean.getAccountid());
            request.setFlowid(inBean.getFlowid());
            request.setLockkey(inBean.getLockkey());
            request.setRuleServiceUrl(inBean.getRuleServiceUrl());
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }
            if (null != inBean.getRirekiTaskName()) {
                request.setRirekiTaskName(IwfBase64Urls.encodeFromString(inBean.getRirekiTaskName()));
            }

            WSExecProcessForwardResponse response = client.execProcessForward(request);

            ProcessForwardOutBean outBean = new ProcessForwardOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setAutocreateflowid(response.getAutocreateflowid());
            outBean.setKouteisyuuryouflg(response.getKouteisyuuryouflg());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ForceProcessForwardOutBean execForceProcessForward(ForceProcessForwardInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ForceProcessForwardInBean.class.getSimpleName());

            WSExecForceProcessForwardRequest request = new WSExecForceProcessForwardRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setSrcnodename(inBean.getSrcnodename());
            request.setDestnodename(inBean.getDestnodename());
            request.setAccountid(inBean.getAccountid());
            request.setLockkey(inBean.getLockkey());

            WSExecForceProcessForwardResponse response = client.execForceProcessForward(request);

            ForceProcessForwardOutBean outBean = new ForceProcessForwardOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public ProcessForwardForBatchOutBean execProcessForwardForBatch(ProcessForwardForBatchInBean inBean,
        Object... contditions) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessForwardForBatchInBean.class.getSimpleName());

            WSExecProcessForwardForBatchRequest request = new WSExecProcessForwardForBatchRequest();

            request.setAccountid(inBean.getAccountId());
            request.setRuleServiceUrl(inBean.getRuleServiceUrl());
            request.setRirekiYouhi(inBean.getRirekiYouhi());

            List<ProcessForwardBeanForBatch> forwardBeans = new ArrayList<ProcessForwardBeanForBatch>();

            List<ProcessForwardForBatchBean> batchBeans = inBean.getProcessForwardForBatchBeanList();
            if (null != batchBeans) {
                for (ProcessForwardForBatchBean batchBean : batchBeans) {
                    ProcessForwardBeanForBatch forwardBean = new ProcessForwardBeanForBatch();

                    forwardBean.setFlowid(batchBean.getFlowid());
                    forwardBean.setGyoumukey(batchBean.getGyoumukey());
                    forwardBean.setLockConfirmKbn(batchBean.getLockConfirmKbn());
                    forwardBean.setLockkey(batchBean.getLockkey());
                    forwardBean.setRirekiTaskMessage(batchBean.getRirekiTaskMessage());
                    forwardBean.setRuleConditionName(IwfBase64Urls.encodeFromString(batchBean.getRuleCondition().getClass().getName()));
                    forwardBean.setRuleCondition(IwfBase64Urls.encodeFromString(JSON.encode(batchBean.getRuleCondition())));

                    if (null != batchBean.getExtInfo()) {
                        forwardBean.setExtInfo(IwfBase64Urls.encodeFromString(JSON.encode(batchBean.getExtInfo())));
                    }
                    if (null != batchBean.getRirekiTaskName()) {
                        forwardBean.setRirekiTaskName(IwfBase64Urls.encodeFromString(batchBean.getRirekiTaskName()));
                    }
                    IwfClientUtil.setCommonRequestParams(batchBean, forwardBean);

                    forwardBeans.add(forwardBean);
                }
            }

            request.setProcessForwardForBatchBeanList(forwardBeans);

            WSExecProcessForwardForBatchResponse response = client.execProcessForwardForBatch(request);

            ProcessForwardForBatchOutBean outBean = new ProcessForwardForBatchOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setAutocreateflowid(response.getAutocreateflowid());
            outBean.setKouteisyuuryouflg(response.getKouteisyuuryouflg());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProcessForwardForBatchOutBean execProcessForwardForBatch(ProcessForwardForBatchInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessForwardForBatchInBean.class.getSimpleName());

            WSExecProcessForwardForBatchRequest request = new WSExecProcessForwardForBatchRequest();

            request.setRequestid(inBean.getRequestid());
            request.setAccountid(inBean.getAccountId());
            request.setRuleServiceUrl(inBean.getRuleServiceUrl());
            request.setRirekiYouhi(inBean.getRirekiYouhi());

            List<ProcessForwardBeanForBatch> forwardBeans = new ArrayList<ProcessForwardBeanForBatch>();

            List<ProcessForwardForBatchBean> batchBeans = inBean.getProcessForwardForBatchBeanList();
            if (null != batchBeans) {
                for (ProcessForwardForBatchBean batchBean : batchBeans) {
                    ProcessForwardBeanForBatch forwardBean = new ProcessForwardBeanForBatch();

                    forwardBean.setFlowid(batchBean.getFlowid());
                    forwardBean.setGyoumukey(batchBean.getGyoumukey());
                    forwardBean.setLockConfirmKbn(batchBean.getLockConfirmKbn());
                    forwardBean.setLockkey(batchBean.getLockkey());
                    forwardBean.setRirekiTaskMessage(batchBean.getRirekiTaskMessage());
                    if (null != batchBean.getRuleCondition()) {
                        forwardBean.setRuleConditionName(IwfBase64Urls.encodeFromString(batchBean.getRuleCondition().getClass().getName()));
                        forwardBean.setRuleCondition(IwfBase64Urls.encodeFromString(JSON.encode(batchBean.getRuleCondition())));
                    }

                    List<Map<String, String>> extInfoList = batchBean.getExtInfo() != null ? new ArrayList<>(batchBean.getExtInfo()) : new ArrayList<Map<String,String>>();

                    if (StringUtils.isNotEmpty(batchBean.getRirekiTaskName())) {
                        Map<String, String> taskNmMap = new HashMap<>();
                        taskNmMap.put("taskname", batchBean.getRirekiTaskName());
                        extInfoList.add(taskNmMap);
                    }
                    if (!extInfoList.isEmpty()) {
                        forwardBean.setExtInfo(IwfBase64Urls.encodeFromString(JSON.encode(extInfoList)));
                    }
                    if (null != batchBean.getRirekiTaskName()) {
                        forwardBean.setRirekiTaskName(IwfBase64Urls.encodeFromString(batchBean.getRirekiTaskName()));
                    }

                    IwfClientUtil.convertRequestParams(batchBean, forwardBean);

                    forwardBeans.add(forwardBean);
                }
            }

            request.setProcessForwardForBatchBeanList(forwardBeans);
            request.setRequestid(uniqueKey.generateUniqueKey());

            IwfClientUtil.outputIwfBeginLogList(batchBeans);

            WSExecProcessForwardForBatchResponse response = client.execProcessForwardForBatch(request);

            ProcessForwardForBatchOutBean outBean = new ProcessForwardForBatchOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setAutocreateflowid(response.getAutocreateflowid());
            outBean.setKouteisyuuryouflg(response.getKouteisyuuryouflg());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProcessCancelOutBean execProcessCancel(ProcessCancelInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessCancelInBean.class.getSimpleName());

            WSExecProcessCancelRequest request = new WSExecProcessCancelRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setFlowid(inBean.getFlowid());
            request.setAccountid(inBean.getAccountid());
            request.setLockkey(inBean.getLockkey());
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }

            WSExecProcessCancelResponse response = client.execProcessCancel(request);

            ProcessCancelOutBean outBean = new ProcessCancelOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProcessUpdateOutBean execProcessUpdate(ProcessUpdateInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessUpdateInBean.class.getSimpleName());

            WSExecProcessUpdateRequest request = new WSExecProcessUpdateRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setFlowid(inBean.getFlowid());
            request.setAccountid(inBean.getAccountid());
            request.setLockkey(inBean.getLockkey());
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }

            WSExecProcessUpdateResponse response = client.execProcessUpdate(request);

            ProcessUpdateOutBean outBean = new ProcessUpdateOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProcessUpdateForBatchOutBean execProcessUpdateForBatch(ProcessUpdateForBatchInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ProcessUpdateForBatchInBean.class.getSimpleName());

            WSExecProcessUpdateForBatchRequest request = new WSExecProcessUpdateForBatchRequest();
            request.setRequestid(uniqueKey.generateUniqueKey());
            request.setAccountid(inBean.getAccountid());
            request.setLockConfirmKbn(inBean.getLockConfirmKbn());

            List<ProcessUpdateBeanForBatch> UpdateBeans = new ArrayList<>();

            List<ProcessUpdateForBatchBean> batchBeans = inBean.getProcessUpdateForBatchBeanList();

            if (null != batchBeans) {
                for (ProcessUpdateForBatchBean batchBean : batchBeans) {
                    ProcessUpdateBeanForBatch UpdateBean = new ProcessUpdateBeanForBatch();
                    UpdateBean.setGyoumukey(batchBean.getGyoumukey());
                    UpdateBean.setFlowid(batchBean.getFlowid());
                    UpdateBean.setLockkey(batchBean.getLockkey());
                    List<Map<String, String>> extInfoList = batchBean.getExtInfo() != null ? new ArrayList<>(batchBean.getExtInfo()) : new ArrayList<Map<String,String>>();
                    if(!extInfoList.isEmpty()) {
                        UpdateBean.setExtInfo(IwfBase64Urls.encodeFromString(JSON.encode(extInfoList)));
                    }
                    IwfClientUtil.convertRequestParams(batchBean, UpdateBean);
                    UpdateBeans.add(UpdateBean);
                }
            }
            request.setProcessUpdateBeanForBatchList(UpdateBeans);
            IwfClientUtil.outputIwfBeginLogList(batchBeans);

            WSExecProcessUpdateForBatchResponse response = client.execProcessUpdateForBatch(request);

            ProcessUpdateForBatchOutBean outBean = new ProcessUpdateForBatchOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setErrGyoumukey(response.getErrGyoumukey());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public CreateProcessRecordOutBean execCcreateProcessRecord(CreateProcessRecordInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, CreateProcessRecordInBean.class.getSimpleName());

            WSCreateProcessRecordRequest request = new WSCreateProcessRecordRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setFlowid(inBean.getFlowid());
            request.setAccountid(inBean.getAccountid());
            if (null != inBean.getRirekimsg()) {
                request.setRirekimsg(IwfBase64Urls.encodeFromString(inBean.getRirekimsg()));
            }
            request.setTaskname(inBean.getTaskname());

            List<Map<String, String>> extInfoList = new ArrayList<Map<String,String>>();
            if (null != inBean.getExtInfo()) {
                extInfoList = inBean.getExtInfo();
            }

            if (StringUtils.isNotEmpty(inBean.getTaskname())) {
                Map<String, String> taskNmMap = new HashMap<String, String>();
                taskNmMap.put("taskname", inBean.getTaskname());
                extInfoList.add(taskNmMap);
            }

            if (!extInfoList.isEmpty()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(extInfoList)));
            }

            WSCreateProcessRecordResponse response = client.execCcreateProcessRecord(request);

            CreateProcessRecordOutBean outBean = new CreateProcessRecordOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetProcessSummaryOutBean execGetProcessSummary(GetProcessSummaryInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetProcessSummaryInBean.class.getSimpleName());

            WSGetKouteiRirekiSummaryRequest request = new WSGetKouteiRirekiSummaryRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setGyoumukey(inBean.getGyoumukey());
            request.setGyoumukeys(inBean.getGyoumukeys());
            request.setFlowid(inBean.getFlowid());
            request.setFlowids(inBean.getFlowids());
            request.setAccountid(inBean.getAccountid());
            request.setLastsyoritimefrom(inBean.getLastsyoritimefrom());
            request.setLastsyoritimeto(inBean.getLastsyoritimeto());
            request.setKouteikaisibifrom(inBean.getKouteikaisibifrom());
            request.setKouteikaisibito(inBean.getKouteikaisibito());
            request.setKouteikanryoubifrom(inBean.getKouteikanryoubifrom());
            request.setKouteikanryoubito(inBean.getKouteikanryoubito());
            request.setSyoristatus(inBean.getSyoristatus());
            request.setNodename(inBean.getNodename());
            request.setAccountwariateumu(inBean.getAccountwariateumu());
            request.setKekkajyougenkensu(inBean.getKekkajyougenkensu());

            WSGetKouteiRirekiSummaryResponse response = client.execGetProcessSummary(request);

            GetProcessSummaryOutBean outBean = new GetProcessSummaryOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (response.getRirekimaps() != null) {
                List<ProcessSummaryBean> summarys = new ArrayList<ProcessSummaryBean>();

                for (Map<String, String> map : response.getRirekimaps()) {

                    ProcessSummaryBean summary = new ProcessSummaryBean();
                    ExtParamBean extParamBean = new ExtParamBean();

                    summary.setFlowId(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_FLOWID));
                    summary.setGyoumukey(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_GYOUMUKEY));
                    summary.setKouteiKaisiYmd(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_KOUTEI_KAISIBI));
                    summary.setKouteikanryouYmd(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_KOUTEI_KANRYOUBI));
                    summary.setProcessstatus(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_SYORI_STATUS));
                    summary.setUpdateTime(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_LAST_UPDATE));
                    summary.setFirstAccountId(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_FIRST_ACCOUNTID));
                    summary.setPreviousAccountId(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_PREVIOUS_ACCOUNTID));
                    summary.setPreviousNodeName(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_PREVIOUS_NODENAME));
                    summary.setPreviousNodeLocalname(map
                        .get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_PREVIOUS_NODELOCALNAME));
                    summary.setCurrentAccountId(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_ACCOUNTID));
                    summary.setCurrentNodeName(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_NODENAME));
                    summary.setCurrentNodeLocalname(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_NODELOCALNAME));

                    extParamBean.setExtparam1(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM1));
                    extParamBean.setExtparam2(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM2));
                    extParamBean.setExtparam3(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM3));
                    extParamBean.setExtparam4(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM4));
                    extParamBean.setExtparam5(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM5));
                    extParamBean.setExtparam6(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM6));
                    extParamBean.setExtparam7(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM7));
                    extParamBean.setExtparam8(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM8));
                    extParamBean.setExtparam9(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM9));
                    extParamBean.setExtparam10(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM10));
                    extParamBean.setExtparam11(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM11));
                    extParamBean.setExtparam12(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM12));
                    extParamBean.setExtparam13(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM13));
                    extParamBean.setExtparam14(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM14));
                    extParamBean.setExtparam15(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM15));
                    extParamBean.setExtparam16(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM16));
                    extParamBean.setExtparam17(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM17));
                    extParamBean.setExtparam18(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM18));
                    extParamBean.setExtparam19(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM19));
                    extParamBean.setExtparam20(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM20));
                    extParamBean.setExtparam21(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM21));
                    extParamBean.setExtparam22(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM22));
                    extParamBean.setExtparam23(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM23));
                    extParamBean.setExtparam24(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM24));
                    extParamBean.setExtparam25(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM25));
                    extParamBean.setExtparam26(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM26));
                    extParamBean.setExtparam27(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM27));
                    extParamBean.setExtparam28(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM28));
                    extParamBean.setExtparam29(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM29));
                    extParamBean.setExtparam30(map.get(IWSGetKouteiRirekiSummaryIOKey.MapKey.sS_EXTPARAM30));
                    summary.setExtparamBean(extParamBean);

                    summarys.add(summary);
                }

                outBean.setProcessSummaryBeanList(summarys);
            }
            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public GetProcessRecordOutBean execGetProcessRecord(GetProcessRecordInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetProcessRecordInBean.class.getSimpleName());

            WSGetKouteiRirekiSyousaiRequest request = new WSGetKouteiRirekiSyousaiRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setRirekikbn(inBean.getRirekikbn());

            WSGetKouteiRirekiSyousaiResponse response = client.execGetProcessRecord(request);

            GetProcessRecordOutBean outBean = new GetProcessRecordOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (response.getRirekimaps() != null) {
                List<ProcessRecordBean> processes = new ArrayList<ProcessRecordBean>();

                for (Map<String, String> map : response.getRirekimaps()) {

                    ProcessRecordBean process = new ProcessRecordBean();

                    process.setSyoriTime(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_SYORITiME));
                    process.setFlowId(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_FLOW_ID));
                    process.setGyoumukey(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_GYOUMUKEY));

                    process.setFlowName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_FLOW_LOCALNAME));
                    process.setNodeName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_NODE_NAME));
                    process.setNodeLocalName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_NODE_LOCALNAME));
                    process.setAccountId(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_ACCOUNT_ID));
                    process.setSyoriKbn(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_SYORI_KBN));
                    process.setRirekiKbn(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_RIREKI_KBN));
                    process.setRirekiMessage(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_RIREKI_MESSAGE));
                    //                  process.setExtinfo((List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_EXT_INFO)))));
                    String extInfo = map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_EXT_INFO);
                    if (null != extInfo && !(extInfo.isEmpty())) {
                        process.setExtinfo((List<Map<String, String>>) JSON.decode(IwfBase64Urls
                            .decodeToString(extInfo)));
                    }
                    else {
                        process.setExtinfo(null);
                    }
                    processes.add(process);
                }

                if (null != processes && !(processes.isEmpty())) {
                    Collections.sort(processes,
                        new Comparator<ProcessRecordBean>() {
                        @Override
                        public int compare(ProcessRecordBean record1, ProcessRecordBean record2) {
                            return record2.getSyoriTime().compareTo(
                                record1.getSyoriTime());
                        }
                    });
                }
                outBean.setProcessRecordBeanList(processes);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public GetProcessRecordAndSummaryByUserOutBean execGetProcessRecordAndSummaryByUser(GetProcessRecordAndSummaryByUserInBean inBean) {
        try {
            IwfClientUtil.validateInBean(inBean, GetProcessRecordAndSummaryByUserInBean.class.getSimpleName());

            WSGetKouteiRirekiAndSummaryByUserRequest request = new WSGetKouteiRirekiAndSummaryByUserRequest();

            IwfClientUtil.setCommonRequestParams(inBean, request);
            request.setUserId(inBean.getUserId());
            request.setListFlowid(inBean.getListFlowId());
            request.setSyoriTimeFrom(inBean.getSyoriTimeFrom());
            request.setSyoriTimeTo(inBean.getSyoriTimeTo());

            WSGetKouteiRirekiAndSummaryByUserResponse response = client.execGetProcessRecordAndSummaryByUser(request);

            GetProcessRecordAndSummaryByUserOutBean outBean = new GetProcessRecordAndSummaryByUserOutBean();
            outBean.setKouteiRirekiAndSummary(response.getKouteiRirekiAndSummary());

            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public GetLastRecordOutBean execGetLastRecord(GetLastRecordInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetLastRecordInBean.class.getSimpleName());

            WSGetKouteiRirekiSyousaiRequest request = new WSGetKouteiRirekiSyousaiRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setRirekikbn(inBean.getRirekikbn());

            WSGetKouteiRirekiSyousaiResponse response = client.execGetProcessRecord(request);

            GetLastRecordOutBean outBean = new GetLastRecordOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (response.getRirekimaps() != null) {
                List<ProcessRecordBean> processes = new ArrayList<ProcessRecordBean>();

                for (Map<String, String> map : response.getRirekimaps()) {

                    ProcessRecordBean process = new ProcessRecordBean();

                    process.setSyoriTime(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_SYORITiME));
                    process.setFlowId(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_FLOW_ID));
                    process.setGyoumukey(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_GYOUMUKEY));

                    process.setFlowName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_FLOW_LOCALNAME));
                    process.setNodeName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_NODE_NAME));
                    process.setNodeLocalName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_NODE_LOCALNAME));
                    process.setAccountId(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_ACCOUNT_ID));
                    process.setSyoriKbn(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_SYORI_KBN));
                    process.setRirekiKbn(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_RIREKI_KBN));
                    process.setRirekiMessage(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_RIREKI_MESSAGE));
                    //                  process.setExtinfo((List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_EXT_INFO)))));
                    String extInfo = map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_EXT_INFO);
                    if (null != extInfo && !(extInfo.isEmpty())) {
                        process.setExtinfo((List<Map<String, String>>) JSON.decode(IwfBase64Urls
                            .decodeToString(extInfo)));
                    }
                    else {
                        process.setExtinfo(null);
                    }

                    if ("03".equals(process.getSyoriKbn()) ||
                        "06".equals(process.getSyoriKbn())) {
                        processes.add(process);
                    }
                }

                if (null != processes && !(processes.isEmpty())) {
                    Collections.sort(processes,
                        new Comparator<ProcessRecordBean>() {
                        @Override
                        public int compare(ProcessRecordBean record1, ProcessRecordBean record2) {
                            return record2.getSyoriTime().compareTo(
                                record1.getSyoriTime());
                        }
                    });
                    outBean.setProcessRecordBean(processes.get(0));
                }
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public GetLastRecordByKinouOutBean execGetLastRecordByKinou(GetLastRecordByKinouInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetLastRecordByKinouInBean.class.getSimpleName());

            WSGetKouteiRirekiSyousaiRequest request = new WSGetKouteiRirekiSyousaiRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setRirekikbn(inBean.getRirekikbn());

            WSGetKouteiRirekiSyousaiResponse response = client.execGetProcessRecord(request);

            GetLastRecordByKinouOutBean outBean = new GetLastRecordByKinouOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (response.getRirekimaps() != null) {
                List<ProcessRecordBean> processes = new ArrayList<ProcessRecordBean>();

                for (Map<String, String> map : response.getRirekimaps()) {

                    ProcessRecordBean process = new ProcessRecordBean();

                    process.setSyoriTime(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_SYORITiME));
                    process.setFlowId(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_FLOW_ID));
                    process.setGyoumukey(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_GYOUMUKEY));

                    process.setFlowName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_FLOW_LOCALNAME));
                    process.setNodeName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_NODE_NAME));
                    process.setNodeLocalName(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_NODE_LOCALNAME));
                    process.setAccountId(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_ACCOUNT_ID));
                    process.setSyoriKbn(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_SYORI_KBN));
                    process.setRirekiKbn(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_RIREKI_KBN));
                    process.setRirekiMessage(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_RIREKI_MESSAGE));
                    //                  process.setExtinfo((List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_EXT_INFO)))));
                    String extInfo = map.get(IWSGetKouteiRirekiSyousaiIOKey.MapKey.sS_EXT_INFO);
                    if (null != extInfo && !(extInfo.isEmpty())) {
                        process.setExtinfo((List<Map<String, String>>) JSON.decode(IwfBase64Urls
                            .decodeToString(extInfo)));
                    }
                    else {
                        process.setExtinfo(null);
                    }
                    processes.add(process);
                }

                if (null != processes && !(processes.isEmpty())) {

                    Collections.sort(processes,
                        new Comparator<ProcessRecordBean>() {
                        @Override
                        public int compare(ProcessRecordBean record1, ProcessRecordBean record2) {
                            return record2.getSyoriTime().compareTo(
                                record1.getSyoriTime());
                        }
                    });

                    List<ProcessRecordBean> filterdProcesses = ImmutableList.copyOf(Iterables.filter(processes,
                        new FilterKinouIdKinouSsId(inBean.getKinouId(), inBean.getKinouSSId())));

                    if (null != filterdProcesses && !(filterdProcesses.isEmpty())) {
                        outBean.setProcessRecordBean(filterdProcesses.get(0));
                    }

                }
            }
            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public class FilterKinouIdKinouSsId implements Predicate<ProcessRecordBean>{
        String kinouId;
        String kinouSsId;

        public FilterKinouIdKinouSsId(String pKinouId, String pKinouSsId){
            super();
            kinouId = pKinouId;
            kinouSsId = pKinouSsId;
        }

        @Override
        public boolean apply(ProcessRecordBean pProcess) {

            if (StringUtils.isEmpty(kinouId) && StringUtils.isEmpty(kinouSsId)) {
                return true;
            }

            if (StringUtils.isNotEmpty(kinouId) && StringUtils.isEmpty(kinouSsId)) {
                if (kinouId.equals(IwfClientUtil.getKinouId(pProcess.getNodeName()))) {
                    return true;
                }
            }

            if (StringUtils.isNotEmpty(kinouSsId) && StringUtils.isEmpty(kinouId)) {
                if (kinouSsId.equals(IwfClientUtil.getKinouMode(pProcess.getNodeName()))) {
                    return true;
                }
            }

            if (StringUtils.isNotEmpty(kinouId) && StringUtils.isNotEmpty(kinouSsId)) {
                if (kinouId.equals(IwfClientUtil.getKinouId(pProcess.getNodeName()))
                    && kinouSsId.equals(IwfClientUtil.getKinouMode(pProcess.getNodeName()))) {
                    return true;
                }
            }

            return false;
        }
    }

    public LockProcessOutBean execLockProcess(LockProcessInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, LockProcessInBean.class.getSimpleName());

            WSLockProcessRequest request = new WSLockProcessRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setLockkey(inBean.getLockkey());
            request.setAccountid(baseUserInfo.getUserId());

            WSLockProcessResponse response = client.execLockProcess(request);

            LockProcessOutBean outBean = new LockProcessOutBean();
            outBean.setGyoumukey(response.getGyoumukey());
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public UnlockProcessOutBean execUnlockProcess(UnlockProcessInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, UnlockProcessInBean.class.getSimpleName());

            WSUnlockProcessRequest request = new WSUnlockProcessRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setLockkey(inBean.getLockkey());

            WSUnlockProcessResponse response = client.execUnlockProcess(request);

            UnlockProcessOutBean outBean = new UnlockProcessOutBean();
            outBean.setGyoumukey(response.getGyoumukey());
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public WSForceUnlockProcessResponse execForceUnlockProcess(ForceUnlockProcessInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ForceUnlockProcessInBean.class.getSimpleName());

            WSForceUnlockProcessRequest request = new WSForceUnlockProcessRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());

            WSForceUnlockProcessResponse response = client.execForceUnlockProcess(request);

            ForceUnlockProcessOutBean outBean = new ForceUnlockProcessOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public ContinueLockProcessOutBean execContinueLockProcess(ContinueLockProcessInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, ContinueLockProcessInBean.class.getSimpleName());

            WSContinueLockProcessRequest request = new WSContinueLockProcessRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setLockkey(inBean.getLockkey());
            request.setAccountid(baseUserInfo.getUserId());

            WSContinueLockProcessResponse response = client.execContinueLockProcess(request);

            ContinueLockProcessOutBean outBean = new ContinueLockProcessOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetLockInfoOutBean getLockInfo(GetLockInfoInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetLockInfoInBean.class.getSimpleName());

            WSGetLockInfoRequest request = new WSGetLockInfoRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());

            WSGetLockInfoResponse response = client.execGetLockInfo(request);

            GetLockInfoOutBean outBean = new GetLockInfoOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (null != response.getLockInfomaps()) {
                List<LockInfoBean> lockInfos = new ArrayList<LockInfoBean>();

                for (Map<String, String> map : response.getLockInfomaps()) {

                    LockInfoBean lockinfo = new LockInfoBean();

                    lockinfo.setFlowId(map.get(IWSGetLockInfoIOKey.MapKey.sS_FLOW_ID));
                    lockinfo.setGyoumukey(map.get(IWSGetLockInfoIOKey.MapKey.sS_GYOUMUKEY));
                    lockinfo.setNodeName(map.get(IWSGetLockInfoIOKey.MapKey.sS_NODE_NAME));
                    lockinfo.setAccountId(map.get(IWSGetLockInfoIOKey.MapKey.sS_ACCOUNT_ID));
                    lockinfo.setLockKey(map.get(IWSGetLockInfoIOKey.MapKey.sS_LOCKKEY));
                    lockinfo.setLockTime(map.get(IWSGetLockInfoIOKey.MapKey.sS_LOCKTiME));

                    lockInfos.add(lockinfo);
                }
                outBean.setLockInfoBeanList(lockInfos);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public StartTaskOutBean execStartTask(StartTaskInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, StartTaskInBean.class.getSimpleName());

            WSExecTaskStartRequest request = new WSExecTaskStartRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setTaskname(inBean.getTaskname());
            request.setAccountid(inBean.getAccountid());
            request.setLockkey(inBean.getLockkey());
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }

            WSExecTaskStartResponse response = client.execStartTask(request);

            StartTaskOutBean outBean = new StartTaskOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public UnassignTaskOutBean execUnsignTask(UnassignTaskInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, UnassignTaskInBean.class.getSimpleName());

            WSExecTaskCancelRequest request = new WSExecTaskCancelRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setGyoumukey(inBean.getGyoumukey());
            request.setAccountid(inBean.getAccountid());
            String rirekiAccountId = inBean.getRirekiaccountid();
            request.setRirekiaccountid(StringUtils.isEmpty(rirekiAccountId) ? inBean.getAccountid() : rirekiAccountId);
            request.setLockkey(inBean.getLockkey());
            if (null != inBean.getExtInfo()) {
                request.setExtinfo(IwfBase64Urls.encodeFromString(JSON.encode(inBean.getExtInfo())));
            }

            WSExecTaskCancelResponse response = client.execUnassignTask(request);

            UnassignTaskOutBean outBean = new UnassignTaskOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetExecutableTasksOutBean execGetExecutableTasks(GetExecutableTasksInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetExecutableTasksInBean.class.getSimpleName());

            WSGetExecutableTasksRequest request = new WSGetExecutableTasksRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.seKensuuSyutokuYouhi(inBean.getKensuuSyutokuYouhi());

            WSGetExecutableTasksResponse response = client.execGetExecutableTasks(request);

            GetExecutableTasksOutBean outBean = new GetExecutableTasksOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            List<ExecutableTaskInfoBean> taskBeanList = new ArrayList<ExecutableTaskInfoBean>();
            String[] flowids = response.getFlowids();
            String[] nodenames = response.getNodename();
            String[] taskcoutkojins = response.getTaskcountkojin();
            String[] taskcoutkyouyuus = response.getTaskcountkyouyuu();
            if (flowids != null) {
                for (int i = 0; i < flowids.length; i++) {
                    ExecutableTaskInfoBean taskBean = new ExecutableTaskInfoBean();
                    taskBean.setFlowId(flowids[i]);
                    taskBean.setNodeName(nodenames[i]);
                    taskBean.setTaskCountKojin(taskcoutkojins[i]);
                    taskBean.setTaskcountKyouyuu(taskcoutkyouyuus[i]);
                    taskBeanList.add(taskBean);
                }
            }
            outBean.setExecutableTaskInfos(taskBeanList);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetExecutableTasksByProcessOutBean execGetExecutableTasksByProcess(GetExecutableTasksByProcessInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetExecutableTasksByProcessInBean.class.getSimpleName());

            WSGetExecutableTasksByProcessRequest request = new WSGetExecutableTasksByProcessRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setKouteikaisiYmdFrom(inBean.getKouteikaisiYmdFrom());
            request.setKouteikaisiYmdTo(inBean.getKouteikaisiYmdTo());
            request.setKouteikanryouYmdFrom(inBean.getKouteikanryouYmdFrom());
            request.setKouteikanryouYmdTo(inBean.getKouteikanryouYmdTo());
            request.setSyoriStatus(inBean.getSyoriStatus());
            request.setFlowIds(inBean.getFlowIds());

            WSGetExecutableTasksByProcessResponse response = client.execGetExecutableTasksByProcess(request);

            GetExecutableTasksByProcessOutBean outBean = new GetExecutableTasksByProcessOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            List<ExecutableTaskInfoBean> taskBeanList = new ArrayList<ExecutableTaskInfoBean>();
            String[] flowids = response.getFlowids();
            String[] nodenames = response.getNodename();
            String[] taskcoutkojins = response.getTaskcountkojin();
            String[] taskcoutkyouyuus = response.getTaskcountkyouyuu();
            if (flowids != null) {
                for (int i = 0; i < flowids.length; i++) {
                    ExecutableTaskInfoBean taskBean = new ExecutableTaskInfoBean();
                    taskBean.setFlowId(flowids[i]);
                    taskBean.setNodeName(nodenames[i]);
                    taskBean.setTaskCountKojin(taskcoutkojins[i]);
                    taskBean.setTaskcountKyouyuu(taskcoutkyouyuus[i]);
                    taskBeanList.add(taskBean);
                }
            }
            outBean.setExecutableTaskInfos(taskBeanList);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetTasksOutBean execGetTasks(GetTasksInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTasksInBean.class.getSimpleName());

            WSGetTasksRequest request = new WSGetTasksRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setFlowid(inBean.getFlowid());
            request.setNodename(inBean.getNodename());
            request.setAccountid(inBean.getAccountid());
            request.setTaskkbn(inBean.getTaskkbn());

            WSGetTasksResponse response = client.execGetTasks(request);

            GetTasksOutBean outBean = new GetTasksOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            outBean.setGyoumukeys(response.getGyoumukeys());

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetTaskDefsOutBean execGetTaskDefs(GetTaskDefsInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTaskDefsInBean.class.getSimpleName());

            WSGetTaskDefsRequest request = new WSGetTaskDefsRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setFlowid(inBean.getFlowid());

            WSGetTaskDefsResponse response = client.execGetTaskDefs(request);

            GetTaskDefsOutBean outBean = new GetTaskDefsOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (response.getTaskdefs() != null) {
                List<TaskDefBean> taskDefs = new ArrayList<TaskDefBean>();

                for (Map<String, String> map : response.getTaskdefs()) {

                    TaskDefBean taskDef = new TaskDefBean();

                    taskDef.setFlowId(map.get(IWSGetTaskDefsIOKey.MapKey.sS_FLOW_ID));
                    taskDef.setFlowName(map.get(IWSGetTaskDefsIOKey.MapKey.sS_FLOW_LOCALNAME));
                    taskDef.setTaskName(map.get(IWSGetTaskDefsIOKey.MapKey.sTASK_NAME));
                    taskDef.setTaskLocalName(map.get(IWSGetTaskDefsIOKey.MapKey.sTASK_LOCALNAME));
                    taskDef.setTaskKengen(map.get(IWSGetTaskDefsIOKey.MapKey.sTASK_KENGENUMU));

                    taskDefs.add(taskDef);
                }
                outBean.setTaskDefBeanList(taskDefs);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public CreateTaskSummaryOutBean execCreateTaskSummary(CreateTaskSummaryInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, CreateTaskSummaryInBean.class.getSimpleName());

            WSCreateTaskSummaryRequest request = new WSCreateTaskSummaryRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setSFlowids(inBean.getSFlowids());

            WSCreateTaskSummaryResponse response = client.execCreateTaskSummary(request);

            CreateTaskSummaryOutBean outBean = new CreateTaskSummaryOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetTaskSummaryOutBean execGetTaskSummary(GetTaskSummaryInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTaskSummaryInBean.class.getSimpleName());

            WSGetTaskSummaryRequest request = new WSGetTaskSummaryRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setWariateumu(inBean.getWariateumu());
            request.setTaskendumu(inBean.getTaskendumu());
            request.setFlowid(inBean.getFlowid());
            request.setTaskid(inBean.getTaskid());
            request.setTaskcreatetimefrom(inBean.getTaskcreatetimefrom());
            request.setTaskcreatetimeto(inBean.getTaskcreatetimeto());
            request.setTaskstarttimefrom(inBean.getTaskstarttimefrom());
            request.setTaskstarttimeto(inBean.getTaskstarttimeto());
            request.setTaskendtimefrom(inBean.getTaskendtimefrom());
            request.setTaskendtimeto(inBean.getTaskendtimeto());

            WSGetTaskSummaryResponse response = client.execGetTaskSummary(request);

            GetTaskSummaryOutBean outBean = new GetTaskSummaryOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (null != response.getTaskSummaryMaps()) {
                List<TaskSummaryBean> summarys = new ArrayList<TaskSummaryBean>();

                for (Map<String, String> map : response.getTaskSummaryMaps()) {

                    TaskSummaryBean summary = new TaskSummaryBean();

                    summary.setFlowId(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_FLOW_ID));
                    summary.setFlowName(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_FLOW_NAME));
                    summary.setTaskName(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_TASK_ID));
                    summary.setTaskLocalName(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_TASK_NAME));
                    summary.setTaskCount(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_TASK_COUNT));

                    summarys.add(summary);
                }

                outBean.setTaskSummaryBeanList(summarys);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetTaskKensuuOutBean execGetTaskKensuu(GetTaskKensuuInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTaskKensuuInBean.class.getSimpleName());

            WSGetTaskKensuuRequest request = new WSGetTaskKensuuRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setWariateumu(inBean.getWariateumu());
            request.setTaskendumu(inBean.getTaskendumu());
            request.setFlowid(inBean.getFlowid());
            request.setTaskid(inBean.getTaskid());
            request.setTaskcreatetimefrom(inBean.getTaskcreatetimefrom());
            request.setTaskcreatetimeto(inBean.getTaskcreatetimeto());
            request.setTaskstarttimefrom(inBean.getTaskstarttimefrom());
            request.setTaskstarttimeto(inBean.getTaskstarttimeto());
            request.setTaskendtimefrom(inBean.getTaskendtimefrom());
            request.setTaskendtimeto(inBean.getTaskendtimeto());

            WSGetTaskKensuuResponse response = client.execGetTaskKensuu(request);

            GetTaskKensuuOutBean outBean = new GetTaskKensuuOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (null != response.getTaskSummaryMaps()) {
                List<TaskSummaryBean> summarys = new ArrayList<TaskSummaryBean>();

                for (Map<String, String> map : response.getTaskSummaryMaps()) {

                    TaskSummaryBean summary = new TaskSummaryBean();

                    summary.setFlowId(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_FLOW_ID));
                    summary.setFlowName(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_FLOW_NAME));
                    summary.setTaskName(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_TASK_ID));
                    summary.setTaskLocalName(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_TASK_NAME));
                    summary.setTaskCount(map.get(IWSGetTaskSummaryIOKey.MapKey.sS_TASK_COUNT));

                    summarys.add(summary);
                }

                outBean.setTaskSummaryBeanList(summarys);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetTaskSummaryByActorOutBean execGetTaskSummaryByActor(GetTaskSummaryByActorInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTaskSummaryByActorInBean.class.getSimpleName());

            WSGetTaskSummaryByActorRequest request = new WSGetTaskSummaryByActorRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setWariateumu(inBean.getWariateumu());
            request.setTaskendumu(inBean.getTaskendumu());
            request.setFlowid(inBean.getFlowid());
            request.setTaskid(inBean.getTaskid());
            request.setTaskcreatetimefrom(inBean.getTaskcreatetimefrom());
            request.setTaskcreatetimeto(inBean.getTaskcreatetimeto());
            request.setTaskstarttimefrom(inBean.getTaskstarttimefrom());
            request.setTaskstarttimeto(inBean.getTaskstarttimeto());
            request.setTaskendtimefrom(inBean.getTaskendtimefrom());
            request.setTaskendtimeto(inBean.getTaskendtimeto());

            WSGetTaskSummaryByActorResponse response = client.execGetTaskSummaryByActor(request);

            GetTaskSummaryByActorOutBean outBean = new GetTaskSummaryByActorOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (null != response.getTaskSummaryMaps()) {
                List<TaskSummaryByActorBean> summarys = new ArrayList<TaskSummaryByActorBean>();

                for (Map<String, String> map : response.getTaskSummaryMaps()) {

                    TaskSummaryByActorBean summary = new TaskSummaryByActorBean();

                    summary.setFlowId(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_FLOW_ID));
                    summary.setFlowName(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_FLOW_NAME));
                    summary.setTaskName(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_TASK_ID));
                    summary.setTaskLocalName(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_TASK_NAME));
                    summary.setUserId(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_USER_ID));
                    summary.setTaskCount(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_TASK_COUNT));

                    summarys.add(summary);
                }

                outBean.setTaskSummaryByActorBeanList(summarys);
            }

            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public GetTaskKensuuByActorOutBean execGetTaskKensuuByActor(GetTaskKensuuByActorInBean inBean) {

        try {
            IwfClientUtil.validateInBean(inBean, GetTaskKensuuByActorInBean.class.getSimpleName());

            WSGetTaskKensuuByActorRequest request = new WSGetTaskKensuuByActorRequest();
            IwfClientUtil.setCommonRequestParams(inBean, request);

            request.setAccountid(inBean.getAccountid());
            request.setWariateumu(inBean.getWariateumu());
            request.setTaskendumu(inBean.getTaskendumu());
            request.setFlowid(inBean.getFlowid());
            request.setTaskid(inBean.getTaskid());
            request.setTaskcreatetimefrom(inBean.getTaskcreatetimefrom());
            request.setTaskcreatetimeto(inBean.getTaskcreatetimeto());
            request.setTaskstarttimefrom(inBean.getTaskstarttimefrom());
            request.setTaskstarttimeto(inBean.getTaskstarttimeto());
            request.setTaskendtimefrom(inBean.getTaskendtimefrom());
            request.setTaskendtimeto(inBean.getTaskendtimeto());

            WSGetTaskKensuuByActorResponse response = client.execGetTaskKensuuByActor(request);

            GetTaskKensuuByActorOutBean outBean = new GetTaskKensuuByActorOutBean();
            IwfClientUtil.setCommonResponseParams(response, outBean);

            if (null != response.getTaskSummaryMaps()) {
                List<TaskSummaryByActorBean> summarys = new ArrayList<TaskSummaryByActorBean>();

                for (Map<String, String> map : response.getTaskSummaryMaps()) {

                    TaskSummaryByActorBean summary = new TaskSummaryByActorBean();

                    summary.setFlowId(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_FLOW_ID));
                    summary.setFlowName(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_FLOW_NAME));
                    summary.setTaskName(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_TASK_ID));
                    summary.setTaskLocalName(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_TASK_NAME));
                    summary.setUserId(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_USER_ID));
                    summary.setTaskCount(map.get(IWSGetTaskSummaryByActorIOKey.MapKey.sS_TASK_COUNT));

                    summarys.add(summary);
                }

                outBean.setTaskSummaryByActorBeanList(summarys);
            }
            return outBean;
        } catch(RuntimeException re){
            throw re;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

