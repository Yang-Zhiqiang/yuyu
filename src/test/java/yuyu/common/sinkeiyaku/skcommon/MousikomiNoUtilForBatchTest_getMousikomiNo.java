package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込番号管理クラスのメソッド {@link MousikomiNoUtilForBatch#getMousikomiNo(final String pMosnoChannel, final int pKennsuu,  final BizDate pSyoriYmd)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class MousikomiNoUtilForBatchTest_getMousikomiNo extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_申込番号採番（バッチ用）";
    private final static String sheetName = "テストデータ";
    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilForBatchTest_getMousikomiNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    @Transactional
    public void testGetMousikomiNo_E1() {

        try {

            final String mosnoChannel = "86";

            final int kennsuu = 99;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.WEB);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    @Transactional
    public void testGetMousikomiNo_E2() {

        try {

            final String mosnoChannel = "";

            final Integer kennsuu = 99;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "パラメータエラー　param='申込番号チャネル',value=''", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(25)
    @Transactional
    public void testGetMousikomiNo_E3() {

        try {

            String mosnoChannel = null;

            final Integer kennsuu = 99;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "パラメータエラー　param='申込番号チャネル',value=''", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    @Transactional
    public void testGetMousikomiNo_E4() {

        try {

            final String mosnoChannel = "e1";

            final Integer kennsuu = 99;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "パラメータエラー　param='申込番号チャネル',value='e1'", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    @Transactional
    public void testGetMousikomiNo_E5() {

        try {

            final String mosnoChannel = "00";

            final Integer kennsuu = 99;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "パラメータエラー　param='申込番号チャネル',value='00'", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    @Transactional
    public void testGetMousikomiNo_E6() {

        try {

            final String mosnoChannel = "66";

            final int kennsuu = 2;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "テーブル取得エラー　HT_MosnoKanri　key:申込番号チャネル=66,件数=2", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(999)
    @Transactional
    public void testGetMousikomiNo_E7() {

        try {

            SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
            sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

            final String mosnoChannel = "86";

            final int kennsuu = 2;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "テーブル取得エラー　HT_MosnoKanri　key:申込番号チャネル=86,件数=2", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    @Transactional
    public void testGetMousikomiNo_E8() {

        try {

            final String mosnoChannel = "99";

            final int kennsuu = 2;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "テーブル取得エラー　HT_MosnoKanri　key:申込番号チャネル=99,件数=2", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(62)
    @Transactional
    public void testGetMousikomiNo_E9() {

        try {

            SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
            sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

            final String mosnoChannel = "78";

            final int kennsuu = 1;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "テーブル取得エラー　HT_MosnoKanri　key:申込番号チャネル=78,件数=1", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(64)
    @Transactional
    public void testExec_A12_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ012", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
    @Test(expected = BizAppException.class)
    @TestOrder(66)
    @Transactional
    public void testGetMousikomiNo_E10() {

        try {

            SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
            sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

            final String mosnoChannel = "88";

            final int kennsuu = 2;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        } catch (BizAppException ex) {

            exStringEquals(ex.getMessage(), "テーブル取得エラー　HT_MosnoKanri　key:申込番号チャネル=88,件数=2", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A1_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ010", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testGetMousikomiNo_A1() {

        try {

            final String mosnoChannel = "78";

            final int kennsuu = 1;

            changeSystemDate(BizDate.valueOf(2017, 8, 1));

            BizDate syoriYmd  = BizDate.getSysDate();

            CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

            MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);


        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage().substring(0, 13), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A2_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testGetMousikomiNo_A2() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<String>  actMosnList = new ArrayList<>();

        final List<String>  expMosnList = new ArrayList<>();
        expMosnList.add("860000017");
        expMosnList.add("860000058");
        expMosnList.add("870000015");
        expMosnList.add("870000023");
        expMosnList.add("880000013");
        expMosnList.add("860000025");
        expMosnList.add("870000031");
        expMosnList.add("880000021");
        expMosnList.add("886999994");
        expMosnList.add("870000049");
        expMosnList.add("870000056");
        expMosnList.add("880000047");

        final String mosnoChannel = "86";

        final int kennsuu = 12;

        changeSystemDate(BizDate.valueOf(2023,6,1));

        BizDate syoriYmd  = BizDate.getSysDate();


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        actMosnList = MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        exListEquals(actMosnList, expMosnList, "申込番号リスト");

        HT_MosnoKanri mosnoKanri = null;
        for (String mousikomiNo : actMosnList) {
            mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mousikomiNo.substring(0,8));
            exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
                "採番可否区分");
            exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf("20230601"), "採番日");
            exDateEquals(mosnoKanri.getMossykykyoteiymd(),  BizDate.valueOf("20250829"), "申込消却予定日");
        }

        HT_MosnoKanri mosnoKanri2 = sinkeiyakuDomManager.getMosnoKanri("86000003");
        exClassificationEquals(mosnoKanri2.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri2.getSaibanymd(), BizDate.valueOf("20180201"), "採番日");
        exDateEquals(mosnoKanri2.getMossykykyoteiymd(),  BizDate.valueOf("20190501"), "申込消却予定日");

        HT_MosnoKanri mosnoKanri3 = sinkeiyakuDomManager.getMosnoKanri("86000004");
        exClassificationEquals(mosnoKanri3.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri3.getSaibanymd(), BizDate.valueOf("20180201"), "採番日");
        exDateEquals(mosnoKanri3.getMossykykyoteiymd(),  BizDate.valueOf("20190501"), "申込消却予定日");

        HT_MosnoKanri mosnoKanri4 = sinkeiyakuDomManager.getMosnoKanri("88700000");
        exClassificationEquals(mosnoKanri4.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri4.getSaibanymd(), BizDate.valueOf("20180201"), "採番日");
        exDateEquals(mosnoKanri4.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri5 = sinkeiyakuDomManager.getMosnoKanri("86000000");
        exClassificationEquals(mosnoKanri5.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri5.getSaibanymd(), BizDate.valueOf("20180201"), "採番日");
        exDateEquals(mosnoKanri5.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri6 = sinkeiyakuDomManager.getMosnoKanri("78000004");
        exClassificationEquals(mosnoKanri6.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri6.getSaibanymd(), BizDate.valueOf("20180201"), "採番日");
        exDateEquals(mosnoKanri6.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri7 = sinkeiyakuDomManager.getMosnoKanri("79000005");
        exClassificationEquals(mosnoKanri7.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri7.getSaibanymd(), BizDate.valueOf("20180201"), "採番日");
        exDateEquals(mosnoKanri7.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri8 = sinkeiyakuDomManager.getMosnoKanri("88000005");
        exClassificationEquals(mosnoKanri8.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri8.getSaibanymd(), BizDate.valueOf("20190501"), "採番日");
        exDateEquals(mosnoKanri8.getMossykykyoteiymd(),  null, "申込消却予定日");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A3_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testGetMousikomiNo_A3() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<String>  actMosnList = new ArrayList<>();

        final List<String>  expMosnList = new ArrayList<>();
        expMosnList.add("780000014");
        expMosnList.add("780000063");
        expMosnList.add("790000012");
        expMosnList.add("799999990");

        final String mosnoChannel = "78";

        final int kennsuu = 4;

        changeSystemDate(BizDate.valueOf(2020,8,1));

        BizDate syoriYmd  = BizDate.getSysDate();


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        actMosnList = MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        exListEquals(actMosnList, expMosnList, "申込番号リスト");

        HT_MosnoKanri mosnoKanri = null;
        for (String mousikomiNo : actMosnList) {
            mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mousikomiNo.substring(0, 8));
            exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
                "採番可否区分");
            exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf("20200801"), "採番日");
            exDateEquals(mosnoKanri.getMossykykyoteiymd(),  BizDate.valueOf("20221031"), "申込消却予定日");
        }


        HT_MosnoKanri mosnoKanri7 = sinkeiyakuDomManager.getMosnoKanri("78000000");
        exClassificationEquals(mosnoKanri7.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri7.getSaibanymd(), BizDate.valueOf("20180101"), "採番日");
        exDateEquals(mosnoKanri7.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri8 = sinkeiyakuDomManager.getMosnoKanri("80000000");
        exClassificationEquals(mosnoKanri8.getSaibankahikbn(), C_KahiKbn.KA,
            "採番可否区分");
        exDateEquals(mosnoKanri8.getSaibanymd(), BizDate.valueOf("20180101"), "採番日");
        exDateEquals(mosnoKanri8.getMossykykyoteiymd(),  null, "申込消却予定日");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A4_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testGetMousikomiNo_A4() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<String>  actMosnList = new ArrayList<>();

        final List<String>  expMosnList = new ArrayList<>();
        expMosnList.add("970000014");
        expMosnList.add("979999992");

        final String mosnoChannel = "97";

        final int kennsuu = 2;

        changeSystemDate(BizDate.valueOf(2020,8,1));

        BizDate syoriYmd  = BizDate.getSysDate();


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        actMosnList = MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        exListEquals(actMosnList, expMosnList, "申込番号リスト");

        HT_MosnoKanri mosnoKanri = null;
        for (String mousikomiNo : actMosnList) {
            mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mousikomiNo.substring(0, 8));
            exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
                "採番可否区分");
            exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf("20200801"), "採番日");
            exDateEquals(mosnoKanri.getMossykykyoteiymd(),  BizDate.valueOf("20221031"), "申込消却予定日");
        }

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A5_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ011", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testGetMousikomiNo_A5() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<String>  actMosnList = new ArrayList<>();

        final List<String>  expMosnList = new ArrayList<>();
        expMosnList.add("887000008");
        expMosnList.add("887000040");
        expMosnList.add("888000015");
        expMosnList.add("888000023");
        expMosnList.add("889000014");
        expMosnList.add("887000016");
        expMosnList.add("888000031");
        expMosnList.add("889000022");
        expMosnList.add("889999991");
        expMosnList.add("888000049");
        expMosnList.add("888000056");
        expMosnList.add("889000048");

        final String mosnoChannel = "88";

        final int kennsuu = 12;

        changeSystemDate(BizDate.valueOf(2023,6,1));

        BizDate syoriYmd  = BizDate.getSysDate();


        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        actMosnList = MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu, syoriYmd);

        exListEquals(actMosnList, expMosnList, "申込番号リスト");

        HT_MosnoKanri mosnoKanri = null;
        for (String mousikomiNo : actMosnList) {
            mosnoKanri = sinkeiyakuDomManager.getMosnoKanri(mousikomiNo.substring(0,8));
            exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
                "採番可否区分");
            exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf("20230601"), "採番日");
            exDateEquals(mosnoKanri.getMossykykyoteiymd(),  BizDate.valueOf("20280630"), "申込消却予定日");
        }

        HT_MosnoKanri mosnoKanri1 = sinkeiyakuDomManager.getMosnoKanri("88700002");
        exDateEquals(mosnoKanri1.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri2 = sinkeiyakuDomManager.getMosnoKanri("88700003");
        exDateEquals(mosnoKanri2.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri3 = sinkeiyakuDomManager.getMosnoKanri("89000000");
        exDateEquals(mosnoKanri3.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri4 = sinkeiyakuDomManager.getMosnoKanri("88699999");
        exDateEquals(mosnoKanri4.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri5 = sinkeiyakuDomManager.getMosnoKanri("78000004");
        exDateEquals(mosnoKanri5.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri6 = sinkeiyakuDomManager.getMosnoKanri("79000005");
        exDateEquals(mosnoKanri6.getMossykykyoteiymd(),  null, "申込消却予定日");

        HT_MosnoKanri mosnoKanri7 = sinkeiyakuDomManager.getMosnoKanri("88900005");
        exDateEquals(mosnoKanri7.getMossykykyoteiymd(),  null, "申込消却予定日");
    }



}
