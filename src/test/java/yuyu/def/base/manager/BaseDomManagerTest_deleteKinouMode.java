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
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * deleteKinouMode() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_deleteKinouMode extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ) {

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);
        }

        String pKinouModeId1 = "KMI0000001";
        String pKinouModeId2 = "KMI0000002";
        String pKinouModeId3 = "KMI0000003";

        AS_KinouMode aS_KinouMode1 = aS_Kinou.getKinouMode(pKinouModeId1);
        if ( null == aS_KinouMode1 ) {

            aS_KinouMode1 = aS_Kinou.createKinouMode();
            aS_KinouMode1.setKinouModeId(pKinouModeId1);

        }

        AS_KinouMode aS_KinouMode2 = aS_Kinou.getKinouMode(pKinouModeId2);
        if ( null == aS_KinouMode2 ) {

            aS_KinouMode2 = aS_Kinou.createKinouMode();
            aS_KinouMode2.setKinouModeId(pKinouModeId2);

        }

        AS_KinouMode aS_KinouMode3 = aS_Kinou.getKinouMode(pKinouModeId3);
        if ( null == aS_KinouMode3 ) {

            aS_KinouMode3 = aS_Kinou.createKinouMode();
            aS_KinouMode3.setKinouModeId(pKinouModeId3);

        }

        baseDomManager.update(aS_Kinou);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null != aS_Kinou ) {

            aS_Kinou.getKinouModes().removeAll(aS_Kinou.getKinouModes());

            baseDomManager.update(aS_Kinou);
            baseDomManager.delete(aS_Kinou);
        }

    }

    @Test
    public void test001(){
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        AS_KinouMode aS_KinouMode1 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);
        baseDomManager.getKinou(pKinouId).deleteKinouMode(pKinouModeId);
        AS_KinouMode aS_KinouMode2 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);

        assertNotEquals(aS_KinouMode1, aS_KinouMode2);
        assertNull(aS_KinouMode2);

    }
}
