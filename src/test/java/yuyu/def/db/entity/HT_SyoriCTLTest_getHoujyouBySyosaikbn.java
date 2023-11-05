package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 報状テーブルテーブル取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHoujyouBySyosaikbn {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("800000001");

            HT_Houjyou houjyou = syoriCTL1.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);
            Assert.assertEquals(null, houjyou);

            HT_Houjyou houjyou1 = syoriCTL1.createHoujyou();
            houjyou1.setSyosaikbn(C_SyosaiKbn.SOYSIN);

            HT_Houjyou houjyou2 = syoriCTL1.createHoujyou();
            houjyou2.setSyosaikbn(C_SyosaiKbn.SAISIN);

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("800000002");

        if(syoriCTL2 == null) {

            syoriCTL2 = new HT_SyoriCTL("800000002");
            HT_Houjyou houjyou1 = syoriCTL2.createHoujyou();
            houjyou1.setSyosaikbn(C_SyosaiKbn.SOYSIN);

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
        HT_Houjyou houjyou = syoriCTL1.getHoujyouBySyosaikbn(C_SyosaiKbn.SAISIN);
        Assert.assertEquals(null, houjyou);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");
        HT_Houjyou houjyou = syoriCTL1.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);
        Assert.assertEquals("800000001", houjyou.getMosno());
        Assert.assertEquals(C_SyosaiKbn.SOYSIN, houjyou.getSyosaikbn());
    }

}
