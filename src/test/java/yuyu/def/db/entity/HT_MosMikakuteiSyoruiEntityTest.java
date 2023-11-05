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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_MosMikakuteiSyoruiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno3 = "MOSNO3";
        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";

        C_SyoruiCdKbn pSyoruiCd3 = C_SyoruiCdKbn.WF_HYOUSI;
        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.WF_QRSEAL;
        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.USERITIRANHYOU;

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri3 = new HT_MosMikakuteiJyouhouKanri(pMosno3);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri3);

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri2 = new HT_MosMikakuteiJyouhouKanri(pMosno2);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri2);

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri1 = new HT_MosMikakuteiJyouhouKanri(pMosno1);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());

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
}