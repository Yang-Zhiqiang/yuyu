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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
 public class BaseDomManagerTest_getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount extends AbstractTest {

     @Inject
     BaseDomManager baseDomManager;

     @BeforeClass
     @Transactional
     public static void insertTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.BLNK;
         C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.USERITIRANHYOU;

         AM_SyoruiZokusei aM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCd1);
         if ( null == aM_SyoruiZokusei1 ){

             aM_SyoruiZokusei1 = new AM_SyoruiZokusei();
             aM_SyoruiZokusei1.setSyoruiCd(pSyoruiCd1);

             baseDomManager.insert(aM_SyoruiZokusei1);
         }

         AM_SyoruiZokusei aM_SyoruiZokusei2 = baseDomManager.getSyoruiZokusei(pSyoruiCd2);
         if ( null == aM_SyoruiZokusei2 ){

             aM_SyoruiZokusei2 = new AM_SyoruiZokusei();
             aM_SyoruiZokusei2.setSyoruiCd(pSyoruiCd2);

             baseDomManager.insert(aM_SyoruiZokusei2);
         }

         String pUniqueId1 = "UNI0000001";
         String pUniqueId2 = "UNI0000002";
         String pUniqueId3 = "UNI0000003";
         String pUniqueId4 = "UNI0000004";
         String pUniqueId5 = "UNI0000005";
         String pUniqueId6 = "UNI0000006";
         String pUniqueId7 = "UNI0000007";
         String pUniqueId8 = "UNI0000008";
         String pUniqueId9 = "UNI0000009";
         String pUniqueId10 = "UNI0000010";
         String pUniqueId11 = "UNI0000011";
         BizDate pSyoriYmd1 = BizDate.valueOf("20150309");
         BizDate pSyoriYmd2 = BizDate.valueOf("20150409");
         BizDate pSyoriYmd3 = BizDate.valueOf("20150509");
         int pOutCount1 = 0;
         int pOutCount2 = 2;
         int pOutCount3 = 3;
         int pOutCount4 = 4;
         int pOutCount5 = 5;
         int pOutCount6 = 6;
         int pOutCount7 = 7;
         int pOutCount8 = 8;

         AT_TyouhyouKensaku aT_TyouhyouKensaku1 = baseDomManager.getTyouhyouKensaku(pUniqueId1);
         if ( null == aT_TyouhyouKensaku1 ) {

             aT_TyouhyouKensaku1 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku1.setUniqueId(pUniqueId1);
             aT_TyouhyouKensaku1.setSyoruiCd(pSyoruiCd1);
             aT_TyouhyouKensaku1.setSyoriYmd(pSyoriYmd1);
             aT_TyouhyouKensaku1.setOutCount(pOutCount1);

             baseDomManager.insert(aT_TyouhyouKensaku1);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku2 = baseDomManager.getTyouhyouKensaku(pUniqueId2);
         if ( null == aT_TyouhyouKensaku2 ) {

             aT_TyouhyouKensaku2 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku2.setUniqueId(pUniqueId2);
             aT_TyouhyouKensaku2.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku2.setSyoriYmd(pSyoriYmd2);
             aT_TyouhyouKensaku2.setOutCount(pOutCount1);

             baseDomManager.insert(aT_TyouhyouKensaku2);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku3 = baseDomManager.getTyouhyouKensaku(pUniqueId3);
         if ( null == aT_TyouhyouKensaku3 ) {

             aT_TyouhyouKensaku3 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku3.setUniqueId(pUniqueId3);
             aT_TyouhyouKensaku3.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku3.setSyoriYmd(pSyoriYmd2);
             aT_TyouhyouKensaku3.setOutCount(pOutCount1);

             baseDomManager.insert(aT_TyouhyouKensaku3);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku4 = baseDomManager.getTyouhyouKensaku(pUniqueId4);
         if ( null == aT_TyouhyouKensaku4 ) {

             aT_TyouhyouKensaku4 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku4.setUniqueId(pUniqueId4);
             aT_TyouhyouKensaku4.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku4.setSyoriYmd(pSyoriYmd2);
             aT_TyouhyouKensaku4.setOutCount(pOutCount1);

             baseDomManager.insert(aT_TyouhyouKensaku4);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku5 = baseDomManager.getTyouhyouKensaku(pUniqueId5);
         if ( null == aT_TyouhyouKensaku5 ) {

             aT_TyouhyouKensaku5 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku5.setUniqueId(pUniqueId5);
             aT_TyouhyouKensaku5.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku5.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku5.setOutCount(pOutCount2);

             baseDomManager.insert(aT_TyouhyouKensaku5);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku6 = baseDomManager.getTyouhyouKensaku(pUniqueId6);
         if ( null == aT_TyouhyouKensaku6 ) {

             aT_TyouhyouKensaku6 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku6.setUniqueId(pUniqueId6);
             aT_TyouhyouKensaku6.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku6.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku6.setOutCount(pOutCount3);

             baseDomManager.insert(aT_TyouhyouKensaku6);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku7 = baseDomManager.getTyouhyouKensaku(pUniqueId7);
         if ( null == aT_TyouhyouKensaku7 ) {

             aT_TyouhyouKensaku7 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku7.setUniqueId(pUniqueId7);
             aT_TyouhyouKensaku7.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku7.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku7.setOutCount(pOutCount4);

             baseDomManager.insert(aT_TyouhyouKensaku7);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku8 = baseDomManager.getTyouhyouKensaku(pUniqueId8);
         if ( null == aT_TyouhyouKensaku8 ) {

             aT_TyouhyouKensaku8 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku8.setUniqueId(pUniqueId8);
             aT_TyouhyouKensaku8.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku8.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku8.setOutCount(pOutCount5);

             baseDomManager.insert(aT_TyouhyouKensaku8);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku9 = baseDomManager.getTyouhyouKensaku(pUniqueId9);
         if ( null == aT_TyouhyouKensaku9 ) {

             aT_TyouhyouKensaku9 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku9.setUniqueId(pUniqueId9);
             aT_TyouhyouKensaku9.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku9.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku9.setOutCount(pOutCount6);

             baseDomManager.insert(aT_TyouhyouKensaku9);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku10 = baseDomManager.getTyouhyouKensaku(pUniqueId10);
         if ( null == aT_TyouhyouKensaku10 ) {

             aT_TyouhyouKensaku10 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku10.setUniqueId(pUniqueId10);
             aT_TyouhyouKensaku10.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku10.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku10.setOutCount(pOutCount7);

             baseDomManager.insert(aT_TyouhyouKensaku10);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku11 = baseDomManager.getTyouhyouKensaku(pUniqueId11);
         if ( null == aT_TyouhyouKensaku11 ) {

             aT_TyouhyouKensaku11 = new AT_TyouhyouKensaku();
             aT_TyouhyouKensaku11.setUniqueId(pUniqueId11);
             aT_TyouhyouKensaku11.setSyoruiCd(pSyoruiCd2);
             aT_TyouhyouKensaku11.setSyoriYmd(pSyoriYmd3);
             aT_TyouhyouKensaku11.setOutCount(pOutCount8);

             baseDomManager.insert(aT_TyouhyouKensaku11);
         }

     }

     @AfterClass
     @Transactional
     public static void deleteTestData() {
         BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

         String pUniqueId1 = "UNI0000001";
         String pUniqueId2 = "UNI0000002";
         String pUniqueId3 = "UNI0000003";
         String pUniqueId4 = "UNI0000004";
         String pUniqueId5 = "UNI0000005";
         String pUniqueId6 = "UNI0000006";
         String pUniqueId7 = "UNI0000007";
         String pUniqueId8 = "UNI0000008";
         String pUniqueId9 = "UNI0000009";
         String pUniqueId10 = "UNI0000010";
         String pUniqueId11 = "UNI0000011";

         AT_TyouhyouKensaku aT_TyouhyouKensaku1 = baseDomManager.getTyouhyouKensaku(pUniqueId1);
         if ( null != aT_TyouhyouKensaku1 ) {

             baseDomManager.delete(aT_TyouhyouKensaku1);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku2 = baseDomManager.getTyouhyouKensaku(pUniqueId2);
         if ( null != aT_TyouhyouKensaku2 ) {

             baseDomManager.delete(aT_TyouhyouKensaku2);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku3 = baseDomManager.getTyouhyouKensaku(pUniqueId3);
         if ( null != aT_TyouhyouKensaku3 ) {

             baseDomManager.delete(aT_TyouhyouKensaku3);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku4 = baseDomManager.getTyouhyouKensaku(pUniqueId4);
         if ( null != aT_TyouhyouKensaku4 ) {

             baseDomManager.delete(aT_TyouhyouKensaku4);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku5 = baseDomManager.getTyouhyouKensaku(pUniqueId5);
         if ( null != aT_TyouhyouKensaku5 ) {

             baseDomManager.delete(aT_TyouhyouKensaku5);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku6 = baseDomManager.getTyouhyouKensaku(pUniqueId6);
         if ( null != aT_TyouhyouKensaku6 ) {

             baseDomManager.delete(aT_TyouhyouKensaku6);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku7 = baseDomManager.getTyouhyouKensaku(pUniqueId7);
         if ( null != aT_TyouhyouKensaku7 ) {

             baseDomManager.delete(aT_TyouhyouKensaku7);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku8 = baseDomManager.getTyouhyouKensaku(pUniqueId8);
         if ( null != aT_TyouhyouKensaku8 ) {

             baseDomManager.delete(aT_TyouhyouKensaku8);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku9 = baseDomManager.getTyouhyouKensaku(pUniqueId9);
         if ( null != aT_TyouhyouKensaku9 ) {

             baseDomManager.delete(aT_TyouhyouKensaku9);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku10 = baseDomManager.getTyouhyouKensaku(pUniqueId10);
         if ( null != aT_TyouhyouKensaku10 ) {

             baseDomManager.delete(aT_TyouhyouKensaku10);
         }

         AT_TyouhyouKensaku aT_TyouhyouKensaku11 = baseDomManager.getTyouhyouKensaku(pUniqueId11);
         if ( null != aT_TyouhyouKensaku11 ) {

             baseDomManager.delete(aT_TyouhyouKensaku11);
         }

         C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.BLNK;
         C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.USERITIRANHYOU;
         AM_SyoruiZokusei aM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCd1);
         if ( null != aM_SyoruiZokusei1 ) {

             baseDomManager.delete(aM_SyoruiZokusei1);
         }

         AM_SyoruiZokusei aM_SyoruiZokusei2 = baseDomManager.getSyoruiZokusei(pSyoruiCd2);
         if ( null != aM_SyoruiZokusei2 ) {

             baseDomManager.delete(aM_SyoruiZokusei2);
         }

     }

     @Test
     public void test001(){
         C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;
         BizDate pSyoriYmd = BizDate.valueOf("20151231");
         String pOutCount = "0";
         long count = baseDomManager.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

         assertEquals(0, count);

     }

     @Test
     public void test002(){
         C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;
         BizDate pSyoriYmd = BizDate.valueOf("20150309");
         String pOutCount = "0";
         long count = baseDomManager.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

         assertEquals(1, count);


     }

     @Test
     public void test003(){
         C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
         BizDate pSyoriYmd = BizDate.valueOf("20150409");
         String pOutCount = "0";
         long count = baseDomManager.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

         assertEquals(3, count);


     }

     @Test
     public void test004(){
         C_SyoruiCdKbn pSyoruiCd = null;
         BizDate pSyoriYmd = null;
         String pOutCount = null;
         long count = baseDomManager.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

         assertEquals(0, count);

     }


     @Test
     public void test005(){
         C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.USERITIRANHYOU;
         BizDate pSyoriYmd = BizDate.valueOf("20150509");
         String pOutCount = "3";
         long count = baseDomManager.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);

         assertEquals(6, count);

     }
 }
