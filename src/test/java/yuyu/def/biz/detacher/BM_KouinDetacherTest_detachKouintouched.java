package yuyu.def.biz.detacher;

import java.util.ArrayList;
import java.util.List;

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
import yuyu.def.db.entity.BM_Kouin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 行員マスタ(BM_Kouin) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_KouinDetacherTest_detachKouintouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_Kouin bM_Kouin1 = new BM_Kouin();

        bM_Kouin1.setKinyuucd("1");
        bM_Kouin1.setKouincd("1");
        bM_Kouin1.setBosyuucd("1");

        bizDomManager.insert(bM_Kouin1);

        BM_Kouin bM_Kouin2 = new BM_Kouin();

        bM_Kouin2.setKinyuucd("1");
        bM_Kouin2.setKouincd("2");
        bM_Kouin2.setBosyuucd("1");
        bizDomManager.insert(bM_Kouin2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("1");

        bizDomManager.delete(kouinLst);

    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        List<BM_Kouin> kouinLst = bizDomManager.getKouinsBybosyuucd("1");

        BM_Kouin kouin = kouinLst.get(0);

        if (kouin != null) {
            kouin = BM_KouinDetacher.detachKouintouched(kouin);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(kouin);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BM_Kouin> kouinLst = new ArrayList<>();

        for (int i = 0; i <= 1; i++) {

            kouinLst.add(null);

        }

        BM_Kouin kouin = BM_KouinDetacher.detachKouintouched(kouinLst.get(0));

        Assert.assertNull(kouin);
    }
}
