package yuyu.batch.biz.bzmaster.bzbyoumeitorikomi;

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

import yuyu.batch.biz.bzmaster.bzbyoumeitorikomi.BzByoumeiTorikomiDao;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzByoumeiTorikomiDaoクラスの、<br />
 * deleteByoumei() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BzByoumeiTorikomiDaoTest_deleteByoumei {
    @Inject
    private BzByoumeiTorikomiDao bzByoumeiTorikomiDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        JM_Byoumei byoumei1 = new JM_Byoumei("100000");
        em.persist(byoumei1);

        JM_Byoumei byoumei2 = new JM_Byoumei("200000");
        em.persist(byoumei2);

        JM_Byoumei byoumei3 = new JM_Byoumei("300000");
        em.persist(byoumei3);

        JM_Byoumei byoumei4 = new JM_Byoumei("400000");
        em.persist(byoumei4);

        JM_Byoumei byoumei5 = new JM_Byoumei("500000");
        em.persist(byoumei5);

    }

    @AfterClass
    @Transactional
    public static void TestDataDelete() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from JM_Byoumei where byoumeitourokuno like '0%'").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        bzByoumeiTorikomiDao.deleteByoumei();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_002() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<JM_Byoumei> byoumeiList = em.findAll(JM_Byoumei.class);
        assertEquals(0, byoumeiList.size());
    }

}
