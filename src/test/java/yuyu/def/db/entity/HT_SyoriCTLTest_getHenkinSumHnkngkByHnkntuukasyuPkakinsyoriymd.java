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

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("791112220");
            Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(C_Tuukasyu.JPY, BizDate.valueOf(20150405));
            Assert.assertEquals(0, sumHnkngkMap.size());

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(1);
            henkin1.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
            henkin1.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin1.setPkakinsyoriymd(BizDate.valueOf(20150405));

            HT_Henkin henkin2 = syoriCTL1.createHenkin();
            henkin2.setRenno(2);
            henkin2.setHnkngk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
            henkin2.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin2.setPkakinsyoriymd(BizDate.valueOf(20150404));

            HT_Henkin henkin3 = syoriCTL1.createHenkin();
            henkin3.setRenno(3);
            henkin3.setHnkngk(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
            henkin3.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
            henkin3.setPkakinsyoriymd(BizDate.valueOf(20150404));

            HT_Henkin henkin4 = syoriCTL1.createHenkin();
            henkin4.setRenno(4);
            henkin4.setHnkngk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
            henkin4.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin4.setPkakinsyoriymd(BizDate.valueOf(20150406));

            HT_Henkin henkin5 = syoriCTL1.createHenkin();
            henkin5.setRenno(5);
            henkin5.setHnkngk(BizCurrency.valueOf(300, BizCurrencyTypes.YEN));
            henkin5.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));

            HT_Henkin henkin6 = syoriCTL1.createHenkin();
            henkin6.setRenno(6);
            henkin6.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
            henkin6.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin6.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin7 = syoriCTL1.createHenkin();
            henkin7.setRenno(7);
            henkin7.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            henkin7.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin7.setPkakinsyoriymd(BizDate.valueOf(20160404));

            HT_Henkin henkin8 = syoriCTL1.createHenkin();
            henkin8.setRenno(8);
            henkin8.setHnkngk(BizCurrency.valueOf(25, BizCurrencyTypes.MANYEN));
            henkin8.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin8.setPkakinsyoriymd(BizDate.valueOf(20160403));

            HT_Henkin henkin9 = syoriCTL1.createHenkin();
            henkin9.setRenno(9);
            henkin9.setHnkngk(BizCurrency.valueOf(34, BizCurrencyTypes.MANYEN));
            henkin9.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin9.setPkakinsyoriymd(BizDate.valueOf(20160402));

            HT_Henkin henkin10 = syoriCTL1.createHenkin();
            henkin10.setRenno(10);
            henkin10.setHnkngk(BizCurrency.valueOf(77.5, BizCurrencyTypes.DOLLAR));
            henkin10.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin10.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin11 = syoriCTL1.createHenkin();
            henkin11.setRenno(11);
            henkin11.setHnkngk(BizCurrency.valueOf(22.5, BizCurrencyTypes.DOLLAR));
            henkin11.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin11.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin12 = syoriCTL1.createHenkin();
            henkin12.setRenno(12);
            henkin12.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
            henkin12.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin12.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin13 = syoriCTL1.createHenkin();
            henkin13.setRenno(13);
            henkin13.setHnkngk(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR));
            henkin13.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin13.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin14 = syoriCTL1.createHenkin();
            henkin14.setRenno(14);
            henkin14.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin14.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin15 = syoriCTL1.createHenkin();
            henkin15.setRenno(15);
            henkin15.setHnkngk(BizCurrency.valueOf(600, BizCurrencyTypes.EURO));
            henkin15.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin15.setPkakinsyoriymd(BizDate.valueOf(20160405));

            HT_Henkin henkin16 = syoriCTL1.createHenkin();
            henkin16.setRenno(16);
            henkin16.setHnkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO));
            henkin16.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
            henkin16.setPkakinsyoriymd(BizDate.valueOf(20160405));

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
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(C_Tuukasyu.JPY, BizDate.valueOf(20150403));
        Assert.assertEquals(0, sumHnkngkMap.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(C_Tuukasyu.JPY, BizDate.valueOf(20150405));

        Assert.assertEquals(1, sumHnkngkMap.size());

        Assert.assertEquals(BizCurrency.valueOf(300), sumHnkngkMap.get(BizCurrencyTypes.YEN));
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(C_Tuukasyu.JPY, BizDate.valueOf(20160405));

        Assert.assertEquals(5, sumHnkngkMap.size());

        Assert.assertEquals(BizCurrency.valueOf(700, BizCurrencyTypes.YEN), sumHnkngkMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(59, BizCurrencyTypes.MANYEN), sumHnkngkMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), sumHnkngkMap.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR), sumHnkngkMap.get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(1600, BizCurrencyTypes.EURO), sumHnkngkMap.get(BizCurrencyTypes.EURO));
    }
}
