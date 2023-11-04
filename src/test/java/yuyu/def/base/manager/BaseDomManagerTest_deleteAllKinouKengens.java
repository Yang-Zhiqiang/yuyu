package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * deleteAllKinouKengens() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_deleteAllKinouKengens extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ){

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);
        }

        String pKinouModeId = "KMI0000001";

        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);
        if ( null == aS_KinouMode ){

            aS_KinouMode = aS_Kinou.createKinouMode();
            aS_KinouMode.setKinouModeId(pKinouModeId);

            baseDomManager.update(aS_Kinou);
        }

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";
        String pRoleCd3 = "RC0000003";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if (null == aM_Role1) {

            aM_Role1 = new AM_Role();
            aM_Role1.setRoleCd(pRoleCd1);

            baseDomManager.insert(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if (null == aM_Role2) {

            aM_Role2 = new AM_Role();
            aM_Role2.setRoleCd(pRoleCd2);

            baseDomManager.insert(aM_Role2);
        }

        AM_Role aM_Role3 = baseDomManager.getRole(pRoleCd3);
        if (null == aM_Role3) {

            aM_Role3 = new AM_Role();
            aM_Role3.setRoleCd(pRoleCd3);

            baseDomManager.insert(aM_Role3);
        }

        AT_KinouKengen aT_KinouKengen1 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd1);
        if ( null == aT_KinouKengen1 ){

            aT_KinouKengen1 = aS_KinouMode.createKinouKengen();
            aT_KinouKengen1.setRoleCd(pRoleCd1);

        }

        AT_KinouKengen aT_KinouKengen2 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd2);
        if ( null == aT_KinouKengen2 ){

            aT_KinouKengen2 = aS_KinouMode.createKinouKengen();
            aT_KinouKengen2.setRoleCd(pRoleCd2);

        }

        AT_KinouKengen aT_KinouKengen3 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd3);
        if ( null == aT_KinouKengen3 ){

            aT_KinouKengen3 = aS_KinouMode.createKinouKengen();
            aT_KinouKengen3.setRoleCd(pRoleCd3);

        }

        baseDomManager.update(aS_Kinou);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";
        String pRoleCd3 = "RC0000003";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if (null != aM_Role1) {

            baseDomManager.delete(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if (null != aM_Role2) {

            baseDomManager.delete(aM_Role2);
        }

        AM_Role aM_Role3 = baseDomManager.getRole(pRoleCd3);
        if (null != aM_Role3) {

            baseDomManager.delete(aM_Role3);
        }

        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null != aS_Kinou ){

            AS_KinouMode aS_KinouMode = aS_Kinou.getKinouMode(pKinouModeId);
            aS_KinouMode.getKinouKengens().removeAll(aS_KinouMode.getKinouKengens());
            aS_Kinou.getKinouModes().remove(aS_KinouMode);

            baseDomManager.update(aS_Kinou);
            baseDomManager.delete(aS_Kinou);
        }

    }

    @Test
    public void test001(){

        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);

        List<AT_KinouKengen> aT_KinouKengenList1 = aS_KinouMode.getKinouKengens();
        long count1 = aT_KinouKengenList1.size();

        aS_KinouMode.deleteAllKinouKengens();

        List<AT_KinouKengen> aT_KinouKengenList2 = aS_KinouMode.getKinouKengens();
        long count2 = aT_KinouKengenList2.size();

        assertNotEquals(count1, count2);
        assertEquals(3, count1 - count2);

    }

}
