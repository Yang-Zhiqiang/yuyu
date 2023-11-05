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
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 諾否決定テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_DakuhiKetteiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @Inject
    private BizDomManager bizDomManager;

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
        sinkeiyakuDomManager.insert(new HM_KetteiSya("333"));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_DakuhiKettei hT_DakuhiKettei1 = hT_SyoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei1.setDakuhiktrenno(1);
        hT_DakuhiKettei1.setSyoubyoucd1("11");
        hT_DakuhiKettei1.setSyoubyoucd2("22");
        hT_DakuhiKettei1.setKetsyacd("33");

        HT_SonotaTkykJktkRireki hT_SonotaTkykJktkRireki1 = hT_DakuhiKettei1.createSonotaTkykJktkRireki();
        hT_SonotaTkykJktkRireki1.setPmnjtkkbn(C_PmnjtkKbn.SANDAISIPPMNJTOK);
        HT_SonotaTkykJktkRireki hT_SonotaTkykJktkRireki2 = hT_DakuhiKettei1.createSonotaTkykJktkRireki();
        hT_SonotaTkykJktkRireki2.setPmnjtkkbn(C_PmnjtkKbn.NONE);

        HT_SyouhnTokujyouRireki hT_SyouhnTokujyouRireki1 = hT_DakuhiKettei1.createSyouhnTokujyouRireki();
        hT_SyouhnTokujyouRireki1.setSyouhncd("bbb");
        HT_SyouhnTokujyouRireki hT_SyouhnTokujyouRireki2 = hT_DakuhiKettei1.createSyouhnTokujyouRireki();
        hT_SyouhnTokujyouRireki2.setSyouhncd("aaa");

        hT_DakuhiKettei1.createTokujyouRireki();

        HT_DakuhiKettei hT_DakuhiKettei2 = hT_SyoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei2.setDakuhiktrenno(2);
        hT_DakuhiKettei2.setSyoubyoucd1("111");
        hT_DakuhiKettei2.setSyoubyoucd2("222");
        hT_DakuhiKettei2.setKetsyacd("333");

        HT_DakuhiKettei hT_DakuhiKettei3 = hT_SyoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei3.setDakuhiktrenno(3);

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
    public void getSyoriCTL() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_DakuhiKettei> hT_DakuhiKetteis1 = hT_SyoriCTL1.getDakuhiKetteis();
        HT_DakuhiKettei hT_DakuhiKettei1 = hT_DakuhiKetteis1.get(0);

        Assert.assertEquals(pMosno1, hT_DakuhiKettei1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getKetteiSya() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("33"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getKetteiSya());
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("333"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(1).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(2).getKetteiSya());

    }
    @Test
    @TestOrder(71)
    @Transactional
    public void getKetteiSyaNull01() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getKetteiSya("333"));

    }

    @Test
    @TestOrder(72)
    public void getKetteiSyaNull02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("33"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(1).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(2).getKetteiSya());

    }

    @Test
    @TestOrder(80)
    public void getSyoubyou1() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSyoubyou1());
        Assert.assertEquals(bizDomManager.getSyoubyou("111"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(1).getSyoubyou1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(2).getSyoubyou1());

    }

    @Test
    @TestOrder(81)
    @Transactional
    public void getSyoubyou1Null01() {

        bizDomManager.delete(bizDomManager.getSyoubyou("111"));

    }

    @Test
    @TestOrder(82)
    public void getSyoubyou1Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSyoubyou1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(1).getSyoubyou1());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(2).getSyoubyou1());

    }



    @Test
    @TestOrder(90)
    public void getSyoubyou2() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSyoubyou2());
        Assert.assertEquals(bizDomManager.getSyoubyou("222"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(1).getSyoubyou2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(2).getSyoubyou2());

    }

    @Test
    @TestOrder(91)
    @Transactional
    public void getSyoubyou2Null01() {

        bizDomManager.delete(bizDomManager.getSyoubyou("222"));

    }

    @Test
    @TestOrder(92)
    public void getSyoubyou2Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(bizDomManager.getSyoubyou("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSyoubyou2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(1).getSyoubyou2());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(2).getSyoubyou2());

    }

    @Test
    @TestOrder(100)
    public void getSonotaTkykJktkRireki() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_DakuhiKettei> hT_DakuhiKetteis1 = hT_SyoriCTL1.getDakuhiKetteis();
        HT_DakuhiKettei hT_DakuhiKettei1 = hT_DakuhiKetteis1.get(0);

        List<HT_SonotaTkykJktkRireki> hT_SonotaTkykJktkRireki = hT_DakuhiKettei1.getSonotaTkykJktkRirekis();
        Assert.assertEquals(2, hT_SonotaTkykJktkRireki.size());


        Assert.assertEquals(pMosno1, hT_SonotaTkykJktkRireki.get(0).getMosno());
        Assert.assertEquals(1, hT_SonotaTkykJktkRireki.get(0).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.NONE, hT_SonotaTkykJktkRireki.get(0).getPmnjtkkbn());
        Assert.assertEquals(pMosno1, hT_SonotaTkykJktkRireki.get(1).getMosno());
        Assert.assertEquals(1, hT_SonotaTkykJktkRireki.get(1).getDakuhiktrenno().intValue());
        Assert.assertEquals(C_PmnjtkKbn.SANDAISIPPMNJTOK, hT_SonotaTkykJktkRireki.get(1).getPmnjtkkbn());

        Assert.assertEquals(0, hT_DakuhiKetteis1.get(1).getSonotaTkykJktkRirekis().size());
        Assert.assertEquals(0, hT_DakuhiKetteis1.get(2).getSonotaTkykJktkRirekis().size());
    }

    @Test
    @TestOrder(110)
    public void ToHT_SyouhnTokujyouRireki() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_DakuhiKettei> hT_DakuhiKetteis1 = hT_SyoriCTL1.getDakuhiKetteis();
        HT_DakuhiKettei hT_DakuhiKettei1 = hT_DakuhiKetteis1.get(0);

        List<HT_SyouhnTokujyouRireki> hT_SyouhnTokujyouRireki = hT_DakuhiKettei1.getSyouhnTokujyouRirekis();
        Assert.assertEquals(2, hT_SyouhnTokujyouRireki.size());

        Assert.assertEquals(pMosno1, hT_SyouhnTokujyouRireki.get(0).getMosno());
        Assert.assertEquals(1, hT_SyouhnTokujyouRireki.get(0).getDakuhiktrenno().intValue());
        Assert.assertEquals("aaa", hT_SyouhnTokujyouRireki.get(0).getSyouhncd());
        Assert.assertEquals(pMosno1, hT_SyouhnTokujyouRireki.get(1).getMosno());
        Assert.assertEquals(1, hT_SyouhnTokujyouRireki.get(1).getDakuhiktrenno().intValue());
        Assert.assertEquals("bbb", hT_SyouhnTokujyouRireki.get(1).getSyouhncd());

        Assert.assertEquals(0, hT_DakuhiKetteis1.get(1).getSyouhnTokujyouRirekis().size());
        Assert.assertEquals(0, hT_DakuhiKetteis1.get(2).getSyouhnTokujyouRirekis().size());

    }

    @Test
    @TestOrder(120)
    public void ToHT_TokujyouRireki() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_DakuhiKettei> hT_DakuhiKetteis1 = hT_SyoriCTL1.getDakuhiKetteis();
        HT_DakuhiKettei hT_DakuhiKettei1 = hT_DakuhiKetteis1.get(0);

        HT_TokujyouRireki hT_TokujyouRireki = hT_DakuhiKettei1.getTokujyouRireki();

        Assert.assertEquals(pMosno1, hT_TokujyouRireki.getMosno());
        Assert.assertEquals(1, hT_TokujyouRireki.getDakuhiktrenno().intValue());

    }

}