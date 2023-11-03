package yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke;

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
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwTumitatekinItenUketukeOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ積立金移転受付サービスのメイン処理（積立金移転稼動判定処理）{@link DwTumitatekinItenUketukeImpl#execPostFormKadouhantei(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwTumitatekinItenUketukeTest_execPostFormKadouhantei extends AbstractTest {

    @Inject
    private DwTumitatekinItenUketukeImpl dwTumitatekinItenUketukeImpl;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormKadouhantei.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormKadouhantei_A1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180310));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormKadouhantei(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012300", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormKadouhantei_A2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20180315));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormKadouhantei(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012000", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormKadouhantei_A3() throws Exception {


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013'}");

        String className = "";

        try {
            dwTumitatekinItenUketukeImpl.execPostFormKadouhantei(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
