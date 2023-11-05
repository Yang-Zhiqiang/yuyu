package yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos;

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
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutoku;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuMockForSinkeiyaku;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.CheckSP;
import yuyu.common.sinkeiyaku.moschk.CheckSPMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.CheckSkTuusan;
import yuyu.common.sinkeiyaku.moschk.CheckSkTuusanMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhin;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.SeihowebMosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.SeihowebMosnaiCheckMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.SetSP;
import yuyu.common.sinkeiyaku.moschk.SetSPMockForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosOutputBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ設計書申込書作成のメイン処理{@link HbSeihoWebSekMosImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings("unchecked")
public class HbSeihoWebSekMosTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebSekMosImpl hbSeihoWebSekMosImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ設計書申込書作成";

    private final static String sheetName = "INデータ_網羅テスト";

    private final static String requestSheetName = "業務データ_網羅テスト";

    private static Map<String, String> gyoumuInfoMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebSekMosTest_execPostForm2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(SeihowebMosnaiCheck.class).to(SeihowebMosnaiCheckMockForSinkeiyaku.class);
                bind(DairitenTesuuryouInfoSyutoku.class).to(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class);
                bind(CheckTblMosSyouhin.class).to(CheckTblMosSyouhinMockForSinkeiyaku.class);
                bind(CheckSP.class).to(CheckSPMockForSinkeiyaku.class);
                bind(CheckSkTuusan.class).to(CheckSkTuusanMockForSinkeiyaku.class);

                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
                bind(SetSP.class).to(SetSPMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SeihowebMosnaiCheckMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm.class;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm.class;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm.class;
        CheckSPMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm.class;
        CheckSkTuusanMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm.class;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        SeihowebMosnaiCheckMockForSinkeiyaku.caller = null;
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = null;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = null;
        CheckSPMockForSinkeiyaku.caller = null;
        CheckSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSkTuusanMockForSinkeiyaku.caller = null;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = null;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = null;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebSekMosTest_execPostForm.class, fileName, requestSheetName);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", " ");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ａ扱者個人コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ｂ扱者個人コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    //    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(50)
    //    public void testExecPostForm_A5() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", getRequestInfo(11).get(0));
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A6"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A7"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字契約者名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A8"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A9"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "通信先電話番号エラー　市外局番も含めてＸＸ－ＸＸＸ－ＸＸＸＸの形式にしてください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A10"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A11"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "通信先郵便番号エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A12"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    //    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(130)
    //    public void testExecPostForm_A13() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", getRequestInfo(19).get(0));
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_A14() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A14"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }



    //    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(150)
    //    public void testExecPostForm_A15() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", getRequestInfo(21).get(0));
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    /**
     * 検証ポイント１　：単項目チェックの網羅テスト<br />
     * ケース１６　　　：パターン(16)<br />
     * 期待結果　　　　：（共通）WebサービスレスポンスパラメータBeanの確認<br />
     * @since 2016/07/28
     */
    @Test
    @TestOrder(160)
    public void testExecPostForm_A16() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A16"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    //    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(170)
    //    public void testExecPostForm_A17() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", getRequestInfo(23).get(0));
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A18"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被保険者生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_A19() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A19"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(200)
    //    public void testExecPostForm_A20() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(210)
    public void testExecPostForm_A21() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A21"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(220)
    //    public void testExecPostForm_A22() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1㍻㌍㍻㌍㍻㌍㍻㌍㍻漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(230)
    public void testExecPostForm_A23() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A23"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(240)
    //    public void testExecPostForm_A24() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031㍻㌍㍻㌍㍻㌍㍻㌍㍻漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(250)
    public void testExecPostForm_A25() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A25"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(260)
    //    public void testExecPostForm_A26() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041㍻㌍㍻㌍㍻㌍㍻㌍㍻漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(270)
    public void testExecPostForm_A27() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A27"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(280)
    //    public void testExecPostForm_A28() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051㍻㌍㍻㌍㍻㌍㍻㌍㍻漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(290)
    public void testExecPostForm_A29() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A29"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(300)
    public void testExecPostForm_A30() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A30"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(310)
    public void testExecPostForm_A31() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A31"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(320)
    public void testExecPostForm_A32() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A32"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(330)
    public void testExecPostForm_A33() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A33"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(340)
    //    public void testExecPostForm_A34() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(350)
    public void testExecPostForm_A35() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A35"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(360)
    //    public void testExecPostForm_A36() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(370)
    public void testExecPostForm_A37() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A37"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(380)
    //    public void testExecPostForm_A38() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(390)
    public void testExecPostForm_A39() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A39"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // QA1837-001について、現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(400)
    //    public void testExecPostForm_A40() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(410)
    public void testExecPostForm_A41() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A41"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人続柄区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(420)
    public void testExecPostForm_A42() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A42"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人続柄区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(430)
    public void testExecPostForm_A43() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A43"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人続柄区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(440)
    public void testExecPostForm_A44() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A44"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人続柄区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(450)
    public void testExecPostForm_A45() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A45"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(460)
    public void testExecPostForm_A46() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A46"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "入金用為替レート円エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(470)
    public void testExecPostForm_A47() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A47"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(480)
    public void testExecPostForm_A48() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A48"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "入金用為替レート外貨エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(490)
    public void testExecPostForm_A49() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A49"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(500)
    public void testExecPostForm_A50() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A50"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "基本Ｓエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(510)
    public void testExecPostForm_A51() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A51"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(520)
    public void testExecPostForm_A52() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A52"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "申込主契約Ｐエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(530)
    public void testExecPostForm_A53() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData",  gyoumuInfoMap.get("testExecPostForm_A53"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(540)
    public void testExecPostForm_A54() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A54"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "外貨基本Ｓエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(550)
    public void testExecPostForm_A55() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A55"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(560)
    public void testExecPostForm_A56() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A56"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "外貨申込主契約Ｐエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(570)
    public void testExecPostForm_A57() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A57"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(580)
    //    public void testExecPostForm_A58() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3㍻㌍㍻㌍㍻㌍㍻㌍㍻漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(590)
    public void testExecPostForm_A59() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A59"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(600)
    public void testExecPostForm_A60() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A60"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(610)
    //    public void testExecPostForm_A61() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名名名名漢1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(620)
    public void testExecPostForm_A62() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A62"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "受取人続柄区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(630)
    public void testExecPostForm_A63() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A63"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(640)
    //    public void testExecPostForm_A64() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521㍻㌍㍻㌍㍻㌍㍻㌍㍻家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(650)
    public void testExecPostForm_A65() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A65"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(660)
    //    public void testExecPostForm_A66() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名名名名漢1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(670)
    public void testExecPostForm_A67() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A67"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(680)
    public void testExecPostForm_A68() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A68"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(690)
    //    public void testExecPostForm_A69() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㍻"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㍻"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(700)
    public void testExecPostForm_A70() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A70"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(710)
    //    public void testExecPostForm_A71() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2㍻㌍㍻㌍㍻㌍㍻㌍㍻家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(720)
    public void testExecPostForm_A72() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A72"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(730)
    //    public void testExecPostForm_A73() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名名名名漢1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(740)
    public void testExecPostForm_A74() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A74"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(750)
    public void testExecPostForm_A75() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A75"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(760)
    //    public void testExecPostForm_A76() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㍻"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㌍㍻㍻㌍㍻㌍㍻㌍㍻㍻"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(770)
    public void testExecPostForm_A77() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A77"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理続柄区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(780)
    public void testExecPostForm_A78() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A78"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(790)
    //    public void testExecPostForm_A79() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名漢字受取1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ家族漢字氏名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005㍻㌍㍻㌍㍻㌍㍻㌍㍻被代理漢字氏名名名名漢2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(800)
    public void testExecPostForm_A80() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A80"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    // 現在不具合対応中ですので、入力不可文字チェックのテストはテス対象外
    //    @Test
    //    @TestOrder(810)
    //    public void testExecPostForm_A81() throws Exception {
    //        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
    //            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
    //
    //        pMap.add("gyoumuData", "10100100001100002ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅ漢字契約者名漢字契約者201601011110ﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝﾎｳｼﾞﾝ"
    //            + "漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名漢字法人名20ﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳﾀﾞｲﾋｮｳ"
    //            + "法人代表者法人代表者法人代表者法人代表者法人代表者法人代表者0120-127-023  11234567"
    //            + "漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住所漢字通信先下位住"
    //            + "ﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝﾎｹﾝ漢字被保険者名漢字被保2016020211234567"
    //            + "被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位住所被保険者下位"
    //            + "1ｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅｶﾅﾅ漢字受取人名名名名名漢1201603031ｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅﾅﾅｶﾅ漢字受取人名名名漢字受1201604041ｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅﾅﾅｶﾅﾅ漢字受取人名名名名漢字"
    //            + "1201605051ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢120160606"
    //            + "3ｶｶﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅ漢字受取人名名名名名漢2000000001012016070711111150001500029876543217894561230110111112111021110102030405"
    //            + "20160202111AAbb15001099912234000000000521ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅｶ漢字受取人名名名名名漢1000000001001000家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３住住"
    //            + "2ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅﾅｶｶ家族漢字氏名名名名漢漢2000000002002000家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４所所"
    //            + "110005ｶﾅﾅﾅﾅﾅｶﾅﾅﾅﾅﾅｶﾅﾅｶｶｶ㍻㌍㍻㌍㍻㌍㍻㌍㍻㌍㍻2016101011"
    //            );
    //
    //        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);
    //
    //        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
    //            WsHbSeihoWebSekMosOutputBean.class);
    //
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
    //        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    //
    //    }

    @Test
    @TestOrder(811)
    public void testExecPostForm_A82() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A82"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(812)
    public void testExecPostForm_A83() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A83"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "申込主契約Ｐエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }


    @Test
    @TestOrder(813)
    public void testExecPostForm_A84() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A84"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(814)
    public void testExecPostForm_A85() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A85"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "外貨申込主契約Ｐエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(840)
    public void testExecPostForm_B1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B1"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "契約者カナ氏名を正しく入力してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("00000000"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("00000000"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.ZERO, "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.ZERO, "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.ZERO, "（ＩＷＳ）変動金利積立利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), null, "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(850)
    public void testExecPostForm_B2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B2"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "契約者カナ氏名を正しく入力してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(860)
    public void testExecPostForm_B4() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B4"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被保険者カナ氏名を正しく入力してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(870)
    public void testExecPostForm_B5() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B5"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "契約者生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(880)
    public void testExecPostForm_B9() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B9"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(890)
    public void testExecPostForm_B11() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B11"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(900)
    public void testExecPostForm_B13() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B13"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(910)
    public void testExecPostForm_B15() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B15"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(920)
    public void testExecPostForm_B17() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B17"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(930)
    public void testExecPostForm_B19() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B19"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(940)
    public void testExecPostForm_B21() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B21"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(950)
    public void testExecPostForm_B23() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B23"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(960)
    public void testExecPostForm_B24() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B24"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(970)
    public void testExecPostForm_B25() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B25"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(980)
    public void testExecPostForm_B26() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B26"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(990)
    public void testExecPostForm_B27() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B27"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1000)
    public void testExecPostForm_B28() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B28"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_B29() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B29"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1020)
    public void testExecPostForm_B30() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B30"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1030)
    public void testExecPostForm_B31() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B31"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1040)
    public void testExecPostForm_B32() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B32"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "入力計算基準年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1050)
    public void testExecPostForm_B33() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B33"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ｓ建Ｐ建区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1060)
    public void testExecPostForm_B34() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B34"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "配当支払区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1070)
    public void testExecPostForm_B35() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B35"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "才満期表示エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1080)
    public void testExecPostForm_B36() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B36"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1090)
    public void testExecPostForm_B38() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B38"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1100)
    public void testExecPostForm_B39() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B39"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1110)
    public void testExecPostForm_B40() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B40"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1120)
    public void testExecPostForm_B41() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B41"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1130)
    public void testExecPostForm_B42() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B42"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族漢字氏名（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1140)
    public void testExecPostForm_B43() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B43"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族生年月日（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1150)
    public void testExecPostForm_B44() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B44"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族漢字氏名（２人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1160)
    public void testExecPostForm_B45() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B45"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族生年月日（２人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1170)
    public void testExecPostForm_B46() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B46"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族カナ氏名（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1180)
    public void testExecPostForm_B47() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B47"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族カナ氏名（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1190)
    public void testExecPostForm_B48() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B48"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族カナ氏名（２人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1200)
    public void testExecPostForm_B49() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B49"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族カナ氏名（２人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1210)
    public void testExecPostForm_B50() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B50"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理漢字氏名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1220)
    public void testExecPostForm_B51() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B51"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1230)
    public void testExecPostForm_B52() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B52"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理カナ氏名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1240)
    public void testExecPostForm_B53() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B53"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理カナ氏名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1260)
    public void testExecPostForm_C1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C1"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1270)
    public void testExecPostForm_C2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C2"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "2", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ａ担当者コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1280)
    public void testExecPostForm_C3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C3"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ａ担当者組織コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1290)
    public void testExecPostForm_C4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C4"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "2", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ｂ担当者コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1300)
    public void testExecPostForm_C5() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C5"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "Ｂ担当者組織コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1310)
    public void testExecPostForm_C6() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C6"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1320)
    public void testExecPostForm_C7() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C7"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "2000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), "2045", "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), "3020", "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), "3030", "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), "5000", "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), "6000", "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1330)
    public void testExecPostForm_C8() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN3;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C8"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("00000000"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.valueOf(12), "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.valueOf(12), "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.valueOf(13), "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(13), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(13), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(0), "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(0), "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(0), "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(0), "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(0), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "2000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), "2045", "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), "3020", "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), "3030", "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), "5000", "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), "6000", "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1340)
    public void testExecPostForm_C9() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN4;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C9"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20170201"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(),BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1350)
    public void testExecPostForm_C10() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN5;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C10"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20170131"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "T001", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(200), "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000), "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100), "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(10000), "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100), "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(20000), "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100), "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(30000), "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(40000), "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1360)
    public void testExecPostForm_C11() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN6;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C11"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20170216"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1370)
    public void testExecPostForm_C12() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN9;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C12"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20170201"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170209"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.ZERO, "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.ZERO, "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1380)
    public void testExecPostForm_C13() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN6;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C13"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20170201"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270217"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1390)
    public void testExecPostForm_C14() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN7;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C14"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(1400)
    public void testExecPostForm_C15() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN8;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "053456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C15"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20170201"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.valueOf(12), "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.valueOf(12), "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.valueOf(13), "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(13), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), "漢字募集人名", "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "大手庁代理店", "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1410)
    public void testExecPostForm_C16() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "738000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C16"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "端末権限エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(1420)
    public void testExecPostForm_C17() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "123456789032");
        pMap.add("orgCode", "5439000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C17"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "使用者権限エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(1430)
    public void testExecPostForm_C18() throws Exception {
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "7448000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C18"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "2000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), "2045", "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), "3020", "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), "3030", "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), "5000", "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), "6000", "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");

    }

    @Test
    @TestOrder(1440)
    public void testExecPostForm_C19() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C19"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.valueOf(12), "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.valueOf(12), "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.valueOf(13), "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(13), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("13")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), "00DRHJA000024", "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");
    }

    @Test
    @TestOrder(1450)
    public void testExecPostForm_C20() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C20"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.valueOf(12), "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.valueOf(12), "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.valueOf(13), "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(13), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(13), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");
    }

    @Test
    @TestOrder(1460)
    public void testExecPostForm_C21() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C21"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.valueOf(12), "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.valueOf(12), "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.valueOf(13), "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(13), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("13")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");
    }

    @Test
    @TestOrder(1470)
    public void testExecPostForm_C22() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C22"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.valueOf(12), "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.ZERO, "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.valueOf(12), "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.ZERO, "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.valueOf(13), "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.ZERO, "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(13), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("13")), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");
    }

    @Test
    @TestOrder(1480)
    public void testExecPostForm_C23() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C23"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteikykymd(), BizDate.valueOf("20160707"), "（ＩＷＳ）予定契約年月日");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20270201"), "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHhknnen(), BizNumber.valueOf(10), "（ＩＷＳ）被保険者年令");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSbs(), BizNumber.ZERO, "（ＩＷＳ）死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasbs(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨死亡Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsKihons(), BizNumber.ZERO, "（ＩＷＳ）基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikakihons(), BizNumber.valueOf(1200), "（ＩＷＳ）外貨基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyupn(), BizNumber.ZERO, "（ＩＷＳ）主契約Ｐ（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyup(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyokaiharaikomip(), BizNumber.valueOf(1300), "（ＩＷＳ）外貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanextharaikomip(), BizNumber.ZERO, "（ＩＷＳ）外貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(0), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.valueOf(new BigDecimal("1300")), "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukanexthrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨次回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargetyenknsnp(), BizNumber.valueOf(13), "（ＩＷＳ）ターゲット円換算保険料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTargettokuyakumkhgk(), BizNumber.ZERO, "（ＩＷＳ）ターゲット特約目標額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHendouknrtumitateriritu(), BizNumber.valueOf(50), "（ＩＷＳ）変動金利積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.ZERO, "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0), "（ＩＷＳ）市場価格調整用利率");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBsyutrkno(), null, "（ＩＷＳ）募集人登録番号");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsDirtnbosyuuninkanji(), null, "（ＩＷＳ）代理店募集人漢字氏名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsTsrycd(), "9999999", "（ＩＷＳ）手数料コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtentsryshrkaisuu(), BizNumber.ZERO, "（ＩＷＳ）代理店手数料支払回数");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.ZERO, "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.ZERO, "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.ZERO, "（ＩＷＳ）外貨初年度手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.ZERO, "（ＩＷＳ）外貨２年目以降手数料累計額");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.ZERO, "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.ZERO, "（ＩＷＳ）外貨総額手数料");

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), null, "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), null, "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), null, "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");

        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.ZERO, "（ＩＷＳ）外貨試算基本Ｓ");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnkanouhyj(), "0", "（ＩＷＳ）健診書可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNngndkkkanouhyj(), "0", "（ＩＷＳ）人間ドック可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsMnstskanouhyj(), "0", "（ＩＷＳ）面接士可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyktkikanouhyj(), "0", "（ＩＷＳ）嘱託医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyaikanouhyj(), "0", "（ＩＷＳ）社医可能表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSndnzknsyouhyj(), "0", "（ＩＷＳ）心電図検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKtekknsyouhyj(), "0", "（ＩＷＳ）血液検査要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnsysndnzyou(), "0", "（ＩＷＳ）健診書用心電図要表示");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKnsnketuekikensayouhyj(), "0", "（ＩＷＳ）健診書用血液検査項目要表示");
    }

    @Test
    @TestOrder(1490)
    public void testExecPostForm_C24() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN13;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C24"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(1500)
    public void testExecPostForm_C25() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN12;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C25"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }


    @Test
    @TestOrder(1510)
    public void testExecPostForm_C26() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C26"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }


    @Test
    @TestOrder(1520)
    public void testExecPostForm_C27() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN11;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C27"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }


    @Test
    @TestOrder(1530)
    public void testExecPostForm_C28() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN4;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C28"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd01(), "1000", "（ＩＷＳ）必要書類等ＭＳＧコード１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd02(), "2000", "（ＩＷＳ）必要書類等ＭＳＧコード２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd03(), "2045", "（ＩＷＳ）必要書類等ＭＳＧコード３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd04(), "2710", "（ＩＷＳ）必要書類等ＭＳＧコード４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd05(), "3000", "（ＩＷＳ）必要書類等ＭＳＧコード５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd06(), "3010", "（ＩＷＳ）必要書類等ＭＳＧコード６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd07(), "3020", "（ＩＷＳ）必要書類等ＭＳＧコード７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd08(), "3030", "（ＩＷＳ）必要書類等ＭＳＧコード８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd09(), "5000", "（ＩＷＳ）必要書類等ＭＳＧコード９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd10(), "6000", "（ＩＷＳ）必要書類等ＭＳＧコード１０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd11(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd12(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd13(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd14(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd15(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd16(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd17(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd18(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd19(), null, "（ＩＷＳ）必要書類等ＭＳＧコード１９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd20(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd21(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd22(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd23(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd24(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd25(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd26(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd27(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd28(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd29(), null, "（ＩＷＳ）必要書類等ＭＳＧコード２９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd30(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd31(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd32(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd33(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd34(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd35(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd36(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd37(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd38(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd39(), null, "（ＩＷＳ）必要書類等ＭＳＧコード３９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd40(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd41(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd42(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd43(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd44(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd45(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd46(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd47(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd48(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd49(), null, "（ＩＷＳ）必要書類等ＭＳＧコード４９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd50(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５０");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd51(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd52(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd53(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５３");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd54(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５４");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd55(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd56(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５６");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd57(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５７");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd58(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５８");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd59(), null, "（ＩＷＳ）必要書類等ＭＳＧコード５９");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsHtysyoruicd60(), null, "（ＩＷＳ）必要書類等ＭＳＧコード６０");
    }

    @Test
    @TestOrder(1540)
    public void testExecPostForm_C29() throws Exception {
        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN10;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN8;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = null;
        CheckSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = null;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_C29"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }
}
