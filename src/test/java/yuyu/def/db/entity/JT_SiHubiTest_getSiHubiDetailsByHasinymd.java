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

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払不備テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SiHubiTest_getSiHubiDetailsByHasinymd {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SiHubi siHubi1 = siharaiDomManager.getSiHubi("11011101");
        if (siHubi1 == null) {
            siHubi1 = new JT_SiHubi("11011101");

            List<JT_SiHubiDetail> siHubiDetailLst = siHubi1.getSiHubiDetailsByHasinymd();
            Assert.assertEquals(0, siHubiDetailLst.size());

            JT_SiHubiDetail siHubiDetail1 = siHubi1.createSiHubiDetail();
            siHubiDetail1.setRenno3keta(123);
            siHubiDetail1.setHasinymd(BizDate.valueOf(20160205));

            JT_SiHubiDetail siHubiDetail2 = siHubi1.createSiHubiDetail();
            siHubiDetail2.setRenno3keta(111);

            siharaiDomManager.insert(siHubi1);
        }

        JT_SiHubi siHubi2 = new JT_SiHubi("21010120");

        JT_SiHubiDetail siHubiDetail3 = siHubi2.createSiHubiDetail();
        siHubiDetail3.setRenno3keta(414);
        siHubiDetail3.setHasinymd(BizDate.valueOf(20150607));

        JT_SiHubiDetail siHubiDetail4 = siHubi2.createSiHubiDetail();
        siHubiDetail4.setRenno3keta(415);
        siHubiDetail4.setHasinymd(BizDate.valueOf(20150608));

        JT_SiHubiDetail siHubiDetail5 = siHubi2.createSiHubiDetail();
        siHubiDetail5.setRenno3keta(416);
        siHubiDetail5.setHasinymd(BizDate.valueOf(20150609));

        siharaiDomManager.insert(siHubi2);

        JT_SiHubi siHubi3 = new JT_SiHubi("33013301");

        siharaiDomManager.insert(siHubi3);


    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiHubi());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        JT_SiHubi siHubi1 = siharaiDomManager.getSiHubi("33013301");
        List<JT_SiHubiDetail> siHubiDetailLst = siHubi1.getSiHubiDetailsByHasinymd();
        Assert.assertEquals(0, siHubiDetailLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SiHubi siHubi1 = siharaiDomManager.getSiHubi("11011101");
        List<JT_SiHubiDetail> siHubiDetailLst = siHubi1.getSiHubiDetailsByHasinymd();
        Assert.assertEquals(1, siHubiDetailLst.size());

        Assert.assertEquals("11011101", siHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(123, siHubiDetailLst.get(0).getRenno3keta().intValue());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        JT_SiHubi siHubi1 = siharaiDomManager.getSiHubi("21010120");
        List<JT_SiHubiDetail> siHubiDetailLst = siHubi1.getSiHubiDetailsByHasinymd();
        Assert.assertEquals(3, siHubiDetailLst.size());

        Assert.assertEquals("21010120", siHubiDetailLst.get(0).getHubisikibetukey());
        Assert.assertEquals(414, siHubiDetailLst.get(0).getRenno3keta().intValue());

        Assert.assertEquals("21010120", siHubiDetailLst.get(1).getHubisikibetukey());
        Assert.assertEquals(415, siHubiDetailLst.get(1).getRenno3keta().intValue());

        Assert.assertEquals("21010120", siHubiDetailLst.get(2).getHubisikibetukey());
        Assert.assertEquals(416, siHubiDetailLst.get(2).getRenno3keta().intValue());
    }

}
