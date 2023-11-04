package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_ErrorKbn;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 一括払P計算のモッククラスです。<br />
 */
public class KeisanIkkatuPGkMock extends KeisanIkkatuPGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flag = "";

    private int flagNum = 0;

    public void setKeikatukisuu(int pKeikaMon) {
        if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if (pKeikaMon == 2) {
                flag = "1";
            }
            else if (pKeikaMon == 1) {
                flag = "2";
            }
        }
        setKeikatukisuu(pKeikaMon);
    }

    @Override
    public BizCurrency getIkkatuP() {
        if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }
        else if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if ("1".equals(flag)) {
                return BizCurrency.valueOf(500);
            }
            else if ("2".equals(flag)) {
                flag = "";
                return BizCurrency.valueOf(300);
            }
            return BizCurrency.valueOf(100);
        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            if ("".equals(flag)) {
                flag = "1";
                return BizCurrency.valueOf(200);
            }
            else if ("1".equals(flag)) {
                flag = "";
                return BizCurrency.valueOf(100);
            }
        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if (flagNum/3 == 0) {
                flagNum++;
                return BizCurrency.valueOf(200);
            }
            else if (flagNum/3 == 1) {
                flagNum++;
                return BizCurrency.valueOf(100);
            }
            else if(flagNum/3 > 1) {
                flagNum = 0;
            }
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(0);
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizCurrency.valueOf(-1);
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return BizCurrency.valueOf(1);
        }
        if (caller == EditSeihowebIdouRirekiTblTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1001);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(2001);
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(3001);
            }
        }

        if (caller == KeisanHrrtksnHrkPGkgkTest_exec.class&& TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(5000);
        }

        return super.getIkkatuP();

    }

    public void exec() {
        if (caller == SyouhnTaniKeisanMsyMkeiPTest_exec.class) {
            return;
        }
        else if (caller == KeisanMsyMkeiPTest_exec.class) {
            return;
        }
        else if (caller == EditKoujyonaiyouTblTest_exec.class) {
            return;
        }
        else if (caller == KeisanHrrtksnHrkPGkgkTest_exec.class) {
            return;
        }

        exec();
    }
    @Override
    public C_ErrorKbn exec(KeisanIkkatuPGkBean pKeisanIkkatuPGkBean, boolean pIktwaribikifuyouFlg) {
        if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }
        if (caller == EditSeihowebIdouRirekiTblTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        if (caller == KeisanHrrtksnHrkPGkgkTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_ErrorKbn.OK;
        }

        return super.exec(pKeisanIkkatuPGkBean, pIktwaribikifuyouFlg);
    }

}
