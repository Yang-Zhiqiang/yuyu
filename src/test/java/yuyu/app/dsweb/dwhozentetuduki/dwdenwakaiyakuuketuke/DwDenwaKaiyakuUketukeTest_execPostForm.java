package yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke;

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
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.CheckKaiyakuUketuke;
import yuyu.common.direct.dscommon.CheckKaiyakuUketukeMockForDirect;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsSaibanSyoriMockForDirect;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_DsGyoumuCdKbn;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SetudanKasyoKbn;
import yuyu.def.classification.C_SetudanRiyuuKbn;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_TtdkIsihyouziKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.entity.MT_SousaRirekiIvrInfo;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwDenwaKaiyakuUketukeOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 電話解約受付のメイン処理{@link DwDenwaKaiyakuUketuke#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwDenwaKaiyakuUketukeTest_execPostForm extends AbstractTest {

    @Inject
    private DwDenwaKaiyakuUketukeImpl dwDenwaKaiyakuUketukeImpl;

    @Inject
    private DirectDomManager directDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_電話解約受付";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsSaibanSyori.class).to(DsSaibanSyoriMockForDirect.class);
                bind(CheckKaiyakuUketuke.class).to(CheckKaiyakuUketukeMockForDirect.class);
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        WebServiceAccesslogOutputMockForDirect.caller = DwDenwaKaiyakuUketukeTest_execPostForm.class;

        DsSaibanSyoriMockForDirect.caller = DwDenwaKaiyakuUketukeTest_execPostForm.class;

        CheckKaiyakuUketukeMockForDirect.caller = DwDenwaKaiyakuUketukeTest_execPostForm.class;

        KeisanCommonKaiyakuMockForDirect.caller = DwDenwaKaiyakuUketukeTest_execPostForm.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwDenwaKaiyakuUketukeTest_execPostForm.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
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
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3_1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'1a', 'iwsSyorinaiyou':'001'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3_2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'00a'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567891', 'iwsTtdkis':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'999'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "991", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsGyoumucd(), "01", "（ＩＷＳ）業務コード");
        exStringEquals(resultBean.getIwsSyorinaiyou(), "999", "（ＩＷＳ）処理内容 ");

    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsTtdkskbt(), "1810170120", "（ＩＷＳ）手続識別ＩＤ");
        exStringEquals(resultBean.getIwsNextsyoricd(), "020", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1810170120");

        exDateEquals(sousaRireki.getTtdkstartymd(), BizDate.valueOf(20180101), "手続開始日付");
        exClassificationEquals(sousaRireki.getTtdkkinoukbn(), C_TtdkKinouKbn.DENWAKAIYAKUUKETUKE, "手続機能区分");
        exClassificationEquals(sousaRireki.getSousarirekijkkbn(), C_SousaRirekiJkKbn.TETUZUKITYUU, "操作履歴状況区分");
        exClassificationEquals(sousaRireki.getSousarirekikekkakbn(), C_TtdkKekkaKbn.BLNK, "操作履歴結果区分");
        exStringEquals(sousaRireki.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");

        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(0);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1810170120", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 2, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYOKITOUROKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（出力内容：手続識別ＩＤ＝１８１０１７０１２０）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        BizDate pDate = (BizDate) MockObjectManager.getArgument(DsSaibanSyoriMockForDirect.class,
            "saibanDsTetuzukiSikibetuId", 0, 0);
        exDateEquals(pDate, BizDate.valueOf("20180101"), "手続開始日付");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567890', 'iwsSyono':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'a234567890', 'iwsSyono':'17807000016'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567890', 'iwsSyono':'17807000289'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "050", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(4);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 5, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "証券番号の規定回数を超えました。　（入力内容：証券番号＝１７８０７０００２８９）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567891', 'iwsSyono':'17807000290'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "050", "（ＩＷＳ）遷移先処理コード");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567891");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(3);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567891", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 4, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "証券番号の規定回数を超えました。　（入力内容：証券番号＝１７８０７０００２９０）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000304'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "040", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(2);
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 3, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "該当する証券番号が存在しません。　（入力内容：証券番号＝１７８０７０００３０４）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_A13() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        exStringEquals(sousaRireki.getSyono(), "17807000016", "操作履歴状況区分");
        exStringEquals(sousaRireki.getDskokno(), null, "操作履歴結果区分");
        exStringEquals(sousaRireki.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRireki.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(3);
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 4, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "システム稼動時間外です。　（入力内容：証券番号＝１７８０７００００１６）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_A14() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000050'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "030", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsTtdkskbt(), "1234567892", "（ＩＷＳ）手続識別ＩＤ");
        exStringEquals(resultBean.getIwsSyono(), "17807000050", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsDskokno(), "9000000001", "（ＩＷＳ）ＤＳ顧客番号");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        exStringEquals(sousaRireki.getSyono(), "17807000050", "操作履歴状況区分");
        exStringEquals(sousaRireki.getDskokno(), "9000000001", "操作履歴結果区分");
        exStringEquals(sousaRireki.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRireki.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(4);
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 5, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（入力内容：証券番号＝１７８０７００００５０）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(150)
    public void testExecPostForm_A15() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_A16() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003',  'iwsTtdkskbt':'1234567892','iwsSyono':'17807000027','iwsDskokno':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(170)
    public void testExecPostForm_A17() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003',  'iwsTtdkskbt':'1234567892','iwsSyono':'17807000027','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18_1() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'123456789a', 'iwsSyono':'17807000027','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'10120000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18_2() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'1780700002a','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'10120000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18_3() throws Exception {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000027','iwsDskokno':'900000000a','iwsTokuteitrhkansyono':'10120000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_A19() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000027','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'10120000'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsTtdkskbt(), "1234567892", "（ＩＷＳ）手続識別ＩＤ");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(5);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567892", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 6, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "特定取引用口座、特定取引用暗証番号が利用できません。　（入力内容：特定取引用暗証番号＝＊＊＊＊）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(200)
    public void testExecPostForm_A20() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000027','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'101'}");

        dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("9000000001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono("17807000027");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn(),
            C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA, "ＤＳ取引サービス利用状況区分");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn(),
            C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT, "ＤＳ取引サービス停止理由区分");
        exDateEquals(dsTorihikiServiceKanri.getDstrhkservicemukouymd(), BizDate.valueOf(20180101), "ＤＳ取引サービス無効年月日");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(6);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567892", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 7, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "特定取引用暗証番号の規定回数を超えました。　（入力内容：特定取引用暗証番号＝＊＊＊＊）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(210)
    public void testExecPostForm_A21() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000038','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'101'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "080", "（ＩＷＳ）遷移先処理コード");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("9000000001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono("17807000038");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn(),
            C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA, "ＤＳ取引サービス利用状況区分");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn(),
            C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT, "ＤＳ取引サービス停止理由区分");
        exDateEquals(dsTorihikiServiceKanri.getDstrhkservicemukouymd(), BizDate.valueOf(20180101), "ＤＳ取引サービス無効年月日");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(7);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567892", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 8, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "特定取引用暗証番号の規定回数を超えました。　（入力内容：特定取引用暗証番号＝＊＊＊＊）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(220)
    public void testExecPostForm_A22() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000049','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'101'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "070", "（ＩＷＳ）遷移先処理コード");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("9000000001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono("17807000049");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();
        exNumericEquals(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu(), 3, "特定取引用暗証番号エラー回数");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(8);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567892", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 9, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "特定取引用暗証番号が登録されている番号と相違しています。　（入力内容：特定取引用暗証番号＝＊＊＊＊）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(230)
    public void testExecPostForm_A23() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'003', 'iwsTtdkskbt':'1234567892', 'iwsSyono':'17807000050','iwsDskokno':'9000000001','iwsTokuteitrhkansyono':'102'}");


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "060", "（ＩＷＳ）遷移先処理コード");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("9000000001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono("17807000050");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();
        exNumericEquals(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu(), 0, "特定取引用暗証番号エラー回数");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(9);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567892", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 10, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（入力内容：特定取引用暗証番号＝＊＊＊＊）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(240)
    public void testExecPostForm_A24() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'0001', 'iwsSyono':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(250)
    public void testExecPostForm_A25() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'0001', 'iwsSyono':'17807000016', 'iwsDskokno':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(261)
    public void testExecPostForm_A26_1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'000a', 'iwsSyono':'17807000013', 'iwsDskokno':'9000000001'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(262)
    public void testExecPostForm_A26_2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'0001', 'iwsSyono':'1780700001a', 'iwsDskokno':'9000000001'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(263)
    public void testExecPostForm_A26_3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'0001', 'iwsSyono':'17807000013', 'iwsDskokno':'900000000a'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(270)
    public void testExecPostForm_A27() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567893', 'iwsSyono':'17807000016', 'iwsDskokno':'9000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567893");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(1);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567893", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 2, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "システム稼動時間外です。", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(280)
    public void testExecPostForm_A28() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567893', 'iwsSyono':'17807000016', 'iwsDskokno':'9000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567893");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(2);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567893", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 3, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "テストの規定回数を超えました。", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(290)
    public void testExecPostForm_A29() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567893', 'iwsSyono':'17807000108', 'iwsDskokno':'9000000001'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。解約共通計算（証券番号：17807000108、処理年月日：20180101）処理中にエラーが発生しました。", "メッセージ内容");
        C_Tuukasyu pTuukasyu = (C_Tuukasyu) MockObjectManager.getArgument(CheckKaiyakuUketukeMockForDirect.class,
            "kawaserateExistChk", 0, 0);
        exClassificationEquals(pTuukasyu, C_Tuukasyu.USD, "契約通貨種類");

    }

    @Test
    @TestOrder(300)
    public void testExecPostForm_A30() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567893', 'iwsSyono':'17807000108', 'iwsDskokno':'9000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567893");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(3);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567893", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 4, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(310)
    public void testExecPostForm_A31() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN4;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567893', 'iwsSyono':'17807000131', 'iwsDskokno':'9000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "090", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsTtdkskbt(), "1234567893", "（ＩＷＳ）手続識別ＩＤ");
        exStringEquals(resultBean.getIwsShrgkkei(), "100", "（ＩＷＳ）支払額合計");
        exStringEquals(resultBean.getIwsBankcd(), "0001", "（ＩＷＳ）銀行コード");
        exStringEquals(resultBean.getIwsBanknmkn(), "ミズホ", "（ＩＷＳ）銀行名（カナ）");
        exStringEquals(resultBean.getIwsKouzaVersion(), "0", "（ＩＷＳ）口座情報バージョン");
        exStringEquals(resultBean.getIwsKzmeiginmkn(), "カナ", "（ＩＷＳ）口座名義人（カナ）");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567893");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(4);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567893", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 5, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（出力内容：支払額合計＝１００円、送金先＝ミズホ、口座名義人＝カナ）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(320)
    public void testExecPostForm_A32() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN4;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567893', 'iwsSyono':'17807000142', 'iwsDskokno':'9000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "090", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsTtdkskbt(), "1234567893", "（ＩＷＳ）手続識別ＩＤ");
        exStringEquals(resultBean.getIwsShrgkkei(), "100", "（ＩＷＳ）支払額合計");
        exStringEquals(resultBean.getIwsBankcd(), "0002", "（ＩＷＳ）銀行コード");
        exStringEquals(resultBean.getIwsBanknmkn(), null, "（ＩＷＳ）銀行名（カナ）");
        exStringEquals(resultBean.getIwsKouzaVersion(), "1", "（ＩＷＳ）口座情報バージョン");
        exStringEquals(resultBean.getIwsKzmeiginmkn(), "ココ", "（ＩＷＳ）口座名義人（カナ）");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567893");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(5);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567893", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 6, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（出力内容：支払額合計＝１００円、送金先＝ｎｕｌｌ、口座名義人＝ココ）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(330)
    public void testExecPostForm_A33() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'1234567890', 'iwsSyono':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(340)
    public void testExecPostForm_A34() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'1234567890', 'iwsSyono':'17807000027', 'iwsDskokno':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(350)
    public void testExecPostForm_A35() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'1234567890', 'iwsSyono':'17807000027', 'iwsDskokno':'9000000001', 'iwsTtdkis':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(360)
    public void testExecPostForm_A36() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'1234567890', 'iwsSyono':'17807000027', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(371)
    public void testExecPostForm_A37_1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'123456789a', 'iwsSyono':'17807000022', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(372)
    public void testExecPostForm_A37_2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'1234567890', 'iwsSyono':'1780700002a', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(373)
    public void testExecPostForm_A37_3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsTtdkskbt':'1234567890', 'iwsSyono':'17807000022', 'iwsDskokno':'900000000a', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(380)
    public void testExecPostForm_A38() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000027', 'iwsDskokno':'9000000001', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(5);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 6, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "システム稼動時間外です。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(390)
    public void testExecPostForm_A39() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000027', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(6);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 7, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "テストの規定回数を超えました。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(400)
    public void testExecPostForm_A40() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000131', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "100", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsTtdkskbt(), "1234567890", "（ＩＷＳ）手続識別ＩＤ");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(7);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 8, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk("17807000131", Integer.valueOf(10));
        exDateEquals(khHenkouUktk.getUktkymd(), BizDate.valueOf(20180101), "受付日");
        exClassificationEquals(khHenkouUktk.getTourokuroute(), C_TourokuRouteKbn.TEL, "登録ルート");
        exClassificationEquals(khHenkouUktk.getUktksyorikbn(), C_UktkSyoriKbn.KAIYAKU, "受付処理区分");
        exDateEquals(khHenkouUktk.getKouryokuhasseiymd(), BizDate.valueOf(20180101), "効力発生日");
        exDateEquals(khHenkouUktk.getSyoriyoteiymd(), BizDate.valueOf(20180101), "処理予定日");
        exClassificationEquals(khHenkouUktk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(khHenkouUktk.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        IT_KhHenkouUktkKaiyaku khHenkouUktkKaiyaku = khHenkouUktk.getKhHenkouUktkKaiyaku();
        exClassificationEquals(khHenkouUktkKaiyaku.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exClassificationEquals(khHenkouUktkKaiyaku.getYenshrtkhkumu(), C_UmuKbn.ARI, "円支払特約付加有無");
        exStringEquals(khHenkouUktkKaiyaku.getBankcd(), "0001", "銀行コード");
        exStringEquals(khHenkouUktkKaiyaku.getSitencd(), "001", "支店コード");
        exClassificationEquals(khHenkouUktkKaiyaku.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khHenkouUktkKaiyaku.getKouzano(), "0001", "口座番号");
        exClassificationEquals(khHenkouUktkKaiyaku.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khHenkouUktkKaiyaku.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ");
        exStringEquals(khHenkouUktkKaiyaku.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkKaiyaku.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(410)
    public void testExecPostForm_A41() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN8;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000142', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "100", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(8);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 9, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk("17807000142", Integer.valueOf(10));
        exDateEquals(khHenkouUktk.getUktkymd(), BizDate.valueOf(20180101), "受付日");
        exClassificationEquals(khHenkouUktk.getTourokuroute(), C_TourokuRouteKbn.TEL, "登録ルート");
        exClassificationEquals(khHenkouUktk.getUktksyorikbn(), C_UktkSyoriKbn.KAIYAKU, "受付処理区分");
        exDateEquals(khHenkouUktk.getKouryokuhasseiymd(), BizDate.valueOf(20180101), "効力発生日");
        exDateEquals(khHenkouUktk.getSyoriyoteiymd(), BizDate.valueOf(20180101), "処理予定日");
        exClassificationEquals(khHenkouUktk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(khHenkouUktk.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        IT_KhHenkouUktkKaiyaku khHenkouUktkKaiyaku = khHenkouUktk.getKhHenkouUktkKaiyaku();
        exClassificationEquals(khHenkouUktkKaiyaku.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exClassificationEquals(khHenkouUktkKaiyaku.getYenshrtkhkumu(), C_UmuKbn.NONE, "円支払特約付加有無");
        exStringEquals(khHenkouUktkKaiyaku.getBankcd(), "0002", "銀行コード");
        exStringEquals(khHenkouUktkKaiyaku.getSitencd(), "002", "支店コード");
        exClassificationEquals(khHenkouUktkKaiyaku.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(khHenkouUktkKaiyaku.getKouzano(), "0002", "口座番号");
        exClassificationEquals(khHenkouUktkKaiyaku.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(khHenkouUktkKaiyaku.getKzmeiginmkn(), "ココ", "口座名義人氏名（カナ");
        exStringEquals(khHenkouUktkKaiyaku.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkKaiyaku.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(420)
    public void testExecPostForm_A42() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000142', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'0'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(9);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 10, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "口座情報が変更されています。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(430)
    public void testExecPostForm_A43() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000142', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "100", "（ＩＷＳ）遷移先処理コード");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(10);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 11, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(440)
    public void testExecPostForm_A44() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000142', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'0', 'iwsKouzaVersion':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "110", "（ＩＷＳ）遷移先処理コード");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(11);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 12, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "手続中断しました。　（入力内容：手続意思表示＝０）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    /**@Test
    @TestOrder(450)
    public void testExecPostForm_A45() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMock.SYORIPTN = WebServiceAccesslogOutputMock.TESTPATTERN1;
        DsSaibanSyoriMock.SYORIPTN = DsSaibanSyoriMock.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }*/

    @Test
    @TestOrder(460)
    public void testExecPostForm_A46() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkis':'1', 'iwsTtdkskbt':'1234567890', 'iwsTyakusintime':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(470)
    public void testExecPostForm_A47() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(480)
    public void testExecPostForm_A48() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(490)
    public void testExecPostForm_A49() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(500)
    public void testExecPostForm_A50() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(510)
    public void testExecPostForm_A51() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkis':'1', 'iwsTtdkskbt':'1234567890', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':''}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(521)
    public void testExecPostForm_A52_1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'123456789a', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(522)
    public void testExecPostForm_A52_2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'a', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(523)
    public void testExecPostForm_A52_3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'2018010112500a', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(524)
    public void testExecPostForm_A52_4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'あ', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(525)
    public void testExecPostForm_A52_5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'a', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'あ', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(526)
    public void testExecPostForm_A52_6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'a', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'01a', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(527)
    public void testExecPostForm_A52_7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'a', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'0a', 'iwsTuuwatime':'1010010000'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(528)
    public void testExecPostForm_A52_8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'a', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'iwsCallid01', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'101001000a'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。入力項目が改ざんされている恐れがあります。", "メッセージ内容");

    }

    @Test
    @TestOrder(530)
    public void testExecPostForm_A53() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567890', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'901999019990199901', 'iwsSyorikekka':'1', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        exDateEquals(sousaRireki.getTtdkendymd(), BizDate.valueOf(20180101), "手続終了日付");
        exClassificationEquals(sousaRireki.getSousarirekijkkbn(), C_SousaRirekiJkKbn.END, "操作履歴状況区分");
        exClassificationEquals(sousaRireki.getSousarirekikekkakbn(), C_TtdkKekkaKbn.TETUDUKIKANRYOU, "操作履歴結果区分");
        exStringEquals(sousaRireki.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRireki.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(12);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 13, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYUURYOUSYORI, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "正常終了しました。", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRirekiIvrInfo susaRirekiIvrInfo = sousaRireki.getSousaRirekiIvrInfo();
        exStringEquals(susaRirekiIvrInfo.getTyakusinymd(), "20180101125001", "着信日時");
        exClassificationEquals(susaRirekiIvrInfo.getDsgyoumucd(), C_DsGyoumuCdKbn.KAIYAKU, "業務コード");
        exClassificationEquals(susaRirekiIvrInfo.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYUURYOUSYORI, "処理内容区分");
        exStringEquals(susaRirekiIvrInfo.getCallid(), "901999019990199901", "コールID");
        exClassificationEquals(susaRirekiIvrInfo.getDssyorikekkakbn(), C_TtdkKekkaKbn.TETUDUKIKANRYOU, "処理結果区分");
        exClassificationEquals(susaRirekiIvrInfo.getSetudankasyokbn(), C_SetudanKasyoKbn.HASSINNOCHECK, "切断箇所区分");
        exClassificationEquals(susaRirekiIvrInfo.getSetudanriyuukbn(), C_SetudanRiyuuKbn.HASSINNOERROR, "切断理由区分");
        exStringEquals(susaRirekiIvrInfo.getTuuwatime(), "1010010000", "通話時間");
        exClassificationEquals(susaRirekiIvrInfo.getTtdkisihyouzikbn(), C_TtdkIsihyouziKbn.TETUZUKIZISSI, "手続意思表示区分");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(540)
    public void testExecPostForm_A54() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567891', 'iwsTtdkis':'1', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'901999019990199901', 'iwsSyorikekka':'2', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567891");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(4);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567891", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 5, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYUURYOUSYORI, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "手続中断しました。", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_SousaRirekiIvrInfo susaRirekiIvrInfo = sousaRireki.getSousaRirekiIvrInfo();
        exStringEquals(susaRirekiIvrInfo.getTyakusinymd(), "20180101125001", "着信日時");
        exClassificationEquals(susaRirekiIvrInfo.getDsgyoumucd(), C_DsGyoumuCdKbn.KAIYAKU, "業務コード");
        exClassificationEquals(susaRirekiIvrInfo.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYUURYOUSYORI, "処理内容区分");
        exStringEquals(susaRirekiIvrInfo.getCallid(), "901999019990199901", "コールID");
        exClassificationEquals(susaRirekiIvrInfo.getDssyorikekkakbn(), C_TtdkKekkaKbn.TETUDUKITYUUDAN, "処理結果区分");
        exClassificationEquals(susaRirekiIvrInfo.getSetudankasyokbn(), C_SetudanKasyoKbn.HASSINNOCHECK, "切断箇所区分");
        exClassificationEquals(susaRirekiIvrInfo.getSetudanriyuukbn(), C_SetudanRiyuuKbn.HASSINNOERROR, "切断理由区分");
        exStringEquals(susaRirekiIvrInfo.getTuuwatime(), "1010010000", "通話時間");
        exClassificationEquals(susaRirekiIvrInfo.getTtdkisihyouzikbn(), C_TtdkIsihyouziKbn.TETUZUKIZISSI, "手続意思表示区分");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(550)
    public void testExecPostForm_A55() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'008'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。ＤＳ処理内容区分が想定外の値です。（ＤＳ処理内容区分：008）", "メッセージ内容");

    }

    @Test
    @TestOrder(560)
    public void testExecPostForm_A56() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN99;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "010", "（ＩＷＳ）遷移先処理コード");

    }

    @Test
    @TestOrder(570)
    public void testExecPostForm_A57() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN99;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'002', 'iwsTtdkskbt':'1234567892'}");

        dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567892");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(10);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567892", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 11, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.SYONOINPUT, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "特定取引用口座、特定取引用暗証番号が利用できません。", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(580)
    public void testExecPostForm_A58() throws Exception {

        MockObjectManager.initialize();
        String className = "";

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDskokno':'8600000041'}");

        try {
            dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }

    @Test
    @TestOrder(590)
    public void testExecPostForm_A59() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'005', 'iwsSyono':'17807000142', 'iwsTtdkskbt':'1234567890', 'iwsDskokno':'9000000001', 'iwsTtdkis':'1', 'iwsKouzaVersion':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");
        exStringEquals(resultBean.getIwsTtdkskbt(), "1234567890", "（ＩＷＳ）手続識別ＩＤ");

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567890");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(13);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567890", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 14, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "特定取引用口座、特定取引用暗証番号が利用できません。　（入力内容：手続意思表示＝１）", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(600)
    public void testExecPostForm_A60() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'004', 'iwsTtdkskbt':'1234567894', 'iwsSyono':'17807000153', 'iwsDskokno':'9000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);
        WsDwDenwaKaiyakuUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDenwaKaiyakuUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsNextsyoricd(), "990", "（ＩＷＳ）遷移先処理コード");
        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567894");
        MT_SousaRirekiSyousai sousaRirekiSys = sousaRireki.getSousaRirekiSyousais().get(1);
        exStringEquals(sousaRirekiSys.getTtdksikibetuid(), "1234567894", "手続識別ＩＤ");
        exNumericEquals(sousaRirekiSys.getSousarirekirenno(), 2, "操作履歴連番");
        exDateEquals(sousaRirekiSys.getSyoriendymd(), BizDate.valueOf(20180101), "処理終了日付");
        exClassificationEquals(sousaRirekiSys.getSyorinaiyoukbn(), C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU, "処理内容区分");
        exStringEquals(sousaRirekiSys.getSyorisyousai(), "データメンテナンス中契約のため、処理できません。", "処理詳細");
        exStringEquals(sousaRirekiSys.getGyoumuKousinKinou(), "dwdenwakaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(sousaRirekiSys.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(610)
    public void testExecPostForm_A61() throws Exception {

        changeSystemDate(BizDate.valueOf(20180101));
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsSaibanSyoriMockForDirect.SYORIPTN = DsSaibanSyoriMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add(
            "gyoumuData",
            "{'iwsGyoumucd':'01', 'iwsSyorinaiyou':'006', 'iwsTtdkskbt':'1234567896', 'iwsTtdkis':'', 'iwsTyakusintime':'20180101125001', 'iwsCallid':'901999019990199901', 'iwsSyorikekka':'0', 'iwsStdnkasyo':'010', 'iwsStdnriyuu':'01', 'iwsTuuwatime':'1010010000'}");

        dwDenwaKaiyakuUketukeImpl.execPostForm(pMap);

        MT_SousaRireki sousaRireki = directDomManager.getSousaRireki("1234567896");
        MT_SousaRirekiIvrInfo susaRirekiIvrInfo = sousaRireki.getSousaRirekiIvrInfo();
        exClassificationEquals(susaRirekiIvrInfo.getTtdkisihyouzikbn(), C_TtdkIsihyouziKbn.BLNK, "手続意思表示区分");

    }
}
