package yuyu.batch.direct.dskokyakukanri.dskaripasswordtuutisakusei;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮パスワード通知テーブル（中）のテストクラス <br />
 * deleteDsKariPasswordTuutiTy() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DsKariPasswordTuutiSakuseiDaoTest_deleteDsKariPasswordTuutiTy {

    @Inject
    private DsKariPasswordTuutiSakuseiDao dsKariPasswordTuutiSakuseiDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy1 = new ZT_DsKariPasswordTuutiTy("abc123");

        em.persist(dsKariPasswordTuutiTy1);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy2 = new ZT_DsKariPasswordTuutiTy("abc132");

        em.persist(dsKariPasswordTuutiTy2);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy3 = new ZT_DsKariPasswordTuutiTy("abc231");

        em.persist(dsKariPasswordTuutiTy3);

        ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy4 = new ZT_DsKariPasswordTuutiTy("abc321");

        em.persist(dsKariPasswordTuutiTy4);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        dsKariPasswordTuutiSakuseiDao.deleteDsKariPasswordTuutiTy();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        List<ZT_DsKariPasswordTuutiTy> dsKariPasswordTuutiTyList = em.findAll(ZT_DsKariPasswordTuutiTy.class);
        assertEquals(0, dsKariPasswordTuutiTyList.size());
    }
}
