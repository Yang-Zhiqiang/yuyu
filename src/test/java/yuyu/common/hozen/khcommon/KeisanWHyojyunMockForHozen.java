package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanWHyojyun}のモッククラスです<br />
 */
public class KeisanWHyojyunMockForHozen extends KeisanWHyojyun {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency kaiyakuhr = null;

    private int keikanensuu = 0;

    private int keikatukisuu = 0;

    @Override
    public BizCurrency getW() {
        return kaiyakuhr;
    }

    @Override
    public int getKeikanensuu() {
        return keikanensuu;
    }

    @Override
    public int getKeikatukisuu() {
        return keikatukisuu;
    }

    @Override
    public C_ErrorKbn exec(BizDate pCalckijyunYmd, BizDateYM pCalckijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (caller == KeisanWTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.ERROR;
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {
                kaiyakuhr = BizCurrency.valueOf(555, BizCurrencyTypes.DOLLAR);
                keikanensuu = 6;
                keikatukisuu = 7;
                return C_ErrorKbn.OK;
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {
                kaiyakuhr = BizCurrency.valueOf(888, BizCurrencyTypes.YEN);
                keikanensuu = 1;
                keikatukisuu = 3;
                return C_ErrorKbn.OK;
            }
        }

        C_ErrorKbn result = super.exec(pCalckijyunYmd, pCalckijyunYm, pKeisanWExtBean);
        kaiyakuhr = super.getW();
        keikanensuu = super.getKeikanensuu();
        keikatukisuu = super.getKeikatukisuu();
        return result;
    }
}
