package yuyu.def.db.entity;

import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
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
import yuyu.testinfr.TestOrder;

/**
 * 入金テーブルエンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyoriCTLTest_getNyuukinSumRsgakuByRstuukasyu {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("791112220");

            Map<CurrencyType, BizCurrency> syoriCTLMap = syoriCTL1.getNyuukinSumRsgakuByRstuukasyu(C_Tuukasyu.BLNK);
            Assert.assertEquals(0, syoriCTLMap.size());

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(1);
            nyuukin1.setRsgaku(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));
            nyuukin1.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(2);
            nyuukin2.setRsgaku(BizCurrency.valueOf(234, BizCurrencyTypes.YEN));
            nyuukin2.setRstuukasyu(C_Tuukasyu.BLNK);

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(3);
            nyuukin3.setRsgaku(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));
            nyuukin3.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(4);
            nyuukin4.setRsgaku(BizCurrency.valueOf(234, BizCurrencyTypes.YEN));
            nyuukin4.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
            nyuukin5.setRenno(5);
            nyuukin5.setRsgaku(BizCurrency.valueOf(4.1, BizCurrencyTypes.DOLLAR));
            nyuukin5.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
            nyuukin6.setRenno(6);
            nyuukin6.setRsgaku(BizCurrency.valueOf(5.9, BizCurrencyTypes.DOLLAR));
            nyuukin6.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
            nyuukin7.setRenno(7);
            nyuukin7.setRsgaku(BizCurrency.valueOf(110, BizCurrencyTypes.MANYEN));
            nyuukin7.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin8 = syoriCTL1.createNyuukin();
            nyuukin8.setRenno(8);
            nyuukin8.setRsgaku(BizCurrency.valueOf(13, BizCurrencyTypes.MANYEN));
            nyuukin8.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin9 = syoriCTL1.createNyuukin();
            nyuukin9.setRenno(9);
            nyuukin9.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin10 = syoriCTL1.createNyuukin();
            nyuukin10.setRenno(10);
            nyuukin10.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            nyuukin10.setRstuukasyu(C_Tuukasyu.EUR);

            HT_Nyuukin nyuukin11 = syoriCTL1.createNyuukin();
            nyuukin11.setRenno(11);
            nyuukin11.setRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
            nyuukin11.setRstuukasyu(C_Tuukasyu.EUR);

            sinkeiyakuDomManager.insert(syoriCTL1);

        }
        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("791112444");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("791112444");
            HT_Nyuukin nyuukin9 = syoriCTL2.createNyuukin();
            nyuukin9.setRenno(1);
            nyuukin9.setRsgaku(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));
            nyuukin9.setRstuukasyu(C_Tuukasyu.EUR);
            sinkeiyakuDomManager.insert(syoriCTL2);
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
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> syoriCTLMap = syoriCTL1.getNyuukinSumRsgakuByRstuukasyu(C_Tuukasyu.JPY);
        Assert.assertEquals(0, syoriCTLMap.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Map<CurrencyType, BizCurrency> syoriCTLMap = syoriCTL1.getNyuukinSumRsgakuByRstuukasyu(C_Tuukasyu.EUR);
        Assert.assertEquals(BizCurrency.valueOf(480, BizCurrencyTypes.YEN), syoriCTLMap.get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(123, BizCurrencyTypes.MANYEN), syoriCTLMap.get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), syoriCTLMap.get(BizCurrencyTypes.DOLLAR));
    }


}
