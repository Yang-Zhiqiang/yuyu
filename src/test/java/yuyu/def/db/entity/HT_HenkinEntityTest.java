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

@RunWith(SWAKTestRunner.class)
public class HT_HenkinEntityTest {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private static final String pBankcd11 = "1111";
    private static final String pSitencd11 = "111";
    private static final String pBankcd22 = "2222";
    private static final String pSitencd22 = "222";

    private static final String pDenrenno11 = "De11";
    private static final Integer pEdano11 = 11;
    private static final String pDenrenno22 = "De22";
    private static final Integer pEdano22 = 22;

    private static final String pFbsoukindatasikibetukey11 = "fb11";
    private static final String pFbsoukindatasikibetukey22 = "fb22";

    private static final String pMosno1 = "MOSNO000001";

    private static final Integer pRenno1 = 11;
    private static final Integer pRenno2 = 22;
    private static final Integer pRenno3 = 33;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_Ginkou bm_ginkou1 = new BM_Ginkou();
        bm_ginkou1.setBankcd(pBankcd11);
        bm_ginkou1.setSitencd(pSitencd11);
        bizDomManager.insert(bm_ginkou1);

        HT_SkDenpyoData denpyou1 = new HT_SkDenpyoData();
        denpyou1.setDenrenno(pDenrenno11);
        denpyou1.setEdano(pEdano11);
        sinkeiyakuDomManager.insert(denpyou1);


        HT_SkFBSoukinData syokinData1 = new HT_SkFBSoukinData();
        syokinData1.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey11);
        sinkeiyakuDomManager.insert(syokinData1);

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData1 = new HT_SkGaikaFBSoukinData();
        hT_SkGaikaFBSoukinData1.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey11);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData1);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(pMosno1);

        HT_Henkin hT_Henkin1 = hT_SyoriCTL1.createHenkin();
        hT_Henkin1.setRenno(pRenno1);
        hT_Henkin1.setBankcd(pBankcd11);
        hT_Henkin1.setSitencd(pSitencd11);
        hT_Henkin1.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey11);
        hT_Henkin1.setDenrenno(pDenrenno11);
        hT_Henkin1.setEdano(pEdano11);

        HT_Henkin hT_Henkin2 = hT_SyoriCTL1.createHenkin();
        hT_Henkin2.setRenno(pRenno2);
        hT_Henkin2.setBankcd(pBankcd22);
        hT_Henkin2.setSitencd(pSitencd22);
        hT_Henkin2.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey22);
        hT_Henkin2.setDenrenno(pDenrenno22);
        hT_Henkin2.setEdano(pEdano22);

        HT_Henkin hT_Henkin3 = hT_SyoriCTL1.createHenkin();
        hT_Henkin3.setRenno(pRenno3);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);


        //        String pMosno2 = "MOSNO000002"; //$NON-NLS-1$
        //        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(pMosno2);
        //
        //        Integer pRenno3 = 33;
        //        HT_Henkin hT_Henkin1 = hT_SyoriCTL2.createHenkin();
        //        hT_Henkin1.setRenno(pRenno3);
        //
        //        sinkeiyakuDomManager.insert(hT_SyoriCTL2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGinkou());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkFBSoukinData());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkGaikaFBSoukinData());
    }

    @Test
    @TestOrder(60)
    public void getSyoriCTL() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_Henkin>  hT_Henkins = hT_SyoriCTL.getHenkins();
        HT_Henkin hT_Henkin = hT_Henkins.get(0);

        Assert.assertEquals(pMosno1, hT_Henkin.getSyoriCTL().getMosno());
    }

    @Test
    @TestOrder(70)
    public void getGinkou() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_Henkin> hT_Henkins = hT_SyoriCTL.getHenkins();
        HT_Henkin hT_Henkin = hT_Henkins.get(0);
        BM_Ginkou bM_Ginkou = hT_Henkin.getGinkou();

        Assert.assertEquals(pBankcd11, bM_Ginkou.getBankcd());
        Assert.assertEquals(pSitencd11, bM_Ginkou.getSitencd());
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void getGinkouNull01() {
        BM_Ginkou bM_Ginkou = bizDomManager.getGinkou(pBankcd11, pSitencd11);

        bizDomManager.delete(bM_Ginkou);
    }

    @Test
    @TestOrder(90)
    public void getGinkouNull02() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        List<HT_Henkin> hT_Henkins = hT_SyoriCTL.getHenkins();
        HT_Henkin hT_Henkin = hT_Henkins.get(0);

        BM_Ginkou bM_Ginkou = hT_Henkin.getGinkou();

        Assert.assertNull(bM_Ginkou);

        Assert.assertNull(hT_Henkins.get(1).getGinkou());
        Assert.assertNull(hT_Henkins.get(2).getGinkou());
    }

}
