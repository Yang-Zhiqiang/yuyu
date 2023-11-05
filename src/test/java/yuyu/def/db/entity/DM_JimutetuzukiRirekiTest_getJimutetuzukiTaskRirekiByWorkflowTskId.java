package yuyu.def.db.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 事務手続タスクマスタ履歴保存テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class DM_JimutetuzukiRirekiTest_getJimutetuzukiTaskRirekiByWorkflowTskId {

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getJimutetuzukiTaskRirekiByWorkflowTskId";

    private final static String sheetName = "INデータ";

    @Inject
    private WorkflowDomManager workflowDomManager;


    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        DM_JimutetuzukiRireki jimutetuzukiRireki = workflowDomManager.getJimutetuzukiRireki(BizDate.valueOf(20180130), "10", "hozen");

        if (jimutetuzukiRireki == null) {
            jimutetuzukiRireki = new DM_JimutetuzukiRireki(BizDate.valueOf(20180130), "10", "hozen");
            DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki = jimutetuzukiRireki.getJimutetuzukiTaskRirekiByWorkflowTskId("100");

            Assert.assertEquals(null, jimutetuzukiTaskRireki);

            insertTestData();
        }
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DM_JimutetuzukiRirekiTest_getJimutetuzukiTaskRirekiByWorkflowTskId.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzukiRireki());

    }

    @Test
    @TestOrder(30)
    public void noResult1() {

        DM_JimutetuzukiRireki jimutetuzukiRireki = workflowDomManager.getJimutetuzukiRireki(BizDate.valueOf(20180130), "10", "hozen");
        DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki = jimutetuzukiRireki.getJimutetuzukiTaskRirekiByWorkflowTskId("150");

        Assert.assertEquals(null, jimutetuzukiTaskRireki);
    }

    @Test
    @TestOrder(40)
    public void normal1() {

        DM_JimutetuzukiRireki jimutetuzukiRireki = workflowDomManager.getJimutetuzukiRireki(BizDate.valueOf(20180130), "10", "hozen");
        DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki = jimutetuzukiRireki.getJimutetuzukiTaskRirekiByWorkflowTskId("100");

        Assert.assertEquals(BizDate.valueOf(20180130), jimutetuzukiTaskRireki.getKensuuHokanYmd());
        Assert.assertEquals("hozen", jimutetuzukiTaskRireki.getSubSystemId());
        Assert.assertEquals("10", jimutetuzukiTaskRireki.getJimutetuzukicd());
        Assert.assertEquals("100", jimutetuzukiTaskRireki.getWorkflowTskId());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        DM_JimutetuzukiRireki jimutetuzukiRireki = workflowDomManager.getJimutetuzukiRireki(BizDate.valueOf(20180130), "10", "hozen");
        DM_JimutetuzukiTaskRireki jimutetuzukiTaskRireki = jimutetuzukiRireki.getJimutetuzukiTaskRirekiByWorkflowTskId("");

        Assert.assertEquals(null, jimutetuzukiTaskRireki);
    }
}