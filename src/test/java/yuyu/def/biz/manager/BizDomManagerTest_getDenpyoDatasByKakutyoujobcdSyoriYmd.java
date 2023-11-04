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
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 新契約振替伝票テーブル作成処理<br />
 * 経理伝票データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmd {

    @Inject
    private BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_DENRENNO_01 = "10000000001";
    static String P_DENRENNO_02 = "10000000002";
    static String P_DENRENNO_03 = "10000000003";
    static String P_DENRENNO_04 = "10000000004";
    static Integer P_EDANO_01 = new Integer(11);
    static Integer P_EDANO_02 = new Integer(12);
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160215");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160220");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160201");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160214");
    static BizDate P_DENYMD_01 = BizDate.valueOf("20160110");
    static BizDate P_DENYMD_02 = BizDate.valueOf("20160115");
    static BizDate P_DENYMD_03 = BizDate.valueOf("20160117");
    static String P_HURIDENATESAKICD_01 = "101";
    static String P_HURIDENATESAKICD_02 = "102";
    static String P_HURIDENATESAKICD_03 = "103";

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        BT_DenpyoData bT_DenpyoData1 = new BT_DenpyoData(C_DensysKbn.BLNK, P_DENRENNO_01, P_EDANO_01);
        bT_DenpyoData1.setHuridenatesakicd(P_HURIDENATESAKICD_01);
        bT_DenpyoData1.setDenymd(P_DENYMD_02);
        bT_DenpyoData1.setSyoriYmd(P_SYORIYMD_01);
        bizDomManager.insert(bT_DenpyoData1);

        BT_DenpyoData bT_DenpyoData2 = new BT_DenpyoData(C_DensysKbn.SKEI, P_DENRENNO_02, P_EDANO_01);
        bT_DenpyoData2.setHuridenatesakicd(P_HURIDENATESAKICD_01);
        bT_DenpyoData2.setDenymd(P_DENYMD_02);
        bT_DenpyoData2.setSyoriYmd(P_SYORIYMD_03);
        bizDomManager.insert(bT_DenpyoData2);

        BT_DenpyoData bT_DenpyoData3 = new BT_DenpyoData(C_DensysKbn.SKEI, P_DENRENNO_01, P_EDANO_01);
        bT_DenpyoData3.setHuridenatesakicd(P_HURIDENATESAKICD_01);
        bT_DenpyoData3.setDenymd(P_DENYMD_02);
        bT_DenpyoData3.setSyoriYmd(P_SYORIYMD_01);
        bizDomManager.insert(bT_DenpyoData3);

        BT_DenpyoData bT_DenpyoData4 = new BT_DenpyoData(C_DensysKbn.SKEI, P_DENRENNO_02, P_EDANO_02);
        bT_DenpyoData4.setHuridenatesakicd(P_HURIDENATESAKICD_02);
        bT_DenpyoData4.setDenymd(P_DENYMD_03);
        bT_DenpyoData4.setSyoriYmd(P_SYORIYMD_02);
        bizDomManager.insert(bT_DenpyoData4);

        BT_DenpyoData bT_DenpyoData5 = new BT_DenpyoData(C_DensysKbn.SKEI, P_DENRENNO_03, P_EDANO_02);
        bT_DenpyoData5.setHuridenatesakicd(P_HURIDENATESAKICD_02);
        bT_DenpyoData5.setDenymd(P_DENYMD_01);
        bT_DenpyoData5.setSyoriYmd(P_SYORIYMD_02);
        bizDomManager.insert(bT_DenpyoData5);

        BT_DenpyoData bT_DenpyoData6 = new BT_DenpyoData(C_DensysKbn.SKEI, P_DENRENNO_04, P_EDANO_02);
        bT_DenpyoData6.setHuridenatesakicd(P_HURIDENATESAKICD_03);
        bT_DenpyoData6.setDenymd(P_DENYMD_03);
        bT_DenpyoData6.setSyoriYmd(P_SYORIYMD_02);
        bizDomManager.insert(bT_DenpyoData6);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllDenpyoData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {
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
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)) {
            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResults.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_03, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_02, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_DENYMD_01, bT_DenpyoData.getDenymd());
                    Assert.assertEquals(P_HURIDENATESAKICD_02, bT_DenpyoData.getHuridenatesakicd());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_02, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_02, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_DENYMD_03, bT_DenpyoData.getDenymd());
                    Assert.assertEquals(P_HURIDENATESAKICD_02, bT_DenpyoData.getHuridenatesakicd());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, bT_DenpyoData.getDensyskbn());
                    Assert.assertEquals(P_DENRENNO_04, bT_DenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_02, bT_DenpyoData.getEdano());
                    Assert.assertEquals(P_DENYMD_03, bT_DenpyoData.getDenymd());
                    Assert.assertEquals(P_HURIDENATESAKICD_03, bT_DenpyoData.getHuridenatesakicd());
                    Assert.assertEquals(P_SYORIYMD_02, bT_DenpyoData.getSyoriYmd());
                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
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

        try(ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd("RGAE", P_SYORIYMD_02)) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Bz105");
        filter.setRecoveryfilternm("伝票データフィルタ");
        filter.setRecoveryfilterkeykmid1("densyskbn");
        filter.setRecoveryfilterkeykmid2("denrenno");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("900001");
        key3.setRecoveryfilterid("Bz105");
        key3.setTableid("BT_DenpyoData");
        key3.setKakutyoujobcd("RGAE");
        key3.setRecoveryfilterkey1("10");
        key3.setRecoveryfilterkey2("10000000002");

        bizDomManager.insert(key3);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd("RGAE", P_SYORIYMD_02)){
            for(BT_DenpyoData denpyoData : exDBResults){
                Assert.assertNotEquals(denpyoData.getDenrenno(), "10000000002");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }


    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey key1 = new BT_SkipKey("900002");
        key1.setRecoveryfilterid("Bz105");
        key1.setTableid("BT_DenpyoData");
        key1.setKakutyoujobcd("RGAE");
        key1.setRecoveryfilterkey1("10");
        key1.setRecoveryfilterkey2("10000000003");

        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        int iCount = 0;
        try(ExDBResults<BT_DenpyoData> exDBResults =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmd("RGAE", P_SYORIYMD_02)){
            for(BT_DenpyoData denpyoData : exDBResults){
                Assert.assertNotEquals(denpyoData.getDenrenno(), "10000000002");
                Assert.assertNotEquals(denpyoData.getDenrenno(), "10000000003");

                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }
    }
}
