package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * （商品単位）未収Ｐ・未経過Ｐ計算のモッククラスです。<br />
 */
public class SyouhnTaniKeisanMsyMkeiPMock extends SyouhnTaniKeisanMsyMkeiP {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private String flag = "";

    @Override
    public BizCurrency getMikeikaP() {
        if (caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(100);
        }
        return super.getMikeikaP();
    }

    @Override
    public void exec() {
        if (caller == EditKoujyonaiyouTblTest_exec.class) {
            return;
        }
        super.exec();

    }

}
