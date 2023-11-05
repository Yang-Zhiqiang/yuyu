package yuyu.def.zdb.manager;

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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.ZT_GknyknmeisaiTr;
import yuyu.def.db.meta.QZT_GknyknmeisaiTr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd {

    @Inject
    ZdbDomManager zdbDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        try (ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("JCD01","20160224")){

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_GknyknmeisaiTr gknyknmeisaiTr1 = new ZT_GknyknmeisaiTr();
        gknyknmeisaiTr1.setZtrsakuseiymd("20160220");
        gknyknmeisaiTr1.setZtrrenrakuymd("20160220");
        gknyknmeisaiTr1.setZtrrenrakukaisuu("1");
        gknyknmeisaiTr1.setZtrbankcd("1");
        gknyknmeisaiTr1.setZtrshitencd("1");
        gknyknmeisaiTr1.setZtryokinkbn("1");
        gknyknmeisaiTr1.setZtrkouzano("1");
        gknyknmeisaiTr1.setZtrzndktuukasyu("1");
        gknyknmeisaiTr1.setZtrsyorino1("1");
        zdbDomManager.insert(gknyknmeisaiTr1);

        ZT_GknyknmeisaiTr gknyknmeisaiTr2 = new ZT_GknyknmeisaiTr();
        gknyknmeisaiTr2.setZtrsakuseiymd("20160223");
        gknyknmeisaiTr2.setZtrrenrakuymd("20160223");
        gknyknmeisaiTr2.setZtrrenrakukaisuu("2");
        gknyknmeisaiTr2.setZtrbankcd("2");
        gknyknmeisaiTr2.setZtrshitencd("2");
        gknyknmeisaiTr2.setZtryokinkbn("2");
        gknyknmeisaiTr2.setZtrkouzano("2");
        gknyknmeisaiTr2.setZtrzndktuukasyu("2");
        gknyknmeisaiTr2.setZtrsyorino1("2");
        zdbDomManager.insert(gknyknmeisaiTr2);

        ZT_GknyknmeisaiTr gknyknmeisaiTr3 = new ZT_GknyknmeisaiTr();
        gknyknmeisaiTr3.setZtrsakuseiymd("20160224");
        gknyknmeisaiTr3.setZtrrenrakuymd("20160224");
        gknyknmeisaiTr3.setZtrrenrakukaisuu("3");
        gknyknmeisaiTr3.setZtrbankcd("3");
        gknyknmeisaiTr3.setZtrshitencd("3");
        gknyknmeisaiTr3.setZtryokinkbn("3");
        gknyknmeisaiTr3.setZtrkouzano("3");
        gknyknmeisaiTr3.setZtrzndktuukasyu("3");
        gknyknmeisaiTr3.setZtrsyorino1("3");
        zdbDomManager.insert(gknyknmeisaiTr3);

        ZT_GknyknmeisaiTr gknyknmeisaiTr4 = new ZT_GknyknmeisaiTr();
        gknyknmeisaiTr4.setZtrsakuseiymd("20160224");
        gknyknmeisaiTr4.setZtrrenrakuymd("20160224");
        gknyknmeisaiTr4.setZtrrenrakukaisuu("4");
        gknyknmeisaiTr4.setZtrbankcd("4");
        gknyknmeisaiTr4.setZtrshitencd("4");
        gknyknmeisaiTr4.setZtryokinkbn("4");
        gknyknmeisaiTr4.setZtrkouzano("4");
        gknyknmeisaiTr4.setZtrzndktuukasyu("4");
        gknyknmeisaiTr4.setZtrsyorino1("4");
        zdbDomManager.insert(gknyknmeisaiTr4);

        ZT_GknyknmeisaiTr gknyknmeisaiTr5 = new ZT_GknyknmeisaiTr();
        gknyknmeisaiTr5.setZtrsakuseiymd("20160224");
        gknyknmeisaiTr5.setZtrrenrakuymd("20160224");
        gknyknmeisaiTr5.setZtrrenrakukaisuu("5");
        gknyknmeisaiTr5.setZtrbankcd("5");
        gknyknmeisaiTr5.setZtrshitencd("5");
        gknyknmeisaiTr5.setZtryokinkbn("5");
        gknyknmeisaiTr5.setZtrkouzano("5");
        gknyknmeisaiTr5.setZtrzndktuukasyu("5");
        gknyknmeisaiTr5.setZtrsyorino1("5");
        zdbDomManager.insert(gknyknmeisaiTr5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_GknyknmeisaiTr qZT_GknyknmeisaiTr = new QZT_GknyknmeisaiTr("qZT_GknyknmeisaiTr");
        String jpql1 = $DELETE_FROM(qZT_GknyknmeisaiTr) ;
        em.createJPQL(jpql1).bind(qZT_GknyknmeisaiTr).executeUpdate();

        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("JCD01","20150220");){

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("JCD01","20160220");){

            int iCount = 0;
            Iterator<ZT_GknyknmeisaiTr> iter = beans.iterator();
            ZT_GknyknmeisaiTr zT_GknyknmeisaiTr = null;
            while (iter.hasNext()) {
                zT_GknyknmeisaiTr = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("20160220", zT_GknyknmeisaiTr.getZtrsakuseiymd());
                    Assert.assertEquals("1", zT_GknyknmeisaiTr.getZtrbankcd());
                    Assert.assertEquals("1", zT_GknyknmeisaiTr.getZtrshitencd());
                    Assert.assertEquals("1", zT_GknyknmeisaiTr.getZtrsyorino1());
                }
            }
            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("JCD01","20160224")){

            int iCount = 0;
            Iterator<ZT_GknyknmeisaiTr> iter = beans.iterator();
            ZT_GknyknmeisaiTr zT_GknyknmeisaiTr = null;

            Map<String,String> map = new HashMap<String,String>();
            map.put($("20160224","3","3","3"), "1");
            map.put($("20160224","4","4","4"), "1");
            map.put($("20160224","5","5","5"), "1");
            while (iter.hasNext()) {
                zT_GknyknmeisaiTr = iter.next();
                iCount++;
                if (1 == iCount) {
                    map.remove($(zT_GknyknmeisaiTr.getZtrsakuseiymd(),zT_GknyknmeisaiTr.getZtrbankcd(),zT_GknyknmeisaiTr.getZtrshitencd(),zT_GknyknmeisaiTr.getZtrsyorino1()));
                }
                if (2 == iCount) {
                    map.remove($(zT_GknyknmeisaiTr.getZtrsakuseiymd(),zT_GknyknmeisaiTr.getZtrbankcd(),zT_GknyknmeisaiTr.getZtrshitencd(),zT_GknyknmeisaiTr.getZtrsyorino1()));
                }
                if (3 == iCount) {
                    map.remove($(zT_GknyknmeisaiTr.getZtrsakuseiymd(),zT_GknyknmeisaiTr.getZtrbankcd(),zT_GknyknmeisaiTr.getZtrshitencd(),zT_GknyknmeisaiTr.getZtrsyorino1()));
                }
            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }

    }

    @Test
    @TestOrder(40)
    public void blank() {

        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("", "")){

            int iCount = 0;
            for (ZT_GknyknmeisaiTr gknyknmeisaiTr : beans) {
                if(gknyknmeisaiTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(51)
    public void testSkippedFilter11() {

        int iCount = 0;
        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("RGAL","20160224")){
            for(ZT_GknyknmeisaiTr gknyknmeisaiTr : beans){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(52)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Bz104");
        filter.setRecoveryfilternm("外貨入出金明細フィルタ（取）");
        filter.setRecoveryfilterkeykmid1("ztrsakuseiymd");
        filter.setRecoveryfilterkeykmid2("ztrbankcd");
        zdbDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("900001");
        key3.setRecoveryfilterid("Bz104");
        key3.setTableid("ZT_GknyknmeisaiTr");
        key3.setKakutyoujobcd("RGAL");
        key3.setRecoveryfilterkey1("20160224");
        key3.setRecoveryfilterkey2("3");

        zdbDomManager.insert(key3);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("RGAL","20160224")){
            for(ZT_GknyknmeisaiTr gknyknmeisaiTr : beans){
                assertNotEquals(gknyknmeisaiTr.getZtrbankcd(), "3");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(62)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey key1 = new BT_SkipKey("900002");
        key1.setRecoveryfilterid("Bz104");
        key1.setKakutyoujobcd("RGAL");
        key1.setRecoveryfilterkey1("20160224");
        key1.setRecoveryfilterkey2("4");
        key1.setTableid("ZT_GknyknmeisaiTr");
        zdbDomManager.insert(key1);

    }

    @Test
    @TestOrder(70)
    public void testSkippedFilter3(){

        int iCount = 0;
        try(ExDBResults<ZT_GknyknmeisaiTr> beans = zdbDomManager.
            getGknyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd("RGAL","20160224")){
            for(ZT_GknyknmeisaiTr gknyknmeisaiTr : beans){
                assertNotEquals(gknyknmeisaiTr.getZtrbankcd(), "3");
                assertNotEquals(gknyknmeisaiTr.getZtrbankcd(), "4");

                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }

    }
}
