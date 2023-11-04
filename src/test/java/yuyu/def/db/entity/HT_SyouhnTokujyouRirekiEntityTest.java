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
 * 商品別特条条件付履歴テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyouhnTokujyouRirekiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pSyouhncd1 = "SH01";
        Integer pSyouhnsdno1 = 11;

        bizDomManager.insert(new BM_SyouhnZokusei(pSyouhncd1, pSyouhnsdno1));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_DakuhiKettei hT_DakuhiKettei = hT_SyoriCTL1.createDakuhiKettei();
        hT_DakuhiKettei.setDakuhiktrenno(1);

        HT_SyouhnTokujyouRireki hT_SyouhnTokujyouRireki1 = hT_DakuhiKettei.createSyouhnTokujyouRireki();
        hT_SyouhnTokujyouRireki1.setSyouhncd(pSyouhncd1);
        hT_SyouhnTokujyouRireki1.setSyouhnsdno(pSyouhnsdno1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
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
    public void getDakuhiKettei() {

        HT_DakuhiKettei hT_DakuhiKettei1 = sinkeiyakuDomManager.getSyoriCTL("MOSNOD00001").getDakuhiKetteis().get(0);
        HT_SyouhnTokujyouRireki hT_SyouhnTokujyouRireki = hT_DakuhiKettei1.getSyouhnTokujyouRirekis().get(0);

        HT_DakuhiKettei hT_DakuhiKettei = hT_SyouhnTokujyouRireki.getDakuhiKettei();

        Assert.assertEquals("MOSNOD00001", hT_DakuhiKettei.getMosno());
        Assert.assertEquals(1, hT_DakuhiKettei.getDakuhiktrenno().intValue());

    }

    @Test
    @TestOrder(70)
    public void getSyouhnZokusei() {

        String pMosno1 = "MOSNOD00001";
        String pSyouhncd = "SH01";
        Integer pSyouhnsdno1 = 11;

        Assert.assertEquals(bizDomManager.getSyouhnZokusei(pSyouhncd,pSyouhnsdno1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getDakuhiKetteis().get(0).getSyouhnTokujyouRirekis().get(0).getSyouhnZokusei());

    }
}