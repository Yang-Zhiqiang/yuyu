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
 * getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd {

    @Inject
    WorkflowDomManager workflowDomManager;

    private final static String[] dSyukouteikanriid1 = {"A100","A700"};
    private final static String[] dSyukouteikanriid2 = {"A700","A800"};
    private final static String[] dSyukouteikanriid3 = {"A100","A500","A600"};
    private final static String[] dSyukouteikanriid4 = {""};

    @BeforeClass
    @Transactional

    public static void insertTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid1);

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

        DM_Jimutetuzuki jimutetuzuki1 = new DM_Jimutetuzuki("ASD100", "A100");

        DM_JimutetuzukiTask jimutetuzukiTask1 = jimutetuzuki1.createJimutetuzukiTask();
        jimutetuzukiTask1.setWorkflowTskId("100");
        jimutetuzukiTask1.setHyoujijyun(3);

        workflowDomManager.insert(jimutetuzuki1);

        DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("ASD200", "A100");

        workflowDomManager.insert(jimutetuzuki2);

        DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("ASD100", "A200");

        workflowDomManager.insert(jimutetuzuki3);

        DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("ASD100", "A300");

        DM_JimutetuzukiTask jimutetuzukiTask2 = jimutetuzuki4.createJimutetuzukiTask();
        jimutetuzukiTask2.setWorkflowTskId("100");
        jimutetuzukiTask2.setHyoujijyun(3);

        workflowDomManager.insert(jimutetuzuki4);

        DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki("ASD400", "A100");
        jimutetuzuki5.setSyukouteijimutetuzukicd("S100");

        DM_JimutetuzukiTask jimutetuzukiTask5 = jimutetuzuki5.createJimutetuzukiTask();
        jimutetuzukiTask5.setWorkflowTskId("100");
        jimutetuzukiTask5.setHyoujijyun(3);

        workflowDomManager.insert(jimutetuzuki5);

        DM_Jimutetuzuki jimutetuzuki6 = new DM_Jimutetuzuki("ASD100", "A500");

        DM_JimutetuzukiTask jimutetuzukiTask3 = jimutetuzuki6.createJimutetuzukiTask();
        jimutetuzukiTask3.setWorkflowTskId("100");
        jimutetuzukiTask3.setHyoujijyun(2);

        workflowDomManager.insert(jimutetuzuki6);

        DM_Jimutetuzuki jimutetuzuki7 = new DM_Jimutetuzuki("ASD100", "A600");

        DM_JimutetuzukiTask jimutetuzukiTask4 = jimutetuzuki7.createJimutetuzukiTask();
        jimutetuzukiTask4.setWorkflowTskId("100");
        jimutetuzukiTask4.setHyoujijyun(1);

        workflowDomManager.insert(jimutetuzuki7);

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

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid2);

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid1);

        Assert.assertEquals(1,jimutetuzukiTaskLst.size());
        Assert.assertEquals("A100", jimutetuzukiTaskLst.get(0).getSubSystemId());
        Assert.assertEquals("ASD100", jimutetuzukiTaskLst.get(0).getJimutetuzukicd());
        Assert.assertEquals("100", jimutetuzukiTaskLst.get(0).getWorkflowTskId());
        Assert.assertEquals(3, jimutetuzukiTaskLst.get(0).getHyoujijyun().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid3);

        Assert.assertEquals(3,jimutetuzukiTaskLst.size());
        Assert.assertEquals("A600", jimutetuzukiTaskLst.get(0).getSubSystemId());
        Assert.assertEquals("ASD100", jimutetuzukiTaskLst.get(0).getJimutetuzukicd());
        Assert.assertEquals("100", jimutetuzukiTaskLst.get(0).getWorkflowTskId());
        Assert.assertEquals(1, jimutetuzukiTaskLst.get(0).getHyoujijyun().intValue());

        Assert.assertEquals("A500", jimutetuzukiTaskLst.get(1).getSubSystemId());
        Assert.assertEquals("ASD100", jimutetuzukiTaskLst.get(1).getJimutetuzukicd());
        Assert.assertEquals("100", jimutetuzukiTaskLst.get(1).getWorkflowTskId());
        Assert.assertEquals(2, jimutetuzukiTaskLst.get(1).getHyoujijyun().intValue());

        Assert.assertEquals("A100", jimutetuzukiTaskLst.get(2).getSubSystemId());
        Assert.assertEquals("ASD100", jimutetuzukiTaskLst.get(2).getJimutetuzukicd());
        Assert.assertEquals("100", jimutetuzukiTaskLst.get(2).getWorkflowTskId());
        Assert.assertEquals(3, jimutetuzukiTaskLst.get(2).getHyoujijyun().intValue());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = workflowDomManager.getJimutetuzukiTasksBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid4);

        Assert.assertEquals(0,jimutetuzukiTaskLst.size());

    }
}

