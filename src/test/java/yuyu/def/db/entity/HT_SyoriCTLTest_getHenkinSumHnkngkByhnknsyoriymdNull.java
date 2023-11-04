package yuyu.def.db.entity;

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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルの返金額合計取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinSumHnkngkByhnknsyoriymdNull {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin11 = syoriCTL1.createHenkin();
        henkin11.setRenno(new Integer(1));
        henkin11.setHnknsyoriymd(BizDate.valueOf("20160406"));
        henkin11.setHnkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        List<BizCurrency> sumHnkngkLst = syoriCTL2.getHenkinSumHnkngkByhnknsyoriymdNull();
        Assert.assertEquals(0, sumHnkngkLst.size());

        HT_Henkin henkin21 = syoriCTL2.createHenkin();
        henkin21.setRenno(new Integer(1));
        henkin21.setHnkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin31 = syoriCTL3.createHenkin();
        henkin31.setRenno(new Integer(1));
        henkin31.setHnknsyoriymd(BizDate.valueOf("20160406"));
        henkin31.setHnkngk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));

        HT_Henkin henkin32 = syoriCTL3.createHenkin();
        henkin32.setRenno(new Integer(2));
        henkin32.setHnkngk(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));

        HT_Henkin henkin33 = syoriCTL3.createHenkin();
        henkin33.setRenno(new Integer(3));
        henkin33.setHnkngk(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

        HT_Henkin henkin34 = syoriCTL3.createHenkin();
        henkin34.setRenno(new Integer(4));
        henkin34.setHnkngk(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));

        HT_Henkin henkin35 = syoriCTL3.createHenkin();
        henkin35.setRenno(new Integer(5));
        henkin35.setHnkngk(BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR));

        HT_Henkin henkin36 = syoriCTL3.createHenkin();
        henkin36.setRenno(new Integer(6));
        henkin36.setHnkngk(BizCurrency.valueOf(50, BizCurrencyTypes.MANYEN));

        HT_Henkin henkin37 = syoriCTL3.createHenkin();
        henkin37.setRenno(new Integer(7));

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

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");

        List<BizCurrency> sumHnkngkLst = syoriCTL1.getHenkinSumHnkngkByhnknsyoriymdNull();

        Assert.assertEquals(0, sumHnkngkLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112238");

        List<BizCurrency> sumHnkngkLst = syoriCTL1.getHenkinSumHnkngkByhnknsyoriymdNull();

        Assert.assertEquals(1, sumHnkngkLst.size());

        Assert.assertEquals(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), sumHnkngkLst.get(0));
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("791112246");

        List<BizCurrency> sumHnkngkLst = syoriCTL2.getHenkinSumHnkngkByhnknsyoriymdNull();

        Assert.assertEquals(3, sumHnkngkLst.size());

        for (BizCurrency bizCurrency : sumHnkngkLst) {

            if (BizCurrencyTypes.YEN.equals(bizCurrency.getType())) {

                Assert.assertEquals(BizCurrency.valueOf(5000, BizCurrencyTypes.YEN), bizCurrency);
            }

            if (BizCurrencyTypes.DOLLAR.equals(bizCurrency.getType())) {

                Assert.assertEquals(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR), bizCurrency);
            }

            if (BizCurrencyTypes.MANYEN.equals(bizCurrency.getType())) {

                Assert.assertEquals(BizCurrency.valueOf(50, BizCurrencyTypes.MANYEN), bizCurrency);
            }
        }
    }
}
