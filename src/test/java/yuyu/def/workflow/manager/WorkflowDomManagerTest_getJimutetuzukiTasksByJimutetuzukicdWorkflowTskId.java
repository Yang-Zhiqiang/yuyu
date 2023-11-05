package yuyu.def.workflow.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * WorkflowDomManagerクラスの、<br />
 * getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId {

    @Inject
    WorkflowDomManager workflowDomManager;

    @BeforeClass
    @Transactional

    public static void insertTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("10000000001", "80000000001");

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());


        DM_Jimutetuzuki jimutetuzuki1 = workflowDomManager.getJimutetuzuki("10000000001", "10000000060");
        if( null == jimutetuzuki1 ) {
            jimutetuzuki1 = new DM_Jimutetuzuki("10000000001", "10000000060");
            DM_JimutetuzukiTask jimutetuzukiTask1 = jimutetuzuki1.createJimutetuzukiTask();
            jimutetuzukiTask1.setWorkflowTskId("80000000001");

            DM_JimutetuzukiTask jimutetuzukiTask2 = jimutetuzuki1.createJimutetuzukiTask();
            jimutetuzukiTask2.setWorkflowTskId("80000000002");
            workflowDomManager.insert(jimutetuzuki1);

            DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("10000000002", "10000000060");

            DM_JimutetuzukiTask jimutetuzukiTask3 = jimutetuzuki2.createJimutetuzukiTask();
            jimutetuzukiTask3.setWorkflowTskId("80000000001");
            workflowDomManager.insert(jimutetuzuki2);

            DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("10000000003", "10000000061");

            DM_JimutetuzukiTask jimutetuzukiTask4 = jimutetuzuki3.createJimutetuzukiTask();
            jimutetuzukiTask4.setWorkflowTskId("80000000003");
            workflowDomManager.insert(jimutetuzuki3);

            DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("10000000003", "10000000062");

            DM_JimutetuzukiTask jimutetuzukiTask5 = jimutetuzuki4.createJimutetuzukiTask();
            jimutetuzukiTask5.setWorkflowTskId("80000000003");
            workflowDomManager.insert(jimutetuzuki4);

            DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki("10000000003", "10000000063");

            DM_JimutetuzukiTask jimutetuzukiTask6 = jimutetuzuki5.createJimutetuzukiTask();
            jimutetuzukiTask6.setWorkflowTskId("80000000003");
            workflowDomManager.insert(jimutetuzuki5);

        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("10000000001", "80000000003");

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("10000000001", "80000000001");

        Assert.assertEquals(1,jimutetuzukiTaskLst.size());
        Assert.assertEquals("10000000060", jimutetuzukiTaskLst.get(0).getSubSystemId());
        Assert.assertEquals("10000000001", jimutetuzukiTaskLst.get(0).getJimutetuzukicd());
        Assert.assertEquals("80000000001", jimutetuzukiTaskLst.get(0).getWorkflowTskId());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("10000000003", "80000000003");

        Assert.assertEquals(3,jimutetuzukiTaskLst.size());
        Map<String,String> map = new HashMap<>();
        map.put($("10000000061","10000000003","80000000003"), "1");
        map.put($("10000000062","10000000003","80000000003"), "1");
        map.put($("10000000063","10000000003","80000000003"), "1");

        for(DM_JimutetuzukiTask jimutetuzukiTask : jimutetuzukiTaskLst){
            map.remove($(jimutetuzukiTask.getSubSystemId(),jimutetuzukiTask.getJimutetuzukicd(),jimutetuzukiTask.getWorkflowTskId()));
        }
        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("", "80000000003");

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByJimutetuzukicdWorkflowTskId("10000000003", "");

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }
}

