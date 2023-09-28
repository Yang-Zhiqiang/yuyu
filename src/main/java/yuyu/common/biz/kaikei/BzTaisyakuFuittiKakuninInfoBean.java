package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DensysKbn;

/**
 * 貸借不一致確認用情報Beanクラスです。<br />
 */
public class BzTaisyakuFuittiKakuninInfoBean {

    private C_DensysKbn densysKbn;

    private String denrenNo;

    private BizCurrency kariGoukeiKagk;

    private BizCurrency kariMaxKagk;

    private Integer kariMaxKagkEdano;

    private BizCurrency kasiGoukeiKagk;

    private BizCurrency kasiMaxKagk;

    private Integer kasiMaxKagkEdano;

    private Boolean kariTyouseiFlg;

    private Boolean kasiTyouseiFlg;

    private String syono;

    public C_DensysKbn getDensysKbn() {
        return densysKbn;
    }

    public void setDensysKbn(C_DensysKbn pDensysKbn) {
        densysKbn = pDensysKbn;
    }

    public String getDenrenNo() {
        return denrenNo;
    }

    public void setDenrenNo(String pDenrenNo) {
        denrenNo = pDenrenNo;
    }

    public BizCurrency getKariGoukeiKagk() {
        return kariGoukeiKagk;
    }

    public void setKariGoukeiKagk(BizCurrency pKariGoukeiKagk) {
        kariGoukeiKagk = pKariGoukeiKagk;
    }

    public BizCurrency getKariMaxKagk() {
        return kariMaxKagk;
    }

    public void setKariMaxKagk(BizCurrency pKariMaxKagk) {
        kariMaxKagk = pKariMaxKagk;
    }

    public Integer getKariMaxKagkEdano() {
        return kariMaxKagkEdano;
    }

    public void setKariMaxKagkEdano(Integer pKariMaxKagkEdano) {
        kariMaxKagkEdano = pKariMaxKagkEdano;
    }

    public BizCurrency getKasiGoukeiKagk() {
        return kasiGoukeiKagk;
    }

    public void setKasiGoukeiKagk(BizCurrency pKasiGoukeiKagk) {
        kasiGoukeiKagk = pKasiGoukeiKagk;
    }

    public BizCurrency getKasiMaxKagk() {
        return kasiMaxKagk;
    }

    public void setKasiMaxKagk(BizCurrency pKasiMaxKagk) {
        kasiMaxKagk = pKasiMaxKagk;
    }

    public Integer getKasiMaxKagkEdano() {
        return kasiMaxKagkEdano;
    }

    public void setKasiMaxKagkEdano(Integer pKasiMaxKagkEdano) {
        kasiMaxKagkEdano = pKasiMaxKagkEdano;
    }

    public Boolean getKariTyouseiFlg() {
        return kariTyouseiFlg;
    }

    public void setKariTyouseiFlg(Boolean pKariTyouseiFlg) {
        kariTyouseiFlg = pKariTyouseiFlg;
    }

    public Boolean getKasiTyouseiFlg() {
        return kasiTyouseiFlg;
    }

    public void setKasiTyouseiFlg(Boolean pKasiTyouseiFlg) {
        kasiTyouseiFlg = pKasiTyouseiFlg;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}
