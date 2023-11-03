package yuyu.common.hozen.prereport;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.koutei.BzOutputProcessRecordMock;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateMock;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiMock;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全帳票作成前工程操作処理クラスのメソッド {@link HozenPreReportOperateProcess#operateProcess(TorikomiSyoruiBean,BM_TorikomiSyoruiHukaInfo,ReportServicesBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HozenPreReportOperateProcessTest_OperateProcess {

    private final static String fileName = "UT_SP_単体テスト仕様書_契約保全帳票作成前工程操作処理";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    public static void testInit() {
        BzProcessCreateMock.caller = HozenPreReportOperateProcessTest_OperateProcess.class;
        BzOutputProcessRecordMock.caller = HozenPreReportOperateProcessTest_OperateProcess.class;
        KhHituyousyoruiHanteiMock.caller = HozenPreReportOperateProcessTest_OperateProcess.class;
    }
    @AfterClass
    public static void testClear() {
        BzProcessCreateMock.caller = null;
        BzOutputProcessRecordMock.caller = null;
        KhHituyousyoruiHanteiMock.caller = null;

        BzProcessCreateMock.SYORIPTN = null;
        BzOutputProcessRecordMock.SYORIPTN = null;
        KhHituyousyoruiHanteiMock.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenPreReportOperateProcessTest_OperateProcess.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testOperateProcess_A1() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId(null);

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSyoNo("12806345672");

        hozenPreReportRenkeiBean.setSyoriComment("Comment");

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khjyuusyohenkou");

        torikomiSyoruiBean.setTorikomisyoruinm("住所変更");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        BzProcessCreateInBean bzProcessCreateInBean = (BzProcessCreateInBean) MockObjectManager.getArgument(
            BzProcessCreateMock.class, "exec", 0, 0);
        exStringEquals(bzProcessCreateInBean.getSyoNo(), "12806345672", "証券番号");
        exStringEquals(bzProcessCreateInBean.getJimuTetuzukiCd(), "khjyuusyohenkou", "事務手続コード");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiKanriId(), null, "親工程管理ID");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd(), "100", "親工程事務手続コード");

        khHituyousyoruiHanteiInBean = (KhHituyousyoruiHanteiInBean) MockObjectManager.getArgument(
            KhHituyousyoruiHanteiMock.class, "exec", 0, 0);
        exStringEquals(khHituyousyoruiHanteiInBean.getKouteikanriId(), "NenkinPreReport", "工程管理ID");
        exStringEquals(khHituyousyoruiHanteiInBean.getJimutetuzukiCd(), "khjyuusyohenkou", "事務手続コード");

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 0),
            "NenkinPreReport", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 1),
            "khjyuusyohenkou", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 2),
            "Comment", "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3), "住所変更作成",
            "タスク名");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");

        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
        exStringEquals(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "NenkinPreReport", "作成済工程管理ID");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testOperateProcess_A2() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khmeigihenkou");

        torikomiSyoruiBean.setTorikomisyoruinm("名義変更／契約者等生年月日訂正");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "名義変更／契約者等生年月日訂正作成", "タスク名");

        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void testOperateProcess_A3() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khkaiyaku");

        torikomiSyoruiBean.setTorikomisyoruinm("解約");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "解約作成", "タスク名");

        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testOperateProcess_A4() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khgengaku");

        torikomiSyoruiBean.setTorikomisyoruinm("減額");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "減額作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testOperateProcess_A5() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khseinegappiseits");

        torikomiSyoruiBean.setTorikomisyoruinm("被保険者生年月日・性訂正");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "被保険者生年月日・性訂正作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testOperateProcess_A6() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN2;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khsyoukensaihakkou");

        torikomiSyoruiBean.setTorikomisyoruinm("証券再発行");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "証券再発行作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(70)
    @Transactional
    public void testOperateProcess_A7() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khkeiyakutorikesi");

        torikomiSyoruiBean.setTorikomisyoruinm("契約取消");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "契約取消作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(80)
    @Transactional
    public void testOperateProcess_A8() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khcoolingoff");

        torikomiSyoruiBean.setTorikomisyoruinm("クーリングオフ");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "クーリングオフ作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(90)
    @Transactional
    public void testOperateProcess_A9() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khkaijyo");

        torikomiSyoruiBean.setTorikomisyoruinm("解除");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "解除作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(100)
    @Transactional
    public void testOperateProcess_A10() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khmukou");

        torikomiSyoruiBean.setTorikomisyoruinm("無効");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "無効作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(110)
    @Transactional
    public void testOperateProcess_A11() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khsiboukaijyo");

        torikomiSyoruiBean.setTorikomisyoruinm("死亡解除");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "死亡解除作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(120)
    @Transactional
    public void testOperateProcess_A12() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khmenseki");

        torikomiSyoruiBean.setTorikomisyoruinm("免責");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "免責作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(130)
    @Transactional
    public void testOperateProcess_A13() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khnenkinshrtkykhnk");

        torikomiSyoruiBean.setTorikomisyoruinm("年金支払特約変更");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "年金支払特約変更作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(140)
    @Transactional
    public void testOperateProcess_A14() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khstdrskytkyktythk");

        torikomiSyoruiBean.setTorikomisyoruinm("指定代理請求特約中途付加");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "指定代理請求特約中途付加作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(150)
    @Transactional
    public void testOperateProcess_A15() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khtargettkykhenkou");

        torikomiSyoruiBean.setTorikomisyoruinm("ターゲット特約変更");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "ターゲット特約変更作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(160)
    @Transactional
    public void testOperateProcess_A16() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("khshrkouzajyhhenkou");

        torikomiSyoruiBean.setTorikomisyoruinm("支払口座情報変更");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "支払口座情報変更作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }
    @Test
    @TestOrder(170)
    @Transactional
    public void testOperateProcess_A17() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN1;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN1;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("msmk");

        torikomiSyoruiBean.setTorikomisyoruinm("申出無効");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3),
            "申出無効作成", "タスク名");
        exStringEquals(kouteiKanriId, "NenkinPreReport", "工程管理ID");
    }


    @Test
    @TestOrder(180)
    @Transactional
    public void testOperateProcess_A18() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN2;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("1018");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "既に処理中の工程が存在する為、工程作成処理を中止しました。"
                + "（ 事務手続コード：1018, 工程管理ID：NenkinPreReport ）", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testOperateProcess_A19() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN3;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("1019");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testOperateProcess_A20() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN3;

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setOyaKouteiKanriId("100");

        bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        torikomiSyoruiBean.setFlowid("1020");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
        }
    }
    @Test
    @TestOrder(210)
    @Transactional
    public void testOperateProcess_A21() {

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("123");
        hozenPreReportRenkeiBean.setBzWorkflowInfo(bzWorkflowInfo);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);

        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals(kouteiKanriId, "123", "工程管理ID");

    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testOperateProcess_A22() {

        MockObjectManager.initialize();
        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN8;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN2;

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setSyoNo("11807111613");
        hozenPreReportRenkeiBean.setSyoriComment("Comment1");
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
        torikomiSyoruiBean.setFlowid("1234");
        torikomiSyoruiBean.setTorikomisyoruinm("住所変更");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");
        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean, torikomiSyoruiHukaInfo, reportServicesBean);

        exStringEquals(kouteiKanriId, "NenkinPreReport1", "工程管理ID");
        exStringEquals(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "NenkinPreReport1", "作成済工程管理ID");

        BzProcessCreateInBean bzProcessCreateInBean = (BzProcessCreateInBean) MockObjectManager.getArgument(
            BzProcessCreateMock.class, "exec", 0, 0);
        exStringEquals(bzProcessCreateInBean.getSyoNo(), "11807111613", "証券番号");
        exStringEquals(bzProcessCreateInBean.getJimuTetuzukiCd(), "1234", "事務手続コード");

        khHituyousyoruiHanteiInBean = (KhHituyousyoruiHanteiInBean) MockObjectManager.getArgument(
            KhHituyousyoruiHanteiMock.class, "exec", 0, 0);
        exStringEquals(khHituyousyoruiHanteiInBean.getKouteikanriId(), "NenkinPreReport1", "工程管理ID");
        exStringEquals(khHituyousyoruiHanteiInBean.getJimutetuzukiCd(), "1234", "事務手続コード");

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 0),
            "NenkinPreReport1", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 1),
            "1234", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 2),
            "Comment1", "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 3), "住所変更作成",
            "住所変更作成");
        exClassificationEquals(
            (C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMock.class, "exec", 0, 4),
            C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testOperateProcess_A23() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN9;

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setSyoNo("11807111624");

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
        torikomiSyoruiBean.setFlowid("1111");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");

        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "既に処理中の工程が存在する為、工程作成処理を中止しました。"
                + "（ 事務手続コード：1111, 工程管理ID：NenkinPreReport2 ）", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testOperateProcess_A24() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN10;

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
        hozenPreReportRenkeiBean.setSyoNo("11807111635");

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
        torikomiSyoruiBean.setFlowid("2222");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");
        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testOperateProcess_A25() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN11;
        KhHituyousyoruiHanteiMock.SYORIPTN = KhHituyousyoruiHanteiMock.TESTPATTERN2;

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setSyoNo("11807111646");
        hozenPreReportRenkeiBean.setSyoriComment("Comment2");
        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
        torikomiSyoruiBean.setFlowid("3333");
        torikomiSyoruiBean.setTorikomisyoruinm("住所変更2");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");
        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);
        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals(kouteiKanriId, "NenkinPreReport4", "工程管理ID");
        exStringEquals(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "NenkinPreReport4", "作成済工程管理ID");

    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testOperateProcess_A26() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN12;

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setSyoNo("11807111657");

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
        torikomiSyoruiBean.setFlowid("4444");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");
        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "既に処理中の工程が存在する為、工程作成処理を中止しました。"
                + "（ 事務手続コード：4444, 工程管理ID：NenkinPreReport5 ）", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testOperateProcess_A27() {

        BzProcessCreateMock.SYORIPTN = BzProcessCreateMock.TESTPATTERN13;

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
        hozenPreReportRenkeiBean.setSyoNo("11807111668");

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
        torikomiSyoruiBean.setFlowid("5555");

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");
        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        try {
            hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testOperateProcess_A28() {

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId("123");

        TorikomiSyoruiBean torikomiSyoruiBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
        torikomiSyoruiHukaInfo.setHozonKikan(1);

        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "", "");
        reportServicesBean.setKensakuKeys("tesuto");

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        HozenPreReportOperateProcess hozenPreReportOperateProcess = SWAKInjector.getInstance(HozenPreReportOperateProcess.class);

        String kouteiKanriId = hozenPreReportOperateProcess.operateProcess(torikomiSyoruiBean,torikomiSyoruiHukaInfo,reportServicesBean);

        exStringEquals(kouteiKanriId, "123", "工程管理ID");
    }
}
