package yuyu.def.siharai.manager;

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
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 経理伝票データテーブル作成処理(保険金)<br />
 * 支払伝票データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiDenpyoDatasByKakutyoujobcdSyoriYmd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGAC";
    static String P_FILTER_ID = "Bz105";
    static String P_DENRENNO_01 = "11111111111111111111";
    static String P_DENRENNO_02 = "22222222222222222222";
    static String P_DENRENNO_03 = "33333333333333333333";
    static String P_DENRENNO_04 = "44444444444444444444";
    static String P_DENRENNO_05 = "55555555555555555555";
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

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(jT_SiDenpyoDataResults.iterator().hasNext());
        }

        JT_SiDenpyoData jT_SiDenpyoData1 = new JT_SiDenpyoData(P_DENRENNO_01,P_EDANO_01);
        jT_SiDenpyoData1.setSyoriYmd(P_SYORIYMD_01);
        siharaiDomManager.insert(jT_SiDenpyoData1);

        JT_SiDenpyoData jT_SiDenpyoData2 = new JT_SiDenpyoData(P_DENRENNO_04,P_EDANO_03);
        jT_SiDenpyoData2.setSyoriYmd(P_SYORIYMD_02);
        jT_SiDenpyoData2.setDensyskbn(C_DensysKbn.HOZEN);
        siharaiDomManager.insert(jT_SiDenpyoData2);

        JT_SiDenpyoData jT_SiDenpyoData3 = new JT_SiDenpyoData(P_DENRENNO_02,P_EDANO_03);
        jT_SiDenpyoData3.setSyoriYmd(P_SYORIYMD_02);
        jT_SiDenpyoData3.setDensyskbn(C_DensysKbn.HKSIHARAI);
        siharaiDomManager.insert(jT_SiDenpyoData3);

        JT_SiDenpyoData jT_SiDenpyoData4 = new JT_SiDenpyoData(P_DENRENNO_05,P_EDANO_03);
        jT_SiDenpyoData4.setSyoriYmd(P_SYORIYMD_02);
        jT_SiDenpyoData4.setDensyskbn(C_DensysKbn.NENKIN);
        siharaiDomManager.insert(jT_SiDenpyoData4);

        JT_SiDenpyoData jT_SiDenpyoData5 = new JT_SiDenpyoData(P_DENRENNO_02,P_EDANO_02);
        jT_SiDenpyoData5.setSyoriYmd(P_SYORIYMD_02);
        jT_SiDenpyoData5.setDensyskbn(C_DensysKbn.AGKANRI);
        siharaiDomManager.insert(jT_SiDenpyoData5);

        JT_SiDenpyoData jT_SiDenpyoData6 = new JT_SiDenpyoData(P_DENRENNO_03,P_EDANO_03);
        jT_SiDenpyoData6.setSyoriYmd(P_SYORIYMD_03);
        siharaiDomManager.insert(jT_SiDenpyoData6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiDenpyoData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(jT_SiDenpyoDataResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<JT_SiDenpyoData> iter = jT_SiDenpyoDataResults.iterator();
            JT_SiDenpyoData jT_SiDenpyoData = null;
            while (iter.hasNext()) {

                jT_SiDenpyoData = iter.next();
                iCount++;

                Assert.assertEquals(P_DENRENNO_01, jT_SiDenpyoData.getDenrenno());
                Assert.assertEquals(P_EDANO_01, jT_SiDenpyoData.getEdano());
                Assert.assertEquals(P_SYORIYMD_01, jT_SiDenpyoData.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_01, P_SYORIYMD_02)){

            int iCount = 0;
            Iterator<JT_SiDenpyoData> iter = jT_SiDenpyoDataResults.iterator();
            JT_SiDenpyoData jT_SiDenpyoData = null;
            while (iter.hasNext()) {

                jT_SiDenpyoData = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_DENRENNO_02, jT_SiDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_02, jT_SiDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, jT_SiDenpyoData.getSyoriYmd());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_DENRENNO_02, jT_SiDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, jT_SiDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, jT_SiDenpyoData.getSyoriYmd());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_DENRENNO_04, jT_SiDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, jT_SiDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, jT_SiDenpyoData.getSyoriYmd());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_DENRENNO_05, jT_SiDenpyoData.getDenrenno());
                    Assert.assertEquals(P_EDANO_03, jT_SiDenpyoData.getEdano());
                    Assert.assertEquals(P_SYORIYMD_02, jT_SiDenpyoData.getSyoriYmd());
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
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try(ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_02, P_SYORIYMD_02)) {

            Iterator<JT_SiDenpyoData> iter = jT_SiDenpyoDataResults.iterator();
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
        siharaiDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey1.setTableid("JT_SiDenpyoData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        bT_SkipKey1.setRecoveryfilterkey2(P_DENRENNO_04);

        siharaiDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (JT_SiDenpyoData jT_SiDenpyoData : jT_SiDenpyoDataResults) {

                Assert.assertNotEquals(jT_SiDenpyoData.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(jT_SiDenpyoData.getDenrenno(), P_DENRENNO_04);

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
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("JT_SiDenpyoData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.NENKIN.getValue());
        bT_SkipKey2.setRecoveryfilterkey2(P_DENRENNO_05);

        siharaiDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        try(ExDBUpdatableResults<JT_SiDenpyoData> jT_SiDenpyoDataResults =
            siharaiDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(P_JOB_CD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (JT_SiDenpyoData jT_SiDenpyoData : jT_SiDenpyoDataResults) {

                Assert.assertNotEquals(jT_SiDenpyoData.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(jT_SiDenpyoData.getDenrenno(), P_DENRENNO_04);
                Assert.assertNotEquals(jT_SiDenpyoData.getDensyskbn(), C_DensysKbn.NENKIN);
                Assert.assertNotEquals(jT_SiDenpyoData.getDenrenno(), P_DENRENNO_05);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
