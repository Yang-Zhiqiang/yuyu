package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 新契約不備詳細テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SkHubiTest_getSkHubiDetailsByHasinymdKaisyouymd {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getAllSyoriCTL();
        if (syoriCTLLst.size() == 0) {
            HT_SyoriCTL syoriCtl = new HT_SyoriCTL("10000000001");

            HT_SkHubi skHubi = syoriCtl.createSkHubi();
            skHubi.setHubisikibetukey("20150101");

            List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetailsByHasinymdKaisyouymd();

            Assert.assertEquals(0, skHubiDetailLst.size());

            HT_SkHubiDetail skHubiDetail = skHubi.createSkHubiDetail();
            skHubiDetail.setRenno3keta(1);
            skHubiDetail.setKaisyouymd(BizDate.valueOf("20150201"));

            HT_SkHubiDetail skHubiDetail2 = skHubi.createSkHubiDetail();
            skHubiDetail2.setRenno3keta(2);
            skHubiDetail2.setHasinymd(BizDate.valueOf("20150301"));

            HT_SkHubiDetail skHubiDetail3 = skHubi.createSkHubiDetail();
            skHubiDetail3.setRenno3keta(3);
            skHubiDetail3.setHasinymd(BizDate.valueOf("20150301"));
            skHubiDetail3.setKaisyouymd(BizDate.valueOf("20150401"));

            HT_SkHubiDetail skHubiDetail4 = skHubi.createSkHubiDetail();
            skHubiDetail4.setRenno3keta(4);
            skHubiDetail4.setHasinymd(BizDate.valueOf("20150301"));

            sinkeiyakuDomManager.insert(syoriCtl);

            HT_SyoriCTL syoriCtl2 = new HT_SyoriCTL("10000000002");

            HT_SkHubi skHubi2 = syoriCtl2.createSkHubi();
            skHubi2.setHubisikibetukey("20150101");

            HT_SkHubiDetail skHubiDetail5 = skHubi2.createSkHubiDetail();
            skHubiDetail5.setRenno3keta(1);
            skHubiDetail5.setHasinymd(BizDate.valueOf("20150301"));

            sinkeiyakuDomManager.insert(syoriCtl2);

            HT_SyoriCTL syoriCtl3 = new HT_SyoriCTL("10000000003");

            HT_SkHubi skHubi3 = syoriCtl3.createSkHubi();
            skHubi3.setHubisikibetukey("20150101");

            HT_SkHubiDetail skHubiDetail6 = skHubi3.createSkHubiDetail();
            skHubiDetail6.setRenno3keta(1);
            skHubiDetail6.setHasinymd(BizDate.valueOf("20150301"));
            skHubiDetail6.setKaisyouymd(BizDate.valueOf("20150401"));

            sinkeiyakuDomManager.insert(syoriCtl3);

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


        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        List<HT_SkHubiDetail> skHubiDetailLst = syoriCtl.getSkHubis().get(0).getSkHubiDetailsByHasinymdKaisyouymd();

        Assert.assertEquals(0, skHubiDetailLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        List<HT_SkHubiDetail> skHubiDetailLst = syoriCtl.getSkHubis().get(0).getSkHubiDetailsByHasinymdKaisyouymd();

        Assert.assertEquals(1, skHubiDetailLst.size());
        Assert.assertEquals("10000000002", skHubiDetailLst.get(0).getMosno());
        Assert.assertEquals("20150101", skHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(1), skHubiDetailLst.get(0).getRenno3keta());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_SkHubiDetail> skHubiDetailLst = syoriCtl.getSkHubis().get(0).getSkHubiDetailsByHasinymdKaisyouymd();

        Assert.assertEquals(3, skHubiDetailLst.size());
        Assert.assertEquals("10000000001", skHubiDetailLst.get(0).getMosno());
        Assert.assertEquals("20150101", skHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(1), skHubiDetailLst.get(0).getRenno3keta());

        Assert.assertEquals("10000000001", skHubiDetailLst.get(1).getMosno());
        Assert.assertEquals("20150101", skHubiDetailLst.get(1).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(2), skHubiDetailLst.get(1).getRenno3keta());

        Assert.assertEquals("10000000001", skHubiDetailLst.get(2).getMosno());
        Assert.assertEquals("20150101", skHubiDetailLst.get(2).getHubisikibetukey());
        Assert.assertEquals(Integer.valueOf(4), skHubiDetailLst.get(2).getRenno3keta());

    }
}
