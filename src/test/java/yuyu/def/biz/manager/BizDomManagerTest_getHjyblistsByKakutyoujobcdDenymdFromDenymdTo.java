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

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 補助簿リスト用テーブルリスト作成<br />
 * 補助簿リスト用テーブルエンティティリスト（大量）取得（拡張ジョブコード、伝票日付（自）、伝票日付（至））のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getHjyblistsByKakutyoujobcdDenymdFromDenymdTo {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess(){

        deleteTestSubData();


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_Hjyblist> denpyoDataExDBResults =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161228), BizDate.valueOf(20161228))) {

            Assert.assertFalse(denpyoDataExDBResults.iterator().hasNext());
        }

        insertSubData();

    }

    @Transactional()
    public static void insertSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_Hjyblist hjyblist1 = new BT_Hjyblist("t01", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "101", BizDate.valueOf(20161228));

        bizDomManager.insert(hjyblist1);

        BT_Hjyblist hjyblist2 = new BT_Hjyblist("t13", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "113", BizDate.valueOf(20161214));

        bizDomManager.insert(hjyblist2);

        BT_Hjyblist hjyblist3 = new BT_Hjyblist("t13", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "113", BizDate.valueOf(20161210));

        bizDomManager.insert(hjyblist3);

        BT_Hjyblist hjyblist4 = new BT_Hjyblist("t13", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "113", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist4);

        BT_Hjyblist hjyblist5 = new BT_Hjyblist("t12", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "113", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist5);

        BT_Hjyblist hjyblist6 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "113", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist6);

        BT_Hjyblist hjyblist7 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "113", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist7);

        BT_Hjyblist hjyblist8 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "113", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist8);

        BT_Hjyblist hjyblist9 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "112", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist9);

        BT_Hjyblist hjyblist10 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "111", BizDate.valueOf(20161213));

        bizDomManager.insert(hjyblist10);

        BT_Hjyblist hjyblist11 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "111", BizDate.valueOf(20161212));

        bizDomManager.insert(hjyblist11);

        BT_Hjyblist hjyblist12 = new BT_Hjyblist("t11", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "111", BizDate.valueOf(20161211));

        bizDomManager.insert(hjyblist12);

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_Hjyblist> denpyoDataExDBResults =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161229), BizDate.valueOf(20161231))) {

            Assert.assertFalse(denpyoDataExDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_Hjyblist> denpyoDataExDBResults =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161228), BizDate.valueOf(20161228))) {

            int iCount = 0;
            Iterator<BT_Hjyblist> iter = denpyoDataExDBResults.iterator();
            BT_Hjyblist bT_Hjyblist = null;
            while (iter.hasNext()) {

                bT_Hjyblist = iter.next();
                iCount++;

                Assert.assertEquals("t01", bT_Hjyblist.getHjybtantositucd());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, bT_Hjyblist.getKanjyoukmkcd());
                Assert.assertEquals("101", bT_Hjyblist.getSyorisyokantantcd());
                Assert.assertEquals(BizDate.valueOf(20161228), bT_Hjyblist.getDenymd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_Hjyblist> denpyoDataExDBResults =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161211), BizDate.valueOf(20161213))) {

            int iCount = 0;
            Iterator<BT_Hjyblist> iter = denpyoDataExDBResults.iterator();
            BT_Hjyblist bT_Hjyblist = null;
            while (iter.hasNext()) {

                bT_Hjyblist = iter.next();
                iCount++;

                if (iCount == 1) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("111", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161211), bT_Hjyblist.getDenymd());
                }

                if (iCount == 2) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("111", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161212), bT_Hjyblist.getDenymd());
                }

                if (iCount == 3) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("111", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }

                if (iCount == 4) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("112", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }

                if (iCount == 5) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("113", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }

                if (iCount == 6) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("113", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }

                if (iCount == 7) {

                    Assert.assertEquals("t11", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("113", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }

                if (iCount == 8) {

                    Assert.assertEquals("t12", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("113", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }

                if (iCount == 9) {

                    Assert.assertEquals("t13", bT_Hjyblist.getHjybtantositucd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, bT_Hjyblist.getKanjyoukmkcd());
                    Assert.assertEquals("113", bT_Hjyblist.getSyorisyokantantcd());
                    Assert.assertEquals(BizDate.valueOf(20161213), bT_Hjyblist.getDenymd());
                }
            }

            Assert.assertEquals(9, iCount);
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
        try (ExDBResults<BT_Hjyblist> bT_Hjyblist =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161211), BizDate.valueOf(20161213))) {


            int iCount = 0;
            Iterator<BT_Hjyblist> iter = bT_Hjyblist.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(9, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz106");
        recoveryFilter1.setRecoveryfilternm("補助簿リストフィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("hjybtantositucd");
        recoveryFilter1.setRecoveryfilterkeykmid2("kanjyoukmkcd");
        recoveryFilter1.setRecoveryfilterkeykmid3("syorisyokantantcd");
        recoveryFilter1.setRecoveryfilterkeykmid4("denymd");

        bizDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RGBG");
        skipKey1.setTableid("BT_Hjyblist");
        skipKey1.setRecoveryfilterid("Bz106");
        skipKey1.setRecoveryfilterkey1("t11");
        skipKey1.setRecoveryfilterkey2("27229");
        skipKey1.setRecoveryfilterkey3("111");
        skipKey1.setRecoveryfilterkey4("20161211");

        bizDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20() {

        try (ExDBResults<BT_Hjyblist> bT_DenpyoDataResults =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161211), BizDate.valueOf(20161213))) {

            int iCount = 0;
            Iterator<BT_Hjyblist> iter = bT_DenpyoDataResults.iterator();
            BT_Hjyblist bT_Hjyblist = null;
            while (iter.hasNext()) {

                bT_Hjyblist = iter.next();

                boolean result1 = (bT_Hjyblist.getHjybtantositucd().equals("t11"))
                    && (bT_Hjyblist.getKanjyoukmkcd().equals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY))
                    && (bT_Hjyblist.getSyorisyokantantcd().equals("111"))
                    && (bT_Hjyblist.getDenymd().equals(BizDate.valueOf(20161211)));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(8, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RGBG");
        skipKey2.setTableid("BT_Hjyblist");
        skipKey2.setRecoveryfilterid("Bz106");
        skipKey2.setRecoveryfilterkey1("t11");
        skipKey2.setRecoveryfilterkey2("27229");
        skipKey2.setRecoveryfilterkey3("111");
        skipKey2.setRecoveryfilterkey4("20161212");

        bizDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3() {

        try (ExDBResults<BT_Hjyblist> bT_DenpyoDataResults =
            bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo("RGBG", BizDate.valueOf(20161211), BizDate.valueOf(20161213))) {

            int iCount = 0;
            Iterator<BT_Hjyblist> iter = bT_DenpyoDataResults.iterator();
            BT_Hjyblist bT_Hjyblist = null;
            while (iter.hasNext()) {

                bT_Hjyblist = iter.next();

                boolean result1 = (bT_Hjyblist.getHjybtantositucd().equals("t11"))
                    && (bT_Hjyblist.getKanjyoukmkcd().equals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY))
                    && (bT_Hjyblist.getSyorisyokantantcd().equals("111"))
                    && (bT_Hjyblist.getDenymd().equals(BizDate.valueOf(20161211)));

                boolean result2 = (bT_Hjyblist.getHjybtantositucd().equals("t11"))
                    && (bT_Hjyblist.getKanjyoukmkcd().equals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY))
                    && (bT_Hjyblist.getSyorisyokantantcd().equals("111"))
                    && (bT_Hjyblist.getDenymd().equals(BizDate.valueOf(20161212)));

                assertFalse(result1 || result2);

                iCount++;
            }

            Assert.assertEquals(7, iCount);
        }
    }

    @AfterClass
    @Transactional()
    public static void deleteTestSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHjyblist());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

}
