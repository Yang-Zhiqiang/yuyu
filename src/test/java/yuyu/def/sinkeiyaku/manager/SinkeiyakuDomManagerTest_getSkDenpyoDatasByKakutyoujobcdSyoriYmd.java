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
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 経理伝票データテーブル作成処理(新契約)<br />
 * 新契約伝票データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDatasByKakutyoujobcdSyoriYmd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_DENRENNO_01 = "11111111111111111111";
    static String P_DENRENNO_02 = "22222222222222222222";
    static String P_DENRENNO_03 = "33333333333333333333";
    static String P_DENRENNO_04 = "44444444444444444444";
    static String P_DENRENNO_05 = "55555555555555555555";
    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGAA";
    static String P_FILTER_ID = "Bz105";
    static Integer P_EDANO_01 = new Integer(11);
    static Integer P_EDANO_02 = new Integer(12);
    static Integer P_EDANO_03 = new Integer(13);
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160301");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160302");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160303");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160304");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(HT_SkDenpyoDataResults.iterator().hasNext());
        }

        HT_SkDenpyoData HT_SkDenpyoData1 = new HT_SkDenpyoData(P_DENRENNO_01,P_EDANO_01);
        HT_SkDenpyoData1.setSyoriYmd(P_SYORIYMD_01);
        HT_SkDenpyoData1.setDensyskbn(C_DensysKbn.SKEI);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData1);

        HT_SkDenpyoData HT_SkDenpyoData2 = new HT_SkDenpyoData(P_DENRENNO_04,P_EDANO_03);
        HT_SkDenpyoData2.setSyoriYmd(P_SYORIYMD_02);
        HT_SkDenpyoData2.setDensyskbn(C_DensysKbn.HOZEN);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData2);

        HT_SkDenpyoData HT_SkDenpyoData3 = new HT_SkDenpyoData(P_DENRENNO_05,P_EDANO_03);
        HT_SkDenpyoData3.setSyoriYmd(P_SYORIYMD_02);
        HT_SkDenpyoData3.setDensyskbn(C_DensysKbn.HKSIHARAI);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData3);

        HT_SkDenpyoData HT_SkDenpyoData4 = new HT_SkDenpyoData(P_DENRENNO_02,P_EDANO_02);
        HT_SkDenpyoData4.setSyoriYmd(P_SYORIYMD_02);
        HT_SkDenpyoData4.setDensyskbn(C_DensysKbn.AGKANRI);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData4);

        HT_SkDenpyoData HT_SkDenpyoData5 = new HT_SkDenpyoData(P_DENRENNO_02,P_EDANO_03);
        HT_SkDenpyoData5.setSyoriYmd(P_SYORIYMD_02);
        HT_SkDenpyoData5.setDensyskbn(C_DensysKbn.AGKANRI);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData5);

        HT_SkDenpyoData HT_SkDenpyoData6 = new HT_SkDenpyoData(P_DENRENNO_03,P_EDANO_03);
        HT_SkDenpyoData6.setSyoriYmd(P_SYORIYMD_03);
        HT_SkDenpyoData6.setDensyskbn(C_DensysKbn.AGKANRI);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(HT_SkDenpyoDataResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<HT_SkDenpyoData> iter = HT_SkDenpyoDataResults.iterator();
            HT_SkDenpyoData hT_SkDenpyoData = null;
            while (iter.hasNext()) {

                hT_SkDenpyoData = iter.next();
                iCount++;

                Assert.assertEquals(P_DENRENNO_01, hT_SkDenpyoData.getDenrenno());
                Assert.assertEquals(P_EDANO_01, hT_SkDenpyoData.getEdano());
                Assert.assertEquals(P_SYORIYMD_01, hT_SkDenpyoData.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)){

            int iCount = 0;
            Iterator<HT_SkDenpyoData> iter = HT_SkDenpyoDataResults.iterator();
            HT_SkDenpyoData hT_SkDenpyoData = null;
            while (iter.hasNext()) {

                hT_SkDenpyoData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_DENRENNO_02, hT_SkDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_02, hT_SkDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, hT_SkDenpyoData.getSyoriYmd());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_DENRENNO_02, hT_SkDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, hT_SkDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, hT_SkDenpyoData.getSyoriYmd());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_DENRENNO_04, hT_SkDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, hT_SkDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, hT_SkDenpyoData.getSyoriYmd());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_DENRENNO_05, hT_SkDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, hT_SkDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, hT_SkDenpyoData.getSyoriYmd());
                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
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
    public void testSkippedFilter40(){

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            Iterator<HT_SkDenpyoData> iter = HT_SkDenpyoDataResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();
                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("伝票データフィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("densyskbn");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("denrenno");
        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("HT_SkDenpyoData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        bT_SkipKey1.setRecoveryfilterkey2(P_DENRENNO_04);

        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (HT_SkDenpyoData entity : HT_SkDenpyoDataResults) {

                Assert.assertNotEquals(entity.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(entity.getDenrenno(), P_DENRENNO_04);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("HT_SkDenpyoData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.HKSIHARAI.getValue());
        bT_SkipKey2.setRecoveryfilterkey2(P_DENRENNO_05);

        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        try (ExDBUpdatableResults<HT_SkDenpyoData> HT_SkDenpyoDataResults =
            sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (HT_SkDenpyoData entity : HT_SkDenpyoDataResults) {

                Assert.assertNotEquals(entity.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(entity.getDenrenno(), P_DENRENNO_04);
                Assert.assertNotEquals(entity.getDensyskbn(), C_DensysKbn.HKSIHARAI);
                Assert.assertNotEquals(entity.getDenrenno(), P_DENRENNO_05);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
