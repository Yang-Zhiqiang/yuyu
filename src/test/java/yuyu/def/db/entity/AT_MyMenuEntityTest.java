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
 * マイメニューテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_MyMenuEntityTest implements EntityTestInterface {

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

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ){

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ){

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);

            baseDomManager.insert(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null == aS_Kinou3 ){

            aS_Kinou3 = new AS_Kinou();
            aS_Kinou3.setKinouId(pKinouId3);

            baseDomManager.insert(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null == aS_Kinou4 ){

            aS_Kinou4 = new AS_Kinou();
            aS_Kinou4.setKinouId(pKinouId4);

            baseDomManager.insert(aS_Kinou4);
        }

        AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
        if ( null == aS_Kinou5 ){

            aS_Kinou5 = new AS_Kinou();
            aS_Kinou5.setKinouId(pKinouId5);

            baseDomManager.insert(aS_Kinou5);
        }

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";
        String pSubSystemId3 = "SSI0000003";
        String pSubSystemId4 = "SSI0000004";
        String pSubSystemId5 = "SSI0000005";
        String pCategoryId1 = "CI00000001";
        String pCategoryId2 = "CI00000002";
        String pCategoryId3 = "CI00000003";
        String pCategoryId4 = "CI00000004";
        String pCategoryId5 = "CI00000005";
        AT_MyMenu aT_MyMenu1 = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId1);
        if ( null == aT_MyMenu1 ){

            aT_MyMenu1 = aM_User.createMyMenu();
            aT_MyMenu1.setKinouId(pKinouId1);
            aT_MyMenu1.setSubSystemId(pSubSystemId1);
            aT_MyMenu1.setCategoryId(pCategoryId1);

        }

        AT_MyMenu aT_MyMenu2 = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId2);
        if ( null == aT_MyMenu2 ){

            aT_MyMenu2 = aM_User.createMyMenu();
            aT_MyMenu2.setKinouId(pKinouId2);
            aT_MyMenu2.setSubSystemId(pSubSystemId2);
            aT_MyMenu2.setCategoryId(pCategoryId2);

        }

        AT_MyMenu aT_MyMenu3 = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId3);
        if ( null == aT_MyMenu3 ){

            aT_MyMenu3 = aM_User.createMyMenu();
            aT_MyMenu3.setKinouId(pKinouId3);
            aT_MyMenu3.setSubSystemId(pSubSystemId3);
            aT_MyMenu3.setCategoryId(pCategoryId3);

        }

        AT_MyMenu aT_MyMenu4 = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId4);
        if ( null == aT_MyMenu4 ){

            aT_MyMenu4 = aM_User.createMyMenu();
            aT_MyMenu4.setKinouId(pKinouId4);
            aT_MyMenu4.setSubSystemId(pSubSystemId4);
            aT_MyMenu4.setCategoryId(pCategoryId4);

        }

        AT_MyMenu aT_MyMenu5 = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId5);
        if ( null == aT_MyMenu5 ){

            aT_MyMenu5 = aM_User.createMyMenu();
            aT_MyMenu5.setKinouId(pKinouId5);
            aT_MyMenu5.setSubSystemId(pSubSystemId5);
            aT_MyMenu5.setCategoryId(pCategoryId5);

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

            aM_User.getMyMenus().removeAll(aM_User.getMyMenus());

            baseDomManager.update(aM_User);
            baseDomManager.delete(aM_User);
        }

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            baseDomManager.delete(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null != aS_Kinou3 ) {

            baseDomManager.delete(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null != aS_Kinou4 ) {

            baseDomManager.delete(aS_Kinou4);
        }

        AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
        if ( null != aS_Kinou5 ) {

            baseDomManager.delete(aS_Kinou5);
        }

    }

    @Override
    @Test
    public void getAll() {

        String pUserId = "UI00000001";
        List<AT_MyMenu> myMenuList = baseDomManager.getUser(pUserId).getMyMenus();

        List<AT_MyMenu> resultMyMenuList = ImmutableList.copyOf(Iterables.filter(myMenuList, new Predicate<AT_MyMenu>() {

            @Override
            public boolean apply(AT_MyMenu pMyMenuEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000001");
                pKinouIdList.add("KI00000002");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000004");
                pKinouIdList.add("KI00000005");

                for ( String kinouId : pKinouIdList ){
                    if ( kinouId.equals(pMyMenuEntity.getKinouId())){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultMyMenuList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUserId = "UI00000001";
        String pKinouId = "KI00000001";
        AT_MyMenu aT_MyMenu = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId);

        assertEquals(pUserId, aT_MyMenu.getUserId());
        assertEquals(pKinouId, aT_MyMenu.getKinouId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUserId = "UI00000001";
        String pKinouId = "KI00000099";
        AT_MyMenu aT_MyMenu = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId);

        assertNull(aT_MyMenu);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUserId = "UI00000001";
        String pKinouId = "";
        AT_MyMenu aT_MyMenu = baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId);

        assertNull(aT_MyMenu);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUserId = "UI00000001";
        String pKinouId = null;
        try {
            baseDomManager.getUser(pUserId).getMyMenuByKinouId(pKinouId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
