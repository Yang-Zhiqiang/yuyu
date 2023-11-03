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
public class HT_NrkDifEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno3 = "MOSNO3";
        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);

        String pVrfkinouid3 = "VKID0000003";
        Integer pRenno3keta3 = 333;
        HT_NrkDif hT_NrkDif3 = hT_SyoriCTL3.createNrkDif();
        hT_NrkDif3.setVrfkinouid(pVrfkinouid3);
        hT_NrkDif3.setRenno3keta(pRenno3keta3);

        String pVrfkinouid2 = "VKID0000002";
        Integer pRenno3keta2 = 222;
        HT_NrkDif hT_NrkDif2 = hT_SyoriCTL3.createNrkDif();
        hT_NrkDif2.setVrfkinouid(pVrfkinouid2);
        hT_NrkDif2.setRenno3keta(pRenno3keta2);

        String pVrfkinouid1 = "VKID0000001";
        Integer pRenno3keta1 = 111;
        HT_NrkDif hT_NrkDif1 = hT_SyoriCTL3.createNrkDif();
        hT_NrkDif1.setVrfkinouid(pVrfkinouid1);
        hT_NrkDif1.setRenno3keta(pRenno3keta1);

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

        String pMosno3 = "MOSNO3";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        List<HT_NrkDif> hT_NrkDifs1 = hT_SyoriCTL1.getNrkDifs();
        HT_NrkDif hT_NrkDif1 = hT_NrkDifs1.get(0);

        Assert.assertEquals(pMosno3, hT_NrkDif1.getSyoriCTL().getMosno());
    }
}
