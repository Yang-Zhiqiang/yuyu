package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * {@link ChkSubhassoKbn}のモッククラスです。<br />
 */
public class ChkSubhassoKbnMock extends ChkSubhassoKbn {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SaisateiKbn pSaisateiKbn, String pSaikennmKj, String SaikennYno,
        String SaikenAdr1Kj, C_Tkhukaumu pTkhukaumu, C_KanryotuutioutKbn pShrDtlsyoOutKbn,
        C_HassouKbn pHassouKbn, C_InputShrhousiteiKbn pInputShrhousiteiKbn,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }

        }

        super.exec(pSaisateiKbn, pSaikennmKj, SaikennYno, SaikenAdr1Kj, pTkhukaumu, pShrDtlsyoOutKbn, pHassouKbn,
            pInputShrhousiteiKbn, pSiKykKihon, pChkKekkaBeanLst);

    }

}
