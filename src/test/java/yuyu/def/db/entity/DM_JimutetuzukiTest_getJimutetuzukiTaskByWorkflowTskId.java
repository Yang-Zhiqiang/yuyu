package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 事務手続タスクマスタテーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class DM_JimutetuzukiTest_getJimutetuzukiTaskByWorkflowTskId {

    @Inject
    private WorkflowDomManager workflowDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        DM_Jimutetuzuki jimutetuzuki1 =  workflowDomManager.getJimutetuzuki("1", "2");
        if (jimutetuzuki1 == null) {
            jimutetuzuki1 = new DM_Jimutetuzuki("1", "2");
            DM_JimutetuzukiTask jimutetuzukiTask = jimutetuzuki1.getJimutetuzukiTaskByWorkflowTskId("111");
            Assert.assertEquals(null, jimutetuzukiTask);

            DM_JimutetuzukiTask jimutetuzukiTask2 = jimutetuzuki1.createJimutetuzukiTask();
            jimutetuzukiTask2.setWorkflowTskId("222");

            DM_JimutetuzukiTask jimutetuzukiTask1 = jimutetuzuki1.createJimutetuzukiTask();
            jimutetuzukiTask1.setWorkflowTskId("111");

            workflowDomManager.insert(jimutetuzuki1);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
    }

    @Test
    @TestOrder(30)
    public void noResult1() {

        DM_Jimutetuzuki jimutetuzuki = workflowDomManager.getJimutetuzuki("1", "2");
        DM_JimutetuzukiTask jimutetuzukiTask = jimutetuzuki.getJimutetuzukiTaskByWorkflowTskId("444");

        Assert.assertEquals(null, jimutetuzukiTask);
    }

    @Test
    @TestOrder(40)
    public void normal1() {

        DM_Jimutetuzuki jimutetuzuki = workflowDomManager.getJimutetuzuki("1", "2");
        DM_JimutetuzukiTask jimutetuzukiTask = jimutetuzuki.getJimutetuzukiTaskByWorkflowTskId("111");

        Assert.assertEquals("111", jimutetuzukiTask.getWorkflowTskId());
        Assert.assertEquals("2", jimutetuzukiTask.getSubSystemId());
        Assert.assertEquals("1", jimutetuzukiTask.getJimutetuzukicd());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        DM_Jimutetuzuki jimutetuzuki = workflowDomManager.getJimutetuzuki("1", "2");
        DM_JimutetuzukiTask jimutetuzukiTask = jimutetuzuki.getJimutetuzukiTaskByWorkflowTskId("");

        Assert.assertEquals(null, jimutetuzukiTask);
    }
}