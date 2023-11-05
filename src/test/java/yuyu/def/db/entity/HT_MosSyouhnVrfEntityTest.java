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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_MosSyouhnVrfEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pSyouhncd1 = "SH01";
        Integer pSyouhnsdno1 = 11;
        BM_SyouhnZokusei bM_SyouhnZokusei1 = new BM_SyouhnZokusei(pSyouhncd1, pSyouhnsdno1);
        bizDomManager.insert(bM_SyouhnZokusei1);

        String pSyouhncd2 = "SH02";
        Integer pSyouhnsdno2 = 22;

        String pSyouhncd3 = "SH03";
        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);
        HT_MosSyouhnVrf hT_MosSyouhnVrf3 = hT_SyoriCTL3.createMosSyouhnVrf();
        hT_MosSyouhnVrf3.setSyouhncd(pSyouhncd1);
        hT_MosSyouhnVrf3.setSyouhnsdno(pSyouhnsdno1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        String pMosno2 = "MOSNO000002";
        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);
        HT_MosSyouhnVrf hT_MosSyouhnVrf2 = hT_SyoriCTL2.createMosSyouhnVrf();
        hT_MosSyouhnVrf2.setSyouhncd(pSyouhncd2);
        hT_MosSyouhnVrf2.setSyouhnsdno(pSyouhnsdno2);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        String pMosno1 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        HT_MosSyouhnVrf hT_MosSyouhnVrf1 = hT_SyoriCTL1.createMosSyouhnVrf();
        hT_MosSyouhnVrf1.setSyouhncd(pSyouhncd3);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

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
    public void getSyoriCTL() {

        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs1 = hT_SyoriCTL1.getMosSyouhnVrfs();
        HT_MosSyouhnVrf hT_MosSyouhnVrf1 = hT_MosSyouhnVrfs1.get(0);

        Assert.assertEquals(pMosno3, hT_MosSyouhnVrf1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getSyouhnZokusei() {

        String pMosno3 = "MOSNO000003";
        String pSyouhncd1 = "SH01";
        Integer pSyouhnsdno1 = 11;
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs1 = hT_SyoriCTL1.getMosSyouhnVrfs();
        HT_MosSyouhnVrf hT_MosSyouhnVrf1 = hT_MosSyouhnVrfs1.get(0);

        BM_SyouhnZokusei bM_SyouhnZokusei1 = hT_MosSyouhnVrf1.getSyouhnZokusei();

        Assert.assertEquals(pSyouhncd1, bM_SyouhnZokusei1.getSyouhncd());
        Assert.assertEquals(pSyouhnsdno1, bM_SyouhnZokusei1.getSyouhnsdno());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getSyouhnZokuseiNull01() {

        String pSyouhncd1 = "SH01";
        Integer pSyouhnsdno1 = 11;
        BM_SyouhnZokusei bM_SyouhnZokusei2 = bizDomManager.getSyouhnZokusei(pSyouhncd1, pSyouhnsdno1);

        bizDomManager.delete(bM_SyouhnZokusei2);

    }

    @Test
    @TestOrder(90)
    public void getSyouhnZokuseiNull02() {

        String pMosno1 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs = hT_SyoriCTL.getMosSyouhnVrfs();
        HT_MosSyouhnVrf hT_MosSyouhnVrf = hT_MosSyouhnVrfs.get(0);

        BM_SyouhnZokusei bM_SyouhnZokusei = hT_MosSyouhnVrf.getSyouhnZokusei();

        Assert.assertNull(bM_SyouhnZokusei);

        String pMosno2 = "MOSNO000002";
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs2 = hT_SyoriCTL2.getMosSyouhnVrfs();
        HT_MosSyouhnVrf hT_MosSyouhnVrf2 = hT_MosSyouhnVrfs2.get(0);

        BM_SyouhnZokusei bM_SyouhnZokusei2 = hT_MosSyouhnVrf2.getSyouhnZokusei();

        Assert.assertNull(bM_SyouhnZokusei2);

        String pMosno3 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs3 = hT_SyoriCTL3.getMosSyouhnVrfs();
        HT_MosSyouhnVrf hT_MosSyouhnVrf3 = hT_MosSyouhnVrfs3.get(0);

        BM_SyouhnZokusei bM_SyouhnZokusei3 = hT_MosSyouhnVrf3.getSyouhnZokusei();

        Assert.assertNull(bM_SyouhnZokusei3);
    }

}
