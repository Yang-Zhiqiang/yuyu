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

/**
 * 特条テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_TokujyouEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.insert(new BM_HutanpoBui("11"));
        bizDomManager.insert(new BM_HutanpoBui("22"));
        bizDomManager.insert(new BM_HutanpoBui("33"));
        bizDomManager.insert(new BM_HutanpoBui("44"));
        bizDomManager.insert(new BM_HutanpoBui("111"));
        bizDomManager.insert(new BM_HutanpoBui("222"));
        bizDomManager.insert(new BM_HutanpoBui("333"));
        bizDomManager.insert(new BM_HutanpoBui("444"));


        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_Tokujyou hT_Tokujyou1 = hT_SyoriCTL1.createTokujyou();
        hT_Tokujyou1.setHtnpbuicd1("11");
        hT_Tokujyou1.setHtnpbuicd2("22");
        hT_Tokujyou1.setHtnpbuicd3("33");
        hT_Tokujyou1.setHtnpbuicd4("44");

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);


        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL("MOSNOD00002");

        HT_Tokujyou hT_Tokujyou2 = hT_SyoriCTL2.createTokujyou();
        hT_Tokujyou2.setHtnpbuicd1("111");
        hT_Tokujyou2.setHtnpbuicd2("222");
        hT_Tokujyou2.setHtnpbuicd3("333");
        hT_Tokujyou2.setHtnpbuicd4("444");

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);


        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL("MOSNOD00003");

        hT_SyoriCTL3.createTokujyou();

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHutanpoBui());

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
        HT_Tokujyou hT_Tokujyou = hT_SyoriCTL1.getTokujyou();

        Assert.assertEquals(pMosno1, hT_Tokujyou.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getHutanpoBui1() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("11"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui1());
        Assert.assertEquals(bizDomManager.getHutanpoBui("111"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui1());

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getHutanpoBui1Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("111"));
    }

    @Test
    @TestOrder(90)
    public void getHutanpoBui1Null02() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("11"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui1());

    }

    @Test
    @TestOrder(100)
    public void getHutanpoBui2() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("22"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui2());
        Assert.assertEquals(bizDomManager.getHutanpoBui("222"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui2());

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void getHutanpoBui2Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("222"));
    }

    @Test
    @TestOrder(120)
    public void getHutanpoBui2Null02() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("22"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui2());

    }

    @Test
    @TestOrder(130)
    public void getHutanpoBui3() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("33"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui3());
        Assert.assertEquals(bizDomManager.getHutanpoBui("333"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui3());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui3());

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void getHutanpoBui3Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("333"));
    }

    @Test
    @TestOrder(150)
    public void getHutanpoBui3Null02() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("33"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui3());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui3());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui3());

    }

    @Test
    @TestOrder(160)
    public void getHutanpoBui4() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("44"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui4());
        Assert.assertEquals(bizDomManager.getHutanpoBui("444"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui4());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui4());

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void getHutanpoBui4Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("444"));
    }

    @Test
    @TestOrder(180)
    public void getHutanpoBui4Null02() {

        Assert.assertEquals(bizDomManager.getHutanpoBui("44"), sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getTokujyou().getHutanpoBui4());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00002").getTokujyou().getHutanpoBui4());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL("MOSNOD00003").getTokujyou().getHutanpoBui4());

    }
}