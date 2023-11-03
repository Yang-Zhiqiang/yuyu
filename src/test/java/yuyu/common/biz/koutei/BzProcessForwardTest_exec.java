package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.StringUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程遷移クラスのメソッド {@link BzProcessForward#exec(BzProcessForwardInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzProcessForwardTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetWariateHukaInfo.class).to(SetWariateHukaInfoMockForBiz.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
                bind(UpdateJimustartymd.class).to(UpdateJimustartymdMockForBiz.class);
                bind(BzTaskStart.class).to(BzTaskStartMockForBiz.class);
                bind(BzOutputProcessRecord.class).to(BzOutputProcessRecordMockForBiz.class);
                bind(BzEndProcess.class).to(BzEndProcessMockForBiz.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        BzGetProcessSummaryMockForBiz.caller = BzProcessForwardTest_exec.class;
        UpdateJimustartymdMockForBiz.caller = BzProcessForwardTest_exec.class;
        BzTaskStartMockForBiz.caller = BzProcessForwardTest_exec.class;
        SetWariateHukaInfoMockForBiz.caller = BzProcessForwardTest_exec.class;
        BzOutputProcessRecordMockForBiz.caller = BzProcessForwardTest_exec.class;
        BzEndProcessMockForBiz.caller = BzProcessForwardTest_exec.class;
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        BzGetProcessSummaryMockForBiz.caller = null;
        UpdateJimustartymdMockForBiz.caller = null;
        BzTaskStartMockForBiz.caller = null;
        SetWariateHukaInfoMockForBiz.caller = null;
        BzOutputProcessRecordMockForBiz.caller = null;
        BzEndProcessMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode=null;

        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        UpdateJimustartymdMockForBiz.SYORIPTN = null;
        BzTaskStartMockForBiz.SYORIPTN = null;
        SetWariateHukaInfoMockForBiz.SYORIPTN = null;
        BzOutputProcessRecordMockForBiz.SYORIPTN = null;
        BzEndProcessMockForBiz.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        UpdateJimustartymdMockForBiz.SYORIPTN = UpdateJimustartymdMockForBiz.TESTPATTERN1;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 0), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 1), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 2), "103", "工程ロックキー");
        String jimuStartYmd = (String) MockObjectManager.getArgument(UpdateJimustartymdMockForBiz.class, "exec", 0, 3);
        exStringEquals(jimuStartYmd.substring(0, 8), BizDate.getSysDateTimeMilli().substring(0, 8), "事務開始日");

        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 2), "処理コメント", "処理コメント");
        exStringEquals((String) MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 3), null, "タスク名");
        exClassificationEquals((C_SyorikekkaKbn) MockObjectManager.getArgument(BzOutputProcessRecordMockForBiz.class, "exec", 0, 4), C_SyorikekkaKbn.BLNK, "処理結果区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        IwfKouteiClientMockForBiz.mode = "dl-02";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        try {
            BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
            BzProcessForward.exec(pBzProcessForwardInBean);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程遷移、API＝工程遷移、エラーコード＝IWF0002", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");
        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;
        BzEndProcessMockForBiz.SYORIPTN = BzEndProcessMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");
        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        MockObjectManager.assertCalled(BzTaskStartMockForBiz.class, "exec");

        exStringEquals((String) MockObjectManager.getArgument(BzEndProcessMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzEndProcessMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzEndProcessMockForBiz.class, "exec", 0, 2), "103", "工程ロックキー");
        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(BzEndProcessMockForBiz.class, "exec", 0, 3), C_YouhiKbn.HUYOU, "主工程終了要否区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");
        pBzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.YOU);
        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");

        MockObjectManager.assertCalled(BzOutputProcessRecordMockForBiz.class, "exec");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");
        pBzProcessForwardInBean.setProcessRecordOutYouhiKbn(C_YouhiKbn.HUYOU);
        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");

        MockObjectManager.assertNotCalled(BzOutputProcessRecordMockForBiz.class, "exec");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");
        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");

        MockObjectManager.assertCalled(BzOutputProcessRecordMockForBiz.class, "exec");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_1);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");
        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2A);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_KANKYOU_2B);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIUW);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_IMU_KANIMD);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU_MOSTORIKESI);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_1);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_2);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_TENKEN_3);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_1);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_2A);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_KANKYOU_2B);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIUW);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIMD);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 1), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 2), StringUtils.EMPTY, "タスクID");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 3), "103", "工程ロックキー");
        exStringEquals((String) MockObjectManager.getArgument(BzTaskStartMockForBiz.class, "exec", 0, 4), "user01", "ユーザーID");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIMD);
        pBzProcessForwardInBean.setSaiwariateUserId(null);

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        MockObjectManager.assertNotCalled(BzTaskStartMockForBiz.class, "exec");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.IRAI_IMU_KANIMD);
        pBzProcessForwardInBean.setSaiwariateUserId("");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        MockObjectManager.assertNotCalled(BzTaskStartMockForBiz.class, "exec");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        SetWariateHukaInfoMockForBiz.SYORIPTN = SetWariateHukaInfoMockForBiz.TESTPATTERN1;
        BzTaskStartMockForBiz.SYORIPTN = BzTaskStartMockForBiz.TESTPATTERN1;
        IwfKouteiClientMockForBiz.mode = "dl-011";
        BzOutputProcessRecordMockForBiz.SYORIPTN = BzOutputProcessRecordMockForBiz.TESTPATTERN1;

        BzProcessForwardInBean pBzProcessForwardInBean = new BzProcessForwardInBean();
        pBzProcessForwardInBean.setKouteiKanriId("101");
        pBzProcessForwardInBean.setJimuTetuzukiCd("102");
        pBzProcessForwardInBean.setKouteiLockKey("103");
        pBzProcessForwardInBean.setSyoriComment("処理コメント");
        pBzProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.HUBI);
        pBzProcessForwardInBean.setSaiwariateUserId("user01");

        BzProcessForward BzProcessForward = SWAKInjector.getInstance(BzProcessForward.class);
        BzProcessForward.exec(pBzProcessForwardInBean);

        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 0), "101", "工程管理ID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 1), "common", "サブシステムID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 2), "102", "事務手続コード");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 3), "TaskNm01", "現在タスクID");
        exStringEquals((String) MockObjectManager.getArgument(SetWariateHukaInfoMockForBiz.class, "exec", 0, 4), StringUtils.EMPTY, "次回タスクID");

        MockObjectManager.assertCalled(BzTaskStartMockForBiz.class, "exec");
    }
}
