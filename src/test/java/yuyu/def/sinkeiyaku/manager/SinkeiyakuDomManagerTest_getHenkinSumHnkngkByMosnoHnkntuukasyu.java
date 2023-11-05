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

import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHenkinSumHnkngkByMosnoHnkntuukasyu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinSumHnkngkByMosnoHnkntuukasyu {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnkntuukasyu("791112220", C_Tuukasyu.JPY);
        Assert.assertEquals(0, sumRsgakuMap.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(11);
        henkin1.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin1.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
        henkin1.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin2 = syoriCTL1.createHenkin();
        henkin2.setRenno(12);
        henkin2.setHnkngk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        henkin2.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
        henkin2.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin4 = syoriCTL1.createHenkin();
        henkin4.setRenno(13);
        henkin4.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin4.setHnkntuukasyu(C_Tuukasyu.valueOf("0"));
        henkin4.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin5 = syoriCTL1.createHenkin();
        henkin5.setRenno(14);
        henkin5.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin5.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
        henkin5.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Henkin henkin3 = syoriCTL2.createHenkin();
        henkin3.setRenno(11);
        henkin3.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin3.setHnkntuukasyu(C_Tuukasyu.valueOf("JPY"));
        henkin3.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin6 = syoriCTL3.createHenkin();
        henkin6.setRenno(11);
        henkin6.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin6.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin6.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin7 = syoriCTL3.createHenkin();
        henkin7.setRenno(12);
        henkin7.setHnkngk(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        henkin7.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin7.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin8 = syoriCTL3.createHenkin();
        henkin8.setRenno(13);
        henkin8.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        henkin8.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin8.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin9 = syoriCTL3.createHenkin();
        henkin9.setRenno(14);
        henkin9.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin9.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin10 = syoriCTL3.createHenkin();
        henkin10.setRenno(15);
        henkin10.setHnkngk(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));
        henkin10.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin10.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin11 = syoriCTL3.createHenkin();
        henkin11.setRenno(16);
        henkin11.setHnkngk(BizCurrency.valueOf(1, BizCurrencyTypes.MANYEN));
        henkin11.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin11.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin12 = syoriCTL3.createHenkin();
        henkin12.setRenno(17);
        henkin12.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        henkin12.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin12.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin13 = syoriCTL3.createHenkin();
        henkin13.setRenno(18);
        henkin13.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin13.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin14 = syoriCTL3.createHenkin();
        henkin14.setRenno(19);
        henkin14.setHnkngk(BizCurrency.valueOf(2.5, BizCurrencyTypes.DOLLAR));
        henkin14.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin14.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin15 = syoriCTL3.createHenkin();
        henkin15.setRenno(20);
        henkin15.setHnkngk(BizCurrency.valueOf(2.5, BizCurrencyTypes.DOLLAR));
        henkin15.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin15.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin16 = syoriCTL3.createHenkin();
        henkin16.setRenno(21);
        henkin16.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        henkin16.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin16.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin17 = syoriCTL3.createHenkin();
        henkin17.setRenno(22);
        henkin17.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin17.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin18 = syoriCTL3.createHenkin();
        henkin18.setRenno(23);
        henkin18.setHnkngk(BizCurrency.valueOf(11, BizCurrencyTypes.AU_DOLLAR));
        henkin18.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin18.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin19 = syoriCTL3.createHenkin();
        henkin19.setRenno(24);
        henkin19.setHnkngk(BizCurrency.valueOf(12, BizCurrencyTypes.AU_DOLLAR));
        henkin19.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin19.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin20 = syoriCTL3.createHenkin();
        henkin20.setRenno(25);
        henkin20.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        henkin20.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin20.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin21 = syoriCTL3.createHenkin();
        henkin21.setRenno(26);
        henkin21.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin21.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin22 = syoriCTL3.createHenkin();
        henkin22.setRenno(27);
        henkin22.setHnkngk(BizCurrency.valueOf(5, BizCurrencyTypes.EURO));
        henkin22.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin22.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin23 = syoriCTL3.createHenkin();
        henkin23.setRenno(28);
        henkin23.setHnkngk(BizCurrency.valueOf(2.5, BizCurrencyTypes.EURO));
        henkin23.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin23.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin24 = syoriCTL3.createHenkin();
        henkin24.setRenno(29);
        henkin24.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
        henkin24.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin24.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        HT_Henkin henkin25 = syoriCTL3.createHenkin();
        henkin25.setRenno(30);
        henkin25.setHnkntuukasyu(C_Tuukasyu.valueOf("USD"));
        henkin25.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        sinkeiyakuDomManager.insert(syoriCTL3);
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

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnkntuukasyu("791112238", C_Tuukasyu.BLNK);
        Assert.assertEquals(0, sumRsgakuMap.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnkntuukasyu("791112220", C_Tuukasyu.JPY);
        Assert.assertEquals(BizCurrency.valueOf(101, BizCurrencyTypes.YEN), sumRsgakuMap.get(BizCurrencyTypes.YEN));
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnkntuukasyu("791112246", C_Tuukasyu.USD);
        Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), sumRsgakuMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.MANYEN), sumRsgakuMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(5, BizCurrencyTypes.DOLLAR), sumRsgakuMap.get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(23, BizCurrencyTypes.AU_DOLLAR), sumRsgakuMap.get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(7.5, BizCurrencyTypes.EURO), sumRsgakuMap.get(BizCurrencyTypes.EURO));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        Map<CurrencyType, BizCurrency> sumRsgakuMap = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnkntuukasyu("", C_Tuukasyu.JPY);
        Assert.assertEquals(0, sumRsgakuMap.size());
    }
}
