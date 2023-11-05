package yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn;

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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
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
import yuyu.common.direct.dscommon.DsTeirituTumitatekinKeisan;
import yuyu.common.direct.dscommon.DsTeirituTumitatekinKeisanMockForDirect;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheck;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckMockForDirect;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKiykGikItijiNnknOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約詳細取得（外貨建一時払年金）のメイン処理{@link DwGetHozenKiykGikItijiNnknImpl#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwGetHozenKiykGikItijiNnknImplTest_execPostForm extends AbstractTest {

    @Inject
    private DwGetHozenKiykGikItijiNnknImpl dwGetHozenKiykGikItijiNnknImpl;

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf("20180625"));
    }

    private BizDate sysDate;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約詳細取得（外貨建一時払年金）";

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
                bind(DsTumitatekinItenCheck.class).to(DsTumitatekinItenCheckMockForDirect.class);
                bind(DsTeirituTumitatekinKeisan.class).to(DsTeirituTumitatekinKeisanMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        DsGetKeiyakuCommonMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        DsGetSeigyoMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        KeisanGaikakanzanMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        CalcHkShrKngkMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        SetNenreiMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        DsTumitatekinItenCheckMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;
        DsTeirituTumitatekinKeisanMockForDirect.caller = DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class;

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
        DsTumitatekinItenCheckMockForDirect.caller = null;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = null;
        DsTeirituTumitatekinKeisanMockForDirect.caller = null;
        DsTeirituTumitatekinKeisanMockForDirect.SYORIPTN = null;

    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011100", "（ＩＷＳ）ＤＳメッセージコード");

        test(wsDwGetHozenKiykGikItijiNnknOutputBean);

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, C_AccessLogSyubetuKbn.ACTION_BEGIN);
    }

    @Test
    @TestOrder(2010)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'100000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011100", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011201", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011202", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011203", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011204", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class, "getGamenSeigyo", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806000848", "証券番号");
        exStringEquals(dsSyouhinBean.getDsSyouhnbunruiKbn().getValue(), "3", "ＤＳ商品分類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011205", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class, "getHosyou", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806001045", "証券番号");
        exStringEquals(dsSyouhinBean.getDsSyouhnbunruiKbn().getValue(), "3", "ＤＳ商品分類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011206", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        pMap.add("gyoumuData", "{'iwsSyono':'60806001241'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class, "getTokuyaku", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806001241", "証券番号");
        exStringEquals(dsSyouhinBean.getDsSyouhnbunruiKbn().getValue(), "3", "ＤＳ商品分類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011207", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        pMap.add("gyoumuData", "{'iwsSyono':'60806001241'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        DsSyouhinBean dsSyouhinBean = (DsSyouhinBean) MockObjectManager.getArgument(DsGetSeigyoMockForDirect.class, "getSyoriKahi", 0, 0);
        exStringEquals(dsSyouhinBean.getSyoNo(), "60806001241", "証券番号");
        exStringEquals(dsSyouhinBean.getDsSyouhnbunruiKbn().getValue(), "3", "ＤＳ商品分類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011208", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011200", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011209", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011210", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
    }

    @Test
    @TestOrder(5030)
    public void testExecPostForm_A14() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806001849'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011211", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
    }

    @Test
    @TestOrder(5040)
    public void testExecPostForm_A15() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806002046'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011212", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
    }

    @Test
    @TestOrder(5050)
    public void testExecPostForm_A16() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN6;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806019529'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011213", "（ＩＷＳ）ＤＳメッセージコード");
        test(wsDwGetHozenKiykGikItijiNnknOutputBean);
    }

    @Test
    @TestOrder(6010)
    public void testExecPostForm_B1() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN1;
        DsTeirituTumitatekinKeisanMockForDirect.SYORIPTN = DsTeirituTumitatekinKeisanMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806012407'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyono(), "60806012407", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsAisyoumei() ,"ふるはーとＪロードグローバル", "（ＩＷＳ）愛称名区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyouhnnm() ,"商品名商品名", "（ＩＷＳ）商品名");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKykymdstr() ,"20180404", "（ＩＷＳ）契約日（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKyktuukasyu() ,"JPY", "（ＩＷＳ）契約通貨種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSakuseikijyunymdstr() ,"20180305", "（ＩＷＳ）作成基準日（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKyknmkn() ,"カナカナ", "（ＩＷＳ）契約者名（カナ）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKyknmkj() ,"林さん", "（ＩＷＳ）契約者名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKykseiymdstr() ,"20170305", "（ＩＷＳ）契約者生年月日（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKyksei() ,"3", "（ＩＷＳ）契約者性別");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHhknnmkn() ,"サシサシ", "（ＩＷＳ）被保険者名（カナ）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHhknseiymdstr() ,"20170525", "（ＩＷＳ）被保険者生年月日（文字列） ");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSbuktnin() ,"11", "（ＩＷＳ）死亡受取人人数");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn1() ,"1", "（ＩＷＳ）受取人見出し区分１");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn1str() ,"01", "（ＩＷＳ）受取人区分１（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei1() ,"王１", "（ＩＷＳ）受取人氏名１");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn2() ,"2", "（ＩＷＳ）受取人見出し区分２");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn2str() ,"02", "（ＩＷＳ）受取人区分２（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei2() ,"王２", "（ＩＷＳ）受取人氏名２");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn3() ,"3", "（ＩＷＳ）受取人見出し区分３");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn3str() ,"03", "（ＩＷＳ）受取人区分３（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei3() ,"王３", "（ＩＷＳ）受取人氏名３");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn4() ,"4", "（ＩＷＳ）受取人見出し区分４");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn4str() ,"04", "（ＩＷＳ）受取人区分４（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei4() ,"王４", "（ＩＷＳ）受取人氏名４");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn5() ,"5", "（ＩＷＳ）受取人見出し区分５");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn5str() ,"05", "（ＩＷＳ）受取人区分５（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei5() ,"王５", "（ＩＷＳ）受取人氏名５");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn6() ,"9", "（ＩＷＳ）受取人見出し区分６");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn6str() ,"06", "（ＩＷＳ）受取人区分６（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei6() ,"王６", "（ＩＷＳ）受取人氏名６");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn7() ,"5", "（ＩＷＳ）受取人見出し区分７");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn7str() ,"07", "（ＩＷＳ）受取人区分７（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei7() ,"王７", "（ＩＷＳ）受取人氏名７");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn8() ,"4", "（ＩＷＳ）受取人見出し区分８");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn8str() ,"06", "（ＩＷＳ）受取人区分８（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei8() ,"王８", "（ＩＷＳ）受取人氏名８");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn9() ,"3", "（ＩＷＳ）受取人見出し区分９");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn9str() ,"05", "（ＩＷＳ）受取人区分９（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei9() ,"王９", "（ＩＷＳ）受取人氏名９");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktmidasikbn10() ,"2", "（ＩＷＳ）受取人見出し区分１０");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktkbn10str() ,"04", "（ＩＷＳ）受取人区分１０（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsUktsimei10() ,"王１０", "（ＩＷＳ）受取人氏名１０");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTrkkzknmkn1() ,"カナ１", "（ＩＷＳ）登録家族名（カナ）１");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTrkkzknmkn2() ,"カナ２", "（ＩＷＳ）登録家族名（カナ）２");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTutakinumukbn() ,"1", "（ＩＷＳ）積立金有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKaiyakuhrsuiiumukbn() ,"0", "（ＩＷＳ）解約返戻金推移有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSbhsyumukbn() ,"1", "（ＩＷＳ）死亡保障有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKghsyumukbn() ,"1", "（ＩＷＳ）介護保障有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsIryhsyumukbn() ,"1", "（ＩＷＳ）医療保障有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRougohsyumukbn() ,"1", "（ＩＷＳ）老後保障有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKykdrtkhkumu() ,"1", "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsStdrsktkyhkumu() ,"1", "（ＩＷＳ）指定代理請求特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsYennykntkhkumu() ,"1", "（ＩＷＳ）円入金特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsGaikanykntkhkumu() ,"1", "（ＩＷＳ）外貨入金特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTargettkhkumu() ,"1", "（ＩＷＳ）ターゲット特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyksbyensitihsyutyhkumu() ,"1", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsJyudkaigomehrtkhkumu() ,"1", "（ＩＷＳ）重度介護前払特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsZeiseitkkktkykhukaumu() ,"1", "（ＩＷＳ）税制適格特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKjsmsaihakkoukahikbn() ,"1", "（ＩＷＳ）控除証明書再発行処理可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKykmeigihnkkahikbn() ,"1", "（ＩＷＳ）名義変更処理可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyoukensaihkkahikbn() ,"1", "（ＩＷＳ）証券再発行処理可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsStdrsktkytthkkahikbn() ,"1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTargettkhkkahikbn() ,"1", "（ＩＷＳ）ターゲット特約変更可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKykniyusyoukaikahikbn() ,"1", "（ＩＷＳ）契約内容照会可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTumitatekinitenkahikbn() ,"1", "（ＩＷＳ）積立金移転可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDskaiyakukahikbn() ,"1", "（ＩＷＳ）ＤＳ解約可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsAdrhenkoukahikbn() ,"1", "（ＩＷＳ）住所変更可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPhrkhouhenkoukahikbn() ,"1", "（ＩＷＳ）保険料払込方法変更可否区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSksikijyunymdkawaserate() ,"90.12", "（ＩＷＳ）作成基準日為替レート");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKwsratekijyunymdsakusei() ,"20180625", "（ＩＷＳ）為替レート基準日（作成基準日）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsytuukasyu() ,"USD", "（ＩＷＳ）領収通貨種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsymdkawaserate() ,"88.74", "（ＩＷＳ）領収日為替レート");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsymdkawaseratestigi() ,"0.728", "（ＩＷＳ）領収日為替レート（指定外通貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKwsratekijyunymdrs() ,"20170705", "（ＩＷＳ）為替レート基準日（領収日）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKwsratekijyunymdrsstigi() ,"20170705", "（ＩＷＳ）為替レート基準日（領収日）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsgakuyen() ,"0", "（ＩＷＳ）領収金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsgakustigi() ,"10000000", "（ＩＷＳ）領収金額（指定外通貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKijyunkingaku() ,"12181195", "（ＩＷＳ）基準金額");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsItijibrprsgaika() ,"13726836", "（ＩＷＳ）一時払保険料（領収日）（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsMkhgkwari() ,"150", "（ＩＷＳ）目標額割合");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHokenkngkksnkekkakbn() ,"0", "（ＩＷＳ）保険金額計算結果区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSueokikknstr() ,"99", "（ＩＷＳ）据置期間（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinsyustr() ,"", "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinkkn() ,"0", "（ＩＷＳ）年金期間");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinstartymd() ,"99991231", "（ＩＷＳ）年金支払開始日");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinstartnen() ,"43", "（ＩＷＳ）年金開始年齢");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKihonkyhgkgaika() ,"1234567890123", "（ＩＷＳ）基本給付金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSbkyhgkyen() ,"1234", "（ＩＷＳ）死亡給付金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSbkyhgkgaika() ,"6666", "（ＩＷＳ）死亡給付金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtumitatekngkyen() ,"1234", "（ＩＷＳ）保険料積立金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtumitatekngkgaika() ,"7777", "（ＩＷＳ）保険料積立金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKaiyakuhryen() ,"1234", "（ＩＷＳ）解約返戻金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKaiyakuhrgaika() ,"5555", "（ＩＷＳ）解約返戻金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkyenteiritu() ,"1234", "（ＩＷＳ）保険料積立金額（円貨）（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkgaikateiritu() ,"8888", "（ＩＷＳ）保険料積立金額（外貨）（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHaibunwariteiritu() ,"100", "（ＩＷＳ）配分割合（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTumitateriritustr() ,"12.30", "（ＩＷＳ）積立利率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSisuusyu() ,"ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "（ＩＷＳ）指数種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkyensisuu() ,"1234", "（ＩＷＳ）保険料積立金額（円貨）（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkgaikasisuu() ,"9999", "（ＩＷＳ）保険料積立金額（外貨）（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHaibunwarisisuu() ,"0", "（ＩＷＳ）配分割合（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTmttknzkrt() ,"", "（ＩＷＳ）積立金増加率");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSisuuupritu() ,"", "（ＩＷＳ）指数上昇率");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSetteibairitustr() ,"4.56", "（ＩＷＳ）設定倍率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTumitatekinitenyoteibi() ,"20190404", "（ＩＷＳ）積立金移転予定日");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTmttknitnttdkumukbn() ,"1", "（ＩＷＳ）積立金移転手続有無区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTmttknzkrtjygnstr() ,"78.90", "（ＩＷＳ）積立金増加率上限（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsYakkanbunsyono() ,"1234567890", "（ＩＷＳ）約款文書番号");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRendouritustr() ,"12.40", "（ＩＷＳ）連動率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrtkykhukaumu() ,"1", "（ＩＷＳ）定期支払特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikisiharaikin() ,"1234567890123", "（ＩＷＳ）定期支払金");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrkinshrtuukasyu() ,"USD", "（ＩＷＳ）定期支払金支払通貨種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzsyuruikbn() ,"2", "（ＩＷＳ）口座種類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBankcd() ,"0001", "（ＩＷＳ）銀行コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitencd() ,"001", "（ＩＷＳ）支店コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBanknmkj() ,"受取人ユ受名　一えウ受取人ユ受名　一えウ受取人ユ受名　一えウ", "（ＩＷＳ）銀行名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitennmkj() ,"受取人ユ受名　一えウ受取人ユ受名　一えウ受取人ユ受名　一ウえ", "（ＩＷＳ）支店名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsYokinkbn() ,"3", "（ＩＷＳ）預金種目区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKouzano() ,"213456789012", "（ＩＷＳ）口座番号");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzmeiginmkn() ,"ユ受名受取人　一えウ受取人ユ受名　一えウ受取人ユ受名　一ウえ", "（ＩＷＳ）口座名義人氏名（カナ）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyrnkgnshyjchkrsltkbn(), "0", "（ＩＷＳ）将来年金原資表示チェック結果区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyourainkgnsgaika(), "1034567890", "（ＩＷＳ）将来年金原資（外貨）");

        CurrencyType currencyType = BizCurrencyTypes.YEN;

        sysDate = BizDate.getSysDate();

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 0), "60806012407", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 1), sysDate, "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForDirect.class, "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 0, 1), BizCurrency.valueOf(7777L, currencyType), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 0, 2), BizNumber.valueOf(90.12), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 1, 1), BizCurrency.valueOf(5555L, currencyType), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 1, 2), BizNumber.valueOf(90.12), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 2, 1), BizCurrency.valueOf(6666L, currencyType), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 2, 2), BizNumber.valueOf(90.12), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 3, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 3, 1), BizCurrency.valueOf(8888L, currencyType), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 3, 2), BizNumber.valueOf(90.12), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 3, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 4, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 4, 1), BizCurrency.valueOf(9999L, currencyType), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 4, 2), BizNumber.valueOf(90.12), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForDirect.class, "exec", 4, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForDirect.class, "exec", 0, 0), BizDate.valueOf(99991231), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetNenreiMockForDirect.class, "exec", 0, 1), BizDate.valueOf(20170525), "生年月日");

        exStringEquals((String)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkDsTumitatekinItenUketukeUmu", 0, 0), "60806012407", "証券番号");

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getTrkKazoku", 0, "60806012407");

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getUketoriKouza", 0, "60806012407");

        exStringEquals((String)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkTumitatekinIten", 0, 0), "60806012407", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkTumitatekinIten", 0, 1), BizDate.valueOf(20180625), "受付日");
        exDateEquals((BizDate)MockObjectManager.getArgument(DsTumitatekinItenCheckMockForDirect.class, "checkTumitatekinIten", 0, 2), BizDate.valueOf(20190404), "積立金移転予定日");

        exStringEquals((String)MockObjectManager.getArgument(DsTeirituTumitatekinKeisanMockForDirect.class, "keisanNkGnsGk", 0, 0), "60806012407", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(DsTeirituTumitatekinKeisanMockForDirect.class, "keisanNkGnsGk", 0, 1), BizDate.valueOf(20180625), "計算基準年月日");
        IT_KykSyouhn kykSyouhn =(IT_KykSyouhn)MockObjectManager.getArgument(DsTeirituTumitatekinKeisanMockForDirect.class, "keisanNkGnsGk", 2);
        exStringEquals(kykSyouhn.getSyono(), "60806012407", "証券番号");
        IT_KykSonotaTkyk kykSonotaTkyk =(IT_KykSonotaTkyk)MockObjectManager.getArgument(DsTeirituTumitatekinKeisanMockForDirect.class, "keisanNkGnsGk", 3);
        exStringEquals(kykSonotaTkyk.getSyono(), "60806012407", "証券番号");
    }

    @Test
    @TestOrder(6015)
    public void testExecPostForm_B2() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN7;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN3;
        DsTeirituTumitatekinKeisanMockForDirect.SYORIPTN = DsTeirituTumitatekinKeisanMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806010900'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsMkhgkwari() ,"0", "（ＩＷＳ）目標額割合");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRendouritustr() ,"12.34", "（ＩＷＳ）連動率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrtkykhukaumu() ,"1", "（ＩＷＳ）定期支払特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikisiharaikin() ,"0", "（ＩＷＳ）定期支払金");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrkinshrtuukasyu() ,"JPY", "（ＩＷＳ）定期支払金支払通貨種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzsyuruikbn() ,"0", "（ＩＷＳ）口座種類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBankcd() ,"", "（ＩＷＳ）銀行コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitencd() ,"", "（ＩＷＳ）支店コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBanknmkj() ,"", "（ＩＷＳ）銀行名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitennmkj() ,"", "（ＩＷＳ）支店名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsYokinkbn() ,"0", "（ＩＷＳ）預金種目区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKouzano() ,"", "（ＩＷＳ）口座番号");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzmeiginmkn() ,"", "（ＩＷＳ）口座名義人氏名（カナ）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyrnkgnshyjchkrsltkbn(), "0", "（ＩＷＳ）将来年金原資表示チェック結果区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyourainkgnsgaika(), null, "（ＩＷＳ）将来年金原資（外貨）");

    }

    @Test
    @TestOrder(6020)
    public void testExecPostForm_B3() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN5;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN2;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806012500'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSksikijyunymdkawaserate() ,"122.91", "（ＩＷＳ）作成基準日為替レート");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKwsratekijyunymdsakusei() ,"20180625", "（ＩＷＳ）為替レート基準日（作成基準日）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsymdkawaserate() ,"0", "（ＩＷＳ）領収日為替レート");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKwsratekijyunymdrs() ,null, "（ＩＷＳ）為替レート基準日（領収日）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsymdkawaseratestigi() ,"0", "（ＩＷＳ）領収日為替レート（指定外通貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKwsratekijyunymdrsstigi() ,null, "（ＩＷＳ）為替レート基準日（領収日）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtumitatekngkgaika() ,"0", "（ＩＷＳ）保険料積立金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKaiyakuhrgaika() ,"0", "（ＩＷＳ）解約返戻金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSbkyhgkgaika() ,"0", "（ＩＷＳ）死亡給付金額（外貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkgaikateiritu() ,"0", "（ＩＷＳ）保険料積立金額（外貨）（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkgaikasisuu() ,"0", "（ＩＷＳ）保険料積立金額（外貨）（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtumitatekngkyen() ,"0", "（ＩＷＳ）保険料積立金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKaiyakuhryen() ,"0", "（ＩＷＳ）解約返戻金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSbkyhgkyen() ,"0", "（ＩＷＳ）死亡給付金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkyenteiritu() ,"0", "（ＩＷＳ）保険料積立金額（円貨）（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsPtmttkngkyensisuu() ,"0", "（ＩＷＳ）保険料積立金額（円貨）（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsgakuyen() ,"11100000", "（ＩＷＳ）領収金額（円貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRsgakustigi() ,"0", "（ＩＷＳ）領収金額（指定外通貨）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsMkhgkwari() ,"0", "（ＩＷＳ）目標額割合");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKijyunkingaku() ,"0", "（ＩＷＳ）基準金額");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinsyustr() ,"13年確定年金", "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHokenkngkksnkekkakbn() ,"1", "（ＩＷＳ）保険金額計算結果区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinstartnen() ,"43", "（ＩＷＳ）年金開始年齢");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHaibunwariteiritu() ,"0", "（ＩＷＳ）配分割合（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHaibunwarisisuu() ,"100", "（ＩＷＳ）配分割合（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTumitateriritustr() ,"0.00", "（ＩＷＳ）積立利率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSetteibairitustr() ,"0.00", "（ＩＷＳ）設定倍率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTmttknzkrtjygnstr() ,"0.00", "（ＩＷＳ）積立金増加率上限（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyrnkgnshyjchkrsltkbn(), "1", "（ＩＷＳ）将来年金原資表示チェック結果区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyourainkgnsgaika(), null, "（ＩＷＳ）将来年金原資（外貨）");
    }

    @Test
    @TestOrder(6030)
    public void testExecPostForm_B4() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN8;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN4;
        DsTeirituTumitatekinKeisanMockForDirect.SYORIPTN = DsTeirituTumitatekinKeisanMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'60806010807'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsMkhgkwari() ,"110", "（ＩＷＳ）目標額割合");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsNenkinsyustr() ,"年金総額保証付終身年金", "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHaibunwariteiritu() ,"86", "（ＩＷＳ）配分割合（定率積立部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsHaibunwarisisuu() ,"14", "（ＩＷＳ）配分割合（指数連動部分）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRendouritustr() ,"0.00", "（ＩＷＳ）連動率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrtkykhukaumu() ,"1", "（ＩＷＳ）定期支払特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikisiharaikin() ,"0", "（ＩＷＳ）定期支払金");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrkinshrtuukasyu() ,"JPY", "（ＩＷＳ）定期支払金支払通貨種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzsyuruikbn() ,"0", "（ＩＷＳ）口座種類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBankcd() ,"", "（ＩＷＳ）銀行コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitencd() ,"", "（ＩＷＳ）支店コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBanknmkj() ,"", "（ＩＷＳ）銀行名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitennmkj() ,"", "（ＩＷＳ）支店名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsYokinkbn() ,"0", "（ＩＷＳ）預金種目区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKouzano() ,"", "（ＩＷＳ）口座番号");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzmeiginmkn() ,"", "（ＩＷＳ）口座名義人氏名（カナ）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyrnkgnshyjchkrsltkbn(), "0", "（ＩＷＳ）将来年金原資表示チェック結果区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSyourainkgnsgaika(), "1034567890", "（ＩＷＳ）将来年金原資（外貨）");

    }

    @Test
    @TestOrder(6040)
    public void testExecPostForm_B5() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN9;
        DsGetSeigyoMockForDirect.SYORIPTN = DsGetSeigyoMockForDirect.TESTPATTERN5;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN1;
        SetNenreiMockForDirect.SYORIPTN = SetNenreiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000297'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);
        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTumitateriritustr() ,"2.00", "（ＩＷＳ）積立利率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSetteibairitustr() ,"4.00", "（ＩＷＳ）設定倍率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTmttknzkrtjygnstr() ,"3.00", "（ＩＷＳ）積立金増加率上限（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsRendouritustr() ,"13.00", "（ＩＷＳ）連動率（文字列）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrtkykhukaumu() ,"1", "（ＩＷＳ）定期支払特約付加有無");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikisiharaikin() ,"0", "（ＩＷＳ）定期支払金");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsTeikishrkinshrtuukasyu() ,"JPY", "（ＩＷＳ）定期支払金支払通貨種類");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzsyuruikbn() ,"0", "（ＩＷＳ）口座種類区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBankcd() ,"", "（ＩＷＳ）銀行コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitencd() ,"", "（ＩＷＳ）支店コード");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsBanknmkj() ,"", "（ＩＷＳ）銀行名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsSitennmkj() ,"", "（ＩＷＳ）支店名（漢字）");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsYokinkbn() ,"0", "（ＩＷＳ）預金種目区分");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKouzano() ,"", "（ＩＷＳ）口座番号");

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsKzmeiginmkn() ,"", "（ＩＷＳ）口座名義人氏名（カナ）");

    }

    @Test
    @TestOrder(7010)
    public void testExecPostForm_C1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'100000000001'}");

        String className = "";

        try {
            dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }

    @Test
    @TestOrder(8010)
    public void testExecPostForm_D1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'60806019563'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);

        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011215", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(8020)
    public void testExecPostForm_D2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'60806019518'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);

        WsDwGetHozenKiykGikItijiNnknOutputBean wsDwGetHozenKiykGikItijiNnknOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKiykGikItijiNnknOutputBean.class);

        exStringEquals(wsDwGetHozenKiykGikItijiNnknOutputBean.getIwsDsmsgcd(), "011214", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(8030)
    public void testExecPostForm_D3() throws Exception{

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'60806019585'}");

        String className = "";

        try {
            WsBzWebserviceResParamBean  wsBzWebserviceResParamBean = dwGetHozenKiykGikItijiNnknImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }

    private void test(WsDwGetHozenKiykGikItijiNnknOutputBean pBean){

        exStringEquals(pBean.getIwsSyono(), null, "（ＩＷＳ）証券番号");

        exStringEquals(pBean.getIwsAisyoumei() ,null, "（ＩＷＳ）愛称名区分");

        exStringEquals(pBean.getIwsSyouhnnm() ,null, "（ＩＷＳ）商品名");

        exStringEquals(pBean.getIwsKykymdstr() ,null, "（ＩＷＳ）契約日（文字列）");

        exStringEquals(pBean.getIwsKyktuukasyu() ,null, "（ＩＷＳ）契約通貨種類");

        exStringEquals(pBean.getIwsSakuseikijyunymdstr() ,null, "（ＩＷＳ）作成基準日（文字列）");

        exStringEquals(pBean.getIwsKyknmkn() ,null, "（ＩＷＳ）契約者名（カナ）");

        exStringEquals(pBean.getIwsKyknmkj() ,null, "（ＩＷＳ）契約者名（漢字）");

        exStringEquals(pBean.getIwsKykseiymdstr() ,null, "（ＩＷＳ）契約者生年月日（文字列）");

        exStringEquals(pBean.getIwsKyksei() ,null, "（ＩＷＳ）契約者性別");

        exStringEquals(pBean.getIwsHhknnmkn() ,null, "（ＩＷＳ）被保険者名（カナ）");

        exStringEquals(pBean.getIwsHhknseiymdstr() ,null, "（ＩＷＳ）被保険者生年月日（文字列） ");

        exStringEquals(pBean.getIwsSbuktnin() ,null, "（ＩＷＳ）死亡受取人人数");

        exStringEquals(pBean.getIwsUktmidasikbn1() ,null, "（ＩＷＳ）受取人見出し区分１");

        exStringEquals(pBean.getIwsUktkbn1str() ,null, "（ＩＷＳ）受取人区分１（文字列）");

        exStringEquals(pBean.getIwsUktsimei1() ,null, "（ＩＷＳ）受取人氏名１");

        exStringEquals(pBean.getIwsUktmidasikbn2() ,null, "（ＩＷＳ）受取人見出し区分２");

        exStringEquals(pBean.getIwsUktkbn2str() ,null, "（ＩＷＳ）受取人区分２（文字列）");

        exStringEquals(pBean.getIwsUktsimei2() ,null, "（ＩＷＳ）受取人氏名２");

        exStringEquals(pBean.getIwsUktmidasikbn3() ,null, "（ＩＷＳ）受取人見出し区分３");

        exStringEquals(pBean.getIwsUktkbn3str() ,null, "（ＩＷＳ）受取人区分３（文字列）");

        exStringEquals(pBean.getIwsUktsimei3() ,null, "（ＩＷＳ）受取人氏名３ ");

        exStringEquals(pBean.getIwsUktmidasikbn4() ,null, "（ＩＷＳ）受取人見出し区分４");

        exStringEquals(pBean.getIwsUktkbn4str() ,null, "（ＩＷＳ）受取人区分４（文字列）");

        exStringEquals(pBean.getIwsUktsimei4() ,null, "（ＩＷＳ）受取人氏名４");

        exStringEquals(pBean.getIwsUktmidasikbn5() ,null, "（ＩＷＳ）受取人見出し区分５");

        exStringEquals(pBean.getIwsUktkbn5str() ,null, "（ＩＷＳ）受取人区分５（文字列）");

        exStringEquals(pBean.getIwsUktsimei5() ,null, "（ＩＷＳ）受取人氏名５");

        exStringEquals(pBean.getIwsUktmidasikbn6() ,null, "（ＩＷＳ）受取人見出し区分６");

        exStringEquals(pBean.getIwsUktkbn6str() ,null, "（ＩＷＳ）受取人区分６（文字列）");

        exStringEquals(pBean.getIwsUktsimei6() ,null, "（ＩＷＳ）受取人氏名６");

        exStringEquals(pBean.getIwsUktmidasikbn7() ,null, "（ＩＷＳ）受取人見出し区分７");

        exStringEquals(pBean.getIwsUktkbn7str() ,null, "（ＩＷＳ）受取人区分７（文字列）");

        exStringEquals(pBean.getIwsUktsimei7() ,null, "（ＩＷＳ）受取人氏名７");

        exStringEquals(pBean.getIwsUktmidasikbn8() ,null, "（ＩＷＳ）受取人見出し区分８");

        exStringEquals(pBean.getIwsUktkbn8str() ,null, "（ＩＷＳ）受取人区分８（文字列）");

        exStringEquals(pBean.getIwsUktsimei8() ,null, "（ＩＷＳ）受取人氏名８");

        exStringEquals(pBean.getIwsUktmidasikbn9() ,null, "（ＩＷＳ）受取人見出し区分９");

        exStringEquals(pBean.getIwsUktkbn9str() ,null, "（ＩＷＳ）受取人区分９（文字列）");

        exStringEquals(pBean.getIwsUktsimei9() ,null, "（ＩＷＳ）受取人氏名９");

        exStringEquals(pBean.getIwsUktmidasikbn10() ,null, "（ＩＷＳ）受取人見出し区分１０");

        exStringEquals(pBean.getIwsUktkbn10str() ,null, "（ＩＷＳ）受取人区分１０（文字列）");

        exStringEquals(pBean.getIwsUktsimei10() ,null, "（ＩＷＳ）受取人氏名１０");

        exStringEquals(pBean.getIwsTutakinumukbn() ,null, "（ＩＷＳ）積立金有無区分");

        exStringEquals(pBean.getIwsKaiyakuhrsuiiumukbn() ,null, "（ＩＷＳ）解約返戻金推移有無区分");

        exStringEquals(pBean.getIwsSbhsyumukbn() ,null, "（ＩＷＳ）死亡保障有無区分");

        exStringEquals(pBean.getIwsKghsyumukbn() ,null, "（ＩＷＳ）介護保障有無区分");

        exStringEquals(pBean.getIwsIryhsyumukbn() ,null, "（ＩＷＳ）医療保障有無区分");

        exStringEquals(pBean.getIwsRougohsyumukbn() ,null, "（ＩＷＳ）老後保障有無区分");

        exStringEquals(pBean.getIwsStdrsktkyhkumu() ,null, "（ＩＷＳ）指定代理請求特約付加有無");

        exStringEquals(pBean.getIwsYennykntkhkumu() ,null, "（ＩＷＳ）円入金特約付加有無");

        exStringEquals(pBean.getIwsGaikanykntkhkumu() ,null, "（ＩＷＳ）外貨入金特約付加有無");

        exStringEquals(pBean.getIwsTargettkhkumu() ,null, "（ＩＷＳ）ターゲット特約付加有無");

        exStringEquals(pBean.getIwsSyksbyensitihsyutyhkumu() ,null, "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");

        exStringEquals(pBean.getIwsJyudkaigomehrtkhkumu() ,null, "（ＩＷＳ）重度介護前払特約付加有無");

        exStringEquals(pBean.getIwsZeiseitkkktkykhukaumu() ,null, "（ＩＷＳ）税制適格特約付加有無");

        exStringEquals(pBean.getIwsKjsmsaihakkoukahikbn() ,null, "（ＩＷＳ）控除証明書再発行処理可否区分");

        exStringEquals(pBean.getIwsKykmeigihnkkahikbn() ,null, "（ＩＷＳ）名義変更処理可否区分");

        exStringEquals(pBean.getIwsSyoukensaihkkahikbn() ,null, "（ＩＷＳ）証券再発行処理可否区分");

        exStringEquals(pBean.getIwsStdrsktkytthkkahikbn() ,null, "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");

        exStringEquals(pBean.getIwsTargettkhkkahikbn() ,null, "（ＩＷＳ）ターゲット特約変更可否区分");

        exStringEquals(pBean.getIwsKykniyusyoukaikahikbn() ,null, "（ＩＷＳ）契約内容照会可否区分");

        exStringEquals(pBean.getIwsTumitatekinitenkahikbn() ,null, "（ＩＷＳ）積立金移転可否区分");

        exStringEquals(pBean.getIwsDskaiyakukahikbn() ,null, "（ＩＷＳ）ＤＳ解約可否区分");

        exStringEquals(pBean.getIwsAdrhenkoukahikbn() ,null, "（ＩＷＳ）住所変更可否区分");

        exStringEquals(pBean.getIwsPhrkhouhenkoukahikbn() ,null, "（ＩＷＳ）保険料払込方法変更可否区分");

        exStringEquals(pBean.getIwsSksikijyunymdkawaserate() ,null, "（ＩＷＳ）作成基準日為替レート");

        exStringEquals(pBean.getIwsKwsratekijyunymdsakusei() ,null, "（ＩＷＳ）為替レート基準日（作成基準日）");

        exStringEquals(pBean.getIwsRsytuukasyu() ,null, "（ＩＷＳ）領収通貨種類");

        exStringEquals(pBean.getIwsRsymdkawaserate() ,null, "（ＩＷＳ）領収日為替レート");

        exStringEquals(pBean.getIwsRsymdkawaseratestigi() ,null, "（ＩＷＳ）領収日為替レート（指定外通貨）");

        exStringEquals(pBean.getIwsKwsratekijyunymdrs() ,null, "（ＩＷＳ）為替レート基準日（領収日）");

        exStringEquals(pBean.getIwsKwsratekijyunymdrsstigi() ,null, "（ＩＷＳ）為替レート基準日（領収日）");

        exStringEquals(pBean.getIwsRsgakuyen() ,null, "（ＩＷＳ）領収金額（円貨）");

        exStringEquals(pBean.getIwsRsgakustigi() ,null, "（ＩＷＳ）領収金額（指定外通貨）");

        exStringEquals(pBean.getIwsKijyunkingaku() ,null, "（ＩＷＳ）基準金額");

        exStringEquals(pBean.getIwsItijibrprsgaika() ,null, "（ＩＷＳ）一時払保険料（領収日）（外貨）");

        exStringEquals(pBean.getIwsMkhgkwari() ,null, "（ＩＷＳ）目標額割合");

        exStringEquals(pBean.getIwsHokenkngkksnkekkakbn() ,null, "（ＩＷＳ）保険金額計算結果区分");

        exStringEquals(pBean.getIwsSueokikknstr() ,null, "（ＩＷＳ）据置期間（文字列）");

        exStringEquals(pBean.getIwsNenkinsyustr() ,null, "（ＩＷＳ）年金種類（文字列）");

        exStringEquals(pBean.getIwsNenkinkkn() ,null, "（ＩＷＳ）年金期間");

        exStringEquals(pBean.getIwsNenkinstartymd() ,null, "（ＩＷＳ）年金支払開始日");

        exStringEquals(pBean.getIwsNenkinstartnen() ,null, "（ＩＷＳ）年金開始年齢");

        exStringEquals(pBean.getIwsKihonkyhgkgaika() ,null, "（ＩＷＳ）基本給付金額（外貨）");

        exStringEquals(pBean.getIwsSbkyhgkyen() ,null, "（ＩＷＳ）死亡給付金額（円貨）");

        exStringEquals(pBean.getIwsSbkyhgkgaika() ,null, "（ＩＷＳ）死亡給付金額（外貨）");

        exStringEquals(pBean.getIwsPtumitatekngkyen() ,null, "（ＩＷＳ）保険料積立金額（円貨）");

        exStringEquals(pBean.getIwsPtumitatekngkgaika() ,null, "（ＩＷＳ）保険料積立金額（外貨）");

        exStringEquals(pBean.getIwsKaiyakuhryen() ,null, "（ＩＷＳ）解約返戻金額（円貨）");

        exStringEquals(pBean.getIwsKaiyakuhrgaika() ,null, "（ＩＷＳ）解約返戻金額（外貨）");

        exStringEquals(pBean.getIwsPtmttkngkyenteiritu() ,null, "（ＩＷＳ）保険料積立金額（円貨）（定率積立部分）");

        exStringEquals(pBean.getIwsPtmttkngkgaikateiritu() ,null, "（ＩＷＳ）保険料積立金額（外貨）（定率積立部分）");

        exStringEquals(pBean.getIwsHaibunwariteiritu() ,null, "（ＩＷＳ）配分割合（定率積立部分）");

        exStringEquals(pBean.getIwsTumitateriritustr() ,null, "（ＩＷＳ）積立利率（文字列）");

        exStringEquals(pBean.getIwsSisuusyu() ,null, "（ＩＷＳ）指数種類");

        exStringEquals(pBean.getIwsPtmttkngkyensisuu() ,null, "（ＩＷＳ）保険料積立金額（円貨）（指数連動部分）");

        exStringEquals(pBean.getIwsPtmttkngkgaikasisuu() ,null, "（ＩＷＳ）保険料積立金額（外貨）（指数連動部分）");

        exStringEquals(pBean.getIwsHaibunwarisisuu() ,null, "（ＩＷＳ）配分割合（指数連動部分）");

        exStringEquals(pBean.getIwsTmttknzkrt() ,null, "（ＩＷＳ）積立金増加率");

        exStringEquals(pBean.getIwsSisuuupritu() ,null, "（ＩＷＳ）指数上昇率");

        exStringEquals(pBean.getIwsSetteibairitustr() ,null, "（ＩＷＳ）設定倍率（文字列）");

        exStringEquals(pBean.getIwsTumitatekinitenyoteibi() ,null, "（ＩＷＳ）積立金移転予定日");

        exStringEquals(pBean.getIwsTmttknitnttdkumukbn() ,null, "（ＩＷＳ）積立金移転手続有無区分");

        exStringEquals(pBean.getIwsTmttknzkrtjygnstr() ,null, "（ＩＷＳ）積立金増加率上限（文字列）");
    }
}
