package yuyu.def.biz.manager;

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
 * getTjtIdouNySkMaxRenno3ketaByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNySkMaxRenno3ketaByMosno {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        Assert.assertEquals(null, bizDomManager.getTjtIdouNySkMaxRenno3ketaByMosno("10000000010"));
        BT_TjtIdouNySk bT_TjtIdouNySk1 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk1.setMosno("10000000010");
        bT_TjtIdouNySk1.setRenno3keta(101);
        bizDomManager.insert(bT_TjtIdouNySk1);

        BT_TjtIdouNySk bT_TjtIdouNySk2 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk2.setMosno("10000000010");
        bT_TjtIdouNySk2.setRenno3keta(102);
        bizDomManager.insert(bT_TjtIdouNySk2);

        BT_TjtIdouNySk bT_TjtIdouNySk3 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk3.setMosno("10000000010");
        bT_TjtIdouNySk3.setRenno3keta(103);
        bizDomManager.insert(bT_TjtIdouNySk3);

        BT_TjtIdouNySk bT_TjtIdouNySk4 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk4.setMosno("10000000010");
        bT_TjtIdouNySk4.setRenno3keta(104);
        bizDomManager.insert(bT_TjtIdouNySk4);

        BT_TjtIdouNySk bT_TjtIdouNySk5 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk5.setMosno("10000000011");
        bT_TjtIdouNySk5.setRenno3keta(105);
        bizDomManager.insert(bT_TjtIdouNySk5);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
    }

    @Test
    @Transactional
    public void noResult1() {
        Integer result = bizDomManager.getTjtIdouNySkMaxRenno3ketaByMosno("10000000012");
        Assert.assertNull(result);
    }

    @Test
    @TestOrder(40)
    public void normal1() {
        Integer result = bizDomManager.getTjtIdouNySkMaxRenno3ketaByMosno("10000000010");
        Assert.assertEquals(Integer.valueOf(104), result);
    }
    @Test
    @TestOrder(40)
    public void noResult2() {
        Integer result = bizDomManager.getTjtIdouNySkMaxRenno3ketaByMosno("");
        Assert.assertNull(result);
    }

}