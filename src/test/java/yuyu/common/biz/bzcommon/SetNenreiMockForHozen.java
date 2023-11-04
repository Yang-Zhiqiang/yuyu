package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase5Test_editInfo;
import yuyu.common.hozen.khcommon.HasseijikziEditShrtyousyotblTest_exec;

/**
 * {@link SetNenrei}のモッククラスです。<br />
 */
public class SetNenreiMockForHozen extends SetNenrei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 11;
            }
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return 35;
        }

        else if (HasseijikziEditShrtyousyotblTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 98;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return 99;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return 100;
            }
        }

        return super.exec(pKijyunYmd, pBirthday);
    }

    @Override
    public int getNkshrStartNenrei(int pHhknnen, int pHknkkn) {

        if (EditKykNaiyouOsirase5Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 11;
            }
        }
        else if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 10;
            }
            return 0;
        }

        return super.getNkshrStartNenrei(pHhknnen, pHknkkn);
    }
}