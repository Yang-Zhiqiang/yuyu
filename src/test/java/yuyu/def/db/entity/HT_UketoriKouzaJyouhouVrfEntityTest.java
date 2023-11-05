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

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_UketoriKouzaJyouhouVrfEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno3 = "MOSNO3";

        C_UketorikouzasyubetuKbn UketorikouzasyubetuKbn3 = C_UketorikouzasyubetuKbn.BLNK;

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);

        HT_UketoriKouzaJyouhouVrf hT_UketoriKouzaJyouhouVrf3 = hT_SyoriCTL3.createUketoriKouzaJyouhouVrf();
        hT_UketoriKouzaJyouhouVrf3.setUktkzsyubetukbn(UketorikouzasyubetuKbn3);

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
    public void ToHT_SyoriCTL() {

        String pMosno3 = "MOSNO3";

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_UketoriKouzaJyouhouVrf hT_UketoriKouzaJyouhouVrf = hT_SyoriCTL.getUketoriKouzaJyouhouVrfs().get(0);

        Assert.assertEquals(pMosno3, hT_UketoriKouzaJyouhouVrf.getSyoriCTL().getMosno());
    }

}
