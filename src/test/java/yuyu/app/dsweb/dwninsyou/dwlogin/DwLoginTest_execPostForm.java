package yuyu.app.dsweb.dwninsyou.dwlogin;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.CheckDsKaiyakuMockForDirect;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuMockForDirect;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngaiMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwLoginOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ログイン認証のメイン処理{@link DwLoginImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwLoginTest_execPostForm extends AbstractTest {

    @Inject
    private DwLoginImpl dwLoginImpl;

    @Inject
    DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf("20160509"));
    }

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ログイン認証";

    private final static String sheetName = "INデータ";

    private String sysDateTime;

    private BizDate sysDate;

    private String sysTime;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class);
                bind(CheckDsKaiyaku.class).to(CheckDsKaiyakuMockForDirect.class);
                bind(CheckYuuyokkngai.class).to(CheckYuuyokkngaiMockForDirect.class);
            }
        });
    }

    @Before
    public void testInit() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = DwLoginTest_execPostForm.class;
        CheckDsKaiyakuMockForDirect.caller = DwLoginTest_execPostForm.class;
        CheckYuuyokkngaiMockForDirect.caller = DwLoginTest_execPostForm.class;
        baseUserInfo.getUser().setUserId("JUnit");
    }

    @After
    public void testClear() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = null;
        CheckDsKaiyakuMockForDirect.caller = null;
        CheckYuuyokkngaiMockForDirect.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwLoginTest_execPostForm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000024"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000035"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000046"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000057"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000068"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000079"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000080"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000091"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000105"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000116"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000127"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000138"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000149"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000150"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000161"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000172"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000183"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000194"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000208"));
        directDomManager.delete(directDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("17806000219"));

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        directDomManager.delete(directDomManager.getAllBAKDsKokyakuKanri());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_C1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(15)
    public void testExec_C2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10000000001','iwsPassword':''}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(16)
    public void testExec_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10000000001','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(20)
    public void testExec_B1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001201", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(30)
    public void testExec_B2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000024','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001300", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(40)
    public void testExec_B3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000035','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001001", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(50)
    public void testExec_B4() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000046','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001003", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(60)
    public void testExec_B5() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000057','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001003", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(70)
    public void testExec_B6() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000068','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001008", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(80)
    public void testExec_B7() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000079','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        sysDateTime = BizDate.getSysDateTimeMilli();
        sysDate     = BizDate.getSysDate();
        sysTime     = sysDateTime.substring(8, 14);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000006", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "2", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "20160607", "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "115721", "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "20160509", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "0", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000006");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000006", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.valueOf(20160509), "最新ログイン年月日");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(110)
    public void testExec_B10() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000105','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        sysDateTime = BizDate.getSysDateTimeMilli();
        sysDate     = BizDate.getSysDate();
        sysTime     = sysDateTime.substring(8, 14);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000009", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "2", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "20160604", "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "114721", "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "20160509", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "0", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000009");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000009", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.valueOf(20160509), "最新ログイン年月日");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), C_BaitaiKbn.PC, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(120)
    public void testExec_B11() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000116','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        sysDateTime = BizDate.getSysDateTimeMilli();
        sysDate     = BizDate.getSysDate();
        sysTime     = sysDateTime.substring(8, 14);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001006", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(130)
    public void testExec_B12() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000127','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001007", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000011", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "2", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "", "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "", "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "4", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000011");

        exClassificationEquals(dsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");

        exDateEquals(dsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");

        exClassificationEquals(dsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");

        exDateEquals(dsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf(20160509), "ＤＳ顧客無効年月日");

        exClassificationEquals(dsKokyakuKanri.getSeisahuyouhyj(), null, "精査不要表示");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkn(), "ＤＳ顧客名（カナ）１１", "ＤＳ顧客名（カナ）");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkj(), "ＤＳ顧客名（漢字）１１", "ＤＳ顧客名（漢字）");

        exDateEquals(dsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf(20160507), "ＤＳ顧客生年月日");

        exStringEquals(dsKokyakuKanri.getDskokyakuyno(), "0000000", "ＤＳ顧客郵便番号");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000011", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.valueOf(20160605), "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), "143724", "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 4, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(140)
    public void testExec_B13() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000138','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001007", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000012", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "2", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "", "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "", "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "3", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000012");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000012", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), BizDate.valueOf(20160606), "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), "122724", "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 3, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(150)
    public void testExec_B14() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000149','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001002", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(160)
    public void testExec_B15() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000150','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001002", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(170)
    public void testExec_B16() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000161','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001005", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(180)
    public void testExec_B17() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000172','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000016", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "1", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "", "（ＩＷＳ）最新ログイン年月日");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "", "（ＩＷＳ）最新ログイン時刻");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "20160509", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "0", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000016");


        exClassificationEquals(dsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");

        exDateEquals(dsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");

        exClassificationEquals(dsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU, "ＤＳ停止理由区分");

        exDateEquals(dsKokyakuKanri.getDskokyakumukouymd(), null, "ＤＳ顧客無効年月日");

        exClassificationEquals(dsKokyakuKanri.getSeisahuyouhyj(), null, "精査不要表示");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkn(), "ＤＳ顧客名（カナ）１６", "ＤＳ顧客名（カナ）");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkj(), "ＤＳ顧客名（漢字）１６", "ＤＳ顧客名（漢字）");

        exDateEquals(dsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf(20160507), "ＤＳ顧客生年月日");

        exStringEquals(dsKokyakuKanri.getDskokyakuyno(), "0000000", "ＤＳ顧客郵便番号");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinTime(),sysTime, "業務用更新時間");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000016", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), null, "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), null, "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");

        assertNull("ＤＳ顧客名エラー回数", dsLoginKanri.getDskokyakunmerrorkaisuu());

        assertNull("ＤＳ顧客生年月日エラー回数", dsLoginKanri.getDskokyakuseiymderrorkaisuu());

        assertNull("ＤＳ顧客電話番号エラー回数", dsLoginKanri.getDskokyakutelnoerrorkaisuu());

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(190)
    public void testExec_B18() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000183','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        sysDateTime = BizDate.getSysDateTimeMilli();
        sysTime     = sysDateTime.substring(8, 14);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000017", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "1", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "", "（ＩＷＳ）最新ログイン年月日");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "", "（ＩＷＳ）最新ログイン時刻");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "20160509", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "0", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000017");

        exClassificationEquals(dsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");

        exDateEquals(dsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");

        exClassificationEquals(dsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU, "ＤＳ停止理由区分");

        exDateEquals(dsKokyakuKanri.getDskokyakumukouymd(), null, "ＤＳ顧客無効年月日");

        exClassificationEquals(dsKokyakuKanri.getSeisahuyouhyj(), null, "精査不要表示");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkn(), "ＤＳ顧客名（カナ）１７", "ＤＳ顧客名（カナ）");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkj(), "ＤＳ顧客名（漢字）１７", "ＤＳ顧客名（漢字）");

        exDateEquals(dsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf(20160507), "ＤＳ顧客生年月日");

        exStringEquals(dsKokyakuKanri.getDskokyakuyno(), "0000000", "ＤＳ顧客郵便番号");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinTime(),null, "業務用更新時間");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000017", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), null, "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), null, "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 0, "ＤＳ本人確認コードエラー回数");

        assertNull("ＤＳ顧客名エラー回数", dsLoginKanri.getDskokyakunmerrorkaisuu());

        assertNull("ＤＳ顧客生年月日エラー回数", dsLoginKanri.getDskokyakuseiymderrorkaisuu());

        assertNull("ＤＳ顧客電話番号エラー回数", dsLoginKanri.getDskokyakutelnoerrorkaisuu());

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(200)
    public void testExec_B19() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000194','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001006", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000018");

        exClassificationEquals(dsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");

        exDateEquals(dsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");

        exClassificationEquals(dsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");

        exDateEquals(dsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf(20160509), "ＤＳ顧客無効年月日");

        exClassificationEquals(dsKokyakuKanri.getSeisahuyouhyj(), null, "精査不要表示");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkn(), "ＤＳ顧客名（カナ）１８", "ＤＳ顧客名（カナ）");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkj(), "ＤＳ顧客名（漢字）１８", "ＤＳ顧客名（漢字）");

        exDateEquals(dsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf(20160507), "ＤＳ顧客生年月日");

        exStringEquals(dsKokyakuKanri.getDskokyakuyno(), "0000000", "ＤＳ顧客郵便番号");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000018", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), null, "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), null, "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 4, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(210)
    public void testExec_B20() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000208','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001006", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000019", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "1", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "", "（ＩＷＳ）最新ログイン年月日");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "", "（ＩＷＳ）最新ログイン時刻");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "4", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000019");

        exClassificationEquals(dsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.ITIJI_TEISI, "ＤＳ顧客状態区分");

        exDateEquals(dsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");

        exClassificationEquals(dsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.LOCK_OUT, "ＤＳ停止理由区分");

        exDateEquals(dsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf(20160509), "ＤＳ顧客無効年月日");

        exClassificationEquals(dsKokyakuKanri.getSeisahuyouhyj(), null, "精査不要表示");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkn(), "ＤＳ顧客名（カナ）１９", "ＤＳ顧客名（カナ）");

        exStringEquals(dsKokyakuKanri.getDskokyakunmkj(), "ＤＳ顧客名（漢字）１９", "ＤＳ顧客名（漢字）");

        exDateEquals(dsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf(20160507), "ＤＳ顧客生年月日");

        exStringEquals(dsKokyakuKanri.getDskokyakuyno(), "0000000", "ＤＳ顧客郵便番号");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsKokyakuKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000019", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), null, "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), null, "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 4, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(220)
    public void testExec_B21() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000219','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001007", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), "0000000020", "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), "1", "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), "", "（ＩＷＳ）最新ログイン年月日");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), "", "（ＩＷＳ）最新ログイン時刻");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), "", "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), "3", "（ＩＷＳ）パスワードエラー回数 ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("0000000020");

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        exStringEquals(dsLoginKanri.getDskokno(), "0000000020", "ＤＳ顧客番号");

        exDateEquals(dsLoginKanri.getSyokailoginymd(), null, "初回ログイン年月日");

        exStringEquals(dsLoginKanri.getSyokailogintime(), null, "初回ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSyokailoginbaitaikbn(), null, "初回ログイン媒体区分");

        exDateEquals(dsLoginKanri.getSaisinloginymd(), null, "最新ログイン年月日");

        exStringEquals(dsLoginKanri.getSaisinlogintime(), null, "最新ログイン時刻");

        exClassificationEquals(dsLoginKanri.getSaisinloginbaitaikbn(), null, "最新ログイン媒体区分");

        exNumericEquals(dsLoginKanri.getDshnnkakcderrorkaisuu(), 3, "ＤＳ本人確認コードエラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakunmerrorkaisuu(), 0, "ＤＳ顧客名エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakuseiymderrorkaisuu(), 0, "ＤＳ顧客生年月日エラー回数");

        exNumericEquals(dsLoginKanri.getDskokyakutelnoerrorkaisuu(), 0, "ＤＳ顧客電話番号エラー回数");

        exStringEquals(dsLoginKanri.getGyoumuKousinKinou(), "dwlogin", "業務用更新機能ＩＤ");

        exStringEquals(dsLoginKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(230)
    public void testExec_B22() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000057','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001003", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(240)
    public void testExec_B24() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000230','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001006", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }

    @Test
    @TestOrder(250)
    public void testExec_B25() throws Exception {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000241','iwsPassword':'123456'}");
        pMap.add("operatorId","operatorID");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwninsyou.dwlogin.DwLogin/execPostForm");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001006", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwLoginOutputBean.getIwsDskokno(), null, "（ＩＷＳ）ＤＳ顧客番号");

        exStringEquals(wsDwLoginOutputBean.getIwsPasswordjtkbn(), null, "（ＩＷＳ）パスワード状態区分");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinloginymd(), null, "（ＩＷＳ）最新ログイン年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsSaisinlogintime(), null, "（ＩＷＳ）最新ログイン時刻 ");

        exStringEquals(wsDwLoginOutputBean.getIwsFuho2serverymd(), null, "（ＩＷＳ）普保Ⅱサーバ年月日 ");

        exStringEquals(wsDwLoginOutputBean.getIwsPassworderrorkaisuu(), null, "（ＩＷＳ）パスワードエラー回数 ");
    }
}
