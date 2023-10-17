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
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 募集人マスタ(BM_Bosyuunin) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_BosyuuninDetacherTest_detachBosyuunintouched {

    private static final int DATA_CNT = 2;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        for (int index = 1; index <= DATA_CNT; index++) {
            BM_Bosyuunin bosyuunin = new BM_Bosyuunin();

            bosyuunin.setBosyuucd(String.valueOf(index));

            bizDomManager.insert(bosyuunin);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        for (int index = 1; index <= DATA_CNT; index++) {
            BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin(String.valueOf(index));

            bizDomManager.delete(bosyuunin);
        }
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin("1");

        if (bosyuunin != null) {
            bosyuunin = BM_BosyuuninDetacher.detachBosyuunintouched(bosyuunin);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(bosyuunin);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_Bosyuunin bosyuunin = bizDomManager.getBosyuunin("3");

        bosyuunin = BM_BosyuuninDetacher.detachBosyuunintouched(bosyuunin);

        Assert.assertNull(bosyuunin);
    }
}
