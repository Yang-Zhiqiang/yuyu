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
 * 申込商品テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosSyouhnBySyouhncd {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("10012002");

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("10012002");
            HT_MosSyouhn mosSyouhn = syoriCTL1.getMosSyouhnBySyouhncd("A10");
            Assert.assertEquals(null, mosSyouhn);

            HT_MosSyouhn mosSyouhn1 = syoriCTL1.createMosSyouhn();
            mosSyouhn1.setSyouhncd("A10");

            HT_MosSyouhn mosSyouhn2 = syoriCTL1.createMosSyouhn();
            mosSyouhn2.setSyouhncd("A11");

            sinkeiyakuDomManager.insert(syoriCTL1);

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

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10012002");
        HT_MosSyouhn mosSyouhn = syoriCtl.getMosSyouhnBySyouhncd("A13");

        Assert.assertEquals(null, mosSyouhn);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10012002");
        HT_MosSyouhn mosSyouhn = syoriCtl.getMosSyouhnBySyouhncd("A10");

        Assert.assertEquals("10012002", mosSyouhn.getMosno());
        Assert.assertEquals("A10", mosSyouhn.getSyouhncd());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10012002");
        HT_MosSyouhn mosSyouhn = syoriCtl.getMosSyouhnBySyouhncd("");

        Assert.assertEquals(null, mosSyouhn);

    }

}
