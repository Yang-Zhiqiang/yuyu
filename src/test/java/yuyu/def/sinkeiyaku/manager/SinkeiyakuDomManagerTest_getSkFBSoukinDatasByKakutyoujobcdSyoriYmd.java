package yuyu.def.sinkeiyaku.manager;

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
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 新契約ＦＢ送金データ取込<br />
 * 新契約ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkFBSoukinDatasByKakutyoujobcdSyoriYmd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_FBSOUKINDATASIKIBETUKEY_01 = "11111111111111111111";
    static String P_FBSOUKINDATASIKIBETUKEY_02 = "22222222222222222222";
    static String P_FBSOUKINDATASIKIBETUKEY_03 = "33333333333333333333";
    static String P_FBSOUKINDATASIKIBETUKEY_04 = "44444444444444444444";
    static String P_FBSOUKINDATASIKIBETUKEY_05 = "55555555555555555555";
    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RGDA";
    static String P_FILTER_ID = "Bz107";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160301");
    static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160302");
    static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160303");
    static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160304");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SkFBSoukinData> beans =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SkFBSoukinData hT_SkFBSoukinData1 = new HT_SkFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_01);
        hT_SkFBSoukinData1.setSyoriYmd(P_SYORIYMD_01);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData1);

        HT_SkFBSoukinData hT_SkFBSoukinData2 = new HT_SkFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_02);
        hT_SkFBSoukinData2.setSyoriYmd(P_SYORIYMD_02);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData2);

        HT_SkFBSoukinData hT_SkFBSoukinData3 = new HT_SkFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_03);
        hT_SkFBSoukinData3.setSyoriYmd(P_SYORIYMD_02);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData3);

        HT_SkFBSoukinData hT_SkFBSoukinData4 = new HT_SkFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_04);
        hT_SkFBSoukinData4.setSyoriYmd(P_SYORIYMD_02);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData4);

        HT_SkFBSoukinData hT_SkFBSoukinData5 = new HT_SkFBSoukinData(P_FBSOUKINDATASIKIBETUKEY_05);
        hT_SkFBSoukinData5.setSyoriYmd(P_SYORIYMD_03);
        sinkeiyakuDomManager.insert(hT_SkFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<HT_SkFBSoukinData> beans =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_04)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HT_SkFBSoukinData> beans =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_01)) {

            int iCount = 0;
            Iterator<HT_SkFBSoukinData> iter = beans.iterator();
            HT_SkFBSoukinData skfbsoukindata = null;
            while (iter.hasNext()) {

                skfbsoukindata = iter.next();
                iCount++;

                Assert.assertEquals(P_FBSOUKINDATASIKIBETUKEY_01, skfbsoukindata.getFbsoukindatasikibetukey());
                Assert.assertEquals(P_SYORIYMD_01, skfbsoukindata.getSyoriYmd());
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


        try (ExDBResults<HT_SkFBSoukinData> beans =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, P_SYORIYMD_02)){

            int iCount = 0;
            Iterator<HT_SkFBSoukinData> iter = beans.iterator();
            HT_SkFBSoukinData skfbsoukindata = null;
            while (iter.hasNext()) {

                skfbsoukindata = iter.next();
                iCount++;

                datamap.remove($(
                    skfbsoukindata.getFbsoukindatasikibetukey(),
                    skfbsoukindata.getSyoriYmd()));

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
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){

        try(ExDBResults<HT_SkFBSoukinData> exDBResBean =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            Iterator<HT_SkFBSoukinData> iter = exDBResBean.iterator();
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
        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("HT_SkFBSoukinData");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_02);
        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<HT_SkFBSoukinData> exDBResBean =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (HT_SkFBSoukinData entity : exDBResBean) {

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
        bT_SkipKey2.setTableid("HT_SkFBSoukinData");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1(P_FBSOUKINDATASIKIBETUKEY_03);
        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<HT_SkFBSoukinData> exDBResBean =
            sinkeiyakuDomManager.getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, P_SYORIYMD_02)) {

            int iCount = 0;
            for (HT_SkFBSoukinData entity : exDBResBean) {

                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_02);
                assertNotEquals(entity.getFbsoukindatasikibetukey(), P_FBSOUKINDATASIKIBETUKEY_03);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
