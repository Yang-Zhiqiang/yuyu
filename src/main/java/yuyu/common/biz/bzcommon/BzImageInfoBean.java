package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 業務共通 共通 業務共通イメージ情報Beanクラス
 */
public class BzImageInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imageId;

    private String mosno;

    private String syono;

    private String nksysyno;

    private String torikomiSyoruiCd;

    private String syoruiTtykYmdTime;

    private String kengenUmu;

    private byte[] pdfImage;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String pImageId) {
        imageId = pImageId;
    }

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getNksysyno() {
        return nksysyno;
    }

    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    public String getSyoruiTtykYmdTime() {
        return syoruiTtykYmdTime;
    }

    public void setSyoruiTtykYmdTime(String pSyoruiTtykYmdTime) {
        syoruiTtykYmdTime = pSyoruiTtykYmdTime;
    }

    public String getKengenUmu() {
        return kengenUmu;
    }

    public void setKengenUmu(String pKengenUmu) {
        kengenUmu = pKengenUmu;
    }

    public byte[] getPdfImage() {
        return pdfImage;
    }

    public void setPdfImage(byte[] pPdfImage) {
        pdfImage = pPdfImage;
    }
}