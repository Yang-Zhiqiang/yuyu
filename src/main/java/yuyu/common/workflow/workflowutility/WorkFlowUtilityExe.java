package yuyu.common.workflow.workflowutility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.string.ConvertUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.lang.StringUtils;

import yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai.TantousyabetuSyoriTaskSyoukaiConstants;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.workflow.IwfAccountClient;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.account.DelImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.GetImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.UpdImageAuthorityInBean;
import yuyu.common.biz.workflow.io.image.CreateExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.CreateImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DeleteImageSpaceInBean;
import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeInBean;
import yuyu.common.biz.workflow.io.image.GetExpectedArrivalNoticeOutBean;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstInBean;
import yuyu.common.biz.workflow.io.image.PutArrivalImageInBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoInBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordAndSummaryByUserInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordAndSummaryByUserOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskKensuuOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateOutBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.sub.LockInfoBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordAndSummaryByUserBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.common.workflow.collection.WorkListFlowIdNodeNameSortComparator;
import yuyu.common.workflow.collection.WorkListJimuStartYmdSortComparator;
import yuyu.common.workflow.collection.WorkListJimutetuzukiCdTaskIdSortComparator;
import yuyu.common.workflow.collection.WorkflowCountOfTaskSummaryBeanSortFunction;
import yuyu.common.workflow.collection.WorkflowDMJimutetuzukiTaskRirekiSortComparator;
import yuyu.common.workflow.collection.WorkflowDMJimutetuzukiTaskRirekiSortFunction;
import yuyu.common.workflow.collection.WorkflowDMJimutetuzukiTaskSortFunction;
import yuyu.common.workflow.collection.WorkflowImagePropsBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowJimutetuzukiFilter;
import yuyu.common.workflow.collection.WorkflowLockInfoFilter;
import yuyu.common.workflow.collection.WorkflowLockedTaskBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowProcessHistoryBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTaskFilter;
import yuyu.common.workflow.collection.WorkflowTaskTantoInfoBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTaskTantoNmBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTasksForCancelBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTasksForHyousiBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTasksForKouteiStatusBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTasksForPutImageBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTasksForWorkListBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTorikomiSyoruiBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowTorikomiSyoruiMstSortBeanSortComparator;
import yuyu.common.workflow.collection.WorkflowWariateInfoFilter;
import yuyu.common.workflow.workflowutility.dba4workflowutility.WorkFlowUtilityDao;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.common.WSCommonIOKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.createExpectedArrivalNotice.WSCreateExpectedArrivalNoticeResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage.WSPutArrivalImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord.WSCreateProcessRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscancel.WSExecProcessCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocesscreate.WSExecProcessCreateResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel.WSExecTaskCancelResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess.WSLockProcessResponse;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_QrCodeTaikeiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHokenSyuruiNo;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * ワークフロー呼出ユーティリティクラス API使用です。<br/>
 * YuyuWorkflowConfigのデバッグモードがfalseの場合に呼び出されます。
 */
public class WorkFlowUtilityExe {

