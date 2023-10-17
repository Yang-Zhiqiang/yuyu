package yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke;

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
import jp.co.slcs.swak.db.ExDBEntityManager;
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
import yuyu.common.direct.dscommon.DsTumitatekinItenCheck;
import yuyu.common.direct.dscommon.DsTumitatekinItenCheckMockForDirect;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwTumitatekinItenUketukeOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ積立金移転受付サービスのメイン処理（積立金移転受付データ更新）{@link DwTumitatekinItenUketukeImpl#execPostFormUpdate(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwTumitatekinItenUketukeTest_execPostFormUpdate extends AbstractTest {

    @Inject
    private DwTumitatekinItenUketukeImpl dwTumitatekinItenUketukeImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ積立金移転受付";

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
                bind(DsTumitatekinItenCheck.class).to(DsTumitatekinItenCheckMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormUpdate.class;
        DsDB2UtilMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormUpdate.class;
        DsTumitatekinItenCheckMockForDirect.caller = DwTumitatekinItenUketukeTest_execPostFormPrepare.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        DsTumitatekinItenCheckMockForDirect.caller = null;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DwTumitatekinItenUketukeTest_execPostFormUpdate.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getSequence("21"));
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllKhHenkouUktkYyk());
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormUpdate_A1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormUpdate_A2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormUpdate_A3() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'860000017','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormUpdate_A4() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012301", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExecPostFormUpdate_A5() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN10;

        changeSystemDate(BizDate.valueOf(20180319));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180319'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012000", "（ＩＷＳ）ＤＳメッセージコード");

        List<IT_KhHenkouUktk> itKhHenkouUktks = hozenDomManager.getAllKhHenkouUktk();
        IT_KhHenkouUktk itKhHenkouUktk = itKhHenkouUktks.get(0);
        exStringEquals(itKhHenkouUktk.getSyono(), "17806000013", "証券番号");
        exBooleanEquals(itKhHenkouUktk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(itKhHenkouUktk.getUktkymd(), BizDate.valueOf(20180319), "受付日");
        exClassificationEquals(itKhHenkouUktk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(itKhHenkouUktk.getUktksyorikbn(), C_UktkSyoriKbn.TMTTKNITEN, "受付処理区分");
        exDateEquals(itKhHenkouUktk.getKouryokuhasseiymd(), BizDate.valueOf(20180319), "効力発生日");
        exDateEquals(itKhHenkouUktk.getSyoriyoteiymd(), BizDate.valueOf(20180316), "処理予定日");
        exClassificationEquals(itKhHenkouUktk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinKinou(), "dwtumitatekinitenuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
    }



    @Test
    @TestOrder(60)
    @Transactional
    public void testExecPostFormUpdate_A6() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN10;

        changeSystemDate(BizDate.valueOf(20180319));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180319'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012000", "（ＩＷＳ）ＤＳメッセージコード");

        List<MT_KhHenkouUktkYyk> mtKhHenkouUktkYyks = directDomManager.getAllKhHenkouUktkYyk();
        MT_KhHenkouUktkYyk khHenkouUktkYyk = mtKhHenkouUktkYyks.get(0);
        exStringEquals(khHenkouUktkYyk.getSyono(), "17806000013", "証券番号");
        exBooleanEquals(khHenkouUktkYyk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(khHenkouUktkYyk.getUktkymd(), BizDate.valueOf(20180319), "受付日");
        exClassificationEquals(khHenkouUktkYyk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(khHenkouUktkYyk.getUktksyorikbn(), C_UktkSyoriKbn.TMTTKNITEN, "受付処理区分");
        exDateEquals(khHenkouUktkYyk.getKouryokuhasseiymd(), BizDate.valueOf(20180319), "効力発生日");
        exDateEquals(khHenkouUktkYyk.getSyoriyoteiymd(), BizDate.valueOf(20180316), "処理予定日");
        exClassificationEquals(khHenkouUktkYyk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(khHenkouUktkYyk.getGyoumuKousinKinou(), "dwtumitatekinitenuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkYyk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(khHenkouUktkYyk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExecPostFormUpdate_A7() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsTumitatekinItenCheckMockForDirect.SYORIPTN = DsTumitatekinItenCheckMockForDirect.TESTPATTERN10;

        changeSystemDate(BizDate.valueOf(20180317));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180317'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012000", "（ＩＷＳ）ＤＳメッセージコード");

        List<MT_KhHenkouUktkYyk> mtKhHenkouUktkYyks = directDomManager.getAllKhHenkouUktkYyk();
        MT_KhHenkouUktkYyk khHenkouUktkYyk = mtKhHenkouUktkYyks.get(1);
        exStringEquals(khHenkouUktkYyk.getSyono(), "17806000013", "証券番号");
        exBooleanEquals(khHenkouUktkYyk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(khHenkouUktkYyk.getUktkymd(), BizDate.valueOf(20180317), "受付日");
        exClassificationEquals(khHenkouUktkYyk.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(khHenkouUktkYyk.getUktksyorikbn(), C_UktkSyoriKbn.TMTTKNITEN, "受付処理区分");
        exDateEquals(khHenkouUktkYyk.getKouryokuhasseiymd(), BizDate.valueOf(20180317), "効力発生日");
        exDateEquals(khHenkouUktkYyk.getSyoriyoteiymd(), BizDate.valueOf(20180316), "処理予定日");
        exClassificationEquals(khHenkouUktkYyk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(khHenkouUktkYyk.getGyoumuKousinKinou(), "dwtumitatekinitenuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkYyk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(khHenkouUktkYyk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    public void testExecPostFormUpdate_A8() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012203", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(90)
    public void testExecPostFormUpdate_A9() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013','iwsTumitatekinitenyoteibi':'20180316'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        WsDwTumitatekinItenUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwTumitatekinItenUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "012202", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(100)
    public void testExecPostFormUpdate_A10() throws Exception{

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013'}");

        String className = "";

        try {
            dwTumitatekinItenUketukeImpl.execPostFormUpdate(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
