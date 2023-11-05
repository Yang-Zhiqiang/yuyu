package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;

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
 * getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    private static String P_JOB_CD_02 = "RHG0";
    private static String P_FILTER_ID = "Sk001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
            getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(P_KAKUTYOUJOBCD_01, BizDateYM.valueOf(201602));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setSeisekiym(BizDateYM.valueOf(201602));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.valueOf("0"));

        HT_MosKihon mosKihon2 = syoriCTL3.createMosKihon();
        mosKihon2.setSeisekiym(BizDateYM.valueOf(201602));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon3 = syoriCTL4.createMosKihon();
        mosKihon3.setSeisekiym(BizDateYM.valueOf(201601));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon4 = syoriCTL5.createMosKihon();
        mosKihon4.setSeisekiym(BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon5 = syoriCTL6.createMosKihon();
        mosKihon5.setSeisekiym(BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        HT_MosKihon mosKihon6 = syoriCTL7.createMosKihon();
        mosKihon6.setSeisekiym(BizDateYM.valueOf(201605));

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
    @TestOrder(10)
    public void noResult1() {
        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
            getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(P_KAKUTYOUJOBCD_01, BizDateYM.valueOf(201603));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
            getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(P_KAKUTYOUJOBCD_01, BizDateYM.valueOf(201602));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", syoriCTL.getMosno());

            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112261"), "1");
        datamap.put($("791112279"), "1");
        datamap.put($("791112287"), "1");

        ExDBResults<HT_SyoriCTL> beans = sinkeiyakuDomManager.
            getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(P_KAKUTYOUJOBCD_01, BizDateYM.valueOf(201605));

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : beans) {
            iCount++;

            datamap.remove($(
                syoriCTL.getMosno()));

        }
        Assert.assertEquals(3, iCount);
        Assert.assertTrue(datamap.isEmpty());
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
        try(ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(
                P_JOB_CD_02, BizDateYM.valueOf(201605));){
            for(HT_SyoriCTL syoriCTL : beans){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("mosno");
        filter.setRecoveryfilternm("申込番号フィルタ");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("791112287");
        key3.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key3);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(
                P_JOB_CD_02, BizDateYM.valueOf(201605));){
            for(HT_SyoriCTL syoriCTL : beans){
                assertNotEquals(syoriCTL.getMosno(), "791112287");

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
        key1.setRecoveryfilterid(P_FILTER_ID);
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterkey1("791112261");
        key1.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL> beans =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(
                P_JOB_CD_02, BizDateYM.valueOf(201605));){
            for(HT_SyoriCTL syoriCTL : beans){
                assertNotEquals(syoriCTL.getMosno(), "791112261");
                assertNotEquals(syoriCTL.getMosno(), "791112287");


                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}