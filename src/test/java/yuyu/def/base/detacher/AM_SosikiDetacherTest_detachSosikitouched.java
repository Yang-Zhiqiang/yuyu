package yuyu.def.base.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 組織情報取得<br />
 * 組織マスタエンティティデタッチをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class AM_SosikiDetacherTest_detachSosikitouched {

    @Inject
    BaseDomManager baseDomManager;

    static String P_SOSIKICD_01 = "SCD0001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.insert(new AM_Sosiki(P_SOSIKICD_01));

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllSosikis());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        AM_Sosiki aM_Sosiki = baseDomManager.getSosiki(P_SOSIKICD_01);

        AM_Sosiki entity = AM_SosikiDetacher.detachSosikitouched(aM_Sosiki);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        AM_Sosiki aM_Sosiki = null;

        Assert.assertNull(AM_SosikiDetacher.detachSosikitouched(aM_Sosiki));
    }
}
