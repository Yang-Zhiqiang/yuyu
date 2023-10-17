package yuyu.batch.biz.bzmaster.bzidcardyakusyokutorikomi;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzidcardtorikomi.BzIdCardTorikomiDao;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzIdCardTorikomiDaoクラスの、<br />
 * deleteIdCardYakusyokuWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BzIdCardYakusyokuTorikomiDaoTest_deleteIdCardYakusyokuWk {
    @Inject
    private BzIdCardYakusyokuTorikomiDao bzIdCardYakusyokuTorikomiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BzIdCardYakusyokuTorikomiDao bzIdCardYakusyokuTorikomiDao = SWAKInjector.getInstance(BzIdCardYakusyokuTorikomiDao.class);
        bzIdCardYakusyokuTorikomiDao.deleteIdCardYakusyokuWk();

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {


        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        BW_IdCardYakusyokuWk idCardYakusyokuWk1 = new BW_IdCardYakusyokuWk("00","IDCD00", BizDate.valueOf(20150101), "00");

        em.persist(idCardYakusyokuWk1);

        BW_IdCardYakusyokuWk idCardYakusyokuWk2 = new BW_IdCardYakusyokuWk("01","IDCD01", BizDate.valueOf(20150102), "01");

        em.persist(idCardYakusyokuWk2);

        BW_IdCardYakusyokuWk idCardYakusyokuWk3 = new BW_IdCardYakusyokuWk("02","IDCD02", BizDate.valueOf(20150103), "02");

        em.persist(idCardYakusyokuWk3);

        BW_IdCardYakusyokuWk idCardYakusyokuWk4 = new BW_IdCardYakusyokuWk("03","IDCD03", BizDate.valueOf(20150104), "03");

        em.persist(idCardYakusyokuWk4);

        BW_IdCardYakusyokuWk idCardYakusyokuWk5 = new BW_IdCardYakusyokuWk("05","IDCD05", BizDate.valueOf(20150105), "05");

        em.persist(idCardYakusyokuWk5);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        bzIdCardYakusyokuTorikomiDao.deleteIdCardYakusyokuWk();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<BW_IdCardYakusyokuWk> BW_IdCardYakusyokuWkList = em.findAll(BW_IdCardYakusyokuWk.class);
        assertEquals(0, BW_IdCardYakusyokuWkList.size());
    }

    @Transactional
    public static void deleteTestSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BW_IdCardYakusyokuWk").executeUpdate();

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }


}
