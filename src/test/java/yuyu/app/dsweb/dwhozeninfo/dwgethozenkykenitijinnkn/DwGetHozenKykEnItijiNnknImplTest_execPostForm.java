package yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForDirect;
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
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKykEnItijiNnknOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約詳細取得（円建一時払年金）のメイン処理{@link DwGetHozenKykEnItijiNnknImpl#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwGetHozenKykEnItijiNnknImplTest_execPostForm extends AbstractTest {

    @Inject
    private DwGetHozenKykEnItijiNnknImpl dwGetHozenKykEnItijiNnknImpl;

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf("20180625"));
    }

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約詳細取得（円建一時払年金）";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetHozenKykEnItijiNnknImplTest_execPostForm.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(DsGetKeiyakuCommon.class).to(DsGetKeiyakuCommonMockForDirect.class);
                bind(DsGetSeigyo.class).to(DsGetSeigyoMockForDirect.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForDirect.class);
                bind(SetNenrei.class).to(SetNenreiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKykEnItijiNnknImplTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwGetHozenKykEnItijiNnknImplTest_execPostForm.class;
        DsGetKeiyakuCommonMockForDirect.caller = DwGetHozenKykEnItijiNnknImplTest_execPostForm.class;
        DsGetSeigyoMockForDirect.caller = DwGetHozenKykEnItijiNnknImplTest_execPostForm.class;
        CalcHkShrKngkMockForDirect.caller = DwGetHozenKykEnItijiNnknImplTest_execPostForm.class;
        SetNenreiMockForDirect.caller = DwGetHozenKykEnItijiNnknImplTest_execPostForm.class;

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    public static void testClear() {
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        DsGetKeiyakuCommonMockForDirect.caller = null;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = null;
        DsGetSeigyoMockForDirect.caller = null;
        DsGetSeigyoMockForDirect.SYORIPTN = null;
        CalcHkShrKngkMockForDirect.caller = null;
        CalcHkShrKngkMockForDirect.SYORIPTN = null;
        SetNenreiMockForDirect.caller = null;
        SetNenreiMockForDirect.SYORIPTN = null;

    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);

        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019100", "（ＩＷＳ）ＤＳメッセージコード");

        test(wsDwGetHozenKykEnItijiNnknOutputBean);

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

    }

    @Test
    @TestOrder(2010)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'100000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(3010)
    public void testExecPostForm_A3() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000044'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019201", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykKihon", 0, "60806000044");
    }

    @Test
    @TestOrder(3020)
    public void testExecPostForm_A4() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000446'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019202", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykSya", 0, "60806000446");
    }

    @Test
    @TestOrder(3030)
    public void testExecPostForm_A5() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000240'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019203", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getHhknSya", 0, "60806000240");
    }

    @Test
    @TestOrder(3040)
    public void testExecPostForm_A6() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000642'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019204", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykUkt", 0, "60806000642");
    }

    @Test
    @TestOrder(4010)
    public void testExecPostForm_A7() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806000848'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getGamenSeigyo", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806000848", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRNK, "ＤＳ商品分類区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019205", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(4020)
    public void testExecPostForm_A8() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806001045'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class, "getHosyou",
            0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806001045", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRNK, "ＤＳ商品分類区分");
        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019206", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(4030)
    public void testExecPostForm_A9() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806002046'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getTokuyaku", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806002046", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRNK, "ＤＳ商品分類区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019207", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(4040)
    public void testExecPostForm_A10() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806002046'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getSyoriKahi", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806002046", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.YENDTITIJIBRNK, "ＤＳ商品分類区分");
        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019208", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(5000)
    public void testExecPostForm_A11() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806001241'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019200", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(5010)
    public void testExecPostForm_A12() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806001447'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019209", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(5020)
    public void testExecPostForm_A13() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806001643'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019210", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykEnItijiNnknOutputBean);
    }

    @Test
    @TestOrder(6010)
    public void testExecPostForm_B1() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806012407'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSyono(), "60806012407", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsAisyoumei(), "ふるはーとＪロードグローバル", "（ＩＷＳ）愛称名区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKykymdstr(), "20180404", "（ＩＷＳ）契約日（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSakuseikijyunymdstr(), "20180305", "（ＩＷＳ）作成基準日（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKykseiymdstr(), "20170305", "（ＩＷＳ）契約者生年月日（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsHhknseiymdstr(), "20170525", "（ＩＷＳ）被保険者生年月日（文字列） ");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTrkkzknmkn1(), "トウロクカゾク１", "（ＩＷＳ）登録家族名（カナ）１");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTrkkzknmkn2(), "トウロクカゾク２", "（ＩＷＳ）登録家族名（カナ）２");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsStdrsktkytthkkahikbn(), "1","（ＩＷＳ）指定代理請求特約中途付加処理可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsNenkinsyustr(), "", "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsNenkinstartymd(), "99991231", "（ＩＷＳ）年金支払開始日");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsNenkinstartnen(), "43", "（ＩＷＳ）年金開始年齢");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKijyunkingaku(), "29526425", "（ＩＷＳ）基準金額");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTumitateriritustr(), "12.3", "（ＩＷＳ）積立利率（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSbkyhgkyen(), "1234", "（ＩＷＳ）死亡給付金額（円貨）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsPtumitatekngkyen(), "1234", "（ＩＷＳ）保険料積立金額（円貨）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKaiyakuhryen(), "1234", "（ＩＷＳ）解約返戻金額（円貨）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsYendtitijibrnkhkhnkymd(), "20180115","（ＩＷＳ）円建一時払年金保険変更日");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsYakkanbunsyono(), "1234567890","（ＩＷＳ）約款文書番号");

        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, "60806012407");
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 2, C_SiinKbn.SP);
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 3, C_HokenkinsyuruiKbn.SBHOKENKIN);
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 4, C_Sdpd.PD);
        MockObjectManager.assertArgumentPassed(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 5, C_Hrkkeiro.BLNK);

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForDirect.class, "exec", 0),
            BizDate.valueOf("99991231"), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForDirect.class, "exec", 1),
            BizDate.valueOf("20170525"), "生年月日");

    }

    @Test
    @TestOrder(6020)
    public void testExecPostForm_B2() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806012500'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsPtumitatekngkyen(), "0", "（ＩＷＳ）保険料積立金額（円貨）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKaiyakuhryen(), "0", "（ＩＷＳ）解約返戻金額（円貨）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsSbkyhgkyen(), "0", "（ＩＷＳ）死亡給付金額（円貨）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsKijyunkingaku(), "0", "（ＩＷＳ）基準金額");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsNenkinsyustr(), "13年確定年金", "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsTumitateriritustr(), "0", "（ＩＷＳ）積立利率（文字列）");

    }

    @Test
    @TestOrder(6030)
    public void testExecPostForm_B3() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806010807'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsNenkinsyustr(), "年金総額保証付終身年金", "（ＩＷＳ）年金種類（文字列）");

    }

    @Test
    @TestOrder(7010)
    public void testExecPostForm_C1() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'60806019563'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);

        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean = JSON.decode(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019212", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(7020)
    public void testExecPostForm_C2() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'60806019518'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);

        WsDwGetHozenKykEnItijiNnknOutputBean wsDwGetHozenKykEnItijiNnknOutputBean = JSON.decode(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKykEnItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKykEnItijiNnknOutputBean.getIwsDsmsgcd(), "019211", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(8010)
    public void testExecPostForm_C3() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'100000000001'}");

        String className = "";

        try {
            dwGetHozenKykEnItijiNnknImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }

    private void test(WsDwGetHozenKykEnItijiNnknOutputBean pBean) {

        exStringEquals(pBean.getIwsSyono(), null, "（ＩＷＳ）証券番号");

        exStringEquals(pBean.getIwsAisyoumei(), null, "（ＩＷＳ）愛称名区分");

        exStringEquals(pBean.getIwsSyouhnnm(), null, "（ＩＷＳ）商品名");

        exStringEquals(pBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");

        exStringEquals(pBean.getIwsKyktuukasyu(), null, "（ＩＷＳ）契約通貨種類");

        exStringEquals(pBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");

        exStringEquals(pBean.getIwsKyknmkn(), null, "（ＩＷＳ）契約者名（カナ）");

        exStringEquals(pBean.getIwsKyknmkj(), null, "（ＩＷＳ）契約者名（漢字）");

        exStringEquals(pBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");

        exStringEquals(pBean.getIwsKyksei(), null, "（ＩＷＳ）契約者性別");

        exStringEquals(pBean.getIwsHhknnmkn(), null, "（ＩＷＳ）被保険者名（カナ）");

        exStringEquals(pBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列） ");

        exStringEquals(pBean.getIwsSbuktnin(), null, "（ＩＷＳ）死亡受取人人数");

        exStringEquals(pBean.getIwsUktmidasikbn1(), null, "（ＩＷＳ）受取人見出し区分１");

        exStringEquals(pBean.getIwsUktkbn1str(), null, "（ＩＷＳ）受取人区分１（文字列）");

        exStringEquals(pBean.getIwsUktsimei1(), null, "（ＩＷＳ）受取人氏名１");

        exStringEquals(pBean.getIwsUktmidasikbn2(), null, "（ＩＷＳ）受取人見出し区分２");

        exStringEquals(pBean.getIwsUktkbn2str(), null, "（ＩＷＳ）受取人区分２（文字列）");

        exStringEquals(pBean.getIwsUktsimei2(), null, "（ＩＷＳ）受取人氏名２");

        exStringEquals(pBean.getIwsUktmidasikbn3(), null, "（ＩＷＳ）受取人見出し区分３");

        exStringEquals(pBean.getIwsUktkbn3str(), null, "（ＩＷＳ）受取人区分３（文字列）");

        exStringEquals(pBean.getIwsUktsimei3(), null, "（ＩＷＳ）受取人氏名３ ");

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

        exStringEquals(pBean.getIwsTrkkzknmkn1(), null, "（ＩＷＳ）登録家族名（カナ）１");

        exStringEquals(pBean.getIwsTrkkzknmkn2(), null, "（ＩＷＳ）登録家族名（カナ）２");

        exStringEquals(pBean.getIwsTutakinumukbn(), null, "（ＩＷＳ）積立金有無区分");

        exStringEquals(pBean.getIwsSbhsyumukbn(), null, "（ＩＷＳ）死亡保障有無区分");

        exStringEquals(pBean.getIwsKghsyumukbn(), null, "（ＩＷＳ）介護保障有無区分");

        exStringEquals(pBean.getIwsIryhsyumukbn(), null, "（ＩＷＳ）医療保障有無区分");

        exStringEquals(pBean.getIwsRougohsyumukbn(), null, "（ＩＷＳ）老後保障有無区分");

        exStringEquals(pBean.getIwsKykdrtkhkumu(), null, "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(pBean.getIwsStdrsktkyhkumu(), null, "（ＩＷＳ）指定代理請求特約付加有無");

        exStringEquals(pBean.getIwsKjsmsaihakkoukahikbn(), null, "（ＩＷＳ）控除証明書再発行処理可否区分");

        exStringEquals(pBean.getIwsKykmeigihnkkahikbn(), null, "（ＩＷＳ）名義変更処理可否区分");

        exStringEquals(pBean.getIwsSyoukensaihkkahikbn(), null, "（ＩＷＳ）証券再発行処理可否区分");

        exStringEquals(pBean.getIwsStdrsktkytthkkahikbn(), null, "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");

        exStringEquals(pBean.getIwsTargettkhkkahikbn(), null, "（ＩＷＳ）ターゲット特約変更可否区分");

        exStringEquals(pBean.getIwsKykniyusyoukaikahikbn(), null, "（ＩＷＳ）契約内容照会可否区分");

        exStringEquals(pBean.getIwsTumitatekinitenkahikbn(), null, "（ＩＷＳ）積立金移転可否区分");

        exStringEquals(pBean.getIwsDskaiyakukahikbn(), null, "（ＩＷＳ）ＤＳ解約可否区分");

        exStringEquals(pBean.getIwsAdrhenkoukahikbn(), null, "（ＩＷＳ）住所変更可否区分");

        exStringEquals(pBean.getIwsPhrkhouhenkoukahikbn(), null, "（ＩＷＳ）保険料払込方法変更可否区分");

        exStringEquals(pBean.getIwsKijyunkingaku(), null, "（ＩＷＳ）基準金額");

        exStringEquals(pBean.getIwsNenkinsyustr(), null, "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(pBean.getIwsNenkinstartymd(), null, "（ＩＷＳ）年金支払開始日");

        exStringEquals(pBean.getIwsNenkinstartnen(), null, "（ＩＷＳ）年金開始年齢");

        exStringEquals(pBean.getIwsSbkyhgkyen(), null, "（ＩＷＳ）死亡給付金額（円貨）");

        exStringEquals(pBean.getIwsPtumitatekngkyen(), null, "（ＩＷＳ）保険料積立金額（円貨）");

        exStringEquals(pBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");

        exStringEquals(pBean.getIwsTumitateriritustr(), null, "（ＩＷＳ）積立利率（文字列）");

        exStringEquals(pBean.getIwsYendtitijibrnkhkhnkymd(), null, "（ＩＷＳ）円建一時払年金保険変更日");

    }
}
