package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link SetDNnd}のモッククラスです。<br />
 */
public class CheckDJyoutaiMock extends CheckDJyoutai{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_HaitoujyoutaiHanteiKbn execForHaitouJyoutaiHantei(
        BizDate pHanteikijyunymd,
        BizDate pKeiyakuymd,
        BizDate pEndataihenkoymd,
        BizDateY pHaitounendo) {
        if (CheckDShrGengakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.BLNK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }
        }
        if (CheckDShrKaiyakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.BLNK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }
        }
        if (CheckDShrSibouTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.BLNK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }
        }
        if (CheckDShrDShrTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.BLNK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }
        }
        if (CheckDShrYendtHnkuketukeTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.BLNK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI;
            }
        }
        return super.execForHaitouJyoutaiHantei(pHanteikijyunymd, pKeiyakuymd, pEndataihenkoymd, pHaitounendo);
    }

    @Override
    public C_UmuKbn execForMibaraiHaitouHantei(
        BizDate pHanteikijyunymd,
        BizDate pKeiyakuymd,
        BizDate pEndataihenkoymd,
        BizDateY pHaitounendo) {
        if (CheckDShrGengakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrKaiyakuTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrSibouTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrDShrTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        if (CheckDShrYendtHnkuketukeTest_checkDShr.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_UmuKbn.ARI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_UmuKbn.NONE;
            }
        }
        return super.execForMibaraiHaitouHantei(pHanteikijyunymd, pKeiyakuymd, pEndataihenkoymd, pHaitounendo);
    }
}
