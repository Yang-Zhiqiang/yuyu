package yuyu.common.sinkeiyaku.moschk;

import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 払込回数チェック{@link CheckHrkKaisuu}のモッククラスです。<br />
 */
public class CheckHrkKaisuuMockForSinkeiyaku extends CheckHrkKaisuu {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(MosnaiCheckParam pMp, BM_SyouhnZokusei pSyouhinZokusei) {

        if (caller == CheckTblMosKihonTest_exec1.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
        }
        if (caller == CheckTblMosKihonTest_exec2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
                return;
            }
        }

        super.exec(pMp, pSyouhinZokusei);
    }
}

