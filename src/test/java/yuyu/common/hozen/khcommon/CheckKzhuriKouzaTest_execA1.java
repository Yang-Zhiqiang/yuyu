package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckKouzaNoMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * CheckKzhuriKouzaクラスのメソッド {@link CheckKzhuriKouza#exec(String, String, C_YokinKbn, C_KzkykdouKbn, String,
 * String, String, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKzhuriKouzaTest_execA1 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_口座振替口座入力チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private CheckKzhuriKouza checkKzhuriKouza;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckKouzaNo.class).to(CheckKouzaNoMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckKouzaNoMockForKhansyuu.caller = CheckKzhuriKouzaTest_execA1.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        CheckKouzaNoMockForKhansyuu.caller = null;
        CheckKouzaNoMockForKhansyuu.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckKzhuriKouzaTest_execA1.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
        bizDomManager.delete(bizDomManager.getAllKinyuuKikanHuhoyofuriInfo());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN2;

        C_ErrorKbn kekkakbn = checkKzhuriKouza.exec("", "", C_YokinKbn.BLNK, C_KzkykdouKbn.DOUITU, "", "",
            "1234", BizDate.valueOf("20181107"));

        List<Integer> errorCdList = checkKzhuriKouza.getErrorCdlst();

        exNumericEquals(errorCdList.size(), 6, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 1, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 2, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 6, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 9, "エラーコードリスト[3]");
        exNumericEquals(errorCdList.get(4), 10, "エラーコードリスト[4]");
        exNumericEquals(errorCdList.get(5), 14, "エラーコードリスト[5]");

        MockObjectManager.assertArgumentPassed(CheckKouzaNoMockForKhansyuu.class, "isCheckOK", 0, "0001234");
        MockObjectManager.assertArgumentPassed(CheckKouzaNoMockForKhansyuu.class, "isCheckOK", 1, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(CheckKouzaNoMockForKhansyuu.class, "isKyoyouKeta", 0, "0001234");
        MockObjectManager.assertArgumentPassed(CheckKouzaNoMockForKhansyuu.class, "isKyoyouKeta", 1, C_Tuukasyu.JPY);

        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn kekkakbn = checkKzhuriKouza.exec("9900", "", C_YokinKbn.TOUZA, C_KzkykdouKbn.BLNK, "test01", "",
            "", BizDate.valueOf("20181107"));

        List<Integer> errorCdList = checkKzhuriKouza.getErrorCdlst();

        exNumericEquals(errorCdList.size(), 4, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 2, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 7, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 8, "エラーコードリスト[2]");
        exNumericEquals(errorCdList.get(3), 11, "エラーコードリスト[3]");

        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn kekkakbn = checkKzhuriKouza.exec("1234", "123", C_YokinKbn.TOUZA, C_KzkykdouKbn.SITEI, "test02",
            "", "", BizDate.valueOf("20181107"));

        List<Integer> errorCdList = checkKzhuriKouza.getErrorCdlst();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 3, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 8, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 12, "エラーコードリスト[2]");

        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn kekkakbn = checkKzhuriKouza.exec("4321", "004", C_YokinKbn.TOUZA, C_KzkykdouKbn.DOUITU, "test03",
            "1234567891011121314151617181920", "", BizDate.valueOf("20181107"));

        List<Integer> errorCdList = checkKzhuriKouza.getErrorCdlst();

        exNumericEquals(errorCdList.size(), 3, "エラーコードリストのサイズ");

        exNumericEquals(errorCdList.get(0), 5, "エラーコードリスト[0]");
        exNumericEquals(errorCdList.get(1), 8, "エラーコードリスト[1]");
        exNumericEquals(errorCdList.get(2), 13, "エラーコードリスト[2]");

        exClassificationEquals(kekkakbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN1;

        C_ErrorKbn kekkakbn = checkKzhuriKouza.exec("1234", "005", C_YokinKbn.HUTUU, C_KzkykdouKbn.SITEI, "test04",
            "123456", "123", BizDate.valueOf("20181107"));

        List<Integer> errorCdList = checkKzhuriKouza.getErrorCdlst();

        exNumericEquals(errorCdList.size(), 0, "エラーコードリストのサイズ");

        exClassificationEquals(kekkakbn, C_ErrorKbn.OK, "結果区分");
    }

}
