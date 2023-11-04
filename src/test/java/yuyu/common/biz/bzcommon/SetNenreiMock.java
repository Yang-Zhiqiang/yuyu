package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase3Test_editInfo;
import yuyu.common.siharai.sicommon.SiSetUiBeanTest_setMskmjSkjNen;
import yuyu.common.sinkeiyaku.moschk.CheckHokenRyouYuukouKigenTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;

/**
 * {@link SetNenrei}のモッククラスです。<br />
 */
public class SetNenreiMock extends SetNenrei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public int exec(BizDate pKijyunYmd, BizDate pBirthday) {

        if (caller == SetKisoKoumokuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                == BizDateUtil.COMPARE_EQUAL) {
                return 5;
            }
            else {
                return 4;
            }
        }
        else if (caller == SetKisoKoumokuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)){
            if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                == BizDateUtil.COMPARE_EQUAL) {
                return 6;
            }
            else {
                return 5;
            }
        }
        else if (caller == SetKisoKoumokuTest_exec.class && TESTPATTERN3.equals(SYORIPTN)){
            if (BizDateUtil.compareYmd(BizDate.valueOf("20101010"), pBirthday)
                == BizDateUtil.COMPARE_EQUAL) {
                return 6;
            }
            else {
                return 4;
            }
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return 35;
        }
        else if (caller == SiSetUiBeanTest_setMskmjSkjNen.class && TESTPATTERN1.equals(SYORIPTN)) {
            if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf("20160101")) == BizDateUtil.COMPARE_EQUAL) {
                return 15;
            }
            else if (BizDateUtil.compareYmd(pKijyunYmd, BizDate.valueOf("20160102")) == BizDateUtil.COMPARE_EQUAL) {
                return 16;
            }
            else {
                return 0;
            }
        }

        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return 20;
        }
        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return 35;
        }

        else if (caller == CheckHokenRyouYuukouKigenTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return 99;
        }

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN5.equals(SYORIPTN)) {
            return 99;
        }
        else if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller && TESTPATTERN1.equals(SYORIPTN)) {
            return 43;
        }
        else if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller && TESTPATTERN1.equals(SYORIPTN)) {
            return 43;
        }
        else if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller && TESTPATTERN1.equals(SYORIPTN)) {
            return 60;
        }
        else if (HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class == caller && TESTPATTERN1.equals(SYORIPTN)) {
            return 8;

        }
        else if (HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class == caller && TESTPATTERN2.equals(SYORIPTN)) {
            return 9;

        }
        else if (HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class == caller && TESTPATTERN3.equals(SYORIPTN)) {
            return 10;

        }
        else if (EditKykNaiyouOsirase3Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 11;
            }
            else {
                return 0;
            }
        }
        else {
            return super.exec(pKijyunYmd, pBirthday);
        }
    }

    @Override
    public int getNkshrStartNenrei(int pHhknnen, int pHknkkn) {
        if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 10;
            }
            else {
                return 0;
            }
        }
        else {
            return super.getNkshrStartNenrei(pHhknnen, pHknkkn);
        }
    }

}