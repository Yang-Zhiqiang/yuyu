package yuyu.def.biz.manager;

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
 * getTjtIdouNyNkMaxRenno3ketaByNksysyno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyNkMaxRenno3ketaByNksysyno {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        Assert.assertEquals(null, bizDomManager.getTjtIdouNyNkMaxRenno3ketaByNksysyno("10000000010"));
        BT_TjtIdouNyNk bT_TjtIdouNyNk1 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk1.setNksysyno("10000000010");
        bT_TjtIdouNyNk1.setRenno3keta(101);
        bizDomManager.insert(bT_TjtIdouNyNk1);

        BT_TjtIdouNyNk bT_TjtIdouNyNk2 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk2.setNksysyno("10000000010");
        bT_TjtIdouNyNk2.setRenno3keta(102);
        bizDomManager.insert(bT_TjtIdouNyNk2);

        BT_TjtIdouNyNk bT_TjtIdouNyNk3 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk3.setNksysyno("10000000010");
        bT_TjtIdouNyNk3.setRenno3keta(103);
        bizDomManager.insert(bT_TjtIdouNyNk3);

        BT_TjtIdouNyNk bT_TjtIdouNyNk4 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk4.setNksysyno("10000000010");
        bT_TjtIdouNyNk4.setRenno3keta(104);
        bizDomManager.insert(bT_TjtIdouNyNk4);

        BT_TjtIdouNyNk bT_TjtIdouNyNk5 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk5.setNksysyno("10000000011");
        bT_TjtIdouNyNk5.setRenno3keta(105);
        bizDomManager.insert(bT_TjtIdouNyNk5);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
    }

    @Test
    @Transactional
    public void noResult1() {
        Integer result = bizDomManager.getTjtIdouNyNkMaxRenno3ketaByNksysyno("10000000012");
        Assert.assertNull(result);
    }

    @Test
    @TestOrder(40)
    public void normal1() {
        Integer result = bizDomManager.getTjtIdouNyNkMaxRenno3ketaByNksysyno("10000000010");
        Assert.assertEquals(Integer.valueOf(104), result);
    }
    @Test
    @TestOrder(40)
    public void noResult2() {
        Integer result = bizDomManager.getTjtIdouNyNkMaxRenno3ketaByNksysyno("");
        Assert.assertNull(result);
    }

}
