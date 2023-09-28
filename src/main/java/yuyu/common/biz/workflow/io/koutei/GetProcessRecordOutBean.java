package yuyu.common.biz.workflow.io.koutei;

import java.util.List;
import java.util.Map;

import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiResponse;

/**
 * 工程履歴取得サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetProcessRecordOutBean extends WSGetKouteiRirekiSyousaiResponse {

    private List<ProcessRecordBean> oProcessSummaryBeanList_ = null;


    public List<ProcessRecordBean> getProcessRecordBeanList() {
        return oProcessSummaryBeanList_;
    }

    public void setProcessRecordBeanList(List<ProcessRecordBean> pProcessRecordBeanList) {
        oProcessSummaryBeanList_ = pProcessRecordBeanList;
    }

    @Override
    @Deprecated
    public  Map<String, String>[] getRirekimaps() {
        return null;
    }
}
