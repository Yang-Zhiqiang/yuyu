package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKyoutuuInfoTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 基準金額計算<br />
 * {@link KeisanKijyungk}のモッククラスです。<br />
 *
 */
public class KeisanKijyungkMockForHozen extends KeisanKijyungk {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public KeisanKijyungkMockForHozen() {
        super();
    }

    @Override
    public C_ErrorKbn exec(
        BizDate pPryousyuuymd,
        BizCurrency pRsgaku,
        BizCurrency pHokenryou,
        C_Tuukasyu pKyktuukasyu,
        C_Tkhukaumu pYennykntkhkkbn) {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            return super.exec(pPryousyuuymd, pRsgaku, pHokenryou, pKyktuukasyu, pYennykntkhkkbn);
        }

        if (caller == EditSyoukenTbltest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == EditSyoukenTblSyuusinTest_editTBL.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

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


        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;

            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
        }

        if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pPryousyuuymd, pRsgaku, pHokenryou, pKyktuukasyu, pYennykntkhkkbn);
    }

    @Override
    public BizCurrency getKijyungk() {

        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(11000);
        }

        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(11000);
            }

            return super.getKijyungk();
        }
        if (caller == EditSyoukenTbltest_editTBL.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(11000);
            }
        }

        if (caller == EditSyoukenTblSyuusinTest_editTBL.class ) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(11000);
            }
        }

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



        if (caller == KhGetSyanaiWebKyoutuuInfoTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(12, BizCurrencyTypes.YEN);
            }
        }

        if (caller == SetHosyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(11000);
            }
        }

        return super.getKijyungk();
    }

    @Override
    public BizNumber getYenkawaserate() {

        if (caller == EditSyoukenTbltest_editTBL.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(50) ;
            }
            return super.getYenkawaserate();
        }

        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizNumber.valueOf(50);
        }

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