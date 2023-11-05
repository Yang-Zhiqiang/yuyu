package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
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
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    private static String P_JOB_CD_01 = "RBN1";
    private static String P_FILTER_ID = "Sk001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(P_JOB_CD_01, BizDateYM.valueOf("201603"), BizDateYM.valueOf("201603"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSeisekiym(BizDateYM.valueOf("201602"));
        mosKihon1.setBosyuuym(BizDateYM.valueOf("201602"));

        sinkeiyakuDomManager.insert(syoriCTL1);

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
    @TestOrder(20)
    public void noResult1() {

        ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(P_JOB_CD_01, BizDateYM.valueOf("201601"), BizDateYM.valueOf("201601"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;
        }

        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(P_JOB_CD_01, BizDateYM.valueOf("201603"), BizDateYM.valueOf("201603"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("791112220", hT_SyoriCTL.getMosno());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal40() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112410");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setSeisekiym(BizDateYM.valueOf("201601"));
        mosKihon2.setBosyuuym(BizDateYM.valueOf("201601"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112311");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.ITIPMATI);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setSeisekiym(BizDateYM.valueOf("201601"));
        mosKihon3.setBosyuuym(BizDateYM.valueOf("201601"));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112444");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setSeisekiym(BizDateYM.valueOf("201602"));
        mosKihon4.setBosyuuym(BizDateYM.valueOf("201601"));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112477");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setSeisekiym(BizDateYM.valueOf("201601"));
        mosKihon5.setBosyuuym(BizDateYM.valueOf("201602"));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112238");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.NONE);

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112253");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setSeisekiym(BizDateYM.valueOf("201601"));
        mosKihon7.setBosyuuym(BizDateYM.valueOf("201601"));

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112261");
        syoriCTL8.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon8 = syoriCTL8.createMosKihon();
        mosKihon8.setSeisekiym(BizDateYM.valueOf("201602"));
        mosKihon8.setBosyuuym(BizDateYM.valueOf("201602"));

        sinkeiyakuDomManager.insert(syoriCTL8);

        HT_SyoriCTL syoriCTL9 = new HT_SyoriCTL("791112279");
        syoriCTL9.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon9 = syoriCTL9.createMosKihon();
        mosKihon9.setSeisekiym(BizDateYM.valueOf("201603"));
        mosKihon9.setBosyuuym(BizDateYM.valueOf("201603"));

        sinkeiyakuDomManager.insert(syoriCTL9);

    }

    @Test
    @TestOrder(41)
    @Transactional
    public void normal41() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112410"), "1");
        datamap.put($("791112311"), "1");
        datamap.put($("791112444"), "1");
        datamap.put($("791112477"), "1");

        ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(P_JOB_CD_01,  BizDateYM.valueOf("201602"), BizDateYM.valueOf("201602"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;

            datamap.remove($(
                hT_SyoriCTL.getMosno()));

        }
        Assert.assertEquals(4, iCount);
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(49)
    @Transactional
    public void testSkippedFilter49(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {

        int iCount = 0;
        try(ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(
                P_JOB_CD_01,  BizDateYM.valueOf("201602"), BizDateYM.valueOf("201602"));){
            for(HT_SyoriCTL hT_SyoriCTL : syoriCTEx){

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("mosno");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key4 = new BT_SkipKey("A04");
        key4.setRecoveryfilterid(P_FILTER_ID);
        key4.setKakutyoujobcd(P_JOB_CD_01);
        key4.setRecoveryfilterkey1("791112477");
        key4.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key4);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(
                P_JOB_CD_01,  BizDateYM.valueOf("201602"), BizDateYM.valueOf("201602"));){
            for(HT_SyoriCTL hT_SyoriCTL : syoriCTEx){
                assertNotEquals(hT_SyoriCTL.getMosno(), "791112477");

                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testSkippedFilter70(){
        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_01);
        key3.setRecoveryfilterkey1("791112444");
        key3.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key3);

    }

    @Test
    @TestOrder(71)
    @Transactional
    public void testSkippedFilter71(){

        int iCount = 0;
        try(ExDBUpdatableResults<HT_SyoriCTL> syoriCTEx =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(
                P_JOB_CD_01,  BizDateYM.valueOf("201602"), BizDateYM.valueOf("201602"));){
            for(HT_SyoriCTL hT_SyoriCTL : syoriCTEx){
                assertNotEquals(hT_SyoriCTL.getMosno(), "791112477");
                assertNotEquals(hT_SyoriCTL.getMosno(), "791112444");

                iCount++;
            }
            assertEquals(2, iCount);

        }
    }
}
