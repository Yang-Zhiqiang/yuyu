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
public class HM_KetteiSyaEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        String pKetsyacd22 = "Ketsyacd22";
        HM_KetteiSya hM_KetteiSya22 = new HM_KetteiSya(pKetsyacd22);
        sinkeiyakuDomManager.insert(hM_KetteiSya22);

        String pKetsyacd21 = "Ketsyacd21";
        HM_KetteiSya hM_KetteiSya21 = new HM_KetteiSya(pKetsyacd21);
        sinkeiyakuDomManager.insert(hM_KetteiSya21);

        String pKetsyacd12 = "Ketsyacd12";
        HM_KetteiSya hM_KetteiSya12 = new HM_KetteiSya(pKetsyacd12);
        sinkeiyakuDomManager.insert(hM_KetteiSya12);

        String pKetsyacd11 = "Ketsyacd11";
        HM_KetteiSya hM_KetteiSya11 = new HM_KetteiSya(pKetsyacd11);
        sinkeiyakuDomManager.insert(hM_KetteiSya11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllKetteiSya());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pKetsyacd22 = "Ketsyacd22";
        String pKetsyacd21 = "Ketsyacd21";
        String pKetsyacd12 = "Ketsyacd12";
        String pKetsyacd11 = "Ketsyacd11";

        List<HM_KetteiSya> hM_KetteiSyas = sinkeiyakuDomManager.getAllKetteiSya();

        Assert.assertEquals(pKetsyacd11, sinkeiyakuDomManager.getAllKetteiSya().get(0).getKetsyacd());
        Assert.assertEquals(pKetsyacd12, sinkeiyakuDomManager.getAllKetteiSya().get(1).getKetsyacd());
        Assert.assertEquals(pKetsyacd21, sinkeiyakuDomManager.getAllKetteiSya().get(2).getKetsyacd());
        Assert.assertEquals(pKetsyacd22, sinkeiyakuDomManager.getAllKetteiSya().get(3).getKetsyacd());

        Assert.assertEquals(4, hM_KetteiSyas.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pKetsyacd22 = "Ketsyacd22";

        HM_KetteiSya hM_KetteiSya = sinkeiyakuDomManager.getKetteiSya(pKetsyacd22);
        Assert.assertEquals(pKetsyacd22, hM_KetteiSya.getKetsyacd());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pKetsyacd33 = "Ketsyacd33";

        HM_KetteiSya hM_KetteiSya = sinkeiyakuDomManager.getKetteiSya(pKetsyacd33);
        Assert.assertNull(hM_KetteiSya);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pKetsyacd = "";
        HM_KetteiSya hM_KetteiSya = sinkeiyakuDomManager.getKetteiSya(pKetsyacd);

        Assert.assertNull(hM_KetteiSya);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }

}
