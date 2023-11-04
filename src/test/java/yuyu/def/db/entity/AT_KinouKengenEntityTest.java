package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 機能権限テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_KinouKengenEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

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
        String pRoleCd4 = "RC0000004";
        String pRoleCd5 = "RC0000005";

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

        AM_Role aM_Role4 = baseDomManager.getRole(pRoleCd4);
        if (null == aM_Role4) {

            aM_Role4 = new AM_Role();
            aM_Role4.setRoleCd(pRoleCd4);

            baseDomManager.insert(aM_Role4);
        }

        AM_Role aM_Role5 = baseDomManager.getRole(pRoleCd5);
        if (null == aM_Role5) {

            aM_Role5 = new AM_Role();
            aM_Role5.setRoleCd(pRoleCd5);

            baseDomManager.insert(aM_Role5);
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

        AT_KinouKengen aT_KinouKengen4 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd4);
        if ( null == aT_KinouKengen4 ){

            aT_KinouKengen4 = aS_KinouMode.createKinouKengen();
            aT_KinouKengen4.setRoleCd(pRoleCd4);

        }

        AT_KinouKengen aT_KinouKengen5 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd5);
        if ( null == aT_KinouKengen5 ){

            aT_KinouKengen5 = aS_KinouMode.createKinouKengen();
            aT_KinouKengen5.setRoleCd(pRoleCd5);

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
        String pRoleCd4 = "RC0000004";
        String pRoleCd5 = "RC0000005";

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

        AM_Role aM_Role4 = baseDomManager.getRole(pRoleCd4);
        if (null != aM_Role4) {

            baseDomManager.delete(aM_Role4);
        }

        AM_Role aM_Role5 = baseDomManager.getRole(pRoleCd5);
        if (null != aM_Role5) {

            baseDomManager.delete(aM_Role5);
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

    @Override
    @Test
    public void getAll() {

        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        List<AT_KinouKengen> kinouKengenList = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengens();

        List<AT_KinouKengen> resultKinouKengenList = ImmutableList.copyOf(Iterables.filter(kinouKengenList, new Predicate<AT_KinouKengen>() {

            @Override
            public boolean apply(AT_KinouKengen pKinouKengenEntity) {

                List<String> pRoleCdList = new ArrayList<String>();
                pRoleCdList.add("RC0000001");
                pRoleCdList.add("RC0000002");
                pRoleCdList.add("RC0000003");
                pRoleCdList.add("RC0000004");
                pRoleCdList.add("RC0000005");

                for ( String roleCd : pRoleCdList ){
                    if ( roleCd.equals(pKinouKengenEntity.getRoleCd())){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultKinouKengenList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pRoleCd = "RC0000001";
        AT_KinouKengen aT_KinouKengen = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd);

        assertEquals(pKinouId, aT_KinouKengen.getKinouId());
        assertEquals(pKinouModeId, aT_KinouKengen.getKinouModeId());
        assertEquals(pRoleCd, aT_KinouKengen.getRoleCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pRoleCd = "RC0000099";
        AT_KinouKengen aT_KinouKengen = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd);

        assertNull(aT_KinouKengen);
    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pRoleCd = "";
        AT_KinouKengen aT_KinouKengen = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd);

        assertNull(aT_KinouKengen);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pRoleCd = null;
        try {
            baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouKengen(pRoleCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
