package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 工程情報表示設定クラスのメソッド {@link SetKouteiInfo#exec(SetKouteiInfoExecUiBeanParam pUiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKouteiInfoTest_exec {

    @Inject
    private SetKouteiInfo setKouteiInfo;


    @Inject
    private SetKouteiInfoExecUiBeanParamImpl setKouteiInfoExecUiBeanParamImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_工程情報表示設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKouteiInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        setKouteiInfoExecUiBeanParamImpl.setBzworkflowInfo(new BzWorkflowInfo());
        setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().setJimuTetuzukiCd("A");
        setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().setTaskId("B");

        setKouteiInfo.exec(setKouteiInfoExecUiBeanParamImpl);

        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getVktifdispjimutetuzukinm(), "", "（工程情報表示）事務手続名");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getVktifdisptasknm(), "", "（工程情報表示）タスク");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().getJimuTetuzukiCd(), "A", "事務手続コード");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().getTaskId(), "B", "タスクID");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        setKouteiInfoExecUiBeanParamImpl.setBzworkflowInfo(new BzWorkflowInfo());
        setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().setJimuTetuzukiCd("80000000010");
        setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().setTaskId("B");

        setKouteiInfo.exec(setKouteiInfoExecUiBeanParamImpl);

        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getVktifdispjimutetuzukinm(), "（表示用）事務手続名", "（工程情報表示）事務手続名");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getVktifdisptasknm(), "", "（工程情報表示）タスク");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().getJimuTetuzukiCd(), "80000000010", "事務手続コード");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().getTaskId(), "B", "タスクID");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        setKouteiInfoExecUiBeanParamImpl.setBzworkflowInfo(new BzWorkflowInfo());
        setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().setJimuTetuzukiCd("80000000010");
        setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().setTaskId("20000000010");

        setKouteiInfo.exec(setKouteiInfoExecUiBeanParamImpl);

        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getVktifdispjimutetuzukinm(), "（表示用）事務手続名", "（工程情報表示）事務手続名");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getVktifdisptasknm(), "ワークフロータスク名", "（工程情報表示）タスク");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().getJimuTetuzukiCd(), "80000000010", "事務手続コード");
        exStringEquals(setKouteiInfoExecUiBeanParamImpl.getBzWorkflowInfo().getTaskId(), "20000000010", "タスクID");

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());

    }

}
