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
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金開始後Ｐ基礎Ｖレートマスタ(BM_RateNenkinPkisoV) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_RateNenkinPkisoVDetacherTest_detachRateNenkinPkisoVtouched {


    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_RateNenkinPkisoV rateNenkinPkisoV1 = new BM_RateNenkinPkisoV("1", "11", "1", "22", "11", "11");

        bizDomManager.insert(rateNenkinPkisoV1);

        BM_RateNenkinPkisoV rateNenkinPkisoV2 = new BM_RateNenkinPkisoV("2", "11", "1", "22", "11", "11");

        bizDomManager.insert(rateNenkinPkisoV2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllRateNenkinPkisoV());

    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_RateNenkinPkisoV rateNenkinPkisoV = bizDomManager.getRateNenkinPkisoV("1", "11", "1", "22", "11", "11");

        rateNenkinPkisoV = BM_RateNenkinPkisoVDetacher.detachRateNenkinPkisoVtouched(rateNenkinPkisoV);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(rateNenkinPkisoV);

        Assert.assertFalse(result);

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_RateNenkinPkisoV rateNenkinPkisoV = bizDomManager.getRateNenkinPkisoV("3", "11", "1", "22", "11", "11");
        rateNenkinPkisoV = BM_RateNenkinPkisoVDetacher.detachRateNenkinPkisoVtouched(rateNenkinPkisoV);

        Assert.assertNull(rateNenkinPkisoV);
    }
}

