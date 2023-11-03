package yuyu.batch.biz.bzmaster.bzidcardtorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzIdCardTorikomiDaoクラスの、<br />
 * deleteIdCardWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BzIdCardTorikomiDaoTest_deleteIdCardWk {
    @Inject
    private BzIdCardTorikomiDao bzIdCardTorikomiDao;
    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BzIdCardTorikomiDao bzIdCardTorikomiDao = SWAKInjector.getInstance(BzIdCardTorikomiDao.class);
        bzIdCardTorikomiDao.deleteIdCardWk();

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("01", "100001");

        em.persist(idCardWk1);

        BW_IdCardWk idCardWk2 = new BW_IdCardWk("02", "100002");

        em.persist(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("03", "100003");

        em.persist(idCardWk3);

        BW_IdCardWk idCardWk4 = new BW_IdCardWk("05", "100004");

        em.persist(idCardWk4);

        BW_IdCardWk idCardWk5 = new BW_IdCardWk("07", "100005");

        em.persist(idCardWk5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        bzIdCardTorikomiDao.deleteIdCardWk();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        assertEquals(0, bizDomManager.getAllIdCardWk().size());
    }

    @Transactional
    public static void deleteTestSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BW_IdCardWk").executeUpdate();

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
