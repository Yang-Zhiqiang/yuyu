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

import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTjtIdouNyNksByNksysynoYoukyuuno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyNksByNksysynoYoukyuuno {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("11807111118", "A110");
        Assert.assertEquals(0, tjtIdouNyNkLst.size());

        BT_TjtIdouNyNk tjtIdouNyNk1 = new BT_TjtIdouNyNk("11807111118", 100);
        tjtIdouNyNk1.setYoukyuuno("A110");

        bizDomManager.insert(tjtIdouNyNk1);

        BT_TjtIdouNyNk tjtIdouNyNk2 = new BT_TjtIdouNyNk("11807111129", 101);
        tjtIdouNyNk2.setYoukyuuno("A110");

        bizDomManager.insert(tjtIdouNyNk2);

        BT_TjtIdouNyNk tjtIdouNyNk3 = new BT_TjtIdouNyNk("11807111118", 102);
        tjtIdouNyNk3.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNyNk3);

        BT_TjtIdouNyNk tjtIdouNyNk4 = new BT_TjtIdouNyNk("11807111118", 103);
        tjtIdouNyNk4.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNyNk4);

        BT_TjtIdouNyNk tjtIdouNyNk5 = new BT_TjtIdouNyNk("11807111118", 104);
        tjtIdouNyNk5.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNyNk5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("11807111118", "A200");
        Assert.assertEquals(0, tjtIdouNyNkLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("11807111118", "A110");
        Assert.assertEquals(1, tjtIdouNyNkLst.size());

        Assert.assertEquals("11807111118", tjtIdouNyNkLst.get(0).getNksysyno());
        Assert.assertEquals(100, tjtIdouNyNkLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals("A110", tjtIdouNyNkLst.get(0).getYoukyuuno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("11807111118", "A120");
        Assert.assertEquals(3, tjtIdouNyNkLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("11807111118",102,"A120"), "1");
        map.put($("11807111118",103,"A120"), "1");
        map.put($("11807111118",104,"A120"), "1");

        for(BT_TjtIdouNyNk tjtIdouNyNk : tjtIdouNyNkLst){
            map.remove($(tjtIdouNyNk.getNksysyno(),tjtIdouNyNk.getRenno3keta().intValue(),tjtIdouNyNk.getYoukyuuno()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("", "A110");
        Assert.assertEquals(0, tjtIdouNyNkLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("11807111118", "");
        Assert.assertEquals(0, tjtIdouNyNkLst.size());

    }
}
