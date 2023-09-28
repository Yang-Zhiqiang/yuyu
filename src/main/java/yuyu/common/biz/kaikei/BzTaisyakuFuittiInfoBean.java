package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DensysKbn;

/**
 * 貸借不一致情報Beanクラスです。<br />
 */
public class BzTaisyakuFuittiInfoBean {

    private C_DensysKbn densysKbn;

    private String denrenNo;

    private Integer edaNo;

    private BizCurrency kagk;

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

    public Integer getEdaNo() {
        return edaNo;
    }

    public void setEdaNo(Integer pEdaNo) {
        edaNo = pEdaNo;
    }

    public BizCurrency getKagk() {
        return kagk;
    }

    public void setKagk(BizCurrency pKagk) {
        kagk = pKagk;
    }
}
