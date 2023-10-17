package yuyu.def.biz.manager;

import java.util.Iterator;

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

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 振替伝票テーブル作成処理<br />
 * 経理伝票データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日、伝票用システム区分）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn {

    @Inject
    private BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGBB";
    static String P_FILTER_ID = "Bz105";
    static String P_DENRENNO_01 = "10000000001";
    static String P_DENRENNO_02 = "10000000002";
    static String P_DENRENNO_03 = "10000000003";
    static String P_DENRENNO_04 = "10000000004";
    static Integer P_EDANO_01 = new Integer(11);
    static Integer P_EDANO_02= new Integer(12);
    static Integer P_EDANO_03 = new Integer(13);
    static Integer P_EDANO_04 = new Integer(14);
    static Integer P_EDANO_05 = new Integer(15);
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160215");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160220");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160201");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01,
                C_DensysKbn.SKEI, C_DensysKbn.AGKANRI)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        BT_DenpyoData bT_DenpyoData1 = new BT_DenpyoData(C_DensysKbn.BLNK, P_DENRENNO_01, P_EDANO_01);
        bT_DenpyoData1.setSyoriYmd(P_SYORIYMD_01);
        bT_DenpyoData1.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData1);

        BT_DenpyoData bT_DenpyoData2 = new BT_DenpyoData(C_DensysKbn.AGKANRI, P_DENRENNO_02, P_EDANO_01);
        bT_DenpyoData2.setSyoriYmd(P_SYORIYMD_03);
        bT_DenpyoData2.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData2);

        BT_DenpyoData bT_DenpyoData3 = new BT_DenpyoData(C_DensysKbn.SKEI, P_DENRENNO_01, P_EDANO_01);
        bT_DenpyoData3.setSyoriYmd(P_SYORIYMD_01);
        bT_DenpyoData3.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData3);

        BT_DenpyoData bT_DenpyoData4 = new BT_DenpyoData(C_DensysKbn.NENKIN, P_DENRENNO_02, P_EDANO_02);
        bT_DenpyoData4.setSyoriYmd(P_SYORIYMD_02);
        bT_DenpyoData4.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData4);

        BT_DenpyoData bT_DenpyoData5 = new BT_DenpyoData(C_DensysKbn.HKSIHARAI, P_DENRENNO_03, P_EDANO_04);
        bT_DenpyoData5.setSyoriYmd(P_SYORIYMD_02);
        bT_DenpyoData5.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData5);

        BT_DenpyoData bT_DenpyoData6 = new BT_DenpyoData(C_DensysKbn.NENKIN, P_DENRENNO_02, P_EDANO_01);
        bT_DenpyoData6.setSyoriYmd(P_SYORIYMD_02);
        bT_DenpyoData6.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData6);

        BT_DenpyoData bT_DenpyoData7 = new BT_DenpyoData(C_DensysKbn.HOZEN, P_DENRENNO_04, P_EDANO_05);
        bT_DenpyoData7.setSyoriYmd(P_SYORIYMD_02);
        bT_DenpyoData7.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData7);

        BT_DenpyoData bT_DenpyoData8 = new BT_DenpyoData(C_DensysKbn.NENKIN, P_DENRENNO_01, P_EDANO_03);
        bT_DenpyoData8.setSyoriYmd(P_SYORIYMD_02);
        bT_DenpyoData8.setSeg2cd(C_Segcd.BLNK);
        bizDomManager.insert(bT_DenpyoData8);

        BT_DenpyoData bT_DenpyoData9 = new BT_DenpyoData(C_DensysKbn.AGKANRI, P_DENRENNO_03, P_EDANO_01);
        bT_DenpyoData9.setSyoriYmd(P_SYORIYMD_01);
        bT_DenpyoData9.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bizDomManager.insert(bT_DenpyoData9);
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

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01,
                C_DensysKbn.HOZEN)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01,
                C_DensysKbn.SKEI, C_DensysKbn.AGKANRI)) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.SKEI, bT_DenpyoData.getDensyskbn());
                Assert.assertEquals(P_DENRENNO_01, bT_DenpyoData.getDenrenno());
                Assert.assertEquals(P_EDANO_01, bT_DenpyoData.getEdano());
                Assert.assertEquals(P_SYORIYMD_01, bT_DenpyoData.getSyoriYmd());
                Assert.assertEquals(C_Segcd.BLNK, bT_DenpyoData.getSeg2cd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02,
                C_DensysKbn.HOZEN, C_DensysKbn.HKSIHARAI, C_DensysKbn.NENKIN)) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_04, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_05, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    Assert.assertEquals(C_Segcd.BLNK, bT_DenpyoData.getSeg2cd());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HKSIHARAI, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_03, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_04, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    Assert.assertEquals(C_Segcd.BLNK, bT_DenpyoData.getSeg2cd());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_01, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    Assert.assertEquals(C_Segcd.BLNK, bT_DenpyoData.getSeg2cd());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_02, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    Assert.assertEquals(C_Segcd.BLNK, bT_DenpyoData.getSeg2cd());
                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_02, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_02, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    Assert.assertEquals(C_Segcd.BLNK, bT_DenpyoData.getSeg2cd());
                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
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
    public void testSkippedFilter11(){

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02,
                C_DensysKbn.HOZEN, C_DensysKbn.HKSIHARAI, C_DensysKbn.NENKIN)) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();
                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12(){

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("伝票データフィルタ");

        bM_RecoveryFilter.setRecoveryfilterkeykmid1("densyskbn");

        bM_RecoveryFilter.setRecoveryfilterkeykmid2("denrenno");
        bizDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("BT_DenpyoData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        bT_SkipKey1.setRecoveryfilterkey2(P_DENRENNO_04);
        bizDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20(){

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02,
                C_DensysKbn.HOZEN, C_DensysKbn.HKSIHARAI, C_DensysKbn.NENKIN)) {

            int iCount = 0;
            for (BT_DenpyoData exDBResult : exDBResults) {

                Assert.assertNotEquals(exDBResult.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(exDBResult.getDenrenno(), P_DENRENNO_04);

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter21(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("BT_DenpyoData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.HKSIHARAI.getValue());
        bT_SkipKey2.setRecoveryfilterkey2(P_DENRENNO_03);
        bizDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02,
                C_DensysKbn.HOZEN, C_DensysKbn.HKSIHARAI, C_DensysKbn.NENKIN)) {

            int iCount = 0;
            for (BT_DenpyoData exDBResult : exDBResults) {

                Assert.assertNotEquals(exDBResult.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(exDBResult.getDenrenno(), P_DENRENNO_04);
                Assert.assertNotEquals(exDBResult.getDensyskbn(), C_DensysKbn.HKSIHARAI);
                Assert.assertNotEquals(exDBResult.getDenrenno(), P_DENRENNO_03);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
