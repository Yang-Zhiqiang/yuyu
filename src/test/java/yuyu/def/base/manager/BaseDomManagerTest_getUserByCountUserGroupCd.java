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
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getUserByCountUserGroupCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getUserByCountUserGroupCd extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserGroupCd1 = "UGC0000001";
         String pUserGroupCd2 = "UGC0000002";

         AM_UserGroup aM_UserGroup1 = baseDomManager.getUserGroup(pUserGroupCd1);
         if ( null == aM_UserGroup1 ) {

             aM_UserGroup1 = new AM_UserGroup();
             aM_UserGroup1.setUserGroupCd(pUserGroupCd1);

             baseDomManager.insert(aM_UserGroup1);
         }

         AM_UserGroup aM_UserGroup2 = baseDomManager.getUserGroup(pUserGroupCd2);
         if ( null == aM_UserGroup2 ) {

             aM_UserGroup2 = new AM_UserGroup();
             aM_UserGroup2.setUserGroupCd(pUserGroupCd2);

             baseDomManager.insert(aM_UserGroup2);
         }

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
             aM_User1.setUserGroupCd(pUserGroupCd1);

             baseDomManager.insert(aM_User1);
         }

         AM_User aM_User2 = baseDomManager.getUser(pUserId2);
         if ( null == aM_User2 ) {

             aM_User2 = new AM_User();
             aM_User2.setUserId(pUserId2);
             aM_User2.setUserNm(pUserNm2);
             aM_User2.setPassword(pPassword2);
             aM_User2.setUserGroupCd(pUserGroupCd2);

             baseDomManager.insert(aM_User2);
         }

         AM_User aM_User3 = baseDomManager.getUser(pUserId3);
         if ( null == aM_User3 ) {

             aM_User3 = new AM_User();
             aM_User3.setUserId(pUserId3);
             aM_User3.setUserNm(pUserNm3);
             aM_User3.setPassword(pPassword3);
             aM_User3.setUserGroupCd(pUserGroupCd2);

             baseDomManager.insert(aM_User3);
         }

         AM_User aM_User4 = baseDomManager.getUser(pUserId4);
         if ( null == aM_User4 ) {

             aM_User4 = new AM_User();
             aM_User4.setUserId(pUserId4);
             aM_User4.setUserNm(pUserNm4);
             aM_User4.setPassword(pPassword4);
             aM_User4.setUserGroupCd(pUserGroupCd2);

             baseDomManager.insert(aM_User4);
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

         AM_User aM_User1 = baseDomManager.getUser(pUserId1);
         if ( null != aM_User1 ) {

             baseDomManager.delete(aM_User1);
         }

         AM_User aM_User2 = baseDomManager.getUser(pUserId2);
         if ( null != aM_User2 ) {

             baseDomManager.delete(aM_User2);
         }

         AM_User aM_User3 = baseDomManager.getUser(pUserId3);
         if ( null != aM_User3 ) {

             baseDomManager.delete(aM_User3);
         }

         AM_User aM_User4 = baseDomManager.getUser(pUserId4);
         if ( null != aM_User4 ) {

             baseDomManager.delete(aM_User4);
         }

         String pUserGroupCd1 = "UGC0000001";
         String pUserGroupCd2 = "UGC0000002";

         AM_UserGroup aM_UserGroup1 = baseDomManager.getUserGroup(pUserGroupCd1);
         if ( null != aM_UserGroup1 ) {

             baseDomManager.delete(aM_UserGroup1);
         }

         AM_UserGroup aM_UserGroup2 = baseDomManager.getUserGroup(pUserGroupCd2);
         if ( null != aM_UserGroup2 ) {

             baseDomManager.delete(aM_UserGroup2);
         }

     }

     @Test
     public void test001(){
         String pUserGroupCd = "UGC0000099";
         long count = baseDomManager.getUserByCountUserGroupCd(pUserGroupCd);

         assertEquals(0, count);

     }

     @Test
     public void test002(){
         String pUserGroupCd = "UGC0000001";
         long count = baseDomManager.getUserByCountUserGroupCd(pUserGroupCd);

         assertEquals(1, count);


     }

     @Test
     public void test003(){
         String pUserGroupCd = "UGC0000002";
         long count = baseDomManager.getUserByCountUserGroupCd(pUserGroupCd);

         assertEquals(3, count);


     }

     @Test
     public void test004(){
         String pUserGroupCd = "";
         long count = baseDomManager.getUserByCountUserGroupCd(pUserGroupCd);

         assertEquals(0, count);

     }

     @Test
     public void test005(){
         String pUserGroupCd = null;
         long count = baseDomManager.getUserByCountUserGroupCd(pUserGroupCd);

         assertEquals(0, count);

     }

 }
