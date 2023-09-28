package yuyu.common.biz.workflow.io.image.sub;

import java.io.Serializable;

/**
 * 到着予定書類の通知情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class ArrivalNoticeBean implements Serializable {

    private String arriveKey_;

    private String gyoumuKey_;

    private String flowId_;

    private String torikomisyoruiCd_;

    private String subsystemId_;


    public String getArriveKey() {
        return arriveKey_;
    }

    public void setArriveKey(String pArriveKey) {
        arriveKey_ = pArriveKey;
    }

    public String getGyoumuKey() {
        return gyoumuKey_;
    }

    public void setGyoumuKey(String pGyoumukey) {
        gyoumuKey_ = pGyoumukey;
    }

    public String getFlowId() {
        return flowId_;
    }

    public void setFlowId(String pFlowId) {
        flowId_ = pFlowId;
    }

    public String getTorikomisyoruiCd() {
        return torikomisyoruiCd_;
    }

    public void setTorikomisyoruiCd(String pTorikomisyoruiCd) {
        torikomisyoruiCd_ = pTorikomisyoruiCd;
    }

    public String getSubsystemId() {
        return subsystemId_;
    }

    public void setSubsystemId(String pSubsystemId) {
        subsystemId_ = pSubsystemId;
    }
}
