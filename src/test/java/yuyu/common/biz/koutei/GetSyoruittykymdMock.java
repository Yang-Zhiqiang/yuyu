package yuyu.common.biz.koutei;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.moschk.HandSateiKetteiHanteiTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiHituyouSyoruiTest_exec;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link GetSyoruittykymd}のモッククラスです。<br />
 */
public class GetSyoruittykymdMock extends GetSyoruittykymd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private String flag = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BizDate exec(String pKouteiKanriId, C_SyoruiCdKbn pSyoruiCd) {
        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return null;
        }
        if (caller == HanteiHituyouSyoruiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            if (C_SyoruiCdKbn.SK_PPLESSKOKUSYO.equals(pSyoruiCd)) {
                return BizDate.valueOf(20160219);
            }
            return null;
        }
        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return null;
        }
        if (caller == SkProcessForwardMousikomisyoNyuuryokuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf(20160229);
        }
        if (caller == SkProcessForwardKokutisyoNyuuryokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf(20160302);
        }
        if (caller == SkProcessForwardTeiseiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return null;
        }
        if (caller == SkProcessForwardTeiseiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf(20160304);
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN) && flag.equals("1")) {
            flag = "2";
            return BizDate.valueOf(20160304);
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN) && flag.equals("2")) {
            flag = "1";
            return null;
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return null;
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN3.equals(SYORIPTN) && flag.equals("1")) {
            flag = "2";
            return null;
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN3.equals(SYORIPTN) && flag.equals("2")) {
            flag = "1";
            return BizDate.valueOf(20160304);
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN4.equals(SYORIPTN) && flag.equals("1")) {
            flag = "2";
            return null;
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN4.equals(SYORIPTN) && flag.equals("2")) {
            flag = "3";
            return null;
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN4.equals(SYORIPTN) && flag.equals("3")) {
            flag = "1";
            return BizDate.valueOf(20160304);
        }
        else if (caller == HandSateiKetteiHanteiTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return null;
        }
        else if (caller == SkProcessForwardToujituSeirituTorikesiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return  BizDate.valueOf(20160304);
        }
        return super.exec(pKouteiKanriId, pSyoruiCd);
    }
}