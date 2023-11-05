package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 経理伝票データテーブル作成処理(保全)<br />
 * 契約保全伝票データエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhDenpyoDatasByKakutyoujobcdSyoriYmd {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGAB";
    static String P_FILTER_ID = "Bz105";
    static String P_DENRENNO_01 = "DENRENNO01";
    static String P_DENRENNO_02 = "DENRENNO02";
    static String P_DENRENNO_03 = "DENRENNO03";
    static String P_DENRENNO_04 = "DENRENNO04";
    static BizDate P_SYORIYM_01 = BizDate.valueOf("20160301");
    static BizDate P_SYORIYM_02 = BizDate.valueOf("20160302");
    static BizDate P_SYORIYM_03 = BizDate.valueOf("20160303");
    static BizDate P_SYORIYM_04 = BizDate.valueOf("20160304");

    @BeforeClass
    @Transactional()
    public static void insertTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYM_01)) {

            Assert.assertFalse(iT_KhDenpyoDatas.iterator().hasNext());
        }

        IT_KhDenpyoData khDenpyoData1 = new IT_KhDenpyoData(P_DENRENNO_01, 1);
        khDenpyoData1.setSyoriYmd(P_SYORIYM_01);
        khDenpyoData1.setDensyskbn(C_DensysKbn.AGKANRI);

        hozenDomManager.insert(khDenpyoData1);

        IT_KhDenpyoData khDenpyoData2 = new IT_KhDenpyoData(P_DENRENNO_04, 1);
        khDenpyoData2.setSyoriYmd(P_SYORIYM_02);
        khDenpyoData2.setDensyskbn(C_DensysKbn.HOZEN);

        hozenDomManager.insert(khDenpyoData2);

        IT_KhDenpyoData khDenpyoData3 = new IT_KhDenpyoData(P_DENRENNO_03, 1);
        khDenpyoData3.setSyoriYmd(P_SYORIYM_02);
        khDenpyoData3.setDensyskbn(C_DensysKbn.NENKIN);

        hozenDomManager.insert(khDenpyoData3);

        IT_KhDenpyoData khDenpyoData4 = new IT_KhDenpyoData(P_DENRENNO_02, 3);
        khDenpyoData4.setSyoriYmd(P_SYORIYM_03);
        khDenpyoData4.setDensyskbn(C_DensysKbn.AGKANRI);

        hozenDomManager.insert(khDenpyoData4);

        IT_KhDenpyoData khDenpyoData5 = new IT_KhDenpyoData(P_DENRENNO_02, 2);
        khDenpyoData5.setSyoriYmd(P_SYORIYM_02);
        khDenpyoData5.setDensyskbn(C_DensysKbn.AGKANRI);

        hozenDomManager.insert(khDenpyoData5);

        IT_KhDenpyoData khDenpyoData6 = new IT_KhDenpyoData(P_DENRENNO_02, 1);
        khDenpyoData6.setSyoriYmd(P_SYORIYM_02);
        khDenpyoData6.setDensyskbn(C_DensysKbn.AGKANRI);

        hozenDomManager.insert(khDenpyoData6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhDenpyoData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {


        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYM_04)) {

            Assert.assertFalse(iT_KhDenpyoDatas.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {


        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYM_01)) {

            int iCount = 0;
            Iterator<IT_KhDenpyoData> iter = iT_KhDenpyoDatas.iterator();
            IT_KhDenpyoData iT_KhDenpyoData = null;
            while (iter.hasNext()) {

                iT_KhDenpyoData = iter.next();
                iCount++;

                Assert.assertEquals(P_DENRENNO_01, iT_KhDenpyoData.getDenrenno());
                Assert.assertEquals(1, iT_KhDenpyoData.getEdano().intValue());
                Assert.assertEquals(P_SYORIYM_01, iT_KhDenpyoData.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {


        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYM_02)) {

            int iCount = 0;
            Iterator<IT_KhDenpyoData> iter = iT_KhDenpyoDatas.iterator();
            IT_KhDenpyoData iT_KhDenpyoData = null;
            while (iter.hasNext()) {

                iT_KhDenpyoData = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_DENRENNO_02, iT_KhDenpyoData.getDenrenno());
                    Assert.assertEquals(1, iT_KhDenpyoData.getEdano().intValue());
                    Assert.assertEquals(P_SYORIYM_02, iT_KhDenpyoData.getSyoriYmd());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_DENRENNO_02, iT_KhDenpyoData.getDenrenno());
                    Assert.assertEquals(2, iT_KhDenpyoData.getEdano().intValue());
                    Assert.assertEquals(P_SYORIYM_02, iT_KhDenpyoData.getSyoriYmd());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_DENRENNO_03, iT_KhDenpyoData.getDenrenno());
                    Assert.assertEquals(1, iT_KhDenpyoData.getEdano().intValue());
                    Assert.assertEquals(P_SYORIYM_02, iT_KhDenpyoData.getSyoriYmd());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_DENRENNO_04, iT_KhDenpyoData.getDenrenno());
                    Assert.assertEquals(1, iT_KhDenpyoData.getEdano().intValue());
                    Assert.assertEquals(P_SYORIYM_02, iT_KhDenpyoData.getSyoriYmd());

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter1() {

        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYM_02)) {

            int iCount = 0;
            Iterator<IT_KhDenpyoData> iter = iT_KhDenpyoDatas.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("伝票データフィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("densyskbn");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("denrenno");
        hozenDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("IT_KhDenpyoData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(C_DensysKbn.HOZEN.getValue());
        bT_SkipKey1.setRecoveryfilterkey2(P_DENRENNO_04);

        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter2() {

        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYM_02)) {

            int iCount = 0;
            for (IT_KhDenpyoData iT_KhDenpyoData : iT_KhDenpyoDatas) {

                Assert.assertNotEquals(iT_KhDenpyoData.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(iT_KhDenpyoData.getDenrenno(), P_DENRENNO_04);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("IT_KhDenpyoData");
        bT_SkipKey2.setRecoveryfilterkey1(C_DensysKbn.NENKIN.getValue());
        bT_SkipKey2.setRecoveryfilterkey2(P_DENRENNO_03);

        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3() {

        try (ExDBUpdatableResults<IT_KhDenpyoData> iT_KhDenpyoDatas = hozenDomManager
                .getKhDenpyoDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYM_02)) {

            int iCount = 0;
            for (IT_KhDenpyoData iT_KhDenpyoData : iT_KhDenpyoDatas) {

                Assert.assertNotEquals(iT_KhDenpyoData.getDensyskbn(), C_DensysKbn.HOZEN);
                Assert.assertNotEquals(iT_KhDenpyoData.getDensyskbn(), C_DensysKbn.NENKIN);
                Assert.assertNotEquals(iT_KhDenpyoData.getDenrenno(), P_DENRENNO_04);
                Assert.assertNotEquals(iT_KhDenpyoData.getDenrenno(), P_DENRENNO_03);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
