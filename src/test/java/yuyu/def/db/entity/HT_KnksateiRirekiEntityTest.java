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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 環境査定履歴テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_KnksateiRirekiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.insert(new HM_KetteiSya("11"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("22"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("111"));
        sinkeiyakuDomManager.insert(new HM_KetteiSya("222"));


        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_KnksateiRireki hT_KnksateiRireki1 = hT_SyoriCTL1.createKnksateiRireki();
        hT_KnksateiRireki1.setRenno(1);
        hT_KnksateiRireki1.setTnsketsyacd("11");
        hT_KnksateiRireki1.setKetsyacd("22");

        HT_KnksateiRireki hT_KnksateiRireki2 = hT_SyoriCTL1.createKnksateiRireki();
        hT_KnksateiRireki2.setRenno(2);
        hT_KnksateiRireki2.setTnsketsyacd("111");
        hT_KnksateiRireki2.setKetsyacd("222");

        HT_KnksateiRireki hT_KnksateiRireki3 = hT_SyoriCTL1.createKnksateiRireki();
        hT_KnksateiRireki3.setRenno(3);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

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
        List<HT_KnksateiRireki> hT_KnksateiRirekis1 = hT_SyoriCTL1.getKnksateiRirekis();
        HT_KnksateiRireki hT_KnksateiRireki1 = hT_KnksateiRirekis1.get(0);

        Assert.assertEquals(pMosno1, hT_KnksateiRireki1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getKetteiSya1() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(0).getTensousakiKetteiSya());
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("111"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(1).getTensousakiKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(2).getTensousakiKetteiSya());

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getKetteiSya1Null01() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getKetteiSya("111"));

    }

    @Test
    @TestOrder(90)
    public void getKetteiSya1Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("11"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(0).getTensousakiKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(1).getTensousakiKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(2).getTensousakiKetteiSya());

    }


    @Test
    @TestOrder(100)
    public void getKetteiSya2() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(0).getKetteiSya());
        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("222"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(1).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(2).getKetteiSya());

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void getKetteiSya2Null01() {

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getKetteiSya("222"));

    }

    @Test
    @TestOrder(120)
    public void getKetteiSya2Null02() {

        String pMosno1 = "MOSNOD00001";

        Assert.assertEquals(sinkeiyakuDomManager.getKetteiSya("22"), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(0).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(1).getKetteiSya());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKnksateiRirekis().get(2).getKetteiSya());

    }
}