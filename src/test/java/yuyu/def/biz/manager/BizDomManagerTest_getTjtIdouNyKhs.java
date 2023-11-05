package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容契約管理テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyKhs {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhs();

        int iCount = 0;
        for (BT_TjtIdouNyKh tjtIdouNyKk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        BT_TjtIdouNyKh bT_TjtIdouNyKk1 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk1.setSyono("11807111118");
        bT_TjtIdouNyKk1.setRenno3keta(111);
        bizDomManager.insert(bT_TjtIdouNyKk1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
    }

    @Test
    @TestOrder(20)
    public void normal10() {


        ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhs();

        int iCount = 0;
        for (BT_TjtIdouNyKh tjtIdouNyKk : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("11807111118", tjtIdouNyKk.getSyono());
                Assert.assertEquals(111, tjtIdouNyKk.getRenno3keta().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());

        BT_TjtIdouNyKh bT_TjtIdouNyKk2 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk2.setSyono("11807111130");
        bT_TjtIdouNyKk2.setRenno3keta(222);
        bizDomManager.insert(bT_TjtIdouNyKk2);

        BT_TjtIdouNyKh bT_TjtIdouNyKk3 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk3.setSyono("11807111130");
        bT_TjtIdouNyKk3.setRenno3keta(333);
        bizDomManager.insert(bT_TjtIdouNyKk3);

        BT_TjtIdouNyKh bT_TjtIdouNyKk4 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk4.setSyono("11807111130");
        bT_TjtIdouNyKk4.setRenno3keta(444);
        bizDomManager.insert(bT_TjtIdouNyKk4);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhs();

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("11807111130",222), "1");
        map.put($("11807111130",333), "1");
        map.put($("11807111130",444), "1");

        for (BT_TjtIdouNyKh tjtIdouNyKk : beans) {
            iCount++;

            map.remove($(tjtIdouNyKk.getSyono(),tjtIdouNyKk.getRenno3keta().intValue()));
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

}

