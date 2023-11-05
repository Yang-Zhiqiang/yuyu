package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.common.hozen.haitou.KeisanDTest_exec;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTblTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A1;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A2;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A3;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A4;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A5;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuTest_keisanKaiyakuseisankin;
import yuyu.common.hozen.khcommon.KeisanGaikaPTest_exec;
import yuyu.common.hozen.khcommon.KeisanGaikaPTest_execKawaseSitei;
import yuyu.common.hozen.khcommon.KeisanKhGensenTest_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkin2Test_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkinTest_exec;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec;
import yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_execPkakin;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link GetKawaseRate}のモッククラスです。<br />
 */
public class KeisanGaikakanzanMock extends KeisanGaikakanzan {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private String flag = "0";

    @Override
    public BizCurrency exec(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        if (caller == HenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(10);
        }

        if (caller == KeisanSPTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(10,BizCurrencyTypes.DOLLAR);
        }

        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                return BizCurrency.valueOf(30405.56);
            }
            return super.exec(pTuukaSyu, pKingaku, BizNumber.valueOf(100), pHasuuSyoriKbn);
        }

        if (caller == KeisanKhGensenTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1) {

                super.exec(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
                return BizCurrency.valueOf(2000.65);
            }

            return BizCurrency.valueOf(3000);
        }

        if (caller == EditKoujyonaiyouTblTest_exec.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(0);
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && SYORIPTN == TESTPATTERN2) {

            return BizCurrency.valueOf(200);
        }
        if (caller == CheckTuusanTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(251);
        } else if (caller == CheckTuusanTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(250);
        } else if (caller == CheckTuusanTest_exec.class && SYORIPTN == TESTPATTERN3) {
            return BizCurrency.valueOf(249);
        } else if (caller == CheckTuusanTest_exec.class) {
            return BizCurrency.valueOf(100);
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }
        if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) && SYORIPTN == TESTPATTERN1) {
            if (BizNumber.valueOf(20).equals(pKawaseRate)) {
                return BizCurrency.valueOf(120);
            }
            else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
                return BizCurrency.valueOf(130);
            }
            else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
                return BizCurrency.valueOf(140);
            }

            return BizCurrency.valueOf(100);
        }
        else if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) && SYORIPTN == TESTPATTERN2) {
            if (BizNumber.valueOf(50).equals(pKawaseRate)) {
                return BizCurrency.valueOf(150);
            }
            else if (BizNumber.valueOf(60).equals(pKawaseRate)) {
                return BizCurrency.valueOf(160);
            }
            else if (BizNumber.valueOf(70).equals(pKawaseRate)) {
                return BizCurrency.valueOf(170);
            }

            return BizCurrency.valueOf(200);
        }

        //        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
        //            if (BizCurrency.valueOf(10010,pKingaku.getType()).equals(pKingaku)) {
        //                if (BizNumber.valueOf(20).equals(pKawaseRate)) {
        //                    return BizCurrency.valueOf(102);
        //                }
        //                else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
        //                    return BizCurrency.valueOf(103);
        //                }
        //                else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
        //                    return BizCurrency.valueOf(104);
        //                }
        //            }
        //            else if (BizCurrency.valueOf(130000,pKingaku.getType()).equals(pKingaku)) {
        //                if (BizNumber.valueOf(20).equals(pKawaseRate)) {
        //                    return BizCurrency.valueOf(105);
        //                }
        //                else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
        //                    return BizCurrency.valueOf(106);
        //                }
        //                else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
        //                    return BizCurrency.valueOf(107);
        //                }
        //            }
        //            return BizCurrency.valueOf(100);
        //        }
        //        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN2.equals(SYORIPTN)) {
        //            if (BizNumber.valueOf(50).equals(pKawaseRate)) {
        //                return BizCurrency.valueOf(150);
        //            }
        //            else if (BizNumber.valueOf(60).equals(pKawaseRate)) {
        //                return BizCurrency.valueOf(160);
        //            }
        //            else if (BizNumber.valueOf(70).equals(pKawaseRate)) {
        //                return BizCurrency.valueOf(170);
        //            }
        //
        //            return BizCurrency.valueOf(200);
        //        }

        else if (caller == CheckSPTest_exec.class && SYORIPTN.equals(TESTPATTERN1)) {

            return BizCurrency.valueOf(11.11, BizCurrencyTypes.DOLLAR);
        }

        if (caller == KeisanDTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(10);
        }
        else if (caller == KeisanDTest_exec.class && SYORIPTN == TESTPATTERN2) {

            if (BizCurrency.valueOf(2206).equals(pKingaku)) {
                return BizCurrency.valueOf(269646);
            }
            else if (BizCurrency.valueOf(2585).equals(pKingaku)) {
                return BizCurrency.valueOf(316223);
            }
            else if (BizCurrency.valueOf(163246).equals(pKingaku)) {
                return BizCurrency.valueOf(1000);
            }
            else if (BizCurrency.valueOf(162490).equals(pKingaku)) {
                return BizCurrency.valueOf(1500);
            }
            else {
                return BizCurrency.valueOf(0);
            }
        }
        else if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000);
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(20000);
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(1234);
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(1001);
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(2001);
        }

        if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            else {
                return BizCurrency.valueOf(2000);
            }
        }
        else if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(8888);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3333);
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (SYORIPTN == TESTPATTERN1) {
                if (pKingaku != null &&
                    BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);
                }
                else if (pKingaku != null &&
                    BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(60000000, BizCurrencyTypes.YEN);
                }
            }
            else if (SYORIPTN == TESTPATTERN2) {
                if (pKingaku != null &&
                    BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return null;
                }
                else if (pKingaku != null &&
                    BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(60000000, BizCurrencyTypes.YEN);
                }
            }
            else if (SYORIPTN == TESTPATTERN3) {
                if (pKingaku != null &&
                    BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);
                }
                else if (pKingaku != null &&
                    BizCurrency.valueOf(45000.00, BizCurrencyTypes.DOLLAR).compareTo(pKingaku) == 0) {
                    return null;
                }
            }
            return BizCurrency.valueOf(70000000, BizCurrencyTypes.YEN);
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(789654);
            }
        }

        return super.exec(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

    @Override
    public BizCurrency execDivide(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        if (caller == KeisanSPTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(100);
        }
        if (caller == KeisanSPTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(100);
        }
        if (caller == HenkinTest_exec.class || caller == HenkinTest_execPkakin.class) {

            return BizCurrency.valueOf(100);
        }
        if (caller == CheckTuusanTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(251);
        } else if (caller == CheckTuusanTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(250);
        } else if (caller == CheckTuusanTest_exec.class && SYORIPTN == TESTPATTERN3) {
            return BizCurrency.valueOf(249);
        } else if (caller == CheckTuusanTest_exec.class) {
            return BizCurrency.valueOf(100);
        }
        if (caller == CheckTblMosSyouhinTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(100);
        }
        if (caller == CheckTblMosSyouhinTest_exec.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(20406.00, BizCurrencyTypes.DOLLAR);
        }
        if (caller == SiSiharaiKingakuKeisanTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(100020);
            }
            return super.execDivide(pTuukaSyu, pKingaku, BizNumber.valueOf(101), pHasuuSyoriKbn);
        }
        if (caller == DsGetKeiyakuSyousaiTest_exec.class && SYORIPTN == TESTPATTERN1) {
            return super.execDivide(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
        }

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(1001);
        }
        if (caller == KeisanGaikaPTest_execKawaseSitei.class) {
            return BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR);
        }
        else if (caller == KeisanGaikaPTest_exec.class) {
            return BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR);
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(2001);
        }
        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
            }else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR);
            }
        }
        if (EditKykNaiyouOsirase3Test_editInfo.class == caller && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(1001);
        }
        else if (EditKykNaiyouOsirase3Test_editInfo.class == caller && SYORIPTN == TESTPATTERN3) {
            return BizCurrency.valueOf(2001);
        }

        return super.execDivide(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

    @Override
    public BizCurrency getKanzanGaku() {

        if (caller == WSuiihyouNenkinTest_exec.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(20000);
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN1) {

            return BizCurrency.valueOf(30000, BizCurrencyTypes.DOLLAR);
        }
        else if (caller == SiSiharaiKingakuKeisanTest_exec.class && SYORIPTN == TESTPATTERN2) {
            if (flag.equals(0)) {
                flag = "1";
                return BizCurrency.valueOf(30000, BizCurrencyTypes.DOLLAR);
            }
            else if (flag.equals(1)) {
                return BizCurrency.valueOf(40000, BizCurrencyTypes.YEN);
            }
        }
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && SYORIPTN == TESTPATTERN1) {
            return BizCurrency.valueOf(1001);
        }
        else if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class && SYORIPTN == TESTPATTERN2) {
            return BizCurrency.valueOf(2001);
        }

        else if (caller == WSuiihyouNenkin2Test_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (flag.equals("0")) {
                    flag = "1";
                    return BizCurrency.valueOf(789654);
                }
                else if (flag.equals("1")) {
                    flag = "2";
                    return BizCurrency.valueOf(856957);
                }
                else if (flag.equals("2")) {
                    flag = "0";
                    return BizCurrency.valueOf(963274);
                }
            }
        }

        return super.getKanzanGaku();
    }
}
