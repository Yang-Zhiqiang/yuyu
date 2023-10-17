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

import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserSettei;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * removeUserSettei() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_removeUserSettei extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserId1 = "UI00000001";
         String pUserId2 = "UI00000002";
         String pUserId3 = "UI00000003";
         String pUserNm1 = "テストユーザ１";
         String pUserNm2 = "テストユーザ２";
         String pUserNm3 = "テストユーザ３";
         String pPassword1 = "PWD0000001";
         String pPassword2 = "PWD0000002";
         String pPassword3 = "PWD0000003";

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

         AT_UserSettei aT_UserSettei1 = baseDomManager.getUserSettei(pUserId1);
         if ( null == aT_UserSettei1 ) {

             aT_UserSettei1 = aM_User1.createUserSettei();

             baseDomManager.update(aM_User1);
         }

         AT_UserSettei aT_UserSettei2 = baseDomManager.getUserSettei(pUserId2);
         if ( null == aT_UserSettei2 ) {

             aT_UserSettei2 = aM_User2.createUserSettei();

             baseDomManager.update(aM_User2);
         }

         AT_UserSettei aT_UserSettei3 = baseDomManager.getUserSettei(pUserId3);
         if ( null == aT_UserSettei3 ) {

             aT_UserSettei3 = aM_User3.createUserSettei();

             baseDomManager.update(aM_User3);
         }

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserId1 = "UI00000001";
         String pUserId2 = "UI00000002";
         String pUserId3 = "UI00000003";

         AM_User aM_User1 = baseDomManager.getUser(pUserId1);
         if ( null != aM_User1 ) {

             baseDomManager.delete(aM_User1.getUserSettei());
             baseDomManager.delete(aM_User1);
         }

         AM_User aM_User2 = baseDomManager.getUser(pUserId2);
         if ( null != aM_User2 ) {

             baseDomManager.delete(aM_User2.getUserSettei());
             baseDomManager.delete(aM_User2);
         }

         AM_User aM_User3 = baseDomManager.getUser(pUserId3);
         if ( null != aM_User3 ) {

             baseDomManager.delete(aM_User3.getUserSettei());
             baseDomManager.delete(aM_User3);
         }

     }

     @Test
     public void test001(){
         String pUserId = "UI00000001";
         AT_UserSettei aT_UserSettei1 = baseDomManager.getUser(pUserId).getUserSettei();
         baseDomManager.getUser(pUserId).removeUserSettei();
         AT_UserSettei aT_UserSettei2 = baseDomManager.getUser(pUserId).getUserSettei();

         assertNotEquals(aT_UserSettei1, aT_UserSettei2);
         assertNull(aT_UserSettei2);
     }

 }
