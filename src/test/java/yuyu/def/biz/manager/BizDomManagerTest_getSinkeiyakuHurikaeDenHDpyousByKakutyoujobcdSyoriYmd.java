package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 新契約振替伝票作成処理<br />
 * 新契約振替伝票作成用テーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd {

    @Inject
    private BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGAF";
    static String P_FILTER_ID = "Bz105";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf(20160303);
    static BizDate P_SYORIYMD_02 = BizDate.valueOf(20160313);
    static BizDate P_SYORIYMD_03 = BizDate.valueOf(20160323);
    static String P_DENRENNO_01 = "DRNO0000001";
    static String P_DENRENNO_02 = "DRNO0000002";
    static String P_DENRENNO_03 = "DRNO0000003";
    static String P_DENRENNO_04 = "DRNO0000004";
    static Integer P_EDANO_01 = new Integer(11);
    static String P_TORIHIKINO_01 = "TORI001";
    static String P_TORIHIKINO_02 = "TORI002";
    static String P_DENKANJOKAMOKUCD_01 = "DKNO1";
    static String P_DENKANJOKAMOKUCD_02 = "DKNO2";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }

        BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen1 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.AGKANRI,
            P_DENRENNO_01, P_EDANO_01);
        bT_SinkeiyakuHurikaeDen1.setSyoriYmd(P_SYORIYMD_01);
        bT_SinkeiyakuHurikaeDen1.setTorihikino(P_TORIHIKINO_01);
        bT_SinkeiyakuHurikaeDen1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);
        bT_SinkeiyakuHurikaeDen1.setDenkanjokamokucd(P_DENKANJOKAMOKUCD_01);
        bT_SinkeiyakuHurikaeDen1.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen1.setTekiyoukbn(C_TekiyouKbn.BLNK);
        bizDomManager.insert(bT_SinkeiyakuHurikaeDen1);

        BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen2 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.NENKIN,
            P_DENRENNO_04, P_EDANO_01);
        bT_SinkeiyakuHurikaeDen2.setSyoriYmd(P_SYORIYMD_02);
        bT_SinkeiyakuHurikaeDen2.setTorihikino(P_TORIHIKINO_02);
        bT_SinkeiyakuHurikaeDen2.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);
        bT_SinkeiyakuHurikaeDen2.setDenkanjokamokucd(P_DENKANJOKAMOKUCD_02);
        bT_SinkeiyakuHurikaeDen2.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bT_SinkeiyakuHurikaeDen2.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen2.setTekiyoukbn(C_TekiyouKbn.BLNK);
        bizDomManager.insert(bT_SinkeiyakuHurikaeDen2);

        BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen3 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.NENKIN,
            P_DENRENNO_03, P_EDANO_01);
        bT_SinkeiyakuHurikaeDen3.setSyoriYmd(P_SYORIYMD_02);
        bT_SinkeiyakuHurikaeDen3.setTorihikino(P_TORIHIKINO_01);
        bT_SinkeiyakuHurikaeDen3.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);
        bT_SinkeiyakuHurikaeDen3.setDenkanjokamokucd(P_DENKANJOKAMOKUCD_02);
        bT_SinkeiyakuHurikaeDen3.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bT_SinkeiyakuHurikaeDen3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen3.setTekiyoukbn(C_TekiyouKbn.BLNK);
        bizDomManager.insert(bT_SinkeiyakuHurikaeDen3);

        BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen4 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.HOZEN,
            P_DENRENNO_02, P_EDANO_01);
        bT_SinkeiyakuHurikaeDen4.setSyoriYmd(P_SYORIYMD_02);
        bT_SinkeiyakuHurikaeDen4.setTorihikino(P_TORIHIKINO_01);
        bT_SinkeiyakuHurikaeDen4.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);
        bT_SinkeiyakuHurikaeDen4.setDenkanjokamokucd(P_DENKANJOKAMOKUCD_02);
        bT_SinkeiyakuHurikaeDen4.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen4.setTekiyoukbn(C_TekiyouKbn.BLNK);
        bizDomManager.insert(bT_SinkeiyakuHurikaeDen4);

        BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen5 = new BT_SinkeiyakuHurikaeDen(C_DensysKbn.SKEI,
            P_DENRENNO_01, P_EDANO_01);
        bT_SinkeiyakuHurikaeDen5.setSyoriYmd(P_SYORIYMD_02);
        bT_SinkeiyakuHurikaeDen5.setTorihikino(P_TORIHIKINO_01);
        bT_SinkeiyakuHurikaeDen5.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);
        bT_SinkeiyakuHurikaeDen5.setDenkanjokamokucd(P_DENKANJOKAMOKUCD_01);
        bT_SinkeiyakuHurikaeDen5.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bT_SinkeiyakuHurikaeDen5.setTekiyoukbn(C_TekiyouKbn.BLNK);
        bizDomManager.insert(bT_SinkeiyakuHurikaeDen5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSinkeiyakuHurikaeDen());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_03)) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<BT_SinkeiyakuHurikaeDen> iter = exDBResEntity.iterator();
            BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen = null;
            while (iter.hasNext()) {

                bT_SinkeiyakuHurikaeDen = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.AGKANRI, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                Assert.assertEquals(P_DENRENNO_01, bT_SinkeiyakuHurikaeDen.getDenrenno());
                Assert.assertEquals(P_EDANO_01, bT_SinkeiyakuHurikaeDen.getEdano());
                Assert.assertEquals(P_SYORIYMD_01, bT_SinkeiyakuHurikaeDen.getSyoriYmd());
                Assert.assertEquals(P_TORIHIKINO_01, bT_SinkeiyakuHurikaeDen.getTorihikino());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bT_SinkeiyakuHurikaeDen.getKanjyoukmkgroupkbn());
                Assert.assertEquals(P_DENKANJOKAMOKUCD_01, bT_SinkeiyakuHurikaeDen.getDenkanjokamokucd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTekiyoukbn());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)) {

            int iCount = 0;
            Iterator<BT_SinkeiyakuHurikaeDen> iter = exDBResEntity.iterator();
            BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen = null;
            while (iter.hasNext()) {

                bT_SinkeiyakuHurikaeDen = iter.next();
                iCount++;

                if(1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_01, bT_SinkeiyakuHurikaeDen.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_SinkeiyakuHurikaeDen.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_SinkeiyakuHurikaeDen.getSyoriYmd());
                    Assert.assertEquals(P_TORIHIKINO_01, bT_SinkeiyakuHurikaeDen.getTorihikino());
                    Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bT_SinkeiyakuHurikaeDen.getKanjyoukmkgroupkbn());
                    Assert.assertEquals(P_DENKANJOKAMOKUCD_01, bT_SinkeiyakuHurikaeDen.getDenkanjokamokucd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTaisyakukbn());
                    Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getNaibukeiyakukbn());
                    Assert.assertEquals(C_TekiyouKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTekiyoukbn());

                    continue;
                }

                if(2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_02, bT_SinkeiyakuHurikaeDen.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_SinkeiyakuHurikaeDen.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_SinkeiyakuHurikaeDen.getSyoriYmd());
                    Assert.assertEquals(P_TORIHIKINO_01, bT_SinkeiyakuHurikaeDen.getTorihikino());
                    Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bT_SinkeiyakuHurikaeDen.getKanjyoukmkgroupkbn());
                    Assert.assertEquals(P_DENKANJOKAMOKUCD_02, bT_SinkeiyakuHurikaeDen.getDenkanjokamokucd());
                    Assert.assertEquals(C_TaisyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTaisyakukbn());
                    Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getNaibukeiyakukbn());
                    Assert.assertEquals(C_TekiyouKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTekiyoukbn());

                    continue;
                }

                if(3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_03, bT_SinkeiyakuHurikaeDen.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_SinkeiyakuHurikaeDen.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_SinkeiyakuHurikaeDen.getSyoriYmd());
                    Assert.assertEquals(P_TORIHIKINO_01, bT_SinkeiyakuHurikaeDen.getTorihikino());
                    Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bT_SinkeiyakuHurikaeDen.getKanjyoukmkgroupkbn());
                    Assert.assertEquals(P_DENKANJOKAMOKUCD_02, bT_SinkeiyakuHurikaeDen.getDenkanjokamokucd());
                    Assert.assertEquals(C_TaisyakuKbn.KARIKATA, bT_SinkeiyakuHurikaeDen.getTaisyakukbn());
                    Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getNaibukeiyakukbn());
                    Assert.assertEquals(C_TekiyouKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTekiyoukbn());

                    continue;
                }

                if(4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_04, bT_SinkeiyakuHurikaeDen.getDenrenno());
                    Assert.assertEquals(P_EDANO_01, bT_SinkeiyakuHurikaeDen.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, bT_SinkeiyakuHurikaeDen.getSyoriYmd());
                    Assert.assertEquals(P_TORIHIKINO_02, bT_SinkeiyakuHurikaeDen.getTorihikino());
                    Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bT_SinkeiyakuHurikaeDen.getKanjyoukmkgroupkbn());
                    Assert.assertEquals(P_DENKANJOKAMOKUCD_02, bT_SinkeiyakuHurikaeDen.getDenkanjokamokucd());
                    Assert.assertEquals(C_TaisyakuKbn.KARIKATA, bT_SinkeiyakuHurikaeDen.getTaisyakukbn());
                    Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bT_SinkeiyakuHurikaeDen.getNaibukeiyakukbn());
                    Assert.assertEquals(C_TekiyouKbn.BLNK, bT_SinkeiyakuHurikaeDen.getTekiyoukbn());

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
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
    @Transactional
    public void testSkippedFilter11() {

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            Iterator<BT_SinkeiyakuHurikaeDen> iter = exDBResEntity.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }
    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("伝票データフィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("densyskbn");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("denrenno");
        bizDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("BT_SinkeiyakuHurikaeDen");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.SKEI.getValue());
        bT_SkipKey1.setRecoveryfilterkey2(P_DENRENNO_01);
        bizDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20() {

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for(BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen : exDBResEntity){

                assertNotEquals(C_DensysKbn.SKEI, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                assertNotEquals(P_DENRENNO_01, bT_SinkeiyakuHurikaeDen.getDenrenno());

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("BT_SinkeiyakuHurikaeDen");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        bT_SkipKey2.setRecoveryfilterkey2(P_DENRENNO_02);
        bizDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3() {

        try (ExDBResults<BT_SinkeiyakuHurikaeDen> exDBResEntity = bizDomManager
            .getSinkeiyakuHurikaeDenHDpyousByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for(BT_SinkeiyakuHurikaeDen bT_SinkeiyakuHurikaeDen : exDBResEntity){

                assertNotEquals(C_DensysKbn.SKEI, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                assertNotEquals(P_DENRENNO_01, bT_SinkeiyakuHurikaeDen.getDenrenno());

                assertNotEquals(C_DensysKbn.HOZEN, bT_SinkeiyakuHurikaeDen.getDensyskbn());
                assertNotEquals(P_DENRENNO_02, bT_SinkeiyakuHurikaeDen.getDenrenno());

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
