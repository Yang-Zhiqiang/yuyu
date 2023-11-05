package yuyu.def.siharai.manager;

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
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 支払ＦＢ送金データ取込<br />
 * 支払ＦＢ送金データテーブルエンティティリスト（大量）取得(拡張ジョブコード、処理年月日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiFBSoukinDatasByKakutyoujobcdSyoriYmd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_FBSOUKINDATASIKIBETUKEY_01 = "11111111111111111111";
    static String P_FBSOUKINDATASIKIBETUKEY_02 = "22222222222222222222";
    static String P_FBSOUKINDATASIKIBETUKEY_03 = "33333333333333333333";
    static String P_FBSOUKINDATASIKIBETUKEY_04 = "44444444444444444444";
    static String P_FBSOUKINDATASIKIBETUKEY_05 = "55555555555555555555";
    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGDC";
    static String P_FILTER_ID = "Bz107";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160301");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160302");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160303");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160304");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiFBSoukinData> beans =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SiFBSoukinData jT_SiFBSoukinData1 = new JT_SiFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_01);
        jT_SiFBSoukinData1.setSyoriYmd(P_SYORIYMD_01);
        siharaiDomManager.insert(jT_SiFBSoukinData1);

        JT_SiFBSoukinData jT_SiFBSoukinData2 = new JT_SiFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_02);
        jT_SiFBSoukinData2.setSyoriYmd(P_SYORIYMD_02);
        siharaiDomManager.insert(jT_SiFBSoukinData2);

        JT_SiFBSoukinData jT_SiFBSoukinData3 = new JT_SiFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_03);
        jT_SiFBSoukinData3.setSyoriYmd(P_SYORIYMD_02);
        siharaiDomManager.insert(jT_SiFBSoukinData3);

        JT_SiFBSoukinData jT_SiFBSoukinData4 = new JT_SiFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_04);
        jT_SiFBSoukinData4.setSyoriYmd(P_SYORIYMD_02);
        siharaiDomManager.insert(jT_SiFBSoukinData4);

        JT_SiFBSoukinData jT_SiFBSoukinData5 = new JT_SiFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_05);
        jT_SiFBSoukinData5.setSyoriYmd(P_SYORIYMD_03);
        siharaiDomManager.insert(jT_SiFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SiFBSoukinData> beans =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SiFBSoukinData> beans =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<JT_SiFBSoukinData> iter = beans.iterator();
            JT_SiFBSoukinData sifbsoukindata = null;
            while (iter.hasNext()) {

                sifbsoukindata = iter.next();
                iCount++;

                Assert.assertEquals(P_FBSOUKINDATASIKIBETUKEY_01, sifbsoukindata.getFbsoukindatasikibetukey());
                Assert.assertEquals(P_SYORIYMD_01, sifbsoukindata.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_FBSOUKINDATASIKIBETUKEY_02,P_SYORIYMD_02), "1");
        datamap.put($(P_FBSOUKINDATASIKIBETUKEY_03,P_SYORIYMD_02), "2");
        datamap.put($(P_FBSOUKINDATASIKIBETUKEY_04,P_SYORIYMD_02), "2");

        try (ExDBResults<JT_SiFBSoukinData> beans =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)) {

            Iterator<JT_SiFBSoukinData> iter = beans.iterator();
            JT_SiFBSoukinData sifbsoukindata = null;
            while (iter.hasNext()) {

                sifbsoukindata = iter.next();

                datamap.remove($(
                    sifbsoukindata.getFbsoukindatasikibetukey(),
                    sifbsoukindata.getSyoriYmd()));
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

        try(ExDBResults<JT_SiFBSoukinData> exDBResBean =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            Iterator<JT_SiFBSoukinData> iter = exDBResBean.iterator();
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
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("ＦＢ送金データフィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");
        siharaiDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("JT_SiFBSoukinData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_02);
        siharaiDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<JT_SiFBSoukinData> exDBResBean =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (JT_SiFBSoukinData entity : exDBResBean) {

                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_02);

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
        bT_SkipKey2.setTableid("JT_SiFBSoukinData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_03);
        siharaiDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<JT_SiFBSoukinData> exDBResBean =
            siharaiDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (JT_SiFBSoukinData entity : exDBResBean) {

                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_02);
                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_03);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
