package yuyu.def.workflow.manager;

import static org.junit.Assert.*;

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
 * getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd {

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


        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid1);

        Assert.assertEquals(0,jimutetuzukiLst.size());

        DM_Jimutetuzuki jimutetuzuki1 = new DM_Jimutetuzuki("A01", "sk01");
        jimutetuzuki1.setHyoujijyun(7);

        workflowDomManager.insert(jimutetuzuki1);

        DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("A02", "sk07");
        jimutetuzuki2.setHyoujijyun(1);

        workflowDomManager.insert(jimutetuzuki2);

        DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("A03", "sk01");
        jimutetuzuki3.setHyoujijyun(4);
        jimutetuzuki3.setSyukouteijimutetuzukicd("1101");

        workflowDomManager.insert(jimutetuzuki3);

        DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("A03", "sk02");
        jimutetuzuki4.setSyukouteijimutetuzukicd("");
        jimutetuzuki4.setHyoujijyun(4);

        workflowDomManager.insert(jimutetuzuki4);

        DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki("A04", "sk03");
        jimutetuzuki5.setHyoujijyun(3);

        workflowDomManager.insert(jimutetuzuki5);

        DM_Jimutetuzuki jimutetuzuki6 = new DM_Jimutetuzuki("A05", "sk04");
        jimutetuzuki6.setHyoujijyun(2);

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

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid2);

        assertEquals(0, jimutetuzukiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid3);

        assertEquals(1, jimutetuzukiLst.size());
        assertEquals("A05", jimutetuzukiLst.get(0).getJimutetuzukicd());
        assertEquals("sk04", jimutetuzukiLst.get(0).getSubSystemId());
        assertEquals("2", jimutetuzukiLst.get(0).getHyoujijyun().toString());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid1);

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

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(dSyukouteikanriid4);
        Assert.assertEquals(0, jimutetuzukiLst.size());
    }
}
