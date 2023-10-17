package yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn;

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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForDirect;
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
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForDirect;
import yuyu.common.hozen.khcommon.KeisanHrrtksnHrkPGkgk;
import yuyu.common.hozen.khcommon.KeisanHrrtksnHrkPGkgkMockForDirect;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForDirect;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.hozen.khcommon.KeisanVHeijyunMockForDirect;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKiykGikHijynNnknOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約詳細取得（外貨建平準払年金）のメイン処理{@link DwGetHozenKiykGikHijynNnknImpl#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwGetHozenKiykGikHijynNnknImplTest_execPostForm extends AbstractTest {

    @Inject
    private DwGetHozenKiykGikHijynNnknImpl dwGetHozenKiykGikHijynNnknImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約詳細取得（外貨建平準払年金）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(DsGetKeiyakuCommon.class).to(DsGetKeiyakuCommonMockForDirect.class);
                bind(DsGetSeigyo.class).to(DsGetSeigyoMockForDirect.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForDirect.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForDirect.class);
                bind(SetNenrei.class).to(SetNenreiMockForDirect.class);
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForDirect.class);
                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForDirect.class);
                bind(KeisanVHeijyun.class).to(KeisanVHeijyunMockForDirect.class);
                bind(KeisanHrrtksnHrkPGkgk.class).to(KeisanHrrtksnHrkPGkgkMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        DsGetKeiyakuCommonMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        DsGetSeigyoMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        KeisanGaikakanzanMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        CalcHkShrKngkMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        SetNenreiMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        KeisanCommonKaiyakuMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        KeisanTukiIkkatuNyuukinGkMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        KeisanVHeijyunMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
        KeisanHrrtksnHrkPGkgkMockForDirect.caller = DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
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

        KeisanGaikakanzanMockForDirect.caller = null;
        KeisanGaikakanzanMockForDirect.SYORIPTN = null;

        CalcHkShrKngkMockForDirect.caller = null;
        CalcHkShrKngkMockForDirect.SYORIPTN = null;

        SetNenreiMockForDirect.caller = null;
        SetNenreiMockForDirect.SYORIPTN = null;

        KeisanCommonKaiyakuMockForDirect.caller = null;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = null;

        KeisanTukiIkkatuNyuukinGkMockForDirect.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = null;

        KeisanVHeijyunMockForDirect.caller = null;
        KeisanVHeijyunMockForDirect.SYORIPTN = null;

        KeisanHrrtksnHrkPGkgkMockForDirect.caller = null;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'abcd'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017201", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykKihon", 0, "18806000025");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017202", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykSya", 0, "18806000025");
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017203", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getHhknSya", 0, "18806000025");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017204", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getKykUkt", 0, "18806000025");
    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017205", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getGamenSeigyo", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "18806000025", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017206", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getHosyou", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "18806000025", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017207", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getTokuyaku", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "18806000025", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017208", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class,
            "getSyoriKahi", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "18806000025", "証券番号");
        exClassificationEquals(dsSyouhinBean.getDsSyouhnbunruiKbn(), C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000014'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017209", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017210", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
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

        pMap.add("gyoumuData", "{'iwsSyono':'18806000036'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017211", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
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

        pMap.add("gyoumuData", "{'iwsSyono':'18806000047'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017212", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
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

        pMap.add("gyoumuData", "{'iwsSyono':'18806000058'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017213", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_A16() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000069'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017214", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikHijynNnknOutputBean);
    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000081", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsAisyoumei(), "たのしみ未来グローバル", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyouhnnm(), "商品名商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykymdstr(), "20190301", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKyktuukasyu(), "USD", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSakuseikijyunymdstr(), "20190325",
            "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKyknmkn(), "カナカナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKyknmkj(), "林さん", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykseiymdstr(), "19990101", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKyksei(), "3", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHhknnmkn(), "サシサシ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHhknseiymdstr(), "19990201", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSbuktnin(), "11", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei1(), "王１", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei2(), "王２", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei3(), "王３", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei4(), "王４", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei5(), "王５", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei6(), "王６", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn7(), "5", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei7(), "王７", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn8(), "4", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn8str(), "06", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei8(), "王８", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn9str(), "05", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei9(), "王９", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktmidasikbn10(), "2", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsUktsimei10(), "王１０", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTrkkzknmkn1(), "サシサシ", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTrkkzknmkn2(), "サシサス", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsGaikanykntkhkumu(), "1", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTargettkhkumu(), "1", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyksbyensitihsyutyhkumu(), "1",
            "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZeiseitkkktkykhukaumu(), "1", "（ＩＷＳ）税制適格特約付加有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsStdrsktkytthkkahikbn(), "1",
            "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkaisuu(), "月払（全期前納・６か月定期一括）", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkeiro(), "口座振替扱い", "（ＩＷＳ）払込経路");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkkn(), "10", "（ＩＷＳ）払込期間");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsNenkinstartymd(), "20600401", "（ＩＷＳ）年金開始年月日");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsNenkinstartnen(), "60", "（ＩＷＳ）年金開始年齢");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSueokikknstr(), "50", "（ＩＷＳ）据置期間（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsNenkinsyustr(), "10年確定年金（定額年金型）", "（ＩＷＳ）年金種類（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsRsgakuyen(),
            BizCurrency.valueOf(10000001, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）領収金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTikiktbrisyuruikbn(), "６か月定期一括", "（ＩＷＳ）定期一括払種類区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsRsgakuyentikiktbri(),
            BizCurrency.valueOf(123456, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）領収金額（円貨）（定期一括払）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennoutikiktbriyenhrkgk(),
            BizCurrency.valueOf(110000002, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）前納定期一括払円貨払込額");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsYoteiriritu(), "20", "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKwsratekijyunymdsakusei(), "20190325",
            "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSksikijyunymdkawaserate(), "0.11",
            "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSbkyhgkyen(),
            BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）死亡給付金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSbkyhgkgaika(),
            BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR).toAdsoluteString(), "（ＩＷＳ）死亡給付金額（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakujshrgkyen(),
            BizCurrency.valueOf(88888888, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakuhryen(),
            BizCurrency.valueOf(33333333, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakuhrgaika(),
            BizCurrency.valueOf(222222.00, BizCurrencyTypes.DOLLAR).toAdsoluteString(), "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennouzndkyen(),
            BizCurrency.valueOf(44444444, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSonotasiharaikingakuyen(),
            BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKihrkmpstgkyen(),
            BizCurrency.valueOf(10000001, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsGenzainohrritu(), "888", "（ＩＷＳ）現在の返戻率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsyen(), "70000000", "（ＩＷＳ）将来年金原資（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsgaika(),
            BizCurrency.valueOf(46150.00, BizCurrencyTypes.DOLLAR).toAdsoluteString(), "（ＩＷＳ）将来年金原資（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyouraihrkmpstgkyen(),
            BizCurrency.valueOf(20000001, BizCurrencyTypes.YEN).toAdsoluteString(), "（ＩＷＳ）将来払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainohrritu(), "349", "（ＩＷＳ）将来の返戻率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTeikiikkatubaraiumu(), "1", "（ＩＷＳ）定期一括払有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennouumu(), "1", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "0", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkpgkeiksnkhkbn(), "1", "（ＩＷＳ）払込保険料合計額計算可否区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsYakkanbunsyono(), "1234567890", "（ＩＷＳ）約款文書番号");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForDirect.class, "exec", 0),
            BizDate.valueOf("20600401"), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetNenreiMockForDirect.class, "exec", 1),
            BizDate.valueOf("19990201"), "生年月日");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "execDivide", 0, 0), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "execDivide", 0, 1), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "execDivide", 0, 2), BizNumber.valueOf(0.12), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "execDivide", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 0, 1), BizCurrency.valueOf(45150.00, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 0, 2), BizNumber.valueOf(0.11), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 1, 1), BizCurrency.valueOf(100004.00, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 1, 2), BizNumber.valueOf(0.11), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(
            KeisanGaikakanzanMockForDirect.class, "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 0), "18806000081", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 1), BizDate.valueOf("20190325"), "計算基準日");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 4), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro) MockObjectManager.getArgument(
            CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 5), C_Hrkkeiro.KOUHURI, "払込経路");

        exStringEquals((String) MockObjectManager.getArgument(
            KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 0),
            KeisanCommonKaiyaku.KINOUBUNRUI_DRCTSERVICE, "機能分類");
        IT_KykKihon kykKihon =
            (IT_KykKihon) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 1);
        exStringEquals(kykKihon.getKbnkey(), "08", "区分キー");
        exStringEquals(kykKihon.getSyono(), "18806000081", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(
            KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 2), BizDate.valueOf("20190325"), "処理年月日");
        KeisanKaiyakuBean keisanKaiyakuBean =
            (KeisanKaiyakuBean) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin",
                0, 3);
        exDateEquals(keisanKaiyakuBean.getSyoruiukeymd(), BizDate.valueOf("20190325"), "書類受付日");
        exDateEquals(keisanKaiyakuBean.getKaiykymd(), BizDate.valueOf("20190325"), "解約日");
        exBizCalcbleEquals(keisanKaiyakuBean.getYenshrkwsrate(), BizNumber.valueOf(0.11), "円支払為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean =
            (KeisanIkkatuNyuukinGkBean) MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForDirect.class, "exec", 0, 0);
        KeisanIkkatuNyuukinGkSyouhnBean KeisanIkkatuNyuukinGkSyouhnBean =
            keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst().get(0);
        exStringEquals(KeisanIkkatuNyuukinGkSyouhnBean.getSyouhnCd(), "ﾕﾁ", "商品コード");
        exNumericEquals(KeisanIkkatuNyuukinGkSyouhnBean.getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(KeisanIkkatuNyuukinGkSyouhnBean.getRyouritusdNo(), "3", "料率世代番号");
        exBizCalcbleEquals(KeisanIkkatuNyuukinGkSyouhnBean.getYoteiRiritu(),BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(KeisanIkkatuNyuukinGkSyouhnBean.getHokenryou(),
            BizCurrency.valueOf(23456, BizCurrencyTypes.YEN), "保険料");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 6, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS,
            "定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.USD, "領収通貨種類");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.BLNK, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.BLNK, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), null, "領収年月日");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), null, "充当開始年月");
        exBooleanEquals((boolean) MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForDirect.class, "exec", 0, 1), false, "一括割引不要フラグ");

        KeisanVHeijyunBean keisanVHeijyunBean =
            (KeisanVHeijyunBean) MockObjectManager.getArgument(KeisanVHeijyunMockForDirect.class, "exec", 0, 0);

        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "ﾕﾁ", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "3", "料率世代番号");
        exDateYMEquals(keisanVHeijyunBean.getCalckijyunYm(), BizDateYM.valueOf("206004"), "計算基準年月");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf("20190301"), "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(23456, BizCurrencyTypes.YEN), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 20, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 80, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exClassificationEquals(keisanVHeijyunBean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateEquals(keisanVHeijyunBean.getFstpryosyu(), BizDate.valueOf("20190215"), "初回保険料領収日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(0.0125), "最低保証利率");
        exDateYMEquals(keisanVHeijyunBean.getTmttkntaisyouym(), BizDateYM.valueOf("202003"), "積立金対象年月");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitenv(),
            BizCurrency.valueOf(123456, BizCurrencyTypes.YEN), "計算開始年月時点Ｖ");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitensump(),
            BizCurrency.valueOf(654321, BizCurrencyTypes.YEN), "計算開始年月時点累計Ｐ");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI_SISAN, "試算種類区分");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), BizDate.valueOf("20190325"), "予測計算開始日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), BizNumber.valueOf(0.0050), "予測計算予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), BizNumber.valueOf(0.12), "予測計算為替レート");

        exStringEquals((String) MockObjectManager.getArgument(
            KeisanHrrtksnHrkPGkgkMockForDirect.class, "exec", 0, 0), "18806000081", "証券番号");

    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_A19() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000092'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000092", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkaisuu(), "月払（６か月定期一括）", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSueokikknstr(), "0", "（ＩＷＳ）据置期間（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsNenkinsyustr(), "年金総額保証付終身年金", "（ＩＷＳ）年金種類（文字列）");
    }

    @Test
    @TestOrder(200)
    public void testExecPostForm_A20() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN2;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000106'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000106", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkaisuu(), "月払（全期前納・１２か月定期一括）", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainohrritu(), null, "（ＩＷＳ）将来の返戻率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTeikiikkatubaraiumu(), "1", "（ＩＷＳ）定期一括払有無");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean =
            (KeisanIkkatuNyuukinGkBean) MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForDirect.class, "exec", 0, 0);
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 12, "充当月数");

        KeisanVHeijyunBean keisanVHeijyunBean =
            (KeisanVHeijyunBean) MockObjectManager.getArgument(KeisanVHeijyunMockForDirect.class, "exec", 0, 0);

        exDateYMEquals(keisanVHeijyunBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitenv(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),
            "計算開始年月時点Ｖ");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitensump(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "計算開始年月時点累計Ｐ");
    }

    @Test
    @TestOrder(210)
    public void testExecPostForm_A21() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN2;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000117'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000117", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkaisuu(), "月払（１２か月定期一括）", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsNenkinsyustr(), "5年確定年金（第１回年金倍額型）",
            "（ＩＷＳ）年金種類（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsyen(), null, "（ＩＷＳ）将来年金原資（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsgaika(),
            null, "（ＩＷＳ）将来年金原資（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainohrritu(), null, "（ＩＷＳ）将来の返戻率");
    }

    @Test
    @TestOrder(220)
    public void testExecPostForm_A22() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN2;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN4;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000128'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000128", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkkaisuu(), "月払", "（ＩＷＳ）払込回数");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsNenkinsyustr(), "", "（ＩＷＳ）年金種類（文字列）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsRsgakuyen(),
            null, "（ＩＷＳ）領収金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTikiktbrisyuruikbn(), "", "（ＩＷＳ）定期一括払種類区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsRsgakuyentikiktbri(),
            null, "（ＩＷＳ）領収金額（円貨）（定期一括払）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennoutikiktbriyenhrkgk(),
            null, "（ＩＷＳ）前納定期一括払円貨払込額");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsYoteiriritu(), BizNumber.valueOf(0).toString(),
            "（ＩＷＳ）予定利率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKwsratekijyunymdsakusei(), null,
            "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSksikijyunymdkawaserate(), BizNumber.valueOf(0)
            .toString(), "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSbkyhgkyen(),
            null, "（ＩＷＳ）死亡給付金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSbkyhgkgaika(),
            null, "（ＩＷＳ）死亡給付金額（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakujshrgkyen(),
            null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakuhryen(),
            null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKaiyakuhrgaika(),
            null, "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennouzndkyen(),
            null, "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSonotasiharaikingakuyen(),
            null, "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKihrkmpstgkyen(),
            null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsGenzainohrritu(), null, "（ＩＷＳ）現在の返戻率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsyen(), null, "（ＩＷＳ）将来年金原資（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsgaika(),
            null, "（ＩＷＳ）将来年金原資（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainohrritu(), null, "（ＩＷＳ）将来の返戻率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsTeikiikkatubaraiumu(), "0", "（ＩＷＳ）定期一括払有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsHrkpgkeiksnkhkbn(), "0", "（ＩＷＳ）払込保険料合計額計算可否区分");
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean =
            (KeisanIkkatuNyuukinGkBean) MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForDirect.class, "exec", 0, 0);
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 0, "充当月数");
    }

    @Test
    @TestOrder(230)
    public void testExecPostForm_A23() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN2;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000139'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000139", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean =
            (KeisanIkkatuNyuukinGkBean) MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForDirect.class, "exec", 0, 0);
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 1, "充当月数");
    }

    @Test
    @TestOrder(240)
    public void testExecPostForm_A24() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000081", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
    }

    @Test
    @TestOrder(250)
    public void testExecPostForm_A25() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000081", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsGenzainohrritu(), null, "（ＩＷＳ）現在の返戻率");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
    }



    @Test
    @TestOrder(270)
    public void testExecPostForm_A27() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN2;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000081", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
    }

    @Test
    @TestOrder(340)
    public void testExecPostForm_A34() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000140'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000140", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");

    }

    @Test
    @TestOrder(350)
    public void testExecPostForm_A35() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000151'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000151", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsZennouumu(), "0", "（ＩＷＳ）前納有無");

    }

    @Test
    @TestOrder(360)
    public void testExecPostForm_A36() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN2;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKihrkmpstgkyen(),
            null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyouraihrkmpstgkyen(),
            null, "（ＩＷＳ）将来払込保険料相当額（円貨）");
    }

    @Test
    @TestOrder(370)
    public void testExecPostForm_A37() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKihrkmpstgkyen(),
            null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyouraihrkmpstgkyen(),
            null, "（ＩＷＳ）将来払込保険料相当額（円貨）");

    }

    @Test
    @TestOrder(380)
    public void testExecPostForm_A38() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN4;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKihrkmpstgkyen(),
            null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyouraihrkmpstgkyen(),
            null, "（ＩＷＳ）将来払込保険料相当額（円貨）");
    }

    @Test
    @TestOrder(390)
    public void testExecPostForm_A39() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN2;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;


        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000081", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsyen(), null, "（ＩＷＳ）将来年金原資（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsgaika(),
            null, "（ＩＷＳ）将来年金原資（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
    }

    @Test
    @TestOrder(400)
    public void testExecPostForm_A40() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000162'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000162", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsyen(), null, "（ＩＷＳ）将来年金原資（円貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyourainkgnsgaika(),
            null, "（ＩＷＳ）将来年金原資（外貨）");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsKngkksnkekkakbn(), "1", "（ＩＷＳ）金額計算結果区分");
    }

    @Test
    @TestOrder(410)
    public void testExecPostForm_A41() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForDirect.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForDirect.TESTPATTERN1;
        KeisanVHeijyunMockForDirect.SYORIPTN = KeisanVHeijyunMockForDirect.TESTPATTERN1;
        KeisanHrrtksnHrkPGkgkMockForDirect.SYORIPTN = KeisanHrrtksnHrkPGkgkMockForDirect.TESTPATTERN2;

        changeSystemDate(BizDate.valueOf("20190325"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsSyono(), "18806000081", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsGenzainohrritu(), null, "（ＩＷＳ）現在の返戻率");
    }

    @Test
    @TestOrder(500)
    public void testExecPostForm_B1() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017217", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(510)
    public void testExecPostForm_B2() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'18806000081'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikHijynNnknOutputBean wsDwGetHozenKiykGikHijynNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikHijynNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikHijynNnknOutputBean.getIwsDsmsgcd(), "017216", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(520)
    public void testExecPostForm_B3() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'18806000081'}");

        String className = "";

        try {
            dwGetHozenKiykGikHijynNnknImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外のクラス名");

    }

    private void test(WsDwGetHozenKiykGikHijynNnknOutputBean pBean) {

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
        exStringEquals(pBean.getIwsSbhsyumukbn(), null, "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(pBean.getIwsKghsyumukbn(), null, "（ＩＷＳ）介護保障有無区分");
        exStringEquals(pBean.getIwsIryhsyumukbn(), null, "（ＩＷＳ）医療保障有無区分");
        exStringEquals(pBean.getIwsRougohsyumukbn(), null, "（ＩＷＳ）老後保障有無区分");
        exStringEquals(pBean.getIwsKykdrtkhkumu(), null, "（ＩＷＳ）保険契約者代理特約付加有無");
        exStringEquals(pBean.getIwsStdrsktkyhkumu(), null, "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(pBean.getIwsYennykntkhkumu(), null, "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(pBean.getIwsGaikanykntkhkumu(), null, "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(pBean.getIwsTargettkhkumu(), null, "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(pBean.getIwsSyksbyensitihsyutyhkumu(), null, "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(pBean.getIwsJyudkaigomehrtkhkumu(), null, "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(pBean.getIwsZeiseitkkktkykhukaumu(), null, "（ＩＷＳ）税制適格特約付加有無");
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
        exStringEquals(pBean.getIwsNenkinstartymd(), null, "（ＩＷＳ）年金開始年月日");
        exStringEquals(pBean.getIwsNenkinstartnen(), null, "（ＩＷＳ）年金開始年齢");
        exStringEquals(pBean.getIwsSueokikknstr(), null, "（ＩＷＳ）据置期間（文字列）");
        exStringEquals(pBean.getIwsNenkinsyustr(), null, "（ＩＷＳ）年金種類（文字列）");
        exStringEquals(pBean.getIwsRsgakuyen(), null, "（ＩＷＳ）領収金額（円貨）");
        exStringEquals(pBean.getIwsTikiktbrisyuruikbn(), null, "（ＩＷＳ）定期一括払種類区分");
        exStringEquals(pBean.getIwsRsgakuyentikiktbri(), null, "（ＩＷＳ）領収金額（円貨）（定期一括払）");
        exStringEquals(pBean.getIwsZennoutikiktbriyenhrkgk(), null, "（ＩＷＳ）前納定期一括払円貨払込額");
        exStringEquals(pBean.getIwsYoteiriritu(), null, "（ＩＷＳ）予定利率");
        exStringEquals(pBean.getIwsKwsratekijyunymdsakusei(), null, "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(pBean.getIwsSksikijyunymdkawaserate(), null, "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(pBean.getIwsSbkyhgkyen(), null, "（ＩＷＳ）死亡給付金額（円貨）");
        exStringEquals(pBean.getIwsSbkyhgkgaika(), null, "（ＩＷＳ）死亡給付金額（外貨）");
        exStringEquals(pBean.getIwsKaiyakujshrgkyen(), null, "（ＩＷＳ）解約時支払額（円貨）");
        exStringEquals(pBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(pBean.getIwsKaiyakuhrgaika(), null, "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(pBean.getIwsZennouzndkyen(), null, "（ＩＷＳ）前納残高（円貨）");
        exStringEquals(pBean.getIwsSonotasiharaikingakuyen(), null, "（ＩＷＳ）その他支払金額（円貨）");
        exStringEquals(pBean.getIwsKihrkmpstgkyen(), null, "（ＩＷＳ）既払込保険料相当額（円貨）");
        exStringEquals(pBean.getIwsGenzainohrritu(), null, "（ＩＷＳ）現在の返戻率");
        exStringEquals(pBean.getIwsSyourainkgnsyen(), null, "（ＩＷＳ）将来年金原資（円貨）");
        exStringEquals(pBean.getIwsSyourainkgnsgaika(), null, "（ＩＷＳ）将来年金原資（外貨）");
        exStringEquals(pBean.getIwsSyouraihrkmpstgkyen(), null, "（ＩＷＳ）将来払込保険料相当額（円貨）");
        exStringEquals(pBean.getIwsSyourainohrritu(), null, "（ＩＷＳ）将来の返戻率");
        exStringEquals(pBean.getIwsTeikiikkatubaraiumu(), null, "（ＩＷＳ）定期一括払有無");
        exStringEquals(pBean.getIwsZennouumu(), null, "（ＩＷＳ）前納有無");
        exStringEquals(pBean.getIwsKngkksnkekkakbn(), null, "（ＩＷＳ）金額計算結果区分");
        exStringEquals(pBean.getIwsHrkpgkeiksnkhkbn(), null, "（ＩＷＳ）払込保険料合計額計算可否区分");

    }
}
