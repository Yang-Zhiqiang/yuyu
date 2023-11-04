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

import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getMyMenu() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getMyMenu extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserId1 = "UI00000001";
         String pUserId2 = "UI00000002";
         String pUserNm1 = "テストユーザ１";
         String pUserNm2 = "テストユーザ２";
         String pPassword1 = "PWD0000001";
         String pPassword2 = "PWD0000002";

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

         String pKinouId1 = "KI00000001";
         String pKinouId2 = "KI00000002";
         String pKinouId3 = "KI00000003";
         String pKinouId4 = "KI00000004";

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

         AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
         if ( null == aS_Kinou3 ) {

             aS_Kinou3 = new AS_Kinou();
             aS_Kinou3.setKinouId(pKinouId3);

             baseDomManager.insert(aS_Kinou3);
         }

         AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
         if ( null == aS_Kinou4 ) {

             aS_Kinou4 = new AS_Kinou();
             aS_Kinou4.setKinouId(pKinouId4);

             baseDomManager.insert(aS_Kinou4);
         }

         String pSubSystemId1 = "SSI0000001";
         String pSubSystemId2 = "SSI0000002";
         String pSubSystemId3 = "SSI0000003";
         String pSubSystemId4 = "SSI0000004";
         String pCategoryId1 = "CI00000001";
         String pCategoryId2 = "CI00000002";
         String pCategoryId3 = "CI00000003";
         String pCategoryId4 = "CI00000004";
         AT_MyMenu aT_MyMenu1 = aM_User1.getMyMenuByKinouId(pKinouId1);
         if ( null == aT_MyMenu1 ) {

             aT_MyMenu1 = aM_User1.createMyMenu();
             aT_MyMenu1.setSubSystemId(pSubSystemId1);
             aT_MyMenu1.setCategoryId(pCategoryId1);
             aT_MyMenu1.setKinouId(pKinouId1);

         }

         baseDomManager.update(aM_User1);

         AT_MyMenu aT_MyMenu2 = aM_User2.getMyMenuByKinouId(pKinouId2);
         if ( null == aT_MyMenu2 ) {

             aT_MyMenu2 = aM_User2.createMyMenu();
             aT_MyMenu2.setSubSystemId(pSubSystemId2);
             aT_MyMenu2.setCategoryId(pCategoryId2);
             aT_MyMenu2.setKinouId(pKinouId2);

         }

         AT_MyMenu aT_MyMenu3 = aM_User2.getMyMenuByKinouId(pKinouId3);
         if ( null == aT_MyMenu3 ) {

             aT_MyMenu3 = aM_User2.createMyMenu();
             aT_MyMenu3.setSubSystemId(pSubSystemId3);
             aT_MyMenu3.setCategoryId(pCategoryId3);
             aT_MyMenu3.setKinouId(pKinouId3);

         }

         AT_MyMenu aT_MyMenu4 = aM_User2.getMyMenuByKinouId(pKinouId4);
         if ( null == aT_MyMenu4 ) {

             aT_MyMenu4 = aM_User2.createMyMenu();
             aT_MyMenu4.setSubSystemId(pSubSystemId4);
             aT_MyMenu4.setCategoryId(pCategoryId4);
             aT_MyMenu4.setKinouId(pKinouId4);

         }

         baseDomManager.update(aM_User2);

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserId1 = "UI00000001";
         String pUserId2 = "UI00000002";

         AM_User aM_User1 = baseDomManager.getUser(pUserId1);
         if ( null != aM_User1 ) {

             aM_User1.getMyMenus().removeAll(aM_User1.getMyMenus());

             baseDomManager.update(aM_User1);
             baseDomManager.delete(aM_User1);
         }

         AM_User aM_User2 = baseDomManager.getUser(pUserId2);
         if ( null != aM_User2 ) {

             aM_User2.getMyMenus().removeAll(aM_User2.getMyMenus());

             baseDomManager.update(aM_User2);
             baseDomManager.delete(aM_User2);
         }

         String pKinouId1 = "KI00000001";
         String pKinouId2 = "KI00000002";
         String pKinouId3 = "KI00000003";
         String pKinouId4 = "KI00000004";

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

     }

     @Test
     public void test001(){
         String pUserId = "UI00000099";
         List<AT_MyMenu> aT_MyMenuList = baseDomManager.getMyMenu(pUserId);

         assertEquals(0, aT_MyMenuList.size());

     }

     @Test
     public void test002(){
         String pUserId = "UI00000001";
         List<AT_MyMenu> aT_MyMenuList = baseDomManager.getMyMenu(pUserId);

         assertEquals(1, aT_MyMenuList.size());


     }

     @Test
     public void test003(){
         String pUserId = "UI00000002";
         List<AT_MyMenu> aT_MyMenuList = baseDomManager.getMyMenu(pUserId);

         assertEquals(3, aT_MyMenuList.size());


     }

     @Test
     public void test004(){
         String pUserId = "";
         List<AT_MyMenu> aT_MyMenuList = baseDomManager.getMyMenu(pUserId);

         assertEquals(0, aT_MyMenuList.size());


     }

     @Test
     public void test005(){
         String pUserId = null;
         List<AT_MyMenu> aT_MyMenuList = baseDomManager.getMyMenu(pUserId);

         assertEquals(4, aT_MyMenuList.size());

     }
 }
