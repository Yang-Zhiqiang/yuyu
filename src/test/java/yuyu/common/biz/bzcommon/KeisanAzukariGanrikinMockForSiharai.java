package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
/**
 * {@link KeisanAzukariGanrikin}のモッククラスです。<br />
 */
public class KeisanAzukariGanrikinMockForSiharai extends KeisanAzukariGanrikin {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private BizCurrency azukariGanrikinKyktuuka;

    private BizCurrency azukariGanrikinYen;

    @Override
    public C_ErrorKbn exec(String pSyono,
        BizDate pCalcKijyunYmd,
        C_Tuukasyu pKyktuukasyu) {

        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(0);
                azukariGanrikinYen = BizCurrency.valueOf(0);
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(1003);
                azukariGanrikinYen = BizCurrency.valueOf(1003, BizCurrencyTypes.DOLLAR);
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(4002, BizCurrencyTypes.DOLLAR);
                azukariGanrikinYen = BizCurrency.valueOf(5003, BizCurrencyTypes.YEN);
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(110, BizCurrencyTypes.DOLLAR);
                azukariGanrikinYen = BizCurrency.valueOf(13000, BizCurrencyTypes.YEN);
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pSyono, pCalcKijyunYmd, pKyktuukasyu);

    }

    @Override
    public BizCurrency getAzukariGanrikinKyktuuka() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return azukariGanrikinKyktuuka;
        }

        return super.getAzukariGanrikinKyktuuka();
    }

    @Override
    public BizCurrency getAzukariGanrikinYen() {

        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return azukariGanrikinYen;
        }

        return super.getAzukariGanrikinYen();
    }

}
