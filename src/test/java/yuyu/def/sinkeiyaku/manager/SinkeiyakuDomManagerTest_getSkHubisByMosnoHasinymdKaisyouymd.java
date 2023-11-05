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
 * getSkHubisByMosnoHasinymdKaisyouymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHubisByMosnoHasinymdKaisyouymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoHasinymdKaisyouymd("1001",BizDate.valueOf("20160202"),BizDate.valueOf("20160205"));

        Assert.assertEquals(0,skHubiLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("1001");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("A100");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(123);
        skHubiDetail1.setHasinymd(BizDate.valueOf(20160202));
        skHubiDetail1.setKaisyouymd(BizDate.valueOf(20160205));

        HT_SkHubi skHubi3 = syoriCTL1.createSkHubi();
        skHubi3.setHubisikibetukey("A101");

        HT_SkHubiDetail skHubiDetail3 = skHubi3.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(123);
        skHubiDetail3.setHasinymd(BizDate.valueOf(20160203));
        skHubiDetail3.setKaisyouymd(BizDate.valueOf(20160205));

        HT_SkHubi skHubi4 = syoriCTL1.createSkHubi();
        skHubi4.setHubisikibetukey("A102");

        HT_SkHubiDetail skHubiDetail4 = skHubi4.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(123);
        skHubiDetail4.setHasinymd(BizDate.valueOf(20160202));
        skHubiDetail4.setKaisyouymd(BizDate.valueOf(20160206));

        HT_SkHubi skHubi5 = syoriCTL1.createSkHubi();
        skHubi5.setHubisikibetukey("A104");

        HT_SkHubiDetail skHubiDetail5 = skHubi5.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(123);
        skHubiDetail5.setHasinymd(BizDate.valueOf(20160201));
        skHubiDetail5.setKaisyouymd(BizDate.valueOf(20160205));

        HT_SkHubi skHubi6 = syoriCTL1.createSkHubi();
        skHubi6.setHubisikibetukey("A105");

        HT_SkHubiDetail skHubiDetail6 = skHubi6.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(123);
        skHubiDetail6.setHasinymd(BizDate.valueOf(20160201));
        skHubiDetail6.setKaisyouymd(BizDate.valueOf(20160205));

        HT_SkHubi skHubi7 = syoriCTL1.createSkHubi();
        skHubi7.setHubisikibetukey("A103");

        HT_SkHubiDetail skHubiDetail7 = skHubi7.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(123);
        skHubiDetail7.setHasinymd(BizDate.valueOf(20160201));
        skHubiDetail7.setKaisyouymd(BizDate.valueOf(20160205));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("1002");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("A100");

        HT_SkHubiDetail skHubiDetail2 = skHubi2.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(123);
        skHubiDetail2.setHasinymd(BizDate.valueOf(20160202));
        skHubiDetail2.setKaisyouymd(BizDate.valueOf(20160205));

        sinkeiyakuDomManager.insert(syoriCTL2);
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

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoHasinymdKaisyouymd("1001",BizDate.valueOf("20160102"),BizDate.valueOf("20160205"));

        Assert.assertEquals(0,skHubiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoHasinymdKaisyouymd("1001",BizDate.valueOf("20160202"),BizDate.valueOf("20160205"));

        Assert.assertEquals(1,skHubiLst.size());

        Assert.assertEquals("1001", skHubiLst.get(0).getMosno());
        Assert.assertEquals("A100", skHubiLst.get(0).getHubisikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoHasinymdKaisyouymd("1001",BizDate.valueOf("20160201"),BizDate.valueOf("20160205"));

        Assert.assertEquals(3,skHubiLst.size());

        Assert.assertEquals("1001", skHubiLst.get(0).getMosno());
        Assert.assertEquals("A103", skHubiLst.get(0).getHubisikibetukey());

        Assert.assertEquals("1001", skHubiLst.get(1).getMosno());
        Assert.assertEquals("A104", skHubiLst.get(1).getHubisikibetukey());

        Assert.assertEquals("1001", skHubiLst.get(2).getMosno());
        Assert.assertEquals("A105", skHubiLst.get(2).getHubisikibetukey());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoHasinymdKaisyouymd("",BizDate.valueOf("20160202"),BizDate.valueOf("20160205"));

        Assert.assertEquals(0,skHubiLst.size());

    }
}