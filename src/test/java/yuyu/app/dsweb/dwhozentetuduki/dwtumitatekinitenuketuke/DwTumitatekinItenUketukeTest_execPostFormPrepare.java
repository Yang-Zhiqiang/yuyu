package yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheck;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwTumitatekinItenUketukeInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwTumitatekinItenUketukeOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ積立金移転受付サービスのメイン処理（事前準備）{@link DwTumitatekinItenUketukeImpl#execPostFormPrepare(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwTumitatekinItenUketukeTest_execPostFormPrepare {

    @Inject
    private DwTumitatekinItenUketukeImpl dwTumitatekinItenUketukeImpl;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(DsTumitatekinItenCheck.class).to(DsTumitatekinItenCheckMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormPrepare.class;
        DsDB2UtilMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormPrepare.class;
        DsTumitatekinItenCheckMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormPrepare.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        DsTumitatekinItenCheckMockForDirect.caller = null;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormPrepare_A1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormPrepare_A2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'860000017','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormPrepare_A3() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012301", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormPrepare_A4() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012302", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(50)
    public void testExecPostFormPrepare_A5() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012303", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(60)
    public void testExecPostFormPrepare_A6() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012304", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(70)
    public void testExecPostFormPrepare_A7() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012305", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(80)
    public void testExecPostFormPrepare_A8() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012306", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(90)
    public void testExecPostFormPrepare_A9() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012307", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(100)
    public void testExecPostFormPrepare_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN8;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012308", "（ＩＷＳ）ＤＳメッセージコード");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwTumitatekinItenUketukeInputBean tBean = (WsDwTumitatekinItenUketukeInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

        exStringEquals((String)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkTumitatekinIten", 0, 0), "17806000013", "証券番号");

        exDateEquals((BizDate)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkTumitatekinIten", 0, 1), BizDate.getSysDate(), "受付日");

        exDateEquals((BizDate)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkTumitatekinIten", 0, 2), BizDate.valueOf(20180316), "積立金移転予定日");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(110)
    public void testExecPostFormPrepare_A11() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        try {
            dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。ＤＳ積立金移転共通チェック結果が想定外の値です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(120)
    public void testExecPostFormPrepare_A12() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012203", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(130)
    public void testExecPostFormPrepare_A13() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012202", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(140)
    public void testExecPostFormPrepare_A14() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013'}");

        String className = "";

        try {
            dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

        Throwable throwable = (Throwable) MockObjectManager.getArgument(DsDB2UtilMockForDirect.class, "exec", 0, 0);
        exStringEquals(throwable.toString(),
            "java.lang.RuntimeException: java.lang.reflect.InvocationTargetException", "エラー");
    }

    @Test
    @TestOrder(150)
    public void testExecPostFormPrepare_A15() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormPrepare(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012000", "（ＩＷＳ）ＤＳメッセージコード");
    }
}
