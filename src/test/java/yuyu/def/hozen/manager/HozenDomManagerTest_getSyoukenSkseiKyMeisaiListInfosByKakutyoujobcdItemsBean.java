package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean {

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160215))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertTestData();
    }


    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160228));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean sSKMbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160215));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean sSKMbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("11807111118", sSKMbean.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160215), sSKMbean.getTyouhyouymd());
                Assert.assertEquals(C_SinsaihkKbn.SIN, sSKMbean.getSinsaihkkbn());
                Assert.assertEquals(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU,sSKMbean.getSyoukensaihkkbn());
                Assert.assertEquals(C_InsizeiShryouhiKbn.YOU,sSKMbean.getInsizeishryouhikbn());
                Assert.assertEquals(C_HassouKbn.TYOKUSOU,sSKMbean.getHassoukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKoujyosyoumeiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getSuiihyouumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKanryoutuutiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getStdrsktirasidouhuukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getDstirasidouhuukbn());
                Assert.assertEquals(C_AisyoumeiKbn.BLNK,sSKMbean.getAisyoumeikbn());
                Assert.assertEquals("04",sSKMbean.getHknsyukigou());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.BLNK,sSKMbean.getTokusyusyorinaiyoukbn1());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn2());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn3());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn4());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn5());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn6());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn7());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn8());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI,sSKMbean.getTokusyusyorinaiyoukbn9());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI,sSKMbean.getTokusyusyorinaiyoukbn10());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STKNSETARI,sSKMbean.getTokusyusyorinaiyoukbn11());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn12());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn13());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn14());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn15());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn16());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn17());
                Assert.assertEquals("1000000000",sSKMbean.getGyoumuKousinKinou());
                Assert.assertEquals("12345600000",sSKMbean.getGyoumuKousinsyaId());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, sSKMbean.getTantocd());

                Assert.assertEquals("01",sSKMbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118",sSKMbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01",sSKMbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118",sSKMbean.getIT_KykSya().getSyono());

                Assert.assertEquals("01",sSKMbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111118",sSKMbean.getIT_HhknSya().getSyono());

            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean sSKMbean : beans) {
            iCount++;

            if (iCount == 1) {
                Assert.assertEquals("11807111152", sSKMbean.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), sSKMbean.getTyouhyouymd());
                Assert.assertEquals(C_SinsaihkKbn.SIN, sSKMbean.getSinsaihkkbn());
                Assert.assertEquals(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU,sSKMbean.getSyoukensaihkkbn());
                Assert.assertEquals(C_InsizeiShryouhiKbn.YOU,sSKMbean.getInsizeishryouhikbn());
                Assert.assertEquals(C_HassouKbn.TYOKUSOU,sSKMbean.getHassoukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKoujyosyoumeiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getSuiihyouumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKanryoutuutiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getStdrsktirasidouhuukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getDstirasidouhuukbn());
                Assert.assertEquals(C_AisyoumeiKbn.BLNK,sSKMbean.getAisyoumeikbn());
                Assert.assertEquals("04",sSKMbean.getHknsyukigou());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.BLNK,sSKMbean.getTokusyusyorinaiyoukbn1());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn2());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn3());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn4());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn5());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn6());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn7());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn8());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI,sSKMbean.getTokusyusyorinaiyoukbn9());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI,sSKMbean.getTokusyusyorinaiyoukbn10());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STKNSETARI,sSKMbean.getTokusyusyorinaiyoukbn11());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn12());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn13());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn14());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn15());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn16());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn17());
                Assert.assertEquals("1000000000",sSKMbean.getGyoumuKousinKinou());
                Assert.assertEquals("12345600000",sSKMbean.getGyoumuKousinsyaId());
                Assert.assertEquals(C_TantouCdKbn.KETTEI, sSKMbean.getTantocd());

                Assert.assertEquals("05",sSKMbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111152",sSKMbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("05",sSKMbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111152",sSKMbean.getIT_KykSya().getSyono());

                Assert.assertEquals("05",sSKMbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111152",sSKMbean.getIT_HhknSya().getSyono());
            }
            if (iCount == 2) {
                Assert.assertEquals("11807111163", sSKMbean.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), sSKMbean.getTyouhyouymd());
                Assert.assertEquals(C_SinsaihkKbn.SIN, sSKMbean.getSinsaihkkbn());
                Assert.assertEquals(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU,sSKMbean.getSyoukensaihkkbn());
                Assert.assertEquals(C_InsizeiShryouhiKbn.YOU,sSKMbean.getInsizeishryouhikbn());
                Assert.assertEquals(C_HassouKbn.TYOKUSOU,sSKMbean.getHassoukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKoujyosyoumeiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getSuiihyouumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKanryoutuutiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getStdrsktirasidouhuukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getDstirasidouhuukbn());
                Assert.assertEquals(C_AisyoumeiKbn.BLNK,sSKMbean.getAisyoumeikbn());
                Assert.assertEquals("04",sSKMbean.getHknsyukigou());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.BLNK,sSKMbean.getTokusyusyorinaiyoukbn1());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn2());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn3());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn4());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn5());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn6());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn7());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn8());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI,sSKMbean.getTokusyusyorinaiyoukbn9());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI,sSKMbean.getTokusyusyorinaiyoukbn10());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STKNSETARI,sSKMbean.getTokusyusyorinaiyoukbn11());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn12());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn13());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn14());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn15());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn16());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn17());
                Assert.assertEquals("1000000000",sSKMbean.getGyoumuKousinKinou());
                Assert.assertEquals("12345600000",sSKMbean.getGyoumuKousinsyaId());
                Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, sSKMbean.getTantocd());

                Assert.assertEquals("06",sSKMbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111163",sSKMbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("06",sSKMbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111163",sSKMbean.getIT_KykSya().getSyono());

                Assert.assertEquals("06",sSKMbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111163",sSKMbean.getIT_HhknSya().getSyono());
            }
            if (iCount == 3) {
                Assert.assertEquals("11807111174", sSKMbean.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), sSKMbean.getTyouhyouymd());
                Assert.assertEquals(C_SinsaihkKbn.SIN, sSKMbean.getSinsaihkkbn());
                Assert.assertEquals(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU,sSKMbean.getSyoukensaihkkbn());
                Assert.assertEquals(C_InsizeiShryouhiKbn.YOU,sSKMbean.getInsizeishryouhikbn());
                Assert.assertEquals(C_HassouKbn.TYOKUSOU,sSKMbean.getHassoukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKoujyosyoumeiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getSuiihyouumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getKanryoutuutiumukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getStdrsktirasidouhuukbn());
                Assert.assertEquals(C_UmuKbn.ARI,sSKMbean.getDstirasidouhuukbn());
                Assert.assertEquals(C_AisyoumeiKbn.BLNK,sSKMbean.getAisyoumeikbn());
                Assert.assertEquals("04",sSKMbean.getHknsyukigou());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.BLNK,sSKMbean.getTokusyusyorinaiyoukbn1());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn2());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn3());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn4());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn5());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn6());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn7());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn8());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI,sSKMbean.getTokusyusyorinaiyoukbn9());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI,sSKMbean.getTokusyusyorinaiyoukbn10());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STKNSETARI,sSKMbean.getTokusyusyorinaiyoukbn11());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn12());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn13());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU,sSKMbean.getTokusyusyorinaiyoukbn14());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn15());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI,sSKMbean.getTokusyusyorinaiyoukbn16());
                Assert.assertEquals(C_TokusyuSyoriNaiyouKbn.KANJIADRNASI,sSKMbean.getTokusyusyorinaiyoukbn17());
                Assert.assertEquals("1000000000",sSKMbean.getGyoumuKousinKinou());
                Assert.assertEquals("12345600000",sSKMbean.getGyoumuKousinsyaId());
                Assert.assertEquals(C_TantouCdKbn.SYOUKENTYOUSEI, sSKMbean.getTantocd());

                Assert.assertEquals("07",sSKMbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111174",sSKMbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("07",sSKMbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111174",sSKMbean.getIT_KykSya().getSyono());

                Assert.assertEquals("07",sSKMbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111174",sSKMbean.getIT_HhknSya().getSyono());
            }


        }
        Assert.assertEquals(3, iCount);
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean sSKMbean : beans) {
            iCount++;
        }
        Assert.assertEquals(3, iCount);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RBC1");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("05");
        skipKey1.setRecoveryfilterkey2("11807111152");

        hozenDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        hozenDomManager.insert(recoveryFilter1);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean sSKMbean : beans) {
            iCount++;

            boolean result1 =
                (sSKMbean.getIT_KykKihon().getKbnkey().equals("05")) &&
                (sSKMbean.getIT_KykKihon().getSyono().equals("11807111152"));

            assertFalse(result1);

        }
        Assert.assertEquals(2, iCount);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RBC1");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("06");
        skipKey2.setRecoveryfilterkey2("11807111163");

        hozenDomManager.insert(skipKey2);

    }


    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean sSKMbean : beans) {
            iCount++;

            boolean result1 =
                (sSKMbean.getIT_KykKihon().getKbnkey().equals("05")) &&
                (sSKMbean.getIT_KykKihon().getSyono().equals("11807111152"));
            boolean result2 =
                (sSKMbean.getIT_KykKihon().getKbnkey().equals("06")) &&
                (sSKMbean.getIT_KykKihon().getSyono().equals("11807111163"));
            assertFalse(result1);
            assertFalse(result2);

        }
        Assert.assertEquals(1, iCount);
    }
}
