package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link SetDNnd}のモッククラスです。<br />
 */
public class NaiteiKakuteiRateHanteiMock extends NaiteiKakuteiRateHantei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn exec(BizDate pSyoriYmd, BizDateY pDratenendo, C_UmuKbn pKessanSiyouUmu) {

        if (KeisanDGanrikinTest_exec2.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }else if (KeisanDGanrikinTest_exec3.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }else if (SetDNndTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }
        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller ||
            KeisanDCommonSibouTest_calcDShrgk.class == caller ||
            KeisanDCommonGengakuTest_calcDShrgk.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
    }

    @Override
    public C_NaiteiKakuteiKbn getNaiteiKakuteiKbn() {

        if (KeisanDGanrikinTest_exec2.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.BLNK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.KAKUTEI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.NAITEI;
            }
        }else if (KeisanDGanrikinTest_exec3.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.BLNK;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.KAKUTEI;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.NAITEI;
            }
        }else if (SetDNndTest_exec.class == caller) {
            return C_NaiteiKakuteiKbn.KAKUTEI;
        }
        if (KeisanDCommonKaiyakuTest_calcDShrgk.class == caller ||
            KeisanDCommonSibouTest_calcDShrgk.class == caller ||
            KeisanDCommonGengakuTest_calcDShrgk.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkAllhikidasi.class == caller ||
            KeisanDCommonDShrTest_calcDShrgkItibuhikidasi.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.KAKUTEI;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.NAITEI;
            }
        }
        return super.getNaiteiKakuteiKbn();
    }
}
