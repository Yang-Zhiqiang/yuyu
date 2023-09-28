package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.io.Serializable;


/**
 * 【書類情報一覧】イメージ情報Bean の処理結果クラスです。<br />
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

    private String kouteikanriid;

    public String getSyoNo() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
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
