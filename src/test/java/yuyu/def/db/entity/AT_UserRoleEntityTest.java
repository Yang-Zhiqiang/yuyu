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
 * ユーザーロールテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_UserRoleEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId = "UI00000001";
        String pUserNm = "テストユーザ１";
        String pPassword = "PWD0000001";

        AM_User aM_User = baseDomManager.getUser(pUserId);
        if ( null == aM_User ){

            aM_User = new AM_User();
            aM_User.setUserId(pUserId);
            aM_User.setUserNm(pUserNm);
            aM_User.setPassword(pPassword);

            baseDomManager.insert(aM_User);
        }

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";
        String pRoleCd3 = "RC0000003";
        String pRoleCd4 = "RC0000004";
        String pRoleCd5 = "RC0000005";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if ( null == aM_Role1 ){

            aM_Role1 = new AM_Role();
            aM_Role1.setRoleCd(pRoleCd1);

            baseDomManager.insert(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if ( null == aM_Role2 ){

            aM_Role2 = new AM_Role();
            aM_Role2.setRoleCd(pRoleCd2);

            baseDomManager.insert(aM_Role2);
        }

        AM_Role aM_Role3 = baseDomManager.getRole(pRoleCd3);
        if ( null == aM_Role3 ){

            aM_Role3 = new AM_Role();
            aM_Role3.setRoleCd(pRoleCd3);

            baseDomManager.insert(aM_Role3);
        }

        AM_Role aM_Role4 = baseDomManager.getRole(pRoleCd4);
        if ( null == aM_Role4 ){

            aM_Role4 = new AM_Role();
            aM_Role4.setRoleCd(pRoleCd4);

            baseDomManager.insert(aM_Role4);
        }

        AM_Role aM_Role5 = baseDomManager.getRole(pRoleCd5);
        if ( null == aM_Role5 ){

            aM_Role5 = new AM_Role();
            aM_Role5.setRoleCd(pRoleCd5);

            baseDomManager.insert(aM_Role5);
        }

        AT_UserRole aT_UserRole1 = baseDomManager.getUser(pUserId).getUserRole(pRoleCd1);
        if (null == aT_UserRole1) {

            aT_UserRole1 = aM_User.createUserRole();
            aT_UserRole1.setRoleCd(pRoleCd1);

        }

        AT_UserRole aT_UserRole2 = baseDomManager.getUser(pUserId).getUserRole(pRoleCd2);
        if (null == aT_UserRole2) {

            aT_UserRole2 = aM_User.createUserRole();
            aT_UserRole2.setRoleCd(pRoleCd2);

        }

        AT_UserRole aT_UserRole3 = baseDomManager.getUser(pUserId).getUserRole(pRoleCd3);
        if (null == aT_UserRole3) {

            aT_UserRole3 = aM_User.createUserRole();
            aT_UserRole3.setRoleCd(pRoleCd3);

        }

        AT_UserRole aT_UserRole4 = baseDomManager.getUser(pUserId).getUserRole(pRoleCd4);
        if (null == aT_UserRole4) {

            aT_UserRole4 = aM_User.createUserRole();
            aT_UserRole4.setRoleCd(pRoleCd4);

        }

        AT_UserRole aT_UserRole5 = baseDomManager.getUser(pUserId).getUserRole(pRoleCd5);
        if (null == aT_UserRole5) {

            aT_UserRole5 = aM_User.createUserRole();
            aT_UserRole5.setRoleCd(pRoleCd5);

        }

        baseDomManager.update(aM_User);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId = "UI00000001";

        AM_User aM_User = baseDomManager.getUser(pUserId);
        if ( null != aM_User ){

            aM_User.getUserRoles().removeAll(aM_User.getUserRoles());

            baseDomManager.update(aM_User);
            baseDomManager.delete(aM_User);
        }

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";
        String pRoleCd3 = "RC0000003";
        String pRoleCd4 = "RC0000004";
        String pRoleCd5 = "RC0000005";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if ( null != aM_Role1 ){

            baseDomManager.delete(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if ( null != aM_Role2 ){

            baseDomManager.delete(aM_Role2);
        }

        AM_Role aM_Role3 = baseDomManager.getRole(pRoleCd3);
        if ( null != aM_Role3 ){

            baseDomManager.delete(aM_Role3);
        }

        AM_Role aM_Role4 = baseDomManager.getRole(pRoleCd4);
        if ( null != aM_Role4 ){

            baseDomManager.delete(aM_Role4);
        }

        AM_Role aM_Role5 = baseDomManager.getRole(pRoleCd5);
        if ( null != aM_Role5 ){

            baseDomManager.delete(aM_Role5);
        }
    }

    @Override
    @Test
    public void getAll() {

        String pUserId = "UI00000001";
        List<AT_UserRole> userRoleList = baseDomManager.getUser(pUserId).getUserRoles();

        List<AT_UserRole> resultUserRoleList = ImmutableList.copyOf(Iterables.filter(userRoleList, new Predicate<AT_UserRole>() {

            @Override
            public boolean apply(AT_UserRole pUseerRoleEntity) {

                List<String> pRoleCdList = new ArrayList<String>();
                pRoleCdList.add("RC0000001");
                pRoleCdList.add("RC0000002");
                pRoleCdList.add("RC0000003");
                pRoleCdList.add("RC0000004");
                pRoleCdList.add("RC0000005");

                for ( String roleCd : pRoleCdList ){
                    if ( roleCd.equals(pUseerRoleEntity.getRoleCd())){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultUserRoleList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUserId = "UI00000001";
        String pRoleCd = "RC0000001";
        AT_UserRole aT_UserRole = baseDomManager.getUser(pUserId).getUserRole(pRoleCd);

        assertEquals(pUserId, aT_UserRole.getUserId());
        assertEquals(pRoleCd, aT_UserRole.getRoleCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUserId = "UI00000001";
        String pRoleCd = "RC0000099";
        AT_UserRole aT_UserRole = baseDomManager.getUser(pUserId).getUserRole(pRoleCd);

        assertNull(aT_UserRole);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUserId = "UI00000001";
        String pRoleCd = "";
        AT_UserRole aT_UserRole = baseDomManager.getUser(pUserId).getUserRole(pRoleCd);

        assertNull(aT_UserRole);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUserId = "UI00000001";
        String pRoleCd = null;
        try {
            baseDomManager.getUser(pUserId).getUserRole(pRoleCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
