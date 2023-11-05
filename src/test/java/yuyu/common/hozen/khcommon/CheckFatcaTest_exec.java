package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_FatcatghtkekKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Uktsei;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.manager.impl.HozenDomManagerImpl;
import yuyu.testinfr.TestOrder;

/**
 * FATCA対象チェッククラスのメソッド {@link CheckFatca#exec(C_FatcatgKbn, String, BizDate, Classification)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckFatcaTest_exec {

    @Inject
    private CheckFatca checkFatca;

    private final static String fileName = "UT_SP_単体テスト仕様書_ＦＡＴＣＡ対象チェック";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckFatcaTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(110)
    public void testExec_A1() {
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", null, C_Kyksei.MALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A2() {
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), null);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A3() {
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ９９", null, null);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOU, "FATCA対象判定結果区分");
        exNumericEquals(checkFatca.getMsgIdList().size(), 1, "メッセージＩＤリストの件数");
        exStringEquals(checkFatca.getMsgIdList().get(0), "WIC0034", "メッセージＩＤ");
        exNumericEquals(checkFatca.getMsgList().size(), 1, "メッセージリストの件数");
        exStringEquals(checkFatca.getMsgList().get(0), "契約者相続人がＦＡＴＣＡ確認対象者です。　該当証券番号：11807111130", "メッセージ");
    }

    @Test
    @TestOrder(210)
    public void testExec_B1() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "ヴガギグゲゴザジズ", BizDate.valueOf("20130101"), C_Kyksei.MALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        exNumericEquals(checkFatca.getMsgIdList().size(), 0, "メッセージＩＤリストの件数");
        exNumericEquals(checkFatca.getMsgList().size(), 0, "メッセージリストの件数");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 0, C_FatcakekKbn.TAISYOUGAIHUYOU);
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 1, "ウカキクケコサシス");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 2, BizDate.valueOf("20130101"));
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.MALE);
    }

    @Test
    @TestOrder(220)
    public void testExec_B2() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Kyksei.FEMALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.FEMALE);
    }

    @Test
    @TestOrder(230)
    public void testExec_B3() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Kyksei.HJNKYK);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.HJN);
    }

    @Test
    @TestOrder(240)
    public void testExec_B4() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Kyksei.BLNK);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.BLNK);
    }

    @Test
    @TestOrder(250)
    public void testExec_B5() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Hhknsei.MALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.MALE);
    }

    @Test
    @TestOrder(260)
    public void testExec_B6() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Hhknsei.FEMALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.FEMALE);
    }

    @Test
    @TestOrder(270)
    public void testExec_B7() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Hhknsei.BLNK);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.BLNK);
    }

    @Test
    @TestOrder(280)
    public void testExec_B8() {
        MockObjectManager.initialize();
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ", BizDate.valueOf("20130101"), C_Uktsei.MALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOUGAI, "FATCA対象判定結果区分");
        MockObjectManager.assertArgumentPassed(HozenDomManagerImpl.class, "getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu", 3, C_Seibetu.BLNK);
    }

    @Test
    @TestOrder(310)
    public void testExec_C1() {
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ３２", BizDate.valueOf("20130105"), C_Hhknsei.MALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOU, "FATCA対象判定結果区分");
        exNumericEquals(checkFatca.getMsgIdList().size(), 1, "メッセージＩＤリストの件数");
        exStringEquals(checkFatca.getMsgIdList().get(0), "WIC0034", "メッセージＩＤ");
        exNumericEquals(checkFatca.getMsgList().size(), 1, "メッセージリストの件数");
        exStringEquals(checkFatca.getMsgList().get(0), "契約者相続人がＦＡＴＣＡ確認対象者です。　該当証券番号：11807111118", "メッセージ");
    }

    @Test
    @TestOrder(320)
    public void testExec_C2() {
        C_FatcatghtkekKbn fatcatghtkekKbn = checkFatca.exec(C_FatcatgKbn.KYKSZK, "カナ３３", BizDate.valueOf("20130108"), C_Hhknsei.MALE);

        exClassificationEquals(fatcatghtkekKbn, C_FatcatghtkekKbn.TAISYOU, "FATCA対象判定結果区分");
        exNumericEquals(checkFatca.getMsgIdList().size(), 1, "メッセージＩＤリストの件数");
        exStringEquals(checkFatca.getMsgIdList().get(0), "WIC0034", "メッセージＩＤ");
        exNumericEquals(checkFatca.getMsgList().size(), 1, "メッセージリストの件数");
        exStringEquals(checkFatca.getMsgList().get(0), "契約者相続人がＦＡＴＣＡ確認対象者です。　該当証券番号：11807111129　他", "メッセージ");
    }
}