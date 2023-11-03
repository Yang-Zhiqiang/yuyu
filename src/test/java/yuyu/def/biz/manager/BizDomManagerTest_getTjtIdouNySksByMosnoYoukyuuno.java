package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTjtIdouNySksByMosnoYoukyuuno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNySksByMosnoYoukyuuno {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("791112220", "A110");
        Assert.assertEquals(0, tjtIdouNySkLst.size());

        BT_TjtIdouNySk tjtIdouNySk1 = new BT_TjtIdouNySk("791112220", 100);
        tjtIdouNySk1.setYoukyuuno("A110");

        bizDomManager.insert(tjtIdouNySk1);

        BT_TjtIdouNySk tjtIdouNySk2 = new BT_TjtIdouNySk("791112238", 101);
        tjtIdouNySk2.setYoukyuuno("A110");

        bizDomManager.insert(tjtIdouNySk2);

        BT_TjtIdouNySk tjtIdouNySk3 = new BT_TjtIdouNySk("791112220", 102);
        tjtIdouNySk3.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNySk3);

        BT_TjtIdouNySk tjtIdouNySk4 = new BT_TjtIdouNySk("791112220", 103);
        tjtIdouNySk4.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNySk4);

        BT_TjtIdouNySk tjtIdouNySk5 = new BT_TjtIdouNySk("791112220", 104);
        tjtIdouNySk5.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNySk5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("791112220", "A200");
        Assert.assertEquals(0, tjtIdouNySkLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("791112220", "A110");
        Assert.assertEquals(1, tjtIdouNySkLst.size());

        Assert.assertEquals("791112220", tjtIdouNySkLst.get(0).getMosno());
        Assert.assertEquals(100, tjtIdouNySkLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals("A110", tjtIdouNySkLst.get(0).getYoukyuuno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("791112220", "A120");
        Assert.assertEquals(3, tjtIdouNySkLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("791112220",102,"A120"), "1");
        map.put($("791112220",103,"A120"), "1");
        map.put($("791112220",104,"A120"), "1");
        for(BT_TjtIdouNySk tjtIdouNySk : tjtIdouNySkLst){
            map.remove($(tjtIdouNySk.getMosno(),tjtIdouNySk.getRenno3keta().intValue(),tjtIdouNySk.getYoukyuuno()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("", "A110");
        Assert.assertEquals(0, tjtIdouNySkLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("791112220", "");
        Assert.assertEquals(0, tjtIdouNySkLst.size());

    }
}
