package yuyu.batch.siharai.sikessan.simakebikinjikou;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 保険金給付金支払 決算 備金時効リスト集計内部Bean
 */
public class BikinJikouListSyuukeiNaibuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private long kensuu1;

    private BizCurrency kingaku1;

    public BikinJikouListSyuukeiNaibuBean() {
        kensuu1 = 0;

        kingaku1 = BizCurrency.valueOf(0);
    }

    public long getKensuu1() {
        return kensuu1;
    }

    public void setKensuu1(long pKensuu1) {
        kensuu1 = pKensuu1;
    }

    public BizCurrency getKingaku1() {
        return kingaku1;
    }

    public void setKingaku1(BizCurrency pKingaku1) {
        kingaku1 = pKingaku1;
    }


}
