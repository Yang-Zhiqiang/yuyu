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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * WorkflowDomManagerクラスの、<br />
 * getJimutetuzukisBySubSystemIdJimutetuzukicds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukisBySubSystemIdJimutetuzukicds {

    @Inject
    WorkflowDomManager workflowDomManager;

    private final static String[] jimutetuzukicd1 = {"000001","000022"};
    private final static String[] jimutetuzukicd2 = {"000002","000022"};
    private final static String[] jimutetuzukicd3 = {"000001","000006","000011"};
    private final static String[] jimutetuzukicd4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);


        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds("0001",jimutetuzukicd1);

        Assert.assertEquals(0,jimutetuzukiList.size());

        DM_Jimutetuzuki jimutetuzuki1 = new DM_Jimutetuzuki("000001", "0001");
        jimutetuzuki1.setHyoujijyun(01);
        jimutetuzuki1.setSyukouteijimutetuzukicd("000011");

        workflowDomManager.insert(jimutetuzuki1);

        DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("000001", "0002");
        jimutetuzuki2.setHyoujijyun(01);
        jimutetuzuki2.setSyukouteijimutetuzukicd("000011");

        workflowDomManager.insert(jimutetuzuki2);

        DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("111111", "0001");
        jimutetuzuki3.setHyoujijyun(01);
        jimutetuzuki3.setSyukouteijimutetuzukicd("111100");

        workflowDomManager.insert(jimutetuzuki3);

        DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("000006", "0003");
        jimutetuzuki4.setHyoujijyun(03);
        jimutetuzuki4.setSyukouteijimutetuzukicd("000011");

        workflowDomManager.insert(jimutetuzuki4);

        DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki("000002", "0003");
        jimutetuzuki5.setHyoujijyun(02);
        jimutetuzuki5.setSyukouteijimutetuzukicd("000011");

        workflowDomManager.insert(jimutetuzuki5);

        DM_Jimutetuzuki jimutetuzuki6 = new DM_Jimutetuzuki("000001", "0003");
        jimutetuzuki6.setHyoujijyun(01);
        jimutetuzuki6.setSyukouteijimutetuzukicd("000022");

        workflowDomManager.insert(jimutetuzuki6);

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

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds("0001",jimutetuzukicd2);

        Assert.assertEquals(0,jimutetuzukiList.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds("0001",jimutetuzukicd1);

        Assert.assertEquals(1,jimutetuzukiList.size());

        Assert.assertEquals("000001",jimutetuzukiList.get(0).getJimutetuzukicd());
        Assert.assertEquals("0001",jimutetuzukiList.get(0).getSubSystemId());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds("0003",jimutetuzukicd3);

        Assert.assertEquals(3,jimutetuzukiList.size());

        Assert.assertEquals("000001",jimutetuzukiList.get(0).getJimutetuzukicd());
        Assert.assertEquals("0003",jimutetuzukiList.get(0).getSubSystemId());
        Assert.assertEquals(01,jimutetuzukiList.get(0).getHyoujijyun().intValue());

        Assert.assertEquals("000002",jimutetuzukiList.get(1).getJimutetuzukicd());
        Assert.assertEquals("0003",jimutetuzukiList.get(1).getSubSystemId());
        Assert.assertEquals(02,jimutetuzukiList.get(1).getHyoujijyun().intValue());

        Assert.assertEquals("000006",jimutetuzukiList.get(2).getJimutetuzukicd());
        Assert.assertEquals("0003",jimutetuzukiList.get(2).getSubSystemId());
        Assert.assertEquals(03,jimutetuzukiList.get(2).getHyoujijyun().intValue());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds("",jimutetuzukicd1);

        Assert.assertEquals(0,jimutetuzukiList.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2(){

        List<DM_Jimutetuzuki> jimutetuzukiList = workflowDomManager.getJimutetuzukisBySubSystemIdJimutetuzukicds("0001",jimutetuzukicd4);

        Assert.assertEquals(0,jimutetuzukiList.size());

    }
}

