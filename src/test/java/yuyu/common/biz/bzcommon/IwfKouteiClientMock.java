package yuyu.common.biz.bzcommon;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoInBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryByActorOutBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetTaskSummaryOutBean;
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
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateOutBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskInBean;
import yuyu.common.biz.workflow.io.koutei.UnassignTaskOutBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.UnlockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExecutableTaskInfoBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExtParamBean;
import yuyu.common.biz.workflow.io.koutei.sub.LockInfoBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.common.workflow.workflowutility.WorkFlowUtilityConstants;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;

public class IwfKouteiClientMock extends IwfKouteiClient {
    public static String caller = null;
    public static String mode = null;
    public static String flg = null;

    @Override
    public GetProcessSummaryOutBean execGetProcessSummary(GetProcessSummaryInBean inBean) {

        if ("Test".equals(caller)) {

            GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
            ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
            List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
            ExtParamBean extParamBean = new ExtParamBean();

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "01":
                    getProcessSummaryOutBean = execGetProcessSummary01(tmpMode[1]);
                    break;
                case "03":
                    getProcessSummaryOutBean = execGetProcessSummary03(tmpMode[1]);
                    break;
                case "04":
                    getProcessSummaryOutBean = execGetProcessSummary04(tmpMode[1]);
                    break;
                case "06":
                    getProcessSummaryOutBean = execGetProcessSummary06(tmpMode[1]);
                    break;
                case "07":
                    getProcessSummaryOutBean = execGetProcessSummary07(tmpMode[1]);
                    break;
                case "08":
                    getProcessSummaryOutBean = execGetProcessSummary08(tmpMode[1]);
                    break;
                case "09":
                    getProcessSummaryOutBean = execGetProcessSummary09(tmpMode[1]);
                    break;
                case "10":
                    getProcessSummaryOutBean = execGetProcessSummary10(tmpMode[1]);
                    break;
                case "13":
                    getProcessSummaryOutBean = execGetProcessSummary13(tmpMode[1]);
                    break;
                case "14":
                    getProcessSummaryOutBean = execGetProcessSummary14(tmpMode[1]);
                    break;
                case "15":
                    getProcessSummaryOutBean = execGetProcessSummary15(tmpMode[1], inBean);
                    break;
                case "20":
                    getProcessSummaryOutBean = execGetProcessSummary20(tmpMode[1], inBean);
                    break;
                case "21":
                    getProcessSummaryOutBean = execGetProcessSummary21(tmpMode[1]);
                    break;
                case "dl01":
                    super.execGetProcessSummary(inBean);
                    getProcessSummaryOutBean = execGetProcessSummaryDL01(tmpMode[1]);
                    break;
                case "dl":
                    super.execGetProcessSummary(inBean);
                    getProcessSummaryOutBean = execGetProcessSummaryDL01(tmpMode[1]);
                    break;
                default:
                    getProcessSummaryOutBean.setKekkastatus("0");
                    getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                    getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                    processSummaryBean.setFlowId("FlowId01");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    extParamBean.setExtparam12("SyoNo01");
                    extParamBean.setExtparam13("NkSysyNo01");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                    getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                    break;
            }

            return getProcessSummaryOutBean;
        }
        else {

            return super.execGetProcessSummary(inBean);
        }
    }

    private GetProcessSummaryOutBean execGetProcessSummaryDL01(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "02":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("user003");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0001");
                getProcessSummaryOutBean.setSyousaimsg("取得数が、上限件数を超えています。");
                break;
            case "04":


                beanList = null;
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "05":


                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":


                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("user003");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);

                ProcessSummaryBean processSummaryBean2 = new ProcessSummaryBean();
                ExtParamBean extParamBean2 = new ExtParamBean();
                processSummaryBean2.setFlowId("0003");
                processSummaryBean2.setGyoumukey("GyoumuKey03");
                processSummaryBean2.setPreviousNodeName("TaskNm01");
                processSummaryBean2.setCurrentNodeName("TaskNm02");
                processSummaryBean2.setProcessstatus("10");
                processSummaryBean2.setUpdateTime("20150720163400");
                processSummaryBean2.setFirstAccountId("user001");
                processSummaryBean2.setPreviousAccountId("user002");
                processSummaryBean2.setCurrentAccountId("user003");
                processSummaryBean2.setKouteiKaisiYmd("20150901");
                processSummaryBean2.setKouteikanryouYmd("20150902");
                extParamBean2.setExtparam11("");
                extParamBean2.setExtparam12("SyoNo01");
                extParamBean2.setExtparam13("NkSysyNo01");
                processSummaryBean2.setExtparamBean(extParamBean2);

                ProcessSummaryBean processSummaryBean3 = new ProcessSummaryBean();
                ExtParamBean extParamBean3 = new ExtParamBean();

                processSummaryBean3.setFlowId("0004");
                processSummaryBean3.setGyoumukey("GyoumuKey04");
                processSummaryBean3.setPreviousNodeName("TaskNm01");
                processSummaryBean3.setCurrentNodeName("TaskNm02");
                processSummaryBean3.setProcessstatus("10");
                processSummaryBean3.setUpdateTime("20150720163400");
                processSummaryBean3.setFirstAccountId("user001");
                processSummaryBean3.setPreviousAccountId("user002");
                processSummaryBean3.setCurrentAccountId("user003");
                extParamBean3.setExtparam11("20151001");
                extParamBean3.setExtparam12("SyoNo01");
                extParamBean3.setExtparam13("NkSysyNo01");
                processSummaryBean3.setKouteiKaisiYmd("20150901");
                processSummaryBean3.setKouteikanryouYmd("20150902");
                processSummaryBean3.setExtparamBean(extParamBean3);

                beanList.add(processSummaryBean);
                beanList.add(processSummaryBean2);
                beanList.add(processSummaryBean3);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("3001");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("JUnit");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("3001");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("3001");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("3001");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId(null);
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("3001");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId(null);
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":


                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("3001");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("user003");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":

                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }

        return getProcessSummaryOutBean;
    }


    private GetProcessSummaryOutBean execGetProcessSummary01(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF2160");
                getProcessSummaryOutBean.setSyousaimsg("取得数が、上限件数を超えています。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF2160");
                getProcessSummaryOutBean.setSyousaimsg("取得数が、上限件数を超えています。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF2160");
                getProcessSummaryOutBean.setSyousaimsg("取得数が、上限件数を超えています。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF2160");
                getProcessSummaryOutBean.setSyousaimsg("取得数が、上限件数を超えています。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam11("20150716020304005");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId04");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam11("20150716040506007");
                extParamBean.setExtparam12("SyoNo04");
                extParamBean.setExtparam13("NkSysyNo04");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716020304005");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716020304005");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId04");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                processSummaryBean.setCurrentAccountId("UserId04");
                processSummaryBean.setCurrentNodeName("TaskNm04");
                processSummaryBean.setCurrentNodeLocalname("タスク名04");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716040506007");
                extParamBean.setExtparam12("SyoNo04");
                extParamBean.setExtparam13("NkSysyNo04");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716020304005");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716020304005");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("（表示用）タスク名");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212020304005");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("（表示用）タスク名");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212020304005");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("（表示用）タスク名");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212020304005");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("（表示用）タスク名");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212020304005");
                extParamBean.setExtparam12("12345678903");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("（表示用）タスク名");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212020304005");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("（表示用）タスク名");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212020304005");
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }

        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary03(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId(null);
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId(null);
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;

        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary04(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("Id03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150714030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId(null);
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId(null);
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId(null);
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150714030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150714030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("FlowId03");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150714030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("10");
                processSummaryBean.setCurrentNodeName("TaskId01");
                processSummaryBean.setCurrentNodeLocalname("TaskId01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212030405006");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;

            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary06(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("7777");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("9999");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "16":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "17":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("100");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678903");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("100");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("100");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "18":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("100");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("100");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setCurrentAccountId("100");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary07(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150702010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Node02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("002");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150701010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Node01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("001");
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150702010203004");
                processSummaryBean.setCurrentNodeName("Node02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("002");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150701010203004");
                processSummaryBean.setCurrentNodeName("Node01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("001");
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150702010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Node02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("002");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150701010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Node01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("001");
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150702010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Node02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("002");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150701010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Node01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("001");
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150702010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Node02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("002");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150701010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Node01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("001");
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setFlowId("Id02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150702010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Node02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("002");
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setFlowId("Id01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150701010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Node01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("001");
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setFlowId("Id03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150703010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Node03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("003");
                extParamBean.setExtparam11("20150717010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setFlowId("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("");
                extParamBean.setExtparam12("12345678903");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setFlowId("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("");
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setFlowId("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setFlowId("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setFlowId("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setFlowId("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary08(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setKouteiKaisiYmd("20150630");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150717010203004");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setKouteikanryouYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setKouteikanryouYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212010203004");
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setKouteikanryouYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("20151212");
                processSummaryBean.setKouteikanryouYmd("20151212");
                processSummaryBean.setProcessstatus("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20151212010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }

        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary09(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0004");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("9999");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("9999");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("9999");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("9999");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User99");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150714");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User99");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150702010203004");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User03");
                processSummaryBean.setCurrentNodeName("Task03");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150704010203004");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0004");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User04");
                processSummaryBean.setCurrentNodeName("Task04");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名04");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo04");
                extParamBean.setExtparam13("NkSysyNo04");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0005");
                processSummaryBean.setGyoumukey("GyoumuKey05");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("User05");
                processSummaryBean.setCurrentNodeName("Task05");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名05");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo05");
                extParamBean.setExtparam13("NkSysyNo05");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0006");
                processSummaryBean.setGyoumukey("GyoumuKey06");
                processSummaryBean.setKouteiKaisiYmd("20150630");
                processSummaryBean.setKouteikanryouYmd("20150713");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("User06");
                processSummaryBean.setCurrentNodeName("Task06");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名06");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("SyoNo06");
                extParamBean.setExtparam13("NkSysyNo06");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "16":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("");
                processSummaryBean.setKouteiKaisiYmd("");
                processSummaryBean.setKouteikanryouYmd("");
                processSummaryBean.setProcessstatus("");
                processSummaryBean.setUpdateTime("");
                processSummaryBean.setCurrentAccountId("");
                processSummaryBean.setCurrentNodeName("");
                processSummaryBean.setCurrentNodeLocalname("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary10(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12345678902");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678903");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary13(String pMode) {

        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey05");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey06");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task03");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean.setFlowId("0099");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("JimuTetuzukiCd_142");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean.setFlowId("0024");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("JimuTetuzukiCd_147");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("JimuTetuzukiCd_147");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean.setFlowId("0024");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId99");
                processSummaryBean.setPreviousNodeName("JimuTetuzukiCd_147");
                processSummaryBean.setCurrentAccountId("UserId99");
                processSummaryBean.setCurrentNodeName("JimuTetuzukiCd_147");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean.setFlowId("0024");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("JimuTetuzukiCd_147");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("JimuTetuzukiCd_147");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean.setFlowId("0024");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId99");
                processSummaryBean.setPreviousNodeName("JimuTetuzukiCd_147");
                processSummaryBean.setCurrentAccountId("UserId99");
                processSummaryBean.setCurrentNodeName("JimuTetuzukiCd_147");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey05");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150102123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey06");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150103123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task03");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam11("20150101123456777");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("101");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam11("20150101123456777");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("102");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam11("20150101123456777");
                extParamBean.setExtparam14("");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
        }

        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary14(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {

            case "01":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "02":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "06":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task03");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                processSummaryBean.setFlowId("0100");
                processSummaryBean.setGyoumukey("GyoumuKey10");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId10");
                processSummaryBean.setPreviousNodeName("JimuTetuzukiCd_100");
                processSummaryBean.setCurrentAccountId("UserId10");
                processSummaryBean.setCurrentNodeName("JimuTetuzukiCd_100");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "09":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId99");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId99");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "12":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId99");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId99");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId02");
                processSummaryBean.setPreviousNodeName("Task02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam11("20150101123456777");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task03");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "14":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam11("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam11("");
                extParamBean.setExtparam14("");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                extParamBean.setExtparam3("");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
        }

        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary15(String pMode, GetProcessSummaryInBean inBean) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "06":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "07":
                if ("12345".equals(inBean.getExtParam12().getValues()[0])) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("GyoumuKey02");
                    processSummaryBean.setKouteiKaisiYmd("20150702");
                    processSummaryBean.setKouteikanryouYmd("20150712");
                    processSummaryBean.setProcessstatus("10");
                    processSummaryBean.setUpdateTime("20150702010203004");
                    processSummaryBean.setCurrentAccountId("UserId02");
                    processSummaryBean.setCurrentNodeName("Node02");
                    processSummaryBean.setCurrentNodeLocalname("タスク名02");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("002");
                    extParamBean.setExtparam11("20150716010203004");
                    extParamBean.setExtparam12("SyoNo02");
                    extParamBean.setExtparam13("NkSysyNo02");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                } else if ("67890".equals(inBean.getExtParam12().getValues()[0])) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setKouteiKaisiYmd("20150701");
                    processSummaryBean.setKouteikanryouYmd("20150711");
                    processSummaryBean.setProcessstatus("10");
                    processSummaryBean.setUpdateTime("20150701010203004");
                    processSummaryBean.setCurrentAccountId("UserId01");
                    processSummaryBean.setCurrentNodeName("Node01");
                    processSummaryBean.setCurrentNodeLocalname("タスク名01");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("001");
                    extParamBean.setExtparam11("20150715010203004");
                    extParamBean.setExtparam12("SyoNo01");
                    extParamBean.setExtparam13("NkSysyNo01");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                } else {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("GyoumuKey03");
                    processSummaryBean.setKouteiKaisiYmd("20150703");
                    processSummaryBean.setKouteikanryouYmd("20150713");
                    processSummaryBean.setProcessstatus("10");
                    processSummaryBean.setUpdateTime("20150703010203004");
                    processSummaryBean.setCurrentAccountId("UserId01");
                    processSummaryBean.setCurrentNodeName("Node03");
                    processSummaryBean.setCurrentNodeLocalname("タスク名03");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("003");
                    extParamBean.setExtparam11("20150717010203004");
                    extParamBean.setExtparam12("SyoNo03");
                    extParamBean.setExtparam13("NkSysyNo03");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "08":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "10":
                if ("12345".equals(inBean.getExtParam14().getValues()[0])) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("");
                    processSummaryBean.setKouteiKaisiYmd("");
                    processSummaryBean.setKouteikanryouYmd("");
                    processSummaryBean.setProcessstatus("");
                    processSummaryBean.setUpdateTime("");
                    processSummaryBean.setCurrentAccountId("");
                    processSummaryBean.setCurrentNodeName("");
                    processSummaryBean.setCurrentNodeLocalname("");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("0001");
                    extParamBean.setExtparam11("");
                    extParamBean.setExtparam12("");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("12345");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                } else if ("67890".equals(inBean.getExtParam14().getValues()[0])) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("");
                    processSummaryBean.setKouteiKaisiYmd("");
                    processSummaryBean.setKouteikanryouYmd("");
                    processSummaryBean.setProcessstatus("");
                    processSummaryBean.setUpdateTime("");
                    processSummaryBean.setCurrentAccountId("");
                    processSummaryBean.setCurrentNodeName("");
                    processSummaryBean.setCurrentNodeLocalname("");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("0002");
                    extParamBean.setExtparam11("");
                    extParamBean.setExtparam12("");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("67890");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                } else {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("");
                    processSummaryBean.setKouteiKaisiYmd("");
                    processSummaryBean.setKouteikanryouYmd("");
                    processSummaryBean.setProcessstatus("");
                    processSummaryBean.setUpdateTime("");
                    processSummaryBean.setCurrentAccountId("");
                    processSummaryBean.setCurrentNodeName("");
                    processSummaryBean.setCurrentNodeLocalname("");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("0003");
                    extParamBean.setExtparam11("");
                    extParamBean.setExtparam12("");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("13579");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "11":
                if ("12345".equals(inBean.getExtParam12().getValues()[0])) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("");
                    processSummaryBean.setKouteiKaisiYmd("");
                    processSummaryBean.setKouteikanryouYmd("");
                    processSummaryBean.setProcessstatus("");
                    processSummaryBean.setUpdateTime("");
                    processSummaryBean.setCurrentAccountId("");
                    processSummaryBean.setCurrentNodeName("");
                    processSummaryBean.setCurrentNodeLocalname("");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("0001");
                    extParamBean.setExtparam11("");
                    extParamBean.setExtparam12("12345");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                } else if ("67890".equals(inBean.getExtParam12().getValues()[0])) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("");
                    processSummaryBean.setKouteiKaisiYmd("");
                    processSummaryBean.setKouteikanryouYmd("");
                    processSummaryBean.setProcessstatus("");
                    processSummaryBean.setUpdateTime("");
                    processSummaryBean.setCurrentAccountId("");
                    processSummaryBean.setCurrentNodeName("");
                    processSummaryBean.setCurrentNodeLocalname("");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("0002");
                    extParamBean.setExtparam11("");
                    extParamBean.setExtparam12("67890");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                } else {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setGyoumukey("");
                    processSummaryBean.setKouteiKaisiYmd("");
                    processSummaryBean.setKouteikanryouYmd("");
                    processSummaryBean.setProcessstatus("");
                    processSummaryBean.setUpdateTime("");
                    processSummaryBean.setCurrentAccountId("");
                    processSummaryBean.setCurrentNodeName("");
                    processSummaryBean.setCurrentNodeLocalname("");
                    extParamBean = new ExtParamBean();
                    extParamBean.setExtparam7("0003");
                    extParamBean.setExtparam11("");
                    extParamBean.setExtparam12("13579");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary20(String pMode, GetProcessSummaryInBean inBean) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "04":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "05":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "06":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "08":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "09":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "10":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "11":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "12":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "13":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "14":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "15":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "16":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "17":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "18":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "19":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "20":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "21":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "23":
                if (inBean.getGyoumukey() == "GyoumuKey01") {
                    getProcessSummaryOutBean.setKekkastatus("0");
                    getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                    getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                    processSummaryBean.setFlowId("FlowId01");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    extParamBean.setExtparam12("SyoNo01");
                    extParamBean.setExtparam13("NkSysyNo01");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                    getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                } else {
                    getProcessSummaryOutBean.setKekkastatus("0");
                    getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                    getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                    processSummaryBean.setFlowId("FlowId02");
                    processSummaryBean.setGyoumukey("GyoumuKey02");
                    extParamBean.setExtparam12("SyoNo02");
                    extParamBean.setExtparam13("NkSysyNo02");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                    getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                }
                break;
            case "24":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("");
                processSummaryBean.setGyoumukey("");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "25":
                if (inBean.getGyoumukey() == "GyoumuKey01") {
                    getProcessSummaryOutBean.setKekkastatus("0");
                    getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                    getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                    processSummaryBean.setFlowId("");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    extParamBean.setExtparam12("12345678901");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("12345678901");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                    getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                } else if (inBean.getGyoumukey() == "GyoumuKey02") {
                    getProcessSummaryOutBean.setKekkastatus("0");
                    getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                    getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                    processSummaryBean.setFlowId("");
                    processSummaryBean.setGyoumukey("GyoumuKey02");
                    extParamBean.setExtparam12("12345678901");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("12345678902");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                    getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                } else {
                    getProcessSummaryOutBean.setKekkastatus("0");
                    getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                    getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                    processSummaryBean.setFlowId("");
                    processSummaryBean.setGyoumukey("GyoumuKey03");
                    extParamBean.setExtparam12("12345678901");
                    extParamBean.setExtparam13("");
                    extParamBean.setExtparam14("12345678901");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                    getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                }
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary21(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "03":

                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "10":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("");
                extParamBean.setExtparam13("");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }

        return getProcessSummaryOutBean;
    }

    @Override
    public LockProcessOutBean execLockProcess(LockProcessInBean inBean) {

        if ("Test".equals(caller)) {
            LockProcessOutBean response = new LockProcessOutBean();
            switch (mode) {
                case "05-01":
                    response.setKekkastatus("0");
                    break;
                case "05-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-05":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-07":
                    response.setKekkastatus("0");
                    break;
                case "05-08":
                    response.setKekkastatus("0");
                    break;
                case "05-09":
                    response.setKekkastatus("0");
                    break;
                case "05-10":
                    response.setKekkastatus("0");
                    break;
                case "05-12":
                    response.setKekkastatus("0");
                    break;
                case "05-13":
                    response.setKekkastatus("0");
                    break;
                case "05-14":
                    response.setKekkastatus("0");
                    break;
                case "05-15":
                    response.setKekkastatus("0");
                    break;
                case "05-16":
                    response.setKekkastatus("0");
                    break;
                case "16-01":
                    response.setKekkastatus("0");
                    break;
                case "16-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-05":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-07":
                    response.setKekkastatus("0");
                    break;
                case "16-08":
                    response.setKekkastatus("0");
                    break;
                case "16-09":
                    response.setKekkastatus("0");
                    break;
                case "16-10":
                    response.setKekkastatus("0");
                    break;
                case "16-12":
                    response.setKekkastatus("0");
                    break;
                case "16-13":
                    response.setKekkastatus("0");
                    break;
                case "16-14":
                    response.setKekkastatus("0");
                    break;
                case "16-15":
                    response.setKekkastatus("0");
                    break;
                case "16-17":
                    response.setKekkastatus("0");
                    break;
                case "16-18":
                    response.setKekkastatus("0");
                    break;
                case "16-19":
                    response.setKekkastatus("0");
                    break;
                case "16-20":
                    response.setKekkastatus("0");
                    break;
                case "16-21":
                    response.setKekkastatus("0");
                    break;
                case "32-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2091");
                    response.setSyousaimsg("対象のトークンは既にロックされています。");
                    break;
                case "32-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-05":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-06":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                default:
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {

            return super.execLockProcess(inBean);
        }
    }

    @Override
    public ProcessUpdateOutBean execProcessUpdate(ProcessUpdateInBean inBean) {
        if ("Test".equals(caller)) {
            ProcessUpdateOutBean response = new ProcessUpdateOutBean();
            switch (mode) {
                case "32-08":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-09":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-10":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-11":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-12":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-13":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }

            return response;
        } else {
            return super.execProcessUpdate(inBean);
        }
    }

    @Override
    public UnlockProcessOutBean execUnlockProcess(UnlockProcessInBean inBean) {
        if ("Test".equals(caller)) {
            UnlockProcessOutBean response = new UnlockProcessOutBean();
            switch (mode) {
                case "05-11":
                    response.setKekkastatus("0");
                    break;
                case "05-12":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-13":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-14":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-15":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-16":
                    response.setKekkastatus("0");
                    break;
                case "16-16":
                    response.setKekkastatus("0");
                    break;
                case "16-17":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-18":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-19":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-20":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-21":
                    response.setKekkastatus("0");
                    break;
                case "32-14":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "32-15":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "32-16":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "32-17":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "32-18":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                default:
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execUnlockProcess(inBean);
        }
    }

    @Override
    public CreateTaskSummaryOutBean execCreateTaskSummary(CreateTaskSummaryInBean inBean) {

        if ("Test".equals(caller)) {

            CreateTaskSummaryOutBean response = new CreateTaskSummaryOutBean();

            switch (mode) {

                case "31-01":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "31-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "31-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "31-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                default:
                    break;
            }
            return response;
        }

        return super.execCreateTaskSummary(inBean);
    }

    @Override
    public WSForceUnlockProcessResponse execForceUnlockProcess(ForceUnlockProcessInBean inBean) {

        if ("Test".equals(caller)) {

            WSForceUnlockProcessResponse response = new WSForceUnlockProcessResponse();

            switch (mode) {

                case "02-01":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "02-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "02-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "02-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                default:
                    break;
            }
            return response;
        }

        return super.execForceUnlockProcess(inBean);
    }

    @Override
    public UnassignTaskOutBean execUnsignTask(UnassignTaskInBean inBean) {

        if ("Test".equals(caller)) {

            UnassignTaskOutBean response = new UnassignTaskOutBean();

            switch (mode) {

                case "05-06":
                    response.setKekkastatus("0");
                    break;
                case "05-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-08":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-09":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-10":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "05-12":
                    response.setKekkastatus("0");
                    break;
                case "05-13":
                    response.setKekkastatus("0");
                    break;
                case "05-14":
                    response.setKekkastatus("0");
                    break;
                case "05-15":
                    response.setKekkastatus("0");
                    break;
                case "05-16":
                    response.setKekkastatus("0");
                    break;
                default:
                    break;
            }
            return response;
        }

        return super.execUnsignTask(inBean);
    }

    @Override
    public ProcessCancelOutBean execProcessCancel(ProcessCancelInBean inBean) {

        if ("Test".equals(caller)) {

            ProcessCancelOutBean response = new ProcessCancelOutBean();

            switch (mode) {

                case "16-06":
                    response.setKekkastatus("0");
                    break;
                case "16-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-08":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-09":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-10":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-11":
                    response.setKekkastatus("0");
                    break;
                case "16-12":
                    response.setKekkastatus("0");
                    break;
                case "16-13":
                    response.setKekkastatus("0");
                    break;
                case "16-14":
                    response.setKekkastatus("0");
                    break;
                case "16-15":
                    response.setKekkastatus("0");
                    break;
                case "16-17":
                    response.setKekkastatus("0");
                    break;
                case "16-18":
                    response.setKekkastatus("0");
                    break;
                case "16-19":
                    response.setKekkastatus("0");
                    break;
                case "16-20":
                    response.setKekkastatus("0");
                    break;
                case "16-21":
                    response.setKekkastatus("0");
                    break;
                case "dl01-01":
                    if (flg == "dl01") {
                        response.setKekkastatus("0");
                    } else if(flg == "dl02") {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF0009");
                    }

                    break;
                case "dl01-02":
                    if (flg == "dl01") {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF0000");
                    }
                    break;
                default:
                    break;
            }
            return response;
        }

        return super.execProcessCancel(inBean);

    }

    @Override
    public CreateProcessRecordOutBean execCcreateProcessRecord(CreateProcessRecordInBean inBean) {

        if ("Test".equals(caller)) {

            CreateProcessRecordOutBean response = new CreateProcessRecordOutBean();

            switch (mode) {

                case "16-11":
                    response.setKekkastatus("0");
                    break;
                case "16-12":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-13":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-14":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-15":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-17":
                    response.setKekkastatus("0");
                    break;
                case "16-18":
                    response.setKekkastatus("0");
                    break;
                case "16-19":
                    response.setKekkastatus("0");
                    break;
                case "16-20":
                    response.setKekkastatus("0");
                    break;
                case "16-21":
                    response.setKekkastatus("0");
                    break;
                case "01-05":
                    response.setKekkastatus("0");
                    break;
                default:
                    break;
            }
            return response;
        }

        return super.execCcreateProcessRecord(inBean);
    }

    @Override
    public ProcessCreateOutBean execProcessCreate(ProcessCreateInBean inBean) {
        if ("Test".equals(caller)) {

            ProcessCreateOutBean response = new ProcessCreateOutBean();

            switch (mode) {
                case "dl01-01":
                    if (flg == "dl01") {
                        response.setKekkastatus("0");
                        break;
                    } else if(flg == "dl02") {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF0009");
                        break;
                    }

                case "dl01-02":
                    if (flg == "dl01") {
                        response.setKekkastatus("0");
                        break;
                    } else if(flg == "dl02") {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF0009");
                        break;
                    }

            }
            return response;
        }

        return super.execProcessCreate(inBean);
    }

    @Override
    public GetLockInfoOutBean getLockInfo(GetLockInfoInBean inBean) {
        if ("Test".equals(caller)) {
            GetLockInfoOutBean response = new GetLockInfoOutBean();
            List<LockInfoBean> beanList = new ArrayList<LockInfoBean>();
            LockInfoBean bean = new LockInfoBean();

            switch (mode) {
                case "01-06":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "01-07":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "01-08":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "01-13":
                    bean.setGyoumukey("GyoumuKey03");
                    bean.setFlowId("0003");
                    bean.setNodeName("TaskNm03");
                    bean.setAccountId("UserId03");
                    bean.setLockKey("LockKey03");
                    bean.setLockTime("20150716010203004");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId02");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId01");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "01-14":
                    bean.setGyoumukey("101");
                    bean.setFlowId("0003");
                    bean.setNodeName("TaskNm03");
                    bean.setAccountId("10");
                    bean.setLockKey("LockKey03");
                    bean.setLockTime("20151212020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("101");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("10");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20151212020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("101");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("10");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20151212020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "01-15":
                    bean.setGyoumukey("101");
                    bean.setFlowId("0003");
                    bean.setNodeName("TaskNm03");
                    bean.setAccountId("10");
                    bean.setLockKey("LockKey03");
                    bean.setLockTime("20151212020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("101");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("10");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20151212020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("101");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("10");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20151212020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                default:
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId01");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716010203004");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId02");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.getLockInfo(inBean);
        }
    }

    @Override
    public GetProcessRecordOutBean execGetProcessRecord(GetProcessRecordInBean inBean) {

        if ("Test".equals(caller)) {
            List<ProcessRecordBean> beanList = new ArrayList<ProcessRecordBean>();
            GetProcessRecordOutBean getProcessRecordOutBean = new GetProcessRecordOutBean();
            ProcessRecordBean bean = new ProcessRecordBean();

            List<Map<String, String>> extinfos = new ArrayList<Map<String, String>>();
            Map<String, String> extinfosMap = new HashMap<String, String>();

            switch (mode) {
                case "17-01":
                    getProcessRecordOutBean.setKekkastatus("9");
                    getProcessRecordOutBean.setSyousaimsg("必須入力チェックエラー");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0002");
                    break;

                case "17-02":

                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-03":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-04":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-05":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-06":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-07":
                    getProcessRecordOutBean.setKekkastatus("9");
                    getProcessRecordOutBean.setSyousaimsg("異常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0001");
                    break;

                case "17-08":
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-09":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-10":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setFlowId("Id01");
                    bean.setNodeName("Task01");
                    bean.setNodeLocalName("テストノード名");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("testAccountId");
                    bean.setRirekiMessage("タスク生成");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-11":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    for (int i = 0; i < 5; i++) {
                        bean = new ProcessRecordBean();
                        bean.setSyoriTime("20150101");
                        bean.setNodeName("testNodeId");
                        bean.setNodeLocalName("テストノード名");
                        bean.setExtinfo(extinfos);
                        bean.setAccountId("testAccountId");
                        bean.setRirekiMessage("タスク生成");
                        beanList.add(bean);
                    }
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-12":
                    extinfosMap.put("syorikekkakbn", "00");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "01");
                    extinfos.add(extinfosMap);

                    for (int i = 0; i < 5; i++) {
                        bean = new ProcessRecordBean();
                        bean.setSyoriTime("20150101");
                        bean.setNodeName("testNodeId");
                        bean.setNodeLocalName("テストノード名");
                        bean.setExtinfo(extinfos);
                        bean.setAccountId("testAccountId");
                        bean.setRirekiMessage("タスク生成");
                        beanList.add(bean);
                    }
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-13":
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put("1", "910");
                    extinfos.add(extinfosMap);
                    extinfosMap.put("syorikekkakbn", "110");
                    extinfos.add(extinfosMap);
                    extinfosMap = new HashMap<String, String>();
                    extinfosMap.put(null, "410");
                    extinfos.add(extinfosMap);

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId");
                    bean.setNodeLocalName("TASK1");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("count2");
                    bean.setRirekiMessage("コメント１");
                    beanList.add(bean);
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

                case "17-14":
                    getProcessRecordOutBean.setKekkastatus("9");
                    getProcessRecordOutBean.setSyousaimsgcd("EBS0008");
                    break;
                case "17-15":

                    if ("ktkrId1004".equals(inBean.getGyoumukey())) {
                        ProcessRecordBean bean2 = new ProcessRecordBean();
                        List<Map<String, String>> extinfos2 = new ArrayList<Map<String, String>>();
                        Map<String, String> extinfosMap2 = new HashMap<String, String>();

                        extinfosMap2.put("1", "110");
                        extinfos2.add(extinfosMap2);
                        extinfosMap2 = new HashMap<String, String>();
                        extinfosMap2.put("2", "410");
                        extinfos2.add(extinfosMap2);

                        bean2.setSyoriTime("20151101");
                        bean2.setNodeName("testNodeId");
                        bean2.setNodeLocalName("TASK2");
                        bean2.setExtinfo(extinfos);
                        bean2.setAccountId("count2");
                        bean2.setRirekiMessage("コメント２");
                        beanList.add(bean2);

                        extinfosMap = new HashMap<String, String>();
                        extinfosMap.put("1", "110");
                        extinfos.add(extinfosMap);
                        extinfosMap = new HashMap<String, String>();
                        extinfosMap.put("2", "410");
                        extinfos.add(extinfosMap);

                        bean.setSyoriTime("20151201");
                        bean.setNodeName("testNodeId");
                        bean.setNodeLocalName("TASK1");
                        bean.setExtinfo(extinfos);
                        bean.setAccountId("count1");
                        bean.setRirekiMessage("コメント１");
                        beanList.add(bean);

                        ProcessRecordBean bean4 = new ProcessRecordBean();
                        List<Map<String, String>> extinfos4 = new ArrayList<Map<String, String>>();
                        Map<String, String> extinfosMap4 = new HashMap<String, String>();

                        extinfosMap4.put("1", "110");
                        extinfos4.add(extinfosMap4);
                        extinfosMap4 = new HashMap<String, String>();
                        extinfosMap4.put("syorikekkakbn", "210");
                        extinfos4.add(extinfosMap4);

                        bean4.setSyoriTime("20150901");
                        bean4.setNodeName("testNodeId");
                        bean4.setNodeLocalName("TASK4");
                        bean4.setExtinfo(extinfos4);
                        bean4.setAccountId("count4");
                        bean4.setRirekiMessage("コメント４");
                        beanList.add(bean4);

                        ProcessRecordBean bean3 = new ProcessRecordBean();
                        List<Map<String, String>> extinfos3 = new ArrayList<Map<String, String>>();
                        Map<String, String> extinfosMap3 = new HashMap<String, String>();

                        extinfosMap3.put("syorikekkakbn", "110");
                        extinfos3.add(extinfosMap3);
                        extinfosMap3 = new HashMap<String, String>();
                        extinfosMap3.put("2", "410");
                        extinfos3.add(extinfosMap3);

                        bean3.setSyoriTime("20151001");
                        bean3.setNodeName("testNodeId");
                        bean3.setNodeLocalName("TASK3");
                        bean3.setExtinfo(extinfos3);
                        bean3.setAccountId("count3");
                        bean3.setRirekiMessage("コメント３");
                        beanList.add(bean3);

                    }
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    break;

            }

            return getProcessRecordOutBean;
        }


        return super.execGetProcessRecord(inBean);

    }

    @Override
    public GetTaskSummaryOutBean execGetTaskSummary(GetTaskSummaryInBean inBean) {

        if ("Test".equals(caller)) {

            GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {

                case "28":
                    response = execGetTaskSummary28(tmpMode[1], inBean);
                    break;

                case "29":
                    response = execGetTaskSummary29(tmpMode[1], inBean);
                    break;

                default:
                    break;

            }

            return response;
        }


        return super.execGetTaskSummary(inBean);
    }

    private GetTaskSummaryOutBean execGetTaskSummary28(String pMode, GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        switch (pMode) {
            case "01":
                response = execGetTaskSummary2801(inBean);
                break;
            case "02":
                response = execGetTaskSummary2802(inBean);
                break;
            case "03":
                response = execGetTaskSummary2803(inBean);
                break;
            case "04":
                response = execGetTaskSummary2804(inBean);
                break;
            case "05":
                response = execGetTaskSummary2805(inBean);
                break;
            case "06":
                response = execGetTaskSummary2806(inBean);
                break;
            case "07":
                response = execGetTaskSummary2807(inBean);
                break;
            case "08":
                response = execGetTaskSummary2808(inBean);
                break;
            case "09":
                response = execGetTaskSummary2809(inBean);
                break;
            case "10":
                response = execGetTaskSummary2810(inBean);
                break;
            case "11":
                response = execGetTaskSummary2811(inBean);
                break;
            case "12":
                response = execGetTaskSummary2812(inBean);
                break;
            case "13":
                response = execGetTaskSummary2813(inBean);
                break;
            case "14":
                response = execGetTaskSummary2814(inBean);
                break;
            case "15":
                response = execGetTaskSummary2815(inBean);
                break;
            default:
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                beanList.add(bean);
                response.setTaskSummaryBeanList(beanList);
                break;
        }

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2801(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2802(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("-1");
        response.setSyousaimsgcd("IWFXXXX");
        response.setSyousaimsg("対象なし");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2803(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2804(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2805(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2806(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2807(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("新契約事務２タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務2");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務２タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2808(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2809(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        response.setKekkastatus("9");
        response.setSyousaimsgcd("IWF0001");
        response.setSyousaimsg("異常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2810(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            switch(inBean.getFlowid()){
                case "0024":
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName111");
                    bean.setTaskLocalName("新契約事務１タスク１");
                    bean.setTaskCount("10");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName346");
                    bean.setTaskLocalName("テストタスク２");
                    bean.setTaskCount("20");
                    beanList.add(bean);
                    break;
                case "0026":
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName222");
                    bean.setTaskLocalName("新契約事務３タスク１");
                    bean.setTaskCount("50");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName151");
                    bean.setTaskLocalName("新契約事務３タスク２");
                    bean.setTaskCount("60");
                    beanList.add(bean);
                    break;
                default:
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName333");
                    bean.setTaskLocalName("年金事務１タスク１");
                    bean.setTaskCount("80");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName834");
                    bean.setTaskLocalName("年金事務１タスク２");
                    bean.setTaskCount("90");
                    break;
            }
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            switch(inBean.getFlowid()){
                case "0024":
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName111");
                    bean.setTaskLocalName("新契約事務１タスク１");
                    bean.setTaskCount("10");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName346");
                    bean.setTaskLocalName("テストタスク２");
                    bean.setTaskCount("20");
                    beanList.add(bean);
                    break;
                case "0026":
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName222");
                    bean.setTaskLocalName("新契約事務３タスク１");
                    bean.setTaskCount("50");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName151");
                    bean.setTaskLocalName("新契約事務３タスク２");
                    bean.setTaskCount("60");
                    beanList.add(bean);
                    break;
                default:
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName333");
                    bean.setTaskLocalName("年金事務１タスク１");
                    bean.setTaskCount("80");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName834");
                    bean.setTaskLocalName("年金事務１タスク２");
                    bean.setTaskCount("90");
                    break;
            }
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            switch(inBean.getFlowid()){
                case "0024":
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName111");
                    bean.setTaskLocalName("新契約事務１タスク１");
                    bean.setTaskCount("10");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName346");
                    bean.setTaskLocalName("テストタスク２");
                    bean.setTaskCount("20");
                    beanList.add(bean);
                    break;
                case "0026":
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName222");
                    bean.setTaskLocalName("新契約事務３タスク１");
                    bean.setTaskCount("50");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName151");
                    bean.setTaskLocalName("新契約事務３タスク２");
                    bean.setTaskCount("60");
                    beanList.add(bean);
                    break;
                default:
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName333");
                    bean.setTaskLocalName("年金事務１タスク１");
                    bean.setTaskCount("80");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName834");
                    bean.setTaskLocalName("年金事務１タスク２");
                    bean.setTaskCount("90");
                    break;
            }
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            switch(inBean.getFlowid()){
                case "0024":
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName111");
                    bean.setTaskLocalName("新契約事務１タスク１");
                    bean.setTaskCount("10");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName346");
                    bean.setTaskLocalName("テストタスク２");
                    bean.setTaskCount("20");
                    beanList.add(bean);
                    break;
                case "0026":
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName222");
                    bean.setTaskLocalName("新契約事務３タスク１");
                    bean.setTaskCount("50");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務2");
                    bean.setTaskName("TaskName151");
                    bean.setTaskLocalName("新契約事務３タスク２");
                    bean.setTaskCount("60");
                    beanList.add(bean);
                    break;
                default:
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName333");
                    bean.setTaskLocalName("年金事務１タスク１");
                    bean.setTaskCount("80");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName834");
                    bean.setTaskLocalName("年金事務１タスク２");
                    bean.setTaskCount("90");
                    break;
            }
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2811(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            switch(inBean.getFlowid()){
                case "0024":
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName147");
                    bean.setTaskLocalName("新契約事務１タスク１");
                    bean.setTaskCount("10");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName346");
                    bean.setTaskLocalName("テストタスク２");
                    bean.setTaskCount("20");
                    beanList.add(bean);
                    break;
                case "0026":
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務3");
                    bean.setTaskName("TaskName150");
                    bean.setTaskLocalName("新契約事務３タスク１");
                    bean.setTaskCount("50");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務3");
                    bean.setTaskName("TaskName151");
                    bean.setTaskLocalName("新契約事務３タスク２");
                    bean.setTaskCount("60");
                    beanList.add(bean);
                    break;
                default:
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName147");
                    bean.setTaskLocalName("新契約事務２タスク３");
                    bean.setTaskCount("80");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName834");
                    bean.setTaskLocalName("テストタスク３");
                    bean.setTaskCount("90");
                    beanList.add(bean);
                    break;
            }
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            switch(inBean.getFlowid()){
                case "0024":
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName147");
                    bean.setTaskLocalName("新契約事務１タスク１");
                    bean.setTaskCount("10");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0024");
                    bean.setFlowName("新契約事務1");
                    bean.setTaskName("TaskName346");
                    bean.setTaskLocalName("テストタスク２");
                    bean.setTaskCount("20");
                    beanList.add(bean);
                    break;
                case "0026":
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務3");
                    bean.setTaskName("TaskName150");
                    bean.setTaskLocalName("新契約事務３タスク１");
                    bean.setTaskCount("50");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0026");
                    bean.setFlowName("新契約事務3");
                    bean.setTaskName("TaskName151");
                    bean.setTaskLocalName("新契約事務３タスク２");
                    bean.setTaskCount("60");
                    beanList.add(bean);
                    break;
                default:
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName147");
                    bean.setTaskLocalName("新契約事務２タスク３");
                    bean.setTaskCount("80");
                    beanList.add(bean);
                    bean = new TaskSummaryBean();
                    bean.setFlowId("0021");
                    bean.setFlowName("年金事務1");
                    bean.setTaskName("TaskName834");
                    bean.setTaskLocalName("テストタスク３");
                    bean.setTaskCount("90");
                    beanList.add(bean);
                    break;
            }
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2812(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2813(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2814(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("-1");
        response.setSyousaimsgcd("IWFXXXX");
        response.setSyousaimsg("対象なし");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2815(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName346");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName150");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName151");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName147");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName834");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary29(String pMode, GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        switch (pMode) {
            case "01":
                response = execGetTaskSummary2901(inBean);
                break;
            case "02":
                response = execGetTaskSummary2902(inBean);
                break;
            case "03":
                response = execGetTaskSummary2903(inBean);
                break;
            case "04":
                response = execGetTaskSummary2904(inBean);
                break;
            case "05":
                response = execGetTaskSummary2905(inBean);
                break;
            case "06":
                response = execGetTaskSummary2906(inBean);
                break;
            case "07":
                response = execGetTaskSummary2907(inBean);
                break;
            case "08":
                response = execGetTaskSummary2908(inBean);
                break;
            case "09":
                response = execGetTaskSummary2909(inBean);
                break;
            default:
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                beanList.add(bean);
                response.setTaskSummaryBeanList(beanList);
                break;
        }

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2901(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2902(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2903(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2904(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        response.setKekkastatus("9");
        response.setSyousaimsgcd("IWF0001");
        response.setSyousaimsg("異常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2905(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2906(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2907(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2908(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("-1");
        response.setSyousaimsgcd("IWFXXXX");
        response.setSyousaimsg("対象なし");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2909(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    @Override
    public GetExecutableTasksByProcessOutBean execGetExecutableTasksByProcess(GetExecutableTasksByProcessInBean inBean) {

        if ("Test".equals(caller)) {

            GetExecutableTasksByProcessOutBean response = new GetExecutableTasksByProcessOutBean();
            List<ExecutableTaskInfoBean> beanList = new ArrayList<ExecutableTaskInfoBean>();
            ExecutableTaskInfoBean bean = new ExecutableTaskInfoBean();

            switch (mode) {

                case "11-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "11-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-05":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-06":
                    bean.setFlowId("0024");
                    bean.setNodeName("JimuTetuzukiCd_147");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0025");
                    bean.setNodeName("JimuTetuzukiCd_148");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0026");
                    bean.setNodeName("JimuTetuzukiCd_142");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-07":
                    bean.setFlowId("0024");
                    bean.setNodeName("JimuTetuzukiCd_147");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0025");
                    bean.setNodeName("JimuTetuzukiCd_148");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0026");
                    bean.setNodeName("JimuTetuzukiCd_142");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-08":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "11-09":
                    bean.setFlowId("Id01");
                    bean.setNodeName("Task01");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("Id02");
                    bean.setNodeName("Task02");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("Id03");
                    bean.setNodeName("Task03");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-10":
                    bean.setFlowId("0024");
                    bean.setNodeName("JimuTetuzukiCd_147");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0025");
                    bean.setNodeName("JimuTetuzukiCd_148");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0026");
                    bean.setNodeName("JimuTetuzukiCd_142");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-11":
                    response.setKekkastatus("-1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("対象無し");
                    break;
                case "11-12":
                    bean.setFlowId("0024");
                    bean.setNodeName("JimuTetuzukiCd_147");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0025");
                    bean.setNodeName("JimuTetuzukiCd_148");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0026");
                    bean.setNodeName("JimuTetuzukiCd_142");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-13":
                    bean.setFlowId("Id01");
                    bean.setNodeName("Task01");
                    bean.setTaskCountKojin("5");
                    bean.setTaskcountKyouyuu("10");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "11-14":
                    bean.setFlowId("Id01");
                    bean.setNodeName("Task01");
                    bean.setTaskCountKojin("5");
                    bean.setTaskcountKyouyuu("10");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "12-02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-04":
                    bean.setFlowId("0001");
                    bean.setNodeName("JimuTetuzukiCd_5");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0002");
                    bean.setNodeName("JimuTetuzukiCd_8");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0003");
                    bean.setNodeName("JimuTetuzukiCd_15");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-05":
                    bean.setFlowId("0001");
                    bean.setNodeName("JimuTetuzukiCd_5");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0002");
                    bean.setNodeName("JimuTetuzukiCd_8");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0003");
                    bean.setNodeName("JimuTetuzukiCd_15");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-06":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "12-07":
                    bean.setFlowId("0001");
                    bean.setNodeName("Task01");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0002");
                    bean.setNodeName("Task02");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0003");
                    bean.setNodeName("Task03");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-08":
                    bean.setFlowId("0001");
                    bean.setNodeName("JimuTetuzukiCd_5");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0002");
                    bean.setNodeName("JimuTetuzukiCd_8");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0003");
                    bean.setNodeName("JimuTetuzukiCd_15");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-09":
                    response.setKekkastatus("-1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("対象無し");
                    break;
                case "12-10":
                    bean.setFlowId("0001");
                    bean.setNodeName("JimuTetuzukiCd_5");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0002");
                    bean.setNodeName("JimuTetuzukiCd_8");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    bean = new ExecutableTaskInfoBean();
                    bean.setFlowId("0003");
                    bean.setNodeName("JimuTetuzukiCd_15");
                    bean.setTaskCountKojin("1");
                    bean.setTaskcountKyouyuu("1");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-11":
                    bean.setFlowId("0001");
                    bean.setNodeName("Task01");
                    bean.setTaskCountKojin("5");
                    bean.setTaskcountKyouyuu("10");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "12-12":
                    bean.setFlowId("0001");
                    bean.setNodeName("Task01");
                    bean.setTaskCountKojin("5");
                    bean.setTaskcountKyouyuu("10");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        }

        return super.execGetExecutableTasksByProcess(inBean);

    }

    @Override
    public GetTaskSummaryByActorOutBean execGetTaskSummaryByActor(GetTaskSummaryByActorInBean inBean) {

        if ("Test".equals(caller)) {

            GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {

                case "30":
                    response = execGetTaskSummaryByActor30(tmpMode[1], inBean);
                    break;
                default:
                    break;

            }

            return response;
        }


        return super.execGetTaskSummaryByActor(inBean);
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor30(String pMode, GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();

        switch (pMode) {
            case "01":
                response = execGetTaskSummaryByActor3001(inBean);
                break;
            case "02":
                response = execGetTaskSummaryByActor3002(inBean);
                break;
            case "03":
                response = execGetTaskSummaryByActor3003(inBean);
                break;
            case "04":
                response = execGetTaskSummaryByActor3004(inBean);
                break;
            case "05":
                response = execGetTaskSummaryByActor3005(inBean);
                break;
            case "06":
                response = execGetTaskSummaryByActor3006(inBean);
                break;
            case "07":
                response = execGetTaskSummaryByActor3007(inBean);
                break;
            case "08":
                response = execGetTaskSummaryByActor3008(inBean);
                break;
            case "09":
                response = execGetTaskSummaryByActor3009(inBean);
                break;
            case "10":
                response = execGetTaskSummaryByActor3010(inBean);
                break;
            case "11":
                response = execGetTaskSummaryByActor3011(inBean);
                break;
            case "12":
                response = execGetTaskSummaryByActor3012(inBean);
                break;
            case "13":
                response = execGetTaskSummaryByActor3013(inBean);
                break;
            case "14":
                response = execGetTaskSummaryByActor3014(inBean);
                break;
            default:
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                beanList.add(bean);
                response.setTaskSummaryByActorBeanList(beanList);
                break;
        }

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3001(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test1");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3002(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3003(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3004(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();

        response.setKekkastatus("9");
        response.setSyousaimsgcd("IWF0001");
        response.setSyousaimsg("異常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3005(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3006(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test");
            beanList.add(bean);

        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3007(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3008(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3009(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId("test4");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("test4");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId("test4");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3010(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3011(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId("test");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId("test");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId("test");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            bean.setUserId(inBean.getAccountid());
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("6");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("13");
            bean.setUserId("test");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3012(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("test");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("test1");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("3");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("21");
            bean.setUserId("test");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("45");
            bean.setUserId("test1");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3013(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("-1");
        response.setSyousaimsgcd("IWFXXXX");
        response.setSyousaimsg("対象なし");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3014(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() == null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() != null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_ARI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }


        if (inBean.getAccountid() == null
                && inBean.getWariateumu().equals(WorkFlowUtilityConstants.ACCOUNT_WARIATE_UMU_NASHI)
                && inBean.getTaskstarttimeto() != null && inBean.getTaskendtimeto() != null) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("20");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        response.setTaskSummaryByActorBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    @Override
    public ProcessForwardOutBean execProcessForward(ProcessForwardInBean inBean, Object... contditions) {

        if ("Test".equals(caller)) {

            ProcessForwardOutBean processForwardOutBean = new ProcessForwardOutBean();

            switch (mode) {
                case "dl-01":
                    super.execProcessForward(inBean);
                    processForwardOutBean.setKekkastatus("0");
                    processForwardOutBean.setSyousaimsg("正常終了しました。");
                    processForwardOutBean.setSyousaimsgcd("IWF0000");

                    break;

                case "dl-02":
                    processForwardOutBean.setKekkastatus("9");
                    processForwardOutBean.setSyousaimsg("必須入力チェックエラー");
                    processForwardOutBean.setSyousaimsgcd("IWF0002");
                    break;
                case "dl01-01":
                    super.execProcessForward(inBean);
                    processForwardOutBean.setKekkastatus("0");
                    processForwardOutBean.setSyousaimsg("正常終了しました。");
                    processForwardOutBean.setSyousaimsgcd("IWF0000");

                    break;

                case "dl01-02":
                    processForwardOutBean.setKekkastatus("9");
                    processForwardOutBean.setSyousaimsg("必須入力チェックエラー");
                    processForwardOutBean.setSyousaimsgcd("IWF0002");
                    break;

            }

            return processForwardOutBean;
        }



        return super.execProcessForward(inBean);

    }

    @Override
    public ForceProcessForwardOutBean execForceProcessForward(ForceProcessForwardInBean inBean) {

        if ("Test".equals(caller)) {

            ForceProcessForwardOutBean forceProcessForwardOutBean = new ForceProcessForwardOutBean();

            switch (mode) {
                case "dl-01":
                    super.execForceProcessForward(inBean);
                    forceProcessForwardOutBean.setKekkastatus("0");
                    forceProcessForwardOutBean.setSyousaimsg("正常終了しました。");
                    forceProcessForwardOutBean.setSyousaimsgcd("IWF0000");

                    break;

                case "dl-02":
                    forceProcessForwardOutBean.setKekkastatus("9");
                    forceProcessForwardOutBean.setSyousaimsg("必須入力チェックエラー");
                    forceProcessForwardOutBean.setSyousaimsgcd("IWF0002");
                    break;
                case "dl01-01":
                    super.execForceProcessForward(inBean);
                    forceProcessForwardOutBean.setKekkastatus("0");
                    forceProcessForwardOutBean.setSyousaimsg("正常終了しました。");
                    forceProcessForwardOutBean.setSyousaimsgcd("IWF0000");

                    break;

                case "dl01-02":
                    forceProcessForwardOutBean.setKekkastatus("9");
                    forceProcessForwardOutBean.setSyousaimsg("必須入力チェックエラー");
                    forceProcessForwardOutBean.setSyousaimsgcd("IWF0002");
                    break;

            }

            return forceProcessForwardOutBean;
        }



        return super.execForceProcessForward(inBean);

    }

    @Override
    public ProcessForwardForBatchOutBean execProcessForwardForBatch(ProcessForwardForBatchInBean inBean) {

        ProcessForwardForBatchOutBean processForwardForBatchOutBean = SWAKInjector.getInstance(ProcessForwardForBatchOutBean.class);
        ProcessForwardForBatchInBean processForwardForBatchInBean = SWAKInjector.getInstance(ProcessForwardForBatchInBean.class);
        if ("Test".equals(caller)) {

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "dl":
                    processForwardForBatchOutBean = execProcessForwardForBatch01(tmpMode[1]);
            }
        }
        return processForwardForBatchOutBean;

    }

    public ProcessForwardForBatchOutBean execProcessForwardForBatch01(String pMode){
        ProcessForwardForBatchOutBean processForwardForBatchOutBean = SWAKInjector.getInstance(ProcessForwardForBatchOutBean.class);
        switch (pMode) {
            case "01":
                processForwardForBatchOutBean.setKekkastatus(BzIwfUtilConstants.API_RESULTCD_OK);
                break;
            case "02":
                processForwardForBatchOutBean.setKekkastatus(BzIwfUtilConstants.API_SYORIKBN_RIREKISAKUSEIYOU);
                processForwardForBatchOutBean.setSyousaimsgcd("IWF0002");
                break;
        }

        return processForwardForBatchOutBean;
    }

    @Override
    public GetExecutableTasksOutBean execGetExecutableTasks(GetExecutableTasksInBean inBean) {

        if ("Test".equals(caller)) {

            GetExecutableTasksOutBean response = new GetExecutableTasksOutBean();
            List<ExecutableTaskInfoBean> beanList = new ArrayList<ExecutableTaskInfoBean>();
            ExecutableTaskInfoBean bean = new ExecutableTaskInfoBean();

            switch (mode) {

                case "01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9999");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "02":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    bean.setFlowId("Flow01");
                    bean.setNodeName("Node01");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    break;
                case "04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    bean.setFlowId("Flow01");
                    bean.setNodeName("Node01");
                    beanList.add(bean);
                    bean.setFlowId("Flow02");
                    bean.setNodeName("Node02");
                    beanList.add(bean);
                    bean.setFlowId("Flow03");
                    bean.setNodeName("Node03");
                    beanList.add(bean);
                    response.setExecutableTaskInfos(beanList);
                    break;
            }
            return response;
        }

        return super.execGetExecutableTasks(inBean);

    }


}