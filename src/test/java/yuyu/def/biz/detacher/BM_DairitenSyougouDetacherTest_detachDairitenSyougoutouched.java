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
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代理店法人商号マスタ(BM_DairitenSyougou) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_DairitenSyougouDetacherTest_detachDairitenSyougoutouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_DairitenSyougou dairitenSyougou1 = new BM_DairitenSyougou("1011111");

        bizDomManager.insert(dairitenSyougou1);

        BM_DairitenSyougou dairitenSyougou2 = new BM_DairitenSyougou("2011111");

        bizDomManager.insert(dairitenSyougou2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairitenSyougou());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        BM_DairitenSyougou bM_DairitenSyougou = bizDomManager.getDairitenSyougou("1011111");

        bM_DairitenSyougou = BM_DairitenSyougouDetacher.detachDairitenSyougoutouched(bM_DairitenSyougou);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        boolean result = em.getEntityManager().contains(bM_DairitenSyougou);

        Assert.assertFalse(result);

    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_DairitenSyougou bM_DairitenSyougou = bizDomManager.getDairitenSyougou("3011111");

        bM_DairitenSyougou = BM_DairitenSyougouDetacher.detachDairitenSyougoutouched(bM_DairitenSyougou);

        Assert.assertNull(bM_DairitenSyougou);
    }
}
