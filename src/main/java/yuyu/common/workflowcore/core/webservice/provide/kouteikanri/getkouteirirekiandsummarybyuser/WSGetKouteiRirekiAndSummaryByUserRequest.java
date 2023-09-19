package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser;

import java.util.List;

import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * ユーザー別工程履歴取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetKouteiRirekiAndSummaryByUserRequest extends WSCommonRequest {
    public static final String sSERVICE_NAME= "GetKouteiRirekiAndSummaryByUser";

    private String userId;

    private List<String> listFlowId;

    private String syoriTimeFrom;

    private String syoriTimeTo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    public List<String> getListFlowId() {
        return listFlowId;
    }

    public void setListFlowid(List<String> pListFlowId) {
        listFlowId = pListFlowId;
    }

    public String getSyoriTimeFrom() {
        return syoriTimeFrom;
    }

    public void setSyoriTimeFrom(String pSyoriTimeFrom) {
        syoriTimeFrom = pSyoriTimeFrom;
    }

    public String getSyoriTimeTo() {
        return syoriTimeTo;
    }

    public void setSyoriTimeTo(String pSyoriTimeTo) {
        syoriTimeTo = pSyoriTimeTo;
    }
}