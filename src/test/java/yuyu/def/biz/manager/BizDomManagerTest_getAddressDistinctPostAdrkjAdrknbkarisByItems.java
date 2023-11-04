package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.result.bean.AddressDistinctPostAdrkjAdrknbkarisByItemsBean;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 郵便番号検索<br />
 * 住所マスタ(郵便番号)情報Beanリスト取得　基本地区コード消滅理由区分のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAddressDistinctPostAdrkjAdrknbkarisByItems {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("3", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "エ", "後");

        Assert.assertEquals(0, beanLst.size());

        BM_Address address1 = new BM_Address("2111111", "1");
        address1.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address1.setKjtodouhukennmketasuu(1);
        address1.setKjsikugunnmketasuu(1);
        address1.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address1.setAdrkj("朝昼朝");
        address1.setAdrkn("アイア");
        address1.setAdrknblankari("ク");
        bizDomManager.insert(address1);

        BM_Address address2 = new BM_Address("1222222", "2");
        address2.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address2.setKjtodouhukennmketasuu(2);
        address2.setKjsikugunnmketasuu(1);
        address2.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address2.setAdrkj("昼朝昼");
        address2.setAdrkn("イアイ");
        address2.setAdrknblankari("サ");
        bizDomManager.insert(address2);

        BM_Address address3 = new BM_Address("2222221", "1");
        address3.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address3.setKjtodouhukennmketasuu(2);
        address3.setKjsikugunnmketasuu(3);
        address3.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address3.setAdrkj("昼昼");
        address3.setAdrkn("イイ");
        address3.setAdrknblankari("カ");
        bizDomManager.insert(address3);

        BM_Address address4 = new BM_Address("2000000", "3");
        address4.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address4.setKjtodouhukennmketasuu(1);
        address4.setKjsikugunnmketasuu(2);
        address4.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address4.setAdrkj("昼");
        address4.setAdrkn("イ");
        address4.setAdrknblankari("カ");
        bizDomManager.insert(address4);

        BM_Address address5 = new BM_Address("2111112", "1");
        address5.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address5.setKjtodouhukennmketasuu(2);
        address5.setKjsikugunnmketasuu(1);
        address5.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address5.setAdrkj("昼朝");
        address5.setAdrkn("イア");
        address5.setAdrknblankari("カ");
        bizDomManager.insert(address5);

        BM_Address address6 = new BM_Address("1000000", "4");
        address6.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address6.setKjtodouhukennmketasuu(3);
        address6.setKjsikugunnmketasuu(3);
        address6.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address6.setAdrkj("朝");
        address6.setAdrkn("ア");
        address6.setAdrknblankari("キ");
        bizDomManager.insert(address6);

        BM_Address address7 = new BM_Address("2222222", "5");
        address7.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address7.setKjtodouhukennmketasuu(2);
        address7.setKjsikugunnmketasuu(2);
        address7.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address7.setAdrkj("昼昼昼");
        address7.setAdrkn("イイイ");
        address7.setAdrknblankari("ス");
        bizDomManager.insert(address7);

        BM_Address address72 = new BM_Address("2222222", "6");
        address72.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address72.setKjtodouhukennmketasuu(2);
        address72.setKjsikugunnmketasuu(2);
        address72.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address72.setAdrkj("昼昼昼");
        address72.setAdrkn("イイイ");
        address72.setAdrknblankari("ス");
        bizDomManager.insert(address72);

        BM_Address address73 = new BM_Address("2222222", "7");
        address73.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address73.setKjtodouhukennmketasuu(2);
        address73.setKjsikugunnmketasuu(3);
        address73.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address73.setAdrkj("昼昼昼");
        address73.setAdrkn("イイイ");
        address73.setAdrknblankari("ス");
        bizDomManager.insert(address73);

        BM_Address address74 = new BM_Address("2222222", "8");
        address74.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address74.setKjtodouhukennmketasuu(3);
        address74.setKjsikugunnmketasuu(2);
        address74.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address74.setAdrkj("昼昼昼");
        address74.setAdrkn("イイイ");
        address74.setAdrknblankari("ス");
        bizDomManager.insert(address74);

        BM_Address address8 = new BM_Address("1111111", "6");
        address8.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address8.setKjtodouhukennmketasuu(1);
        address8.setKjsikugunnmketasuu(1);
        address8.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address8.setAdrkj("朝朝朝");
        address8.setAdrkn("アアア");
        address8.setAdrknblankari("セ");
        bizDomManager.insert(address8);

        BM_Address address9 = new BM_Address("3456789", "7");
        address9.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address9.setKjtodouhukennmketasuu(1);
        address9.setKjsikugunnmketasuu(2);
        address9.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address9.setAdrkj("明後日");
        address9.setAdrkn("ウエオ");
        address9.setAdrknblankari("ソ");
        bizDomManager.insert(address9);

        BM_Address address10 = new BM_Address("4111111", "8");
        address10.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address10.setKjtodouhukennmketasuu(2);
        address10.setKjsikugunnmketasuu(2);
        address10.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address10.setAdrkj("朝昼朝");
        address10.setAdrkn("アイア");
        address10.setAdrknblankari("ケ");
        bizDomManager.insert(address10);

        BM_Address address11 = new BM_Address("2111111", "4");
        address11.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YNOHENKOU);
        address11.setKjtodouhukennmketasuu(1);
        address11.setKjsikugunnmketasuu(2);
        address11.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address11.setAdrkj("朝昼朝");
        address11.setAdrkn("アイア");
        address11.setAdrknblankari("ニ");
        bizDomManager.insert(address11);

        BM_Address address12 = new BM_Address("2111111", "5");
        address12.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address12.setKjtodouhukennmketasuu(2);
        address12.setKjsikugunnmketasuu(1);
        address12.setTodouhukencd(C_TodouhukenKbn.HOKKAIDOU);
        address12.setAdrkj("朝昼朝");
        address12.setAdrkn("アイア");
        address12.setAdrknblankari("ヌ");
        bizDomManager.insert(address12);

        BM_Address address13 = new BM_Address("2111111", "6");
        address13.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address13.setKjtodouhukennmketasuu(3);
        address13.setKjsikugunnmketasuu(2);
        address13.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address13.setAdrkj("朝晩朝");
        address13.setAdrkn("アイア");
        address13.setAdrknblankari("ネ");
        bizDomManager.insert(address13);

        BM_Address address14 = new BM_Address("2111111", "7");
        address14.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        address14.setKjtodouhukennmketasuu(1);
        address14.setKjsikugunnmketasuu(1);
        address14.setTodouhukencd(C_TodouhukenKbn.BLNK);
        address14.setAdrkj("朝昼朝");
        address14.setAdrkn("アオア");
        address14.setAdrknblankari("ノ");
        bizDomManager.insert(address14);


        for(int i=1; i< 2000; i++){
            BM_Address address = new BM_Address("9" + String.format("%06d", i),"9");
            address.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YNO7KETAKA);
            address.setKjtodouhukennmketasuu(9);
            address.setKjsikugunnmketasuu(9);
            address.setTodouhukencd(C_TodouhukenKbn.IBARAKI);
            address.setAdrkj("茨城");
            address.setAdrkn("イバラキ");
            address.setAdrknblankari("イバ　ラキ");
            bizDomManager.insert(address);
        }
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

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("6", C_KihontikucdSyoumetuKbn.YUUKOUTYUU,C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(0, beanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("3", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "エ", "後");

        Assert.assertEquals(1, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean = beanLst.get(0);

        Assert.assertEquals("3456789", bean.getPostalCd());
        Assert.assertEquals("明後日", bean.getAdrkj());
        Assert.assertEquals("ソ", bean.getAdrknblankari());
        Assert.assertEquals(1, bean.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(7, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(9, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean9 = beanLst.get(8);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("4111111", bean5.getPostalCd());
        Assert.assertEquals("朝昼朝", bean5.getAdrkj());
        Assert.assertEquals("ケ", bean5.getAdrknblankari());
        Assert.assertEquals(2, bean5.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean5.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("1222222", bean6.getPostalCd());
        Assert.assertEquals("昼朝昼", bean6.getAdrkj());
        Assert.assertEquals("サ", bean6.getAdrknblankari());
        Assert.assertEquals(2, bean6.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean6.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "", "昼");

        Assert.assertEquals(8, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("2111111", bean8.getPostalCd());
        Assert.assertEquals("朝昼朝", bean8.getAdrkj());
        Assert.assertEquals("ノ", bean8.getAdrknblankari());
        Assert.assertEquals(1, bean8.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean8.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "イ", "");

        Assert.assertEquals(8, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("2111111", bean8.getPostalCd());
        Assert.assertEquals("朝晩朝", bean8.getAdrkj());
        Assert.assertEquals("ネ", bean8.getAdrknblankari());
        Assert.assertEquals(3, bean8.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean8.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(70)
    public void blankCondition4() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "", "");

        Assert.assertEquals(14, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean9 = beanLst.get(8);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean10 = beanLst.get(9);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean11 = beanLst.get(10);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean12 = beanLst.get(11);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean13 = beanLst.get(12);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean14 = beanLst.get(13);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("1000000", bean4.getPostalCd());
        Assert.assertEquals("朝", bean4.getAdrkj());
        Assert.assertEquals("キ", bean4.getAdrknblankari());
        Assert.assertEquals(3, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean4.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean5.getPostalCd());
        Assert.assertEquals("朝昼朝", bean5.getAdrkj());
        Assert.assertEquals("ク", bean5.getAdrknblankari());
        Assert.assertEquals(1, bean5.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean5.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("4111111", bean6.getPostalCd());
        Assert.assertEquals("朝昼朝", bean6.getAdrkj());
        Assert.assertEquals("ケ", bean6.getAdrknblankari());
        Assert.assertEquals(2, bean6.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean6.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("1222222", bean7.getPostalCd());
        Assert.assertEquals("昼朝昼", bean7.getAdrkj());
        Assert.assertEquals("サ", bean7.getAdrknblankari());
        Assert.assertEquals(2, bean7.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean7.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean10.getPostalCd(), bean10.getAdrkj(), bean10.getAdrknblankari(), bean10.getKjtodouhukennmketasuu().intValue(), bean10.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean10.getPostalCd(), bean10.getAdrkj(), bean10.getAdrknblankari(), bean10.getKjtodouhukennmketasuu().intValue(), bean10.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("1111111", bean11.getPostalCd());
        Assert.assertEquals("朝朝朝", bean11.getAdrkj());
        Assert.assertEquals("セ", bean11.getAdrknblankari());
        Assert.assertEquals(1, bean11.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean11.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("3456789", bean12.getPostalCd());
        Assert.assertEquals("明後日", bean12.getAdrkj());
        Assert.assertEquals("ソ", bean12.getAdrknblankari());
        Assert.assertEquals(1, bean12.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean12.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean13.getPostalCd());
        Assert.assertEquals("朝晩朝", bean13.getAdrkj());
        Assert.assertEquals("ネ", bean13.getAdrknblankari());
        Assert.assertEquals(3, bean13.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean13.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean14.getPostalCd());
        Assert.assertEquals("朝昼朝", bean14.getAdrkj());
        Assert.assertEquals("ノ", bean14.getAdrknblankari());
        Assert.assertEquals(1, bean14.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean14.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(80)
    public void nullCondition1() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems(null, C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
                C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(9, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean9 = beanLst.get(8);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("4111111", bean5.getPostalCd());
        Assert.assertEquals("朝昼朝", bean5.getAdrkj());
        Assert.assertEquals("ケ", bean5.getAdrknblankari());
        Assert.assertEquals(2, bean5.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean5.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("1222222", bean6.getPostalCd());
        Assert.assertEquals("昼朝昼", bean6.getAdrkj());
        Assert.assertEquals("サ", bean6.getAdrknblankari());
        Assert.assertEquals(2, bean6.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean6.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(90)
    public void nullCondition2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, null, "昼");

        Assert.assertEquals(8, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("2111111", bean8.getPostalCd());
        Assert.assertEquals("朝昼朝", bean8.getAdrkj());
        Assert.assertEquals("ノ", bean8.getAdrknblankari());
        Assert.assertEquals(1, bean8.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean8.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(100)
    public void nullCondition3() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, C_TodouhukenKbn.BLNK, "イ", null);

        Assert.assertEquals(8, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("2111111", bean8.getPostalCd());
        Assert.assertEquals("朝晩朝", bean8.getAdrkj());
        Assert.assertEquals("ネ", bean8.getAdrknblankari());
        Assert.assertEquals(3, bean8.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean8.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(110)
    public void nullCondition4() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", null, C_TodouhukenKbn.BLNK, "イ", "昼");

        Assert.assertEquals(8, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("2111111", bean8.getPostalCd());
        Assert.assertEquals("朝昼朝", bean8.getAdrkj());
        Assert.assertEquals("ニ", bean8.getAdrknblankari());
        Assert.assertEquals(1, bean8.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean8.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(120)
    public void nullCondition5() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems("2", C_KihontikucdSyoumetuKbn.YUUKOUTYUU, null, "イ", "昼");

        Assert.assertEquals(8, beanLst.size());

        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);

        Assert.assertEquals("2000000", bean1.getPostalCd());
        Assert.assertEquals("昼", bean1.getAdrkj());
        Assert.assertEquals("カ", bean1.getAdrknblankari());
        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111112", bean2.getPostalCd());
        Assert.assertEquals("昼朝", bean2.getAdrkj());
        Assert.assertEquals("カ", bean2.getAdrknblankari());
        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2222221", bean3.getPostalCd());
        Assert.assertEquals("昼昼", bean3.getAdrkj());
        Assert.assertEquals("カ", bean3.getAdrknblankari());
        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());

        Assert.assertEquals("2111111", bean4.getPostalCd());
        Assert.assertEquals("朝昼朝", bean4.getAdrkj());
        Assert.assertEquals("ク", bean4.getAdrknblankari());
        Assert.assertEquals(1, bean4.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean4.getKjsikugunnmketasuu().intValue());

        assertTrue(map.containsKey($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue())));
        assertTrue(map.containsKey($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue())));

        map.remove($(bean5.getPostalCd(), bean5.getAdrkj(), bean5.getAdrknblankari(), bean5.getKjtodouhukennmketasuu().intValue(), bean5.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean6.getPostalCd(), bean6.getAdrkj(), bean6.getAdrknblankari(), bean6.getKjtodouhukennmketasuu().intValue(), bean6.getKjsikugunnmketasuu().intValue()));
        map.remove($(bean7.getPostalCd(), bean7.getAdrkj(), bean7.getAdrknblankari(), bean7.getKjtodouhukennmketasuu().intValue(), bean7.getKjsikugunnmketasuu().intValue()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("2111111", bean8.getPostalCd());
        Assert.assertEquals("朝昼朝", bean8.getAdrkj());
        Assert.assertEquals("ヌ", bean8.getAdrknblankari());
        Assert.assertEquals(2, bean8.getKjtodouhukennmketasuu().intValue());
        Assert.assertEquals(1, bean8.getKjsikugunnmketasuu().intValue());
    }

    @Test
    @TestOrder(130)
    public void nullCondition6() {

        //        Map<String,String> map = new HashMap<String,String>();
        //
        //        map.put($("2222222", "昼昼昼", "ス", 2, 3),"1");
        //        map.put($("2222222", "昼昼昼", "ス", 3, 2),"1");
        //        map.put($("2222222", "昼昼昼", "ス", 2, 2),"1");

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> beanLst = bizDomManager
            .getAddressDistinctPostAdrkjAdrknbkarisByItems(null, null, null, null, null);

        Assert.assertEquals(1001, beanLst.size());
        //
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean1 = beanLst.get(0);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean2 = beanLst.get(1);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean3 = beanLst.get(2);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean4 = beanLst.get(3);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean5 = beanLst.get(4);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean6 = beanLst.get(5);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean7 = beanLst.get(6);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean8 = beanLst.get(7);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean9 = beanLst.get(8);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean10 = beanLst.get(9);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean11 = beanLst.get(10);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean12 = beanLst.get(11);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean13 = beanLst.get(12);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean14 = beanLst.get(13);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean15 = beanLst.get(14);
        //        AddressDistinctPostAdrkjAdrknbkarisByItemsBean bean16 = beanLst.get(15);
        //
        //        Assert.assertEquals("2000000", bean1.getPostalCd());
        //        Assert.assertEquals("昼", bean1.getAdrkj());
        //        Assert.assertEquals("カ", bean1.getAdrknblankari());
        //        Assert.assertEquals(1, bean1.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(2, bean1.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2111112", bean2.getPostalCd());
        //        Assert.assertEquals("昼朝", bean2.getAdrkj());
        //        Assert.assertEquals("カ", bean2.getAdrknblankari());
        //        Assert.assertEquals(2, bean2.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(1, bean2.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2222221", bean3.getPostalCd());
        //        Assert.assertEquals("昼昼", bean3.getAdrkj());
        //        Assert.assertEquals("カ", bean3.getAdrknblankari());
        //        Assert.assertEquals(2, bean3.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(3, bean3.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("1000000", bean4.getPostalCd());
        //        Assert.assertEquals("朝", bean4.getAdrkj());
        //        Assert.assertEquals("キ", bean4.getAdrknblankari());
        //        Assert.assertEquals(3, bean4.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(3, bean4.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2111111", bean5.getPostalCd());
        //        Assert.assertEquals("朝昼朝", bean5.getAdrkj());
        //        Assert.assertEquals("ク", bean5.getAdrknblankari());
        //        Assert.assertEquals(1, bean5.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(1, bean5.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("4111111", bean6.getPostalCd());
        //        Assert.assertEquals("朝昼朝", bean6.getAdrkj());
        //        Assert.assertEquals("ケ", bean6.getAdrknblankari());
        //        Assert.assertEquals(2, bean6.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(2, bean6.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("1222222", bean7.getPostalCd());
        //        Assert.assertEquals("昼朝昼", bean7.getAdrkj());
        //        Assert.assertEquals("サ", bean7.getAdrknblankari());
        //        Assert.assertEquals(2, bean7.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(1, bean7.getKjsikugunnmketasuu().intValue());
        //
        //        assertTrue(map.containsKey($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue())));
        //        assertTrue(map.containsKey($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue())));
        //        assertTrue(map.containsKey($(bean10.getPostalCd(), bean10.getAdrkj(), bean10.getAdrknblankari(), bean10.getKjtodouhukennmketasuu().intValue(), bean10.getKjsikugunnmketasuu().intValue())));
        //
        //        map.remove($(bean8.getPostalCd(), bean8.getAdrkj(), bean8.getAdrknblankari(), bean8.getKjtodouhukennmketasuu().intValue(), bean8.getKjsikugunnmketasuu().intValue()));
        //        map.remove($(bean9.getPostalCd(), bean9.getAdrkj(), bean9.getAdrknblankari(), bean9.getKjtodouhukennmketasuu().intValue(), bean9.getKjsikugunnmketasuu().intValue()));
        //        map.remove($(bean10.getPostalCd(), bean10.getAdrkj(), bean10.getAdrknblankari(), bean10.getKjtodouhukennmketasuu().intValue(), bean10.getKjsikugunnmketasuu().intValue()));
        //
        //        assertTrue(map.isEmpty());
        //
        //        Assert.assertEquals("1111111", bean11.getPostalCd());
        //        Assert.assertEquals("朝朝朝", bean11.getAdrkj());
        //        Assert.assertEquals("セ", bean11.getAdrknblankari());
        //        Assert.assertEquals(1, bean11.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(1, bean11.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("3456789", bean12.getPostalCd());
        //        Assert.assertEquals("明後日", bean12.getAdrkj());
        //        Assert.assertEquals("ソ", bean12.getAdrknblankari());
        //        Assert.assertEquals(1, bean12.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(2, bean12.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2111111", bean13.getPostalCd());
        //        Assert.assertEquals("朝昼朝", bean13.getAdrkj());
        //        Assert.assertEquals("ニ", bean13.getAdrknblankari());
        //        Assert.assertEquals(1, bean13.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(2, bean13.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2111111", bean14.getPostalCd());
        //        Assert.assertEquals("朝昼朝", bean14.getAdrkj());
        //        Assert.assertEquals("ヌ", bean14.getAdrknblankari());
        //        Assert.assertEquals(2, bean14.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(1, bean14.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2111111", bean15.getPostalCd());
        //        Assert.assertEquals("朝晩朝", bean15.getAdrkj());
        //        Assert.assertEquals("ネ", bean15.getAdrknblankari());
        //        Assert.assertEquals(3, bean15.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(2, bean15.getKjsikugunnmketasuu().intValue());
        //
        //        Assert.assertEquals("2111111", bean16.getPostalCd());
        //        Assert.assertEquals("朝昼朝", bean16.getAdrkj());
        //        Assert.assertEquals("ノ", bean16.getAdrknblankari());
        //        Assert.assertEquals(1, bean16.getKjtodouhukennmketasuu().intValue());
        //        Assert.assertEquals(1, bean16.getKjsikugunnmketasuu().intValue());
    }

}
