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

import yuyu.def.db.entity.BM_Address;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 募集代理店保有契約Ｆ作成<br />
 * 住所マスタエンティティリスト取得(郵便番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAddressesByPostalCd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Address> bM_AddressLst = bizDomManager.getAddressesByPostalCd("1111111");

        Assert.assertEquals(0, bM_AddressLst.size());

        BM_Address bM_Address1 = new BM_Address();
        bM_Address1.setPostalCd("1111111");
        bM_Address1.setKihontikucdsimo1("1");
        bizDomManager.insert(bM_Address1);

        BM_Address bM_Address2 = new BM_Address();
        bM_Address2.setPostalCd("1111112");
        bM_Address2.setKihontikucdsimo1("1");
        bizDomManager.insert(bM_Address2);

        BM_Address bM_Address3 = new BM_Address();
        bM_Address3.setPostalCd("1111112");
        bM_Address3.setKihontikucdsimo1("2");
        bizDomManager.insert(bM_Address3);

        BM_Address bM_Address4 = new BM_Address();
        bM_Address4.setPostalCd("1111112");
        bM_Address4.setKihontikucdsimo1("3");
        bizDomManager.insert(bM_Address4);
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

        List<BM_Address> bM_AddressLst = bizDomManager.getAddressesByPostalCd("1111114");

        Assert.assertEquals(0, bM_AddressLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_Address> bM_AddressLst = bizDomManager.getAddressesByPostalCd("1111111");

        Assert.assertEquals(1, bM_AddressLst.size());

        Assert.assertEquals("1111111", bM_AddressLst.get(0).getPostalCd());
        Assert.assertEquals("1", bM_AddressLst.get(0).getKihontikucdsimo1());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_Address> bM_AddressLst = bizDomManager.getAddressesByPostalCd("1111112");
        Assert.assertEquals(3, bM_AddressLst.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($("1111112", "1"),"1");
        map.put($("1111112", "2"),"2");
        map.put($("1111112", "3"),"3");

        assertTrue(map.containsKey($(bM_AddressLst.get(0).getPostalCd(), bM_AddressLst.get(0).getKihontikucdsimo1())));
        assertTrue(map.containsKey($(bM_AddressLst.get(1).getPostalCd(), bM_AddressLst.get(1).getKihontikucdsimo1())));
        assertTrue(map.containsKey($(bM_AddressLst.get(2).getPostalCd(), bM_AddressLst.get(2).getKihontikucdsimo1())));

        map.remove($(bM_AddressLst.get(0).getPostalCd(), bM_AddressLst.get(0).getKihontikucdsimo1()));
        map.remove($(bM_AddressLst.get(1).getPostalCd(), bM_AddressLst.get(1).getKihontikucdsimo1()));
        map.remove($(bM_AddressLst.get(2).getPostalCd(), bM_AddressLst.get(2).getKihontikucdsimo1()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_Address> bM_AddressLst = bizDomManager.getAddressesByPostalCd("");

        Assert.assertEquals(0, bM_AddressLst.size());
    }
}
