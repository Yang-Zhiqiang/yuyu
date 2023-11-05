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

import yuyu.def.db.entity.BM_Kouin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 行員マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getKouinsBybosyuucd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("100001");
        Assert.assertEquals(0, kouinLst.size());

        BM_Kouin kouin1 = new BM_Kouin("1001", "1");
        kouin1.setBosyuucd("100001");

        bizDomManager.insert(kouin1);

        BM_Kouin kouin2 = new BM_Kouin("1001", "2");
        kouin2.setBosyuucd("100001");

        bizDomManager.insert(kouin2);

        BM_Kouin kouin3 = new BM_Kouin("1001", "3");
        kouin3.setBosyuucd("100001");

        bizDomManager.insert(kouin3);

        BM_Kouin kouin4 = new BM_Kouin("1001", "4");
        kouin4.setBosyuucd("100002");

        bizDomManager.insert(kouin4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKouin());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("100004");
        Assert.assertEquals(0, kouinLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("100002");
        Assert.assertEquals(1, kouinLst.size());
        Assert.assertEquals("1001", kouinLst.get(0).getKinyuucd());
        Assert.assertEquals("4", kouinLst.get(0).getKouincd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("100001");
        Assert.assertEquals(3, kouinLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("1001","1"), "1");
        map.put($("1001","2"), "1");
        map.put($("1001","3"), "1");

        assertTrue(map.containsKey($(kouinLst.get(0).getKinyuucd(),kouinLst.get(0).getKouincd())));
        assertTrue(map.containsKey($(kouinLst.get(1).getKinyuucd(),kouinLst.get(1).getKouincd())));
        assertTrue(map.containsKey($(kouinLst.get(2).getKinyuucd(),kouinLst.get(2).getKouincd())));

        map.remove($(kouinLst.get(0).getKinyuucd(),kouinLst.get(0).getKouincd()));
        map.remove($(kouinLst.get(1).getKinyuucd(),kouinLst.get(1).getKouincd()));
        map.remove($(kouinLst.get(2).getKinyuucd(),kouinLst.get(2).getKouincd()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("");
        Assert.assertEquals(0, kouinLst.size());
    }
}
