package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 取込用表紙作成対象工程サマリBean の処理結果共通クラスです。<br />
 */
public class TaskSummaryForHyousiBean implements Serializable {

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

    private String jimuStartYmd;

    public String getJimuStartYmd() {
        return jimuStartYmd;
    }

    public void setJimuStartYmd(String pJimuStartYmd) {
        jimuStartYmd = pJimuStartYmd;
    }

    private String kouteiKaisiYmd;

    public String getKouteiKaisiYmd() {
        return kouteiKaisiYmd;
    }

    public void setKouteiKaisiYmd(String pKouteiKaisiYmd) {
        kouteiKaisiYmd = pKouteiKaisiYmd;
    }

    private String kouteiKanryouYmd;

    public String getKouteiKanryouYmd() {
        return kouteiKanryouYmd;
    }

    public void setKouteiKanryouYmd(String pKouteiKanryouYmd) {
        kouteiKanryouYmd = pKouteiKanryouYmd;
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

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String jimutetuzukiNm;

    public String getJimutetuzukiNm() {
        return jimutetuzukiNm;
    }

    public void setJimutetuzukiNm(String pJimutetuzukiNm) {
        jimutetuzukiNm = pJimutetuzukiNm;
    }
}
