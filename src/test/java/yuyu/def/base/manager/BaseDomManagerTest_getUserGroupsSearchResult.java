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

import yuyu.def.db.entity.AM_UserGroup;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getUserGroupsSerchResult() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getUserGroupsSearchResult extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUserGroupCd1 = "UGC0000001";
         String pUserGroupCd2 = "UGC0000002";
         String pUserGroupCd3 = "UGC0000003";
         String pUserGroupCd4 = "UGC0000004";
         String pUserGroupNm1 = "ユーザーグループ名１";
         String pUserGroupNm2 = "ユーザーグループ名２";

         AM_UserGroup aM_UserGroup1 = baseDomManager.getUserGroup(pUserGroupCd1);
         if ( null == aM_UserGroup1 ) {

             aM_UserGroup1 = new AM_UserGroup();
             aM_UserGroup1.setUserGroupCd(pUserGroupCd1);
             aM_UserGroup1.setUserGroupNm(pUserGroupNm1);

             baseDomManager.insert(aM_UserGroup1);
         }

         AM_UserGroup aM_UserGroup2 = baseDomManager.getUserGroup(pUserGroupCd2);
         if ( null == aM_UserGroup2 ) {

             aM_UserGroup2 = new AM_UserGroup();
             aM_UserGroup2.setUserGroupCd(pUserGroupCd2);
             aM_UserGroup2.setUserGroupNm(pUserGroupNm2);

             baseDomManager.insert(aM_UserGroup2);
         }

         AM_UserGroup aM_UserGroup3 = baseDomManager.getUserGroup(pUserGroupCd3);
         if ( null == aM_UserGroup3 ) {

             aM_UserGroup3 = new AM_UserGroup();
             aM_UserGroup3.setUserGroupCd(pUserGroupCd3);
             aM_UserGroup3.setUserGroupNm(pUserGroupNm2);

             baseDomManager.insert(aM_UserGroup3);
         }

         AM_UserGroup aM_UserGroup4 = baseDomManager.getUserGroup(pUserGroupCd4);
         if ( null == aM_UserGroup4 ) {

             aM_UserGroup4 = new AM_UserGroup();
             aM_UserGroup4.setUserGroupCd(pUserGroupCd4);
             aM_UserGroup4.setUserGroupNm(pUserGroupNm2);

             baseDomManager.insert(aM_UserGroup4);
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

         AM_UserGroup aM_UserGroup1 = baseDomManager.getUserGroup(pUserGroupCd1);
         if ( null != aM_UserGroup1 ) {

             baseDomManager.delete(aM_UserGroup1);
         }

         AM_UserGroup aM_UserGroup2 = baseDomManager.getUserGroup(pUserGroupCd2);
         if ( null != aM_UserGroup2 ) {

             baseDomManager.delete(aM_UserGroup2);
         }

         AM_UserGroup aM_UserGroup3 = baseDomManager.getUserGroup(pUserGroupCd3);
         if ( null != aM_UserGroup3 ) {

             baseDomManager.delete(aM_UserGroup3);
         }

         AM_UserGroup aM_UserGroup4 = baseDomManager.getUserGroup(pUserGroupCd4);
         if ( null != aM_UserGroup4 ) {

             baseDomManager.delete(aM_UserGroup4);
         }

     }

     @Test
     public void test001(){
         String pUserGroupCd = "UGC0000099";
         String pUserGroupNm = "ユーザーグループ名３";
         List<AM_UserGroup> aM_UserGrouplist = baseDomManager.getUserGroupsSerchResult(pUserGroupCd, pUserGroupNm);

         assertEquals(0, aM_UserGrouplist.size());

     }

     @Test
     public void test002(){
         String pUserGroupCd = "UGC0000001";
         String pUserGroupNm = "ユーザーグループ名";
         List<AM_UserGroup> aM_UserGrouplist = baseDomManager.getUserGroupsSerchResult(pUserGroupCd, pUserGroupNm);

         assertEquals(1, aM_UserGrouplist.size());


     }

     @Test
     public void test003(){
         String pUserGroupCd = "UGC00000";
         String pUserGroupNm = "ユーザーグループ名２";
         List<AM_UserGroup> aM_UserGrouplist = baseDomManager.getUserGroupsSerchResult(pUserGroupCd, pUserGroupNm);

         assertEquals(3, aM_UserGrouplist.size());


     }

     @Test
     public void test004(){
         String pUserGroupCd = "";
         String pUserGroupNm = "";
         List<AM_UserGroup> aM_UserGrouplist = baseDomManager.getUserGroupsSerchResult(pUserGroupCd, pUserGroupNm);

         assertEquals(4, aM_UserGrouplist.size());

     }

     @Test
     public void test005(){
         String pUserGroupCd = null;
         String pUserGroupNm = null;
         List<AM_UserGroup> aM_UserGrouplist = baseDomManager.getUserGroupsSerchResult(pUserGroupCd, pUserGroupNm);

         assertEquals(4, aM_UserGrouplist.size());

     }

 }
