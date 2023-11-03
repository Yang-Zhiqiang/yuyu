package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL5;

/**
 * {@link BzGetSosikiMadogutiInfo}のモッククラスです。<br />
 */
public class BzGetSosikiMadogutiInfoMockForHozen extends BzGetSosikiMadogutiInfo {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public BzGetSosikiMadogutiInfoKekkaBean exec(String pSosikicd) {

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = SWAKInjector
            .getInstance(BzGetSosikiMadogutiInfoKekkaBean.class);

        if (caller == EditTtdkKanryouTblTest_editTBL5.class) {
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
