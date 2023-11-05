package yuyu.def.direct.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * 顧客状態精査<br />
 * ＤＳ顧客管理テーブルエンティティリスト（大量）更新（拡張ジョブコード）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj {

    @Inject
    DirectDomManager directDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGUO";
    static String P_FILTER_ID = "Ds001";
    static String DSKOKNO_01 = "1001";
    static String DSKOKNO_02 = "1002";
    static String DSKOKNO_03 = "1003";
    static String DSKOKNO_04 = "1004";
    static String DSKOKNO_05 = "1005";
    static String DSKOKNO_06 = "1006";
    static String DSKOKNO_07 = "1007";
    static String SYONO_01 = "11807111141";
    static String SYONO_02 = "11807111152";
    static String SYONO_03 = "11807111163";
    static String SYONO_04 = "11807111174";
    static String SYONO_05 = "11807111185";
    static String SYONO_06 = "11807111196";
    static String SYONO_07 = "11807111277";
    static String SYONO_08 = "11807111288";

    @BeforeClass
    @Transactional()
    public static void preProcess(){

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_01)) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri(DSKOKNO_01);
        mT_DsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.KAIYAKU);
        mT_DsKokyakuKanri1.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku1 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku1.setSyono(SYONO_01);
        mT_DsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri(DSKOKNO_02);
        mT_DsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
        mT_DsKokyakuKanri2.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku2 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku2.setSyono(SYONO_02);
        mT_DsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri2);

        MT_DsKokyakuKanri mT_DsKokyakuKanri3 = new MT_DsKokyakuKanri(DSKOKNO_03);
        mT_DsKokyakuKanri3.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        mT_DsKokyakuKanri3.setSeisahuyouhyj(C_SeisaHuyouHyj.SEISA_HUYOU);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku3 = mT_DsKokyakuKanri3.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku3.setSyono(SYONO_03);
        mT_DsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult10() {

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_01)) {

            Assert.assertFalse(exDBUpdatableResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri(DSKOKNO_04);
        mT_DsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        mT_DsKokyakuKanri1.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku1 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku1.setSyono(SYONO_04);
        mT_DsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku2 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku2.setSyono(SYONO_05);
        mT_DsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri(DSKOKNO_05);
        mT_DsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        mT_DsKokyakuKanri2.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku3 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku3.setSyono(SYONO_06);
        mT_DsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri2);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_01)) {

            int iCount = 0;
            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();
                iCount++;

                Assert.assertEquals(DSKOKNO_05, mT_DsKokyakuKanri.getDskokno());
                Assert.assertEquals(C_DsKokyakuJtKbn.BLANK, mT_DsKokyakuKanri.getDskokyakujtkbn());
                Assert.assertEquals(C_SeisaHuyouHyj.BLANK, mT_DsKokyakuKanri.getSeisahuyouhyj());
            }

            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri(DSKOKNO_06);
        mT_DsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        mT_DsKokyakuKanri1.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku1 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku1.setSyono(SYONO_07);
        mT_DsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri(DSKOKNO_07);
        mT_DsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        mT_DsKokyakuKanri2.setSeisahuyouhyj(C_SeisaHuyouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku2 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku2.setSyono(SYONO_08);
        mT_DsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri2);
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1005","0","0"), "1");
        datamap.put($("1006","1","0"), "2");
        datamap.put($("1007","2","0"), "3");

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_01)) {

            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
            MT_DsKokyakuKanri mT_DsKokyakuKanri = null;
            while (iter.hasNext()) {

                mT_DsKokyakuKanri = iter.next();

                datamap.remove($(mT_DsKokyakuKanri.getDskokno(),mT_DsKokyakuKanri.getDskokyakujtkbn(),mT_DsKokyakuKanri.getSeisahuyouhyj()));

            }

            Assert.assertTrue(datamap.isEmpty());
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_02)) {

            int iCount = 0;
            Iterator<MT_DsKokyakuKanri> iter = exDBUpdatableResults.iterator();
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
    public void testSkippedFilter50() {
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("ＤＳ顧客管理テーブル");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("dskokno");
        directDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("MT_DsKokyakuKanri");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(DSKOKNO_05);
        directDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_02)) {

            int iCount = 0;
            for (MT_DsKokyakuKanri exDBUpdatableResult : exDBUpdatableResults) {

                Assert.assertNotEquals(exDBUpdatableResult.getDskokno(), DSKOKNO_05);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("MT_DsKokyakuKanri");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(DSKOKNO_06);
        directDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> exDBUpdatableResults =
            directDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(P_KAKUTYOUJOBCD_02)) {

            int iCount = 0;
            for (MT_DsKokyakuKanri exDBUpdatableResult : exDBUpdatableResults) {

                Assert.assertNotEquals(exDBUpdatableResult.getDskokno(), DSKOKNO_05);
                Assert.assertNotEquals(exDBUpdatableResult.getDskokno(), DSKOKNO_06);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
