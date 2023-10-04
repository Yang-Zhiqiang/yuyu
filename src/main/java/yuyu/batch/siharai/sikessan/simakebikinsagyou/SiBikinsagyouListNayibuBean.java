package yuyu.batch.siharai.sikessan.simakebikinsagyou;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 保険金給付金支払 決算 保険金給付金備金作業リスト作成
 */
public class SiBikinsagyouListNayibuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizNumber kensuu1;

    private BizCurrency kingaku1;

    public SiBikinsagyouListNayibuBean() {
        super();
        kensuu1 = BizNumber.ZERO;

        kingaku1 = BizCurrency.valueOf(0);
    }

    public BizNumber getKensuu1() {
        return kensuu1;
    }

    public void setKensuu1(BizNumber pKensuu1) {
        kensuu1 = pKensuu1;
    }

    public BizCurrency getKingaku1() {
        return kingaku1;
    }

    public void setKingaku1(BizCurrency pKingaku1) {
        kingaku1 = pKingaku1;
    }
}
