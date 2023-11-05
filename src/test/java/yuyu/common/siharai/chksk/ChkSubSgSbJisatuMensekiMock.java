package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * {@link ChkSubSgSbJisatuMenseki}のモッククラスです。<br />
 */
public class ChkSubSgSbJisatuMensekiMock extends ChkSubSgSbJisatuMenseki {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, BizDate pHkSknnKaisiYmd, JT_SiKykSyouhn pSiKykSyouhn,
        C_GeninKbn pGeninKbn, List<String> pByoumeiTourokuNoLst, C_UmuKbn pSateiKakSaigaiKanouseiKbn,
        JT_SkKihon pSkKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pHanteiKijyunYmd, pHkSknnKaisiYmd, pSiKykSyouhn, pGeninKbn, pByoumeiTourokuNoLst,
            pSateiKakSaigaiKanouseiKbn, pSkKihon, pChkKekkaBeanLst);
    }

}
