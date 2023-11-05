package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanIkkatuNyuukinGk}のモッククラスです。<br />
 */
public class KeisanIkkatuNyuukinGkMock extends KeisanIkkatuNyuukinGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency iktnyknkgk;

    public int count = 0;

    @Override
    public BizCurrency getIktwaribikikgk() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(500);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(500);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {
            return BizCurrency.valueOf(500);
        }

        return super.getIktwaribikikgk();
    }

    @Override
    public BizCurrency getWrbktkyokknp() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(3000);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(3000);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {
            return BizCurrency.valueOf(3000);
        }
        return super.getWrbktkyokknp();
    }

    @Override
    public Integer getWrbktkyokkntksu() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return 1;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {
            return 1;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {
            return 1;
        }
        return super.getWrbktkyokkntksu();
    }

    @Override
    public BizCurrency getWrbktkyukkngip() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(2000);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(2000);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {
            return BizCurrency.valueOf(2000);
        }
        return super.getWrbktkyukkngip();
    }

    @Override
    public Integer getWrbktkyukkngitksu() {
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return 1;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {
            return 0;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {
            return 2;
        }
        return super.getWrbktkyukkngitksu();
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.ERROR;
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            if (count == 0) {

                count++;
                return C_ErrorKbn.OK;
            }
            return C_ErrorKbn.ERROR;

        }
        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }

        if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.ERROR;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN4.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN5.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN6.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        if (caller == EditSyoukenTblNenkin2Test_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)) {

                iktnyknkgk = BizCurrency.valueOf(50000);
                return C_ErrorKbn.OK;
            }else {

                iktnyknkgk = BizCurrency.valueOf(0);
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKeisanIkkatuNyuukinGkBean, pIktwaribikiFuyouFlg);
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, BizDate pRyosyuYmd,
        BizDateYM pJyuutouYm) {

        if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {

            return C_ErrorKbn.OK;
        }
        return super.exec(pKeisanIkkatuNyuukinGkBean, pRyosyuYmd, pJyuutouYm);
    }

    @Override
    public BizCurrency getIktnyknkgk() {

        if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {

            return BizCurrency.valueOf(new BigDecimal("14"), BizCurrencyTypes.DOLLAR);
        }
        else if (caller == yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            if (count < 2) {

                count++;
                return BizCurrency.valueOf(new BigDecimal("14"), BizCurrencyTypes.DOLLAR);
            }
            return BizCurrency.valueOf(new BigDecimal("15"), BizCurrencyTypes.DOLLAR);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizCurrency.valueOf(5000);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN2.equals(SYORIPTN)) {

            return BizCurrency.valueOf(5000);
        }
        else if ((caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec5.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {

            return BizCurrency.valueOf(5000);
        }

        if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {

            return BizCurrency.valueOf(3333.35);
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN3.equals(SYORIPTN)) {

            return null;
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN4.equals(SYORIPTN)) {

            return BizCurrency.valueOf(0);
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN5.equals(SYORIPTN)) {

            return BizCurrency.valueOf(-1);
        }
        else if ((caller == SkZennouIkkatuUtilTest_getIkkatuPFromIkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getZennouPFrom12IkkatuTukiPYenforMsg.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class ||
            caller == SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class) &&
            TESTPATTERN6.equals(SYORIPTN)) {

            return BizCurrency.valueOf(1200000);
        }
        else if (caller == EditSyoukenTblNenkin2Test_exec.class) {

            if(TESTPATTERN1.equals(SYORIPTN)) {

                return iktnyknkgk;
            }else {

                return iktnyknkgk;
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            return BizCurrency.valueOf(123456, BizCurrencyTypes.YEN);
        }

        if (caller == EditKykNaiyouOsirase3Test_editInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123456, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(50000, BizCurrencyTypes.YEN);
            }
        }

        return super.getIktnyknkgk();
    }
}
