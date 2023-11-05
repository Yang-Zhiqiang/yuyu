package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 外貨ＦＢ送金データ取込（新契約）<br />
 * 新契約外貨ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_FILTER_ID = "Bz107";
    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGEA";
    static String P_FBSOUKINDATASIKIBETUKEY_01 = "FBSK1111";
    static String P_FBSOUKINDATASIKIBETUKEY_02 = "FBSK2222";
    static String P_FBSOUKINDATASIKIBETUKEY_03 = "FBSK3333";
    static String P_FBSOUKINDATASIKIBETUKEY_04 = "FBSK4444";
    static String P_FBSOUKINDATASIKIBETUKEY_05 = "FBSK5555";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160301");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160302");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160303");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160304");
    static BizDate P_SYORIYMD_05 = BizDate.valueOf("20160305");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData1 = new HT_SkGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_01);
        hT_SkGaikaFBSoukinData1.setSyoriYmd(P_SYORIYMD_01);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData1);

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData2 = new HT_SkGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_02);
        hT_SkGaikaFBSoukinData2.setSyoriYmd(P_SYORIYMD_02);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData2);

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData3 = new HT_SkGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_03);
        hT_SkGaikaFBSoukinData3.setSyoriYmd(P_SYORIYMD_02);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData3);

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData4 = new HT_SkGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_04);
        hT_SkGaikaFBSoukinData4.setSyoriYmd(P_SYORIYMD_02);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData4);

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData5 = new HT_SkGaikaFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_05);
        hT_SkGaikaFBSoukinData5.setSyoriYmd(P_SYORIYMD_03);
        sinkeiyakuDomManager.insert(hT_SkGaikaFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkGaikaFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<HT_SkGaikaFBSoukinData> iter = beans.iterator();
            HT_SkGaikaFBSoukinData skGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                skGaikaFBSoukinData = iter.next();
                iCount++;

                Assert.assertEquals(P_FBSOUKINDATASIKIBETUKEY_01, skGaikaFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(P_SYORIYMD_01, skGaikaFBSoukinData.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_FBSOUKINDATASIKIBETUKEY_02,P_SYORIYMD_02), "1");
        datamap.put($(P_FBSOUKINDATASIKIBETUKEY_03,P_SYORIYMD_02), "1");
        datamap.put($(P_FBSOUKINDATASIKIBETUKEY_04,P_SYORIYMD_02), "1");

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)){

            int iCount = 0;
            Iterator<HT_SkGaikaFBSoukinData> iter = beans.iterator();
            HT_SkGaikaFBSoukinData skGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                skGaikaFBSoukinData = iter.next();
                iCount++;

                datamap.remove($(
                    skGaikaFBSoukinData.getFbsoukindatasikibetukey(),
                    skGaikaFBSoukinData.getSyoriYmd()));

            }

            Assert.assertEquals(3, iCount);
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
    public void testSkippedFilter40() {

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)){

            int iCount = 0;
            Iterator<HT_SkGaikaFBSoukinData> iter = beans.iterator();
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
        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("HT_SkGaikaFBSoukinData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_02);
        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)){

            int iCount = 0;
            for (HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData : beans) {

                Assert.assertNotEquals(hT_SkGaikaFBSoukinData.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_02);

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
        bT_SkipKey2.setTableid("HT_SkGaikaFBSoukinData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_03);
        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try (ExDBResults<HT_SkGaikaFBSoukinData> beans =
            sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)){

            int iCount = 0;
            for (HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData : beans) {

                Assert.assertNotEquals(hT_SkGaikaFBSoukinData.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_02);
                Assert.assertNotEquals(hT_SkGaikaFBSoukinData.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_03);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
