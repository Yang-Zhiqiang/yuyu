package yuyu.def.sinkeiyaku.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込書類未到着リスト作成<br />
 * 申込書類未到着リスト情報ビューエンティティリスト（大量）取得　勘定日Leのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMosSyoruiMitoutyakuListsByKnjyymdLe {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try(ExDBResults<HV_MosSyoruiMitoutyakuList> exDBResults = sinkeiyakuDomManager.
            getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate.valueOf(20170113))){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170112), "1");
        gaikaHrkmNyknData1.setNykmosno("791112253");
        gaikaHrkmNyknData1.setKsnymd(BizDate.valueOf(20170109));
        gaikaHrkmNyknData1.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData1.setOyadrtencd("A130");
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170113), "1");
        gaikaHrkmNyknData2.setNykmosno("791112253");
        gaikaHrkmNyknData2.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData2.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData2.setOyadrtencd("A120");
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170114), "1");
        gaikaHrkmNyknData3.setNykmosno("791112261");
        gaikaHrkmNyknData3.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData3.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData3.setOyadrtencd("A110");
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170115), "1");
        gaikaHrkmNyknData4.setNykmosno("791112279");
        gaikaHrkmNyknData4.setKsnymd(BizDate.valueOf(20170112));
        gaikaHrkmNyknData4.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData4.setOyadrtencd("A100");
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170116), "1");
        gaikaHrkmNyknData5.setNykmosno("791112287");
        gaikaHrkmNyknData5.setKsnymd(BizDate.valueOf(20170111));
        gaikaHrkmNyknData5.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData5.setOyadrtencd("A100");
        gaikaHrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170117), "1");
        gaikaHrkmNyknData6.setNykmosno("791112295");
        gaikaHrkmNyknData6.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData6.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData6.setOyadrtencd("A100");
        gaikaHrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170118), "1");
        gaikaHrkmNyknData7.setNykmosno("791112303");
        gaikaHrkmNyknData7.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData7.setTuukasyu(C_Tuukasyu.EUR);
        gaikaHrkmNyknData7.setOyadrtencd("A100");
        gaikaHrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170119), "1");
        gaikaHrkmNyknData8.setNykmosno("791112246");
        gaikaHrkmNyknData8.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData8.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData8.setOyadrtencd("A100");
        gaikaHrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData9 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170120), "1");
        gaikaHrkmNyknData9.setNykmosno("791112238");
        gaikaHrkmNyknData9.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData9.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData9.setOyadrtencd("A100");
        gaikaHrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData9);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData10 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20170121), "1");
        gaikaHrkmNyknData10.setNykmosno("791112220");
        gaikaHrkmNyknData10.setKsnymd(BizDate.valueOf(20170110));
        gaikaHrkmNyknData10.setTuukasyu(C_Tuukasyu.AUD);
        gaikaHrkmNyknData10.setOyadrtencd("A100");
        gaikaHrkmNyknData10.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData10);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknData());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<HV_MosSyoruiMitoutyakuList> exDBResults = sinkeiyakuDomManager.
            getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate.valueOf(20170108))){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<HV_MosSyoruiMitoutyakuList> exDBResults = sinkeiyakuDomManager.
            getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate.valueOf(20170109))){

            int iCount = 0;
            Iterator<HV_MosSyoruiMitoutyakuList> iter = exDBResults.iterator();
            HV_MosSyoruiMitoutyakuList hV_MosSyoruiMitoutyakuList = null;
            while (iter.hasNext()) {

                hV_MosSyoruiMitoutyakuList = iter.next();
                iCount++;

                Assert.assertEquals(BizDate.valueOf(20170112), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                Assert.assertEquals("791112253", hV_MosSyoruiMitoutyakuList.getNykmosno());
                Assert.assertEquals(BizDate.valueOf(20170109), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                Assert.assertEquals("A130", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
            }

            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<HV_MosSyoruiMitoutyakuList> exDBResults = sinkeiyakuDomManager.
            getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate.valueOf(20170112))){

            int iCount = 0;
            Iterator<HV_MosSyoruiMitoutyakuList> iter = exDBResults.iterator();
            HV_MosSyoruiMitoutyakuList hV_MosSyoruiMitoutyakuList = null;
            while (iter.hasNext()) {

                hV_MosSyoruiMitoutyakuList = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170121), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112220", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170120), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112238", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170119), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112246", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170118), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112303", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.EUR, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170117), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112295", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.USD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170116), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112287", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170111), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170115), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112279", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170112), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A100", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170114), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112261", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A110", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (9 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170113), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112253", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170110), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A120", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

                if (10 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20170112), hV_MosSyoruiMitoutyakuList.getSyoriYmd());
                    Assert.assertEquals("1", hV_MosSyoruiMitoutyakuList.getItirenno());
                    Assert.assertEquals("791112253", hV_MosSyoruiMitoutyakuList.getNykmosno());
                    Assert.assertEquals(BizDate.valueOf(20170109), hV_MosSyoruiMitoutyakuList.getKnjyymd());
                    Assert.assertEquals(C_Tuukasyu.AUD, hV_MosSyoruiMitoutyakuList.getTuukasyu());
                    Assert.assertEquals("A130", hV_MosSyoruiMitoutyakuList.getOyadrtencd());
                    continue;
                }

            }
            Assert.assertEquals(10, iCount);
        }
    }
}