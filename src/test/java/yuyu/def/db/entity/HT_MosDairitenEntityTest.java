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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 申込代理店テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_MosDairitenEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pDrtencd1 = "DTCD001";
        String pDrtencd2 = "DTCD002";
        String pDrtencd3 = "DTCD003";
        String pDrtencd4 = "DTCD004";

        bizDomManager.insert(new BM_Dairiten(pDrtencd1));
        bizDomManager.insert(new BM_Dairiten(pDrtencd2));
        bizDomManager.insert(new BM_Dairiten(pDrtencd3));
        bizDomManager.insert(new BM_Dairiten(pDrtencd4));

        String pBosyuucd1 = "BCD001";
        String pBosyuucd2 = "BCD002";

        bizDomManager.insert(new BM_Bosyuunin(pBosyuucd1));
        bizDomManager.insert(new BM_Bosyuunin(pBosyuucd2));


        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        Integer pRenno1 = 11;
        HT_MosDairiten hT_MosDairiten1 = hT_SyoriCTL1.createMosDairiten();
        hT_MosDairiten1.setRenno(pRenno1);
        hT_MosDairiten1.setTratkiagcd(pDrtencd1);
        hT_MosDairiten1.setOyadrtencd(pDrtencd2);
        hT_MosDairiten1.setBosyuucd(pBosyuucd1);
        Integer pRenno2 = 22;
        HT_MosDairiten hT_MosDairiten2 = hT_SyoriCTL1.createMosDairiten();
        hT_MosDairiten2.setRenno(pRenno2);
        hT_MosDairiten2.setTratkiagcd(pDrtencd3);
        hT_MosDairiten2.setOyadrtencd(pDrtencd4);
        hT_MosDairiten2.setBosyuucd(pBosyuucd2);
        Integer pRenno3 = 33;
        HT_MosDairiten hT_MosDairiten3 = hT_SyoriCTL1.createMosDairiten();
        hT_MosDairiten3.setRenno(pRenno3);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete( bizDomManager.getAllBosyuunin());
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
        List<HT_MosDairiten> hT_MosDairitens1 = hT_SyoriCTL1.getMosDairitens();
        HT_MosDairiten hT_MosDairiten1 = hT_MosDairitens1.get(0);

        Assert.assertEquals(pMosno1, hT_MosDairiten1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getToriatukaiDairiten() {

        String pMosno1 = "MOSNOD00001";
        String pDrtencd1 = "DTCD001";
        String pDrtencd3 = "DTCD003";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(0).getDairitenTrat());
        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd3), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(1).getDairitenTrat());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(2).getDairitenTrat());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getToriatukaiDairitenNull01() {

        bizDomManager.delete(bizDomManager.getDairiten("DTCD003"));
    }

    @Test
    @TestOrder(90)
    public void getToriatukaiDairitenNull02() {

        String pMosno1 = "MOSNOD00001";
        String pDrtencd1 = "DTCD001";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(0).getDairitenTrat());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(1).getDairitenTrat());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(2).getDairitenTrat());
    }

    @Test
    @TestOrder(100)
    public void getOyaDairiten() {

        String pMosno1 = "MOSNOD00001";
        String pDrtencd2 = "DTCD002";
        String pDrtencd4 = "DTCD004";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd2), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(0).getDairitenOya());
        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd4), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(1).getDairitenOya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(2).getDairitenOya());
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void getOyaDairitenNull01() {

        bizDomManager.delete(bizDomManager.getDairiten("DTCD004"));
    }

    @Test
    @TestOrder(120)
    public void getOyaDairitenNull02() {
        String pMosno1 = "MOSNOD00001";
        String pDrtencd2 = "DTCD002";

        Assert.assertEquals(bizDomManager.getDairiten(pDrtencd2), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(0).getDairitenOya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(1).getDairitenOya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(2).getDairitenOya());
    }

    @Test
    @TestOrder(130)
    public void getBosyuuKihon() {

        String pMosno1 = "MOSNOD00001";
        String pBosyuucd1 = "BCD001";
        String pBosyuucd2 = "BCD002";

        Assert.assertEquals(bizDomManager.getBosyuunin(pBosyuucd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(0).getBosyuunin());
        Assert.assertEquals(bizDomManager.getBosyuunin(pBosyuucd2), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(1).getBosyuunin());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(2).getBosyuunin());
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void getBosyuuKihonNull01() {

        bizDomManager.delete(bizDomManager.getBosyuunin("BCD002"));
    }

    @Test
    @TestOrder(150)
    public void getBosyuuKihonNull02() {

        String pMosno1 = "MOSNOD00001";
        String pBosyuucd1 = "BCD001";

        Assert.assertEquals(bizDomManager.getBosyuunin(pBosyuucd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(0).getBosyuunin());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(1).getBosyuunin());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosDairitens().get(2).getBosyuunin());
    }
}
