package yuyu.common.biz.bzwebserviceaccesslogoutput;

import yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrateTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzanTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosnoTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo.DwGetSoukinyouKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenhokenryohurikaekouzainfo.DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai.DwGetHozenKeiyakuSyousaiTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke.DwDenwaKaiyakuUketukeTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormKadouhantei;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormKadouhantei;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormPrepare;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormUpdate;
import yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou.DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;

/**
 * {@link WebServiceAccesslogOutput}のモッククラスです。<br />
 */
public class WebServiceAccesslogOutputMock extends WebServiceAccesslogOutput {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    @Override
    public <T> void exec(C_AccessLogSyubetuKbn pLogKindCd, WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        T pGyoumuBean) {
        if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return;
        }

        if (caller == DwGetHozenKeiyakuSyousaiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwGetSoukinyouKouzaInfoTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormUpdate.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormKadouhantei.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwTumitatekinItenUketukeTest_execPostFormPrepare.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwTumitatekinItenUketukeTest_execPostFormUpdate.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwTumitatekinItenUketukeTest_execPostFormKadouhantei.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class) {
            return;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN4.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        if (caller == DwRealTimeMailSousin_execPostFormPrepare.class ||
            caller == DwRealTimeMailSousin_execPostFormUpdate.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        if (caller == HbNyknkwsrateTest_execPostForm.class) {
            return;
        }

        if (caller == HbSeihoWebMosnoTest_execPostForm.class) {
            return;
        }

        if (caller == HbSeihoWebGaikaKanzanTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pLogKindCd, pWsBzWebserviceReqParamBean, pGyoumuBean);
    }
}
