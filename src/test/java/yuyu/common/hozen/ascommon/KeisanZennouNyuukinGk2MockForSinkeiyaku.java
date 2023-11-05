package yuyu.common.hozen.ascommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisanTest_execPostForm;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeNenbaraiPSpecifiedZennouP;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getZennouPFromNenbaraiPforMsg;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 前納入金額計算２のモッククラスです。<br />
 */
public class KeisanZennouNyuukinGk2MockForSinkeiyaku extends KeisanZennouNyuukinGk2 {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public int count = 0;

    @Override
    public C_ErrorKbn execKeisanSinkeiyakuDoujiZennouNyuukinGk(
        BizDate pKijyunymd,
        BizCurrency pZennouHrkp,
        Integer pZennouKikan,
        C_Tuukasyu pRsTuukasyu,
        BizNumber pRyosyukwsRate,
        BizNumber pYenkansanTkykwsRate) {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class || caller == SkZennouIkkatuUtilTest_getZennouPFromNenbaraiPforMsg.class
            || caller == SkZennouIkkatuUtilTest_getInRangeNenbaraiPSpecifiedZennouP.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == HbSeihoWebZennouKeisanTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if(TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if(TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if(TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.execKeisanSinkeiyakuDoujiZennouNyuukinGk(pKijyunymd, pZennouHrkp, pZennouKikan, pRsTuukasyu,
            pRyosyukwsRate, pYenkansanTkykwsRate);
    }

    @Override
    public BizCurrency getZennouNyuukinGk() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(new BigDecimal("11"));
            }
        }
        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {

                if (count == 0) {

                    count ++;
                    return BizCurrency.valueOf(new BigDecimal("1230"));
                }
                return BizCurrency.valueOf(new BigDecimal("1530"));
            }
        }
        if (caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class || caller == SkZennouIkkatuUtilTest_getZennouPFromNenbaraiPforMsg.class
            || caller == SkZennouIkkatuUtilTest_getInRangeNenbaraiPSpecifiedZennouP.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(4444.45);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(-1);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1200000);
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1200000,BizCurrencyTypes.DOLLAR);
            }
        }
        if (caller == HbSeihoWebZennouKeisanTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3234567890l);
            }
            if(TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(52345678901.23);
            }
            if(TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
            if(TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(12345678901l);
            }
        }

        return super.getZennouNyuukinGk();
    }

    @Override
    public BizCurrency getZennouGenka() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class) {

            return BizCurrency.valueOf(new BigDecimal("10000"));
        }
        if (caller == HbSeihoWebZennouKeisanTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2234567890l);
            }
            if(TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(42345678901.23);
            }
            if(TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
            if(TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(12345678901l);
            }
        }
        return super.getZennouGenka();
    }
}
