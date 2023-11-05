package yuyu.def.workflow.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
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
 * getJimutetuzukisByJimutetuzukicd() メソッドのテストクラスです。 */
@RunWith(OrderedRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukisByJimutetuzukicd {

    @Inject
    WorkflowDomManager workflowDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisByJimutetuzukicd("A01");

        Assert.assertEquals(0,jimutetuzukiLst.size());

        DM_Jimutetuzuki jimutetuzuki1 = new DM_Jimutetuzuki("A01", "B11");

        workflowDomManager.insert(jimutetuzuki1);

        DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki("A03", "B11");

        workflowDomManager.insert(jimutetuzuki2);

        DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki("A02", "B12");

        workflowDomManager.insert(jimutetuzuki3);

        DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki("A02", "B13");

        workflowDomManager.insert(jimutetuzuki4);

        DM_Jimutetuzuki jimutetuzuki5 = new DM_Jimutetuzuki("A02", "B14");

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

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisByJimutetuzukicd("A04");

        assertEquals(0, jimutetuzukiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisByJimutetuzukicd("A01");

        assertEquals(1, jimutetuzukiLst.size());
        assertEquals("A01", jimutetuzukiLst.get(0).getJimutetuzukicd());
        assertEquals("B11", jimutetuzukiLst.get(0).getSubSystemId());

    }

    @Test
    @TestOrder(30)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("A02","B12"),"1");
        datamap.put($("A02","B13"),"1");
        datamap.put($("A02","B14"),"1");

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisByJimutetuzukicd("A02");

        assertEquals(3, jimutetuzukiLst.size());

        datamap.remove($(jimutetuzukiLst.get(0).getJimutetuzukicd(),jimutetuzukiLst.get(0).getSubSystemId()));
        datamap.remove($(jimutetuzukiLst.get(1).getJimutetuzukicd(),jimutetuzukiLst.get(1).getSubSystemId()));
        datamap.remove($(jimutetuzukiLst.get(2).getJimutetuzukicd(),jimutetuzukiLst.get(2).getSubSystemId()));

        assertTrue(datamap.isEmpty());
        //
        //        assertEquals("A02", jimutetuzukiLst.get(0).getJimutetuzukicd());
        //        assertEquals("B12", jimutetuzukiLst.get(0).getSubSystemId());
        //
        //        assertEquals("A02", jimutetuzukiLst.get(1).getJimutetuzukicd());
        //        assertEquals("B13", jimutetuzukiLst.get(1).getSubSystemId());
        //
        //        assertEquals("A02", jimutetuzukiLst.get(2).getJimutetuzukicd());
        //        assertEquals("B14", jimutetuzukiLst.get(2).getSubSystemId());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisByJimutetuzukicd("");

        Assert.assertEquals(0,jimutetuzukiLst.size());

    }
}
