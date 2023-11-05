package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsByKakutyoujobcdSrsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdSrsyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd("RBA0", BizDate.valueOf(20160215))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.valueOf("1"));
        syoriCTL1.setSrsyoriymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.valueOf("2"));
        syoriCTL2.setSrsyoriymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.valueOf("1"));
        syoriCTL3.setSrsyoriymd(BizDate.valueOf(20160214));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112261");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.valueOf("1"));
        syoriCTL4.setSrsyoriymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112253");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.valueOf("1"));
        syoriCTL5.setSrsyoriymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.valueOf("1"));
        syoriCTL6.setSrsyoriymd(BizDate.valueOf(20160220));

        sinkeiyakuDomManager.insert(syoriCTL6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd("RBA0", BizDate.valueOf(20160216))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {


        ExDBUpdatableResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd("RBA0",
            BizDate.valueOf(20160215));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", syoriCTL.getMosno());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBUpdatableResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd("RBA0",
            BizDate.valueOf(20160220));
        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112253", syoriCTL.getMosno());
            }

            if (2 == iCount) {
                Assert.assertEquals("791112261", syoriCTL.getMosno());
            }

            if (3 == iCount) {
                Assert.assertEquals("791112279", syoriCTL.getMosno());
            }
        }
        Assert.assertEquals(3, iCount);
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        int iCount = 0;
        try(ExDBUpdatableResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd(
            "RBA0", BizDate.valueOf(20160220));){
            for (HT_SyoriCTL syoriCTL : beans) {
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk001");
        filter.setRecoveryfilterkeykmid1("mosno");
        filter.setRecoveryfilternm("申込番号フィルタ");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid("Sk001");
        key3.setKakutyoujobcd("RBA0");
        key3.setRecoveryfilterkey1("791112279");
        key3.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key3);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBUpdatableResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd(
            "RBA0", BizDate.valueOf(20160220));){
            for(HT_SyoriCTL syoriCTL : beans){
                assertNotEquals(syoriCTL.getMosno(), "791112279");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid("Sk001");
        key1.setKakutyoujobcd("RBA0");
        key1.setRecoveryfilterkey1("791112261");
        key1.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBUpdatableResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSrsyoriymd(
            "RBA0", BizDate.valueOf(20160220));){
            for(HT_SyoriCTL syoriCTL : beans){
                assertNotEquals(syoriCTL.getMosno(), "791112261");
                assertNotEquals(syoriCTL.getMosno(), "791112279");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}


