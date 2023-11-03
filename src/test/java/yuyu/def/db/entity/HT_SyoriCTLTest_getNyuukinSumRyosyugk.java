package yuyu.def.db.entity;

import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
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
 * 領収金額合計マップクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNyuukinSumRyosyugk {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");

            Map<CurrencyType, BizCurrency> sumRskngkMap = syoriCTL1.getNyuukinSumRyosyugk();
            Assert.assertEquals(0, sumRskngkMap.size());

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(10);

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(11);
            nyuukin2.setRsgaku(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(12);
            nyuukin3.setRsgaku(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
            nyuukin5.setRenno(13);
            nyuukin5.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
            nyuukin6.setRenno(14);
            nyuukin6.setRsgaku(BizCurrency.valueOf(500 ,BizCurrencyTypes.MANYEN));

            HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
            nyuukin7.setRenno(15);
            nyuukin7.setRsgaku(BizCurrency.valueOf(100, BizCurrencyTypes.MANYEN));

            HT_Nyuukin nyuukin9 = syoriCTL1.createNyuukin();
            nyuukin9.setRenno(17);
            nyuukin9.setRsgaku(BizCurrency.valueOf(25.5, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin10 = syoriCTL1.createNyuukin();
            nyuukin10.setRenno(18);
            nyuukin10.setRsgaku(BizCurrency.valueOf(34.5, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin11 = syoriCTL1.createNyuukin();
            nyuukin11.setRenno(19);
            nyuukin11.setRsgaku(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin12 = syoriCTL1.createNyuukin();
            nyuukin12.setRenno(20);

            HT_Nyuukin nyuukin13 = syoriCTL1.createNyuukin();
            nyuukin13.setRenno(21);
            nyuukin13.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));

            sinkeiyakuDomManager.insert(syoriCTL1);

        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("10000000070");

        HT_Nyuukin nyuukin14 = syoriCTL2.createNyuukin();
        nyuukin14.setRenno(19);
        nyuukin14.setRsgaku(BizCurrency.valueOf(400, BizCurrencyTypes.YEN));

        HT_Nyuukin nyuukin15 = syoriCTL2.createNyuukin();
        nyuukin15.setRenno(20);
        nyuukin15.setRsgaku(BizCurrency.valueOf(600, BizCurrencyTypes.YEN));

        HT_Nyuukin nyuukin16 = syoriCTL2.createNyuukin();
        nyuukin16.setRenno(21);
        nyuukin16.setRsgaku(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("10000000080");

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

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000080");
        Map<CurrencyType, BizCurrency> sumRskngkMap = syoriCTL1.getNyuukinSumRyosyugk();

        Assert.assertEquals(0, sumRskngkMap.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000070");
        Map<CurrencyType, BizCurrency> sumRskngkMap = syoriCTL1.getNyuukinSumRyosyugk();

        Assert.assertEquals(BizCurrency.valueOf(2000), sumRskngkMap.get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        Map<CurrencyType, BizCurrency> sumRskngkMap = syoriCTL1.getNyuukinSumRyosyugk();

        Assert.assertEquals(BizCurrency.valueOf(5000), sumRskngkMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(600, BizCurrencyTypes.MANYEN), sumRskngkMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(160, BizCurrencyTypes.DOLLAR), sumRskngkMap.get(BizCurrencyTypes.DOLLAR));
    }

}
