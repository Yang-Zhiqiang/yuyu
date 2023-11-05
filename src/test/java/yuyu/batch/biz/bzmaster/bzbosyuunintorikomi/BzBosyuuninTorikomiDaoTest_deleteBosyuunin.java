package yuyu.batch.biz.bzmaster.bzbosyuunintorikomi;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzbosyuunintorikomi.BzBosyuuninTorikomiDao;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzBosyuuninTorikomiDaoクラスの、<br />
 * deleteBosyuunin() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BzBosyuuninTorikomiDaoTest_deleteBosyuunin {
    @Inject
    private BzBosyuuninTorikomiDao bzBosyuuninTorikomiDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        BM_Bosyuunin bosyuunin1 = new BM_Bosyuunin("100000");
        em.persist(bosyuunin1);

        BM_Bosyuunin bosyuunin2 = new BM_Bosyuunin("200000");
        em.persist(bosyuunin2);

        BM_Bosyuunin bosyuunin3 = new BM_Bosyuunin("300000");
        em.persist(bosyuunin3);

        BM_Bosyuunin bosyuunin4 = new BM_Bosyuunin("400000");
        em.persist(bosyuunin4);

        BM_Bosyuunin bosyuunin5 = new BM_Bosyuunin("500000");
        em.persist(bosyuunin5);

    }

    @AfterClass
    @Transactional
    public static void TestDataDelete() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BM_Bosyuunin where bosyuucd like '0%'").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        bzBosyuuninTorikomiDao.deleteBosyuunin();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_002() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<BM_Bosyuunin> bosyuuninList = em.findAll(BM_Bosyuunin.class);
        assertEquals(0, bosyuuninList.size());
    }

}
