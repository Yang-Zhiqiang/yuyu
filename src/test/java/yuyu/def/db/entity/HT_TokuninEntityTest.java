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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 特認テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_TokuninEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.insert(new HM_KetteiSya("11"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("22"));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_Tokunin hT_Tokunin1 = hT_SyoriCTL1.createTokunin();
        hT_Tokunin1.setKetsyacd("11");

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);


        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL("MOSNOD00002");

        HT_Tokunin hT_Tokunin2 = hT_SyoriCTL2.createTokunin();
        hT_Tokunin2.setKetsyacd("22");

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);


        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL("MOSNOD00003");

        hT_SyoriCTL3.createTokunin();

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllKetteiSya());
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
    public void getSyoriCTL() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_Tokunin hT_Tokunin1 = hT_SyoriCTL1.getTokunin();

        Assert.assertEquals(pMosno1, hT_Tokunin1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(60)
    public void getKetteiSya() {

        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getTokunin().getKetteiSya());
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno2).getTokunin().getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno3).getTokunin().getKetteiSya());

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getKetteiSyaNull01() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getKetteiSya("22"));

    }

    @Test
    @TestOrder(80)
    public void getKetteiSyaNull02() {

        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getTokunin().getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno2).getTokunin().getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno3).getTokunin().getKetteiSya());

    }

}