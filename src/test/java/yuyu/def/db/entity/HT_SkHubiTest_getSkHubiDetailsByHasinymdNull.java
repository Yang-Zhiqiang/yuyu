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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約不備詳細テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SkHubiTest_getSkHubiDetailsByHasinymdNull {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");

        if (syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("791112220");

            HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
            skHubi1.setHubisikibetukey("201520161001");

            List<HT_SkHubiDetail> skHubiDetailLst = skHubi1.getSkHubiDetailsByHasinymdNull();

            Assert.assertEquals(0, skHubiDetailLst.size());

            HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
            skHubiDetail1.setRenno3keta(1);

            HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
            skHubiDetail2.setRenno3keta(2);
            skHubiDetail2.setHasinymd(BizDate.valueOf(20160315));

            HT_SkHubi skHubi2 = syoriCTL1.createSkHubi();
            skHubi2.setHubisikibetukey("201520161002");

            HT_SkHubiDetail skHubiDetail3 = skHubi2.createSkHubiDetail();
            skHubiDetail3.setRenno3keta(3);
            skHubiDetail3.setHasinymd(BizDate.valueOf(20160315));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi3 = syoriCTL2.createSkHubi();
        skHubi3.setHubisikibetukey("201520161001");

        HT_SkHubiDetail skHubiDetail4 = skHubi3.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(1);

        HT_SkHubiDetail skHubiDetail5 = skHubi3.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(2);

        HT_SkHubiDetail skHubiDetail6 = skHubi3.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(3);

        sinkeiyakuDomManager.insert(syoriCTL2);
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

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_SkHubiDetail> skHubiDetailLst = syoriCtl.getSkHubiByHubisikibetukey("201520161002").getSkHubiDetailsByHasinymdNull();

        Assert.assertEquals(0, skHubiDetailLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_SkHubiDetail> skHubiDetailLst = syoriCtl.getSkHubiByHubisikibetukey("201520161001").getSkHubiDetailsByHasinymdNull();

        Assert.assertEquals(1, skHubiDetailLst.size());


        Assert.assertEquals("791112220", skHubiDetailLst.get(0).getMosno());
        Assert.assertEquals("201520161001", skHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(1, skHubiDetailLst.get(0).getRenno3keta().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_SkHubiDetail> skHubiDetailLst = syoriCtl.getSkHubiByHubisikibetukey("201520161001").getSkHubiDetailsByHasinymdNull();
        Assert.assertEquals(3, skHubiDetailLst.size());

        Assert.assertEquals("791112238", skHubiDetailLst.get(0).getMosno());
        Assert.assertEquals("201520161001", skHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(1, skHubiDetailLst.get(0).getRenno3keta().intValue());

        Assert.assertEquals("791112238", skHubiDetailLst.get(1).getMosno());
        Assert.assertEquals("201520161001", skHubiDetailLst.get(1).getHubisikibetukey());
        Assert.assertEquals(2, skHubiDetailLst.get(1).getRenno3keta().intValue());

        Assert.assertEquals("791112238", skHubiDetailLst.get(2).getMosno());
        Assert.assertEquals("201520161001", skHubiDetailLst.get(2).getHubisikibetukey());
        Assert.assertEquals(3, skHubiDetailLst.get(2).getRenno3keta().intValue());

    }
}

