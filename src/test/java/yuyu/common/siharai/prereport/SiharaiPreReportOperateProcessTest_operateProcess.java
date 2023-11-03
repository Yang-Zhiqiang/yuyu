package yuyu.common.siharai.prereport;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForSiharai;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateMockForSiharai;
import yuyu.common.siharai.koutei.SiHituyousyoruiHantei;
import yuyu.common.siharai.koutei.SiHituyousyoruiHanteiInBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金給付金支払帳票作成前工程操作処理クラスのメソッド {@link SiharaiPreReportOperateProcess#operateProcess(TorikomiSyoruiBean, BM_TorikomiSyoruiHukaInfo, ReportServicesBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiPreReportOperateProcessTest_operateProcess extends AbstractTest {

    @Inject
    private SiHituyousyoruiHanteiInBean siHituyousyoruiHanteiInBean;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金給付金支払帳票作成前工程操作処理 ";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzProcessCreate.class).to(BzProcessCreateMockForSiharai.class);
                bind(SiharaiPreReportRenkeiBean.class).to(SiharaiPreReportRenkeiBeanMockForSiharai.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzProcessCreateMockForSiharai.caller = SiharaiPreReportOperateProcessTest_operateProcess.class;
        SiharaiPreReportRenkeiBeanMockForSiharai.caller = SiharaiPreReportOperateProcessTest_operateProcess.class;
        BzOutputProcessRecordMockForSiharai.caller = SiharaiPreReportOperateProcessTest_operateProcess.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiharaiPreReportOperateProcessTest_operateProcess.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.caller = null;
        SiharaiPreReportRenkeiBeanMockForSiharai.caller = null;
        BzOutputProcessRecordMockForSiharai.caller = null;
        BzProcessCreateMockForSiharai.SYORIPTN = null;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = null;
        BzOutputProcessRecordMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testOperateProcess_A1() {
        MockObjectManager.initialize();
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN1;
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN4;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");
        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);

        MockObjectManager.assertCalled(SiHituyousyoruiHantei.class, "exec");

        exStringEquals(kouteiKanriId, "10010", "工程管理ID");

        String pKouteiKanriId = (String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSiharai.class, "exec", 0, 0);
        String pJimuTetuzukiCd = (String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSiharai.class, "exec", 0, 1);
        String pSyoriComment = (String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSiharai.class, "exec", 0, 2);
        String pTaskName = (String) MockObjectManager.getArgument(BzOutputProcessRecordMockForSiharai.class, "exec", 0, 3);
        exStringEquals(pKouteiKanriId, "10010", "工程管理ID");
        exStringEquals(pJimuTetuzukiCd, "123", "事務手続コード");
        exStringEquals(pSyoriComment, "exec", "処理コメント");
        exStringEquals(pTaskName, "SiharaiPreReportOperateProcess", "タスク名");
        siHituyousyoruiHanteiInBean = (SiHituyousyoruiHanteiInBean)MockObjectManager.getArgument(SiHituyousyoruiHantei.class, "exec", 0, 0);
        exStringEquals(siHituyousyoruiHanteiInBean.getKouteiKanriId(),"10010", "支払必要書類判定入力Bean.工程管理ID");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);

    }

    @Test
    @TestOrder(20)
    public void testOperateProcess_A2() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN5;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN2;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);

        MockObjectManager.assertCalled(SiHituyousyoruiHantei.class, "exec");
        exStringEquals(kouteiKanriId, null, "工程管理ID");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 0, null);
        siHituyousyoruiHanteiInBean = (SiHituyousyoruiHanteiInBean)MockObjectManager.getArgument(SiHituyousyoruiHantei.class, "exec", 0, 0);
        exStringEquals(siHituyousyoruiHanteiInBean.getKouteiKanriId(),null, "支払必要書類判定入力Bean.工程管理ID");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    }

    @Test
    @TestOrder(30)
    public void testOperateProcess_A3() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN5;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN3;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);
        MockObjectManager.assertCalled(SiHituyousyoruiHantei.class, "exec");
        exStringEquals(kouteiKanriId, null, "工程管理ID");
        siHituyousyoruiHanteiInBean = (SiHituyousyoruiHanteiInBean)MockObjectManager.getArgument(SiHituyousyoruiHantei.class, "exec", 0, 0);
        exStringEquals(siHituyousyoruiHanteiInBean.getKouteiKanriId(),null, "支払必要書類判定入力Bean.工程管理ID");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    }

    @Test
    @TestOrder(40)
    public void testOperateProcess_A4() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN5;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN4;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);
        MockObjectManager.assertCalled(SiHituyousyoruiHantei.class, "exec");
        exStringEquals(kouteiKanriId, null, "工程管理ID");
        siHituyousyoruiHanteiInBean = (SiHituyousyoruiHanteiInBean)MockObjectManager.getArgument(SiHituyousyoruiHantei.class, "exec", 0, 0);
        exStringEquals(siHituyousyoruiHanteiInBean.getKouteiKanriId(),null, "支払必要書類判定入力Bean.工程管理ID");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    }

    @Test
    @TestOrder(50)
    public void testOperateProcess_A5() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN1;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN5;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);
        exStringEquals(kouteiKanriId, null, "工程管理ID");

        BzProcessCreateInBean bzProcessCreateInBean = (BzProcessCreateInBean) MockObjectManager.getArgument(
            BzProcessCreateMockForSiharai.class, "exec", 0, 0);

        exStringEquals(bzProcessCreateInBean.getSyoNo(), "tesuto", "証券番号");
        exStringEquals(bzProcessCreateInBean.getSkNo(), "123", "請求番号");
        exStringEquals(bzProcessCreateInBean.getJimuTetuzukiCd(), "123", "事務手続コード");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiKanriId(), "100", "親工程管理ＩＤ");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd(), "101", "親工程事務手続コード");

        MockObjectManager.assertNotCalled(SiHituyousyoruiHantei.class, "exec");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    }

    @Test
    @TestOrder(60)
    public void testOperateProcess_A6() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN6;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN5;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");
        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);
        exStringEquals(kouteiKanriId, "slow1", "工程管理ID");

        BzProcessCreateInBean bzProcessCreateInBean = (BzProcessCreateInBean) MockObjectManager.getArgument(
            BzProcessCreateMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzProcessCreateInBean.getSyoNo(), "tesuto", "証券番号");
        exStringEquals(bzProcessCreateInBean.getSkNo(), "123", "請求番号");
        exStringEquals(bzProcessCreateInBean.getJimuTetuzukiCd(), "123", "事務手続コード");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiKanriId(), "100", "親工程管理ＩＤ");
        exStringEquals(bzProcessCreateInBean.getOyaKouteiJimuTetuzukiCd(), "101", "親工程事務手続コード");

        MockObjectManager.assertNotCalled(SiHituyousyoruiHantei.class, "exec");
        MockObjectManager.assertArgumentPassed(BzOutputProcessRecordMockForSiharai.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);

    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testOperateProcess_A7() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN3;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN5;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        try {
            siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean, pTorikomiSyoruiHukaInfoBean,
                reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
            throw e;

        }
    }

    @Test
    @TestOrder(80)
    public void testOperateProcess_A8() {
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN6;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        String kouteiKanriId = siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean,
            pTorikomiSyoruiHukaInfoBean, reportServicesBean);
        exStringEquals(kouteiKanriId, "123", "工程管理ID");

    }

    @Test(expected = BizAppException.class)
    @TestOrder(90)
    public void testOperateProcess_A9() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN2;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN7;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        try {
            siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean, pTorikomiSyoruiHukaInfoBean,
                reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "既に処理中の工程が存在する為、工程作成処理を中止しました。（ 事務手続コード：123, 工程管理ID：slow1 ）", "エラーメッセージ");
            throw e;

        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(100)
    public void testOperateProcess_A10() {
        MockObjectManager.initialize();
        BzProcessCreateMockForSiharai.SYORIPTN = BzProcessCreateMockForSiharai.TESTPATTERN7;
        SiharaiPreReportRenkeiBeanMockForSiharai.SYORIPTN = SiharaiPreReportRenkeiBeanMockForSiharai.TESTPATTERN7;
        TorikomiSyoruiBean pTorikomiSyoruiMstBean = new TorikomiSyoruiBean();
        pTorikomiSyoruiMstBean.setFlowid("123");
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean = new BM_TorikomiSyoruiHukaInfo();
        pTorikomiSyoruiHukaInfoBean.setHozonKikan(1);
        CreateReport createReport = new CreateReport();
        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            "123",
            "456"
            );
        reportServicesBean.setKensakuKeys("tesuto");

        SiharaiPreReportOperateProcess siharaiPreReportOperateProcess = SWAKInjector.getInstance(SiharaiPreReportOperateProcess.class);
        try {
            siharaiPreReportOperateProcess.operateProcess(pTorikomiSyoruiMstBean, pTorikomiSyoruiHukaInfoBean,
                reportServicesBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "工程作成に失敗しました。", "エラーメッセージ");
            throw e;

        }
    }
}
