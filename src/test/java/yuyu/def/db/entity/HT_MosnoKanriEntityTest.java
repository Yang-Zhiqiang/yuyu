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
public class HT_MosnoKanriEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_MosnoKanri> sT_MosnoKanris = sinkeiyakuDomManager.getAllMosnoKanri();
        Assert.assertEquals(0, sT_MosnoKanris.size());

        String pMosno8keta22 = "Mosno22";

        HT_MosnoKanri hT_MosnoKanri22 = new HT_MosnoKanri(pMosno8keta22);
        sinkeiyakuDomManager.insert(hT_MosnoKanri22);

        String pMosno8keta21 = "Mosno21";

        HT_MosnoKanri hT_MosnoKanri21 = new HT_MosnoKanri(pMosno8keta21);
        sinkeiyakuDomManager.insert(hT_MosnoKanri21);

        String pMosno8keta12 = "Mosno12";

        HT_MosnoKanri hT_MosnoKanri12 = new HT_MosnoKanri(pMosno8keta12);
        sinkeiyakuDomManager.insert(hT_MosnoKanri12);

        String pMosno8keta11 = "Mosno11";

        HT_MosnoKanri hT_MosnoKanri11 = new HT_MosnoKanri(pMosno8keta11);
        sinkeiyakuDomManager.insert(hT_MosnoKanri11);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_MosnoKanri> sT_MosnoKanris = sinkeiyakuDomManager.getAllMosnoKanri();

        String pMosno8keta22 = "Mosno22";
        String pMosno8keta21 = "Mosno21";
        String pMosno8keta12 = "Mosno12";
        String pMosno8keta11 = "Mosno11";

        Assert.assertEquals(sT_MosnoKanris.get(0), sinkeiyakuDomManager.getMosnoKanri(pMosno8keta11));
        Assert.assertEquals(sT_MosnoKanris.get(1), sinkeiyakuDomManager.getMosnoKanri(pMosno8keta12));
        Assert.assertEquals(sT_MosnoKanris.get(2), sinkeiyakuDomManager.getMosnoKanri(pMosno8keta21));
        Assert.assertEquals(sT_MosnoKanris.get(3), sinkeiyakuDomManager.getMosnoKanri(pMosno8keta22));
        Assert.assertEquals(4, sT_MosnoKanris.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pMosno8keta22 = "Mosno22";

        HT_MosnoKanri hT_MosnoKanri = sinkeiyakuDomManager.getMosnoKanri(pMosno8keta22);

        Assert.assertEquals(pMosno8keta22, hT_MosnoKanri.getMosno8keta());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pMosno8keta33 = "Mosno33";

        HT_MosnoKanri hT_MosnoKanri = sinkeiyakuDomManager.getMosnoKanri(pMosno8keta33);

        Assert.assertNull(hT_MosnoKanri);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pMosno8keta22 = "";

        HT_MosnoKanri hT_MosnoKanri = sinkeiyakuDomManager.getMosnoKanri(pMosno8keta22);

        Assert.assertNull(hT_MosnoKanri);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }
}
