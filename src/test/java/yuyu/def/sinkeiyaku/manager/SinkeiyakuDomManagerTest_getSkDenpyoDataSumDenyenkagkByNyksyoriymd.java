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
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkDenpyoDataSumDenyenkagkByNyksyoriymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDataSumDenyenkagkByNyksyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(
            "791112220", C_Tuukasyu.JPY, BizDate.valueOf(20160819));
        Assert.assertEquals(0, bizCurrencyLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(11);
        nyuukin1.setNyksyoriymd(BizDate.valueOf(20160819));
        nyuukin1.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin1.setDenrenno("100000001");
        nyuukin1.setEdano(11);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(12);
        nyuukin2.setNyksyoriymd(BizDate.valueOf(20160818));
        nyuukin2.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin2.setDenrenno("100000001");
        nyuukin2.setEdano(12);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(13);
        nyuukin3.setNyksyoriymd(BizDate.valueOf(20160817));
        nyuukin3.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin3.setDenrenno("100000001");
        nyuukin3.setEdano(13);

        HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
        nyuukin6.setRenno(15);
        nyuukin6.setNyksyoriymd(BizDate.valueOf(20160819));
        nyuukin6.setRstuukasyu(C_Tuukasyu.BLNK);
        nyuukin6.setDenrenno("100000001");
        nyuukin6.setEdano(11);

        HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
        nyuukin7.setRenno(16);
        nyuukin7.setNyksyoriymd(BizDate.valueOf(20160820));
        nyuukin7.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin7.setDenrenno("100000001");
        nyuukin7.setEdano(11);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Nyuukin nyuukin5 = syoriCTL2.createNyuukin();
        nyuukin5.setRenno(11);
        nyuukin5.setNyksyoriymd(BizDate.valueOf(20160819));
        nyuukin5.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin5.setDenrenno("100000001");
        nyuukin5.setEdano(11);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Nyuukin nyuukin8 = syoriCTL3.createNyuukin();
        nyuukin8.setRenno(17);
        nyuukin8.setNyksyoriymd(BizDate.valueOf(20090919));
        nyuukin8.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin8.setDenrenno("100000002");
        nyuukin8.setEdano(11);

        HT_Nyuukin nyuukin9 = syoriCTL3.createNyuukin();
        nyuukin9.setRenno(18);
        nyuukin9.setNyksyoriymd(BizDate.valueOf(20090918));
        nyuukin9.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin9.setDenrenno("100000002");
        nyuukin9.setEdano(12);

        HT_Nyuukin nyuukin10 = syoriCTL3.createNyuukin();
        nyuukin10.setRenno(19);
        nyuukin10.setNyksyoriymd(BizDate.valueOf(20090917));
        nyuukin10.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin10.setDenrenno("100000002");
        nyuukin10.setEdano(13);

        HT_Nyuukin nyuukin11 = syoriCTL3.createNyuukin();
        nyuukin11.setRenno(20);
        nyuukin11.setNyksyoriymd(BizDate.valueOf(20090916));
        nyuukin11.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin11.setDenrenno("100000002");
        nyuukin11.setEdano(14);

        HT_Nyuukin nyuukin12 = syoriCTL3.createNyuukin();
        nyuukin12.setRenno(21);
        nyuukin12.setNyksyoriymd(BizDate.valueOf(20090919));
        nyuukin12.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin12.setDenrenno("100000003");
        nyuukin12.setEdano(11);

        HT_Nyuukin nyuukin13 = syoriCTL3.createNyuukin();
        nyuukin13.setRenno(22);
        nyuukin13.setNyksyoriymd(BizDate.valueOf(20090918));
        nyuukin13.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin13.setDenrenno("100000003");
        nyuukin13.setEdano(12);

        HT_Nyuukin nyuukin14 = syoriCTL3.createNyuukin();
        nyuukin14.setRenno(23);
        nyuukin14.setNyksyoriymd(BizDate.valueOf(20090917));
        nyuukin14.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin14.setDenrenno("100000003");
        nyuukin14.setEdano(13);

        HT_Nyuukin nyuukin15 = syoriCTL3.createNyuukin();
        nyuukin15.setRenno(24);
        nyuukin15.setNyksyoriymd(BizDate.valueOf(20090916));
        nyuukin15.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin15.setDenrenno("100000003");
        nyuukin15.setEdano(14);

        HT_Nyuukin nyuukin16 = syoriCTL3.createNyuukin();
        nyuukin16.setRenno(25);
        nyuukin16.setNyksyoriymd(BizDate.valueOf(20090919));
        nyuukin16.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin16.setDenrenno("100000004");
        nyuukin16.setEdano(11);

        HT_Nyuukin nyuukin17 = syoriCTL3.createNyuukin();
        nyuukin17.setRenno(26);
        nyuukin17.setNyksyoriymd(BizDate.valueOf(20090918));
        nyuukin17.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin17.setDenrenno("100000004");
        nyuukin17.setEdano(12);

        HT_Nyuukin nyuukin18 = syoriCTL3.createNyuukin();
        nyuukin18.setRenno(27);
        nyuukin18.setNyksyoriymd(BizDate.valueOf(20090917));
        nyuukin18.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin18.setDenrenno("100000004");
        nyuukin18.setEdano(13);

        HT_Nyuukin nyuukin19 = syoriCTL3.createNyuukin();
        nyuukin19.setRenno(28);
        nyuukin19.setNyksyoriymd(BizDate.valueOf(20090916));
        nyuukin19.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin19.setDenrenno("100000004");
        nyuukin19.setEdano(14);

        HT_Nyuukin nyuukin20 = syoriCTL3.createNyuukin();
        nyuukin20.setRenno(29);
        nyuukin20.setNyksyoriymd(BizDate.valueOf(20090919));
        nyuukin20.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin20.setDenrenno("100000005");
        nyuukin20.setEdano(11);

        HT_Nyuukin nyuukin21 = syoriCTL3.createNyuukin();
        nyuukin21.setRenno(30);
        nyuukin21.setNyksyoriymd(BizDate.valueOf(20090918));
        nyuukin21.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin21.setDenrenno("100000005");
        nyuukin21.setEdano(12);

        HT_Nyuukin nyuukin22 = syoriCTL3.createNyuukin();
        nyuukin22.setRenno(31);
        nyuukin22.setNyksyoriymd(BizDate.valueOf(20090917));
        nyuukin22.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin22.setDenrenno("100000005");
        nyuukin22.setEdano(13);

        HT_Nyuukin nyuukin23 = syoriCTL3.createNyuukin();
        nyuukin23.setRenno(32);
        nyuukin23.setNyksyoriymd(BizDate.valueOf(20090916));
        nyuukin23.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin23.setDenrenno("100000005");
        nyuukin23.setEdano(14);

        HT_Nyuukin nyuukin24 = syoriCTL3.createNyuukin();
        nyuukin24.setRenno(33);
        nyuukin24.setNyksyoriymd(BizDate.valueOf(20090919));
        nyuukin24.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin24.setDenrenno("100000006");
        nyuukin24.setEdano(11);

        HT_Nyuukin nyuukin25 = syoriCTL3.createNyuukin();
        nyuukin25.setRenno(34);
        nyuukin25.setNyksyoriymd(BizDate.valueOf(20090918));
        nyuukin25.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin25.setDenrenno("100000006");
        nyuukin25.setEdano(12);

        HT_Nyuukin nyuukin26 = syoriCTL3.createNyuukin();
        nyuukin26.setRenno(35);
        nyuukin26.setNyksyoriymd(BizDate.valueOf(20090917));
        nyuukin26.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin26.setDenrenno("100000006");
        nyuukin26.setEdano(13);

        HT_Nyuukin nyuukin27 = syoriCTL3.createNyuukin();
        nyuukin27.setRenno(36);
        nyuukin27.setNyksyoriymd(BizDate.valueOf(20090916));
        nyuukin27.setRstuukasyu(C_Tuukasyu.JPY);
        nyuukin27.setDenrenno("100000006");
        nyuukin27.setEdano(14);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData("100000001", 11);
        skDenpyoData1.setDenyenkagk(BizCurrency.valueOf(11,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData("100000001", 12);
        skDenpyoData2.setDenyenkagk(BizCurrency.valueOf(12,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData("100000001", 13);
        skDenpyoData3.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData("100000020", 11);
        skDenpyoData5.setDenyenkagk(BizCurrency.valueOf(11,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData5);

        HT_SkDenpyoData skDenpyoData6 = new HT_SkDenpyoData("100000001", 15);
        skDenpyoData6.setDenyenkagk(BizCurrency.valueOf(12,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData6);

        HT_SkDenpyoData skDenpyoData7 = new HT_SkDenpyoData("100000002", 11);
        skDenpyoData7.setDenyenkagk(BizCurrency.valueOf(12,BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData7);

        HT_SkDenpyoData skDenpyoData8 = new HT_SkDenpyoData("100000002", 12);
        skDenpyoData8.setDenyenkagk(BizCurrency.valueOf(13,BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData8);

        HT_SkDenpyoData skDenpyoData9 = new HT_SkDenpyoData("100000002", 13);
        skDenpyoData9.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.MANYEN));

        sinkeiyakuDomManager.insert(skDenpyoData9);

        HT_SkDenpyoData skDenpyoData10 = new HT_SkDenpyoData("100000002", 14);

        sinkeiyakuDomManager.insert(skDenpyoData10);

        HT_SkDenpyoData skDenpyoData11 = new HT_SkDenpyoData("100000003", 11);
        skDenpyoData11.setDenyenkagk(BizCurrency.valueOf(12.5,BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData11);

        HT_SkDenpyoData skDenpyoData12 = new HT_SkDenpyoData("100000003", 12);
        skDenpyoData12.setDenyenkagk(BizCurrency.valueOf(14.5,BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData12);

        HT_SkDenpyoData skDenpyoData13 = new HT_SkDenpyoData("100000003", 13);
        skDenpyoData13.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData13);

        HT_SkDenpyoData skDenpyoData14 = new HT_SkDenpyoData("100000003", 14);

        sinkeiyakuDomManager.insert(skDenpyoData14);

        HT_SkDenpyoData skDenpyoData15 = new HT_SkDenpyoData("100000004", 11);
        skDenpyoData15.setDenyenkagk(BizCurrency.valueOf(12,BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData15);

        HT_SkDenpyoData skDenpyoData16 = new HT_SkDenpyoData("100000004", 12);
        skDenpyoData16.setDenyenkagk(BizCurrency.valueOf(18,BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData16);

        HT_SkDenpyoData skDenpyoData17 = new HT_SkDenpyoData("100000004", 13);
        skDenpyoData17.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));

        sinkeiyakuDomManager.insert(skDenpyoData17);

        HT_SkDenpyoData skDenpyoData18 = new HT_SkDenpyoData("100000004", 14);

        sinkeiyakuDomManager.insert(skDenpyoData18);

        HT_SkDenpyoData skDenpyoData19 = new HT_SkDenpyoData("100000005", 11);
        skDenpyoData19.setDenyenkagk(BizCurrency.valueOf(12,BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData19);

        HT_SkDenpyoData skDenpyoData20 = new HT_SkDenpyoData("100000005", 12);
        skDenpyoData20.setDenyenkagk(BizCurrency.valueOf(16,BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData20);

        HT_SkDenpyoData skDenpyoData21 = new HT_SkDenpyoData("100000005", 13);
        skDenpyoData21.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));

        sinkeiyakuDomManager.insert(skDenpyoData21);

        HT_SkDenpyoData skDenpyoData22 = new HT_SkDenpyoData("100000005", 14);

        sinkeiyakuDomManager.insert(skDenpyoData22);

        HT_SkDenpyoData skDenpyoData23 = new HT_SkDenpyoData("100000006", 11);
        skDenpyoData23.setDenyenkagk(BizCurrency.valueOf(12,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData23);

        HT_SkDenpyoData skDenpyoData24 = new HT_SkDenpyoData("100000006", 12);
        skDenpyoData24.setDenyenkagk(BizCurrency.valueOf(17,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData24);

        HT_SkDenpyoData skDenpyoData25 = new HT_SkDenpyoData("100000006", 13);
        skDenpyoData25.setDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

        sinkeiyakuDomManager.insert(skDenpyoData25);

        HT_SkDenpyoData skDenpyoData26 = new HT_SkDenpyoData("100000006", 14);

        sinkeiyakuDomManager.insert(skDenpyoData26);

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

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(
            "791112238", C_Tuukasyu.BLNK, BizDate.valueOf(20160819));
        Assert.assertEquals(0, bizCurrencyLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(
            "791112220", C_Tuukasyu.JPY, BizDate.valueOf(20160819));
        Assert.assertEquals(1, bizCurrencyLst.size());
        Assert.assertEquals(BizCurrency.valueOf(12, BizCurrencyTypes.YEN), bizCurrencyLst.get(0));

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(
            "791112246", C_Tuukasyu.JPY, BizDate.valueOf(20090919));

        Assert.assertEquals(6, bizCurrencyLst.size());
        Assert.assertEquals(BizCurrency.valueOf(18, BizCurrencyTypes.AU_DOLLAR), bizCurrencyLst.get(0));
        Assert.assertEquals(BizCurrency.valueOf(14.5, BizCurrencyTypes.DOLLAR), bizCurrencyLst.get(1));
        Assert.assertEquals(BizCurrency.valueOf(16, BizCurrencyTypes.EURO), bizCurrencyLst.get(2));
        Assert.assertEquals(BizCurrency.valueOf(13, BizCurrencyTypes.MANYEN), bizCurrencyLst.get(3));
        Assert.assertEquals(BizCurrency.valueOf(17, BizCurrencyTypes.YEN), bizCurrencyLst.get(4));
        Assert.assertEquals(null, bizCurrencyLst.get(5));

    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        List<BizCurrency> bizCurrencyLst = sinkeiyakuDomManager.getSkDenpyoDataSumDenyenkagkByNyksyoriymd(
            "", C_Tuukasyu.JPY, BizDate.valueOf(20160819));
        Assert.assertEquals(0, bizCurrencyLst.size());
    }
}

