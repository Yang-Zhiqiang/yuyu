package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getNyuukinSumRyosyugkByMosnoMaxRenno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinSumRyosyugkByMosnoMaxRenno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getNyuukinSumRyosyugkByMosnoMaxRenno("10000000001");
        Assert.assertEquals(0, sumRsgakuMap.size());

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("10000000001");

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(3);
            nyuukin1.setRsgaku(BizCurrency.valueOf(3, BizCurrencyTypes.MANYEN));

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(4);
            nyuukin2.setRsgaku(BizCurrency.valueOf(150, BizCurrencyTypes.MANYEN));

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(5);
            nyuukin3.setRsgaku(BizCurrency.valueOf(4.9, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(6);
            nyuukin4.setRsgaku(BizCurrency.valueOf(123.6, BizCurrencyTypes.DOLLAR));

            HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
            nyuukin5.setRenno(7);
            nyuukin5.setRsgaku(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));


            HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
            nyuukin6.setRenno(8);
            nyuukin6.setRsgaku(null);

            HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
            nyuukin7.setRenno(9);
            nyuukin7.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));


            HT_Nyuukin nyuukin8 = syoriCTL1.createNyuukin();
            nyuukin8.setRenno(10);
            nyuukin8.setRsgaku(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin9 = syoriCTL1.createNyuukin();
            nyuukin9.setRenno(11);
            nyuukin9.setRsgaku(BizCurrency.valueOf(77, BizCurrencyTypes.YEN));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }
        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("10000000002");
            HT_Nyuukin nyuukin10 = syoriCTL2.createNyuukin();
            nyuukin10.setRenno(1);
            nyuukin10.setRsgaku(BizCurrency.valueOf(120, BizCurrencyTypes.YEN));
            sinkeiyakuDomManager.insert(syoriCTL2);
        }
        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        if (syoriCTL3 == null) {
            syoriCTL3 = new HT_SyoriCTL("10000000003");

            HT_Nyuukin nyuukin11 = syoriCTL3.createNyuukin();
            nyuukin11.setRenno(1);
            nyuukin11.setRsgaku(BizCurrency.valueOf(55, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin12 = syoriCTL3.createNyuukin();
            nyuukin12.setRenno(2);
            nyuukin12.setRsgaku(BizCurrency.valueOf(45, BizCurrencyTypes.YEN));

            HT_Nyuukin nyuukin13 = syoriCTL3.createNyuukin();
            nyuukin13.setRenno(3);
            nyuukin13.setRsgaku(BizCurrency.valueOf(456, BizCurrencyTypes.YEN));

            sinkeiyakuDomManager.insert(syoriCTL3);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager SinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSyoriCTL());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getNyuukinSumRyosyugkByMosnoMaxRenno("10000000002");
        Assert.assertEquals(0, sumRsgakuMap.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Map<CurrencyType, BizCurrency> syoriCTLMap = sinkeiyakuDomManager.getNyuukinSumRyosyugkByMosnoMaxRenno("10000000003");
        Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.YEN), syoriCTLMap.get(BizCurrencyTypes.YEN));
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<CurrencyType, BizCurrency> syoriCTLMap = sinkeiyakuDomManager.getNyuukinSumRyosyugkByMosnoMaxRenno("10000000001");
        Assert.assertEquals(BizCurrency.valueOf(223, BizCurrencyTypes.YEN), syoriCTLMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(153, BizCurrencyTypes.MANYEN), syoriCTLMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(128.5, BizCurrencyTypes.DOLLAR), syoriCTLMap.get(BizCurrencyTypes.DOLLAR));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getNyuukinSumRyosyugkByMosnoMaxRenno("");
        Assert.assertEquals(0, sumRsgakuMap.size());
    }
}
