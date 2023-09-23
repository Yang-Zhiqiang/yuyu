package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_SeikyuuSyubetu;
/**
 * 保険金給付金支払 保険金給付金支払帳票編集 確認依頼書編集Bean
 */
public class EditKakuniniraisyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private String syoNo;

    private BizDate kykYmd;

    private BizDate sibouYmd;

    private BizDate syoruiukeYmd;

    private BizDate sikkouYmd;

    private BizDate hksknnkaisiYmd;

    private BizDate lastmeihenYmd;

    private String hhknNmkn;

    private String hhknNmkj;

    private String kykNmkn;

    private String kyknmkj;

    private BizCurrency hokenknGk;

    private BizCurrency saigais;

    private String hyojitelNo;

    public EditKakuniniraisyoBean() {
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

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyono(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public BizDate getSibouYmd() {
        return sibouYmd;
    }

    public void setSibouYmd(BizDate pSibouYmd) {
        sibouYmd = pSibouYmd;
    }

    public BizDate getSyoruiukeYmd() {
        return syoruiukeYmd;
    }

    public void setSyoruiukeYmd(BizDate pSyoruiukeYmd) {
        syoruiukeYmd = pSyoruiukeYmd;
    }

    public BizDate getSikkouYmd() {
        return sikkouYmd;
    }

    public void setSikkouYmd(BizDate pSikkouYmd) {
        sikkouYmd = pSikkouYmd;
    }

    public BizDate getHksknnkaisiYmd() {
        return hksknnkaisiYmd;
    }

    public void setHksknnkaisiYmd(BizDate pHksknnkaisiYmd) {
        hksknnkaisiYmd = pHksknnkaisiYmd;
    }

    public BizDate getLastmeihenYmd() {
        return lastmeihenYmd;
    }

    public void setLastmeihenYmd(BizDate pLastmeihenYmd) {
        lastmeihenYmd = pLastmeihenYmd;
    }

    public String getHhknNmkn() {
        return hhknNmkn;
    }

    public void setHhknNmkn(String pHhknNmkn) {
        hhknNmkn = pHhknNmkn;
    }

    public String getHhknNmkj() {
        return hhknNmkj;
    }

    public void setHhknNmkj(String pHhknNmkj) {
        hhknNmkj = pHhknNmkj;
    }

    public String getKykNmkn() {
        return kykNmkn;
    }

    public void setKyknmkn(String pKykNmkn) {
        kykNmkn = pKykNmkn;
    }

    public String getKyknmkj() {
        return kyknmkj;
    }

    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    public BizCurrency getHokenknGk() {
        return hokenknGk;
    }

    public void setHokenknGk(BizCurrency pHokenknGk) {
        hokenknGk = pHokenknGk;
    }

    public BizCurrency getSaigais() {
        return saigais;
    }

    public void setSaigais(BizCurrency pSaigais) {
        saigais = pSaigais;
    }

    public String getHyojitelNo() {
        return hyojitelNo;
    }

    public void setHyojitelno(String pHyojitelNo) {
        hyojitelNo = pHyojitelNo;
    }
}
