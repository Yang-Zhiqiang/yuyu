package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getTokuteibiKadouTimeByCountKadouTimeGroupCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getTokuteibiKadouTimeByCountKadouTimeGroupCd extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pKadouTimeGroupCd1 = "KGC0000001";
         String pKadouTimeGroupCd2 = "KGC0000002";

         AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
         if ( null == aT_KadouTimeGroup1 ) {

             aT_KadouTimeGroup1 = new AT_KadouTimeGroup();
             aT_KadouTimeGroup1.setKadouTimeGroupCd(pKadouTimeGroupCd1);

             baseDomManager.insert(aT_KadouTimeGroup1);

         }

         AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
         if ( null == aT_KadouTimeGroup2 ) {

             aT_KadouTimeGroup2 = new AT_KadouTimeGroup();
             aT_KadouTimeGroup2.setKadouTimeGroupCd(pKadouTimeGroupCd2);

             baseDomManager.insert(aT_KadouTimeGroup2);

         }

         BizDate pKadouTimeSiteiYmd1 = BizDate.valueOf("20150309");
         BizDate pKadouTimeSiteiYmd2 = BizDate.valueOf("20150409");
         BizDate pKadouTimeSiteiYmd3 = BizDate.valueOf("20150509");
         BizDate pKadouTimeSiteiYmd4 = BizDate.valueOf("20150609");

         AT_TokuteibiKadouTime aT_TokuteibiKadouTime1 = aT_KadouTimeGroup1.getTokuteibiKadouTime(pKadouTimeSiteiYmd1);
         if ( null == aT_TokuteibiKadouTime1 ) {

             aT_TokuteibiKadouTime1 = aT_KadouTimeGroup1.createTokuteibiKadouTime();
             aT_TokuteibiKadouTime1.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd1);

         }

         baseDomManager.update(aT_KadouTimeGroup1);

         AT_TokuteibiKadouTime aT_TokuteibiKadouTime2 = aT_KadouTimeGroup2.getTokuteibiKadouTime(pKadouTimeSiteiYmd2);
         if ( null == aT_TokuteibiKadouTime2 ) {

             aT_TokuteibiKadouTime2 = aT_KadouTimeGroup2.createTokuteibiKadouTime();
             aT_TokuteibiKadouTime2.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd2);

         }

         AT_TokuteibiKadouTime aT_TokuteibiKadouTime3 = aT_KadouTimeGroup2.getTokuteibiKadouTime(pKadouTimeSiteiYmd3);
         if ( null == aT_TokuteibiKadouTime3 ) {

             aT_TokuteibiKadouTime3 = aT_KadouTimeGroup2.createTokuteibiKadouTime();
             aT_TokuteibiKadouTime3.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd3);

         }

         AT_TokuteibiKadouTime aT_TokuteibiKadouTime4 = aT_KadouTimeGroup2.getTokuteibiKadouTime(pKadouTimeSiteiYmd4);
         if ( null == aT_TokuteibiKadouTime4 ) {

             aT_TokuteibiKadouTime4 = aT_KadouTimeGroup2.createTokuteibiKadouTime();
             aT_TokuteibiKadouTime4.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd4);

         }

         baseDomManager.update(aT_KadouTimeGroup2);

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pKadouTimeGroupCd1 = "KGC0000001";
         String pKadouTimeGroupCd2 = "KGC0000002";

         AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
         if ( null != aT_KadouTimeGroup1 ) {

             aT_KadouTimeGroup1.getTokuteibiKadouTimes().removeAll(aT_KadouTimeGroup1.getTokuteibiKadouTimes());

             baseDomManager.update(aT_KadouTimeGroup1);
             baseDomManager.delete(aT_KadouTimeGroup1);
         }

         AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
         if ( null != aT_KadouTimeGroup2 ) {

             aT_KadouTimeGroup2.getTokuteibiKadouTimes().removeAll(aT_KadouTimeGroup2.getTokuteibiKadouTimes());

             baseDomManager.update(aT_KadouTimeGroup2);
             baseDomManager.delete(aT_KadouTimeGroup2);
         }

     }

     @Test
     public void test001(){
         String pKadouTimeGroupCd = "KGC0000099";
         long count = baseDomManager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

         assertEquals(0, count);

     }

     @Test
     public void test002(){
         String pKadouTimeGroupCd = "KGC0000001";
         long count = baseDomManager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

         assertEquals(1, count);


     }

     @Test
     public void test003(){
         String pKadouTimeGroupCd = "KGC0000002";
         long count = baseDomManager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

         assertEquals(3, count);


     }

     @Test
     public void test004(){
         String pKadouTimeGroupCd = "";
         long count = baseDomManager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

         assertEquals(0, count);


     }

     @Test
     public void test005(){
         String pKadouTimeGroupCd = null;
         long count = baseDomManager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);

         assertEquals(0, count);

     }
 }
