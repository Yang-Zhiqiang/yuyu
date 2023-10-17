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
import yuyu.def.db.entity.BM_RateNenkinD;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金開始後Ｄレートマスタ(BM_RateNenkinD) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_RateNenkinDDetacherTest_detachRateNenkinDtouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        BM_RateNenkinD rateNenkinD1 = new BM_RateNenkinD("1", "01", "1", "01", "01", "01", "2015", "1");

        bizDomManager.insert(rateNenkinD1);

        BM_RateNenkinD rateNenkinD2 = new BM_RateNenkinD("2", "01", "1", "01", "01", "01", "2015", "1");

        bizDomManager.insert(rateNenkinD2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRateNenkinD());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_RateNenkinD bM_RateNenkinD = bizDomManager.getRateNenkinD("1", "01", "1", "01", "01", "01", "2015", "1");

        if (bM_RateNenkinD != null) {
            bM_RateNenkinD = BM_RateNenkinDDetacher.detachRateNenkinDtouched(bM_RateNenkinD);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(bM_RateNenkinD);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_RateNenkinD bM_RateNenkinD = bizDomManager.getRateNenkinD("3", "01", "1", "01", "01", "01", "2015", "1");

        bM_RateNenkinD = BM_RateNenkinDDetacher.detachRateNenkinDtouched(bM_RateNenkinD);

        Assert.assertNull(bM_RateNenkinD);
    }
}
