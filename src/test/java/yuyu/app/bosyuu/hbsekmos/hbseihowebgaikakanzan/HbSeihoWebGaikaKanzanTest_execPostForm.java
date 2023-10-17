package yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebGaikaKanzanOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ外貨換算のメイン処理{@link HbSeihoWebGaikaKanzanImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebGaikaKanzanTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebGaikaKanzanImpl hbSeihoWebGaikaKanzanImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ外貨換算";

    private final static String sheetName = "INデータ";

    private final static String requestSheetName = "業務データ";

    private static Map<String, String> gyoumuInfoMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebGaikaKanzanTest_execPostForm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebGaikaKanzanTest_execPostForm.class, fileName, requestSheetName);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A1"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("20191108"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(7340), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.valueOf(1681972602317L), "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.ZERO, "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("20191108"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(9110), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.valueOf(1355178804L), "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.ZERO, "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("00000000"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(0), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.ZERO, "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.ZERO, "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf(00000000), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(0), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.valueOf(0), "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.valueOf(0), "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A5"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf(00000000), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(0), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.valueOf(0), "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.valueOf(0), "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A6"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("00000000"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(0), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.ZERO, "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.ZERO, "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A7"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("20191108"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(40), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.valueOf(493827156L), "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.ZERO, "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A8"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("20191108"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(9110), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.ZERO, "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.valueOf(11044L), "（ＩＷＳ）換算後円貨保険料");
    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A9"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebgaikakanzan.HbSeihoWebGaikaKanzan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebGaikaKanzanImpl.execPostForm(pMap);

        WsHbSeihoWebGaikaKanzanOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebGaikaKanzanOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkwsratetekiymd(), BizDate.valueOf("20191108"), "（ＩＷＳ）換算用為替レート適用日");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsnkawaserate(), BizNumber.valueOf(40), "（ＩＷＳ）換算用為替レート");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngogkp(), BizNumber.ZERO, "（ＩＷＳ）換算後外貨保険料");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKnsngoyenp(), BizNumber.valueOf(11064210L), "（ＩＷＳ）換算後円貨保険料");
    }
}
