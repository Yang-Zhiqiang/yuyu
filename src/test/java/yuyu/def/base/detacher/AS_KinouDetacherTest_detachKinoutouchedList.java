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
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 機能基幹テーブル(AS_Kinou) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AS_KinouDetacherTest_detachKinoutouchedList {

    @Inject
    BaseDomManager baseDomManager;

    static String P_KINOUID_01 = "KNID1";
    static String P_KINOUID_02 = "KNID2";
    static String P_KINOUID_03 = "KNID3";


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AS_Kinou aS_Kinou1 = new AS_Kinou(P_KINOUID_01);
        AS_Kinou aS_Kinou2 = new AS_Kinou(P_KINOUID_02);
        AS_Kinou aS_Kinou3 = new AS_Kinou(P_KINOUID_03);

        baseDomManager.insert(aS_Kinou1);
        baseDomManager.insert(aS_Kinou2);
        baseDomManager.insert(aS_Kinou3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllKinous());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        List<AS_Kinou> aS_Kinous = baseDomManager.getAllKinous();

        List<AS_Kinou> entityList = AS_KinouDetacher.detachKinoutouched(aS_Kinous);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(AS_Kinou entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<AS_Kinou> aS_Kinous = new ArrayList<>();
        aS_Kinous.add(null);
        aS_Kinous.add(null);

        List<AS_Kinou> entityList = AS_KinouDetacher.detachKinoutouched(aS_Kinous);

        for(AS_Kinou entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
