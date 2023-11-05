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

import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getKinousBySubSystem() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getKinousBySubSystem extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pSubSystemId1 = "SSI0000001";
         String pSubSystemId2 = "SSI0000002";
         String pSubSystemId3 = "SSI0000003";
         int pSubSystemSortNo1 = 1;
         int pSubSystemSortNo2 = 2;
         int pSubSystemSortNo3 = 3;

         AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
         if ( null == aS_SubSystem1 ) {

             aS_SubSystem1 = new AS_SubSystem();
             aS_SubSystem1.setSubSystemId(pSubSystemId1);
             aS_SubSystem1.setSortNo(pSubSystemSortNo1);

             baseDomManager.insert(aS_SubSystem1);
         }

         AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
         if ( null == aS_SubSystem2 ) {

             aS_SubSystem2 = new AS_SubSystem();
             aS_SubSystem2.setSubSystemId(pSubSystemId2);
             aS_SubSystem2.setSortNo(pSubSystemSortNo2);

             baseDomManager.insert(aS_SubSystem2);
         }

         AS_SubSystem aS_SubSystem3 = baseDomManager.getSubSystem(pSubSystemId3);
         if ( null == aS_SubSystem3 ) {

             aS_SubSystem3 = new AS_SubSystem();
             aS_SubSystem3.setSubSystemId(pSubSystemId3);
             aS_SubSystem3.setSortNo(pSubSystemSortNo3);

             baseDomManager.insert(aS_SubSystem3);
         }

         String pCategoryId1 = "CI00000001";
         String pCategoryId2 = "CI00000002";
         String pCategoryId3 = "CI00000003";
         int pCategorySortNo1 = 3;
         int pCategorySortNo2 = 1;
         int pCategorySortNo3 = 2;

         AS_Category aS_Category1 = baseDomManager.getCategory(pCategoryId1);
         if ( null == aS_Category1 ) {

             aS_Category1 = new AS_Category();
             aS_Category1.setCategoryId(pCategoryId1);
             aS_Category1.setSortNo(pCategorySortNo1);

             baseDomManager.insert(aS_Category1);
         }

         AS_Category aS_Category2 = baseDomManager.getCategory(pCategoryId2);
         if ( null == aS_Category2 ) {

             aS_Category2 = new AS_Category();
             aS_Category2.setCategoryId(pCategoryId2);
             aS_Category2.setSortNo(pCategorySortNo2);

             baseDomManager.insert(aS_Category2);
         }

         AS_Category aS_Category3 = baseDomManager.getCategory(pCategoryId3);
         if ( null == aS_Category3 ) {

             aS_Category3 = new AS_Category();
             aS_Category3.setCategoryId(pCategoryId3);
             aS_Category3.setSortNo(pCategorySortNo3);

             baseDomManager.insert(aS_Category3);
         }

         String pKinouId1 = "KI00000001";
         String pKinouId2 = "KI00000002";
         String pKinouId3 = "KI00000003";
         String pKinouId4 = "KI00000004";
         String pKinouId5 = "KI00000005";
         String pKinouId6 = "KI00000006";
         String pKinouId7 = "KI00000007";
         String pKinouId8 = "KI00000008";
         String pKinouId9 = "KI00000009";
         String pKinouId10 = "KI00000010";
         String pKinouId11 = "KI00000011";
         int pKinouSortNo1 = 3;
         int pKinouSortNo2 = 2;
         int pKinouSortNo3 = 7;
         int pKinouSortNo4 = 5;
         int pKinouSortNo5 = 3;
         int pKinouSortNo6 = 2;
         int pKinouSortNo7 = 7;
         int pKinouSortNo8 = 5;
         int pKinouSortNo9 = 1;
         int pKinouSortNo10 = 6;
         int pKinouSortNo11 = 4;

         AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
         if ( null == aS_Kinou1 ) {

             aS_Kinou1 = new AS_Kinou();
             aS_Kinou1.setKinouId(pKinouId1);
             aS_Kinou1.setSubSystemId(pSubSystemId1);
             aS_Kinou1.setCategoryId(pCategoryId1);
             aS_Kinou1.setSortNo(pKinouSortNo1);

             baseDomManager.insert(aS_Kinou1);
         }

         AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
         if ( null == aS_Kinou2 ) {

             aS_Kinou2 = new AS_Kinou();
             aS_Kinou2.setKinouId(pKinouId2);
             aS_Kinou2.setSubSystemId(pSubSystemId2);
             aS_Kinou2.setCategoryId(pCategoryId1);
             aS_Kinou2.setSortNo(pKinouSortNo2);

             baseDomManager.insert(aS_Kinou2);
         }

         AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
         if ( null == aS_Kinou3 ) {

             aS_Kinou3 = new AS_Kinou();
             aS_Kinou3.setKinouId(pKinouId3);
             aS_Kinou3.setSubSystemId(pSubSystemId2);
             aS_Kinou3.setCategoryId(pCategoryId1);
             aS_Kinou3.setSortNo(pKinouSortNo3);

             baseDomManager.insert(aS_Kinou3);
         }

         AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
         if ( null == aS_Kinou4 ) {

             aS_Kinou4 = new AS_Kinou();
             aS_Kinou4.setKinouId(pKinouId4);
             aS_Kinou4.setSubSystemId(pSubSystemId2);
             aS_Kinou4.setCategoryId(pCategoryId1);
             aS_Kinou4.setSortNo(pKinouSortNo4);

             baseDomManager.insert(aS_Kinou4);
         }

         AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
         if ( null == aS_Kinou5 ) {

             aS_Kinou5 = new AS_Kinou();
             aS_Kinou5.setKinouId(pKinouId5);
             aS_Kinou5.setSubSystemId(pSubSystemId3);
             aS_Kinou5.setCategoryId(pCategoryId1);
             aS_Kinou5.setSortNo(pKinouSortNo5);

             baseDomManager.insert(aS_Kinou5);
         }

         AS_Kinou aS_Kinou6 = baseDomManager.getKinou(pKinouId6);
         if ( null == aS_Kinou6 ) {

             aS_Kinou6 = new AS_Kinou();
             aS_Kinou6.setKinouId(pKinouId6);
             aS_Kinou6.setSubSystemId(pSubSystemId3);
             aS_Kinou6.setCategoryId(pCategoryId1);
             aS_Kinou6.setSortNo(pKinouSortNo6);

             baseDomManager.insert(aS_Kinou6);
         }

         AS_Kinou aS_Kinou7 = baseDomManager.getKinou(pKinouId7);
         if ( null == aS_Kinou7 ) {

             aS_Kinou7 = new AS_Kinou();
             aS_Kinou7.setKinouId(pKinouId7);
             aS_Kinou7.setSubSystemId(pSubSystemId3);
             aS_Kinou7.setCategoryId(pCategoryId1);
             aS_Kinou7.setSortNo(pKinouSortNo7);

             baseDomManager.insert(aS_Kinou7);
         }

         AS_Kinou aS_Kinou8 = baseDomManager.getKinou(pKinouId8);
         if ( null == aS_Kinou8 ) {

             aS_Kinou8 = new AS_Kinou();
             aS_Kinou8.setKinouId(pKinouId8);
             aS_Kinou8.setSubSystemId(pSubSystemId3);
             aS_Kinou8.setCategoryId(pCategoryId2);
             aS_Kinou8.setSortNo(pKinouSortNo8);

             baseDomManager.insert(aS_Kinou8);
         }

         AS_Kinou aS_Kinou9 = baseDomManager.getKinou(pKinouId9);
         if ( null == aS_Kinou9 ) {

             aS_Kinou9 = new AS_Kinou();
             aS_Kinou9.setKinouId(pKinouId9);
             aS_Kinou9.setSubSystemId(pSubSystemId3);
             aS_Kinou9.setCategoryId(pCategoryId2);
             aS_Kinou9.setSortNo(pKinouSortNo9);

             baseDomManager.insert(aS_Kinou9);
         }

         AS_Kinou aS_Kinou10 = baseDomManager.getKinou(pKinouId10);
         if ( null == aS_Kinou10 ) {

             aS_Kinou10 = new AS_Kinou();
             aS_Kinou10.setKinouId(pKinouId10);
             aS_Kinou10.setSubSystemId(pSubSystemId3);
             aS_Kinou10.setCategoryId(pCategoryId3);
             aS_Kinou10.setSortNo(pKinouSortNo10);

             baseDomManager.insert(aS_Kinou10);
         }

         AS_Kinou aS_Kinou11 = baseDomManager.getKinou(pKinouId11);
         if ( null == aS_Kinou11 ) {

             aS_Kinou11 = new AS_Kinou();
             aS_Kinou11.setKinouId(pKinouId11);
             aS_Kinou11.setSubSystemId(pSubSystemId3);
             aS_Kinou11.setCategoryId(pCategoryId3);
             aS_Kinou11.setSortNo(pKinouSortNo11);

             baseDomManager.insert(aS_Kinou11);
         }

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pKinouId1 = "KI00000001";
         String pKinouId2 = "KI00000002";
         String pKinouId3 = "KI00000003";
         String pKinouId4 = "KI00000004";
         String pKinouId5 = "KI00000005";
         String pKinouId6 = "KI00000006";
         String pKinouId7 = "KI00000007";
         String pKinouId8 = "KI00000008";
         String pKinouId9 = "KI00000009";
         String pKinouId10 = "KI00000010";
         String pKinouId11 = "KI00000011";

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

         AS_Kinou aS_Kinou6 = baseDomManager.getKinou(pKinouId6);
         if ( null != aS_Kinou6 ) {

             baseDomManager.delete(aS_Kinou6);
         }

         AS_Kinou aS_Kinou7 = baseDomManager.getKinou(pKinouId7);
         if ( null != aS_Kinou7 ) {

             baseDomManager.delete(aS_Kinou7);
         }

         AS_Kinou aS_Kinou8 = baseDomManager.getKinou(pKinouId8);
         if ( null != aS_Kinou8 ) {

             baseDomManager.delete(aS_Kinou8);
         }

         AS_Kinou aS_Kinou9 = baseDomManager.getKinou(pKinouId9);
         if ( null != aS_Kinou9 ) {

             baseDomManager.delete(aS_Kinou9);
         }

         AS_Kinou aS_Kinou10 = baseDomManager.getKinou(pKinouId10);
         if ( null != aS_Kinou10 ) {

             baseDomManager.delete(aS_Kinou10);
         }

         AS_Kinou aS_Kinou11 = baseDomManager.getKinou(pKinouId11);
         if ( null != aS_Kinou11 ) {

             baseDomManager.delete(aS_Kinou11);
         }

         String pCategoryId1 = "CI00000001";
         String pCategoryId2 = "CI00000002";
         String pCategoryId3 = "CI00000003";

         AS_Category aS_Category1 = baseDomManager.getCategory(pCategoryId1);
         if ( null != aS_Category1 ) {

             baseDomManager.delete(aS_Category1);
         }

         AS_Category aS_Category2 = baseDomManager.getCategory(pCategoryId2);
         if ( null != aS_Category2 ) {

             baseDomManager.delete(aS_Category2);
         }

         AS_Category aS_Category3 = baseDomManager.getCategory(pCategoryId3);
         if ( null != aS_Category3 ) {

             baseDomManager.delete(aS_Category3);
         }

         String pSubSystemId1 = "SSI0000001";
         String pSubSystemId2 = "SSI0000002";
         String pSubSystemId3 = "SSI0000003";

         AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
         if ( null != aS_SubSystem1 ) {

             baseDomManager.delete(aS_SubSystem1);
         }

         AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
         if ( null != aS_SubSystem2 ) {

             baseDomManager.delete(aS_SubSystem2);
         }

         AS_SubSystem aS_SubSystem3 = baseDomManager.getSubSystem(pSubSystemId3);
         if ( null != aS_SubSystem3 ) {

             baseDomManager.delete(aS_SubSystem3);
         }

     }

     @Test
     public void test001(){
         String pSubSystemId = "SSI0000099";
         List<AS_Kinou> aS_KinouList = baseDomManager.getKinousBySubSystem(pSubSystemId);

         assertEquals(0, aS_KinouList.size());

     }

     @Test
     public void test002(){
         String pSubSystemId = "SSI0000001";
         List<AS_Kinou> aS_KinouList = baseDomManager.getKinousBySubSystem(pSubSystemId);

         assertEquals(1, aS_KinouList.size());


     }

     @Test
     public void test003(){
         String pSubSystemId = "SSI0000002";
         List<AS_Kinou> aS_KinouList = baseDomManager.getKinousBySubSystem(pSubSystemId);

         assertEquals(3, aS_KinouList.size());


     }

     @Test
     public void test004(){
         String pSubSystemId = "";
         List<AS_Kinou> aS_KinouList = baseDomManager.getKinousBySubSystem(pSubSystemId);

         assertEquals(0, aS_KinouList.size());


     }

     @Test
     public void test005(){
         String pSubSystemId = null;
         List<AS_Kinou> aS_KinouList = baseDomManager.getKinousBySubSystem(pSubSystemId);

         assertEquals(0, aS_KinouList.size());

     }

     @Test
     public void test006(){
         String pSubSystemId = "SSI0000003";
         List<AS_Kinou> aS_KinouList = baseDomManager.getKinousBySubSystem(pSubSystemId);

         String pCategoryId1 = "CI00000001";
         String pCategoryId2 = "CI00000002";
         String pCategoryId3 = "CI00000003";
         String pKinouId1 = "KI00000005";
         String pKinouId2 = "KI00000006";
         String pKinouId3 = "KI00000007";
         String pKinouId4 = "KI00000008";
         String pKinouId5 = "KI00000009";
         String pKinouId6 = "KI00000010";
         String pKinouId7 = "KI00000011";

         assertEquals(pCategoryId2, aS_KinouList.get(0).getCategoryId());
         assertEquals(pKinouId5, aS_KinouList.get(0).getKinouId());

         assertEquals(pCategoryId2, aS_KinouList.get(1).getCategoryId());
         assertEquals(pKinouId4, aS_KinouList.get(1).getKinouId());

         assertEquals(pCategoryId3, aS_KinouList.get(2).getCategoryId());
         assertEquals(pKinouId7, aS_KinouList.get(2).getKinouId());

         assertEquals(pCategoryId3, aS_KinouList.get(3).getCategoryId());
         assertEquals(pKinouId6, aS_KinouList.get(3).getKinouId());

         assertEquals(pCategoryId1, aS_KinouList.get(4).getCategoryId());
         assertEquals(pKinouId2, aS_KinouList.get(4).getKinouId());

         assertEquals(pCategoryId1, aS_KinouList.get(5).getCategoryId());
         assertEquals(pKinouId1, aS_KinouList.get(5).getKinouId());

         assertEquals(pCategoryId1, aS_KinouList.get(6).getCategoryId());
         assertEquals(pKinouId3, aS_KinouList.get(6).getKinouId());
     }
 }
