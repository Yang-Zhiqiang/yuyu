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
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns {

    @Inject
    private BizDomManager bizDomManager;


    @BeforeClass
    @Transactional()
    public static void preProcess(){

        deleteTestSubData();


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(BizDate.valueOf(20160215))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertSubData();

    }

    @Transactional()
    public static void insertSubData(){
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "101", 1);
        denpyoData1.setHuridenatesakicd("111");
        denpyoData1.setDenymd(BizDate.valueOf(20160515));
        denpyoData1.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData1.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData1.setSyoriYmd(BizDate.valueOf(20160215));
        denpyoData1.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData1.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "101", 2);
        denpyoData2.setHuridenatesakicd("111");
        denpyoData2.setDenymd(BizDate.valueOf(20160515));
        denpyoData2.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData2.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData2.setSyoriYmd(BizDate.valueOf(20160214));
        denpyoData2.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData2.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "101", 3);
        denpyoData3.setHuridenatesakicd("111");
        denpyoData3.setDenymd(BizDate.valueOf(20160515));
        denpyoData3.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData3.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData3.setSyoriYmd(BizDate.valueOf(20160215));
        denpyoData3.setSeg1cd(C_Segcd.valueOf("0000"));
        denpyoData3.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData3);

        BT_DenpyoData denpyoData4 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "101", 4);
        denpyoData4.setHuridenatesakicd("111");
        denpyoData4.setDenymd(BizDate.valueOf(20160515));
        denpyoData4.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData4.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData4.setSyoriYmd(BizDate.valueOf(20160215));
        denpyoData4.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData4.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData4);

        BT_DenpyoData denpyoData5 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "101", 5);
        denpyoData5.setHuridenatesakicd("111");
        denpyoData5.setDenymd(BizDate.valueOf(20160515));
        denpyoData5.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData5.setKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        denpyoData5.setSyoriYmd(BizDate.valueOf(20160215));
        denpyoData5.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData5.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData5);

        BT_DenpyoData denpyoData6 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "102", 1);
        denpyoData6.setHuridenatesakicd("111");
        denpyoData6.setDenymd(BizDate.valueOf(20160515));
        denpyoData6.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData6.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        denpyoData6.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData6.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData6.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData6);

        BT_DenpyoData denpyoData7 = new BT_DenpyoData(C_DensysKbn.valueOf("30"), "103", 1);
        denpyoData7.setHuridenatesakicd("111");
        denpyoData7.setDenymd(BizDate.valueOf(20160517));
        denpyoData7.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData7.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData7.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData7.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData7.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData7);

        BT_DenpyoData denpyoData8 = new BT_DenpyoData(C_DensysKbn.valueOf("50"), "104", 1);
        denpyoData8.setHuridenatesakicd("111");
        denpyoData8.setDenymd(BizDate.valueOf(20160516));
        denpyoData8.setTaisyakukbn(C_TaisyakuKbn.valueOf("0"));
        denpyoData8.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        denpyoData8.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData8.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData8.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData8);

        BT_DenpyoData denpyoData9 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "105", 1);
        denpyoData9.setHuridenatesakicd("111");
        denpyoData9.setDenymd(BizDate.valueOf(20160517));
        denpyoData9.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData9.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        denpyoData9.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData9.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData9.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData9);

        BT_DenpyoData denpyoData10 = new BT_DenpyoData(C_DensysKbn.valueOf("30"), "106", 1);
        denpyoData10.setHuridenatesakicd("111");
        denpyoData10.setDenymd(BizDate.valueOf(20160517));
        denpyoData10.setTaisyakukbn(C_TaisyakuKbn.valueOf("1"));
        denpyoData10.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        denpyoData10.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData10.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData10.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData10);

        BT_DenpyoData denpyoData11 = new BT_DenpyoData(C_DensysKbn.valueOf("50"), "107", 1);
        denpyoData11.setHuridenatesakicd("111");
        denpyoData11.setDenymd(BizDate.valueOf(20160517));
        denpyoData11.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData11.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData11.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData11.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData11.setSeg2cd(C_Segcd.valueOf("2901"));

        bizDomManager.insert(denpyoData11);

        BT_DenpyoData denpyoData12 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "108", 1);
        denpyoData12.setHuridenatesakicd("111");
        denpyoData12.setDenymd(BizDate.valueOf(20160517));
        denpyoData12.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData12.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        denpyoData12.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData12.setSeg1cd(C_Segcd.valueOf("2801"));
        denpyoData12.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData12);

        BT_DenpyoData denpyoData13 = new BT_DenpyoData(C_DensysKbn.valueOf("30"), "109", 1);
        denpyoData13.setHuridenatesakicd("113");
        denpyoData13.setDenymd(BizDate.valueOf(20160517));
        denpyoData13.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData13.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData13.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData13.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData13.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData13);

        BT_DenpyoData denpyoData14 = new BT_DenpyoData(C_DensysKbn.valueOf("50"), "110", 1);
        denpyoData14.setHuridenatesakicd("111");
        denpyoData14.setDenymd(BizDate.valueOf(20160517));
        denpyoData14.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData14.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData14.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData14.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData14.setSeg2cd(C_Segcd.valueOf("2801"));

        bizDomManager.insert(denpyoData14);

        BT_DenpyoData denpyoData15 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "111", 1);
        denpyoData15.setHuridenatesakicd("111");
        denpyoData15.setDenymd(BizDate.valueOf(20160517));
        denpyoData15.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData15.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData15.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData15.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData15.setSeg2cd(C_Segcd.valueOf("2901"));

        bizDomManager.insert(denpyoData15);

        BT_DenpyoData denpyoData16 = new BT_DenpyoData(C_DensysKbn.valueOf("30"), "112", 1);
        denpyoData16.setHuridenatesakicd("111");
        denpyoData16.setDenymd(BizDate.valueOf(20160517));
        denpyoData16.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData16.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData16.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData16.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData16.setSeg2cd(C_Segcd.valueOf("2901"));

        bizDomManager.insert(denpyoData16);

        BT_DenpyoData denpyoData17 = new BT_DenpyoData(C_DensysKbn.valueOf("50"), "113", 1);
        denpyoData17.setHuridenatesakicd("113");
        denpyoData17.setDenymd(BizDate.valueOf(20160517));
        denpyoData17.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData17.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData17.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData17.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData17.setSeg2cd(C_Segcd.valueOf("2901"));

        bizDomManager.insert(denpyoData17);

        BT_DenpyoData denpyoData18 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "114", 1);
        denpyoData18.setHuridenatesakicd("112");
        denpyoData18.setDenymd(BizDate.valueOf(20160517));
        denpyoData18.setTaisyakukbn(C_TaisyakuKbn.valueOf("2"));
        denpyoData18.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData18.setSyoriYmd(BizDate.valueOf(20160220));
        denpyoData18.setSeg1cd(C_Segcd.valueOf("2901"));
        denpyoData18.setSeg2cd(C_Segcd.valueOf("2901"));

        bizDomManager.insert(denpyoData18);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        kanjyouKamoku1.setDenkanjokamokucd("11111");

        bizDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        kanjyouKamoku2.setDenkanjokamokucd("11111");

        bizDomManager.insert(kanjyouKamoku2);

        BM_KanjyouKamoku kanjyouKamoku3 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        kanjyouKamoku3.setDenkanjokamokucd("11113");

        bizDomManager.insert(kanjyouKamoku3);

        BM_KanjyouKamoku kanjyouKamoku4 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        kanjyouKamoku4.setDenkanjokamokucd("11112");

        bizDomManager.insert(kanjyouKamoku4);


    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(BizDate.valueOf(20160221))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(
            BizDate.valueOf(20160215));

        int iCount = 0;
        for (BT_DenpyoData denpyoData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                Assert.assertEquals("101", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
            }
        }

        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(
            BizDate.valueOf(20160220));

        int iCount = 0;
        for (BT_DenpyoData denpyoData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                Assert.assertEquals("102", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160515), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (2 == iCount) {
                Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                Assert.assertEquals("104", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160516), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (3 == iCount) {
                Assert.assertEquals(C_DensysKbn.HKSIHARAI, denpyoData.getDensyskbn());
                Assert.assertEquals("103", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (4 == iCount) {
                Assert.assertEquals(C_DensysKbn.HKSIHARAI, denpyoData.getDensyskbn());
                Assert.assertEquals("106", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (5 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                Assert.assertEquals("105", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (6 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                Assert.assertEquals("108", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (7 == iCount) {
                Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                Assert.assertEquals("107", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (8 == iCount) {
                Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                Assert.assertEquals("110", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }

            if (9 == iCount) {
                Assert.assertEquals(C_DensysKbn.HKSIHARAI, denpyoData.getDensyskbn());
                Assert.assertEquals("109", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("113", denpyoData.getHuridenatesakicd());
            }
            if (10 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                Assert.assertEquals("111", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }
            if (11 == iCount) {
                Assert.assertEquals(C_DensysKbn.HKSIHARAI, denpyoData.getDensyskbn());
                Assert.assertEquals("112", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("111", denpyoData.getHuridenatesakicd());
            }


            if (12 == iCount) {
                Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                Assert.assertEquals("114", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("112", denpyoData.getHuridenatesakicd());
            }

            if (13 == iCount) {
                Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                Assert.assertEquals("113", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
                Assert.assertEquals(BizDate.valueOf(20160517), denpyoData.getDenymd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoData.getTaisyakukbn());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, denpyoData.getKanjyoukmkcd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg1cd());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, denpyoData.getSeg2cd());
                Assert.assertEquals("113", denpyoData.getHuridenatesakicd());
            }
        }
        Assert.assertEquals(13, iCount);

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