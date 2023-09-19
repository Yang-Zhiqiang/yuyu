package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser;

import java.util.List;
import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordAndSummaryByUserBean;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * ユーザー別工程履歴取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetKouteiRirekiAndSummaryByUserResponse extends WSCommonResponse {
    private List<ProcessRecordAndSummaryByUserBean> listKouteirirekiAndSummaryBean;

    public WSGetKouteiRirekiAndSummaryByUserResponse() {
    }

    public List<ProcessRecordAndSummaryByUserBean> getKouteiRirekiAndSummary() {
        return listKouteirirekiAndSummaryBean;
    }

    public void setKouteiRirekiAndSummary(List<ProcessRecordAndSummaryByUserBean> pListKouteirirekiAndSummaryBean) {
        listKouteirirekiAndSummaryBean = pListKouteirirekiAndSummaryBean;
    }
}
