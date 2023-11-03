package yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin;

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
import yuyu.common.direct.dscommon.DsGetKeiyakuCommon;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommonMockForDirect;
import yuyu.common.direct.dscommon.DsGetSeigyo;
import yuyu.common.direct.dscommon.DsGetSeigyoMockForDirect;
import yuyu.common.direct.dscommon.DsSyouhinBean;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuEnItijiSyusinOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約詳細取得（円建一時払終身）のメイン処理{@link DwGetHozenKeiyakuEnItijiSyusinImpl#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm extends AbstractTest {

    @Inject
    private DwGetHozenKeiyakuEnItijiSyusinImpl dwGetHozenKeiyakuEnItijiSyusinImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約詳細取得（円建一時払終身）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(DsGetKeiyakuCommon.class).to(DsGetKeiyakuCommonMockForDirect.class);
                bind(DsGetSeigyo.class).to(DsGetSeigyoMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class;
        CalcHkShrKngkMockForDirect.caller = DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class;
        DsGetKeiyakuCommonMockForDirect.caller = DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class;
        DsGetSeigyoMockForDirect.caller = DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    public static void testClear() {

        WebServiceAccesslogOutputMockForDirect.caller = null ;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null ;
        CalcHkShrKngkMockForDirect.caller = null;
        CalcHkShrKngkMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        DsGetKeiyakuCommonMockForDirect.caller = null;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = null;
        DsGetSeigyoMockForDirect.caller = null;
        DsGetSeigyoMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, C_AccessLogSyubetuKbn.ACTION_BEGIN);
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11111111111'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000044'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010200", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010201", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykKihon", 0, "11807111129");

    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010202", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykSya", 0, "11807111129");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010203", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getHhknSya", 0, "11807111129");

    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010204", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykUkt", 0, "11807111129");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010205", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getGamenSeigyo", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "11807111129", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010206", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getHosyou", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "11807111129", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010207", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getTokuyaku", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "11807111129", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010208", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getSyoriKahi", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "11807111129", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_A13() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010209", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_A14() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111130'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010210", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

    }

    @Test
    @TestOrder(150)
    public void testExecPostForm_A15() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111141'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010211", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_A16() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111152'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyono(), "11807111152", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAisyoumei(), "ふるはーとＪロードグローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykymdstr(), "20180226", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSakuseikijyunymdstr(), "20180305", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykseiymdstr(), "20170405", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknseiymdstr(), "20170525", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn1(), "登録家族名（カナ）１", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn2(), "登録家族名（カナ）２", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsGaikanykntkhkumu(), "1", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkumu(), "1", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyksbyensitihsyutyhkumu(), "1", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsZeiseitkkktkykhukaumu(), "1", "（ＩＷＳ）税制適格特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKaiyakuhryen(), "20005", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSibohknkngkyen(), "10010", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkymd(), "20140506", "（ＩＷＳ）円建一時払終身保険変更日");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkhr(), "98715", "（ＩＷＳ）円建一時払終身保険変更返戻金");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHrsiharaijyoutaikbn(), "1", "（ＩＷＳ）返戻金支払状態区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");

        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, "11807111152");
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 2, C_SiinKbn.SP);
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 3, C_HokenkinsyuruiKbn.SBHOKENKIN);
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 4, C_Sdpd.SD);
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 5, C_Hrkkeiro.BLNK);

    }

    @Test
    @TestOrder(170)
    public void testExecPostForm_A17() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111174'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyono(), "11807111174", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAisyoumei(), "ふるはーとＪロードグローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn1(), "登録家族名（カナ）１", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn2(), "登録家族名（カナ）２", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsGaikanykntkhkumu(), "1", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkumu(), "1", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyksbyensitihsyutyhkumu(), "1", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsZeiseitkkktkykhukaumu(), "1", "（ＩＷＳ）税制適格特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKaiyakuhryen(), "0", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSibohknkngkyen(), "0", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkymd(), "20140506", "（ＩＷＳ）円建一時払終身保険変更日");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkhr(), "98715", "（ＩＷＳ）円建一時払終身保険変更返戻金");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHrsiharaijyoutaikbn(), "1", "（ＩＷＳ）返戻金支払状態区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYakkanbunsyono(), "", "（ＩＷＳ）約款文書番号");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111185'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyono(), "11807111185", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAisyoumei(), "ふるはーとＪロードグローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn1(), "登録家族名（カナ）１", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn2(), "登録家族名（カナ）２", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsGaikanykntkhkumu(), "1", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkumu(), "1", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyksbyensitihsyutyhkumu(), "1", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKaiyakuhryen(), "0", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSibohknkngkyen(), "0", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkymd(), "20140507", "（ＩＷＳ）円建一時払終身保険変更日");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkhr(), "0", "（ＩＷＳ）円建一時払終身保険変更返戻金");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHrsiharaijyoutaikbn(), "0", "（ＩＷＳ）返戻金支払状態区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYakkanbunsyono(), "", "（ＩＷＳ）約款文書番号");

    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_A19() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111196'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyono(), "11807111196", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAisyoumei(), "ふるはーとＪロードグローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn1(), "登録家族名（カナ）１", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTrkkzknmkn2(), "登録家族名（カナ）２", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsGaikanykntkhkumu(), "1", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkumu(), "1", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyksbyensitihsyutyhkumu(), "1", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsKaiyakuhryen(), "0", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsSibohknkngkyen(), "0", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkymd(), null, "（ＩＷＳ）円建一時払終身保険変更日");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYendtitijibrsysnhkhnkhr(), "0", "（ＩＷＳ）円建一時払終身保険変更返戻金");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsHrsiharaijyoutaikbn(), "0", "（ＩＷＳ）返戻金支払状態区分");
        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsYakkanbunsyono(), "", "（ＩＷＳ）約款文書番号");

    }

    @Test
    @TestOrder(200)
    public void testExecPostForm_A20() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000011'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010211", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean);

    }

    @Test
    @TestOrder(210)
    public void testExecPostForm_B1() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'11807111118'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010213", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(220)
    public void testExecPostForm_B2() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'11807111118'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "010212", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(230)
    public void testExecPostForm_B3() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'11807111118'}");

        String className = "";

        try {
            dwGetHozenKeiyakuEnItijiSyusinImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外のクラス名");

    }

    private void test (WsDwGetHozenKeiyakuEnItijiSyusinOutputBean pBean) {

        exStringEquals(pBean.getIwsSyono(), null, "（ＩＷＳ）証券番号");
        exStringEquals(pBean.getIwsAisyoumei(), null, "（ＩＷＳ）愛称名");
        exStringEquals(pBean.getIwsSyouhnnm(), null, "（ＩＷＳ）商品名");
        exStringEquals(pBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");
        exStringEquals(pBean.getIwsKyktuukasyu(), null, "（ＩＷＳ）契約通貨種類");
        exStringEquals(pBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(pBean.getIwsKyknmkn(), null, "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(pBean.getIwsKyknmkj(), null, "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(pBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(pBean.getIwsKyksei(), null, "（ＩＷＳ）契約者性別");
        exStringEquals(pBean.getIwsHhknnmkn(), null, "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(pBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(pBean.getIwsSbuktnin(), null, "（ＩＷＳ）死亡受取人人数");
        exStringEquals(pBean.getIwsUktmidasikbn1(), null, "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(pBean.getIwsUktkbn1str(), null, "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(pBean.getIwsUktsimei1(), null, "（ＩＷＳ）受取人氏名１");
        exStringEquals(pBean.getIwsUktmidasikbn2(), null, "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(pBean.getIwsUktkbn2str(), null, "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(pBean.getIwsUktsimei2(), null, "（ＩＷＳ）受取人氏名２");
        exStringEquals(pBean.getIwsUktmidasikbn3(), null, "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(pBean.getIwsUktkbn3str(), null, "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(pBean.getIwsUktsimei3(), null, "（ＩＷＳ）受取人氏名３");
        exStringEquals(pBean.getIwsUktmidasikbn4(), null, "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(pBean.getIwsUktkbn4str(), null, "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(pBean.getIwsUktsimei4(), null, "（ＩＷＳ）受取人氏名４");
        exStringEquals(pBean.getIwsUktmidasikbn5(), null, "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(pBean.getIwsUktkbn5str(), null, "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(pBean.getIwsUktsimei5(), null, "（ＩＷＳ）受取人氏名５");
        exStringEquals(pBean.getIwsUktmidasikbn6(), null, "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(pBean.getIwsUktkbn6str(), null, "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(pBean.getIwsUktsimei6(), null, "（ＩＷＳ）受取人氏名６");
        exStringEquals(pBean.getIwsUktmidasikbn7(), null, "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(pBean.getIwsUktkbn7str(), null, "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(pBean.getIwsUktsimei7(), null, "（ＩＷＳ）受取人氏名７");
        exStringEquals(pBean.getIwsUktmidasikbn8(), null, "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(pBean.getIwsUktkbn8str(), null, "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(pBean.getIwsUktsimei8(), null, "（ＩＷＳ）受取人氏名８");
        exStringEquals(pBean.getIwsUktmidasikbn9(), null, "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(pBean.getIwsUktkbn9str(), null, "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(pBean.getIwsUktsimei9(), null, "（ＩＷＳ）受取人氏名９");
        exStringEquals(pBean.getIwsUktmidasikbn10(), null, "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(pBean.getIwsUktkbn10str(), null, "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(pBean.getIwsUktsimei10(), null, "（ＩＷＳ）受取人氏名１０");
        exStringEquals(pBean.getIwsTutakinumukbn(), null, "（ＩＷＳ）積立金有無区分");
        exStringEquals(pBean.getIwsSbhsyumukbn(), null, "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(pBean.getIwsKghsyumukbn(), null, "（ＩＷＳ）介護保障有無区分");
        exStringEquals(pBean.getIwsIryhsyumukbn(), null, "（ＩＷＳ）医療保障有無区分");
        exStringEquals(pBean.getIwsRougohsyumukbn(), null, "（ＩＷＳ）老後保障有無区分");
        exStringEquals(pBean.getIwsStdrsktkyhkumu(), null, "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(pBean.getIwsYennykntkhkumu(), null, "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(pBean.getIwsGaikanykntkhkumu(), null, "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(pBean.getIwsTargettkhkumu(), null, "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(pBean.getIwsSyksbyensitihsyutyhkumu(), null, "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(pBean.getIwsJyudkaigomehrtkhkumu(), null, "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(pBean.getIwsKjsmsaihakkoukahikbn(), null, "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(pBean.getIwsKykmeigihnkkahikbn(), null, "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(pBean.getIwsSyoukensaihkkahikbn(), null, "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(pBean.getIwsStdrsktkytthkkahikbn(), null, "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(pBean.getIwsTargettkhkkahikbn(), null, "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(pBean.getIwsKykniyusyoukaikahikbn(), null, "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(pBean.getIwsTumitatekinitenkahikbn(), null, "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(pBean.getIwsDskaiyakukahikbn(), null, "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(pBean.getIwsAdrhenkoukahikbn(), null, "（ＩＷＳ）住所変更可否区分");
        exStringEquals(pBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(pBean.getIwsSibohknkngkyen(), null, "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(pBean.getIwsYendtitijibrsysnhkhnkymd(), null, "（ＩＷＳ）円建一時払終身保険変更日");
        exStringEquals(pBean.getIwsYendtitijibrsysnhkhnkhr(), null, "（ＩＷＳ）円建一時払終身保険変更返戻金");
        exStringEquals(pBean.getIwsHrsiharaijyoutaikbn(), null, "（ＩＷＳ）返戻金支払状態区分");
        exStringEquals(pBean.getIwsTrkkzknmkn1(), null, "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(pBean.getIwsTrkkzknmkn2(), null, "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(pBean.getIwsKykdrtkhkumu(), null, "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(pBean.getIwsYakkanbunsyono(), null, "（ＩＷＳ）約款文書番号");

    }

}
