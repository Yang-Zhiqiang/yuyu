package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanW}のモッククラスです。<br />
 */
public class KeisanWMockForSinkeiyaku extends KeisanW {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizDate pCalcKijyunYmd, BizDateYM pKijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);
    }

    @Override
    public BizCurrency getV() {
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(40);
            }else if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(0);
            }
        }
        return super.getV();
    }
}
