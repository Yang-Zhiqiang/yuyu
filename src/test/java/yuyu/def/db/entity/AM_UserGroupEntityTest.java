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
 * ユーザーマスタ エンティティのテストクラス<br />
 * 基礎実装テストするため
 */
@RunWith(SWAKTestRunner.class)
public class AM_UserGroupEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserGroupCd1 = "UGC0000001";
        String pUserGroupCd2 = "UGC0000002";
        String pUserGroupCd3 = "UGC0000003";
        String pUserGroupCd4 = "UGC0000004";
        String pUserGroupCd5 = "UGC0000005";

        AM_UserGroup aM_UserGroup1 = baseDomManager.getUserGroup(pUserGroupCd1);
        if ( null == aM_UserGroup1 ){

            aM_UserGroup1 = new AM_UserGroup();
            aM_UserGroup1.setUserGroupCd(pUserGroupCd1);

            baseDomManager.insert(aM_UserGroup1);
        }

        AM_UserGroup aM_UserGroup2 = baseDomManager.getUserGroup(pUserGroupCd2);
        if ( null == aM_UserGroup2 ){

            aM_UserGroup2 = new AM_UserGroup();
            aM_UserGroup2.setUserGroupCd(pUserGroupCd2);

            baseDomManager.insert(aM_UserGroup2);
        }

        AM_UserGroup aM_UserGroup3 = baseDomManager.getUserGroup(pUserGroupCd3);
        if ( null == aM_UserGroup3 ){

            aM_UserGroup3 = new AM_UserGroup();
            aM_UserGroup3.setUserGroupCd(pUserGroupCd3);

            baseDomManager.insert(aM_UserGroup3);
        }

        AM_UserGroup aM_UserGroup4 = baseDomManager.getUserGroup(pUserGroupCd4);
        if ( null == aM_UserGroup4 ){

            aM_UserGroup4 = new AM_UserGroup();
            aM_UserGroup4.setUserGroupCd(pUserGroupCd4);

            baseDomManager.insert(aM_UserGroup4);
        }

        AM_UserGroup aM_UserGroup5 = baseDomManager.getUserGroup(pUserGroupCd5);
        if ( null == aM_UserGroup5 ){

            aM_UserGroup5 = new AM_UserGroup();
            aM_UserGroup5.setUserGroupCd(pUserGroupCd5);

            baseDomManager.insert(aM_UserGroup5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserGroupCd1 = "UGC0000001";
        String pUserGroupCd2 = "UGC0000002";
        String pUserGroupCd3 = "UGC0000003";
        String pUserGroupCd4 = "UGC0000004";
        String pUserGroupCd5 = "UGC0000005";

        AM_UserGroup aM_UserGroup1 = baseDomManager.getUserGroup(pUserGroupCd1);
        if ( null != aM_UserGroup1 ){

            baseDomManager.delete(aM_UserGroup1);
        }

        AM_UserGroup aM_UserGroup2 = baseDomManager.getUserGroup(pUserGroupCd2);
        if ( null != aM_UserGroup2 ){

            baseDomManager.delete(aM_UserGroup2);
        }

        AM_UserGroup aM_UserGroup3 = baseDomManager.getUserGroup(pUserGroupCd3);
        if ( null != aM_UserGroup3 ){

            baseDomManager.delete(aM_UserGroup3);
        }

        AM_UserGroup aM_UserGroup4 = baseDomManager.getUserGroup(pUserGroupCd4);
        if ( null != aM_UserGroup4 ){

            baseDomManager.delete(aM_UserGroup4);
        }

        AM_UserGroup aM_UserGroup5 = baseDomManager.getUserGroup(pUserGroupCd5);
        if ( null != aM_UserGroup5 ){

            baseDomManager.delete(aM_UserGroup5);
        }

    }

    @Override
    @Test
    public void getAll() {

        List<AM_UserGroup> userGroupList = baseDomManager.getAllUserGroups();

        List<AM_UserGroup> resultUserGroupList = ImmutableList.copyOf(Iterables.filter(userGroupList, new Predicate<AM_UserGroup>() {

            @Override
            public boolean apply(AM_UserGroup pUserGroupEntity) {

                List<String> userGroupCdList = new ArrayList<String>();
                userGroupCdList.add("UGC0000001");
                userGroupCdList.add("UGC0000002");
                userGroupCdList.add("UGC0000003");
                userGroupCdList.add("UGC0000004");
                userGroupCdList.add("UGC0000005");

                for (String userGroupCd : userGroupCdList) {
                    if (userGroupCd.equals(pUserGroupEntity.getUserGroupCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultUserGroupList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUserGroupCd = "UGC0000001";
        AM_UserGroup aM_UserGroup = baseDomManager.getUserGroup(pUserGroupCd);

        assertEquals(pUserGroupCd, aM_UserGroup.getUserGroupCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUserGroupCd = "UGC0000099";
        AM_UserGroup aM_UserGroup = baseDomManager.getUserGroup(pUserGroupCd);

        assertNull(aM_UserGroup);

    }

    @Override
    @Test
    public void blankCondition() {
        String pUserGroupCd = "";
        AM_UserGroup aM_UserGroup = baseDomManager.getUserGroup(pUserGroupCd);

        assertNull(aM_UserGroup);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUserGroupCd = null;
        try {
            baseDomManager.getUserGroup(pUserGroupCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
