package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IW_KhKaiyakuWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    private static String P_JOB_CD_02 = "RBI1";
    private static String P_FILTER_ID = "Bz003";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults =
            hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215))) {

            Assert.assertFalse(khKaiyakuWkesults.iterator().hasNext());
        }

        IW_KhKaiyakuWk khKaiyakuWk1 = new IW_KhKaiyakuWk("10000000001");
        khKaiyakuWk1.setSkssakuseiymd(BizDate.valueOf(20160215));

        hozenDomManager.insert(khKaiyakuWk1);

        IW_KhKaiyakuWk khKaiyakuWk2 = new IW_KhKaiyakuWk("10000000002");
        khKaiyakuWk2.setSkssakuseiymd(BizDate.valueOf(20160214));

        hozenDomManager.insert(khKaiyakuWk2);

        IW_KhKaiyakuWk khKaiyakuWk3 = new IW_KhKaiyakuWk("10000000003");
        khKaiyakuWk3.setSkssakuseiymd(BizDate.valueOf(20160220));

        hozenDomManager.insert(khKaiyakuWk3);

        IW_KhKaiyakuWk khKaiyakuWk4 = new IW_KhKaiyakuWk("10000000004");
        khKaiyakuWk4.setSkssakuseiymd(BizDate.valueOf(20160220));

        hozenDomManager.insert(khKaiyakuWk4);

        IW_KhKaiyakuWk khKaiyakuWk5 = new IW_KhKaiyakuWk("10000000005");
        khKaiyakuWk5.setSkssakuseiymd(BizDate.valueOf(20160220));

        hozenDomManager.insert(khKaiyakuWk5);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhKaiyakuWk());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults =
            hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160228))) {

            Assert.assertFalse(khKaiyakuWkesults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults = hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_KAKUTYOUJOBCD_01,
            BizDate.valueOf(20160215));

        int iCount = 0;
        for (IW_KhKaiyakuWk khKaiyakuWk : khKaiyakuWkesults) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("10000000001", khKaiyakuWk.getKouteikanriid());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000003"), "1");
        datamap.put($("10000000004"), "2");
        datamap.put($("10000000005"), "3");

        ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults = hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_KAKUTYOUJOBCD_01,
            BizDate.valueOf(20160220));

        for (IW_KhKaiyakuWk khKaiyakuWk : khKaiyakuWkesults) {
            datamap.remove($(khKaiyakuWk.getKouteikanriid()));
        }
        Assert.assertTrue(datamap.isEmpty());
    }


    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        int iCount = 0;
        try(ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults = hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_JOB_CD_02,
            BizDate.valueOf(20160220));){
            for(IW_KhKaiyakuWk khKaiyakuWk : khKaiyakuWkesults){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){

        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilternm("工程管理ＩＤフィルタ");
        filter.setRecoveryfilterkeykmid1("kouteikanriid");
        hozenDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("10000000003");
        key3.setTableid("IW_KhKaiyakuWk");
        hozenDomManager.insert(key3);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults = hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_JOB_CD_02,
            BizDate.valueOf(20160220));){
            for(IW_KhKaiyakuWk khKaiyakuWk : khKaiyakuWkesults){
                assertNotEquals(khKaiyakuWk.getKouteikanriid(), "10000000003");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid(P_FILTER_ID);
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterkey1("10000000004");
        key1.setTableid("IW_KhKaiyakuWk");
        hozenDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<IW_KhKaiyakuWk> khKaiyakuWkesults = hozenDomManager.getKhKaiyakuWksByKakutyoujobcdSkssakuseiymd(P_JOB_CD_02,
            BizDate.valueOf(20160220));){
            for(IW_KhKaiyakuWk khKaiyakuWk : khKaiyakuWkesults){
                assertNotEquals(khKaiyakuWk.getKouteikanriid(), "10000000003");
                assertNotEquals(khKaiyakuWk.getKouteikanriid(), "10000000004");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}

