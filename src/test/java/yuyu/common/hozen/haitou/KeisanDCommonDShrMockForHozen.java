package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase1Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase4Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase5Test_editInfo;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 契約保全 配当 配当共通計算（配当金支払）<br />
 * {@link KeisanDCommonDShr}のモッククラスです。<br />
 */
public class KeisanDCommonDShrMockForHozen extends KeisanDCommonDShr {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public KeisanDCommonDShrMockForHozen() {
        super();
    }

    @Override
    public C_ErrorKbn calcDShrgkAllhikidasi(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd, BizDateYM pSyoriYm) {
        if (caller == EditKykNaiyouOsirase4Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == EditKykNaiyouOsirase5Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == EditKykNaiyouOsirase1Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.calcDShrgkAllhikidasi(pSyono, pCalckijyunymd, pSyoriYmd, pSyoriYm);
    }

    @Override
    public BizCurrency getShrgk() {
        if (caller == EditKykNaiyouOsirase4Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234, BizCurrencyTypes.YEN);
            }
        }

        if (caller == EditKykNaiyouOsirase5Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234, BizCurrencyTypes.YEN);
            }
        }

        if (caller == EditKykNaiyouOsirase1Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
        }
        return super.getShrgk();
    }
}