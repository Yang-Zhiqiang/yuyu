package yuyu.batch.biz.bzmaster.bzginkoutorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzginkoutorikomi.BzGinkouTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGinkouTorikomiDaoクラスの、<br />
 * deleteGinkou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BzGinkouTorikomiDaoTest_deleteGinkou {
    @Inject
    private BzGinkouTorikomiDao bzGinkouTorikomiDao;
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        BM_Ginkou ginkou1 = new BM_Ginkou("1001", "101");

        em.persist(ginkou1);

        BM_Ginkou ginkou2 = new BM_Ginkou("1002", "102");

        em.persist(ginkou2);

        BM_Ginkou ginkou3 = new BM_Ginkou("1003", "103");

        em.persist(ginkou3);

        BM_Ginkou ginkou4 = new BM_Ginkou("1004", "104");

        em.persist(ginkou4);

        BM_Ginkou ginkou5 = new BM_Ginkou("1005", "105");

        em.persist(ginkou5);

    }

    @AfterClass
    @Transactional
    public static void TestDataDelete() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BM_Ginkou where bankcd like '0%'").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        bzGinkouTorikomiDao.deleteGinkou();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        assertEquals(0, bizDomManager.getAllGinkou().size());
    }

}
