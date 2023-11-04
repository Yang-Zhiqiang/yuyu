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
import yuyu.def.db.entity.BM_SosikiMadoguti;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 組織窓口情報マスタ(BM_SosikiMadoguti) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_SosikiMadogutiDetacherTest_detachSosikiMadogutitouched {

    private static final int DATA_CNT = 2;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        for (int index = 1; index <= DATA_CNT; index++) {
            BM_SosikiMadoguti sosikiMadoguti = new BM_SosikiMadoguti();

            sosikiMadoguti.setSskmdsosikicd(String.valueOf(index));

            bizDomManager.insert(sosikiMadoguti);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        for (int index = 1; index <= DATA_CNT; index++) {
            BM_SosikiMadoguti sosikiMadoguti = bizDomManager.getSosikiMadoguti(String.valueOf(index));

            bizDomManager.delete(sosikiMadoguti);
        }
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_SosikiMadoguti sosikiMadoguti = bizDomManager.getSosikiMadoguti("1");

        if (sosikiMadoguti != null) {
            sosikiMadoguti = BM_SosikiMadogutiDetacher.detachSosikiMadogutitouched(sosikiMadoguti);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(sosikiMadoguti);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_SosikiMadoguti sosikiMadoguti = bizDomManager.getSosikiMadoguti("3");

        sosikiMadoguti = BM_SosikiMadogutiDetacher.detachSosikiMadogutitouched(sosikiMadoguti);

        Assert.assertNull(sosikiMadoguti);
    }
}
