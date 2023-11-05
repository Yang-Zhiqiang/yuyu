package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.haitou.KeisanDTest_exec;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusin2Test_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusinTest_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuTest_keisanKaiyakuseisankin;
import yuyu.common.hozen.khcommon.KeisanGaikaPTest_exec;
import yuyu.common.hozen.khcommon.KeisanGaikaPTest_execKawaseSitei;
import yuyu.common.hozen.khcommon.KeisanKhGensenTest_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkin2Test_exec;
import yuyu.common.hozen.khcommon.WSuiihyouNenkinTest_exec;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 通貨換算計算{@link KeisanGaikakanzan}のモッククラスです。<br />
 */
public class KeisanGaikakanzanMockForHozen extends KeisanGaikakanzan {

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

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(1001);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(2001);
            }
        }

        else if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000);
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
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
        }

        else if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            return BizCurrency.valueOf(2000);
        }

        else if (KeisanDTest_exec.class == caller) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                if (BizCurrency.valueOf(2206).equals(pKingaku)) {
                    return BizCurrency.valueOf(269646);
                }
                if (BizCurrency.valueOf(2585).equals(pKingaku)) {
                    return BizCurrency.valueOf(316223);
                }
                if (BizCurrency.valueOf(163246).equals(pKingaku)) {
                    return BizCurrency.valueOf(1000);
                }
                if (BizCurrency.valueOf(162490).equals(pKingaku)) {
                    return BizCurrency.valueOf(1500);
                }

                return BizCurrency.valueOf(0);
            }
        }

        else if (caller == KeisanKhGensenTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1) {

                return BizCurrency.valueOf(2000.65);
            }

            return BizCurrency.valueOf(3000);
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }

        if (caller == EditSyoukenTblSyuusin2Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (BizCurrency.valueOf(10010,pKingaku.getType()).equals(pKingaku)) {
                    if (BizNumber.valueOf(20).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(102);
                    }
                    else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(103);
                    }
                    else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(104);
                    }
                }
                else if (BizCurrency.valueOf(130000,pKingaku.getType()).equals(pKingaku)) {
                    if (BizNumber.valueOf(20).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(105);
                    }
                    else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(106);
                    }
                    else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(107);
                    }
                }
                return BizCurrency.valueOf(100);
            }
        }

        if (caller == EditSyoukenTbltest_editTBL.class&& SYORIPTN == TESTPATTERN1) {
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
        else if (caller == EditSyoukenTbltest_editTBL.class  && SYORIPTN == TESTPATTERN2) {
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

        if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                if (BizCurrency.valueOf(10010,pKingaku.getType()).equals(pKingaku)) {
                    if (BizNumber.valueOf(20).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(102);
                    }
                    else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(103);
                    }
                    else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(104);
                    }
                }
                else if (BizCurrency.valueOf(130000,pKingaku.getType()).equals(pKingaku)) {
                    if (BizNumber.valueOf(20).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(105);
                    }
                    else if (BizNumber.valueOf(30).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(106);
                    }
                    else if (BizNumber.valueOf(40).equals(pKawaseRate)) {
                        return BizCurrency.valueOf(107);
                    }
                }
                return BizCurrency.valueOf(100);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

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

        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(789654);
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(20000);
            }
        }
        return super.exec(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

    @Override
    public BizCurrency execDivide(C_Tuukasyu pTuukaSyu,
        BizCurrency pKingaku,
        BizNumber pKawaseRate,
        C_HasuusyoriKbn pHasuuSyoriKbn) {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(1001);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(2001);
            }
        }
        if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(1000);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(1001);
            }
            else if (SYORIPTN == TESTPATTERN3) {
                return BizCurrency.valueOf(2001);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
            }
        }
        if (caller == KeisanGaikaPTest_execKawaseSitei.class) {
            return BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR);
        }
        else if (caller == KeisanGaikaPTest_exec.class) {
            return BizCurrency.valueOf(16, BizCurrencyTypes.DOLLAR);
        }

        return super.execDivide(pTuukaSyu, pKingaku, pKawaseRate, pHasuuSyoriKbn);
    }

    @Override
    public BizCurrency getKanzanGaku() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(1001);
            }
            else if (SYORIPTN == TESTPATTERN2) {
                return BizCurrency.valueOf(2001);
            }
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

        if (caller == WSuiihyouNenkinTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1) {
                return BizCurrency.valueOf(20000);
            }
        }
        return super.getKanzanGaku();
    }
}

