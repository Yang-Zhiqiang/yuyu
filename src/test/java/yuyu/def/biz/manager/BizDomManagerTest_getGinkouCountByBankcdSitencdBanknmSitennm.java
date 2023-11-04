package yuyu.def.biz.manager;

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
 * 業務共通<br />
 * 銀行支店検索<br />
 * 銀行マスタエンティティ件数取得　銀行名　支店名複数のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGinkouCountByBankcdSitencdBanknmSitennm {

    @Inject
    private BizDomManager bizDomManager;

    private final static String[] bankcd1 = {"0111", "0000"};
    private final static String[] bankcd2 = {"0000", "2345"};
    private final static String[] bankcd3 = {"2345", "2346", "2347"};
    private final static String[] bankcd4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "一", "三", bankcd3);
        Assert.assertEquals(0, counts);

        BM_Ginkou ginkou1 = new BM_Ginkou("0111", "100");
        ginkou1.setBanknmkn("アイイ");
        ginkou1.setSitennmkn("カキキ");
        ginkou1.setBanknmkj("一二二");
        ginkou1.setSitennmkj("三四四");

        bizDomManager.insert(ginkou1);

        BM_Ginkou ginkou2 = new BM_Ginkou("1000", "011");
        ginkou2.setBanknmkn("イアア");
        ginkou2.setSitennmkn("キカカ");
        ginkou2.setBanknmkj("二一一");
        ginkou2.setSitennmkj("四三三");

        bizDomManager.insert(ginkou2);

        BM_Ginkou ginkou3 = new BM_Ginkou("0000", "111");
        ginkou3.setBanknmkn("ア");
        ginkou3.setSitennmkn("カ");
        ginkou3.setBanknmkj("一");
        ginkou3.setSitennmkj("三");

        bizDomManager.insert(ginkou3);

        BM_Ginkou ginkou4 = new BM_Ginkou("1111", "000");
        ginkou4.setBanknmkn("イ");
        ginkou4.setSitennmkn("キ");
        ginkou4.setBanknmkj("二");
        ginkou4.setSitennmkj("四");

        bizDomManager.insert(ginkou4);

        BM_Ginkou ginkou5 = new BM_Ginkou("0000", "110");
        ginkou5.setBanknmkn("アアア");
        ginkou5.setSitennmkn("カカカ");
        ginkou5.setBanknmkj("一一一");
        ginkou5.setSitennmkj("三三三");

        bizDomManager.insert(ginkou5);

        BM_Ginkou ginkou6 = new BM_Ginkou("1110", "001");
        ginkou6.setBanknmkn("イイイ");
        ginkou6.setSitennmkn("キキキ");
        ginkou6.setBanknmkj("二二二");
        ginkou6.setSitennmkj("四四四");

        bizDomManager.insert(ginkou6);

        BM_Ginkou ginkou7 = new BM_Ginkou("2345", "456");
        ginkou7.setBanknmkn("カキク");
        ginkou7.setSitennmkn("ハヒウ");
        ginkou7.setBanknmkj("三四五");
        ginkou7.setSitennmkj("六七八");

        bizDomManager.insert(ginkou7);

        BM_Ginkou ginkou8 = new BM_Ginkou("4567", "456");
        ginkou8.setBanknmkn("カキク");
        ginkou8.setSitennmkn("ハヒウ");
        ginkou8.setBanknmkj("三四五");
        ginkou8.setSitennmkj("六七八");

        bizDomManager.insert(ginkou8);

        BM_Ginkou ginkou9 = new BM_Ginkou("2345", "789");
        ginkou9.setBanknmkn("カキク");
        ginkou9.setSitennmkn("ハヒウ");
        ginkou9.setBanknmkj("三四五");
        ginkou9.setSitennmkj("六七八");

        bizDomManager.insert(ginkou9);

        BM_Ginkou ginkou10 = new BM_Ginkou("2345", "457");
        ginkou10.setBanknmkn("クキカ");
        ginkou10.setSitennmkn("ハヒウ");
        ginkou10.setBanknmkj("三四五");
        ginkou10.setSitennmkj("六七八");

        bizDomManager.insert(ginkou10);

        BM_Ginkou ginkou11 = new BM_Ginkou("2345", "458");
        ginkou11.setBanknmkn("カキク");
        ginkou11.setSitennmkn("ウヒハ");
        ginkou11.setBanknmkj("三四五");
        ginkou11.setSitennmkj("六七八");

        bizDomManager.insert(ginkou11);

        BM_Ginkou ginkou12 = new BM_Ginkou("2345", "459");
        ginkou12.setBanknmkn("カキク");
        ginkou12.setSitennmkn("ハヒウ");
        ginkou12.setBanknmkj("五四三");
        ginkou12.setSitennmkj("六七八");

        bizDomManager.insert(ginkou12);

        BM_Ginkou ginkou13 = new BM_Ginkou("2345", "460");
        ginkou13.setBanknmkn("カキク");
        ginkou13.setSitennmkn("ハヒウ");
        ginkou13.setBanknmkj("三四五");
        ginkou13.setSitennmkj("八七六");

        bizDomManager.insert(ginkou13);

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
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "一", "三", bankcd1);
        Assert.assertEquals(0, counts);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("00", "11", "アア", "カカ", "一一", "三三", bankcd3);
        Assert.assertEquals(1, counts);

        long counts1 = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("2", "4", "カ", "ハ", "三", "六", bankcd1);
        Assert.assertEquals(1, counts1);
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "一", "三", bankcd3);
        Assert.assertEquals(3, counts);
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("", "1", "ア", "カ", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(50)
    public void nullCondition1() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm(null, "1", "ア", "カ", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(60)
    public void blankCondition2() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "", "ア", "カ", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(70)
    public void nullCondition2() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", null, "ア", "カ", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(80)
    public void blankCondition3() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "", "カ", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(90)
    public void nullCondition3() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", null, "カ", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(100)
    public void blankCondition4() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "", "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(110)
    public void nullCondition4() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", null, "一", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(120)
    public void blankCondition5() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "", "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(130)
    public void nullCondition5() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", null, "三", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(140)
    public void blankCondition6() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "一", "", bankcd2);
        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(150)
    public void nullCondition6() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "一", null, bankcd2);
        Assert.assertEquals(1, counts);

    }

    @Test
    @TestOrder(160)
    public void blankCondition7() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("0", "1", "ア", "カ", "一", "三", bankcd4);
        Assert.assertEquals(3, counts);

    }

    @Test
    @TestOrder(170)
    public void blankCondition8() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm("", "", "", "", "", "", bankcd2);
        Assert.assertEquals(5, counts);
    }

    @Test
    @TestOrder(180)
    public void nullCondition7() {
        long counts = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm(null, null, null, null, null, null, bankcd2);
        Assert.assertEquals(5, counts);
    }

}
