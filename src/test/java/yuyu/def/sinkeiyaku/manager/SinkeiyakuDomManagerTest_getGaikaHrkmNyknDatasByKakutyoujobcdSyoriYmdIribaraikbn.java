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
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ訂正<br />
 * 外貨振込入金データテーブルエンティティリスト（大量更新）取得（拡張ジョブコード、処理年月日、入払区分）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20160408), 1)) {

            Assert.assertFalse(gaikaHrkmNyknDataResults.iterator().hasNext());
        }
        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160409), "IRNO01");
        gaikaHrkmNyknData1.setBankcd("1000");
        gaikaHrkmNyknData1.setSitencd("100");
        gaikaHrkmNyknData1.setIribaraikbn(1);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160409), "IRNO02");
        gaikaHrkmNyknData2.setBankcd("1000");
        gaikaHrkmNyknData2.setSitencd("100");
        gaikaHrkmNyknData2.setIribaraikbn(2);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160101), "IRNO03");
        gaikaHrkmNyknData3.setBankcd("1000");
        gaikaHrkmNyknData3.setSitencd("100");
        gaikaHrkmNyknData3.setIribaraikbn(1);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161222), "IRNO04");
        gaikaHrkmNyknData4.setBankcd("1003");
        gaikaHrkmNyknData4.setSitencd("103");
        gaikaHrkmNyknData4.setIribaraikbn(3);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161222), "IRNO05");
        gaikaHrkmNyknData5.setBankcd("1002");
        gaikaHrkmNyknData5.setSitencd("103");
        gaikaHrkmNyknData5.setIribaraikbn(3);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161222), "IRNO06");
        gaikaHrkmNyknData6.setBankcd("1001");
        gaikaHrkmNyknData6.setSitencd("103");
        gaikaHrkmNyknData6.setIribaraikbn(3);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161222), "IRNO07");
        gaikaHrkmNyknData7.setBankcd("1001");
        gaikaHrkmNyknData7.setSitencd("102");
        gaikaHrkmNyknData7.setIribaraikbn(3);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161222), "IRNO08");
        gaikaHrkmNyknData8.setBankcd("1001");
        gaikaHrkmNyknData8.setSitencd("101");
        gaikaHrkmNyknData8.setIribaraikbn(3);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);
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

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> hrkmNyknDataUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20160409), 4)) {

            Assert.assertFalse(hrkmNyknDataUpdatableResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20160409), 1)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = gaikaHrkmNyknDataResults.iterator();
            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;
            while (iter.hasNext()) {

                hT_GaikaHrkmNyknData = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                Assert.assertEquals(BizDate.valueOf(20160409), hT_GaikaHrkmNyknData.getSyoriYmd());
                Assert.assertEquals("IRNO01", hT_GaikaHrkmNyknData.getItirenno());
                Assert.assertEquals(1, hT_GaikaHrkmNyknData.getIribaraikbn().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20161222), 3)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = gaikaHrkmNyknDataResults.iterator();
            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;
            while (iter.hasNext()) {

                hT_GaikaHrkmNyknData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20161222), hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO08", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals("1001", hT_GaikaHrkmNyknData.getBankcd());
                    Assert.assertEquals("101", hT_GaikaHrkmNyknData.getSitencd());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20161222), hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO07", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals("1001", hT_GaikaHrkmNyknData.getBankcd());
                    Assert.assertEquals("102", hT_GaikaHrkmNyknData.getSitencd());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20161222), hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO06", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals("1001", hT_GaikaHrkmNyknData.getBankcd());
                    Assert.assertEquals("103", hT_GaikaHrkmNyknData.getSitencd());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20161222), hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO05", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals("1002", hT_GaikaHrkmNyknData.getBankcd());
                    Assert.assertEquals("103", hT_GaikaHrkmNyknData.getSitencd());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf(20161222), hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("IRNO04", hT_GaikaHrkmNyknData.getItirenno());
                    Assert.assertEquals("1003", hT_GaikaHrkmNyknData.getBankcd());
                    Assert.assertEquals("103", hT_GaikaHrkmNyknData.getSitencd());

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

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20161222), 3)) {

            int iCount = 0;
            Iterator<HT_GaikaHrkmNyknData> iter = gaikaHrkmNyknDataResults.iterator();
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
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Sk002");
        recoveryFilter1.setRecoveryfilternm("振込入金フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("densyskbn");
        recoveryFilter1.setRecoveryfilterkeykmid2("syoriYmd");
        recoveryFilter1.setRecoveryfilterkeykmid3("itirenno");

        sinkeiyakuDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RBT9");
        skipKey1.setTableid("HT_GaikaHrkmNyknData");
        skipKey1.setRecoveryfilterid("Sk002");
        skipKey1.setRecoveryfilterkey1("20");
        skipKey1.setRecoveryfilterkey2("20161222");
        skipKey1.setRecoveryfilterkey3("IRNO08");

        sinkeiyakuDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> hrkmNyknDataUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20161222), 3)) {

            int iCount = 0;
            for (HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData : hrkmNyknDataUpdatableResults) {

                boolean result1 = C_DensysKbn.HOZEN.eq(hT_GaikaHrkmNyknData.getDensyskbn()) &&
                    BizDate.valueOf(20161222).compareTo(hT_GaikaHrkmNyknData.getSyoriYmd()) == 0 &&
                    !"IRNO08".equals(hT_GaikaHrkmNyknData.getItirenno());

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
        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RBT9");
        skipKey2.setTableid("HT_GaikaHrkmNyknData");
        skipKey2.setRecoveryfilterid("Sk002");
        skipKey2.setRecoveryfilterkey1("20");
        skipKey2.setRecoveryfilterkey2("20161222");
        skipKey2.setRecoveryfilterkey3("IRNO07");

        sinkeiyakuDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> hrkmNyknDataUpdatableResults = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByKakutyoujobcdSyoriYmdIribaraikbn("RBT9", BizDate.valueOf(20161222), 3)) {

            int iCount = 0;
            for (HT_GaikaHrkmNyknData hT_GaikaHrkmNyknDat : hrkmNyknDataUpdatableResults) {

                boolean result1 = C_DensysKbn.HOZEN.eq(hT_GaikaHrkmNyknDat.getDensyskbn()) &&
                    BizDate.valueOf(20161222).compareTo(hT_GaikaHrkmNyknDat.getSyoriYmd()) == 0 &&
                    !"IRNO07".equals(hT_GaikaHrkmNyknDat.getItirenno());

                boolean result2 = C_DensysKbn.HOZEN.eq(hT_GaikaHrkmNyknDat.getDensyskbn()) &&
                    BizDate.valueOf(20161222).compareTo(hT_GaikaHrkmNyknDat.getSyoriYmd()) == 0 &&
                    !"IRNO08".equals(hT_GaikaHrkmNyknDat.getItirenno());

                Assert.assertTrue(result1 && result2);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
