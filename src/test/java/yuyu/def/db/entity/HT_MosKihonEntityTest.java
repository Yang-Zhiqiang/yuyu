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
 * 申込基本テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_MosKihonEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.insert(new BM_Syokugyou("001"));
        bizDomManager.insert(new BM_Syokugyou("002"));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_MosKihon hT_MosKihon1 = hT_SyoriCTL1.createMosKihon();
        hT_MosKihon1.setHhknsykgycd("001");
        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL("MOSNOD00002");
        HT_MosKihon hT_MosKihon2 = hT_SyoriCTL2.createMosKihon();
        hT_MosKihon2.setHhknsykgycd("002");
        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL("MOSNOD00003");
        hT_SyoriCTL3.createMosKihon();

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyokugyou());

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
        HT_MosKihon hT_MosKihon1 = hT_SyoriCTL1.getMosKihon();

        Assert.assertEquals(pMosno1, hT_MosKihon1.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getSyokugyou() {

        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        String pSyokugyoucd1 = "001";
        String pSyokugyoucd2 = "002";

        Assert.assertEquals(bizDomManager.getSyokugyou(pSyokugyoucd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosKihon().getSyokugyou());
        Assert.assertEquals(bizDomManager.getSyokugyou(pSyokugyoucd2), sinkeiyakuDomManager.getSyoriCTL(pMosno2).getMosKihon().getSyokugyou());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno3).getMosKihon().getSyokugyou());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getSyokugyouNull01() {

        bizDomManager.delete(bizDomManager.getSyokugyou("002"));
    }

    @Test
    @TestOrder(90)
    public void getSyokugyouNull02() {

        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        String pSyokugyoucd1 = "001";

        Assert.assertEquals(bizDomManager.getSyokugyou(pSyokugyoucd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getMosKihon().getSyokugyou());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno2).getMosKihon().getSyokugyou());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno3).getMosKihon().getSyokugyou());
    }
}
