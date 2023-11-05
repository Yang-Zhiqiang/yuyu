package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_Ginkou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 銀行マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGinkousByBankcdSitencdBanknmknSitennmkn {

    @Inject
    private BizDomManager bizDomManager;

    private final static String pBankcd1 = "1";
    private final static String pBankcd2 = "2";
    private final static String pBankcd3 = "3";
    private final static String pBankcd4 = "11";

    private final static String pSitencd1 = "8";
    private final static String pSitencd2 = "5";
    private final static String pSitencd3 = "88";

    private final static String pBanknmkn1 = "ア";
    private final static String pBanknmkn2 = "カ";
    private final static String pBanknmkn3 = "アア";

    private final static String pSitennmkn1 = "イ";
    private final static String pSitennmkn2 = "サ";
    private final static String pSitennmkn3 = "イイ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd3, pSitencd2,
                pBanknmkn2, pSitennmkn2);
        Assert.assertEquals(0, ginkouLst.size());

        BM_Ginkou ginkou1 = new BM_Ginkou();
        ginkou1.setBankcd("1222");
        ginkou1.setSitencd("811");
        ginkou1.setBanknmkn("アウウ");
        ginkou1.setSitennmkn("イエエ");
        bizDomManager.insert(ginkou1);

        BM_Ginkou ginkou2 = new BM_Ginkou();
        ginkou2.setBankcd("2111");
        ginkou2.setSitencd("188");
        ginkou2.setBanknmkn("ウアア");
        ginkou2.setSitennmkn("エイイ");
        bizDomManager.insert(ginkou2);

        BM_Ginkou ginkou3 = new BM_Ginkou();
        ginkou3.setBankcd("1222");
        ginkou3.setSitencd("818");
        ginkou3.setBanknmkn("ア");
        ginkou3.setSitennmkn("イ");
        bizDomManager.insert(ginkou3);

        BM_Ginkou ginkou4 = new BM_Ginkou();
        ginkou4.setBankcd("2111");
        ginkou4.setSitencd("189");
        ginkou4.setBanknmkn("ウ");
        ginkou4.setSitennmkn("エ");
        bizDomManager.insert(ginkou4);

        BM_Ginkou ginkou5 = new BM_Ginkou();
        ginkou5.setBankcd("1111");
        ginkou5.setSitencd("888");
        ginkou5.setBanknmkn("アアア");
        ginkou5.setSitennmkn("イイイ");
        bizDomManager.insert(ginkou5);

        BM_Ginkou ginkou6 = new BM_Ginkou();
        ginkou6.setBankcd("2222");
        ginkou6.setSitencd("111");
        ginkou6.setBanknmkn("ウウウ");
        ginkou6.setSitennmkn("エエエ");
        bizDomManager.insert(ginkou6);

        BM_Ginkou ginkou7 = new BM_Ginkou();
        ginkou7.setBankcd("3456");
        ginkou7.setSitencd("567");
        ginkou7.setBanknmkn("カキク");
        ginkou7.setSitennmkn("サシス");
        bizDomManager.insert(ginkou7);

        BM_Ginkou ginkou8 = new BM_Ginkou();
        ginkou8.setBankcd("4456");
        ginkou8.setSitencd("567");
        ginkou8.setBanknmkn("カキク");
        ginkou8.setSitennmkn("サシス");
        bizDomManager.insert(ginkou8);

        BM_Ginkou ginkou9 = new BM_Ginkou();
        ginkou9.setBankcd("3456");
        ginkou9.setSitencd("867");
        ginkou9.setBanknmkn("カキク");
        ginkou9.setSitennmkn("サシス");
        bizDomManager.insert(ginkou9);

        BM_Ginkou ginkou10 = new BM_Ginkou();
        ginkou10.setBankcd("3456");
        ginkou10.setSitencd("568");
        ginkou10.setBanknmkn("ケキク");
        ginkou10.setSitennmkn("サシス");
        bizDomManager.insert(ginkou10);

        BM_Ginkou ginkou11 = new BM_Ginkou();
        ginkou11.setBankcd("3456");
        ginkou11.setSitencd("569");
        ginkou11.setBanknmkn("カキク");
        ginkou11.setSitennmkn("ソシス");
        bizDomManager.insert(ginkou11);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd2, pSitencd1,
                pBanknmkn1, pSitennmkn1);
        Assert.assertEquals(0, ginkouLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<BM_Ginkou> ginkouLst1 = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd3, pSitencd2,
                pBanknmkn2, pSitennmkn2);
        Assert.assertEquals(1, ginkouLst1.size());
        Assert.assertEquals("3456", ginkouLst1.get(0).getBankcd());
        Assert.assertEquals("567", ginkouLst1.get(0).getSitencd());

        List<BM_Ginkou> ginkouLst2 = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd4, pSitencd3,
                pBanknmkn3, pSitennmkn3);
        Assert.assertEquals(1, ginkouLst2.size());
        Assert.assertEquals("1111", ginkouLst2.get(0).getBankcd());
        Assert.assertEquals("888", ginkouLst2.get(0).getSitencd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, pSitencd1,
                pBanknmkn1, pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn("", pSitencd1, pBanknmkn1,
                pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, "", pBanknmkn1,
                pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, pSitencd1, "",
                pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
    }

    @Test
    @TestOrder(70)
    public void blankCondition4() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, pSitencd1,
                pBanknmkn1, "");
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());

    }

    @Test
    @TestOrder(80)
    public void blankCondition5() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn("", "", "", "");
        Assert.assertEquals(11, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("2111", ginkouLst.get(3).getBankcd());
        Assert.assertEquals("2111", ginkouLst.get(4).getBankcd());
        Assert.assertEquals("2222", ginkouLst.get(5).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(6).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(7).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(8).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(9).getBankcd());
        Assert.assertEquals("4456", ginkouLst.get(10).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
        Assert.assertEquals("188", ginkouLst.get(3).getSitencd());
        Assert.assertEquals("189", ginkouLst.get(4).getSitencd());
        Assert.assertEquals("111", ginkouLst.get(5).getSitencd());
        Assert.assertEquals("567", ginkouLst.get(6).getSitencd());
        Assert.assertEquals("568", ginkouLst.get(7).getSitencd());
        Assert.assertEquals("569", ginkouLst.get(8).getSitencd());
        Assert.assertEquals("867", ginkouLst.get(9).getSitencd());
        Assert.assertEquals("567", ginkouLst.get(10).getSitencd());
    }

    @Test
    @TestOrder(90)
    public void nullCondition1() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(null, pSitencd1, pBanknmkn1,
                pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
    }

    @Test
    @TestOrder(100)
    public void nullCondition2() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, null, pBanknmkn1,
                pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
    }

    @Test
    @TestOrder(110)
    public void nullCondition3() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, pSitencd1, null,
                pSitennmkn1);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
    }

    @Test
    @TestOrder(120)
    public void nullCondition4() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd1, pSitencd1,
                pBanknmkn1, null);
        Assert.assertEquals(3, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());

    }

    @Test
    @TestOrder(130)
    public void nullCondition5() {
        List<BM_Ginkou> ginkouLst = bizDomManager.getGinkousByBankcdSitencdBanknmknSitennmkn(null, null, null, null);
        Assert.assertEquals(11, ginkouLst.size());
        Assert.assertEquals("1111", ginkouLst.get(0).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(1).getBankcd());
        Assert.assertEquals("1222", ginkouLst.get(2).getBankcd());
        Assert.assertEquals("2111", ginkouLst.get(3).getBankcd());
        Assert.assertEquals("2111", ginkouLst.get(4).getBankcd());
        Assert.assertEquals("2222", ginkouLst.get(5).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(6).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(7).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(8).getBankcd());
        Assert.assertEquals("3456", ginkouLst.get(9).getBankcd());
        Assert.assertEquals("4456", ginkouLst.get(10).getBankcd());
        Assert.assertEquals("888", ginkouLst.get(0).getSitencd());
        Assert.assertEquals("811", ginkouLst.get(1).getSitencd());
        Assert.assertEquals("818", ginkouLst.get(2).getSitencd());
        Assert.assertEquals("188", ginkouLst.get(3).getSitencd());
        Assert.assertEquals("189", ginkouLst.get(4).getSitencd());
        Assert.assertEquals("111", ginkouLst.get(5).getSitencd());
        Assert.assertEquals("567", ginkouLst.get(6).getSitencd());
        Assert.assertEquals("568", ginkouLst.get(7).getSitencd());
        Assert.assertEquals("569", ginkouLst.get(8).getSitencd());
        Assert.assertEquals("867", ginkouLst.get(9).getSitencd());
        Assert.assertEquals("567", ginkouLst.get(10).getSitencd());
    }

}
