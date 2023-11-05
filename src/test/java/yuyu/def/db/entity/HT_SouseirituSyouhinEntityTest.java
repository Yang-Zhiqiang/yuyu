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
public class HT_SouseirituSyouhinEntityTest implements EntityTestInterface {

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

        String pSyono1 = "SYONO1";
        String pSyono2 = "SYONO2";
        String pSyouhncd1 = "1111";
        String pSyouhncd2 = "2222";
        String pSyouhncd3 = "3333";
        Integer pSyouhnsdno1 = 11;
        Integer pSyouhnsdno2 = 22;
        Integer pSyouhnsdno3 = 33;

        BM_SyouhnZokusei bM_SyouhnZokusei1 = new BM_SyouhnZokusei(pSyouhncd1,pSyouhnsdno1);
        bizDomManager.insert(bM_SyouhnZokusei1);

        BM_SyouhnZokusei bM_SyouhnZokusei2 = new BM_SyouhnZokusei(pSyouhncd2,pSyouhnsdno2);
        bizDomManager.insert(bM_SyouhnZokusei2);

        HT_SouseirituKihon hT_SouseirituKihon1= new HT_SouseirituKihon(pSyono1);
        HT_SouseirituSyouhin hT_SouseirituSyouhin1 = hT_SouseirituKihon1.createSouseirituSyouhin();
        hT_SouseirituSyouhin1.setSyouhncd(pSyouhncd1);
        hT_SouseirituSyouhin1.setSyouhnsdno(pSyouhnsdno1);
        HT_SouseirituSyouhin hT_SouseirituSyouhin2 = hT_SouseirituKihon1.createSouseirituSyouhin();
        hT_SouseirituSyouhin2.setSyouhncd(pSyouhncd2);
        hT_SouseirituSyouhin2.setSyouhnsdno(pSyouhnsdno2);
        HT_SouseirituSyouhin hT_SouseirituSyouhin3 = hT_SouseirituKihon1.createSouseirituSyouhin();
        hT_SouseirituSyouhin3.setSyouhncd(pSyouhncd3);
        hT_SouseirituSyouhin3.setSyouhnsdno(pSyouhnsdno3);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon1);

        HT_SouseirituKihon hT_SouseirituKihon2= new HT_SouseirituKihon(pSyono2);
        HT_SouseirituSyouhin hT_SouseirituSyouhin4 = hT_SouseirituKihon2.createSouseirituSyouhin();
        hT_SouseirituSyouhin4.setSyouhncd(pSyouhncd1);
        sinkeiyakuDomManager.insert(hT_SouseirituKihon2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSouseirituKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

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
    public void getSyouhnZokusei() {

        String pSyono1 = "SYONO1";
        String pSyouhncd1 = "1111";
        String pSyouhncd2 = "2222";
        Integer pSyouhnsdno1 = 11;
        Integer pSyouhnsdno2 = 22;

        Assert.assertEquals(bizDomManager.getSyouhnZokusei(pSyouhncd1, pSyouhnsdno1), sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituSyouhins().get(0).getSyouhnZokusei());
        Assert.assertEquals(bizDomManager.getSyouhnZokusei(pSyouhncd2, pSyouhnsdno2), sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituSyouhins().get(1).getSyouhnZokusei());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituSyouhins().get(2).getSyouhnZokusei());
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void getSyouhnZokuseiNull01() {

        String pSyouhncd2 = "2222";
        Integer pSyouhnsdno2 = 22;

        sinkeiyakuDomManager.delete(bizDomManager.getSyouhnZokusei(pSyouhncd2,pSyouhnsdno2));
    }

    @Test
    @TestOrder(80)
    public void getSyouhnZokuseiNull02() {

        String pSyono1 = "SYONO1";
        String pSyouhncd1 = "1111";
        Integer pSyouhnsdno1 = 11;

        Assert.assertEquals(bizDomManager.getSyouhnZokusei(pSyouhncd1, pSyouhnsdno1), sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituSyouhins().get(0).getSyouhnZokusei());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituSyouhins().get(1).getSyouhnZokusei());

        Assert.assertNull(sinkeiyakuDomManager.getSouseirituKihon(pSyono1).getSouseirituSyouhins().get(2).getSyouhnZokusei());
    }

    @Test
    @TestOrder(90)
    public void getSouseirituKihon() {

        String pSyono1 = "SYONO1";

        HT_SouseirituKihon hT_SouseirituKihon = sinkeiyakuDomManager.getSouseirituKihon(pSyono1) ;
        HT_SouseirituSyouhin hT_SouseirituSyouhin = hT_SouseirituKihon.getSouseirituSyouhins().get(0);

        Assert.assertEquals(pSyono1, hT_SouseirituSyouhin.getSouseirituKihon().getSyono());
    }

}
