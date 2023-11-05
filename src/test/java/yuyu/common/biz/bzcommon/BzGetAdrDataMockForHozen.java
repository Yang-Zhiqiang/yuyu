package yuyu.common.biz.bzcommon;

import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TodouhukenKbn;

/**
 * 住所情報取得クラス{@link BzGetAdrData}のモッククラスです。<br />
 */
public class BzGetAdrDataMockForHozen extends BzGetAdrData{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private C_ErrorKbn errorKbn;

    private String adrknBlankAri;

    @Override
    public void execAdrKanaBlankAriByPostalcd(String pPostalCd) {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                errorKbn = C_ErrorKbn.OK;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {
                errorKbn = C_ErrorKbn.ERROR;
            }
        }

        super.execAdrKanaBlankAriByPostalcd(pPostalCd);
    }

    @Override
    public C_ErrorKbn getErrorKbn() {

        if (caller == HbKeiyakuSyoukaiTest_exec.class) {
            return errorKbn;
        }
        return super.getErrorKbn();
    }

    @Override
    public String getAdrKanaBlankAri() {

        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            adrknBlankAri = "カナカナカナカナ";
            return adrknBlankAri;
        }

        return super.getAdrKanaBlankAri();
    }

    @Override
    public void execTodouhukenCdByPostalcd(String pPostalCd) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        super.execTodouhukenCdByPostalcd(pPostalCd);
    }

    @Override
    public C_TodouhukenKbn getTodouhukenCd() {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_TodouhukenKbn.HOKKAIDOU;
            }
        }
        return super.getTodouhukenCd();
    }
}
