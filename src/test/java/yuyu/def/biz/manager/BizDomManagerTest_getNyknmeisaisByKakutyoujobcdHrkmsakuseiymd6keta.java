package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入出金明細テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta {

    @Inject
    BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_HRKMSAKUSEIYMD6KETA_01 = "201507";
    static String P_HRKMSAKUSEIYMD6KETA_02 = "201508";
    static String P_HRKMSAKUSEIYMD6KETA_03 = "201509";
    static String P_HRKMSAKUSEIYMD6KETA_04 = "201510";
    static String P_HRKMBANKCD_01 = "1111";
    static String P_HRKMBANKCD_02 = "2222";
    static String P_HRKMBANKCD_03 = "3333";
    static String P_HRKMBANKCD_04 = "4444";
    static String P_HRKMBANKCD_05 = "5555";
    static String P_HRKMSHITENCD_01 = "111";
    static String P_HRKMSHITENCD_02 = "222";
    static String P_HRKMSHITENCD_03 = "333";
    static String P_HRKMSHITENCD_04 = "444";
    static String P_HRKMSHITENCD_05 = "555";
    static String P_HRKMRENNO8_01 = "11111111";
    static String P_HRKMRENNO8_02= "22222222";
    static String P_HRKMRENNO8_03= "33333333";
    static String P_HRKMRENNO8_04= "44444444";
    static String P_HRKMRENNO8_05= "55555555";
    static String P_HRKMSYOUKAINO_01 = "11111111";
    static String P_HRKMSYOUKAINO_02 = "22222222";
    static String P_HRKMSYOUKAINO_03 = "33333333";
    static String P_HRKMSYOUKAINO_04 = "44444444";
    static String P_HRKMSYOUKAINO_05 = "55555555";

    private static String P_JOB_CD_02 = "RGAK";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_Nyknmeisai> beans =
            bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_KAKUTYOUJOBCD_01, P_HRKMSAKUSEIYMD6KETA_01)) {

            int count = 0;
            for (BT_Nyknmeisai nyknmeisai : beans) {
                count++;
            }
            Assert.assertEquals(0, count);
        }

        BT_Nyknmeisai bT_Nyknmeisai1 = new BT_Nyknmeisai();
        bT_Nyknmeisai1.setHrkmyokinkbn("1");
        bT_Nyknmeisai1.setHrkmkouzano("2");
        bT_Nyknmeisai1.setHrkmsakuseiymd6keta(P_HRKMSAKUSEIYMD6KETA_01);
        bT_Nyknmeisai1.setHrkmbankcd(P_HRKMBANKCD_01);
        bT_Nyknmeisai1.setHrkmshitencd(P_HRKMSHITENCD_01);
        bT_Nyknmeisai1.setHrkmrenno8(P_HRKMRENNO8_01);
        bT_Nyknmeisai1.setHrkmsyoukaino(P_HRKMSYOUKAINO_01);
        bizDomManager.insert(bT_Nyknmeisai1);

        BT_Nyknmeisai bT_Nyknmeisai2 = new BT_Nyknmeisai();
        bT_Nyknmeisai2.setHrkmyokinkbn("1");
        bT_Nyknmeisai2.setHrkmkouzano("2");
        bT_Nyknmeisai2.setHrkmsakuseiymd6keta(P_HRKMSAKUSEIYMD6KETA_02);
        bT_Nyknmeisai2.setHrkmbankcd(P_HRKMBANKCD_02);
        bT_Nyknmeisai2.setHrkmshitencd(P_HRKMSHITENCD_02);
        bT_Nyknmeisai2.setHrkmrenno8(P_HRKMRENNO8_02);
        bT_Nyknmeisai2.setHrkmsyoukaino(P_HRKMSYOUKAINO_02);
        bizDomManager.insert(bT_Nyknmeisai2);

        BT_Nyknmeisai bT_Nyknmeisai3 = new BT_Nyknmeisai();
        bT_Nyknmeisai3.setHrkmyokinkbn("1");
        bT_Nyknmeisai3.setHrkmkouzano("2");
        bT_Nyknmeisai3.setHrkmsakuseiymd6keta(P_HRKMSAKUSEIYMD6KETA_02);
        bT_Nyknmeisai3.setHrkmbankcd(P_HRKMBANKCD_03);
        bT_Nyknmeisai3.setHrkmshitencd(P_HRKMSHITENCD_03);
        bT_Nyknmeisai3.setHrkmrenno8(P_HRKMRENNO8_03);
        bT_Nyknmeisai3.setHrkmsyoukaino(P_HRKMSYOUKAINO_03);
        bizDomManager.insert(bT_Nyknmeisai3);

        BT_Nyknmeisai bT_Nyknmeisai4 = new BT_Nyknmeisai();
        bT_Nyknmeisai4.setHrkmyokinkbn("1");
        bT_Nyknmeisai4.setHrkmkouzano("2");
        bT_Nyknmeisai4.setHrkmsakuseiymd6keta(P_HRKMSAKUSEIYMD6KETA_02);
        bT_Nyknmeisai4.setHrkmbankcd(P_HRKMBANKCD_04);
        bT_Nyknmeisai4.setHrkmshitencd(P_HRKMSHITENCD_04);
        bT_Nyknmeisai4.setHrkmrenno8(P_HRKMRENNO8_04);
        bT_Nyknmeisai4.setHrkmsyoukaino(P_HRKMSYOUKAINO_04);
        bizDomManager.insert(bT_Nyknmeisai4);

        BT_Nyknmeisai bT_Nyknmeisai5 = new BT_Nyknmeisai();
        bT_Nyknmeisai5.setHrkmyokinkbn("1");
        bT_Nyknmeisai5.setHrkmkouzano("2");
        bT_Nyknmeisai5.setHrkmsakuseiymd6keta(P_HRKMSAKUSEIYMD6KETA_03);
        bT_Nyknmeisai5.setHrkmbankcd(P_HRKMBANKCD_05);
        bT_Nyknmeisai5.setHrkmshitencd(P_HRKMSHITENCD_05);
        bT_Nyknmeisai5.setHrkmrenno8(P_HRKMRENNO8_05);
        bT_Nyknmeisai5.setHrkmsyoukaino(P_HRKMSYOUKAINO_05);
        bizDomManager.insert(bT_Nyknmeisai5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllNyknmeisai());


        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_Nyknmeisai> beans = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_KAKUTYOUJOBCD_01,
            P_HRKMSAKUSEIYMD6KETA_04)) {

            int count = 0;
            for (BT_Nyknmeisai nyknmeisai : beans) {
                count++;
            }
            Assert.assertEquals(0, count);
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_Nyknmeisai> beans = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_KAKUTYOUJOBCD_01,
            P_HRKMSAKUSEIYMD6KETA_01))
            {

            int iCount = 0;
            Iterator<BT_Nyknmeisai> iter = beans.iterator();
            BT_Nyknmeisai nyknmeisai = null;
            while (iter.hasNext()) {

                nyknmeisai = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(P_HRKMSAKUSEIYMD6KETA_01, nyknmeisai.getHrkmsakuseiymd6keta());
                    Assert.assertEquals(P_HRKMBANKCD_01, nyknmeisai.getHrkmbankcd());
                    Assert.assertEquals(P_HRKMSHITENCD_01, nyknmeisai.getHrkmshitencd());
                    Assert.assertEquals(P_HRKMSYOUKAINO_01, nyknmeisai.getHrkmsyoukaino());

                    continue;
                }
            }

            Assert.assertEquals(1, iCount);
            }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_Nyknmeisai> beans = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_KAKUTYOUJOBCD_01,
            P_HRKMSAKUSEIYMD6KETA_02))
            {
            Map<String,String> map = new HashMap<String,String>();
            map.put($(P_HRKMSAKUSEIYMD6KETA_02,P_HRKMBANKCD_02,P_HRKMSHITENCD_02,P_HRKMSYOUKAINO_02),"1");
            map.put($(P_HRKMSAKUSEIYMD6KETA_02,P_HRKMBANKCD_03,P_HRKMSHITENCD_03,P_HRKMSYOUKAINO_03),"1");
            map.put($(P_HRKMSAKUSEIYMD6KETA_02,P_HRKMBANKCD_04,P_HRKMSHITENCD_04,P_HRKMSYOUKAINO_04),"1");


            int iCount = 0;
            Iterator<BT_Nyknmeisai> iter = beans.iterator();
            BT_Nyknmeisai nyknmeisai = null;
            while (iter.hasNext()) {

                nyknmeisai = iter.next();
                iCount++;

                if (1 == iCount) {

                    assertTrue(map.containsKey($(nyknmeisai.getHrkmsakuseiymd6keta(),nyknmeisai.getHrkmbankcd(),nyknmeisai.getHrkmshitencd(),nyknmeisai.getHrkmsyoukaino())));
                    map.remove($(nyknmeisai.getHrkmsakuseiymd6keta(),nyknmeisai.getHrkmbankcd(),nyknmeisai.getHrkmshitencd(),nyknmeisai.getHrkmsyoukaino()));

                    continue;
                }

                if (2 == iCount) {

                    assertTrue(map.containsKey($(nyknmeisai.getHrkmsakuseiymd6keta(),nyknmeisai.getHrkmbankcd(),nyknmeisai.getHrkmshitencd(),nyknmeisai.getHrkmsyoukaino())));
                    map.remove($(nyknmeisai.getHrkmsakuseiymd6keta(),nyknmeisai.getHrkmbankcd(),nyknmeisai.getHrkmshitencd(),nyknmeisai.getHrkmsyoukaino()));

                    continue;
                }

                if (3 == iCount) {

                    assertTrue(map.containsKey($(nyknmeisai.getHrkmsakuseiymd6keta(),nyknmeisai.getHrkmbankcd(),nyknmeisai.getHrkmshitencd(),nyknmeisai.getHrkmsyoukaino())));
                    map.remove($(nyknmeisai.getHrkmsakuseiymd6keta(),nyknmeisai.getHrkmbankcd(),nyknmeisai.getHrkmshitencd(),nyknmeisai.getHrkmsyoukaino()));

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
            }
    }

    @Test
    @TestOrder(40)
    public void blank() {

        try (ExDBResults<BT_Nyknmeisai> nyknmeisaiLst =
            bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_KAKUTYOUJOBCD_01, "")) {

            Assert.assertFalse(nyknmeisaiLst.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter11() {

        int iCount = 0;
        try(ExDBResults<BT_Nyknmeisai> nyknmeisaiLst = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_JOB_CD_02,
            P_HRKMSAKUSEIYMD6KETA_02)){
            for(BT_Nyknmeisai nyknmeisai : nyknmeisaiLst){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(62)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Bz101");
        filter.setRecoveryfilternm("入出金明細フィルタ");
        filter.setRecoveryfilterkeykmid1("hrkmsakuseiymd6keta");
        filter.setRecoveryfilterkeykmid2("hrkmbankcd");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterid("Bz101");
        key3.setRecoveryfilterkey1("201508");
        key3.setRecoveryfilterkey2("2222");
        key3.setTableid("BT_Nyknmeisai");
        bizDomManager.insert(key3);
    }

    @Test
    @TestOrder(70)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<BT_Nyknmeisai> nyknmeisaiLst = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_JOB_CD_02,
            P_HRKMSAKUSEIYMD6KETA_02)){
            for(BT_Nyknmeisai nyknmeisai : nyknmeisaiLst){
                assertNotEquals(nyknmeisai.getHrkmbankcd(), "2222");
                assertNotEquals(nyknmeisai.getHrkmshitencd(), "222");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(71)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterid("Bz101");
        key1.setRecoveryfilterkey1("201508");
        key1.setRecoveryfilterkey2("3333");
        key1.setTableid("BT_Nyknmeisai");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(80)
    public void testSkippedFilter3(){

        int iCount = 0;
        try(ExDBResults<BT_Nyknmeisai> nyknmeisaiLst = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(P_JOB_CD_02,
            P_HRKMSAKUSEIYMD6KETA_02)){
            for(BT_Nyknmeisai nyknmeisai : nyknmeisaiLst){
                assertNotEquals(nyknmeisai.getHrkmbankcd(), "2222");
                assertNotEquals(nyknmeisai.getHrkmshitencd(), "222");
                assertNotEquals(nyknmeisai.getHrkmbankcd(), "3333");
                assertNotEquals(nyknmeisai.getHrkmshitencd(), "333");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }

}
