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
import yuyu.def.db.entity.ZT_SmbcBosTr;
import yuyu.def.db.meta.QZT_SmbcBosTr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ZdbDomManagerクラスの、<br />
 * getSmbcBosTrsByKakutyoujobcdItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getSmbcBosTrsByKakutyoujobcdItems {

    @Inject
    ZdbDomManager zdbDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        try (ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "20161016", "20161018")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_SmbcBosTr smbcBosTr1 = new ZT_SmbcBosTr("01", "100001", "a", 111);
        smbcBosTr1.setZtrseihowebmosno("1");
        smbcBosTr1.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr1.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr1.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr1);

        ZT_SmbcBosTr smbcBosTr2 = new ZT_SmbcBosTr("01", "100001", "b", 111);
        smbcBosTr2.setZtrseihowebmosno("1");
        smbcBosTr2.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr2.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr2.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr2);

        ZT_SmbcBosTr smbcBosTr3 = new ZT_SmbcBosTr("01", "100001", "a", 112);
        smbcBosTr3.setZtrseihowebmosno("1");
        smbcBosTr3.setZtrseihowebmosprtzmhyj("w");
        smbcBosTr3.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr3.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr3);

        ZT_SmbcBosTr smbcBosTr4 = new ZT_SmbcBosTr("01", "100001", "a", 113);
        smbcBosTr4.setZtrseihowebmosno("1");
        smbcBosTr4.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr4.setZtrseihowebfstmossksymd("20161016");
        smbcBosTr4.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr4);

        ZT_SmbcBosTr smbcBosTr5 = new ZT_SmbcBosTr("01", "100001", "a", 114);
        smbcBosTr5.setZtrseihowebmosno("1");
        smbcBosTr5.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr5.setZtrseihowebfstmossksymd("20161015");
        smbcBosTr5.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr5);

        ZT_SmbcBosTr smbcBosTr6 = new ZT_SmbcBosTr("01", "100001", "a", 115);
        smbcBosTr6.setZtrseihowebmosno("1");
        smbcBosTr6.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr6.setZtrseihowebfstmossksymd("20161019");
        smbcBosTr6.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr6);

        ZT_SmbcBosTr smbcBosTr7 = new ZT_SmbcBosTr("02", "100001", "a", 111);
        smbcBosTr7.setZtrseihowebmosno("1");
        smbcBosTr7.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr7.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr7.setZtrseihowebtkiyougyoutaikbn("1");

        zdbDomManager.insert(smbcBosTr7);

        ZT_SmbcBosTr smbcBosTr8 = new ZT_SmbcBosTr("02", "100001", "a", 112);
        smbcBosTr8.setZtrseihowebmosno("1");
        smbcBosTr8.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr8.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr8.setZtrseihowebtkiyougyoutaikbn("6");

        zdbDomManager.insert(smbcBosTr8);

        ZT_SmbcBosTr smbcBosTr9 = new ZT_SmbcBosTr("02", "100001", "a", 113);
        smbcBosTr9.setZtrseihowebmosno("1");
        smbcBosTr9.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr9.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr9.setZtrseihowebtkiyougyoutaikbn("D");

        zdbDomManager.insert(smbcBosTr9);

        ZT_SmbcBosTr smbcBosTr10 = new ZT_SmbcBosTr("02", "100001", "a", 114);
        smbcBosTr10.setZtrseihowebmosno("1");
        smbcBosTr10.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr10.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr10.setZtrseihowebtkiyougyoutaikbn("E");

        zdbDomManager.insert(smbcBosTr10);

        ZT_SmbcBosTr smbcBosTr11 = new ZT_SmbcBosTr("01", "100001", "a", 116);
        smbcBosTr11.setZtrseihowebmosno("1");
        smbcBosTr11.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr11.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr11.setZtrseihowebtkiyougyoutaikbn("5");

        zdbDomManager.insert(smbcBosTr11);

        ZT_SmbcBosTr smbcBosTr12 = new ZT_SmbcBosTr("01", "100001", "a", 117);
        smbcBosTr12.setZtrseihowebmosno("0");
        smbcBosTr12.setZtrseihowebmosprtzmhyj("q");
        smbcBosTr12.setZtrseihowebfstmossksymd("20161017");
        smbcBosTr12.setZtrseihowebtkiyougyoutaikbn("4");

        zdbDomManager.insert(smbcBosTr12);

        ZT_SmbcBosTr smbcBosTr13 = new ZT_SmbcBosTr("05", "100002", "c", 201);
        smbcBosTr13.setZtrseihowebmosno("2");
        smbcBosTr13.setZtrseihowebmosprtzmhyj("e");
        smbcBosTr13.setZtrseihowebfstmossksymd("20161117");
        smbcBosTr13.setZtrseihowebtkiyougyoutaikbn("2");

        zdbDomManager.insert(smbcBosTr13);

        ZT_SmbcBosTr smbcBosTr14 = new ZT_SmbcBosTr("05", "100003", "c", 202);
        smbcBosTr14.setZtrseihowebmosno("2");
        smbcBosTr14.setZtrseihowebmosprtzmhyj("e");
        smbcBosTr14.setZtrseihowebfstmossksymd("20161118");
        smbcBosTr14.setZtrseihowebtkiyougyoutaikbn("3");

        zdbDomManager.insert(smbcBosTr14);

        ZT_SmbcBosTr smbcBosTr15 = new ZT_SmbcBosTr("05", "100004", "c", 203);
        smbcBosTr15.setZtrseihowebmosno("2");
        smbcBosTr15.setZtrseihowebmosprtzmhyj("e");
        smbcBosTr15.setZtrseihowebfstmossksymd("20161119");
        smbcBosTr15.setZtrseihowebtkiyougyoutaikbn("7");

        zdbDomManager.insert(smbcBosTr15);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_SmbcBosTr qZT_SmbcBosTr = new QZT_SmbcBosTr("qZT_SmbcBosTr");
        String jpql1 = $DELETE_FROM(qZT_SmbcBosTr) ;
        em.createJPQL(jpql1).bind(qZT_SmbcBosTr).executeUpdate();

        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "b", "w", "20161016", "20161018")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "20161016", "20161018");

        int iCount = 0;
        for (ZT_SmbcBosTr SmbcBosTr : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("01", SmbcBosTr.getZtrseihowebidkbn());
                Assert.assertEquals("100001", SmbcBosTr.getZtrseihowebkojincd());
                Assert.assertEquals("a", SmbcBosTr.getZtrseihowebitijihozonhyouji());
                Assert.assertEquals(111, SmbcBosTr.getZtrseihowebsekno().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("05","100002","c",201), "1");
        map.put($("05","100003","c",202), "1");
        map.put($("05","100004","c",203), "1");
        for (ZT_SmbcBosTr SmbcBosTr : beans) {
            iCount++;

            if (1 == iCount) {
                map.remove($(SmbcBosTr.getZtrseihowebidkbn(),SmbcBosTr.getZtrseihowebkojincd(),SmbcBosTr.getZtrseihowebitijihozonhyouji(),SmbcBosTr.getZtrseihowebsekno().intValue()));
            }

            if (2 == iCount) {
                map.remove($(SmbcBosTr.getZtrseihowebidkbn(),SmbcBosTr.getZtrseihowebkojincd(),SmbcBosTr.getZtrseihowebitijihozonhyouji(),SmbcBosTr.getZtrseihowebsekno().intValue()));
            }

            if (3 == iCount) {
                map.remove($(SmbcBosTr.getZtrseihowebidkbn(),SmbcBosTr.getZtrseihowebkojincd(),SmbcBosTr.getZtrseihowebitijihozonhyouji(),SmbcBosTr.getZtrseihowebsekno().intValue()));
            }
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition1() {

        try(ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "", "q", "20161016", "20161018")){
            int iCount = 0;
            for (ZT_SmbcBosTr SmbcBosTr : beans) {
                if(SmbcBosTr != null){
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

        try(ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "a", "", "20161016", "20161018")){
            int iCount = 0;
            for (ZT_SmbcBosTr SmbcBosTr : beans) {
                if(SmbcBosTr != null){
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

        ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "", "20161018");

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("01","100001","a",111), "1");
        map.put($("01","100001","a",113), "1");
        map.put($("01","100001","a",114), "1");
        for (ZT_SmbcBosTr SmbcBosTr : beans) {
            iCount++;

            if (1 == iCount) {
                map.remove($(SmbcBosTr.getZtrseihowebidkbn(),SmbcBosTr.getZtrseihowebkojincd(),SmbcBosTr.getZtrseihowebitijihozonhyouji(),SmbcBosTr.getZtrseihowebsekno().intValue()));
            }

            if (2 == iCount) {
                map.remove($(SmbcBosTr.getZtrseihowebidkbn(),SmbcBosTr.getZtrseihowebkojincd(),SmbcBosTr.getZtrseihowebitijihozonhyouji(),SmbcBosTr.getZtrseihowebsekno().intValue()));
            }

            if (3 == iCount) {
                map.remove($(SmbcBosTr.getZtrseihowebidkbn(),SmbcBosTr.getZtrseihowebkojincd(),SmbcBosTr.getZtrseihowebitijihozonhyouji(),SmbcBosTr.getZtrseihowebsekno().intValue()));
            }
        }
        Assert.assertEquals(3, iCount);
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void blankCondition4() {

        try(ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "a", "q", "20161016", "")){
            int iCount = 0;
            for (ZT_SmbcBosTr SmbcBosTr : beans) {
                if(SmbcBosTr != null){
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
        try(ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");){
            for (ZT_SmbcBosTr SmbcBosTr : beans) {
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
        key3.setTableid("ZT_SmbcBosTr");
        zdbDomManager.insert(key3);
    }

    @Test
    @TestOrder(90)
    public void testSkippedFilter20(){

        try(ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");){

            int iCount = 0;
            Iterator<ZT_SmbcBosTr> iter = beans.iterator();
            ZT_SmbcBosTr zT_SmbcBosTr = null;
            while (iter.hasNext()) {

                zT_SmbcBosTr = iter.next();

                boolean result1 = (zT_SmbcBosTr.getZtrseihowebidkbn().equals("05")) &&
                    (zT_SmbcBosTr.getZtrseihowebkojincd().equals("100004"))&&
                    (zT_SmbcBosTr.getZtrseihowebitijihozonhyouji().equals("c"))&&
                    (zT_SmbcBosTr.getZtrseihowebsekno().equals(203));

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
        key1.setTableid("ZT_SmbcBosTr");
        zdbDomManager.insert(key1);

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testSkippedFilter3(){

        try(ExDBResults<ZT_SmbcBosTr> beans =
            zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems("RSC1", "c", "e", "20161116", "20161119");){

            int iCount = 0;
            Iterator<ZT_SmbcBosTr> iter = beans.iterator();
            ZT_SmbcBosTr zT_SmbcBosTr = null;
            while (iter.hasNext()) {

                zT_SmbcBosTr = iter.next();

                boolean result1 = (zT_SmbcBosTr.getZtrseihowebidkbn().equals("05")) &&
                    (zT_SmbcBosTr.getZtrseihowebkojincd().equals("100004"))&&
                    (zT_SmbcBosTr.getZtrseihowebitijihozonhyouji().equals("c"))&&
                    (zT_SmbcBosTr.getZtrseihowebsekno().equals(203));

                boolean result2 = (zT_SmbcBosTr.getZtrseihowebidkbn().equals("05")) &&
                    (zT_SmbcBosTr.getZtrseihowebkojincd().equals("100003"))&&
                    (zT_SmbcBosTr.getZtrseihowebitijihozonhyouji().equals("c"))&&
                    (zT_SmbcBosTr.getZtrseihowebsekno().equals(202));

                assertFalse(result1);
                assertFalse(result2);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
