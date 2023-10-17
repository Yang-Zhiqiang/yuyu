package yuyu.def.biz.manager;

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
 * getTjtIdouNyKhMaxRenno3ketaBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyKhMaxRenno3ketaBySyono {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        Assert.assertEquals(null, bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono("10000000001"));
        BT_TjtIdouNyKh bT_TjtIdouNyKk1 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk1.setSyono("10000000001");
        bT_TjtIdouNyKk1.setRenno3keta(111);
        bizDomManager.insert(bT_TjtIdouNyKk1);

        BT_TjtIdouNyKh bT_TjtIdouNyKk2 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk2.setSyono("10000000001");
        bT_TjtIdouNyKk2.setRenno3keta(112);
        bizDomManager.insert(bT_TjtIdouNyKk2);

        BT_TjtIdouNyKh bT_TjtIdouNyKk3 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk3.setSyono("10000000001");
        bT_TjtIdouNyKk3.setRenno3keta(113);
        bizDomManager.insert(bT_TjtIdouNyKk3);

        BT_TjtIdouNyKh bT_TjtIdouNyKk4 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk4.setSyono("10000000001");
        bT_TjtIdouNyKk4.setRenno3keta(114);
        bizDomManager.insert(bT_TjtIdouNyKk4);

        BT_TjtIdouNyKh bT_TjtIdouNyKk5 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk5.setSyono("10000000002");
        bT_TjtIdouNyKk5.setRenno3keta(115);
        bizDomManager.insert(bT_TjtIdouNyKk5);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @Transactional
    public void noResult1() {
        Integer result = bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono("10000000003");
        Assert.assertNull(result);
    }

    @Test
    @TestOrder(40)
    public void normal1() {
        Integer result = bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono("10000000001");
        Assert.assertEquals(Integer.valueOf(114), result);
    }
    @Test
    @TestOrder(40)
    public void noResult2() {
        Integer result = bizDomManager.getTjtIdouNyKhMaxRenno3ketaBySyono("");
        Assert.assertNull(result);
    }

}