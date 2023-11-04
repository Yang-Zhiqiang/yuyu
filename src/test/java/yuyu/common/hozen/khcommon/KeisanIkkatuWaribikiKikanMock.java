package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 一括割引期間計算のモッククラスです。<br />
 */
public class KeisanIkkatuWaribikiKikanMock extends KeisanIkkatuWaribikiKikan{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private Integer wrbkTekikknTksu;

    private Integer wrbkTekikkngaiTksu;

    @Override
    public Integer getWrbkTekikknTksu() {
        if (caller == KeisanIkkatuNyuukinGkTest_exec.class ) {
            return wrbkTekikknTksu;
        }

        if (caller == CommonNyuukinTest_exec.class ) {
            if(SYORIPTN == null){

                return 2 ;
            }

            return wrbkTekikknTksu;
        }
        else if (caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec5.class) {
            return 2 ;
        }
        return super.getWrbkTekikknTksu();
    }

    @Override
    public Integer getWrbkTekikkngaiTksu() {
        if (caller == KeisanIkkatuNyuukinGkTest_exec.class) {
            return wrbkTekikkngaiTksu;
        }
        return super.getWrbkTekikkngaiTksu();
    }

    @Override
    public void exec(BizDate pRyosyuYmd, BizDateYM pJyuutouYm, Integer pJyuutouTukisuu) {
        if (caller == KeisanIkkatuNyuukinGkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                wrbkTekikknTksu = 0;
                wrbkTekikkngaiTksu = 0;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                wrbkTekikknTksu = 0;
                wrbkTekikkngaiTksu = 1;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                wrbkTekikknTksu = 1;
                wrbkTekikkngaiTksu = 1;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                wrbkTekikknTksu = 6;
                wrbkTekikkngaiTksu = 0;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                wrbkTekikknTksu = 11;
                wrbkTekikkngaiTksu = 0;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                wrbkTekikknTksu = 12;
                wrbkTekikkngaiTksu = 0;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                wrbkTekikknTksu = 10;
                wrbkTekikkngaiTksu = 2;
            }
        }
        else if (caller == CommonNyuukinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                wrbkTekikknTksu = 2;
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                wrbkTekikknTksu = 3;
                return;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                wrbkTekikknTksu = 4;
                return;
            }
        }

        super.exec(pRyosyuYmd, pJyuutouYm, pJyuutouTukisuu);
    }

}
