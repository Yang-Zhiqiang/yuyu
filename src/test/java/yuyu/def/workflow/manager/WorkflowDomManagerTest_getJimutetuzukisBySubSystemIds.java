package yuyu.def.workflow.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.testinfr.TestOrder;

/**
 * WorkflowDomManagerクラスの、<br />
 * getJimutetuzukisBySubSystemIds() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukisBySubSystemIds {

    @Inject
    WorkflowDomManager workflowDomManager;

    private final static String[] dSyukouteikanriid1 = {"sk01","sk02","sk03"};
    private final static String[] dSyukouteikanriid2 = {"sk05","sk06"};
    private final static String[] dSyukouteikanriid3 = {"sk04","sk06"};
    private final static String[] dSyukouteikanriid4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);


        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIds(dSyukouteikanriid1);

        Assert.assertEquals(0,jimutetuzukiLst.size());

        DM_Jimutetuzuki jimutetuzuki = new DM_Jimutetuzuki();
        jimutetuzuki.setJimutetuzukicd("A01");
        jimutetuzuki.setSubSystemId("sk01");
        jimutetuzuki.setHyoujijyun(7);
        workflowDomManager.insert(jimutetuzuki);


        DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki();
        jimutetuzuki3.setJimutetuzukicd("A03");
        jimutetuzuki3.setSubSystemId("sk02");
        jimutetuzuki3.setHyoujijyun(4);

        workflowDomManager.insert(jimutetuzuki3);

        DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki();
        jimutetuzuki4.setJimutetuzukicd("A04");
        jimutetuzuki4.setSubSystemId("sk03");
        jimutetuzuki4.setHyoujijyun(3);

        workflowDomManager.insert(jimutetuzuki4);

        DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki();
        jimutetuzuki2.setJimutetuzukicd("A05");
        jimutetuzuki2.setSubSystemId("sk04");
        jimutetuzuki2.setHyoujijyun(2);

        workflowDomManager.insert(jimutetuzuki2);

        DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki();
        jimutetuzuki5.setJimutetuzukicd("A02");
        jimutetuzuki5.setSubSystemId("sk07");
        jimutetuzuki5.setHyoujijyun(1);

        workflowDomManager.insert(jimutetuzuki5);
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

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIds(dSyukouteikanriid2);

        assertEquals(0, jimutetuzukiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIds(dSyukouteikanriid3);

        assertEquals(1, jimutetuzukiLst.size());
        assertEquals("A05", jimutetuzukiLst.get(0).getJimutetuzukicd());
        assertEquals("sk04", jimutetuzukiLst.get(0).getSubSystemId());
        assertEquals("2", jimutetuzukiLst.get(0).getHyoujijyun().toString());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIds(dSyukouteikanriid1);

        assertEquals(3, jimutetuzukiLst.size());
        assertEquals("A04", jimutetuzukiLst.get(0).getJimutetuzukicd());
        assertEquals("sk03", jimutetuzukiLst.get(0).getSubSystemId());
        assertEquals("3", jimutetuzukiLst.get(0).getHyoujijyun().toString());

        assertEquals("A03", jimutetuzukiLst.get(1).getJimutetuzukicd());
        assertEquals("sk02", jimutetuzukiLst.get(1).getSubSystemId());
        assertEquals("4", jimutetuzukiLst.get(1).getHyoujijyun().toString());

        assertEquals("A01", jimutetuzukiLst.get(2).getJimutetuzukicd());
        assertEquals("sk01", jimutetuzukiLst.get(2).getSubSystemId());
        assertEquals("7", jimutetuzukiLst.get(2).getHyoujijyun().toString());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIds(dSyukouteikanriid4);
        Assert.assertEquals(0, jimutetuzukiLst.size());
    }
}
