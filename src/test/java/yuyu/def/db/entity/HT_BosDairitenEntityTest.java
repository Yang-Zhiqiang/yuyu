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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_BosDairitenEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pDrtencd2 = "Da2";
        BM_Dairiten bM_Dairiten2 = new BM_Dairiten(pDrtencd2);
        bizDomManager.insert(bM_Dairiten2);

        String pDrtencd1 = "Da1";
        BM_Dairiten bM_Dairiten1 = new BM_Dairiten(pDrtencd1);
        bizDomManager.insert(bM_Dairiten1);

        String pDrtencd3 = "Da3";
        BM_Dairiten bM_Dairiten3 = new BM_Dairiten(pDrtencd3);
        bizDomManager.insert(bM_Dairiten3);

        String pDrtencd4 = "Da4";
        BM_Dairiten bM_Dairiten4 = new BM_Dairiten(pDrtencd4);
        bizDomManager.insert(bM_Dairiten4);

        String pBosyuucd2 = "Bo2";
        BM_Bosyuunin BM_Bosyuunin2 = new BM_Bosyuunin(pBosyuucd2);
        bizDomManager.insert(BM_Bosyuunin2);

        String pBosyuucd1 = "Bo1";
        BM_Bosyuunin BM_Bosyuunin1 = new BM_Bosyuunin(pBosyuucd1);
        bizDomManager.insert(BM_Bosyuunin1);

        String pMosno3 = "MOSNO3";
        Integer pRenno3 = 3;
        Integer pRenno2 = 2;
        Integer pRenno1 = 1;

        HT_BosKihon hT_BosKihon3 = new HT_BosKihon(pMosno3);
        HT_BosDairiten hT_BosDairiten33 = hT_BosKihon3.createBosDairiten();
        hT_BosDairiten33.setRenno(pRenno3);
        HT_BosDairiten hT_BosDairiten32 = hT_BosKihon3.createBosDairiten();
        hT_BosDairiten32.setRenno(pRenno2);
        HT_BosDairiten hT_BosDairiten31 = hT_BosKihon3.createBosDairiten();
        hT_BosDairiten31.setRenno(pRenno1);
        sinkeiyakuDomManager.insert(hT_BosKihon3);

        String pMosno2 = "MOSNO2";
        HT_BosKihon hT_BosKihon2 = new HT_BosKihon(pMosno2);
        HT_BosDairiten hT_BosDairiten2 = hT_BosKihon2.createBosDairiten();
        hT_BosDairiten2.setRenno(pRenno2);
        hT_BosDairiten2.setTratkiagcd(pDrtencd1);
        hT_BosDairiten2.setOyadrtencd(pDrtencd2);
        hT_BosDairiten2.setBosyuutrkno(pBosyuucd1);
        sinkeiyakuDomManager.insert(hT_BosKihon2);

        String pMosno1 = "MOSNO1";
        HT_BosKihon hT_BosKihon1 = new HT_BosKihon(pMosno1);
        HT_BosDairiten hT_BosDairiten1 = hT_BosKihon1.createBosDairiten();
        hT_BosDairiten1.setRenno(pRenno1);
        hT_BosDairiten1.setTratkiagcd(pDrtencd3);
        hT_BosDairiten1.setOyadrtencd(pDrtencd4);
        hT_BosDairiten1.setBosyuutrkno(pBosyuucd2);
        sinkeiyakuDomManager.insert(hT_BosKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllBosyuunin());

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
    public void getBosKihon() {

        String pMosno3 = "MOSNO3";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno3) ;
        HT_BosDairiten hT_BosDairiten = hT_BosKihon.getBosDairitens().get(0);
        HT_BosKihon result_hT_BosKihon = hT_BosDairiten.getBosKihon();

        Assert.assertEquals(hT_BosKihon.getMosno(), result_hT_BosKihon.getMosno());
    }

    @Test
    @TestOrder(70)
    public void getDairiten() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String pDrtencd1 = "Da1";
        String pDrtencd3 = "Da3";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd1), sinkeiyakuDomManager.getBosKihon(pMosno2).getBosDairitens().get(0).getDairitenTrat());
        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd3), sinkeiyakuDomManager.getBosKihon(pMosno1).getBosDairitens().get(0).getDairitenTrat());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosDairitens().get(0).getDairitenTrat());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getDairitenNull01() {

        String pDrtencd3 = "Da3";

        bizDomManager.delete(bizDomManager.getDairiten(pDrtencd3));
    }

    @Test
    @TestOrder(90)
    public void getDairitenNull02() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String pDrtencd1 = "Da1";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd1), sinkeiyakuDomManager.getBosKihon(pMosno2).getBosDairitens().get(0).getDairitenTrat());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno1).getBosDairitens().get(0).getDairitenTrat());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosDairitens().get(0).getDairitenTrat());
    }

    @Test
    @TestOrder(100)
    public void getDairitenOya() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String pDrtencd2 = "Da2";
        String pDrtencd4= "Da4";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd2), sinkeiyakuDomManager.getBosKihon(pMosno2).getBosDairitens().get(0).getDairitenOya());
        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd4), sinkeiyakuDomManager.getBosKihon(pMosno1).getBosDairitens().get(0).getDairitenOya());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosDairitens().get(0).getDairitenOya());
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void getDairitenOyaNull01() {

        String pDrtencd4= "Da4";

        sinkeiyakuDomManager.delete(bizDomManager.getDairiten(pDrtencd4));
    }

    @Test
    @TestOrder(120)
    public void getDairitenOyaNull02() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String pDrtencd2 = "Da2";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd2), sinkeiyakuDomManager.getBosKihon(pMosno2).getBosDairitens().get(0).getDairitenOya());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno1).getBosDairitens().get(0).getDairitenOya());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosDairitens().get(0).getDairitenOya());
    }


    @Test
    @TestOrder(130)
    public void getBosyuunin() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String BM_Bosyuunin1 = "Bo1";
        String BM_Bosyuunin2 = "Bo2";

        Assert.assertEquals(bizDomManager.getBosyuunin(BM_Bosyuunin1), sinkeiyakuDomManager.getBosKihon(pMosno2).getBosDairitens().get(0).getBosyuunin());
        Assert.assertEquals(bizDomManager.getBosyuunin(BM_Bosyuunin2), sinkeiyakuDomManager.getBosKihon(pMosno1).getBosDairitens().get(0).getBosyuunin());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosDairitens().get(0).getBosyuunin());
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void getBosyuuninNull01() {

        String BM_Bosyuunin2 = "Bo2";

        sinkeiyakuDomManager.delete(bizDomManager.getBosyuunin(BM_Bosyuunin2));
    }

    @Test
    @TestOrder(150)
    public void getBosyuuninNull02() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String BM_Bosyuunin1 = "Bo1";

        Assert.assertEquals(bizDomManager.getBosyuunin(BM_Bosyuunin1), sinkeiyakuDomManager.getBosKihon(pMosno2).getBosDairitens().get(0).getBosyuunin());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno1).getBosDairitens().get(0).getBosyuunin());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosDairitens().get(0).getBosyuunin());
    }
}
