package yuyu.common.sinkeiyaku.moschk;

import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * リビングニーズ付加有無チェック{@link CheckLivHuka}のモッククラスです。<br />
 */
public class CheckLivHukaMockForSinkeiyaku extends CheckLivHuka {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp, BM_SyouhnZokusei pSyouhinZokusei) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            return;
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            return;
        }

        super.exec(pMp, pSyouhinZokusei);
    }
}
