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
 * 医務査定特条テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_ImusateiTokujyouEntityTest implements EntityTestInterface {

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

        HT_ImusateiTokujyou hT_ImusateiTokujyou1 = hT_SyoriCTL1.createImusateiTokujyou();
        hT_ImusateiTokujyou1.setRenno(1);
        hT_ImusateiTokujyou1.setHtnpbuicd1("11");
        hT_ImusateiTokujyou1.setHtnpbuicd2("22");
        hT_ImusateiTokujyou1.setHtnpbuicd3("33");
        hT_ImusateiTokujyou1.setHtnpbuicd4("44");

        HT_ImusateiTokujyou hT_ImusateiTokujyou2 = hT_SyoriCTL1.createImusateiTokujyou();
        hT_ImusateiTokujyou2.setRenno(2);
        hT_ImusateiTokujyou2.setHtnpbuicd1("111");
        hT_ImusateiTokujyou2.setHtnpbuicd2("222");
        hT_ImusateiTokujyou2.setHtnpbuicd3("333");
        hT_ImusateiTokujyou2.setHtnpbuicd4("444");

        HT_ImusateiTokujyou hT_ImusateiTokujyou3 = hT_SyoriCTL1.createImusateiTokujyou();
        hT_ImusateiTokujyou3.setRenno(3);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
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
        List<HT_ImusateiTokujyou> hT_ImusateiTokujyous = hT_SyoriCTL1.getImusateiTokujyous();

        Assert.assertEquals(pMosno1, hT_ImusateiTokujyous.get(0).getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getHutanpoBui1() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui1());
        Assert.assertEquals(bizDomManager.getHutanpoBui("111"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui1());

    }

    @Test
    @TestOrder(71)
    @Transactional
    public void getHutanpoBui1Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("111"));

    }

    @Test
    @TestOrder(72)
    public void getHutanpoBui1Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui1());

    }

    @Test
    @TestOrder(80)
    public void getHutanpoBui2() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui2());
        Assert.assertEquals(bizDomManager.getHutanpoBui("222"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui2());
    }

    @Test
    @TestOrder(81)
    @Transactional
    public void getHutanpoBui2Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("222"));

    }

    @Test
    @TestOrder(82)
    public void getHutanpoBui2Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui2());

    }

    @Test
    @TestOrder(90)
    public void getHutanpoBui3() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("33"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui3());
        Assert.assertEquals(bizDomManager.getHutanpoBui("333"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui3());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui3());

    }

    @Test
    @TestOrder(91)
    @Transactional
    public void getHutanpoBui3Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("333"));

    }

    @Test
    @TestOrder(92)
    public void getHutanpoBui3Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("33"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui3());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui3());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui3());


    }

    @Test
    @TestOrder(100)
    public void getHutanpoBui4() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("44"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui4());
        Assert.assertEquals(bizDomManager.getHutanpoBui("444"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui4());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui4());
    }

    @Test
    @TestOrder(101)
    @Transactional
    public void getHutanpoBui4Null01() {

        bizDomManager.delete(bizDomManager.getHutanpoBui("444"));

    }

    @Test
    @TestOrder(102)
    public void getHutanpoBui4Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getHutanpoBui("44"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(0).getHutanpoBui4());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(1).getHutanpoBui4());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiTokujyous().get(2).getHutanpoBui4());

    }
}