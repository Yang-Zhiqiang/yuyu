package yuyu.batch.biz.bzmaster.bzkinyuukikanhuhoyohuriinfotorikomi;

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

import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzKinyuuKikanHuhoyohuriInfoTorikomiDaoクラスの<br />
 * deleteKinyuuKikanHuhoyohuriInfo() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKinyuuKikanHuhoyohuriInfoTorikomiDao_deleteKinyuuKikanHuhoyohuriInfo {
    @Inject
    private BzKinyuuKikanHuhoyohuriInfoTorikomiDao bzKinyuuKikanHuhoyohuriInfoTorikomiDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan1 = new BM_KinyuuKikanHuhoyofuriInfo("1001");

        em.persist(kinyuuKikan1);

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan2 = new BM_KinyuuKikanHuhoyofuriInfo("1002");

        em.persist(kinyuuKikan2);

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan3 = new BM_KinyuuKikanHuhoyofuriInfo("1003");

        em.persist(kinyuuKikan3);

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan4 = new BM_KinyuuKikanHuhoyofuriInfo("1004");

        em.persist(kinyuuKikan4);

        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan5 = new BM_KinyuuKikanHuhoyofuriInfo("1005");

        em.persist(kinyuuKikan5);

    }

    @AfterClass
    @Transactional
    public static void TestDataDelete() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BM_KinyuuKikanHuhoyofuriInfo where bankcd like '0%'").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        bzKinyuuKikanHuhoyohuriInfoTorikomiDao.deleteKinyuuKikanHuhoyohuriInfo();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<BM_KinyuuKikanHuhoyofuriInfo> kinyuuList= em.findAll(BM_KinyuuKikanHuhoyofuriInfo.class);
        assertEquals(0, kinyuuList.size());
    }
}
