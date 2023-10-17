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
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 当日異動内容契約保全テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta {

    @Inject
    BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    private static String P_JOB_CD_02 = "RG9F";
    private static String P_FILTER_ID = "Bz001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta("JCD01");

        int iCount = 0;
        for (BT_TjtIdouNyKh tjtIdouNyKk : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        BT_TjtIdouNyKh bT_TjtIdouNyKk1 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk1.setSyono("11807111118");
        bT_TjtIdouNyKk1.setRenno3keta(115);
        bizDomManager.insert(bT_TjtIdouNyKk1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(20)
    public void normal10() {


        ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta("JCD01");

        int iCount = 0;
        for (BT_TjtIdouNyKh tjtIdouNyKk : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("11807111118", tjtIdouNyKk.getSyono());
                Assert.assertEquals(115, tjtIdouNyKk.getRenno3keta().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());

        BT_TjtIdouNyKh bT_TjtIdouNyKk2 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk2.setSyono("11807111130");
        bT_TjtIdouNyKk2.setRenno3keta(113);
        bizDomManager.insert(bT_TjtIdouNyKk2);

        BT_TjtIdouNyKh bT_TjtIdouNyKk3 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk3.setSyono("11807111130");
        bT_TjtIdouNyKk3.setRenno3keta(114);
        bizDomManager.insert(bT_TjtIdouNyKk3);

        BT_TjtIdouNyKh bT_TjtIdouNyKk4 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk4.setSyono("11807111130");
        bT_TjtIdouNyKk4.setRenno3keta(115);
        bizDomManager.insert(bT_TjtIdouNyKk4);

        BT_TjtIdouNyKh bT_TjtIdouNyKk5 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk5.setSyono("11807111141");
        bT_TjtIdouNyKk5.setRenno3keta(116);
        bizDomManager.insert(bT_TjtIdouNyKk5);

        BT_TjtIdouNyKh bT_TjtIdouNyKk6 = new BT_TjtIdouNyKh();
        bT_TjtIdouNyKk6.setSyono("11807111152");
        bT_TjtIdouNyKk6.setRenno3keta(114);
        bizDomManager.insert(bT_TjtIdouNyKk6);


    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta("JCD01");

        int iCount = 0;
        Map<String,String> map = new HashMap<String,String>();
        map.put($("11807111130",115), "1");
        map.put($("11807111141",116), "1");
        map.put($("11807111152",114), "1");

        for (BT_TjtIdouNyKh tjtIdouNyKk : beans) {
            iCount++;

            map.remove($(tjtIdouNyKk.getSyono(),tjtIdouNyKk.getRenno3keta().intValue()));
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
        try(ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(P_JOB_CD_02);){
            for(BT_TjtIdouNyKh bT_TjtIdouNyKh : beans){

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
        filter.setRecoveryfilterkeykmid1("syono");
        filter.setRecoveryfilternm("証券番号フィルタ");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("11807111152");
        key3.setTableid("BT_TjtIdouNyKh");
        bizDomManager.insert(key3);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        int iCount = 0;
        try(ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(P_JOB_CD_02);){
            for(BT_TjtIdouNyKh bT_TjtIdouNyKh : beans){
                assertNotEquals(bT_TjtIdouNyKh.getSyono(), "11807111152");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {
        BT_SkipKey key2 = new BT_SkipKey("A02");
        key2.setRecoveryfilterid(P_FILTER_ID);
        key2.setKakutyoujobcd(P_JOB_CD_02);
        key2.setRecoveryfilterkey1("11807111141");
        key2.setTableid("BT_TjtIdouNyKh");
        bizDomManager.insert(key2);

    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        int iCount = 0;
        try(ExDBResults<BT_TjtIdouNyKh> beans = bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(P_JOB_CD_02);){
            for(BT_TjtIdouNyKh bT_TjtIdouNyKh : beans){
                assertNotEquals(bT_TjtIdouNyKh.getSyono(), "11807111152");
                assertNotEquals(bT_TjtIdouNyKh.getSyono(), "11807111141");

                iCount++;
            }
            assertEquals(1, iCount);

        }
    }
}

