package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.biz.workflow.io.koutei.sub.ProcessSummaryBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.WSGetKouteiRirekiSummaryResponse;

/**
 * 工程サマリ取得サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetProcessSummaryOutBean extends WSGetKouteiRirekiSummaryResponse {

    private List<ProcessSummaryBean> oProcessSummaryBeanList_;

    public List<ProcessSummaryBean> getProcessSummaryBeanList() {
        return oProcessSummaryBeanList_;
    }

    public void setProcessSummaryBeanList(List<ProcessSummaryBean> poProcessSummaryBeanList) {
        oProcessSummaryBeanList_ = poProcessSummaryBeanList;
    }

    @Override
    @Deprecated
    public  Map<String, String>[] getRirekimaps() {
        return null;
    }
}
