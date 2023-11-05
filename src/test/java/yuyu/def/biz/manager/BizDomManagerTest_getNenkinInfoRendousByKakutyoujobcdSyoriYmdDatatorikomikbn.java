package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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

import yuyu.def.classification.C_DatatorikomiKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_NenkinInfoRendou;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金情報取込<br />
 * 年金情報連動テーブルエンティティリスト（大量）取得(拡張ジョブコード、処理年月日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn {

    @Inject
    BizDomManager bizDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RDA0";
    static String P_FILTER_ID = "Nk002";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_SYONO_05 = "11807111152";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160209");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160210");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160219");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160220");
    static BizDate P_SYORIYMD_05 = BizDate.valueOf("20160221");
    static BizDate P_SYORIYMD_06 = BizDate.valueOf("20150214");
    static Integer P_RENNO_01 = new Integer(10);
    static Integer P_RENNO_02 = new Integer(20);
    static Integer P_RENNO_03 = new Integer(30);
    static Integer P_RENNO_04 = new Integer(40);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_01, P_SYORIYMD_02)) {

            Assert.assertFalse(bT_NenkinInfoRendouResults.iterator().hasNext());
        }

        BT_NenkinInfoRendou bT_NenkinInfoRendou1 = new BT_NenkinInfoRendou(P_SYORIYMD_01, P_SYONO_01, P_RENNO_01);
        bT_NenkinInfoRendou1.setDatatorikomikbn(C_DatatorikomiKbn.TORIKOMIZUMI);

        bizDomManager.insert(bT_NenkinInfoRendou1);

        BT_NenkinInfoRendou bT_NenkinInfoRendou2 = new BT_NenkinInfoRendou(P_SYORIYMD_02, P_SYONO_02, P_RENNO_02);
        bT_NenkinInfoRendou2.setDatatorikomikbn(C_DatatorikomiKbn.MITORIKOMI);

        bizDomManager.insert(bT_NenkinInfoRendou2);

        BT_NenkinInfoRendou bT_NenkinInfoRendou4 = new BT_NenkinInfoRendou(P_SYORIYMD_04, P_SYONO_04, P_RENNO_04);
        bT_NenkinInfoRendou4.setDatatorikomikbn(C_DatatorikomiKbn.MITORIKOMI);

        bizDomManager.insert(bT_NenkinInfoRendou4);

        BT_NenkinInfoRendou bT_NenkinInfoRendou3 = new BT_NenkinInfoRendou(P_SYORIYMD_03, P_SYONO_03, P_RENNO_03);
        bT_NenkinInfoRendou3.setDatatorikomikbn(C_DatatorikomiKbn.MITORIKOMI);

        bizDomManager.insert(bT_NenkinInfoRendou3);

        BT_NenkinInfoRendou bT_NenkinInfoRendou5 = new BT_NenkinInfoRendou(P_SYORIYMD_05, P_SYONO_05, P_RENNO_01);
        bT_NenkinInfoRendou5.setDatatorikomikbn(C_DatatorikomiKbn.MITORIKOMI);

        bizDomManager.insert(bT_NenkinInfoRendou5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllNenkinInfoRendou());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_01, P_SYORIYMD_06)) {

            Assert.assertFalse(bT_NenkinInfoRendouResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_01, P_SYORIYMD_02)) {

            int iCount = 0;
            for (BT_NenkinInfoRendou bT_NenkinInfoRendou : bT_NenkinInfoRendouResults) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_SYORIYMD_02, bT_NenkinInfoRendou.getSyoriYmd());
                    Assert.assertEquals(P_SYONO_02, bT_NenkinInfoRendou.getSyono());
                    Assert.assertEquals(P_RENNO_02, bT_NenkinInfoRendou.getRenno());
                    Assert.assertEquals(C_DatatorikomiKbn.MITORIKOMI, bT_NenkinInfoRendou.getDatatorikomikbn());
                }

                Assert.assertEquals(1, iCount);
            }
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_01, P_SYORIYMD_04)) {

            int iCount = 0;
            for (BT_NenkinInfoRendou bT_NenkinInfoRendou : bT_NenkinInfoRendouResults) {

                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_SYORIYMD_02, bT_NenkinInfoRendou.getSyoriYmd());
                    Assert.assertEquals(P_SYONO_02, bT_NenkinInfoRendou.getSyono());
                    Assert.assertEquals(P_RENNO_02, bT_NenkinInfoRendou.getRenno());
                    Assert.assertEquals(C_DatatorikomiKbn.MITORIKOMI, bT_NenkinInfoRendou.getDatatorikomikbn());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SYORIYMD_03, bT_NenkinInfoRendou.getSyoriYmd());
                    Assert.assertEquals(P_SYONO_03, bT_NenkinInfoRendou.getSyono());
                    Assert.assertEquals(P_RENNO_03, bT_NenkinInfoRendou.getRenno());
                    Assert.assertEquals(C_DatatorikomiKbn.MITORIKOMI, bT_NenkinInfoRendou.getDatatorikomikbn());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SYORIYMD_04, bT_NenkinInfoRendou.getSyoriYmd());
                    Assert.assertEquals(P_SYONO_04, bT_NenkinInfoRendou.getSyono());
                    Assert.assertEquals(P_RENNO_04, bT_NenkinInfoRendou.getRenno());
                    Assert.assertEquals(C_DatatorikomiKbn.MITORIKOMI, bT_NenkinInfoRendou.getDatatorikomikbn());

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
    @Transactional
    public void testSkippedFilter11() {

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_02, P_SYORIYMD_04)) {

            Iterator<BT_NenkinInfoRendou> iter = bT_NenkinInfoRendouResults.iterator();
            int iCount = 0;
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

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("年金連動フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("syoriYmd");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("syono");
        bM_RecoveryFilter.setRecoveryfilterkeykmid3("renno");
        bizDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey1.setTableid("BT_NenkinInfoRendou");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(String.valueOf(P_SYORIYMD_02));
        bT_SkipKey1.setRecoveryfilterkey2(P_SYONO_02);
        bT_SkipKey1.setRecoveryfilterkey3(String.valueOf(P_RENNO_02));
        bizDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20() {

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_02, P_SYORIYMD_04)) {

            int iCount = 0;
            for (BT_NenkinInfoRendou bT_NenkinInfoRendou : bT_NenkinInfoRendouResults) {

                assertNotEquals(bT_NenkinInfoRendou.getSyoriYmd(), P_SYORIYMD_02);
                assertNotEquals(bT_NenkinInfoRendou.getSyono(), P_SYONO_02);
                assertNotEquals(bT_NenkinInfoRendou.getRenno(), P_RENNO_02);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("BT_NenkinInfoRendou");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(String.valueOf(P_SYORIYMD_03));
        bT_SkipKey2.setRecoveryfilterkey2(P_SYONO_03);
        bT_SkipKey2.setRecoveryfilterkey3(String.valueOf(P_RENNO_03));
        bizDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3() {

        try (ExDBUpdatableResults<BT_NenkinInfoRendou> bT_NenkinInfoRendouResults = bizDomManager.
            getNenkinInfoRendousByKakutyoujobcdSyoriYmdDatatorikomikbn(P_JOB_CD_02, P_SYORIYMD_04)) {

            int iCount = 0;
            for (BT_NenkinInfoRendou bT_NenkinInfoRendou : bT_NenkinInfoRendouResults) {

                assertNotEquals(bT_NenkinInfoRendou.getSyoriYmd(), P_SYORIYMD_02);
                assertNotEquals(bT_NenkinInfoRendou.getSyono(), P_SYONO_02);
                assertNotEquals(bT_NenkinInfoRendou.getRenno(), P_RENNO_02);

                assertNotEquals(bT_NenkinInfoRendou.getSyoriYmd(), P_SYORIYMD_03);
                assertNotEquals(bT_NenkinInfoRendou.getSyono(), P_SYONO_03);
                assertNotEquals(bT_NenkinInfoRendou.getRenno(), P_RENNO_03);
                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
