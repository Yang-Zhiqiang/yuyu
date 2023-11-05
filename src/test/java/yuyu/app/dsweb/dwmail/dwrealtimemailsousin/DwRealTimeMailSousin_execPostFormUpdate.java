package yuyu.app.dsweb.dwmail.dwrealtimemailsousin;

import static org.junit.Assert.*;
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
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsSaibanSyoriMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwRealTimeMailSousinInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwRealTimeMailSousinOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * DSリアルタイムメール送信のメイン処理{@link DwRealTimeMailSousinImpl#execPostFormUpdate(MultivaluedMap<String, String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwRealTimeMailSousin_execPostFormUpdate extends AbstractTest  {

    @Inject
    private DwRealTimeMailSousinImpl dwRealTimeMailSousinImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳリアルタイムメール送信";

    private final static String sheetName = "INデータ";

    @Inject
    private DirectDomManager directDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DsSaibanSyori.class).to(DsSaibanSyoriMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        DsSaibanSyoriMockForDirect.caller = DwRealTimeMailSousin_execPostFormUpdate.class;
        DsDB2UtilMockForDirect.caller = DwRealTimeMailSousin_execPostFormUpdate.class;
        WebServiceAccesslogOutputMockForDirect.caller = DwRealTimeMailSousin_execPostFormUpdate.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        DsSaibanSyoriMockForDirect.caller = null;
        DsSaibanSyoriMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwRealTimeMailSousin_execPostFormUpdate.class,
                fileName, sheetName);
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
        directDomManager.delete(directDomManager.getAllBAKDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormUpdate_A1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20180508"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDssousinmailsyubetukbn':'10200','iwsDskokno':'1001111001',"
            + "'iwsDsmailaddress':'www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp',"
            + "'iwsDssousinno':'180508T1400NR00000001','iwsSyono':'11807111118'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormUpdate(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016000", "（ＩＷＳ）ＤＳメッセージコード");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111001");

        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekis();
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDsdatasakuseiymd().toString(), "20180508", "ＤＳデータ作成日");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban(), 1, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getHaisinjidsmailaddress(),
            "www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp", "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinno(), "180508T1400NR00000001", "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinmailsyubetukbn().toString(), "10200", "ＤＳ送信メール種別区分");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getSyono(), "11807111118", "証券番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinKinou(), "dwrealtimemailsousin", "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwRealTimeMailSousinInputBean tBean = (WsDwRealTimeMailSousinInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormUpdate_A2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20180509"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDssousinmailsyubetukbn':'10200','iwsDskokno':'1001111003',"
            + "'iwsDsmailaddress':'sumisei003@yuyu.jp','iwsDssousinno':'180509T1400NR00000001','iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormUpdate(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016000", "（ＩＷＳ）ＤＳメッセージコード");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111003");

        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekis();
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDsdatasakuseiymd().toString(), "20180509", "ＤＳデータ作成日");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban(), 200000003, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getHaisinjidsmailaddress(), "sumisei003@yuyu.jp", "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinno(), "180509T1400NR00000001", "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinmailsyubetukbn().toString(), "10200", "ＤＳ送信メール種別区分");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getSyono(), "", "証券番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinKinou(), "dwrealtimemailsousin", "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormUpdate_B1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormUpdate(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016203", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormUpdate_B2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDssousinmailsyubetukbn':'10200'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormUpdate(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016202", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(50)
    public void testExecPostFormUpdate_B3() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDssousinmailsyubetukbn':'10200'}");

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormUpdate(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

        Throwable throwable = (Throwable) MockObjectManager.getArgument(DsDB2UtilMockForDirect.class, "exec", 0, 0);
        exStringEquals(throwable.toString(),
            "java.lang.RuntimeException: java.lang.reflect.InvocationTargetException", "エラー");
    }

    @Test
    @TestOrder(60)
    public void testExecPostFormUpdate_C1() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDssousinmailsyubetukbn':'10200','iwsDskokno':'1001111004',"
            + "'iwsDsmailaddress':'sumisei004@yuyu.jp','iwsDssousinno':'180509T1400NR00000002','iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwRealTimeMailSousinImpl.execPostFormUpdate(pMap);
        WsDwRealTimeMailSousinOutputBean wsDwRealTimeMailSousinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwRealTimeMailSousinOutputBean.class);

        exStringEquals(wsDwRealTimeMailSousinOutputBean.getIwsDsmsgcd(), "016201", "（ＩＷＳ）ＤＳメッセージコード");
    }
}
