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

import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getMosnoKanrisByKakutyoujobcdMossykykyoteiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMosnoKanrisByKakutyoujobcdMossykykyoteiymd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_MosnoKanri> mosnoKanri =
            sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH", BizDate.valueOf(20160213))) {

            Assert.assertFalse(mosnoKanri.iterator().hasNext());
        }

        HT_MosnoKanri mosnoKanri1 = new HT_MosnoKanri("10000001");
        mosnoKanri1.setSaibankahikbn(C_KahiKbn.valueOf("0"));
        mosnoKanri1.setMossykykyoteiymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(mosnoKanri1);

        HT_MosnoKanri mosnoKanri2 = new HT_MosnoKanri("10000002");
        mosnoKanri2.setSaibankahikbn(C_KahiKbn.valueOf("1"));
        mosnoKanri2.setMossykykyoteiymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(mosnoKanri2);

        HT_MosnoKanri mosnoKanri3 = new HT_MosnoKanri("10000003");
        mosnoKanri3.setSaibankahikbn(C_KahiKbn.valueOf("0"));
        mosnoKanri3.setMossykykyoteiymd(BizDate.valueOf(20160216));

        sinkeiyakuDomManager.insert(mosnoKanri3);

        HT_MosnoKanri mosnoKanri4 = new HT_MosnoKanri("10000005");
        mosnoKanri4.setSaibankahikbn(C_KahiKbn.valueOf("0"));
        mosnoKanri4.setMossykykyoteiymd(BizDate.valueOf(20160214));

        sinkeiyakuDomManager.insert(mosnoKanri4);

        HT_MosnoKanri mosnoKanri5 = new HT_MosnoKanri("10000004");
        mosnoKanri5.setSaibankahikbn(C_KahiKbn.valueOf("0"));
        mosnoKanri5.setMossykykyoteiymd(BizDate.valueOf(20160213));

        sinkeiyakuDomManager.insert(mosnoKanri5);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

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

        try (ExDBUpdatableResults<HT_MosnoKanri> mosnoKanri =
            sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH", BizDate.valueOf(20160212))) {

            Assert.assertFalse(mosnoKanri.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        ExDBUpdatableResults<HT_MosnoKanri> khKaiyakuWkesults = sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH",
            BizDate.valueOf(20160213));

        int iCount = 0;
        for (HT_MosnoKanri mosnoKanri : khKaiyakuWkesults) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("10000004", mosnoKanri.getMosno8keta());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBUpdatableResults<HT_MosnoKanri> khKaiyakuWkesults = sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH",
            BizDate.valueOf(20160215));

        int iCount = 0;
        for (HT_MosnoKanri mosnoKanri : khKaiyakuWkesults) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("10000001", mosnoKanri.getMosno8keta());
            }

            if (2 == iCount) {
                Assert.assertEquals("10000004", mosnoKanri.getMosno8keta());
            }

            if (3 == iCount) {
                Assert.assertEquals("10000005", mosnoKanri.getMosno8keta());
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
        try(ExDBUpdatableResults<HT_MosnoKanri> khKaiyakuWkesults = sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH",
            BizDate.valueOf(20160215));){
            for(HT_MosnoKanri mosnoKanri : khKaiyakuWkesults){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk004");
        filter.setRecoveryfilternm("申込番号（８桁）フィルタ ");
        filter.setRecoveryfilterkeykmid1("mosno8keta");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid("Sk004");
        key3.setKakutyoujobcd("RGSH");
        key3.setRecoveryfilterkey1("10000005");
        key3.setTableid("HT_MosnoKanri");
        sinkeiyakuDomManager.insert(key3);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBUpdatableResults<HT_MosnoKanri> khKaiyakuWkesults = sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH",
            BizDate.valueOf(20160215));){
            for(HT_MosnoKanri mosnoKanri : khKaiyakuWkesults){
                assertNotEquals(mosnoKanri.getMosno8keta(), "10000005");

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
        key1.setRecoveryfilterid("Sk004");
        key1.setKakutyoujobcd("RGSH");
        key1.setRecoveryfilterkey1("10000004");
        key1.setTableid("HT_MosnoKanri");
        sinkeiyakuDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBUpdatableResults<HT_MosnoKanri> khKaiyakuWkesults = sinkeiyakuDomManager.getMosnoKanrisByKakutyoujobcdMossykykyoteiymd("RGSH",
            BizDate.valueOf(20160215));){
            for(HT_MosnoKanri mosnoKanri : khKaiyakuWkesults){
                assertNotEquals(mosnoKanri.getMosno8keta(), "10000004");
                assertNotEquals(mosnoKanri.getMosno8keta(), "10000005");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}