    public static GetLockedTaskListResultBean getLockedTasksInfoList(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd,
        String pUserId,
        List<Map<String, String>> pAdditionalParam) {

        GetLockedTaskListResultBean resultBean = new GetLockedTaskListResultBean();
        List<LockedTaskSummaryBean> beanList = new ArrayList<LockedTaskSummaryBean>();
        LockedTaskSummaryBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        List<LockedTaskSummaryBean> wkBeanList = new ArrayList<LockedTaskSummaryBean>();
        Map<String, String> taskNmMap = new HashMap<String, String>();

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
        WSExtParam wSExtParam;
        if (pJimutetuzukiCd != null &&
            pJimutetuzukiCd.length > 0) {
            getProcessSummaryInBean.setFlowids(pJimutetuzukiCd);
        }
        if (pMosNo != null &&
            pMosNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pMosNo);
            getProcessSummaryInBean.setExtParam14(wSExtParam);
        }
        if (pSyoNo != null &&
            pSyoNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pSyoNo);
            getProcessSummaryInBean.setExtParam12(wSExtParam);
        }
        if (pNkSysyNo != null &&
            pNkSysyNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pNkSysyNo);
            getProcessSummaryInBean.setExtParam13(wSExtParam);
        }
        GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient
            .execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
            return resultBean;
        }
        if (getProcessSummaryOutBean.getProcessSummaryBeanList() == null ||
            getProcessSummaryOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DM_Jimutetuzuki> jimuMst = workflowDomManager.getAllJimutetuzuki();

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimuMst != null) {
            for (DM_Jimutetuzuki tmpJimu : jimuMst) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        List<String> gyoumuKeys = new ArrayList<String>();
        for (ProcessSummaryBean processSummaryBean : getProcessSummaryOutBean.getProcessSummaryBeanList()) {
            gyoumuKeys.add(processSummaryBean.getGyoumukey());
        }
        String[] arrayGyoumuKeys = new String[gyoumuKeys.size()];
        for (int i = 0; i < gyoumuKeys.size(); i++) {
            arrayGyoumuKeys[i] = gyoumuKeys.get(i);
        }

        GetLockInfoInBean getLockInfoInBean = new GetLockInfoInBean();
        getLockInfoInBean.setGyoumukey(arrayGyoumuKeys);
        GetLockInfoOutBean getLockInfoOutBean = iwfKouteiClient.getLockInfo(getLockInfoInBean);
        if (!WorkFlowResultConstants.RESULT_OK.equals(getLockInfoOutBean.getKekkastatus())) {

            if (WorkFlowResultConstants.RESULT_WARN.equals(getLockInfoOutBean.getKekkastatus())
                && getLockInfoOutBean.getSyousaimsgcd().equals("IWF4030")) {

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);

            } else {
                resultBean.setSyorikekkaStatus(getLockInfoOutBean.getKekkastatus());
            }

            return resultBean;
        }

        List<ProcessSummaryBean> wkProcessList = getProcessSummaryOutBean.getProcessSummaryBeanList();
        WorkflowLockInfoFilter lockInfoFilter = new WorkflowLockInfoFilter();

        for (int idx = wkProcessList.size() - 1; idx >= 0; idx--) {
            ProcessSummaryBean processSummaryBean = wkProcessList.get(idx);
            lockInfoFilter.setTargetGyoumuKey(processSummaryBean.getGyoumukey());
            List<LockInfoBean> filteredList = ImmutableList.copyOf(Iterables.filter(
                getLockInfoOutBean.getLockInfoBeanList(), lockInfoFilter));
            if (filteredList == null ||
                filteredList.size() <= 0) {
                wkProcessList.remove(idx);
            }
            else {
                for (LockInfoBean lockInfoBean : getLockInfoOutBean.getLockInfoBeanList()) {
                    if (lockInfoBean.getGyoumukey().equals(processSummaryBean.getGyoumukey())) {

                        processSummaryBean.setCurrentAccountId(lockInfoBean.getAccountId());
                    }
                }
            }
        }

        if (wkProcessList.size() > 1000) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
            resultBean.setSyousaiMessageCd("IWF2160");
            return resultBean;
        } else if (wkProcessList.size() > 0) {
            for (ProcessSummaryBean processSummaryBean : wkProcessList) {
                bean = new LockedTaskSummaryBean();
                bean.setJimutetuzukiCd(processSummaryBean.getFlowId());
                bean.setMosNo(processSummaryBean.getExtparamBean().getExtparam14());
                bean.setSyoNo(processSummaryBean.getExtparamBean().getExtparam12());
                bean.setNkSysyNo(processSummaryBean.getExtparamBean().getExtparam13());
                bean.setKouteiKnrId(processSummaryBean.getGyoumukey());
                if (!Strings.isNullOrEmpty(processSummaryBean.getExtparamBean().getExtparam11())) {
                    try {
                        bean.setJimuStartYmd(BizDate.valueOf(sdf.parse(processSummaryBean.getExtparamBean()
                            .getExtparam11())));
                    } catch (Exception e) {
                        bean.setJimuStartYmd(null);
                    }
                }
                bean.setNowSyoriTantouId(processSummaryBean.getCurrentAccountId());
                bean.setNowTaskNm(processSummaryBean.getCurrentNodeName());

                if (!taskNmMap.containsKey(bean.getNowTaskNm())) {
                    WorkflowTaskFilter taskFilter = new WorkflowTaskFilter();
                    taskFilter.setTargetJimutetuzukiCd(bean.getJimutetuzukiCd());
                    taskFilter.setTargetTaskId(bean.getNowTaskNm());
                    List<DM_JimutetuzukiTask> filteredList = ImmutableList.copyOf(Iterables
                        .filter(taskList, taskFilter));
                    if (filteredList.size() > 0) {
                        taskNmMap.put(bean.getJimutetuzukiCd() + "." + bean.getNowTaskNm(), filteredList.get(0)
                            .getWorkflowTskNm());
                    } else {
                        taskNmMap.put(bean.getNowTaskNm(), null);
                    }
                }
                bean.setNowTaskLocalNm(taskNmMap.get(bean.getJimutetuzukiCd() + "." + bean.getNowTaskNm()));

                if (!Strings.isNullOrEmpty(bean.getNowSyoriTantouId())) {
                    if (accountNmMap.size() <= 0 ||
                        !accountNmMap.containsKey(bean.getNowSyoriTantouId())) {
                        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                        AM_User userInfo = baseDomManager.getUser(bean.getNowSyoriTantouId());
                        if (userInfo == null) {
                            accountNmMap.put(bean.getNowSyoriTantouId(), null);
                        } else {
                            accountNmMap.put(bean.getNowSyoriTantouId(), userInfo.getUserNm());
                        }
                    }
                    bean.setDispNowSyoriTantouNm(accountNmMap.get(bean.getNowSyoriTantouId()));
                }
                wkBeanList.add(bean);
            }
            Ordering<LockedTaskSummaryBean> ordering = Ordering.from(new WorkflowLockedTaskBeanSortComparator());
            beanList = ordering.sortedCopy(wkBeanList);

            resultBean.setLockedTaskSummaryBeanList(beanList);
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        } else {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        return resultBean;
    }

    public static UnlockProcessForceResultBean unlockProcessForce(String pKouteiKnrId, String pJimutetuzukiCd) {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoList = bizDomManager.
            getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(pKouteiKnrId, pJimutetuzukiCd);

        UnlockProcessForceResultBean resultBean = new UnlockProcessForceResultBean();

        WSForceUnlockProcessResponse forceUnlockProcessOutBean =
            SWAKInjector.getInstance(WSForceUnlockProcessResponse.class);

        for (BT_GyoumuKouteiInfo gyoumuKouteiInfo : gyoumuKouteiInfoList) {

            ForceUnlockProcessInBean forceUnlockProcessInBean = new ForceUnlockProcessInBean();
            forceUnlockProcessInBean.setGyoumukey(gyoumuKouteiInfo.getKouteikanriid());
            forceUnlockProcessInBean.setFlowid(gyoumuKouteiInfo.getJimutetuzukicd());

            IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

            forceUnlockProcessOutBean = iwfKouteiClient.execForceUnlockProcess(forceUnlockProcessInBean);

            resultBean.setSyorikekkaStatus(forceUnlockProcessOutBean.getKekkastatus());
            resultBean.setSyousaiMessageCd(forceUnlockProcessOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(forceUnlockProcessOutBean.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(forceUnlockProcessOutBean.getKekkastatus())) {

                if ("IWF2201".equals(forceUnlockProcessOutBean.getSyousaimsgcd()) ||
                    "IWF2202".equals(forceUnlockProcessOutBean.getSyousaimsgcd())) {

                    if (gyoumuKouteiInfo.getKouteikanriid().equals(gyoumuKouteiInfo.getSyukouteikanriid())) {

                        return resultBean;
                    }
                    else {

                    }
                }
                else {

                    return resultBean;
                }
            }
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        resultBean.setSyousaiMessageCd("IWF0000");

        return resultBean;
    }

    public static GetTaskTantoNmResultBean getTaskTantoNm(String[] pJimutetuzukiCd) {

        GetTaskTantoNmResultBean resultBean = new GetTaskTantoNmResultBean();
        List<TaskTantoNmBean> beanList = new ArrayList<TaskTantoNmBean>();
        TaskTantoNmBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();
        List<TaskTantoNmBean> wkBeanList = new ArrayList<>();

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
        if (pJimutetuzukiCd != null && pJimutetuzukiCd.length == 1) {
            getProcessSummaryInBean.setFlowid(pJimutetuzukiCd[0]);
        } else {
            getProcessSummaryInBean.setFlowids(pJimutetuzukiCd);
        }
        getProcessSummaryInBean.setAccountwariateumu(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI);
        GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient
            .execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
            return resultBean;
        }

        if (getProcessSummaryOutBean.getProcessSummaryBeanList() == null ||
            getProcessSummaryOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        for (ProcessSummaryBean processBean : getProcessSummaryOutBean.getProcessSummaryBeanList()) {
            if (!Strings.isNullOrEmpty(processBean.getCurrentAccountId()) &&
                (accountNmMap.size() == 0 || !accountNmMap.containsKey(processBean.getCurrentAccountId()))) {
                bean = SWAKInjector.getInstance(TaskTantoNmBean.class);
                bean.setTantId(processBean.getCurrentAccountId());

                BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                AM_User userInfo = baseDomManager.getUser(bean.getTantId());
                if (userInfo == null) {
                    accountNmMap.put(bean.getTantId(), null);
                } else {
                    accountNmMap.put(bean.getTantId(), userInfo.getUserNm());
                }

                bean.setDispTntNm(accountNmMap.get(bean.getTantId()));
                wkBeanList.add(bean);
            }
        }

        if (wkBeanList.size() > 0) {
            Ordering<TaskTantoNmBean> ordering = Ordering.from(new WorkflowTaskTantoNmBeanSortComparator());
            beanList = ordering.sortedCopy(wkBeanList);

            resultBean.setTaskTantoNmBeanList(beanList);
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        } else {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
        }

        return resultBean;
    }

    public static GetTaskTantoInfoListResultBean getTaskTantoInfoList(String pSubsystemId, String[] pJimutetuzukiCd,
        String pUserId, String pTaskNm) {
        GetTaskTantoInfoListResultBean resultBean = new GetTaskTantoInfoListResultBean();
        List<TaskTantoInfoBean> beanList = new ArrayList<TaskTantoInfoBean>();
        TaskTantoInfoBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();
        List<TaskTantoInfoBean> wkBeanList = new ArrayList<TaskTantoInfoBean>();
        Map<String, String> taskNmMap = new HashMap<String, String>();

        GetProcessSummaryInBean getProcessInBean = new GetProcessSummaryInBean();
        getProcessInBean.setAccountwariateumu(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI);
        getProcessInBean.setSyoristatus(new String[] { WorkFlowUtilityConstants.SYORI_STATUS_SYORITYU });
        getProcessInBean.setKekkajyougenkensu(WorkFlowUtilityConstants.KENSAKU_MAX);

        List<DM_Jimutetuzuki> jimutetuzukiLst = new ArrayList<>();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        if (pJimutetuzukiCd == null) {

            jimutetuzukiLst = workflowDomManager.getAllJimutetuzuki();
        }
        else if (BizUtil.isBlank(pTaskNm)) {

            jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(
                pSubsystemId,
                pJimutetuzukiCd);

            String[] jimutetuzukiCd = new String[jimutetuzukiLst.size()];

            for (int i = 0; i < jimutetuzukiLst.size(); i++) {

                jimutetuzukiCd[i] = jimutetuzukiLst.get(i).getJimutetuzukicd();
            }

            getProcessInBean.setFlowids(jimutetuzukiCd);
        }
        else {

            jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(
                pSubsystemId,
                pJimutetuzukiCd);

            getProcessInBean.setFlowids(pJimutetuzukiCd);
        }

        if (!Strings.isNullOrEmpty(pUserId)) {
            getProcessInBean.setAccountid(pUserId);
        }
        if (!Strings.isNullOrEmpty(pTaskNm)) {
            getProcessInBean.setNodename(pTaskNm);
        }
        GetProcessSummaryOutBean getProcessOutBean = iwfKouteiClient.execGetProcessSummary(getProcessInBean);
        resultBean.setSyousaiMessageCd(getProcessOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessOutBean.getKekkastatus());
            return resultBean;
        }

        if (getProcessOutBean.getProcessSummaryBeanList() == null ||
            getProcessOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimutetuzukiLst != null) {
            for (DM_Jimutetuzuki tmpJimu : jimutetuzukiLst) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        for (ProcessSummaryBean processBean : getProcessOutBean.getProcessSummaryBeanList()) {
            bean = new TaskTantoInfoBean();
            bean.setMosNo(processBean.getExtparamBean().getExtparam14());
            bean.setSyoNo(processBean.getExtparamBean().getExtparam12());
            bean.setNkSysyNo(processBean.getExtparamBean().getExtparam13());
            bean.setKouteiKnrId(processBean.getGyoumukey());
            if (!Strings.isNullOrEmpty(processBean.getExtparamBean().getExtparam11())) {
                bean.setJimuStartYmd(processBean.getExtparamBean().getExtparam11());
            }
            bean.setNowSyoriTantouId(processBean.getCurrentAccountId());
            bean.setNowTaskNm(processBean.getCurrentNodeName());
            bean.setJimutetuzukiCd(processBean.getFlowId());

            bean.setTaskNm(bean.getNowTaskNm());
            if (!taskNmMap.containsKey(processBean.getFlowId() + "." + bean.getNowTaskNm())) {
                WorkflowTaskFilter taskFilter = new WorkflowTaskFilter();
                taskFilter.setTargetJimutetuzukiCd(processBean.getFlowId());
                taskFilter.setTargetTaskId(bean.getNowTaskNm());
                List<DM_JimutetuzukiTask> filteredList = ImmutableList.copyOf(Iterables.filter(taskList, taskFilter));
                if (filteredList.size() > 0) {
                    taskNmMap.put(processBean.getFlowId() + "." + bean.getNowTaskNm(), filteredList.get(0)
                        .getWorkflowTskNm());
                } else {
                    taskNmMap.put(processBean.getFlowId() + "." + bean.getNowTaskNm(), null);
                }
            }
            bean.setNowTaskNm(taskNmMap.get(processBean.getFlowId() + "." + bean.getNowTaskNm()));

            if (!Strings.isNullOrEmpty(bean.getNowSyoriTantouId())) {
                if (accountNmMap.size() <= 0 ||
                    !accountNmMap.containsKey(bean.getNowSyoriTantouId())) {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(bean.getNowSyoriTantouId());
                    if (userInfo == null) {
                        accountNmMap.put(bean.getNowSyoriTantouId(), null);
                    } else {
                        accountNmMap.put(bean.getNowSyoriTantouId(), userInfo.getUserNm());
                    }
                }
                bean.setDispNowSyoriTantouNm(accountNmMap.get(bean.getNowSyoriTantouId()));
            }
            wkBeanList.add(bean);
        }

        Ordering<TaskTantoInfoBean> ordering = Ordering.from(new WorkflowTaskTantoInfoBeanSortComparator());
        beanList = ordering.sortedCopy(wkBeanList);
        resultBean.setTaskTantoInfoBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static WorkListUnassignTaskResultBean unassignTask(String pKouteiKnrId, String pJimutetuzukiCd,String pTaskNm,
        String pUserId, String pRirekiUserId) {

        WorkListUnassignTaskResultBean resultBean = new WorkListUnassignTaskResultBean();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        UniqueKeyGenerator uid = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        String lockKey = uid.generateUniqueKey();

        LockProcessInBean lockProcessInBean = new LockProcessInBean();
        lockProcessInBean.setGyoumukey(pKouteiKnrId);
        lockProcessInBean.setFlowid(pJimutetuzukiCd);
        lockProcessInBean.setLockkey(lockKey);

        WSLockProcessResponse lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(lockProcessOutBean.getKekkastatus())) {

            if ("IWF2091".equals(lockProcessOutBean.getSyousaimsgcd())) {

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);
                resultBean.setSyousaiMessageCd(lockProcessOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(lockProcessOutBean.getSyousaimsg());
                resultBean.setErrorApiName("LockProcess");
            }
            else
                if ("IWF2092".equals(lockProcessOutBean.getSyousaimsgcd())) {

                    resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                    resultBean.setSyousaiMessageCd(lockProcessOutBean.getSyousaimsgcd());
                    resultBean.setSyousaiMessage(lockProcessOutBean.getSyousaimsg());
                    resultBean.setErrorApiName("LockProcess");
                }
                else {

                    resultBean.setSyorikekkaStatus(lockProcessOutBean.getKekkastatus());
                    resultBean.setSyousaiMessageCd(lockProcessOutBean.getSyousaimsgcd());
                    resultBean.setSyousaiMessage(lockProcessOutBean.getSyousaimsg());
                    resultBean.setErrorApiName("LockProcess");
                }

            return resultBean;
        }

        resultBean.setLockProcessInBean(lockProcessInBean);

        GetProcessSummaryInBean getProcessInBean = new GetProcessSummaryInBean();
        getProcessInBean.setGyoumukey(pKouteiKnrId);
        GetProcessSummaryOutBean getProcessOutBean = iwfKouteiClient.execGetProcessSummary(getProcessInBean);
        resultBean.setSyousaiMessageCd(getProcessOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessOutBean.getSyousaimsg());

        boolean haitaErrorFlg = false;

        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessOutBean.getKekkastatus());
            resultBean.setErrorApiName("GetProcessSummary");
            return resultBean;
        }

        if(!pTaskNm.equals(getProcessOutBean.getProcessSummaryBeanList().get(0).getCurrentNodeName())){
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            haitaErrorFlg=true;
        }

        if (BizUtil.isBlank(getProcessOutBean.getProcessSummaryBeanList().get(0).getCurrentAccountId())) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            haitaErrorFlg=true;
        }

        if(!pUserId.equals(getProcessOutBean.getProcessSummaryBeanList().get(0).getCurrentAccountId())){
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            haitaErrorFlg=true;
        }

        if(!haitaErrorFlg){
            UnassignTaskInBean unassignTaskInBean = new UnassignTaskInBean();
            unassignTaskInBean.setGyoumukey(pKouteiKnrId);
            unassignTaskInBean.setFlowid(pJimutetuzukiCd);
            unassignTaskInBean.setAccountid(pUserId);
            unassignTaskInBean.setRirekiaccountid(pRirekiUserId);
            unassignTaskInBean.setLockkey(lockKey);

            WSExecTaskCancelResponse unassignTaskOutBean = iwfKouteiClient.execUnsignTask(unassignTaskInBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(unassignTaskOutBean.getKekkastatus())) {

                resultBean.setSyorikekkaStatus(unassignTaskOutBean.getKekkastatus());
                resultBean.setSyousaiMessageCd(unassignTaskOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(unassignTaskOutBean.getSyousaimsg());
                resultBean.setErrorApiName("UnassignTask");
            }
        }

        if(haitaErrorFlg){
            return resultBean;
        }

        if (Strings.isNullOrEmpty(resultBean.getErrorApiName())) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        }

        return resultBean;
    }

    public static GetTasksForCancelResultBean getTasksForCancel(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd) {

        GetTasksForCancelResultBean resultBean = new GetTasksForCancelResultBean();
        List<TaskForCancelBean> beanList = new ArrayList<TaskForCancelBean>();
        TaskForCancelBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();
        Map<String, String> jimutetuzukiNmMap = new HashMap<String, String>();
        List<TaskForCancelBean> wkBeanList = new ArrayList<TaskForCancelBean>();

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
        WSExtParam wSExtParam;

        if (!Strings.isNullOrEmpty(pMosNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pMosNo);
            getProcessSummaryInBean.setExtParam14(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pSyoNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pSyoNo);
            getProcessSummaryInBean.setExtParam12(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pNkSysyNo);
            getProcessSummaryInBean.setExtParam13(wSExtParam);
        }

        List<DM_Jimutetuzuki> jimutetuzukiLst = new ArrayList<>();
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        if (BizUtil.isBlank(pJimutetuzukiCd)) {

            jimutetuzukiLst = workflowDomManager.getAllJimutetuzuki();
        }
        else {

            jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(
                pSubsystemId,
                new String[] { pJimutetuzukiCd });

            String[] jimutetuzukiCd = new String[jimutetuzukiLst.size()];
            for (int i = 0; i < jimutetuzukiLst.size(); i++) {
                jimutetuzukiCd[i] = jimutetuzukiLst.get(i).getJimutetuzukicd();
            }

            getProcessSummaryInBean.setFlowids(jimutetuzukiCd);
        }

        getProcessSummaryInBean.setSyoristatus(new String[] { WorkFlowUtilityConstants.SYORI_STATUS_SYORITYU });

        GetProcessSummaryOutBean getProcessOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(getProcessOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessOutBean.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessOutBean.getKekkastatus());
            return resultBean;
        }
        if (getProcessOutBean.getProcessSummaryBeanList() == null ||
            getProcessOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        for (ProcessSummaryBean processBean : getProcessOutBean.getProcessSummaryBeanList()) {
            if (!Strings.isNullOrEmpty(processBean.getExtparamBean().getExtparam11())) {
                continue;
            }

            bean = new TaskForCancelBean();
            bean.setJimutetuzukiCd(processBean.getFlowId());
            bean.setMosNo(processBean.getExtparamBean().getExtparam14());
            bean.setSyoNo(processBean.getExtparamBean().getExtparam12());
            bean.setNkSysyNo(processBean.getExtparamBean().getExtparam13());
            bean.setKouteiKnrId(processBean.getGyoumukey());
            bean.setJimuStartYmd(null);
            if (!Strings.isNullOrEmpty(processBean.getKouteiKaisiYmd())) {
                bean.setKouteiKaisiYmd(processBean.getKouteiKaisiYmd());
            }
            bean.setKouteiStatus(processBean.getProcessstatus());
            bean.setDispKouteiStatus(C_Kouteikanristatus.getContentByValue(processBean.getProcessstatus()));
            bean.setTantouId(processBean.getFirstAccountId());
            bean.setDispTantouNm(null);

            if (!jimutetuzukiNmMap.containsKey(bean.getJimutetuzukiCd())) {
                WorkflowJimutetuzukiFilter jimutetuzukiFilter = new WorkflowJimutetuzukiFilter();
                jimutetuzukiFilter.setTargetJimutetuzukiCd(bean.getJimutetuzukiCd());
                List<DM_Jimutetuzuki> filteredList = ImmutableList
                    .copyOf(Iterables.filter(jimutetuzukiLst, jimutetuzukiFilter));
                if (filteredList.size() > 0) {
                    jimutetuzukiNmMap.put(bean.getJimutetuzukiCd(), filteredList.get(0).getJimutetuzukinm());
                } else {
                    jimutetuzukiNmMap.put(bean.getJimutetuzukiCd(), null);
                }
            }
            bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));

            if (!Strings.isNullOrEmpty(bean.getTantouId())) {
                if (accountNmMap.size() <= 0 ||
                    !accountNmMap.containsKey(bean.getTantouId())) {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(bean.getTantouId());
                    if (userInfo == null) {
                        accountNmMap.put(bean.getTantouId(), null);
                    } else {
                        accountNmMap.put(bean.getTantouId(), userInfo.getUserNm());
                    }
                }
                bean.setDispTantouNm(accountNmMap.get(bean.getTantouId()));
            }
            wkBeanList.add(bean);
        }

        if (wkBeanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        Ordering<TaskForCancelBean> ordering = Ordering.from(new WorkflowTasksForCancelBeanSortComparator());
        beanList = ordering.sortedCopy(wkBeanList);

        resultBean.setTaskForCancelBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetTasksForPutImageResultBean getTasksForPutImage(
        String pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pSyoriStatus,
        String pJimuyouCd,
        String pWariateSousasyaId,
        String pIsWariate,
        String pSousasyaId) {

        GetTasksForPutImageResultBean resultBean = new GetTasksForPutImageResultBean();
        List<TaskSummaryForPutImageBean> taskSummaryBeanList = new ArrayList<TaskSummaryForPutImageBean>();
        TaskSummaryForPutImageBean taskSummaryBean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        List<TaskSummaryForPutImageBean> wkBeanList = new ArrayList<TaskSummaryForPutImageBean>();
        Map<String, String> taskNmMap = new HashMap<String, String>();

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
        WSExtParam wSExtParam;

        getProcessSummaryInBean.setKekkajyougenkensu(WorkFlowUtilityConstants.KENSAKU_MAX);
        if (!Strings.isNullOrEmpty(pJimutetuzukiCd)) {
            getProcessSummaryInBean.setFlowid(pJimutetuzukiCd);
        }
        if (!Strings.isNullOrEmpty(pMosNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pMosNo);
            getProcessSummaryInBean.setExtParam14(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pSyoNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pSyoNo);
            getProcessSummaryInBean.setExtParam12(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pNkSysyNo);
            getProcessSummaryInBean.setExtParam13(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pJimuKaisiYmdFrom) || !Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
            wSExtParam = new WSExtParam();

            if (Strings.isNullOrEmpty(pJimuKaisiYmdFrom)) {
                wSExtParam.setValueFrom("19700101000000000");
                try {
                    wSExtParam.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    wSExtParam.setValueTo(pJimuKaisiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
                try {
                    wSExtParam.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                } catch (Exception e) {
                    wSExtParam.setValueFrom(pJimuKaisiYmdFrom);
                }
                wSExtParam.setValueTo("99991231235959999");
            } else {
                try {
                    wSExtParam.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                    wSExtParam.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    wSExtParam.setValueFrom(pJimuKaisiYmdFrom);
                    wSExtParam.setValueTo(pJimuKaisiYmdTo);
                }
            }
            getProcessSummaryInBean.setExtParam11(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pSyoriStatus)) {
            getProcessSummaryInBean.setSyoristatus(new String[] { pSyoriStatus });
        }
        if (!Strings.isNullOrEmpty(pJimuyouCd)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pJimuyouCd);
            getProcessSummaryInBean.setExtParam7(wSExtParam);
        }

        GetProcessSummaryOutBean getProcessOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(getProcessOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessOutBean.getKekkastatus());
            return resultBean;
        }
        if (getProcessOutBean.getProcessSummaryBeanList() == null ||
            getProcessOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DM_Jimutetuzuki> jimuMst = workflowDomManager.getAllJimutetuzuki();

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimuMst != null) {
            for (DM_Jimutetuzuki tmpJimu : jimuMst) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        for (ProcessSummaryBean wkBean : getProcessOutBean.getProcessSummaryBeanList()) {
            taskSummaryBean = new TaskSummaryForPutImageBean();
            taskSummaryBean.setMosNo(wkBean.getExtparamBean().getExtparam14());
            taskSummaryBean.setSyoNo(wkBean.getExtparamBean().getExtparam12());
            taskSummaryBean.setNkSysyNo(wkBean.getExtparamBean().getExtparam13());
            taskSummaryBean.setKouteiKnrId(wkBean.getGyoumukey());
            if (!Strings.isNullOrEmpty(wkBean.getExtparamBean().getExtparam11())) {
                try {
                    taskSummaryBean.setJimuStartYmd(BizDate.valueOf(sdf17.parse(wkBean.getExtparamBean()
                        .getExtparam11())));
                } catch (Exception e) {
                }
            }
            if (!Strings.isNullOrEmpty(wkBean.getKouteiKaisiYmd())) {
                try {
                    taskSummaryBean.setKouteiKaisiYmd(BizDate.valueOf(sdf8.parse(wkBean.getKouteiKaisiYmd())));
                } catch (Exception e) {
                }
            }
            if (!Strings.isNullOrEmpty(wkBean.getKouteikanryouYmd())) {
                try {
                    taskSummaryBean.setKouteiKanryouYmd(BizDate.valueOf(sdf8.parse(wkBean.getKouteikanryouYmd())));
                } catch (Exception e) {
                }
            }
            taskSummaryBean.setKouteiStatus(wkBean.getProcessstatus());
            taskSummaryBean.setDispKouteiStatus(C_Kouteikanristatus.getContentByValue(wkBean.getProcessstatus()));
            taskSummaryBean.setLastUpdateTime(wkBean.getUpdateTime());
            taskSummaryBean.setNowSyoriTantouId(wkBean.getCurrentAccountId());
            taskSummaryBean.setNowTaskNm(wkBean.getCurrentNodeName());
            taskSummaryBean.setJimuyouCd(wkBean.getExtparamBean().getExtparam7());

            if (!taskNmMap.containsKey(wkBean.getFlowId() + "." + taskSummaryBean.getNowTaskNm())) {
                WorkflowTaskFilter taskFilter = new WorkflowTaskFilter();
                taskFilter.setTargetJimutetuzukiCd(wkBean.getFlowId());
                taskFilter.setTargetTaskId(taskSummaryBean.getNowTaskNm());
                List<DM_JimutetuzukiTask> filteredList = ImmutableList.copyOf(Iterables.filter(taskList, taskFilter));
                if (filteredList.size() > 0) {
                    taskNmMap.put(wkBean.getFlowId() + "." + taskSummaryBean.getNowTaskNm(), filteredList.get(0)
                        .getWorkflowTskNm());
                } else {
                    taskNmMap.put(wkBean.getFlowId() + "." + taskSummaryBean.getNowTaskNm(), null);
                }
            }
            taskSummaryBean.setNowTaskLocalNm(taskNmMap.get(wkBean.getFlowId() + "." + taskSummaryBean.getNowTaskNm()));

            if (!Strings.isNullOrEmpty(taskSummaryBean.getNowSyoriTantouId())) {
                if (accountNmMap.size() <= 0 ||
                    !accountNmMap.containsKey(taskSummaryBean.getNowSyoriTantouId())) {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(taskSummaryBean.getNowSyoriTantouId());
                    if (userInfo == null) {
                        accountNmMap.put(taskSummaryBean.getNowSyoriTantouId(), null);
                    } else {
                        accountNmMap.put(taskSummaryBean.getNowSyoriTantouId(), userInfo.getUserNm());
                    }
                }
                taskSummaryBean.setDispNowSyoriTantouNm(accountNmMap.get(taskSummaryBean.getNowSyoriTantouId()));
            }
            wkBeanList.add(taskSummaryBean);
        }

        Ordering<TaskSummaryForPutImageBean> ordering = Ordering.from(new WorkflowTasksForPutImageBeanSortComparator());
        taskSummaryBeanList = ordering.sortedCopy(wkBeanList);

        resultBean.setTaskSummaryBeanList(taskSummaryBeanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetTasksForHyousiResultBean getTasksForHyousi(
        String pSubsystemId,
        String pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pUserId) {

        GetTasksForHyousiResultBean resultBean = new GetTasksForHyousiResultBean();
        List<TaskSummaryForHyousiBean> beanList = new ArrayList<TaskSummaryForHyousiBean>();
        TaskSummaryForHyousiBean bean;
        Map<String, String> flowNmMap = new HashMap<String, String>();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        WSExtParam wSExtParam;

        List<TaskSummaryForHyousiBean> wkBeanList = new ArrayList<TaskSummaryForHyousiBean>();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(
            pSubsystemId,
            new String[] { pJimutetuzukiCd });

        String[] jimutetuzukiCd = new String[jimutetuzukiLst.size()];

        for (int i = 0; i < jimutetuzukiLst.size(); i++) {

            jimutetuzukiCd[i] = jimutetuzukiLst.get(i).getJimutetuzukicd();

            flowNmMap.put(jimutetuzukiLst.get(i).getJimutetuzukicd(), jimutetuzukiLst.get(i).getJimutetuzukinm());
        }

        inBean.setFlowids(jimutetuzukiCd);

        if (!Strings.isNullOrEmpty(pMosNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pMosNo);
            inBean.setExtParam14(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pSyoNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pSyoNo);
            inBean.setExtParam12(wSExtParam);
        }
        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pNkSysyNo);
            inBean.setExtParam13(wSExtParam);
        }

        GetTorikomiSyoruiMstResultBean getTorikomiSyoruiMstResultBean = getTorikomiSyoruiMst(jimutetuzukiCd);

        if (!WorkFlowResultConstants.RESULT_OK.equals(getTorikomiSyoruiMstResultBean.getSyorikekkaStatus())) {

            resultBean.setSyorikekkaStatus(getTorikomiSyoruiMstResultBean.getSyorikekkaStatus());
            return resultBean;
        }
        else if (getTorikomiSyoruiMstResultBean.getTorikomiSyoruiMstBeanList().size() == 0) {

            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<TorikomiSyoruiMstBean> torikomiSyoruiMstBeanLst = getTorikomiSyoruiMstResultBean
            .getTorikomiSyoruiMstBeanList();

        inBean.setSyoristatus(new String[] { C_Kouteikanristatus.SYORITYUU.toString(),
            C_Kouteikanristatus.KANRYOU.toString() });
        GetProcessSummaryOutBean outBean = iwfKouteiClient.execGetProcessSummary(inBean);
        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
            return resultBean;
        }

        if (outBean.getProcessSummaryBeanList() == null ||
            outBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<ProcessSummaryBean> psBeanLst = outBean.getProcessSummaryBeanList();

        for (ProcessSummaryBean summaryBean : psBeanLst) {

            for (TorikomiSyoruiMstBean torikomiSyoruiMstBean : torikomiSyoruiMstBeanLst) {

                if (torikomiSyoruiMstBean.getJimutetuzukiCd().equals(summaryBean.getFlowId()) &&
                    C_SyoruiTorikomiHouKbn.SCAN_QR.eq(torikomiSyoruiMstBean.getSyoruitorikomihoukbn())) {

                    bean = new TaskSummaryForHyousiBean();
                    bean.setMosNo(summaryBean.getExtparamBean().getExtparam14());
                    bean.setSyoNo(summaryBean.getExtparamBean().getExtparam12());
                    bean.setNkSysyNo(summaryBean.getExtparamBean().getExtparam13());
                    bean.setKouteiKnrId(summaryBean.getGyoumukey());
                    if (!Strings.isNullOrEmpty(summaryBean.getExtparamBean().getExtparam11())) {
                        bean.setJimuStartYmd(summaryBean.getExtparamBean().getExtparam11());
                    }
                    if (!Strings.isNullOrEmpty(summaryBean.getKouteiKaisiYmd())) {
                        bean.setKouteiKaisiYmd(summaryBean.getKouteiKaisiYmd());
                    }
                    if (!Strings.isNullOrEmpty(summaryBean.getKouteikanryouYmd())) {
                        bean.setKouteiKanryouYmd(summaryBean.getKouteikanryouYmd());
                    }
                    bean.setKouteiStatus(summaryBean.getProcessstatus());
                    bean.setDispKouteiStatus(C_Kouteikanristatus.getContentByValue(summaryBean.getProcessstatus()));
                    bean.setJimutetuzukiCd(summaryBean.getFlowId());
                    bean.setJimutetuzukiNm(flowNmMap.get(bean.getJimutetuzukiCd()));

                    beanList.add(bean);

                    break;
                }
            }
        }

        if (beanList.size() == 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        Ordering<TaskSummaryForHyousiBean> ordering = Ordering.from(new WorkflowTasksForHyousiBeanSortComparator());
        wkBeanList = ordering.sortedCopy(beanList);

        resultBean.setTaskSummaryForHyousiBeanList(wkBeanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetTasksForKouteiStatusResultBean getTasksForKouteiStatus(
        String pSubsystemId,
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pKouteiKanryouYmdFrom,
        String pKouteiKanryouYmdTo,
        String pLastUpdateYmdFrom,
        String pLastUpdateYmdTo,
        String[] pSyoriStatus,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pUserId,
        String pTaskNm,
        boolean pSubflowincludeCheckBox) {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        GetTasksForKouteiStatusResultBean resultBean = new GetTasksForKouteiStatusResultBean();
        List<TaskSummaryForKouteiStatusBean> beanList = new ArrayList<TaskSummaryForKouteiStatusBean>();
        List<TaskSummaryForKouteiStatusBean> wkBeanList = new ArrayList<TaskSummaryForKouteiStatusBean>();
        TaskSummaryForKouteiStatusBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();
        Map<String, String> jimutetuzukiNmMap = new HashMap<String, String>();
        Map<String, String> taskNmMap = new HashMap<String, String>();
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
        WSExtParam wSExtParam;

        getProcessSummaryInBean.setKekkajyougenkensu(WorkFlowUtilityConstants.KENSAKU_MAX);

        if (pMosNo != null && pMosNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pMosNo);
            getProcessSummaryInBean.setExtParam14(wSExtParam);
        }
        if (pSyoNo != null && pSyoNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pSyoNo);
            getProcessSummaryInBean.setExtParam12(wSExtParam);
        }
        if (pNkSysyNo != null && pNkSysyNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pNkSysyNo);
            getProcessSummaryInBean.setExtParam13(wSExtParam);
        }

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DM_Jimutetuzuki> jimutetuzukiLst = new ArrayList<>();

        if (pJimutetuzukiCd == null) {

            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
            return resultBean;

        }
        jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(
            pSubsystemId,
            pJimutetuzukiCd);

        if (!Strings.isNullOrEmpty(pTaskNm)) {

            getProcessSummaryInBean.setFlowids(pJimutetuzukiCd);
            getProcessSummaryInBean.setNodename(pTaskNm);

        } else {

            if (pSubflowincludeCheckBox) {

                String[] jimutetuzukiCd = new String[jimutetuzukiLst.size()];

                for (int i = 0; i < jimutetuzukiLst.size(); i++) {

                    jimutetuzukiCd[i] = jimutetuzukiLst.get(i).getJimutetuzukicd();
                }
                getProcessSummaryInBean.setFlowids(jimutetuzukiCd);

            } else {
                getProcessSummaryInBean.setFlowids(pJimutetuzukiCd);
            }
        }

        if (!Strings.isNullOrEmpty(pJimuKaisiYmdFrom) || !Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
            wSExtParam = new WSExtParam();

            if (Strings.isNullOrEmpty(pJimuKaisiYmdFrom)) {
                wSExtParam.setValueFrom("19700101000000000");
                try {
                    wSExtParam.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    wSExtParam.setValueTo(pJimuKaisiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
                try {
                    wSExtParam.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                } catch (Exception e) {
                    wSExtParam.setValueFrom(pJimuKaisiYmdFrom);
                }
                wSExtParam.setValueTo("99991231235959999");
            } else {
                try {
                    wSExtParam.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                    wSExtParam.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    wSExtParam.setValueFrom(pJimuKaisiYmdFrom);
                    wSExtParam.setValueTo(pJimuKaisiYmdTo);
                }
            }
            getProcessSummaryInBean.setExtParam11(wSExtParam);
        }

        if (!Strings.isNullOrEmpty(pKouteiKanryouYmdFrom) || !Strings.isNullOrEmpty(pKouteiKanryouYmdTo)) {

            if (Strings.isNullOrEmpty(pKouteiKanryouYmdFrom)) {
                getProcessSummaryInBean.setKouteikanryoubifrom("19700101");
                try {
                    getProcessSummaryInBean.setKouteikanryoubito(sdf8.format(sdf8.parse(pKouteiKanryouYmdTo)));
                } catch (Exception e) {
                    getProcessSummaryInBean.setKouteikanryoubito(pKouteiKanryouYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pKouteiKanryouYmdTo)) {
                try {
                    getProcessSummaryInBean.setKouteikanryoubifrom(sdf8.format(sdf8.parse(pKouteiKanryouYmdFrom)));
                } catch (Exception e) {
                    getProcessSummaryInBean.setKouteikanryoubifrom(pKouteiKanryouYmdFrom);
                }
                getProcessSummaryInBean.setKouteikanryoubito("99991231");
            } else {
                try {
                    getProcessSummaryInBean.setKouteikanryoubifrom(sdf8.format(sdf8.parse(pKouteiKanryouYmdFrom)));
                    getProcessSummaryInBean.setKouteikanryoubito(sdf8.format(sdf8.parse(pKouteiKanryouYmdTo)));
                } catch (Exception e) {
                    getProcessSummaryInBean.setKouteikanryoubifrom(pKouteiKanryouYmdFrom);
                    getProcessSummaryInBean.setKouteikanryoubito(pKouteiKanryouYmdTo);
                }
            }
        }

        if (!Strings.isNullOrEmpty(pLastUpdateYmdFrom) || !Strings.isNullOrEmpty(pLastUpdateYmdTo)) {

            if (Strings.isNullOrEmpty(pLastUpdateYmdFrom)) {
                getProcessSummaryInBean.setLastsyoritimefrom("19700101000000000");
                try {
                    getProcessSummaryInBean.setLastsyoritimeto(pLastUpdateYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    getProcessSummaryInBean.setLastsyoritimeto(pLastUpdateYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pLastUpdateYmdTo)) {
                try {
                    getProcessSummaryInBean.setLastsyoritimefrom(sdf17.format(sdf8.parse(pLastUpdateYmdFrom)));
                } catch (Exception e) {
                    getProcessSummaryInBean.setLastsyoritimefrom(pLastUpdateYmdFrom);
                }
                getProcessSummaryInBean.setLastsyoritimeto("99991231235959999");
            } else {
                try {
                    getProcessSummaryInBean.setLastsyoritimefrom(sdf17.format(sdf8.parse(pLastUpdateYmdFrom)));
                    getProcessSummaryInBean.setLastsyoritimeto(pLastUpdateYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    getProcessSummaryInBean.setLastsyoritimefrom(pLastUpdateYmdFrom);
                    getProcessSummaryInBean.setLastsyoritimeto(pLastUpdateYmdTo);
                }
            }
        }

        if (pSyoriStatus != null && pSyoriStatus.length > 0) {
            getProcessSummaryInBean.setSyoristatus(pSyoriStatus);
        }
        if (!Strings.isNullOrEmpty(pJimuyouCd)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pJimuyouCd);
            getProcessSummaryInBean.setExtParam7(wSExtParam);
        }
        if (WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_ARI.equals(pJimuyouCdUmu)) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_CONVERT_ARI);
            getProcessSummaryInBean.setExtParam8(wSExtParam);
        }

        GetProcessSummaryOutBean outBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
            return resultBean;
        }
        if (outBean.getProcessSummaryBeanList() == null ||
            outBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = new ArrayList<>();

        for (int i = 0; i < jimutetuzukiLst.size(); i++) {

            jimutetuzukiTaskLst.addAll(jimutetuzukiLst.get(i).getJimutetuzukiTasks());
        }

        for (ProcessSummaryBean summaryBean : outBean.getProcessSummaryBeanList()) {
            bean = new TaskSummaryForKouteiStatusBean();
            bean.setJimutetuzukiCd(summaryBean.getFlowId());
            bean.setMosNo(summaryBean.getExtparamBean().getExtparam14());
            bean.setSyoNo(summaryBean.getExtparamBean().getExtparam12());
            bean.setNkSysyNo(summaryBean.getExtparamBean().getExtparam13());
            bean.setKouteiKnrId(summaryBean.getGyoumukey());
            if (!Strings.isNullOrEmpty(summaryBean.getExtparamBean().getExtparam11())) {
                bean.setJimuStartYmd(summaryBean.getExtparamBean().getExtparam11());
            }
            if (!Strings.isNullOrEmpty(summaryBean.getKouteiKaisiYmd())) {
                bean.setKouteiKaisiYmd(summaryBean.getKouteiKaisiYmd());
            }
            if (!Strings.isNullOrEmpty(summaryBean.getKouteikanryouYmd())) {
                bean.setKouteiKanryouYmd(summaryBean.getKouteikanryouYmd());
            }
            bean.setKouteiStatus(summaryBean.getProcessstatus());
            bean.setDispKouteiStatus(C_Kouteikanristatus.getContentByValue(summaryBean.getProcessstatus()));
            bean.setLastUpdateTime(summaryBean.getUpdateTime());
            bean.setNowSyoriTantouId(summaryBean.getCurrentAccountId());
            bean.setNowTaskNm(summaryBean.getCurrentNodeName());
            bean.setNowTaskLocalNm(summaryBean.getCurrentNodeLocalname());

            if (!jimutetuzukiNmMap.containsKey(bean.getJimutetuzukiCd())) {
                WorkflowJimutetuzukiFilter jimutetuzukiFilter = new WorkflowJimutetuzukiFilter();
                jimutetuzukiFilter.setTargetJimutetuzukiCd(bean.getJimutetuzukiCd());
                List<DM_Jimutetuzuki> filteredList = ImmutableList
                    .copyOf(Iterables.filter(jimutetuzukiLst, jimutetuzukiFilter));
                if (filteredList.size() > 0) {
                    jimutetuzukiNmMap.put(bean.getJimutetuzukiCd(), filteredList.get(0).getJimutetuzukinm());
                } else {
                    jimutetuzukiNmMap.put(bean.getJimutetuzukiCd(), null);
                }
            }
            bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));

            if (!taskNmMap.containsKey(bean.getNowTaskNm())) {
                WorkflowTaskFilter taskFilter = new WorkflowTaskFilter();
                taskFilter.setTargetJimutetuzukiCd(bean.getJimutetuzukiCd());
                taskFilter.setTargetTaskId(bean.getNowTaskNm());
                List<DM_JimutetuzukiTask> filteredList = ImmutableList.copyOf(Iterables.filter(jimutetuzukiTaskLst,
                    taskFilter));
                if (filteredList.size() > 0) {
                    taskNmMap.put(bean.getJimutetuzukiCd() + "." + bean.getNowTaskNm(), filteredList.get(0)
                        .getWorkflowTskNm());
                } else {
                    taskNmMap.put(bean.getNowTaskNm(), null);
                }
            }
            bean.setNowTaskLocalNm(taskNmMap.get(bean.getJimutetuzukiCd() + "." + bean.getNowTaskNm()));

            if (!Strings.isNullOrEmpty(bean.getNowSyoriTantouId())) {
                if (accountNmMap.size() <= 0 ||
                    !accountNmMap.containsKey(bean.getNowSyoriTantouId())) {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(bean.getNowSyoriTantouId());
                    if (userInfo == null) {
                        accountNmMap.put(bean.getNowSyoriTantouId(), null);
                    } else {
                        accountNmMap.put(bean.getNowSyoriTantouId(), userInfo.getUserNm());
                    }
                }
                bean.setDispNowSyoriTantouNm(accountNmMap.get(bean.getNowSyoriTantouId()));
            }

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(bean.getKouteiKnrId());

            bean.setSyuKouteiKnrId(gyoumuKouteiInfo.getSyukouteikanriid());

            wkBeanList.add(bean);
        }

        Ordering<TaskSummaryForKouteiStatusBean> ordering = Ordering
            .from(new WorkflowTasksForKouteiStatusBeanSortComparator());
        beanList = ordering.sortedCopy(wkBeanList);

        resultBean.setTaskSummaryForKouteiStatusBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetTasksForQrSealResultBean getTasksForQrSeal(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo) {
        GetTasksForQrSealResultBean resultBean = new GetTasksForQrSealResultBean();
        List<TaskSummaryForQrSealBean> beanList = new ArrayList<TaskSummaryForQrSealBean>();
        TaskSummaryForQrSealBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();
        WSExtParam wSExtParam;

        if (pMosNo != null && pMosNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pMosNo);
            getProcessSummaryInBean.setExtParam14(wSExtParam);
        }
        if (pSyoNo != null && pSyoNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pSyoNo);
            getProcessSummaryInBean.setExtParam12(wSExtParam);
        }
        if (pNkSysyNo != null && pNkSysyNo.length > 0) {
            wSExtParam = new WSExtParam();
            wSExtParam.setValues(pNkSysyNo);
            getProcessSummaryInBean.setExtParam13(wSExtParam);
        }
        GetProcessSummaryOutBean outBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
            return resultBean;
        }
        if (outBean.getProcessSummaryBeanList() == null ||
            outBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        for (ProcessSummaryBean summaryBean : outBean.getProcessSummaryBeanList()) {
            bean = new TaskSummaryForQrSealBean();
            bean.setMosNo(summaryBean.getExtparamBean().getExtparam14());
            bean.setSyoNo(summaryBean.getExtparamBean().getExtparam12());
            bean.setNkSysyNo(summaryBean.getExtparamBean().getExtparam13());
            bean.setKouteiKnrId(summaryBean.getGyoumukey());
            beanList.add(bean);
        }
        resultBean.setTaskSummaryForQrSealBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetExecutableTasksForWorkListSkResultBean getExecutableTasksForWorkListSk(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pMousikomiYmdFrom,
        String pMousikomiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pTaskNm,
        String[] pSkeijimukbn,
        String[] pMousikomiHou,
        String[] pHknsyuruino,
        String[] pDairiten,
        String pChildDairitenUmu,
        String pDoujiMousikomi) {

        GetExecutableTasksForWorkListSkResultBean resultBean = new GetExecutableTasksForWorkListSkResultBean();
        List<ExecutableTaskInfoBean> beanList = new ArrayList<ExecutableTaskInfoBean>();
        ExecutableTaskInfoBean bean;

        String[] jimutetuzukiArray = null;

        Map<String, String> jimutetuzukiNmMap = Maps.newHashMap();
        Map<String, String> taskNmMap = Maps.newHashMap();

        Map<String, Integer> jimutetuzukiOrderMap = Maps.newHashMap();

        Map<String, Integer> taskOrderMap = Maps.newHashMap();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = Lists.newArrayList();

        jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIds(new String[] { pSubsystemId });

        jimutetuzukiArray = new String[jimutetuzukiList.size()];
        for (int i = 0; i < jimutetuzukiList.size(); i++) {
            if (jimutetuzukiList.get(i).getHyoujijyun() != null) {
                jimutetuzukiArray[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
                if (!jimutetuzukiNmMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiNmMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getJimutetuzukinm());
                }

                if (!jimutetuzukiOrderMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiOrderMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getHyoujijyun());
                }
            }
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimutetuzukiList.size() > 0) {
            for (DM_Jimutetuzuki tmpJimu : jimutetuzukiList) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getHyoujijyun() != null) {
                if (!taskNmMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                    taskNmMap.put(
                        taskList.get(i).getJimutetuzukicd() + "." + taskList.get(i).getWorkflowTskId(),
                        taskList.get(i).getWorkflowTskNm());
                }

                if (taskList.get(i).getWorklistHyoujiFlag() == 1) {
                    if (!taskOrderMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                        taskOrderMap.put(
                            taskList.get(i).getJimutetuzukicd() + "." + taskList.get(i).getWorkflowTskId(),
                            taskList.get(i).getHyoujijyun());
                    }
                }
            }
        }

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        GetExecutableTasksByProcessOutBean outBean = new GetExecutableTasksByProcessOutBean();
        GetExecutableTasksByProcessOutBean outBean2 = new GetExecutableTasksByProcessOutBean();
        GetExecutableTasksByProcessOutBean outBean3 = new GetExecutableTasksByProcessOutBean();

        Ordering<ExecutableTaskInfoBean> ordering = Ordering.from(new WorkListJimutetuzukiCdTaskIdSortComparator());
        List<ExecutableTaskInfoBean> sortedBean;

        Ordering<yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean> ordering2 = Ordering.from(new WorkListFlowIdNodeNameSortComparator());

        if (Strings.isNullOrEmpty(pJimutetuzukiCd)) {
            inBean.setFlowIds(jimutetuzukiArray);

        } else {
            inBean.setFlowIds(new String[] { pJimutetuzukiCd });
        }

        inBean.setAccountid(pWariateUserId);

        if (pSkeijimukbn != null) {
            WSExtParam extParam1 = new WSExtParam();
            extParam1.setValues(pSkeijimukbn);
            inBean.setExtParam1(extParam1);
        }

        if (pMousikomiHou != null) {
            WSExtParam extParam2 = new WSExtParam();
            extParam2.setValues(pMousikomiHou);
            inBean.setExtParam2(extParam2);
        }

        if (pHknsyuruino != null) {
            WSExtParam extParam3 = new WSExtParam();
            extParam3.setValues(pHknsyuruino);
            inBean.setExtParam3(extParam3);
        }

        if (!Strings.isNullOrEmpty(pChildDairitenUmu)) {
            WSExtParam extParam6 = new WSExtParam();
            extParam6.setValues(pChildDairitenUmu);
            inBean.setExtParam6(extParam6);
        }

        if (!Strings.isNullOrEmpty(pJimuyouCd)) {
            WSExtParam extParam7 = new WSExtParam();
            extParam7.setValues(pJimuyouCd);
            inBean.setExtParam7(extParam7);
        }

        if (WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_ARI.equals(pJimuyouCdUmu)) {
            WSExtParam extParam8 = new WSExtParam();
            extParam8.setValues(WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_CONVERT_ARI);
            inBean.setExtParam8(extParam8);
        }

        if (!Strings.isNullOrEmpty(pDoujiMousikomi)) {
            WSExtParam extParam9 = new WSExtParam();
            extParam9.setValues(pDoujiMousikomi);
            inBean.setExtParam9(extParam9);
        }

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        if (!Strings.isNullOrEmpty(pMousikomiYmdFrom) || !Strings.isNullOrEmpty(pMousikomiYmdTo)) {
            WSExtParam extParam10 = new WSExtParam();

            if (Strings.isNullOrEmpty(pMousikomiYmdFrom)) {
                extParam10.setValueFrom("19700101");
                try {
                    extParam10.setValueTo(sdf8.format(sdf8.parse(pMousikomiYmdTo)));
                } catch (Exception e) {
                    extParam10.setValueTo(pMousikomiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pMousikomiYmdTo)) {
                try {
                    extParam10.setValueFrom(sdf8.format(sdf8.parse(pMousikomiYmdFrom)));
                } catch (Exception e) {
                    extParam10.setValueFrom(pMousikomiYmdFrom);
                }
                extParam10.setValueTo("99991231");
            } else {
                try {
                    extParam10.setValueFrom(sdf8.format(sdf8.parse(pMousikomiYmdFrom)));
                    extParam10.setValueTo(sdf8.format(sdf8.parse(pMousikomiYmdTo)));
                } catch (Exception e) {
                    extParam10.setValueFrom(pMousikomiYmdFrom);
                    extParam10.setValueTo(pMousikomiYmdTo);
                }
            }
            inBean.setExtParam10(extParam10);
        }

        if (!Strings.isNullOrEmpty(pJimuKaisiYmdFrom) || !Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
            WSExtParam extParam11 = new WSExtParam();

            if (Strings.isNullOrEmpty(pJimuKaisiYmdFrom)) {
                extParam11.setValueFrom("19700101000000000");
                try {
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                }
                extParam11.setValueTo("99991231235959999");
            } else {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            }
            inBean.setExtParam11(extParam11);
        }

        if (!Strings.isNullOrEmpty(pMosNo)) {
            WSExtParam extParam14 = new WSExtParam();
            extParam14.setValues(pMosNo);
            inBean.setExtParam14(extParam14);
        }

        if (!Strings.isNullOrEmpty(pSyoNo)) {
            WSExtParam extParam12 = new WSExtParam();
            extParam12.setValues(pSyoNo);
            inBean.setExtParam12(extParam12);
        }

        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            WSExtParam extParam13 = new WSExtParam();
            extParam13.setValues(pNkSysyNo);
            inBean.setExtParam13(extParam13);
        }

        if (pDairiten != null) {

            WSExtParam extParam4 = new WSExtParam();
            extParam4.setValues(pDairiten);
            inBean.setExtParam4(extParam4);
            inBean.setExtParam5(null);

            outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
                if(!IwfMessageCd.IWF2070.toString().equals(outBean.getSyousaimsgcd())){
                    resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
                    return resultBean;
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
            }

            List<yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean> wkExecutableTaskInfosList1 = outBean.getExecutableTaskInfos();

            if (wkExecutableTaskInfosList1.size() > 0) {
                wkExecutableTaskInfosList1 = ordering2.sortedCopy(wkExecutableTaskInfosList1);
            }

            WSExtParam extParam5 = new WSExtParam();
            extParam5.setValues(pDairiten);
            inBean.setExtParam4(null);
            inBean.setExtParam5(extParam5);

            outBean2 = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(outBean2.getKekkastatus())) {
                if(!IwfMessageCd.IWF2070.toString().equals(outBean2.getSyousaimsgcd())){
                    resultBean.setSyorikekkaStatus(outBean2.getKekkastatus());
                    return resultBean;
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
            }

            List<yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean> wkExecutableTaskInfosList2 = outBean2.getExecutableTaskInfos();

            if (wkExecutableTaskInfosList2.size() > 0) {
                wkExecutableTaskInfosList2 = ordering2.sortedCopy(wkExecutableTaskInfosList2);
            }

            inBean.setExtParam4(extParam4);
            inBean.setExtParam5(extParam5);

            outBean3 = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(outBean3.getKekkastatus())) {
                if(!IwfMessageCd.IWF2070.toString().equals(outBean3.getSyousaimsgcd())){
                    resultBean.setSyorikekkaStatus(outBean3.getKekkastatus());
                    return resultBean;
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
            }

            List<yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean> wkExecutableTaskInfosList3 = outBean3.getExecutableTaskInfos();

            if (wkExecutableTaskInfosList3.size() > 0) {
                wkExecutableTaskInfosList3 = ordering2.sortedCopy(wkExecutableTaskInfosList3);
            }

            if(wkExecutableTaskInfosList1.size() > 0){
                if(wkExecutableTaskInfosList2.size() > 0){
                    for(int i=0;i<wkExecutableTaskInfosList2.size();i++){
                        if(wkExecutableTaskInfosList2.get(i).getFlowId().equals(wkExecutableTaskInfosList1.get(i).getFlowId()) &&
                            wkExecutableTaskInfosList2.get(i).getNodeName().equals(wkExecutableTaskInfosList1.get(i).getNodeName())){
                            int wkCountKojin1 = Integer.valueOf(wkExecutableTaskInfosList1.get(i).getTaskCountKojin());
                            int wkCountKyouyuu1 = Integer.valueOf(wkExecutableTaskInfosList1.get(i).getTaskCountKyouyuu());
                            int wkCountKojin2 = Integer.valueOf(wkExecutableTaskInfosList2.get(i).getTaskCountKojin());
                            int wkCountKyouyuu2 = Integer.valueOf(wkExecutableTaskInfosList2.get(i).getTaskCountKyouyuu());
                            wkExecutableTaskInfosList1.get(i).setTaskCountKojin(String.valueOf((wkCountKojin1+wkCountKojin2)));
                            wkExecutableTaskInfosList1.get(i).setTaskcountKyouyuu(String.valueOf((wkCountKyouyuu1+wkCountKyouyuu2)));
                        }
                    }
                }
                if(wkExecutableTaskInfosList3.size() > 0){
                    for(int i=0;i<wkExecutableTaskInfosList3.size();i++){
                        if(wkExecutableTaskInfosList3.get(i).getFlowId().equals(wkExecutableTaskInfosList1.get(i).getFlowId()) &&
                            wkExecutableTaskInfosList3.get(i).getNodeName().equals(wkExecutableTaskInfosList1.get(i).getNodeName())){
                            int wkCountKojin1 = Integer.valueOf(wkExecutableTaskInfosList1.get(i).getTaskCountKojin());
                            int wkCountKyouyuu1 = Integer.valueOf(wkExecutableTaskInfosList1.get(i).getTaskCountKyouyuu());
                            int wkCountKojin3 = Integer.valueOf(wkExecutableTaskInfosList3.get(i).getTaskCountKojin());
                            int wkCountKyouyuu3 = Integer.valueOf(wkExecutableTaskInfosList3.get(i).getTaskCountKyouyuu());
                            wkExecutableTaskInfosList1.get(i).setTaskCountKojin(String.valueOf((wkCountKojin1-wkCountKojin3)));
                            wkExecutableTaskInfosList1.get(i).setTaskcountKyouyuu(String.valueOf((wkCountKyouyuu1-wkCountKyouyuu3)));
                        }
                    }
                }
            }else{
                if(wkExecutableTaskInfosList2.size() > 0){
                    wkExecutableTaskInfosList1.addAll(wkExecutableTaskInfosList2);
                }
            }

            outBean.setExecutableTaskInfos(wkExecutableTaskInfosList1);

        }else{

            outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);
            if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
                if(!IwfMessageCd.IWF2070.toString().equals(outBean.getSyousaimsgcd())){
                    resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
                    return resultBean;
                }
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
            }

        }

        if (outBean.getExecutableTaskInfos() == null ||
            outBean.getExecutableTaskInfos().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        for (yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean tmpBean : outBean.getExecutableTaskInfos()) {

            String tmpJimutetuzukiCd = tmpBean.getFlowId();
            String tmpTaskId = tmpBean.getNodeName();
            String tmpJimutetuzukiTask = tmpJimutetuzukiCd + "." + tmpTaskId;

            if (jimutetuzukiOrderMap.containsKey(tmpJimutetuzukiCd) &&
                taskOrderMap.containsKey(tmpJimutetuzukiTask)) {
                bean = new ExecutableTaskInfoBean();

                bean.setJimutetuzukiCd(tmpJimutetuzukiCd);

                bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(tmpJimutetuzukiCd));

                bean.setTaskNm(tmpTaskId);

                bean.setDispTaskNm(taskNmMap.get(tmpJimutetuzukiTask));

                bean.setSharedTaskNum(BizNumber.valueOf(Integer.valueOf(tmpBean.getTaskCountKyouyuu())));

                bean.setPersonalizedTaskNum(BizNumber.valueOf(Integer.valueOf(tmpBean.getTaskCountKojin())));

                bean.setJimutetuzukiDispOrder(jimutetuzukiOrderMap.get(tmpJimutetuzukiCd));

                bean.setTaskDispOrder(taskOrderMap.get(tmpJimutetuzukiTask));

                beanList.add(bean);
            }
        }

        sortedBean = ordering.sortedCopy(beanList);

        resultBean.setExecutableTaskInfoBeanList(sortedBean);

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());

        return resultBean;
    }

    public static GetExecutableTasksForWorkListResultBean getExecutableTasksForWorkList(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId) {

        GetExecutableTasksForWorkListResultBean resultBean = new GetExecutableTasksForWorkListResultBean();
        List<ExecutableTaskInfoBean> beanList = new ArrayList<ExecutableTaskInfoBean>();
        ExecutableTaskInfoBean bean;

        String[] jimutetuzukiArray = null;

        Map<String, String> jimutetuzukiNmMap = Maps.newHashMap();
        Map<String, String> taskNmMap = Maps.newHashMap();

        Map<String, Integer> jimutetuzukiOrderMap = Maps.newHashMap();

        Map<String, Integer> taskOrderMap = Maps.newHashMap();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager
            .getJimutetuzukisBySubSystemIds(new String[] { pSubsystemId });

        jimutetuzukiArray = new String[jimutetuzukiList.size()];
        for (int i = 0; i < jimutetuzukiList.size(); i++) {
            if (jimutetuzukiList.get(i).getHyoujijyun() != null) {
                jimutetuzukiArray[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
                if (!jimutetuzukiNmMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiNmMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getJimutetuzukinm());
                }

                if (!jimutetuzukiOrderMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiOrderMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getHyoujijyun());
                }
            }
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimutetuzukiList.size() > 0) {
            for (DM_Jimutetuzuki tmpJimu : jimutetuzukiList) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getHyoujijyun() != null) {
                if (!taskNmMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                    taskNmMap.put(
                        taskList.get(i).getJimutetuzukicd() + "." + taskList.get(i).getWorkflowTskId(),
                        taskList.get(i).getWorkflowTskNm());
                }

                if (taskList.get(i).getWorklistHyoujiFlag() == 1) {
                    if (!taskOrderMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                        taskOrderMap.put(
                            taskList.get(i).getJimutetuzukicd() + "." + taskList.get(i).getWorkflowTskId(),
                            taskList.get(i).getHyoujijyun());
                    }
                }
            }
        }

        GetExecutableTasksByProcessInBean inBean = new GetExecutableTasksByProcessInBean();

        if (Strings.isNullOrEmpty(pJimutetuzukiCd)) {
            inBean.setFlowIds(jimutetuzukiArray);

        } else {
            inBean.setFlowIds(new String[] { pJimutetuzukiCd });

        }

        inBean.setAccountid(pWariateUserId);

        if (!Strings.isNullOrEmpty(pJimuyouCd)) {
            WSExtParam extParam7 = new WSExtParam();
            extParam7.setValues(pJimuyouCd);
            inBean.setExtParam7(extParam7);
        }

        if (WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_ARI.equals(pJimuyouCdUmu)) {
            WSExtParam extParam8 = new WSExtParam();
            extParam8.setValues(WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_CONVERT_ARI);
            inBean.setExtParam8(extParam8);
        }

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        if (!Strings.isNullOrEmpty(pJimuKaisiYmdFrom) || !Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
            WSExtParam extParam11 = new WSExtParam();

            if (Strings.isNullOrEmpty(pJimuKaisiYmdFrom)) {
                extParam11.setValueFrom("19700101000000000");
                try {
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                }
                extParam11.setValueTo("99991231235959999");
            } else {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            }
            inBean.setExtParam11(extParam11);
        }

        if (!Strings.isNullOrEmpty(pMosNo)) {
            WSExtParam extParam14 = new WSExtParam();
            extParam14.setValues(pMosNo);
            inBean.setExtParam14(extParam14);
        }

        if (!Strings.isNullOrEmpty(pSyoNo)) {
            WSExtParam extParam12 = new WSExtParam();
            extParam12.setValues(pSyoNo);
            inBean.setExtParam12(extParam12);
        }

        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            WSExtParam extParam13 = new WSExtParam();
            extParam13.setValues(pNkSysyNo);
            inBean.setExtParam13(extParam13);
        }

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);
        GetExecutableTasksByProcessOutBean outBean = iwfKouteiClient.execGetExecutableTasksByProcess(inBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
            if(!IwfMessageCd.IWF2070.toString().equals(outBean.getSyousaimsgcd())){
                resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
                return resultBean;
            }
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        }

        if (outBean.getExecutableTaskInfos() == null ||
            outBean.getExecutableTaskInfos().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        for (yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean tmpBean : outBean.getExecutableTaskInfos()) {

            String tmpJimutetuzukiCd = tmpBean.getFlowId();
            String tmpTaskId = tmpBean.getNodeName();
            String tmpJimutetuzukiTask = tmpJimutetuzukiCd + "." + tmpTaskId;

            if (jimutetuzukiOrderMap.containsKey(tmpJimutetuzukiCd) &&
                taskOrderMap.containsKey(tmpJimutetuzukiTask)) {
                bean = new ExecutableTaskInfoBean();

                bean.setJimutetuzukiCd(tmpJimutetuzukiCd);

                bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(tmpJimutetuzukiCd));

                bean.setTaskNm(tmpTaskId);

                bean.setDispTaskNm(taskNmMap.get(tmpJimutetuzukiTask));

                bean.setSharedTaskNum(BizNumber.valueOf(Integer.valueOf(tmpBean.getTaskCountKyouyuu())));

                bean.setPersonalizedTaskNum(BizNumber.valueOf(Integer.valueOf(tmpBean.getTaskCountKojin())));

                bean.setJimutetuzukiDispOrder(jimutetuzukiOrderMap.get(tmpJimutetuzukiCd));

                bean.setTaskDispOrder(taskOrderMap.get(tmpJimutetuzukiTask));

                beanList.add(bean);
            }
        }

        Ordering<ExecutableTaskInfoBean> ordering = Ordering.from(new WorkListJimutetuzukiCdTaskIdSortComparator());
        List<ExecutableTaskInfoBean> sortedBean;

        sortedBean = ordering.sortedCopy(beanList);

        resultBean.setExecutableTaskInfoBeanList(sortedBean);

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());

        return resultBean;

    }

    public static GetTasksForWorkListSkResultBean getTasksForWorkListSk(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pMousikomiYmdFrom,
        String pMousikomiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pTaskNm,
        String[] pSkeijimukbn,
        String[] pMousikomiHou,
        String[] pHknsyuruino,
        String[] pDairiten,
        String pChildDairitenUmu,
        String pDoujiMousikomi) {

        GetTasksForWorkListSkResultBean resultBean = new GetTasksForWorkListSkResultBean();
        List<TaskSummaryForWorkListBean> beanList = new ArrayList<TaskSummaryForWorkListBean>();
        TaskSummaryForWorkListBean bean = new TaskSummaryForWorkListBean();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();

        String[] jimutetuzukiArray = null;

        Map<String, String> jimutetuzukiNmMap = Maps.newHashMap();
        Map<String, String> taskNmMap = Maps.newHashMap();

        Map<String, Integer> jimutetuzukiOrderMap = Maps.newHashMap();

        Map<String, Integer> taskOrderMap = Maps.newHashMap();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager
            .getJimutetuzukisBySubSystemIds(new String[] { pSubsystemId });

        jimutetuzukiArray = new String[jimutetuzukiList.size()];
        for (int i = 0; i < jimutetuzukiList.size(); i++) {
            if (jimutetuzukiList.get(i).getHyoujijyun() != null) {
                jimutetuzukiArray[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
                if (!jimutetuzukiNmMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiNmMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getJimutetuzukinm());
                }

                if (!jimutetuzukiOrderMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiOrderMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getHyoujijyun());
                }
            }
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimutetuzukiList.size() > 0) {
            for (DM_Jimutetuzuki tmpJimu : jimutetuzukiList) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getHyoujijyun() != null) {
                if (!taskNmMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                    taskNmMap.put(
                        taskList.get(i).getJimutetuzukicd() + "." + taskList.get(i).getWorkflowTskId(),
                        taskList.get(i).getWorkflowTskNm());
                }

                if (taskList.get(i).getWorklistHyoujiFlag() == 1) {
                    if (!taskOrderMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                        taskOrderMap.put(
                            taskList.get(i).getJimutetuzukicd() + "." + taskList.get(i).getWorkflowTskId(),
                            taskList.get(i).getHyoujijyun());
                    }
                }
            }
        }

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        GetProcessSummaryOutBean getProcessSummaryOutBean2 = new GetProcessSummaryOutBean();

        if (Strings.isNullOrEmpty(pJimutetuzukiCd)) {
            inBean.setFlowids(jimutetuzukiArray);

        } else {
            inBean.setFlowids(new String[] { pJimutetuzukiCd });
        }

        if (pIsWariate.equals("0")) {
            inBean.setAccountid(pWariateUserId);
        }

        inBean.setNodename(pTaskNm);

        inBean.setAccountwariateumu(pIsWariate);

        inBean.setKekkajyougenkensu("2000");

        if (pSkeijimukbn != null) {
            WSExtParam extParam1 = new WSExtParam();
            extParam1.setValues(pSkeijimukbn);
            inBean.setExtParam1(extParam1);
        }

        if (pMousikomiHou != null) {
            WSExtParam extParam2 = new WSExtParam();
            extParam2.setValues(pMousikomiHou);
            inBean.setExtParam2(extParam2);
        }

        if (pHknsyuruino != null) {
            WSExtParam extParam3 = new WSExtParam();
            extParam3.setValues(pHknsyuruino);
            inBean.setExtParam3(extParam3);
        }

        if (!Strings.isNullOrEmpty(pChildDairitenUmu)) {
            WSExtParam extParam6 = new WSExtParam();
            extParam6.setValues(pChildDairitenUmu);
            inBean.setExtParam6(extParam6);
        }

        if (!Strings.isNullOrEmpty(pJimuyouCd)) {
            WSExtParam extParam7 = new WSExtParam();
            extParam7.setValues(pJimuyouCd);
            inBean.setExtParam7(extParam7);
        }

        if (WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_ARI.equals(pJimuyouCdUmu)) {
            WSExtParam extParam8 = new WSExtParam();
            extParam8.setValues(WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_CONVERT_ARI);
            inBean.setExtParam8(extParam8);
        }

        if (!Strings.isNullOrEmpty(pDoujiMousikomi)) {
            WSExtParam extParam9 = new WSExtParam();
            extParam9.setValues(pDoujiMousikomi);
            inBean.setExtParam9(extParam9);
        }

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        if (!Strings.isNullOrEmpty(pMousikomiYmdFrom) || !Strings.isNullOrEmpty(pMousikomiYmdTo)) {
            WSExtParam extParam10 = new WSExtParam();

            if (Strings.isNullOrEmpty(pMousikomiYmdFrom)) {
                extParam10.setValueFrom("19700101");
                try {
                    extParam10.setValueTo(sdf8.format(sdf8.parse(pMousikomiYmdTo)));
                } catch (Exception e) {
                    extParam10.setValueTo(pMousikomiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pMousikomiYmdTo)) {
                try {
                    extParam10.setValueFrom(sdf8.format(sdf8.parse(pMousikomiYmdFrom)));
                } catch (Exception e) {
                    extParam10.setValueFrom(pMousikomiYmdFrom);
                }
                extParam10.setValueTo("99991231");
            } else {
                try {
                    extParam10.setValueFrom(sdf8.format(sdf8.parse(pMousikomiYmdFrom)));
                    extParam10.setValueTo(sdf8.format(sdf8.parse(pMousikomiYmdTo)));
                } catch (Exception e) {
                    extParam10.setValueFrom(pMousikomiYmdFrom);
                    extParam10.setValueTo(pMousikomiYmdTo);
                }
            }
            inBean.setExtParam10(extParam10);
        }

        if (!Strings.isNullOrEmpty(pJimuKaisiYmdFrom) || !Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
            WSExtParam extParam11 = new WSExtParam();

            if (Strings.isNullOrEmpty(pJimuKaisiYmdFrom)) {
                extParam11.setValueFrom("19700101000000000");
                try {
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                }
                extParam11.setValueTo("99991231235959999");
            } else {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            }
            inBean.setExtParam11(extParam11);
        }

        if (!Strings.isNullOrEmpty(pMosNo)) {
            WSExtParam extParam14 = new WSExtParam();
            extParam14.setValues(pMosNo);
            inBean.setExtParam14(extParam14);
        }

        if (!Strings.isNullOrEmpty(pSyoNo)) {
            WSExtParam extParam12 = new WSExtParam();
            extParam12.setValues(pSyoNo);
            inBean.setExtParam12(extParam12);
        }

        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            WSExtParam extParam13 = new WSExtParam();
            extParam13.setValues(pNkSysyNo);
            inBean.setExtParam13(extParam13);
        }


        if (pDairiten != null) {

            WSExtParam extParam4 = new WSExtParam();
            extParam4.setValues(pDairiten);
            inBean.setExtParam4(extParam4);
            inBean.setExtParam5(null);

            getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(inBean);

            resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
            if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
                return resultBean;
            }

            List<ProcessSummaryBean> wkProcessSummaryOutBeanList1 = getProcessSummaryOutBean.getProcessSummaryBeanList();


            WSExtParam extParam5 = new WSExtParam();
            extParam5.setValues(pDairiten);
            inBean.setExtParam4(null);
            inBean.setExtParam5(extParam5);

            getProcessSummaryOutBean2 = iwfKouteiClient.execGetProcessSummary(inBean);

            resultBean.setSyousaiMessageCd(getProcessSummaryOutBean2.getSyousaimsgcd());
            resultBean.setSyousaiMessage(getProcessSummaryOutBean2.getSyousaimsg());
            if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean2.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(getProcessSummaryOutBean2.getKekkastatus());
                return resultBean;
            }

            List<ProcessSummaryBean> wkProcessSummaryOutBeanList2 = getProcessSummaryOutBean2.getProcessSummaryBeanList();

            if(wkProcessSummaryOutBeanList1.size() > 0){
                if(wkProcessSummaryOutBeanList2.size() > 0){
                    wkProcessSummaryOutBeanList1.addAll(wkProcessSummaryOutBeanList2);

                    HashSet<String> hs = new HashSet<String>();

                    for(int n =0;wkProcessSummaryOutBeanList1.size()>n;){
                        if(!hs.contains(wkProcessSummaryOutBeanList1.get(n).getGyoumukey())){
                            hs.add(wkProcessSummaryOutBeanList1.get(n).getGyoumukey());
                            n++;
                        }else{
                            wkProcessSummaryOutBeanList1.remove(n);
                        }
                    }

                }
            } else{
                if(wkProcessSummaryOutBeanList2.size() > 0){
                    wkProcessSummaryOutBeanList1.addAll(wkProcessSummaryOutBeanList2);
                }
            }

            getProcessSummaryOutBean.setProcessSummaryBeanList(wkProcessSummaryOutBeanList1);

        }else{
            getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(inBean);

            resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
            if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
                return resultBean;
            }

        }

        if (getProcessSummaryOutBean.getProcessSummaryBeanList() == null ||
            getProcessSummaryOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<ProcessSummaryBean> sortBeanList = new ArrayList<ProcessSummaryBean>();
        sortBeanList = getProcessSummaryOutBean.getProcessSummaryBeanList();

        List<ProcessSummaryBean> wkBeanList = new ArrayList<ProcessSummaryBean>();

        Ordering<ProcessSummaryBean> ordering = Ordering.from(new WorkListJimuStartYmdSortComparator());
        wkBeanList = ordering.sortedCopy(sortBeanList);

        List<BT_WariateHukaInfo> wariateList =
            bizDomManager.getWariateHukaInfosBySubSystemIdUserId(pSubsystemId, pWariateUserId);

        int syoriKensu = 0;

        for (ProcessSummaryBean tmpBean : wkBeanList) {

            if (syoriKensu == 1000) {
                break;
            }

            String tmpJimutetuzukiCd = tmpBean.getFlowId();
            String tmpCurrentTaskId = tmpBean.getCurrentNodeName();
            String tmpPreTaskId = tmpBean.getPreviousNodeName();
            String tmpJimutetuzukiCurrentTask = tmpJimutetuzukiCd + "." + tmpCurrentTaskId;
            String tmpJimutetuzukiPreTask = tmpJimutetuzukiCd + "." + tmpPreTaskId;

            if (jimutetuzukiOrderMap.containsKey(tmpJimutetuzukiCd) &&
                taskOrderMap.containsKey(tmpJimutetuzukiCurrentTask)) {

                bean = new TaskSummaryForWorkListBean();

                bean.setJimutetuzukiCd(tmpJimutetuzukiCd);

                bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(tmpJimutetuzukiCd));

                bean.setKouteiKnrId(tmpBean.getGyoumukey());

                bean.setMosNo(tmpBean.getExtparamBean().getExtparam14());

                bean.setSyoNo(tmpBean.getExtparamBean().getExtparam12());

                bean.setNkSysyNo(tmpBean.getExtparamBean().getExtparam13());

                if (!Strings.isNullOrEmpty(tmpBean.getExtparamBean().getExtparam11())) {
                    bean.setJimuStartYmd(tmpBean.getExtparamBean().getExtparam11());
                }


                bean.setPreSyoriTantouId(tmpBean.getPreviousAccountId());

                bean.setPreTaskNm(tmpPreTaskId);

                bean.setDispPreTaskNm(taskNmMap.get(tmpJimutetuzukiPreTask));

                bean.setNowSyoriTantouId(tmpBean.getCurrentAccountId());

                bean.setNowTaskNm(tmpCurrentTaskId);

                bean.setDispNowTaskNm(taskNmMap.get(tmpJimutetuzukiCurrentTask));

                bean.setHknsyuruino(tmpBean.getExtparamBean().getExtparam3());

                if (!BizUtil.isBlank(bean.getPreSyoriTantouId())) {

                    if (accountNmMap.size() <= 0 ||
                        !accountNmMap.containsKey(bean.getPreSyoriTantouId())) {

                        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                        AM_User userInfo = baseDomManager.getUser(bean.getPreSyoriTantouId());
                        if (userInfo == null) {
                            accountNmMap.put(bean.getPreSyoriTantouId(), null);
                        } else {
                            accountNmMap.put(bean.getPreSyoriTantouId(), userInfo.getUserNm());
                        }
                    }

                    bean.setDispPreSyoriTantouNm(accountNmMap.get(bean.getPreSyoriTantouId()));
                }

                if (!BizUtil.isBlank(bean.getNowSyoriTantouId())) {

                    if (accountNmMap.size() <= 0 ||
                        !accountNmMap.containsKey(bean.getNowSyoriTantouId())) {

                        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                        AM_User userInfo = baseDomManager.getUser(bean.getNowSyoriTantouId());
                        if (userInfo == null) {
                            accountNmMap.put(bean.getNowSyoriTantouId(), null);
                        } else {
                            accountNmMap.put(bean.getNowSyoriTantouId(), userInfo.getUserNm());
                        }
                    }

                    bean.setDispNowSyoriTantouNm(accountNmMap.get(bean.getNowSyoriTantouId()));
                }

                WorkflowWariateInfoFilter wariateInfoFilter = new WorkflowWariateInfoFilter();
                wariateInfoFilter.setTargetGyoumuKey(tmpBean.getGyoumukey());
                wariateInfoFilter.setTargetFlowNm(tmpBean.getFlowId());
                wariateInfoFilter.setTargetNodeNm(tmpBean.getCurrentNodeName());
                List<BT_WariateHukaInfo> filteredList = ImmutableList.copyOf(Iterables.filter(wariateList,
                    wariateInfoFilter));
                if (filteredList == null ||
                    filteredList.size() <= 0) {
                    bean.setNyuuryokuKahi(true);
                } else {
                    bean.setNyuuryokuKahi(false);
                }

                beanList.add(bean);

                syoriKensu++;
            }
        }

        resultBean.setTaskSummaryForWorkListBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;

    }

    public static GetTasksForWorkListResultBean getTasksForWorkList(
        String pSubsystemId,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pJimutetuzukiCd,
        String pJimuKaisiYmdFrom,
        String pJimuKaisiYmdTo,
        String pJimuyouCd,
        String pJimuyouCdUmu,
        String pWariateUserId,
        String pIsWariate,
        String pTaskNm) {

        GetTasksForWorkListResultBean resultBean = new GetTasksForWorkListResultBean();
        List<TaskSummaryForWorkListBean> beanList = new ArrayList<TaskSummaryForWorkListBean>();
        TaskSummaryForWorkListBean bean = new TaskSummaryForWorkListBean();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> accountNmMap = new HashMap<String, String>();

        String[] jimutetuzukiArray = null;

        Map<String, String> jimutetuzukiNmMap = Maps.newHashMap();
        Map<String, String> taskNmMap = Maps.newHashMap();

        Map<String, Integer> jimutetuzukiOrderMap = Maps.newHashMap();

        Map<String, Integer> taskOrderMap = Maps.newHashMap();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager
            .getJimutetuzukisBySubSystemIds(new String[] { pSubsystemId });

        jimutetuzukiArray = new String[jimutetuzukiList.size()];
        for (int i = 0; i < jimutetuzukiList.size(); i++) {
            if (jimutetuzukiList.get(i).getHyoujijyun() != null) {
                jimutetuzukiArray[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
                if (!jimutetuzukiNmMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiNmMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getJimutetuzukinm());
                }

                if (!jimutetuzukiOrderMap.containsKey(jimutetuzukiList.get(i).getJimutetuzukicd())) {
                    jimutetuzukiOrderMap.put(
                        jimutetuzukiList.get(i).getJimutetuzukicd(),
                        jimutetuzukiList.get(i).getHyoujijyun());
                }
            }
        }

        List<DM_JimutetuzukiTask> taskList = Lists.newArrayList();
        if (jimutetuzukiList.size() > 0) {
            for (DM_Jimutetuzuki tmpJimu : jimutetuzukiList) {
                taskList.addAll(tmpJimu.getJimutetuzukiTasks());
            }
        }

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getHyoujijyun() != null) {
                if (!taskNmMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                    taskNmMap.put(
                        taskList.get(i).getJimutetuzukicd() + "." +
                            taskList.get(i).getWorkflowTskId(),
                            taskList.get(i).getWorkflowTskNm());
                }

                if (taskList.get(i).getWorklistHyoujiFlag() == 1) {
                    if (!taskOrderMap.containsKey(taskList.get(i).getWorkflowTskId())) {
                        taskOrderMap.put(
                            taskList.get(i).getJimutetuzukicd() + "." +
                                taskList.get(i).getWorkflowTskId(),
                                taskList.get(i).getHyoujijyun());
                    }
                }
            }
        }

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        if (Strings.isNullOrEmpty(pJimutetuzukiCd)) {
            inBean.setFlowids(jimutetuzukiArray);

        } else {
            inBean.setFlowids(new String[] { pJimutetuzukiCd });
        }

        if (pIsWariate.equals("0")) {
            inBean.setAccountid(pWariateUserId);
        }

        inBean.setNodename(pTaskNm);

        inBean.setAccountwariateumu(pIsWariate);

        inBean.setKekkajyougenkensu("1000");

        if (!Strings.isNullOrEmpty(pJimuyouCd)) {
            WSExtParam extParam7 = new WSExtParam();
            extParam7.setValues(pJimuyouCd);
            inBean.setExtParam7(extParam7);
        }

        if (WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_ARI.equals(pJimuyouCdUmu)) {
            WSExtParam extParam8 = new WSExtParam();
            extParam8.setValues(WorkFlowUtilityConstants.JIMUYOU_CODE_MISETTEI_KUBUN_CONVERT_ARI);
            inBean.setExtParam8(extParam8);
        }

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        if (!Strings.isNullOrEmpty(pJimuKaisiYmdFrom) || !Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
            WSExtParam extParam11 = new WSExtParam();

            if (Strings.isNullOrEmpty(pJimuKaisiYmdFrom)) {
                extParam11.setValueFrom("19700101000000000");
                try {
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            } else if (Strings.isNullOrEmpty(pJimuKaisiYmdTo)) {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                }
                extParam11.setValueTo("99991231235959999");
            } else {
                try {
                    extParam11.setValueFrom(sdf17.format(sdf8.parse(pJimuKaisiYmdFrom)));
                    extParam11.setValueTo(pJimuKaisiYmdTo.substring(0, 8).concat("235959999"));
                } catch (Exception e) {
                    extParam11.setValueFrom(pJimuKaisiYmdFrom);
                    extParam11.setValueTo(pJimuKaisiYmdTo);
                }
            }
            inBean.setExtParam11(extParam11);
        }

        if (!Strings.isNullOrEmpty(pMosNo)) {
            WSExtParam extParam14 = new WSExtParam();
            extParam14.setValues(pMosNo);
            inBean.setExtParam14(extParam14);
        }

        if (!Strings.isNullOrEmpty(pSyoNo)) {
            WSExtParam extParam12 = new WSExtParam();
            extParam12.setValues(pSyoNo);
            inBean.setExtParam12(extParam12);
        }

        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            WSExtParam extParam13 = new WSExtParam();
            extParam13.setValues(pNkSysyNo);
            inBean.setExtParam13(extParam13);
        }

        GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient.execGetProcessSummary(inBean);
        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
            return resultBean;
        }
        if (getProcessSummaryOutBean.getProcessSummaryBeanList() == null ||
            getProcessSummaryOutBean.getProcessSummaryBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<BT_WariateHukaInfo> wariateList =
            bizDomManager.getWariateHukaInfosBySubSystemIdUserId(pSubsystemId, pWariateUserId);

        List<TaskSummaryForWorkListBean> wkBeanList = new ArrayList<TaskSummaryForWorkListBean>();
        for (ProcessSummaryBean tmpBean : getProcessSummaryOutBean.getProcessSummaryBeanList()) {

            String tmpJimutetuzukiCd = tmpBean.getFlowId();
            String tmpCurrentTaskId = tmpBean.getCurrentNodeName();
            String tmpPreTaskId = tmpBean.getPreviousNodeName();
            String tmpJimutetuzukiCurrentTask = tmpJimutetuzukiCd + "." + tmpCurrentTaskId;
            String tmpJimutetuzukiPreTask = tmpJimutetuzukiCd + "." + tmpPreTaskId;

            if (jimutetuzukiOrderMap.containsKey(tmpJimutetuzukiCd) &&
                taskOrderMap.containsKey(tmpJimutetuzukiCurrentTask)) {
                bean = new TaskSummaryForWorkListBean();

                bean.setJimutetuzukiCd(tmpJimutetuzukiCd);

                bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(tmpJimutetuzukiCd));

                bean.setKouteiKnrId(tmpBean.getGyoumukey());

                bean.setMosNo(tmpBean.getExtparamBean().getExtparam14());

                bean.setSyoNo(tmpBean.getExtparamBean().getExtparam12());

                bean.setNkSysyNo(tmpBean.getExtparamBean().getExtparam13());

                if (!Strings.isNullOrEmpty(tmpBean.getExtparamBean().getExtparam11())) {
                    bean.setJimuStartYmd(tmpBean.getExtparamBean().getExtparam11());
                }


                bean.setPreSyoriTantouId(tmpBean.getPreviousAccountId());

                bean.setPreTaskNm(tmpPreTaskId);

                bean.setDispPreTaskNm(taskNmMap.get(tmpJimutetuzukiPreTask));

                bean.setNowSyoriTantouId(tmpBean.getCurrentAccountId());

                bean.setNowTaskNm(tmpCurrentTaskId);

                bean.setDispNowTaskNm(taskNmMap.get(tmpJimutetuzukiCurrentTask));

                bean.setSyouhinCd(tmpBean.getExtparamBean().getExtparam3());

                if (!BizUtil.isBlank(bean.getPreSyoriTantouId())) {

                    if (accountNmMap.size() <= 0 ||
                        !accountNmMap.containsKey(bean.getPreSyoriTantouId())) {

                        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                        AM_User userInfo = baseDomManager.getUser(bean.getPreSyoriTantouId());
                        if (userInfo == null) {
                            accountNmMap.put(bean.getPreSyoriTantouId(), null);
                        } else {
                            accountNmMap.put(bean.getPreSyoriTantouId(), userInfo.getUserNm());
                        }
                    }

                    bean.setDispPreSyoriTantouNm(accountNmMap.get(bean.getPreSyoriTantouId()));
                }

                if (!BizUtil.isBlank(bean.getNowSyoriTantouId())) {

                    if (accountNmMap.size() <= 0 ||
                        !accountNmMap.containsKey(bean.getNowSyoriTantouId())) {

                        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                        AM_User userInfo = baseDomManager.getUser(bean.getNowSyoriTantouId());
                        if (userInfo == null) {
                            accountNmMap.put(bean.getNowSyoriTantouId(), null);
                        } else {
                            accountNmMap.put(bean.getNowSyoriTantouId(), userInfo.getUserNm());
                        }
                    }

                    bean.setDispNowSyoriTantouNm(accountNmMap.get(bean.getNowSyoriTantouId()));
                }

                WorkflowWariateInfoFilter wariateInfoFilter = new WorkflowWariateInfoFilter();
                wariateInfoFilter.setTargetGyoumuKey(tmpBean.getGyoumukey());
                wariateInfoFilter.setTargetFlowNm(tmpBean.getFlowId());
                wariateInfoFilter.setTargetNodeNm(tmpBean.getCurrentNodeName());
                List<BT_WariateHukaInfo> filteredList = ImmutableList.copyOf(Iterables.filter(wariateList,
                    wariateInfoFilter));
                if (filteredList == null ||
                    filteredList.size() <= 0) {
                    bean.setNyuuryokuKahi(true);
                } else {
                    bean.setNyuuryokuKahi(false);
                }

                beanList.add(bean);
            }
        }

        Ordering<TaskSummaryForWorkListBean> ordering = Ordering.from(new WorkflowTasksForWorkListBeanSortComparator());
        wkBeanList = ordering.sortedCopy(beanList);

        resultBean.setTaskSummaryForWorkListBeanList(wkBeanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;

    }

    public static GetTasksForJimuyouCdResultBean getTasksForJimuyouCd(
        String[] pMosNo,
        String[] pSyoNo,
        String[] pNkSysyNo,
        String[] pJimutetuzukiCd) {

        GetTasksForJimuyouCdResultBean resultBean = new GetTasksForJimuyouCdResultBean();
        List<TaskSummaryForJimuyouCdBean> beanList = new ArrayList<TaskSummaryForJimuyouCdBean>();
        TaskSummaryForJimuyouCdBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        int paramCount = 0;
        String paramMode = null;
        if (pMosNo != null && pMosNo.length > 0) {
            paramCount = pMosNo.length;
            paramMode = "pMosNo";
        } else if (pSyoNo != null && pSyoNo.length > 0) {
            paramCount = pSyoNo.length;
            paramMode = "pSyoNo";
        } else if (pNkSysyNo != null && pNkSysyNo.length > 0) {
            paramCount = pNkSysyNo.length;
            paramMode = "pNkSysyNo";
        }

        for (int i = 0; i < paramCount; i++) {
            GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();
            WSExtParam wSExtParam = new WSExtParam();

            inBean.setSyoristatus(new String[] { WorkFlowUtilityConstants.SYORI_STATUS_SYORITYU });

            if ("pSyoNo".equals(paramMode)) {
                wSExtParam.setValues(pSyoNo[i]);
                inBean.setExtParam12(wSExtParam);
            } else if ("pMosNo".equals(paramMode)) {
                wSExtParam.setValues(pMosNo[i]);
                inBean.setExtParam14(wSExtParam);
            } else if ("pNkSysyNo".equals(paramMode)) {
                wSExtParam.setValues(pNkSysyNo[i]);
                inBean.setExtParam13(wSExtParam);
            }

            if (pJimutetuzukiCd != null &&
                pJimutetuzukiCd.length > 0) {
                if (pJimutetuzukiCd.length == 1) {
                    inBean.setFlowid(pJimutetuzukiCd[0]);
                } else {
                    inBean.setFlowids(pJimutetuzukiCd);
                }
            }

            GetProcessSummaryOutBean outBean = iwfKouteiClient.execGetProcessSummary(inBean);
            resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(outBean.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
                return resultBean;
            }

            if (outBean.getProcessSummaryBeanList() != null &&
                outBean.getProcessSummaryBeanList().size() > 0) {
                for (ProcessSummaryBean processSummaryBean : outBean.getProcessSummaryBeanList()) {

                    bean = new TaskSummaryForJimuyouCdBean();

                    GetLockInfoResultBean lockResult = WorkFlowUtility.getLockInfo(processSummaryBean.getGyoumukey());

                    if (WorkFlowResultConstants.RESULT_LOCK.equals(lockResult.getSyorikekkaStatus())) {

                        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);
                        resultBean.getLockGyoumuKeyBean().setMosNo(processSummaryBean.getExtparamBean().getExtparam14());
                        resultBean.getLockGyoumuKeyBean().setSyoNo(processSummaryBean.getExtparamBean().getExtparam12());
                        resultBean.getLockGyoumuKeyBean().setNkSysyNo(processSummaryBean.getExtparamBean().getExtparam13());
                        return resultBean;
                    }

                    bean.setMosNo(processSummaryBean.getExtparamBean().getExtparam14());
                    bean.setSyoNo(processSummaryBean.getExtparamBean().getExtparam12());
                    bean.setNkSysyNo(processSummaryBean.getExtparamBean().getExtparam13());
                    bean.setKouteiKnrId(processSummaryBean.getGyoumukey());
                    bean.setKouteiStatus(processSummaryBean.getProcessstatus());
                    bean.setDispKouteiStatus(C_Kouteikanristatus.getContentByValue(processSummaryBean
                        .getProcessstatus()));
                    bean.setJimuyouCd(processSummaryBean.getExtparamBean().getExtparam7());

                    beanList.add(bean);
                }
            }
        }

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        resultBean.setTaskSummaryForJimuyouCdBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static CancelProcessResultBean cancelProcess(String pKouteiKnrId, String pJimutetuzukiCd, String pUserId,
        String pComment) {

        CancelProcessResultBean resultBean = new CancelProcessResultBean();

        UniqueKeyGenerator uid = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        String lockKey = uid.generateUniqueKey();

        LockProcessInBean lockProcessInBean = new LockProcessInBean();
        lockProcessInBean.setGyoumukey(pKouteiKnrId);
        lockProcessInBean.setFlowid(pJimutetuzukiCd);
        lockProcessInBean.setLockkey(lockKey);

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        WSLockProcessResponse lockProcessOutBean = iwfKouteiClient.execLockProcess(lockProcessInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(lockProcessOutBean.getKekkastatus())) {

            if ("IWF2091".equals(lockProcessOutBean.getSyousaimsgcd())) {

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);
            }
            else {

                resultBean.setSyorikekkaStatus(lockProcessOutBean.getKekkastatus());
            }

            resultBean.setSyousaiMessageCd(lockProcessOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(lockProcessOutBean.getSyousaimsg());
            resultBean.setErrorApiName("LockProcess");

            return resultBean;
        }

        ProcessCancelInBean processCancelInBean = new ProcessCancelInBean();
        processCancelInBean.setGyoumukey(pKouteiKnrId);
        processCancelInBean.setFlowid(pJimutetuzukiCd);
        processCancelInBean.setAccountid(pUserId);
        processCancelInBean.setLockkey(lockKey);

        WSExecProcessCancelResponse processCancelOutBean = iwfKouteiClient.execProcessCancel(processCancelInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(processCancelOutBean.getKekkastatus())) {

            resultBean.setSyorikekkaStatus(processCancelOutBean.getKekkastatus());
            resultBean.setSyousaiMessageCd(processCancelOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(processCancelOutBean.getSyousaimsg());
            resultBean.setErrorApiName("ProcessCancel");

            UnlockProcessInBean unlockProcessInBean = new UnlockProcessInBean();
            unlockProcessInBean.setGyoumukey(pKouteiKnrId);
            unlockProcessInBean.setFlowid(pJimutetuzukiCd);
            unlockProcessInBean.setLockkey(lockKey);

            iwfKouteiClient.execUnlockProcess(unlockProcessInBean);

            return resultBean;
        }

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(pKouteiKnrId);
        createProcessRecordInBean.setFlowid(pJimutetuzukiCd);
        createProcessRecordInBean.setAccountid(pUserId);
        createProcessRecordInBean.setRirekimsg(pComment);
        createProcessRecordInBean.setTaskname("工程取消");

        WSCreateProcessRecordResponse createProcessRecordOutBean = iwfKouteiClient
            .execCcreateProcessRecord(createProcessRecordInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(createProcessRecordOutBean.getKekkastatus())) {

            resultBean.setSyorikekkaStatus(createProcessRecordOutBean.getKekkastatus());
            resultBean.setSyousaiMessageCd(createProcessRecordOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(createProcessRecordOutBean.getSyousaimsg());
            resultBean.setErrorApiName("CreateProcessRecord");
        }

        if (Strings.isNullOrEmpty(resultBean.getErrorApiName())) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        }

        return resultBean;
    }

    public static GetProcessHistoryResultBean getProcessHistory(String pKouteiKnrId, String pJimutetuzukiCd) {

        final GetProcessHistoryResultBean resultBean = new GetProcessHistoryResultBean();
        final List<ProcessHistoryBean> beanList = new ArrayList<ProcessHistoryBean>();
        ProcessHistoryBean bean;

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);
        GetProcessRecordInBean kouteiInBean = new GetProcessRecordInBean();
        GetProcessRecordOutBean kouteiOutBean;

        Map<String, String> accountNmMap = new HashMap<String, String>();

        if (!Strings.isNullOrEmpty(pKouteiKnrId)) {
            kouteiInBean.setGyoumukey(pKouteiKnrId);
        }
        if (!Strings.isNullOrEmpty(pJimutetuzukiCd)) {
            kouteiInBean.setFlowid(pJimutetuzukiCd);
        }
        kouteiInBean.setRirekikbn(WorkFlowUtilityConstants.GYOUMU_RIREKI);

        kouteiOutBean = iwfKouteiClient.execGetProcessRecord(kouteiInBean);

        resultBean.setSyousaiMessage(kouteiOutBean.getSyousaimsg());
        resultBean.setSyousaiMessageCd(kouteiOutBean.getSyousaimsgcd());

        if (!WorkFlowResultConstants.RESULT_OK.equals(kouteiOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(kouteiOutBean.getKekkastatus());
            return resultBean;
        }
        if (kouteiOutBean.getProcessRecordBeanList().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        if (kouteiOutBean.getProcessRecordBeanList() != null &&
            kouteiOutBean.getProcessRecordBeanList().size() > 0) {

            for (int i = 0; i < kouteiOutBean.getProcessRecordBeanList().size(); i++) {
                ProcessRecordBean processBean = kouteiOutBean.getProcessRecordBeanList().get(i);
                bean = new ProcessHistoryBean();

                bean.setProcessYmdTime(processBean.getSyoriTime());
                bean.setTaskNm(processBean.getNodeName());
                bean.setDispTaskNm(processBean.getNodeLocalName());

                bean.setProcessResult("0");
                if (processBean.getExtinfo() != null) {
                    List<Map<String, String>> hukaInfo = processBean.getExtinfo();
                    for (int y = 0; y < hukaInfo.size(); y++) {
                        if (hukaInfo.get(y).containsKey(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN)) {
                            bean.setProcessResult(hukaInfo.get(y).get(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN));
                        }
                    }
                }
                bean.setTantouId(processBean.getAccountId());
                bean.setHistoryMessage(processBean.getRirekiMessage());

                if (accountNmMap.size() == 0 || !accountNmMap.containsKey(processBean.getAccountId())) {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(processBean.getAccountId());
                    if (userInfo == null) {
                        accountNmMap.put(processBean.getAccountId(), null);
                    } else {
                        accountNmMap.put(processBean.getAccountId(), userInfo.getUserNm());
                    }
                }
                bean.setTantouNm(accountNmMap.get(processBean.getAccountId()));

                beanList.add(bean);
            }
        }
        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        Ordering<ProcessHistoryBean> ordering = Ordering
            .from(new WorkflowProcessHistoryBeanSortComparator());
        List<ProcessHistoryBean> sortedList = ordering.sortedCopy(beanList);

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        resultBean.setProcessHistoryBeanList(sortedList);

        return resultBean;
    }

    public static GetTorikomiSyoruiMstResultBean getTorikomiSyoruiMst(String[] pJimutetuzukiCd) {
        GetTorikomiSyoruiMstResultBean resultBean = new GetTorikomiSyoruiMstResultBean();
        List<TorikomiSyoruiMstBean> beanList = new ArrayList<TorikomiSyoruiMstBean>();
        TorikomiSyoruiMstBean bean;

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        GetTorikomiSyoruiMstInBean getSyoruiMstInBean;
        WSGetTorikomiSyoruiMstResponse syoruiMstResponse;

        Map<String, DM_JimutetuzukiTask> taskNmMap = Maps.newHashMap();
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DM_Jimutetuzuki> jimuList = Lists.newArrayList();
        jimuList = workflowDomManager.getAllJimutetuzuki();
        for (DM_Jimutetuzuki jimuTetuduki : jimuList) {
            for (DM_JimutetuzukiTask task : jimuTetuduki.getJimutetuzukiTasks()) {
                taskNmMap.put(task.getJimutetuzukicd() + "." + task.getWorkflowTskId(), task);
            }
        }

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfo;
        torikomiSyoruiHukaInfo = bizDomManager.getAllTorikomiSyoruiHukaInfo();

        Map<String, String> torikomiSyoruiSubsystemMap = new HashMap<String, String>();

        Map<String, C_SyoruiTorikomiHouKbn> syoruitorikomihoukbnMap = new HashMap<String, C_SyoruiTorikomiHouKbn>();

        Map<String, Integer> torikomiSyoruisortNoMap = new HashMap<String, Integer>();

        if (torikomiSyoruiHukaInfo != null && torikomiSyoruiHukaInfo.size() > 0) {
            for (BM_TorikomiSyoruiHukaInfo hukaInfo : torikomiSyoruiHukaInfo) {
                torikomiSyoruiSubsystemMap.put(hukaInfo.getSyoruiCd().getValue(), hukaInfo.getSubSystemId());
                syoruitorikomihoukbnMap.put(hukaInfo.getSyoruiCd().getValue(), hukaInfo.getSyoruitorikomihoukbn());
                torikomiSyoruisortNoMap.put(hukaInfo.getSyoruiCd().getValue(), hukaInfo.getSortNo());
            }
        }
        else {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<String> wkJimuList = Lists.newArrayList();
        if (pJimutetuzukiCd != null) {
            if (pJimutetuzukiCd.length == 0) {
                for(int i = 0; i < jimuList.size(); i++){
                    wkJimuList.add(jimuList.get(i).getJimutetuzukicd());
                }
            } else {
                for(int i = 0; i < pJimutetuzukiCd.length; i++){
                    wkJimuList.add(pJimutetuzukiCd[i]);
                }
            }
        } else {
            for(int i = 0; i < jimuList.size(); i++){
                wkJimuList.add(jimuList.get(i).getJimutetuzukicd());
            }
        }

        List<TorikomiSyoruiMstSortBean> sortBeanList = new ArrayList<TorikomiSyoruiMstSortBean>();

        for (int i = 0; i < wkJimuList.size(); i++) {
            getSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();
            getSyoruiMstInBean.setFlowid(wkJimuList.get(i));

            syoruiMstResponse = iwfImageClient.execGetTorikomiSyoruiMst(getSyoruiMstInBean);

            resultBean.setSyousaiMessage(syoruiMstResponse.getSyousaimsg());
            resultBean.setSyousaiMessageCd(syoruiMstResponse.getSyousaimsgcd());

            if (!WorkFlowResultConstants.RESULT_OK.equals(syoruiMstResponse.getKekkastatus())) {
                if (syoruiMstResponse.getSyousaimsgcd().equals("IWF9004")) {
                    continue;
                }
                resultBean.setSyorikekkaStatus(syoruiMstResponse.getKekkastatus());
                return resultBean;
            }

            if (syoruiMstResponse.getTorikomisyoruilist().size() > 0) {

                TorikomiSyoruiMstSortBean torikomiSyoruiMstSortBean;

                for(TorikomiSyoruiBean syoruiBean : syoruiMstResponse.getTorikomisyoruilist()){
                    torikomiSyoruiMstSortBean = new TorikomiSyoruiMstSortBean();
                    torikomiSyoruiMstSortBean.setSyoruiCd(syoruiBean.getTorikomisyoruicd());
                    torikomiSyoruiMstSortBean.setSyoruiNm(syoruiBean.getTorikomisyoruinm());
                    torikomiSyoruiMstSortBean.setSyoruiRyakuNm(syoruiBean.getTorikomisyoruiryaku());
                    torikomiSyoruiMstSortBean.setSyzkDaiBunruiId(syoruiBean.getSyzkdaibunruiid());
                    torikomiSyoruiMstSortBean.setSyzkSyouBunruiId(syoruiBean.getSyzksyoubunruiid());
                    torikomiSyoruiMstSortBean.setZipHozonKbn(syoruiBean.getZiphozonkbn());
                    torikomiSyoruiMstSortBean.setKouteiSeigyoUmuKbn(syoruiBean.getKouteiseigyoumukbn());
                    torikomiSyoruiMstSortBean.setFlowId(syoruiBean.getFlowid());
                    torikomiSyoruiMstSortBean.setNodeId(syoruiBean.getNodeid());
                    if (torikomiSyoruisortNoMap.containsKey(torikomiSyoruiMstSortBean.getSyoruiCd())) {
                        torikomiSyoruiMstSortBean.setSortNo(torikomiSyoruisortNoMap.get(torikomiSyoruiMstSortBean.getSyoruiCd()));
                    }
                    sortBeanList.add(torikomiSyoruiMstSortBean);
                }
            }
        }

        Ordering<TorikomiSyoruiMstSortBean> ordering = Ordering.from(new WorkflowTorikomiSyoruiMstSortBeanSortComparator());
        List<TorikomiSyoruiMstSortBean> sortedList = ordering.sortedCopy(sortBeanList);

        for(TorikomiSyoruiMstSortBean torikomiSyoruiMstSortBean : sortedList) {
            bean = new TorikomiSyoruiMstBean();
            bean.setJimutetuzukiCd(torikomiSyoruiMstSortBean.getFlowId());
            bean.setSyoruiCd(torikomiSyoruiMstSortBean.getSyoruiCd());
            bean.setSyoruiNm(torikomiSyoruiMstSortBean.getSyoruiNm());
            bean.setSyoruiRyakuNm(torikomiSyoruiMstSortBean.getSyoruiRyakuNm());
            bean.setSyzkSyouBunruiId(torikomiSyoruiMstSortBean.getSyzkSyouBunruiId());
            bean.setSyzkDaiBunruiId(torikomiSyoruiMstSortBean.getSyzkDaiBunruiId());
            bean.setZipHozonKbn(torikomiSyoruiMstSortBean.getZipHozonKbn());
            bean.setKouteiSeigyoUmuKbn(torikomiSyoruiMstSortBean.getKouteiSeigyoUmuKbn());
            if (taskNmMap.containsKey(bean.getJimutetuzukiCd() + "." + torikomiSyoruiMstSortBean.getNodeId())) {
                bean.setTaskNm(taskNmMap.get(bean.getJimutetuzukiCd() + "." + torikomiSyoruiMstSortBean.getNodeId())
                    .getWorkflowTskNm());
            }
            if(torikomiSyoruiSubsystemMap.containsKey(bean.getSyoruiCd())){
                bean.setSubsystemId(torikomiSyoruiSubsystemMap.get(bean.getSyoruiCd()));
            }
            if(syoruitorikomihoukbnMap.containsKey(bean.getSyoruiCd())){
                bean.setSyoruitorikomihoukbn(syoruitorikomihoukbnMap.get(bean.getSyoruiCd()));
            }

            beanList.add(bean);
        }

        resultBean.setTorikomiSyoruiMstBeanList(beanList);

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetImagePropsListResultBean getImagePropsList(
        String pSubsystemId,
        String pUserId,
        String[] pJimutetuzukiCd,
        String pMosNo,
        String pSyoNo,
        String pNkSysyNo,
        String pSyoruiCd,
        String pToutyakuYmdTimeFrom,
        String pToutyakuYmdTimeTo,
        String pKouteiStatus) {

        GetImagePropsListResultBean resultBean = new GetImagePropsListResultBean();
        List<ImagePropsBean> beanList = new ArrayList<ImagePropsBean>();
        ImagePropsBean bean;

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps.WSGetKouteiSiteiImagePropsResponse.ImagePropsBean imageProp;
        GetTorikomiSyoruiMstInBean getSyoruiMstInBean;
        WSGetTorikomiSyoruiMstResponse syoruiMstResponse;
        GetKouteiSiteiImagePropsInBean getKouteiSiteiImagePropsInBean = new GetKouteiSiteiImagePropsInBean();
        GetKouteiSiteiImagePropsOutBean outBean;

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo;
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DM_Jimutetuzuki> jimuMst = new ArrayList<>();

        WSExtParam extParam = new WSExtParam();

        Map<String, WSExtParam> extParamMap = new HashMap<String, WSExtParam>();
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM1, extParam);

        Map<String, String> jimutetuzukiNmMap = new HashMap<String, String>();
        Map<String, String> syoruiNmMap = new HashMap<String, String>();
        Map<String, String> accountNmMap = new HashMap<String, String>();
        Map<String, String> syoruiTorikomiHouMap = new HashMap<String, String>();

        getKouteiSiteiImagePropsInBean.setKekkajyougenkensu("1000");

        if (!BizUtil.isBlank(pUserId)) {

            getKouteiSiteiImagePropsInBean.setAccountid(pUserId);
        }

        if (pJimutetuzukiCd == null) {

            jimuMst = workflowDomManager.getAllJimutetuzuki();
        }
        else {

            jimuMst = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds(
                pSubsystemId,
                pJimutetuzukiCd);

            String[] jimutetuzukiCd = new String[jimuMst.size()];

            for (int i = 0; i < jimuMst.size(); i++) {

                jimutetuzukiCd[i] = jimuMst.get(i).getJimutetuzukicd();
            }

            getKouteiSiteiImagePropsInBean.setFlowids(jimutetuzukiCd);
        }

        if (!BizUtil.isBlank(pSyoruiCd)) {

            getKouteiSiteiImagePropsInBean.setTorikomisyoruicd(pSyoruiCd);
        }

        if (!BizUtil.isBlank(pToutyakuYmdTimeFrom)) {

            getKouteiSiteiImagePropsInBean.setSyoruitoutyakuymdfrom(pToutyakuYmdTimeFrom);
        }

        if (BizUtil.isBlank(pToutyakuYmdTimeFrom) && !BizUtil.isBlank(pToutyakuYmdTimeTo)) {

            getKouteiSiteiImagePropsInBean.setSyoruitoutyakuymdfrom("19700101000000000");
        }

        if (!BizUtil.isBlank(pToutyakuYmdTimeTo)) {

            getKouteiSiteiImagePropsInBean.setSyoruitoutyakuymdto(pToutyakuYmdTimeTo);
        }

        if (BizUtil.isBlank(pToutyakuYmdTimeTo) && !BizUtil.isBlank(pToutyakuYmdTimeFrom)) {

            getKouteiSiteiImagePropsInBean.setSyoruitoutyakuymdto("99991231235959999");
        }

        if (!BizUtil.isBlank(pMosNo)) {

            extParam = new WSExtParam();
            extParam.setValues(pMosNo);
            extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM14, extParam);
            getKouteiSiteiImagePropsInBean.setExtParam14(extParam);
        }

        if (!Strings.isNullOrEmpty(pSyoNo)) {
            extParam = new WSExtParam();
            extParam.setValues(pSyoNo);
            extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM12, extParam);
            getKouteiSiteiImagePropsInBean.setExtParam12(extParam);
        }

        if (!Strings.isNullOrEmpty(pNkSysyNo)) {
            extParam = new WSExtParam();
            extParam.setValues(pNkSysyNo);
            extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM13, extParam);
            getKouteiSiteiImagePropsInBean.setExtParam13(extParam);
        }

        if (!Strings.isNullOrEmpty(pKouteiStatus)) {
            getKouteiSiteiImagePropsInBean.setSyoristatus(new String[] { pKouteiStatus });
        }

        outBean = iwfImageClient.GetKouteiSiteiImageProps(getKouteiSiteiImagePropsInBean);

        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus()) &&
            !outBean.getSyousaimsgcd().equals("IWF9004")) {
            resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
            return resultBean;
        }

        if (outBean.getImagepropslist() != null &&
            outBean.getImagepropslist().size() > 0) {
            for (int j = 0; j < outBean.getImagepropslist().size(); j++) {
                imageProp = outBean.getImagepropslist().get(j);
                bean = new ImagePropsBean();
                bean.setJimutetuzukiCd(imageProp.getFlowid());
                bean.setImageId(imageProp.getImageid());
                bean.setMosNo(imageProp.getExtparamBean().getExtparam14());
                bean.setSyoNo(imageProp.getExtparamBean().getExtparam12());
                bean.setNkSysyNo(imageProp.getExtparamBean().getExtparam13());
                bean.setTorikomiSyoruiCd(imageProp.getTorikomisyoruicd());
                bean.setSyoruiTtykYmdTime(imageProp.getSyoruitoutyakutime());
                bean.setKouteiStatus(imageProp.getKouteijyoutai());
                bean.setDispKouteiStatus(C_Kouteikanristatus.getContentByValue(imageProp.getKouteijyoutai()));
                bean.setKengenUmu(imageProp.getKengenumu());

                if (!jimutetuzukiNmMap.containsKey(bean.getJimutetuzukiCd())) {
                    WorkflowJimutetuzukiFilter jimutetuzukiFilter = new WorkflowJimutetuzukiFilter();
                    jimutetuzukiFilter.setTargetJimutetuzukiCd(bean.getJimutetuzukiCd());
                    List<DM_Jimutetuzuki> filteredList = ImmutableList.copyOf(Iterables.filter(jimuMst,
                        jimutetuzukiFilter));
                    if (filteredList.size() > 0) {
                        jimutetuzukiNmMap.put(bean.getJimutetuzukiCd(), filteredList.get(0).getJimutetuzukinm());
                    } else {
                        jimutetuzukiNmMap.put(bean.getJimutetuzukiCd(), null);
                    }
                }

                bean.setJimutetuzukiNm(jimutetuzukiNmMap.get(bean.getJimutetuzukiCd()));

                if (syoruiNmMap.size() == 0 || !syoruiNmMap.containsKey(bean.getTorikomiSyoruiCd())) {
                    getSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();
                    getSyoruiMstInBean.setTorikomisyoruicd(bean.getTorikomiSyoruiCd());
                    syoruiMstResponse = iwfImageClient.execGetTorikomiSyoruiMst(getSyoruiMstInBean);
                    if (WorkFlowResultConstants.RESULT_OK.equals(syoruiMstResponse.getKekkastatus()) &&
                        syoruiMstResponse.getTorikomisyoruilist() != null &&
                        syoruiMstResponse.getTorikomisyoruilist().size() > 0) {
                        syoruiNmMap.put(bean.getTorikomiSyoruiCd(), syoruiMstResponse.getTorikomisyoruilist()
                            .get(0).getTorikomisyoruinm());
                    } else {
                        syoruiNmMap.put(bean.getTorikomiSyoruiCd(), null);
                    }
                }
                bean.setDispTorikomiSyoruiNm(syoruiNmMap.get(bean.getTorikomiSyoruiCd()));

                if (accountNmMap.size() == 0 || !accountNmMap.containsKey(imageProp.getTourokuaccountid())) {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(imageProp.getTourokuaccountid());
                    if (userInfo == null) {
                        accountNmMap.put(imageProp.getTourokuaccountid(), null);
                    } else {
                        accountNmMap.put(imageProp.getTourokuaccountid(), userInfo.getUserNm());
                    }
                }
                bean.setTourokuUserNm(accountNmMap.get(imageProp.getTourokuaccountid()));

                if (syoruiTorikomiHouMap.size() == 0
                    || !syoruiTorikomiHouMap.containsKey(bean.getTorikomiSyoruiCd())) {
                    if (!Strings.isNullOrEmpty(C_SyoruiCdKbn.getContentByValue(bean.getTorikomiSyoruiCd()))) {
                        torikomiSyoruiHukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.valueOf(bean
                            .getTorikomiSyoruiCd()));
                        if (torikomiSyoruiHukaInfo != null) {
                            syoruiTorikomiHouMap.put(bean.getTorikomiSyoruiCd(), torikomiSyoruiHukaInfo
                                .getSyoruitorikomihoukbn().getValue());
                        } else {
                            syoruiTorikomiHouMap.put(bean.getTorikomiSyoruiCd(), null);
                        }
                    }
                }
                bean.setSyoruiTorikomiHouKbn(syoruiTorikomiHouMap.get(bean.getTorikomiSyoruiCd()));
                beanList.add(bean);
            }
        }

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        if (beanList.size() > 0) {
            Ordering<ImagePropsBean> ordering = Ordering.from(new WorkflowImagePropsBeanSortComparator());
            List<ImagePropsBean> sortedList = ordering.sortedCopy(beanList);
            resultBean.setImagePropsBeanList(sortedList);
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        }

        return resultBean;
    }

    public static GetImageInfoListResultBean getImage(String pImageId, String pUserId) {
        GetImageInfoListResultBean resultBean = new GetImageInfoListResultBean();
        ImageInfoBean bean = new ImageInfoBean();
        List<ImageInfoBean> beanList = new ArrayList<ImageInfoBean>();

        GetImageInBean inBean = new GetImageInBean();
        inBean.setImageids(new String[] { pImageId });
        inBean.setAccountid(pUserId);

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        WSGetImageByIdResponse outBean = iwfImageClient.execGetImage(inBean);

        resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(outBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
            return resultBean;
        }

        if (outBean.getImageinfolist().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        if (outBean.getImageinfolist() != null &&
            outBean.getImageinfolist().size() > 0) {
            yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse.ImageInfoBean imageInfoBean = outBean
                .getImageinfolist().get(0);
            bean.setImageid(imageInfoBean.getImageid());
            bean.setMosNo(null);
            bean.setSyoNo(null);
            bean.setNkSysyNo(null);
            bean.setTorikomisyoruicd(imageInfoBean.getTorikomisyoruicd());
            bean.setSyoruittykymdtime(imageInfoBean.getSyoruitoutyakutime());
            bean.setKengenumu(imageInfoBean.getKengenumu());
            bean.setPdfImage(imageInfoBean.getPdfimage());

            GetProcessSummaryInBean kouteiInBean = new GetProcessSummaryInBean();
            kouteiInBean.setGyoumukey(imageInfoBean.getGyoumukey());

            IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);
            GetProcessSummaryOutBean kouteiOutBean = iwfKouteiClient.execGetProcessSummary(kouteiInBean);

            if (WorkFlowResultConstants.RESULT_OK.equals(kouteiOutBean.getKekkastatus()) &&
                kouteiOutBean.getProcessSummaryBeanList() != null &&
                kouteiOutBean.getProcessSummaryBeanList().size() > 0) {
                bean.setMosNo(kouteiOutBean.getProcessSummaryBeanList().get(0).getExtparamBean().getExtparam14());
                bean.setSyoNo(kouteiOutBean.getProcessSummaryBeanList().get(0).getExtparamBean().getExtparam12());
                bean.setNkSysyNo(kouteiOutBean.getProcessSummaryBeanList().get(0).getExtparamBean().getExtparam13());
            }

            beanList.add(bean);
            resultBean.setImageInfoBeanList(beanList);

            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
            return resultBean;
        }

        return resultBean;
    }

    public static PutImageResultBean putImage(
        String pTorikomiSyoruiCd,
        String pUserId,
        String pJimutetuzukiCd,
        byte[] pImage,
        String pKouteiKnrId,
        String pToutyakuYmdTime,
        String pTourokuYmdTime,
        String pRyouikiSakuseiUmu) {

        PutImageResultBean resultBean = new PutImageResultBean();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        final String sysDateTimeString = sdf.format(date);

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);

        if (C_UmuKbn.ARI.getValue().equals(pRyouikiSakuseiUmu)) {
            CreateImageSpaceInBean createSpaceInBean = new CreateImageSpaceInBean();
            createSpaceInBean.setGyoumukey(pKouteiKnrId);
            createSpaceInBean.setAccountid(pUserId);

            WSExecProcessCreateResponse createSpaceOutBean = iwfImageClient.execCreateImageSpace(createSpaceInBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(createSpaceOutBean.getKekkastatus())) {
                resultBean.setSyousaiMessageCd(createSpaceOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(createSpaceOutBean.getSyousaimsg());
                resultBean.setSyorikekkaStatus(createSpaceOutBean.getKekkastatus());
                return resultBean;
            }
        }

        PutImageInBean putImageInBean = new PutImageInBean();
        putImageInBean.setSyoruicd(pTorikomiSyoruiCd);
        putImageInBean.setAccountid(pUserId);
        putImageInBean.setFlowid(pJimutetuzukiCd);
        putImageInBean.setImagedata(pImage);
        putImageInBean.setGyoumukey(pKouteiKnrId);
        if (!Strings.isNullOrEmpty(pToutyakuYmdTime)) {
            putImageInBean.setSyoruitoutyakutime(pToutyakuYmdTime);
        } else {
            putImageInBean.setSyoruitoutyakutime(sysDateTimeString);
        }
        if (!Strings.isNullOrEmpty(pTourokuYmdTime)) {
            putImageInBean.setTourokutime(pTourokuYmdTime);
        } else {
            putImageInBean.setTourokutime(sysDateTimeString);
        }

        WSPutImageResponse wSPutImageResponse = iwfImageClient.execPutImage(putImageInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(wSPutImageResponse.getKekkastatus())) {
            resultBean.setSyousaiMessageCd(wSPutImageResponse.getSyousaimsgcd());
            resultBean.setSyousaiMessage(wSPutImageResponse.getSyousaimsg());
            resultBean.setSyorikekkaStatus(wSPutImageResponse.getKekkastatus());

            if (C_UmuKbn.ARI.getValue().equals(pRyouikiSakuseiUmu)) {
                DeleteImageSpaceInBean deleteImageSpaceInBean = new DeleteImageSpaceInBean();
                deleteImageSpaceInBean.setGyoumukey(pKouteiKnrId);
                deleteImageSpaceInBean.setAccountid(pUserId);

                iwfImageClient.execDeleteImageSpace(deleteImageSpaceInBean);
            }
            return resultBean;
        }
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static DropImageResultBean dropImage(String pImageId, String pUserId) {

        DropImageResultBean resultBean = new DropImageResultBean();

        DropImageInBean dropImageInBean = new DropImageInBean();
        dropImageInBean.setImageids(new String[] { pImageId });
        dropImageInBean.setAccountid(pUserId);

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        WSDropImageByIdResponse wSDropImageByIdResponse = iwfImageClient.execDropImage(dropImageInBean);

        resultBean.setSyousaiMessageCd(wSDropImageByIdResponse.getSyousaimsgcd());
        resultBean.setSyousaiMessage(wSDropImageByIdResponse.getSyousaimsg());
        resultBean.setSyorikekkaStatus(wSDropImageByIdResponse.getKekkastatus());

        return resultBean;
    }

    public static CreateProcessIkkatuResultBean createProcessIkkatu(List<CreateProcessIkkatuInBean> pInBeanList) {
        CreateProcessIkkatuResultBean resultBean = new CreateProcessIkkatuResultBean();


        return resultBean;
    }

    public static GetSyoruiKengenResultBean getSyoruiKengen(String pRollCd, String[] pJimutetuzukiCd, String pUserId) {

        GetSyoruiKengenResultBean resultBean = new GetSyoruiKengenResultBean();
        List<SyoruiKengenBean> beanList = new ArrayList<SyoruiKengenBean>();
        SyoruiKengenBean bean;

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        GetTorikomiSyoruiMstInBean getSyoruiMstInBean;
        ArrayList<TorikomiSyoruiBean> wkTorikomiSyorui = new ArrayList<TorikomiSyoruiBean>();

        IwfAccountClient iwfAccountClient = SWAKInjector.getInstance(IwfAccountClient.class);
        GetImageAuthorityInBean getImageAuthorityInBean = new GetImageAuthorityInBean();
        WSGetImageAuthorityResponse getImageAuthorityResponse = new WSGetImageAuthorityResponse();

        for (String jimutetuzukiCd : pJimutetuzukiCd) {
            getSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();
            getSyoruiMstInBean.setFlowid(jimutetuzukiCd);

            WSGetTorikomiSyoruiMstResponse torikomiSyoruiMstResponse = iwfImageClient
                .execGetTorikomiSyoruiMst(getSyoruiMstInBean);
            resultBean.setSyousaiMessageCd(torikomiSyoruiMstResponse.getSyousaimsgcd());
            resultBean.setSyousaiMessage(torikomiSyoruiMstResponse.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(torikomiSyoruiMstResponse.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(torikomiSyoruiMstResponse.getKekkastatus());
                return resultBean;
            }

            if (torikomiSyoruiMstResponse.getTorikomisyoruilist() != null &&
                torikomiSyoruiMstResponse.getTorikomisyoruilist().size() > 0) {
                Ordering<TorikomiSyoruiBean> ordering = Ordering.from(new WorkflowTorikomiSyoruiBeanSortComparator());
                List<TorikomiSyoruiBean> sortedList = ordering.sortedCopy(torikomiSyoruiMstResponse
                    .getTorikomisyoruilist());
                wkTorikomiSyorui.addAll(sortedList);
            }
        }

        if (wkTorikomiSyorui.size() > 0) {
            getImageAuthorityInBean.setImageauthid(pRollCd);
            getImageAuthorityResponse = iwfAccountClient.execGetImageAuthority(getImageAuthorityInBean);

            resultBean.setSyousaiMessageCd(getImageAuthorityResponse.getSyousaimsgcd());
            resultBean.setSyousaiMessage(getImageAuthorityResponse.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(getImageAuthorityResponse.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(getImageAuthorityResponse.getKekkastatus());
                return resultBean;
            }
        }

        List<String> syoruiCds = new ArrayList<String>();
        if (getImageAuthorityResponse.getTorikomiSyoruiCds() != null &&
            getImageAuthorityResponse.getTorikomiSyoruiCds().length > 0) {
            for (int i = 0; i < getImageAuthorityResponse.getTorikomiSyoruiCds().length; i++) {
                syoruiCds.add(getImageAuthorityResponse.getTorikomiSyoruiCds()[i]);
            }
        }

        for (TorikomiSyoruiBean torikomiSyorui : wkTorikomiSyorui) {
            bean = new SyoruiKengenBean();
            bean.setJimutetuzukiCd(torikomiSyorui.getFlowid());
            bean.setSyoruiCd(torikomiSyorui.getTorikomisyoruicd());
            bean.setSyoruiNm(torikomiSyorui.getTorikomisyoruinm());
            if (syoruiCds.contains(torikomiSyorui.getTorikomisyoruicd())) {
                bean.setKengenFlg("1");
            } else {
                bean.setKengenFlg("0");
            }
            beanList.add(bean);
        }

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        resultBean.setSyoruiKengenBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static PutSyoruiKengenResultBean putSyoruiKengen(
        String pRollCd,
        String[] pSyoruiCd) {

        PutSyoruiKengenResultBean resultBean = new PutSyoruiKengenResultBean();

        IwfAccountClient iwfAccountClient = SWAKInjector.getInstance(IwfAccountClient.class);

        UpdImageAuthorityInBean inBean = new UpdImageAuthorityInBean();
        inBean.setImageauthid(pRollCd);
        inBean.setTorikomisyoruicds(pSyoruiCd);
        WSUpdImageAuthorityResponse response = iwfAccountClient.execUpdImageAuthority(inBean);

        resultBean.setSyousaiMessageCd(response.getSyousaimsgcd());
        resultBean.setSyousaiMessage(response.getSyousaimsg());
        resultBean.setSyorikekkaStatus(response.getKekkastatus());

        return resultBean;
    }

    public static DropSyoruiKengenResultBean dropSyoruiKengen(
        String pRollCd) {

        DropSyoruiKengenResultBean resultBean = new DropSyoruiKengenResultBean();

        IwfAccountClient iwfAccountClient = SWAKInjector.getInstance(IwfAccountClient.class);

        DelImageAuthorityInBean inBean = new DelImageAuthorityInBean();
        inBean.setImageauthids(new String[] { pRollCd });
        WSDelImageAuthorityResponse response = iwfAccountClient.execDelImageAuthority(inBean);

        resultBean.setSyousaiMessageCd(response.getSyousaimsgcd());
        resultBean.setSyousaiMessage(response.getSyousaimsg());
        resultBean.setSyorikekkaStatus(response.getKekkastatus());

        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfTaskSummaryBySubsystem(String[] pSubsystemId,
        String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryBySubsystemBean>();
        CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBean;
        HashSet<String> workListDispFlagManage = new HashSet<>();
        LinkedHashMap<String, CountOfTaskSummaryBySubsystemBean> map = Maps.newLinkedHashMap();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

        Calendar sysDate = BizDate.getSystemDate();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiList = Lists.newArrayList();

        if (pSubsystemId != null && pSubsystemId.length > 0) {

            jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIds(pSubsystemId);

            for (DM_Jimutetuzuki jimutetuzuki : jimutetuzukiList) {

                List<DM_JimutetuzukiTask> jimutetuzukitaskList = jimutetuzuki.getJimutetuzukiTasks();

                for (DM_JimutetuzukiTask jimutetuzukitask : jimutetuzukitaskList) {

                    if (jimutetuzukitask.getWorklistHyoujiFlag() == 1) {

                        String jimutetuzukiCd = jimutetuzuki.getJimutetuzukicd();

                        workListDispFlagManage.add(jimutetuzukiCd + "." + jimutetuzukitask.getWorkflowTskId());

                        if (!map.containsKey(jimutetuzukiCd)) {

                            countOfTaskSummaryBean = new CountOfTaskSummaryBySubsystemBean();

                            countOfTaskSummaryBean.setJimutetuzukiCd(jimutetuzukiCd);
                            countOfTaskSummaryBean.setJimutetuzukiNm(jimutetuzuki.getJimutetuzukinm());
                            countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.ZERO);
                            countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.ZERO);
                            countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.ZERO);

                            map.put(jimutetuzukiCd,countOfTaskSummaryBean);

                        }
                    }
                }
            }
        }

        for (String key : map.keySet()) {

            GetTaskSummaryInBean taskSummaryInBean = new GetTaskSummaryInBean();

            if (!Strings.isNullOrEmpty(pUserId)) {
                taskSummaryInBean.setAccountid(pUserId);
            }

            taskSummaryInBean.setFlowid(key);

            taskSummaryInBean.setTaskendumu("1");

            GetTaskSummaryOutBean taskSummaryOutBean = iwfKouteiClient.execGetTaskSummary(taskSummaryInBean);

            resultBean.setSyousaiMessageCd(taskSummaryOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(taskSummaryOutBean.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(taskSummaryOutBean.getKekkastatus())) {

                if (!taskSummaryOutBean.getSyousaimsgcd().equals("IWF4020")) {
                    resultBean.setSyorikekkaStatus(taskSummaryOutBean.getKekkastatus());
                    return resultBean;
                }
            }

            if (taskSummaryOutBean.getTaskSummaryBeanList() != null) {
                for (yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean tmpBean : taskSummaryOutBean.getTaskSummaryBeanList()) {

                    if (workListDispFlagManage.contains(tmpBean.getFlowId() + "." + tmpBean.getTaskName())) {

                        CountOfTaskSummaryBySubsystemBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getFlowId());

                        tmpCountOfTaskSummaryBean.setCountOfprocessStartToday(tmpCountOfTaskSummaryBean
                            .getCountOfprocessStartToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                                .getTaskCount()))));

                        map.put(tmpCountOfTaskSummaryBean.getJimutetuzukiCd(), tmpCountOfTaskSummaryBean);
                    }
                }
            }

            GetTaskKensuuInBean taskKensuuInBean = new GetTaskKensuuInBean();

            if (!Strings.isNullOrEmpty(pUserId)) {
                taskKensuuInBean.setAccountid(pUserId);
            }

            taskKensuuInBean.setFlowid(key);

            sysDate.set(Calendar.HOUR_OF_DAY, 0);
            sysDate.set(Calendar.MINUTE, 0);
            sysDate.set(Calendar.SECOND, 0);
            sysDate.set(Calendar.MILLISECOND, 0);

            taskKensuuInBean.setTaskendtimefrom(sdf.format(sysDate.getTime()));

            sysDate.set(Calendar.HOUR_OF_DAY, 23);
            sysDate.set(Calendar.MINUTE, 59);
            sysDate.set(Calendar.SECOND, 59);
            sysDate.set(Calendar.MILLISECOND, 999);
            taskKensuuInBean.setTaskendtimeto(sdf.format(sysDate.getTime()));


            taskKensuuInBean.setTaskendumu("0");


            GetTaskKensuuOutBean taskKensuuOutBean = iwfKouteiClient.execGetTaskKensuu(taskKensuuInBean);

            resultBean.setSyousaiMessageCd(taskKensuuOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(taskKensuuOutBean.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuOutBean.getKekkastatus())) {
                if (!taskKensuuOutBean.getSyousaimsgcd().equals("IWF4020")) {
                    resultBean.setSyorikekkaStatus(taskKensuuOutBean.getKekkastatus());
                    return resultBean;
                }
            }


            if (taskKensuuOutBean.getTaskSummaryBeanList() != null) {
                for (yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean tmpBean : taskKensuuOutBean.getTaskSummaryBeanList()) {

                    if (workListDispFlagManage.contains(tmpBean.getFlowId() + "." + tmpBean.getTaskName())) {

                        CountOfTaskSummaryBySubsystemBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getFlowId());

                        tmpCountOfTaskSummaryBean.setTaskFinByActorFlg(true);

                        map.put(tmpCountOfTaskSummaryBean.getJimutetuzukiCd(), tmpCountOfTaskSummaryBean);
                    }
                }
            }

            taskKensuuInBean = new GetTaskKensuuInBean();

            if (!Strings.isNullOrEmpty(pUserId)) {
                taskKensuuInBean.setAccountid(pUserId);
            }

            taskKensuuInBean.setFlowid(key);

            taskKensuuInBean.setTaskendumu("1");

            taskKensuuOutBean = iwfKouteiClient.execGetTaskKensuu(taskKensuuInBean);

            resultBean.setSyousaiMessageCd(taskKensuuOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(taskKensuuOutBean.getSyousaimsg());

            if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuOutBean.getKekkastatus())) {
                if (!taskKensuuOutBean.getSyousaimsgcd().equals("IWF4020")) {
                    resultBean.setSyorikekkaStatus(taskKensuuOutBean.getKekkastatus());
                    return resultBean;
                }
            }

            if (taskKensuuOutBean.getTaskSummaryBeanList() != null) {
                for (yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean tmpBean : taskKensuuOutBean.getTaskSummaryBeanList()) {

                    if (workListDispFlagManage.contains(tmpBean.getFlowId() + "." + tmpBean.getTaskName())) {

                        CountOfTaskSummaryBySubsystemBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getFlowId());

                        tmpCountOfTaskSummaryBean.setCountOfprocessLeftToday(tmpCountOfTaskSummaryBean
                            .getCountOfprocessLeftToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                                .getTaskCount()))));

                        map.put(tmpCountOfTaskSummaryBean.getJimutetuzukiCd(), tmpCountOfTaskSummaryBean);
                    }
                }
            }
        }

        GetProcessSummaryInBean inBean = new GetProcessSummaryInBean();

        String[] jimutetuzukiCd = new String[jimutetuzukiList.size()];

        for (int i = 0; i < jimutetuzukiList.size(); i++) {

            jimutetuzukiCd[i] = jimutetuzukiList.get(i).getJimutetuzukicd();
        }

        inBean.setFlowids(jimutetuzukiCd);
        inBean.setSyoristatus(new String[] { WorkFlowUtilityConstants.SYORI_STATUS_END });

        inBean.setKouteikanryoubifrom(sdf2.format(sysDate.getTime()));

        inBean.setKouteikanryoubito(sdf2.format(sysDate.getTime()));

        GetProcessSummaryOutBean response = iwfKouteiClient.execGetProcessSummary(inBean);

        if(response.getProcessSummaryBeanList() != null && response.getProcessSummaryBeanList().size() > 0){

            for (yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean tmpBean : response.getProcessSummaryBeanList()) {

                if(!Strings.isNullOrEmpty(pUserId)){
                    if(tmpBean.getPreviousAccountId().equals(pUserId)){
                        CountOfTaskSummaryBySubsystemBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getFlowId());

                        tmpCountOfTaskSummaryBean.setCountOfprocessFinToday(tmpCountOfTaskSummaryBean
                            .getCountOfprocessFinToday().add(BizNumber.valueOf(1)));

                        map.put(tmpCountOfTaskSummaryBean.getJimutetuzukiCd(), tmpCountOfTaskSummaryBean);
                    }
                } else{

                    CountOfTaskSummaryBySubsystemBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getFlowId());

                    tmpCountOfTaskSummaryBean.setCountOfprocessFinToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessFinToday().add(BizNumber.valueOf(1)));

                    map.put(tmpCountOfTaskSummaryBean.getJimutetuzukiCd(), tmpCountOfTaskSummaryBean);
                }
            }

        }

        countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryBySubsystemBean>(map.values());

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfTaskSummaryByJimutetuzuki(
        String pSubsystemId, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>();
        CountOfTaskSummaryByJimutetuzukiBean countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();
        HashSet<String> workListDispFlagManage = new HashSet<>();
        LinkedHashMap<String, CountOfTaskSummaryByJimutetuzukiBean> map = Maps.newLinkedHashMap();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        Calendar sysDate = BizDate.getSystemDate();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        DM_Jimutetuzuki jimutetuzuki = workflowDomManager.getJimutetuzuki(pJimutetuzukiCd,pSubsystemId);

        List<DM_JimutetuzukiTask> jimutetuzukiTaskList = jimutetuzuki.getJimutetuzukiTasks();

        Ordering<DM_JimutetuzukiTask> ordering = Ordering.natural().nullsFirst()
            .onResultOf(new WorkflowDMJimutetuzukiTaskSortFunction());
        List<DM_JimutetuzukiTask> SortedJimutetuzukiTaskList = ordering.sortedCopy(jimutetuzukiTaskList);

        for (DM_JimutetuzukiTask jimutetuzukiTask : SortedJimutetuzukiTaskList) {

            String taskId = jimutetuzukiTask.getWorkflowTskId();

            if (jimutetuzukiTask.getWorklistHyoujiFlag() == 1) {

                workListDispFlagManage.add(taskId);

                if (!map.containsKey(taskId)) {

                    countOfTaskSummaryBean = new CountOfTaskSummaryByJimutetuzukiBean();

                    countOfTaskSummaryBean.setJimutetuzukiCd(jimutetuzukiTask.getJimutetuzukicd());
                    countOfTaskSummaryBean.setTaskNm(taskId);
                    countOfTaskSummaryBean.setDispTaskNm(jimutetuzukiTask.getWorkflowTskNm());
                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.ZERO);
                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.ZERO);
                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.ZERO);

                    map.put(taskId,countOfTaskSummaryBean);
                }
            }
        }

        GetTaskSummaryInBean taskSummaryInBean = new GetTaskSummaryInBean();

        if (!Strings.isNullOrEmpty(pUserId)) {
            taskSummaryInBean.setAccountid(pUserId);
        }

        taskSummaryInBean.setFlowid(pJimutetuzukiCd);

        taskSummaryInBean.setTaskendumu("1");

        GetTaskSummaryOutBean taskSummaryOutBean = iwfKouteiClient.execGetTaskSummary(taskSummaryInBean);

        resultBean.setSyousaiMessageCd(taskSummaryOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskSummaryOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskSummaryOutBean.getKekkastatus())) {
            if (!taskSummaryOutBean.getSyousaimsgcd().equals("IWF4020")) {
                resultBean.setSyorikekkaStatus(taskSummaryOutBean.getKekkastatus());
                return resultBean;
            }
        }

        if (taskSummaryOutBean.getTaskSummaryBeanList() != null) {

            for (yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean tmpBean : taskSummaryOutBean.getTaskSummaryBeanList()) {

                if (workListDispFlagManage.contains(tmpBean.getTaskName())) {

                    CountOfTaskSummaryByJimutetuzukiBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getTaskName());

                    tmpCountOfTaskSummaryBean.setCountOfprocessStartToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessStartToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                            .getTaskCount()))));

                    map.put(tmpCountOfTaskSummaryBean.getTaskNm(), tmpCountOfTaskSummaryBean);
                }
            }
        }

        GetTaskKensuuInBean taskKensuuInBean = new GetTaskKensuuInBean();

        if (!Strings.isNullOrEmpty(pUserId)) {
            taskKensuuInBean.setAccountid(pUserId);
        }

        taskKensuuInBean.setFlowid(pJimutetuzukiCd);

        sysDate.set(Calendar.HOUR_OF_DAY, 0);
        sysDate.set(Calendar.MINUTE, 0);
        sysDate.set(Calendar.SECOND, 0);
        sysDate.set(Calendar.MILLISECOND, 0);

        taskKensuuInBean.setTaskendtimefrom(sdf.format(sysDate.getTime()));

        sysDate.set(Calendar.HOUR_OF_DAY, 23);
        sysDate.set(Calendar.MINUTE, 59);
        sysDate.set(Calendar.SECOND, 59);
        sysDate.set(Calendar.MILLISECOND, 999);
        taskKensuuInBean.setTaskendtimeto(sdf.format(sysDate.getTime()));


        taskKensuuInBean.setTaskendumu("0");


        GetTaskKensuuOutBean taskKensuuOutBean = iwfKouteiClient.execGetTaskKensuu(taskKensuuInBean);

        resultBean.setSyousaiMessageCd(taskKensuuOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuOutBean.getKekkastatus())) {
            if (!taskKensuuOutBean.getSyousaimsgcd().equals("IWF4020")) {
                resultBean.setSyorikekkaStatus(taskKensuuOutBean.getKekkastatus());
                return resultBean;
            }
        }

        if (taskKensuuOutBean.getTaskSummaryBeanList() != null) {
            for (yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean tmpBean : taskKensuuOutBean.getTaskSummaryBeanList()) {

                if (workListDispFlagManage.contains(tmpBean.getTaskName())) {

                    CountOfTaskSummaryByJimutetuzukiBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getTaskName());

                    tmpCountOfTaskSummaryBean.setCountOfprocessFinToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessFinToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                            .getTaskCount()))));

                    map.put(tmpCountOfTaskSummaryBean.getTaskNm(), tmpCountOfTaskSummaryBean);
                }
            }
        }

        taskKensuuInBean = new GetTaskKensuuInBean();

        if (!Strings.isNullOrEmpty(pUserId)) {
            taskKensuuInBean.setAccountid(pUserId);
        }

        taskKensuuInBean.setFlowid(pJimutetuzukiCd);

        taskKensuuInBean.setTaskendumu("1");

        taskKensuuOutBean = iwfKouteiClient.execGetTaskKensuu(taskKensuuInBean);

        resultBean.setSyousaiMessageCd(taskKensuuOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuOutBean.getKekkastatus())) {
            if (!taskKensuuOutBean.getSyousaimsgcd().equals("IWF4020")) {
                resultBean.setSyorikekkaStatus(taskKensuuOutBean.getKekkastatus());
                return resultBean;
            }
        }

        if (taskKensuuOutBean.getTaskSummaryBeanList() != null) {
            for (yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean tmpBean : taskKensuuOutBean.getTaskSummaryBeanList()) {

                if (workListDispFlagManage.contains(tmpBean.getTaskName())) {

                    CountOfTaskSummaryByJimutetuzukiBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getTaskName());

                    tmpCountOfTaskSummaryBean.setCountOfprocessLeftToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessLeftToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                            .getTaskCount()))));

                    map.put(tmpCountOfTaskSummaryBean.getTaskNm(), tmpCountOfTaskSummaryBean);
                }
            }
        }

        countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>(map.values());

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfTaskSummaryByTask(String pJimutetuzukiCd,
        String pTaskNm, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByTaskBean>();
        CountOfTaskSummaryByTaskBean countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        Calendar sysDate = BizDate.getSystemDate();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        Map<String, String> userNmMap = new HashMap<String, String>();

        HashMap<String, CountOfTaskSummaryByTaskBean> map = Maps.newHashMap();

        GetTaskSummaryByActorInBean taskSummaryByActorInBean = new GetTaskSummaryByActorInBean();

        if (!Strings.isNullOrEmpty(pUserId)) {
            taskSummaryByActorInBean.setAccountid(pUserId);
        }

        taskSummaryByActorInBean.setFlowid(pJimutetuzukiCd);

        taskSummaryByActorInBean.setTaskid(pTaskNm);

        taskSummaryByActorInBean.setTaskendumu("1");

        GetTaskSummaryByActorOutBean taskSummaryByActorOutBean = iwfKouteiClient.execGetTaskSummaryByActor(taskSummaryByActorInBean);

        resultBean.setSyousaiMessageCd(taskSummaryByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskSummaryByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskSummaryByActorOutBean.getKekkastatus())) {
            if (!taskSummaryByActorOutBean.getSyousaimsgcd().equals("IWF4020")) {
                resultBean.setSyorikekkaStatus(taskSummaryByActorOutBean.getKekkastatus());
                return resultBean;
            }
        }

        if (taskSummaryByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean tmpBean : taskSummaryByActorOutBean.getTaskSummaryByActorBeanList()) {

                if (!map.containsKey(tmpBean.getUserId())) {

                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();

                    countOfTaskSummaryBean.setUserId(tmpBean.getUserId());

                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(Integer.valueOf(tmpBean
                        .getTaskCount())));

                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.ZERO);

                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    if (!Strings.isNullOrEmpty(tmpBean.getUserId())) {
                        if (!userNmMap.containsKey(tmpBean.getUserId())) {
                            BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                            AM_User userInfo = baseDomManager.getUser(tmpBean.getUserId());
                            if (userInfo == null) {
                                userNmMap.put(tmpBean.getUserId(), ConvertUtil.toZenAll(tmpBean.getUserId(), 0, 0));
                            } else {
                                userNmMap.put(tmpBean.getUserId(), userInfo.getUserNm());
                            }
                        }
                        countOfTaskSummaryBean.setDispUserNm(userNmMap.get(tmpBean.getUserId()));
                    } else {
                        countOfTaskSummaryBean.setDispUserNm(WorkFlowUtilityConstants.KYOUYOU);
                    }

                    map.put(countOfTaskSummaryBean.getUserId(), countOfTaskSummaryBean);

                } else {

                    CountOfTaskSummaryByTaskBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getUserId());

                    tmpCountOfTaskSummaryBean.setCountOfprocessStartToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessStartToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                            .getTaskCount()))));

                    map.put(tmpCountOfTaskSummaryBean.getUserId(), tmpCountOfTaskSummaryBean);
                }
            }
        }

        GetTaskKensuuByActorInBean taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();

        if (!Strings.isNullOrEmpty(pUserId)) {
            taskKensuuByActorInBean.setAccountid(pUserId);
        }

        taskKensuuByActorInBean.setFlowid(pJimutetuzukiCd);

        taskKensuuByActorInBean.setTaskid(pTaskNm);

        sysDate.set(Calendar.HOUR_OF_DAY, 0);
        sysDate.set(Calendar.MINUTE, 0);
        sysDate.set(Calendar.SECOND, 0);
        sysDate.set(Calendar.MILLISECOND, 0);

        taskKensuuByActorInBean.setTaskendtimefrom(sdf.format(sysDate.getTime()));

        sysDate.set(Calendar.HOUR_OF_DAY, 23);
        sysDate.set(Calendar.MINUTE, 59);
        sysDate.set(Calendar.SECOND, 59);
        sysDate.set(Calendar.MILLISECOND, 999);
        taskKensuuByActorInBean.setTaskendtimeto(sdf.format(sysDate.getTime()));

        taskKensuuByActorInBean.setTaskendumu("0");

        GetTaskKensuuByActorOutBean taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {

            if (!taskKensuuByActorOutBean.getSyousaimsgcd().equals("IWF4020")) {
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());
                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean tmpBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {

                if (!map.containsKey(tmpBean.getUserId())) {

                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();

                    countOfTaskSummaryBean.setUserId(tmpBean.getUserId());

                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.valueOf(Integer.valueOf("0")));

                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(Integer.valueOf("0")));

                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.valueOf(Integer.valueOf(tmpBean
                        .getTaskCount())));

                    if (!Strings.isNullOrEmpty(tmpBean.getUserId())) {
                        if (!userNmMap.containsKey(tmpBean.getUserId())) {
                            BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                            AM_User userInfo = baseDomManager.getUser(tmpBean.getUserId());
                            if (userInfo == null) {
                                userNmMap.put(tmpBean.getUserId(), ConvertUtil.toZenAll(tmpBean.getUserId(), 0, 0));
                            } else {
                                userNmMap.put(tmpBean.getUserId(), userInfo.getUserNm());
                            }
                        }
                        countOfTaskSummaryBean.setDispUserNm(userNmMap.get(tmpBean.getUserId()));
                    } else {
                        countOfTaskSummaryBean.setDispUserNm(WorkFlowUtilityConstants.KYOUYOU);
                    }

                    map.put(countOfTaskSummaryBean.getUserId(), countOfTaskSummaryBean);
                } else {

                    CountOfTaskSummaryByTaskBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getUserId());

                    tmpCountOfTaskSummaryBean.setCountOfprocessFinToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessFinToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                            .getTaskCount()))));

                    map.put(tmpCountOfTaskSummaryBean.getUserId(), tmpCountOfTaskSummaryBean);
                }
            }
        }

        taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();

        if (!Strings.isNullOrEmpty(pUserId)) {
            taskKensuuByActorInBean.setAccountid(pUserId);
        }

        taskKensuuByActorInBean.setFlowid(pJimutetuzukiCd);

        taskKensuuByActorInBean.setTaskid(pTaskNm);

        taskKensuuByActorInBean.setTaskendumu("1");

        taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {

            if (!taskKensuuByActorOutBean.getSyousaimsgcd().equals("IWF4020")) {
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());
                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean tmpBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {

                if (!map.containsKey(tmpBean.getUserId())) {

                    countOfTaskSummaryBean = new CountOfTaskSummaryByTaskBean();

                    countOfTaskSummaryBean.setUserId(tmpBean.getUserId());

                    countOfTaskSummaryBean.setCountOfprocessStartToday(BizNumber.ZERO);

                    countOfTaskSummaryBean.setCountOfprocessLeftToday(BizNumber.valueOf(Integer.valueOf(tmpBean
                        .getTaskCount())));

                    countOfTaskSummaryBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    if (!Strings.isNullOrEmpty(tmpBean.getUserId())) {
                        if (!userNmMap.containsKey(tmpBean.getUserId())) {
                            BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                            AM_User userInfo = baseDomManager.getUser(tmpBean.getUserId());
                            if (userInfo == null) {
                                userNmMap.put(tmpBean.getUserId(), ConvertUtil.toZenAll(tmpBean.getUserId(), 0, 0));
                            } else {
                                userNmMap.put(tmpBean.getUserId(), userInfo.getUserNm());
                            }
                        }
                        countOfTaskSummaryBean.setDispUserNm(userNmMap.get(tmpBean.getUserId()));
                    } else {
                        countOfTaskSummaryBean.setDispUserNm(WorkFlowUtilityConstants.KYOUYOU);
                    }

                    map.put(countOfTaskSummaryBean.getUserId(), countOfTaskSummaryBean);
                } else {

                    CountOfTaskSummaryByTaskBean tmpCountOfTaskSummaryBean = map.get(tmpBean.getUserId());

                    tmpCountOfTaskSummaryBean.setCountOfprocessLeftToday(tmpCountOfTaskSummaryBean
                        .getCountOfprocessLeftToday().add(BizNumber.valueOf(Integer.valueOf(tmpBean
                            .getTaskCount()))));

                    map.put(tmpCountOfTaskSummaryBean.getUserId(), tmpCountOfTaskSummaryBean);
                }
            }
        }

        countOfTaskSummaryBeanList = new ArrayList<CountOfTaskSummaryByTaskBean>(map.values());

        if (BizUtil.isBlank(pUserId)) {
            Ordering<CountOfTaskSummaryByTaskBean> ordering = Ordering.natural().nullsFirst()
                .onResultOf(new WorkflowCountOfTaskSummaryBeanSortFunction());
            List<CountOfTaskSummaryByTaskBean> sortedInfoItiran = ordering.sortedCopy(countOfTaskSummaryBeanList);
            resultBean.setCountOfTaskSummaryBean(sortedInfoItiran);
        } else {
            resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBeanList);
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static MakeCountOfTaskSummaryResultBean makeCountOfTaskSummary() {

        MakeCountOfTaskSummaryResultBean resultBean = new MakeCountOfTaskSummaryResultBean();

        CreateTaskSummaryInBean inBean = new CreateTaskSummaryInBean();

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        WSCreateTaskSummaryResponse kouteiOutBean = iwfKouteiClient.execCreateTaskSummary(inBean);

        resultBean.setSyorikekkaStatus(kouteiOutBean.getKekkastatus());
        resultBean.setSyousaiMessageCd(kouteiOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(kouteiOutBean.getSyousaimsg());

        return resultBean;
    }

    public static PutJimuyouCdResultBean putJimuyouCd(String pJimutetuzukiCd, String pUserId,
        List<PutJimuyouCdBean> pPutJimuyouCdBeanLst) {

        PutJimuyouCdResultBean resultBean = SWAKInjector.getInstance(PutJimuyouCdResultBean.class);
        LockGyoumuKeyBean lockGyoumuKeyBean = SWAKInjector.getInstance(LockGyoumuKeyBean.class);

        List<LockProcessInBean> lockProcessInBeanLst = new ArrayList<>();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        HashSet<String> syoriKtKrId = new HashSet<>();

        Map<String, String> map = Maps.newHashMap();

        for (PutJimuyouCdBean putJimuyouCdBean : pPutJimuyouCdBeanLst) {

            List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoList = bizDomManager.
                getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(putJimuyouCdBean.getKouteiKnrId(),
                    pJimutetuzukiCd);

            for (BT_GyoumuKouteiInfo gyoumuKouteiInfo : gyoumuKouteiInfoList) {

                syoriKtKrId.add(gyoumuKouteiInfo.getKouteikanriid());

                map.put(gyoumuKouteiInfo.getKouteikanriid(), putJimuyouCdBean.getJimuyouCd());
            }
        }

        GetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector.getInstance(GetProcessSummaryInBean.class);
        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);

        getProcessSummaryInBean.setGyoumukeys(syoriKtKrId.toArray(new String[syoriKtKrId.size()]));
        getProcessSummaryInBean.setSyoristatus(new String[] { WorkFlowUtilityConstants.SYORI_STATUS_SYORITYU });

        GetProcessSummaryOutBean getProcessOutBean = iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessOutBean.getKekkastatus())) {

            resultBean.setSyorikekkaStatus(getProcessOutBean.getKekkastatus());
            resultBean.setSyousaiMessageCd(getProcessOutBean.getSyousaimsgcd());
            resultBean.setSyousaiMessage(getProcessOutBean.getSyousaimsg());
            resultBean.setErrorApiName("GetProcessSummary");

            return resultBean;
        }

        List<ProcessSummaryBean> wkProcessList = getProcessOutBean.getProcessSummaryBeanList();

        UniqueKeyGenerator uniqueKeyGenerator = SWAKInjector.getInstance(UniqueKeyGenerator.class);
        String lockKey = uniqueKeyGenerator.generateUniqueKey();

        for (ProcessSummaryBean processSummaryBean : wkProcessList) {

            LockProcessInBean lockInBean = new LockProcessInBean();
            lockInBean.setGyoumukey(processSummaryBean.getGyoumukey());
            lockInBean.setFlowid(processSummaryBean.getFlowId());
            lockInBean.setLockkey(lockKey);

            LockProcessOutBean lockProcessOutBean = iwfKouteiClient.execLockProcess(lockInBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(lockProcessOutBean.getKekkastatus())) {

                if ("IWF2091".equals(lockProcessOutBean.getSyousaimsgcd())) {

                    resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);

                    lockGyoumuKeyBean.setMosNo(processSummaryBean.getExtparamBean().getExtparam14());
                    lockGyoumuKeyBean.setSyoNo(processSummaryBean.getExtparamBean().getExtparam12());
                    lockGyoumuKeyBean.setNkSysyNo(processSummaryBean.getExtparamBean().getExtparam13());
                    resultBean.setLockGyoumuKeyBean(lockGyoumuKeyBean);
                }
                else {

                    resultBean.setSyorikekkaStatus(lockProcessOutBean.getKekkastatus());
                }

                resultBean.setSyousaiMessageCd(lockProcessOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(lockProcessOutBean.getSyousaimsg());
                resultBean.setErrorApiName("LockProcess");
                resultBean.setLockProcessInBeanList(lockProcessInBeanLst);

                return resultBean;
            }

            lockProcessInBeanLst.add(lockInBean);
        }

        resultBean.setLockProcessInBeanList(lockProcessInBeanLst);

        for (LockProcessInBean lockProcessInBean : lockProcessInBeanLst) {

            ProcessUpdateInBean processUpdateInBean = new ProcessUpdateInBean();
            processUpdateInBean.setGyoumukey(lockProcessInBean.getGyoumukey());
            processUpdateInBean.setFlowid(lockProcessInBean.getFlowid());
            processUpdateInBean.setAccountid(pUserId);
            processUpdateInBean.setLockkey(lockProcessInBean.getLockkey());

            WSExtParam extParam = new WSExtParam();
            extParam.setValues(map.get(lockProcessInBean.getGyoumukey()));
            processUpdateInBean.setExtParam7(extParam);

            extParam = new WSExtParam();
            if (BizUtil.isBlank(map.get(lockProcessInBean.getGyoumukey()))) {
                extParam.setValues("1");
            }
            else {
                extParam.setValues("0");
            }
            processUpdateInBean.setExtParam8(extParam);

            ProcessUpdateOutBean processUpdateOutBean = iwfKouteiClient.execProcessUpdate(processUpdateInBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(processUpdateOutBean.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(processUpdateOutBean.getKekkastatus());
                resultBean.setSyousaiMessageCd(processUpdateOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(processUpdateOutBean.getSyousaimsg());
                resultBean.setErrorApiName("ProcessUpdate");
                break;
            }
        }

        if (resultBean.getSyorikekkaStatus() != null &&
            !WorkFlowResultConstants.RESULT_OK.equals(resultBean.getSyorikekkaStatus())) {

            return resultBean;
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetTorikomiSyoruiMstAndKengenResultBean getTorikomiSyoruiMstAndKengen(String[] pJimutetuzukiCd,
        String pUserId) {
        GetTorikomiSyoruiMstAndKengenResultBean resultBean = new GetTorikomiSyoruiMstAndKengenResultBean();
        List<TorikomiSyoruiMstAndKengenBean> beanList = new ArrayList<TorikomiSyoruiMstAndKengenBean>();
        TorikomiSyoruiMstAndKengenBean bean;

        IwfAccountClient iwfAccountClient = SWAKInjector.getInstance(IwfAccountClient.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        GetImageAuthorityInBean getImageAuthorityInBean;
        WSGetImageAuthorityResponse getImageAuthorityResponse;

        List<String> authesSyoruiCds = new ArrayList<String>();

        AM_User userInfo = baseDomManager.getUser(pUserId);

        List<AT_UserRole> userRoles = userInfo.getUserRoles();

        List<String> roleCds = new ArrayList<String>();
        if (userRoles != null && userRoles.size() > 0) {
            for (AT_UserRole role : userRoles) {
                roleCds.add(role.getRoleCd());
            }
        }

        if (roleCds.size() > 0) {
            for (String roleCd : roleCds) {
                getImageAuthorityInBean = new GetImageAuthorityInBean();
                getImageAuthorityInBean.setImageauthid(roleCd);

                getImageAuthorityResponse = iwfAccountClient.execGetImageAuthority(getImageAuthorityInBean);
                resultBean.setSyousaiMessageCd(getImageAuthorityResponse.getSyousaimsgcd());
                resultBean.setSyousaiMessage(getImageAuthorityResponse.getSyousaimsg());

                if (!WorkFlowResultConstants.RESULT_OK.equals(getImageAuthorityResponse.getKekkastatus())) {
                    resultBean.setSyorikekkaStatus(getImageAuthorityResponse.getKekkastatus());
                    return resultBean;
                }

                for (String syoruiCd : getImageAuthorityResponse.getTorikomiSyoruiCds()) {
                    authesSyoruiCds.add(syoruiCd);
                }
            }
        }

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);

        if (pJimutetuzukiCd != null && pJimutetuzukiCd.length > 0) {
            Map<String, DM_JimutetuzukiTask> taskNmMap = Maps.newHashMap();
            WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
            List<DM_Jimutetuzuki> jimuList = Lists.newArrayList();
            jimuList = workflowDomManager.getAllJimutetuzuki();
            for (DM_Jimutetuzuki jimuTetuduki : jimuList) {
                for (DM_JimutetuzukiTask task : jimuTetuduki.getJimutetuzukiTasks()) {
                    taskNmMap.put(task.getJimutetuzukicd() + "." + task.getWorkflowTskId(), task);
                }
            }

            GetTorikomiSyoruiMstInBean inBean;
            WSGetTorikomiSyoruiMstResponse response;
            ArrayList<TorikomiSyoruiBean> syoruiMstList = new ArrayList<TorikomiSyoruiBean>();
            for (String jimuTetudukiCd : pJimutetuzukiCd) {
                inBean = new GetTorikomiSyoruiMstInBean();
                inBean.setFlowid(jimuTetudukiCd);
                response = iwfImageClient.execGetTorikomiSyoruiMst(inBean);

                resultBean.setSyousaiMessageCd(response.getSyousaimsgcd());
                resultBean.setSyousaiMessage(response.getSyousaimsg());

                if (!WorkFlowResultConstants.RESULT_OK.equals(response.getKekkastatus())) {
                    resultBean.setSyorikekkaStatus(response.getKekkastatus());
                    return resultBean;
                }
                if (response.getTorikomisyoruilist() != null && response.getTorikomisyoruilist().size() > 0) {
                    syoruiMstList = response.getTorikomisyoruilist();

                    Ordering<TorikomiSyoruiBean> ordering = Ordering
                        .from(new WorkflowTorikomiSyoruiBeanSortComparator());
                    List<TorikomiSyoruiBean> sortedList = ordering.sortedCopy(syoruiMstList);

                    for (TorikomiSyoruiBean syorui : sortedList) {
                        bean = new TorikomiSyoruiMstAndKengenBean();
                        bean.setSyoruiCd(syorui.getTorikomisyoruicd());
                        bean.setSyoruiNm(syorui.getTorikomisyoruinm());
                        bean.setSyoruiRyakuNm(syorui.getTorikomisyoruiryaku());
                        bean.setSyzkSyouBunruiId(syorui.getSyzksyoubunruiid());
                        bean.setSyzkDaiBunruiId(syorui.getSyzkdaibunruiid());
                        bean.setJimutetuzukiCd(syorui.getFlowid());
                        bean.setZipHozonKbn(syorui.getZiphozonkbn());
                        bean.setKouteiSeigyoUmuKbn(syorui.getKouteiseigyoumukbn());
                        if (taskNmMap.containsKey(bean.getJimutetuzukiCd() + "." + syorui.getNodeid())) {
                            bean.setTaskNm(taskNmMap.get(bean.getJimutetuzukiCd() + "." + syorui.getNodeid())
                                .getWorkflowTskNm());
                        }

                        if (authesSyoruiCds.contains(bean.getSyoruiCd())) {
                            bean.setKengenUmu("1");
                        } else {
                            bean.setKengenUmu("0");
                        }
                        beanList.add(bean);
                    }
                }
            }
        }

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        resultBean.setTorikomiSyoruiMstAndKengenBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static PutExpectedArrivalNoticeResultBean putExpectedArrivalNotice(String pKouteiKnrId, String pQrCd,
        String pSyoruiCd, String pJimutetuzukiCd, String pSubSystemId) {

        PutExpectedArrivalNoticeResultBean resultBean = new PutExpectedArrivalNoticeResultBean();

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        CreateExpectedArrivalNoticeInBean inBean = new CreateExpectedArrivalNoticeInBean();
        inBean.setArrivekey(pQrCd);
        inBean.setGyoumukey(pKouteiKnrId);
        inBean.setTorikomisyoruicd(pSyoruiCd);
        inBean.setFlowid(pJimutetuzukiCd);
        inBean.setSubsystemid(pSubSystemId);
        WSCreateExpectedArrivalNoticeResponse response = iwfImageClient.CreateExpectedArrivalNotice(inBean);
        resultBean.setSyousaiMessageCd(response.getSyousaimsgcd());
        resultBean.setSyousaiMessage(response.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(response.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(response.getKekkastatus());
            return resultBean;
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetExpectedArrivalNoticeResultBean getExpectedArrivalNotice(String[] pQrCds) {

        GetExpectedArrivalNoticeResultBean resultBean =
            SWAKInjector.getInstance(GetExpectedArrivalNoticeResultBean.class);
        List<ExpectedArrivalNoticeBean> beanList = new ArrayList<>();
        ExpectedArrivalNoticeBean bean;

        if (pQrCds != null && pQrCds.length > 0) {
            IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
            GetExpectedArrivalNoticeInBean inBean;

            for (int i = 0; i < pQrCds.length; i++) {

                inBean = SWAKInjector.getInstance(GetExpectedArrivalNoticeInBean.class);
                inBean.setArrivekey(pQrCds[i]);

                GetExpectedArrivalNoticeOutBean outBean = iwfImageClient.GetExpectedArrivalNotice(inBean);

                resultBean.setSyousaiMessageCd(outBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(outBean.getSyousaimsg());

                if (WorkFlowResultConstants.RESULT_OK.equals(outBean.getKekkastatus())) {
                } else if (WorkFlowResultConstants.RESULT_WARN.equals(outBean.getKekkastatus())) {

                    if (pQrCds[i].substring(0, 3).equals(C_QrCodeTaikeiKbn.MOS.toString())) {
                        HT_MosMikakuteiSyorui mosMikakuteiSyorui =
                            SWAKInjector.getInstance(SinkeiyakuDomManager.class).getMosMikakuteiSyorui(pQrCds[i]);

                        if (mosMikakuteiSyorui == null) {
                            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                            resultBean.setExpectedArrivalNoticeBeanList(beanList);

                            return resultBean;
                        }

                        GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();

                        getTorikomiSyoruiMstInBean.setTorikomisyoruicd(mosMikakuteiSyorui.getSyoruiCd().toString());

                        WSGetTorikomiSyoruiMstResponse getTorikomiSyoruiMstResPonse = iwfImageClient
                            .execGetTorikomiSyoruiMst(getTorikomiSyoruiMstInBean);

                        if (!WorkFlowResultConstants.RESULT_OK.equals(getTorikomiSyoruiMstResPonse.getKekkastatus())) {
                            resultBean.setSyorikekkaStatus(getTorikomiSyoruiMstResPonse.getKekkastatus());
                            resultBean.setSyousaiMessageCd(getTorikomiSyoruiMstResPonse.getSyousaimsgcd());
                            resultBean.setSyousaiMessage(getTorikomiSyoruiMstResPonse.getSyousaimsg());
                            resultBean.setExpectedArrivalNoticeBeanList(beanList);

                            return resultBean;
                        }

                        bean = SWAKInjector.getInstance(ExpectedArrivalNoticeBean.class);

                        bean.setQrCd(mosMikakuteiSyorui.getDocumentid());
                        bean.setSyoruiCd(mosMikakuteiSyorui.getSyoruiCd().toString());
                        bean.setSyoruiNmRyaku(getTorikomiSyoruiMstResPonse.getTorikomisyoruilist().get(0)
                            .getTorikomisyoruiryaku());

                        beanList.add(bean);

                        continue;
                    }
                    resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
                    resultBean.setExpectedArrivalNoticeBeanList(beanList);

                    return resultBean;
                } else {
                    resultBean.setSyorikekkaStatus(outBean.getKekkastatus());
                    resultBean.setExpectedArrivalNoticeBeanList(beanList);

                    return resultBean;
                }

                if ((outBean.getNoticeBeanList() != null) && (outBean.getNoticeBeanList().size() > 0)) {
                    GetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector
                        .getInstance(GetProcessSummaryInBean.class);

                    getProcessSummaryInBean.setGyoumukey(outBean.getNoticeBeanList().get(0).getGyoumuKey());

                    GetProcessSummaryOutBean getProcessSummaryOutBean = SWAKInjector.getInstance(IwfKouteiClient.class)
                        .execGetProcessSummary(getProcessSummaryInBean);

                    if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
                        resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
                        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
                        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
                        resultBean.setExpectedArrivalNoticeBeanList(beanList);

                        return resultBean;
                    }

                    if (getProcessSummaryOutBean.getProcessSummaryBeanList().size() == 0) {
                        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
                        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());

                        return resultBean;
                    }

                    if (WorkFlowUtilityConstants.SYORI_STATUS_TORIKESI.equals(getProcessSummaryOutBean.getProcessSummaryBeanList().get(0).getProcessstatus())) {
                        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_TORIKESIZUMI);
                        return resultBean;
                    }

                    GetLockInfoResultBean lockResult = WorkFlowUtility.getLockInfo(getProcessSummaryInBean.getGyoumukey());

                    if (WorkFlowResultConstants.RESULT_LOCK.equals(lockResult.getSyorikekkaStatus())) {
                        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);
                        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
                        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
                        resultBean.setLockingQrCd(outBean.getNoticeBeanList().get(0).getArriveKey());
                        resultBean.setExpectedArrivalNoticeBeanList(beanList);

                        return resultBean;
                    }

                    bean = SWAKInjector.getInstance(ExpectedArrivalNoticeBean.class);

                    bean.setKouteiKnrId(outBean.getNoticeBeanList().get(0).getGyoumuKey());
                    bean.setQrCd(outBean.getNoticeBeanList().get(0).getArriveKey());
                    bean.setSyoruiCd(outBean.getNoticeBeanList().get(0).getTorikomisyoruiCd());
                    bean.setJimutetuzukiCd(outBean.getNoticeBeanList().get(0).getFlowId());
                    bean.setSubSystemId(outBean.getNoticeBeanList().get(0).getSubsystemId());

                    GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean =
                        SWAKInjector.getInstance(GetTorikomiSyoruiMstInBean.class);

                    getTorikomiSyoruiMstInBean.setTorikomisyoruicd(bean.getSyoruiCd());

                    WSGetTorikomiSyoruiMstResponse getTorikomiSyoruiMstResPonse = iwfImageClient
                        .execGetTorikomiSyoruiMst(getTorikomiSyoruiMstInBean);

                    if (!WorkFlowResultConstants.RESULT_OK.equals(getTorikomiSyoruiMstResPonse.getKekkastatus())) {
                        resultBean.setSyorikekkaStatus(getTorikomiSyoruiMstResPonse.getKekkastatus());
                        resultBean.setSyousaiMessageCd(getTorikomiSyoruiMstResPonse.getSyousaimsgcd());
                        resultBean.setSyousaiMessage(getTorikomiSyoruiMstResPonse.getSyousaimsg());
                        resultBean.setExpectedArrivalNoticeBeanList(beanList);

                        return resultBean;
                    }

                    bean.setSyoruiNmRyaku(getTorikomiSyoruiMstResPonse.getTorikomisyoruilist().get(0)
                        .getTorikomisyoruiryaku());

                    beanList.add(bean);

                }
            }
        }

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        resultBean.setExpectedArrivalNoticeBeanList(beanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static PutArrivalImageResultBean putArrivalImage(String pQrCd, byte[] pImage, String pKouteikanriId) {

        PutArrivalImageResultBean resultBean = SWAKInjector.getInstance(PutArrivalImageResultBean.class);
        GetLockInfoInBean getLockInfoInBean = SWAKInjector.getInstance(GetLockInfoInBean.class);

        if (!pQrCd.substring(0, 3).equals(C_QrCodeTaikeiKbn.MOS.toString())) {
            GetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector
                .getInstance(GetProcessSummaryInBean.class);

            getProcessSummaryInBean.setGyoumukey(pKouteikanriId);

            GetProcessSummaryOutBean getProcessSummaryOutBean = SWAKInjector.getInstance(IwfKouteiClient.class)
                .execGetProcessSummary(getProcessSummaryInBean);

            if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
                resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());

                return resultBean;
            }

            if (getProcessSummaryOutBean.getProcessSummaryBeanList().size() == 0) {
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
                resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());

                return resultBean;
            }

            if (WorkFlowUtilityConstants.SYORI_STATUS_TORIKESI.equals(getProcessSummaryOutBean.getProcessSummaryBeanList().get(0).getProcessstatus())) {
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_TORIKESIZUMI);
                return resultBean;
            }
        }

        if (!BizUtil.isBlank(pKouteikanriId)) {
            getLockInfoInBean.setGyoumukey(new String[] { pKouteikanriId });

            GetLockInfoOutBean getLockInfoOutBean = SWAKInjector.getInstance(IwfKouteiClient.class).getLockInfo(
                getLockInfoInBean);

            if (WorkFlowResultConstants.RESULT_WARN.equals(getLockInfoOutBean.getKekkastatus())) {
            } else if (WorkFlowResultConstants.RESULT_OK.equals(getLockInfoOutBean.getKekkastatus())) {
                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);

                return resultBean;
            } else {
                resultBean.setSyorikekkaStatus(getLockInfoOutBean.getKekkastatus());
                resultBean.setSyousaiMessageCd(getLockInfoOutBean.getSyousaimsgcd());
                resultBean.setSyousaiMessage(getLockInfoOutBean.getSyousaimsg());

                return resultBean;
            }
        }

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);

        PutArrivalImageInBean inBean = SWAKInjector.getInstance(PutArrivalImageInBean.class);
        inBean.setImagedata(pImage);
        inBean.setArrivekey(pQrCd);

        WSPutArrivalImageResponse response = iwfImageClient.PutArrivalImage(inBean);

        if (!response.getKekkastatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            resultBean.setSyorikekkaStatus(response.getKekkastatus());
            resultBean.setSyousaiMessage(response.getSyousaimsg());
            resultBean.setSyousaiMessageCd(response.getSyousaimsgcd());

            return resultBean;
        }
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetTorikomiSyoruiMstBySyoruiCdResultBean getTorikomiSyoruiMstBySyoruiCd(String pSyoruiCd) {

        GetTorikomiSyoruiMstBySyoruiCdResultBean resultBean = new GetTorikomiSyoruiMstBySyoruiCdResultBean();
        List<TorikomiSyoruiBean> beanList = new ArrayList<TorikomiSyoruiBean>();

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        GetTorikomiSyoruiMstInBean getSyoruiMstInBean;
        WSGetTorikomiSyoruiMstResponse syoruiMstResponse;

        getSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();

        if (!Strings.isNullOrEmpty(pSyoruiCd)) {
            getSyoruiMstInBean.setTorikomisyoruicd(pSyoruiCd);
        }

        syoruiMstResponse = iwfImageClient.execGetTorikomiSyoruiMst(getSyoruiMstInBean);
        resultBean.setSyousaiMessage(syoruiMstResponse.getSyousaimsg());
        resultBean.setSyousaiMessageCd(syoruiMstResponse.getSyousaimsgcd());

        if (!syoruiMstResponse.getKekkastatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            resultBean.setSyorikekkaStatus(syoruiMstResponse.getKekkastatus());
            return resultBean;
        }
        if (syoruiMstResponse.getTorikomisyoruilist().size() > 0) {

            beanList = syoruiMstResponse.getTorikomisyoruilist();
            Ordering<TorikomiSyoruiBean> ordering = Ordering.from(new WorkflowTorikomiSyoruiBeanSortComparator());
            List<TorikomiSyoruiBean> sortedList = ordering.sortedCopy(beanList);

            resultBean.setTorikomiSyoruiMstBeanList(sortedList);
        }

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetScanTorikomiSyoruiMstResultBean getScanTorikomiSyoruiMst(String pJimutetuzukiCd) {
        GetScanTorikomiSyoruiMstResultBean resultBean = new GetScanTorikomiSyoruiMstResultBean();
        List<TorikomiSyoruiMstBean> beanList = new ArrayList<TorikomiSyoruiMstBean>();
        TorikomiSyoruiMstBean bean;

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);
        GetTorikomiSyoruiMstInBean getSyoruiMstInBean = new GetTorikomiSyoruiMstInBean();

        getSyoruiMstInBean.setFlowid(pJimutetuzukiCd);

        WSGetTorikomiSyoruiMstResponse syoruiMstResponse = iwfImageClient.execGetTorikomiSyoruiMst(getSyoruiMstInBean);
        resultBean.setSyousaiMessageCd(syoruiMstResponse.getSyousaimsgcd());
        resultBean.setSyousaiMessage(syoruiMstResponse.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(syoruiMstResponse.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(syoruiMstResponse.getKekkastatus());
            return resultBean;
        }
        if (syoruiMstResponse.getTorikomisyoruilist() == null || syoruiMstResponse.getTorikomisyoruilist().size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_TorikomiSyoruiHukaInfo> torikomiSyoruiHukaInfo;
        torikomiSyoruiHukaInfo = bizDomManager.getAllTorikomiSyoruiHukaInfo();

        Map<String, String> torikomihouMap = new HashMap<String, String>();

        Map<String, String> torikomiSyoruiSubsystemMap = new HashMap<String, String>();

        Map<String, Integer> torikomiSyoruiSortNoMap = new HashMap<String, Integer>();

        if (torikomiSyoruiHukaInfo != null && torikomiSyoruiHukaInfo.size() > 0) {
            for (BM_TorikomiSyoruiHukaInfo hukaInfo : torikomiSyoruiHukaInfo) {
                torikomihouMap.put(hukaInfo.getSyoruiCd().getValue(), hukaInfo.getSyoruitorikomihoukbn().getValue());
                torikomiSyoruiSubsystemMap.put(hukaInfo.getSyoruiCd().getValue(), hukaInfo.getSubSystemId());
                torikomiSyoruiSortNoMap.put(hukaInfo.getSyoruiCd().getValue(), hukaInfo.getSortNo());
            }
        }
        else {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<TorikomiSyoruiMstSortBean> sortBeanList = new ArrayList<TorikomiSyoruiMstSortBean>();

        if (syoruiMstResponse.getTorikomisyoruilist() != null && syoruiMstResponse.getTorikomisyoruilist().size() > 0) {

            TorikomiSyoruiMstSortBean torikomiSyoruiMstSortBean;

            for(TorikomiSyoruiBean syoruiBean : syoruiMstResponse.getTorikomisyoruilist()){
                torikomiSyoruiMstSortBean = new TorikomiSyoruiMstSortBean();
                torikomiSyoruiMstSortBean.setSyoruiCd(syoruiBean.getTorikomisyoruicd());
                torikomiSyoruiMstSortBean.setSyoruiNm(syoruiBean.getTorikomisyoruinm());
                torikomiSyoruiMstSortBean.setSyoruiRyakuNm(syoruiBean.getTorikomisyoruiryaku());
                torikomiSyoruiMstSortBean.setSyzkDaiBunruiId(syoruiBean.getSyzkdaibunruiid());
                torikomiSyoruiMstSortBean.setSyzkSyouBunruiId(syoruiBean.getSyzksyoubunruiid());
                torikomiSyoruiMstSortBean.setZipHozonKbn(syoruiBean.getZiphozonkbn());
                torikomiSyoruiMstSortBean.setKouteiSeigyoUmuKbn(syoruiBean.getKouteiseigyoumukbn());
                torikomiSyoruiMstSortBean.setFlowId(syoruiBean.getFlowid());
                torikomiSyoruiMstSortBean.setNodeId(syoruiBean.getNodeid());
                if (torikomiSyoruiSortNoMap.containsKey(torikomiSyoruiMstSortBean.getSyoruiCd())) {
                    torikomiSyoruiMstSortBean.setSortNo(torikomiSyoruiSortNoMap.get(torikomiSyoruiMstSortBean.getSyoruiCd()));
                }
                sortBeanList.add(torikomiSyoruiMstSortBean);
            }
        }

        Ordering<TorikomiSyoruiMstSortBean> ordering = Ordering.from(new WorkflowTorikomiSyoruiMstSortBeanSortComparator());
        List<TorikomiSyoruiMstSortBean> sortedList = ordering.sortedCopy(sortBeanList);

        Map<String, DM_JimutetuzukiTask> taskNmMap = Maps.newHashMap();
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        List<DM_Jimutetuzuki> jimuList = Lists.newArrayList();
        jimuList = workflowDomManager.getAllJimutetuzuki();
        for (DM_Jimutetuzuki jimuTetuduki : jimuList) {
            for (DM_JimutetuzukiTask task : jimuTetuduki.getJimutetuzukiTasks()) {
                taskNmMap.put(task.getJimutetuzukicd() + "." + task.getWorkflowTskId(), task);
            }
        }
        for (TorikomiSyoruiMstSortBean syorui : sortedList) {
            if (!torikomihouMap.containsKey(syorui.getSyoruiCd()) ||
                !C_SyoruiTorikomiHouKbn.SCAN_QR.getValue().equals(torikomihouMap.get(syorui.getSyoruiCd()))) {
                continue;
            }
            bean = new TorikomiSyoruiMstBean();
            bean.setSyoruiCd(syorui.getSyoruiCd());
            bean.setSyoruiNm(syorui.getSyoruiNm());
            bean.setSyoruiRyakuNm(syorui.getSyoruiRyakuNm());
            bean.setSyzkSyouBunruiId(syorui.getSyzkSyouBunruiId());
            bean.setSyzkDaiBunruiId(syorui.getSyzkDaiBunruiId());
            bean.setJimutetuzukiCd(syorui.getFlowId());
            bean.setZipHozonKbn(syorui.getZipHozonKbn());
            bean.setKouteiSeigyoUmuKbn(syorui.getKouteiSeigyoUmuKbn());
            if (taskNmMap.containsKey(bean.getJimutetuzukiCd() + "." + syorui.getNodeId())) {
                bean.setTaskNm(taskNmMap.get(bean.getJimutetuzukiCd() + "." + syorui.getNodeId()).getWorkflowTskNm());
            }
            if(torikomiSyoruiSubsystemMap.containsKey(bean.getSyoruiCd())){
                bean.setSubsystemId(torikomiSyoruiSubsystemMap.get(bean.getSyoruiCd()));
            }
            beanList.add(bean);
        }

        resultBean.setTorikomiSyoruiMstBeanList(beanList);

        if (beanList.size() <= 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetLockInfoResultBean getLockInfo(String pKouteiKnrId) {

        GetLockInfoResultBean resultBean = SWAKInjector.getInstance(GetLockInfoResultBean.class);

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);
        GetLockInfoInBean getLockInfoInBean = SWAKInjector.getInstance(GetLockInfoInBean.class);

        getLockInfoInBean.setGyoumukey(new String[] { pKouteiKnrId });

        GetLockInfoOutBean getLockInfoOutBean = iwfKouteiClient.getLockInfo(getLockInfoInBean);

        if (WorkFlowResultConstants.RESULT_OK.equals(getLockInfoOutBean.getKekkastatus()) &&
            getLockInfoOutBean.getLockInfoBeanList().size() > 0) {

            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_LOCK);
        }
        else if (WorkFlowResultConstants.RESULT_WARN.equals(getLockInfoOutBean.getKekkastatus())) {

            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        }
        else {

            resultBean.setSyorikekkaStatus(getLockInfoOutBean.getKekkastatus());
        }

        return resultBean;
    }

    public static MakeCountOfKakoJissekiTaskSummaryResultBean makeCountOfKakoJissekiTaskSummary(BizDate pSyoriYmd) {
        MakeCountOfKakoJissekiTaskSummaryResultBean resultBean =
            SWAKInjector.getInstance(MakeCountOfKakoJissekiTaskSummaryResultBean.class);
        LinkedHashMap<String, CountOfJimutetuzukiBetuBean> countOfJimutetuzukiBetuMap = Maps.newLinkedHashMap();
        List<CountOfJimutetuzukiBetuBean> countOfJimutetuzukiBetuBeanList = new ArrayList<CountOfJimutetuzukiBetuBean>();
        long kensuuOfSyoriKensuuHokanJimu = 0;
        LinkedHashMap<String, CountOfTaskBetuBean> countOfTaskBetuMap = Maps.newLinkedHashMap();
        List<CountOfTaskBetuBean> countOfTaskBetuBeanList = null;
        long kensuuOfSyoriKensuuHokanTask = 0;
        long kensuuOfJimutetuzukiRireki = 0;
        long kensuuOfJimutetuzukiTaskRireki = 0;
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        String userId = "";

        List<DM_JimutetuzukiRireki> JimutetuzukiRirekiLst =
            workflowUtilityDao.getJimutetuzukiRirekisBySyoriYmd(pSyoriYmd);
        workflowDomManager.delete(JimutetuzukiRirekiLst);

        workflowUtilityDao.delSyoriKensuuHokanJimuBySyoriYmd(pSyoriYmd);

        workflowUtilityDao.delSyoriKensuuHokanTaskBySyoriYmd(pSyoriYmd);

        GetTaskKensuuByActorInBean taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();
        BizDate syoriPreYmd = pSyoriYmd.getPreviousDay();

        taskKensuuByActorInBean.setTaskcreatetimefrom("19700101000000000");
        taskKensuuByActorInBean.setTaskcreatetimeto(syoriPreYmd.toString().concat("235959999"));
        taskKensuuByActorInBean.setTaskendumu("1");

        GetTaskKensuuByActorOutBean taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {
            if (!"IWF4020".equals(resultBean.getSyousaiMessageCd())) {
                resultBean.setErrHasseiSyoriNm("TaskSummaryByActor");
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());

                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean taskSummaryByActorBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {

                if (BizUtil.isBlank(taskSummaryByActorBean.getUserId())) {
                    userId = WorkFlowUtilityConstants.USERID_KYOUYUU;
                }
                else {
                    userId = taskSummaryByActorBean.getUserId();
                }

                String countOfJimutetuzukiBetuMapKey = taskSummaryByActorBean.getFlowId() + "." + userId;
                if (!countOfJimutetuzukiBetuMap.containsKey(countOfJimutetuzukiBetuMapKey)) {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean = new CountOfJimutetuzukiBetuBean();
                    countOfJimutetuzukiBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfJimutetuzukiBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfJimutetuzukiBetuBean.setAccountId(userId);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("0");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
                else {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean =
                        countOfJimutetuzukiBetuMap.get(countOfJimutetuzukiBetuMapKey);

                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(
                        countOfJimutetuzukiBetuBean.getCountOfprocessLeftYesterday().add(
                            BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }

                CountOfTaskBetuBean countOfTaskBetuBean = new CountOfTaskBetuBean();
                countOfTaskBetuBean.setKensuuHokanYmd(pSyoriYmd);
                countOfTaskBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                countOfTaskBetuBean.setTaskid(taskSummaryByActorBean.getTaskName());
                countOfTaskBetuBean.setAccountId(userId);
                countOfTaskBetuBean.setCountOfprocessLeftYesterday(BizNumber.valueOf(
                    Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                countOfTaskBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                countOfTaskBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);

                countOfTaskBetuMap.put(taskSummaryByActorBean.getFlowId() + "." + taskSummaryByActorBean.getTaskName()
                    + "." + userId, countOfTaskBetuBean);
            }
        }

        taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();
        taskKensuuByActorInBean.setTaskcreatetimefrom("19700101000000000");
        taskKensuuByActorInBean.setTaskcreatetimeto(syoriPreYmd.toString().concat("235959999"));
        taskKensuuByActorInBean.setTaskendtimefrom(pSyoriYmd.toString().concat("00000000"));
        taskKensuuByActorInBean.setTaskendtimeto("99991231235959999");
        taskKensuuByActorInBean.setTaskendumu("0");

        taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {
            if (!"IWF4020".equals(resultBean.getSyousaiMessageCd())) {
                resultBean.setErrHasseiSyoriNm("TaskSummaryByActor");
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());

                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean taskSummaryByActorBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {
                if (BizUtil.isBlank(taskSummaryByActorBean.getUserId())) {
                    userId = WorkFlowUtilityConstants.USERID_KYOUYUU;
                }
                else {
                    userId = taskSummaryByActorBean.getUserId();
                }

                String countOfJimutetuzukiBetuMapKey = taskSummaryByActorBean.getFlowId() + "." + userId;

                if (!countOfJimutetuzukiBetuMap.containsKey(countOfJimutetuzukiBetuMapKey)) {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean = new CountOfJimutetuzukiBetuBean();
                    countOfJimutetuzukiBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfJimutetuzukiBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfJimutetuzukiBetuBean.setAccountId(userId);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("0");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
                else {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean =
                        countOfJimutetuzukiBetuMap.get(countOfJimutetuzukiBetuMapKey);

                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(
                        countOfJimutetuzukiBetuBean.getCountOfprocessLeftYesterday().add(
                            BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }

                String countOfTaskBetuMapKey = taskSummaryByActorBean.getFlowId() + "." +
                    taskSummaryByActorBean.getTaskName() + "." + userId;

                if (!countOfTaskBetuMap.containsKey(countOfTaskBetuMapKey)) {
                    CountOfTaskBetuBean countOfTaskBetuBean = new CountOfTaskBetuBean();
                    countOfTaskBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfTaskBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfTaskBetuBean.setTaskid(taskSummaryByActorBean.getTaskName());
                    countOfTaskBetuBean.setAccountId(userId);
                    countOfTaskBetuBean.setCountOfprocessLeftYesterday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfTaskBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfTaskBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
                else {
                    CountOfTaskBetuBean countOfTaskBetuBean = countOfTaskBetuMap.get(countOfTaskBetuMapKey);

                    countOfTaskBetuBean.setCountOfprocessLeftYesterday(
                        countOfTaskBetuBean.getCountOfprocessLeftYesterday().add(
                            BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
            }
        }

        taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();
        taskKensuuByActorInBean.setTaskcreatetimefrom("19700101000000000");
        taskKensuuByActorInBean.setTaskcreatetimeto(pSyoriYmd.toString().concat("235959999"));
        taskKensuuByActorInBean.setTaskendumu("1");

        taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {
            if (!"IWF4020".equals(resultBean.getSyousaiMessageCd())) {
                resultBean.setErrHasseiSyoriNm("TaskSummaryByActor");
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());

                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean taskSummaryByActorBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {
                if (BizUtil.isBlank(taskSummaryByActorBean.getUserId())) {
                    userId = WorkFlowUtilityConstants.USERID_KYOUYUU;
                }
                else {
                    userId = taskSummaryByActorBean.getUserId();
                }

                String countOfJimutetuzukiBetuMapKey = taskSummaryByActorBean.getFlowId() + "." + userId;

                if (!countOfJimutetuzukiBetuMap.containsKey(countOfJimutetuzukiBetuMapKey)) {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean = new CountOfJimutetuzukiBetuBean();
                    countOfJimutetuzukiBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfJimutetuzukiBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfJimutetuzukiBetuBean.setAccountId(userId);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("0");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
                else {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean =
                        countOfJimutetuzukiBetuMap.get(countOfJimutetuzukiBetuMapKey);

                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(
                        countOfJimutetuzukiBetuBean.getCountOfprocessLeftToday().add(
                            BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }

                String countOfTaskBetuMapKey = taskSummaryByActorBean.getFlowId() + "." +
                    taskSummaryByActorBean.getTaskName() + "." + userId;

                if (!countOfTaskBetuMap.containsKey(countOfTaskBetuMapKey)) {
                    CountOfTaskBetuBean countOfTaskBetuBean = new CountOfTaskBetuBean();
                    countOfTaskBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfTaskBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfTaskBetuBean.setTaskid(taskSummaryByActorBean.getTaskName());
                    countOfTaskBetuBean.setAccountId(userId);
                    countOfTaskBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfTaskBetuBean.setCountOfprocessLeftToday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfTaskBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
                else {
                    CountOfTaskBetuBean countOfTaskBetuBean = countOfTaskBetuMap.get(countOfTaskBetuMapKey);

                    countOfTaskBetuBean.setCountOfprocessLeftToday(countOfTaskBetuBean.getCountOfprocessLeftToday().add(
                        BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
            }
        }

        taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();
        taskKensuuByActorInBean.setTaskcreatetimefrom("19700101000000000");
        taskKensuuByActorInBean.setTaskcreatetimeto(pSyoriYmd.toString().concat("235959999"));
        taskKensuuByActorInBean.setTaskendtimefrom(pSyoriYmd.getNextDay().toString().concat("00000000"));
        taskKensuuByActorInBean.setTaskendtimeto("99991231235959999");
        taskKensuuByActorInBean.setTaskendumu("0");

        taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {
            if (!"IWF4020".equals(resultBean.getSyousaiMessageCd())) {
                resultBean.setErrHasseiSyoriNm("TaskSummaryByActor");
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());

                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean taskSummaryByActorBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {
                if (BizUtil.isBlank(taskSummaryByActorBean.getUserId())) {
                    userId = WorkFlowUtilityConstants.USERID_KYOUYUU;
                }
                else {
                    userId = taskSummaryByActorBean.getUserId();
                }

                String countOfJimutetuzukiBetuMapKey = taskSummaryByActorBean.getFlowId() + "." + userId;

                if (!countOfJimutetuzukiBetuMap.containsKey(countOfJimutetuzukiBetuMapKey)) {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean = new CountOfJimutetuzukiBetuBean();
                    countOfJimutetuzukiBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfJimutetuzukiBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfJimutetuzukiBetuBean.setAccountId(userId);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("0");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
                else {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean =
                        countOfJimutetuzukiBetuMap.get(countOfJimutetuzukiBetuMapKey);

                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(
                        countOfJimutetuzukiBetuBean.getCountOfprocessLeftToday().add(
                            BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }

                String countOfTaskBetuMapKey = taskSummaryByActorBean.getFlowId() + "." +
                    taskSummaryByActorBean.getTaskName() + "." + userId;

                if (!countOfTaskBetuMap.containsKey(countOfTaskBetuMapKey)) {
                    CountOfTaskBetuBean countOfTaskBetuBean = new CountOfTaskBetuBean();
                    countOfTaskBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfTaskBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfTaskBetuBean.setTaskid(taskSummaryByActorBean.getTaskName());
                    countOfTaskBetuBean.setAccountId(userId);
                    countOfTaskBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfTaskBetuBean.setCountOfprocessLeftToday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));
                    countOfTaskBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
                else {
                    CountOfTaskBetuBean countOfTaskBetuBean = countOfTaskBetuMap.get(countOfTaskBetuMapKey);

                    countOfTaskBetuBean.setCountOfprocessLeftToday(countOfTaskBetuBean.getCountOfprocessLeftToday().add(
                        BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
            }
        }

        taskKensuuByActorInBean = new GetTaskKensuuByActorInBean();
        taskKensuuByActorInBean.setTaskendtimefrom(pSyoriYmd.toString().concat("00000000"));
        taskKensuuByActorInBean.setTaskendtimeto(pSyoriYmd.toString().concat("235959999"));
        taskKensuuByActorInBean.setTaskendumu("0");

        taskKensuuByActorOutBean = iwfKouteiClient.execGetTaskKensuuByActor(taskKensuuByActorInBean);

        resultBean.setSyousaiMessageCd(taskKensuuByActorOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(taskKensuuByActorOutBean.getSyousaimsg());

        if (!WorkFlowResultConstants.RESULT_OK.equals(taskKensuuByActorOutBean.getKekkastatus())) {
            if (!"IWF4020".equals(resultBean.getSyousaiMessageCd())) {
                resultBean.setErrHasseiSyoriNm("TaskSummaryByActor");
                resultBean.setSyorikekkaStatus(taskKensuuByActorOutBean.getKekkastatus());

                return resultBean;
            }
        }

        if (taskKensuuByActorOutBean.getTaskSummaryByActorBeanList() != null) {
            for (TaskSummaryByActorBean taskSummaryByActorBean : taskKensuuByActorOutBean.getTaskSummaryByActorBeanList()) {
                if (BizUtil.isBlank(taskSummaryByActorBean.getUserId())) {
                    userId = WorkFlowUtilityConstants.USERID_KYOUYUU;
                }
                else {
                    userId = taskSummaryByActorBean.getUserId();
                }

                String countOfJimutetuzukiBetuMapKey = taskSummaryByActorBean.getFlowId() + "." + userId;

                if (!countOfJimutetuzukiBetuMap.containsKey(countOfJimutetuzukiBetuMapKey)) {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean = new CountOfJimutetuzukiBetuBean();
                    countOfJimutetuzukiBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfJimutetuzukiBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfJimutetuzukiBetuBean.setAccountId(userId);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("1");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
                else {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean =
                        countOfJimutetuzukiBetuMap.get(countOfJimutetuzukiBetuMapKey);

                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("1");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }

                String countOfTaskBetuMapKey = taskSummaryByActorBean.getFlowId() + "." +
                    taskSummaryByActorBean.getTaskName() + "." + userId;

                if (!countOfTaskBetuMap.containsKey(countOfTaskBetuMapKey)) {
                    CountOfTaskBetuBean countOfTaskBetuBean = new CountOfTaskBetuBean();
                    countOfTaskBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfTaskBetuBean.setJimutetuzukiCd(taskSummaryByActorBean.getFlowId());
                    countOfTaskBetuBean.setTaskid(taskSummaryByActorBean.getTaskName());
                    countOfTaskBetuBean.setAccountId(userId);
                    countOfTaskBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfTaskBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfTaskBetuBean.setCountOfprocessFinToday(BizNumber.valueOf(
                        Integer.valueOf(taskSummaryByActorBean.getTaskCount())));

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
                else {
                    CountOfTaskBetuBean countOfTaskBetuBean = countOfTaskBetuMap.get(countOfTaskBetuMapKey);

                    countOfTaskBetuBean.setCountOfprocessFinToday(countOfTaskBetuBean.getCountOfprocessFinToday().add(
                        BizNumber.valueOf(Integer.valueOf(taskSummaryByActorBean.getTaskCount()))));

                    countOfTaskBetuMap.put(countOfTaskBetuMapKey, countOfTaskBetuBean);
                }
            }
        }

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getAllJimutetuzuki();
        GetProcessSummaryInBean getProcessSummaryInBean = new GetProcessSummaryInBean();

        String[] flowIds = new String[jimutetuzukiLst.size()];
        for (int i = 0; i < jimutetuzukiLst.size(); i++) {
            flowIds[i] = jimutetuzukiLst.get(i).getJimutetuzukicd();
        }

        getProcessSummaryInBean.setFlowids(flowIds);
        getProcessSummaryInBean.setKouteikanryoubifrom(pSyoriYmd.toString());
        getProcessSummaryInBean.setKouteikanryoubito(pSyoriYmd.toString());
        getProcessSummaryInBean.setSyoristatus(new String[]{"90"});

        GetProcessSummaryOutBean getProcessSummaryOutBean = iwfKouteiClient
            .execGetProcessSummary(getProcessSummaryInBean);
        resultBean.setSyousaiMessageCd(getProcessSummaryOutBean.getSyousaimsgcd());
        resultBean.setSyousaiMessage(getProcessSummaryOutBean.getSyousaimsg());
        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessSummaryOutBean.getKekkastatus())) {
            resultBean.setErrHasseiSyoriNm("ProcessSummary");
            resultBean.setSyorikekkaStatus(getProcessSummaryOutBean.getKekkastatus());
            return resultBean;
        }

        if (getProcessSummaryOutBean.getProcessSummaryBeanList() != null) {
            for (ProcessSummaryBean processSummaryBean : getProcessSummaryOutBean.getProcessSummaryBeanList()) {

                String countOfJimutetuzukiBetuMapKey = processSummaryBean.getFlowId() + "." +
                    processSummaryBean.getPreviousAccountId();

                if (!countOfJimutetuzukiBetuMap.containsKey(countOfJimutetuzukiBetuMapKey)) {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean = new CountOfJimutetuzukiBetuBean();
                    countOfJimutetuzukiBetuBean.setKensuuHokanYmd(pSyoriYmd);
                    countOfJimutetuzukiBetuBean.setJimutetuzukiCd(processSummaryBean.getFlowId());
                    countOfJimutetuzukiBetuBean.setAccountId(processSummaryBean.getPreviousAccountId());
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftYesterday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(BizNumber.ONE);
                    countOfJimutetuzukiBetuBean.setTaskKanryouKensuuarihyouji("1");

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
                else {
                    CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean =
                        countOfJimutetuzukiBetuMap.get(countOfJimutetuzukiBetuMapKey);

                    countOfJimutetuzukiBetuBean.setCountOfprocessFinToday(
                        countOfJimutetuzukiBetuBean.getCountOfprocessFinToday().add(BizNumber.ONE));

                    countOfJimutetuzukiBetuMap.put(countOfJimutetuzukiBetuMapKey, countOfJimutetuzukiBetuBean);
                }
            }
        }

        countOfJimutetuzukiBetuBeanList = new ArrayList<CountOfJimutetuzukiBetuBean>(countOfJimutetuzukiBetuMap.values());

        countOfTaskBetuBeanList = new ArrayList<CountOfTaskBetuBean>(countOfTaskBetuMap.values());

        if (countOfJimutetuzukiBetuBeanList != null && countOfJimutetuzukiBetuBeanList.size() > 0) {
            try (EntityInserter<DT_SyoriKensuuHokanJimu> syoriKensuuHokanJimuLst = new EntityInserter<>()) {
                for (CountOfJimutetuzukiBetuBean countOfJimutetuzukiBetuBean : countOfJimutetuzukiBetuBeanList) {
                    DT_SyoriKensuuHokanJimu syoriKensuuHokanJimu = new DT_SyoriKensuuHokanJimu();

                    syoriKensuuHokanJimu.setKensuuHokanYmd(countOfJimutetuzukiBetuBean.getKensuuHokanYmd());
                    syoriKensuuHokanJimu.setJimutetuzukicd(countOfJimutetuzukiBetuBean.getJimutetuzukiCd());
                    syoriKensuuHokanJimu.setAccountId(countOfJimutetuzukiBetuBean.getAccountId());
                    syoriKensuuHokanJimu.setZenjituzanKensuu(countOfJimutetuzukiBetuBean.getCountOfprocessLeftYesterday());
                    syoriKensuuHokanJimu.setZanKensuu(countOfJimutetuzukiBetuBean.getCountOfprocessLeftToday());
                    syoriKensuuHokanJimu.setKanryoKensuu(countOfJimutetuzukiBetuBean.getCountOfprocessFinToday());
                    syoriKensuuHokanJimu.setTaskKanryouKensuuarihyouji(countOfJimutetuzukiBetuBean.getTaskKanryouKensuuarihyouji());

                    BizPropertyInitializer.initialize(syoriKensuuHokanJimu);

                    syoriKensuuHokanJimuLst.add(syoriKensuuHokanJimu);

                    kensuuOfSyoriKensuuHokanJimu++;
                }
            }
            catch (Exception e) {
                resultBean.setSyousaiMessageCd("EBF0130");

                resultBean.setSyousaiMessage("キーが重複している為、登録されません。（処理件数保管（事務手続別）テーブル）");

                resultBean.setErrHasseiSyoriNm("DT_SyoriKensuuHokanJimu");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);

                return resultBean;
            }
        }

        if (countOfTaskBetuBeanList != null && countOfTaskBetuBeanList.size() > 0) {
            try (EntityInserter<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskLst = new EntityInserter<>()) {
                for (CountOfTaskBetuBean countOfTaskBetuBean : countOfTaskBetuBeanList) {
                    DT_SyoriKensuuHokanTask syoriKensuuHokanTask = new DT_SyoriKensuuHokanTask();

                    syoriKensuuHokanTask.setKensuuHokanYmd(countOfTaskBetuBean.getKensuuHokanYmd());
                    syoriKensuuHokanTask.setJimutetuzukicd(countOfTaskBetuBean.getJimutetuzukiCd());
                    syoriKensuuHokanTask.setTskid(countOfTaskBetuBean.getTaskid());
                    syoriKensuuHokanTask.setAccountId(countOfTaskBetuBean.getAccountId());
                    syoriKensuuHokanTask.setZenjituzanKensuu(countOfTaskBetuBean.getCountOfprocessLeftYesterday());
                    syoriKensuuHokanTask.setZanKensuu(countOfTaskBetuBean.getCountOfprocessLeftToday());
                    syoriKensuuHokanTask.setKanryoKensuu(countOfTaskBetuBean.getCountOfprocessFinToday());

                    BizPropertyInitializer.initialize(syoriKensuuHokanTask);

                    syoriKensuuHokanTaskLst.add(syoriKensuuHokanTask);

                    kensuuOfSyoriKensuuHokanTask++;
                }
            }
            catch (Exception e) {
                resultBean.setSyousaiMessageCd("EBF0130");

                resultBean.setSyousaiMessage("キーが重複している為、登録されません。（処理件数保管（タスク別）テーブル）");

                resultBean.setErrHasseiSyoriNm("DT_SyoriKensuuHokanTask");

                resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);

                return resultBean;
            }
        }

        try (EntityInserter<DM_JimutetuzukiRireki> jimutetuzukiRirekiLst = new EntityInserter<>()) {
            for (DM_Jimutetuzuki jimutetuzuki : jimutetuzukiLst) {
                DM_JimutetuzukiRireki jimutetuzukiRireki = new DM_JimutetuzukiRireki();

                jimutetuzukiRireki.setKensuuHokanYmd(pSyoriYmd);
                jimutetuzukiRireki.setJimutetuzukicd(jimutetuzuki.getJimutetuzukicd());
                jimutetuzukiRireki.setSubSystemId(jimutetuzuki.getSubSystemId());
                jimutetuzukiRireki.setJimutetuzukinm(jimutetuzuki.getJimutetuzukinm());
                jimutetuzukiRireki.setImagerenkeikbn(jimutetuzuki.getImagerenkeikbn());
                jimutetuzukiRireki.setHyoujijyun(jimutetuzuki.getHyoujijyun());
                jimutetuzukiRireki.setSyukouteijimutetuzukicd(jimutetuzuki.getSyukouteijimutetuzukicd());

                BizPropertyInitializer.initialize(jimutetuzukiRireki);

                jimutetuzukiRirekiLst.add(jimutetuzukiRireki);
                kensuuOfJimutetuzukiRireki++;
            }
        }

        List<DM_JimutetuzukiTask> jimutetuzukiTaskList = Lists.newArrayList();
        for (DM_Jimutetuzuki jimutetuzuki : jimutetuzukiLst) {
            jimutetuzukiTaskList.addAll(jimutetuzuki.getJimutetuzukiTasks());
        }

        try (EntityInserter<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiLst = new EntityInserter<>()) {
            for (DM_JimutetuzukiTask jimutetuzukiTask : jimutetuzukiTaskList) {
                DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki = new DM_JimutetuzukiTaskRireki();

                jimutetuzukiTaskRireki.setKensuuHokanYmd(pSyoriYmd);
                jimutetuzukiTaskRireki.setSubSystemId(jimutetuzukiTask.getSubSystemId());
                jimutetuzukiTaskRireki.setJimutetuzukicd(jimutetuzukiTask.getJimutetuzukicd());
                jimutetuzukiTaskRireki.setWorkflowTskId(jimutetuzukiTask.getWorkflowTskId());
                jimutetuzukiTaskRireki.setWorkflowTskNm(jimutetuzukiTask.getWorkflowTskNm());
                jimutetuzukiTaskRireki.setHyoujijyun(jimutetuzukiTask.getHyoujijyun());
                jimutetuzukiTaskRireki.setWorklistHyoujiFlag(jimutetuzukiTask.getWorklistHyoujiFlag());

                BizPropertyInitializer.initialize(jimutetuzukiTaskRireki);

                jimutetuzukiTaskRirekiLst.add(jimutetuzukiTaskRireki);

                kensuuOfJimutetuzukiTaskRireki++;
            }
        }

        resultBean.setKensuuOfSyoriKensuuHokanJimu(String.valueOf(kensuuOfSyoriKensuuHokanJimu));
        resultBean.setKensuuOfSyoriKensuuHokanTask(String.valueOf(kensuuOfSyoriKensuuHokanTask));
        resultBean.setKensuuOfJimutetuzukiRireki(String.valueOf(kensuuOfJimutetuzukiRireki));
        resultBean.setKensuuOfJimutetuzukiTaskRireki(String.valueOf(kensuuOfJimutetuzukiTaskRireki));

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfKakoJissekiTaskSummaryBySubsystem(
        String[] pSubsystemId, BizDate pSyoriYmd,  String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanList = new ArrayList<CountOfTaskSummaryBySubsystemBean>();
        CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBySubsystemBean;
        LinkedHashMap<String, CountOfTaskSummaryBySubsystemBean> map = Maps.newLinkedHashMap();
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiList = Lists.newArrayList();

        if (pSubsystemId != null && pSubsystemId.length > 0 && pSyoriYmd != null) {
            jimutetuzukiRirekiList = workflowUtilityDao.getJimutetuzukiRirekisBySyoriYmdSubSystemIds(
                pSyoriYmd, pSubsystemId);
        }

        if (jimutetuzukiRirekiList.size() == 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);

            return resultBean;
        }

        for (DM_JimutetuzukiRireki jimutetuzukiRireki : jimutetuzukiRirekiList) {
            List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = jimutetuzukiRireki.getJimutetuzukiTaskRirekis();

            for (DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki : jimutetuzukiTaskRirekiList) {

                if (jimutetuzukiTaskRireki.getWorklistHyoujiFlag() == 1) {
                    String jimutetuzukiCd = jimutetuzukiRireki.getJimutetuzukicd();

                    if (!map.containsKey(jimutetuzukiCd)) {

                        countOfTaskSummaryBySubsystemBean = new CountOfTaskSummaryBySubsystemBean();

                        countOfTaskSummaryBySubsystemBean.setJimutetuzukiCd(jimutetuzukiCd);
                        countOfTaskSummaryBySubsystemBean.setJimutetuzukiNm(jimutetuzukiRireki.getJimutetuzukinm());
                        countOfTaskSummaryBySubsystemBean.setCountOfprocessStartToday(BizNumber.ZERO);
                        countOfTaskSummaryBySubsystemBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                        countOfTaskSummaryBySubsystemBean.setCountOfprocessFinToday(BizNumber.ZERO);
                        countOfTaskSummaryBySubsystemBean.setTaskFinByActorFlg(false);

                        map.put(jimutetuzukiCd, countOfTaskSummaryBySubsystemBean);
                    }
                }
            }
        }

        String[] mapKeys = new String[map.size()];
        int count = 0;
        for (String key : map.keySet()) {
            mapKeys[count] = key;

            count++;
        }

        List<DT_SyoriKensuuHokanJimu> syoriKensuuHokanJimuList = Lists.newArrayList();
        if (mapKeys.length > 0) {
            syoriKensuuHokanJimuList =
                workflowUtilityDao.getSyoriKensuuHokanJimuByKensuHokanbiJimutetuzukiAccountIds(
                    pSyoriYmd, mapKeys, pUserId);
        }

        for (String key : map.keySet()) {

            for (DT_SyoriKensuuHokanJimu syoriKensuuHokanJimu : syoriKensuuHokanJimuList) {
                if (syoriKensuuHokanJimu.getJimutetuzukicd().equals(key)) {
                    countOfTaskSummaryBySubsystemBean = map.get(key);
                    countOfTaskSummaryBySubsystemBean.setCountOfprocessStartToday(
                        countOfTaskSummaryBySubsystemBean.getCountOfprocessStartToday().add(
                            syoriKensuuHokanJimu.getZenjituzanKensuu()));
                    countOfTaskSummaryBySubsystemBean.setCountOfprocessLeftToday(
                        countOfTaskSummaryBySubsystemBean.getCountOfprocessLeftToday().add(
                            syoriKensuuHokanJimu.getZanKensuu()));
                    countOfTaskSummaryBySubsystemBean.setCountOfprocessFinToday(
                        countOfTaskSummaryBySubsystemBean.getCountOfprocessFinToday().add(
                            syoriKensuuHokanJimu.getKanryoKensuu()));

                    if (WorkFlowUtilityConstants.TASKKANRYOUKENSUUARI_FLAG_ARI.equals(
                        syoriKensuuHokanJimu.getTaskKanryouKensuuarihyouji())) {
                        countOfTaskSummaryBySubsystemBean.setTaskFinByActorFlg(true);
                    }

                    map.put(key, countOfTaskSummaryBySubsystemBean);
                }
            }
        }
        countOfTaskSummaryBySubsystemBeanList = new ArrayList<CountOfTaskSummaryBySubsystemBean>(map.values());
        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBySubsystemBeanList);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfKakoJissekiTaskSummaryByJimutetuzuki(
        String[] pSubsystemId, BizDate pSyoriYmd, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanList =
            new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>();
        CountOfTaskSummaryByJimutetuzukiBean countOfTaskSummaryByJimutetuzukiBean;
        LinkedHashMap<String, CountOfTaskSummaryByJimutetuzukiBean> map = Maps.newLinkedHashMap();
        HashSet<String> workListDispFlagManage = new HashSet<>();
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiList = Lists.newArrayList();

        jimutetuzukiRirekiList = workflowUtilityDao.getJimutetuzukiRirekisBySyoriYmdJimutetuzukiSubSystemIds(
            pSyoriYmd, pJimutetuzukiCd, pSubsystemId);

        if (jimutetuzukiRirekiList.size() == 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = Lists.newArrayList();
        for (DM_JimutetuzukiRireki jimutetuzukiRireki : jimutetuzukiRirekiList) {
            jimutetuzukiTaskRirekiList.addAll(jimutetuzukiRireki.getJimutetuzukiTaskRirekis());
        }
        Ordering<DM_JimutetuzukiTaskRireki> ordering = Ordering.natural().nullsFirst()
            .onResultOf(new WorkflowDMJimutetuzukiTaskRirekiSortFunction());
        List<DM_JimutetuzukiTaskRireki> sortedJimutetuzukiTaskRirekiList =
            ordering.sortedCopy(jimutetuzukiTaskRirekiList);

        for (DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki : sortedJimutetuzukiTaskRirekiList) {
            String workflowTskId = jimutetuzukiTaskRireki.getWorkflowTskId();

            if (jimutetuzukiTaskRireki.getWorklistHyoujiFlag() == 1) {

                workListDispFlagManage.add(workflowTskId);

                if (!map.containsKey(workflowTskId)) {

                    countOfTaskSummaryByJimutetuzukiBean = new CountOfTaskSummaryByJimutetuzukiBean();

                    countOfTaskSummaryByJimutetuzukiBean.setJimutetuzukiCd(jimutetuzukiTaskRireki.getJimutetuzukicd());
                    countOfTaskSummaryByJimutetuzukiBean.setTaskNm(workflowTskId);
                    countOfTaskSummaryByJimutetuzukiBean.setDispTaskNm(jimutetuzukiTaskRireki.getWorkflowTskNm());
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessStartToday(BizNumber.ZERO);
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    map.put(workflowTskId, countOfTaskSummaryByJimutetuzukiBean);
                }
            }
        }

        String[] mapKeys = new String[map.size()];
        int count = 0;
        for (String key : map.keySet()) {
            mapKeys[count] = key;

            count++;
        }

        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskList = Lists.newArrayList();
        if (mapKeys.length > 0) {
            syoriKensuuHokanTaskList =
                workflowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiJimutetuzukiTaskIdAccountIds(
                    pSyoriYmd, pJimutetuzukiCd, mapKeys, pUserId);
        }

        for (String key : map.keySet()) {
            for (DT_SyoriKensuuHokanTask syoriKensuuHokanTask : syoriKensuuHokanTaskList) {
                if (syoriKensuuHokanTask.getTskid().equals(key)) {
                    countOfTaskSummaryByJimutetuzukiBean = map.get(key);

                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessStartToday(
                        countOfTaskSummaryByJimutetuzukiBean.getCountOfprocessStartToday().add(
                            syoriKensuuHokanTask.getZenjituzanKensuu()));
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessLeftToday(
                        countOfTaskSummaryByJimutetuzukiBean.getCountOfprocessLeftToday().add(
                            syoriKensuuHokanTask.getZanKensuu()));
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessFinToday(
                        countOfTaskSummaryByJimutetuzukiBean.getCountOfprocessFinToday().add(
                            syoriKensuuHokanTask.getKanryoKensuu()));

                    map.put(key, countOfTaskSummaryByJimutetuzukiBean);
                }
            }
        }

        countOfTaskSummaryByJimutetuzukiBeanList = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>(map.values());

        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryByJimutetuzukiBeanList);

        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfKakoJissekiTaskSummaryByTask(BizDate pSyoriYmd,
        String pJimutetuzukiCd, String[] pTaskId, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryByTaskBeanList = new ArrayList<CountOfTaskSummaryByTaskBean>();
        CountOfTaskSummaryByTaskBean countOfTaskSummaryByTaskBean = new CountOfTaskSummaryByTaskBean();
        HashMap<String, CountOfTaskSummaryByTaskBean> map = Maps.newHashMap();
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskList = Lists.newArrayList();

        syoriKensuuHokanTaskList = workflowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiJimutetuzukiTaskIdAccountIds(
            pSyoriYmd, pJimutetuzukiCd, pTaskId, pUserId);

        for (DT_SyoriKensuuHokanTask syoriKensuuHokanTask : syoriKensuuHokanTaskList) {
            if (!map.containsKey(syoriKensuuHokanTask.getAccountId() + syoriKensuuHokanTask.getTskid())) {
                countOfTaskSummaryByTaskBean = new CountOfTaskSummaryByTaskBean();

                countOfTaskSummaryByTaskBean.setUserId(syoriKensuuHokanTask.getAccountId());

                countOfTaskSummaryByTaskBean.setCountOfprocessStartToday(syoriKensuuHokanTask.getZenjituzanKensuu());

                countOfTaskSummaryByTaskBean.setCountOfprocessLeftToday(syoriKensuuHokanTask.getZanKensuu());

                countOfTaskSummaryByTaskBean.setCountOfprocessFinToday(syoriKensuuHokanTask.getKanryoKensuu());

                countOfTaskSummaryByTaskBean.setJimutetuzukiCd(syoriKensuuHokanTask.getJimutetuzukicd());

                countOfTaskSummaryByTaskBean.setTaskNm(syoriKensuuHokanTask.getTskid());

                if (WorkFlowUtilityConstants.USERID_KYOUYUU.equals(syoriKensuuHokanTask.getAccountId())) {
                    countOfTaskSummaryByTaskBean.setUserId(null);

                    countOfTaskSummaryByTaskBean.setDispUserNm(WorkFlowUtilityConstants.KYOUYOU);
                }
                else {
                    BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                    AM_User userInfo = baseDomManager.getUser(syoriKensuuHokanTask.getAccountId());
                    if (userInfo == null) {
                        String accountId = ConvertUtil.toZenAll(syoriKensuuHokanTask.getAccountId(), 0, 0);
                        if (accountId.length() > 15) {
                            accountId = accountId.substring(0, 15);
                        }
                        countOfTaskSummaryByTaskBean.setDispUserNm(accountId);
                    }
                    else {
                        countOfTaskSummaryByTaskBean.setDispUserNm(userInfo.getUserNm());
                    }
                }

                map.put(syoriKensuuHokanTask.getAccountId() + syoriKensuuHokanTask.getTskid(), countOfTaskSummaryByTaskBean);
            }
        }
        countOfTaskSummaryByTaskBeanList = new ArrayList<CountOfTaskSummaryByTaskBean>(map.values());

        if (BizUtil.isBlank(pUserId)) {
            Ordering<CountOfTaskSummaryByTaskBean> ordering = Ordering.natural().nullsFirst()
                .onResultOf(new WorkflowCountOfTaskSummaryBeanSortFunction());
            List<CountOfTaskSummaryByTaskBean> sortedInfoItiran = ordering.sortedCopy(
                countOfTaskSummaryByTaskBeanList);

            resultBean.setCountOfTaskSummaryBean(sortedInfoItiran);
        }
        else {
            resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryByTaskBeanList);
        }
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetCountOfTaskSummaryBySubsystemResultBean getCountOfKakoJissekiTaskSummaryBySubsystem(
        String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pUserId) {

        GetCountOfTaskSummaryBySubsystemResultBean resultBean = new GetCountOfTaskSummaryBySubsystemResultBean();
        List<CountOfTaskSummaryBySubsystemBean> countOfTaskSummaryBySubsystemBeanLst =
            new ArrayList<CountOfTaskSummaryBySubsystemBean>();
        CountOfTaskSummaryBySubsystemBean countOfTaskSummaryBySubsystemBean;
        LinkedHashMap<String, CountOfTaskSummaryBySubsystemBean> map = Maps.newLinkedHashMap();
        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiLst = Lists.newArrayList();
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        if (pSubsystemId != null && pSubsystemId.length > 0 && pSyoriYmdFrom != null && pSyoriYmdTo != null) {
            jimutetuzukiRirekiLst = workflowUtilityDao.getJimutetuzukiRirekisByFromtoSyoriYmdSubSystemIds(
                pSyoriYmdFrom, pSyoriYmdTo, pSubsystemId);
        }
        if (jimutetuzukiRirekiLst.size() == 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);

            return resultBean;
        }

        for (DM_JimutetuzukiRireki jimutetuzukiRireki : jimutetuzukiRirekiLst) {
            List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = jimutetuzukiRireki.getJimutetuzukiTaskRirekis();

            for (DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki : jimutetuzukiTaskRirekiList) {

                if (jimutetuzukiTaskRireki.getWorklistHyoujiFlag() == 1) {
                    String jimutetuzukiCd = jimutetuzukiRireki.getJimutetuzukicd();

                    if (!map.containsKey(jimutetuzukiCd)) {

                        countOfTaskSummaryBySubsystemBean = new CountOfTaskSummaryBySubsystemBean();

                        countOfTaskSummaryBySubsystemBean.setJimutetuzukiCd(jimutetuzukiCd);
                        countOfTaskSummaryBySubsystemBean.setJimutetuzukiNm(jimutetuzukiRireki.getJimutetuzukinm());
                        countOfTaskSummaryBySubsystemBean.setCountOfprocessStartToday(BizNumber.ZERO);
                        countOfTaskSummaryBySubsystemBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                        countOfTaskSummaryBySubsystemBean.setCountOfprocessFinToday(BizNumber.ZERO);
                        countOfTaskSummaryBySubsystemBean.setTaskFinByActorFlg(false);

                        map.put(jimutetuzukiCd, countOfTaskSummaryBySubsystemBean);
                    }
                }
            }
        }
        String[] mapKeys = new String[map.size()];
        int count = 0;
        for (String key : map.keySet()) {
            mapKeys[count] = key;
            count++;
        }
        List<DT_SyoriKensuuHokanJimu> syoriKensuuHokanJimuLst = Lists.newArrayList();
        if (mapKeys.length > 0) {
            syoriKensuuHokanJimuLst =
                workflowUtilityDao.getSyoriKensuuHokanJimuByKensuHokanbiFromtoJimutetuzukiAccountIds(
                    pSyoriYmdFrom, pSyoriYmdTo, mapKeys, pUserId);
        }
        for (String key : map.keySet()) {
            for (DT_SyoriKensuuHokanJimu syoriKensuuHokanJimu : syoriKensuuHokanJimuLst) {

                if (syoriKensuuHokanJimu.getJimutetuzukicd().equals(key)) {

                    CountOfTaskSummaryBySubsystemBean tmpCountOfTaskSummaryBySubsystemBean = map.get(key);
                    tmpCountOfTaskSummaryBySubsystemBean.setCountOfprocessStartToday(
                        tmpCountOfTaskSummaryBySubsystemBean.getCountOfprocessStartToday().add(
                            syoriKensuuHokanJimu.getZenjituzanKensuu()));
                    tmpCountOfTaskSummaryBySubsystemBean.setCountOfprocessLeftToday(
                        tmpCountOfTaskSummaryBySubsystemBean.getCountOfprocessLeftToday().add(
                            syoriKensuuHokanJimu.getZanKensuu()));
                    tmpCountOfTaskSummaryBySubsystemBean.setCountOfprocessFinToday(
                        tmpCountOfTaskSummaryBySubsystemBean.getCountOfprocessFinToday().add(
                            syoriKensuuHokanJimu.getKanryoKensuu()));

                    if (WorkFlowUtilityConstants.TASKKANRYOUKENSUUARI_FLAG_ARI.equals(
                        syoriKensuuHokanJimu.getTaskKanryouKensuuarihyouji())) {
                        tmpCountOfTaskSummaryBySubsystemBean.setTaskFinByActorFlg(true);
                    }

                    map.put(tmpCountOfTaskSummaryBySubsystemBean.getJimutetuzukiCd(),
                        tmpCountOfTaskSummaryBySubsystemBean);
                }
            }
        }
        countOfTaskSummaryBySubsystemBeanLst = new ArrayList<CountOfTaskSummaryBySubsystemBean>(map.values());
        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryBySubsystemBeanLst);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetCountOfTaskSummaryByJimutetuzukiResultBean getCountOfTaskSummaryByJimutetuzuki(
        String[] pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String pUserId) {

        GetCountOfTaskSummaryByJimutetuzukiResultBean resultBean = new GetCountOfTaskSummaryByJimutetuzukiResultBean();
        List<CountOfTaskSummaryByJimutetuzukiBean> countOfTaskSummaryByJimutetuzukiBeanLst =
            new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>();
        CountOfTaskSummaryByJimutetuzukiBean countOfTaskSummaryByJimutetuzukiBean =
            new CountOfTaskSummaryByJimutetuzukiBean();
        HashSet<String> workListDispFlagManage = new HashSet<>();
        LinkedHashMap<String, CountOfTaskSummaryByJimutetuzukiBean> map = Maps.newLinkedHashMap();
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DM_JimutetuzukiRireki> jimutetuzukiRirekiLst = Lists.newArrayList();
        List<DM_JimutetuzukiTaskRireki> jimutetuzukiTaskRirekiList = Lists.newArrayList();


        jimutetuzukiRirekiLst = workflowUtilityDao.getJimutetuzukiRirekisBySyoriYmdFromtoJimutetuzukiSubSystemIds(
            pSyoriYmdFrom, pSyoriYmdTo, pJimutetuzukiCd, pSubsystemId);

        if (jimutetuzukiRirekiLst.size() == 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }

        for (DM_JimutetuzukiRireki jimutetuzukiRireki : jimutetuzukiRirekiLst) {
            jimutetuzukiTaskRirekiList.addAll(jimutetuzukiRireki.getJimutetuzukiTaskRirekis());
        }

        List<DM_JimutetuzukiTaskRireki> sortedJimutetuzukiTaskLst = Lists.newArrayList();

        if (jimutetuzukiTaskRirekiList.size() > 0) {
            Ordering<DM_JimutetuzukiTaskRireki> ordering = Ordering.from(
                new WorkflowDMJimutetuzukiTaskRirekiSortComparator());
            sortedJimutetuzukiTaskLst = ordering.sortedCopy(jimutetuzukiTaskRirekiList);
        }

        for (DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki : sortedJimutetuzukiTaskLst) {
            if (jimutetuzukiTaskRireki.getWorklistHyoujiFlag() == 1) {

                workListDispFlagManage.add(jimutetuzukiTaskRireki.getWorkflowTskId());

                if (!map.containsKey(jimutetuzukiTaskRireki.getWorkflowTskId())) {

                    countOfTaskSummaryByJimutetuzukiBean = new CountOfTaskSummaryByJimutetuzukiBean();

                    countOfTaskSummaryByJimutetuzukiBean.setJimutetuzukiCd(
                        jimutetuzukiTaskRireki.getJimutetuzukicd());
                    countOfTaskSummaryByJimutetuzukiBean.setTaskNm(jimutetuzukiTaskRireki.getWorkflowTskId());
                    countOfTaskSummaryByJimutetuzukiBean.setDispTaskNm(jimutetuzukiTaskRireki.getWorkflowTskNm());
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessStartToday(BizNumber.ZERO);
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                    countOfTaskSummaryByJimutetuzukiBean.setCountOfprocessFinToday(BizNumber.ZERO);

                    map.put(jimutetuzukiTaskRireki.getWorkflowTskId(), countOfTaskSummaryByJimutetuzukiBean);
                }
            }
        }

        String[] mapKeys = new String[map.size()];
        int count = 0;
        for (String key : map.keySet()) {
            mapKeys[count] = key;
            count++;
        }

        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskLst = Lists.newArrayList();
        if (mapKeys.length > 0) {
            syoriKensuuHokanTaskLst =
                workflowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiFromtoJimutetuzukiTaskIdAccountIds(
                    pSyoriYmdFrom, pSyoriYmdTo, pJimutetuzukiCd, mapKeys, pUserId);
        }

        for (String key : map.keySet()) {
            for (DT_SyoriKensuuHokanTask syoriKensuuHokanTask : syoriKensuuHokanTaskLst) {
                if (syoriKensuuHokanTask.getTskid().equals(key)) {

                    CountOfTaskSummaryByJimutetuzukiBean tmpCountOfTaskSummaryByJimutetuzukiBean = map.get(key);

                    tmpCountOfTaskSummaryByJimutetuzukiBean.setCountOfprocessStartToday(
                        tmpCountOfTaskSummaryByJimutetuzukiBean.getCountOfprocessStartToday().add(
                            syoriKensuuHokanTask.getZenjituzanKensuu()));
                    tmpCountOfTaskSummaryByJimutetuzukiBean.setCountOfprocessLeftToday(
                        tmpCountOfTaskSummaryByJimutetuzukiBean.getCountOfprocessLeftToday().add(
                            syoriKensuuHokanTask.getZanKensuu()));
                    tmpCountOfTaskSummaryByJimutetuzukiBean.setCountOfprocessFinToday(
                        tmpCountOfTaskSummaryByJimutetuzukiBean.getCountOfprocessFinToday().add(
                            syoriKensuuHokanTask.getKanryoKensuu()));

                    map.put(tmpCountOfTaskSummaryByJimutetuzukiBean.getTaskNm(),
                        tmpCountOfTaskSummaryByJimutetuzukiBean);
                }
            }
        }
        countOfTaskSummaryByJimutetuzukiBeanLst = new ArrayList<CountOfTaskSummaryByJimutetuzukiBean>(map.values());
        resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryByJimutetuzukiBeanLst);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
        return resultBean;
    }

    public static GetCountOfTaskSummaryByTaskResultBean getCountOfKakoJissekiTaskSummaryByTask(
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pJimutetuzukiCd, String[] pTaskId, String pUserId) {

        GetCountOfTaskSummaryByTaskResultBean resultBean = new GetCountOfTaskSummaryByTaskResultBean();
        List<CountOfTaskSummaryByTaskBean> countOfTaskSummaryByTaskBeanLst =
            new ArrayList<CountOfTaskSummaryByTaskBean>();
        CountOfTaskSummaryByTaskBean countOfTaskSummaryByTaskBean = new CountOfTaskSummaryByTaskBean();
        HashMap<String, CountOfTaskSummaryByTaskBean> map = Maps.newHashMap();
        WorkFlowUtilityDao workflowUtilityDao = SWAKInjector.getInstance(WorkFlowUtilityDao.class);
        List<DT_SyoriKensuuHokanTask> syoriKensuuHokanTaskLst = Lists.newArrayList();

        syoriKensuuHokanTaskLst =
            workflowUtilityDao.getSyoriKensuuHokanTaskByKensuHokanbiFromtoJimutetuzukiTaskIdAccountIds(
                pSyoriYmdFrom, pSyoriYmdTo, pJimutetuzukiCd, pTaskId, pUserId);

        for (DT_SyoriKensuuHokanTask syoriKensuuHokanTask : syoriKensuuHokanTaskLst) {
            if (!map.containsKey(syoriKensuuHokanTask.getAccountId())) {
                countOfTaskSummaryByTaskBean = new CountOfTaskSummaryByTaskBean();
                countOfTaskSummaryByTaskBean.setCountOfprocessStartToday(BizNumber.ZERO);
                countOfTaskSummaryByTaskBean.setCountOfprocessLeftToday(BizNumber.ZERO);
                countOfTaskSummaryByTaskBean.setCountOfprocessFinToday(BizNumber.ZERO);
            }
            else {

                countOfTaskSummaryByTaskBean = map.get(syoriKensuuHokanTask.getAccountId());
            }

            countOfTaskSummaryByTaskBean.setUserId(syoriKensuuHokanTask.getAccountId());
            countOfTaskSummaryByTaskBean.setCountOfprocessStartToday(
                countOfTaskSummaryByTaskBean.getCountOfprocessStartToday().add(
                    syoriKensuuHokanTask.getZenjituzanKensuu()));
            countOfTaskSummaryByTaskBean.setCountOfprocessLeftToday(
                countOfTaskSummaryByTaskBean.getCountOfprocessLeftToday().add(
                    syoriKensuuHokanTask.getZanKensuu()));
            countOfTaskSummaryByTaskBean.setCountOfprocessFinToday(
                countOfTaskSummaryByTaskBean.getCountOfprocessFinToday().add(
                    syoriKensuuHokanTask.getKanryoKensuu()));
            countOfTaskSummaryByTaskBean.setJimutetuzukiCd(syoriKensuuHokanTask.getJimutetuzukicd());
            countOfTaskSummaryByTaskBean.setTaskNm(syoriKensuuHokanTask.getTskid());

            if (WorkFlowUtilityConstants.USERID_KYOUYUU.equals(syoriKensuuHokanTask.getAccountId())) {
                countOfTaskSummaryByTaskBean.setUserId(null);

                countOfTaskSummaryByTaskBean.setDispUserNm(WorkFlowUtilityConstants.KYOUYOU);
            }
            else {
                BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
                AM_User userInfo = baseDomManager.getUser(syoriKensuuHokanTask.getAccountId());
                if (userInfo == null) {
                    String accountId = ConvertUtil.toZenAll(syoriKensuuHokanTask.getAccountId(), 0, 0);
                    if (accountId.length() > 15) {
                        accountId = accountId.substring(0, 15);
                    }
                    countOfTaskSummaryByTaskBean.setDispUserNm(accountId);
                }
                else {
                    countOfTaskSummaryByTaskBean.setDispUserNm(userInfo.getUserNm());
                }
            }

            map.put(syoriKensuuHokanTask.getAccountId(), countOfTaskSummaryByTaskBean);

        }
        countOfTaskSummaryByTaskBeanLst = new ArrayList<CountOfTaskSummaryByTaskBean>(map.values());

        if (BizUtil.isBlank(pUserId)) {
            Ordering<CountOfTaskSummaryByTaskBean> ordering = Ordering.natural().nullsFirst()
                .onResultOf(new WorkflowCountOfTaskSummaryBeanSortFunction());
            List<CountOfTaskSummaryByTaskBean> sorCountOfTaskSummaryByTaskBeanLst =
                ordering.sortedCopy(countOfTaskSummaryByTaskBeanLst);
            resultBean.setCountOfTaskSummaryBean(sorCountOfTaskSummaryByTaskBeanLst);
        }
        else {
            resultBean.setCountOfTaskSummaryBean(countOfTaskSummaryByTaskBeanLst);
        }
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;
    }



    public static GetSumiTaskByUserResultBean getSumiTask(String pSubSystemId, String pUserId,
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {


        GetSumiTaskByUserResultBean resultBean = new GetSumiTaskByUserResultBean();
        List<DM_Jimutetuzuki> jimtetudukiLst = new ArrayList<DM_Jimutetuzuki>();
        LinkedHashMap<String, String> jimutetudukiMap = new LinkedHashMap<String, String>();
        List<String> flowIdLst = new ArrayList<>();
        List<ProcessRecordAndSummaryByUserBean> processRecordAndSummaryByUserOutBeanLst = new ArrayList<>();
        List<DM_JimutetuzukiTask> jimutetudukiTaskLst = Lists.newArrayList();
        LinkedHashMap<String, String> jimutetudukiTaskMap = Maps.newLinkedHashMap();
        List<GetSumiTaskByUserResultBean> sumiTaskBeanLst = new ArrayList<>();


        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        jimtetudukiLst = workflowDomManager.getJimutetuzukisBySubSystemId(pSubSystemId);

        for (DM_Jimutetuzuki jimutetuduki : jimtetudukiLst) {
            flowIdLst.add(jimutetuduki.getJimutetuzukicd());
            jimutetudukiMap.put(jimutetuduki.getJimutetuzukicd(), jimutetuduki.getJimutetuzukinm());
        }


        String syoriYmdFrom = pSyoriYmdFrom.toString().concat("000000000");
        String syoriYmdTo = pSyoriYmdTo.toString().concat("235959999");

        GetProcessRecordAndSummaryByUserInBean inBean = new GetProcessRecordAndSummaryByUserInBean();
        inBean.setUserId(pUserId);
        inBean.setListFlowid(flowIdLst);
        inBean.setSyoriTimeFrom(syoriYmdFrom);
        inBean.setSyoriTimeTo(syoriYmdTo);

        IwfKouteiClient iwfKouteiClient = SWAKInjector.getInstance(IwfKouteiClient.class);
        GetProcessRecordAndSummaryByUserOutBean getProcessRecordAndSummaryByUserOutBean = new GetProcessRecordAndSummaryByUserOutBean();
        getProcessRecordAndSummaryByUserOutBean = iwfKouteiClient.execGetProcessRecordAndSummaryByUser(inBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(getProcessRecordAndSummaryByUserOutBean.getKekkastatus())) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NG);
            return resultBean;
        }
        else if (WorkFlowResultConstants.RESULT_OK.equals(getProcessRecordAndSummaryByUserOutBean.getKekkastatus())
            && getProcessRecordAndSummaryByUserOutBean.getKouteiRirekiAndSummary().size() == 0) {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_NODATA);
            return resultBean;
        }
        else {
            resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);
            processRecordAndSummaryByUserOutBeanLst = getProcessRecordAndSummaryByUserOutBean
                .getKouteiRirekiAndSummary();
        }


        jimutetudukiTaskLst = workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(new String[] { pSubSystemId });

        for (DM_JimutetuzukiTask jimutetudukiTask : jimutetudukiTaskLst) {
            jimutetudukiTaskMap.put(jimutetudukiTask.getJimutetuzukicd() + "." + jimutetudukiTask.getWorkflowTskId(),
                jimutetudukiTask.getWorkflowTskNm());
        }


        for (ProcessRecordAndSummaryByUserBean processRecordAndSummaryByUserOutBean : processRecordAndSummaryByUserOutBeanLst) {
            GetSumiTaskByUserResultBean sumiTaskBean = new GetSumiTaskByUserResultBean();

            sumiTaskBean.setJimutetuzukinm(jimutetudukiMap.get(processRecordAndSummaryByUserOutBean
                .getKouteiRireki().getFlowId()));

            sumiTaskBean.setSyoritime(DefaultDateFormatter
                .formatYMDHMSZeroFill(processRecordAndSummaryByUserOutBean.getKouteiRireki().getSyoriTime()));

            String taskNm = jimutetudukiTaskMap.get(processRecordAndSummaryByUserOutBean.getKouteiRireki()
                .getFlowId() + "." + processRecordAndSummaryByUserOutBean.getKouteiRireki().getNodeNm());
            if (BizUtil.isBlank(taskNm)) {
                sumiTaskBean.setTasknm(ConvertUtil.toZenAll(processRecordAndSummaryByUserOutBean.getKouteiRireki()
                    .getNodeNm(), 0, 0));
            }
            else {
                sumiTaskBean.setTasknm(taskNm);
            }

            String bExtInfo = IwfBase64Urls.encodeFromString(new String(processRecordAndSummaryByUserOutBean.getKouteiRireki().getExtInfo()));

            if (!StringUtils.isEmpty(bExtInfo)) {
                List<Map<String, String>> extInfoList = (List<Map<String, String>>) JSON.decode(IwfBase64Urls
                    .decodeToString(bExtInfo));
                for (Map<String, String> extMap : extInfoList) {
                    if (extMap.containsKey("taskname")) {
                        taskNm = extMap.get("taskname");
                        break;
                    }
                }
            }

            sumiTaskBean.setTasknm(taskNm);


            String dairitencd = processRecordAndSummaryByUserOutBean.getKouteiSummary().getExtParam4();

            if (BizUtil.isBlank(dairitencd)) {
                sumiTaskBean.setTratkiagnm1("");
            }
            else {
                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                List<BzGetAgInfoBean> dairitenInfoA = bzGetAgInfo.exec(dairitencd);

                if (dairitenInfoA.size() == 0) {
                    sumiTaskBean.setTratkiagnm1(ConvertUtil.toZenAll(dairitencd, 1, 1));
                }
                else {
                    sumiTaskBean.setTratkiagnm1(dairitenInfoA.get(1).getKanjiDairitenNm());
                }
            }

            if (TantousyabetuSyoriTaskSyoukaiConstants.E_SubSystem.SINKEIYAKU.getName().equals(pSubSystemId)) {

                String mosno = processRecordAndSummaryByUserOutBean.getKouteiSummary().getExtParam14();

                sumiTaskBean.setGyoumuKey(mosno);


                String hknSyuruiNo = processRecordAndSummaryByUserOutBean.getKouteiSummary().getExtParam3();

                if (BizUtil.isBlank(hknSyuruiNo)) {
                    sumiTaskBean.setHknsyuruiworklist("");
                }
                else {

                    List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                        SWAKInjector.getInstance(SinkeiyakuDomManager.class).getSkHokenSyuruiNosByHknsyuruino(
                            C_HknsyuruiNo.valueOf(hknSyuruiNo));
                    SortHM_SkHokenSyuruiNo sortHM_SkHokenSyuruiNo = SWAKInjector
                        .getInstance(SortHM_SkHokenSyuruiNo.class);
                    skHokenSyuruiNoLst = sortHM_SkHokenSyuruiNo.OrderHM_SkHokenSyuruiNoByPkDesc(skHokenSyuruiNoLst);

                    if (skHokenSyuruiNoLst == null || skHokenSyuruiNoLst.size() == 0) {
                        sumiTaskBean.setHknsyuruiworklist(ConvertUtil.toZenAll(hknSyuruiNo, 1, 1));
                    }
                    else {
                        sumiTaskBean.setHknsyuruiworklist(skHokenSyuruiNoLst.get(0).getHknsyuruiworklist());
                    }
                }

                HT_SyoriCTL syoriCTL = SWAKInjector.getInstance(SinkeiyakuDomManager.class).getSyoriCTL(mosno);

                if (syoriCTL == null) {
                    sumiTaskBean.setKyknmkj("");
                    sumiTaskBean.setKyknmkn("");
                }
                else {
                    HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                    if (mosKihon == null) {
                        sumiTaskBean.setKyknmkj("");
                        sumiTaskBean.setKyknmkn("");
                    }
                    else {
                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                            sumiTaskBean.setKyknmkj(mosKihon.getHhknnmkj());
                            sumiTaskBean.setKyknmkn(mosKihon.getHhknnmkn());
                        }
                        else {
                            sumiTaskBean.setKyknmkj(mosKihon.getKyknmkj());
                            sumiTaskBean.setKyknmkn(mosKihon.getKyknmkn());
                        }
                    }
                }
            }
            else {

                String syono = processRecordAndSummaryByUserOutBean.getKouteiSummary().getExtParam12();

                sumiTaskBean.setGyoumuKey(syono);

                IT_KykKihon kykKihon = SWAKInjector.getInstance(HozenDomManager.class).getKykKihon(syono);
                if (kykKihon == null) {
                    sumiTaskBean.setHknsyuruiworklist("");
                    sumiTaskBean.setKyknmkj("");
                    sumiTaskBean.setKyknmkn("");
                }
                else {

                    List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                    if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {
                        sumiTaskBean.setHknsyuruiworklist("");
                    }
                    else {

                        if (kykSyouhnLst.get(0).getSyouhnZokusei() == null) {
                            sumiTaskBean.setHknsyuruiworklist(ConvertUtil.toZenAll(kykSyouhnLst.get(0).getSyouhncd(), 1, 1));
                        }
                        else {
                            sumiTaskBean.setHknsyuruiworklist(kykSyouhnLst.get(0).getSyouhnZokusei()
                                .getSyouhnnmworklist());
                        }
                    }

                    IT_KykSya kykSya = kykKihon.getKykSya();
                    if (kykSya == null) {
                        sumiTaskBean.setKyknmkj("");
                        sumiTaskBean.setKyknmkn("");
                    }
                    else {
                        sumiTaskBean.setKyknmkj(kykSya.getKyknmkj());
                        sumiTaskBean.setKyknmkn(kykSya.getKyknmkn());
                    }
                }
            }

            sumiTaskBeanLst.add(sumiTaskBean);
        }

        resultBean.setProcessHistoryBeanList(sumiTaskBeanLst);
        resultBean.setSyorikekkaStatus(WorkFlowResultConstants.RESULT_OK);

        return resultBean;

    }
}