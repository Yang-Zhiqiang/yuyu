package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.CheckDsMkhgkHenkou;
import yuyu.common.direct.dscommon.CheckDsMkhgkHenkouMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import yuyu.def.dsweb.bean.webservice.WsDwMkhgkHenkouUketukeInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwMkhgkHenkouUketukeOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ目標額変更受付のメイン処理（目標額変更受付データ更新）{@link DwMkhgkHenkouUketukeImpl#execPostFormUpdate(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwMkhgkHenkouUketukeTest_execPostFormUpdate {

    @Inject
    private DwMkhgkHenkouUketukeImpl dwMkhgkHenkouUketukeImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ目標額変更受付";

    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
                bind(CheckDsMkhgkHenkou.class).to(CheckDsMkhgkHenkouMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        WebServiceAccesslogOutputMockForDirect.caller = DwMkhgkHenkouUketukeTest_execPostFormUpdate.class;
        DsDB2UtilMockForDirect.caller = DwMkhgkHenkouUketukeTest_execPostFormUpdate.class;
        CheckDsMkhgkHenkouMockForDirect.caller = DwMkhgkHenkouUketukeTest_execPostFormUpdate.class;

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        CheckDsMkhgkHenkouMockForDirect.caller = null;
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DwMkhgkHenkouUketukeTest_execPostFormUpdate.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
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
    public void testExecPostFormUpdate_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'', "
               + "'iwsHenkougomkhgkwari':'8600000026'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021100", "（ＩＷＳ）ＤＳメッセージコード");
    }


    @Test
    @TestOrder(20)
    public void testExecPostFormUpdate_A2() throws Exception {

        MockObjectManager.initialize();

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
                + "'iwsHenkougomkhgkwari':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormUpdate_A3() throws Exception {

        MockObjectManager.initialize();

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013', "
               + "'iwsHenkougomkhgkwari':'8600000026'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormUpdate_A4() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021300", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(50)
    public void testExecPostFormUpdate_A5() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021301", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(60)
    public void testExecPostFormUpdate_A6() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021307", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(70)
    public void testExecPostFormUpdate_A7() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021303", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(80)
    public void testExecPostFormUpdate_A8() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021304", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(90)
    public void testExecPostFormUpdate_A9() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021302", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(100)
    public void testExecPostFormUpdate_A10() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN8;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021305", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(110)
    public void testExecPostFormUpdate_A11() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021306", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(120)
    public void testExecPostFormUpdate_A12() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021101", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(130)
    public void testExecPostFormUpdate_A13() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN11;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021203", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(resultBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(resultBean.getIwsMkhgkhnkkahikbn(), "0", "（ＩＷＳ）目標額変更可否区分");
    }

    @Test
    @TestOrder(140)
    public void testExecPostFormUpdate_A14() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN12;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129', "
                + "'iwsHenkougomkhgkwari':'1'}");

        try{
            dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。ＤＳ目標額変更共通チェック結果が想定外の値です。", "メッセージ内容");
        }

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExecPostFormUpdate_A15() throws Exception {

        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111141', "
                + "'iwsHenkougomkhgkwari':'100'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        assertNotNull("（共通）ＷｅｂサービスリクエストパラメータBEAN", wsBzWebserviceReqParamBean);

        WsDwMkhgkHenkouUketukeInputBean tBean = (WsDwMkhgkHenkouUketukeInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        assertNotNull("業務データBEAN", tBean);

        MockObjectManager.assertArgumentPassed(CheckDsMkhgkHenkouMockForDirect.class, "chkMkhgkHnkUktkDataUpd", 0, "11807111141");
        MockObjectManager.assertArgumentPassed(CheckDsMkhgkHenkouMockForDirect.class, "chkMkhgkHnkUktkDataUpd", 1, 100);

        IT_KhHenkouUktk itKhHenkouUktk = hozenDomManager.getKhHenkouUktk("11807111141", 1);

        exStringEquals(itKhHenkouUktk.getSyono(), "11807111141", "証券番号");
        exBooleanEquals(itKhHenkouUktk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(itKhHenkouUktk.getUktkymd(), BizDate.valueOf(20190801), "受付日");
        exClassificationEquals(itKhHenkouUktk.getTourokuroute(), C_TourokuRouteKbn.BATCH, "登録ルート");
        exClassificationEquals(itKhHenkouUktk.getUktksyorikbn(), C_UktkSyoriKbn.MKHGKHNK, "受付処理区分");
        exDateEquals(itKhHenkouUktk.getKouryokuhasseiymd(), BizDate.valueOf(20190802), "効力発生日");
        exDateEquals(itKhHenkouUktk.getSyoriyoteiymd(), BizDate.valueOf(20190801), "処理予定日");
        exClassificationEquals(itKhHenkouUktk.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.TORIKESI, "受付状態区分");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinKinou(), "dwmkhgkhenkouuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");

        IT_KhHenkouUktk itKhHenkouUktk2 = hozenDomManager.getKhHenkouUktk("11807111141", 2);

        exStringEquals(itKhHenkouUktk2.getSyono(), "11807111141", "証券番号");
        exBooleanEquals(itKhHenkouUktk2.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exDateEquals(itKhHenkouUktk2.getUktkymd(), BizDate.getSysDate(), "受付日");
        exClassificationEquals(itKhHenkouUktk2.getTourokuroute(), C_TourokuRouteKbn.DS, "登録ルート");
        exClassificationEquals(itKhHenkouUktk2.getUktksyorikbn(), C_UktkSyoriKbn.MKHGKHNK, "受付処理区分");
        exDateEquals(itKhHenkouUktk2.getKouryokuhasseiymd(), BizDate.getSysDate(), "効力発生日");
        exDateEquals(itKhHenkouUktk2.getSyoriyoteiymd(), BizDate.getSysDate(), "処理予定日");
        exClassificationEquals(itKhHenkouUktk2.getUktkjyoutaikbn(), C_UktkJyoutaiKbn.MISYORI, "受付状態区分");
        exStringEquals(itKhHenkouUktk2.getGyoumuKousinKinou(), "dwmkhgkhenkouuketuke", "業務用更新機能ＩＤ");
        exStringEquals(itKhHenkouUktk2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(itKhHenkouUktk2.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");


        IT_KhHenkouUktkMkhgkHnk khHenkouUktkMkhgkHnk = itKhHenkouUktk2.getKhHenkouUktkMkhgkHnk();
        exStringEquals(khHenkouUktkMkhgkHnk.getSyono(), "11807111141", "証券番号");
        exBooleanEquals(khHenkouUktkMkhgkHnk.getHozenhenkouuktkrenno() > 0, true, "保全変更受付連番");
        exNumericEquals(khHenkouUktkMkhgkHnk.getTargettkmokuhyouti(), 100, "ターゲット特約目標値");
        exStringEquals(khHenkouUktkMkhgkHnk.getGyoumuKousinKinou(), "dwmkhgkhenkouuketuke", "業務用更新機能ＩＤ");
        exStringEquals(khHenkouUktkMkhgkHnk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exBooleanEquals(khHenkouUktkMkhgkHnk.getGyoumuKousinTime().length() > 0, true, "業務用更新時間");
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExecPostFormUpdate_A16() throws Exception {


        MockObjectManager.initialize();
        CheckDsMkhgkHenkouMockForDirect.SYORIPTN = CheckDsMkhgkHenkouMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111130', "
                + "'iwsHenkougomkhgkwari':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021000", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(170)
    public void testExecPostFormUpdate_B1() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021202", "（ＩＷＳ）ＤＳメッセージコード");


    }

    @Test
    @TestOrder(180)
    public void testExecPostFormUpdate_B2() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        WsDwMkhgkHenkouUketukeOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
                WsDwMkhgkHenkouUketukeOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "021201", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(190)
    public void testExecPostFormUpdate_B3() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'10806000016'}");

        String className = "";

        try {
            dwMkhgkHenkouUketukeImpl.execPostFormUpdate(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, null, "例外");

    }
}
