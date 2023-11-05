package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 諾否決定テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getDakuhiKetteiByMosnoMaxDakuhiktrenno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("791112220");

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno("791112220");
        Assert.assertEquals(null, hT_DakuhiKettei);

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("791112220");

            HT_DakuhiKettei dakuhiKettei1 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei1.setDakuhiktrenno(11);

            HT_DakuhiKettei dakuhiKettei2 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei2.setDakuhiktrenno(12);

            HT_DakuhiKettei dakuhiKettei3 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei3.setDakuhiktrenno(15);

            HT_DakuhiKettei dakuhiKettei4 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei4.setDakuhiktrenno(14);

            sinkeiyakuDomManager.insert(syoriCTL1);

            HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112261");

            sinkeiyakuDomManager.insert(syoriCTL2);

            HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112253");

            HT_DakuhiKettei dakuhiKettei5 = syoriCTL3.createDakuhiKettei();
            dakuhiKettei5.setDakuhiktrenno(16);

            sinkeiyakuDomManager.insert(syoriCTL3);

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
    public void noResult() {

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno("791112303");
        Assert.assertEquals(null, hT_DakuhiKettei);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno("791112220");

        Assert.assertEquals("791112220", hT_DakuhiKettei.getMosno());
        Assert.assertEquals(15, hT_DakuhiKettei.getDakuhiktrenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void blankCondition() {

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.getDakuhiKetteiByMosnoMaxDakuhiktrenno("");
        Assert.assertEquals(null, hT_DakuhiKettei);

    }

}
