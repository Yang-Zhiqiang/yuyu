package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容年金支払テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_TjtIdouNyNk> beans =
            bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta("JCD01")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_TjtIdouNyNk bT_TjtIdouNyNk1 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk1.setNksysyno("11807111118");
        bT_TjtIdouNyNk1.setRenno3keta(111);

        bizDomManager.insert(bT_TjtIdouNyNk1);

        BT_TjtIdouNyNk bT_TjtIdouNyNk2 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk2.setNksysyno("11807111118");
        bT_TjtIdouNyNk2.setRenno3keta(222);

        bizDomManager.insert(bT_TjtIdouNyNk2);

        BT_TjtIdouNyNk bT_TjtIdouNyNk3 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk3.setNksysyno("11807111118");
        bT_TjtIdouNyNk3.setRenno3keta(333);

        bizDomManager.insert(bT_TjtIdouNyNk3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void normal10() {

        try (ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta("JCD01"))
        {

            int iCount = 0;
            Iterator<BT_TjtIdouNyNk> iter = beans.iterator();
            BT_TjtIdouNyNk tjtIdouNyNk = null;
            while (iter.hasNext()) {

                tjtIdouNyNk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("11807111118", tjtIdouNyNk.getNksysyno());
                    Assert.assertEquals(333, tjtIdouNyNk.getRenno3keta().intValue());

                    continue;
                }
            }

            Assert.assertEquals(1, iCount);

        }
    }

    @Test
    @TestOrder(11)
    @Transactional
    public void normal11() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());

        BT_TjtIdouNyNk bT_TjtIdouNyNk4 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk4.setNksysyno("11807111118");
        bT_TjtIdouNyNk4.setRenno3keta(111);

        bizDomManager.insert(bT_TjtIdouNyNk4);

        BT_TjtIdouNyNk bT_TjtIdouNyNk5 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk5.setNksysyno("11807111118");
        bT_TjtIdouNyNk5.setRenno3keta(222);

        bizDomManager.insert(bT_TjtIdouNyNk5);

        BT_TjtIdouNyNk bT_TjtIdouNyNk6 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk6.setNksysyno("11807111118");
        bT_TjtIdouNyNk6.setRenno3keta(333);

        bizDomManager.insert(bT_TjtIdouNyNk6);

        BT_TjtIdouNyNk bT_TjtIdouNyNk7 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk7.setNksysyno("11807111129");
        bT_TjtIdouNyNk7.setRenno3keta(111);

        bizDomManager.insert(bT_TjtIdouNyNk7);

        BT_TjtIdouNyNk bT_TjtIdouNyNk8 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk8.setNksysyno("11807111129");
        bT_TjtIdouNyNk8.setRenno3keta(222);

        bizDomManager.insert(bT_TjtIdouNyNk8);

        BT_TjtIdouNyNk bT_TjtIdouNyNk9 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk9.setNksysyno("11807111129");
        bT_TjtIdouNyNk9.setRenno3keta(333);

        bizDomManager.insert(bT_TjtIdouNyNk9);

        BT_TjtIdouNyNk bT_TjtIdouNyNk10 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk10.setNksysyno("11807111130");
        bT_TjtIdouNyNk10.setRenno3keta(111);

        bizDomManager.insert(bT_TjtIdouNyNk10);

        BT_TjtIdouNyNk bT_TjtIdouNyNk11 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk11.setNksysyno("11807111130");
        bT_TjtIdouNyNk11.setRenno3keta(222);

        bizDomManager.insert(bT_TjtIdouNyNk11);

        BT_TjtIdouNyNk bT_TjtIdouNyNk12 = new BT_TjtIdouNyNk();
        bT_TjtIdouNyNk12.setNksysyno("11807111130");
        bT_TjtIdouNyNk12.setRenno3keta(333);

        bizDomManager.insert(bT_TjtIdouNyNk12);
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        try (ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta("JCD01"))
        {

            int iCount = 0;
            Map<String,String> map = new HashMap<String,String>();
            map.put($("11807111118",333), "1");
            map.put($("11807111129",333), "1");
            map.put($("11807111130",333), "1");

            Iterator<BT_TjtIdouNyNk> iter = beans.iterator();
            BT_TjtIdouNyNk tjtIdouNyNk = null;
            while (iter.hasNext()) {

                tjtIdouNyNk = iter.next();
                iCount++;
                map.remove($(tjtIdouNyNk.getNksysyno(),tjtIdouNyNk.getRenno3keta().intValue()));
                continue;

            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    public void testSkippedFilter11() {

        try (ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta("RG9G")){

            int iCount = 0;
            Iterator<BT_TjtIdouNyNk> iter = beans.iterator();
            BT_TjtIdouNyNk tjtIdouNyNk = null;
            while (iter.hasNext()) {

                tjtIdouNyNk = iter.next();
                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }

    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {
        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RG9G");
        skipKey1.setTableid("BT_TjtIdouNyNk");
        skipKey1.setRecoveryfilterid("Nk001");
        skipKey1.setRecoveryfilterkey1("11807111118");

        bizDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Nk001");
        recoveryFilter1.setRecoveryfilternm("年金基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("nksysyno");

        bizDomManager.insert(recoveryFilter1);
    }
    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try (ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta("RG9G")){

            int iCount = 0;
            Iterator<BT_TjtIdouNyNk> iter = beans.iterator();
            BT_TjtIdouNyNk tjtIdouNyNk = null;
            while (iter.hasNext()) {

                tjtIdouNyNk = iter.next();
                assertNotEquals(tjtIdouNyNk.getNksysyno(), "11807111118");
                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey skipKey2 = new BT_SkipKey("A03");
        skipKey2.setKakutyoujobcd("RG9G");
        skipKey2.setTableid("BT_TjtIdouNyNk");
        skipKey2.setRecoveryfilterid("Nk001");
        skipKey2.setRecoveryfilterkey1("11807111129");

        bizDomManager.insert(skipKey2);
    }


    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try (ExDBResults<BT_TjtIdouNyNk> beans = bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta("RG9G")){

            int iCount = 0;
            Iterator<BT_TjtIdouNyNk> iter = beans.iterator();
            BT_TjtIdouNyNk tjtIdouNyNk = null;
            while (iter.hasNext()) {

                tjtIdouNyNk = iter.next();
                assertNotEquals(tjtIdouNyNk.getNksysyno(), "11807111118");
                assertNotEquals(tjtIdouNyNk.getNksysyno(), "11807111129");
                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }
    }
}
