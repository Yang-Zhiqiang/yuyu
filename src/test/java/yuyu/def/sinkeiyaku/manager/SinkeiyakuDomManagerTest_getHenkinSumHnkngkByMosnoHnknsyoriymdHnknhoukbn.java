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

import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn("791112220", BizDate.valueOf(20160215));

        Assert.assertEquals(0, sumLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(11);
        henkin1.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin1.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin1.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin2 = syoriCTL1.createHenkin();
        henkin2.setRenno(12);
        henkin2.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin2.setHnkngk(BizCurrency.valueOf(120, BizCurrencyTypes.YEN));
        henkin2.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin3 = syoriCTL1.createHenkin();
        henkin3.setRenno(13);
        henkin3.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin3.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        henkin3.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin4 = syoriCTL1.createHenkin();
        henkin4.setRenno(14);
        henkin4.setHnknsyoriymd(BizDate.valueOf(20160214));
        henkin4.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin4.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin5 = syoriCTL1.createHenkin();
        henkin5.setRenno(15);
        henkin5.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin5.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin5.setHnknhoukbn(C_HnknhouKbn.valueOf("4"));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Henkin henkin6 = syoriCTL2.createHenkin();
        henkin6.setRenno(11);
        henkin6.setHnknsyoriymd(BizDate.valueOf(20160215));
        henkin6.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin6.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin7 = syoriCTL3.createHenkin();
        henkin7.setRenno(16);
        henkin7.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin7.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        henkin7.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin8 = syoriCTL3.createHenkin();
        henkin8.setRenno(17);
        henkin8.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin8.setHnkngk(BizCurrency.valueOf(120, BizCurrencyTypes.YEN));
        henkin8.setHnknhoukbn(C_HnknhouKbn.valueOf("1"));

        HT_Henkin henkin9 = syoriCTL3.createHenkin();
        henkin9.setRenno(18);
        henkin9.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin9.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        henkin9.setHnknhoukbn(C_HnknhouKbn.valueOf("2"));

        HT_Henkin henkin10 = syoriCTL3.createHenkin();
        henkin10.setRenno(19);
        henkin10.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin10.setHnknhoukbn(C_HnknhouKbn.valueOf("3"));

        HT_Henkin henkin11 = syoriCTL3.createHenkin();
        henkin11.setRenno(20);
        henkin11.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin11.setHnkngk(BizCurrency.valueOf(11, BizCurrencyTypes.MANYEN));
        henkin11.setHnknhoukbn(C_HnknhouKbn.valueOf("5"));

        HT_Henkin henkin12 = syoriCTL3.createHenkin();
        henkin12.setRenno(21);
        henkin12.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin12.setHnkngk(BizCurrency.valueOf(10, BizCurrencyTypes.MANYEN));
        henkin12.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin13 = syoriCTL3.createHenkin();
        henkin13.setRenno(22);
        henkin13.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin13.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));
        henkin13.setHnknhoukbn(C_HnknhouKbn.valueOf("1"));

        HT_Henkin henkin14 = syoriCTL3.createHenkin();
        henkin14.setRenno(23);
        henkin14.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin14.setHnknhoukbn(C_HnknhouKbn.valueOf("2"));

        HT_Henkin henkin15 = syoriCTL3.createHenkin();
        henkin15.setRenno(24);
        henkin15.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin15.setHnkngk(BizCurrency.valueOf(3.5, BizCurrencyTypes.DOLLAR));
        henkin15.setHnknhoukbn(C_HnknhouKbn.valueOf("3"));

        HT_Henkin henkin16 = syoriCTL3.createHenkin();
        henkin16.setRenno(25);
        henkin16.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin16.setHnkngk(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR));
        henkin16.setHnknhoukbn(C_HnknhouKbn.valueOf("5"));

        HT_Henkin henkin17 = syoriCTL3.createHenkin();
        henkin17.setRenno(26);
        henkin17.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin17.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        henkin17.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin18 = syoriCTL3.createHenkin();
        henkin18.setRenno(27);
        henkin18.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin18.setHnknhoukbn(C_HnknhouKbn.valueOf("1"));

        HT_Henkin henkin19 = syoriCTL3.createHenkin();
        henkin19.setRenno(28);
        henkin19.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin19.setHnkngk(BizCurrency.valueOf(11, BizCurrencyTypes.AU_DOLLAR));
        henkin19.setHnknhoukbn(C_HnknhouKbn.valueOf("2"));

        HT_Henkin henkin20 = syoriCTL3.createHenkin();
        henkin20.setRenno(29);
        henkin20.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin20.setHnkngk(BizCurrency.valueOf(9, BizCurrencyTypes.AU_DOLLAR));
        henkin20.setHnknhoukbn(C_HnknhouKbn.valueOf("3"));

        HT_Henkin henkin21 = syoriCTL3.createHenkin();
        henkin21.setRenno(30);
        henkin21.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin21.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        henkin21.setHnknhoukbn(C_HnknhouKbn.valueOf("5"));

        HT_Henkin henkin22 = syoriCTL3.createHenkin();
        henkin22.setRenno(31);
        henkin22.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin22.setHnknhoukbn(C_HnknhouKbn.valueOf("0"));

        HT_Henkin henkin23 = syoriCTL3.createHenkin();
        henkin23.setRenno(32);
        henkin23.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin23.setHnkngk(BizCurrency.valueOf(1.5, BizCurrencyTypes.EURO));
        henkin23.setHnknhoukbn(C_HnknhouKbn.valueOf("1"));

        HT_Henkin henkin24 = syoriCTL3.createHenkin();
        henkin24.setRenno(33);
        henkin24.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin24.setHnkngk(BizCurrency.valueOf(10, BizCurrencyTypes.EURO));
        henkin24.setHnknhoukbn(C_HnknhouKbn.valueOf("2"));

        HT_Henkin henkin25 = syoriCTL3.createHenkin();
        henkin25.setRenno(34);
        henkin25.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin25.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));
        henkin25.setHnknhoukbn(C_HnknhouKbn.valueOf("3"));

        HT_Henkin henkin26 = syoriCTL3.createHenkin();
        henkin26.setRenno(35);
        henkin26.setHnknsyoriymd(BizDate.valueOf(20160315));
        henkin26.setHnknhoukbn(C_HnknhouKbn.valueOf("5"));

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

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn("791112238", BizDate.valueOf(20160214));

        Assert.assertEquals(0, sumLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn("791112220", BizDate.valueOf(20160215));

        Assert.assertEquals(1, sumLst.size());

        Assert.assertEquals(BizCurrency.valueOf(220, BizCurrencyTypes.YEN), sumLst.get(0));
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BizCurrency> sumHnkngkLst = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn("791112246", BizDate.valueOf(20160315));

        Assert.assertEquals(6, sumHnkngkLst.size());

        Assert.assertEquals(BizCurrency.valueOf(20, BizCurrencyTypes.AU_DOLLAR), sumHnkngkLst.get(0));

        Assert.assertEquals(BizCurrency.valueOf(5, BizCurrencyTypes.DOLLAR), sumHnkngkLst.get(1));

        Assert.assertEquals(BizCurrency.valueOf(11.5, BizCurrencyTypes.EURO), sumHnkngkLst.get(2));

        Assert.assertEquals(BizCurrency.valueOf(21, BizCurrencyTypes.MANYEN), sumHnkngkLst.get(3));

        Assert.assertEquals(BizCurrency.valueOf(220, BizCurrencyTypes.YEN), sumHnkngkLst.get(4));

        Assert.assertEquals(null, sumHnkngkLst.get(5));
    }

    @Test
    @TestOrder(40)
    public void blankCondition() {

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getHenkinSumHnkngkByMosnoHnknsyoriymdHnknhoukbn("", BizDate.valueOf(20160215));

        Assert.assertEquals(0, sumLst.size());
    }

}
