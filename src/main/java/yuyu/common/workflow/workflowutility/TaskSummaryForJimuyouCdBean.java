package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 事務用コード入力工程サマリBean の処理結果共通クラスです。<br />
 */
public class TaskSummaryForJimuyouCdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosNo;

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    private String syoNo;

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    private String nkSysyNo;

    public String getNkSysyNo() {
        return nkSysyNo;
    }

    public void setNkSysyNo(String pNkSysyNo) {
        nkSysyNo = pNkSysyNo;
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        kouteiKnrId = pKouteiKnrId;
    }

    private String kouteiStatus;

    public String getKouteiStatus() {
        return kouteiStatus;
    }

    public void setKouteiStatus(String pKouteiStatus) {
        kouteiStatus = pKouteiStatus;
    }

    private String dispKouteiStatus;

    public String getDispKouteiStatus() {
        return dispKouteiStatus;
    }

    public void setDispKouteiStatus(String pDispKouteiStatus) {
        dispKouteiStatus = pDispKouteiStatus;
    }

    private String jimuyouCd;

    public String getJimuyouCd() {
        return jimuyouCd;
    }

    public void setJimuyouCd(String pJimuyouCd) {
        jimuyouCd = pJimuyouCd;
    }
}
