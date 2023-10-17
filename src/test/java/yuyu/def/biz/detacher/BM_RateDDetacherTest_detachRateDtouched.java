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
import yuyu.def.db.entity.BM_RateD;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * Ｄレートマスタ(BM_RateD) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_RateDDetacherTest_detachRateDtouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RateD rateD1 = new BM_RateD("01", "1", "101", "1", "1", "1", "110", "1", "11", "12", "2001", "1");

        bizDomManager.insert(rateD1);

        BM_RateD rateD2 = new BM_RateD("02", "1", "101", "1", "1", "1", "110", "1", "11", "12", "2001", "1");

        bizDomManager.insert(rateD2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRateD());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_RateD bM_RateD = bizDomManager.getRateD("01", "1", "101", "1", "1", "1", "110", "1", "11", "12", "2001", "1");

        if (bM_RateD != null) {
            bM_RateD = BM_RateDDetacher.detachRateDtouched(bM_RateD);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(bM_RateD);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_RateD bM_RateD = bizDomManager.getRateD("03", "1", "101", "1", "1", "1", "110", "1", "11", "12","2001","1");

        bM_RateD = BM_RateDDetacher.detachRateDtouched(bM_RateD);

        Assert.assertNull(bM_RateD);
    }
}
