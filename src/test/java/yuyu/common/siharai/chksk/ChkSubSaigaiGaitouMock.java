package yuyu.common.siharai.chksk;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * {@link ChkSubSaigaiGaitou}のモッククラスです。<br />
 */
public class ChkSubSaigaiGaitouMock extends ChkSubSaigaiGaitou{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(BizDate pHanteiKijyunYmd, List<String> pByoumeiTourokuNoLst, C_GeninKbn pGeninKbn,
        C_UmuKbn pSateiKakSaigaiKanouseiKbn, BM_SyouhnZokusei pSyouhnZokusei, JT_SiKykSyouhn pSiKykSyouhn,
        JT_SkKihon pSkKihon, Boolean pSateiChkFlg, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pHanteiKijyunYmd, pByoumeiTourokuNoLst, pGeninKbn, pSateiKakSaigaiKanouseiKbn, pSyouhnZokusei,
            pSiKykSyouhn, pSkKihon, pSateiChkFlg, pChkKekkaBeanLst);

    }

}
