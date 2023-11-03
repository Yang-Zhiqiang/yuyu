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
import yuyu.def.db.entity.BM_RateV;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * Ｖレートマスタ(BM_RateV) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_RateVDetacherTest_detachRateVtouched {


    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateV rateV1 = new BM_RateV("11", "1", "111", "2", "1", "1", "200", "1", "11", "31");

        bizDomManager.insert(rateV1);

        BM_RateV rateV2 = new BM_RateV("12", "1", "111", "2", "1", "1", "200", "1", "11", "31");

        bizDomManager.insert(rateV2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllRateV());

    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_RateV rateV = bizDomManager.getRateV("11", "1", "111", "2", "1", "1", "200", "1", "11", "31");

        rateV = BM_RateVDetacher.detachRateVtouched(rateV);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(rateV);

        Assert.assertFalse(result);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_RateV rateV = bizDomManager.getRateV("13", "1", "111", "2", "1", "1", "200", "1", "11", "31");
        rateV = BM_RateVDetacher.detachRateVtouched(rateV);

        Assert.assertNull(rateV);
    }
}

