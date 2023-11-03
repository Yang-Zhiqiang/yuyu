package yuyu.def.db.entity;

import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNyuukinSumRsgakuByNyksyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("791112220");
            Map<CurrencyType, BizCurrency> sumRsgakuMap = syoriCTL1.getNyuukinSumRsgakuByNyksyoriymd(BizDate.valueOf(20150405));
            Assert.assertEquals(0, sumRsgakuMap.size());

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(1);
            nyuukin1.setNyksyoriymd(BizDate.valueOf(20150405));
            nyuukin1.setRsgaku(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(2);
            nyuukin2.setNyksyoriymd(BizDate.valueOf(20150404));
            nyuukin2.setRsgaku(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(3);
            nyuukin3.setNyksyoriymd(BizDate.valueOf(20150406));
            nyuukin3.setRsgaku(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(4);
            nyuukin4.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin4.setRsgaku(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
            nyuukin5.setRenno(5);
            nyuukin5.setNyksyoriymd(BizDate.valueOf(20160404));
            nyuukin5.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
            nyuukin6.setRenno(6);
            nyuukin6.setNyksyoriymd(BizDate.valueOf(20160403));
            nyuukin6.setRsgaku(BizCurrency.valueOf(25, BizCurrencyTypes.MANYEN));

            HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
            nyuukin7.setRenno(7);
            nyuukin7.setNyksyoriymd(BizDate.valueOf(20160402));
            nyuukin7.setRsgaku(BizCurrency.valueOf(34, BizCurrencyTypes.MANYEN));

            HT_Nyuukin nyuukin8 = syoriCTL1.createNyuukin();
            nyuukin8.setRenno(8);
            nyuukin8.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin8.setRsgaku(BizCurrency.valueOf(77.5, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin9 = syoriCTL1.createNyuukin();
            nyuukin9.setRenno(9);
            nyuukin9.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin9.setRsgaku(BizCurrency.valueOf(22.5, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin10 = syoriCTL1.createNyuukin();
            nyuukin10.setRenno(10);
            nyuukin10.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin10.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

            HT_Nyuukin nyuukin11 = syoriCTL1.createNyuukin();
            nyuukin11.setRenno(11);
            nyuukin11.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin11.setRsgaku(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR));

            HT_Nyuukin nyuukin12 = syoriCTL1.createNyuukin();
            nyuukin12.setRenno(12);
            nyuukin12.setNyksyoriymd(BizDate.valueOf(20160405));

            HT_Nyuukin nyuukin13 = syoriCTL1.createNyuukin();
            nyuukin13.setRenno(13);
            nyuukin13.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin13.setRsgaku(BizCurrency.valueOf(600, BizCurrencyTypes.EURO));

            HT_Nyuukin nyuukin14 = syoriCTL1.createNyuukin();
            nyuukin14.setRenno(14);
            nyuukin14.setNyksyoriymd(BizDate.valueOf(20160405));
            nyuukin14.setRsgaku(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO));

            HT_Nyuukin nyuukin15 = syoriCTL1.createNyuukin();
            nyuukin15.setRenno(15);
            nyuukin15.setRsgaku(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> sumRsgakuMap = syoriCTL1.getNyuukinSumRsgakuByNyksyoriymd(BizDate.valueOf(20150403));
        Assert.assertEquals(0, sumRsgakuMap.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> sumRsgakuMap = syoriCTL1.getNyuukinSumRsgakuByNyksyoriymd(BizDate.valueOf(20150405));

        Assert.assertEquals(1, sumRsgakuMap.size());

        Assert.assertEquals(BizCurrency.valueOf(300), sumRsgakuMap.get(BizCurrencyTypes.YEN));
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> sumRsgakuMap = syoriCTL1.getNyuukinSumRsgakuByNyksyoriymd(BizDate.valueOf(20160405));

        Assert.assertEquals(5, sumRsgakuMap.size());

        Assert.assertEquals(BizCurrency.valueOf(700, BizCurrencyTypes.YEN), sumRsgakuMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(59, BizCurrencyTypes.MANYEN), sumRsgakuMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), sumRsgakuMap.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR), sumRsgakuMap.get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(1600, BizCurrencyTypes.EURO), sumRsgakuMap.get(BizCurrencyTypes.EURO));
    }
}
