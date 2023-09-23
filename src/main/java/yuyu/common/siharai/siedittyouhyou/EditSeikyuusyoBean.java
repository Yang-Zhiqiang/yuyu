package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 請求書編集Bean
 */
public class EditSeikyuusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private String syono;

    private C_SeikyuuSyubetu seikyuusyubetu;

    private C_UktKbn uktKbn;

    private String toritsugisyakjncd;

    private String toritsugisyaKjnmei;

    private String toritsugisyaSosikimei;

    private C_Tuukasyu tuukasyu;

    public EditSeikyuusyoBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public SeikyuusyaInfoBean getSeikyuusyaInfoBean() {
        return seikyuusyaInfoBean;
    }

    public void setSeikyuusyaInfoBean(SeikyuusyaInfoBean pSeikyuusyaInfoBean) {
        seikyuusyaInfoBean = pSeikyuusyaInfoBean;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    public C_UktKbn getUktKbn() {
        return uktKbn;
    }

    public void setUktKbn(C_UktKbn pUktKbn) {
        uktKbn = pUktKbn;
    }

    public String getToritsugisyakjncd() {
        return toritsugisyakjncd;
    }

    public void setToritsugisyakjncd(String pToritsugisyakjncd) {
        toritsugisyakjncd = pToritsugisyakjncd;
    }

    public String getToritsugisyaKjnmei() {
        return toritsugisyaKjnmei;
    }

    public void setToritsugisyaKjnmei(String pToritsugisyaKjnmei) {
        toritsugisyaKjnmei = pToritsugisyaKjnmei;
    }

    public String getToritsugisyaSosikimei() {
        return toritsugisyaSosikimei;
    }

    public void setToritsugisyaSosikimei(String pToritsugisyaSosikimei) {
        toritsugisyaSosikimei = pToritsugisyaSosikimei;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
}
