package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約 新契約共通 支払金指定口座チェックのメソッド
 * {@link CheckShiharaikinSiteiKouza#exec(C_Tkhukaumu, C_KouzasyuruiKbn, String, String, C_YokinKbn,
 * String, C_KzkykdouKbn, String, String, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckShiharaikinSiteiKouza_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払金指定口座チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private CheckShiharaikinSiteiKouza checkShiharaikinSiteiKouza;

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckShiharaikinSiteiKouza_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
    }

    @Test
    @TestOrder(10)
    public void CheckShiharaikinSiteiKouzaTest_exec_A1() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.NONE, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 0, "エラーコードリストのサイズ");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void CheckShiharaikinSiteiKouzaTest_exec_A2() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, "ナナ", "カカ", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 22, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void CheckShiharaikinSiteiKouzaTest_exec_A3() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, "カカ", "カカ", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void CheckShiharaikinSiteiKouzaTest_exec_A4() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, "カカ", null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 18, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(50)
    public void CheckShiharaikinSiteiKouzaTest_exec_A5() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.DOUITU, "ナナ", "カカ", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 19, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }


    @Test
    @TestOrder(60)
    public void CheckShiharaikinSiteiKouzaTest_exec_A6() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.NONE, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void CheckShiharaikinSiteiKouzaTest_exec_A7() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.BLNK, C_KouzasyuruiKbn.BLNK, "AA", null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void CheckShiharaikinSiteiKouzaTest_exec_A8() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.NONE, C_KouzasyuruiKbn.BLNK, null, "BB",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void CheckShiharaikinSiteiKouzaTest_exec_A9() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.BLNK, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.HUTUU, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(100)
    public void CheckShiharaikinSiteiKouzaTest_exec_A10() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.NONE, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, "CC", C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(110)
    public void CheckShiharaikinSiteiKouzaTest_exec_A11() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.BLNK, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(120)
    public void CheckShiharaikinSiteiKouzaTest_exec_A12() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.NONE, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, "DD", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(130)
    public void CheckShiharaikinSiteiKouzaTest_exec_A13() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.BLNK, C_KouzasyuruiKbn.YENKOUZA, "AA", "BB",
            C_YokinKbn.HUTUU, "CC", C_KzkykdouKbn.SITEI, null, "DD", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(140)
    public void CheckShiharaikinSiteiKouzaTest_exec_A14() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.NONE, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 0, "エラーコードリストのサイズ");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(150)
    public void CheckShiharaikinSiteiKouzaTest_exec_A15() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 1, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 2, "エラーコードリスト[0]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(160)
    public void CheckShiharaikinSiteiKouzaTest_exec_A16() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 16, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(170)
    public void CheckShiharaikinSiteiKouzaTest_exec_A17() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "AA", null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(180)
    public void CheckShiharaikinSiteiKouzaTest_exec_A18() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, "BB",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(190)
    public void CheckShiharaikinSiteiKouzaTest_exec_A19() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.HUTUU, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 16, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(200)
    public void CheckShiharaikinSiteiKouzaTest_exec_A20() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, "CC", C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(210)
    public void CheckShiharaikinSiteiKouzaTest_exec_A21() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 18, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(220)
    public void CheckShiharaikinSiteiKouzaTest_exec_A22() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, "DD", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 5, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 16, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(230)
    public void CheckShiharaikinSiteiKouzaTest_exec_A23() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, "AA", "BB",
            C_YokinKbn.HUTUU, "CC", C_KzkykdouKbn.SITEI, null, "DD", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 6, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 14, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 22, "エラーコードリスト[2]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(240)
    public void CheckShiharaikinSiteiKouzaTest_exec_A24() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.BLNK, C_KouzasyuruiKbn.BLNK, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 0, "エラーコードリストのサイズ");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(250)
    public void CheckShiharaikinSiteiKouzaTest_exec_A25() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, null, "BB",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 4, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(260)
    public void CheckShiharaikinSiteiKouzaTest_exec_A26() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "AA", null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(270)
    public void CheckShiharaikinSiteiKouzaTest_exec_A27() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "0010", "001",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 6, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(280)
    public void CheckShiharaikinSiteiKouzaTest_exec_A28() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "0010", "005",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 7, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(290)
    public void CheckShiharaikinSiteiKouzaTest_exec_A29() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "0010", "008",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, BizDate.valueOf(20200507));

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 13, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 16, "エラーコードリスト[2]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(300)
    public void CheckShiharaikinSiteiKouzaTest_exec_A30() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, "9900", "618",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 6, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 7, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 8, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 12, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 13, "エラーコードリスト[4]");
        exNumericEquals(errorCdList.get(5), 16, "エラーコードリスト[5]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(310)
    public void CheckShiharaikinSiteiKouzaTest_exec_A31() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, "0010", "050",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 7, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 10, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(320)
    public void CheckShiharaikinSiteiKouzaTest_exec_A32() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, "9900", "618",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 7, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 9, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 12, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 16, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(330)
    public void CheckShiharaikinSiteiKouzaTest_exec_A33() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, "0010", "050",
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 7, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 13, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 16, "エラーコードリスト[2]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(340)
    public void CheckShiharaikinSiteiKouzaTest_exec_A34() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 16, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(350)
    public void CheckShiharaikinSiteiKouzaTest_exec_A35() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, "9900", null,
            C_YokinKbn.TOUZA, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 5, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 12, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(360)
    public void CheckShiharaikinSiteiKouzaTest_exec_A36() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, "1234", null,
            C_YokinKbn.HUTUU, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 5, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 11, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(370)
    public void CheckShiharaikinSiteiKouzaTest_exec_A37() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, "9900", null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 5, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 12, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(380)
    public void CheckShiharaikinSiteiKouzaTest_exec_A38() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "9900", null,
            C_YokinKbn.HUTUU, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(390)
    public void CheckShiharaikinSiteiKouzaTest_exec_A39() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, "AAAAAAAA", C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 6, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 14, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 15, "エラーコードリスト[4]");
        exNumericEquals(errorCdList.get(5), 16, "エラーコードリスト[5]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(400)
    public void CheckShiharaikinSiteiKouzaTest_exec_A40() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, null, null,
            C_YokinKbn.BLNK, "0123456789", C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 16, "エラーコードリスト[2]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(410)
    public void CheckShiharaikinSiteiKouzaTest_exec_A41() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(420)
    public void CheckShiharaikinSiteiKouzaTest_exec_A42() {

        String checkMoji = "0123456789ABCDEFGHIJKLMNOP!#$%";

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, null, null,
            C_YokinKbn.BLNK, checkMoji,  C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 14, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 15, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 16, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(430)
    public void CheckShiharaikinSiteiKouzaTest_exec_A43() {

        String checkMoji = "0123456789ABCDEFGHIJKLMNOP!#$%";

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "123", null,
            C_YokinKbn.BLNK, checkMoji, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 16, "エラーコードリスト[2]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }



    @Test
    @TestOrder(440)
    public void CheckShiharaikinSiteiKouzaTest_exec_A44() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.DOUITU, "ｱｲｳｴｵｶ!#$%", null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 20, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(450)
    public void CheckShiharaikinSiteiKouzaTest_exec_A45() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, null, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 6, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 21, "エラーコードリスト[4]");
        exNumericEquals(errorCdList.get(5), 22, "エラーコードリスト[5]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(460)
    public void CheckShiharaikinSiteiKouzaTest_exec_A46() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.DOUITU, null, "AA", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 17, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 19, "エラーコードリスト[4]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(470)
    public void CheckShiharaikinSiteiKouzaTest_exec_A47() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.GAIKAKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, null, "AA", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 22, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(480)
    public void CheckShiharaikinSiteiKouzaTest_exec_A48() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.YENKOUZA, null, null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 5, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 4, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 10, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 13, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 18, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(490)
    public void CheckShiharaikinSiteiKouzaTest_exec_A49() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "AA", null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.BLNK, null, null, null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 16, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(500)
    public void CheckShiharaikinSiteiKouzaTest_exec_A50() {

        C_ErrorKbn errorKbn = checkShiharaikinSiteiKouza.exec(C_Tkhukaumu.HUKA, C_KouzasyuruiKbn.BLNK, "AA", null,
            C_YokinKbn.BLNK, null, C_KzkykdouKbn.SITEI, null, "ｱｲｳｴｵｶ!#$%", null);

        List<Integer> errorCdList = checkShiharaikinSiteiKouza.getErrorCdList();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 5, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 22, "エラーコードリスト[3]");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

}
