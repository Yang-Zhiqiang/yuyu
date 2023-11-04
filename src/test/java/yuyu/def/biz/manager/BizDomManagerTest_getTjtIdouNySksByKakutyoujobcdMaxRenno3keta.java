package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;


import java.util.HashMap;
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
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容新契約テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNySksByKakutyoujobcdMaxRenno3keta {

    @Inject
    BizDomManager bizDomManager;

    private static String P_JOB_CD_02 = "RG9H";
    private static String P_FILTER_ID = "Sk001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<BT_TjtIdouNySk> beans = bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta("JCD01");

        int iCount = 0;
        for (BT_TjtIdouNySk tjtIdouNySk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        BT_TjtIdouNySk bT_TjtIdouNySk1 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk1.setMosno("791112220");
        bT_TjtIdouNySk1.setRenno3keta(115);
        bizDomManager.insert(bT_TjtIdouNySk1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal10() {


        ExDBResults<BT_TjtIdouNySk> beans = bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta("JCD01");

        int iCount = 0;
        for (BT_TjtIdouNySk tjtIdouNySk : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("791112220", tjtIdouNySk.getMosno());
                Assert.assertEquals(115, tjtIdouNySk.getRenno3keta().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {


        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());

        BT_TjtIdouNySk bT_TjtIdouNySk2 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk2.setMosno("791112238");
        bT_TjtIdouNySk2.setRenno3keta(113);
        bizDomManager.insert(bT_TjtIdouNySk2);

        BT_TjtIdouNySk bT_TjtIdouNySk3 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk3.setMosno("791112238");
        bT_TjtIdouNySk3.setRenno3keta(114);
        bizDomManager.insert(bT_TjtIdouNySk3);

        BT_TjtIdouNySk bT_TjtIdouNySk4 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk4.setMosno("791112238");
        bT_TjtIdouNySk4.setRenno3keta(115);
        bizDomManager.insert(bT_TjtIdouNySk4);

        BT_TjtIdouNySk bT_TjtIdouNySk5 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk5.setMosno("791112246");
        bT_TjtIdouNySk5.setRenno3keta(116);
        bizDomManager.insert(bT_TjtIdouNySk5);

        BT_TjtIdouNySk bT_TjtIdouNySk6 = new BT_TjtIdouNySk();
        bT_TjtIdouNySk6.setMosno("791112253");
        bT_TjtIdouNySk6.setRenno3keta(114);
        bizDomManager.insert(bT_TjtIdouNySk6);


    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<BT_TjtIdouNySk> beans = bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta("JCD01");

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("791112238",115), "1");
        map.put($("791112246",116), "1");
        map.put($("791112253",114), "1");

        for (BT_TjtIdouNySk tjtIdouNySk : beans) {
            iCount++;
            map.remove($(tjtIdouNySk.getMosno(),tjtIdouNySk.getRenno3keta().intValue()));
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    public void testSkippedFilter11() {

        int iCount = 0;
        try(ExDBResults<BT_TjtIdouNySk> beans =
            bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(
                P_JOB_CD_02);){
            for(BT_TjtIdouNySk tjtIdouNySk : beans){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("mosno");
        filter.setRecoveryfilternm("申込番号フィルタ");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("791112253");
        key3.setTableid("BT_TjtIdouNySk");
        bizDomManager.insert(key3);
    }
    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<BT_TjtIdouNySk> beans =
            bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(
                P_JOB_CD_02);){
            for(BT_TjtIdouNySk tjtIdouNySk : beans){
                assertNotEquals(tjtIdouNySk.getMosno(), "791112253");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid(P_FILTER_ID);
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterkey1("791112246");
        key1.setTableid("BT_TjtIdouNySk");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        int iCount = 0;
        try(ExDBResults<BT_TjtIdouNySk> beans =
            bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(
                P_JOB_CD_02);){
            for(BT_TjtIdouNySk tjtIdouNySk : beans){
                assertNotEquals(tjtIdouNySk.getMosno(), "791112246");
                assertNotEquals(tjtIdouNySk.getMosno(), "791112253");


                iCount++;
            }
            assertEquals(1, iCount);
        }
    }

}