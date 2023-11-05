package yuyu.def.db.entity;

import java.util.List;

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
 * 諾否決定テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getDakuhiKetteiByDakuhiktrenno {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    private final static String mosno1 = "10000000060";

    private final static Integer dakuhiktrenno1 = 1;
    private final static Integer dakuhiktrenno2 = 2;
    private final static Integer dakuhiktrenno3 = 3;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL(mosno1);
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL(mosno1);
            HT_DakuhiKettei dakuhiKettei = syoriCTL1.getDakuhiKetteiByDakuhiktrenno(dakuhiktrenno1);
            Assert.assertEquals(null, dakuhiKettei );

            HT_DakuhiKettei dakuhiKettei1 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei1.setMosno(mosno1);
            dakuhiKettei1.setDakuhiktrenno(dakuhiktrenno1);

            HT_DakuhiKettei dakuhiKettei2 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei2.setMosno(mosno1);
            dakuhiKettei2.setDakuhiktrenno(dakuhiktrenno2);
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
    public void noResult1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno1);

        HT_DakuhiKettei dakuhiKettei = syoriCTL.getDakuhiKetteiByDakuhiktrenno(dakuhiktrenno3);

        Assert.assertEquals(null, dakuhiKettei);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno1);

        HT_DakuhiKettei dakuhiKettei = syoriCTL.getDakuhiKetteiByDakuhiktrenno(dakuhiktrenno1);

        Assert.assertEquals(mosno1, dakuhiKettei.getMosno());
        Assert.assertEquals(dakuhiktrenno1, dakuhiKettei.getDakuhiktrenno());
        List<HT_DakuhiKettei> hT_DakuhiKetteis = syoriCTL.getDakuhiKetteis();
        hT_DakuhiKetteis.remove(dakuhiKettei);
        sinkeiyakuDomManager.update(syoriCTL);
    }

    @Test
    @TestOrder(30)
    public void noResult2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno1);
        HT_DakuhiKettei dakuhiKettei = syoriCTL.getDakuhiKetteiByDakuhiktrenno(dakuhiktrenno1);

        Assert.assertEquals(null, dakuhiKettei);

    }
}
