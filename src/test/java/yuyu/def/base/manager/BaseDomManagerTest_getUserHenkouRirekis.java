package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.testinfr.AbstractTest;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * BaseDomManagerクラスの、<br />
 * getUserHenkouRirekis() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getUserHenkouRirekis extends AbstractTest {

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

         String pUniqueId1 = "UNI0000004";
         String pUniqueId2 = "UNI0000001";
         String pUniqueId3 = "UNI0000002";
         String pUniqueId4 = "UNI0000003";

         AT_UserHenkouRireki aT_UserHenkouRireki1 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId1);
         if ( null == aT_UserHenkouRireki1 ) {

             aT_UserHenkouRireki1 = new AT_UserHenkouRireki();
             aT_UserHenkouRireki1.setUniqueId(pUniqueId1);
             aT_UserHenkouRireki1.setUserId(pUserId1);

             baseDomManager.insert(aT_UserHenkouRireki1);
         }

         AT_UserHenkouRireki aT_UserHenkouRireki2 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId2);
         if ( null == aT_UserHenkouRireki2 ) {

             aT_UserHenkouRireki2 = new AT_UserHenkouRireki();
             aT_UserHenkouRireki2.setUniqueId(pUniqueId2);
             aT_UserHenkouRireki2.setUserId(pUserId2);

             baseDomManager.insert(aT_UserHenkouRireki2);
         }

         AT_UserHenkouRireki aT_UserHenkouRireki3 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId3);
         if ( null == aT_UserHenkouRireki3 ) {

             aT_UserHenkouRireki3 = new AT_UserHenkouRireki();
             aT_UserHenkouRireki3.setUniqueId(pUniqueId3);
             aT_UserHenkouRireki3.setUserId(pUserId2);

             baseDomManager.insert(aT_UserHenkouRireki3);
         }

         AT_UserHenkouRireki aT_UserHenkouRireki4 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId4);
         if ( null == aT_UserHenkouRireki4 ) {

             aT_UserHenkouRireki4 = new AT_UserHenkouRireki();
             aT_UserHenkouRireki4.setUniqueId(pUniqueId4);
             aT_UserHenkouRireki4.setUserId(pUserId2);

             baseDomManager.insert(aT_UserHenkouRireki4);
         }
     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
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

         String pUniqueId1 = "UNI0000004";
         String pUniqueId2 = "UNI0000001";
         String pUniqueId3 = "UNI0000002";
         String pUniqueId4 = "UNI0000003";

         AT_UserHenkouRireki aTUserHenkouRireki1 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId1);
         if ( null != aTUserHenkouRireki1 ) {

             baseDomManager.delete(aTUserHenkouRireki1);
         }

         AT_UserHenkouRireki aTUserHenkouRireki2 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId2);
         if ( null != aTUserHenkouRireki2 ) {

             baseDomManager.delete(aTUserHenkouRireki2);
         }

         AT_UserHenkouRireki aTUserHenkouRireki3 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId3);
         if ( null != aTUserHenkouRireki3 ) {

             baseDomManager.delete(aTUserHenkouRireki3);
         }

         AT_UserHenkouRireki aTUserHenkouRireki4 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId4);
         if ( null != aTUserHenkouRireki4 ) {

             baseDomManager.delete(aTUserHenkouRireki4);
         }

     }

     @Test
     public void test001(){
         String pUserId = "UI00000099";
         List<AT_UserHenkouRireki> aT_UserHenkouRirekiList = baseDomManager.getUserHenkouRirekis(pUserId);

         assertEquals(0, aT_UserHenkouRirekiList.size());

     }

     @Test
     public void test002(){
         String pUserId = "UI00000001";
         List<AT_UserHenkouRireki> aT_UserHenkouRirekiList = baseDomManager.getUserHenkouRirekis(pUserId);

         List<AT_UserHenkouRireki> resultaT_UserHenkouRirekiList = ImmutableList.copyOf(Iterables.filter(aT_UserHenkouRirekiList, new Predicate<AT_UserHenkouRireki>() {

             @Override
             public boolean apply(AT_UserHenkouRireki paT_UserHenkouRirekiEntity) {

                 List<String> pUniqueIdList = new ArrayList<String>();
                 pUniqueIdList.add("UNI0000004");
                 pUniqueIdList.add("UNI0000001");
                 pUniqueIdList.add("UNI0000002");
                 pUniqueIdList.add("UNI0000003");

                 for (String uniqueId : pUniqueIdList) {
                     if (uniqueId.equals(paT_UserHenkouRirekiEntity.getUniqueId())) {
                         return true;
                     }
                 }

                 return false;
             }

         }));

         long count = resultaT_UserHenkouRirekiList.size();

         assertEquals(1, count);

     }

     @Test
     public void test003(){
         String pUserId = "UI00000002";
         List<AT_UserHenkouRireki> aT_UserHenkouRirekiList = baseDomManager.getUserHenkouRirekis(pUserId);

         List<AT_UserHenkouRireki> resultaT_UserHenkouRirekiList = ImmutableList.copyOf(Iterables.filter(aT_UserHenkouRirekiList, new Predicate<AT_UserHenkouRireki>() {

             @Override
             public boolean apply(AT_UserHenkouRireki paT_UserHenkouRirekiEntity) {

                 List<String> pUniqueIdList = new ArrayList<String>();
                 pUniqueIdList.add("UNI0000004");
                 pUniqueIdList.add("UNI0000001");
                 pUniqueIdList.add("UNI0000002");
                 pUniqueIdList.add("UNI0000003");

                 for (String uniqueId : pUniqueIdList) {
                     if (uniqueId.equals(paT_UserHenkouRirekiEntity.getUniqueId())) {
                         return true;
                     }
                 }

                 return false;
             }

         }));

         long count = resultaT_UserHenkouRirekiList.size();

         assertEquals(3, count);

     }

     @Test
     public void test004(){
         String pUserId = "";
         List<AT_UserHenkouRireki> aT_UserHenkouRirekiList = baseDomManager.getUserHenkouRirekis(pUserId);

         assertEquals(0, aT_UserHenkouRirekiList.size());

     }

     @Test
     public void test005(){
         String pUserId = null;
         List<AT_UserHenkouRireki> aT_UserHenkouRirekiList = baseDomManager.getUserHenkouRirekis(pUserId);

         assertEquals(0, aT_UserHenkouRirekiList.size());

     }

     @Test
     public void test006(){
         String pUserId = "UI00000002";
         List<AT_UserHenkouRireki> aT_UserHenkouRirekiList = baseDomManager.getUserHenkouRirekis(pUserId);

         List<AT_UserHenkouRireki> resultaT_UserHenkouRirekiList = ImmutableList.copyOf(Iterables.filter(aT_UserHenkouRirekiList, new Predicate<AT_UserHenkouRireki>() {

             @Override
             public boolean apply(AT_UserHenkouRireki paT_UserHenkouRirekiEntity) {

                 List<String> pUniqueIdList = new ArrayList<String>();
                 pUniqueIdList.add("UNI0000004");
                 pUniqueIdList.add("UNI0000001");
                 pUniqueIdList.add("UNI0000002");
                 pUniqueIdList.add("UNI0000003");

                 for (String uniqueId : pUniqueIdList) {
                     if (uniqueId.equals(paT_UserHenkouRirekiEntity.getUniqueId())) {
                         return true;
                     }
                 }

                 return false;
             }

         }));

         String pUniqueId1 = "UNI0000001";
         String pUniqueId2 = "UNI0000002";
         String pUniqueId3 = "UNI0000003";

         assertEquals(pUniqueId1, resultaT_UserHenkouRirekiList.get(0).getUniqueId());

         assertEquals(pUniqueId2, resultaT_UserHenkouRirekiList.get(1).getUniqueId());

         assertEquals(pUniqueId3, resultaT_UserHenkouRirekiList.get(2).getUniqueId());

     }

 }
