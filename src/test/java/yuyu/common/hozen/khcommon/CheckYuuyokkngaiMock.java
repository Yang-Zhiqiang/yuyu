package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.app.dsweb.dwninsyou.dwlogin.DwLoginTest_execPostForm;
import yuyu.common.direct.dscommon.CheckDsKaiyakuTest_kaiyakukytChk;
import yuyu.common.direct.dscommon.DsKokyakuYuukouKeiyakuHanteiTest_exec;
import yuyu.common.siharai.chksk.ChkSubPHrkmYuuyokknTest_exec;

/**
 * {@link CheckYuuyokkngai}のモッククラスです。<br />
 */
public class CheckYuuyokkngaiMock extends CheckYuuyokkngai {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public boolean exec(String pSyono, BizDate pDate) {

        if (caller == ChkSubPHrkmYuuyokknTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return false;
        }
        else if (caller == ChkSubPHrkmYuuyokknTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return true;
        }

        if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == CheckDsKaiyakuTest_kaiyakukytChk.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }

        if (caller == DwLoginTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == DwLoginTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }

        if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }

        if (caller == DsKokyakuYuukouKeiyakuHanteiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return true;
        }
        else if (caller == DsKokyakuYuukouKeiyakuHanteiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return false;
        }
        return super.exec(pSyono, pDate);
    }
}
