package yuyu.app.dsweb.dwhozeninfo.dwkyknaiyouosirase;

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
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsiraseMockForDirect;
import yuyu.common.hozen.khcommon.KhAddKoumokuSetteiBean;
import yuyu.common.hozen.khcommon.KykNaiyouOsiraseiSks;
import yuyu.common.hozen.khcommon.KykNaiyouOsiraseiSksMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwKykNaiyouOsiraseOutOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳご契約内容のお知らせ {@link DwKykNaiyouOsirase#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwKykNaiyouOsiraseTest_exec extends AbstractTest {

    @Inject
    private DwKykNaiyouOsiraseImpl dwKykNaiyouOsiraseImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳご契約内容のお知らせ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DwKykNaiyouOsiraseTest_exec.class, fileName, sheetName);

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

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(KykNaiyouOsiraseiSks.class).to(KykNaiyouOsiraseiSksMockForDirect.class);
                bind(EditKykNaiyouOsirase.class).to(EditKykNaiyouOsiraseMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KykNaiyouOsiraseiSksMockForDirect.caller = DwKykNaiyouOsiraseTest_exec.class;
        EditKykNaiyouOsiraseMockForDirect.caller = DwKykNaiyouOsiraseTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        KykNaiyouOsiraseiSksMockForDirect.caller = null;
        KykNaiyouOsiraseiSksMockForDirect.SYORIPTN = null;
        EditKykNaiyouOsiraseMockForDirect.caller = null;
        EditKykNaiyouOsiraseMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        StringBuffer gyoumuData = new StringBuffer();
        gyoumuData.append("1234567890A");
        pMap.add("gyoumuData", gyoumuData.toString());
        pMap.add("methodName", "/yuyu.app.dsweb.dwhozeninfo.dwkyknaiyouosirase.DwKykNaiyouOsirase");
        pMap.add("coopClass", "2");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKykNaiyouOsiraseImpl.execPostForm(pMap);

        WsDwKykNaiyouOsiraseOutOutputBean wsDwKykNaiyouOsiraseOutOutputBean  =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(), WsDwKykNaiyouOsiraseOutOutputBean.class);

        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）エラーメッセージＶ６０");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsTanmatutyouhyoucd(), null, "（ＩＷＳ）端末帳票コード");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsPdfdata(), null, "（ＩＷＳ）ＰＤＦデータ");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        KykNaiyouOsiraseiSksMockForDirect.SYORIPTN = KykNaiyouOsiraseiSksMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        StringBuffer gyoumuData = new StringBuffer();
        gyoumuData.append("11807111369");
        pMap.add("gyoumuData", gyoumuData.toString());
        pMap.add("methodName", "/yuyu.app.dsweb.dwhozeninfo.dwkyknaiyouosirase.DwKykNaiyouOsirase");
        pMap.add("coopClass", "2");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKykNaiyouOsiraseImpl.execPostForm(pMap);

        WsDwKykNaiyouOsiraseOutOutputBean wsDwKykNaiyouOsiraseOutOutputBean  =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(), WsDwKykNaiyouOsiraseOutOutputBean.class);

        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(), "払込猶予期間外のため処理できません。", "（ＩＷＳ）エラーメッセージＶ６０");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsTanmatutyouhyoucd(), null, "（ＩＷＳ）端末帳票コード");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsPdfdata(), null, "（ＩＷＳ）ＰＤＦデータ");

        exStringEquals((String)MockObjectManager.getArgument(
            KykNaiyouOsiraseiSksMockForDirect.class, "exec", 0, 0), "11807111369", "証券番号");
        exNumericEquals((int)MockObjectManager.getArgument(
            KykNaiyouOsiraseiSksMockForDirect.class, "exec", 0, 1), 2, "呼び出し元区分");
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean =
            (KhAddKoumokuSetteiBean)MockObjectManager.getArgument(KykNaiyouOsiraseiSksMockForDirect.class, "exec", 0, 2);
        exStringEquals(khAddKoumokuSetteiBean.getSakuseisya(), null, "作成者所属");
        exStringEquals(khAddKoumokuSetteiBean.getSakuseiSyozoku(), null, "作成者");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        KykNaiyouOsiraseiSksMockForDirect.SYORIPTN = KykNaiyouOsiraseiSksMockForDirect.TESTPATTERN2;
        EditKykNaiyouOsiraseMockForDirect.SYORIPTN = EditKykNaiyouOsiraseMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190618"));

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        StringBuffer gyoumuData = new StringBuffer();
        gyoumuData.append("11807111646");
        pMap.add("gyoumuData", gyoumuData.toString());
        pMap.add("methodName", "/yuyu.app.dsweb.dwhozeninfo.dwkyknaiyouosirase.DwKykNaiyouOsirase");
        pMap.add("coopClass", "2");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwKykNaiyouOsiraseImpl.execPostForm(pMap);

        WsDwKykNaiyouOsiraseOutOutputBean wsDwKykNaiyouOsiraseOutOutputBean  =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(), WsDwKykNaiyouOsiraseOutOutputBean.class);

        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsErrormsgv60(), null, "（ＩＷＳ）エラーメッセージＶ６０");
        exStringEquals(wsDwKykNaiyouOsiraseOutOutputBean.getIwsTanmatutyouhyoucd(), null, "（ＩＷＳ）端末帳票コード");

        exStringEquals((String)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForDirect.class, "editInfo", 0, 0), "11807111646", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForDirect.class, "editInfo", 0, 1), BizDate.valueOf(20190618), "処理年月日");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForDirect.class, "editInfo", 0, 2), BizDate.valueOf(20190618), "契約応当日");
        exStringEquals((String)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForDirect.class, "editInfo", 0, 3), "04", "商品判明区分");
        exStringEquals((String)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForDirect.class, "editInfo", 0, 4), "0", "キャンペーンフラグ");
        exNumericEquals((int)MockObjectManager.getArgument(
            EditKykNaiyouOsiraseMockForDirect.class, "editInfo", 0, 6), 2, "呼び出し元区分");

    }

}
