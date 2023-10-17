package yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran;

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
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.CheckDsKaiyakuMockForDirect;
import yuyu.common.direct.dscommon.DsDataMaintenanceHantei;
import yuyu.common.direct.dscommon.DsDataMaintenanceHanteiMockForDirect;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuMockForDirect;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngaiMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranKykInfoBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ加入契約一覧取得のメイン処理{@link DwGetDsKanyuuKeiyakuItiranImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwGetDsKanyuuKeiyakuItiranTest_execPostForm extends AbstractTest {

    @Inject
    private DwGetDsKanyuuKeiyakuItiranImpl dwGetDsKanyuuKeiyakuItiranImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ加入契約一覧取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class);
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(CheckDsKaiyaku.class).to(CheckDsKaiyakuMockForDirect.class);
                bind(CheckYuuyokkngai.class).to(CheckYuuyokkngaiMockForDirect.class);
                bind(DsDataMaintenanceHantei.class).to(DsDataMaintenanceHanteiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class;
        WebServiceAccesslogOutputMockForDirect.caller = DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class;
        CheckDsKaiyakuMockForDirect.caller = DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class;
        CheckYuuyokkngaiMockForDirect.caller = DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class;
        DsDataMaintenanceHanteiMockForDirect.caller = DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        WebServiceAccesslogOutputMockForDirect.caller = null;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = null;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = null;
        CheckDsKaiyakuMockForDirect.SYORIPTN = null;
        CheckDsKaiyakuMockForDirect.caller = null;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = null;
        CheckYuuyokkngaiMockForDirect.caller = null;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = null;
        DsDataMaintenanceHanteiMockForDirect.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'1Aa00000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004100", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000017'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004200", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004001", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000033'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 1, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "17806000013", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "2", "（ＩＷＳ）ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf("20190826"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000041'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 2, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "17806000046", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "2", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsSyono(), "17806000068", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "2", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsKykssmongon(), "（円建終身保険へ変更済）", "（ＩＷＳ）契約詳細文言");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004100", "（ＩＷＳ）ＤＳメッセージコード");
        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);
        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 1);
        exBooleanEquals(wsBzWebserviceReqParamBean != null, true, "（共通）ＷｅｂサービスリクエストパラメータBEAN");
        WsDwGetDsKanyuuKeiyakuItiranInputBean tBean = (WsDwGetDsKanyuuKeiyakuItiranInputBean) MockObjectManager
            .getArgument(WebServiceAccesslogOutputMockForDirect.class, "exec", 0, 2);
        exBooleanEquals(tBean != null, true, "業務データBEAN");
    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf("20190325"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000059'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 8, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "11807111118", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(2).getIwsSyono(), "11807111130", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(2).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(2).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(3).getIwsSyono(), "11807111141", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(3).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(3).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(4).getIwsSyono(), "11807111152", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(4).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(4).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(5).getIwsSyono(), "11807111163", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(5).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(5).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(6).getIwsSyono(), "11807111174", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(6).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(6).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(7).getIwsSyono(), "11807111185", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(7).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(7).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(7).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000067'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 8, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "11807111211", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyono(), "11807111222", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(2).getIwsSyono(), "11807111233", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(2).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(3).getIwsSyono(), "11807111244", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(3).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(4).getIwsSyono(), "11807111255", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(4).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(5).getIwsSyono(), "11807111266", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(5).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(6).getIwsSyono(), "11807111277", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(6).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(7).getIwsSyono(), "11807111288", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(7).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000073'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004203", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);

    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000033'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004001", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);

        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, "17806000013");

    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000067'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004002", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 7, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "11807111211", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsSyono(), "11807111233", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(2).getIwsSyono(), "11807111244", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(2).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(2).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(3).getIwsSyono(), "11807111255", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(3).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(3).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(4).getIwsSyono(), "11807111266", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(4).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(4).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(5).getIwsSyono(), "11807111277", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(5).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(5).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(6).getIwsSyono(), "11807111288", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(6).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(6).getIwsSyohnkiticd(), "1", "（ＩＷＳ）商品改定コード");
    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000084'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 8, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "11807111303", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsSyono(), "11807111314", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(2).getIwsSyono(), "11807111325", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(2).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(2).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(3).getIwsSyono(), "11807111336", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(3).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(3).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(4).getIwsSyono(), "11807111347", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(4).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(4).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(5).getIwsSyono(), "11807111358", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(5).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(5).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(6).getIwsSyono(), "11807111369", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(6).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(6).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(7).getIwsSyono(), "11807111370", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(7).getIwsDssyouhnbunruikbn(), "4", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(7).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_A13() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN2;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000041'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004001", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);
    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_A14() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf("20190826"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000095'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 4, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "60806000011", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "5", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsSyono(), "60806000022", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "5", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(2).getIwsSyono(), "60806000033", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(2).getIwsDssyouhnbunruikbn(), "5", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(2).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(3).getIwsSyono(), "60806000044", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(3).getIwsDssyouhnbunruikbn(), "5", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(3).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(3).getIwsKykssmongon(), "（円建年金保険へ変更済）", "（ＩＷＳ）契約詳細文言");
    }

    @Test
    @TestOrder(150)
    public void testExecPostForm_A15() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN2;
        changeSystemDate(BizDate.valueOf("20190401"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000096'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004204", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();
        assertNull(beanLst);

    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_A16() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN3;
        changeSystemDate(BizDate.valueOf("20190826"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000097'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exStringEquals(beanLst.get(0).getIwsKykssmongon(), "（データメンテナンス中）", "（ＩＷＳ）契約詳細文言");
    }

    @Test
    @TestOrder(170)
    public void testExecPostForm_A17() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf("20190826"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000098'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 4, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "60806000077", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "2", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(0).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
        exStringEquals(beanLst.get(1).getIwsSyono(), "60806000088", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(1).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(1).getIwsSyohnkiticd(), "2", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(1).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
        exStringEquals(beanLst.get(2).getIwsSyono(), "60806000099", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(2).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(2).getIwsSyohnkiticd(), "2", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(2).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
        exStringEquals(beanLst.get(3).getIwsSyono(), "60806000103", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(3).getIwsDssyouhnbunruikbn(), "1", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(3).getIwsSyohnkiticd(), "2", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(3).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000090'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 1, "件数");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "3", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "2", "（ＩＷＳ）商品改定コード");
    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_A19() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf("20201214"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000109'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 1, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "11807111381", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "2", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "2", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(0).getIwsKykssmongon(), "（円建終身保険へ変更済）", "（ＩＷＳ）契約詳細文言");
    }

    @Test
    @TestOrder(200)
    public void testExecPostForm_A20() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf("20201214"));
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'8600000110'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        exStringEquals(resultBean.getIwsDsmsgcd(), "004000", "（ＩＷＳ）ＤＳメッセージコード");

        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> beanLst = resultBean.getWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList();

        exNumericEquals(beanLst.size(), 1, "件数");
        exStringEquals(beanLst.get(0).getIwsSyono(), "86806000013", "（ＩＷＳ）証券番号");
        exStringEquals(beanLst.get(0).getIwsDssyouhnbunruikbn(), "6", "（ＩＷＳ）ＤＳ商品分類区分");
        exStringEquals(beanLst.get(0).getIwsSyohnkiticd(), "", "（ＩＷＳ）商品改定コード");
        exStringEquals(beanLst.get(0).getIwsKykssmongon(), "", "（ＩＷＳ）契約詳細文言");
    }
}
