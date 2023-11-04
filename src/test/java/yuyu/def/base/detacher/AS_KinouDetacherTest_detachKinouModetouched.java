package yuyu.def.base.detacher;

import java.util.Set;

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
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 保険金給付金備金情報抽出<br />
 * 機能基幹テーブル(AS_Kinou) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AS_KinouDetacherTest_detachKinouModetouched {

    @Inject
    BaseDomManager baseDomManager;

    static String P_KINOUID_01 = "KNID1";
    static String P_KINOUMODEID_01 = "KNMID1";
    static String P_KINOUMODEID_02 = "KNMID2";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AS_Kinou aS_Kinou = new AS_Kinou(P_KINOUID_01);

        AS_KinouMode aS_KinouMode1 = aS_Kinou.createKinouMode();
        aS_KinouMode1.setKinouModeId(P_KINOUMODEID_01);

        AS_KinouMode aS_KinouMode2 = aS_Kinou.createKinouMode();
        aS_KinouMode2.setKinouModeId(P_KINOUMODEID_02);

        baseDomManager.insert(aS_Kinou);
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

        AS_Kinou aS_Kinou = baseDomManager.getKinou(P_KINOUID_01);

        aS_Kinou = AS_KinouDetacher.detachKinouModetouched(aS_Kinou);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(aS_Kinou));

        Set<AS_KinouMode> aS_KinouModeList = aS_Kinou.getKinouModes();

        Assert.assertEquals(2, aS_KinouModeList.size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        AS_Kinou aS_Kinou = null;

        Assert.assertNull(AS_KinouDetacher.detachKinouModetouched(aS_Kinou));
    }
}
