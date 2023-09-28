package yuyu.common.biz.bznayose;

import java.io.Serializable;

import yuyu.def.classification.C_Huho2kyknoKbn;

/**
 * 業務共通 名寄せ 要求通番発番Bean
 */
public class BzYoukyuuNoKanriBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_Huho2kyknoKbn huho2KykNoKbn;

    private String huho2KykNo;

    private String youkyuuNo;

    public C_Huho2kyknoKbn getHuho2KykNoKbn() {
        return huho2KykNoKbn;
    }

    public void setHuho2KykNoKbn(C_Huho2kyknoKbn pHuho2KykNoKbn) {
        huho2KykNoKbn = pHuho2KykNoKbn;
    }

    public String getHuho2KykNo() {
        return huho2KykNo;
    }

    public void setHuho2KykNo(String pHuho2KykNo) {
        huho2KykNo = pHuho2KykNo;
    }

    public String getYoukyuuNo() {
        return youkyuuNo;
    }

    public void setYoukyuuNo(String pYoukyuuNo) {
        youkyuuNo = pYoukyuuNo;
    }

}
