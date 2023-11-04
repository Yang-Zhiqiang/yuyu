package yuyu.common.biz.bzwebserviceaccesslogoutput;

import yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrateTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyounoTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzanTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosnoTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisanTest_execPostForm;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;

/**
 * {@link WebServiceAccesslogOutput}のモッククラスです。<br />
 */
public class WebServiceAccesslogOutputMockForSinkeiyaku extends WebServiceAccesslogOutput {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN4 = "4";


    @Override
    public <T> void exec(C_AccessLogSyubetuKbn pLogKindCd, WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        T pGyoumuBean) {

        if (caller == HbSeihoWebCreditkessaiyounoTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                return;
            }
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return;
        }
        if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class) {
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
        if (caller == HbNyknkwsrateTest_execPostForm.class) {
            return;
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if(TESTPATTERN4.equals(SYORIPTN)) {
                return;
            }
        }
        if (caller == HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        if (caller == HbSeihoWebZennouKeisanTest_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pLogKindCd, pWsBzWebserviceReqParamBean, pGyoumuBean);
    }
}
