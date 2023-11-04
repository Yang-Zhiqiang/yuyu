package yuyu.def.biz.manager;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 仮受計上明細リスト作成<br />
 * 経理伝票データテーブルエンティティリスト(大量)取得　拡張ジョブコードかつ処理年月日のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn";

    private final static String sheetName = "INデータ";


    @Inject
    private BizDomManager bizDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGBU";
    static String P_FILTER_ID = "Bz105";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_DenpyoData> denpyoDataExDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_01, BizDate.valueOf(20160406))) {

            Assert.assertFalse(denpyoDataExDBResults.iterator().hasNext());

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        }
        catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllDenpyoData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_DenpyoData> denpyoDataExDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_01, BizDate.valueOf(20160414))) {

            Assert.assertFalse(denpyoDataExDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_DenpyoData> denpyoDataExDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_01, BizDate.valueOf(20160406))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = denpyoDataExDBResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                Assert.assertEquals("1000000003", bT_DenpyoData.getDenrenno());
                Assert.assertEquals(87, bT_DenpyoData.getEdano().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_DenpyoData> denpyoDataExDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_01, BizDate.valueOf(20160405))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = denpyoDataExDBResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000001", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(11, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000001", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(22, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000001", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(33, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000002", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(99, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000003", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(96, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111129", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000003", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(99, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111130", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000001", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(98, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD02", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111130", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000003", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(94, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD03", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000005", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(93, bT_DenpyoData.getEdano().intValue());

                    continue;
                }
                if (10 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD03", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111130", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000003", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(95, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (11 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD05", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000009", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(97, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (12 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD01", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD03", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000001", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(93, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (13 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD02", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SONOTA, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD01", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000001", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(44, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (14 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD02", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD05", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111130", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000003", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(98, bT_DenpyoData.getEdano().intValue());

                    continue;

                }

                if (15 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD03", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD03", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000007", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(97, bT_DenpyoData.getEdano().intValue());

                    continue;
                }

                if (16 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals("SSKCD04", bT_DenpyoData.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN, bT_DenpyoData.getKanjyoukmkcd());
                    Assert.assertEquals("CD03", bT_DenpyoData.getSyoricd());
                    Assert.assertEquals("11807111118", bT_DenpyoData.getKeirisyono());
                    Assert.assertEquals("1000000007", bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(98, bT_DenpyoData.getEdano().intValue());

                    continue;
                }
            }

            Assert.assertEquals(16, iCount);
        }
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

        try (ExDBResults<BT_DenpyoData> bT_DenpyoDataResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_02, BizDate.valueOf(20160405))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = bT_DenpyoDataResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(16, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20() {

        try (ExDBResults<BT_DenpyoData> bT_DenpyoDataResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_02, BizDate.valueOf(20160405))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = bT_DenpyoDataResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();

                boolean result1 = (bT_DenpyoData.getDensyskbn().equals(C_DensysKbn.HOZEN))
                    && (bT_DenpyoData.getDenrenno().equals("1000000007"));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(14, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3() {

        try (ExDBResults<BT_DenpyoData> bT_DenpyoDataResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(P_JOB_CD_02, BizDate.valueOf(20160405))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = bT_DenpyoDataResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();

                boolean result1 = (bT_DenpyoData.getDensyskbn().equals(C_DensysKbn.HOZEN))
                    && (bT_DenpyoData.getDenrenno().equals("1000000007"));

                boolean result2 = (bT_DenpyoData.getDensyskbn().equals(C_DensysKbn.HOZEN))
                    && (bT_DenpyoData.getDenrenno().equals("1000000005"));

                assertFalse(result1);
                assertFalse(result2);

                iCount++;
            }

            Assert.assertEquals(13, iCount);
        }
    }
}
