package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

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
 * getSyoriCTLsByKakutyoujobcdSeisekiym() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdSeisekiym {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    private static String P_JOB_CD_01 = "RBN1";
    private static String P_FILTER_ID = "Sk001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201602"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSeisekiym(BizDateYM.valueOf(201602));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.valueOf("2"));

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setSeisekiym(BizDateYM.valueOf(201602));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setSeisekiym(BizDateYM.valueOf(201603));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112352");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon6 = syoriCTL5.createMosKihon();
        mosKihon6.setSeisekiym(BizDateYM.valueOf(201505));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112345");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon5 = syoriCTL6.createMosKihon();
        mosKihon5.setSeisekiym(BizDateYM.valueOf(201505));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112337");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.valueOf("3"));

        HT_MosKihon mosKihon4 = syoriCTL7.createMosKihon();
        mosKihon4.setSeisekiym(BizDateYM.valueOf(201505));

        sinkeiyakuDomManager.insert(syoriCTL7);

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

        ExDBResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201402"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;
        }

        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        ExDBResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201602"));

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
    public void normal2() {

        ExDBResults<HT_SyoriCTL> syoriCTEx = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201505"));

        int iCount = 0;
        for (HT_SyoriCTL hT_SyoriCTL : syoriCTEx) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("791112337", hT_SyoriCTL.getMosno());

            }

            if (2 == iCount) {

                Assert.assertEquals("791112345", hT_SyoriCTL.getMosno());

            }

            if (3 == iCount) {

                Assert.assertEquals("791112352", hT_SyoriCTL.getMosno());

            }

        }
        Assert.assertEquals(3, iCount);
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
        try(ExDBResults<HT_SyoriCTL>  syoriCTEx =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201505"))){
            for(HT_SyoriCTL hT_SyoriCTL : syoriCTEx){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("mosno");
        filter.setRecoveryfilternm("申込番号フィルタ");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key4 = new BT_SkipKey("A04");
        key4.setRecoveryfilterid(P_FILTER_ID);
        key4.setKakutyoujobcd(P_JOB_CD_01);
        key4.setRecoveryfilterkey1("791112337");
        key4.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key4);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL>  syoriCTEx =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201505"))){
            for(HT_SyoriCTL hT_SyoriCTL : syoriCTEx){
                assertNotEquals(hT_SyoriCTL.getMosno(), "791112337");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testSkippedFilter70(){
        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_01);
        key3.setRecoveryfilterkey1("791112345");
        key3.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key3);

    }

    @Test
    @TestOrder(71)
    public void testSkippedFilter71(){

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL>  syoriCTEx =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(P_JOB_CD_01, BizDateYM.valueOf("201505"))){
            for(HT_SyoriCTL hT_SyoriCTL : syoriCTEx){
                assertNotEquals(hT_SyoriCTL.getMosno(), "791112337");
                assertNotEquals(hT_SyoriCTL.getMosno(), "791112345");

                iCount++;
            }
            assertEquals(1, iCount);

        }
    }
}
