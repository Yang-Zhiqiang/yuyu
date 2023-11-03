package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.sinkeiyaku.moschk.CheckHokenRyouYuukouKigenTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;

/**
 * {@link SetNenrei}のモッククラスです。<br />
 */
public class SetNenreiMockForSinkeiyaku extends SetNenrei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        if (caller == SetKisoKoumokuTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                    == BizDateUtil.COMPARE_EQUAL) {
                    return 5;
                }
                return 4;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)){
                if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                    == BizDateUtil.COMPARE_EQUAL) {
                    return 6;
                }
                return 5;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)){
                if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                    == BizDateUtil.COMPARE_EQUAL) {
                    return 6;
                }
                return 4;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)){
                if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                    == BizDateUtil.COMPARE_EQUAL) {
                    return 93;
                }
                return 4;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)){
                if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                    == BizDateUtil.COMPARE_EQUAL) {
                    return 94;
                }
                return 5;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)){
                if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                    == BizDateUtil.COMPARE_EQUAL) {
                    return 95;
                }
                return 4;
            }
        }

        if (caller == CheckHokenRyouYuukouKigenTest_exec.class ){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 20;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 35;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 99;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return 95;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return 93;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                return 92;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                return 94;
            }
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 8;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 9;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 10;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return 99;
            }

        }
        return super.exec(pKijyunYmd, pBirthday);
    }

    @Override
    public int getNkshrStartNenrei(int pHhknnen, int pHknkkn) {
        return super.getNkshrStartNenrei(pHhknnen, pHknkkn);
    }
}