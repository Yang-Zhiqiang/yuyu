package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getUserByCountUserGroupCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getSosikiRolesByTanmatusettisosikicd extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         List<AT_SosikiRole> sosikiRoleLst = baseDomManager.getSosikiRolesByTanmatusettisosikicd("cd001");
         Assert.assertEquals(0,sosikiRoleLst.size());

         AT_SosikiRole sosikiRole = new AT_SosikiRole();
         sosikiRole.setTanmatusettisosikicd("cd001");
         sosikiRole.setRoleCd("101");
         baseDomManager.insert(sosikiRole);


         AT_SosikiRole sosikiRole2 = new AT_SosikiRole();
         sosikiRole2.setTanmatusettisosikicd("cd003");
         sosikiRole2.setRoleCd("101");
         baseDomManager.insert(sosikiRole2);

         AT_SosikiRole sosikiRole3 = new AT_SosikiRole();
         sosikiRole3.setTanmatusettisosikicd("cd003");
         sosikiRole3.setRoleCd("102");
         baseDomManager.insert(sosikiRole3);

         AT_SosikiRole sosikiRole4 = new AT_SosikiRole();
         sosikiRole4.setTanmatusettisosikicd("cd003");
         sosikiRole4.setRoleCd("103");
         baseDomManager.insert(sosikiRole4);

         AT_SosikiRole sosikiRole5 = new AT_SosikiRole();
         sosikiRole5.setTanmatusettisosikicd("cd002");
         sosikiRole5.setRoleCd("101");
         baseDomManager.insert(sosikiRole5);
     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
         baseDomManager.delete(baseDomManager.getAllSosikiRoles());
     }

     @Test
     @TestOrder(30)
     public void noResult1(){

         List<AT_SosikiRole> sosikiRoleLst = baseDomManager.getSosikiRolesByTanmatusettisosikicd("cd004");

         assertEquals(0, sosikiRoleLst.size());
     }

     @Test
     @TestOrder(30)
     public void normal1(){

         List<AT_SosikiRole> sosikiRoleLst = baseDomManager.getSosikiRolesByTanmatusettisosikicd("cd001");

         assertEquals(1, sosikiRoleLst.size());
         assertEquals("cd001", sosikiRoleLst.get(0).getTanmatusettisosikicd());
         assertEquals("101",sosikiRoleLst.get(0).getRoleCd());
     }
     @Test
     @TestOrder(30)
     public void normal2(){

         List<AT_SosikiRole> sosikiRoleLst = baseDomManager.getSosikiRolesByTanmatusettisosikicd("cd003");

         assertEquals(3, sosikiRoleLst.size());
         assertEquals("cd003", sosikiRoleLst.get(0).getTanmatusettisosikicd());
         assertEquals("101",sosikiRoleLst.get(0).getRoleCd());

         assertEquals("cd003", sosikiRoleLst.get(1).getTanmatusettisosikicd());
         assertEquals("102",sosikiRoleLst.get(1).getRoleCd());

         assertEquals("cd003", sosikiRoleLst.get(2).getTanmatusettisosikicd());
         assertEquals("103",sosikiRoleLst.get(2).getRoleCd());
     }

     @Test
     @TestOrder(40)
     public void blankCondition1() {

         List<AT_SosikiRole> sosikiRoleLst = baseDomManager.getSosikiRolesByTanmatusettisosikicd("");

         assertEquals(0, sosikiRoleLst.size());

     }
 }


