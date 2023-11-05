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
 * 新契約不備詳細テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubiDetailCountByMosnoKaisyouymd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoKaisyouymd("791112220");
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("11112020");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(112);

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(113);
        skHubiDetail3.setKaisyouymd(BizDate.valueOf(20140404));

        HT_SkHubi skHubi3 = syoriCTL1.createSkHubi();
        skHubi3.setHubisikibetukey("33112020");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112279");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("11112020");

        HT_SkHubiDetail skHubiDetail2 = skHubi2.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(112);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112295");

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

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoKaisyouymd("791112295");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoKaisyouymd("791112220");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        Long count = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoKaisyouymd("");
        Assert.assertEquals(new Long(0), count);

    }

}
