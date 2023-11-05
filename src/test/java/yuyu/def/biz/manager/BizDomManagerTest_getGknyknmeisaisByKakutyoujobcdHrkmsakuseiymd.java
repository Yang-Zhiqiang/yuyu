package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 外貨入出金明細テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("JCD01", "20160225")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_Gknyknmeisai bT_Gknyknmeisai1 = new BT_Gknyknmeisai();
        bT_Gknyknmeisai1.setHrkmrenrakuymd("20160902");
        bT_Gknyknmeisai1.setHrkmrenrakukaisuu("1");
        bT_Gknyknmeisai1.setHrkmyokinkbn("2");
        bT_Gknyknmeisai1.setHrkmkouzano("3");
        bT_Gknyknmeisai1.setHrkmzndktuukasyu("4");
        bT_Gknyknmeisai1.setHrkmsakuseiymd("20160225");
        bT_Gknyknmeisai1.setHrkmbankcd("1111");
        bT_Gknyknmeisai1.setHrkmshitencd("111");
        bT_Gknyknmeisai1.setHrkmsyorino1("11111111");
        bizDomManager.insert(bT_Gknyknmeisai1);

        BT_Gknyknmeisai bT_Gknyknmeisai2 = new BT_Gknyknmeisai();
        bT_Gknyknmeisai2.setHrkmrenrakuymd("20160902");
        bT_Gknyknmeisai2.setHrkmrenrakukaisuu("1");
        bT_Gknyknmeisai2.setHrkmyokinkbn("2");
        bT_Gknyknmeisai2.setHrkmkouzano("3");
        bT_Gknyknmeisai2.setHrkmzndktuukasyu("4");
        bT_Gknyknmeisai2.setHrkmsakuseiymd("20160222");
        bT_Gknyknmeisai2.setHrkmbankcd("2222");
        bT_Gknyknmeisai2.setHrkmshitencd("222");
        bT_Gknyknmeisai2.setHrkmsyorino1("11111112");
        bizDomManager.insert(bT_Gknyknmeisai2);

        BT_Gknyknmeisai bT_Gknyknmeisai3 = new BT_Gknyknmeisai();
        bT_Gknyknmeisai3.setHrkmrenrakuymd("20160902");
        bT_Gknyknmeisai3.setHrkmrenrakukaisuu("1");
        bT_Gknyknmeisai3.setHrkmyokinkbn("2");
        bT_Gknyknmeisai3.setHrkmkouzano("3");
        bT_Gknyknmeisai3.setHrkmzndktuukasyu("4");
        bT_Gknyknmeisai3.setHrkmsakuseiymd("20160222");
        bT_Gknyknmeisai3.setHrkmbankcd("3333");
        bT_Gknyknmeisai3.setHrkmshitencd("333");
        bT_Gknyknmeisai3.setHrkmsyorino1("11111113");
        bizDomManager.insert(bT_Gknyknmeisai3);

        BT_Gknyknmeisai bT_Gknyknmeisai4 = new BT_Gknyknmeisai();
        bT_Gknyknmeisai4.setHrkmrenrakuymd("20160902");
        bT_Gknyknmeisai4.setHrkmrenrakukaisuu("1");
        bT_Gknyknmeisai4.setHrkmyokinkbn("2");
        bT_Gknyknmeisai4.setHrkmkouzano("3");
        bT_Gknyknmeisai4.setHrkmzndktuukasyu("4");
        bT_Gknyknmeisai4.setHrkmsakuseiymd("20160222");
        bT_Gknyknmeisai4.setHrkmbankcd("4444");
        bT_Gknyknmeisai4.setHrkmshitencd("444");
        bT_Gknyknmeisai4.setHrkmsyorino1("11111114");
        bizDomManager.insert(bT_Gknyknmeisai4);

        BT_Gknyknmeisai bT_Gknyknmeisai5 = new BT_Gknyknmeisai();
        bT_Gknyknmeisai5.setHrkmrenrakuymd("20160902");
        bT_Gknyknmeisai5.setHrkmrenrakukaisuu("1");
        bT_Gknyknmeisai5.setHrkmyokinkbn("2");
        bT_Gknyknmeisai5.setHrkmkouzano("3");
        bT_Gknyknmeisai5.setHrkmzndktuukasyu("4");
        bT_Gknyknmeisai5.setHrkmsakuseiymd("22222226");
        bT_Gknyknmeisai5.setHrkmbankcd("5555");
        bT_Gknyknmeisai5.setHrkmshitencd("555");
        bT_Gknyknmeisai5.setHrkmsyorino1("11111115");
        bizDomManager.insert(bT_Gknyknmeisai5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGknyknmeisai());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("JCD01","20121111")){

            Assert.assertFalse(beans.iterator().hasNext());

        }

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("JCD01","20160225")){

            int iCount = 0;
            Iterator<BT_Gknyknmeisai> iter = beans.iterator();
            BT_Gknyknmeisai bT_Gknyknmeisai=null;

            while (iter.hasNext()) {
                bT_Gknyknmeisai=iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("20160225", bT_Gknyknmeisai.getHrkmsakuseiymd());
                    Assert.assertEquals("1111", bT_Gknyknmeisai.getHrkmbankcd());
                    Assert.assertEquals("111", bT_Gknyknmeisai.getHrkmshitencd());
                    Assert.assertEquals("11111111", bT_Gknyknmeisai.getHrkmsyorino1());

                }
            }
            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("JCD01","20160222")){

            int iCount = 0;
            Iterator<BT_Gknyknmeisai> iter = beans.iterator();
            BT_Gknyknmeisai bT_Gknyknmeisai=null;
            Map<String,String> map = new HashMap<String,String>();
            map.put($("20160222","2222","222","11111112"), "1");
            map.put($("20160222","3333","333","11111113"), "1");
            map.put($("20160222","4444","444","11111114"), "1");

            while (iter.hasNext()) {
                bT_Gknyknmeisai=iter.next();
                iCount++;

                if (1 == iCount) {
                    assertTrue(map.containsKey($(bT_Gknyknmeisai.getHrkmsakuseiymd(), bT_Gknyknmeisai.getHrkmbankcd(), bT_Gknyknmeisai.getHrkmshitencd(), bT_Gknyknmeisai.getHrkmsyorino1())));
                    map.remove($(bT_Gknyknmeisai.getHrkmsakuseiymd(), bT_Gknyknmeisai.getHrkmbankcd(), bT_Gknyknmeisai.getHrkmshitencd(), bT_Gknyknmeisai.getHrkmsyorino1()));

                    continue;

                }

                if (2 == iCount) {
                    assertTrue(map.containsKey($(bT_Gknyknmeisai.getHrkmsakuseiymd(), bT_Gknyknmeisai.getHrkmbankcd(), bT_Gknyknmeisai.getHrkmshitencd(), bT_Gknyknmeisai.getHrkmsyorino1())));
                    map.remove($(bT_Gknyknmeisai.getHrkmsakuseiymd(), bT_Gknyknmeisai.getHrkmbankcd(), bT_Gknyknmeisai.getHrkmshitencd(), bT_Gknyknmeisai.getHrkmsyorino1()));

                    continue;
                }

                if (3 == iCount) {
                    assertTrue(map.containsKey($(bT_Gknyknmeisai.getHrkmsakuseiymd(), bT_Gknyknmeisai.getHrkmbankcd(), bT_Gknyknmeisai.getHrkmshitencd(), bT_Gknyknmeisai.getHrkmsyorino1())));
                    map.remove($(bT_Gknyknmeisai.getHrkmsakuseiymd(), bT_Gknyknmeisai.getHrkmbankcd(), bT_Gknyknmeisai.getHrkmshitencd(), bT_Gknyknmeisai.getHrkmsyorino1()));

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    public void blank() {

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("JCD01","")){

            Assert.assertFalse(beans.iterator().hasNext());
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
    @Transactional
    public void testSkippedFilter11() {

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("RGAM","20160222")){

            int iCount = 0;
            Iterator<BT_Gknyknmeisai> iter = beans.iterator();
            BT_Gknyknmeisai bT_Gknyknmeisai=null;
            while (iter.hasNext()) {
                bT_Gknyknmeisai=iter.next();
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
        skipKey1.setKakutyoujobcd("RGAM");
        skipKey1.setTableid("BT_Gknyknmeisai");
        skipKey1.setRecoveryfilterid("Bz102");
        skipKey1.setRecoveryfilterkey1("20160222");
        skipKey1.setRecoveryfilterkey2("2222");

        bizDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz102");
        recoveryFilter1.setRecoveryfilternm("外貨入出金明細フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("hrkmsakuseiymd");
        recoveryFilter1.setRecoveryfilterkeykmid2("hrkmbankcd");

        bizDomManager.insert(recoveryFilter1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("RGAM","20160222")){

            int iCount = 0;
            Iterator<BT_Gknyknmeisai> iter = beans.iterator();
            BT_Gknyknmeisai bT_Gknyknmeisai=null;
            while (iter.hasNext()) {
                bT_Gknyknmeisai=iter.next();
                assertNotEquals(bT_Gknyknmeisai.getHrkmbankcd(), "2222");
                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey key1 = new BT_SkipKey("A02");
        key1.setRecoveryfilterid("Bz102");
        key1.setKakutyoujobcd("RGAM");
        key1.setRecoveryfilterkey1("20160222");
        key1.setRecoveryfilterkey2("3333");
        key1.setTableid("BT_Gknyknmeisai");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try(ExDBResults<BT_Gknyknmeisai> beans = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd("RGAM","20160222")){

            int iCount = 0;
            Iterator<BT_Gknyknmeisai> iter = beans.iterator();
            BT_Gknyknmeisai bT_Gknyknmeisai=null;
            while (iter.hasNext()) {
                bT_Gknyknmeisai=iter.next();
                assertNotEquals(bT_Gknyknmeisai.getHrkmbankcd(), "2222");
                assertNotEquals(bT_Gknyknmeisai.getHrkmbankcd(), "3333");
                iCount++;
            }
            assertEquals(1, iCount);
        }
    }

}

