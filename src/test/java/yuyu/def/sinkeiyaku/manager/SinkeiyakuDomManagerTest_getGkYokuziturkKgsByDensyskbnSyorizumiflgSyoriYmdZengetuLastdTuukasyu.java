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
import yuyu.def.sinkeiyaku.result.bean.GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate.valueOf(20160317), BizDate.valueOf(20160314), C_Tuukasyu.USD);

        Assert.assertEquals(0,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "11");
        gaikaHrkmNyknData1.setKsnymd(BizDate.valueOf(20160315));
        gaikaHrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(2000,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setDengk(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "22");
        gaikaHrkmNyknData2.setKsnymd(BizDate.valueOf(20160315));
        gaikaHrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "12");
        gaikaHrkmNyknData4.setKsnymd(BizDate.valueOf(20160313));
        gaikaHrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setDengk(BizCurrency.valueOf(499,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "13");
        gaikaHrkmNyknData5.setKsnymd(BizDate.valueOf(20160314));
        gaikaHrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setDengk(BizCurrency.valueOf(499,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "14");
        gaikaHrkmNyknData6.setKsnymd(BizDate.valueOf(20160315));
        gaikaHrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData6.setDengk(BizCurrency.valueOf(499,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData6.setTuukasyu(C_Tuukasyu.JPY);
        gaikaHrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "20");
        gaikaHrkmNyknData7.setKsnymd(BizDate.valueOf(20160318));
        gaikaHrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData7.setDengk(BizCurrency.valueOf(499,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData7.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "21");
        gaikaHrkmNyknData8.setKsnymd(BizDate.valueOf(20160315));
        gaikaHrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData8.setDengk(BizCurrency.valueOf(499,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData8.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData9 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20160303), "11");
        gaikaHrkmNyknData9.setKsnymd(BizDate.valueOf(20160315));
        gaikaHrkmNyknData9.setTrhkkgk(BizCurrency.valueOf(999,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData9.setDengk(BizCurrency.valueOf(499,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData9.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData9);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData10 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "30");
        gaikaHrkmNyknData10.setKsnymd(BizDate.valueOf(20170317));
        gaikaHrkmNyknData10.setTrhkkgk(BizCurrency.valueOf(2000,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData10.setDengk(BizCurrency.valueOf(1000,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData10.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData10.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData10);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData11 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "31");
        gaikaHrkmNyknData11.setKsnymd(BizDate.valueOf(20170316));
        gaikaHrkmNyknData11.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData11.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData11.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData11.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData11);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData12 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "32");
        gaikaHrkmNyknData12.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData12.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData12.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData12);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData13 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "33");
        gaikaHrkmNyknData13.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData13.setTrhkkgk(BizCurrency.valueOf(2000,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData13.setDengk(BizCurrency.valueOf(1000,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData13.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData13.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData13);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData14 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "34");
        gaikaHrkmNyknData14.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData14.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData14.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData14.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData14.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData14);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData15 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "35");
        gaikaHrkmNyknData15.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData15.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData15.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData15);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData16 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "36");
        gaikaHrkmNyknData16.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData16.setTrhkkgk(BizCurrency.valueOf(2000.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData16.setDengk(BizCurrency.valueOf(1000.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData16.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData16.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData16);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData17 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "37");
        gaikaHrkmNyknData17.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData17.setTrhkkgk(BizCurrency.valueOf(2000.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData17.setDengk(BizCurrency.valueOf(1000.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData17.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData17.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData17);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData18 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "38");
        gaikaHrkmNyknData18.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData18.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData18.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData18);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData19 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "39");
        gaikaHrkmNyknData19.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData19.setTrhkkgk(BizCurrency.valueOf(2000,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData19.setDengk(BizCurrency.valueOf(1000,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData19.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData19.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData19);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData20 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "40");
        gaikaHrkmNyknData20.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData20.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData20.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData20.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData20.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData20);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData21 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "41");
        gaikaHrkmNyknData21.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData21.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData21.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData21);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData22 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "42");
        gaikaHrkmNyknData22.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData22.setTrhkkgk(BizCurrency.valueOf(2000,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData22.setDengk(BizCurrency.valueOf(1000,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData22.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData22.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData22);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData23 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "43");
        gaikaHrkmNyknData23.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData23.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData23.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData23.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData23.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData23);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData24 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "44");
        gaikaHrkmNyknData24.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData24.setTuukasyu(C_Tuukasyu.USD);
        gaikaHrkmNyknData24.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData24);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData25 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160303), "45");
        gaikaHrkmNyknData25.setKsnymd(BizDate.valueOf(20170315));
        gaikaHrkmNyknData25.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData25.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
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
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate.valueOf(20160318), BizDate.valueOf(20160318), C_Tuukasyu.USD);

        Assert.assertEquals(0,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate.valueOf(20160317), BizDate.valueOf(20160314), C_Tuukasyu.USD);

        Assert.assertEquals(1,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getSyoriYmdCount());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate.valueOf(20170317), BizDate.valueOf(20170314), C_Tuukasyu.USD);

        Assert.assertEquals(7,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(4001, BizCurrencyTypes.DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(2001, BizCurrencyTypes.DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getDengkSum());
        Assert.assertEquals(new Long(1),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.MANYEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getSyoriYmdCount());

        Assert.assertEquals(null, gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getTrhkkgkSum());
        Assert.assertEquals(null, gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getDengkSum());
        Assert.assertEquals(new Long(5),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getSyoriYmdCount());
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(null, BizDate.valueOf(20160314), C_Tuukasyu.USD);

        Assert.assertEquals(7,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(4001, BizCurrencyTypes.DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(2001, BizCurrencyTypes.DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getDengkSum());
        Assert.assertEquals(new Long(1),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.MANYEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(4999, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(2499, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getDengkSum());
        Assert.assertEquals(new Long(5),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getSyoriYmdCount());

        Assert.assertEquals(null, gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getTrhkkgkSum());
        Assert.assertEquals(null, gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getDengkSum());
        Assert.assertEquals(new Long(5),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getSyoriYmdCount());
    }

    @Test
    @TestOrder(50)
    public void normal4() {
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(BizDate.valueOf(20160317), null, C_Tuukasyu.USD);

        Assert.assertEquals(1,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());

        Assert.assertEquals(BizCurrency.valueOf(3998, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1998, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getDengkSum());
        Assert.assertEquals(new Long(4),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getSyoriYmdCount());

    }

    @Test
    @TestOrder(60)
    public void normal5() {
        List<GkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBean>
        gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst
        = sinkeiyakuDomManager.getGkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyu(null, null, C_Tuukasyu.USD);

        Assert.assertEquals(7,gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.size());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(0).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(4001, BizCurrencyTypes.DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(2001, BizCurrencyTypes.DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(1).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getDengkSum());
        Assert.assertEquals(new Long(1),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(2).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(3).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.MANYEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.MANYEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getDengkSum());
        Assert.assertEquals(new Long(2),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(4).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(6997, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(3497, BizCurrencyTypes.YEN), gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getDengkSum());
        Assert.assertEquals(new Long(7),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(5).getSyoriYmdCount());

        Assert.assertEquals(null, gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getTrhkkgkSum());
        Assert.assertEquals(null, gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getDengkSum());
        Assert.assertEquals(new Long(5),gkYokuziturkKgsByDensyskbnSyorizumiflgSyoriYmdZengetuLastdTuukasyuBeanLst.get(6).getSyoriYmdCount());
    }
}

