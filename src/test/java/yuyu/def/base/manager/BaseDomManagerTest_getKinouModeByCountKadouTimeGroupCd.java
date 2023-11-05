package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getKinouModeByCountKadouTimeGroupCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getKinouModeByCountKadouTimeGroupCd extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ) {

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ) {

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);

            baseDomManager.insert(aS_Kinou2);
        }

        String pKadouTimeGroupCd1 = "KGC0000001";
        String pKadouTimeGroupCd2 = "KGC0000002";

        AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
        if ( null == aT_KadouTimeGroup1 ) {

            aT_KadouTimeGroup1 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup1.setKadouTimeGroupCd(pKadouTimeGroupCd1);

            baseDomManager.insert(aT_KadouTimeGroup1);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
        if ( null == aT_KadouTimeGroup2 ) {

            aT_KadouTimeGroup2 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup2.setKadouTimeGroupCd(pKadouTimeGroupCd2);

            baseDomManager.insert(aT_KadouTimeGroup2);
        }

        String pKinouModeId1 = "KMI0000001";
        String pKinouModeId2 = "KMI0000002";
        String pKinouModeId3 = "KMI0000003";
        String pKinouModeId4 = "KMI0000004";

        AS_KinouMode aS_KinouMode1 = aS_Kinou1.getKinouMode(pKinouModeId1);
        if ( null == aS_KinouMode1 ) {

            aS_KinouMode1 = aS_Kinou1.createKinouMode();
            aS_KinouMode1.setKinouModeId(pKinouModeId1);
            aS_KinouMode1.setKadouTimeGroupCd(pKadouTimeGroupCd1);

        }

        baseDomManager.update(aS_Kinou1);

        AS_KinouMode aS_KinouMode2 = aS_Kinou2.getKinouMode(pKinouModeId2);
        if ( null == aS_KinouMode2 ) {

            aS_KinouMode2 = aS_Kinou2.createKinouMode();
            aS_KinouMode2.setKinouModeId(pKinouModeId2);
            aS_KinouMode2.setKadouTimeGroupCd(pKadouTimeGroupCd2);

        }

        AS_KinouMode aS_KinouMode3 = aS_Kinou2.getKinouMode(pKinouModeId3);
        if ( null == aS_KinouMode3 ) {

            aS_KinouMode3 = aS_Kinou2.createKinouMode();
            aS_KinouMode3.setKinouModeId(pKinouModeId3);
            aS_KinouMode3.setKadouTimeGroupCd(pKadouTimeGroupCd2);

        }

        AS_KinouMode aS_KinouMode4 = aS_Kinou2.getKinouMode(pKinouModeId4);
        if ( null == aS_KinouMode4 ) {

            aS_KinouMode4 = aS_Kinou2.createKinouMode();
            aS_KinouMode4.setKinouModeId(pKinouModeId4);
            aS_KinouMode4.setKadouTimeGroupCd(pKadouTimeGroupCd2);

        }

        baseDomManager.update(aS_Kinou2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            aS_Kinou1.getKinouModes().removeAll(aS_Kinou1.getKinouModes());

            baseDomManager.update(aS_Kinou1);
            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            aS_Kinou2.getKinouModes().removeAll(aS_Kinou2.getKinouModes());

            baseDomManager.update(aS_Kinou2);
            baseDomManager.delete(aS_Kinou2);
        }

        String pKadouTimeGroupCd1 = "KGC0000001";
        String pKadouTimeGroupCd2 = "KGC0000002";

        AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
        if ( null != aT_KadouTimeGroup1 ) {

            baseDomManager.delete(aT_KadouTimeGroup1);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
        if ( null != aT_KadouTimeGroup2 ) {

            baseDomManager.delete(aT_KadouTimeGroup2);
        }

    }

    @Test
    public void test001(){
        String pKadouTimeGroupCd = "KGC0000099";
        long count = baseDomManager.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        String pKadouTimeGroupCd = "KGC0000001";
        long count = baseDomManager.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

        assertEquals(1, count);

    }

    @Test
    public void test003(){
        String pKadouTimeGroupCd = "KGC0000002";
        long count = baseDomManager.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

        assertEquals(3, count);

    }

    @Test
    public void test004(){
        String pKadouTimeGroupCd = "";
        long count = baseDomManager.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

        assertEquals(0, count);

    }

    @Test
    public void test005(){
        String pKadouTimeGroupCd = null;
        long count = baseDomManager.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

        assertEquals(0, count);

    }
}
