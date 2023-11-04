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

import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchId() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getBatchId extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pKinouId1 = "KI00000001";
         String pKinouId2 = "KI00000002";
         String pKinouId3 = "KI00000003";

         AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
         if ( null == aS_Kinou1 ){

             aS_Kinou1 = new AS_Kinou();
             aS_Kinou1.setKinouId(pKinouId1);

             baseDomManager.insert(aS_Kinou1);
         }

         AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
         if ( null == aS_Kinou2 ){

             aS_Kinou2 = new AS_Kinou();
             aS_Kinou2.setKinouId(pKinouId2);

             baseDomManager.insert(aS_Kinou2);
         }

         AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
         if ( null == aS_Kinou3 ){

             aS_Kinou3 = new AS_Kinou();
             aS_Kinou3.setKinouId(pKinouId3);

             baseDomManager.insert(aS_Kinou3);
         }

         String pBatchClass1 = "BC00000001";
         String pBatchClass2 = "BC00000002";
         String pBatchClass3 = "BC00000003";
         C_KahiKbn pTajuukidouKahiKbn1 = C_KahiKbn.KA;
         C_KahiKbn pTajuukidouKahiKbn2 = C_KahiKbn.KA;
         C_KahiKbn pTajuukidouKahiKbn3 = C_KahiKbn.KA;
         C_BatchModeKbn pBatchMode1 = C_BatchModeKbn .HIDOUKI;
         C_BatchModeKbn pBatchMode2 = C_BatchModeKbn .HIDOUKI;
         C_BatchModeKbn pBatchMode3 = C_BatchModeKbn .HIDOUKI;
         C_KahiKbn pTyuudanKahi1 = C_KahiKbn.HUKA;
         C_KahiKbn pTyuudanKahi2 = C_KahiKbn.HUKA;
         C_KahiKbn pTyuudanKahi3 = C_KahiKbn.KA;

         AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
         if ( null == aM_Batch1 ) {

             aM_Batch1 = new AM_Batch();
             aM_Batch1.setKinouId(pKinouId1);
             aM_Batch1.setBatchClass(pBatchClass1);
             aM_Batch1.setTajuukidouKahiKbn(pTajuukidouKahiKbn1);
             aM_Batch1.setBatchMode(pBatchMode1);
             aM_Batch1.setTyuudanKahi(pTyuudanKahi1);

             baseDomManager.insert(aM_Batch1);
         }

         AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
         if ( null == aM_Batch2 ) {

             aM_Batch2 = new AM_Batch();
             aM_Batch2.setKinouId(pKinouId2);
             aM_Batch2.setBatchClass(pBatchClass2);
             aM_Batch2.setTajuukidouKahiKbn(pTajuukidouKahiKbn2);
             aM_Batch2.setBatchMode(pBatchMode2);
             aM_Batch2.setTyuudanKahi(pTyuudanKahi2);

             baseDomManager.insert(aM_Batch2);
         }

         AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
         if ( null == aM_Batch3 ) {

             aM_Batch3 = new AM_Batch();
             aM_Batch3.setKinouId(pKinouId3);
             aM_Batch3.setBatchClass(pBatchClass3);
             aM_Batch3.setTajuukidouKahiKbn(pTajuukidouKahiKbn3);
             aM_Batch3.setBatchMode(pBatchMode3);
             aM_Batch3.setTyuudanKahi(pTyuudanKahi3);

             baseDomManager.insert(aM_Batch3);
         }

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pKinouId1 = "KI00000001";
         String pKinouId2 = "KI00000002";
         String pKinouId3 = "KI00000003";

         AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
         if ( null != aM_Batch1 ) {

             baseDomManager.delete(aM_Batch1);
         }

         AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
         if ( null != aM_Batch2 ) {

             baseDomManager.delete(aM_Batch2);
         }

         AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
         if ( null != aM_Batch3 ) {

             baseDomManager.delete(aM_Batch3);
         }

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
     }

     @Test
     public void test001(){
         String pKinouId = "KI00000099";
         String resultKinouId = "";
         try {
             baseDomManager.getBatch(pKinouId).getBatchId();
         } catch (Exception e) {
             resultKinouId = null;
         }

         assertEquals(null, resultKinouId);
     }

     @Test
     public void test002(){
         String pKinouId = "KI00000001";
         String resulrKinouId = baseDomManager.getBatch(pKinouId).getBatchId();

         assertEquals(pKinouId, resulrKinouId);
     }

 }
