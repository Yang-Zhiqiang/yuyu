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

import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubiDetailCountByMosnoTrkymdHasinymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailCountByMosnoTrkymdHasinymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymd("791112220");
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("201520161001");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setTrkymd(BizDate.valueOf(20160215));

        HT_SkHubiDetail skHubiDetail5 = skHubi1.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(114);
        skHubiDetail5.setTrkymd(BizDate.valueOf(20160215));

        HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(112);

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(113);
        skHubiDetail3.setTrkymd(BizDate.valueOf(20160215));
        skHubiDetail3.setHasinymd(BizDate.valueOf(20160215));

        HT_SkHubi skHubi4 = syoriCTL1.createSkHubi();
        skHubi4.setHubisikibetukey("201520161002");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("201520161001");

        HT_SkHubiDetail skHubiDetail4 = skHubi2.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(111);
        skHubiDetail4.setTrkymd(BizDate.valueOf(20160215));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_SkHubi skHubi3 = syoriCTL3.createSkHubi();
        skHubi3.setHubisikibetukey("201520161001");

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
        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymd("791112246");
        Assert.assertEquals(new Long(0), count);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymd("791112220");
        Assert.assertEquals(new Long(2), count);

    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {
        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymd("");
        Assert.assertEquals(new Long(0), count);
    }
}

