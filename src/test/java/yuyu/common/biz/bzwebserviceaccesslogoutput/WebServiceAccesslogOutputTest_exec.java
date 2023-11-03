package yuyu.common.biz.bzwebserviceaccesslogoutput;
import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import net.arnx.jsonic.JSON;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKeiyakuSyoukaiWebServiceInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebKaiyakuhrSuiiInputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwHonninKakuninInputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * WEBサービスアクセスログ出力クラスのメソッド {@link WebServiceAccesslogOutput#exec(String, String, WsBzWebserviceReqParamBean, Map<String, String>)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class WebServiceAccesslogOutputTest_exec extends AbstractTest{

    @Inject
    private WebServiceAccesslogOutput webServiceAccesslogOutput;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("");

        WsHbSeihoWebKaiyakuhrSuiiInputBean wsHbSeihoWebKaiyakuhrSuiiInputBean =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbSeihoWebKaiyakuhrSuiiInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebKaiyakuhrSuiiInputBean);

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsSyono11keta:\"12345678901\"");

        WsHbKeiyakuSyoukaiWebServiceInputBean wsHbKeiyakuSyoukaiWebServiceInputBean =
            JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbKeiyakuSyoukaiWebServiceInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbKeiyakuSyoukaiWebServiceInputBean);
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("a201601011201612312a012016070120161115201610bcd123456789123456789012323456789013456789012345341111122d1d2d3d4d5045678901234444415555011");

        WsHbSeihoWebKaiyakuhrSuiiInputBean wsHbSeihoWebKaiyakuhrSuiiInputBean =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbSeihoWebKaiyakuhrSuiiInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebKaiyakuhrSuiiInputBean);
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsSyono:\"12345678901\",iwsDskokno:\"0123456789\",iwsNmkn:\"あいうえおかきくけこさしすせそたちつ\",iwsSeiymd:\"19740812\",iwsTelnosimo4:null");

        WsDwHonninKakuninInputBean wsDwHonninKakuninInputBean =
            JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsDwHonninKakuninInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_END, wsBzWebserviceReqParamBean, wsDwHonninKakuninInputBean);
    }

}