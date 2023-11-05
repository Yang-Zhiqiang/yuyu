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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.result.bean.GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getGkTjtKgsByDensyskbnSyoriYmdTuukasyu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGkTjtKgsByDensyskbnSyoriYmdTuukasyu {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate.valueOf(20161111), C_Tuukasyu.JPY);

        Assert.assertEquals(0,beans.size());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161111), "11");
        gaikaHrkmNyknData.setTrhkkgk(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData.setDengk(BizCurrency.valueOf(111,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161111), "10");
        gaikaHrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(3,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setDengk(BizCurrency.valueOf(5,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161111), "13");
        gaikaHrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20161111), "11");
        gaikaHrkmNyknData3.setTrhkkgk(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData3.setDengk(BizCurrency.valueOf(111,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData3.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161112), "15");
        gaikaHrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setDengk(BizCurrency.valueOf(111,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20161111), "16");
        gaikaHrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(101,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setDengk(BizCurrency.valueOf(111,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setTuukasyu(C_Tuukasyu.BLNK);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "21");
        gaikaHrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(11,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData6.setDengk(BizCurrency.valueOf(21,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData6.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "22");
        gaikaHrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(12,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData7.setDengk(BizCurrency.valueOf(22,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData7.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "23");
        gaikaHrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData8.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.MANYEN));
        gaikaHrkmNyknData8.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData9 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "24");
        gaikaHrkmNyknData9.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData9);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData10 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "25");
        gaikaHrkmNyknData10.setTrhkkgk(BizCurrency.valueOf(1.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData10.setDengk(BizCurrency.valueOf(5.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData10.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData10);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData11 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "26");
        gaikaHrkmNyknData11.setTrhkkgk(BizCurrency.valueOf(2.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData11.setDengk(BizCurrency.valueOf(6.5,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData11.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData11);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData12 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "27");
        gaikaHrkmNyknData12.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData12.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData12.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData12);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData13 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "28");
        gaikaHrkmNyknData13.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData13);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData14 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "29");
        gaikaHrkmNyknData14.setTrhkkgk(BizCurrency.valueOf(11,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData14.setDengk(BizCurrency.valueOf(10,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData14.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData14);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData15 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "30");
        gaikaHrkmNyknData15.setTrhkkgk(BizCurrency.valueOf(1,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData15.setDengk(BizCurrency.valueOf(11,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData15.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData15);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData16 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "31");
        gaikaHrkmNyknData16.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData16.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData16.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData16);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData17 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "32");
        gaikaHrkmNyknData17.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData17);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData18 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "33");
        gaikaHrkmNyknData18.setTrhkkgk(BizCurrency.valueOf(1.5,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData18.setDengk(BizCurrency.valueOf(2.5,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData18.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData18);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData19 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "34");
        gaikaHrkmNyknData19.setTrhkkgk(BizCurrency.valueOf(10,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData19.setDengk(BizCurrency.valueOf(11,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData19.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData19);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData20 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "35");
        gaikaHrkmNyknData20.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData20.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData20.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData20);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData21 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "36");
        gaikaHrkmNyknData21.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData21);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData23 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20171111), "37");
        gaikaHrkmNyknData23.setTrhkkgk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData23.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        gaikaHrkmNyknData23.setTuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData23);

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

        List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate.valueOf(20161109), C_Tuukasyu.JPY);

        Assert.assertEquals(0,beans.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate.valueOf(20161111), C_Tuukasyu.JPY);

        Assert.assertEquals(1, beans.size());

        Assert.assertEquals(BizCurrency.valueOf(104, BizCurrencyTypes.YEN), beans.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(116, BizCurrencyTypes.YEN), beans.get(0).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(0).getSyoriYmdCount());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<GkTjtKgsByDensyskbnSyoriYmdTuukasyuBean> beans =
            sinkeiyakuDomManager.getGkTjtKgsByDensyskbnSyoriYmdTuukasyu(BizDate.valueOf(20171111), C_Tuukasyu.JPY);

        Assert.assertEquals(6, beans.size());

        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.AU_DOLLAR), beans.get(0).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(21, BizCurrencyTypes.AU_DOLLAR), beans.get(0).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(0).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(4, BizCurrencyTypes.DOLLAR), beans.get(1).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.DOLLAR), beans.get(1).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(1).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.EURO), beans.get(2).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), beans.get(2).getDengkSum());
        Assert.assertEquals(Long.valueOf(1), beans.get(2).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(11.5, BizCurrencyTypes.EURO), beans.get(3).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(13.5, BizCurrencyTypes.EURO), beans.get(3).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(3).getSyoriYmdCount());

        Assert.assertEquals(BizCurrency.valueOf(23, BizCurrencyTypes.MANYEN), beans.get(4).getTrhkkgkSum());
        Assert.assertEquals(BizCurrency.valueOf(43, BizCurrencyTypes.MANYEN), beans.get(4).getDengkSum());
        Assert.assertEquals(Long.valueOf(3), beans.get(4).getSyoriYmdCount());

        Assert.assertEquals(null, beans.get(5).getTrhkkgkSum());
        Assert.assertEquals(null, beans.get(5).getDengkSum());
        Assert.assertEquals(Long.valueOf(4), beans.get(5).getSyoriYmdCount());

    }
}

