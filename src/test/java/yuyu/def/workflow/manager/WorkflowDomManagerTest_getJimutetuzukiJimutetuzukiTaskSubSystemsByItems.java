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

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.result.bean.JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * WorkflowDomManagerクラスの、<br />
 * getJimutetuzukiJimutetuzukiTaskSubSystemsByItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukiJimutetuzukiTaskSubSystemsByItems {

    @Inject
    WorkflowDomManager workflowDomManager;
    BaseDomManager baseDomManager;

    private static final String[] jimutetuzukicd1 = {"111","222"};
    private static final String[] jimutetuzukicd2 = {"333","444","555"};
    private static final String[] jimutetuzukicd3 = {"444","555","666"};
    private static final String[] workflowTskId1 = {"123","456"};
    private static final String[] workflowTskId2 = {"789","322","433"};
    private static final String[] workflowTskId3 = {"121","232","343"};
    private static final String[] workflowTskIdblank = {""};
    private static final String[] jimutetuzukicdblank = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean = workflowDomManager
                .getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(jimutetuzukicd1,workflowTskId1);

        int iCount = 0;
        for (JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean : jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean) {
            iCount++;

        }
        Assert.assertEquals(0,iCount);

        DM_Jimutetuzuki jimutetuzuki1 = new DM_Jimutetuzuki("111", "1111");
        jimutetuzuki1.setHyoujijyun(11);

        DM_JimutetuzukiTask jimutetuzukiTask1 = jimutetuzuki1.createJimutetuzukiTask();
        jimutetuzukiTask1.setWorkflowTskId("123");
        jimutetuzukiTask1.setHyoujijyun(01);

        DM_JimutetuzukiTask jimutetuzukiTask3 = jimutetuzuki1.createJimutetuzukiTask();
        jimutetuzukiTask3.setWorkflowTskId("789");
        jimutetuzukiTask3.setHyoujijyun(01);

        workflowDomManager.insert(jimutetuzuki1);

        DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("111", "2222");
        jimutetuzuki2.setHyoujijyun(11);

        workflowDomManager.insert(jimutetuzuki2);

        DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("222", "1111");
        jimutetuzuki3.setHyoujijyun(11);

        workflowDomManager.insert(jimutetuzuki3);

        DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("333", "1111");
        jimutetuzuki4.setHyoujijyun(11);

        DM_JimutetuzukiTask jimutetuzukiTask2 = jimutetuzuki4.createJimutetuzukiTask();
        jimutetuzukiTask2.setWorkflowTskId("123");
        jimutetuzukiTask2.setHyoujijyun(01);

        workflowDomManager.insert(jimutetuzuki4);

        DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki("444", "4444");
        jimutetuzuki5.setHyoujijyun(99);

        DM_JimutetuzukiTask jimutetuzukiTask4 = jimutetuzuki5.createJimutetuzukiTask();
        jimutetuzukiTask4.setWorkflowTskId("121");
        jimutetuzukiTask4.setHyoujijyun(19);

        workflowDomManager.insert(jimutetuzuki5);

        DM_Jimutetuzuki jimutetuzuki6 = new DM_Jimutetuzuki("555", "4441");
        jimutetuzuki6.setHyoujijyun(77);

        DM_JimutetuzukiTask jimutetuzukiTask5 = jimutetuzuki6.createJimutetuzukiTask();
        jimutetuzukiTask5.setWorkflowTskId("232");
        jimutetuzukiTask5.setHyoujijyun(19);

        workflowDomManager.insert(jimutetuzuki6);

        DM_Jimutetuzuki jimutetuzuki7 = new DM_Jimutetuzuki("666", "4442");
        jimutetuzuki7.setHyoujijyun(99);

        DM_JimutetuzukiTask jimutetuzukiTask6 = jimutetuzuki7.createJimutetuzukiTask();
        jimutetuzukiTask6.setWorkflowTskId("343");
        jimutetuzukiTask6.setHyoujijyun(19);

        workflowDomManager.insert(jimutetuzuki7);

        DM_Jimutetuzuki jimutetuzuki8 = new DM_Jimutetuzuki("666", "5555");
        jimutetuzuki8.setHyoujijyun(88);

        DM_JimutetuzukiTask jimutetuzukiTask7 = jimutetuzuki8.createJimutetuzukiTask();
        jimutetuzukiTask7.setWorkflowTskId("121");
        jimutetuzukiTask7.setHyoujijyun(17);

        workflowDomManager.insert(jimutetuzuki8);

        DM_Jimutetuzuki jimutetuzuki9 = new DM_Jimutetuzuki("666", "6666");
        jimutetuzuki9.setHyoujijyun(77);

        DM_JimutetuzukiTask jimutetuzukiTask8 = jimutetuzuki9.createJimutetuzukiTask();
        jimutetuzukiTask8.setWorkflowTskId("121");
        jimutetuzukiTask8.setHyoujijyun(19);

        workflowDomManager.insert(jimutetuzuki9);

        DM_Jimutetuzuki jimutetuzuki10 = new DM_Jimutetuzuki("666", "7777");
        jimutetuzuki10.setHyoujijyun(77);

        DM_JimutetuzukiTask jimutetuzukiTask9 = jimutetuzuki10.createJimutetuzukiTask();
        jimutetuzukiTask9.setWorkflowTskId("121");
        jimutetuzukiTask9.setHyoujijyun(18);

        workflowDomManager.insert(jimutetuzuki10);

        DM_Jimutetuzuki jimutetuzuki11 = new DM_Jimutetuzuki("666", "8888");
        jimutetuzuki11.setHyoujijyun(77);

        DM_JimutetuzukiTask jimutetuzukiTask10 = jimutetuzuki11.createJimutetuzukiTask();
        jimutetuzukiTask10.setWorkflowTskId("121");
        jimutetuzukiTask10.setHyoujijyun(17);

        workflowDomManager.insert(jimutetuzuki11);

        AS_SubSystem subSystem1 = new AS_SubSystem("1111");
        subSystem1.setSortNo(111);

        workflowDomManager.insert(subSystem1);

        AS_SubSystem subSystem2 = new AS_SubSystem("3333");
        subSystem2.setSortNo(111);

        workflowDomManager.insert(subSystem2);

        AS_SubSystem subSystem3 = new AS_SubSystem("4444");
        subSystem3.setSortNo(999);

        workflowDomManager.insert(subSystem3);

        AS_SubSystem subSystem4 = new AS_SubSystem("4441");
        subSystem4.setSortNo(888);

        workflowDomManager.insert(subSystem4);

        AS_SubSystem subSystem5 = new AS_SubSystem("4442");
        subSystem5.setSortNo(777);

        workflowDomManager.insert(subSystem5);

        AS_SubSystem subSystem6 = new AS_SubSystem("5555");
        subSystem6.setSortNo(777);

        workflowDomManager.insert(subSystem6);

        AS_SubSystem subSystem7 = new AS_SubSystem("6666");
        subSystem7.setSortNo(777);

        workflowDomManager.insert(subSystem7);

        AS_SubSystem subSystem8 = new AS_SubSystem("7777");
        subSystem8.setSortNo(777);

        workflowDomManager.insert(subSystem8);

        AS_SubSystem subSystem9 = new AS_SubSystem("8888");
        subSystem9.setSortNo(777);

        workflowDomManager.insert(subSystem9);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void noResult1(){

        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean = workflowDomManager
                .getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(jimutetuzukicd2,workflowTskId2);

        int iCount = 0;
        for (JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean : jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean) {
            iCount++;

        }
        Assert.assertEquals(0,iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean = workflowDomManager
                .getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(jimutetuzukicd1,workflowTskId1);

        int iCount = 0;
        for (JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean : jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean) {
            iCount++;
            if (iCount == 1) {

                Assert.assertEquals("111", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("1111", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals("1111", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("111", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("123", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals("1111", bean.getAS_SubSystem().getSubSystemId());
            }
        }
        Assert.assertEquals(1,iCount);

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean = workflowDomManager
                .getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(jimutetuzukicd3,workflowTskId3);

        int iCount = 0;
        for (JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean : jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean) {
            iCount++;
            if (iCount == 1) {

                Assert.assertEquals("666", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("8888", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(77, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("8888", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("666", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("121", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(17, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("8888", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(777, bean.getAS_SubSystem().getSortNo().intValue());
            }

            if (iCount == 2) {

                Assert.assertEquals("666", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("7777", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(77, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("7777", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("666", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("121", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(18, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("7777", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(777, bean.getAS_SubSystem().getSortNo().intValue());
            }

            if (iCount == 3) {

                Assert.assertEquals("666", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("6666", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(77, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("6666", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("666", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("121", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(19, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("6666", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(777, bean.getAS_SubSystem().getSortNo().intValue());
            }

            if (iCount == 4) {

                Assert.assertEquals("666", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("5555", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(88, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("5555", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("666", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("121", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(17, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("5555", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(777, bean.getAS_SubSystem().getSortNo().intValue());
            }

            if (iCount == 5) {

                Assert.assertEquals("666", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("4442", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(99, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("4442", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("666", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("343", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(19, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("4442", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(777, bean.getAS_SubSystem().getSortNo().intValue());
            }

            if (iCount == 6) {

                Assert.assertEquals("555", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("4441", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(77, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("4441", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("555", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("232", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(19, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("4441", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(888, bean.getAS_SubSystem().getSortNo().intValue());
            }

            if (iCount == 7) {

                Assert.assertEquals("444", bean.getDM_Jimutetuzuki().getJimutetuzukicd());
                Assert.assertEquals("4444", bean.getDM_Jimutetuzuki().getSubSystemId());
                Assert.assertEquals(99, bean.getDM_Jimutetuzuki().getHyoujijyun().intValue());
                Assert.assertEquals("4444", bean.getDM_JimutetuzukiTask().getSubSystemId());
                Assert.assertEquals("444", bean.getDM_JimutetuzukiTask().getJimutetuzukicd());
                Assert.assertEquals("121", bean.getDM_JimutetuzukiTask().getWorkflowTskId());
                Assert.assertEquals(19, bean.getDM_JimutetuzukiTask().getHyoujijyun().intValue());
                Assert.assertEquals("4444", bean.getAS_SubSystem().getSubSystemId());
                Assert.assertEquals(999, bean.getAS_SubSystem().getSortNo().intValue());
            }
        }
        Assert.assertEquals(7,iCount);
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void blankCondition1(){

        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean = workflowDomManager
                .getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(jimutetuzukicdblank,workflowTskId3);

        int iCount = 0;
        for (JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean : jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean) {
            iCount++;

        }
        Assert.assertEquals(0,iCount);

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void blankCondition2(){

        List<JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean> jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean = workflowDomManager
                .getJimutetuzukiJimutetuzukiTaskSubSystemsByItems(jimutetuzukicd3,workflowTskIdblank);

        int iCount = 0;
        for (JimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean bean : jimutetuzukiJimutetuzukiTaskSubSystemsByItemsBean) {
            iCount++;

        }
        Assert.assertEquals(0,iCount);

    }

}

