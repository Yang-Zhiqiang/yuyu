package yuyu.def.biz.manager;

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

import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

/**
 * 当日異動内容新契約テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNySks {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<BT_TjtIdouNySk> beans = bizDomManager.getTjtIdouNySks();

        int iCount = 0;
        for (BT_TjtIdouNySk tjtIdouNySk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        BT_TjtIdouNySk bT_TjtIdouNySk1 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk1.setMosno("791112220");
        bT_TjtIdouNySk1.setRenno3keta(111);
        bizDomManager.insert(bT_TjtIdouNySk1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
    }

    @Test
    @TestOrder(20)
    public void normal10() {


        ExDBResults<BT_TjtIdouNySk> beans = bizDomManager.getTjtIdouNySks();

        int iCount = 0;
        for (BT_TjtIdouNySk tjtIdouNySk : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("791112220", tjtIdouNySk.getMosno());
                Assert.assertEquals(111, tjtIdouNySk.getRenno3keta().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }


    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());

        BT_TjtIdouNySk bT_TjtIdouNySk2 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk2.setMosno("791112410");
        bT_TjtIdouNySk2.setRenno3keta(222);
        bizDomManager.insert(bT_TjtIdouNySk2);

        BT_TjtIdouNySk bT_TjtIdouNySk3 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk3.setMosno("791112410");
        bT_TjtIdouNySk3.setRenno3keta(333);
        bizDomManager.insert(bT_TjtIdouNySk3);

        BT_TjtIdouNySk bT_TjtIdouNySk4 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk4.setMosno("791112410");
        bT_TjtIdouNySk4.setRenno3keta(444);
        bizDomManager.insert(bT_TjtIdouNySk4);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<BT_TjtIdouNySk> beans = bizDomManager.getTjtIdouNySks();

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("791112410",222), "1");
        map.put($("791112410",333), "1");
        map.put($("791112410",444), "1");
        for (BT_TjtIdouNySk tjtIdouNySk : beans) {
            iCount++;
            map.remove($(tjtIdouNySk.getMosno(),tjtIdouNySk.getRenno3keta().intValue()));

        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

}

