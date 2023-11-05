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
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入出金明細テーブル（取）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta {
    @Inject
    ZdbDomManager zdbDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);


        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("JCD01","201501")){

            Assert.assertFalse(beans.iterator().hasNext());

        }

        ZT_NyknmeisaiTr zT_NyknmeisaiTr1 = new ZT_NyknmeisaiTr();
        zT_NyknmeisaiTr1.setZtrsakuseiymd6keta("201501");
        zT_NyknmeisaiTr1.setZtrbankcd("1101");
        zT_NyknmeisaiTr1.setZtrshitencd("112");
        zT_NyknmeisaiTr1.setZtryokinkbn("1");
        zT_NyknmeisaiTr1.setZtrkouzano("1");
        zT_NyknmeisaiTr1.setZtrrenno8("11111111");
        zT_NyknmeisaiTr1.setZtrsyoukaino("10012002");

        zdbDomManager.insert(zT_NyknmeisaiTr1);

        ZT_NyknmeisaiTr zT_NyknmeisaiTr2 = new ZT_NyknmeisaiTr();
        zT_NyknmeisaiTr2.setZtrsakuseiymd6keta("200808");
        zT_NyknmeisaiTr2.setZtrbankcd("1101");
        zT_NyknmeisaiTr2.setZtrshitencd("112");
        zT_NyknmeisaiTr2.setZtryokinkbn("2");
        zT_NyknmeisaiTr2.setZtrkouzano("2");
        zT_NyknmeisaiTr2.setZtrrenno8("22222222");
        zT_NyknmeisaiTr2.setZtrsyoukaino("10012002");

        zdbDomManager.insert(zT_NyknmeisaiTr2);

        ZT_NyknmeisaiTr zT_NyknmeisaiTr3 = new ZT_NyknmeisaiTr();
        zT_NyknmeisaiTr3.setZtrsakuseiymd6keta("201404");
        zT_NyknmeisaiTr3.setZtrbankcd("2002");
        zT_NyknmeisaiTr3.setZtrshitencd("111");
        zT_NyknmeisaiTr3.setZtryokinkbn("3");
        zT_NyknmeisaiTr3.setZtrkouzano("3");
        zT_NyknmeisaiTr3.setZtrrenno8("33333333");
        zT_NyknmeisaiTr3.setZtrsyoukaino("20011101");

        zdbDomManager.insert(zT_NyknmeisaiTr3);

        ZT_NyknmeisaiTr zT_NyknmeisaiTr4 = new ZT_NyknmeisaiTr();
        zT_NyknmeisaiTr4.setZtrsakuseiymd6keta("201404");
        zT_NyknmeisaiTr4.setZtrbankcd("2003");
        zT_NyknmeisaiTr4.setZtrshitencd("111");
        zT_NyknmeisaiTr4.setZtryokinkbn("4");
        zT_NyknmeisaiTr4.setZtrkouzano("4");
        zT_NyknmeisaiTr4.setZtrrenno8("44444444");
        zT_NyknmeisaiTr4.setZtrsyoukaino("20011101");

        zdbDomManager.insert(zT_NyknmeisaiTr4);

        ZT_NyknmeisaiTr zT_NyknmeisaiTr5 = new ZT_NyknmeisaiTr();
        zT_NyknmeisaiTr5.setZtrsakuseiymd6keta("201404");
        zT_NyknmeisaiTr5.setZtrbankcd("2004");
        zT_NyknmeisaiTr5.setZtrshitencd("111");
        zT_NyknmeisaiTr5.setZtryokinkbn("5");
        zT_NyknmeisaiTr5.setZtrkouzano("5");
        zT_NyknmeisaiTr5.setZtrrenno8("55555555");
        zT_NyknmeisaiTr5.setZtrsyoukaino("20011101");

        zdbDomManager.insert(zT_NyknmeisaiTr5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_NyknmeisaiTr qZT_NyknmeisaiTr = new QZT_NyknmeisaiTr("qZT_NyknmeisaiTr");
        String jpql1 = $DELETE_FROM(qZT_NyknmeisaiTr) ;
        em.createJPQL(jpql1).bind(qZT_NyknmeisaiTr).executeUpdate();

        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.
            getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("JCD01","200410");){

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.
            getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("JCD01","201501");){

            int iCount = 0;
            Iterator<ZT_NyknmeisaiTr> iter = beans.iterator();
            ZT_NyknmeisaiTr zT_NyknmeisaiTr = null;
            while (iter.hasNext()) {
                zT_NyknmeisaiTr = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("201501", zT_NyknmeisaiTr.getZtrsakuseiymd6keta());
                    Assert.assertEquals("1101", zT_NyknmeisaiTr.getZtrbankcd());
                    Assert.assertEquals("112", zT_NyknmeisaiTr.getZtrshitencd());
                    Assert.assertEquals("10012002",zT_NyknmeisaiTr.getZtrsyoukaino());
                }
            }
            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.
            getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("JCD01","201404");){

            int iCount = 0;
            Iterator<ZT_NyknmeisaiTr> iter = beans.iterator();
            ZT_NyknmeisaiTr zT_NyknmeisaiTr = null;
            Map<String,String> map = new HashMap<String,String>();
            map.put($("201404","2002","111","20011101"), "1");
            map.put($("201404","2003","111","20011101"), "1");
            map.put($("201404","2004","111","20011101"), "1");
            while (iter.hasNext()) {

                zT_NyknmeisaiTr = iter.next();
                iCount++;

                if (1 == iCount) {
                    map.remove($(zT_NyknmeisaiTr.getZtrsakuseiymd6keta(),zT_NyknmeisaiTr.getZtrbankcd(),zT_NyknmeisaiTr.getZtrshitencd(),zT_NyknmeisaiTr.getZtrsyoukaino()));
                }

                if (2 == iCount) {
                    map.remove($(zT_NyknmeisaiTr.getZtrsakuseiymd6keta(),zT_NyknmeisaiTr.getZtrbankcd(),zT_NyknmeisaiTr.getZtrshitencd(),zT_NyknmeisaiTr.getZtrsyoukaino()));
                }

                if (3 == iCount) {
                    map.remove($(zT_NyknmeisaiTr.getZtrsakuseiymd6keta(),zT_NyknmeisaiTr.getZtrbankcd(),zT_NyknmeisaiTr.getZtrshitencd(),zT_NyknmeisaiTr.getZtrsyoukaino()));
                }
            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }

    }

    @Test
    @TestOrder(40)
    public void blank() {

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.
            getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("JCD01", "");){

            int iCount = 0;
            for (ZT_NyknmeisaiTr nyknmeisaiTr : beans) {
                if(nyknmeisaiTr != null){
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

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("RGAJ", "201404");){

            int iCount = 0;
            Iterator<ZT_NyknmeisaiTr> iter = beans.iterator();
            ZT_NyknmeisaiTr zT_NyknmeisaiTr = null;
            while (iter.hasNext()) {

                zT_NyknmeisaiTr = iter.next();
                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(52)
    @Transactional
    public void testSkippedFilter12() {
        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RGAJ");
        skipKey1.setTableid("ZT_NyknmeisaiTr");
        skipKey1.setRecoveryfilterid("Bz103");
        skipKey1.setRecoveryfilterkey1("201404");
        skipKey1.setRecoveryfilterkey2("2002");

        zdbDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz103");
        recoveryFilter1.setRecoveryfilternm("入出金明細フィルタ（取）");
        recoveryFilter1.setRecoveryfilterkeykmid1("ztrsakuseiymd6keta");
        recoveryFilter1.setRecoveryfilterkeykmid2("ztrbankcd");

        zdbDomManager.insert(recoveryFilter1);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter20(){

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("RGAJ", "201404");){

            int iCount = 0;
            Iterator<ZT_NyknmeisaiTr> iter = beans.iterator();
            ZT_NyknmeisaiTr zT_NyknmeisaiTr = null;
            while (iter.hasNext()) {

                zT_NyknmeisaiTr = iter.next();
                assertNotEquals(zT_NyknmeisaiTr.getZtrbankcd(), "2002");
                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter121() {

        BT_SkipKey skipKey2 = new BT_SkipKey("A02");
        skipKey2.setKakutyoujobcd("RGAJ");
        skipKey2.setTableid("ZT_NyknmeisaiTr");
        skipKey2.setRecoveryfilterid("Bz103");
        skipKey2.setRecoveryfilterkey1("201404");
        skipKey2.setRecoveryfilterkey2("2003");

        zdbDomManager.insert(skipKey2);
    }


    @Test
    @TestOrder(70)
    public void testSkippedFilter3(){

        try(ExDBResults<ZT_NyknmeisaiTr> beans = zdbDomManager.getNyknmeisaiTrsByKakutyoujobcdZtrsakuseiymd6keta("RGAJ", "201404");){

            int iCount = 0;
            Iterator<ZT_NyknmeisaiTr> iter = beans.iterator();
            ZT_NyknmeisaiTr zT_NyknmeisaiTr = null;
            while (iter.hasNext()) {

                zT_NyknmeisaiTr = iter.next();
                assertNotEquals(zT_NyknmeisaiTr.getZtrbankcd(), "2002");
                assertNotEquals(zT_NyknmeisaiTr.getZtrbankcd(), "2003");
                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }
    }
}

