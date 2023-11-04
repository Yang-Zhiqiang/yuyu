package yuyu.app.bosyuu.hbkeiyakusyoukai.hbkyknaiyouosirase;

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
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForHozen;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsiraseMockForHozen;
import yuyu.common.hozen.khcommon.KhAddKoumokuSetteiBean;
import yuyu.common.hozen.khcommon.KykNaiyouOsiraseiSks;
import yuyu.common.hozen.khcommon.KykNaiyouOsiraseiSksMockForHozen;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKykNaiyouOsiraseOutInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKykNaiyouOsiraseOutOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂご契約内容のお知らせ {@link HbKykNaiyouOsirase#exec(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbKykNaiyouOsiraseTest_exec extends AbstractTest {

    @Inject
    private HbKykNaiyouOsiraseImpl hbKykNaiyouOsiraseimpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂご契約内容のお知らせ";

    private final static String sheetName = "INデータ";

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(KykNaiyouOsiraseiSks.class).to(KykNaiyouOsiraseiSksMockForHozen.class);
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForHozen.class);
                bind(EditKykNaiyouOsirase.class).to(EditKykNaiyouOsiraseMockForHozen.class);

            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(HbKykNaiyouOsiraseTest_exec.class, fileName, sheetName);

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

    @BeforeClass
    public static void testInit() {

        KykNaiyouOsiraseiSksMockForHozen.caller = HbKykNaiyouOsiraseTest_exec.class;
        WebServiceAccesslogOutputMockForHozen.caller = HbKykNaiyouOsiraseTest_exec.class;
        EditKykNaiyouOsiraseMockForHozen.caller = HbKykNaiyouOsiraseTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KykNaiyouOsiraseiSksMockForHozen.caller = null;
        KykNaiyouOsiraseiSksMockForHozen.SYORIPTN = null;
        WebServiceAccesslogOutputMockForHozen.caller = null;
        WebServiceAccesslogOutputMockForHozen.SYORIPTN = null;
        EditKykNaiyouOsiraseMockForHozen.caller = null;
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(1010)
    public void testExec_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbKykNaiyouOsiraseimpl.exec(pMap);

        WsHbKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean  =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(), WsHbKykNaiyouOsiraseOutOutputBean.class);
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分 ");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージＶ６０");

    }

    @Test
    @TestOrder(1020)
    public void testExec_A2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "A1807111118");
        pMap.add("operatorId", "010836208911234567890123456789");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbKykNaiyouOsiraseimpl.exec(pMap);

        WsHbKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbKykNaiyouOsiraseOutOutputBean.class);

        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分 ");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(),
            "誤った証券番号が入力されています。正しい証券番号を確認のうえ、再度照会ください。",
            "（ＩＷＳ）エラーメッセージＶ６０");

    }

    @Test
    @TestOrder(2010)
    @Transactional
    public void testExec_B1() throws Exception {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "99806015453");
        pMap.add("operatorId", "010836208911234567890123456789");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbKykNaiyouOsiraseimpl.exec(pMap);

        WsHbKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbKykNaiyouOsiraseOutOutputBean.class);

        exClassificationEquals((C_AccessLogSyubetuKbn)MockObjectManager.getArgument(
            WebServiceAccesslogOutputMockForHozen.class, "exec", 0, 0), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean)MockObjectManager.getArgument(
            WebServiceAccesslogOutputMockForHozen.class, "exec", 0, 1);
        exStringEquals(wsBzWebserviceReqParamBean.getOperatorId(), "010836208911234567890123456789", "（ＩＷＳ）オペレータＩＤ");
        exStringEquals(wsBzWebserviceReqParamBean.getGyoumuData(), "99806015453", "（ＩＷＳ）業務データ");
        WsHbKykNaiyouOsiraseOutInputBean kykNaiyouOsiraseOutInputBean =
            (WsHbKykNaiyouOsiraseOutInputBean)MockObjectManager.getArgument(WebServiceAccesslogOutputMockForHozen.class, "exec", 0, 2);
        exStringEquals(kykNaiyouOsiraseOutInputBean.getIwsSyono11keta(), "99806015453", "（ＩＷＳ）証券番号（１１桁）");

        exStringEquals((String)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForHozen.class, "editInfo", 0, 0), "99806015453", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForHozen.class, "editInfo", 0, 1), BizDate.valueOf(20191108), "処理年月日");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForHozen.class, "editInfo", 0, 2), BizDate.valueOf(20191108), "契約応当日");
        exStringEquals((String)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForHozen.class, "editInfo", 0, 3), "04", "商品判明区分");
        exStringEquals((String)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForHozen.class, "editInfo", 0, 4), "0", "キャンペーンフラグ");
        exNumericEquals((int)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForHozen.class, "editInfo", 0, 6), 2, "呼び出し元区分");

        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(), null, "（ＩＷＳ）エラーメッセージＶ６０");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsTanmatutyouhyoucd(), null, "（ＩＷＳ）端末帳票コード");
    }

    @Test
    @TestOrder(2010)
    @Transactional
    public void testExec_B2() throws Exception {

        MockObjectManager.initialize();
        KykNaiyouOsiraseiSksMockForHozen.SYORIPTN = KykNaiyouOsiraseiSksMockForHozen.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "11807111129");
        pMap.add("operatorId", "010836208911234567890123456789");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbKykNaiyouOsiraseimpl.exec(pMap);

        WsHbKykNaiyouOsiraseOutOutputBean kykNaiyouOsiraseOutOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbKykNaiyouOsiraseOutOutputBean.class);

        exStringEquals((String)MockObjectManager.getArgument(
            KykNaiyouOsiraseiSksMockForHozen.class, "exec", 0, 0), "11807111129", "証券番号");
        exNumericEquals((int)MockObjectManager.getArgument(
            KykNaiyouOsiraseiSksMockForHozen.class, "exec", 0, 1), 2, "呼び出し元区分");
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean =
            (KhAddKoumokuSetteiBean)MockObjectManager.getArgument(KykNaiyouOsiraseiSksMockForHozen.class, "exec", 0, 2);
        exStringEquals(khAddKoumokuSetteiBean.getSakuseisya(), null, "作成者所属");
        exStringEquals(khAddKoumokuSetteiBean.getSakuseiSyozoku(), null, "作成者");

        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(), "払込猶予期間外のため処理できません。", "（ＩＷＳ）エラーメッセージＶ６０");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsTanmatutyouhyoucd(), null, "（ＩＷＳ）端末帳票コード");
        exStringEquals(kykNaiyouOsiraseOutOutputBean.getIwsPdfdata(), null, "（ＩＷＳ）ＰＤＦデータ");

    }
}
