package yuyu.common.biz.bzwebserviceaccesslogoutput;

import yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebServiceTest_exec;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;

/**
 * {@link WebServiceAccesslogOutput}のモッククラスです。<br />
 */
public class WebServiceAccesslogOutputMockForBiz extends WebServiceAccesslogOutput {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";


    @Override
    public <T> void exec(C_AccessLogSyubetuKbn pLogKindCd, WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        T pGyoumuBean) {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                return;
            }
        }

        super.exec(pLogKindCd, pWsBzWebserviceReqParamBean, pGyoumuBean);
    }
}
