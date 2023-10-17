package yuyu.def.base.detacher;

import java.util.ArrayList;
import java.util.List;

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
 * 操作者所属組織情報取得<br />
 * 組織マスタエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class AM_SosikiDetacherTest_detachSosikitouchedList {

    @Inject
    BaseDomManager baseDomManager;

    static String P_SOSIKICD_01 = "SCD0001";

    static String P_SOSIKICD_02 = "SCD0002";

    static String P_SOSIKICD_03 = "SCD0003";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.insert(new AM_Sosiki(P_SOSIKICD_01));

        baseDomManager.insert(new AM_Sosiki(P_SOSIKICD_02));

        baseDomManager.insert(new AM_Sosiki(P_SOSIKICD_03));
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

        List<AM_Sosiki> aM_Sosikis = baseDomManager.getAllSosikis();

        List<AM_Sosiki> entityList = AM_SosikiDetacher.detachSosikitouched(aM_Sosikis);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(AM_Sosiki entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<AM_Sosiki> aM_Sosikis = new ArrayList<>();
        aM_Sosikis.add(null);
        aM_Sosikis.add(null);

        List<AM_Sosiki> entityList = AM_SosikiDetacher.detachSosikitouched(aM_Sosikis);

        for(AM_Sosiki entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
