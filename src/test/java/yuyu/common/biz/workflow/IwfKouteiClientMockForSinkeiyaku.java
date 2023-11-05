package yuyu.common.biz.workflow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzIwfUtilConstants;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ContinueLockProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceUnlockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessInBean;
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksByProcessOutBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoInBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoOutBean;
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
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardForBatchOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardOutBean;
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
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryBean;
import yuyu.common.biz.workflow.io.koutei.sub.TaskSummaryByActorBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.workflow.workflowutility.WorkFlowUtilityConstants;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess.WSForceUnlockProcessResponse;
import yuyu.def.classification.C_ResultCdKbn;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * {@link IwfKouteiClient}のモッククラスです。<br />
 */
public class IwfKouteiClientMockForSinkeiyaku extends IwfKouteiClient {
    public static String caller = null;
    public static String mode = null;
    public static String flg = null;

    public static Class<?> caller2 = null;

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
                case "32":
                    getProcessSummaryOutBean = execGetProcessSummary32(tmpMode[1]);
                    break;
                case "35":
                    getProcessSummaryOutBean = execGetProcessSummary35(tmpMode[1]);
                    break;
                case "dl01":
                    getProcessSummaryOutBean = execGetProcessSummaryDL01(tmpMode[1]);
                    break;
                case "dl":
                    getProcessSummaryOutBean = execGetProcessSummaryDL01(tmpMode[1]);
                    break;
                case "05":
                    getProcessSummaryOutBean = execGetProcessSummary05(tmpMode[1]);
                    break;
                case "28":
                    getProcessSummaryOutBean = execGetProcessSummary28(tmpMode[1]);
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
        if (caller2 == SkProcessCreateTest_exec.class) {
            GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
            getProcessSummaryOutBean.setKekkastatus(BzIwfUtilConstants.API_RESULTCD_OK);
            return getProcessSummaryOutBean;
        }
        return super.execGetProcessSummary(inBean);

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
                extParamBean.setExtparam1("01");
                extParamBean.setExtparam2("1");
                extParamBean.setExtparam3("441");
                extParamBean.setExtparam4("drtcd1");
                extParamBean.setExtparam5("drtcd2");
                extParamBean.setExtparam7("jmcd1");
                extParamBean.setExtparam8("1");
                extParamBean.setExtparam9("0");
                extParamBean.setExtparam10("20150508");
                extParamBean.setExtparam11("20150202121022333");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345661");
                extParamBean.setExtparam14("780123451");
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
                extParamBean.setExtparam1("01");
                extParamBean.setExtparam2("1");
                extParamBean.setExtparam3("441");
                extParamBean.setExtparam4("drtcd1");
                extParamBean.setExtparam5("drtcd2");
                extParamBean.setExtparam7("jmcd1");
                extParamBean.setExtparam8("1");
                extParamBean.setExtparam9("0");
                extParamBean.setExtparam10("20150508");
                extParamBean.setExtparam11("20150202121022333");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345661");
                extParamBean.setExtparam14("780123451");
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
                extParamBean2.setExtparam1("01");
                extParamBean2.setExtparam2("1");
                extParamBean2.setExtparam3("441");
                extParamBean2.setExtparam4("drtcd1");
                extParamBean2.setExtparam5("drtcd2");
                extParamBean2.setExtparam7("jmcd1");
                extParamBean2.setExtparam8("1");
                extParamBean2.setExtparam9("0");
                extParamBean2.setExtparam10("20150508");
                extParamBean2.setExtparam11("20150202121022333");
                extParamBean2.setExtparam12("12806345683");
                extParamBean2.setExtparam13("12806345661");
                extParamBean2.setExtparam14("780123444");
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
                extParamBean3.setExtparam1("02");
                extParamBean3.setExtparam2("2");
                extParamBean3.setExtparam3("442");
                extParamBean3.setExtparam4("drtcd3");
                extParamBean3.setExtparam5("drtcd4");
                extParamBean3.setExtparam7("jmcd2");
                extParamBean3.setExtparam8("0");
                extParamBean3.setExtparam9("1");
                extParamBean3.setExtparam10("20150509");
                extParamBean3.setExtparam11("20150302121022111");
                extParamBean3.setExtparam12("12806345672");
                extParamBean3.setExtparam13("12806345661");
                extParamBean3.setExtparam14("780123451");
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
            case "14":
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("user003");
                extParamBean.setExtparam1("");
                extParamBean.setExtparam2("");
                extParamBean.setExtparam3("");
                extParamBean.setExtparam4("drtcd1");
                extParamBean.setExtparam5("drtcd2");
                extParamBean.setExtparam7("jmcd1");
                extParamBean.setExtparam8("");
                extParamBean.setExtparam9("");
                extParamBean.setExtparam10("");
                extParamBean.setExtparam11("20150202121022333");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345661");
                extParamBean.setExtparam14("780123451");
                extParamBean.setExtparam15("3");
                extParamBean.setExtparam16("3");
                extParamBean.setExtparam17("3");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "15":
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setPreviousNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150720163400");
                processSummaryBean.setFirstAccountId("user001");
                processSummaryBean.setPreviousAccountId("user002");
                processSummaryBean.setCurrentAccountId("user003");
                extParamBean.setExtparam1("");
                extParamBean.setExtparam2("");
                extParamBean.setExtparam3("");
                extParamBean.setExtparam4("drtcd1");
                extParamBean.setExtparam5("drtcd2");
                extParamBean.setExtparam7("jmcd1");
                extParamBean.setExtparam8("");
                extParamBean.setExtparam9("");
                extParamBean.setExtparam10("");
                extParamBean.setExtparam11("20150202121022333");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345661");
                extParamBean.setExtparam14("780123451");
                extParamBean.setExtparam15("3");
                extParamBean.setExtparam16("3");
                extParamBean.setExtparam17("3");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("1");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF2160");
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
                processSummaryBean.setCurrentAccountId("");
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
                processSummaryBean.setCurrentAccountId("");
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
                processSummaryBean.setCurrentAccountId("UserId02");
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
                processSummaryBean.setCurrentAccountId("UserId03");
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
                processSummaryBean.setCurrentAccountId("UserId04");
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
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "03":
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
            case "04":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("TaskNm02");
                processSummaryBean.setCurrentNodeLocalname("タスク名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("SyoNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("TaskNm01");
                processSummaryBean.setCurrentNodeLocalname("タスク名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150714030405006");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam14("12345678902");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("TaskNm03");
                processSummaryBean.setCurrentNodeLocalname("タスク名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716030405006");
                extParamBean.setExtparam12("SyoNo03");
                extParamBean.setExtparam13("NkSysyNo03");
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
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("102");
                processSummaryBean.setFirstAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("12806345683");
                extParamBean.setExtparam13("12806345683");
                extParamBean.setExtparam14("12806345683");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setFirstAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345672");
                extParamBean.setExtparam14("12806345672");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("103");
                processSummaryBean.setFirstAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150715030405006");
                extParamBean.setExtparam12("12806345694");
                extParamBean.setExtparam13("12806345694");
                extParamBean.setExtparam14("12806345694");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "04":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0004");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setFirstAccountId("UserId04");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345672");
                extParamBean.setExtparam14("12806345672");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "05":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("102");
                processSummaryBean.setFirstAccountId("UserId02");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12806345683");
                extParamBean.setExtparam13("12806345683");
                extParamBean.setExtparam14("12806345683");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setFirstAccountId("UserId01");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345672");
                extParamBean.setExtparam14("12806345672");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("103");
                processSummaryBean.setFirstAccountId("UserId03");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam12("12806345694");
                extParamBean.setExtparam13("12806345694");
                extParamBean.setExtparam14("12806345694");
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
                processSummaryBean.setCurrentAccountId("UserId04");
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
                processSummaryBean.setCurrentAccountId("UserId03");
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
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0003");
                getProcessSummaryOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "05":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("102");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150702");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("12806345683");
                extParamBean.setExtparam13("12806345683");
                extParamBean.setExtparam14("12806345683");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("103");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150701");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("12806345694");
                extParamBean.setExtparam13("12806345694");
                extParamBean.setExtparam14("12806345694");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setKouteiKaisiYmd("20150703");
                processSummaryBean.setKouteikanryouYmd("20150703");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150716010203004");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345672");
                extParamBean.setExtparam14("12806345672");
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
                processSummaryBean.setGyoumukey("KouteiKnrId13");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("KouteiKnrId13");
                processSummaryBean.setKouteiKaisiYmd("20150701");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("KouteiKnrId15");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("KouteiKnrId15");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150711");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0004");
                processSummaryBean.setGyoumukey("KouteiKnrId14");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("UserId04");
                processSummaryBean.setCurrentNodeName("Task03");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0004");
                processSummaryBean.setGyoumukey("KouteiKnrId14");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("UserId04");
                processSummaryBean.setCurrentNodeName("Task03");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名03");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150702010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "07":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("KouteiKnrId13");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("KouteiKnrId15");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
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
                processSummaryBean.setGyoumukey("KouteiKnrId13");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150727010203004");
                processSummaryBean.setCurrentAccountId("UserId01");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名01");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("KouteiKnrId15");
                processSummaryBean.setKouteiKaisiYmd("20150702");
                processSummaryBean.setKouteikanryouYmd("20150712");
                processSummaryBean.setProcessstatus("10");
                processSummaryBean.setUpdateTime("20150728010203004");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setCurrentNodeLocalname("タスクローカル名02");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam11("20150703010203004");
                extParamBean.setExtparam12("12345678901");
                extParamBean.setExtparam13("12345678901");
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
                processSummaryBean.setFlowId("0001");
                processSummaryBean.setGyoumukey("GyoumuKey04");
                extParamBean.setExtparam12("SysyNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam14("MosNo01");
                extParamBean.setExtparam11("20150101123456777");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId04");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey05");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam14("MosNo02");
                extParamBean.setExtparam11("20150102123456777");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setPreviousAccountId("UserId05");
                processSummaryBean.setPreviousNodeName("Task02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey06");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam14("MosNo03");
                extParamBean.setExtparam11("20150103123456777");
                extParamBean.setExtparam3("SyouhinCode003");
                processSummaryBean.setPreviousAccountId("UserId03");
                processSummaryBean.setPreviousNodeName("Task03");
                processSummaryBean.setCurrentAccountId("UserId03");
                processSummaryBean.setCurrentNodeName("Task03");
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
                extParamBean.setExtparam14("MosNo01");
                extParamBean.setExtparam11("20150101123456777");
                extParamBean.setExtparam3("SyouhinCode001");
                processSummaryBean.setPreviousAccountId("UserId01");
                processSummaryBean.setPreviousNodeName("Task01");
                processSummaryBean.setCurrentAccountId("UserId04");
                processSummaryBean.setCurrentNodeName("Task01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0002");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SysyNo02");
                extParamBean.setExtparam13("NkSysyNo02");
                extParamBean.setExtparam14("MosNo02");
                extParamBean.setExtparam11("20150101123456777");
                extParamBean.setExtparam3("SyouhinCode002");
                processSummaryBean.setPreviousAccountId("UserId05");
                processSummaryBean.setPreviousNodeName("Task02");
                processSummaryBean.setCurrentAccountId("UserId02");
                processSummaryBean.setCurrentNodeName("Task02");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("0003");
                processSummaryBean.setGyoumukey("GyoumuKey03");
                extParamBean.setExtparam12("SysyNo03");
                extParamBean.setExtparam13("NkSysyNo03");
                extParamBean.setExtparam14("MosNo03");
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
            case "12":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("0001");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345672");
                extParamBean.setExtparam14("12806345672");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                break;
            case "13":
                processSummaryBean = new ProcessSummaryBean();
                processSummaryBean.setGyoumukey("101");
                processSummaryBean.setProcessstatus("10");
                extParamBean = new ExtParamBean();
                extParamBean.setExtparam7("0001");
                extParamBean.setExtparam12("12806345672");
                extParamBean.setExtparam13("12806345672");
                extParamBean.setExtparam14("12806345672");
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

    private GetProcessSummaryOutBean execGetProcessSummary32(String pMode) {
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
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                processSummaryBean = new ProcessSummaryBean();
                extParamBean = new ExtParamBean();
                processSummaryBean.setFlowId("FlowId02");
                processSummaryBean.setGyoumukey("GyoumuKey02");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);

                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                extParamBean.setExtparam14("12345678901");
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
                extParamBean.setExtparam14("12345678901");
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
                extParamBean.setExtparam14("12345678901");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "07":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("hijklmn1");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
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

    private GetProcessSummaryOutBean execGetProcessSummary35(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "05":

                getProcessSummaryOutBean.setKekkastatus("9");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("異常終了しました。");
                break;
            case "06":
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
            case "07":
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
            case "09":
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
                case "05-17":
                    response.setKekkastatus("-9");
                    response.setSyousaimsgcd("IWF2091");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF2091");
                    response.setSyousaimsg("対象のトークンは既にロックされています。");
                    break;
                case "16-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-03":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "16-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "16-05":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-02":
                    if ("FlowId01".equals(inBean.getFlowid()) && "GyoumuKey01".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF0000");
                        response.setSyousaimsg("正常終了しました。");
                    }

                    if ("FlowId02".equals(inBean.getFlowid()) && "GyoumuKey02".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("9");
                        response.setSyousaimsgcd("IWF2091");
                        response.setSyousaimsg("必須入力チェックエラー。");
                    }
                    break;
                case "32-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "32-04":
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-05":
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-06":
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-07":
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;

                case "dl33-01":
                    response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF2092");
                    break;
                case "dl33-02":
                    if ("10000000001".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2092");
                    }
                    else if ("10000000002".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2093");
                        break;
                    }else {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    }
                    break;
                case "dl33-03":
                    if ("10000000001".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2092");
                    }
                    else if ("10000000002".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2091");
                        break;
                    }else {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    }
                    break;
                case "dl33-04":
                    if ("10000000001".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2092");
                    }
                    else if ("10000000002".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2092");
                    }else {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    }
                    break;
                case "dl33-05":
                    if ("10000000001".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2092");
                    }
                    else if ("10000000002".equals(inBean.getGyoumukey())) {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2094");
                    }else {
                        response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    }
                    break;
                case "dl33-06":
                    response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2093");
                    break;
                case "dl33-07":
                    response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2091");
                    break;
                case "dl33-08":
                    response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2092");
                    break;
                case "dl33-09":
                    response.setKekkastatus(C_ResultCdKbn.OK.getValue());
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2094");
                    break;
                default:
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        }

        return super.execLockProcess(inBean);
    }

    @Override
    public ProcessUpdateOutBean execProcessUpdate(ProcessUpdateInBean inBean) {
        if ("Test".equals(caller)) {
            ProcessUpdateOutBean response = new ProcessUpdateOutBean();
            switch (mode) {
                case "32-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0002");
                    response.setSyousaimsg("必須入力チェックエラー。");
                    break;
                case "32-05":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-06":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-07":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "32-08":
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
        }

        return super.execProcessUpdate(inBean);
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
                case "32-02":
                    response.setKekkastatus("0");
                    break;
                case "32-03":
                    response.setKekkastatus("0");
                    break;
                case "32-05":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "32-06":
                    response.setKekkastatus("0");
                    break;
                case "32-07":
                    response.setKekkastatus("0");
                    break;
                case "dl33-01":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF2105");
                    break;
                case "dl33-02":
                    if (flg == null) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2105");
                        flg = "1";
                    } else if ("1".equals(flg)) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2101");
                        flg = null;
                    }
                    break;
                case "dl33-03":
                    if (flg == null) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2105");
                        flg = "1";
                    } else if ("1".equals(flg)) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2102");
                        flg = null;
                    }
                    break;
                case "dl33-04":
                    if (flg == null) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2105");
                        flg = "1";
                    } else if ("1".equals(flg)) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2103");
                        flg = null;
                    }
                    break;
                case "dl33-05":
                    if (flg == null) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2105");
                        flg = "1";
                    } else if ("1".equals(flg)) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2104");
                        flg = null;
                    }
                    break;
                case "dl33-06":
                    if (flg == null) {
                        response.setKekkastatus("0");
                        response.setSyousaimsgcd("IWF2105");
                        flg = "1";
                    } else if ("1".equals(flg)) {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF2105");
                        flg = null;
                    }
                    break;
                case "dl33-07":
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2101");
                    break;
                case "dl33-08":
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2102");
                    break;
                case "dl33-09":
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2103");
                    break;
                case "dl33-10":
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2104");
                    break;
                case "dl33-11":
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF2105");
                    break;
                default:
                    response.setGyoumukey("GyoumuKey01");
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        }

        return super.execUnlockProcess(inBean);
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
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0001");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "02-02":
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
                case "dl01-10":
                    response.setKekkastatus("0");
                    break;
                case "06-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0006");
                    response.setSyousaimsg("異常終了しました");
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

                case "16-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-04":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "16-05":
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "dl01-01":
                    if (flg == "dl01") {
                        response.setKekkastatus("0");
                    } else if (flg == "dl02") {
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
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("異常終了しました");
                    break;
                case "16-12":
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
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "01-05":
                    response.setKekkastatus("0");
                    break;
                case "dl-01":
                    super.execCcreateProcessRecord(inBean);
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
                    } else if (flg == "dl02") {
                        response.setKekkastatus("1");
                        response.setSyousaimsgcd("IWF0009");
                        break;
                    }

                case "dl01-02":
                    if (flg == "dl01") {
                        response.setKekkastatus("0");
                        break;
                    } else if (flg == "dl02") {
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
                case "01-12":
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId04");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId03");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
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
                case "36-01":
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId04");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId03");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "36-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "36-03":
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId04");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId03");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "39-01":
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId04");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId03");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "39-02":
                    bean.setGyoumukey("GyoumuKey02");
                    bean.setFlowId("0002");
                    bean.setNodeName("TaskNm02");
                    bean.setAccountId("UserId04");
                    bean.setLockKey("LockKey02");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    bean = new LockInfoBean();
                    bean.setGyoumukey("GyoumuKey01");
                    bean.setFlowId("0001");
                    bean.setNodeName("TaskNm01");
                    bean.setAccountId("UserId03");
                    bean.setLockKey("LockKey01");
                    bean.setLockTime("20150716020304005");
                    beanList.add(bean);
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("1");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "39-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "15-01":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "15-02":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "15-07":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "15-09":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "15-10":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "15-11":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "15-13":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-07":
                    response.setLockInfoBeanList(beanList);
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "35-09":
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

            List<ProcessRecordBean> beanList1 = new ArrayList<ProcessRecordBean>();
            List<ProcessRecordBean> beanList2 = new ArrayList<ProcessRecordBean>();
            ProcessRecordBean processRecordBean = new ProcessRecordBean();
            processRecordBean.setSyoriTime("20160311");
            processRecordBean.setGyoumukey("01");
            processRecordBean.setFlowId("02");
            processRecordBean.setFlowName("fName");
            processRecordBean.setNodeName("nName");
            processRecordBean.setNodeLocalName("nlName");
            processRecordBean.setAccountId("03");
            processRecordBean.setSyoriKbn("00");
            processRecordBean.setRirekiKbn("0");
            processRecordBean.setRirekiMessage("rirekiMessage");
            beanList2.add(processRecordBean);

            List<ProcessRecordBean> beanList3 = new ArrayList<ProcessRecordBean>();
            List<Map<String, String>> lstMap = new ArrayList<Map<String, String>>();
            Map<String, String> map = new HashMap<String, String>();
            lstMap.add(map);
            ProcessRecordBean processRecordBean1 = new ProcessRecordBean();
            processRecordBean1.setSyoriTime("20160311");
            processRecordBean1.setGyoumukey("01");
            processRecordBean1.setFlowId("02");
            processRecordBean1.setFlowName("fName");
            processRecordBean1.setNodeName("nName");
            processRecordBean1.setNodeLocalName("nlName");
            processRecordBean1.setAccountId("03");
            processRecordBean1.setSyoriKbn("00");
            processRecordBean1.setRirekiKbn("0");
            processRecordBean1.setRirekiMessage("rirekiMessage");
            processRecordBean1.setExtinfo(lstMap);
            beanList3.add(processRecordBean1);

            List<ProcessRecordBean> beanList4 = new ArrayList<ProcessRecordBean>();
            ProcessRecordBean processRecordBean2 = new ProcessRecordBean();
            processRecordBean2.setSyoriTime("20160311");
            processRecordBean2.setGyoumukey("01");
            processRecordBean2.setFlowId("02");
            processRecordBean2.setFlowName("fName");
            processRecordBean2.setNodeName("nName");
            processRecordBean2.setNodeLocalName("nlName");
            processRecordBean2.setAccountId("03");
            processRecordBean2.setSyoriKbn("00");
            processRecordBean2.setRirekiKbn("0");
            processRecordBean2.setRirekiMessage("rirekiMessage");
            beanList4.add(processRecordBean2);
            ProcessRecordBean processRecordBean3 = new ProcessRecordBean();
            processRecordBean3.setSyoriTime("20160312");
            processRecordBean3.setGyoumukey("01");
            processRecordBean3.setFlowId("02");
            processRecordBean3.setFlowName("fName");
            processRecordBean3.setNodeName("nName");
            processRecordBean3.setNodeLocalName("nlName");
            processRecordBean3.setAccountId("03");
            processRecordBean3.setSyoriKbn("00");
            processRecordBean3.setRirekiKbn("0");
            processRecordBean3.setRirekiMessage("rirekiMessage");
            beanList4.add(processRecordBean3);

            List<Map<String, String>> lstMap1 = new ArrayList<Map<String, String>>();
            Map<String, String> map1 = new HashMap<String, String>();
            Map<String, String> map2 = new HashMap<String, String>();
            map2.put(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN, "110");
            Map<String, String> map3 = new HashMap<String, String>();
            lstMap1.add(map1);
            lstMap1.add(map2);
            lstMap1.add(map3);
            ProcessRecordBean processRecordBean4 = new ProcessRecordBean();
            processRecordBean4.setSyoriTime("20160313");
            processRecordBean4.setGyoumukey("01");
            processRecordBean4.setFlowId("02");
            processRecordBean4.setFlowName("fName");
            processRecordBean4.setNodeName("nName");
            processRecordBean4.setNodeLocalName("nlName");
            processRecordBean4.setAccountId("03");
            processRecordBean4.setSyoriKbn("00");
            processRecordBean4.setRirekiKbn("0");
            processRecordBean4.setRirekiMessage("rirekiMessage");
            processRecordBean4.setExtinfo(lstMap1);
            beanList4.add(processRecordBean4);

            List<ProcessRecordBean> beanList5 = new ArrayList<ProcessRecordBean>();
            List<Map<String, String>> lstMap3 = new ArrayList<Map<String, String>>();
            lstMap3.add(map);
            ProcessRecordBean processRecordBean5 = new ProcessRecordBean();
            processRecordBean5.setSyoriTime("20160311");
            processRecordBean5.setGyoumukey("01");
            processRecordBean5.setFlowId("02");
            processRecordBean5.setFlowName("fName");
            processRecordBean5.setNodeName("nName");
            processRecordBean5.setNodeLocalName("nlName");
            processRecordBean5.setAccountId("03");
            processRecordBean5.setSyoriKbn("00");
            processRecordBean5.setRirekiKbn("0");
            processRecordBean5.setRirekiMessage("rirekiMessage");
            beanList5.add(processRecordBean5);

            List<ProcessRecordBean> beanList6 = new ArrayList<ProcessRecordBean>();
            List<Map<String, String>> lstMap4 = new ArrayList<Map<String, String>>();
            lstMap4.add(map);
            ProcessRecordBean processRecordBean6 = new ProcessRecordBean();
            processRecordBean6.setSyoriTime("20160311");
            processRecordBean6.setGyoumukey("01");
            processRecordBean6.setFlowId("02");
            processRecordBean6.setFlowName("fName");
            processRecordBean6.setNodeName("nName");
            processRecordBean6.setNodeLocalName("nlName");
            processRecordBean6.setAccountId("03");
            processRecordBean6.setRirekiMessage("rirekiMessage");
            beanList6.add(processRecordBean6);

            List<ProcessRecordBean> beanList7 = new ArrayList<ProcessRecordBean>();
            List<Map<String, String>> lstMap5 = new ArrayList<Map<String, String>>();
            lstMap5.add(map);
            ProcessRecordBean processRecordBean7 = new ProcessRecordBean();
            processRecordBean7.setSyoriTime("20160311");
            processRecordBean7.setGyoumukey("01");
            processRecordBean7.setFlowId("02");
            processRecordBean7.setFlowName("fName");
            processRecordBean7.setNodeName("nName");
            processRecordBean7.setNodeLocalName("nlName");
            processRecordBean7.setAccountId("03");
            processRecordBean7.setSyoriKbn("");
            processRecordBean7.setRirekiKbn("");
            processRecordBean7.setRirekiMessage("rirekiMessage");
            beanList7.add(processRecordBean7);

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

                    bean.setSyoriTime("20150102");
                    bean.setNodeName("testNodeId1");
                    bean.setNodeLocalName("テストノード名０１");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("UserId01");
                    bean.setRirekiMessage("タスク生成０１");
                    beanList.add(bean);

                    bean = new ProcessRecordBean();
                    extinfos = new ArrayList<Map<String, String>>();

                    bean.setSyoriTime("20150101");
                    bean.setNodeName("testNodeId3");
                    bean.setNodeLocalName("テストノード名０３");
                    bean.setExtinfo(extinfos);
                    bean.setAccountId("UserId03");
                    bean.setRirekiMessage("タスク生成０３");
                    beanList.add(bean);

                    bean = new ProcessRecordBean();

                    bean.setSyoriTime("20140101");
                    bean.setNodeName("testNodeId4");
                    bean.setNodeLocalName("テストノード名０４");
                    bean.setAccountId("UserId04");
                    bean.setRirekiMessage("タスク生成０４");
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
                    bean.setAccountId("count1");
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

                case "dl-01":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(null);
                    break;
                case "dl-02":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList1);
                    break;
                case "dl-03":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList2);
                    break;
                case "dl-04":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList3);
                    break;
                case "dl-05":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList4);
                    break;
                case "dl-06":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList5);
                    break;
                case "dl-07":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList6);
                    break;
                case "dl-08":
                    super.execGetProcessRecord(inBean);
                    getProcessRecordOutBean.setKekkastatus("0");
                    getProcessRecordOutBean.setSyousaimsg("正常終了しました。");
                    getProcessRecordOutBean.setSyousaimsgcd("IWF0000");
                    getProcessRecordOutBean.setProcessRecordBeanList(beanList7);
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
                    if ("05".equals(tmpMode[1])) {
                        if ("02".equals(tmpMode[2])) {
                            response = execGetTaskSummary28(tmpMode[1], inBean);
                        } else {
                            response = execGetTaskSummary280505(inBean);
                        }
                    } else {
                        response = execGetTaskSummary28(tmpMode[1], inBean);
                    }

                    break;

                case "29":
                    if ("04".equals(tmpMode[1])) {
                        if ("03".equals(tmpMode[2])) {
                            response = execGetTaskSummary290403(inBean);
                        } else {
                            response = execGetTaskSummary29(tmpMode[1], inBean);
                        }
                    } else {
                        response = execGetTaskSummary29(tmpMode[1], inBean);
                    }
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
        response.setKekkastatus("9");
        response.setSyousaimsgcd("IWF0003");
        response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2803(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setTaskSummaryBeanList(beanList);
            response.setKekkastatus("1");
            response.setSyousaimsgcd("IWF4020");
            response.setSyousaimsg("警告終了しました。");
        }

        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setTaskSummaryBeanList(beanList);
            response.setKekkastatus("9");
            response.setSyousaimsgcd("IWF0003");
            response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
        }

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2804(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setTaskSummaryBeanList(beanList);
            response.setKekkastatus("1");
            response.setSyousaimsgcd("IWF4020");
            response.setSyousaimsg("警告終了しました。");
        }

        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setTaskSummaryBeanList(beanList);
            response.setKekkastatus("1");
            response.setSyousaimsgcd("IWF4020");
            response.setSyousaimsg("警告終了しました。");
        }

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2805(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if ("0024".equals(inBean.getFlowid()) &&
            BizUtil.isBlank(inBean.getTaskendtimefrom()) &&
            BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("新契約事務１タスク１");
            bean.setTaskCount("10");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("新契約事務1");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("20");
            beanList.add(bean);
        }

        if ("0021".equals(inBean.getFlowid()) &&
            BizUtil.isBlank(inBean.getTaskendtimefrom()) &&
            BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("新契約事務２タスク３");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("年金事務1");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク３");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        if ("0026".equals(inBean.getFlowid()) &&
            !BizUtil.isBlank(inBean.getTaskendtimefrom()) &&
            !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("新契約事務３タスク１");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("新契約事務3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("新契約事務３タスク２");
            bean.setTaskCount("60");
            beanList.add(bean);
            bean = new TaskSummaryBean();
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

            switch (inBean.getFlowid()) {
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

            switch (inBean.getFlowid()) {
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

            switch (inBean.getFlowid()) {
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

            switch (inBean.getFlowid()) {
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

            switch (inBean.getFlowid()) {
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

            switch (inBean.getFlowid()) {
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

        response.setKekkastatus("9");
        response.setSyousaimsgcd("IWF0003");
        response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2902(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");
        beanList.add(bean);
        response.setTaskSummaryBeanList(beanList);
        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2903(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setTaskSummaryBeanList(beanList);
            response.setKekkastatus("9");
            response.setSyousaimsgcd("IWF4020");
            response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
        }

        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setTaskSummaryBeanList(beanList);
            response.setKekkastatus("9");
            response.setSyousaimsgcd("IWF4020");
            response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
        }

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary2904(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

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
            bean = new TaskSummaryBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("90");
            beanList.add(bean);
        }

        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("30");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0023");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
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
                    response = execGetTaskSummaryByActor300100(tmpMode[1], tmpMode[2], inBean);
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

        response.setKekkastatus("9");
        response.setSyousaimsgcd("IWF0003");
        response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3002(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();

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


        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId("");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("UserId01");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("UserId02");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク4");
            bean.setTaskCount("80");
            bean.setUserId("UserId03");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0019");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
            bean.setTaskLocalName("テストタスク5");
            bean.setTaskCount("80");
            bean.setUserId("UserId01");
            beanList.add(bean);
            response.setTaskSummaryByActorBeanList(beanList);

            response.setKekkastatus("0");
            response.setSyousaimsgcd("IWF0000");
            response.setSyousaimsg("正常終了しました。");
            return response;
        }


        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            response.setKekkastatus("9");
            response.setSyousaimsgcd("IWF0003");
            response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
            return response;
        }

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3004(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId("");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("UserId01");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("UserId02");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク4");
            bean.setTaskCount("80");
            bean.setUserId("UserId03");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0019");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
            bean.setTaskLocalName("テストタスク5");
            bean.setTaskCount("80");
            bean.setUserId("UserId01");
            beanList.add(bean);
            response.setTaskSummaryByActorBeanList(beanList);

            response.setKekkastatus("0");
            response.setSyousaimsgcd("IWF0000");
            response.setSyousaimsg("正常終了しました。");
            return response;
        }


        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {
            beanList = new ArrayList<TaskSummaryByActorBean>();
            response.setTaskSummaryByActorBeanList(beanList);
            response.setKekkastatus("0");
            response.setSyousaimsgcd("IWF0000");
            response.setSyousaimsg("正常終了しました。");
            return response;
        }

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor3005(GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();


        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId("");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("UserId01");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("UserId02");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク4");
            bean.setTaskCount("80");
            bean.setUserId("UserId03");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0019");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
            bean.setTaskLocalName("テストタスク5");
            bean.setTaskCount("80");
            bean.setUserId("UserId01");
            beanList.add(bean);
        }


        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("UserId04");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("UserId05");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク4");
            bean.setTaskCount("80");
            bean.setUserId("UserId06");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0019");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
            bean.setTaskLocalName("テストタスク5");
            bean.setTaskCount("80");
            bean.setUserId("UserId04");
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


        if (BizUtil.isBlank(inBean.getTaskendtimefrom()) && BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("UserId01");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("UserId02");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク4");
            bean.setTaskCount("80");
            bean.setUserId("UserId03");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0019");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
            bean.setTaskLocalName("テストタスク5");
            bean.setTaskCount("80");
            bean.setUserId("UserId01");
            beanList.add(bean);
        }


        if (!BizUtil.isBlank(inBean.getTaskendtimefrom()) && !BizUtil.isBlank(inBean.getTaskendtimeto())) {

            bean.setFlowId("0024");
            bean.setFlowName("テストフロー1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("10");
            bean.setUserId("");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0026");
            bean.setFlowName("テストフロー2");
            bean.setTaskName("TaskName222");
            bean.setTaskLocalName("テストタスク2");
            bean.setTaskCount("50");
            bean.setUserId("UserId04");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0021");
            bean.setFlowName("テストフロー3");
            bean.setTaskName("TaskName333");
            bean.setTaskLocalName("テストタスク3");
            bean.setTaskCount("80");
            bean.setUserId("UserId05");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0022");
            bean.setFlowName("テストフロー4");
            bean.setTaskName("TaskName444");
            bean.setTaskLocalName("テストタスク4");
            bean.setTaskCount("80");
            bean.setUserId("UserId06");
            beanList.add(bean);
            bean = new TaskSummaryByActorBean();
            bean.setFlowId("0019");
            bean.setFlowName("テストフロー5");
            bean.setTaskName("TaskName555");
            bean.setTaskLocalName("テストタスク5");
            bean.setTaskCount("80");
            bean.setUserId("UserId04");
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
                case "dl-011":
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

                case "forceprocessforward-01":
                    super.execForceProcessForward(inBean);
                    forceProcessForwardOutBean.setKekkastatus("0");
                    forceProcessForwardOutBean.setSyousaimsg("正常終了しました。");
                    forceProcessForwardOutBean.setSyousaimsgcd("IWF0000");
                    break;
                case "forceprocessforward-02":
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

        ProcessForwardForBatchOutBean processForwardForBatchOutBean = SWAKInjector
            .getInstance(ProcessForwardForBatchOutBean.class);
        ProcessForwardForBatchInBean processForwardForBatchInBean = SWAKInjector
            .getInstance(ProcessForwardForBatchInBean.class);
        if ("Test".equals(caller)) {

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "dl":
                    processForwardForBatchOutBean = execProcessForwardForBatch01(tmpMode[1]);
            }
        }
        return processForwardForBatchOutBean;

    }

    public ProcessForwardForBatchOutBean execProcessForwardForBatch01(String pMode) {
        ProcessForwardForBatchOutBean processForwardForBatchOutBean = SWAKInjector
            .getInstance(ProcessForwardForBatchOutBean.class);
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
    public StartTaskOutBean execStartTask(StartTaskInBean inBean) {
        StartTaskOutBean startTaskOutBean = new StartTaskOutBean();
        if ("Test".equals(caller)) {

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "dl01":
                    super.execStartTask(inBean);
                    startTaskOutBean = getExecStartTask(tmpMode[1]);
                    break;
                default:
                    startTaskOutBean.setKekkastatus("0");
                    break;
            }

            return startTaskOutBean;
        }

        return super.execStartTask(inBean);
    }

    private StartTaskOutBean getExecStartTask(String mode) {
        StartTaskOutBean startTaskOutBean = new StartTaskOutBean();

        switch (mode) {
            case "07":
                startTaskOutBean.setKekkastatus("2");
                startTaskOutBean.setSyousaimsgcd("IWF0003");
                break;
            case "08":
                startTaskOutBean.setKekkastatus("0");
                startTaskOutBean.setSyousaimsgcd("IWF0004");
                break;
            case "09":
                startTaskOutBean.setKekkastatus("1");
                startTaskOutBean.setSyousaimsgcd("IWF0005");
                break;
            case "10":
                startTaskOutBean.setKekkastatus("0");
                startTaskOutBean.setSyousaimsgcd("IWF0006");
                break;
            case "11":
                startTaskOutBean.setKekkastatus("1");
                startTaskOutBean.setSyousaimsgcd("IWF0006");
                break;
            case "12":
                startTaskOutBean.setKekkastatus("1");
                startTaskOutBean.setSyousaimsgcd("IWF0006");
                break;
            case "13":
                startTaskOutBean.setKekkastatus("0");
                break;
            default:
                startTaskOutBean.setKekkastatus("0");
                break;
        }
        return startTaskOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary05(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０１");
                processSummaryBean.setCurrentAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "06":
                getProcessSummaryOutBean.setKekkastatus("0");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０６");
                processSummaryBean.setCurrentAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "07":
                getProcessSummaryOutBean.setKekkastatus("0");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０７");
                processSummaryBean.setCurrentAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "08":
                getProcessSummaryOutBean.setKekkastatus("0");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０８");
                processSummaryBean.setCurrentAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "09":
                getProcessSummaryOutBean.setKekkastatus("0");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０９");
                processSummaryBean.setCurrentAccountId("03804130");
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
                processSummaryBean.setCurrentNodeName("タスク名１０");
                processSummaryBean.setCurrentAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
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
                processSummaryBean.setCurrentAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
        }
        return getProcessSummaryOutBean;
    }

    private GetProcessSummaryOutBean execGetProcessSummary28(String pMode) {
        GetProcessSummaryOutBean getProcessSummaryOutBean = new GetProcessSummaryOutBean();
        ProcessSummaryBean processSummaryBean = new ProcessSummaryBean();
        List<ProcessSummaryBean> beanList = new ArrayList<ProcessSummaryBean>();
        ExtParamBean extParamBean = new ExtParamBean();

        switch (pMode) {
            case "01":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０１");
                processSummaryBean.setCurrentAccountId("03804130");
                processSummaryBean.setPreviousAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "02":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０１");
                processSummaryBean.setCurrentAccountId("03804130");
                processSummaryBean.setPreviousAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "03":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０１");
                processSummaryBean.setCurrentAccountId("03804130");
                processSummaryBean.setPreviousAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "04":
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentNodeName("タスク名０１");
                processSummaryBean.setCurrentAccountId("03804130");
                processSummaryBean.setPreviousAccountId("03804130");
                extParamBean.setExtparam12("SyoNo01");
                extParamBean.setExtparam13("NkSysyNo01");
                processSummaryBean.setExtparamBean(extParamBean);
                beanList.add(processSummaryBean);
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            case "05":
                for (int i = 0; i < 100; i++) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setFlowId("0024");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setCurrentNodeName("タスク名０１");
                    processSummaryBean.setCurrentAccountId("03804130");
                    processSummaryBean.setPreviousAccountId("UserId");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);

                }

                for (int i = 0; i < 1011; i++) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setFlowId("0024");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setCurrentNodeName("タスク名０１");
                    processSummaryBean.setCurrentAccountId("03804130");
                    processSummaryBean.setPreviousAccountId("");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);

                }

                for (int i = 0; i < 500; i++) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setFlowId("0026");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setCurrentNodeName("タスク名０１");
                    processSummaryBean.setCurrentAccountId("03804130");
                    processSummaryBean.setPreviousAccountId("UserId");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                for (int i = 0; i < 5055; i++) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setFlowId("0026");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setCurrentNodeName("タスク名０１");
                    processSummaryBean.setCurrentAccountId("03804130");
                    processSummaryBean.setPreviousAccountId("");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                for (int i = 0; i < 300; i++) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setFlowId("0021");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setCurrentNodeName("タスク名０１");
                    processSummaryBean.setCurrentAccountId("03804130");
                    processSummaryBean.setPreviousAccountId("UserId");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                for (int i = 0; i < 3033; i++) {
                    processSummaryBean = new ProcessSummaryBean();
                    processSummaryBean.setFlowId("0021");
                    processSummaryBean.setGyoumukey("GyoumuKey01");
                    processSummaryBean.setCurrentNodeName("タスク名０１");
                    processSummaryBean.setCurrentAccountId("03804130");
                    processSummaryBean.setPreviousAccountId("");
                    processSummaryBean.setExtparamBean(extParamBean);
                    beanList.add(processSummaryBean);
                }

                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                getProcessSummaryOutBean.setProcessSummaryBeanList(beanList);
                break;
            default:
                getProcessSummaryOutBean.setKekkastatus("0");
                getProcessSummaryOutBean.setSyousaimsgcd("IWF0000");
                getProcessSummaryOutBean.setSyousaimsg("正常終了しました。");
                processSummaryBean.setFlowId("FlowId01");
                processSummaryBean.setGyoumukey("GyoumuKey01");
                processSummaryBean.setCurrentAccountId("03804130");
                processSummaryBean.setPreviousAccountId("03804130");
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
    public GetTaskKensuuOutBean execGetTaskKensuu(GetTaskKensuuInBean inBean) {
        if ("Test".equals(caller)) {

            GetTaskKensuuOutBean getTaskKensuuOutBean = new GetTaskKensuuOutBean();
            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "28":
                    getTaskKensuuOutBean = execGetTaskKensuu28(inBean, tmpMode[1], tmpMode[2]);
                    break;
                case "29":
                    getTaskKensuuOutBean = execGetTaskKensuu29(inBean, tmpMode[1], tmpMode[2]);
                    break;
                default:
                    break;
            }
            return getTaskKensuuOutBean;
        }
        return super.execGetTaskKensuu(inBean);
    }

    private GetTaskKensuuOutBean execGetTaskKensuu28(GetTaskKensuuInBean inBean, String pMode1, String pMode2) {
        GetTaskKensuuOutBean getTaskKensuuOutBean = new GetTaskKensuuOutBean();
        List<TaskSummaryBean> taskSummaryBeanList = Lists.newArrayList();
        switch (pMode1) {
            case "03":
                getTaskKensuuOutBean.setKekkastatus("9");
                getTaskKensuuOutBean.setSyousaimsgcd("IWF0003");
                getTaskKensuuOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                if ("02".equals(pMode2)) {
                    if ("1".equals(inBean.getTaskendumu())) {
                        getTaskKensuuOutBean.setKekkastatus("9");
                        getTaskKensuuOutBean.setSyousaimsgcd("IWF0003");
                        getTaskKensuuOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    }
                    else {
                        TaskSummaryBean bean = new TaskSummaryBean();
                        bean.setFlowId("FlowId01");
                        bean.setFlowName("");
                        taskSummaryBeanList.add(bean);
                        getTaskKensuuOutBean.setKekkastatus("0");
                        getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                        getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                        getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);
                    }
                }
                else if ("05".equals(pMode2)) {
                    if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
                        if ("1".equals(inBean.getTaskendumu())) {
                            if ("0024".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0024");
                                bean.setFlowName("新契約事務１");
                                bean.setTaskName("TaskName111");
                                bean.setTaskCount("10");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0026".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0026");
                                bean.setFlowName("新契約事務２");
                                bean.setTaskName("TaskName222");
                                bean.setTaskCount("50");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0021".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0021");
                                bean.setFlowName("年金事務１");
                                bean.setTaskName("TaskName333");
                                bean.setTaskCount("30");
                                taskSummaryBeanList.add(bean);
                            }
                            getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);
                            getTaskKensuuOutBean.setKekkastatus("0");
                            getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                            getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                        }
                        else {
                            if ("0024".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0024");
                                bean.setFlowName("新契約事務１");
                                bean.setTaskName("TaskName111");
                                bean.setTaskCount("100");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0026".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0026");
                                bean.setFlowName("新契約事務２");
                                bean.setTaskName("TaskName222");
                                bean.setTaskCount("500");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0021".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0021");
                                bean.setFlowName("年金事務１");
                                bean.setTaskName("TaskName333");
                                bean.setTaskCount("300");
                                taskSummaryBeanList.add(bean);
                            }
                        }
                    }
                    else {
                        if ("1".equals(inBean.getTaskendumu())) {
                            if ("0024".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0024");
                                bean.setFlowName("新契約事務１");
                                bean.setTaskName("TaskName111");
                                bean.setTaskCount("111");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0026".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0026");
                                bean.setFlowName("新契約事務２");
                                bean.setTaskName("TaskName222");
                                bean.setTaskCount("555");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0021".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0021");
                                bean.setFlowName("年金事務１");
                                bean.setTaskName("TaskName333");
                                bean.setTaskCount("333");
                                taskSummaryBeanList.add(bean);
                            }
                            getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);
                            getTaskKensuuOutBean.setKekkastatus("0");
                            getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                            getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                        }
                        else {
                            if ("0024".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0024");
                                bean.setFlowName("新契約事務１");
                                bean.setTaskName("TaskName111");
                                bean.setTaskCount("1111");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0026".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0026");
                                bean.setFlowName("新契約事務２");
                                bean.setTaskName("TaskName222");
                                bean.setTaskCount("5555");
                                taskSummaryBeanList.add(bean);
                            }

                            if ("0021".equals(inBean.getFlowid())) {
                                TaskSummaryBean bean = new TaskSummaryBean();
                                bean.setFlowId("0021");
                                bean.setFlowName("年金事務１");
                                bean.setTaskName("TaskName333");
                                bean.setTaskCount("333");
                                taskSummaryBeanList.add(bean);
                            }
                        }
                    }
                    getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);
                    getTaskKensuuOutBean.setKekkastatus("0");
                    getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                    getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                }

                break;
            default:
                break;
        }

        return getTaskKensuuOutBean;
    }

    private GetTaskKensuuOutBean execGetTaskKensuu29(GetTaskKensuuInBean inBean, String pMode1, String pMode2) {
        GetTaskKensuuOutBean getTaskKensuuOutBean = new GetTaskKensuuOutBean();
        List<TaskSummaryBean> taskSummaryBeanList = Lists.newArrayList();
        switch (pMode1) {
            case "02":
                getTaskKensuuOutBean.setKekkastatus("9");
                getTaskKensuuOutBean.setSyousaimsgcd("IWF0003");
                getTaskKensuuOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "04":
                if ("02".equals(pMode2)) {
                    if ("1".equals(inBean.getTaskendumu())) {
                        getTaskKensuuOutBean.setKekkastatus("9");
                        getTaskKensuuOutBean.setSyousaimsgcd("IWF0003");
                        getTaskKensuuOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    }
                    else {
                        getTaskKensuuOutBean.setKekkastatus("0");
                        getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                        getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                        getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);

                    }
                }
                else if ("03".equals(pMode2)) {

                    if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
                        if ("1".equals(inBean.getTaskendumu())) {
                            TaskSummaryBean bean = new TaskSummaryBean();
                            bean.setFlowId("0024");
                            bean.setFlowName("新契約事務１");
                            bean.setTaskName("TaskName111");
                            bean.setTaskCount("10");
                            taskSummaryBeanList.add(bean);
                            bean = new TaskSummaryBean();
                            bean.setFlowId("0026");
                            bean.setFlowName("新契約事務２");
                            bean.setTaskName("TaskName112");
                            bean.setTaskCount("20");
                            taskSummaryBeanList.add(bean);
                            getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);
                            getTaskKensuuOutBean.setKekkastatus("0");
                            getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                            getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                        }
                        else {
                            TaskSummaryBean bean = new TaskSummaryBean();
                            bean.setFlowId("0024");
                            bean.setFlowName("新契約事務１");
                            bean.setTaskName("TaskName111");
                            bean.setTaskCount("100");
                            taskSummaryBeanList.add(bean);

                            bean = new TaskSummaryBean();
                            bean.setFlowId("0026");
                            bean.setFlowName("新契約事務２");
                            bean.setTaskName("TaskName112");
                            bean.setTaskCount("200");
                            taskSummaryBeanList.add(bean);
                        }
                    }
                    getTaskKensuuOutBean.setTaskSummaryBeanList(taskSummaryBeanList);
                    getTaskKensuuOutBean.setKekkastatus("0");
                    getTaskKensuuOutBean.setSyousaimsgcd("IWF0000");
                    getTaskKensuuOutBean.setSyousaimsg("正常終了しました。");
                }
                break;
            default:
                break;
        }

        return getTaskKensuuOutBean;
    }

    private GetTaskSummaryOutBean execGetTaskSummary280505(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
            if ("0024".equals(inBean.getFlowid())) {
                bean.setFlowId("0024");
                bean.setFlowName("新契約事務１");
                bean.setTaskName("TaskName111");
                bean.setTaskLocalName("新契約事務１タスク１");
                bean.setTaskCount("1");
                beanList.add(bean);
            }
            if ("0026".equals(inBean.getFlowid())) {
                bean = new TaskSummaryBean();
                bean.setFlowId("0026");
                bean.setFlowName("新契約事務２");
                bean.setTaskName("TaskName222");
                bean.setTaskLocalName("新契約事務３タスク１");
                bean.setTaskCount("5");
                beanList.add(bean);
            }

            if ("0021".equals(inBean.getFlowid())) {
                bean = new TaskSummaryBean();
                bean.setFlowId("0021");
                bean.setFlowName("年金事務1");
                bean.setTaskName("TaskName333");
                bean.setTaskLocalName("新契約事務２タスク３");
                bean.setTaskCount("3");
                beanList.add(bean);
            }
        }
        else {
            if ("0024".equals(inBean.getFlowid())) {
                bean.setFlowId("0024");
                bean.setFlowName("新契約事務１");
                bean.setTaskName("TaskName111");
                bean.setTaskLocalName("新契約事務１タスク１");
                bean.setTaskCount("11");
                beanList.add(bean);
            }
            if ("0026".equals(inBean.getFlowid())) {
                bean = new TaskSummaryBean();
                bean.setFlowId("0026");
                bean.setFlowName("新契約事務２");
                bean.setTaskName("TaskName222");
                bean.setTaskLocalName("新契約事務３タスク１");
                bean.setTaskCount("55");
                beanList.add(bean);
            }

            if ("0021".equals(inBean.getFlowid())) {
                bean = new TaskSummaryBean();
                bean.setFlowId("0021");
                bean.setFlowName("年金事務1");
                bean.setTaskName("TaskName333");
                bean.setTaskLocalName("新契約事務２タスク３");
                bean.setTaskCount("33");
                beanList.add(bean);
            }
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryOutBean execGetTaskSummary290403(GetTaskSummaryInBean inBean) {
        GetTaskSummaryOutBean response = new GetTaskSummaryOutBean();
        TaskSummaryBean bean = new TaskSummaryBean();
        List<TaskSummaryBean> beanList = new ArrayList<TaskSummaryBean>();

        if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
            bean.setFlowId("0024");
            bean.setFlowName("テストタスク1");
            bean.setTaskName("TaskName111");
            bean.setTaskLocalName("テストタスク1");
            bean.setTaskCount("1");
            beanList.add(bean);
            bean = new TaskSummaryBean();
            bean.setFlowId("0024");
            bean.setFlowName("テストタスク２");
            bean.setTaskName("TaskName112");
            bean.setTaskLocalName("テストタスク２");
            bean.setTaskCount("2");
            beanList.add(bean);
        }

        response.setTaskSummaryBeanList(beanList);
        response.setKekkastatus("0");
        response.setSyousaimsgcd("IWF0000");
        response.setSyousaimsg("正常終了しました。");

        return response;
    }

    private GetTaskSummaryByActorOutBean execGetTaskSummaryByActor300100(String pMode1, String pMode2,
        GetTaskSummaryByActorInBean inBean) {
        GetTaskSummaryByActorOutBean response = new GetTaskSummaryByActorOutBean();
        TaskSummaryByActorBean bean = new TaskSummaryByActorBean();
        List<TaskSummaryByActorBean> beanList = new ArrayList<TaskSummaryByActorBean>();

        switch (pMode1) {
            case "01":
                response.setKekkastatus("9");
                response.setSyousaimsgcd("IWF0003");
                response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                break;
            case "05":
                if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
                    bean.setUserId("");
                    bean.setTaskCount("1");
                    bean.setTaskName("共用");
                    beanList.add(bean);
                    bean = new TaskSummaryByActorBean();
                    bean.setUserId("UserId02");
                    bean.setTaskCount("2");
                    bean.setTaskName("ユーザー名０２");
                    beanList.add(bean);
                    bean = new TaskSummaryByActorBean();
                    bean.setUserId("UserId01");
                    bean.setTaskCount("3");
                    bean.setTaskName("ユーザー名０１");
                    beanList.add(bean);
                }
                else {
                    bean.setUserId("");
                    bean.setTaskCount("10");
                    bean.setTaskName("共用");
                    beanList.add(bean);
                    bean = new TaskSummaryByActorBean();
                    bean.setUserId("UserId01");
                    bean.setTaskCount("30");
                    bean.setTaskName("ユーザー名０１");
                    beanList.add(bean);
                    bean = new TaskSummaryByActorBean();
                    bean.setUserId("UserId02");
                    bean.setTaskCount("20");
                    bean.setTaskName("ユーザー名０２");
                    beanList.add(bean);
                }

                response.setTaskSummaryByActorBeanList(beanList);
                response.setKekkastatus("0");
                response.setSyousaimsgcd("IWF0000");
                response.setSyousaimsg("正常終了しました。");
                break;
            default:
                break;
        }
        return response;
    }

    @Override
    public GetTaskKensuuByActorOutBean execGetTaskKensuuByActor(GetTaskKensuuByActorInBean inBean) {

        GetTaskKensuuByActorOutBean getTaskKensuuByActorOutBean = new GetTaskKensuuByActorOutBean();
        if ("Test".equals(caller)) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "30":
                    getTaskKensuuByActorOutBean = execGetTaskKensuuByActor30(tmpMode[1], tmpMode[2], inBean);
                    break;
                default:
                    break;
            }

        }
        return getTaskKensuuByActorOutBean;
    }

    private GetTaskKensuuByActorOutBean execGetTaskKensuuByActor30(String pMode1, String pMode2,
        GetTaskKensuuByActorInBean inBean) {
        GetTaskKensuuByActorOutBean getTaskKensuuByActorOutBean = new GetTaskKensuuByActorOutBean();
        List<TaskSummaryByActorBean> taskSummaryBeanByActorList = Lists.newArrayList();
        TaskSummaryByActorBean taskSummaryByActorBean = new TaskSummaryByActorBean();
        switch (pMode1) {
            case "05":
                if ("01".equals(pMode2)) {
                    getTaskKensuuByActorOutBean.setKekkastatus("9");
                    getTaskKensuuByActorOutBean.setSyousaimsgcd("IWF0003");
                    getTaskKensuuByActorOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                } else if ("02".equals(pMode2)) {
                    if ("0".equals(inBean.getTaskendumu())) {
                        getTaskKensuuByActorOutBean.setKekkastatus("0");
                        getTaskKensuuByActorOutBean.setSyousaimsgcd("IWF0000");
                        getTaskKensuuByActorOutBean.setSyousaimsg("正常終了しました。");
                    }
                    else {
                        getTaskKensuuByActorOutBean.setKekkastatus("9");
                        getTaskKensuuByActorOutBean.setSyousaimsgcd("IWF0003");
                        getTaskKensuuByActorOutBean.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    }
                } else {
                    if ("0".equals(inBean.getTaskendumu())) {
                        if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("");
                            taskSummaryByActorBean.setFlowName("共用");
                            taskSummaryByActorBean.setTaskCount("100");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId02");
                            taskSummaryByActorBean.setFlowName("ユーザー名０２");
                            taskSummaryByActorBean.setTaskCount("200");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId01");
                            taskSummaryByActorBean.setFlowName("ユーザー名０１");
                            taskSummaryByActorBean.setTaskCount("300");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                        }
                        else {
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("");
                            taskSummaryByActorBean.setFlowName("共用");
                            taskSummaryByActorBean.setTaskCount("1000");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId01");
                            taskSummaryByActorBean.setFlowName("ユーザー名０１");
                            taskSummaryByActorBean.setTaskCount("3000");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId02");
                            taskSummaryByActorBean.setFlowName("ユーザー名０２");
                            taskSummaryByActorBean.setTaskCount("2000");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                        }
                    }
                    else {
                        if (!Strings.isNullOrEmpty(inBean.getAccountid())) {
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("");
                            taskSummaryByActorBean.setFlowName("共用");
                            taskSummaryByActorBean.setTaskCount("10");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId02");
                            taskSummaryByActorBean.setFlowName("ユーザー名０２");
                            taskSummaryByActorBean.setTaskCount("20");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId01");
                            taskSummaryByActorBean.setFlowName("ユーザー名０１");
                            taskSummaryByActorBean.setTaskCount("30");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                        }
                        else {
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("");
                            taskSummaryByActorBean.setFlowName("共用");
                            taskSummaryByActorBean.setTaskCount("100");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId01");
                            taskSummaryByActorBean.setFlowName("ユーザー名０１");
                            taskSummaryByActorBean.setTaskCount("300");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                            taskSummaryByActorBean = new TaskSummaryByActorBean();
                            taskSummaryByActorBean.setUserId("UserId02");
                            taskSummaryByActorBean.setFlowName("ユーザー名０２");
                            taskSummaryByActorBean.setTaskCount("200");
                            taskSummaryBeanByActorList.add(taskSummaryByActorBean);
                        }
                    }

                    getTaskKensuuByActorOutBean.setTaskSummaryByActorBeanList(taskSummaryBeanByActorList);
                    getTaskKensuuByActorOutBean.setKekkastatus("0");
                    getTaskKensuuByActorOutBean.setSyousaimsgcd("IWF0000");
                    getTaskKensuuByActorOutBean.setSyousaimsg("正常終了しました。");
                }
                break;
            default:
                break;
        }

        return getTaskKensuuByActorOutBean;
    }

    @Override
    public ContinueLockProcessOutBean execContinueLockProcess(ContinueLockProcessInBean inBean) {

        if ("Test".equals(caller)) {
            ContinueLockProcessOutBean continueLockProcessOutBean = new ContinueLockProcessOutBean();
            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "dl11":
                    continueLockProcessOutBean = execContinueLockProcessDL(inBean,tmpMode[1]);

                    break;
                default:
                    break;
            }

            return continueLockProcessOutBean;
        }

        return null;
    }

    private ContinueLockProcessOutBean execContinueLockProcessDL(ContinueLockProcessInBean pInBean,String pMode) {
        ContinueLockProcessOutBean continueLockProcessOutBean = new ContinueLockProcessOutBean();
        switch (pMode) {
            case "01":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                break;
            case "02":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF2093.toString());
                break;
            case "03":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF2091.toString());
                break;
            case "04":
                if ("10000000001".equals(pInBean.getGyoumukey())) {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                }
                else if ("hijklmn2".equals(pInBean.getGyoumukey())) {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                    continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF2092.toString());
                }else {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                }
                break;
            case "05":
                if ("10000000001".equals(pInBean.getGyoumukey())) {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                }
                else if ("hijklmn2".equals(pInBean.getGyoumukey())) {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                    continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF4031.toString());
                }else {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                }
                break;
            case "06":
                if ("10000000001".equals(pInBean.getGyoumukey())) {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                }
                else if ("hijklmn2".equals(pInBean.getGyoumukey())) {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                    continueLockProcessOutBean.setSyousaimsgcd("IWF2094");
                }else {
                    continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                }
                break;
            case "07":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.OK.getValue());
                break;
            case "08":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF2091.toString());
                break;
            case "09":

                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF2092.toString());
                break;
            case "10":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                continueLockProcessOutBean.setSyousaimsgcd(IwfMessageCd.IWF4031.toString());
                break;
            case "11":
                continueLockProcessOutBean.setKekkastatus(C_ResultCdKbn.WARN.getValue());
                continueLockProcessOutBean.setSyousaimsgcd("IWF2094");
                break;
            default:
                break;
        }
        return continueLockProcessOutBean;
    }
}