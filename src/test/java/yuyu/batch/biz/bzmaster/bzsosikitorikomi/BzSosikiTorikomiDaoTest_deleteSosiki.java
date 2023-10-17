package yuyu.batch.biz.bzmaster.bzsosikitorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzsosikitorikomi.BzSosikiTorikomiDao;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（組織マスタ）<br />
 * deleteSosiki() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class BzSosikiTorikomiDaoTest_deleteSosiki {

    @Inject
    private BzSosikiTorikomiDao bzSosikiTorikomiDao;
    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AM_Sosiki aM_Sosiki1 = new AM_Sosiki("0111111");

        baseDomManager.insert(aM_Sosiki1);

        AM_Sosiki aM_Sosiki2 = new AM_Sosiki("0222222");

        baseDomManager.insert(aM_Sosiki2);

        AM_Sosiki aM_Sosiki3 = new AM_Sosiki("0333333");

        baseDomManager.insert(aM_Sosiki3);

        AM_Sosiki aM_Sosiki4 = new AM_Sosiki("0444444");

        baseDomManager.insert(aM_Sosiki4);

        AM_Sosiki aM_Sosiki5 = new AM_Sosiki("0555555");

        baseDomManager.insert(aM_Sosiki5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        bzSosikiTorikomiDao.deleteSosiki();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(0, baseDomManager.getAllSosikis().size());
    }
}
