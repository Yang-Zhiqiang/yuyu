package yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
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
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.CheckDsKaiyakuMockForDirect;
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.CheckDsTorihikiServiceMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ解約受付のメイン処理（事前準備）{@link DwKaiyakuUketukeImpl#execPostFormPrepare(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwKaiyakuUketukeTest_execPostFormPrepare extends AbstractTest {

    @Inject
    private DwKaiyakuUketukeImpl dwKaiyakuUketukeImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ解約受付";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(CheckDsKaiyaku.class).to(CheckDsKaiyakuMockForDirect.class);
                bind(CheckDsTorihikiService.class).to(CheckDsTorihikiServiceMockForDirect.class);
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormPrepare.class;
        DsDB2UtilMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormPrepare.class;
        CheckDsKaiyakuMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormPrepare.class;
        CheckDsTorihikiServiceMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormPrepare.class;
        KeisanCommonKaiyakuMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormPrepare.class;

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        CheckDsKaiyakuMockForDirect.caller = null;
        CheckDsKaiyakuMockForDirect.SYORIPTN = null;
        CheckDsTorihikiServiceMockForDirect.caller = null;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = null;
        KeisanCommonKaiyakuMockForDirect.caller = null;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DwKaiyakuUketukeTest_execPostFormPrepare.class, fileName, sheetName);

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

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormPrepare_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormPrepare_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', 'iwsDskokno':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormPrepare_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
            + "'iwsDskokno':'8600000026', "
            + "'iwsDssyouhnbunruikbn':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(50)
    public void testExecPostFormPrepare_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
            + "'iwsDskokno':'8600000026', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(60)
    public void testExecPostFormPrepare_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
            + "'iwsDskokno':'8600000026', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(70)
    public void testExecPostFormPrepare_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
            + "'iwsDskokno':'1Aa00000001', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(80)
    public void testExecPostFormPrepare_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
            + "'iwsDskokno':'8600000026', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013200", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(90)
    public void testExecPostFormPrepare_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013201", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(100)
    public void testExecPostFormPrepare_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'USD', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013007", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(110)
    public void testExecPostFormPrepare_A11() throws Exception {
        changeSystemDate(BizDate.valueOf(20200330));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'USD', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013001", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(120)
    public void testExecPostFormPrepare_A12() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013002", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(130)
    public void testExecPostFormPrepare_A13() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013016", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(140)
    public void testExecPostFormPrepare_A14() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN4;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016',"
            + " 'iwsDskokno':'8600000025',"
            + " 'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013015", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(150)
    public void testExecPostFormPrepare_A15() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN5;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013003", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(160)
    public void testExecPostFormPrepare_A16() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN6;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013004", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(170)
    public void testExecPostFormPrepare_A17() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN7;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013005", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(180)
    public void testExecPostFormPrepare_A18() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN8;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        try{
            dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。ＤＳ解約共通チェック結果が想定外の値です。", "メッセージ内容");
        }
    }

    @Test
    @TestOrder(190)
    public void testExecPostFormPrepare_A19() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016',"
            + " 'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013008", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(200)
    public void testExecPostFormPrepare_A20() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016',"
            + " 'iwsDskokno':'8600000024', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013009", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(210)
    public void testExecPostFormPrepare_A21() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1',"
            + " 'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013010", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(211)
    public void testExecPostFormPrepare_A211() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000049', "
            + "'iwsDskokno':'8600000027', "
            + "'iwsDssyouhnbunruikbn':'1',"
            + " 'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013206", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(212)
    public void testExecPostFormPrepare_A212() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000061', "
            + "'iwsDskokno':'8600000028', "
            + "'iwsDssyouhnbunruikbn':'1',"
            + " 'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013206", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(213)
    public void testExecPostFormPrepare_A213() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000072', "
            + "'iwsDskokno':'8600000029', "
            + "'iwsDssyouhnbunruikbn':'1',"
            + " 'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013206", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(220)
    public void testExecPostFormPrepare_A22() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013011", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(230)
    public void testExecPostFormPrepare_A23() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013012", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(240)
    public void testExecPostFormPrepare_A24() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN4;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013013", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(250)
    public void testExecPostFormPrepare_A25() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN5;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013017", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(260)
    public void testExecPostFormPrepare_A26() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN6;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        try{
            dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。送金用口座正当性チェック結果が想定外の値です。", "メッセージ内容");
        }
    }

    @Test
    @TestOrder(270)
    public void testExecPostFormPrepare_A27() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN10;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013006", "（ＩＷＳ）ＤＳメッセージコード");
    }


    @Test
    @TestOrder(280)
    public void testExecPostFormPrepare_A28() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN11;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsShrgkkeiyen(), "1234546789012", "（ＩＷＳ）支払額合計（円貨）");
        exStringEquals(resultBean.getIwsKaiyakuhryen(), "1234546789012", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(resultBean.getIwsYendthnkhr(), "1234546789012", "（ＩＷＳ）円建変更時返戻金");
        exStringEquals(resultBean.getIwsGstszeigkyen(), "1234546789012", "（ＩＷＳ）源泉徴収税額（円貨）");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwDsKaiyakuUktkInputBean tBean = (WsDwDsKaiyakuUktkInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, "10806000016");
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 1, BizDate.getSysDate());
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 2,
            BizCurrency.valueOf(new BigDecimal("1234546789012")));
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 3,
            C_DsSyouhnbunruiKbn.GKDTITIJIBRSYSN);

        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, "10806000016");

        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 1, "1001");
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 2, "001");
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 3, "ナカムラ３");
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 4, C_Kzdou.SITEI);
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 5, "ユヒメイ　イチア");
    }

    @Test
    @TestOrder(290)
    public void testExecPostFormPrepare_A29() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013019", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsShrgkkeiyen(), null, "（ＩＷＳ）支払額合計（円貨）");
        exStringEquals(resultBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(resultBean.getIwsYendthnkhr(), null, "（ＩＷＳ）円建変更時返戻金");
        exStringEquals(resultBean.getIwsGstszeigkyen(), null, "（ＩＷＳ）源泉徴収税額（円貨）");
    }

    @Test
    @TestOrder(300)
    public void testExecPostFormPrepare_A30() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN12;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013020", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(310)
    public void testExecPostFormPrepare_A31() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN13;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013021", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(320)
    public void testExecPostFormPrepare_A32() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN14;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013022", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(330)
    public void testExecPostFormPrepare_A33() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN15;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013023", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(340)
    public void testExecPostFormPrepare_A34() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN16;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013024", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(350)
    public void testExecPostFormPrepare_A35() throws Exception {
        changeSystemDate(BizDate.valueOf(20200331));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN11;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000083', "
            + "'iwsDskokno':'8600000030', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsKaiyakuhryen(), "1234546789999", "（ＩＷＳ）解約返戻金額（円貨）");
    }

    @Test
    @TestOrder(360)
    public void testExecPostFormPrepare_A36() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN17;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013025", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(370)
    public void testExecPostFormPrepare_A37() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN18;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000016', "
            + "'iwsDskokno':'8600000025', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013026", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(380)
    public void testExecPostFormPrepare_B1() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013205", "（ＩＷＳ）ＤＳメッセージコード");


    }

    @Test
    @TestOrder(390)
    public void testExecPostFormPrepare_B2() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013204", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(400)
    public void testExecPostFormPrepare_B3() throws Exception{

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        String className = "";

        try {
            dwKaiyakuUketukeImpl.execPostFormPrepare(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
