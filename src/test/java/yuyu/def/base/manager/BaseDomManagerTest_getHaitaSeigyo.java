package yuyu.def.base.manager;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AM_HaitaSyurui;
import yuyu.def.db.entity.AT_HaitaSeigyo;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getHaitaSeigyo() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getHaitaSeigyo extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pHaitaSyuruiCd = "HSC0000001";
         AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
         if ( null == aM_HaitaSyurui ) {

             aM_HaitaSyurui = new AM_HaitaSyurui();
             aM_HaitaSyurui.setHaitaSyuruiCd(pHaitaSyuruiCd);

             baseDomManager.insert(aM_HaitaSyurui);
         }

         String pHaitaKey = "HK00000001";
         String pHaitamotoKinouId = "HKI0000001";
         String pHaitaUserId = "HUI0000001";
         String pHaitaKaisiTime = "20130613000000001";
         String pHaitaUniqueKey = "HUK0000001";

         AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
         if ( null == aT_HaitaSeigyo ){

             aT_HaitaSeigyo = new AT_HaitaSeigyo();
             aT_HaitaSeigyo.setHaitaSyuruiCd(pHaitaSyuruiCd);
             aT_HaitaSeigyo.setHaitaKey(pHaitaKey);
             aT_HaitaSeigyo.setHaitamotoKinouId(pHaitamotoKinouId);
             aT_HaitaSeigyo.setHaitaUserId(pHaitaUserId);
             aT_HaitaSeigyo.setHaitaKaisiTime(pHaitaKaisiTime);
             aT_HaitaSeigyo.setHaitaUniqueKey(pHaitaUniqueKey);

             baseDomManager.insert(aT_HaitaSeigyo);
         }
     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pHaitaSyuruiCd = "HSC0000001";
         String pHaitaKey = "HK00000001";

         AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
         if ( null != aT_HaitaSeigyo ) {

             baseDomManager.delete(aT_HaitaSeigyo);
         }

         AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
         if ( null != aM_HaitaSyurui ) {

             baseDomManager.delete(aM_HaitaSyurui);
         }
     }

     @Test
     @Transactional
     public void test001(){
         String pHaitaSyuruiCd = "HSC0000099";
         String pHaitaKey = "HK00000099";

         AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);

         assertNull(aT_HaitaSeigyo);

     }

     @Test
     @Transactional
     public void test002(){
         String pHaitaSyuruiCd = "HSC0000001";
         String pHaitaKey = "HK00000001";

         AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);

         assertNotNull(aT_HaitaSeigyo);
     }

     @Test
     public void test003(){
         String pHaitaSyuruiCd = "";
         String pHaitaKey = "";

         AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);

         assertNull(aT_HaitaSeigyo);
     }


     @Test
     public void test004(){
         String pHaitaSyuruiCd = null;
         String pHaitaKey = null;

         try {
             baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
         } catch (Exception e) {
             assertThat(e, instanceOf(NonUniqueResultException.class));
         }
     }

 }
