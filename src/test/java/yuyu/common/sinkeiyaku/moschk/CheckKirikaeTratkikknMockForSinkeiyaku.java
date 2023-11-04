package yuyu.common.sinkeiyaku.moschk;

/**
 * 商品切替取扱期間チェック{@link CheckKirikaeTratkikkn}のモッククラスです。<br />
 */
public class CheckKirikaeTratkikknMockForSinkeiyaku extends CheckKirikaeTratkikkn {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            return;
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            return;
        }

        super.exec(pMp);
    }
}