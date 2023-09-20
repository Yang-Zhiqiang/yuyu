package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * タスク担当者一覧Bean の処理結果クラスです。<br />
 */
public class TaskTantoInfoBean implements Serializable {

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

    private String nowSyoriTantouId;

    public String getNowSyoriTantouId() {
        return nowSyoriTantouId;
    }

    public void setNowSyoriTantouId(String pNowSyoriTantouId) {
        nowSyoriTantouId = pNowSyoriTantouId;
    }

    private String dispNowSyoriTantouNm;

    public String getDispNowSyoriTantouNm() {
        return dispNowSyoriTantouNm;
    }

    public void setDispNowSyoriTantouNm(String pDispNowSyoriTantouNm) {
        dispNowSyoriTantouNm = pDispNowSyoriTantouNm;
    }

    private String nowTaskNm;

    public String getNowTaskNm() {
        return nowTaskNm;
    }

    public void setNowTaskNm(String pNowTaskNm) {
        nowTaskNm = pNowTaskNm;
    }

    private String jimutetuzukiCd;

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    private String taskNm;

    public String getTaskNm() {
        return taskNm;
    }

    public void setTaskNm(String pTaskNm) {
        taskNm = pTaskNm;
    }

}
