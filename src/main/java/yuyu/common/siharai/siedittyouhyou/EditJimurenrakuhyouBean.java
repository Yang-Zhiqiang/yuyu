package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 事務連絡票編集Bean
 */
public class EditJimurenrakuhyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String messageKey;

    private String syono;

    private String kinouNm;

    private String skeitantCd;

    private String tntNm;

    public EditJimurenrakuhyouBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String pMessageKey) {
        messageKey = pMessageKey;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getKinouNm() {
        return kinouNm;
    }

    public void setKinouNm(String pKinouNm) {
        kinouNm = pKinouNm;
    }

    public String getSkeitantCd() {
        return skeitantCd;
    }

    public void setSkeitantCd(String pSkeitantCd) {
        skeitantCd = pSkeitantCd;
    }

    public String getTntNm() {
        return tntNm;
    }

    public void setTntNm(String pTntNm) {
        tntNm = pTntNm;
    }
}
