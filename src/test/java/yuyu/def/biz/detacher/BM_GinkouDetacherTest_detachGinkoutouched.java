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
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 銀行マスタ(BM_Ginkou) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_GinkouDetacherTest_detachGinkoutouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_Ginkou ginkou1 = new BM_Ginkou("1011", "111");

        bizDomManager.insert(ginkou1);

        BM_Ginkou ginkou2 = new BM_Ginkou("1002", "222");

        bizDomManager.insert(ginkou2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_Ginkou bM_Ginkou = bizDomManager.getGinkou("1011", "111");

        bM_Ginkou = BM_GinkouDetacher.detachGinkoutouched(bM_Ginkou);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(bM_Ginkou);

        Assert.assertFalse(result);

    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_Ginkou bM_Ginkou = bizDomManager.getGinkou("2011", "111");

        bM_Ginkou = BM_GinkouDetacher.detachGinkoutouched(bM_Ginkou);

        Assert.assertNull(bM_Ginkou);
    }
}
