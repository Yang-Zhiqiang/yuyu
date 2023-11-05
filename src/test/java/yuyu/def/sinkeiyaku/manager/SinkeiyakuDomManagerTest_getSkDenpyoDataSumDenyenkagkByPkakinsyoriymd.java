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
 * getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(
            "791112220", C_Tuukasyu.JPY, BizDate.valueOf(20160819));
        Assert.assertEquals(0, sumLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(11);
        henkin1.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin1.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin1.setPkakindenrenno("100000001");
        henkin1.setPkakindenedano(11);

        HT_Henkin henkin2 = syoriCTL1.createHenkin();
        henkin2.setRenno(12);
        henkin2.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin2.setPkakinsyoriymd(BizDate.valueOf(20160818));
        henkin2.setPkakindenrenno("100000001");
        henkin2.setPkakindenedano(12);

        HT_Henkin henkin3 = syoriCTL1.createHenkin();
        henkin3.setRenno(13);
        henkin3.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin3.setPkakinsyoriymd(BizDate.valueOf(20160817));
        henkin3.setPkakindenrenno("100000001");
        henkin3.setPkakindenedano(13);

        HT_Henkin henkin5 = syoriCTL1.createHenkin();
        henkin5.setRenno(15);
        henkin5.setHnkntuukasyu(C_Tuukasyu.BLNK);
        henkin5.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin5.setPkakindenrenno("100000001");
        henkin5.setPkakindenedano(11);

        HT_Henkin henkin6 = syoriCTL1.createHenkin();
        henkin6.setRenno(16);
        henkin6.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin6.setPkakinsyoriymd(BizDate.valueOf(20160820));
        henkin6.setPkakindenrenno("100000001");
        henkin6.setPkakindenedano(11);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Henkin henkin4 = syoriCTL2.createHenkin();
        henkin4.setRenno(11);
        henkin4.setHnkntuukasyu(C_Tuukasyu.JPY);
        henkin4.setPkakinsyoriymd(BizDate.valueOf(20160819));
        henkin4.setPkakindenrenno("100000001");
        henkin4.setPkakindenedano(11);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin7 = syoriCTL3.createHenkin();
        henkin7.setRenno(11);
        henkin7.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin7.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin7.setPkakindenrenno("100000003");
        henkin7.setPkakindenedano(11);

        HT_Henkin henkin8 = syoriCTL3.createHenkin();
        henkin8.setRenno(12);
        henkin8.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin8.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin8.setPkakindenrenno("100000003");
        henkin8.setPkakindenedano(12);

        HT_Henkin henkin9 = syoriCTL3.createHenkin();
        henkin9.setRenno(13);
        henkin9.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin9.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin9.setPkakindenrenno("100000003");
        henkin9.setPkakindenedano(13);

        HT_Henkin henkin10 = syoriCTL3.createHenkin();
        henkin10.setRenno(14);
        henkin10.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin10.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin10.setPkakindenrenno("100000003");
        henkin10.setPkakindenedano(14);

        HT_Henkin henkin11 = syoriCTL3.createHenkin();
        henkin11.setRenno(15);
        henkin11.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin11.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin11.setPkakindenrenno("100000003");
        henkin11.setPkakindenedano(15);

        HT_Henkin henkin12 = syoriCTL3.createHenkin();
        henkin12.setRenno(16);
        henkin12.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin12.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin12.setPkakindenrenno("100000003");
        henkin12.setPkakindenedano(16);

        HT_Henkin henkin13 = syoriCTL3.createHenkin();
        henkin13.setRenno(17);
        henkin13.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin13.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin13.setPkakindenrenno("100000003");
        henkin13.setPkakindenedano(17);

        HT_Henkin henkin14 = syoriCTL3.createHenkin();
        henkin14.setRenno(18);
        henkin14.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin14.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin14.setPkakindenrenno("100000003");
        henkin14.setPkakindenedano(18);

        HT_Henkin henkin15 = syoriCTL3.createHenkin();
        henkin15.setRenno(19);
        henkin15.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin15.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin15.setPkakindenrenno("100000003");
        henkin15.setPkakindenedano(19);

        HT_Henkin henkin16 = syoriCTL3.createHenkin();
        henkin16.setRenno(20);
        henkin16.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin16.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin16.setPkakindenrenno("100000003");
        henkin16.setPkakindenedano(20);

        HT_Henkin henkin17 = syoriCTL3.createHenkin();
        henkin17.setRenno(21);
        henkin17.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin17.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin17.setPkakindenrenno("100000003");
        henkin17.setPkakindenedano(21);

        HT_Henkin henkin18 = syoriCTL3.createHenkin();
        henkin18.setRenno(22);
        henkin18.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin18.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin18.setPkakindenrenno("100000003");
        henkin18.setPkakindenedano(22);

        HT_Henkin henkin19 = syoriCTL3.createHenkin();
        henkin19.setRenno(23);
        henkin19.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin19.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin19.setPkakindenrenno("100000003");
        henkin19.setPkakindenedano(23);

        HT_Henkin henkin20 = syoriCTL3.createHenkin();
        henkin20.setRenno(24);
        henkin20.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin20.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin20.setPkakindenrenno("100000003");
        henkin20.setPkakindenedano(24);

        HT_Henkin henkin21 = syoriCTL3.createHenkin();
        henkin21.setRenno(25);
        henkin21.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin21.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin21.setPkakindenrenno("100000003");
        henkin21.setPkakindenedano(25);

        HT_Henkin henkin22 = syoriCTL3.createHenkin();
        henkin22.setRenno(26);
        henkin22.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin22.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin22.setPkakindenrenno("100000003");
        henkin22.setPkakindenedano(26);

        HT_Henkin henkin23 = syoriCTL3.createHenkin();
        henkin23.setRenno(27);
        henkin23.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin23.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin23.setPkakindenrenno("100000003");
        henkin23.setPkakindenedano(27);

        HT_Henkin henkin24 = syoriCTL3.createHenkin();
        henkin24.setRenno(28);
        henkin24.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin24.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin24.setPkakindenrenno("100000003");
        henkin24.setPkakindenedano(28);

        HT_Henkin henkin25 = syoriCTL3.createHenkin();
        henkin25.setRenno(29);
        henkin25.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin25.setPkakinsyoriymd(BizDate.valueOf(20160919));
        henkin25.setPkakindenrenno("100000003");
        henkin25.setPkakindenedano(29);

        HT_Henkin henkin26 = syoriCTL3.createHenkin();
        henkin26.setRenno(30);
        henkin26.setHnkntuukasyu(C_Tuukasyu.USD);
        henkin26.setPkakinsyoriymd(BizDate.valueOf(20160918));
        henkin26.setPkakindenrenno("100000003");
        henkin26.setPkakindenedano(30);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData("100000001", 11);
        skDenpyoData1.setDenyenkagk(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData("100000001", 12);
        skDenpyoData2.setDenyenkagk(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData("100000001", 13);
        skDenpyoData3.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData4 = new HT_SkDenpyoData("100000002", 11);
        skDenpyoData4.setDenyenkagk(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData4);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData("100000001", 15);
        skDenpyoData5.setDenyenkagk(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData5);

        HT_SkDenpyoData skDenpyoData6 = new HT_SkDenpyoData("100000003", 11);
        skDenpyoData6.setDenyenkagk(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData6);

        HT_SkDenpyoData skDenpyoData7 = new HT_SkDenpyoData("100000003", 12);
        skDenpyoData7.setDenyenkagk(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData7);

        HT_SkDenpyoData skDenpyoData8 = new HT_SkDenpyoData("100000003", 13);
        skDenpyoData8.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData8);

        HT_SkDenpyoData skDenpyoData9 = new HT_SkDenpyoData("100000003", 14);

        sinkeiyakuDomManager.insert(skDenpyoData9);

        HT_SkDenpyoData skDenpyoData10 = new HT_SkDenpyoData("100000003", 15);
        skDenpyoData10.setDenyenkagk(BizCurrency.valueOf(5, BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData10);

        HT_SkDenpyoData skDenpyoData11 = new HT_SkDenpyoData("100000003", 16);
        skDenpyoData11.setDenyenkagk(BizCurrency.valueOf(6, BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData11);

        HT_SkDenpyoData skDenpyoData12 = new HT_SkDenpyoData("100000003", 17);
        skDenpyoData12.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData12);

        HT_SkDenpyoData skDenpyoData13 = new HT_SkDenpyoData("100000003", 18);

        sinkeiyakuDomManager.insert(skDenpyoData13);

        HT_SkDenpyoData skDenpyoData14 = new HT_SkDenpyoData("100000003", 19);
        skDenpyoData14.setDenyenkagk(BizCurrency.valueOf(3.5, BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData14);

        HT_SkDenpyoData skDenpyoData15 = new HT_SkDenpyoData("100000003", 20);
        skDenpyoData15.setDenyenkagk(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData15);

        HT_SkDenpyoData skDenpyoData16 = new HT_SkDenpyoData("100000003", 21);
        skDenpyoData16.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData16);

        HT_SkDenpyoData skDenpyoData17 = new HT_SkDenpyoData("100000003", 22);

        sinkeiyakuDomManager.insert(skDenpyoData17);

        HT_SkDenpyoData skDenpyoData18 = new HT_SkDenpyoData("100000003", 23);
        skDenpyoData18.setDenyenkagk(BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData18);

        HT_SkDenpyoData skDenpyoData19 = new HT_SkDenpyoData("100000003", 24);
        skDenpyoData19.setDenyenkagk(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData19);

        HT_SkDenpyoData skDenpyoData20 = new HT_SkDenpyoData("100000003", 25);
        skDenpyoData20.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData20);

        HT_SkDenpyoData skDenpyoData21 = new HT_SkDenpyoData("100000003", 26);

        sinkeiyakuDomManager.insert(skDenpyoData21);

        HT_SkDenpyoData skDenpyoData22 = new HT_SkDenpyoData("100000003", 27);
        skDenpyoData22.setDenyenkagk(BizCurrency.valueOf(10, BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData22);

        HT_SkDenpyoData skDenpyoData23 = new HT_SkDenpyoData("100000003", 28);
        skDenpyoData23.setDenyenkagk(BizCurrency.valueOf(0.5, BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData23);

        HT_SkDenpyoData skDenpyoData24 = new HT_SkDenpyoData("100000003", 29);
        skDenpyoData24.setDenyenkagk(BizCurrency.valueOf(0, BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData24);

        HT_SkDenpyoData skDenpyoData25 = new HT_SkDenpyoData("100000003", 30);

        sinkeiyakuDomManager.insert(skDenpyoData25);
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

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(
            "791112238", C_Tuukasyu.BLNK, BizDate.valueOf(20160819));
        Assert.assertEquals(0, sumLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(
            "791112220", C_Tuukasyu.JPY, BizDate.valueOf(20160819));
        Assert.assertEquals(1, sumLst.size());
        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.YEN), sumLst.get(0));
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(
            "791112246", C_Tuukasyu.USD, BizDate.valueOf(20160919));
        Assert.assertEquals(6, sumLst.size());
        Assert.assertEquals(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), sumLst.get(0));
        Assert.assertEquals(BizCurrency.valueOf(1.5, BizCurrencyTypes.DOLLAR), sumLst.get(1));
        Assert.assertEquals(BizCurrency.valueOf(0.5, BizCurrencyTypes.EURO), sumLst.get(2));
        Assert.assertEquals(BizCurrency.valueOf(6, BizCurrencyTypes.MANYEN), sumLst.get(3));
        Assert.assertEquals(BizCurrency.valueOf(10, BizCurrencyTypes.YEN), sumLst.get(4));
        Assert.assertEquals(null, sumLst.get(5));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        List<BizCurrency> sumLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(
            "", C_Tuukasyu.JPY, BizDate.valueOf(20160819));
        Assert.assertEquals(0, sumLst.size());
    }
}
