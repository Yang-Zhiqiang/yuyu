package yuyu.def.workflow.manager;

import java.util.List;

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
 * getJimutetuzukiTasksBySubSystemIds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukiTasksByWorklistHyoujiFlag {

    @Inject
    WorkflowDomManager workflowDomManager;


    private final static String[] dSyukouteikanriid1 = {"sk05","sk06"};
    private final static String[] dSyukouteikanriid2 = {"sk00","sk01"};
    private final static String[] dSyukouteikanriid3 = {"sk02","sk03","sk04"};
    private final static String[] dSyukouteikanriid4 = {""};

    @BeforeClass
    @Transactional

    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(dSyukouteikanriid2);

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

        DM_Jimutetuzuki jimutetuzuki1 = workflowDomManager.getJimutetuzuki("10000000001", "sk01");
        if( null == jimutetuzuki1 ) {

            jimutetuzuki1 = new DM_Jimutetuzuki("10000000001", "sk01");

            DM_JimutetuzukiTask jimutetuzukiTask1 = jimutetuzuki1.createJimutetuzukiTask();
            jimutetuzukiTask1.setWorkflowTskId("80000000001");
            jimutetuzukiTask1.setHyoujijyun(11);
            jimutetuzukiTask1.setWorklistHyoujiFlag(1);

            DM_JimutetuzukiTask jimutetuzukiTask2 = jimutetuzuki1.createJimutetuzukiTask();
            jimutetuzukiTask2.setWorkflowTskId("80000000002");
            jimutetuzukiTask2.setHyoujijyun(11);
            jimutetuzukiTask2.setWorklistHyoujiFlag(2);

            workflowDomManager.insert(jimutetuzuki1);

            DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("10000000002", "sk02");

            DM_JimutetuzukiTask jimutetuzukiTask3 = jimutetuzuki2.createJimutetuzukiTask();
            jimutetuzukiTask3.setWorkflowTskId("80000000002");
            jimutetuzukiTask3.setHyoujijyun(12);
            jimutetuzukiTask3.setWorklistHyoujiFlag(1);

            workflowDomManager.insert(jimutetuzuki2);

            DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("10000000004", "sk04");

            DM_JimutetuzukiTask jimutetuzukiTask4 = jimutetuzuki4.createJimutetuzukiTask();
            jimutetuzukiTask4.setWorkflowTskId("80000000004");
            jimutetuzukiTask4.setHyoujijyun(14);
            jimutetuzukiTask4.setWorklistHyoujiFlag(1);

            workflowDomManager.insert(jimutetuzuki4);

            DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("10000000003", "sk03");

            DM_JimutetuzukiTask jimutetuzukiTask5 = jimutetuzuki3.createJimutetuzukiTask();
            jimutetuzukiTask5.setWorkflowTskId("80000000003");
            jimutetuzukiTask5.setHyoujijyun(13);
            jimutetuzukiTask5.setWorklistHyoujiFlag(1);

            workflowDomManager.insert(jimutetuzuki3);

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

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(dSyukouteikanriid1);

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(dSyukouteikanriid2);

        Assert.assertEquals(1,jimutetuzukiTaskLst.size());
        Assert.assertEquals("sk01", jimutetuzukiTaskLst.get(0).getSubSystemId());
        Assert.assertEquals("10000000001", jimutetuzukiTaskLst.get(0).getJimutetuzukicd());
        Assert.assertEquals("80000000001", jimutetuzukiTaskLst.get(0).getWorkflowTskId());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(dSyukouteikanriid3);

        Assert.assertEquals(3,jimutetuzukiTaskLst.size());
        Assert.assertEquals("sk02", jimutetuzukiTaskLst.get(0).getSubSystemId());
        Assert.assertEquals("10000000002", jimutetuzukiTaskLst.get(0).getJimutetuzukicd());
        Assert.assertEquals("80000000002", jimutetuzukiTaskLst.get(0).getWorkflowTskId());
        Assert.assertEquals(Integer.valueOf(12), jimutetuzukiTaskLst.get(0).getHyoujijyun());


        Assert.assertEquals("sk03", jimutetuzukiTaskLst.get(1).getSubSystemId());
        Assert.assertEquals("10000000003", jimutetuzukiTaskLst.get(1).getJimutetuzukicd());
        Assert.assertEquals("80000000003", jimutetuzukiTaskLst.get(1).getWorkflowTskId());
        Assert.assertEquals(Integer.valueOf(13), jimutetuzukiTaskLst.get(1).getHyoujijyun());

        Assert.assertEquals("sk04", jimutetuzukiTaskLst.get(2).getSubSystemId());
        Assert.assertEquals("10000000004", jimutetuzukiTaskLst.get(2).getJimutetuzukicd());
        Assert.assertEquals("80000000004", jimutetuzukiTaskLst.get(2).getWorkflowTskId());
        Assert.assertEquals(Integer.valueOf(14), jimutetuzukiTaskLst.get(2).getHyoujijyun());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(dSyukouteikanriid4);

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }
}

