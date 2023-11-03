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
import jp.co.slcs.swak.db.ExDBEntityManager;
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
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.entity.MT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwDsKaiyakuUktkOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ解約受付のメイン処理（解約受付データ登録）{@link DwKaiyakuUketukeImpl#execPostFormUpdate(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwKaiyakuUketukeTest_execPostFormUpdate {

    @Inject
    private DwKaiyakuUketukeImpl dwKaiyakuUketukeImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ解約受付";

    private final static String sheetName = "INデータ";

    @Inject
    ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

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
        WebServiceAccesslogOutputMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormUpdate.class;
        DsDB2UtilMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormUpdate.class;
        CheckDsKaiyakuMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormUpdate.class;
        CheckDsTorihikiServiceMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormUpdate.class;
        KeisanCommonKaiyakuMockForDirect.caller = DwKaiyakuUketukeTest_execPostFormUpdate.class;
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

            testDataAndTblMap = testDataMaker.getInData(DwKaiyakuUketukeTest_execPostFormUpdate.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        directDomManager.delete(directDomManager.getAllKhHenkouUktkYyk());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormUpdate_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsShrgkkeiyen(), null, "（ＩＷＳ）支払額合計（円貨）");
        exStringEquals(resultBean.getIwsKaiyakuhryen(), null, "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(resultBean.getIwsYendthnkhr(), null, "（ＩＷＳ）円建変更時返戻金");
        exStringEquals(resultBean.getIwsGstszeigkyen(), null, "（ＩＷＳ）源泉徴収税額（円貨）");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormUpdate_A2() throws Exception {

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

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormUpdate_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013',"
            + " 'iwsDskokno':'8600000026', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012', "
            + "'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013200", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormUpdate_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000027', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1',"
            + " 'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'101'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013018", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExecPostFormUpdate_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000038', "
            + "'iwsDskokno':'8600000022', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013000", "（ＩＷＳ）ＤＳメッセージコード");

        List<IT_KhHenkouUktk> itKhHenkouUktks = hozenDomManager.getAllKhHenkouUktk();
        IT_KhHenkouUktk itKhHenkouUktk = itKhHenkouUktks.get(0);
        exStringEquals(itKhHenkouUktk.getSyono(), "10806000038", "証券番号");
        exBooleanEquals(itKhHenkouUktk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(itKhHenkouUktk.getUktkymd(), BizDate.getSysDate(), "受付日");
        exClassificationEquals(itKhHenkouUktk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(itKhHenkouUktk.getUktksyorikbn(), C_UktkSyoriKbn.KAIYAKU, "受付処理区分");
        exDateEquals(itKhHenkouUktk.getKouryokuhasseiymd(), BizDate.getSysDate(), "効力発生日");
        exDateEquals(itKhHenkouUktk.getSyoriyoteiymd(), BizDate.getSysDate(), "処理予定日");
        exClassificationEquals(itKhHenkouUktk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");

        IT_KhHenkouUktkKaiyaku itKhHenkouUktkKaiyaku = itKhHenkouUktk.getKhHenkouUktkKaiyaku();
        exStringEquals(itKhHenkouUktkKaiyaku.getSyono(), "10806000038", "証券番号");
        exBooleanEquals(itKhHenkouUktkKaiyaku.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getYenshrtkhkumu(), C_UmuKbn.ARI, "円支払特約付加有無");
        exStringEquals(itKhHenkouUktkKaiyaku.getBankcd(), "1001", "銀行コード");
        exStringEquals(itKhHenkouUktkKaiyaku.getSitencd(), "001", "支店コード");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(itKhHenkouUktkKaiyaku.getKouzano(), "KZ1234567890", "口座番号");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(itKhHenkouUktkKaiyaku.getKzmeiginmkn(), "ナカムラナカムラナカムラナカムラナカムラナカムラナカムラ３０", "口座名義人氏名（カナ）");
        exStringEquals(itKhHenkouUktkKaiyaku.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktkKaiyaku.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktkKaiyaku.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());

        List<MT_KhHenkouUktkYyk> mtKhHenkouUktkYyks = directDomManager.getAllKhHenkouUktkYyk();
        exNumericEquals(mtKhHenkouUktkYyks.size(), 0, "契約保全変更受付予約テーブル、契約保全変更受付内容（解約）予約テーブル");
    }



    @Test
    @TestOrder(60)
    @Transactional
    public void testExecPostFormUpdate_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000027', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013000", "（ＩＷＳ）ＤＳメッセージコード");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwDsKaiyakuUktkInputBean tBean = (WsDwDsKaiyakuUktkInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, "10806000027");
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 1, BizDate.getSysDate());
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 2,
            BizCurrency.valueOf(new BigDecimal("1234546789012")));
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 3,
            C_DsSyouhnbunruiKbn.GKDTITIJIBRSYSN);

        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, "10806000027");

        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 1, "1001");
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 2, "001");
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 3, "ナカムラ３");
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 4, C_Kzdou.SITEI);
        MockObjectManager.assertArgumentPassed(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 5, "ユヒメイ　イチア");

        List<IT_KhHenkouUktk> itKhHenkouUktks = hozenDomManager.getAllKhHenkouUktk();
        IT_KhHenkouUktk itKhHenkouUktk = itKhHenkouUktks.get(0);
        exStringEquals(itKhHenkouUktk.getSyono(), "10806000027", "証券番号");
        exBooleanEquals(itKhHenkouUktk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(itKhHenkouUktk.getUktkymd(), BizDate.getSysDate(), "受付日");
        exClassificationEquals(itKhHenkouUktk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(itKhHenkouUktk.getUktksyorikbn(), C_UktkSyoriKbn.KAIYAKU, "受付処理区分");
        exDateEquals(itKhHenkouUktk.getKouryokuhasseiymd(), BizDate.getSysDate(), "効力発生日");
        exDateEquals(itKhHenkouUktk.getSyoriyoteiymd(), BizDate.getSysDate(), "処理予定日");
        exClassificationEquals(itKhHenkouUktk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");

        IT_KhHenkouUktkKaiyaku itKhHenkouUktkKaiyaku = itKhHenkouUktk.getKhHenkouUktkKaiyaku();
        exStringEquals(itKhHenkouUktkKaiyaku.getSyono(), "10806000027", "証券番号");
        exBooleanEquals(itKhHenkouUktkKaiyaku.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getYenshrtkhkumu(), C_UmuKbn.NONE, "円支払特約付加有無");
        exStringEquals(itKhHenkouUktkKaiyaku.getBankcd(), "1001", "銀行コード");
        exStringEquals(itKhHenkouUktkKaiyaku.getSitencd(), "001", "支店コード");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(itKhHenkouUktkKaiyaku.getKouzano(), "KZ0000000001", "口座番号");
        exClassificationEquals(itKhHenkouUktkKaiyaku.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(itKhHenkouUktkKaiyaku.getKzmeiginmkn(), "コウザメイギ", "口座名義人氏名（カナ）");
        exStringEquals(itKhHenkouUktkKaiyaku.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktkKaiyaku.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktkKaiyaku.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());

        List<MT_KhHenkouUktkYyk> mtKhHenkouUktkYyks = directDomManager.getAllKhHenkouUktkYyk();
        exNumericEquals(mtKhHenkouUktkYyks.size(), 0, "契約保全変更受付予約テーブル、契約保全変更受付内容（解約）予約テーブル");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExecPostFormUpdate_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000038', "
            + "'iwsDskokno':'8600000022', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013000", "（ＩＷＳ）ＤＳメッセージコード");

        List<MT_KhHenkouUktkYyk> mtKhHenkouUktkYyks = directDomManager.getAllKhHenkouUktkYyk();
        MT_KhHenkouUktkYyk mtKhHenkouUktkYyk = mtKhHenkouUktkYyks.get(0);
        exStringEquals(mtKhHenkouUktkYyk.getSyono(), "10806000038", "証券番号");
        exBooleanEquals(mtKhHenkouUktkYyk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(mtKhHenkouUktkYyk.getUktkymd(), BizDate.getSysDate(), "受付日");
        exClassificationEquals(mtKhHenkouUktkYyk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(mtKhHenkouUktkYyk.getUktksyorikbn(), C_UktkSyoriKbn.KAIYAKU, "受付処理区分");
        exDateEquals(mtKhHenkouUktkYyk.getKouryokuhasseiymd(), BizDate.getSysDate(), "効力発生日");
        exDateEquals(mtKhHenkouUktkYyk.getSyoriyoteiymd(), BizDate.getSysDate().addBusinessDays(1), "処理予定日");
        exClassificationEquals(mtKhHenkouUktkYyk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(mtKhHenkouUktkYyk.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(mtKhHenkouUktkYyk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(mtKhHenkouUktkYyk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");

        MT_KhHenkouUktkKaiyakuYyk mtKhHenkouUktkKaiyakuYyk = mtKhHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk();
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getSyono(), "10806000038", "証券番号");
        exBooleanEquals(mtKhHenkouUktkKaiyakuYyk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getYenshrtkhkumu(), C_UmuKbn.ARI, "円支払特約付加有無");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getBankcd(), "1001", "銀行コード");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getSitencd(), "001", "支店コード");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getKouzano(), "KZ1234567890", "口座番号");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getKzmeiginmkn(), "ナカムラナカムラナカムラナカムラナカムラナカムラナカムラ３０", "口座名義人氏名（カナ）");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(mtKhHenkouUktkKaiyakuYyk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
        directDomManager.delete(directDomManager.getAllKhHenkouUktkYyk());

        List<IT_KhHenkouUktk> itKhHenkouUktks = hozenDomManager.getAllKhHenkouUktk();
        exNumericEquals(itKhHenkouUktks.size(), 0,"契約保全変更受付テーブル、契約保全変更受付内容（解約）テーブル");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExecPostFormUpdate_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'10806000027', "
            + "'iwsDskokno':'8600000023', "
            + "'iwsDssyouhnbunruikbn':'1', "
            + "'iwsKaiyakuhr':'1234546789012',"
            + " 'iwsShrtuukasyu':'JPY', "
            + "'iwsVersion':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013000", "（ＩＷＳ）ＤＳメッセージコード");

        List<MT_KhHenkouUktkYyk> mtKhHenkouUktkYyks = directDomManager.getAllKhHenkouUktkYyk();
        MT_KhHenkouUktkYyk mtKhHenkouUktkYyk = mtKhHenkouUktkYyks.get(0);
        exStringEquals(mtKhHenkouUktkYyk.getSyono(), "10806000027", "証券番号");
        exBooleanEquals(mtKhHenkouUktkYyk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(mtKhHenkouUktkYyk.getUktkymd(), BizDate.getSysDate(), "受付日");
        exClassificationEquals(mtKhHenkouUktkYyk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(mtKhHenkouUktkYyk.getUktksyorikbn(), C_UktkSyoriKbn.KAIYAKU, "受付処理区分");
        exDateEquals(mtKhHenkouUktkYyk.getKouryokuhasseiymd(), BizDate.getSysDate(), "効力発生日");
        exDateEquals(mtKhHenkouUktkYyk.getSyoriyoteiymd(), BizDate.getSysDate().addBusinessDays(1), "処理予定日");
        exClassificationEquals(mtKhHenkouUktkYyk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(mtKhHenkouUktkYyk.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(mtKhHenkouUktkYyk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(mtKhHenkouUktkYyk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");

        MT_KhHenkouUktkKaiyakuYyk mtKhHenkouUktkKaiyakuYyk = mtKhHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk();
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getSyono(), "10806000027", "証券番号");
        exBooleanEquals(mtKhHenkouUktkKaiyakuYyk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getYenshrtkhkumu(), C_UmuKbn.NONE, "円支払特約付加有無");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getBankcd(), "1001", "銀行コード");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getSitencd(), "001", "支店コード");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getKouzano(), "KZ0000000001", "口座番号");
        exClassificationEquals(mtKhHenkouUktkKaiyakuYyk.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getKzmeiginmkn(), "コウザメイギ", "口座名義人氏名（カナ）");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getGyoumuKousinKinou(), "dwkaiyakuuketuke", "業務用更新機能ＩＤ");
        exStringEquals(mtKhHenkouUktkKaiyakuYyk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(mtKhHenkouUktkKaiyakuYyk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
        directDomManager.delete(directDomManager.getAllKhHenkouUktkYyk());

        List<IT_KhHenkouUktk> itKhHenkouUktks = hozenDomManager.getAllKhHenkouUktk();
        exNumericEquals(itKhHenkouUktks.size(), 0,"契約保全変更受付テーブル、契約保全変更受付内容（解約）テーブル");
    }

    @Test
    @TestOrder(90)
    public void testExecPostFormUpdate_B1() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013205", "（ＩＷＳ）ＤＳメッセージコード");


    }

    @Test
    @TestOrder(100)
    public void testExecPostFormUpdate_B2() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        WsDwDsKaiyakuUktkOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwDsKaiyakuUktkOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "013204", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(110)
    public void testExecPostFormUpdate_B3() throws Exception{

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        String className = "";

        try {
            dwKaiyakuUketukeImpl.execPostFormUpdate(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
