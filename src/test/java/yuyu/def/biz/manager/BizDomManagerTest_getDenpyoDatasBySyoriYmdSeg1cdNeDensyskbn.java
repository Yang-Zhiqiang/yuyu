package yuyu.def.biz.manager;

import java.util.List;

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
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn {

    @Inject
    private BizDomManager bizDomManager;


    @BeforeClass
    @Transactional()
    public static void preProcess(){

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate.valueOf(20160713));
        Assert.assertFalse(beans.iterator().hasNext());

        insertSubData();


    }

    @Transactional()
    public static void insertSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 01);
        denpyoData1.setHuridenatesakicd("111");
        denpyoData1.setDenymd(BizDate.valueOf(20180101));
        denpyoData1.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData1.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        denpyoData1.setSyoriYmd(BizDate.valueOf(20160713));
        denpyoData1.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData1.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 02);
        denpyoData2.setHuridenatesakicd("111");
        denpyoData2.setDenymd(BizDate.valueOf(20180101));
        denpyoData2.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData2.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        denpyoData2.setSyoriYmd(BizDate.valueOf(20160613));
        denpyoData2.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData2.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData2.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 03);
        denpyoData3.setHuridenatesakicd("111");
        denpyoData3.setDenymd(BizDate.valueOf(20180101));
        denpyoData3.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData3.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        denpyoData3.setSyoriYmd(BizDate.valueOf(20160713));
        denpyoData3.setSeg1cd(C_Segcd.valueOf("0000"));
        denpyoData3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData3.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData3);

        BT_DenpyoData denpyoData4 = new BT_DenpyoData(C_DensysKbn.valueOf("0"), "1111", 04);
        denpyoData4.setHuridenatesakicd("111");
        denpyoData4.setDenymd(BizDate.valueOf(20180101));
        denpyoData4.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData4.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        denpyoData4.setSyoriYmd(BizDate.valueOf(20160713));
        denpyoData4.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData4.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData4);

        BT_DenpyoData denpyoData5 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 05);
        denpyoData5.setHuridenatesakicd("111");
        denpyoData5.setDenymd(BizDate.valueOf(20180101));
        denpyoData5.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData5.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData5.setSyoriYmd(BizDate.valueOf(20160713));
        denpyoData5.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData5.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData5);

        BT_DenpyoData denpyoData6 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 06);
        denpyoData6.setHuridenatesakicd("333");
        denpyoData6.setDenymd(BizDate.valueOf(20190101));
        denpyoData6.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData6.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData6.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData6.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData6.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData6.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData6);

        BT_DenpyoData denpyoData7 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 07);
        denpyoData7.setHuridenatesakicd("111");
        denpyoData7.setDenymd(BizDate.valueOf(20180101));
        denpyoData7.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData7.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData7.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData7.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData7.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData7.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData7);

        BT_DenpyoData denpyoData8 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 17);
        denpyoData8.setHuridenatesakicd("333");
        denpyoData8.setDenymd(BizDate.valueOf(20170101));
        denpyoData8.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData8.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData8.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData8.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData8.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData8.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData8);

        BT_DenpyoData denpyoData9 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 18);
        denpyoData9.setHuridenatesakicd("222");
        denpyoData9.setDenymd(BizDate.valueOf(20170101));
        denpyoData9.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData9.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData9.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData9.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData9.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData9.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData9);

        BT_DenpyoData denpyoData10 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 10);
        denpyoData10.setHuridenatesakicd("111");
        denpyoData10.setDenymd(BizDate.valueOf(20170101));
        denpyoData10.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData10.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData10.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData10.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData10.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData10.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData10);

        BT_DenpyoData denpyoData11 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 11);
        denpyoData11.setHuridenatesakicd("111");
        denpyoData11.setDenymd(BizDate.valueOf(20170101));
        denpyoData11.setTaisyakukbn(C_TaisyakuKbn.valueOf("1"));
        denpyoData11.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        denpyoData11.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData11.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData11.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData11.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData11);

        BT_DenpyoData denpyoData12 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 12);
        denpyoData12.setHuridenatesakicd("111");
        denpyoData12.setDenymd(BizDate.valueOf(20170101));
        denpyoData12.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData12.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData12.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData12.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData12.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData12.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData12);

        BT_DenpyoData denpyoData13 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 13);
        denpyoData13.setHuridenatesakicd("111");
        denpyoData13.setDenymd(BizDate.valueOf(20170101));
        denpyoData13.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData13.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData13.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData13.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData13.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData13.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData13);

        BT_DenpyoData denpyoData14 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 14);
        denpyoData14.setHuridenatesakicd("111");
        denpyoData14.setDenymd(BizDate.valueOf(20170101));
        denpyoData14.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData14.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        denpyoData14.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData14.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData14.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData14.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData14);

        BT_DenpyoData denpyoData15 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 15);
        denpyoData15.setHuridenatesakicd("111");
        denpyoData15.setDenymd(BizDate.valueOf(20170101));
        denpyoData15.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData15.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        denpyoData15.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData15.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData15.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData15.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData15);

        BT_DenpyoData denpyoData16 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "1111", 16);
        denpyoData16.setHuridenatesakicd("111");
        denpyoData16.setDenymd(BizDate.valueOf(20170101));
        denpyoData16.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData16.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        denpyoData16.setSyoriYmd(BizDate.valueOf(20160813));
        denpyoData16.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData16.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.valueOf("0"));
        denpyoData16.setTekiyoukbn(C_TekiyouKbn.valueOf("0"));

        bizDomManager.insert(denpyoData16);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.BLNK);
        kanjyouKamoku1.setDenkanjokamokucd("11111");

        bizDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        kanjyouKamoku2.setDenkanjokamokucd("33333");

        bizDomManager.insert(kanjyouKamoku2);

        BM_KanjyouKamoku kanjyouKamoku3 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        kanjyouKamoku3.setDenkanjokamokucd("22222");

        bizDomManager.insert(kanjyouKamoku3);

        BM_KanjyouKamoku kanjyouKamoku4 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        kanjyouKamoku4.setDenkanjokamokucd("11111");

        bizDomManager.insert(kanjyouKamoku4);


    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate.valueOf(20150713))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate.valueOf(20160713));

        int iCount = 0;
        for (BT_DenpyoData denpyoData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(01, denpyoData.getEdano().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate.valueOf(20160813));

        int iCount = 0;
        for (BT_DenpyoData denpyoData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(14, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());

            }

            if (2 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(15, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());


            }

            if (3 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(16, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());

            }

            if (4 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(13, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }

            if (5 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(12, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }

            if (6 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(11, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }


            if (7 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(10, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }

            if (8 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(18, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("222", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }

            if (9 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(17, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20170101), denpyoData.getDenymd());
                Assert.assertEquals("333", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }

            if (10 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(07, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20180101), denpyoData.getDenymd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }

            if (11 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("1111", denpyoData.getDenrenno());
                Assert.assertEquals(06, denpyoData.getEdano().intValue());

                Assert.assertEquals(BizDate.valueOf(20190101), denpyoData.getDenymd());
                Assert.assertEquals("333", denpyoData.getHuridenatesakicd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, denpyoData.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, denpyoData.getTekiyoukbn());
            }
        }
        Assert.assertEquals(11, iCount);

    }


    @AfterClass
    @Transactional()
    public static void deleteTestSubData(){
        BizDomManager bizDomManager =SWAKInjector.getInstance(BizDomManager.class);
        List<BT_DenpyoData> list1 = bizDomManager.getAllDenpyoData();
        List<BM_KanjyouKamoku> list2 = bizDomManager.getAllKanjyouKamoku();
        if(list1.size()>0){
            bizDomManager.delete(list1);
        }
        if(list2.size()>0){
            bizDomManager.delete(list2);
        }
    }
}