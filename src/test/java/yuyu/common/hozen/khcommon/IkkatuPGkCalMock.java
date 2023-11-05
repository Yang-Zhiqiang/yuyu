package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * {@link IkkatuPGkCal}のモッククラスです。<br />
 */
public class IkkatuPGkCalMock extends IkkatuPGkCal {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizCurrency getIkkatuP() {
        if(caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizCurrency.valueOf(80);
        }
        else if(caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizCurrency.valueOf(0);
        }
        else if(caller == EditKoujyonaiyouTblTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizCurrency.valueOf(-10);
        }

        return super.getIkkatuP();
    }

    @Override
    public void exec() {

        if(caller == EditKoujyonaiyouTblTest_exec.class){
            return;
        }

        super.exec();
    }

}
