package yuyu.def.db.entity;

import java.util.List;

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
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinsByHnkntuukasyuHnknsyoriymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000002");
            List<HT_Henkin> henkinList = syoriCtl1.getHenkinsByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.AUD, null);
            Assert.assertEquals(0, henkinList.size());

            HT_Henkin henkin1 = syoriCtl1.createHenkin();
            henkin1.setRenno(13);
            henkin1.setHnkntuukasyu(C_Tuukasyu.AUD);
            henkin1.setHnknsyoriymd(null);

            HT_Henkin henkin2 = syoriCtl1.createHenkin();
            henkin2.setRenno(14);
            henkin2.setHnkntuukasyu(C_Tuukasyu.AUD);
            henkin2.setHnknsyoriymd(null);


            HT_Henkin henkin3 = syoriCtl1.createHenkin();
            henkin3.setRenno(15);
            henkin3.setHnkntuukasyu(C_Tuukasyu.AUD);
            henkin3.setHnknsyoriymd(null);

            HT_Henkin henkin7 = syoriCtl1.createHenkin();
            henkin7.setRenno(16);
            henkin7.setHnkntuukasyu(C_Tuukasyu.AUD);
            henkin7.setHnknsyoriymd(BizDate.valueOf("20160119"));

            HT_Henkin henkin6 = syoriCtl1.createHenkin();
            henkin6.setRenno(17);
            henkin6.setHnkntuukasyu(C_Tuukasyu.JPY);
            henkin6.setHnknsyoriymd(null);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000001");


            HT_Henkin henkin4 = syoriCtl2.createHenkin();
            henkin4.setRenno(11);
            henkin4.setHnkntuukasyu(C_Tuukasyu.EUR);
            henkin4.setHnknsyoriymd(null);

            HT_Henkin henkin5 = syoriCtl2.createHenkin();
            henkin5.setRenno(12);
            henkin5.setHnkntuukasyu(C_Tuukasyu.EUR);
            henkin5.setHnknsyoriymd(BizDate.valueOf("20160119"));

            HT_Henkin henkin7 = syoriCtl2.createHenkin();
            henkin7.setRenno(18);
            henkin7.setHnkntuukasyu(C_Tuukasyu.AUD);
            henkin7.setHnknsyoriymd(null);

            sinkeiyakuDomManager.insert(syoriCtl2);
        }
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
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.JPY, null);

        Assert.assertEquals(0, henkinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.EUR, BizDate.valueOf("20160119"));

        Assert.assertEquals(1, henkinList.size());

        Assert.assertEquals("10000000001", henkinList.get(0).getMosno());
        Assert.assertEquals(12, henkinList.get(0).getRenno().intValue());
        Assert.assertEquals(C_Tuukasyu.EUR, henkinList.get(0).getHnkntuukasyu());
        Assert.assertEquals(BizDate.valueOf("20160119"), henkinList.get(0).getHnknsyoriymd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000002");

        List<HT_Henkin> henkinList = syoriCtl.getHenkinsByHnkntuukasyuHnknsyoriymd(C_Tuukasyu.AUD, null);

        Assert.assertEquals(3, henkinList.size());

        Assert.assertEquals("10000000002", henkinList.get(0).getMosno());
        Assert.assertEquals(13, henkinList.get(0).getRenno().intValue());
        Assert.assertEquals(C_Tuukasyu.AUD, henkinList.get(0).getHnkntuukasyu());
        Assert.assertEquals(null, henkinList.get(0).getHnknsyoriymd());

        Assert.assertEquals("10000000002", henkinList.get(1).getMosno());
        Assert.assertEquals(14, henkinList.get(1).getRenno().intValue());
        Assert.assertEquals(C_Tuukasyu.AUD, henkinList.get(1).getHnkntuukasyu());
        Assert.assertEquals(null, henkinList.get(1).getHnknsyoriymd());

        Assert.assertEquals("10000000002", henkinList.get(2).getMosno());
        Assert.assertEquals(15, henkinList.get(2).getRenno().intValue());
        Assert.assertEquals(C_Tuukasyu.AUD, henkinList.get(2).getHnkntuukasyu());
        Assert.assertEquals(null, henkinList.get(2).getHnknsyoriymd());

    }
}


