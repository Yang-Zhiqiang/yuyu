package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 充当回数計算のモッククラスです。<br />
 */
public class JtKaisukeisanMockForKhansyuu extends JtKaisukeisan {

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

        if (EditKoujyonaiyouTblTest_exec.class == caller){
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return;
            }
        }

        if (KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class == caller) {
            return;
        }
        super.exec(pIJtNensuu, pIJtGesuu, pIHhrkkaisuu);
    }
    @Override
    public int getJyutoukaisuu() {

        if (EditKoujyonaiyouTblTest_exec.class == caller){
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return 10;
            }
        }

        if (caller == KeisanZennouKoujyogakuTest_getZennouKoujyogaku.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (flg.equals("0")) {
                    flg = "1";
                    return 2;
                }
                else if (flg.equals("1")) {
                    flg = "0";
                    return 4;
                }
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                if (flg.equals("0")) {
                    flg = "1";
                    return 3;
                }
                else if (flg.equals("1")) {
                    flg = "0";
                    return 5;
                }
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                if (flg.equals("0")) {
                    flg = "1";
                    return 11;
                }
                else if (flg.equals("1")) {
                    flg = "0";
                    return 10;
                }
            }
        }
        return super.getJyutoukaisuu();
    }
}
