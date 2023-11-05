package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約不備テーブルテーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getSkHubiByHubisikibetukey {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("800000001");
            HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("20150101");
            Assert.assertEquals(null, skHubi);

            HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
            skHubi1.setHubisikibetukey("20150101");

            HT_SkHubi skHubi2 = syoriCTL1.createSkHubi();
            skHubi2.setHubisikibetukey("20150102");

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("800000002");

        if(syoriCTL2 == null) {

            syoriCTL2 = new HT_SyoriCTL("800000002");
            HT_SkHubi skHubi1 = syoriCTL2.createSkHubi();
            skHubi1.setHubisikibetukey("20150101");

            sinkeiyakuDomManager.insert(syoriCTL2);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noresult1() {

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000002");
        HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("20150103");
        Assert.assertEquals(null, skHubi);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");
        HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("20150101");
        Assert.assertEquals("800000001", skHubi.getMosno());
        Assert.assertEquals("20150101", skHubi.getHubisikibetukey());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");
        HT_SkHubi skHubi = syoriCTL1.getSkHubiByHubisikibetukey("");
        Assert.assertEquals(null, skHubi);

    }

}
