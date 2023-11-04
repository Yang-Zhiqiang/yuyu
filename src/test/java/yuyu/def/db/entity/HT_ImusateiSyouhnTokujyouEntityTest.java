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
 * 医務査定商品別特条条件付テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_ImusateiSyouhnTokujyouEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pSyouhncd2 = "SH01";
        Integer pSyouhnsdno2 = 11;

        bizDomManager.insert(new BM_SyouhnZokusei(pSyouhncd2, pSyouhnsdno2));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou = hT_SyoriCTL1.createImusateiSyouhnTokujyou();
        hT_ImusateiSyouhnTokujyou.setRenno(1);
        hT_ImusateiSyouhnTokujyou.setSyouhncd(pSyouhncd2);
        hT_ImusateiSyouhnTokujyou.setSyouhnsdno(pSyouhnsdno2);

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
    public void getSyoriCTL() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_ImusateiSyouhnTokujyou> hT_ImusateiSyouhnTokujyous1 = hT_SyoriCTL1.getImusateiSyouhnTokujyous();
        HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou1 = hT_ImusateiSyouhnTokujyous1.get(0);

        Assert.assertEquals(pMosno1, hT_ImusateiSyouhnTokujyou1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getSyouhnZokusei() {

        String pMosno1 = "MOSNOD00001";
        String pSyouhncd1 = "SH01";
        Integer pSyouhnsdno1 = 11;

        Assert.assertEquals(bizDomManager.getSyouhnZokusei(pSyouhncd1, pSyouhnsdno1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getImusateiSyouhnTokujyous().get(0).getSyouhnZokusei());
    }
}