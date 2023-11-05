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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_MosMikakuteiJyouhouKanriEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public static final C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.WF_HYOUSI;
    public static final C_SyoruiCdKbn  pSyoruiCd2 = C_SyoruiCdKbn.WF_QRSEAL;
    public static final C_SyoruiCdKbn  pSyoruiCd3 = C_SyoruiCdKbn.USERITIRANHYOU;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pMosno22 = "MOSNO22";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri22 = new HT_MosMikakuteiJyouhouKanri(pMosno22);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri22);

        String pMosno21 = "MOSNO21";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri21 = new HT_MosMikakuteiJyouhouKanri(pMosno21);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri21);

        String pMosno12 = "MOSNO12";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri12 = new HT_MosMikakuteiJyouhouKanri(pMosno12);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri12);

        String pMosno11 = "MOSNO11";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri11 = new HT_MosMikakuteiJyouhouKanri(pMosno11);

        sinkeiyakuDomManager.insert(hT_MosMikakuteiJyouhouKanri11);

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

        String pMosno22 = "MOSNO22";
        String pMosno21 = "MOSNO21";
        String pMosno12 = "MOSNO12";
        String pMosno11 = "MOSNO11";

        List<HT_MosMikakuteiJyouhouKanri> hT_MosMikakuteiJyouhouKanris = sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri();

        Assert.assertEquals(hT_MosMikakuteiJyouhouKanris.get(0), sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno11));
        Assert.assertEquals(hT_MosMikakuteiJyouhouKanris.get(1), sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno12));
        Assert.assertEquals(hT_MosMikakuteiJyouhouKanris.get(2), sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno21));
        Assert.assertEquals(hT_MosMikakuteiJyouhouKanris.get(3), sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno22));
        Assert.assertEquals(4, hT_MosMikakuteiJyouhouKanris.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pMosno22 = "MOSNO22";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno22) ;
        Assert.assertEquals(pMosno22, hT_MosMikakuteiJyouhouKanri.getMosno());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pMosno33 = "MOSNO33";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno33) ;
        Assert.assertNull(hT_MosMikakuteiJyouhouKanri);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pMosno22 = "";

        HT_MosMikakuteiJyouhouKanri hT_MosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosno22) ;
        Assert.assertNull(hT_MosMikakuteiJyouhouKanri);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }
}
