package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_SkHubiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno1 = "MOSNO000001";
        String pMosno2 = "MOSNO000002";
        String pHubisikibetukey1 = "HBKEY000001";
        String pHubisikibetukey2 = "HBKEY000002";

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        HT_SkHubi hT_SkHubi1 = hT_SyoriCTL1.createSkHubi();
        hT_SkHubi1.setHubisikibetukey(pHubisikibetukey2);
        HT_SkHubiDetail hT_SkHubiDetail1 = hT_SkHubi1.createSkHubiDetail();
        hT_SkHubiDetail1.setRenno3keta(2);
        HT_SkHubiDetail hT_SkHubiDetail2 = hT_SkHubi1.createSkHubiDetail();
        hT_SkHubiDetail2.setRenno3keta(1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);
        HT_SkHubi hT_SkHubi2 = hT_SyoriCTL2.createSkHubi();
        hT_SkHubi2.setHubisikibetukey(pHubisikibetukey1);
        HT_SkHubiDetail hT_SkHubiDetail3 = hT_SkHubi2.createSkHubiDetail();
        hT_SkHubiDetail3.setRenno3keta(3);
        HT_SkHubiDetail hT_SkHubiDetail4 = hT_SkHubi2.createSkHubiDetail();
        hT_SkHubiDetail4.setRenno3keta(4);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getSkHubiDetails() {

        String pMosno1 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_SkHubi> hT_SkHubis =  hT_SyoriCTL.getSkHubis();

        List<HT_SkHubiDetail> hT_SkHubiDetails1 = hT_SkHubis.get(0).getSkHubiDetails();

        Assert.assertEquals(Integer.valueOf(1),hT_SkHubiDetails1.get(0).getRenno3keta());
        Assert.assertEquals(Integer.valueOf(2),hT_SkHubiDetails1.get(1).getRenno3keta());

        Assert.assertEquals(2, hT_SkHubiDetails1.size());

    }

    @Test
    @TestOrder(70)
    public void getSyoriCTL() {

        String pMosno1 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_SkHubi> hT_SkHubis =  hT_SyoriCTL.getSkHubis();

        Assert.assertEquals(sinkeiyakuDomManager.getSyoriCTL(pMosno1),hT_SkHubis.get(0).getSyoriCTL());

    }
}
