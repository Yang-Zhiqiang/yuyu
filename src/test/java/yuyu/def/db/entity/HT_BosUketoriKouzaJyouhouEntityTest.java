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
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_BosUketoriKouzaJyouhouEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String pBankcd1 = "1111";
        String pSitencd1 = "111";
        BM_Ginkou bM_Ginkou2 = new BM_Ginkou(pBankcd1,pSitencd1);
        bizDomManager.insert(bM_Ginkou2);

        String pBankcd2 = "2222";
        String pSitencd2 = "222";
        BM_Ginkou bM_Ginkou1 = new BM_Ginkou(pBankcd2,pSitencd2);
        bizDomManager.insert(bM_Ginkou1);

        String pMosno3 = "MOSNO3";
        C_UketorikouzasyubetuKbn UketorikouzasyubetuKbn3 = C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN;
        C_UketorikouzasyubetuKbn UketorikouzasyubetuKbn2 = C_UketorikouzasyubetuKbn.BLNK;

        HT_BosKihon hT_BosKihon3 = new HT_BosKihon(pMosno3);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou33 = hT_BosKihon3.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou33.setUktkzsyubetukbn(UketorikouzasyubetuKbn3);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou32 = hT_BosKihon3.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou32.setUktkzsyubetukbn(UketorikouzasyubetuKbn2);
        sinkeiyakuDomManager.insert(hT_BosKihon3);

        String pMosno2 = "MOSNO2";
        HT_BosKihon hT_BosKihon2 = new HT_BosKihon(pMosno2);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou2 = hT_BosKihon2.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou2.setUktkzsyubetukbn(UketorikouzasyubetuKbn3);
        hT_BosUketoriKouzaJyouhou2.setBankcd(pBankcd2);
        hT_BosUketoriKouzaJyouhou2.setSitencd(pSitencd2);
        sinkeiyakuDomManager.insert(hT_BosKihon2);

        String pMosno1 = "MOSNO1";
        HT_BosKihon hT_BosKihon1 = new HT_BosKihon(pMosno1);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou1 = hT_BosKihon1.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou1.setUktkzsyubetukbn(UketorikouzasyubetuKbn2);
        hT_BosUketoriKouzaJyouhou1.setBankcd(pBankcd1);
        hT_BosUketoriKouzaJyouhou1.setSitencd(pSitencd1);
        sinkeiyakuDomManager.insert(hT_BosKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());
        bizDomManager.delete(bizDomManager.getAllGinkou());

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
    public void getBosKihon() {

        String pMosno3 = "MOSNO3";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno3) ;
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou = hT_BosKihon.getBosUketoriKouzaJyouhous().get(0);
        HT_BosKihon result_hT_BosKihon = hT_BosUketoriKouzaJyouhou.getBosKihon();

        Assert.assertEquals(pMosno3, result_hT_BosKihon.getMosno());
    }

    @Test
    @TestOrder(70)
    public void getGinkou() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String pBankcd2 = "2222";
        String pSitencd2 = "222";
        String pBankcd1 = "1111";
        String pSitencd1 = "111";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno2);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou = hT_BosKihon.getBosUketoriKouzaJyouhous().get(0);

        Assert.assertEquals(bizDomManager.getGinkou(pBankcd2, pSitencd2), hT_BosUketoriKouzaJyouhou.getGinkou());

        HT_BosKihon hT_BosKihon1 = sinkeiyakuDomManager.getBosKihon(pMosno1);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou1 = hT_BosKihon1.getBosUketoriKouzaJyouhous().get(0);

        Assert.assertEquals(bizDomManager.getGinkou(pBankcd1, pSitencd1),hT_BosUketoriKouzaJyouhou1.getGinkou());

        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosUketoriKouzaJyouhous().get(0).getGinkou());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getGinkouNull01() {

        String pBankcd1 = "1111";
        String pSitencd1 = "111";

        bizDomManager.delete(bizDomManager.getGinkou(pBankcd1,pSitencd1));
    }

    @Test
    @TestOrder(90)
    public void getGinkouNull02() {

        String pMosno2 = "MOSNO2";
        String pMosno1 = "MOSNO1";
        String pMosno3 = "MOSNO3";
        String pBankcd2 = "2222";
        String pSitencd2 = "222";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno2);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou = hT_BosKihon.getBosUketoriKouzaJyouhous().get(0);

        Assert.assertEquals(bizDomManager.getGinkou(pBankcd2, pSitencd2), hT_BosUketoriKouzaJyouhou.getGinkou());

        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno1).getBosUketoriKouzaJyouhous().get(0).getGinkou());

        Assert.assertNull(sinkeiyakuDomManager.getBosKihon(pMosno3).getBosUketoriKouzaJyouhous().get(0).getGinkou());
    }
}
