package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 郵便番号検索<br />
 * 住所マスタ(郵便番号)件数取得　基本地区コード消滅理由区分のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAddressDistinctPostAdrkjAdrknbkarisCountByItems {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("3", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "エ", "後");

        Assert.assertEquals(0, counts);

        BM_Address address1 = new BM_Address("2111111", "1");
        address1.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address1.setKjtodouhukennmketasuu(1);
        address1.setKjsikugunnmketasuu(2);
        address1.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address1.setAdrkj("朝昼朝");
        address1.setAdrkn("アイア");
        address1.setAdrknblankari("カ");
        bizDomManager.insert(address1);

        BM_Address address2 = new BM_Address("1222222", "2");
        address2.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address2.setKjtodouhukennmketasuu(1);
        address2.setKjsikugunnmketasuu(3);
        address2.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address2.setAdrkj("昼朝昼");
        address2.setAdrkn("イアイ");
        address2.setAdrknblankari("キ");
        bizDomManager.insert(address2);

        BM_Address address3 = new BM_Address("2000000", "3");
        address3.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address3.setKjtodouhukennmketasuu(2);
        address3.setKjsikugunnmketasuu(1);
        address3.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address3.setAdrkj("昼");
        address3.setAdrkn("イ");
        address3.setAdrknblankari("ク");
        bizDomManager.insert(address3);

        BM_Address address4 = new BM_Address("1000000", "4");
        address4.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address4.setKjtodouhukennmketasuu(1);
        address4.setKjsikugunnmketasuu(3);
        address4.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address4.setAdrkj("朝");
        address4.setAdrkn("ア");
        address4.setAdrknblankari("ケ");
        bizDomManager.insert(address4);

        BM_Address address5 = new BM_Address("2222222", "5");
        address5.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address5.setKjtodouhukennmketasuu(2);
        address5.setKjsikugunnmketasuu(2);
        address5.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address5.setAdrkj("昼昼昼");
        address5.setAdrkn("イイイ");
        address5.setAdrknblankari("コ");
        bizDomManager.insert(address5);

        BM_Address address52 = new BM_Address("2222222", "6");
        address52.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address52.setKjtodouhukennmketasuu(2);
        address52.setKjsikugunnmketasuu(2);
        address52.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address52.setAdrkj("昼昼昼");
        address52.setAdrkn("イイイ");
        address52.setAdrknblankari("コ");
        bizDomManager.insert(address52);

        BM_Address address53 = new BM_Address("2222222", "7");
        address53.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address53.setKjtodouhukennmketasuu(2);
        address53.setKjsikugunnmketasuu(3);
        address53.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address53.setAdrkj("昼昼昼");
        address53.setAdrkn("イイイ");
        address53.setAdrknblankari("コ");
        bizDomManager.insert(address53);

        BM_Address address54 = new BM_Address("2222222", "8");
        address54.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address54.setKjtodouhukennmketasuu(3);
        address54.setKjsikugunnmketasuu(2);
        address54.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address54.setAdrkj("昼昼昼");
        address54.setAdrkn("イイイ");
        address54.setAdrknblankari("コ");
        bizDomManager.insert(address54);

        BM_Address address6 = new BM_Address("1111111", "6");
        address6.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address6.setKjtodouhukennmketasuu(1);
        address6.setKjsikugunnmketasuu(1);
        address6.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address6.setAdrkj("朝朝朝");
        address6.setAdrkn("アアア");
        address6.setAdrknblankari("サ");
        bizDomManager.insert(address6);

        BM_Address address7 = new BM_Address("3456789", "7");
        address7.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address7.setKjtodouhukennmketasuu(1);
        address7.setKjsikugunnmketasuu(2);
        address7.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address7.setAdrkj("明後日");
        address7.setAdrkn("ウエオ");
        address7.setAdrknblankari("シ");
        bizDomManager.insert(address7);

        BM_Address address8 = new BM_Address("4111111", "8");
        address8.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address8.setKjtodouhukennmketasuu(1);
        address8.setKjsikugunnmketasuu(1);
        address8.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address8.setAdrkj("朝昼朝");
        address8.setAdrkn("アイア");
        address8.setAdrknblankari("ス");
        bizDomManager.insert(address8);

        BM_Address address9 = new BM_Address("2111111", "2");
        address9.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YNOHENKOU);
        address9.setKjtodouhukennmketasuu(2);
        address9.setKjsikugunnmketasuu(1);
        address9.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address9.setAdrkj("朝昼朝");
        address9.setAdrkn("アイア");
        address9.setAdrknblankari("セ");
        bizDomManager.insert(address9);

        BM_Address address10 = new BM_Address("2111111", "3");
        address10.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address10.setKjtodouhukennmketasuu(2);
        address10.setKjsikugunnmketasuu(1);
        address10.setTodouhukencd(C_TodouhukenKbn.HOKKAIDOU);
        address10.setAdrkj("朝昼朝");
        address10.setAdrkn("アイア");
        address10.setAdrknblankari("ソ");
        bizDomManager.insert(address10);

        BM_Address address11 = new BM_Address("2111111", "4");
        address11.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address11.setKjtodouhukennmketasuu(2);
        address11.setKjsikugunnmketasuu(3);
        address11.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address11.setAdrkj("朝晩朝");
        address11.setAdrkn("アイア");
        address11.setAdrknblankari("ナ");
        bizDomManager.insert(address11);

        BM_Address address12 = new BM_Address("2111111", "5");
        address12.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address12.setKjtodouhukennmketasuu(2);
        address12.setKjsikugunnmketasuu(3);
        address12.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address12.setAdrkj("朝昼朝");
        address12.setAdrkn("アオア");
        address12.setAdrknblankari("ニ");
        bizDomManager.insert(address12);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("6", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(0, counts);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("3", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "エ", "後");

        Assert.assertEquals(1, counts);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(5, counts);
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(7, counts);
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "", "昼");

        Assert.assertEquals(6, counts);
    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "イ", "");

        Assert.assertEquals(6, counts);
    }

    @Test
    @TestOrder(70)
    public void blankCondition4() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "", "");

        Assert.assertEquals(12, counts);
    }

    @Test
    @TestOrder(80)
    public void nullCondition1() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems(null, C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(7, counts);
    }

    @Test
    @TestOrder(90)
    public void nullCondition2() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, null, "昼");

        Assert.assertEquals(6, counts);
    }

    @Test
    @TestOrder(100)
    public void nullCondition3() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            C_TodouhukenKbn.BLNK, "イ", null);

        Assert.assertEquals(6, counts);
    }

    @Test
    @TestOrder(110)
    public void nullCondition4() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", null, C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(6, counts);
    }

    @Test
    @TestOrder(120)
    public void nullCondition5() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
            null, "イ", "昼");

        Assert.assertEquals(6, counts);
    }

    @Test
    @TestOrder(130)
    public void nullCondition6() {

        long counts = bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisCountByItems(null, null, null, null, null);

        Assert.assertEquals(14, counts);
    }
}
