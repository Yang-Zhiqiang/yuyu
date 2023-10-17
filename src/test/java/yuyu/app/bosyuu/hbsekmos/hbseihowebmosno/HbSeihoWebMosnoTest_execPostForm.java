package yuyu.app.bosyuu.hbsekmos.hbseihowebmosno;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtil;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtilMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomi;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomiMockForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebMosNoOutputBean;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ申込番号取得のメイン処理{@link HbSeihoWebMosnoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebMosnoTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebMosnoImpl hbSeihoWebMosnoImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ申込番号取得";

    private final static String requestSheetName = "業務データ";

    private static Map<String, String> gyoumuInfoMap;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SkPreSyoruiTorikomi.class).to(SkPreSyoruiTorikomiMockForSinkeiyaku.class);
                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
                bind(MousikomiNoUtil.class).to(MousikomiNoUtilMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SkPreSyoruiTorikomiMockForSinkeiyaku.caller = HbSeihoWebMosnoTest_execPostForm.class;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebMosnoTest_execPostForm.class;
        MousikomiNoUtilMockForSinkeiyaku.caller = HbSeihoWebMosnoTest_execPostForm.class;
        IwfKouteiClientMock.caller = "Test";
        IwfKouteiClientMock.mode = "01-05";
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebMosnoTest_execPostForm.class, fileName, requestSheetName);
    }


    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A1"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);
        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN5;

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A5"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_B1() throws Exception {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B1"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_B2() throws Exception {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B2"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        String gyoumuData = wsBzWebserviceResParamBean.getGyoumuData();
        String errCode = gyoumuData.substring(0, 1);
        String mosno = gyoumuData.substring(1, 10);
        String documentId1 = gyoumuData.substring(10, 31);
        String documentId2 = gyoumuData.substring(31, 52);
        String documentId3 = gyoumuData.substring(52, 73);
        String documentId4 = gyoumuData.substring(73);

        exStringEquals(errCode, "1", "（ＩＷＳ）エラー区分");
        exStringEquals(mosno, "000000000", "（ＩＷＳ）申込番号");
        exStringEquals(documentId1, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(documentId2, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(documentId3, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(documentId4, "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_B3() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN1;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B3"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "mos0032e5vc0hcg3fvchs", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.SMBC, "新契約事務区分");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_B4() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B4"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "mos0042e5vehw8yryhwcg", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");

    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_B5() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN3;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B5"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "mos0042e5vehw8yryhwch", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");

    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_B6() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN4;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B6"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "mos0042e5vehw8yryhwci", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_B7() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN6;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B7"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "mos0032e5vc0hcg3fvchs", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "mos0042e5vehw8yryhwcg", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "mos0042e5vehw8yryhwch", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "mos0042e5vehw8yryhwci", "（ＩＷＳ）ドキュメントＩＤ４");
        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_B8() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B8"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.SMTB, "新契約事務区分");

    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_B9() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B9"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");

    }

    @Test
    @TestOrder(150)
    public void testExecPostForm_B10() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B10"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");

    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_B11() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B11"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");
        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

    }

    @Test
    @TestOrder(170)
    public void testExecPostForm_B12() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B12"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");
        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_B13() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B13"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");
        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_B14() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B14"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");
        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.BLNK, "新契約事務区分");

    }

    @Test
    @TestOrder(200)
    public void testExecPostForm_B15() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B15"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.SHOP, "新契約事務区分");

    }

    @Test
    @TestOrder(210)
    public void testExecPostForm_B16() throws Exception {
        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        SkPreSyoruiTorikomiMockForSinkeiyaku.SYORIPTN = SkPreSyoruiTorikomiMockForSinkeiyaku.TESTPATTERN2;

        MousikomiNoUtilMockForSinkeiyaku.SYORIPTN = MousikomiNoUtilMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B16"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebmosno.HbSeihoWebMosno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosnoImpl.execPostForm(pMap);

        WsHbSeihoWebMosNoOutputBean wsHbSeihoWebMosNoOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosNoOutputBean.class);

        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsMosno(), "970001111", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid1(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ１");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid2(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ２");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid3(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ３");
        exStringEquals(wsHbSeihoWebMosNoOutputBean.getIwsDocumentid4(), "000000000000000000000", "（ＩＷＳ）ドキュメントＩＤ４");

        C_SkeijimuKbn skeiJimuKbn = (C_SkeijimuKbn) MockObjectManager.getArgument(MousikomiNoUtilMockForSinkeiyaku.class, "getMosNo", 0, 0);
        exClassificationEquals(skeiJimuKbn, C_SkeijimuKbn.MIZUHO, "新契約事務区分");

    }
}
