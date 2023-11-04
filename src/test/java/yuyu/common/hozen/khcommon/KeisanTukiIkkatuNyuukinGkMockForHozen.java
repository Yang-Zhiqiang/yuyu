package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanTukiIkkatuNyuukinGk}のモッククラスです。<br />
 */
public class KeisanTukiIkkatuNyuukinGkMockForHozen extends KeisanTukiIkkatuNyuukinGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == EditSyoukenTblNenkin2Test_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

            return C_ErrorKbn.ERROR;
        }

        return super.exec(pKeisanIkkatuNyuukinGkBean, pIktwaribikiFuyouFlg);
    }

    @Override
    public BizCurrency getIktnyknkgk() {

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123456, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(50000, BizCurrencyTypes.YEN);
            }
        }

        else if (caller == EditSyoukenTblNenkin2Test_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(50000);
            }

            return BizCurrency.valueOf(0);
        }

        return super.getIktnyknkgk();
    }
}
