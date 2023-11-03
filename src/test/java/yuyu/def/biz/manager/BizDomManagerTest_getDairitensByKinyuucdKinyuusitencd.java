package yuyu.def.biz.manager;

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

import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDairitensByKinyuucdKinyuusitencd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDairitensByKinyuucdKinyuusitencd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucdKinyuusitencd("cd01", "sd01");

        Assert.assertEquals(0, dairitenLst.size());

        BM_Dairiten dairiten1 = new BM_Dairiten();
        dairiten1.setDrtencd("A001");
        dairiten1.setKinyuucd("cd01");
        dairiten1.setKinyuusitencd("sd01");
        bizDomManager.insert(dairiten1);

        BM_Dairiten dairiten2 = new BM_Dairiten();
        dairiten2.setDrtencd("A002");
        dairiten2.setKinyuucd("cd01");
        dairiten2.setKinyuusitencd("sd01");
        bizDomManager.insert(dairiten2);

        BM_Dairiten dairiten3 = new BM_Dairiten();
        dairiten3.setDrtencd("A003");
        dairiten3.setKinyuucd("cd01");
        dairiten3.setKinyuusitencd("sd01");
        bizDomManager.insert(dairiten3);

        BM_Dairiten dairiten4 = new BM_Dairiten();
        dairiten4.setDrtencd("A004");
        dairiten4.setKinyuucd("cd02");
        dairiten4.setKinyuusitencd("sd01");
        bizDomManager.insert(dairiten4);

        BM_Dairiten dairiten5 = new BM_Dairiten();
        dairiten5.setDrtencd("A005");
        dairiten5.setKinyuucd("cd01");
        dairiten5.setKinyuusitencd("sd02");
        bizDomManager.insert(dairiten5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucdKinyuusitencd("cd02", "sd02");

        assertEquals(0, dairitenLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucdKinyuusitencd("cd01", "sd02");

        assertEquals(1, dairitenLst.size());
        assertEquals("A005", dairitenLst.get(0).getDrtencd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucdKinyuusitencd("cd01", "sd01");

        assertEquals(3, dairitenLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("A001"), "1");
        map.put($("A002"), "1");
        map.put($("A003"), "1");

        assertTrue(map.containsKey($(dairitenLst.get(0).getDrtencd())));
        assertTrue(map.containsKey($(dairitenLst.get(1).getDrtencd())));
        assertTrue(map.containsKey($(dairitenLst.get(2).getDrtencd())));

        map.remove($(dairitenLst.get(0).getDrtencd()));
        map.remove($(dairitenLst.get(1).getDrtencd()));
        map.remove($(dairitenLst.get(2).getDrtencd()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucdKinyuusitencd("", "sd02");

        assertEquals(0, dairitenLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucdKinyuusitencd("cd02", "");

        assertEquals(0, dairitenLst.size());

    }
}
