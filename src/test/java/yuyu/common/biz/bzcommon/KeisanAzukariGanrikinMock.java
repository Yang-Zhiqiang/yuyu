package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuTest_keisanKaiyakuseisankin;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
/**
 * {@link KeisanAzukariGanrikin}のモッククラスです。<br />
 */
public class KeisanAzukariGanrikinMock extends KeisanAzukariGanrikin {

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
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(1001);
                azukariGanrikinYen = BizCurrency.valueOf(1002);
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(2001);
                azukariGanrikinYen = BizCurrency.valueOf(2002);
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);
                azukariGanrikinYen = BizCurrency.valueOf(150);
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR);
                azukariGanrikinYen = BizCurrency.valueOf(250);

                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pSyono, pCalcKijyunYmd, pKyktuukasyu);

    }

    @Override
    public C_ErrorKbn exec(BizDate pCalcStartYmd,
        BizDate pCalcKijyunYmd,
        BizCurrency pAzukariKg,
        C_Tuukasyu pTuukasyu) {
        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(100);
                azukariGanrikinYen = BizCurrency.valueOf(150);
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                azukariGanrikinKyktuuka = BizCurrency.valueOf(200);
                azukariGanrikinYen = BizCurrency.valueOf(250);

                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pCalcStartYmd, pCalcKijyunYmd, pAzukariKg,pTuukasyu);
    }

    @Override
    public BizCurrency getAzukariGanrikinKyktuuka() {
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return azukariGanrikinKyktuuka;
        }
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            return azukariGanrikinKyktuuka;
        }
        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            return azukariGanrikinKyktuuka;
        }

        return super.getAzukariGanrikinKyktuuka();
    }

    @Override
    public BizCurrency getAzukariGanrikinYen() {

        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            return azukariGanrikinYen;
        }
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            return azukariGanrikinYen;
        }
        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            return azukariGanrikinYen;
        }

        return super.getAzukariGanrikinYen();
    }

}
