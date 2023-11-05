package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 支払不支払<br />
 * 請求基本テーブルエンティティリスト（大量）取得（拡張ジョブコード、処理状態区分、支払結果区分）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "SKNO01";
    static String P_SKNO_002 = "SKNO02";
    static String P_SKNO_003 = "SKNO03";
    static String P_SKNO_004 = "SKNO04";
    static String P_SYONO_001 = "11807111118";
    static String P_SYONO_002 = "11807111129";
    static String P_SYONO_003 = "11807111130";
    static String P_SYONO_004 = "11807111152";
    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RCA0";
    static String P_FILTER_ID = "Si001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_01, C_SyoriJyoutaiKbn.SYORITYUU, C_ShrKekkaKbn.BLNK)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_001, P_SYONO_001);
        skKihon1.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.BLNK);
        skKihon1.setShrkekkakbn(C_ShrKekkaKbn.HSHR);

        siharaiDomManager.insert(skKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_01, C_SyoriJyoutaiKbn.SYORITYUU, C_ShrKekkaKbn.HSHR)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_001, P_SYONO_002);
        skKihon1.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        skKihon1.setShrkekkakbn(C_ShrKekkaKbn.HSHR);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKNO_003, P_SYONO_004);
        skKihon2.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.KANRYOU);
        skKihon2.setShrkekkakbn(C_ShrKekkaKbn.BLNK);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKNO_004, P_SYONO_003);
        skKihon3.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.KANRYOU);
        skKihon3.setShrkekkakbn(C_ShrKekkaKbn.SHR);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon(P_SKNO_002, P_SYONO_002);
        skKihon4.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        skKihon4.setShrkekkakbn(C_ShrKekkaKbn.BLNK);

        siharaiDomManager.insert(skKihon4);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_01, C_SyoriJyoutaiKbn.SYORITYUU, C_ShrKekkaKbn.BLNK)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = beans.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                Assert.assertEquals(P_SKNO_001, jT_SkKihon.getSkno());
                Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, jT_SkKihon.getSyorijyoutaikbn());
                Assert.assertEquals(C_ShrKekkaKbn.HSHR, jT_SkKihon.getShrkekkakbn());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_01, C_SyoriJyoutaiKbn.SYORITYUU, C_ShrKekkaKbn.HSHR)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = beans.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_SKNO_001, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.HSHR, jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SKNO_002, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.BLNK, jT_SkKihon.getShrkekkakbn());

                    continue;
                }
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal3() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_01, C_SyoriJyoutaiKbn.KANRYOU, C_ShrKekkaKbn.BLNK)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = beans.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_SKNO_001, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_001, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.BLNK, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.HSHR, jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SKNO_001, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.HSHR, jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SKNO_004, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_003, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.KANRYOU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.SHR, jT_SkKihon.getShrkekkakbn());

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal4() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_01, C_SyoriJyoutaiKbn.BLNK, C_ShrKekkaKbn.HSHR)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = beans.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_SKNO_001, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_001, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.BLNK, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.HSHR, jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SKNO_001,jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_002,jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU,jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.HSHR,jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SKNO_002, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.SYORITYUU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.BLNK, jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(P_SKNO_004, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_003, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.KANRYOU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.SHR, jT_SkKihon.getShrkekkakbn());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(P_SKNO_003, jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_004, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SyoriJyoutaiKbn.KANRYOU, jT_SkKihon.getSyorijyoutaikbn());
                    Assert.assertEquals(C_ShrKekkaKbn.BLNK, jT_SkKihon.getShrkekkakbn());

                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(59)
    @Transactional
    public void testSkippedFilter59(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_02, C_SyoriJyoutaiKbn.BLNK, C_ShrKekkaKbn.HSHR)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = beans.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testSkippedFilter70(){
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("請求基本フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("syono");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("skno");
        siharaiDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("JT_SkKihon");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_SYONO_003);
        bT_SkipKey1.setRecoveryfilterkey2(P_SKNO_004);
        siharaiDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(71)
    @Transactional
    public void testSkippedFilter71() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_02, C_SyoriJyoutaiKbn.BLNK, C_ShrKekkaKbn.HSHR)) {

            int iCount = 0;
            for (JT_SkKihon jT_SkKihon : beans) {

                Assert.assertNotEquals(jT_SkKihon.getSyono(), P_SYONO_003);
                Assert.assertNotEquals(jT_SkKihon.getSkno(), P_SKNO_004);

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testSkippedFilter80(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("JT_SkKihon");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_SYONO_004);
        bT_SkipKey2.setRecoveryfilterkey2(P_SKNO_003);
        siharaiDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(81)
    @Transactional
    public void testSkippedFilter81() {

        try(ExDBUpdatableResults<JT_SkKihon> beans =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(P_KAKUTYOUJOBCD_02, C_SyoriJyoutaiKbn.BLNK, C_ShrKekkaKbn.HSHR)) {

            int iCount = 0;
            for (JT_SkKihon jT_SkKihon : beans) {

                Assert.assertNotEquals(jT_SkKihon.getSyono(), P_SYONO_003);
                Assert.assertNotEquals(jT_SkKihon.getSkno(), P_SKNO_004);

                Assert.assertNotEquals(jT_SkKihon.getSyono(), P_SYONO_004);
                Assert.assertNotEquals(jT_SkKihon.getSkno(), P_SKNO_003);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
