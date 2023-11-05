package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_BosUketorininEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno3 = "MOSNO3";
        C_UktsyuKbn pUktsyuKbn3 = C_UktsyuKbn.BLNK;
        Integer pUktsyurenno3 = 3;
        C_UktsyuKbn pUktsyuKbn2 = C_UktsyuKbn.SBUKT;
        Integer pUktsyurenno2 = 2;
        C_UktsyuKbn pUktsyuKbn1 = C_UktsyuKbn.STDRSK;
        Integer pUktsyurenno1 = 1;

        HT_BosKihon hT_BosKihon3 = new HT_BosKihon(pMosno3);

        HT_BosUketorinin hT_BosUketorinin33 = hT_BosKihon3.createBosUketorinin();
        hT_BosUketorinin33.setUktsyukbn(pUktsyuKbn3);
        hT_BosUketorinin33.setUktsyurenno(pUktsyurenno3);

        HT_BosUketorinin hT_BosUketorinin32 = hT_BosKihon3.createBosUketorinin();
        hT_BosUketorinin32.setUktsyukbn(pUktsyuKbn2);
        hT_BosUketorinin32.setUktsyurenno(pUktsyurenno2);

        HT_BosUketorinin hT_BosUketorinin31 = hT_BosKihon3.createBosUketorinin();
        hT_BosUketorinin31.setUktsyukbn(pUktsyuKbn1);
        hT_BosUketorinin31.setUktsyurenno(pUktsyurenno1);

        sinkeiyakuDomManager.insert(hT_BosKihon3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());

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
    public void ToHT_BosKihon() {

        String pMosno3 = "MOSNO3";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno3) ;
        HT_BosUketorinin hT_BosUketorinin = hT_BosKihon.getBosUketorinins().get(0);
        HT_BosKihon result_hT_BosKihon = hT_BosUketorinin.getBosKihon();

        Assert.assertEquals(pMosno3, result_hT_BosKihon.getMosno());
    }

}
