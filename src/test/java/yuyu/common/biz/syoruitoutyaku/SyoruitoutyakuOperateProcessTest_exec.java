package yuyu.common.biz.syoruitoutyaku;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForBiz;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessMockForBiz;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzOutputProcessRecordMockForBiz;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.BzUnlockProcessMockForBiz;
import yuyu.common.biz.koutei.UpdateJimustartymd;
import yuyu.common.biz.koutei.UpdateJimustartymdMockForBiz;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.image.GetTorikomiSyoruiMstInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessForwardInBean;
import yuyu.common.hozen.syoruitoutyaku.HozenSyoruitoutyakuOperateProcess;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通 書類到着 書類到着時工程操作処理のメソッド {@link SyoruitoutyakuOperateProcess#exec(String, String, String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyoruitoutyakuOperateProcessTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_書類到着時工程操作処理";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
                bind(BzLockProcess.class).to(BzLockProcessMockForBiz.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForBiz.class);
                bind(UpdateJimustartymd.class).to(UpdateJimustartymdMockForBiz.class);
                bind(BzUnlockProcess.class).to(BzUnlockProcessMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        IwfImageClientMockForBiz.caller = "Test";
        IwfKouteiClientMockForBiz.caller = "Test";
        BzGetProcessSummaryMockForBiz.caller = SyoruitoutyakuOperateProcessTest_exec.class;
        BzLockProcessMockForBiz.caller = SyoruitoutyakuOperateProcessTest_exec.class;
        BzOutputProcessRecordMockForBiz.caller = SyoruitoutyakuOperateProcessTest_exec.class;
        UpdateJimustartymdMockForBiz.caller = UpdateJimustartymdMockForBiz.class;
        BzUnlockProcessMockForBiz.caller = SyoruitoutyakuOperateProcessTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMockForBiz.caller = null;
        IwfImageClientMockForBiz.mode = null;
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
        BzGetProcessSummaryMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        BzLockProcessMockForBiz.caller = null;
        BzLockProcessMockForBiz.SYORIPTN = null;
        BzOutputProcessRecordMockForBiz.caller = null;
        BzOutputProcessRecordMockForBiz.SYORIPTN = null;
        UpdateJimustartymdMockForBiz.caller = null;
        UpdateJimustartymdMockForBiz.SYORIPTN = null;
        BzUnlockProcessMockForBiz.caller = null;
        BzUnlockProcessMockForBiz.SYORIPTN = null;
        MockObjectManager.initialize();

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyoruitoutyakuOperateProcessTest_exec.class, fileName, sheetName);
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

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        String pToutyakuKey = "10";
        String pAppKey = "1001";
        String pSyoruiCd = null;
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "異常終了しました、詳細は、出力したログファイルをご参照ください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        String pToutyakuKey = "10";
        String pAppKey = "1002";
        String pSyoruiCd = "";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "異常終了しました、詳細は、出力したログファイルをご参照ください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(30)
    public void testExec_A3() {
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1003";
        String pSyoruiCd = "kk017";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "案件が取り消されています。管理者に連絡してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        IwfImageClientMockForBiz.mode = "08-01";
        String pToutyakuKey = "10";
        String pAppKey = "1004";
        String pSyoruiCd = "kk017";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝書類到着時工程操作処理、API＝取込書類マスタ取得、エラーコード＝IWF9999", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        IwfImageClientMockForBiz.mode = "08-06";
        IwfKouteiClientMockForBiz.mode = "16-05";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1005";
        String pSyoruiCd = "kk017";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1005", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean = (GetTorikomiSyoruiMstInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetTorikomiSyoruiMst", 0, 0);
        exStringEquals(getTorikomiSyoruiMstInBean.getTorikomisyoruicd(), "kk017", "取込書類コード");
        exStringEquals(getTorikomiSyoruiMstInBean.getFlowid(), "sktenken", "フローID");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 0), "1005", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 1), "sktenken", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 2), "取込用表紙", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 3), "書類到着", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 4), C_SyorikekkaKbn.BLNK, "処理結果区分");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        IwfImageClientMockForBiz.mode = "08-06";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1006";
        String pSyoruiCd = "kk060";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "想定外のタイミングで、到着待ち書類の取込が行われました。管理者に連絡してください。", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1007";
        String pSyoruiCd = "kk060";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "想定外のタイミングで、到着待ち書類の取込が行われました。管理者に連絡してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        IwfImageClientMockForBiz.mode = "08-06";
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzUnlockProcessMockForBiz.SYORIPTN = BzUnlockProcessMockForBiz.TESTPATTERN1;
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1008";
        String pSyoruiCd = "kk060";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "想定外のタイミングで、到着待ち書類の取込が行われました。管理者に連絡してください。", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = BizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        IwfImageClientMockForBiz.mode = "08-06";
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        UpdateJimustartymdMockForBiz.SYORIPTN = UpdateJimustartymdMockForBiz.TESTPATTERN1;
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-02";
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1009";
        String pSyoruiCd = "kk152";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝書類到着時工程操作処理、API＝工程遷移、エラーコード＝IWF0002", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        IwfImageClientMockForBiz.mode = "08-06";
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        UpdateJimustartymdMockForBiz.SYORIPTN = UpdateJimustartymdMockForBiz.TESTPATTERN1;
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzUnlockProcessMockForBiz.SYORIPTN = BzUnlockProcessMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        String pToutyakuKey = "10";
        String pAppKey = "1010";
        String pSyoruiCd = "kk152";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";

        hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1010", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getKouteiKanriId(), "2005", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");

        exStringEquals((String)MockObjectManager.getArgument(BzLockProcessMockForBiz.class, "exec", 0, 0), "2005", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzLockProcessMockForBiz.class, "exec", 0, 1), "skkankyou", "事務手続コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getKouteiKanriId(), "1010", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean = (GetTorikomiSyoruiMstInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetTorikomiSyoruiMst", 0, 0);
        exStringEquals(getTorikomiSyoruiMstInBean.getTorikomisyoruicd(), "kk152", "取込書類コード");
        exStringEquals(getTorikomiSyoruiMstInBean.getFlowid(), "sktenken", "フローID");

        exStringEquals((String)MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 0), "sktenken", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 1), "1010", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 2), "testKouteiLockKey", "工程ロックキー");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 0), "1010", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 1), "sktenken", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 2), "取込用表紙", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 3), "書類到着", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 4), C_SyorikekkaKbn.BLNK, "処理結果区分");

        ProcessForwardInBean processForwardInBean = (ProcessForwardInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execProcessForward", 0, 0);
        exStringEquals(processForwardInBean.getGyoumukey(), "1010", "業務キー");
        exStringEquals(processForwardInBean.getFlowid(), "sktenken", "フローID");
        exStringEquals(processForwardInBean.getAccountid(), "JUnit", "アカウントID");
        List<Map<String, String>> extInfoLst = processForwardInBean.getExtInfo();
        exStringEquals(extInfoLst.get(0).get("syorikekkakbn"), "910", "付加情報マップの値");
        exStringEquals(processForwardInBean.getLockkey(), "testKouteiLockKey", "ロックキー");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getKouteiKanriId(), "1010", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "2005", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "skkankyou", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 2), "testKouteiLockKey", "工程ロックキー");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN5;
        IwfImageClientMockForBiz.mode = "08-06";
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzUnlockProcessMockForBiz.SYORIPTN = BzUnlockProcessMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1011";
        String pSyoruiCd = "kk152";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";

        hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1011", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getKouteiKanriId(), "2006", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skkankyou", "事務手続コード");

        exStringEquals((String)MockObjectManager.getArgument(BzLockProcessMockForBiz.class, "exec", 0, 0), "2006", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzLockProcessMockForBiz.class, "exec", 0, 1), "skkankyou", "事務手続コード");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 2, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getKouteiKanriId(), "1011", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean = (GetTorikomiSyoruiMstInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetTorikomiSyoruiMst", 0, 0);
        exStringEquals(getTorikomiSyoruiMstInBean.getTorikomisyoruicd(), "kk152", "取込書類コード");
        exStringEquals(getTorikomiSyoruiMstInBean.getFlowid(), "sktenken", "フローID");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 0), "1011", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 1), "sktenken", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 2), "取込用表紙", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 3), "書類到着", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 4), C_SyorikekkaKbn.BLNK, "処理結果区分");

        ProcessForwardInBean processForwardInBean = (ProcessForwardInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execProcessForward", 0, 0);
        exStringEquals(processForwardInBean.getGyoumukey(), "1011", "業務キー");
        exStringEquals(processForwardInBean.getFlowid(), "sktenken", "フローID");
        exStringEquals(processForwardInBean.getAccountid(), "JUnit", "アカウントID");
        List<Map<String, String>> extInfoLst = processForwardInBean.getExtInfo();
        exStringEquals(extInfoLst.get(0).get("syorikekkakbn"), "910", "付加情報マップの値");
        exStringEquals(processForwardInBean.getLockkey(), "testKouteiLockKey", "ロックキー");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean4 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 3, 0);
        exStringEquals(bzGetProcessSummaryInBean4.getKouteiKanriId(), "1011", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean4.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 0), "2006", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 1), "skkankyou", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzUnlockProcessMockForBiz.class, "exec", 0, 2), "testKouteiLockKey", "工程ロックキー");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        IwfImageClientMockForBiz.mode = "08-06";
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;
        UpdateJimustartymdMockForBiz.SYORIPTN = UpdateJimustartymdMockForBiz.TESTPATTERN1;
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-02";
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1009";
        String pSyoruiCd = "kk152";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        try {

            hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "他ユーザが処理中のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN6;
        IwfImageClientMockForBiz.mode = "08-06";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess = SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        String pToutyakuKey = "10";
        String pAppKey = "1006";
        String pSyoruiCd = "kk060";
        String pFlowId = "sktenken";
        String pSubsystemId = "14";
        String pImageId = "15";
        hozenSyoruitoutyakuOperateProcess.exec(pToutyakuKey, pAppKey, pSyoruiCd, pFlowId, pSubsystemId, pImageId);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager.getArgument(
            BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(), "1006", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "sktenken", "事務手続コード");

        GetTorikomiSyoruiMstInBean getTorikomiSyoruiMstInBean = (GetTorikomiSyoruiMstInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetTorikomiSyoruiMst", 0, 0);
        exStringEquals(getTorikomiSyoruiMstInBean.getTorikomisyoruicd(), "kk060", "取込書類コード");
        exStringEquals(getTorikomiSyoruiMstInBean.getFlowid(), "sktenken", "フローID");

        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 0), "1006", "工程管理ID");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 1), "sktenken", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 2), "取込用表紙", "処理コメント");
        exStringEquals((String)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 3), "書類到着", "タスク名");
        exClassificationEquals((C_SyorikekkaKbn)MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 4), C_SyorikekkaKbn.BLNK, "処理結果区分");

    }

}
