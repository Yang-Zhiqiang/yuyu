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
 * ユーザーマスタエンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AM_UserEntityTest implements EntityTestInterface {

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
            baseDomManager.delete(aM_User1);
        }

        AM_User aM_User2 = baseDomManager.getUser(pUserId2);
        if ( null != aM_User2 ){
            baseDomManager.delete(aM_User2);
        }

        AM_User aM_User3 = baseDomManager.getUser(pUserId3);
        if ( null != aM_User3 ){
            baseDomManager.delete(aM_User3);
        }

        AM_User aM_User4 = baseDomManager.getUser(pUserId4);
        if ( null != aM_User4 ){
            baseDomManager.delete(aM_User4);
        }

        AM_User aM_User5 = baseDomManager.getUser(pUserId5);
        if ( null != aM_User5 ){
            baseDomManager.delete(aM_User5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AM_User> userList = baseDomManager.getAllUsers();

        List<AM_User> resultUserList = ImmutableList.copyOf(Iterables.filter(userList, new Predicate<AM_User>() {

            @Override
            public boolean apply(AM_User pUserEntity) {

                List<String> userIdList = new ArrayList<String>();
                userIdList.add("UI00000001");
                userIdList.add("UI00000002");
                userIdList.add("UI00000003");
                userIdList.add("UI00000004");
                userIdList.add("UI00000005");

                for (String userId : userIdList) {
                    if (userId.equals(pUserEntity.getUserId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultUserList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUserId = "UI00000001";
        AM_User aM_User = baseDomManager.getUser(pUserId);

        assertEquals(pUserId, aM_User.getUserId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUserId = "UI00000099";
        AM_User aM_User = baseDomManager.getUser(pUserId);

        assertNull(aM_User);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUserId = "";
        AM_User aM_User = baseDomManager.getUser(pUserId);

        assertNull(aM_User);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUserId = null;
        try {
            baseDomManager.getUser(pUserId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }

}
