package yuyu.common.workflow.workflowutility;

import java.io.Serializable;

/**
 * イメージ情報Bean の処理結果クラスです。<br />
 */
public class ImageInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imageId;

    public String getImageid() {
        return imageId;
    }

    public void setImageid(String pImageid) {
        imageId = pImageid;
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

    public String getTorikomisyoruicd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomisyoruicd(String pTorikomisyoruicd) {
        torikomiSyoruiCd = pTorikomisyoruicd;
    }

    private String syoruiTtykYmdTime;

    public String getSyoruittykymdtime() {
        return syoruiTtykYmdTime;
    }

    public void setSyoruittykymdtime(String pSyoruittykymdtime) {
        syoruiTtykYmdTime = pSyoruittykymdtime;
    }

    private String kouteiStatus;

    public String getKouteistatus() {
        return kouteiStatus;
    }

    public void setKouteistatus(String pKouteistatus) {
        kouteiStatus = pKouteistatus;
    }

    private String kengenUmu;

    public String getKengenumu() {
        return kengenUmu;
    }

    public void setKengenumu(String pKengenumu) {
        kengenUmu = pKengenumu;
    }

    private byte[] pdfImage;

    public byte[] getPdfImage() {
        return pdfImage;
    }

    public void setPdfImage(byte[] pPdfImage) {
        pdfImage = pPdfImage;
    }
}
