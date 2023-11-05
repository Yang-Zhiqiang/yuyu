package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

/**
 * ユーザー設定テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_UserSetteiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId1 = "UI00000001";
        String pUserId2 = "UI00000002";
        String pUserId3 = "UI00000003";
        String pUserId4 = "UI00000004";
        String pUserId5 = "UI00000005";
        String pUserNm1 = "テストユーザ１";
        String pUserNm2 = "テストユーザ２";
        String pUserNm3 = "テストユーザ３";
        String pUserNm4 = "テストユーザ４";
        String pUserNm5 = "テストユーザ５";
        String pPassword1 = "PWD0000001";
        String pPassword2 = "PWD0000002";
        String pPassword3 = "PWD0000003";
        String pPassword4 = "PWD0000004";
        String pPassword5 = "PWD0000005";

        AM_User aM_User1 = baseDomManager.getUser(pUserId1);
        if ( null == aM_User1 ){

            aM_User1 = new AM_User();
            aM_User1.setUserId(pUserId1);
            aM_User1.setUserNm(pUserNm1);
            aM_User1.setPassword(pPassword1);

            baseDomManager.insert(aM_User1);
        }

        AM_User aM_User2 = baseDomManager.getUser(pUserId2);
        if ( null == aM_User2 ){

            aM_User2 = new AM_User();
            aM_User2.setUserId(pUserId2);
            aM_User2.setUserNm(pUserNm2);
            aM_User2.setPassword(pPassword2);

            baseDomManager.insert(aM_User2);
        }

        AM_User aM_User3 = baseDomManager.getUser(pUserId3);
        if ( null == aM_User3 ){

            aM_User3 = new AM_User();
            aM_User3.setUserId(pUserId3);
            aM_User3.setUserNm(pUserNm3);
            aM_User3.setPassword(pPassword3);

            baseDomManager.insert(aM_User3);
        }

        AM_User aM_User4 = baseDomManager.getUser(pUserId4);
        if ( null == aM_User4 ){

            aM_User4 = new AM_User();
            aM_User4.setUserId(pUserId4);
            aM_User4.setUserNm(pUserNm4);
            aM_User4.setPassword(pPassword4);

            baseDomManager.insert(aM_User4);
        }

        AM_User aM_User5 = baseDomManager.getUser(pUserId5);
        if ( null == aM_User5 ){

            aM_User5 = new AM_User();
            aM_User5.setUserId(pUserId5);
            aM_User5.setUserNm(pUserNm5);
            aM_User5.setPassword(pPassword5);

            baseDomManager.insert(aM_User5);
        }

        AT_UserSettei aT_UserSettei1 = baseDomManager.getUser(pUserId1).getUserSettei();
        if ( null == aT_UserSettei1 ){

            aT_UserSettei1 = aM_User1.createUserSettei();

            baseDomManager.update(aM_User1);
        }

        AT_UserSettei aT_UserSettei2 = baseDomManager.getUser(pUserId2).getUserSettei();
        if ( null == aT_UserSettei2 ){

            aT_UserSettei2 = aM_User2.createUserSettei();

            baseDomManager.update(aM_User2);
        }

        AT_UserSettei aT_UserSettei3 = baseDomManager.getUser(pUserId3).getUserSettei();
        if ( null == aT_UserSettei3 ){

            aT_UserSettei3 = aM_User3.createUserSettei();

            baseDomManager.update(aM_User3);
        }

        AT_UserSettei aT_UserSettei4 = baseDomManager.getUser(pUserId4).getUserSettei();
        if ( null == aT_UserSettei4 ){

            aT_UserSettei4 = aM_User4.createUserSettei();

            baseDomManager.update(aM_User4);
        }

        AT_UserSettei aT_UserSettei5 = baseDomManager.getUser(pUserId5).getUserSettei();
        if ( null == aT_UserSettei5 ){

            aT_UserSettei5 = aM_User5.createUserSettei();

            baseDomManager.update(aM_User5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId1 = "UI00000001";
        String pUserId2 = "UI00000002";
        String pUserId3 = "UI00000003";
        String pUserId4 = "UI00000004";
        String pUserId5 = "UI00000005";

        AM_User aM_User1 = baseDomManager.getUser(pUserId1);
        if ( null != aM_User1 ){

            aM_User1.removeUserSettei();

            baseDomManager.update(aM_User1);
            baseDomManager.delete(aM_User1);
        }

        AM_User aM_User2 = baseDomManager.getUser(pUserId2);
        if ( null != aM_User2 ){

            aM_User2.removeUserSettei();

            baseDomManager.update(aM_User2);
            baseDomManager.delete(aM_User2);
        }

        AM_User aM_User3 = baseDomManager.getUser(pUserId3);
        if ( null != aM_User3 ){

            aM_User3.removeUserSettei();

            baseDomManager.update(aM_User3);
            baseDomManager.delete(aM_User3);
        }

        AM_User aM_User4 = baseDomManager.getUser(pUserId4);
        if ( null != aM_User4 ){

            aM_User4.removeUserSettei();

            baseDomManager.update(aM_User4);
            baseDomManager.delete(aM_User4);
        }

        AM_User aM_User5 = baseDomManager.getUser(pUserId5);
        if ( null != aM_User5 ){

            aM_User5.removeUserSettei();

            baseDomManager.update(aM_User5);
            baseDomManager.delete(aM_User5);
        }
    }

    @Override
    @Test
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUserId = "UI00000001";
        AT_UserSettei aT_UserSettei = baseDomManager.getUserSettei(pUserId);

        assertEquals(pUserId, aT_UserSettei.getUserId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUserId = "UI00000099";
        AT_UserSettei aT_UserSettei = baseDomManager.getUserSettei(pUserId);

        assertNull(aT_UserSettei);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUserId = "";
        AT_UserSettei aT_UserSettei = baseDomManager.getUserSettei(pUserId);

        assertNull(aT_UserSettei);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUserId = null;
        try {
            baseDomManager.getUserSettei(pUserId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }

}
