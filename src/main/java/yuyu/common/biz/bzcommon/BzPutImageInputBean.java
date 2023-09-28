package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 業務共通 共通 業務共通イメージ登録入力Bean
 */
public class BzPutImageInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCd;

    private String userId;

    private byte[] imageDatas;

    private String kouteiKanriId;

    private String syoruiTtykYmdTime;

    private String tourokuYmdTime;

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        this.syoruiCd = pSyoruiCd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        this.userId = pUserId;
    }

    public byte[] getImageDatas() {
        return imageDatas;
    }

    public void setImageDatas(byte[] pImageDatas) {
        this.imageDatas = pImageDatas;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        this.kouteiKanriId = pKouteiKanriId;
    }

    public String getSyoruiTtykYmdTime() {
        return syoruiTtykYmdTime;
    }

    public void setSyoruiTtykYmdTime(String pSyoruiTtykYmdTime) {
        this.syoruiTtykYmdTime = pSyoruiTtykYmdTime;
    }

    public String getTourokuYmdTime() {
        return tourokuYmdTime;
    }

    public void setTourokuYmdTime(String pTourokuYmdTime) {
        this.tourokuYmdTime = pTourokuYmdTime;
    }
}
