package yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke;

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
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ解約受付のメイン処理（ＤＳ解約稼動判定）{@link DwKaiyakuUketukeImpl#execPostFormKadouhantei(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwKaiyakuUketukeTest_execPostFormKadouhantei extends AbstractTest {

    @Inject
    private DwKaiyakuUketukeImpl dwKaiyakuUketukeImpl;

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
        WebServiceAccesslogOutputMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormPrepare.class;
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

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormKadouhantei(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013014", "（ＩＷＳ）ＤＳメッセージコード");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwDsKaiyakuUktkInputBean tBean = (WsDwDsKaiyakuUktkInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormKadouhantei_A2() throws Exception {
        changeSystemDate(BizDate.valueOf("20180113"));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormKadouhantei(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013014", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsShrgkkeiyen(), null, "（ＩＷＳ）支払額合計（円貨）");
        exStringEquals(resultBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(resultBean.getIwsYendthnkhr(), null, "（ＩＷＳ）円建変更時返戻金");
        exStringEquals(resultBean.getIwsGstszeigkyen(), null, "（ＩＷＳ）源泉徴収税額（円貨）");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormKadouhantei_A3() throws Exception {
        changeSystemDate(BizDate.valueOf("20180112"));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormKadouhantei(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013000", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormKadouhantei_B1() throws Exception{

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        String className = "";

        try {
            dwKaiyakuUketukeImpl.execPostFormKadouhantei(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
