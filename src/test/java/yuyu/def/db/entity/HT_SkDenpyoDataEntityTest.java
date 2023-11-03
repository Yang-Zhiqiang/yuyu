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
public class HT_SkDenpyoDataEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkDenpyoData> denPyous = sinkeiyakuDomManager.getAllSkDenpyoData();

        Assert.assertEquals(0, denPyous.size());

        String pMosno1 = "SYONO000001";
        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        String pMosno2 = "SYONO000002";

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        String pDenrenno22 = "DENRENN22";
        Integer pEdano22 = 22;

        HT_SkDenpyoData HT_SkDenpyoData22 = new HT_SkDenpyoData(pDenrenno22,pEdano22);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData22);

        String pDenrenno21 = "DENRENN21";
        Integer pEdano21 = 21;

        HT_SkDenpyoData HT_SkDenpyoData21 = new HT_SkDenpyoData(pDenrenno21,pEdano21);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData21);

        String pDenrenno12 = "DENRENN12";
        Integer pEdano12 = 12;

        HT_SkDenpyoData HT_SkDenpyoData12 = new HT_SkDenpyoData(pDenrenno12,pEdano12);
        HT_SkDenpyoData12.setSyono(pMosno2);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData12);

        String pDenrenno11 = "DENRENN11";
        Integer pEdano11 = 11;

        HT_SkDenpyoData HT_SkDenpyoData11 = new HT_SkDenpyoData(pDenrenno11,pEdano11);
        HT_SkDenpyoData11.setSyono(pMosno1);
        sinkeiyakuDomManager.insert(HT_SkDenpyoData11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pDenrenno11 = "DENRENN11";
        Integer pEdano11 = 11;

        String pDenrenno12 = "DENRENN12";
        Integer pEdano12 = 12;

        String pDenrenno22 = "DENRENN22";
        Integer pEdano22 = 22;

        String pDenrenno21 = "DENRENN21";
        Integer pEdano21 = 21;

        List<HT_SkDenpyoData> denPyous = sinkeiyakuDomManager.getAllSkDenpyoData();
        Assert.assertSame(denPyous.get(0), sinkeiyakuDomManager.getSkDenpyoData(pDenrenno11, pEdano11));
        Assert.assertSame(denPyous.get(1), sinkeiyakuDomManager.getSkDenpyoData(pDenrenno12, pEdano12));
        Assert.assertSame(denPyous.get(2), sinkeiyakuDomManager.getSkDenpyoData(pDenrenno21, pEdano21));
        Assert.assertSame(denPyous.get(3), sinkeiyakuDomManager.getSkDenpyoData(pDenrenno22, pEdano22));

        Assert.assertEquals(4, denPyous.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pDenrenno11 = "DENRENN11";
        Integer pEdano11 = 11;

        HT_SkDenpyoData hT_SkDenpyoData11 = sinkeiyakuDomManager.getSkDenpyoData(pDenrenno11, pEdano11);

        Assert.assertEquals(pDenrenno11, hT_SkDenpyoData11.getDenrenno());
        Assert.assertEquals(pEdano11, hT_SkDenpyoData11.getEdano());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pDenrenno11 = "DENRENN33";
        Integer pEdano11 = 11;
        HT_SkDenpyoData hT_SkDenpyoData11 = sinkeiyakuDomManager.getSkDenpyoData(pDenrenno11, pEdano11);

        Assert.assertNull(hT_SkDenpyoData11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {
        String pDenrenno11 = "";
        Integer pEdano11 = 11;

        HT_SkDenpyoData hT_SkDenpyoData11 = sinkeiyakuDomManager.getSkDenpyoData(pDenrenno11, pEdano11);

        Assert.assertNull(hT_SkDenpyoData11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }
}
