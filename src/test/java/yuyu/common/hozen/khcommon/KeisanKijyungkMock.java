package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 基準金額計算<br />
 * {@link KeisanKijyungk}のモッククラスです。<br />
 */
public class KeisanKijyungkMock extends KeisanKijyungk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public KeisanKijyungkMock() {
        super();
    }

    @Override
    public C_ErrorKbn exec(
        BizDate pPryousyuuymd,
        BizCurrency pRsgaku,
        BizCurrency pHokenryou,
        C_Tuukasyu pKyktuukasyu,
        C_Tkhukaumu pYennykntkhkkbn) {

        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == EditSyoukenTblNenkinTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }

        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        return super.exec(pPryousyuuymd, pRsgaku, pHokenryou, pKyktuukasyu, pYennykntkhkkbn);
    }

    @Override
    public BizCurrency getKijyungk() {
        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(11000);
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(11000);
        }

        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class ) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(11000);
            }
        }

        else if (caller == SetHosyouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(11000);
        }

        return super.getKijyungk();
    }

    @Override
    public BizNumber getYenkawaserate() {
        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(50) ;
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizNumber.valueOf(50);
        }
        return super.getYenkawaserate();
    }
}