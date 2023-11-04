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
public class BizDomManagerTest_getAddressDistinctAdrknblankarisByPostalCd {

    @Inject
    BizDomManager bizDomManager;

    static String P_POSTALCD_01 = "1111111";
    static String P_POSTALCD_02 = "2222222";
    static String P_POSTALCD_03 = "3333333";
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<String> stringLst = bizDomManager.getAddressDistinctAdrknblankarisByPostalCd(P_POSTALCD_01, C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertEquals(0, stringLst.size());

        BM_Address bM_Address1 = new BM_Address(P_POSTALCD_01, "1");
        bM_Address1.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address1.setAdrknblankari("ク");
        bizDomManager.insert(bM_Address1);

        BM_Address bM_Address2 = new BM_Address(P_POSTALCD_02, "1");
        bM_Address2.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address2.setAdrknblankari("セ");
        bizDomManager.insert(bM_Address2);

        BM_Address bM_Address3 = new BM_Address(P_POSTALCD_02, "2");
        bM_Address3.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address3.setAdrknblankari("ス");
        bizDomManager.insert(bM_Address3);

        BM_Address bM_Address4 = new BM_Address(P_POSTALCD_02, "3");
        bM_Address4.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address4.setAdrknblankari("サ");
        bizDomManager.insert(bM_Address4);

        BM_Address bM_Address5 = new BM_Address(P_POSTALCD_02, "4");
        bM_Address5.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address5.setAdrknblankari("サ");
        bizDomManager.insert(bM_Address5);

        BM_Address bM_Address6 = new BM_Address(P_POSTALCD_02, "5");
        bM_Address6.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YNOHENKOU);
        bM_Address6.setAdrknblankari("ナ");
        bizDomManager.insert(bM_Address6);

        BM_Address bM_Address7 = new BM_Address(P_POSTALCD_03, "1");
        bM_Address7.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address7.setAdrknblankari("セ");
        bizDomManager.insert(bM_Address7);
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

        List<String> stringLst = bizDomManager.getAddressDistinctAdrknblankarisByPostalCd(P_POSTALCD_02, C_KihontikucdSyoumetuKbn.SONOTA);

        Assert.assertEquals(0, stringLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<String> stringLst = bizDomManager.getAddressDistinctAdrknblankarisByPostalCd(P_POSTALCD_01, C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertEquals(1, stringLst.size());

        Assert.assertEquals("ク", stringLst.get(0));
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<String> stringLst = bizDomManager.getAddressDistinctAdrknblankarisByPostalCd(P_POSTALCD_02, C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertEquals(3, stringLst.size());

        Assert.assertEquals("サ", stringLst.get(0));
        Assert.assertEquals("ス", stringLst.get(1));
        Assert.assertEquals("セ", stringLst.get(2));
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<String> stringLst = bizDomManager.getAddressDistinctAdrknblankarisByPostalCd("", C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertEquals(0, stringLst.size());
    }
}
