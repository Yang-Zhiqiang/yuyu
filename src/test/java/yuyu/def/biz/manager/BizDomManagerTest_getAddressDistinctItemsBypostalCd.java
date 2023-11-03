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

import yuyu.def.biz.result.bean.AddressDistinctItemsBypostalCdBean;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 住所情報取得<br />
 * 住所（カナ）（空白あり）リスト重複削除取得　郵便番号指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAddressDistinctItemsBypostalCd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<AddressDistinctItemsBypostalCdBean> addressDistinctItemsBypostalCdBeanLst = bizDomManager.getAddressDistinctItemsBypostalCd("2111111", C_KihontikucdSyoumetuKbn.YNOHENKOU);

        Assert.assertEquals(0, addressDistinctItemsBypostalCdBeanLst.size());

        BM_Address address1 = new BM_Address("2111111", "1");
        address1.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("1"));
        address1.setKjsikugunnmketasuu(1);
        address1.setAdrkj("昼昼昼");

        bizDomManager.insert(address1);

        BM_Address address2 = new BM_Address("2111111", "2");
        address2.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("1"));
        address2.setKjsikugunnmketasuu(1);
        address2.setAdrkj("昼昼昼");

        bizDomManager.insert(address2);

        BM_Address address3 = new BM_Address("1222222", "2");
        address3.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("1"));
        address3.setKjsikugunnmketasuu(1);
        address3.setAdrkj("昼昼昼");

        bizDomManager.insert(address3);

        BM_Address address4 = new BM_Address("2111111", "3");
        address4.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("2"));
        address4.setKjsikugunnmketasuu(1);
        address4.setAdrkj("昼昼昼");

        bizDomManager.insert(address4);

        BM_Address address5 = new BM_Address("2222221", "6");
        address5.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("3"));
        address5.setKjsikugunnmketasuu(4);
        address5.setAdrkj("朝晩朝");

        bizDomManager.insert(address5);

        BM_Address address6 = new BM_Address("2222221", "5");
        address6.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("3"));
        address6.setKjsikugunnmketasuu(2);
        address6.setAdrkj("朝昼朝");

        bizDomManager.insert(address6);

        BM_Address address7 = new BM_Address("2222221", "4");
        address7.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("3"));
        address7.setKjsikugunnmketasuu(3);
        address7.setAdrkj("明後日");

        bizDomManager.insert(address7);

        BM_Address address8 = new BM_Address("2222221", "3");
        address8.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("3"));
        address8.setKjsikugunnmketasuu(6);
        address8.setAdrkj("朝晩朝");

        bizDomManager.insert(address8);

        BM_Address address9 = new BM_Address("2222221", "2");
        address9.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.valueOf("3"));
        address9.setKjsikugunnmketasuu(5);
        address9.setAdrkj("朝晩朝");

        bizDomManager.insert(address9);
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

        List<AddressDistinctItemsBypostalCdBean> addressDistinctItemsBypostalCdBeanLst = bizDomManager.getAddressDistinctItemsBypostalCd("2222222", C_KihontikucdSyoumetuKbn.YNO7KETAKA);

        Assert.assertEquals(0, addressDistinctItemsBypostalCdBeanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AddressDistinctItemsBypostalCdBean> addressDistinctItemsBypostalCdBeanLst = bizDomManager.getAddressDistinctItemsBypostalCd("2111111", C_KihontikucdSyoumetuKbn.YNOHENKOU);

        Assert.assertEquals(1, addressDistinctItemsBypostalCdBeanLst.size());

        Assert.assertEquals("昼昼昼",addressDistinctItemsBypostalCdBeanLst.get(0).getAdrkj());
        Assert.assertEquals(Integer.valueOf(1), addressDistinctItemsBypostalCdBeanLst.get(0).getKjsikugunnmketasuu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<AddressDistinctItemsBypostalCdBean> addressDistinctItemsBypostalCdBeanLst = bizDomManager.getAddressDistinctItemsBypostalCd("2222221", C_KihontikucdSyoumetuKbn.TIKUWARIHENKOU);

        Assert.assertEquals(5, addressDistinctItemsBypostalCdBeanLst.size());


        Assert.assertEquals("明後日", addressDistinctItemsBypostalCdBeanLst.get(0).getAdrkj());
        Assert.assertEquals("朝昼朝", addressDistinctItemsBypostalCdBeanLst.get(1).getAdrkj());
        Assert.assertEquals("朝晩朝", addressDistinctItemsBypostalCdBeanLst.get(2).getAdrkj());
        Assert.assertEquals("朝晩朝", addressDistinctItemsBypostalCdBeanLst.get(3).getAdrkj());
        Assert.assertEquals("朝晩朝", addressDistinctItemsBypostalCdBeanLst.get(4).getAdrkj());
        Assert.assertEquals(Integer.valueOf(3), addressDistinctItemsBypostalCdBeanLst.get(0).getKjsikugunnmketasuu());
        Assert.assertEquals(Integer.valueOf(2), addressDistinctItemsBypostalCdBeanLst.get(1).getKjsikugunnmketasuu());
        Assert.assertEquals(Integer.valueOf(4), addressDistinctItemsBypostalCdBeanLst.get(2).getKjsikugunnmketasuu());
        Assert.assertEquals(Integer.valueOf(5), addressDistinctItemsBypostalCdBeanLst.get(3).getKjsikugunnmketasuu());
        Assert.assertEquals(Integer.valueOf(6), addressDistinctItemsBypostalCdBeanLst.get(4).getKjsikugunnmketasuu());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<AddressDistinctItemsBypostalCdBean> addressDistinctItemsBypostalCdBeanLst = bizDomManager.getAddressDistinctItemsBypostalCd("", C_KihontikucdSyoumetuKbn.YNOHENKOU);

        Assert.assertEquals(0, addressDistinctItemsBypostalCdBeanLst.size());
    }
}
