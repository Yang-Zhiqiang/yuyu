package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.hozen.khcommon.KeisanKoujyogakuTest_exce;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkTest_exec;
import yuyu.common.hozen.khcommon.SetKjsmyouZennouInfoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険料領収通貨換算計算{@link KeisanPRsTuukaKnsn}のモッククラスです。<br />
 */
public class KeisanPRsTuukaKnsnMockForKhansyuu extends KeisanPRsTuukaKnsn {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private KeisanPRsTuukaKnsnKekkaBean pRsTuukaKnsn;

    private String flag = "0";

    @Override
    public KeisanPRsTuukaKnsnKekkaBean getPRsTuukaKnsn() {

        if (caller == SetKjsmyouZennouInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN) ||
                TESTPATTERN2.equals(SYORIPTN) ||
                TESTPATTERN3.equals(SYORIPTN)) {
                return pRsTuukaKnsn;
            }
        }
        if (caller == KeisanTukiRsgakuTest_exec1.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return pRsTuukaKnsn;
            }
        }
        if (caller == KeisanKoujyogakuTest_exce.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return pRsTuukaKnsn;
            }
        }
        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return pRsTuukaKnsn;
            }
        }

        return super.getPRsTuukaKnsn();
    }

    @Override
    public C_ErrorKbn exec(BizDate pKwsratekjymd, BizCurrency pHokenryou, C_Tuukasyu pKnsnmotoTuukasyu,
        C_Tuukasyu pKnsnsakiTuukasyu) {

        pRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsnKekkaBean.class);

        if (caller == SetKjsmyouZennouInfoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (flag.equals("0")) {
                    flag = "1";
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(100));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(200));
                    return C_ErrorKbn.OK;
                }
                else if (flag.equals("1")) {
                    flag = "0";
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(300));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(400));
                    return C_ErrorKbn.ERROR;
                }
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (flag.equals("0")) {
                    flag = "1";
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(500));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(600));
                    return C_ErrorKbn.OK;
                }
                else if (flag.equals("1")) {
                    flag = "0";
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(700));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(800));
                    return C_ErrorKbn.OK;
                }
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flag.equals("0")) {
                    flag = "1";
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(900));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(1000));
                    return C_ErrorKbn.ERROR;
                }
                else if (flag.equals("1")) {
                    flag = "0";
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(1100));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(1200));
                    return C_ErrorKbn.OK;
                }
            }
        }

        if (caller == KeisanTukiRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (C_Tuukasyu.USD.eq(pKnsnsakiTuukasyu)) {
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
                    pRsTuukaKnsn.setRstuukaknsnkwsratekjnymd(BizDate.valueOf(20200826));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(1200));
                }
                else if (C_Tuukasyu.JPY.eq(pKnsnsakiTuukasyu)) {
                    pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(1100));
                    pRsTuukaKnsn.setRstuukaknsnkwsratekjnymd(BizDate.valueOf(20200826));
                    pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(1200));
                }
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanKoujyogakuTest_exce.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(1100));
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                pRsTuukaKnsn.setRstuukaknsngop(BizCurrency.valueOf(1100, BizCurrencyTypes.AU_DOLLAR));
                pRsTuukaKnsn.setRstuukaknsnkwsratekjnymd(BizDate.valueOf(20201215));
                pRsTuukaKnsn.setRstuukaknsnkwsrate(BizNumber.valueOf(1200));
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN) || TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKwsratekjymd, pHokenryou, pKnsnmotoTuukasyu, pKnsnsakiTuukasyu);
    }

    @Override
    public List<String> getErrorCd () {

        if (caller == KeisanTukiRsgakuTest_exec1.class) {
            List<String> errorCd = new ArrayList<String>();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR);
                return errorCd;
            }
        }

        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {
            List<String> errorCd = new ArrayList<String>();

            if (TESTPATTERN2.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);
                return errorCd;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR);
                return errorCd;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR);
                return errorCd;
            }
        }

        return super.getErrorCd();
    }

    @Override
    public String getErrorRiyuu() {

        if (caller == KeisanTukiRsgakuTest_exec1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_KAWASERATESYUTOKUERR;
            }
        }
        if (caller == KeisanTukiIkkatuNyuukinGkTest_exec.class) {

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_KAWASERATESYUTOKUERR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR;
            }
        }

        return super.getErrorRiyuu();
    }
}
