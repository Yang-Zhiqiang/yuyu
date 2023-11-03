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

import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTjtIdouNyKhsBySyonoYoukyuuno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyKhsBySyonoYoukyuuno {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("11807111118", "A110");
        Assert.assertEquals(0, tjtIdouNyKhLst.size());


        BT_TjtIdouNyKh tjtIdouNyKh1 = new BT_TjtIdouNyKh("11807111118", 100);
        tjtIdouNyKh1.setYoukyuuno("A110");

        bizDomManager.insert(tjtIdouNyKh1);

        BT_TjtIdouNyKh tjtIdouNyKh2 = new BT_TjtIdouNyKh("11807111129", 101);
        tjtIdouNyKh2.setYoukyuuno("A110");

        bizDomManager.insert(tjtIdouNyKh2);

        BT_TjtIdouNyKh tjtIdouNyKh3 = new BT_TjtIdouNyKh("11807111118", 102);
        tjtIdouNyKh3.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNyKh3);

        BT_TjtIdouNyKh tjtIdouNyKh4 = new BT_TjtIdouNyKh("11807111118", 103);
        tjtIdouNyKh4.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNyKh4);

        BT_TjtIdouNyKh tjtIdouNyKh5 = new BT_TjtIdouNyKh("11807111118", 104);
        tjtIdouNyKh5.setYoukyuuno("A120");

        bizDomManager.insert(tjtIdouNyKh5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("11807111118", "A200");
        Assert.assertEquals(0, tjtIdouNyKhLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("11807111118", "A110");
        Assert.assertEquals(1, tjtIdouNyKhLst.size());

        Assert.assertEquals("11807111118", tjtIdouNyKhLst.get(0).getSyono());
        Assert.assertEquals(100, tjtIdouNyKhLst.get(0).getRenno3keta().intValue());
        Assert.assertEquals("A110", tjtIdouNyKhLst.get(0).getYoukyuuno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("11807111118", "A120");
        Assert.assertEquals(3, tjtIdouNyKhLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("11807111118",102,"A120"), "1");
        map.put($("11807111118",103,"A120"), "1");
        map.put($("11807111118",104,"A120"), "1");

        for(BT_TjtIdouNyKh tjtIdouNyKh : tjtIdouNyKhLst){
            map.remove($(tjtIdouNyKh.getSyono(),tjtIdouNyKh.getRenno3keta().intValue(),tjtIdouNyKh.getYoukyuuno()));
        }
        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("", "A110");
        Assert.assertEquals(0, tjtIdouNyKhLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("11807111118", "");
        Assert.assertEquals(0, tjtIdouNyKhLst.size());

    }
}
