package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusinTest_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A1;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A2;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A3;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A4;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A5;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;

/**
 * {@link CalcJdkghkKngk}のモッククラスです。<br />
 */
public class CalcJdkghkKngkMock extends CalcJdkghkKngk {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(C_JydkgmbHkKsnKbn pJydkgmbHkKsnKbn, BizCurrency pTkkijyunHokenkngk, BizCurrency pKaiyakuhr,
        BizNumber pYoteiriritu, BizDate pKykymd, BizDate pCalckijyunymd, BizDate pHhknseiymd, Integer pNen,
        C_Hhknsei pHhknsei) {

        if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class|| caller == EditSyoukenTbltest_editTBL.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        return super.exec(pJydkgmbHkKsnKbn, pTkkijyunHokenkngk, pKaiyakuhr, pYoteiriritu, pKykymd, pCalckijyunymd,
            pHhknseiymd, pNen, pHhknsei);
    }

    @Override
    public CalcJdkghkKngkBean getCalcJdkghkKngkBean() {
        CalcJdkghkKngkBean calcJdkghkKngkBean = SWAKInjector.getInstance(CalcJdkghkKngkBean.class);
        if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class|| caller == EditSyoukenTbltest_editTBL.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
            calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(110000));
        }
        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            calcJdkghkKngkBean.setWaribikiKikan(BizNumber.valueOf(11));
            calcJdkghkKngkBean.setJdkghkKnGk(BizCurrency.valueOf(110000));
        }
        else {
            return super.getCalcJdkghkKngkBean();
        }
        return calcJdkghkKngkBean;
    }
}
