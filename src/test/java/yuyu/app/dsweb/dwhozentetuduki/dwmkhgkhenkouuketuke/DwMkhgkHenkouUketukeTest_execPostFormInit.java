package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.CheckDsMkhgkHenkou;
import yuyu.common.direct.dscommon.CheckDsMkhgkHenkouMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwMkhgkHenkouUketukeInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwMkhgkHenkouUketukeOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ目標額変更受付のメイン処理（初期処理）{@link DwMkhgkHenkouUketukeImpl#execPostFormInit(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwMkhgkHenkouUketukeTest_execPostFormInit {

    @Inject
    private DwMkhgkHenkouUketukeImpl dwMkhgkHenkouUketukeImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ目標額変更受付";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(CheckDsMkhgkHenkou.class).to(CheckDsMkhgkHenkouMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwMkhgkHenkouUketukeTest_execPostFormCheckUktk.class;
        DsDB2UtilMockForDirect.caller = DwMkhgkHenkouUketukeTest_execPostFormInit.class;
        CheckDsMkhgkHenkouMockForDirect.caller = DwMkhgkHenkouUketukeTest_execPostFormInit.class;

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        CheckDsMkhgkHenkouMockForDirect.caller = null;
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DwMkhgkHenkouUketukeTest_execPostFormInit.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormInit_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021100", "（ＩＷＳ）ＤＳメッセージコード");
    }


    @Test
    @TestOrder(20)
    public void testExecPostFormInit_A2() throws Exception {

        MockObjectManager.initialize();

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
               + "'iwsHenkougomkhgkwari':'8600000026'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021100", "（ＩＷＳ）ＤＳメッセージコード");
    }


    @Test
    @TestOrder(30)
    public void testExecPostFormInit_A3() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
        exStringEquals(resultBean.getIwsTtdktyuumkhgkwari(), "999", "（ＩＷＳ）手続き中目標額割合");
        exStringEquals(resultBean.getIwsMkhgkwarihnkkanouhani(), null, "（ＩＷＳ）目標額割合変更可能範囲");
        exStringEquals(resultBean.getIwsDispmkhgkwari(), "基準金額の　1　％", "（ＩＷＳ）目標額割合（表示用）");
        exStringEquals(resultBean.getIwsDispttdktyuumkhgkwari(), "（指定なしへ変更お手続き中）", "（ＩＷＳ）手続き中目標額割合（表示用）");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwMkhgkHenkouUketukeInputBean tBean = (WsDwMkhgkHenkouUketukeInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

        MockObjectManager.assertArgumentPassed(CheckDsMkhgkHenkouMockForDirect.class, "chkMkhgkHnkSyoriKahi", 0, "10806000016");
    }

    @Test
    @TestOrder(31)
    public void testExecPostFormInit_A3_1() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111509'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111509", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
        exStringEquals(resultBean.getIwsTtdktyuumkhgkwari(), "", "（ＩＷＳ）手続き中目標額割合");
        exStringEquals(resultBean.getIwsMkhgkwarihnkkanouhani(), null, "（ＩＷＳ）目標額割合変更可能範囲");
        exStringEquals(resultBean.getIwsDispmkhgkwari(), "基準金額の　1　％", "（ＩＷＳ）目標額割合（表示用）");
        exStringEquals(resultBean.getIwsDispttdktyuumkhgkwari(), "", "（ＩＷＳ）手続き中目標額割合（表示用）");

    }

    @Test
    @TestOrder(40)
    public void testExecPostFormInit_A4() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021300", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");

    }

    @Test
    @TestOrder(50)
    public void testExecPostFormInit_A5() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021301", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");

    }

    @Test
    @TestOrder(60)
    public void testExecPostFormInit_A6() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021307", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");

    }

    @Test
    @TestOrder(70)
    public void testExecPostFormInit_A7() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021303", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");

    }

    @Test
    @TestOrder(80)
    public void testExecPostFormInit_A8() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021304", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");

    }

    @Test
    @TestOrder(90)
    public void testExecPostFormInit_A9() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021203", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000016", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");

    }

    @Test
    @TestOrder(100)
    public void testExecPostFormInit_A10() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN8;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000016'}");

        try{
            dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。ＤＳ目標額変更共通チェック結果が想定外の値です。", "メッセージ内容");
        }

    }

    @Test
    @TestOrder(110)
    public void testExecPostFormInit_A11() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000038'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000038", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
        exStringEquals(resultBean.getIwsTtdktyuumkhgkwari(), "", "（ＩＷＳ）手続き中目標額割合");
        exStringEquals(resultBean.getIwsMkhgkwarihnkkanouhani(), null, "（ＩＷＳ）目標額割合変更可能範囲");
        exStringEquals(resultBean.getIwsDispmkhgkwari(), "指定なし", "（ＩＷＳ）目標額割合（表示用）");
        exStringEquals(resultBean.getIwsDispttdktyuumkhgkwari(), "", "（ＩＷＳ）手続き中目標額割合（表示用）");

    }

    @Test
    @TestOrder(120)
    public void testExecPostFormInit_A12() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10806000049'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "10806000049", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
        exStringEquals(resultBean.getIwsTtdktyuumkhgkwari(), "130", "（ＩＷＳ）手続き中目標額割合");
        exStringEquals(resultBean.getIwsMkhgkwarihnkkanouhani(), null, "（ＩＷＳ）目標額割合変更可能範囲");
        exStringEquals(resultBean.getIwsDispmkhgkwari(), "基準金額の　1　％", "（ＩＷＳ）目標額割合（表示用）");
        exStringEquals(resultBean.getIwsDispttdktyuumkhgkwari(), "（130％へ変更お手続き中）", "（ＩＷＳ）手続き中目標額割合（表示用）");

    }

    @Test
    @TestOrder(130)
    public void testExecPostFormInit_A13() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111325'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111325", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
        exStringEquals(resultBean.getIwsTtdktyuumkhgkwari(), "130", "（ＩＷＳ）手続き中目標額割合");
        exStringEquals(resultBean.getIwsMkhgkwarihnkkanouhani(), null, "（ＩＷＳ）目標額割合変更可能範囲");
        exStringEquals(resultBean.getIwsDispmkhgkwari(), "円建基準金額の　1　％", "（ＩＷＳ）目標額割合（表示用）");
        exStringEquals(resultBean.getIwsDispttdktyuumkhgkwari(), "（130％へ変更お手続き中）", "（ＩＷＳ）手続き中目標額割合（表示用）");

    }

    @Test
    @TestOrder(140)
    public void testExecPostFormInit_B1() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021202", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(150)
    public void testExecPostFormInit_B2() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021201", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(160)
    public void testExecPostFormInit_B3() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        String className = "";

        try {
            dwMkhgkHenkouUketukeImpl.execPostFormInit(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, null, "例外");

    }
}
