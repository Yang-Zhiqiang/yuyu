package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
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

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 手続完了（住所変更）Ｆ作成<br />
 * 手続完了テーブルエンティティリスト（大量）取得（拡張ジョブコード、帳票作成日、書類コード）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_KAKUCHOJOBCD_01 = "JCD01";
    static String P_KAKUCHOJOBCD_02 = "RBT9";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111141";
    static String P_HENKOUSIKIBETUDEY_01 = "1111111";
    static String P_HENKOUSIKIBETUDEY_02 = "2222222";
    static String P_HENKOUSIKIBETUDEY_03 = "3333333";
    static String P_HENKOUSIKIBETUDEY_04 = "4444444";
    static String P_HENKOUSIKIBETUDEY_05 = "5555555";
    static String P_HENKOUSIKIBETUDEY_06 = "6666666";
    static String P_HENKOUSIKIBETUDEY_07 = "7777777";
    static String P_HENKOUSIKIBETUDEY_08 = "8888888";
    static BizDate P_TYOUHYOUYMD_01 = BizDate.valueOf("20160331");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_01, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.BLNK)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_TtdkKan iT_TtdkKan1 = iT_KykKihon1.createTtdkKan();
        iT_TtdkKan1.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_01);
        iT_TtdkKan1.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        iT_TtdkKan1.setTyouhyouymd(BizDate.valueOf("20160331"));

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_TtdkKan iT_TtdkKan2 = iT_KykKihon2.createTtdkKan();
        iT_TtdkKan2.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_01);
        iT_TtdkKan2.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        iT_TtdkKan2.setTyouhyouymd(BizDate.valueOf("20160331"));

        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);

        IT_TtdkKan iT_TtdkKan3 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan3.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_01);
        iT_TtdkKan3.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
        iT_TtdkKan3.setTyouhyouymd(BizDate.valueOf("20160331"));

        IT_TtdkKan iT_TtdkKan4 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan4.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_02);
        iT_TtdkKan4.setSyoruiCd(C_SyoruiCdKbn.USERITIRANHYOU);
        iT_TtdkKan4.setTyouhyouymd(BizDate.valueOf("20160331"));

        IT_TtdkKan iT_TtdkKan5 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan5.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_03);
        iT_TtdkKan5.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        iT_TtdkKan5.setTyouhyouymd(BizDate.valueOf("20160330"));

        IT_TtdkKan iT_TtdkKan6 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan6.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_04);
        iT_TtdkKan6.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        iT_TtdkKan6.setTyouhyouymd(BizDate.valueOf("20160331"));

        IT_TtdkKan iT_TtdkKan7 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan7.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_05);
        iT_TtdkKan7.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);
        iT_TtdkKan7.setTyouhyouymd(BizDate.valueOf("20160331"));

        IT_TtdkKan iT_TtdkKan8 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan8.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_06);
        iT_TtdkKan8.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        iT_TtdkKan8.setTyouhyouymd(BizDate.valueOf("20160331"));

        IT_TtdkKan iT_TtdkKan9 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan9.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_07);
        iT_TtdkKan9.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        iT_TtdkKan9.setTyouhyouymd(BizDate.valueOf("20160331"));

        IT_TtdkKan iT_TtdkKan10 = iT_KykKihon3.createTtdkKan();
        iT_TtdkKan10.setHenkousikibetukey(P_HENKOUSIKIBETUDEY_08);
        iT_TtdkKan10.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        iT_TtdkKan10.setTyouhyouymd(BizDate.valueOf("20160331"));

        hozenDomManager.insert(iT_KykKihon3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_01, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.HK_SOUHU)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_01, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.BLNK)) {

            int iCount = 0;
            Iterator<IT_TtdkKan> iter = exDBResults.iterator();
            IT_TtdkKan iT_TtdkKan = null;
            while (iter.hasNext()) {

                iT_TtdkKan = iter.next();
                iCount++;

                Assert.assertEquals(P_SYONO_01, iT_TtdkKan.getSyono());
                Assert.assertEquals(P_HENKOUSIKIBETUDEY_01, iT_TtdkKan.getHenkousikibetukey());
                Assert.assertEquals(C_SyoruiCdKbn.BLNK, iT_TtdkKan.getSyoruiCd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap1 = new HashMap<String,String>();
        datamap1.put($("11807111118","1111111","0"), "1");
        datamap1.put($("11807111129","1111111","wf001"), "2");
        datamap1.put($("11807111141","1111111","wf002"), "3");
        datamap1.put($("11807111141","4444444","hk001"), "4");
        datamap1.put($("11807111141","5555555","cm020"), "5");
        datamap1.put($("11807111141","6666666","hk011"), "6");
        datamap1.put($("11807111141","7777777","hk015"), "7");
        datamap1.put($("11807111141","8888888","hk031"), "8");

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_02, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.BLNK, C_SyoruiCdKbn.WF_HYOUSI,
            C_SyoruiCdKbn.WF_QRSEAL, C_SyoruiCdKbn.HK_SHRMESS,
            C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI, C_SyoruiCdKbn.HK_SB_HOKEN_SKS, C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS,
            C_SyoruiCdKbn.HK_SB_DAIHYOU)) {

            Iterator<IT_TtdkKan> iter = exDBResults.iterator();
            IT_TtdkKan iT_TtdkKan = null;
            while (iter.hasNext()) {

                iT_TtdkKan = iter.next();
                datamap1.remove($(iT_TtdkKan.getSyono(),iT_TtdkKan.getHenkousikibetukey(),iT_TtdkKan.getSyoruiCd()));
            }

            Assert.assertTrue(datamap1.isEmpty());
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

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_02, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.BLNK, C_SyoruiCdKbn.WF_HYOUSI,
            C_SyoruiCdKbn.WF_QRSEAL, C_SyoruiCdKbn.HK_SHRMESS,
            C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI, C_SyoruiCdKbn.HK_SB_HOKEN_SKS, C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS,
            C_SyoruiCdKbn.HK_SB_DAIHYOU)) {

            Iterator<IT_TtdkKan> iter = exDBResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(8, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter("Kh001");
        bM_RecoveryFilter.setRecoveryfilternm("契約基本フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("kbnkey");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("syono");
        hozenDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        bT_SkipKey1.setTableid("IT_TtdkKan");
        bT_SkipKey1.setRecoveryfilterid("Kh001");
        bT_SkipKey1.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_01));
        bT_SkipKey1.setRecoveryfilterkey2(P_SYONO_01);
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_02, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.BLNK, C_SyoruiCdKbn.WF_HYOUSI,
            C_SyoruiCdKbn.WF_QRSEAL, C_SyoruiCdKbn.HK_SHRMESS,
            C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI, C_SyoruiCdKbn.HK_SB_HOKEN_SKS, C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS,
            C_SyoruiCdKbn.HK_SB_DAIHYOU)) {

            int iCount = 0;
            for (IT_TtdkKan entity : exDBResults) {

                assertNotEquals(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_01), entity.getKbnkey());
                assertNotEquals(P_SYONO_01, entity.getSyono());

                iCount++;
            }

            Assert.assertEquals(7, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        bT_SkipKey2.setTableid("IT_TtdkKan");
        bT_SkipKey2.setRecoveryfilterid("Kh001");
        bT_SkipKey2.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_02));
        bT_SkipKey2.setRecoveryfilterkey2(P_SYONO_02);
        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try (ExDBResults<IT_TtdkKan> exDBResults = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            P_KAKUCHOJOBCD_02, P_TYOUHYOUYMD_01, C_SyoruiCdKbn.BLNK, C_SyoruiCdKbn.WF_HYOUSI,
            C_SyoruiCdKbn.WF_QRSEAL, C_SyoruiCdKbn.HK_SHRMESS,
            C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI, C_SyoruiCdKbn.HK_SB_HOKEN_SKS, C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS,
            C_SyoruiCdKbn.HK_SB_DAIHYOU)) {

            int iCount = 0;
            for (IT_TtdkKan entity : exDBResults) {

                assertNotEquals(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_01), entity.getKbnkey());
                assertNotEquals(P_SYONO_01, entity.getSyono());
                assertNotEquals(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(P_SYONO_02), entity.getKbnkey());
                assertNotEquals(P_SYONO_02, entity.getSyono());

                iCount++;
            }

            Assert.assertEquals(6, iCount);
        }
    }
}
