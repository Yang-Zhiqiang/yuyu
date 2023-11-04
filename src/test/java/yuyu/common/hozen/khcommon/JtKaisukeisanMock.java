package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 充当回数計算のモッククラスです。<br />
 */
public class JtKaisukeisanMock extends JtKaisukeisan {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flg = "0";

    @Override
    public void exec(int pIJtNensuu,
        int pIJtGesuu,
        C_Hrkkaisuu pIHhrkkaisuu) {
        if (KeisanMsyMkeiPTest_exec.class == caller) {
            return;
        }
        if (KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class == caller) {
            return;
        }
        if (EditKoujyonaiyouTblTest_exec.class == caller && TESTPATTERN3.equals(SYORIPTN)){
            return;
        }
        super.exec(pIJtNensuu, pIJtGesuu, pIHhrkkaisuu);
    }

    @Override
    public int getJyutoukaisuu() {

        if (caller == KeisanKihrkPRuikeigkTest_exec.class && SYORIPTN.equals(TESTPATTERN1)) {
            return 0;

        }
        if (caller == KeisanKihrkPRuikeigkTest_exec.class && SYORIPTN.equals(TESTPATTERN2)) {
            return 1;

        }
        if (caller == KeisanKihrkPRuikeigkTest_exec.class && SYORIPTN.equals(TESTPATTERN3)) {
            return 3;

        }

        if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return 0;
        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return 1;
        }
        else if (caller == KeisanMsyMkeiPTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return 3;
        }
        else if (caller == KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class && TESTPATTERN1.equals(SYORIPTN)) {
            if (flg.equals("0")) {
                flg = "1";
                return 2;
            }
            else if (flg.equals("1")) {
                flg = "0";
                return 4;
            }
        }
        else if (caller == KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class && TESTPATTERN2.equals(SYORIPTN)) {
            if (flg.equals("0")) {
                flg = "1";
                return 3;
            }
            else if (flg.equals("1")) {
                flg = "0";
                return 5;
            }
        }
        else if (caller == KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class && TESTPATTERN3.equals(SYORIPTN)) {
            if (flg.equals("0")) {
                flg = "1";
                return 11;
            }
            else if (flg.equals("1")) {
                flg = "0";
                return 10;
            }
        }
        else if (EditKoujyonaiyouTblTest_exec.class == caller && TESTPATTERN3.equals(SYORIPTN)){
            return 10;
        }
        return super.getJyutoukaisuu();
    }

}
