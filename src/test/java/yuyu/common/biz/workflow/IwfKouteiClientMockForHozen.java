package yuyu.common.biz.workflow;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.ExtParamBean;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;

/**
 * {@link IwfKouteiClient}のモッククラスです。<br />
 */
public class IwfKouteiClientMockForHozen extends IwfKouteiClient {

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

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
                case "21":
                    getProcessSummaryOutBean = execGetProcessSummary21(tmpMode[1]);
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
        return super.execGetProcessSummary(inBean);
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

}
