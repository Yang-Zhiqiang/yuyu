package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn.DwGetHozenKykSntkHijynSysnImplTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 既払込Ｐ計算クラス
 */
public class KeisanKihrkPMockForDirect extends KeisanKihrkP {


    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(String pSyono, C_Tuukasyu pKykTuukasyu) {

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pSyono, pKykTuukasyu);
    }

    @Override
    public BizCurrency getYenKihrkP() {

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            return BizCurrency.valueOf(12345);
        }
        return super.getYenKihrkP();
    }

    @Override
    public BizCurrency getKihrkP() {

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            return BizCurrency.valueOf(22345);
        }
        return super.getKihrkP();
    }
}
