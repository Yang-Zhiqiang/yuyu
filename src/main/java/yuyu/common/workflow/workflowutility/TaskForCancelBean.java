package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * 取消対象工程Bean の処理結果共通クラスです。<br />
 */
public class TaskForCancelBean implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private String tantouId;

    public String getTantouId() {
        return tantouId;
    }

    public void setTantouId(String pTantouId) {
        tantouId = pTantouId;
    }

    private String dispTantouNm;

    public String getDispTantouNm() {
        return dispTantouNm;
    }

    public void setDispTantouNm(String pDispTantouNm) {
        dispTantouNm = pDispTantouNm;
    }
}
