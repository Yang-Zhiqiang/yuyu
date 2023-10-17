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

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkDenpyoDataSumDenyenkagkByHenkin() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDataSumDenyenkagkByHenkin {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(
            "791112220",1,C_Tuukasyu.JPY, BizDate.valueOf(20160822), BizDate.valueOf(20160822));
        Assert.assertEquals(0, bizCurrencyLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(1);
        henkin1.setHnknsyoriymd(BizDate.valueOf(20160823));
        henkin1.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin1.setPkakinsyoriymd(BizDate.valueOf(20160822));
        henkin1.setPkakindenrenno("10");
        henkin1.setPkakindenedano(1);

        HT_Henkin henkin3 = syoriCTL1.createHenkin();
        henkin3.setRenno(3);
        henkin3.setHnknsyoriymd(BizDate.valueOf(20160823));
        henkin3.setHnkntuukasyu(C_Tuukasyu.BLNK);
        henkin3.setPkakinsyoriymd(BizDate.valueOf(20160822));
        henkin3.setPkakindenrenno("10");
        henkin3.setPkakindenedano(1);

        HT_Henkin henkin4 = syoriCTL1.createHenkin();
        henkin4.setRenno(4);
        henkin4.setHnknsyoriymd(BizDate.valueOf(20160823));
        henkin4.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin4.setPkakinsyoriymd(BizDate.valueOf(20160823));
        henkin4.setPkakindenrenno("10");
        henkin4.setPkakindenedano(1);

        HT_Henkin henkin5 = syoriCTL1.createHenkin();
        henkin5.setRenno(5);
        henkin5.setHnknsyoriymd(BizDate.valueOf(20160822));
        henkin5.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin5.setPkakinsyoriymd(BizDate.valueOf(20160822));
        henkin5.setPkakindenrenno("10");
        henkin5.setPkakindenedano(1);

        HT_Henkin henkin6 = syoriCTL1.createHenkin();
        henkin6.setRenno(6);
        henkin6.setHnknsyoriymd(BizDate.valueOf(20160821));
        henkin6.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin6.setPkakinsyoriymd(BizDate.valueOf(20160822));
        henkin6.setPkakindenrenno("10");
        henkin6.setPkakindenedano(1);

        HT_Henkin henkin7 = syoriCTL1.createHenkin();
        henkin7.setRenno(7);
        henkin7.setHnknsyoriymd(BizDate.valueOf(20160823));
        henkin7.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin7.setPkakinsyoriymd(BizDate.valueOf(20160821));
        henkin7.setPkakindenrenno("10");
        henkin7.setPkakindenedano(2);

        HT_Henkin henkin8 = syoriCTL1.createHenkin();
        henkin8.setRenno(8);
        henkin8.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin8.setPkakinsyoriymd(BizDate.valueOf(20160820));
        henkin8.setPkakindenrenno("10");
        henkin8.setPkakindenedano(3);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Henkin henkin2 = syoriCTL2.createHenkin();
        henkin2.setRenno(2);
        henkin2.setHnknsyoriymd(BizDate.valueOf(20160823));
        henkin2.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin2.setPkakinsyoriymd(BizDate.valueOf(20160822));
        henkin2.setPkakindenrenno("10");
        henkin2.setPkakindenedano(1);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin9 = syoriCTL3.createHenkin();
        henkin9.setRenno(9);
        henkin9.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin9.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin9.setPkakindenrenno("10");
        henkin9.setPkakindenedano(4);

        HT_Henkin henkin10 = syoriCTL3.createHenkin();
        henkin10.setRenno(10);
        henkin10.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin10.setPkakinsyoriymd(BizDate.valueOf(20160820));
        henkin10.setPkakindenrenno("10");
        henkin10.setPkakindenedano(6);

        HT_Henkin henkin11 = syoriCTL3.createHenkin();
        henkin11.setRenno(11);
        henkin11.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin11.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin11.setPkakindenrenno("10");
        henkin11.setPkakindenedano(7);

        HT_Henkin henkin12 = syoriCTL3.createHenkin();
        henkin12.setRenno(12);
        henkin12.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin12.setPkakinsyoriymd(BizDate.valueOf(20160820));
        henkin12.setPkakindenrenno("10");
        henkin12.setPkakindenedano(8);

        HT_Henkin henkin13 = syoriCTL3.createHenkin();
        henkin13.setRenno(13);
        henkin13.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin13.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin13.setPkakindenrenno("10");
        henkin13.setPkakindenedano(9);

        HT_Henkin henkin14 = syoriCTL3.createHenkin();
        henkin14.setRenno(14);
        henkin14.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin14.setPkakinsyoriymd(BizDate.valueOf(20160820));
        henkin14.setPkakindenrenno("10");
        henkin14.setPkakindenedano(10);

        HT_Henkin henkin15 = syoriCTL3.createHenkin();
        henkin15.setRenno(15);
        henkin15.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin15.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin15.setPkakindenrenno("10");
        henkin15.setPkakindenedano(11);

        HT_Henkin henkin16 = syoriCTL3.createHenkin();
        henkin16.setRenno(16);
        henkin16.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin16.setPkakinsyoriymd(BizDate.valueOf(20160820));
        henkin16.setPkakindenrenno("10");
        henkin16.setPkakindenedano(12);

        HT_Henkin henkin17 = syoriCTL3.createHenkin();
        henkin17.setRenno(17);
        henkin17.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin17.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin17.setPkakindenrenno("10");
        henkin17.setPkakindenedano(13);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData("10", 1);
        skDenpyoData1.setDenyenkagk(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData("20", 1);
        skDenpyoData2.setDenyenkagk(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData("10", 5);
        skDenpyoData3.setDenyenkagk(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData4 = new HT_SkDenpyoData("10", 3);
        skDenpyoData4.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData4);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData("10", 4);

        sinkeiyakuDomManager.insert(skDenpyoData5);

        HT_SkDenpyoData skDenpyoData6 = new HT_SkDenpyoData("10", 2);
        skDenpyoData6.setDenyenkagk(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData6);

        HT_SkDenpyoData skDenpyoData7 = new HT_SkDenpyoData("10", 6);
        skDenpyoData7.setDenyenkagk(BizCurrency.valueOf(20, BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData7);

        HT_SkDenpyoData skDenpyoData8 = new HT_SkDenpyoData("10", 7);
        skDenpyoData8.setDenyenkagk(BizCurrency.valueOf(30, BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData8);

        HT_SkDenpyoData skDenpyoData9 = new HT_SkDenpyoData("10", 8);
        skDenpyoData9.setDenyenkagk(BizCurrency.valueOf(10.1, BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData9);

        HT_SkDenpyoData skDenpyoData10 = new HT_SkDenpyoData("10", 9);
        skDenpyoData10.setDenyenkagk(BizCurrency.valueOf(9.9, BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData10);

        HT_SkDenpyoData skDenpyoData11 = new HT_SkDenpyoData("10", 10);
        skDenpyoData11.setDenyenkagk(BizCurrency.valueOf(10.1, BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData11);

        HT_SkDenpyoData skDenpyoData12 = new HT_SkDenpyoData("10", 11);
        skDenpyoData12.setDenyenkagk(BizCurrency.valueOf(8.9, BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData12);

        HT_SkDenpyoData skDenpyoData13 = new HT_SkDenpyoData("10", 12);
        skDenpyoData13.setDenyenkagk(BizCurrency.valueOf(9.1, BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData13);

        HT_SkDenpyoData skDenpyoData14 = new HT_SkDenpyoData("10", 13);
        skDenpyoData14.setDenyenkagk(BizCurrency.valueOf(0.9, BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData14);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager SinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSyoriCTL());
        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSkDenpyoData());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(
            "791112238", 1,C_Tuukasyu.BLNK, BizDate.valueOf(20160822), BizDate.valueOf(20160822));
        Assert.assertEquals(0, bizCurrencyLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(
            "791112220", 1,C_Tuukasyu.JPY, BizDate.valueOf(20160822), BizDate.valueOf(20160822));
        Assert.assertEquals(1, bizCurrencyLst.size());

        Assert.assertEquals(BizCurrency.valueOf(10, BizCurrencyTypes.YEN), bizCurrencyLst.get(0));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByHenkin(
            "", 1,C_Tuukasyu.JPY, BizDate.valueOf(20160822), BizDate.valueOf(20160822));
        Assert.assertEquals(0, bizCurrencyLst.size());
    }
}
