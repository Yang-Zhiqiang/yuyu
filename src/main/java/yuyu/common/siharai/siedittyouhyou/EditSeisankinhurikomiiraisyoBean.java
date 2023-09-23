package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Tuukasyu;
/**
 * 保険金給付金支払 保険金給付金支払帳票編集 精算金振込依頼書編集Bean
 */
public class EditSeisankinhurikomiiraisyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private String uktnmkj;

    private String syono;

    private String hhknNmkj;

    private BizDate kykYmd;

    private BizDate sknnkaisiYmd;

    private C_KyksyaSibouUmuKbn kyksyasibouumukbn;

    private String toritsugisyakjncd;

    private String toritsugisyaKjnmei;

    private String toritsugisyaSosikimei;

    private C_Tuukasyu kyktuukasyu;

    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    private String syouhnCd;

    public EditSeisankinhurikomiiraisyoBean() {
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

    public String getUktnmkj() {
        return uktnmkj;
    }

    public void setUktnmkj(String pUktnmkj) {
        uktnmkj = pUktnmkj;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getHhknNmkj() {
        return hhknNmkj;
    }

    public void setHhknNmkj(String pHhknNmkj) {
        hhknNmkj = pHhknNmkj;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public BizDate getSknnkaisiYmd() {
        return sknnkaisiYmd;
    }

    public void setSknnkaisiYmd(BizDate pSknnkaisiYmd) {
        sknnkaisiYmd = pSknnkaisiYmd;
    }

    public C_KyksyaSibouUmuKbn getKyksyasibouumukbn() {
        return kyksyasibouumukbn;
    }

    public void setKyksyasibouumukbn(C_KyksyaSibouUmuKbn pKyksyasibouumukbn) {
        kyksyasibouumukbn = pKyksyasibouumukbn;
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

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruikbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruikbn) {
        hokenkinsyuruikbn = pHokenkinsyuruikbn;
    }

    public String getSyouhncd() {
        return syouhnCd;
    }

    public void setSyouhncd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
    }
}
