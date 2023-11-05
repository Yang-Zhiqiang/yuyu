package yuyu.def.sinkeiyaku.manager;

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
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ振分<br />
 * 振込入金データテーブルエンティティリスト(大量更新)取得 処理済フラグ指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknDatasByKakutyoujobcdSyorizumiflg {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUCHOJOBCD_01 = "JCD01";
    static String P_KAKUCHOJOBCD_02 = "RCA0";
    static String P_FILTER_ID = "Sk002";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            Assert.assertFalse(hrkmNyknDatas.iterator().hasNext());
        }

        HT_HrkmNyknData hrkmNyknData1 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160427), "ITRNO05");
        hrkmNyknData1.setNykmosno("NKNO03");
        hrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            Assert.assertFalse(hrkmNyknDatas.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_HrkmNyknData> iter = hrkmNyknDatas.iterator();
            HT_HrkmNyknData hT_HrkmNyknData = null;
            while (iter.hasNext()) {

                hT_HrkmNyknData = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknData.getDensyskbn());
                Assert.assertEquals(BizDate.valueOf(20160427), hT_HrkmNyknData.getSyoriYmd());
                Assert.assertEquals("ITRNO05", hT_HrkmNyknData.getItirenno());
                Assert.assertEquals("NKNO03", hT_HrkmNyknData.getNykmosno());
                Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknData.getSyorizumiflg());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        HT_HrkmNyknData hrkmNyknData2 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160426), "ITRNO04");
        hrkmNyknData2.setNykmosno("NKNO03");
        hrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData2);

        HT_HrkmNyknData hrkmNyknData3 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160425), "ITRNO03");
        hrkmNyknData3.setNykmosno("NKNO03");
        hrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData3);

        HT_HrkmNyknData hrkmNyknData4 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160427), "ITRNO02");
        hrkmNyknData4.setNykmosno("NKNO02");
        hrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData4);

        HT_HrkmNyknData hrkmNyknData5 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160427), "ITRNO01");
        hrkmNyknData5.setNykmosno("NKNO01");
        hrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData5);

        HT_HrkmNyknData hrkmNyknData6 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160427), "ITRNO06");
        hrkmNyknData6.setNykmosno("NKNO03");
        hrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(hrkmNyknData6);
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_HrkmNyknData> iter = hrkmNyknDatas.iterator();
            HT_HrkmNyknData hT_HrkmNyknData = null;
            while (iter.hasNext()) {

                hT_HrkmNyknData = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20160427), hT_HrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("ITRNO01", hT_HrkmNyknData.getItirenno());
                    Assert.assertEquals("NKNO01", hT_HrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20160427), hT_HrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("ITRNO02", hT_HrkmNyknData.getItirenno());
                    Assert.assertEquals("NKNO02", hT_HrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20160425), hT_HrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("ITRNO03", hT_HrkmNyknData.getItirenno());
                    Assert.assertEquals("NKNO03", hT_HrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20160426), hT_HrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("ITRNO04", hT_HrkmNyknData.getItirenno());
                    Assert.assertEquals("NKNO03", hT_HrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknData.getSyorizumiflg());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20160427), hT_HrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("ITRNO05", hT_HrkmNyknData.getItirenno());
                    Assert.assertEquals("NKNO03", hT_HrkmNyknData.getNykmosno());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknData.getSyorizumiflg());

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

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_HrkmNyknData> iter = hrkmNyknDatas.iterator();
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
        bT_SkipKey1.setTableid("HT_HrkmNyknData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.BLNK.getValue());
        bT_SkipKey1.setRecoveryfilterkey2("20160425");
        bT_SkipKey1.setRecoveryfilterkey3("ITRNO03");
        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (HT_HrkmNyknData hT_HrkmNyknData : hrkmNyknDatas) {

                boolean result1 = !(C_DensysKbn.BLNK.eq(hT_HrkmNyknData.getDensyskbn()) &&
                    BizDate.valueOf("20160425").compareTo(hT_HrkmNyknData.getSyoriYmd()) == 0 &&
                    "ITRNO03".equals(hT_HrkmNyknData.getItirenno()));

                Assert.assertTrue(result1);

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
        bT_SkipKey2.setTableid("HT_HrkmNyknData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.BLNK.getValue());
        bT_SkipKey2.setRecoveryfilterkey2("20160426");
        bT_SkipKey2.setRecoveryfilterkey3("ITRNO04");
        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager
            .getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (HT_HrkmNyknData hT_HrkmNyknData : hrkmNyknDatas) {

                boolean result1 = !(C_DensysKbn.BLNK.eq(hT_HrkmNyknData.getDensyskbn()) &&
                    BizDate.valueOf("20160425").compareTo(hT_HrkmNyknData.getSyoriYmd()) == 0 &&
                    "ITRNO03".equals(hT_HrkmNyknData.getItirenno()));

                boolean result2 = !(C_DensysKbn.BLNK.eq(hT_HrkmNyknData.getDensyskbn()) &&
                    BizDate.valueOf("20160426").compareTo(hT_HrkmNyknData.getSyoriYmd()) == 0 &&
                    "ITRNO04".equals(hT_HrkmNyknData.getItirenno()));

                Assert.assertTrue(result1 && result2);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
}

