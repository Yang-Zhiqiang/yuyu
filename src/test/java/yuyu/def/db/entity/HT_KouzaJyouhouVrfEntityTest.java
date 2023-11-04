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

@RunWith(SWAKTestRunner.class)
public class HT_KouzaJyouhouVrfEntityTest implements EntityTestInterface {

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
        BM_Ginkou bM_Ginkou1 = new BM_Ginkou(pBankcd1, pSitencd1);
        bizDomManager.insert(bM_Ginkou1);

        String pBankcd2 = "1002";
        String pSitencd2 = "202";

        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(pMosno3);

        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf1 = hT_SyoriCTL3.createKouzaJyouhouVrf();
        hT_KouzaJyouhouVrf1.setBankcd(pBankcd1);
        hT_KouzaJyouhouVrf1.setSitencd(pSitencd1);
        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        String pMosno2 = "MOSNO000002";
        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);

        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf2 = hT_SyoriCTL2.createKouzaJyouhouVrf();
        hT_KouzaJyouhouVrf2.setBankcd(pBankcd2);
        hT_KouzaJyouhouVrf2.setSitencd(pSitencd2);
        sinkeiyakuDomManager.insert(hT_SyoriCTL2);


        String pMosno1 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);
        hT_SyoriCTL1.createKouzaJyouhouVrf();
        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGinkou());
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

        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf = hT_SyoriCTL3.getKouzaJyouhouVrf();

        Assert.assertEquals(pMosno3, hT_KouzaJyouhouVrf.getSyoriCTL().getMosno());

    }

    @Test
    @TestOrder(70)
    public void getGinkou() {

        String pMosno3 = "MOSNO000003";
        String pBankcd1 = "1001";
        String pSitencd1 = "201";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf1 = hT_SyoriCTL1.getKouzaJyouhouVrf();
        BM_Ginkou bM_Ginkou1 = hT_KouzaJyouhouVrf1.getGinkou();

        Assert.assertEquals(pBankcd1, bM_Ginkou1.getBankcd());
        Assert.assertEquals(pSitencd1, bM_Ginkou1.getSitencd());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getGinkouNull01() {

        String pBankcd2 = "1001";
        String pSitencd2 = "201";
        BM_Ginkou bM_Ginkou2 = bizDomManager.getGinkou(pBankcd2, pSitencd2);

        bizDomManager.delete(bM_Ginkou2);

    }

    @Test
    @TestOrder(90)
    public void getGinkouNull02() {

        String pMosno1 = "MOSNO000001";
        HT_SyoriCTL hT_SyoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf1 = hT_SyoriCTL1.getKouzaJyouhouVrf();
        BM_Ginkou bM_Ginkou1 = hT_KouzaJyouhouVrf1.getGinkou();

        Assert.assertNull(bM_Ginkou1);

        String pMosno2 = "MOSNO000002";
        HT_SyoriCTL hT_SyoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(pMosno2);
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf2 = hT_SyoriCTL2.getKouzaJyouhouVrf();
        BM_Ginkou bM_Ginkou2 = hT_KouzaJyouhouVrf2.getGinkou();

        Assert.assertNull(bM_Ginkou2);

        String pMosno3 = "MOSNO000003";
        HT_SyoriCTL hT_SyoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(pMosno3);
        HT_KouzaJyouhouVrf hT_KouzaJyouhouVrf3 = hT_SyoriCTL3.getKouzaJyouhouVrf();
        BM_Ginkou bM_Ginkou3 = hT_KouzaJyouhouVrf3.getGinkou();

        Assert.assertNull(bM_Ginkou3);
    }

}
