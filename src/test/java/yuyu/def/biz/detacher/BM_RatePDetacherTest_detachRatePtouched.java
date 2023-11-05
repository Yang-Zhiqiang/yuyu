package yuyu.def.biz.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateP;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * Ｐレートマスタ(BM_RateP) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_RatePDetacherTest_detachRatePtouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateP rateP1 = new BM_RateP("11", "1", "101", "1", "1", "1", "120", "1", "11", "11");

        bizDomManager.insert(rateP1);

        BM_RateP rateP2 = new BM_RateP("22", "1", "101", "1", "1", "1", "120", "1", "11", "11");

        bizDomManager.insert(rateP2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRateP());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_RateP bM_RateP = bizDomManager.getRateP("11", "1", "101", "1", "1", "1", "120", "1", "11", "11");

        if (bM_RateP != null) {
            bM_RateP = BM_RatePDetacher.detachRatePtouched(bM_RateP);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(bM_RateP);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_RateP bM_RateP = bizDomManager.getRateP("33", "1", "101", "1", "1", "1", "120", "1", "11", "11");

        bM_RateP = BM_RatePDetacher.detachRatePtouched(bM_RateP);

        Assert.assertNull(bM_RateP);
    }

}
