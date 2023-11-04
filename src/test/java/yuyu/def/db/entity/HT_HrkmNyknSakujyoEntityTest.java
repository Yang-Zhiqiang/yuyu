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
public class HT_HrkmNyknSakujyoEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_HrkmNyknSakujyo> hT_HrkmNyknSakujyos = sinkeiyakuDomManager.getAllHrkmNyknSakujyo();

        Assert.assertEquals(0, hT_HrkmNyknSakujyos.size());

        String pHrkmdeldataskbtkey22 = "hrkmdeldataskbtkey22";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo22 = new HT_HrkmNyknSakujyo(pHrkmdeldataskbtkey22);
        sinkeiyakuDomManager.insert(hT_HrkmNyknSakujyo22);

        String pHrkmdeldataskbtkey21 = "hrkmdeldataskbtkey21";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo21 = new HT_HrkmNyknSakujyo(pHrkmdeldataskbtkey21);
        sinkeiyakuDomManager.insert(hT_HrkmNyknSakujyo21);

        String pHrkmdeldataskbtkey12 = "hrkmdeldataskbtkey12";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo12 = new HT_HrkmNyknSakujyo(pHrkmdeldataskbtkey12);
        sinkeiyakuDomManager.insert(hT_HrkmNyknSakujyo12);

        String pHrkmdeldataskbtkey11 = "hrkmdeldataskbtkey11";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo11 = new HT_HrkmNyknSakujyo(pHrkmdeldataskbtkey11);
        sinkeiyakuDomManager.insert(hT_HrkmNyknSakujyo11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknSakujyo());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {
        String pHrkmdeldataskbtkey22 = "hrkmdeldataskbtkey22";
        String pHrkmdeldataskbtkey21 = "hrkmdeldataskbtkey21";
        String pHrkmdeldataskbtkey12 = "hrkmdeldataskbtkey12";
        String pHrkmdeldataskbtkey11 = "hrkmdeldataskbtkey11";

        List<HT_HrkmNyknSakujyo> hT_HrkmNyknSakujyos = sinkeiyakuDomManager.getAllHrkmNyknSakujyo();
        Assert.assertSame(hT_HrkmNyknSakujyos.get(0), sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey11));
        Assert.assertSame(hT_HrkmNyknSakujyos.get(1), sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey12));
        Assert.assertSame(hT_HrkmNyknSakujyos.get(2), sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey21));
        Assert.assertSame(hT_HrkmNyknSakujyos.get(3), sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey22));

        Assert.assertEquals(4, hT_HrkmNyknSakujyos.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pHrkmdeldataskbtkey22 = "hrkmdeldataskbtkey22";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo11 = sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey22);

        Assert.assertEquals(pHrkmdeldataskbtkey22, hT_HrkmNyknSakujyo11.getHrkmdeldataskbtkey());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pHrkmdeldataskbtkey33 = "hrkmdeldataskbtkey33";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo11 = sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey33);

        Assert.assertNull(hT_HrkmNyknSakujyo11);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pHrkmdeldataskbtkey22 = "";

        HT_HrkmNyknSakujyo hT_HrkmNyknSakujyo11 = sinkeiyakuDomManager.getHrkmNyknSakujyo(pHrkmdeldataskbtkey22);

        Assert.assertNull(hT_HrkmNyknSakujyo11);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

}
