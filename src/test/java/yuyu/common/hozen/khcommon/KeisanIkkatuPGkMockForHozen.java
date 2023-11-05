package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 一括払P計算のモッククラスです。<br />
 */
public class KeisanIkkatuPGkMockForHozen extends KeisanIkkatuPGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flag = "";

    private int flagNum = 0;
    private BizCurrency ikkatuP;

    public void setKeikatukisuu(int pKeikaMon) {
        if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                if (pKeikaMon == 2) {
                    flag = "1";
                }
                else if (pKeikaMon == 1) {
                    flag = "2";
                }
            }
        }
        setKeikatukisuu(pKeikaMon);
    }

    @Override
    public BizCurrency getIkkatuP() {
        if (caller == KeisanMsyMkeiPTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return ikkatuP;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return ikkatuP;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(200);
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);
            }
        }
        if (caller == KeisanHrrtksnHrkPGkgkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000);
            }
        }
        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
            }
        }

        return super.getIkkatuP();

    }

    public void exec() {
        if (caller == KeisanMsyMkeiPTest_exec.class) {
            return;
        }
        if (caller == KeisanHrrtksnHrkPGkgkTest_exec.class) {
            return;
        }

        exec();
    }
    @Override
    public C_ErrorKbn exec(KeisanIkkatuPGkBean pKeisanIkkatuPGkBean, boolean pIktwaribikifuyouFlg) {

        if (caller == KeisanMsyMkeiPTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN ) ) {
                if (pKeisanIkkatuPGkBean.getKeikamon() == 9) {
                    ikkatuP = BizCurrency.valueOf(200);
                }else {
                    ikkatuP = BizCurrency.valueOf(100);
                }

            }else if (TESTPATTERN2.equals(SYORIPTN ) ) {
                if (pKeisanIkkatuPGkBean.getKeikamon() == 3) {
                    ikkatuP = BizCurrency.valueOf(200);
                }else {
                    ikkatuP = BizCurrency.valueOf(100);
                }

            }
            return C_ErrorKbn.OK;
        }

        if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        if (caller == KeisanHrrtksnHrkPGkgkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == EditHokenKykIdouRirekiTblTest_exec.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanWV.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkP.class ||
            caller == EditHokenKykIdouRirekiTblTest_keisanZnnusisnMikkPKykInfo.class ||
            caller == EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class ||
            caller == EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class ||
            caller == EditHokenKykIdouRirekiTblTest_editHokenKykIdouHaraikataKbn.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            } if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pKeisanIkkatuPGkBean, pIktwaribikifuyouFlg);
    }

}
