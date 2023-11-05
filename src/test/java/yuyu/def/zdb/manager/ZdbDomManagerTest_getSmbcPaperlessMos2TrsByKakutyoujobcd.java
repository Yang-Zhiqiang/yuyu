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
import yuyu.def.db.entity.ZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos2Tr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ZdbDomManagerクラスの、<br />
 * getSmbcPaperlessMos2TrsByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getSmbcPaperlessMos2TrsByKakutyoujobcd {

    @Inject
    ZdbDomManager zdbDomManager;/** 業務共通Domマネージャー */
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        try (ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr1 = new ZT_SmbcPaperlessMos2Tr("02", "100001", "1", 101);
        smbcPaperlessMos2Tr1.setZtrseihowebtkiyougyoutaikbn("1");
        smbcPaperlessMos2Tr1.setZtrseihowebplmosnoc("000000000");

        zdbDomManager.insert(smbcPaperlessMos2Tr1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_SmbcPaperlessMos2Tr qZT_SmbcPaperlessMos2Tr = new QZT_SmbcPaperlessMos2Tr("qZT_SmbcPaperlessMos2Tr");
        String jpql1 = $DELETE_FROM(qZT_SmbcPaperlessMos2Tr) ;
        em.createJPQL(jpql1).bind(qZT_SmbcPaperlessMos2Tr).executeUpdate();

        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult10() {

        try (ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(11)
    @Transactional
    public void noResult11() {

        zdbDomManager.delete(zdbDomManager.getSmbcPaperlessMos2Tr("02", "100001", "1", 101));

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr1 = new ZT_SmbcPaperlessMos2Tr("01", "100001", "1", 101);
        smbcPaperlessMos2Tr1.setZtrseihowebtkiyougyoutaikbn("2");
        smbcPaperlessMos2Tr1.setZtrseihowebplmosnoc("000000001");

        zdbDomManager.insert(smbcPaperlessMos2Tr1);

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr2 = new ZT_SmbcPaperlessMos2Tr("01", "100001", "1", 102);
        smbcPaperlessMos2Tr2.setZtrseihowebtkiyougyoutaikbn("5");
        smbcPaperlessMos2Tr2.setZtrseihowebplmosnoc("000000001");

        zdbDomManager.insert(smbcPaperlessMos2Tr2);

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr3 = new ZT_SmbcPaperlessMos2Tr("01", "100001", "1", 103);
        smbcPaperlessMos2Tr3.setZtrseihowebtkiyougyoutaikbn("2");
        smbcPaperlessMos2Tr3.setZtrseihowebplmosnoc("000000000");

        zdbDomManager.insert(smbcPaperlessMos2Tr3);

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr4 = new ZT_SmbcPaperlessMos2Tr("02", "100001", "1", 104);
        smbcPaperlessMos2Tr4.setZtrseihowebtkiyougyoutaikbn("1");
        smbcPaperlessMos2Tr4.setZtrseihowebplmosnoc("000000001");

        zdbDomManager.insert(smbcPaperlessMos2Tr4);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2");

        int iCount = 0;
        for (ZT_SmbcPaperlessMos2Tr SmbcPaperlessMos2Tr : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("01", SmbcPaperlessMos2Tr.getZtrseihowebidkbn());
                Assert.assertEquals("100001", SmbcPaperlessMos2Tr.getZtrseihowebkojincd());
                Assert.assertEquals("1", SmbcPaperlessMos2Tr.getZtrseihowebitijihozonhyouji());
                Assert.assertEquals(101, SmbcPaperlessMos2Tr.getZtrseihowebseknoc().intValue());
            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        zdbDomManager.delete(zdbDomManager.getSmbcPaperlessMos2Tr("01", "100001", "1", 101));
        zdbDomManager.delete(zdbDomManager.getSmbcPaperlessMos2Tr("01", "100001", "1", 102));
        zdbDomManager.delete(zdbDomManager.getSmbcPaperlessMos2Tr("01", "100001", "1", 103));
        zdbDomManager.delete(zdbDomManager.getSmbcPaperlessMos2Tr("02", "100001", "1", 104));

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr1 = new ZT_SmbcPaperlessMos2Tr("01", "100001", "1", 101);
        smbcPaperlessMos2Tr1.setZtrseihowebtkiyougyoutaikbn("2");
        smbcPaperlessMos2Tr1.setZtrseihowebplmosnoc("000000001");

        zdbDomManager.insert(smbcPaperlessMos2Tr1);

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr2 = new ZT_SmbcPaperlessMos2Tr("01", "100001", "1", 102);
        smbcPaperlessMos2Tr2.setZtrseihowebtkiyougyoutaikbn("3");
        smbcPaperlessMos2Tr2.setZtrseihowebplmosnoc("000000002");

        zdbDomManager.insert(smbcPaperlessMos2Tr2);

        ZT_SmbcPaperlessMos2Tr smbcPaperlessMos2Tr3 = new ZT_SmbcPaperlessMos2Tr("05", "100001", "1", 103);
        smbcPaperlessMos2Tr3.setZtrseihowebtkiyougyoutaikbn("4");
        smbcPaperlessMos2Tr3.setZtrseihowebplmosnoc("000000003");

        zdbDomManager.insert(smbcPaperlessMos2Tr3);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        Map<String,String> smbcPaperlessMos2TrMap = new HashMap<String, String>();
        smbcPaperlessMos2TrMap.put($("01","100001","1",101),"1");
        smbcPaperlessMos2TrMap.put($("01","100001","1",102),"1");
        smbcPaperlessMos2TrMap.put($("05","100001","1",103),"1");

        ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2");

        int iCount = 0;
        for (ZT_SmbcPaperlessMos2Tr SmbcPaperlessMos2Tr : beans) {
            iCount++;
            smbcPaperlessMos2TrMap.remove($(SmbcPaperlessMos2Tr.getZtrseihowebidkbn(),SmbcPaperlessMos2Tr.getZtrseihowebkojincd(),
                SmbcPaperlessMos2Tr.getZtrseihowebitijihozonhyouji(),SmbcPaperlessMos2Tr.getZtrseihowebseknoc().intValue()));
        }
        Assert.assertEquals(3, iCount);
        assertTrue(smbcPaperlessMos2TrMap.isEmpty());
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

        int iCount = 0;
        try(ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2")){
            for (ZT_SmbcPaperlessMos2Tr SmbcPaperlessMos2Tr : beans) {
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk005");
        filter.setRecoveryfilternm("生保Ｗｅｂ募集情報フィルタ");
        filter.setRecoveryfilterkeykmid1("ztrseihowebidkbn");
        filter.setRecoveryfilterkeykmid2("ztrseihowebkojincd");
        filter.setRecoveryfilterkeykmid3("ztrseihowebitijihozonhyouji");
        filter.setRecoveryfilterkeykmid4("ztrseihowebseknoc");
        zdbDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid("Sk005");
        key3.setKakutyoujobcd("RSC2");
        key3.setRecoveryfilterkey2("100001");
        key3.setRecoveryfilterkey1("05");
        key3.setRecoveryfilterkey3("1");
        key3.setRecoveryfilterkey4("103");
        key3.setTableid("ZT_SmbcPaperlessMos2Tr");
        zdbDomManager.insert(key3);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try(ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2")){

            int iCount = 0;
            Iterator<ZT_SmbcPaperlessMos2Tr> iter = beans.iterator();
            ZT_SmbcPaperlessMos2Tr SmbcPaperlessMos2Tr = null;
            while (iter.hasNext()) {

                SmbcPaperlessMos2Tr = iter.next();

                boolean result1 = (SmbcPaperlessMos2Tr.getZtrseihowebidkbn().equals("05")) &&
                    (SmbcPaperlessMos2Tr.getZtrseihowebkojincd().equals("100001"))&&
                    (SmbcPaperlessMos2Tr.getZtrseihowebitijihozonhyouji().equals("1"))&&
                    (SmbcPaperlessMos2Tr.getZtrseihowebseknoc().equals(103));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid("Sk005");
        key1.setKakutyoujobcd("RSC2");
        key1.setRecoveryfilterkey2("100001");
        key1.setRecoveryfilterkey1("01");
        key1.setRecoveryfilterkey3("1");
        key1.setRecoveryfilterkey4("102");
        key1.setTableid("ZT_SmbcPaperlessMos2Tr");
        zdbDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){

        try(ExDBResults<ZT_SmbcPaperlessMos2Tr> beans =
            zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd("RSC2")){

            int iCount = 0;
            Iterator<ZT_SmbcPaperlessMos2Tr> iter = beans.iterator();
            ZT_SmbcPaperlessMos2Tr SmbcPaperlessMos2Tr = null;
            while (iter.hasNext()) {

                SmbcPaperlessMos2Tr = iter.next();

                boolean result1 = (SmbcPaperlessMos2Tr.getZtrseihowebidkbn().equals("05")) &&
                    (SmbcPaperlessMos2Tr.getZtrseihowebkojincd().equals("100001"))&&
                    (SmbcPaperlessMos2Tr.getZtrseihowebitijihozonhyouji().equals("1"))&&
                    (SmbcPaperlessMos2Tr.getZtrseihowebseknoc().equals(103));

                boolean result2 = (SmbcPaperlessMos2Tr.getZtrseihowebidkbn().equals("01")) &&
                    (SmbcPaperlessMos2Tr.getZtrseihowebkojincd().equals("100001"))&&
                    (SmbcPaperlessMos2Tr.getZtrseihowebitijihozonhyouji().equals("1"))&&
                    (SmbcPaperlessMos2Tr.getZtrseihowebseknoc().equals(102));

                assertFalse(result1);
                assertFalse(result2);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
