package yuyu.def.base.manager;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
import org.slf4j.Logger;

import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.testinfr.AbstractTest;

import com.google.common.collect.Lists;

/**
 * BaseDomManagerクラスの、<br />
 * getDetachedUser() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getDetachedUser extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @Inject
     private static Logger logger;

     private static boolean flg = false;

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

         AM_User user = baseDomManager.getUser("unittestadmin");
         if (user == null) {
             flg = true;
             user = new AM_User();
             user.setUserId("unittestadmin");
             user.setUserNm("単体テスト管理者");
             user.setPassword("password");
             List<AT_UserRole> userRoles = Lists.newArrayList();
             {
                 AT_UserRole userRole = new AT_UserRole();
                 userRole.setRoleCd("Administrators");
                 userRole.setUserId("unittestadmin");
                 userRoles.add(userRole);
             }
             {
                 AT_UserRole userRole = new AT_UserRole();
                 userRole.setRoleCd("CommonAdmins");
                 userRole.setUserId("unittestadmin");
                 userRoles.add(userRole);
             }
             {
                 AT_UserRole userRole = new AT_UserRole();
                 userRole.setRoleCd("SystemAdmins");
                 userRole.setUserId("unittestadmin");
                 userRoles.add(userRole);
             }
             baseDomManager.insert(userRoles);
             baseDomManager.insert(user);
         }
     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         logger.debug("====================================================== データ削除処理 ======================================================");
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserId1 = "UI00000001";
         String pUserId2 = "UI00000002";

         AM_User aM_User1 = baseDomManager.getUser(pUserId1);
         if ( null != aM_User1 ) {

             baseDomManager.delete(aM_User1);
         }

         AM_User aM_User2 = baseDomManager.getUser(pUserId2);
         if ( null != aM_User2 ) {

             baseDomManager.delete(aM_User2);
         }

         if (flg) {
             AM_User user = baseDomManager.getUser("unittestadmin");
             baseDomManager.delete(user);
         }

     }

     @Test
     public void test001(){
         String pUserId = "UI00000099";
         AM_User aM_User = baseDomManager.getDetachedUser(pUserId);

         assertNull(aM_User);
     }

     @Test
     public void test002(){
         String pUserId = "UI00000001";
         AM_User aM_User = baseDomManager.getDetachedUser(pUserId);

         assertEquals(pUserId, aM_User.getUserId());
     }

     @Test
     public void test003(){
         String pUserId = "";
         AM_User aM_User = baseDomManager.getDetachedUser(pUserId);

         assertNull(aM_User);
     }

     @Test
     public void test004(){
         String pUserId = null;
         try {
             baseDomManager.getDetachedUser(pUserId);
         } catch (Exception e) {
             assertThat(e, instanceOf(NonUniqueResultException.class));
         }
     }

     @Transactional
     @Test
     public void test005() {
         AM_User user1 = baseDomManager.getUser("unittestadmin");
         AM_User user2 = baseDomManager.getDetachedUser("unittestadmin");
         assertTrue(baseDomManager.isManaged(user1));
         assertFalse(baseDomManager.isManaged(user2));

         assertTrue(user1.equals(user2));

         user1.setUserNm("テスト");
         assertFalse(user1.equals(user2));
         logger.debug("↓↓↓↓↓↓↓↓↓↓↓↓ Update文が発行される ↓↓↓↓↓↓↓↓↓↓↓↓");
     }

     @Transactional
     @Test
     public void test006() {
         AM_User user1 = baseDomManager.getUser("unittestadmin");
         AM_User user2 = baseDomManager.getDetachedUser("unittestadmin");
         assertTrue(baseDomManager.isManaged(user1));
         assertFalse(baseDomManager.isManaged(user2));

         assertTrue(user1.equals(user2));
         logger.debug("====================================================== >> 更新前ユーザー情報 ======================================================");
         logger.debug(user1.toString());
         logger.debug(user2.toString());
         logger.debug("====================================================== 更新前ユーザー情報 << ======================================================");

         user2.setUserNm("テストユーザー２");
         assertFalse(user1.equals(user2));
         logger.debug("====================================================== >> 更新後ユーザー情報 ======================================================");
         logger.debug(user1.toString());
         logger.debug(user2.toString());
         logger.debug("====================================================== 更新後ユーザー情報 << ======================================================");
         logger.debug("↓↓↓↓↓↓↓↓↓↓↓↓ Update文が発行されない ↓↓↓↓↓↓↓↓↓↓↓↓");
     }

     @Test
     public void test007() {
         logger.debug("====================================================== >> マネージドのユーザー情報取得 ======================================================");
         AM_User user1 = baseDomManager.getUser("unittestadmin");
         logger.debug("====================================================== マネージドのユーザー情報取得 << ======================================================");
         logger.debug("====================================================== >> アンマネージドのユーザー情報取得 ======================================================");
         AM_User user2 = baseDomManager.getDetachedUser("unittestadmin");
         logger.debug("====================================================== アンマネージドのユーザー情報取得 << ======================================================");

         logger.debug("====================================================== >> マネージドのユーザーロール取得 ======================================================");
         List<AT_UserRole> userRoles1 = user1.getUserRoles();
         for (AT_UserRole userRole : userRoles1) {
             logger.debug(userRole.toString());
             AM_Role role = userRole.getRole();
             assertTrue(baseDomManager.isManaged(userRole));
             assertTrue(baseDomManager.isManaged(role));
             if (role != null) {
                 logger.debug("====================================================== >> >> マネージドのロール取得 ======================================================");
                 logger.debug(role.toString());
                 List<AT_KinouKengen> kengens = role.getKinouKengens();
                 for (AT_KinouKengen kengen : kengens) {
                     logger.debug(kengen.toString());
                     assertTrue(baseDomManager.isManaged(kengen));
                 }
                 logger.debug("====================================================== マネージドのロール取得 << << ======================================================");
             }
         }
         logger.debug("====================================================== マネージドのユーザーロール取得 << ======================================================");
         logger.debug("====================================================== >> アンマネージドのユーザーロール取得 ======================================================");
         List<AT_UserRole> userRoles2 = user2.getUserRoles();
         for (AT_UserRole userRole : userRoles2) {
             logger.debug(userRole.toString());
             AM_Role role = userRole.getRole();
             assertFalse(baseDomManager.isManaged(userRole));
             assertFalse(baseDomManager.isManaged(role));
             if (role != null) {
                 logger.debug("====================================================== >> >> アンマネージドのロール取得 ======================================================");
                 logger.debug(role.toString());
                 List<AT_KinouKengen> kengens = role.getKinouKengens();
                 for (AT_KinouKengen kengen : kengens) {
                     logger.debug(kengen.toString());
                     assertFalse(baseDomManager.isManaged(kengen));
                 }
                 logger.debug("====================================================== アンマネージドのロール取得 << << ======================================================");
             }
         }
         logger.debug("====================================================== アンマネージドのユーザーロール取得 << ======================================================");
     }

     @Test
     public void test008() {
         logger.debug("====================================================== >> マネージドのユーザー情報取得 ======================================================");
         AM_User user1 = baseDomManager.getUser("unittestadmin");
         user1.detach();
         logger.debug("====================================================== マネージドのユーザー情報取得 << ======================================================");
         logger.debug("====================================================== >> アンマネージドのユーザー情報取得 ======================================================");
         AM_User user2 = baseDomManager.getDetachedUser("unittestadmin");
         logger.debug("====================================================== アンマネージドのユーザー情報取得 << ======================================================");

         logger.debug("====================================================== >> マネージドのユーザーロール取得 ======================================================");
         List<AT_UserRole> userRoles1 = user1.getUserRoles();
         for (AT_UserRole userRole : userRoles1) {
             logger.debug(userRole.toString());
             AM_Role role = userRole.getRole();
             assertFalse(baseDomManager.isManaged(userRole));
             assertTrue(baseDomManager.isManaged(role));
             if (role != null) {
                 logger.debug("====================================================== >> >> マネージドのロール取得 ======================================================");
                 logger.debug(role.toString());
                 List<AT_KinouKengen> kengens = role.getKinouKengens();
                 for (AT_KinouKengen kengen : kengens) {
                     logger.debug(kengen.toString());
                     assertTrue(baseDomManager.isManaged(kengen));
                 }
                 logger.debug("====================================================== マネージドのロール取得 << << ======================================================");
             }
         }
         logger.debug("====================================================== マネージドのユーザーロール取得 << ======================================================");
         logger.debug("====================================================== >> アンマネージドのユーザーロール取得 ======================================================");
         List<AT_UserRole> userRoles2 = user2.getUserRoles();
         for (AT_UserRole userRole : userRoles2) {
             logger.debug(userRole.toString());
             AM_Role role = userRole.getRole();
             assertFalse(baseDomManager.isManaged(userRole));
             assertFalse(baseDomManager.isManaged(role));
             if (role != null) {
                 logger.debug("====================================================== >> >> アンマネージドのロール取得 ======================================================");
                 logger.debug(role.toString());
                 List<AT_KinouKengen> kengens = role.getKinouKengens();
                 for (AT_KinouKengen kengen : kengens) {
                     logger.debug(kengen.toString());
                     assertFalse(baseDomManager.isManaged(kengen));
                 }
                 logger.debug("====================================================== アンマネージドのロール取得 << << ======================================================");
             }
         }
         logger.debug("====================================================== アンマネージドのユーザーロール取得 << ======================================================");
     }
     @Transactional
     @Test
     public void test009() {
         logger.debug("====================================================== >> マネージドのユーザー情報取得 ======================================================");
         AM_User user1 = baseDomManager.getUser("unittestadmin");
         logger.debug("====================================================== マネージドのユーザー情報取得 << ======================================================");
         logger.debug("====================================================== >> アンマネージドのユーザー情報取得 ======================================================");
         @SuppressWarnings("unused")
         AM_User user2 = baseDomManager.getDetachedUser("unittestadmin");
         logger.debug("====================================================== アンマネージドのユーザー情報取得 << ======================================================");

         logger.debug("====================================================== >> マネージドのユーザーロール取得 ======================================================");
         List<AT_UserRole> userRoles1 = user1.getUserRoles();
         for (AT_UserRole userRole : userRoles1) {
             userRole.setKousinKinou("テスト");
         }
         logger.debug("====================================================== マネージドのユーザーロール取得 << ======================================================");
         logger.debug("↓↓↓↓↓↓↓↓↓↓↓↓ Update文が発行される ↓↓↓↓↓↓↓↓↓↓↓↓");
     }

     @Transactional
     @Test
     public void test010() {
         logger.debug("====================================================== >> マネージドのユーザー情報取得 ======================================================");
         AM_User user1 = baseDomManager.getUser("unittestadmin");
         user1.detach();
         logger.debug("====================================================== マネージドのユーザー情報取得 << ======================================================");
         logger.debug("====================================================== >> アンマネージドのユーザー情報取得 ======================================================");
         AM_User user2 = baseDomManager.getDetachedUser("unittestadmin");
         logger.debug("====================================================== アンマネージドのユーザー情報取得 << ======================================================");

         logger.debug("====================================================== >> アンマネージドのユーザーロール取得 ======================================================");
         List<AT_UserRole> userRoles2 = user2.getUserRoles();
         for (AT_UserRole userRole : userRoles2) {
             userRole.setKousinKinou("テスト");
             AM_Role role = userRole.getRole();
             assertFalse(baseDomManager.isManaged(userRole));
             assertFalse(baseDomManager.isManaged(role));
             if (role != null) {
                 logger.debug("====================================================== >> >> アンマネージドのロール取得 ======================================================");
                 logger.debug(role.toString());
                 role.setKousinKinou("テスト");
                 List<AT_KinouKengen> kengens = role.getKinouKengens();
                 for (AT_KinouKengen kengen : kengens) {
                     logger.debug(kengen.toString());
                     kengen.setKousinKinou("テスト");
                 }
                 logger.debug("====================================================== アンマネージドのロール取得 << << ======================================================");
             }
         }
         logger.debug("====================================================== アンマネージドのユーザーロール取得 << ======================================================");
         logger.debug("↓↓↓↓↓↓↓↓↓↓↓↓ Update文が発行されない ↓↓↓↓↓↓↓↓↓↓↓↓");
     }

     @Test
     public void test011() {
         AM_User user = baseDomManager.getDetachedUser("unittestadmin");
         assertFalse(baseDomManager.isManaged(user));
         List<AT_UserRole> userRoles = user.getUserRoles();
         for (AT_UserRole userRole : userRoles) {
             assertFalse(baseDomManager.isManaged(userRole));
         }
     }

 }
