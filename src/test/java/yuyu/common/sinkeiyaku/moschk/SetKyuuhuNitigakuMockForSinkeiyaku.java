package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * {@link SetKyuuhuNitigaku}のモッククラスです。<br />
 */
public class SetKyuuhuNitigakuMockForSinkeiyaku extends SetKyuuhuNitigaku {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    private CurrencyType currencyType;

    @Override
    public void exec(List<HT_MosSyouhn> pSyuMosSyouhnParamLst, List<HT_MosSyouhn> pTkMosSyouhnParamLst) {
        currencyType = pSyuMosSyouhnParamLst.get(0).getKihons().getType();
        super.exec(pSyuMosSyouhnParamLst, pTkMosSyouhnParamLst);
    }

    @Override
    public BizCurrency getSipnyutsnntgk1() {

        if (caller == CheckTblMosSyouhinTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1 || SYORIPTN == TESTPATTERN3) {
                return BizCurrency.valueOf(6500000, currencyType);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(6000000, currencyType);
            }
            else {
                return BizCurrency.valueOf(5000000, currencyType);
            }
        }
        return super.getSipnyutsnntgk1();
    }

    @Override
    public BizCurrency getSipnyutsnntgk2() {
        if (caller == CheckTblMosSyouhinTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1 || SYORIPTN == TESTPATTERN4 || SYORIPTN == TESTPATTERN6) {
                return BizCurrency.valueOf(5500000, currencyType);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(6000000, currencyType);
            }
            else if (SYORIPTN == TESTPATTERN3 || SYORIPTN == TESTPATTERN5) {
                return BizCurrency.valueOf(7000000, currencyType);
            }
        }
        return super.getSipnyutsnntgk2();
    }

    @Override
    public BizCurrency getSipnyutsnntgk3() {
        if (caller == CheckTblMosSyouhinTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1 || SYORIPTN == TESTPATTERN4 || SYORIPTN == TESTPATTERN5) {
                return BizCurrency.valueOf(5500000, currencyType);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(6000000, currencyType);
            }
            else if (SYORIPTN == TESTPATTERN3 || SYORIPTN == TESTPATTERN6) {
                return BizCurrency.valueOf(7000000, currencyType);
            }
        }
        return  super.getSipnyutsnntgk3();
    }
}
