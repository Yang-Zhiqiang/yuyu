package yuyu.def.sinkeiyaku.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ削除<br />
 * 振込入金削除テーブルエンティティリスト（大量）取得（拡張ジョブコード、処理済フラグ）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RG1A";
    static String P_FILTER_ID = "Sk003";
    static String P_HRKMDELDATASKBTKEY_01 = "HKEY0000001";
    static String P_HRKMDELDATASKBTKEY_02 = "HKEY0000002";
    static String P_HRKMDELDATASKBTKEY_03 = "HKEY0000003";
    static String P_HRKMDELDATASKBTKEY_04 = "HKEY0000004";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_01, C_Syorizumiflg.MISYORI)) {

            Assert.assertFalse(exDBUpResBean.iterator().hasNext());
        }

        HT_HrkmNyknSakujyo hrkmNyknSakujyo1 = new HT_HrkmNyknSakujyo("HKEY0000003");
        hrkmNyknSakujyo1.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hrkmNyknSakujyo1.setGyoumuKousinTime("20170111132020123");

        sinkeiyakuDomManager.insert(hrkmNyknSakujyo1);

        HT_HrkmNyknSakujyo hrkmNyknSakujyo2 = new HT_HrkmNyknSakujyo("HKEY0000002");
        hrkmNyknSakujyo2.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hrkmNyknSakujyo2.setGyoumuKousinTime("20170111132020124");

        sinkeiyakuDomManager.insert(hrkmNyknSakujyo2);

        HT_HrkmNyknSakujyo hrkmNyknSakujyo3 = new HT_HrkmNyknSakujyo("HKEY0000001");
        hrkmNyknSakujyo3.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hrkmNyknSakujyo3.setGyoumuKousinTime("20170111132020125");

        sinkeiyakuDomManager.insert(hrkmNyknSakujyo3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknSakujyo());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            Assert.assertFalse(exDBUpResBean.iterator().hasNext());
        }

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo4 = new HT_HrkmNyknSakujyo(P_HRKMDELDATASKBTKEY_04);
        hT_HrkmNyknSakujyo4.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(hT_HrkmNyknSakujyo4);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            int iCount = 0;
            Iterator<HT_HrkmNyknSakujyo> iter = exDBUpResBean.iterator();
            HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo = null;
            while (iter.hasNext()) {

                hT_HrkmNyknSakujyo = iter.next();
                iCount++;

                Assert.assertEquals(P_HRKMDELDATASKBTKEY_04, hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey());
                Assert.assertEquals(C_Syorizumiflg.SYORIZUMI, hT_HrkmNyknSakujyo.getSyorizumiflg());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_01, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_HrkmNyknSakujyo> iter = exDBUpResBean.iterator();
            HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo = null;
            while (iter.hasNext()) {

                hT_HrkmNyknSakujyo = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_HRKMDELDATASKBTKEY_01, hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknSakujyo.getSyorizumiflg());
                    Assert.assertEquals("20170111132020125", hT_HrkmNyknSakujyo.getGyoumuKousinTime());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_HRKMDELDATASKBTKEY_02, hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknSakujyo.getSyorizumiflg());
                    Assert.assertEquals("20170111132020124", hT_HrkmNyknSakujyo.getGyoumuKousinTime());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_HRKMDELDATASKBTKEY_03, hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey());
                    Assert.assertEquals(C_Syorizumiflg.MISYORI, hT_HrkmNyknSakujyo.getSyorizumiflg());
                    Assert.assertEquals("20170111132020123", hT_HrkmNyknSakujyo.getGyoumuKousinTime());

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
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

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<HT_HrkmNyknSakujyo> iter = exDBUpResBean.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("振込入金削除フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("hrkmdeldataskbtkey");
        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("HT_HrkmNyknSakujyo");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_HRKMDELDATASKBTKEY_01);

        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo : exDBUpResBean) {

                Assert.assertNotEquals(hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey(), P_HRKMDELDATASKBTKEY_01);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("HT_HrkmNyknSakujyo");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_HRKMDELDATASKBTKEY_02);

        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBUpdatableResults<HT_HrkmNyknSakujyo> exDBUpResBean = sinkeiyakuDomManager
            .getHrkmNyknSakujyosByKakutyoujobcdSyorizumiflg(P_KAKUTYOUJOBCD_02, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo : exDBUpResBean) {

                Assert.assertNotEquals(hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey(), P_HRKMDELDATASKBTKEY_01);
                Assert.assertNotEquals(hT_HrkmNyknSakujyo.getHrkmdeldataskbtkey(), P_HRKMDELDATASKBTKEY_02);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
