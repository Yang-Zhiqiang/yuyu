package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通実行可能タスク情報取得 {@link BzGetExecutableTasks#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetExecutableTasksTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_業務共通実行可能タスク情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetExecutableTasksTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller2 = BzGetExecutableTasksTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller2 = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());

        List<DM_JimutetuzukiTask> data = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("98765432",
            "3234213");
        workflowDomManager.delete(data);
        data = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("98765433", "3234214");
        workflowDomManager.delete(data);
        data = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("98765434", "3234215");
        workflowDomManager.delete(data);
        data = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("98765435", "3234216");
        workflowDomManager.delete(data);

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "1";

        String pUserId = "345564323";
        BzGetExecutableTasks bzGetExecutableTasks = SWAKInjector.getInstance(BzGetExecutableTasks.class);

        BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = bzGetExecutableTasks.exec(pUserId);

        exStringEquals(bzGetExecutableTasksOutBean.getSyoriKekkaStatus(), "0", "処理結果ステータス ");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessageCd(), "IWF2070", "詳細メッセージコード");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessage(), "権限IDが取得できませんでした。", "詳細メッセージ");
        exNumericEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().size(), 0,
            "業務共通実行可能タスク情報取得リスト件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "2";

        String pUserId = "345564343";
        BzGetExecutableTasks bzGetExecutableTasks = SWAKInjector.getInstance(BzGetExecutableTasks.class);

        BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = bzGetExecutableTasks.exec(pUserId);

        exStringEquals(bzGetExecutableTasksOutBean.getSyoriKekkaStatus(), "9", "処理結果ステータス ");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessageCd(), "EAF1004", "詳細メッセージコード");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessage(), "指定データ異常が発生しました。",
            "詳細メッセージ");
        exNumericEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().size(), 0,
            "業務共通実行可能タスク情報取得リスト件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "3";

        String pUserId = "345564387";
        BzGetExecutableTasks bzGetExecutableTasks = SWAKInjector.getInstance(BzGetExecutableTasks.class);

        BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = bzGetExecutableTasks.exec(pUserId);

        exStringEquals(bzGetExecutableTasksOutBean.getSyoriKekkaStatus(), "0", "処理結果ステータス ");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessageCd(), "IAC0009", "詳細メッセージコード");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessage(), "処理が完了しました。", "詳細メッセージ");
        exNumericEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().size(), 1,
            "業務共通実行可能タスク情報取得リスト件数");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getSubSystemId(), "base",
            "サブシステムＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getSubSystemNm(), "管理機能",
            "サブシステム名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getJimutetuzukiCd(),
            "98765432","事務手続コード");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getJimutetuzukiNm(),
            "事務手続名","事務手続名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getTskId(),
            "3234213","タスクＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getTskNm(),
            "タスク名1","タスク名");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "4";

        String pUserId = "345564337";
        BzGetExecutableTasks bzGetExecutableTasks = SWAKInjector.getInstance(BzGetExecutableTasks.class);

        BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = bzGetExecutableTasks.exec(pUserId);

        exStringEquals(bzGetExecutableTasksOutBean.getSyoriKekkaStatus(), "0", "処理結果ステータス ");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessageCd(), "IAC0009", "詳細メッセージコード");
        exStringEquals(bzGetExecutableTasksOutBean.getSyousaiMessage(), "処理が完了しました。", "詳細メッセージ");
        exNumericEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().size(), 3,
            "業務共通実行可能タスク情報取得リスト件数");

        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getSubSystemId(), "biz",
            "サブシステムＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getSubSystemNm(), "業務共通",
            "サブシステム名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getJimutetuzukiCd(),
            "98765433","事務手続コード");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getJimutetuzukiNm(),
            "事務手続名","事務手続名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getTskId(),
            "3234214","タスクＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(0).getTskNm(),
            "タスク名2","タスク名");

        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(1).getSubSystemId(), "consumer",
            "サブシステムＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(1).getSubSystemNm(),
            "コンシューマ","サブシステム名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(1).getJimutetuzukiCd(),
            "98765433","事務手続コード");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(1).getJimutetuzukiNm(),
            "事務手続名","事務手続名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(1).getTskId(),
            "3234214","タスクＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(1).getTskNm(),
            "タスク名3","タスク名");

        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(2).getSubSystemId(), "hozen",
            "サブシステムＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(2).getSubSystemNm(), "契約保全",
            "サブシステム名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(2).getJimutetuzukiCd(),
            "98765434","事務手続コード");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(2).getJimutetuzukiNm(),
            "事務手続名","事務手続名");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(2).getTskId(),
            "3234215","タスクＩＤ");
        exStringEquals(bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList().get(2).getTskNm(),
            "タスク名4","タスク名");
    }
}