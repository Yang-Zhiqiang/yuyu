package yuyu.def.sinkeiyaku.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate.valueOf(20161111), C_Tuukasyu.JPY);

        Assert.assertEquals(0,beans.size());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161024), "11");
        gaikaHrkmNyknData1.setKsnymd(BizDate.valueOf(20161111));
        gaikaHrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setDengk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161024), "12");
        gaikaHrkmNyknData2.setKsnymd(BizDate.valueOf(20161110));
        gaikaHrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setDengk(BizCurrency.valueOf(112, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161024), "13");
        gaikaHrkmNyknData3.setKsnymd(BizDate.valueOf(20161111));
        gaikaHrkmNyknData3.setTrhkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData3.setDengk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData3.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161024), "11");
        gaikaHrkmNyknData4.setKsnymd(BizDate.valueOf(20161111));
        gaikaHrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setDengk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161024), "14");
        gaikaHrkmNyknData5.setKsnymd(BizDate.valueOf(20161111));
        gaikaHrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setDengk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161024), "15");
        gaikaHrkmNyknData6.setKsnymd(BizDate.valueOf(20161112));
        gaikaHrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData6.setDengk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData6.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161024), "16");
        gaikaHrkmNyknData7.setKsnymd(BizDate.valueOf(20161111));
        gaikaHrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData7.setDengk(BizCurrency.valueOf(111, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData7.setTuukasyu(C_Tuukasyu.BLNK);
        gaikaHrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "21");
        gaikaHrkmNyknData8.setKsnymd(BizDate.valueOf(20161015));
        gaikaHrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData8.setDengk(BizCurrency.valueOf(21, BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData8.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData9 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "22");
        gaikaHrkmNyknData9.setKsnymd(BizDate.valueOf(20161014));
        gaikaHrkmNyknData9.setTrhkkgk(BizCurrency.valueOf(12, BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData9.setDengk(BizCurrency.valueOf(22, BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData9.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData9);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData10 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "23");
        gaikaHrkmNyknData10.setKsnymd(BizDate.valueOf(20161013));
        gaikaHrkmNyknData10.setTrhkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData10.setDengk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData10.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData10.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData10);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData11 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "24");
        gaikaHrkmNyknData11.setKsnymd(BizDate.valueOf(20161012));
        gaikaHrkmNyknData11.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData11.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData11);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData12 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "25");
        gaikaHrkmNyknData12.setKsnymd(BizDate.valueOf(20161015));
        gaikaHrkmNyknData12.setTrhkkgk(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData12.setDengk(BizCurrency.valueOf(5.5, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData12.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData12.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData12);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData13 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "26");
        gaikaHrkmNyknData13.setKsnymd(BizDate.valueOf(20161014));
        gaikaHrkmNyknData13.setTrhkkgk(BizCurrency.valueOf(2.5, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData13.setDengk(BizCurrency.valueOf(6.5, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData13.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData13.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData13);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData14 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "27");
        gaikaHrkmNyknData14.setKsnymd(BizDate.valueOf(20161013));
        gaikaHrkmNyknData14.setTrhkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData14.setDengk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData14.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData14.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData14);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData15 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "28");
        gaikaHrkmNyknData15.setKsnymd(BizDate.valueOf(20161012));
        gaikaHrkmNyknData15.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData15.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData15);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData16 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "29");
        gaikaHrkmNyknData16.setKsnymd(BizDate.valueOf(20161015));
        gaikaHrkmNyknData16.setTrhkkgk(BizCurrency.valueOf(11, BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData16.setDengk(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData16.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData16.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData16);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData17 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "30");
        gaikaHrkmNyknData17.setKsnymd(BizDate.valueOf(20161014));
        gaikaHrkmNyknData17.setTrhkkgk(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData17.setDengk(BizCurrency.valueOf(11, BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData17.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData17.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData17);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData18 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "31");
        gaikaHrkmNyknData18.setKsnymd(BizDate.valueOf(20161013));
        gaikaHrkmNyknData18.setTrhkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData18.setDengk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData18.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData18.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData18);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData19 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "32");
        gaikaHrkmNyknData19.setKsnymd(BizDate.valueOf(20161012));
        gaikaHrkmNyknData19.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData19.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData19);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData20 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "33");
        gaikaHrkmNyknData20.setKsnymd(BizDate.valueOf(20161015));
        gaikaHrkmNyknData20.setTrhkkgk(BizCurrency.valueOf(1.5, BizCurrencyTypes.EURO));
        gaikaHrkmNyknData20.setDengk(BizCurrency.valueOf(2.5, BizCurrencyTypes.EURO));
        gaikaHrkmNyknData20.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData20.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData20);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData21 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "34");
        gaikaHrkmNyknData21.setKsnymd(BizDate.valueOf(20161014));
        gaikaHrkmNyknData21.setTrhkkgk(BizCurrency.valueOf(10, BizCurrencyTypes.EURO));
        gaikaHrkmNyknData21.setDengk(BizCurrency.valueOf(11, BizCurrencyTypes.EURO));
        gaikaHrkmNyknData21.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData21.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData21);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData22 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "35");
        gaikaHrkmNyknData22.setKsnymd(BizDate.valueOf(20161013));
        gaikaHrkmNyknData22.setTrhkkgk(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
        gaikaHrkmNyknData22.setDengk(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
        gaikaHrkmNyknData22.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData22.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData22);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData23 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "36");
        gaikaHrkmNyknData23.setKsnymd(BizDate.valueOf(20161012));
        gaikaHrkmNyknData23.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData23.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData23);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData24 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "37");
        gaikaHrkmNyknData24.setKsnymd(BizDate.valueOf(20161015));
        gaikaHrkmNyknData24.setTrhkkgk(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData24.setDengk(BizCurrency.valueOf(150, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData24.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData24.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData24);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData25 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160924), "38");
        gaikaHrkmNyknData25.setKsnymd(BizDate.valueOf(20161014));
        gaikaHrkmNyknData25.setTrhkkgk(BizCurrency.valueOf(350, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData25.setDengk(BizCurrency.valueOf(6.5, BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData25.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData25.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData25);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate.valueOf(20161109), C_Tuukasyu.BLNK);

        Assert.assertEquals(0,beans.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate.valueOf(20161111), C_Tuukasyu.JPY);

        Assert.assertEquals(1, beans.size());

        Assert.assertEquals(BizCurrency.valueOf(203, BizCurrencyTypes.YEN), beans.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(223, BizCurrencyTypes.YEN), beans.get(0).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(0).getSyoriYmdCount());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<GkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkYokuziturkKgKsansByDensyskbnSyorizumiflgKsnymdTuukasyu(BizDate.valueOf(20161015), C_Tuukasyu.USD);

        Assert.assertEquals(7, beans.size());

        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.AU_DOLLAR), beans.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(21, BizCurrencyTypes.AU_DOLLAR), beans.get(0).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(0).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(4, BizCurrencyTypes.DOLLAR), beans.get(1).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR), beans.get(1).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(1).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR), beans.get(2).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(150, BizCurrencyTypes.YEN), beans.get(2).getDengkSum());
        Assert.assertEquals(Long.valueOf(1), beans.get(2).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(11.5, BizCurrencyTypes.EURO), beans.get(3).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(13.5, BizCurrencyTypes.EURO), beans.get(3).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(3).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(23, BizCurrencyTypes.MANYEN), beans.get(4).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(43, BizCurrencyTypes.MANYEN), beans.get(4).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(4).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(350, BizCurrencyTypes.YEN), beans.get(5).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(6.5, BizCurrencyTypes.DOLLAR), beans.get(5).getDengkSum());
        Assert.assertEquals(Long.valueOf(1), beans.get(5).getSyoriYmdCount());

        Assert.assertEquals(null, beans.get(6).getTrhkkgkSum());
        Assert.assertEquals(null, beans.get(6).getDengkSum());
        Assert.assertEquals(Long.valueOf(4), beans.get(6).getSyoriYmdCount());
    }
}
