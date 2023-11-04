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
public class HT_JigyouIkkatuEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_JigyouIkkatu> hT_JigyouIkkatus = sinkeiyakuDomManager.getAllJigyouIkkatu();
        Assert.assertEquals(0, hT_JigyouIkkatus.size());

        String pDaimosno22 = "DMOSNO22";
        HT_JigyouIkkatu HT_JigyouIkkatu22 = new HT_JigyouIkkatu(pDaimosno22);
        sinkeiyakuDomManager.insert(HT_JigyouIkkatu22);

        String pDaimosno21 = "DMOSNO21";
        HT_JigyouIkkatu HT_JigyouIkkatu21 = new HT_JigyouIkkatu(pDaimosno21);
        sinkeiyakuDomManager.insert(HT_JigyouIkkatu21);

        String pDaimosno12 = "DMOSNO12";
        HT_JigyouIkkatu HT_JigyouIkkatu12 = new HT_JigyouIkkatu(pDaimosno12);
        sinkeiyakuDomManager.insert(HT_JigyouIkkatu12);

        String pDaimosno11 = "DMOSNO11";
        HT_JigyouIkkatu HT_JigyouIkkatu11 = new HT_JigyouIkkatu(pDaimosno11);
        sinkeiyakuDomManager.insert(HT_JigyouIkkatu11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pDaimosno22 = "DMOSNO22";
        String pDaimosno21 = "DMOSNO21";
        String pDaimosno12 = "DMOSNO12";
        String pDaimosno11 = "DMOSNO11";

        List<HT_JigyouIkkatu> hT_JigyouIkkatus = sinkeiyakuDomManager.getAllJigyouIkkatu();
        Assert.assertSame(hT_JigyouIkkatus.get(0), sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno11));
        Assert.assertSame(hT_JigyouIkkatus.get(1), sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno12));
        Assert.assertSame(hT_JigyouIkkatus.get(2), sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno21));
        Assert.assertSame(hT_JigyouIkkatus.get(3), sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno22));
        Assert.assertEquals(4, hT_JigyouIkkatus.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pDaimosno22 = "DMOSNO22";
        HT_JigyouIkkatu hT_JigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno22);

        Assert.assertEquals(pDaimosno22, hT_JigyouIkkatu.getDaimosno());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pDaimosno33 = "DMOSNO33";
        HT_JigyouIkkatu hT_JigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno33);

        Assert.assertNull(hT_JigyouIkkatu);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pDaimosno22 = "";
        HT_JigyouIkkatu hT_JigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(pDaimosno22);

        Assert.assertNull(hT_JigyouIkkatu);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);

    }

}
