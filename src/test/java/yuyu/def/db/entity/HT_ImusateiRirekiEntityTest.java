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
 * 医務査定履歴テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_ImusateiRirekiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        bizDomManager.insert(new BM_Syoubyou("11"));
        bizDomManager.insert(new BM_Syoubyou("22"));
        bizDomManager.insert(new BM_Syoubyou("111"));
        bizDomManager.insert(new BM_Syoubyou("222"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("33"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("44"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("333"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("444"));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_ImusateiRireki hT_ImusateiRireki1 = hT_SyoriCTL1.createImusateiRireki();
        hT_ImusateiRireki1.setRenno(1);
        hT_ImusateiRireki1.setSyoubyoucd1("11");
        hT_ImusateiRireki1.setSyoubyoucd2("22");
        hT_ImusateiRireki1.setTnsketsyacd("33");
        hT_ImusateiRireki1.setKetsyacd("44");

        HT_ImusateiRireki hT_ImusateiRireki2 = hT_SyoriCTL1.createImusateiRireki();
        hT_ImusateiRireki2.setRenno(2);
        hT_ImusateiRireki2.setSyoubyoucd1("111");
        hT_ImusateiRireki2.setSyoubyoucd2("222");
        hT_ImusateiRireki2.setTnsketsyacd("333");
        hT_ImusateiRireki2.setKetsyacd("444");

        HT_ImusateiRireki hT_ImusateiRireki3 = hT_SyoriCTL1.createImusateiRireki();
        hT_ImusateiRireki3.setRenno(3);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyoubyou());
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
    public void ToHT_SyoriCTL() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_ImusateiRireki> hT_ImusateiRirekis1 = hT_SyoriCTL1.getImusateiRirekis();
        HT_ImusateiRireki hT_ImusateiRireki1 = hT_ImusateiRirekis1.get(0);

        Assert.assertEquals(pMosno1, hT_ImusateiRireki1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getKetteiSya1() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("33"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getTensousakiKetteiSya());
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("333"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getTensousakiKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getTensousakiKetteiSya());

    }

    @Test
    @TestOrder(71)
    @Transactional
    public void getKetteiSya1Null01() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getKetteiSya("333"));

    }

    @Test
    @TestOrder(72)
    public void getKetteiSya1Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("33"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getTensousakiKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getTensousakiKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getTensousakiKetteiSya());
    }


    @Test
    @TestOrder(80)
    public void getKetteiSya8() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("44"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getKetteiSya());
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("444"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getKetteiSya());

    }

    @Test
    @TestOrder(81)
    @Transactional
    public void getKetteiSya2Null01() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getKetteiSya("444"));

    }

    @Test
    @TestOrder(82)
    public void getKetteiSya2Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("44"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getKetteiSya());
    }


    @Test
    @TestOrder(90)
    public void getSyoubyou1() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getSyoubyou1());
        Assert.assertEquals(bizDomManager.getSyoubyou("111"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getSyoubyou1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getSyoubyou1());

    }

    @Test
    @TestOrder(91)
    @Transactional
    public void getSyoubyou1Null01() {

        sinkeiyakuDomManager.delete(bizDomManager.getSyoubyou("111"));

    }

    @Test
    @TestOrder(92)
    public void getSyoubyou1Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getSyoubyou1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getSyoubyou1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getSyoubyou1());
    }


    @Test
    @TestOrder(100)
    public void getSyoubyou2() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getSyoubyou2());
        Assert.assertEquals(bizDomManager.getSyoubyou("222"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getSyoubyou2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getSyoubyou2());

    }

    @Test
    @TestOrder(91)
    @Transactional
    public void getSyoubyou2Null01() {

        sinkeiyakuDomManager.delete(bizDomManager.getSyoubyou("222"));

    }

    @Test
    @TestOrder(92)
    public void getSyoubyou2Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(0).getSyoubyou2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(1).getSyoubyou2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiRirekis().get(2).getSyoubyou2());
    }

}