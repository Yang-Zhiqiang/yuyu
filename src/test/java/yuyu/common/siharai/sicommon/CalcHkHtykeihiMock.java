package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link CalcHkHtykeihi}のモッククラスです。<br />
 */
public class CalcHkHtykeihiMock extends CalcHkHtykeihi {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public CalcHkHtykeihiBean exec(String pSyono, C_Tuukasyu pKykTuukasyu, C_SUketoriHouhouKbn pSuketorihouhoukbn,
        BizCurrency pHokenkg, BizCurrency pYenhokenkngk, BizCurrency pNkkknjyutougk, BizCurrency pYennkkknjyutougk,
        BizNumber pMisyuuptekikawaserate, BizCurrency pMisyuup) {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            CurrencyType currencyType = pHokenkg.getType();
            if (TESTPATTERN1.equals(SYORIPTN)) {
                CalcHkHtykeihiBean calcHkHtykeihiBean = SWAKInjector.getInstance(CalcHkHtykeihiBean.class);
                calcHkHtykeihiBean.setHtykeihi(BizCurrency.valueOf(0, currencyType));
                calcHkHtykeihiBean.setYenhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkHtykeihiBean.setNkhtykeihi(BizCurrency.valueOf(0, currencyType));
                calcHkHtykeihiBean.setYennkhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                calcHkHtykeihiBean.setItjknhtykeihi(BizCurrency.valueOf(0, currencyType));
                calcHkHtykeihiBean.setYenitjknhtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                return calcHkHtykeihiBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                CalcHkHtykeihiBean calcHkHtykeihiBean = SWAKInjector.getInstance(CalcHkHtykeihiBean.class);
                calcHkHtykeihiBean.setHtykeihi(BizCurrency.valueOf(17000000L, currencyType));
                calcHkHtykeihiBean.setYenhtykeihi(BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN));
                calcHkHtykeihiBean.setNkhtykeihi(BizCurrency.valueOf(0, currencyType));
                calcHkHtykeihiBean.setYennkhtykeihi(BizCurrency.valueOf(0));
                calcHkHtykeihiBean.setItjknhtykeihi(BizCurrency.valueOf(17000001L, currencyType));
                calcHkHtykeihiBean.setYenitjknhtykeihi(BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN));
                calcHkHtykeihiBean.setShrkykhtykeihi(BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN));
                return calcHkHtykeihiBean;
            }
        }

        return super.exec(pSyono, pKykTuukasyu, pSuketorihouhoukbn, pHokenkg, pYenhokenkngk, pNkkknjyutougk,
            pYennkkknjyutougk, pMisyuuptekikawaserate, pMisyuup);

    }

}
