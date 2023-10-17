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
 * 返金額合計マップクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinSumHnkngk {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");

            Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngk();
            Assert.assertEquals(0, sumHnkngkMap.size());

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(10);

            HT_Henkin henkin2 = syoriCTL1.createHenkin();
            henkin2.setRenno(11);
            henkin2.setHnkngk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));

            HT_Henkin henkin3 = syoriCTL1.createHenkin();
            henkin3.setRenno(12);
            henkin3.setHnkngk(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

            HT_Henkin henkin5 = syoriCTL1.createHenkin();
            henkin5.setRenno(13);
            henkin5.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

            HT_Henkin henkin6 = syoriCTL1.createHenkin();
            henkin6.setRenno(14);
            henkin6.setHnkngk(BizCurrency.valueOf(500 ,BizCurrencyTypes.MANYEN));

            HT_Henkin henkin7 = syoriCTL1.createHenkin();
            henkin7.setRenno(15);
            henkin7.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.MANYEN));

            HT_Henkin henkin9 = syoriCTL1.createHenkin();
            henkin9.setRenno(17);
            henkin9.setHnkngk(BizCurrency.valueOf(25.5, BizCurrencyTypes.DOLLAR));

            HT_Henkin henkin10 = syoriCTL1.createHenkin();
            henkin10.setRenno(18);
            henkin10.setHnkngk(BizCurrency.valueOf(34.5, BizCurrencyTypes.DOLLAR));

            HT_Henkin henkin11 = syoriCTL1.createHenkin();
            henkin11.setRenno(19);
            henkin11.setHnkngk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

            HT_Henkin henkin12 = syoriCTL1.createHenkin();
            henkin12.setRenno(20);

            HT_Henkin henkin13 = syoriCTL1.createHenkin();
            henkin13.setRenno(21);
            henkin13.setHnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));

            sinkeiyakuDomManager.insert(syoriCTL1);

        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("10000000070");

        HT_Henkin henkin14 = syoriCTL2.createHenkin();
        henkin14.setRenno(19);
        henkin14.setHnkngk(BizCurrency.valueOf(400, BizCurrencyTypes.YEN));

        HT_Henkin henkin15 = syoriCTL2.createHenkin();
        henkin15.setRenno(20);
        henkin15.setHnkngk(BizCurrency.valueOf(600, BizCurrencyTypes.YEN));

        HT_Henkin henkin16 = syoriCTL2.createHenkin();
        henkin16.setRenno(21);
        henkin16.setHnkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

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
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngk();

        Assert.assertEquals(0, sumHnkngkMap.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000070");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngk();

        Assert.assertEquals(BizCurrency.valueOf(2000), sumHnkngkMap.get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        Map<CurrencyType, BizCurrency> sumHnkngkMap = syoriCTL1.getHenkinSumHnkngk();

        Assert.assertEquals(BizCurrency.valueOf(5000), sumHnkngkMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(600, BizCurrencyTypes.MANYEN), sumHnkngkMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(160, BizCurrencyTypes.DOLLAR), sumHnkngkMap.get(BizCurrencyTypes.DOLLAR));
    }

}
