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
 * 返金額合計マップクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("791112220");

            Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.JPY);
            Assert.assertEquals(0, sumHnkngkMap.size());

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(10);
            henkin1.setHnknsyoriymd(BizDate.valueOf(20160302));
            henkin1.setHnkngk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            henkin1.setHnkntuukasyu(C_Tuukasyu.JPY);

            HT_Henkin henkin2 = syoriCTL1.createHenkin();
            henkin2.setRenno(11);
            henkin2.setHnknsyoriymd(BizDate.valueOf(20160302));
            henkin2.setHnkngk(BizCurrency.valueOf(2000));
            henkin2.setHnkngk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            henkin2.setHnkntuukasyu(C_Tuukasyu.USD);

            HT_Henkin henkin3 = syoriCTL1.createHenkin();
            henkin3.setRenno(12);
            henkin3.setHnkngk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
            henkin3.setHnkntuukasyu(C_Tuukasyu.JPY);

            sinkeiyakuDomManager.insert(syoriCTL1);

        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin4 = syoriCTL2.createHenkin();
        henkin4.setRenno(13);
        henkin4.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin4.setHnkngk(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));
        henkin4.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin5 = syoriCTL2.createHenkin();
        henkin5.setRenno(14);
        henkin5.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin5.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        henkin5.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin6 = syoriCTL2.createHenkin();
        henkin6.setRenno(15);
        henkin6.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin6.setHnkngk(BizCurrency.valueOf(25, BizCurrencyTypes.MANYEN));
        henkin6.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin7 = syoriCTL2.createHenkin();
        henkin7.setRenno(16);
        henkin7.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin7.setHnkngk(BizCurrency.valueOf(34, BizCurrencyTypes.MANYEN));
        henkin7.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin8 = syoriCTL2.createHenkin();
        henkin8.setRenno(17);
        henkin8.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin8.setHnkngk(BizCurrency.valueOf(77.5, BizCurrencyTypes.DOLLAR));
        henkin8.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin9 = syoriCTL2.createHenkin();
        henkin9.setRenno(18);
        henkin9.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin9.setHnkngk(BizCurrency.valueOf(22.5, BizCurrencyTypes.DOLLAR));
        henkin9.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin10 = syoriCTL2.createHenkin();
        henkin10.setRenno(19);
        henkin10.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin10.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        henkin10.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin11 = syoriCTL2.createHenkin();
        henkin11.setRenno(20);
        henkin11.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin11.setHnkngk(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR));
        henkin11.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin12 = syoriCTL2.createHenkin();
        henkin12.setRenno(21);
        henkin12.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin12.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin13 = syoriCTL2.createHenkin();
        henkin13.setRenno(22);
        henkin13.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin13.setHnkngk(BizCurrency.valueOf(600, BizCurrencyTypes.EURO));
        henkin13.setHnkntuukasyu(C_Tuukasyu.EUR);

        HT_Henkin henkin14 = syoriCTL2.createHenkin();
        henkin14.setRenno(23);
        henkin14.setHnknsyoriymd(BizDate.valueOf(20160302));
        henkin14.setHnkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO));
        henkin14.setHnkntuukasyu(C_Tuukasyu.EUR);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112378");

        sinkeiyakuDomManager.insert(syoriCTL3);

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

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112378");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.JPY);

        Assert.assertEquals(0, sumHnkngkMap.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.JPY);
        Assert.assertEquals(1, sumHnkngkMap.size());

        Assert.assertEquals(BizCurrency.valueOf(2000), sumHnkngkMap.get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112246");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.EUR);
        Assert.assertEquals(5, sumHnkngkMap.size());

        Assert.assertEquals(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN), sumHnkngkMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(59, BizCurrencyTypes.MANYEN), sumHnkngkMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), sumHnkngkMap.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR), sumHnkngkMap.get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(1600, BizCurrencyTypes.EURO), sumHnkngkMap.get(BizCurrencyTypes.EURO));
    }
}
