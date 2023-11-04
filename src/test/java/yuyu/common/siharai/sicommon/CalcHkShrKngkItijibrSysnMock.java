package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;

/**
 * {@link CalcHkShrKngkItijibrSysn}のモッククラスです。<br />
 */
public class CalcHkShrKngkItijibrSysnMock extends CalcHkShrKngkItijibrSysn {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        if (caller == CalcHkShrKngkTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                CalcHkShrKngkBean calcHkShrKngkBean = new CalcHkShrKngkBean();
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("6000002000006"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(Long.valueOf("3000003000003"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(Long.valueOf("6000002000006"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.DAI1HKNKKN);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(Long.valueOf("0")));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(Long.valueOf("0")));
                return calcHkShrKngkBean;
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                CalcHkShrKngkBean calcHkShrKngkBean = new CalcHkShrKngkBean();
                calcHkShrKngkBean.setKihons(BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setKaiyakuhenreiknGk(BizCurrency.valueOf(Long.valueOf("8000002000008"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setTmttKnGk(BizCurrency.valueOf(Long.valueOf("4000003000004"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setHokenryoustGk(BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setSibousGk(BizCurrency.valueOf(Long.valueOf("8000002000008"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setSaigaisGk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setHokenknGk(BizCurrency.valueOf(Long.valueOf("8000002000008"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setHknKknKbn(C_HknKknKbn.BLNK);
                calcHkShrKngkBean.setTeirituTmttkngk(BizCurrency.valueOf(Long.valueOf("3000000"), BizCurrencyTypes.AU_DOLLAR));
                calcHkShrKngkBean.setSisuurendouTmttkngk(BizCurrency.valueOf(Long.valueOf("3400000"), BizCurrencyTypes.AU_DOLLAR));
                return calcHkShrKngkBean;
            }
        }
        return super.getCalcHkShrKngkBean();
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
