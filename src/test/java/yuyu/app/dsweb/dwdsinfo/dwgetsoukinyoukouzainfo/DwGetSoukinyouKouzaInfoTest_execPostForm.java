package yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwGetSoukinyouKouzaInfoInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetSoukinyouKouzaInfoOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ送金用口座情報取得のメイン処理{@link DwGetSoukinyouKouzaInfoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwGetSoukinyouKouzaInfoTest_execPostForm {

    @Inject
    private DwGetSoukinyouKouzaInfoImpl dwGetSoukinyouKouzaInfoImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ送金用口座情報取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwGetSoukinyouKouzaInfoTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwGetSoukinyouKouzaInfoTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DwGetSoukinyouKouzaInfoTest_execPostForm.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015100", "（ＩＷＳ）ＤＳメッセージコード");

        testNull(resultBean);
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000017', 'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015100", "（ＩＷＳ）ＤＳメッセージコード");

        testNull(resultBean);
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'1Aa00000001', 'iwsSyono':'17806000013'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015100", "（ＩＷＳ）ＤＳメッセージコード");

        testNull(resultBean);
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000025', 'iwsSyono':'17806000024'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015200", "（ＩＷＳ）ＤＳメッセージコード");

        testNull(resultBean);
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000027', 'iwsSyono':'17806000013'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);


        exStringEquals(resultBean.getIwsDsmsgcd(), "015000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsBankcd(), "1001", "（ＩＷＳ）銀行コード");
        exStringEquals(resultBean.getIwsSitencd(), "009", "（ＩＷＳ）支店コード");
        exStringEquals(resultBean.getIwsBanknmkj(), "金融機関コード1001", "（ＩＷＳ）銀行名（漢字）");
        exStringEquals(resultBean.getIwsSitennmkj(), "支店コード009", "（ＩＷＳ）支店名（漢字）");
        exStringEquals(resultBean.getIwsYokinsyumoku(), "1", "（ＩＷＳ）預金種目");
        exStringEquals(resultBean.getIwsKouzano(), "KZ0000000001", "（ＩＷＳ）口座番号");
        exStringEquals(resultBean.getIwsKzdoukbn(), "2", "（ＩＷＳ）口座名義人同一区分");
        exStringEquals(resultBean.getIwsKzmeiginmkn(), "口座名義人氏名（カナ）", "（ＩＷＳ）口座名義人氏名（カナ）");
        exStringEquals(resultBean.getIwsVersion(), "100", "（ＩＷＳ）バージョン");

    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000025', 'iwsSyono':'17806000013'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsBankcd(), "1001", "（ＩＷＳ）銀行コード");
        exStringEquals(resultBean.getIwsSitencd(), "001", "（ＩＷＳ）支店コード");
        exStringEquals(resultBean.getIwsBanknmkj(), "みずほ銀行", "（ＩＷＳ）銀行名（漢字）");
        exStringEquals(resultBean.getIwsSitennmkj(), "東京支店", "（ＩＷＳ）支店名（漢字）");
        exStringEquals(resultBean.getIwsYokinsyumoku(), "1", "（ＩＷＳ）預金種目");
        exStringEquals(resultBean.getIwsKouzano(), "KZ0000000001", "（ＩＷＳ）口座番号");
        exStringEquals(resultBean.getIwsKzdoukbn(), "2", "（ＩＷＳ）口座名義人同一区分");
        exStringEquals(resultBean.getIwsKzmeiginmkn(), "口座名義人氏名（カナ）", "（ＩＷＳ）口座名義人氏名（カナ）");
        exStringEquals(resultBean.getIwsVersion(), "100", "（ＩＷＳ）バージョン");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwGetSoukinyouKouzaInfoInputBean tBean = (WsDwGetSoukinyouKouzaInfoInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

    }


    @Test
    @TestOrder(70)
    public void testExecPostForm_B1() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015203", "（ＩＷＳ）ＤＳメッセージコード");


    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_B2() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        WsDwGetSoukinyouKouzaInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetSoukinyouKouzaInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "015202", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_B3() throws Exception{

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        String className = "";

        try {
            dwGetSoukinyouKouzaInfoImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }

    private void testNull (WsDwGetSoukinyouKouzaInfoOutputBean pBean) {
        exStringEquals(pBean.getIwsBankcd(), null, "（ＩＷＳ）銀行コード");
        exStringEquals(pBean.getIwsSitencd(), null, "（ＩＷＳ）支店コード");
        exStringEquals(pBean.getIwsBanknmkj(), null, "（ＩＷＳ）銀行名（漢字）");
        exStringEquals(pBean.getIwsSitennmkj(), null, "（ＩＷＳ）支店名（漢字）");
        exStringEquals(pBean.getIwsYokinsyumoku(), null, "（ＩＷＳ）預金種目");
        exStringEquals(pBean.getIwsKouzano(), null, "（ＩＷＳ）口座番号");
        exStringEquals(pBean.getIwsKzdoukbn(), null, "（ＩＷＳ）口座名義人同一区分");
        exStringEquals(pBean.getIwsKzmeiginmkn(), null, "（ＩＷＳ）口座名義人氏名（カナ）");
        exStringEquals(pBean.getIwsVersion(), null, "（ＩＷＳ）バージョン");
    }
}
