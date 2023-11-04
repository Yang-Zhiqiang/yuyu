package yuyu.batch.suuri.srkessan.srskkessandataretentionperiod;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrSkKessanDataRetentionPeriodDaoクラスの、<br />
 * deleteSkOikmSyukeiPDenpyou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSkKessanDataRetentionPeriodDaoTest_deleteSkOikmSyukeiPDenpyou {
    @Inject
    private SrSkKessanDataRetentionPeriodDao srSkKessanDataRetentionPeriodDao;
    @Inject
    private SuuriDomManager suuriDomManager;
    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou1 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.valueOf("0"), "1001", 0);

        em.persist(skOikmSyukeiPDenpyou1);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou2 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.valueOf("10"), "1002", 1);

        em.persist(skOikmSyukeiPDenpyou2);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou3 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.valueOf("20"), "1003", 2);

        em.persist(skOikmSyukeiPDenpyou3);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou4 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.valueOf("30"), "1004", 3);

        em.persist(skOikmSyukeiPDenpyou4);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou5 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.valueOf("40"), "1005", 4);

        em.persist(skOikmSyukeiPDenpyou5);

    }

    @AfterClass
    @Transactional
    public static void TestDataDelete() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from ST_SkOikmSyukeiPDenpyou").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        srSkKessanDataRetentionPeriodDao.deleteSkOikmSyukeiPDenpyou();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        assertEquals(0, suuriDomManager.getAllSkOikmSyukeiPDenpyou().size());
    }

}
