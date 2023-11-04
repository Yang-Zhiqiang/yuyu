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

import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getRoleSiyouKanouSosikisBySyozokusosikicd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getRoleSiyouKanouSosikisBySyozokusosikicd extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiLst = baseDomManager.getRoleSiyouKanouSosikisBySyozokusosikicd("AAA");
         assertEquals(0, roleSiyouKanouSosikiLst.size());

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki1 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki1.setRoleCd("6");
         roleSiyouKanouSosiki1.setSyozokusosikicd("A");
         baseDomManager.insert(roleSiyouKanouSosiki1);

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki2 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki2.setRoleCd("1");
         roleSiyouKanouSosiki2.setSyozokusosikicd("AAA");
         baseDomManager.insert(roleSiyouKanouSosiki2);

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki3 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki3.setRoleCd("4");
         roleSiyouKanouSosiki3.setSyozokusosikicd("ABB");
         baseDomManager.insert(roleSiyouKanouSosiki3);

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki4 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki4.setRoleCd("7");
         roleSiyouKanouSosiki4.setSyozokusosikicd("B");
         baseDomManager.insert(roleSiyouKanouSosiki4);

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki5 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki5.setRoleCd("3");
         roleSiyouKanouSosiki5.setSyozokusosikicd("BAA");
         baseDomManager.insert(roleSiyouKanouSosiki5);

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki6 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki6.setRoleCd("2");
         roleSiyouKanouSosiki6.setSyozokusosikicd("BBB");
         baseDomManager.insert(roleSiyouKanouSosiki6);

         AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki7 = new AT_RoleSiyouKanouSosiki();
         roleSiyouKanouSosiki7.setRoleCd("5");
         roleSiyouKanouSosiki7.setSyozokusosikicd("CDE");
         baseDomManager.insert(roleSiyouKanouSosiki7);

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
         baseDomManager.delete(baseDomManager.getAllRoleSiyouKanouSosikis());
     }

     @Test
     @TestOrder(30)
     public void noResult1(){

         List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiLst = baseDomManager.getRoleSiyouKanouSosikisBySyozokusosikicd("DDD");

         assertEquals(0, roleSiyouKanouSosikiLst.size());
     }

     @Test
     @TestOrder(40)
     public void normal1(){

         List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiLst = baseDomManager.getRoleSiyouKanouSosikisBySyozokusosikicd("BB");

         assertEquals(1, roleSiyouKanouSosikiLst.size());
         assertEquals("2", roleSiyouKanouSosikiLst.get(0).getRoleCd());
         assertEquals("BBB", roleSiyouKanouSosikiLst.get(0).getSyozokusosikicd());

     }

     @Test
     @TestOrder(50)
     public void normal2(){

         List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiLst = baseDomManager.getRoleSiyouKanouSosikisBySyozokusosikicd("B");

         assertEquals(3, roleSiyouKanouSosikiLst.size());
         assertEquals("2", roleSiyouKanouSosikiLst.get(0).getRoleCd());
         assertEquals("BBB", roleSiyouKanouSosikiLst.get(0).getSyozokusosikicd());

         assertEquals("3", roleSiyouKanouSosikiLst.get(1).getRoleCd());
         assertEquals("BAA", roleSiyouKanouSosikiLst.get(1).getSyozokusosikicd());

         assertEquals("7", roleSiyouKanouSosikiLst.get(2).getRoleCd());
         assertEquals("B", roleSiyouKanouSosikiLst.get(2).getSyozokusosikicd());
     }

     @Test
     @TestOrder(60)
     public void normal3(){

         List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiLst = baseDomManager.getRoleSiyouKanouSosikisBySyozokusosikicd("C");

         assertEquals(1, roleSiyouKanouSosikiLst.size());
         assertEquals("5", roleSiyouKanouSosikiLst.get(0).getRoleCd());
         assertEquals("CDE", roleSiyouKanouSosikiLst.get(0).getSyozokusosikicd());

     }

     @Test
     @TestOrder(70)
     public void blankCondition() {

         List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiLst = baseDomManager.getRoleSiyouKanouSosikisBySyozokusosikicd("");

         assertEquals(7, roleSiyouKanouSosikiLst.size());
         assertEquals("1", roleSiyouKanouSosikiLst.get(0).getRoleCd());
         assertEquals("AAA", roleSiyouKanouSosikiLst.get(0).getSyozokusosikicd());

         assertEquals("2", roleSiyouKanouSosikiLst.get(1).getRoleCd());
         assertEquals("BBB", roleSiyouKanouSosikiLst.get(1).getSyozokusosikicd());

         assertEquals("3", roleSiyouKanouSosikiLst.get(2).getRoleCd());
         assertEquals("BAA", roleSiyouKanouSosikiLst.get(2).getSyozokusosikicd());

         assertEquals("4", roleSiyouKanouSosikiLst.get(3).getRoleCd());
         assertEquals("ABB", roleSiyouKanouSosikiLst.get(3).getSyozokusosikicd());

         assertEquals("5", roleSiyouKanouSosikiLst.get(4).getRoleCd());
         assertEquals("CDE", roleSiyouKanouSosikiLst.get(4).getSyozokusosikicd());

         assertEquals("6", roleSiyouKanouSosikiLst.get(5).getRoleCd());
         assertEquals("A", roleSiyouKanouSosikiLst.get(5).getSyozokusosikicd());

         assertEquals("7", roleSiyouKanouSosikiLst.get(6).getRoleCd());
         assertEquals("B", roleSiyouKanouSosikiLst.get(6).getSyozokusosikicd());
     }
 }

