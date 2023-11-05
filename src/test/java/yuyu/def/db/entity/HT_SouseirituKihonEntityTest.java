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

@RunWith(SWAKTestRunner.class)
public class HT_SouseirituKihonEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0,sinkeiyakuDomManager.getAllSouseirituKihon().size());

        String pSyono22 = "SYONO22";
        String pSyono21 = "SYONO21";
        String pSyouhncd1 = "1111";
        String pSyouhncd2 = "2222";
        String pSyouhncd3 = "3333";
        Integer pRenno1 = 1;
        Integer pRenno2 = 2;
        Integer pRenno3 = 3;
        HT_SouseirituKihon hT_SouseirituKihon1 = new HT_SouseirituKihon(pSyono22);
        HT_SouseirituSyouhin hT_SouseirituSyouhin11 = hT_SouseirituKihon1.createSouseirituSyouhin();
        hT_SouseirituSyouhin11.setSyouhncd(pSyouhncd2);
        HT_SouseirituSyouhin hT_SouseirituSyouhin12 = hT_SouseirituKihon1.createSouseirituSyouhin();
        hT_SouseirituSyouhin12.setSyouhncd(pSyouhncd1);
        HT_SouseirituSyouhin hT_SouseirituSyouhin13 = hT_SouseirituKihon1.createSouseirituSyouhin();
        hT_SouseirituSyouhin13.setSyouhncd(pSyouhncd3);

        HT_SouseirituDairiten hT_SouseirituDairiten11 =  hT_SouseirituKihon1.createSouseirituDairiten();
        hT_SouseirituDairiten11.setRenno(pRenno2);
        HT_SouseirituDairiten hT_SouseirituDairiten12 =  hT_SouseirituKihon1.createSouseirituDairiten();
        hT_SouseirituDairiten12.setRenno(pRenno1);
        HT_SouseirituDairiten hT_SouseirituDairiten13 =  hT_SouseirituKihon1.createSouseirituDairiten();
        hT_SouseirituDairiten13.setRenno(pRenno3);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon1);

        HT_SouseirituKihon hT_SouseirituKihon2 = new HT_SouseirituKihon(pSyono21);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSouseirituKihon());


    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_SouseirituKihon> hT_SouseirituKihons = sinkeiyakuDomManager.getAllSouseirituKihon();

        String pSyono22 = "SYONO22";
        String pSyono21 = "SYONO21";
        Assert.assertEquals(hT_SouseirituKihons.get(0), sinkeiyakuDomManager.getSouseirituKihon(pSyono21));
        Assert.assertEquals(hT_SouseirituKihons.get(1), sinkeiyakuDomManager.getSouseirituKihon(pSyono22));
        Assert.assertEquals(2, hT_SouseirituKihons.size());
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pSyono22 = "SYONO22";

        HT_SouseirituKihon hT_SouseirituKihon = sinkeiyakuDomManager.getSouseirituKihon(pSyono22);

        Assert.assertEquals(pSyono22, hT_SouseirituKihon.getSyono());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pSyono33 = "SYONO33";
        HT_SouseirituKihon hT_SouseirituKihon = sinkeiyakuDomManager.getSouseirituKihon(pSyono33);

        Assert.assertNull(hT_SouseirituKihon);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pSyonoBlank = "";
        HT_SouseirituKihon hT_SouseirituKihon = sinkeiyakuDomManager.getSouseirituKihon(pSyonoBlank);

        Assert.assertNull(hT_SouseirituKihon);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }

    @Test
    @TestOrder(60)
    public void getSouseirituSyouhin() {

        String pSyono22 = "SYONO22";
        String pSyouhncd1 = "1111";
        String pSyouhncd2 = "2222";
        String pSyouhncd3 = "3333";

        HT_SouseirituKihon hT_SouseirituKihon1 = sinkeiyakuDomManager.getSouseirituKihon(pSyono22);
        List<HT_SouseirituSyouhin> hT_SouseirituSyouhins1 = hT_SouseirituKihon1.getSouseirituSyouhins();
        Assert.assertEquals(pSyouhncd1,hT_SouseirituSyouhins1.get(0).getSyouhncd());
        Assert.assertEquals(pSyouhncd2,hT_SouseirituSyouhins1.get(1).getSyouhncd());
        Assert.assertEquals(pSyouhncd3,hT_SouseirituSyouhins1.get(2).getSyouhncd());
        Assert.assertEquals(3, hT_SouseirituSyouhins1.size());
    }

    @Test
    @TestOrder(70)
    public void getSouseirituDairiten() {

        String pSyono22 = "SYONO22";
        Integer pRenno1 = 1;
        Integer pRenno2 = 2;
        Integer pRenno3 = 3;

        HT_SouseirituKihon hT_SouseirituKihon1 = sinkeiyakuDomManager.getSouseirituKihon(pSyono22);
        List<HT_SouseirituDairiten> hT_SouseirituDairiten1 = hT_SouseirituKihon1.getSouseirituDairitens();
        Assert.assertEquals(pRenno1,hT_SouseirituDairiten1.get(0).getRenno());
        Assert.assertEquals(pRenno2,hT_SouseirituDairiten1.get(1).getRenno());
        Assert.assertEquals(pRenno3,hT_SouseirituDairiten1.get(2).getRenno());
        Assert.assertEquals(3, hT_SouseirituDairiten1.size());

    }

}
