package yuyu.app.dsweb.dwmail.dwrealtimemailsousin;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsSaibanSyoriMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwRealTimeMailSousinInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwRealTimeMailSousinOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * DSリアルタイムメール送信のメイン処理{@link DwRealTimeMailSousinImpl#execPostFormPrepare(MultivaluedMap<String, String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwRealTimeMailSousin_execPostFormPrepare extends AbstractTest {

    @Inject
    private DwRealTimeMailSousinImpl dwRealTimeMailSousinImpl;

    @Inject
    private static Logger logger;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DsSaibanSyori.class).to(DsSaibanSyoriMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        DsSaibanSyoriMockForDirect.caller = DwRealTimeMailSousin_execPostFormPrepare.class;
        DsDB2UtilMockForDirect.caller = DwRealTimeMailSousin_execPostFormPrepare.class;
        WebServiceAccesslogOutputMockForDirect.caller = DwRealTimeMailSousin_execPostFormPrepare.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        DsSaibanSyoriMockForDirect.caller = null;
        DsSaibanSyoriMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormPrepare_A1() throws Exception {

        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20180508"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormPrepare(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsSousinymd(), "2018-05-08", "（ＩＷＳ）送信日");

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsSakujyoymd(), "2018-05-10", "（ＩＷＳ）削除日");

        logger.info("（ＩＷＳ）ＤＳ送信番号：" + wsDwRealTimeMailSousinOutputBean.getIwsDssousinno());

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwRealTimeMailSousinInputBean tBean = (WsDwRealTimeMailSousinInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

        String key = (String)MockObjectManager
            .getArgument(DsSaibanSyoriMockForDirect.class, "saibanRealTimeMailDsSousinNoRenban", 0, 0);
        exStringEquals(key, "20180508", "キー項目");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormPrepare_A2() throws Exception {

        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20180517"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormPrepare(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsSakujyoymd(), "2018-05-21", "（ＩＷＳ）削除日");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormPrepare_A3() throws Exception {

        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20181227"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormPrepare(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsSakujyoymd(), "2019-01-04", "（ＩＷＳ）削除日");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormPrepare_B1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormPrepare(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016203", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(50)
    public void testExecPostFormPrepare_B2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormPrepare(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016202", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(60)
    public void testExecPostFormPrepare_B3() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDssousinmailsyubetukbn':'10200'}");

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormPrepare(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

        Throwable throwable = (Throwable) MockObjectManager.getArgument(DsDB2UtilMockForDirect.class, "exec", 0, 0);
        exStringEquals(throwable.toString(),
            "java.lang.RuntimeException: java.lang.reflect.InvocationTargetException", "エラー");
    }
}
