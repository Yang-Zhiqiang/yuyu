package yuyu.def.sinkeiyaku.manager;


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

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.DengkByMosnoRstuukasyuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 未整理事由別明細作成処理<br />
 * 伝票金額Bean取得 申込番号 通貨種類 領収日のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getDengkByMosnoRstuukasyuRyosyuymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        DengkByMosnoRstuukasyuBean dengkByMosnoRstuukasyuBean = sinkeiyakuDomManager.getDengkByMosnoRstuukasyuRyosyuymd(
            "791112220", C_Tuukasyu.BLNK, BizDate.valueOf("20170824"));
        Assert.assertNull(dengkByMosnoRstuukasyuBean);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(1);
        nyuukin1.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin1.setDenrenno("1000000001");
        nyuukin1.setEdano(1);
        nyuukin1.setRyosyuymd(BizDate.valueOf("20170824"));

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(2);
        nyuukin2.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin2.setDenrenno("1000000001");
        nyuukin2.setEdano(2);
        nyuukin2.setRyosyuymd(BizDate.valueOf("20170824"));

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(6);
        nyuukin3.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin3.setDenrenno("1000000001");
        nyuukin3.setEdano(4);
        nyuukin3.setRyosyuymd(BizDate.valueOf("20170824"));

        HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
        nyuukin6.setRenno(3);
        nyuukin6.setRstuukasyu(C_Tuukasyu.valueOf("0"));
        nyuukin6.setDenrenno("1000000001");
        nyuukin6.setEdano(1);
        nyuukin6.setRyosyuymd(BizDate.valueOf("20170824"));

        HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
        nyuukin7.setRenno(4);
        nyuukin7.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin7.setDenrenno("1000000002");
        nyuukin7.setEdano(1);
        nyuukin7.setRyosyuymd(BizDate.valueOf("20170824"));

        HT_Nyuukin nyuukin8 = syoriCTL1.createNyuukin();
        nyuukin8.setRenno(5);
        nyuukin8.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin8.setDenrenno("1000000001");
        nyuukin8.setEdano(3);
        nyuukin8.setRyosyuymd(BizDate.valueOf("20170824"));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Nyuukin nyuukin5 = syoriCTL2.createNyuukin();
        nyuukin5.setRenno(1);
        nyuukin5.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin5.setDenrenno("1000000001");
        nyuukin5.setEdano(1);
        nyuukin5.setRyosyuymd(BizDate.valueOf("20170824"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData("1000000001", 1);
        skDenpyoData1.setDengaikagk(BizCurrency.valueOf(110, BizCurrencyTypes.YEN));
        skDenpyoData1.setDenyenkagk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData("1000000001", 2);
        skDenpyoData2.setDengaikagk(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        skDenpyoData2.setDenyenkagk(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData("1000000001", 4);
        skDenpyoData3.setDengaikagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        skDenpyoData3.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData("1000000002", 3);
        skDenpyoData5.setDengaikagk(BizCurrency.valueOf(110, BizCurrencyTypes.YEN));
        skDenpyoData5.setDenyenkagk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        DengkByMosnoRstuukasyuBean dengkByMosnoRstuukasyuBean = sinkeiyakuDomManager.getDengkByMosnoRstuukasyuRyosyuymd(
            "791112238", C_Tuukasyu.BLNK, BizDate.valueOf("20170824"));

        Assert.assertNull(dengkByMosnoRstuukasyuBean);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        DengkByMosnoRstuukasyuBean dengkByMosnoRstuukasyuBean = sinkeiyakuDomManager.getDengkByMosnoRstuukasyuRyosyuymd(
            "791112220", C_Tuukasyu.JPY, BizDate.valueOf("20170824"));

        Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), dengkByMosnoRstuukasyuBean.getDenyenkagk());
        Assert.assertEquals(BizCurrency.valueOf(121, BizCurrencyTypes.YEN), dengkByMosnoRstuukasyuBean.getDengaikagk());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        DengkByMosnoRstuukasyuBean dengkByMosnoRstuukasyuBean = sinkeiyakuDomManager.getDengkByMosnoRstuukasyuRyosyuymd(
            "", C_Tuukasyu.USD, BizDate.valueOf("20170824"));

        Assert.assertNull(dengkByMosnoRstuukasyuBean);
    }

    @Test
    @TestOrder(40)
    public void blank2() {

        DengkByMosnoRstuukasyuBean dengkByMosnoRstuukasyuBean = sinkeiyakuDomManager.getDengkByMosnoRstuukasyuRyosyuymd(
            "791112238", C_Tuukasyu.USD, BizDate.valueOf("20170823"));

        Assert.assertNull(dengkByMosnoRstuukasyuBean);
    }
}