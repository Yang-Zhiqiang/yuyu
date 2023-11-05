package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.hozen.khcommon.EditMinyuuTuutiTest_editTBL;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL1;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL2;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtlTest_createTyouhyouTBL;
import yuyu.common.sinkeiyaku.skcommon.EditPdfTrksseikyuTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfYoteirirtuTest_exec;

/**
 * {@link BzGetSosikiMadogutiInfo}のモッククラスです。<br />
 */
public class BzGetSosikiMadogutiInfoMock extends BzGetSosikiMadogutiInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetSosikiMadogutiInfoKekkaBean exec(String pSosikicd) {

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = SWAKInjector
            .getInstance(BzGetSosikiMadogutiInfoKekkaBean.class);

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("漢字組織名１");
                bzGetSosikiMadogutiInfoKekkaBean.setPostalCd("1231234");
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr1("漢字組織住所１");
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr2("漢字組織住所２");
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr3("漢字組織住所３");
                bzGetSosikiMadogutiInfoKekkaBean.setTelno("99-9999-1234");

                return bzGetSosikiMadogutiInfoKekkaBean;
            }
        }
        else if (caller == EditPdfTrksseikyuTest_exec.class) {

            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("組織窓口用漢字組織名");
            bzGetSosikiMadogutiInfoKekkaBean.setPostalCd("444-8888");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("2");
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr1("組織窓口用漢字組織住所１");
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr2("組織窓口用漢字組織住所２");

            return bzGetSosikiMadogutiInfoKekkaBean;
        }
        else if (caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editTBL1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("漢字組織名０１組織区分名０１");
                bzGetSosikiMadogutiInfoKekkaBean.setPostalCd("777-8888");
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr1("漢字組織住所１１");
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr2("漢字組織住所２１");
                bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr3("漢字組織住所３１");
                bzGetSosikiMadogutiInfoKekkaBean.setTelno("111-2222-3333");

                return bzGetSosikiMadogutiInfoKekkaBean;
            }
            return super.exec(pSosikicd);
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN7.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        else if (caller == EditPdfYoteirirtuTest_exec.class && TESTPATTERN8.equals(SYORIPTN)) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("代理店契約室");
            bzGetSosikiMadogutiInfoKekkaBean.setHassoukbn("1");
            return bzGetSosikiMadogutiInfoKekkaBean;
        }
        else if (caller == EditMinyuuTuutiTest_editTBL.class) {
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikinm("漢字組織名０１組織区分名０１");
            bzGetSosikiMadogutiInfoKekkaBean.setPostalCd("777-8888");
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr1("漢字組織住所１１");
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr2("漢字組織住所２１");
            bzGetSosikiMadogutiInfoKekkaBean.setKanjisosikiadr3("漢字組織住所３１");
            bzGetSosikiMadogutiInfoKekkaBean.setTelno("111-2222-3333");

            return bzGetSosikiMadogutiInfoKekkaBean;
        }

        return super.exec(pSosikicd);
    }
}
