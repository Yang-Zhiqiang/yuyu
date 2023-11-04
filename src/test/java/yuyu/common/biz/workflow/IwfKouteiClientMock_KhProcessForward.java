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
public class IwfKouteiClientMock_KhProcessForward extends IwfKouteiClient {
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

            String tmpMode[] = mode.split("-");

            switch (tmpMode[0]) {
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
}