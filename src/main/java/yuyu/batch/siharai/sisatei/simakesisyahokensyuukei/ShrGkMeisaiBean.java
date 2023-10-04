package yuyu.batch.siharai.sisatei.simakesisyahokensyuukei;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HokenkinsyuruiKbn;

/**
 * 支払金額明細Beanクラスです。<br />
 */
public class ShrGkMeisaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HokenkinsyuruiKbn hokenkinSyuruiKbn;

    private BizCurrency shrGk;

    private BizCurrency yenshrGk;

    private String kyuuhuCd;

    public ShrGkMeisaiBean() {
        super();
    }

    public C_HokenkinsyuruiKbn getHokenkinSyuruiKbn() {
        return hokenkinSyuruiKbn;
    }

    public void setHokenkinSyuruiKbn(C_HokenkinsyuruiKbn pHokenkinSyuruiKbn) {
        hokenkinSyuruiKbn = pHokenkinSyuruiKbn;
    }

    public BizCurrency getShrGk() {
        return shrGk;
    }

    public void setShrGk(BizCurrency pShrGk) {
        shrGk = pShrGk;
    }

    public BizCurrency getYenshrGk() {
        return yenshrGk;
    }

    public void setYenshrGk(BizCurrency pYenshrGk) {
        yenshrGk = pYenshrGk;
    }

    public String getKyuuhuCd() {
        return kyuuhuCd;
    }

    public void setKyuuhuCd(String pKyuuhuCd) {
        kyuuhuCd = pKyuuhuCd;
    }

}
