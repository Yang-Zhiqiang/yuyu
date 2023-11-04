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
public class HT_MosDairitenVrfEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);

        Integer pRenno3 = 33;
        HT_MosDairitenVrf hT_MosDairitenVrf3 = hT_SyoriCTL3.createMosDairitenVrf();
        hT_MosDairitenVrf3.setRenno(pRenno3);

        Integer pRenno2 = 22;
        HT_MosDairitenVrf hT_MosDairitenVrf2 = hT_SyoriCTL3.createMosDairitenVrf();
        hT_MosDairitenVrf2.setRenno(pRenno2);

        Integer pRenno1 = 11;
        HT_MosDairitenVrf hT_MosDairitenVrf1 = hT_SyoriCTL3.createMosDairitenVrf();
        hT_MosDairitenVrf1.setRenno(pRenno1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

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
    public void getSyoriCTL() {

        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_MosDairitenVrf> hT_MosDairitenVrfs1 = hT_SyoriCTL1.getMosDairitenVrfs();
        HT_MosDairitenVrf hT_MosDairitenVrf1 = hT_MosDairitenVrfs1.get(0);

        Assert.assertEquals(pMosno3, hT_MosDairitenVrf1.getSyoriCTL().getMosno());

    }
}
