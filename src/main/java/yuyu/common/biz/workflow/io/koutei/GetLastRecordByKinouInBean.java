package yuyu.common.biz.workflow.io.koutei;

import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiRequest;

/**
 * 前回処理結果取得（機能指定）サービスの入力Bean
 */
@SuppressWarnings("serial")
public class GetLastRecordByKinouInBean extends WSGetKouteiRirekiSyousaiRequest {

    private String gyoumuKey_ = null;
    private String kinouId_= null;
    private String kinouSSId_ = null;

    public String getGyoumuKey() {
        return gyoumuKey_;
    }

    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey_ = pGyoumuKey;
    }

    public String getKinouId() {
        return kinouId_;
    }

    public void setKinouId(String pKinouId) {
        this.kinouId_ = pKinouId;
    }

    public String getKinouSSId() {
        return kinouSSId_;
    }

    public void setKinouSSId(String pKinouSSId) {
        this.kinouSSId_ = pKinouSSId;
    }

}
