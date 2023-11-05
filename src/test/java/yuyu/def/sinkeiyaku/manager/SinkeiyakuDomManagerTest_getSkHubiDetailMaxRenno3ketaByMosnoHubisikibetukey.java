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
 * getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Integer max = sinkeiyakuDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey("791112220","201520161001");
        Assert.assertEquals(null, max);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("201520161001");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(111);
        skHubiDetail1.setHasinymd(BizDate.valueOf(20160115));

        HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(112);
        skHubiDetail2.setHasinymd(BizDate.valueOf(20160115));

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(117);

        HT_SkHubiDetail skHubiDetail4 = skHubi1.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(114);
        skHubiDetail4.setHasinymd(BizDate.valueOf(20160115));

        HT_SkHubi skHubi3 = syoriCTL1.createSkHubi();
        skHubi3.setHubisikibetukey("201520161002");

        HT_SkHubiDetail skHubiDetail5 = skHubi3.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(115);
        skHubiDetail5.setHasinymd(BizDate.valueOf(20160115));

        HT_SkHubi skHubi4 = syoriCTL1.createSkHubi();
        skHubi4.setHubisikibetukey("201520161003");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("201520161001");

        HT_SkHubiDetail skHubiDetail6 = skHubi2.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(111);
        skHubiDetail6.setHasinymd(BizDate.valueOf(20160115));

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
        Integer max = sinkeiyakuDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey("791112220","201520161003");
        Assert.assertEquals(null, max);

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        Integer max = sinkeiyakuDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey("791112220","201520161001");
        Assert.assertEquals(Integer.valueOf(114), max);

    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {
        Integer max = sinkeiyakuDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey("","201520161001");
        Assert.assertEquals(null, max);
    }

    @Test
    @TestOrder(40)
    public void blankCondition2() {
        Integer max = sinkeiyakuDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey("791112220","");
        Assert.assertEquals(null, max);
    }
}
