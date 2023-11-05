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
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.db.meta.QZT_TiginSinkinBosTr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ZdbDomManagerクラスの、<br />
 * getTiginSinkinBosTrsByKakutyoujobcdItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getTiginSinkinBosTrsByKakutyoujobcdItems {

    @Inject
    ZdbDomManager zdbDomManager;
    @Inject
    BizDomManager bizDomManager;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        try (ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "20161016", "20161018")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_TiginSinkinBosTr tiginSinkinBosTr1 = new ZT_TiginSinkinBosTr("01", "100001", "a", 111);
        tiginSinkinBosTr1.setZtrseihowebmosno("1");
        tiginSinkinBosTr1.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr1.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr1.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr1);

        ZT_TiginSinkinBosTr tiginSinkinBosTr2 = new ZT_TiginSinkinBosTr("01", "100001", "b", 111);
        tiginSinkinBosTr2.setZtrseihowebmosno("1");
        tiginSinkinBosTr2.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr2.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr2.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr2);

        ZT_TiginSinkinBosTr tiginSinkinBosTr3 = new ZT_TiginSinkinBosTr("01", "100001", "a", 112);
        tiginSinkinBosTr3.setZtrseihowebmosno("1");
        tiginSinkinBosTr3.setZtrseihowebmosprtzmhyj("w");
        tiginSinkinBosTr3.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr3.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr3);

        ZT_TiginSinkinBosTr tiginSinkinBosTr4 = new ZT_TiginSinkinBosTr("01", "100001", "a", 113);
        tiginSinkinBosTr4.setZtrseihowebmosno("1");
        tiginSinkinBosTr4.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr4.setZtrseihowebfstmossksymd("20161016");
        tiginSinkinBosTr4.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr4);

        ZT_TiginSinkinBosTr tiginSinkinBosTr5 = new ZT_TiginSinkinBosTr("01", "100001", "a", 114);
        tiginSinkinBosTr5.setZtrseihowebmosno("1");
        tiginSinkinBosTr5.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr5.setZtrseihowebfstmossksymd("20161015");
        tiginSinkinBosTr5.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr5);

        ZT_TiginSinkinBosTr tiginSinkinBosTr6 = new ZT_TiginSinkinBosTr("01", "100001", "a", 115);
        tiginSinkinBosTr6.setZtrseihowebmosno("1");
        tiginSinkinBosTr6.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr6.setZtrseihowebfstmossksymd("20161019");
        tiginSinkinBosTr6.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr6);

        ZT_TiginSinkinBosTr tiginSinkinBosTr7 = new ZT_TiginSinkinBosTr("02", "100001", "a", 111);
        tiginSinkinBosTr7.setZtrseihowebmosno("1");
        tiginSinkinBosTr7.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr7.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr7.setZtrseihowebtkiyougyoutaikbn("1");

        zdbDomManager.insert(tiginSinkinBosTr7);

        ZT_TiginSinkinBosTr tiginSinkinBosTr8 = new ZT_TiginSinkinBosTr("02", "100001", "a", 112);
        tiginSinkinBosTr8.setZtrseihowebmosno("1");
        tiginSinkinBosTr8.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr8.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr8.setZtrseihowebtkiyougyoutaikbn("6");

        zdbDomManager.insert(tiginSinkinBosTr8);

        ZT_TiginSinkinBosTr tiginSinkinBosTr9 = new ZT_TiginSinkinBosTr("02", "100001", "a", 113);
        tiginSinkinBosTr9.setZtrseihowebmosno("1");
        tiginSinkinBosTr9.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr9.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr9.setZtrseihowebtkiyougyoutaikbn("D");

        zdbDomManager.insert(tiginSinkinBosTr9);

        ZT_TiginSinkinBosTr tiginSinkinBosTr10 = new ZT_TiginSinkinBosTr("02", "100001", "a", 114);
        tiginSinkinBosTr10.setZtrseihowebmosno("1");
        tiginSinkinBosTr10.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr10.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr10.setZtrseihowebtkiyougyoutaikbn("E");

        zdbDomManager.insert(tiginSinkinBosTr10);

        ZT_TiginSinkinBosTr tiginSinkinBosTr11 = new ZT_TiginSinkinBosTr("01", "100001", "a", 116);
        tiginSinkinBosTr11.setZtrseihowebmosno("1");
        tiginSinkinBosTr11.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr11.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr11.setZtrseihowebtkiyougyoutaikbn("5");

        zdbDomManager.insert(tiginSinkinBosTr11);

        ZT_TiginSinkinBosTr tiginSinkinBosTr12 = new ZT_TiginSinkinBosTr("01", "100001", "a", 117);
        tiginSinkinBosTr12.setZtrseihowebmosno("0");
        tiginSinkinBosTr12.setZtrseihowebmosprtzmhyj("q");
        tiginSinkinBosTr12.setZtrseihowebfstmossksymd("20161017");
        tiginSinkinBosTr12.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(tiginSinkinBosTr12);

        ZT_TiginSinkinBosTr tiginSinkinBosTr13 = new ZT_TiginSinkinBosTr("05", "100002", "c", 201);
        tiginSinkinBosTr13.setZtrseihowebmosno("2");
        tiginSinkinBosTr13.setZtrseihowebmosprtzmhyj("e");
        tiginSinkinBosTr13.setZtrseihowebfstmossksymd("20161117");
        tiginSinkinBosTr13.setZtrseihowebtkiyougyoutaikbn("2");

        zdbDomManager.insert(tiginSinkinBosTr13);

        ZT_TiginSinkinBosTr tiginSinkinBosTr14 = new ZT_TiginSinkinBosTr("05", "100003", "c", 202);
        tiginSinkinBosTr14.setZtrseihowebmosno("2");
        tiginSinkinBosTr14.setZtrseihowebmosprtzmhyj("e");
        tiginSinkinBosTr14.setZtrseihowebfstmossksymd("20161118");
        tiginSinkinBosTr14.setZtrseihowebtkiyougyoutaikbn("3");

        zdbDomManager.insert(tiginSinkinBosTr14);

        ZT_TiginSinkinBosTr tiginSinkinBosTr15 = new ZT_TiginSinkinBosTr("05", "100004", "c", 203);
        tiginSinkinBosTr15.setZtrseihowebmosno("2");
        tiginSinkinBosTr15.setZtrseihowebmosprtzmhyj("e");
        tiginSinkinBosTr15.setZtrseihowebfstmossksymd("20161119");
        tiginSinkinBosTr15.setZtrseihowebtkiyougyoutaikbn("7");

        zdbDomManager.insert(tiginSinkinBosTr15);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_TiginSinkinBosTr qZT_TiginSinkinBosTr = new QZT_TiginSinkinBosTr("qZT_TiginSinkinBosTr");
        String jpql1 = $DELETE_FROM(qZT_TiginSinkinBosTr) ;
        em.createJPQL(jpql1).bind(qZT_TiginSinkinBosTr).executeUpdate();

        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "b", "w", "20161016", "20161018")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "20161016", "20161018");

        int iCount = 0;
        for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("01", TiginSinkinBosTr.getZtrseihowebidkbn());
                Assert.assertEquals("100001", TiginSinkinBosTr.getZtrseihowebkojincd());
                Assert.assertEquals("a", TiginSinkinBosTr.getZtrseihowebitijihozonhyouji());
                Assert.assertEquals(111, TiginSinkinBosTr.getZtrseihowebsekno().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("05","100002","c",201), "1");
        map.put($("05","100003","c",202), "1");
        map.put($("05","100004","c",203), "1");
        for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
            iCount++;

            if (1 == iCount) {
                map.remove($(TiginSinkinBosTr.getZtrseihowebidkbn(),TiginSinkinBosTr.getZtrseihowebkojincd(),TiginSinkinBosTr.getZtrseihowebitijihozonhyouji(),TiginSinkinBosTr.getZtrseihowebsekno().intValue()));
            }

            if (2 == iCount) {
                map.remove($(TiginSinkinBosTr.getZtrseihowebidkbn(),TiginSinkinBosTr.getZtrseihowebkojincd(),TiginSinkinBosTr.getZtrseihowebitijihozonhyouji(),TiginSinkinBosTr.getZtrseihowebsekno().intValue()));
            }

            if (3 == iCount) {
                map.remove($(TiginSinkinBosTr.getZtrseihowebidkbn(),TiginSinkinBosTr.getZtrseihowebkojincd(),TiginSinkinBosTr.getZtrseihowebitijihozonhyouji(),TiginSinkinBosTr.getZtrseihowebsekno().intValue()));
            }
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition1() {

        try(ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "", "q", "20161016", "20161018")){
            int iCount = 0;
            for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
                if(TiginSinkinBosTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void blankCondition2() {

        try(ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "a", "", "20161016", "20161018")){
            int iCount = 0;
            for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
                if(TiginSinkinBosTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void blankCondition3() {

        ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "", "20161018");

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("01","100001","a",111), "1");
        map.put($("01","100001","a",113), "1");
        map.put($("01","100001","a",114), "1");
        for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
            iCount++;

            if (1 == iCount) {
                map.remove($(TiginSinkinBosTr.getZtrseihowebidkbn(),TiginSinkinBosTr.getZtrseihowebkojincd(),TiginSinkinBosTr.getZtrseihowebitijihozonhyouji(),TiginSinkinBosTr.getZtrseihowebsekno().intValue()));
            }

            if (2 == iCount) {
                map.remove($(TiginSinkinBosTr.getZtrseihowebidkbn(),TiginSinkinBosTr.getZtrseihowebkojincd(),TiginSinkinBosTr.getZtrseihowebitijihozonhyouji(),TiginSinkinBosTr.getZtrseihowebsekno().intValue()));
            }

            if (3 == iCount) {
                map.remove($(TiginSinkinBosTr.getZtrseihowebidkbn(),TiginSinkinBosTr.getZtrseihowebkojincd(),TiginSinkinBosTr.getZtrseihowebitijihozonhyouji(),TiginSinkinBosTr.getZtrseihowebsekno().intValue()));
            }
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void blankCondition4() {

        try(ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "20161016", "")){
            int iCount = 0;
            for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
                if(TiginSinkinBosTr != null){
                    iCount++;
                }
            }
            Assert.assertEquals(0, iCount);
        }

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(81)
    public void testSkippedFilter11() {

        int iCount = 0;
        try(ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");){
            for (ZT_TiginSinkinBosTr TiginSinkinBosTr : beans) {
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(82)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk005");
        filter.setRecoveryfilternm("生保Ｗｅｂ募集情報フィルタ");
        filter.setRecoveryfilterkeykmid1("ztrseihowebidkbn");
        filter.setRecoveryfilterkeykmid2("ztrseihowebkojincd");
        filter.setRecoveryfilterkeykmid3("ztrseihowebitijihozonhyouji");
        filter.setRecoveryfilterkeykmid4("ztrseihowebsekno");
        zdbDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A01");
        key3.setRecoveryfilterid("Sk005");
        key3.setKakutyoujobcd("RSC1");
        key3.setRecoveryfilterkey2("100004");
        key3.setRecoveryfilterkey1("05");
        key3.setRecoveryfilterkey3("c");
        key3.setRecoveryfilterkey4("203");
        key3.setTableid("ZT_TiginSinkinBosTr");
        zdbDomManager.insert(key3);
    }

    @Test
    @TestOrder(90)
    public void testSkippedFilter20(){

        try(ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");){

            int iCount = 0;
            Iterator<ZT_TiginSinkinBosTr> iter = beans.iterator();
            ZT_TiginSinkinBosTr TiginSinkinBosTr = null;
            while (iter.hasNext()) {

                TiginSinkinBosTr = iter.next();

                boolean result1 = (TiginSinkinBosTr.getZtrseihowebidkbn().equals("05")) &&
                    (TiginSinkinBosTr.getZtrseihowebkojincd().equals("100004"))&&
                    (TiginSinkinBosTr.getZtrseihowebitijihozonhyouji().equals("c"))&&
                    (TiginSinkinBosTr.getZtrseihowebsekno().equals(203));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(91)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey key1 = new BT_SkipKey("A03");
        key1.setRecoveryfilterid("Sk005");
        key1.setKakutyoujobcd("RSC1");
        key1.setRecoveryfilterkey2("100003");
        key1.setRecoveryfilterkey1("05");
        key1.setRecoveryfilterkey3("c");
        key1.setRecoveryfilterkey4("202");
        key1.setTableid("ZT_TiginSinkinBosTr");
        zdbDomManager.insert(key1);

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testSkippedFilter3(){

        try(ExDBResults<ZT_TiginSinkinBosTr> beans =
            zdbDomManager.getTiginSinkinBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");){

            int iCount = 0;
            Iterator<ZT_TiginSinkinBosTr> iter = beans.iterator();
            ZT_TiginSinkinBosTr TiginSinkinBosTr = null;
            while (iter.hasNext()) {

                TiginSinkinBosTr = iter.next();

                boolean result1 = (TiginSinkinBosTr.getZtrseihowebidkbn().equals("05")) &&
                    (TiginSinkinBosTr.getZtrseihowebkojincd().equals("100004"))&&
                    (TiginSinkinBosTr.getZtrseihowebitijihozonhyouji().equals("c"))&&
                    (TiginSinkinBosTr.getZtrseihowebsekno().equals(203));

                boolean result2 = (TiginSinkinBosTr.getZtrseihowebidkbn().equals("05")) &&
                    (TiginSinkinBosTr.getZtrseihowebkojincd().equals("100003"))&&
                    (TiginSinkinBosTr.getZtrseihowebitijihozonhyouji().equals("c"))&&
                    (TiginSinkinBosTr.getZtrseihowebsekno().equals(202));

                assertFalse(result1);
                assertFalse(result2);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
