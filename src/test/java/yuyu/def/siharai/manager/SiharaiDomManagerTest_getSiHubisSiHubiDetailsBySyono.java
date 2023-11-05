package yuyu.def.siharai.manager;

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

import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.siharai.result.bean.SiHubisSiHubiDetailsBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備情報Beanのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiHubisSiHubiDetailsBySyono {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<SiHubisSiHubiDetailsBySyonoBean> hubiBeanLst = siharaiDomManager.getSiHubisSiHubiDetailsBySyono("11807111130");
        Assert.assertEquals(0, hubiBeanLst.size());

        JT_SiHubi siHubi1 = siharaiDomManager.getSiHubi("110");

        if (siHubi1 == null) {

            siHubi1 = new JT_SiHubi("110");
            siHubi1.setSyono("11807111130");

            JT_SiHubiDetail siHubiDetail3 = siHubi1.createSiHubiDetail();
            siHubiDetail3.setRenno3keta(1);
            siHubiDetail3.setTrkymd(BizDate.valueOf(20150103));

            JT_SiHubiDetail siHubiDetail4 = siHubi1.createSiHubiDetail();
            siHubiDetail4.setRenno3keta(3);
            siHubiDetail4.setTrkymd(BizDate.valueOf(20150101));

            JT_SiHubiDetail siHubiDetail5 = siHubi1.createSiHubiDetail();
            siHubiDetail5.setRenno3keta(2);
            siHubiDetail5.setTrkymd(BizDate.valueOf(20150102));

            siharaiDomManager.insert(siHubi1);
        }

        JT_SiHubi siHubi2 = siharaiDomManager.getSiHubi("108");

        if (siHubi2 == null) {

            siHubi2 = new JT_SiHubi("108");
            siHubi2.setSyono("11807111130");

            JT_SiHubiDetail siHubiDetail1 = siHubi2.createSiHubiDetail();
            siHubiDetail1.setRenno3keta(4);
            siHubiDetail1.setTrkymd(BizDate.valueOf(20150104));

            siharaiDomManager.insert(siHubi2);
        }

        JT_SiHubi siHubi3 = siharaiDomManager.getSiHubi("109");

        if (siHubi3 == null) {

            siHubi3 = new JT_SiHubi("109");
            siHubi3.setSyono("11807111130");

            JT_SiHubiDetail siHubiDetail2 = siHubi3.createSiHubiDetail();
            siHubiDetail2.setRenno3keta(5);
            siHubiDetail2.setTrkymd(BizDate.valueOf(20150104));

            siharaiDomManager.insert(siHubi3);
        }

        JT_SiHubi siHubi4 = siharaiDomManager.getSiHubi("105");

        if (siHubi4 == null) {

            siHubi4 = new JT_SiHubi("105");
            siHubi4.setSyono("11807111118");

            JT_SiHubiDetail siHubiDetail6 = siHubi4.createSiHubiDetail();
            siHubiDetail6.setRenno3keta(6);
            siHubiDetail6.setTrkymd(BizDate.valueOf(20150120));

            siharaiDomManager.insert(siHubi4);
        }

        JT_SiHubi siHubi5 = siharaiDomManager.getSiHubi("106");

        if (siHubi5 == null) {

            siHubi5 = new JT_SiHubi("106");
            siHubi5.setSyono("11807111129");

            JT_SiHubiDetail siHubiDetail7 = siHubi5.createSiHubiDetail();
            siHubiDetail7.setRenno3keta(7);
            siHubiDetail7.setTrkymd(BizDate.valueOf(20150121));

            siharaiDomManager.insert(siHubi5);
        }


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

        List<SiHubisSiHubiDetailsBySyonoBean> hubiBeanLst = siharaiDomManager.getSiHubisSiHubiDetailsBySyono("11807111141");
        Assert.assertEquals(0, hubiBeanLst.size());
    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<SiHubisSiHubiDetailsBySyonoBean> hubiBeanLst = siharaiDomManager.getSiHubisSiHubiDetailsBySyono("11807111130");
        Assert.assertEquals(5, hubiBeanLst.size());

        Assert.assertEquals("110", hubiBeanLst.get(0).getJT_SiHubi().getHubisikibetukey());
        Assert.assertEquals(3, hubiBeanLst.get(0).getJT_SiHubiDetail().getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150101), hubiBeanLst.get(0).getJT_SiHubiDetail().getTrkymd());

        Assert.assertEquals("110", hubiBeanLst.get(1).getJT_SiHubi().getHubisikibetukey());
        Assert.assertEquals(2, hubiBeanLst.get(1).getJT_SiHubiDetail().getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150102), hubiBeanLst.get(1).getJT_SiHubiDetail().getTrkymd());

        Assert.assertEquals("110", hubiBeanLst.get(2).getJT_SiHubi().getHubisikibetukey());
        Assert.assertEquals(1, hubiBeanLst.get(2).getJT_SiHubiDetail().getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150103), hubiBeanLst.get(2).getJT_SiHubiDetail().getTrkymd());

        Assert.assertEquals("108", hubiBeanLst.get(3).getJT_SiHubi().getHubisikibetukey());
        Assert.assertEquals(4, hubiBeanLst.get(3).getJT_SiHubiDetail().getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150104), hubiBeanLst.get(3).getJT_SiHubiDetail().getTrkymd());

        Assert.assertEquals("109", hubiBeanLst.get(4).getJT_SiHubi().getHubisikibetukey());
        Assert.assertEquals(5, hubiBeanLst.get(4).getJT_SiHubiDetail().getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150104), hubiBeanLst.get(4).getJT_SiHubiDetail().getTrkymd());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        List<SiHubisSiHubiDetailsBySyonoBean> hubiBeanLst = siharaiDomManager.getSiHubisSiHubiDetailsBySyono("11807111118");
        Assert.assertEquals(1, hubiBeanLst.size());

        Assert.assertEquals("105", hubiBeanLst.get(0).getJT_SiHubi().getHubisikibetukey());
        Assert.assertEquals(6, hubiBeanLst.get(0).getJT_SiHubiDetail().getRenno3keta().intValue());
        Assert.assertEquals(BizDate.valueOf(20150120), hubiBeanLst.get(0).getJT_SiHubiDetail().getTrkymd());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<SiHubisSiHubiDetailsBySyonoBean> hubiBeanLst = siharaiDomManager.getSiHubisSiHubiDetailsBySyono("");
        Assert.assertEquals(0, hubiBeanLst.size());
    }


}

