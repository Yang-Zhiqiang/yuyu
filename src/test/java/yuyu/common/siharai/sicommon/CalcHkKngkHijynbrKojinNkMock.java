package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;

/**
 * {@link CalcHkKngkHijynbrKojinNk}のモッククラスです。<br />
 */
public class CalcHkKngkHijynbrKojinNkMock extends CalcHkKngkHijynbrKojinNk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    private BizDate calckijyunYmd;

    @Override
    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                CalcHkShrKngkBean calcHkShrKngkBean = new CalcHkShrKngkBean();
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(Long.valueOf("3000003000003"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("6000006000006"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000004000004"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(Long.valueOf("9000009000009"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(Long.valueOf("7000007000007"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(Long.valueOf("8000008000008"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                return calcHkShrKngkBean;
            }
        }
        return super.getCalcHkShrKngkBean();
    }

    @Override
    public BizDate getCalcKijyunYmd() {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                calckijyunYmd = BizDate.valueOf(20200204);
                return calckijyunYmd;
            }
        }
        return super.getCalcKijyunYmd();
    }

    @Override
    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.exec(pCalcHkShrKngkInputBean);
    }
}
