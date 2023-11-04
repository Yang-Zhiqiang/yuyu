package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubisByMosnoKaisyouymdHasinymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubisByMosnoKaisyouymdHasinymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd("791112220");

        Assert.assertEquals(0,skHubiLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("1000");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(100);
        skHubiDetail1.setHasinymd(BizDate.valueOf(20160310));

        HT_SkHubiDetail skHubiDetail2 = skHubi1.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(101);
        skHubiDetail2.setHasinymd(BizDate.valueOf(20160310));

        HT_SkHubiDetail skHubiDetail3 = skHubi1.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(102);
        skHubiDetail3.setHasinymd(BizDate.valueOf(20160310));

        HT_SkHubiDetail skHubiDetail4 = skHubi1.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(103);
        skHubiDetail4.setHasinymd(BizDate.valueOf(20160310));
        skHubiDetail4.setKaisyouymd(BizDate.valueOf(20160311));

        HT_SkHubiDetail skHubiDetail5 = skHubi1.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(104);

        HT_SkHubi skHubi3 = syoriCTL1.createSkHubi();
        skHubi3.setHubisikibetukey("2000");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("1000");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112253");

        HT_SkHubi skHubi4 = syoriCTL3.createSkHubi();
        skHubi4.setHubisikibetukey("1500");

        HT_SkHubiDetail skHubiDetail6 = skHubi4.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(100);
        skHubiDetail6.setHasinymd(BizDate.valueOf(20160310));

        HT_SkHubi skHubi5 = syoriCTL3.createSkHubi();
        skHubi5.setHubisikibetukey("1400");

        HT_SkHubiDetail skHubiDetail7 = skHubi5.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(100);
        skHubiDetail7.setHasinymd(BizDate.valueOf(20160309));

        HT_SkHubi skHubi6 = syoriCTL3.createSkHubi();
        skHubi6.setHubisikibetukey("1300");

        HT_SkHubiDetail skHubiDetail8 = skHubi6.createSkHubiDetail();
        skHubiDetail8.setRenno3keta(100);
        skHubiDetail8.setHasinymd(BizDate.valueOf(20160311));

        sinkeiyakuDomManager.insert(syoriCTL3);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager SinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        SinkeiyakuDomManager.delete(SinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd("791112261");

        Assert.assertEquals(0,skHubiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd("791112220");

        Assert.assertEquals(1,skHubiLst.size());

        Assert.assertEquals("791112220", skHubiLst.get(0).getMosno());
        Assert.assertEquals("1000", skHubiLst.get(0).getHubisikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd("791112253");

        Assert.assertEquals(3,skHubiLst.size());

        Assert.assertEquals("791112253", skHubiLst.get(0).getMosno());
        Assert.assertEquals("1300", skHubiLst.get(0).getHubisikibetukey());

        Assert.assertEquals("791112253", skHubiLst.get(1).getMosno());
        Assert.assertEquals("1400", skHubiLst.get(1).getHubisikibetukey());

        Assert.assertEquals("791112253", skHubiLst.get(2).getMosno());
        Assert.assertEquals("1500", skHubiLst.get(2).getHubisikibetukey());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd("");

        Assert.assertEquals(0,skHubiLst.size());

    }
}