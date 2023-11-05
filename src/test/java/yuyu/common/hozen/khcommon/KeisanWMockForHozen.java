package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;

/**
 * 解約返戻金計算{@link KeisanW}のモッククラスです。<br />
 */
public class KeisanWMockForHozen extends KeisanW {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    private String flag = "0";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private int kensuu = 0;

    private BizCurrency kaiyakuHr = null;

    @Override
    public C_ErrorKbn exec(BizDate pCalcKijyunYmd, BizDateYM pKijyunYm, KeisanWExtBean pKeisanWExtBean) {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == KeisanYendtHnkSTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
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
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (pKeisanWExtBean.getTmttkntaisyouym() == null) {
                    return C_ErrorKbn.OK;
                }
                return C_ErrorKbn.ERROR;
            }
        }

        else if(caller == WSuiihyouSyuusin3Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
    	
        else if(caller == WSuiihyouSyuusin2Test_exec.class){
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (kensuu == 0) {
                    kensuu = 1;
                    return C_ErrorKbn.OK;
                }
                kensuu = 0;
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                if (kensuu == 0) {
                    kensuu = 1;
                    return C_ErrorKbn.OK;
                }
                else if (kensuu == 1) {
                    kensuu = 2;
                    return C_ErrorKbn.OK;
                }
                kensuu = 0;
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == WSuiihyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN5.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "2";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN6.equals(SYORIPTN) && "2".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "2";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "2".equals(flag)) {
                flag = "3";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) && "3".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
        }

        else if (caller == WSuiihyouNenkinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            } else if (TESTPATTERN4.equals(SYORIPTN)) {
                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            } else if (TESTPATTERN5.equals(SYORIPTN)) {
                if (BizNumber.valueOf(0.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(1.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else if (BizNumber.valueOf(2.5).equals(pKeisanWExtBean.getKyksjkkktyouseiriritu())) {

                    return C_ErrorKbn.ERROR;
                } else {
                    return C_ErrorKbn.OK;
                }
            }
        }

        else if (caller == WSuiihyouNenkin3Test_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN) && "0".equals(flag)) {
                flag = "1";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN) && "1".equals(flag)) {
                flag = "2";
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN) && "2".equals(flag)) {
                flag = "0";
                return C_ErrorKbn.ERROR;
            }
        }
        else if (caller == HanteiTyotikuseihokenTest_exec.class || caller == SetTyotikuseihokenhyoujiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        else if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pKeisanWExtBean.getHrkkkn() == 0) {
                    kaiyakuHr = BizCurrency.valueOf(11345, BizCurrencyTypes.DOLLAR);
                }
                if (pKeisanWExtBean.getHrkkkn() == 1) {

                    kaiyakuHr = BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR);
                }
                if (pKeisanWExtBean.getHrkkkn() == 2) {

                    kaiyakuHr = BizCurrency.valueOf(14345, BizCurrencyTypes.DOLLAR);
                }
                if (pKeisanWExtBean.getHrkkkn() == 3) {

                    kaiyakuHr = BizCurrency.valueOf(11345, BizCurrencyTypes.DOLLAR);
                }
                return C_ErrorKbn.OK;
            }
        }
        return super.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);
    }

    @Override
    public BizCurrency getW() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR);
            }
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(1000);
        }

        else if (caller == KeisanYendtHnkSTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234567890);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123456711);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(123456710);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234567121);
            }
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(654.666);
            }
        }

        if (caller == WSuiihyouSyuusin2Test_exec.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9214.19);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(9214.19);
            }
        }

        else if (caller == WSuiihyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(70);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(55);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN6.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100);
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(10000);
            }
        }
        else if (caller == HanteiTyotikuseihokenTest_exec.class  || caller == SetTyotikuseihokenhyoujiTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(60000000);
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(50000000, BizCurrencyTypes.DOLLAR);
            }else if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(40000000);
            }
        }
        else if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return kaiyakuHr;
            }
        }

        return super.getW();
    }

    @Override
    public BizCurrency getV() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            switch (SYORIPTN) {
                case TESTPATTERN1: return BizCurrency.valueOf(1000);
                default: break;
            }
        }

        else if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(963852);
            }
        }

        if (caller == WSuiihyouSyuusin2Test_exec.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return BizCurrency.valueOf(10000);
            }
        }

        else if (caller == WSuiihyouTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(55);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(68);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(55);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                caller == WSuiihyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN) ||
                caller == WSuiihyouTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
                return BizCurrency.valueOf(68);
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(15000);
            }
        }
        return super.getV();
    }

    @Override
    public BizCurrency getTeirituTmttkngk() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000);
            }
        }
        return super.getTeirituTmttkngk();
    }

    @Override
    public BizCurrency getSisuurendouTmttkngk() {

        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
        }
        return super.getSisuurendouTmttkngk();
    }

    @Override
    public BizNumber getSjkkktyouseiritu() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizNumber.valueOf(3001);
            }
        }
        return super.getSjkkktyouseiritu();
    }

    @Override
    public BizCurrency getSjkkktyouseigk() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }
        return super.getSjkkktyouseigk();
    }

    @Override
    public BizCurrency getKaiyakukjgk() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }
        return super.getKaiyakukjgk();
    }
    @Override
    public BizNumber getKaiyakukjritu() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(2001);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return BizNumber.valueOf(3001);
            }
        }
        return super.getKaiyakukjritu();
    }

    @Override
    public C_FiSiyouKbn getFiSiyouKbn() {
        if (caller == KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_FiSiyouKbn.BLNK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_FiSiyouKbn.TJTMATU;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)
                || TESTPATTERN4.equals(SYORIPTN)) {
                return C_FiSiyouKbn.TJTSI;
            }
        }
        return super.getFiSiyouKbn();
    }

    @Override
    public BizCurrency getPruikei() {

        if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1234.555);
            }
        }
        return super.getPruikei();
    }

    @Override
    public BizDateYM getPtumitatekinKeisanYM() {

        if(caller == WSuiihyouNenkin2Test_exec.class){
            if (TESTPATTERN1.equals(SYORIPTN) || TESTPATTERN3.equals(SYORIPTN)) {
                return BizDateYM.valueOf(201904);
            }
        }
        return super.getPtumitatekinKeisanYM();
    }

    @Override
    public BizCurrency getKaiyakukjMaeW() {

        if (caller == WSuiihyouNenkinTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(25000);
            }
        }
        return super.getKaiyakukjMaeW();
    }

    @Override
    public int getKeikanensuu() {

        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 0;
            }
        }
        return getKeikanensuu();
    }

    @Override
    public int getKeikatukisuu() {

        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 1;
            }
        }
        return getKeikatukisuu();
    }
}

