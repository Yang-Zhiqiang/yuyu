package yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

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
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuMockForDirect;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForDirect;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KeisanKihrkPMockForDirect;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKykSntkHijynSysnOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 保全契約詳細取得（選択通貨建平準払終身）のメイン処理{@link DwGetHozenKykSntkHijynSysnImpl#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwGetHozenKykSntkHijynSysnImplTest_execPostForm extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約詳細取得（選択通貨建平準払終身）";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class,
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
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForDirect.class);
                bind(KeisanRsgaku.class).to(KeisanRsgakuMockForDirect.class);
                bind(KeisanKihrkP.class).to(KeisanKihrkPMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        DsGetKeiyakuCommonMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        DsGetSeigyoMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        CalcHkShrKngkMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        KeisanCommonKaiyakuMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        KeisanRsgakuMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;
        KeisanKihrkPMockForDirect.caller = DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class;

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
        KeisanCommonKaiyakuMockForDirect.caller = null;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = null;
        KeisanRsgakuMockForDirect.caller = null;
        KeisanRsgakuMockForDirect.SYORIPTN = null;
        KeisanKihrkPMockForDirect.caller = null;
        KeisanKihrkPMockForDirect.SYORIPTN = null;

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'abcd'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022200", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykKihon", 0, "99806001010");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022201", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykSya", 0, "99806001010");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022202", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getHhknSya", 0, "99806001010");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022203", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykUkt", 0, "99806001010");
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getTrkKazoku", 0, "99806001010");
        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getHokenKikan", 0, "99806001010");
        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getGamenSeigyo", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "99806001010", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022204", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getHosyou", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "99806001010", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022205", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getTokuyaku", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "99806001010", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022206", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getSyoriKahi", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "99806001010", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'18806000014'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022200", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022200", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001021'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022207", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExecPostForm_A13() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001032'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022208", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKykSntkHijynSysnOutputBean);
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExecPostForm_A14() throws Exception {

        changeSystemDate(BizDate.valueOf(20201118));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001043'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);


        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001043", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年１回払（全期前納）", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "0.00", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202110", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), null, "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "0", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), null, "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), null, "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), null, "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), null, "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), null, "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), null, "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), null, "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), "12345", "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), "22345", "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "1", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");

        exStringEquals((String) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 0), "99806001043", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 1), BizDate.valueOf("20201118"), "計算基準日");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 5), C_Hrkkeiro.KOUHURI, "払込経路");

        exStringEquals((String) MockObjectManager.getArgument(
            KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 0), KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE, "機能分類");
        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 1);
        exStringEquals(kykKihon.getSyono(), "99806001043", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 2), BizDate.valueOf("20201118"), "処理年月日");
        KeisanKaiyakuBean keisanKaiyakuBean = (KeisanKaiyakuBean) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 3);
        exDateEquals(keisanKaiyakuBean.getSyoruiukeymd(), BizDate.valueOf("20201118"), "書類受付日");
        exDateEquals(keisanKaiyakuBean.getKaiykymd(), BizDate.valueOf("20201118"), "解約日");
        exBizCalcbleEquals(keisanKaiyakuBean.getYenshrkwsrate(), BizNumber.valueOf(0), "円支払為替レート");

        exStringEquals((String) MockObjectManager.getArgument(KeisanKihrkPMockForDirect.class, "exec", 0, 0), "99806001043", "証券番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKihrkPMockForDirect.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExecPostForm_A15() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001054'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001054", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), null, "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), null, "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), null, "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "0", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "0", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "44444444", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "0", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "11111111", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "0", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), "12345", "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), "22345", "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "1", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExecPostForm_A16() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN1;
        KeisanRsgakuMockForDirect.SYORIPTN = KeisanRsgakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001065'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001065", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), null, "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202011", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), null, "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "1", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "1", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");

        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "99806001065", "証券番号");

        exClassificationEquals((C_Nykkeiro) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 1), C_Nykkeiro.OTHER, "入金経路");
        exClassificationEquals((C_NyknaiyouKbn) MockObjectManager.getArgument( KeisanRsgakuMockForDirect.class, "exec", 0, 2), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 3), BizDate.valueOf(20201119), "領収年月日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 4), BizDateYM.valueOf(202011), "充当開始年月");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 5), 0, "充当年数");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 6), 6, "充当月数");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExecPostForm_A17() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanRsgakuMockForDirect.SYORIPTN = KeisanRsgakuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001076'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001076", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年１回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), null, "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202011", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), null, "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "1", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExecPostForm_A18() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanRsgakuMockForDirect.SYORIPTN = KeisanRsgakuMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001087'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001087", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "月払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "1", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), null, "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202011", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), null, "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "1", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExecPostForm_A19() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanRsgakuMockForDirect.SYORIPTN = KeisanRsgakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001098'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001098", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "1", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "123", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202011", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), "20200814", "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "2", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExecPostForm_A20() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001102'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001102", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年１回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202110", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExecPostForm_A21() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001113'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001113", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202104", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExecPostForm_A22() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001124'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001124", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "0", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202012", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "88888899", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "22222200", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "54671125", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "44444455", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "884430", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "22222244", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExecPostForm_A23() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001135'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001135", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "1", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "119316972", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), "JPY", "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "2234567", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), null, "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "300", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "100", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "124", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "100", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "55555431", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "100", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExecPostForm_A24() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001146'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001146", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "1", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "119316972", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), "JPY", "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "2234567", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), null, "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "0", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "0", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "0", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "0", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "55555555", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "0", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExecPostForm_A25() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN5;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001157'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001157", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "212.00", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "1", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "119316972", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), "USD", "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), null, "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "12301493", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "10000400", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "100", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "300", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "0", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "-100", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "55555555", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "-100", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExecPostForm_A26() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001168'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001168", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSakuseikijyunymdstr(), "20190325", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd1str(), "20170424", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknmanryouymd1str(), "20200423", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkkn1(), "99", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHknkknkaisiymd2str(), "20200424", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkaisuu(), "年２回払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYoteiriritu(), "112.34", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouumu(), "1", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryou(), "1000000", "（ＩＷＳ）保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihonhokenkngk(), "1690900", "（ＩＷＳ）基本保険金額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnp(), "119316972", "（ＩＷＳ）契約時前納保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnprsytuukasyu(), "JPY", "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKykznnyenhrkgk(), "0", "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "0", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "0", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), null, "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "0", "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKwsratekijyunymdsakusei(), "20201119", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSksikijyunymdkawaserate(), "123.01", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkyen(), "10000400", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSibohknkngkgaika(), "0", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "0", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "0", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "44444444", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "0", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "11111111", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "0", "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsRskngkksnkekkakbn(), "0", "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");
    }


    @Test
    @TestOrder(270)
    @Transactional
    public void testExecPostForm_A27() throws Exception {

        changeSystemDate(BizDate.valueOf(20201118));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN3;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001179'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001179", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "300", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "100", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), null, "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "100", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), null, "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "100", "（ＩＷＳ）その他支払金額（外貨）");
    }


    @Test
    @TestOrder(280)
    @Transactional
    public void testExecPostForm_A28() throws Exception {

        changeSystemDate(BizDate.valueOf(20201118));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN4;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001180'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001180", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "0", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "0", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "0", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "0", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "0", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "0", "（ＩＷＳ）その他支払金額（外貨）");
    }


    @Test
    @TestOrder(290)
    @Transactional
    public void testExecPostForm_A29() throws Exception {

        changeSystemDate(BizDate.valueOf(20201118));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN5;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001191'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001191", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "100", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "300", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "0", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "-100", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "0", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "-100", "（ＩＷＳ）その他支払金額（外貨）");
    }


    @Test
    @TestOrder(300)
    @Transactional
    public void testExecPostForm_A30() throws Exception {

        changeSystemDate(BizDate.valueOf(20201118));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN3;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001179'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001179", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), "300", "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "100", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), null, "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "100", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), null, "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), "100", "（ＩＷＳ）その他支払金額（外貨）");
    }


    @Test
    @TestOrder(310)
    @Transactional
    public void testExecPostForm_A31() throws Exception {

        changeSystemDate(BizDate.valueOf(20201115));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN3;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001179'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSyono(), "99806001179", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkyen(), "88888888", "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakujshrgkgaika(), null, "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhryen(), "33333333", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsKaiyakuhrgaika(), "100", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkyen(), "129", "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsZennouzndkgaika(), "100", "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakuyen(), "55555426", "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsSonotasiharaikingakugk(), null, "（ＩＷＳ）その他支払金額（外貨）");
    }


    @Test
    @TestOrder(320)
    @Transactional
    public void testExecPostForm_A32() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanKihrkPMockForDirect.SYORIPTN = KeisanKihrkPMockForDirect.TESTPATTERN1;
        KeisanRsgakuMockForDirect.SYORIPTN = KeisanRsgakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("gyoumuData", "{'iwsSyono':'99806001065'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);


        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenhrkgkhyoujikahi(), "1", "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenkansanhokenryou(), "123", "（ＩＷＳ）円換算保険料");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsJkirsymd(), "202011", "（ＩＷＳ）次回領収年月");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsYenknsnkijyunymd(), "20200814", "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsHokenryoukktikwsrate(), "2", "（ＩＷＳ）保険料確定為替レート");


        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "99806001065", "証券番号");

        exClassificationEquals((C_Nykkeiro) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 1), C_Nykkeiro.OTHER, "入金経路");
        exClassificationEquals((C_NyknaiyouKbn) MockObjectManager.getArgument( KeisanRsgakuMockForDirect.class, "exec", 0, 2), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 3), BizDate.valueOf(20201119), "領収年月日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 4), BizDateYM.valueOf(202011), "充当開始年月");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 5), 0, "充当年数");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanRsgakuMockForDirect.class, "exec", 0, 6), 6, "充当月数");
    }


    @Test
    @TestOrder(500)
    public void testExecPostForm_B1() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("orgCode", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);
        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022210", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(510)
    public void testExecPostForm_B2() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("orgCode", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);
        WsDwGetHozenKykSntkHijynSysnOutputBean wsDwGetHozenKykSntkHijynSysnOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKykSntkHijynSysnOutputBean.class);

        exStringEquals(wsDwGetHozenKykSntkHijynSysnOutputBean.getIwsDsmsgcd(), "022209", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(520)
    public void testExecPostForm_B3() throws Exception {

        changeSystemDate(BizDate.valueOf(20201119));

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        DwGetHozenKykSntkHijynSysnImpl dwGetHozenKykSntkHijynSysnImpl = SWAKInjector.getInstance(DwGetHozenKykSntkHijynSysnImpl.class);

        pMap.add("orgCode", "{'iwsSyono':'18806000081'}");

        String className = "";

        try {
            dwGetHozenKykSntkHijynSysnImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外のクラス名");

    }


    private void test(WsDwGetHozenKykSntkHijynSysnOutputBean pBean) {

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
        exStringEquals(pBean.getIwsTrkkzknmkn1(), null, "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(pBean.getIwsTrkkzknmkn2(), null, "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(pBean.getIwsTutakinumukbn(), null, "（ＩＷＳ）積立金有無区分");
        exStringEquals(pBean.getIwsKaiyakuhrsuiiumukbn(), null, "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(pBean.getIwsHknkknkaisiymd1str(), null, "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(pBean.getIwsHknkknmanryouymd1str(), null, "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(pBean.getIwsHknkkn1(), null, "（ＩＷＳ）第１保険期間");
        exStringEquals(pBean.getIwsHknkknkaisiymd2str(), null, "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(pBean.getIwsSbhsyumukbn(), null, "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(pBean.getIwsKghsyumukbn(), null, "（ＩＷＳ）介護保障有無区分");
        exStringEquals(pBean.getIwsIryhsyumukbn(), null, "（ＩＷＳ）医療保障有無区分");
        exStringEquals(pBean.getIwsRougohsyumukbn(), null, "（ＩＷＳ）老後保障有無区分");
        exStringEquals(pBean.getIwsKykdrtkhkumu(), null, "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(pBean.getIwsStdrsktkyhkumu(), null, "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(pBean.getIwsJyudkaigomehrtkhkumu(), null, "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(pBean.getIwsYennykntkhkumu(), null, "（ＩＷＳ）円入金特約付加有無");
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
        exStringEquals(pBean.getIwsHrkkaisuu(), null, "（ＩＷＳ）払込回数");
        exStringEquals(pBean.getIwsHrkkeiro(), null, "（ＩＷＳ）払込経路");
        exStringEquals(pBean.getIwsHrkkkn(), null, "（ＩＷＳ）払込期間");
        exStringEquals(pBean.getIwsYoteiriritu(), null, "（ＩＷＳ）予定利率");
        exStringEquals(pBean.getIwsZennouumu(), null, "（ＩＷＳ）前納有無");
        exStringEquals(pBean.getIwsHokenryou(), null, "（ＩＷＳ）保険料");
        exStringEquals(pBean.getIwsKihonhokenkngk(), null, "（ＩＷＳ）基本保険金額");
        exStringEquals(pBean.getIwsKykznnp(), null, "（ＩＷＳ）契約時前納保険料");
        exStringEquals(pBean.getIwsKykznnprsytuukasyu(), null, "（ＩＷＳ）契約時前納保険料領収通貨種類");
        exStringEquals(pBean.getIwsKykznnyenhrkgk(), null, "（ＩＷＳ）契約時前納円貨払込額");
        exStringEquals(pBean.getIwsYenhrkgkhyoujikahi(), null, "（ＩＷＳ）円貨払込額表示可否");
        exStringEquals(pBean.getIwsYenkansanhokenryou(), null, "（ＩＷＳ）円換算保険料");
        exStringEquals(pBean.getIwsJkirsymd(), null, "（ＩＷＳ）次回領収年月");
        exStringEquals(pBean.getIwsYenknsnkijyunymd(), null, "（ＩＷＳ）保険料円換算基準日");
        exStringEquals(pBean.getIwsHokenryoukktikwsrate(), null, "（ＩＷＳ）保険料確定為替レート");
        exStringEquals(pBean.getIwsKwsratekijyunymdsakusei(), null, "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(pBean.getIwsSksikijyunymdkawaserate(), null, "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(pBean.getIwsSibohknkngkyen(), null, "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(pBean.getIwsSibohknkngkgaika(), null, "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(pBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(pBean.getIwsKaiyakujshrgkgaika(), null, "（ＩＷＳ）解約時支払額（外貨）");
        exStringEquals(pBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(pBean.getIwsKaiyakuhrgaika(), null, "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(pBean.getIwsZennouzndkyen(), null, "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(pBean.getIwsZennouzndkgaika(), null, "（ＩＷＳ）前納残高（外貨）");
        exStringEquals(pBean.getIwsSonotasiharaikingakuyen(), null, "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(pBean.getIwsSonotasiharaikingakugk(), null, "（ＩＷＳ）その他支払金額（外貨）");
        exStringEquals(pBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(pBean.getIwsKihrkmpstgkgaika(), null, "（ＩＷＳ）既払込保険料相当額（外貨）");
        exStringEquals(pBean.getIwsRsytuukasyu(), null, "（ＩＷＳ）領収通貨種類");
        exStringEquals(pBean.getIwsKngkksnkekkakbn(), null, "（ＩＷＳ）金額計算結果区分");
        exStringEquals(pBean.getIwsRskngkksnkekkakbn(), null, "（ＩＷＳ）領収金額計算結果区分");
        exStringEquals(pBean.getIwsHrkpgkeiksnkhkbn(), null, "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(pBean.getIwsYakkanbunsyono(), null, "（ＩＷＳ）約款文書番号");

    }
}
