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
public class HT_MiseirijiyuuMeisaiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_MiseirijiyuuMeisai> hT_MiseirijiyuuMeisais = sinkeiyakuDomManager.getAllMiseirijiyuuMeisai();
        Assert.assertEquals(0, hT_MiseirijiyuuMeisais.size());

        String pMosno22 = "Mosno22";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai22 = new HT_MiseirijiyuuMeisai(pMosno22);
        sinkeiyakuDomManager.insert(hT_MiseirijiyuuMeisai22);

        String pMosno21 = "Mosno21";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai21 = new HT_MiseirijiyuuMeisai(pMosno21);
        sinkeiyakuDomManager.insert(hT_MiseirijiyuuMeisai21);

        String pMosno12 = "Mosno12";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai12 = new HT_MiseirijiyuuMeisai(pMosno12);
        sinkeiyakuDomManager.insert(hT_MiseirijiyuuMeisai12);

        String pMosno11 = "Mosno11";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai11 = new HT_MiseirijiyuuMeisai(pMosno11);
        sinkeiyakuDomManager.insert(hT_MiseirijiyuuMeisai11);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMiseirijiyuuMeisai());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_MiseirijiyuuMeisai> hT_MiseirijiyuuMeisais = sinkeiyakuDomManager.getAllMiseirijiyuuMeisai();

        String pMosno22 = "Mosno22";
        String pMosno21 = "Mosno21";
        String pMosno12 = "Mosno12";
        String pMosno11 = "Mosno11";

        Assert.assertEquals(hT_MiseirijiyuuMeisais.get(0), sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno11));
        Assert.assertEquals(hT_MiseirijiyuuMeisais.get(1), sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno12));
        Assert.assertEquals(hT_MiseirijiyuuMeisais.get(2), sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno21));
        Assert.assertEquals(hT_MiseirijiyuuMeisais.get(3), sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno22));
        Assert.assertEquals(4, hT_MiseirijiyuuMeisais.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pMosno22 = "Mosno22";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai = sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno22);

        Assert.assertEquals(pMosno22, hT_MiseirijiyuuMeisai.getMosno());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pMosno33 = "Mosno33";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai = sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno33);

        Assert.assertNull(hT_MiseirijiyuuMeisai);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pMosno22 = "";

        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai = sinkeiyakuDomManager.getMiseirijiyuuMeisai(pMosno22);

        Assert.assertNull(hT_MiseirijiyuuMeisai);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }
}
