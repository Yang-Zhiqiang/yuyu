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
import org.slf4j.Logger;

import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getCountUsersByRoleCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getCountUsersByRoleCd extends AbstractTest {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId1 = "UI00000001";
        String pUserId2 = "UI00000002";
        String pUserId3 = "UI00000003";
        String pUserId4 = "UI00000004";
        String pUserNm1 = "テストユーザ１";
        String pUserNm2 = "テストユーザ２";
        String pUserNm3 = "テストユーザ３";
        String pUserNm4 = "テストユーザ４";
        String pPassword1 = "PWD0000001";
        String pPassword2 = "PWD0000002";
        String pPassword3 = "PWD0000003";
        String pPassword4 = "PWD0000004";

        AM_User aM_User1 = baseDomManager.getUser(pUserId1);
        if ( null == aM_User1 ) {

            aM_User1 = new AM_User();
            aM_User1.setUserId(pUserId1);
            aM_User1.setUserNm(pUserNm1);
            aM_User1.setPassword(pPassword1);

            baseDomManager.insert(aM_User1);
        }

        AM_User aM_User2 = baseDomManager.getUser(pUserId2);
        if ( null == aM_User2 ) {

            aM_User2 = new AM_User();
            aM_User2.setUserId(pUserId2);
            aM_User2.setUserNm(pUserNm2);
            aM_User2.setPassword(pPassword2);

            baseDomManager.insert(aM_User2);
        }

        AM_User aM_User3 = baseDomManager.getUser(pUserId3);
        if ( null == aM_User3 ) {

            aM_User3 = new AM_User();
            aM_User3.setUserId(pUserId3);
            aM_User3.setUserNm(pUserNm3);
            aM_User3.setPassword(pPassword3);

            baseDomManager.insert(aM_User3);
        }

        AM_User aM_User4 = baseDomManager.getUser(pUserId4);
        if ( null == aM_User4 ) {

            aM_User4 = new AM_User();
            aM_User4.setUserId(pUserId4);
            aM_User4.setUserNm(pUserNm4);
            aM_User4.setPassword(pPassword4);

            baseDomManager.insert(aM_User4);
        }

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if ( null == aM_Role1 ) {

            aM_Role1 = new AM_Role();
            aM_Role1.setRoleCd(pRoleCd1);

            baseDomManager.insert(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if ( null == aM_Role2 ) {

            aM_Role2 = new AM_Role();
            aM_Role2.setRoleCd(pRoleCd2);

            baseDomManager.insert(aM_Role2);
        }

        AT_UserRole aT_UserRole1 = aM_User1.getUserRole(pRoleCd1);
        if ( null == aT_UserRole1 ) {

            aT_UserRole1 = aM_User1.createUserRole();
            aT_UserRole1.setRoleCd(pRoleCd1);

        }

        baseDomManager.update(aM_User1);

        AT_UserRole aT_UserRole2 = aM_User2.getUserRole(pRoleCd2);
        if ( null == aT_UserRole2 ) {

            aT_UserRole2 = aM_User2.createUserRole();
            aT_UserRole2.setRoleCd(pRoleCd2);

        }

        baseDomManager.update(aM_User2);

        AT_UserRole aT_UserRole3 = aM_User3.getUserRole(pRoleCd2);
        if ( null == aT_UserRole3 ) {

            aT_UserRole3 = aM_User3.createUserRole();
            aT_UserRole3.setRoleCd(pRoleCd2);

        }

        baseDomManager.update(aM_User3);

        AT_UserRole aT_UserRole4 = aM_User4.getUserRole(pRoleCd2);
        if ( null == aT_UserRole4 ) {

            aT_UserRole4 = aM_User4.createUserRole();
            aT_UserRole4.setRoleCd(pRoleCd2);

        }

        baseDomManager.update(aM_User4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId1 = "UI00000001";
        String pUserId2 = "UI00000002";
        String pUserId3 = "UI00000003";
        String pUserId4 = "UI00000004";

        AM_User aM_User1 = baseDomManager.getUser(pUserId1);
        if ( null != aM_User1 ) {

            aM_User1.getUserRoles().removeAll(aM_User1.getUserRoles());

            baseDomManager.update(aM_User1);
            baseDomManager.delete(aM_User1);
        }

        AM_User aM_User2 = baseDomManager.getUser(pUserId2);
        if ( null != aM_User2 ) {

            aM_User2.getUserRoles().removeAll(aM_User2.getUserRoles());

            baseDomManager.update(aM_User2);
            baseDomManager.delete(aM_User2);
        }

        AM_User aM_User3 = baseDomManager.getUser(pUserId3);
        if ( null != aM_User3 ) {

            aM_User3.getUserRoles().removeAll(aM_User3.getUserRoles());

            baseDomManager.update(aM_User3);
            baseDomManager.delete(aM_User3);
        }

        AM_User aM_User4 = baseDomManager.getUser(pUserId4);
        if ( null != aM_User4 ) {

            aM_User4.getUserRoles().removeAll(aM_User4.getUserRoles());

            baseDomManager.update(aM_User4);
            baseDomManager.delete(aM_User4);
        }

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if ( null != aM_Role1 ) {

            baseDomManager.delete(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if ( null != aM_Role2 ) {

            baseDomManager.delete(aM_Role2);
        }

    }

    @Test
    public void test001(){
        String pRoleCd = "RC0000099";
        long count = baseDomManager.getCountUsersByRoleCd(pRoleCd);

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        String pRoleCd = "RC0000001";
        long count = baseDomManager.getCountUsersByRoleCd(pRoleCd);

        assertEquals(1, count);

    }

    @Test
    public void test003(){
        String pRoleCd = "RC0000002";
        long count = baseDomManager.getCountUsersByRoleCd(pRoleCd);

        assertEquals(3, count);

    }

    @Test
    public void test004(){
        String pRoleCd = "";
        long count = baseDomManager.getCountUsersByRoleCd(pRoleCd);

        assertEquals(0, count);

    }

    @Test
    public void test005(){
        String pRoleCd = null;
        long count = baseDomManager.getCountUsersByRoleCd(pRoleCd);

        assertEquals(0, count);

    }

}