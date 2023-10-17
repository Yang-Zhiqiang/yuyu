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
 * 住所情報取得<br />
 * 最小都道府県コード取得　郵便番号指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAddressMinTodouhukencdByPostalCd {

    @Inject
    BizDomManager bizDomManager;

    static String P_POSTALCD_01 = "2222222";
    static String P_POSTALCD_02 = "3333333";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        C_TodouhukenKbn minTodouhukencd =
                bizDomManager.getAddressMinTodouhukencdByPostalCd(P_POSTALCD_01, C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertNull(minTodouhukencd);

        BM_Address bM_Address1 = new BM_Address(P_POSTALCD_01, "1");
        bM_Address1.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address1.setTodouhukencd(C_TodouhukenKbn.HOKKAIDOU);
        bizDomManager.insert(bM_Address1);

        BM_Address bM_Address2 = new BM_Address(P_POSTALCD_01, "2");
        bM_Address2.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address2.setTodouhukencd(C_TodouhukenKbn.AOMORI);
        bizDomManager.insert(bM_Address2);

        BM_Address bM_Address3 = new BM_Address(P_POSTALCD_01, "3");
        bM_Address3.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YNOHENKOU);
        bM_Address3.setTodouhukencd(C_TodouhukenKbn.HOKKAIDOU);
        bizDomManager.insert(bM_Address3);

        BM_Address bM_Address4 = new BM_Address(P_POSTALCD_02, "1");
        bM_Address4.setKihontikucdsyoumetukbn(C_KihontikucdSyoumetuKbn.YUUKOUTYUU);
        bM_Address4.setTodouhukencd(C_TodouhukenKbn.HOKKAIDOU);
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

        C_TodouhukenKbn minTodouhukencd =
                bizDomManager.getAddressMinTodouhukencdByPostalCd(P_POSTALCD_01, C_KihontikucdSyoumetuKbn.SONOTA);

        Assert.assertNull(minTodouhukencd);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        C_TodouhukenKbn minTodouhukencd =
                bizDomManager.getAddressMinTodouhukencdByPostalCd(P_POSTALCD_01, C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertEquals(C_TodouhukenKbn.HOKKAIDOU, minTodouhukencd);
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        C_TodouhukenKbn minTodouhukencd =
                bizDomManager.getAddressMinTodouhukencdByPostalCd("", C_KihontikucdSyoumetuKbn.YUUKOUTYUU);

        Assert.assertNull(minTodouhukencd);
    }
}
