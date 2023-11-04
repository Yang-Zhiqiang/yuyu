package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

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
 * getSkDenpyoDataMinDenymdByMosnoRstuukasyu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDataMinDenymdByMosnoRstuukasyu {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        BizDate denymdMin = sinkeiyakuDomManager.getSkDenpyoDataMinDenymdByMosnoRstuukasyu("791112220", C_Tuukasyu.JPY);

        Assert.assertEquals(null,denymdMin);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(01);
        nyuukin1.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin1.setDenrenno("0001");
        nyuukin1.setEdano(11);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(02);
        nyuukin2.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin2.setDenrenno("0002");
        nyuukin2.setEdano(22);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(03);
        nyuukin3.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin3.setDenrenno("0003");
        nyuukin3.setEdano(33);

        HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
        nyuukin5.setRenno(05);
        nyuukin5.setRstuukasyu(C_Tuukasyu.valueOf("USD"));
        nyuukin5.setDenrenno("0005");
        nyuukin5.setEdano(55);

        HT_Nyuukin nyuukin6 = syoriCTL1.createNyuukin();
        nyuukin6.setRenno(06);
        nyuukin6.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin6.setDenrenno("0006");
        nyuukin6.setEdano(66);

        HT_Nyuukin nyuukin7 = syoriCTL1.createNyuukin();
        nyuukin7.setRenno(07);
        nyuukin7.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin7.setDenrenno("0007");
        nyuukin7.setEdano(77);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Nyuukin nyuukin4 = syoriCTL2.createNyuukin();
        nyuukin4.setRenno(04);
        nyuukin4.setRstuukasyu(C_Tuukasyu.valueOf("JPY"));
        nyuukin4.setDenrenno("0004");
        nyuukin4.setEdano(44);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData("0001", 11);
        skDenpyoData1.setDenymd(BizDate.valueOf(20160513));

        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData("0002", 22);
        skDenpyoData2.setDenymd(BizDate.valueOf(20160413));

        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData("0003", 33);
        skDenpyoData3.setDenymd(BizDate.valueOf(20160313));

        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData4 = new HT_SkDenpyoData("0004", 44);
        skDenpyoData4.setDenymd(BizDate.valueOf(20160213));

        sinkeiyakuDomManager.insert(skDenpyoData4);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData("0005", 55);
        skDenpyoData5.setDenymd(BizDate.valueOf(20160113));

        sinkeiyakuDomManager.insert(skDenpyoData5);

        HT_SkDenpyoData skDenpyoData6 = new HT_SkDenpyoData("0016", 66);
        skDenpyoData6.setDenymd(BizDate.valueOf(20150113));

        sinkeiyakuDomManager.insert(skDenpyoData6);

        HT_SkDenpyoData skDenpyoData7 = new HT_SkDenpyoData("0007", 07);
        skDenpyoData7.setDenymd(BizDate.valueOf(20140113));

        sinkeiyakuDomManager.insert(skDenpyoData7);

    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        BizDate denymdMin = sinkeiyakuDomManager.getSkDenpyoDataMinDenymdByMosnoRstuukasyu("791112246", C_Tuukasyu.JPY);
        Assert.assertEquals(null,denymdMin);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        BizDate denymdMin = sinkeiyakuDomManager.getSkDenpyoDataMinDenymdByMosnoRstuukasyu("791112220", C_Tuukasyu.JPY);
        Assert.assertEquals(BizDate.valueOf("20160313"),denymdMin);

    }

    @Test
    @TestOrder(30)
    public void blank() {

        BizDate denymdMin = sinkeiyakuDomManager.getSkDenpyoDataMinDenymdByMosnoRstuukasyu("", C_Tuukasyu.JPY);
        Assert.assertEquals(null,denymdMin);
    }
}

