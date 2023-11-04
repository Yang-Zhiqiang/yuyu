package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkTest_exec;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;

/**
 * {@link KeisanWItiji}のモッククラスです<br />
 */
public class KeisanWItijiMock extends KeisanWItiji{
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flag = "0";

    private BizCurrency kaiyakuHr = null;

    private BizCurrency tmttKngk = null;

    @Override
    public C_ErrorKbn exec(
        BizDate pCalcKijyunYmd,
        BizDateYM pKijyunYm,
        KeisanWExtBean pKeisanWExtBean) {

        if (caller == KeisanWTest_exec.class && TESTPATTERN10.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else {
            return super.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);
        }
    }

    @Override
    public BizCurrency getW() {

        if (caller == WSuiihyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(70);
        }
        else if (caller == WSuiihyouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }
        else if (caller == WSuiihyouTest_exec.class && TESTPATTERN4.equals(SYORIPTN) ||
            caller == WSuiihyouTest_exec.class && TESTPATTERN5.equals(SYORIPTN) ||
            caller == WSuiihyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }
        else if (caller == WSuiihyouTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return BizCurrency.valueOf(55);
        }
        else if (caller == CalcHkShrKngkTest_exec.class || caller == SiSiharaiKingakuKeisanTest_exec.class) {
            return kaiyakuHr;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(1000);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(555);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(555, BizCurrencyTypes.DOLLAR);
        }
        return super.getW();
    }

    @Override
    public BizCurrency getV() {

        if (caller == WSuiihyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(55);
        }
        else if (caller == WSuiihyouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(68);
        }
        else if (caller == WSuiihyouTest_exec.class && TESTPATTERN4.equals(SYORIPTN) ||
            caller == WSuiihyouTest_exec.class && TESTPATTERN5.equals(SYORIPTN) ||
            caller == WSuiihyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return BizCurrency.valueOf(68);
        }
        else if (caller == WSuiihyouTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            return BizCurrency.valueOf(55);
        }
        else if (caller == CalcHkShrKngkTest_exec.class || caller == SiSiharaiKingakuKeisanTest_exec.class) {
            return tmttKngk;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(444);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(444, BizCurrencyTypes.DOLLAR);
        }

        return super.getV();
    }

    @Override
    public BizNumber getSjkkktyouseiritu() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizNumber.valueOf(5.3);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizNumber.valueOf(5.3);
        }
        return super.getSjkkktyouseiritu();
    }

    @Override
    public BizCurrency getSjkkktyouseigk() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(333);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(333, BizCurrencyTypes.DOLLAR);
        }
        return super.getSjkkktyouseigk();
    }
    @Override
    public BizNumber getKaiyakukjritu() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizNumber.valueOf(2.1);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizNumber.valueOf(2.1);
        }
        return super.getKaiyakukjritu();
    }
    @Override
    public BizCurrency getKaiyakukjgk() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(222);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(222, BizCurrencyTypes.DOLLAR);
        }
        return super.getKaiyakukjgk();
    }
    @Override
    public int getKaiyakukoujyokeikanensuu() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return 1;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return 1;
        }
        return super.getKaiyakukoujyokeikanensuu();
    }
    @Override
    public int getKeikanensuu() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return 6;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return 6;
        }
        return super.getKeikanensuu();
    }
    @Override
    public int getKeikatukisuu() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return 7;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return 7;
        }
        return super.getKeikatukisuu();
    }
    @Override
    public BizCurrency getCV() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(111);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(111, BizCurrencyTypes.DOLLAR);
        }
        return super.getCV();
    }
    @Override
    public C_FiSiyouKbn getFiSiyouKbn() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return C_FiSiyouKbn.TJTSI;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return C_FiSiyouKbn.TJTSI;
        }
        return super.getFiSiyouKbn();
    }
    @Override
    public BizNumber getMvaTyouseikou() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizNumber.valueOf(9.1);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizNumber.valueOf(9.1);
        }
        return super.getMvaTyouseikou();
    }
    @Override
    public int getMvaYouKeikanensuu() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return 1;
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return 1;
        }
        return super.getMvaYouKeikanensuu();
    }
    @Override
    public BizCurrency getTeiriTutmttKngk() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(345);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(345, BizCurrencyTypes.DOLLAR);
        }
        return super.getTeiriTutmttKngk();
    }
    @Override
    public BizCurrency getSisuuRendouTmttKngk() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(543);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(543, BizCurrencyTypes.DOLLAR);
        }
        return super.getSisuuRendouTmttKngk();
    }
    @Override
    public BizCurrency getKaiyakukjMaeW() {

        if (caller == KeisanWTest_exec.class && TESTPATTERN11.equals(SYORIPTN)) {
            return BizCurrency.valueOf(12345);
        }
        else if (caller == KeisanWTest_exec.class && TESTPATTERN12.equals(SYORIPTN)) {
            return BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR);
        }
        return super.getKaiyakukjMaeW();
    }

}
