package yuyu.common.biz.bzwebserviceaccesslogoutput;

import yuyu.app.bosyuu.hbkeiyakusyoukai.hbkyknaiyouosirase.HbKykNaiyouOsiraseTest_exec;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;

/**
 * {@link WebServiceAccesslogOutput}のモッククラスです。<br />
 */
public class WebServiceAccesslogOutputMockForHozen extends WebServiceAccesslogOutput {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public <T> void exec(C_AccessLogSyubetuKbn pLogKindCd, WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        T pGyoumuBean) {

        if (caller == HbKykNaiyouOsiraseTest_exec.class) {
            return ;
        }
        super.exec(pLogKindCd, pWsBzWebserviceReqParamBean, pGyoumuBean);
    }
}
