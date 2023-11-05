package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

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
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 外貨ＦＢ送金データ取込（契約保全）<br />
 * 契約保全外貨ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGEB";
    static String P_FBSOUKINDATASIKIBETUKEY_01 = "11807111299";
    static String P_FBSOUKINDATASIKIBETUKEY_02 = "11807111230";
    static String P_FBSOUKINDATASIKIBETUKEY_03 = "11807111231";
    static String P_FBSOUKINDATASIKIBETUKEY_04 = "11807111232";
    static String P_FBSOUKINDATASIKIBETUKEY_05 = "11807111233";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160325");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160326");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160327");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160328");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData1 = new IT_KhGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_01);
        iT_KhGaikaFBSoukinData1.setSyoriYmd(P_SYORIYMD_01);

        hozenDomManager.insert(iT_KhGaikaFBSoukinData1);

        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData2 = new IT_KhGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_02);
        iT_KhGaikaFBSoukinData2.setSyoriYmd(P_SYORIYMD_02);

        hozenDomManager.insert(iT_KhGaikaFBSoukinData2);

        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData3 = new IT_KhGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_03);
        iT_KhGaikaFBSoukinData3.setSyoriYmd(P_SYORIYMD_04);

        hozenDomManager.insert(iT_KhGaikaFBSoukinData3);

        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData4 = new IT_KhGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_04);
        iT_KhGaikaFBSoukinData4.setSyoriYmd(P_SYORIYMD_04);

        hozenDomManager.insert(iT_KhGaikaFBSoukinData4);

        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData5 = new IT_KhGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_05);
        iT_KhGaikaFBSoukinData5.setSyoriYmd(P_SYORIYMD_04);

        hozenDomManager.insert(iT_KhGaikaFBSoukinData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhGaikaFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_03)){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)){

            int iCount = 0;
            Iterator<IT_KhGaikaFBSoukinData> iter = exDBResults.iterator();
            IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                iT_KhGaikaFBSoukinData = iter.next();
                iCount++;

                Assert.assertEquals(P_FBSOUKINDATASIKIBETUKEY_01, iT_KhGaikaFBSoukinData.getFbsoukindatasikibetukey());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)){

            HashMap<String,String> datamap = new HashMap<String,String>();
            datamap.put($("11807111231"), "1");
            datamap.put($("11807111232"), "2");
            datamap.put($("11807111233"), "3");

            Iterator<IT_KhGaikaFBSoukinData> iter = exDBResults.iterator();
            IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                iT_KhGaikaFBSoukinData = iter.next();
                datamap.remove($(iT_KhGaikaFBSoukinData.getFbsoukindatasikibetukey()));

            }

            Assert.assertTrue(datamap.isEmpty());
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_04)){

            Iterator<IT_KhGaikaFBSoukinData> iter = exDBResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter("Bz107");
        bM_RecoveryFilter.setRecoveryfilternm("ＦＢ送金データフィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");
        hozenDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("IT_KhGaikaFBSoukinData");
        bT_SkipKey1.setRecoveryfilterid("Bz107");
        bT_SkipKey1.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_03);
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_04)){

            int iCount = 0;
            for (IT_KhGaikaFBSoukinData entity : exDBResults) {

                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_03);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("IT_KhGaikaFBSoukinData");
        bT_SkipKey2.setRecoveryfilterid("Bz107");
        bT_SkipKey2.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_04);
        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_04)){

            int iCount = 0;
            for (IT_KhGaikaFBSoukinData entity : exDBResults) {

                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_03);
                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_04);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
