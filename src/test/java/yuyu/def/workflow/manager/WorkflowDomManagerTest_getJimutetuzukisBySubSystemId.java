package yuyu.def.workflow.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
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

/**
 * WorkflowDomManagerクラスの、<br />
 * getJimutetuzukisBySubSystemId() メソッドのテストクラスです。 */
@RunWith(SWAKTestRunner.class)
public class WorkflowDomManagerTest_getJimutetuzukisBySubSystemId {

    @Inject
    WorkflowDomManager workflowDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);


        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemId("hozen");

        Assert.assertEquals(0,jimutetuzukiLst.size());

        jimutetuzukiLst =  workflowDomManager.getAllJimutetuzuki();

        if (jimutetuzukiLst.size() == 0) {
            DM_Jimutetuzuki jimutetuzuki = new DM_Jimutetuzuki();
            jimutetuzuki.setJimutetuzukicd("A01");
            jimutetuzuki.setSubSystemId("hozen");
            workflowDomManager.insert(jimutetuzuki);


            DM_Jimutetuzuki jimutetuzuki3 = new DM_Jimutetuzuki();
            jimutetuzuki3.setJimutetuzukicd("A02");
            jimutetuzuki3.setSubSystemId("hozen");

            workflowDomManager.insert(jimutetuzuki3);

            DM_Jimutetuzuki jimutetuzuki4 = new DM_Jimutetuzuki();
            jimutetuzuki4.setJimutetuzukicd("A03");
            jimutetuzuki4.setSubSystemId("hozen");

            workflowDomManager.insert(jimutetuzuki4);

            DM_Jimutetuzuki jimutetuzuki2 = new DM_Jimutetuzuki();
            jimutetuzuki2.setJimutetuzukicd("A01");
            jimutetuzuki2.setSubSystemId("biz");

            workflowDomManager.insert(jimutetuzuki2);
        }



    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());
    }

    @Test
    @Transactional
    public void noResult1(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemId("skei");

        assertEquals(0, jimutetuzukiLst.size());

    }

    @Test
    public void normal1(){

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemId("biz");

        assertEquals(1, jimutetuzukiLst.size());
        assertEquals("biz", jimutetuzukiLst.get(0).getSubSystemId());
        assertEquals("A01", jimutetuzukiLst.get(0).getJimutetuzukicd());
    }

    @Test
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("hozen", "A01"),"1");
        datamap.put($("hozen", "A02"),"1");
        datamap.put($("hozen", "A03"),"1");

        List<DM_Jimutetuzuki> jimutetuzukiLst = workflowDomManager.getJimutetuzukisBySubSystemId("hozen");

        assertEquals(3, jimutetuzukiLst.size());
        datamap.remove($(jimutetuzukiLst.get(0).getSubSystemId(),jimutetuzukiLst.get(0).getJimutetuzukicd()));
        datamap.remove($(jimutetuzukiLst.get(1).getSubSystemId(),jimutetuzukiLst.get(1).getJimutetuzukicd()));
        datamap.remove($(jimutetuzukiLst.get(2).getSubSystemId(),jimutetuzukiLst.get(2).getJimutetuzukicd()));

        assertTrue(datamap.isEmpty());

        //        assertEquals("hozen", jimutetuzukiLst.get(0).getSubSystemId());
        //        assertEquals("A01", jimutetuzukiLst.get(0).getJimutetuzukicd());
        //
        //        assertEquals("hozen", jimutetuzukiLst.get(1).getSubSystemId());
        //        assertEquals("A02", jimutetuzukiLst.get(1).getJimutetuzukicd());
        //
        //        assertEquals("hozen", jimutetuzukiLst.get(2).getSubSystemId());
        //        assertEquals("A03", jimutetuzukiLst.get(2).getJimutetuzukicd());
    }
}
