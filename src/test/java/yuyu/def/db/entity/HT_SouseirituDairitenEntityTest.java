package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_SouseirituDairitenEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;


    @Inject
    protected ExDBEntityManager em;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pDrtencd1 = "Dr1";
        BM_Dairiten bM_Dairiten2 = new BM_Dairiten(pDrtencd1);
        bizDomManager.insert(bM_Dairiten2);

        String pDrtencd2 = "Dr2";
        BM_Dairiten bM_Dairiten1 = new BM_Dairiten(pDrtencd2);
        bizDomManager.insert(bM_Dairiten1);

        String pDrtencd3 = "Dr3";
        BM_Dairiten bM_Dairiten3 = new BM_Dairiten(pDrtencd3);
        bizDomManager.insert(bM_Dairiten3);

        String pDrtencd4 = "Dr4";
        BM_Dairiten bM_Dairiten4 = new BM_Dairiten(pDrtencd4);
        bizDomManager.insert(bM_Dairiten4);

        String pBosyuucd2 = "Bo2";
        BM_Bosyuunin bM_Bosyuunin2 = new BM_Bosyuunin(pBosyuucd2);
        bizDomManager.insert(bM_Bosyuunin2);

        String pBosyuucd1 = "Bo1";
        BM_Bosyuunin bM_Bosyuunin1 = new BM_Bosyuunin(pBosyuucd1);
        bizDomManager.insert(bM_Bosyuunin1);

        String pSyono1 = "SYONO1";
        String pSyono2 = "SYONO2";
        String pSyono3 = "SYONO3";
        Integer pRenno1 = 1;
        Integer pRenno2 = 2;
        Integer pRenno3 = 3;

        HT_SouseirituKihon hT_SouseirituKihon1= new HT_SouseirituKihon(pSyono1);
        HT_SouseirituDairiten hT_SouseirituDairiten11 = hT_SouseirituKihon1.createSouseirituDairiten();
        hT_SouseirituDairiten11.setRenno(pRenno1);
        hT_SouseirituDairiten11.setTratkiagcd(pDrtencd1);
        HT_SouseirituDairiten hT_SouseirituDairiten12 = hT_SouseirituKihon1.createSouseirituDairiten();
        hT_SouseirituDairiten12.setRenno(pRenno2);
        hT_SouseirituDairiten12.setTratkiagcd(pDrtencd2);
        HT_SouseirituDairiten hT_SouseirituDairiten13 = hT_SouseirituKihon1.createSouseirituDairiten();
        hT_SouseirituDairiten13.setRenno(pRenno3);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon1);

        HT_SouseirituKihon hT_SouseirituKihon2= new HT_SouseirituKihon(pSyono2);
        HT_SouseirituDairiten hT_SouseirituDairiten21 = hT_SouseirituKihon2.createSouseirituDairiten();
        hT_SouseirituDairiten21.setRenno(pRenno1);
        hT_SouseirituDairiten21.setOyadrtencd(pDrtencd3);
        HT_SouseirituDairiten hT_SouseirituDairiten22 = hT_SouseirituKihon2.createSouseirituDairiten();
        hT_SouseirituDairiten22.setRenno(pRenno2);
        hT_SouseirituDairiten22.setOyadrtencd(pDrtencd4);
        HT_SouseirituDairiten hT_SouseirituDairiten23 = hT_SouseirituKihon2.createSouseirituDairiten();
        hT_SouseirituDairiten23.setRenno(pRenno3);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon2);

        HT_SouseirituKihon hT_SouseirituKihon3 = new HT_SouseirituKihon(pSyono3);
        HT_SouseirituDairiten hT_SouseirituDairiten31 = hT_SouseirituKihon3.createSouseirituDairiten();
        hT_SouseirituDairiten31.setRenno(pRenno1);
        hT_SouseirituDairiten31.setBosyuucd(pBosyuucd1);
        HT_SouseirituDairiten hT_SouseirituDairiten32 = hT_SouseirituKihon3.createSouseirituDairiten();
        hT_SouseirituDairiten32.setRenno(pRenno2);
        hT_SouseirituDairiten32.setBosyuucd(pBosyuucd2);
        HT_SouseirituDairiten hT_SouseirituDairiten33 = hT_SouseirituKihon3.createSouseirituDairiten();
        hT_SouseirituDairiten33.setRenno(pRenno3);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSouseirituKihon());
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
    public void getDairitenTrat() {

        String pSyono1 = "SYONO1";
        String pDrtencd1 = "Dr1";
        String pDrtencd2 = "Dr2";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd1), sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituDairitens().get(0).getDairitenTrat());
        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd2), sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituDairitens().get(1).getDairitenTrat());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituDairitens().get(2).getDairitenTrat());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getDairitenTratNull01() {

        String pDrtencd2 = "Dr2";

        sinkeiyakuDomManager.delete(bizDomManager.getDairiten(pDrtencd2));
    }

    @Test
    @TestOrder(80)
    public void getDairitenTratNull02() {
        String pSyono1 = "SYONO1";
        String pDrtencd1 = "Dr1";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd1), sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituDairitens().get(0).getDairitenTrat());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituDairitens().get(1).getDairitenTrat());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituDairitens().get(2).getDairitenTrat());
    }

    @Test
    @TestOrder(90)
    public void getDairitenOya() {

        String pSyono2 = "SYONO2";
        String pDrtencd3 = "Dr3";
        String pDrtencd4 = "Dr4";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd3), sinkeiyakuDomManager.getSouseirituKihon(pSyono2).getSouseirituDairitens().get(0).getDairitenOya());
        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd4), sinkeiyakuDomManager.getSouseirituKihon(pSyono2).getSouseirituDairitens().get(1).getDairitenOya());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono2).getSouseirituDairitens().get(2).getDairitenOya());
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void getDairitenOyaNull01() {

        String pDrtencd4 = "Dr4";

        sinkeiyakuDomManager.delete(bizDomManager.getDairiten(pDrtencd4));
    }

    @Test
    @TestOrder(110)
    public void getDairitenOyaNull02() {

        String pSyono2 = "SYONO2";
        String pDrtencd3 = "Dr3";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd3), sinkeiyakuDomManager.getSouseirituKihon(pSyono2).getSouseirituDairitens().get(0).getDairitenOya());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono2).getSouseirituDairitens().get(1).getDairitenOya());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono2).getSouseirituDairitens().get(2).getDairitenOya());
    }

    @Test
    @TestOrder(120)
    public void getBosyuunin() {

        String pSyono3 = "SYONO3";
        String pBosyuucd1 = "Bo1";
        String pBosyuucd2 = "Bo2";

        Assert.assertEquals(bizDomManager.getBosyuunin(pBosyuucd1), sinkeiyakuDomManager.getSouseirituKihon(pSyono3).getSouseirituDairitens().get(0).getBosyuunin());
        Assert.assertEquals(bizDomManager.getBosyuunin(pBosyuucd2), sinkeiyakuDomManager.getSouseirituKihon(pSyono3).getSouseirituDairitens().get(1).getBosyuunin());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono3).getSouseirituDairitens().get(2).getBosyuunin());
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void getBosyuuninNull01() {

        String pBosyuucd2 = "Bo2";

        sinkeiyakuDomManager.delete(bizDomManager.getBosyuunin(pBosyuucd2));
    }

    @Test
    @TestOrder(140)
    public void getBosyuuninNull02() {

        String pSyono3 = "SYONO3";
        String pBosyuucd1 = "Bo1";

        Assert.assertEquals(bizDomManager.getBosyuunin(pBosyuucd1), sinkeiyakuDomManager.getSouseirituKihon(pSyono3).getSouseirituDairitens().get(0).getBosyuunin());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono3).getSouseirituDairitens().get(1).getBosyuunin());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono3).getSouseirituDairitens().get(2).getBosyuunin());
    }

    @Test
    @TestOrder(150)
    public void getSouseirituKihon() {

        String pSyono1 = "SYONO1";

        HT_SouseirituKihon hT_SouseirituKihon = sinkeiyakuDomManager.getSouseirituKihon(pSyono1) ;
        HT_SouseirituDairiten hT_SouseirituDairiten = hT_SouseirituKihon.getSouseirituDairitens().get(0);
        HT_SouseirituKihon result_hT_SouseirituKihon =  hT_SouseirituDairiten.getSouseirituKihon();

        Assert.assertEquals(pSyono1, result_hT_SouseirituKihon.getSyono());
    }
}
