package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * イメージプロパティBean の処理結果クラスです。<br />
 */
public class ImagePropsBean implements Serializable {

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

    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String pImageId) {
        imageId = pImageId;
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

    private String torikomiSyoruiCd;

    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    private String dispTorikomiSyoruiNm;

    public String getDispTorikomiSyoruiNm() {
        return dispTorikomiSyoruiNm;
    }

    public void setDispTorikomiSyoruiNm(String pDispTorikomiSyoruiNm) {
        dispTorikomiSyoruiNm = pDispTorikomiSyoruiNm;
    }

    private String syoruiTtykYmdTime;

    public String getSyoruiTtykYmdTime() {
        return syoruiTtykYmdTime;
    }

    public void setSyoruiTtykYmdTime(String pSyoruiTtykYmdTime) {
        syoruiTtykYmdTime = pSyoruiTtykYmdTime;
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

    private String kengenUmu;

    public String getKengenUmu() {
        return kengenUmu;
    }

    public void setKengenUmu(String pKengenUmu) {
        kengenUmu = pKengenUmu;
    }

    private String tourokuUserNm;

    public String getTourokuUserNm() {
        return tourokuUserNm;
    }

    public void setTourokuUserNm(String pTourokuUserNm) {
        tourokuUserNm = pTourokuUserNm;
    }

    private String syoruiTorikomiHouKbn;

    public String getSyoruiTorikomiHouKbn() {
        return syoruiTorikomiHouKbn;
    }

    public void setSyoruiTorikomiHouKbn(String pSyoruiTorikomiHouKbn) {
        syoruiTorikomiHouKbn = pSyoruiTorikomiHouKbn;
    }
}
