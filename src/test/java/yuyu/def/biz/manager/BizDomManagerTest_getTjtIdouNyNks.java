package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容年金支払テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyNks {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNks();

        int iCount = 0;
        for (BT_TjtIdouNyNk tjtIdouNyNk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        BT_TjtIdouNyNk bT_TjtIdouNyNk1 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk1.setNksysyno("11807111130");
        bT_TjtIdouNyNk1.setRenno3keta(111);
        bizDomManager.insert(bT_TjtIdouNyNk1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
    }

    @Test
    @TestOrder(20)
    public void normal10() {


        ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNks();

        int iCount = 0;
        for (BT_TjtIdouNyNk tjtIdouNyNk : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("11807111130", tjtIdouNyNk.getNksysyno());
                Assert.assertEquals(111, tjtIdouNyNk.getRenno3keta().intValue());
            }
        }

        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());

        BT_TjtIdouNyNk bT_TjtIdouNyNk2 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk2.setNksysyno("11807111200");
        bT_TjtIdouNyNk2.setRenno3keta(222);
        bizDomManager.insert(bT_TjtIdouNyNk2);

        BT_TjtIdouNyNk bT_TjtIdouNyNk3 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk3.setNksysyno("11807111200");
        bT_TjtIdouNyNk3.setRenno3keta(333);
        bizDomManager.insert(bT_TjtIdouNyNk3);

        BT_TjtIdouNyNk bT_TjtIdouNyNk4 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk4.setNksysyno("11807111200");
        bT_TjtIdouNyNk4.setRenno3keta(444);
        bizDomManager.insert(bT_TjtIdouNyNk4);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNks();

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("11807111200",222), "1");
        map.put($("11807111200",333), "1");
        map.put($("11807111200",444), "1");

        for (BT_TjtIdouNyNk tjtIdouNyNk : beans) {
            iCount++;

            map.remove($(tjtIdouNyNk.getNksysyno(),tjtIdouNyNk.getRenno3keta().intValue()));
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

}

