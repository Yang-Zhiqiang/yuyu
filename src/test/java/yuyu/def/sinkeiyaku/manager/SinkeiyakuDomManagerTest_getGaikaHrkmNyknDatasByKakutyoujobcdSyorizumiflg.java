package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import java.util.Iterator;

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

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ振分<br />
 * 外貨振込入金データテーブルエンティティリスト(大量更新)取得 処理済フラグ指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUCHOJOBCD_01 = "JCD01";
    static String P_KAKUCHOJOBCD_02 = "RBT9";
    static String P_FILTER_ID = "Sk002";
    static String NYKMOSNO_01 = "791112261";
    static String NYKMOSNO_02 = "791112352";
    static String NYKMOSNO_03 = "791112493";
    static BizDate SYORIYMD_01 = BizDate.valueOf(20160421);
    static BizDate SYORIYMD_02 = BizDate.valueOf(20160422);
    static BizDate SYORIYMD_03 = BizDate.valueOf(20160423);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, SYORIYMD_03, "IRNO1");
        gaikaHrkmNyknData1.setNykmosno(NYKMOSNO_01);
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, SYORIYMD_03, "IRNO2");
        gaikaHrkmNyknData2.setNykmosno(NYKMOSNO_03);
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, SYORIYMD_02, "IRNO3");
        gaikaHrkmNyknData3.setNykmosno(NYKMOSNO_03);
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, SYORIYMD_01, "IRNO4");
        gaikaHrkmNyknData4.setNykmosno(NYKMOSNO_03);
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, SYORIYMD_03, "IRNO5");
        gaikaHrkmNyknData5.setNykmosno(NYKMOSNO_02);
        gaikaHrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, SYORIYMD_03, "IRNO6");
        gaikaHrkmNyknData6.setNykmosno(NYKMOSNO_01);
        gaikaHrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = exDBUpdatableResults.iterator();
            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;

            while (iter.hasNext()) {

                hT_GaikaHrkmNyknData = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                Assert.assertEquals(SYORIYMD_03, hT_GaikaHrkmNyknData.getSyoriYmd());
                Assert.assertEquals("IRNO1", hT_GaikaHrkmNyknData.getItirenno());
                Assert.assertEquals(NYKMOSNO_01, hT_GaikaHrkmNyknData.getNykmosno());
                Assert.assertEquals(C_Syorizumiflg.SYORIZUMI, hT_GaikaHrkmNyknData.getSyorizumiflg());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = exDBUpdatableResults.iterator();
            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;

            while (iter.hasNext()) {

                hT_GaikaHrkmNyknData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(SYORIYMD_03, hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO6", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals(NYKMOSNO_01, hT_GaikaHrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_GaikaHrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(SYORIYMD_03, hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO5", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals(NYKMOSNO_02, hT_GaikaHrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_GaikaHrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(SYORIYMD_01, hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO4", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals(NYKMOSNO_03, hT_GaikaHrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_GaikaHrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(SYORIYMD_02, hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO3", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals(NYKMOSNO_03, hT_GaikaHrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_GaikaHrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(SYORIYMD_03, hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO2", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals(NYKMOSNO_03, hT_GaikaHrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_GaikaHrkmNyknData.getSyorizumiflg());

                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_02, C_Syorizumiflg.MISYORI)) {

            Iterator<HT_GaikaHrkmNyknData> iter = exDBUpdatableResults.iterator();
            int iCount = 0;

            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("振込入金フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("densyskbn");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("syoriYmd");
        bM_RecoveryFilter.setRecoveryfilterkeykmid3("itirenno");

        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        bT_SkipKey1.setTableid("HT_GaikaHrkmNyknData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.SKEI.getValue());
        bT_SkipKey1.setRecoveryfilterkey2(String.valueOf(SYORIYMD_03));
        bT_SkipKey1.setRecoveryfilterkey3("IRNO2");

        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = exDBUpdatableResults.iterator();
            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;

            while (iter.hasNext()) {

                hT_GaikaHrkmNyknData = iter.next();

                boolean result1 = !(hT_GaikaHrkmNyknData.getDensyskbn().equals(C_DensysKbn.SKEI) &&
                    hT_GaikaHrkmNyknData.getSyoriYmd().equals(SYORIYMD_03) &&
                    hT_GaikaHrkmNyknData.getItirenno().equals("IRNO2"));

                assertTrue(result1);

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        bT_SkipKey2.setTableid("HT_GaikaHrkmNyknData");
        bT_SkipKey2.setRecoveryfilterid("Sk002");
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.SKEI.getValue());
        bT_SkipKey2.setRecoveryfilterkey2(String.valueOf(SYORIYMD_02));
        bT_SkipKey2.setRecoveryfilterkey3("IRNO3");

        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {


        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> exDBUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = exDBUpdatableResults.iterator();
            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;

            while (iter.hasNext()) {

                hT_GaikaHrkmNyknData = iter.next();

                boolean result1 = !(hT_GaikaHrkmNyknData.getDensyskbn().equals(C_DensysKbn.SKEI) &&
                    hT_GaikaHrkmNyknData.getSyoriYmd().equals(SYORIYMD_03) &&
                    hT_GaikaHrkmNyknData.getItirenno().equals("IRNO2"));

                boolean result2 = !(hT_GaikaHrkmNyknData.getDensyskbn().equals(C_DensysKbn.SKEI) &&
                    hT_GaikaHrkmNyknData.getSyoriYmd().equals(SYORIYMD_02) &&
                    hT_GaikaHrkmNyknData.getItirenno().equals("IRNO3"));

                assertTrue(result1 && result2);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
