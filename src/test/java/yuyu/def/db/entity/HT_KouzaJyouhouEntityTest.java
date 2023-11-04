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
 * 口座情報テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_KouzaJyouhouEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pBankcd1 = "1001";
        String pSitencd1 = "201";
        String pBankcd2 = "1002";
        String pSitencd2 = "202";

        bizDomManager.insert(new BM_Ginkou(pBankcd1, pSitencd1));
        bizDomManager.insert(new BM_Ginkou(pBankcd2, pSitencd2));

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");
        HT_KouzaJyouhou hT_KouzaJyouhou1 = hT_SyoriCTL1.createKouzaJyouhou();
        hT_KouzaJyouhou1.setBankcd(pBankcd1);
        hT_KouzaJyouhou1.setSitencd(pSitencd1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL("MOSNOD00002");
        HT_KouzaJyouhou hT_KouzaJyouhou2 = hT_SyoriCTL2.createKouzaJyouhou();
        hT_KouzaJyouhou2.setBankcd(pBankcd2);
        hT_KouzaJyouhou2.setSitencd(pSitencd2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL("MOSNOD00003");
        hT_SyoriCTL3.createKouzaJyouhou();

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGinkou() );
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
        HT_KouzaJyouhou hT_KouzaJyouhou1 = hT_SyoriCTL1.getKouzaJyouhou();

        Assert.assertEquals(pMosno1, hT_KouzaJyouhou1.getSyoriCTL().getMosno());
    }

    @Test
    @TestOrder(70)
    public void getGinkou() {

        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        String pBankcd1 = "1001";
        String pSitencd1 = "201";
        String pBankcd2 = "1002";
        String pSitencd2 = "202";

        Assert.assertEquals(bizDomManager.getGinkou(pBankcd1,pSitencd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKouzaJyouhou().getGinkou());
        Assert.assertEquals(bizDomManager.getGinkou(pBankcd2,pSitencd2), sinkeiyakuDomManager.getSyoriCTL(pMosno2).getKouzaJyouhou().getGinkou());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno3).getKouzaJyouhou().getGinkou());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getGinkouNull01() {

        String pBankcd2 = "1002";
        String pSitencd2 = "202";

        bizDomManager.delete(bizDomManager.getGinkou(pBankcd2,pSitencd2));
    }

    @Test
    @TestOrder(90)
    public void getGinkouNull02() {

        String pMosno1 = "MOSNOD00001";
        String pMosno2 = "MOSNOD00002";
        String pMosno3 = "MOSNOD00003";
        String pBankcd1 = "1001";
        String pSitencd1 = "201";

        Assert.assertEquals(bizDomManager.getGinkou(pBankcd1,pSitencd1), sinkeiyakuDomManager.getSyoriCTL(pMosno1).getKouzaJyouhou().getGinkou());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno2).getKouzaJyouhou().getGinkou());
        Assert.assertNull(sinkeiyakuDomManager.getSyoriCTL(pMosno3).getKouzaJyouhou().getGinkou());
    }

}
