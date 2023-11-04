package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 税制適格特約付加条件チェック{@link CheckZeiseiTkkkTkykHukaJyouken#checkZeiseiTkkkTkykHukaJkBySyono(KhozenCommonParam, String)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckZeiseiTkkkTkykHukaJyoukenTest_checkZeiseiTkkkTkykHukaJkBySyono {

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_税制適格特約付加条件チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckZeiseiTkkkTkykHukaJyoukenTest_checkZeiseiTkkkTkykHukaJkBySyono.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A1() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111185");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");

    }

    @Test
    @TestOrder(20)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A2() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111336");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");

    }

    @Test
    @TestOrder(30)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A3() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111347");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), true, "税制適格特約付加条件判定結果");
        exNumericEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList().size(), 0, "エラーコードリスト取得件数");

    }

    @Test
    @TestOrder(40)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A4() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111358");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), true, "税制適格特約付加条件判定結果");
        exNumericEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList().size(), 0, "エラーコードリスト取得件数");

    }

    @Test
    @TestOrder(50)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A5() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111369");
        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(2);
        errorCodeList.add(3);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(60)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A6() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111370");
        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(3);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(70)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A7() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111381");
        List<Integer> errorCodeList = new ArrayList<>();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), true, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(80)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A8() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111392");
        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(4);
        errorCodeList.add(5);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");


    }

    @Test
    @TestOrder(90)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A9() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111406");
        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(4);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(100)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A10() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111417");
        List<Integer> errorCodeList = new ArrayList<>();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), true, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(110)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A11() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111428");
        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(5);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(120)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A12() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111439");
        List<Integer> errorCodeList = new ArrayList<>();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), true, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(130)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A13() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111440");

        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(1);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(140)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A14() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11807111451");

        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(2);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(150)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A15() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11808000068");

        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(1);
        errorCodeList.add(3);
        errorCodeList.add(4);
        errorCodeList.add(5);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

    @Test
    @TestOrder(160)
    public void testCheckZeiseiTkkkTkykHukaJkBySyono_A16() throws Exception {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckZeiseiTkkkTkykHukaJyouken checkZeiseiTkkkTkykHukaJyouken = SWAKInjector.getInstance(CheckZeiseiTkkkTkykHukaJyouken.class);
        C_ErrorKbn errorKbn = checkZeiseiTkkkTkykHukaJyouken.checkZeiseiTkkkTkykHukaJkBySyono(khozenCommonParam, "11808000080");

        List<Integer> errorCodeList = new ArrayList<>();
        errorCodeList.add(2);
        errorCodeList.add(3);
        errorCodeList.add(4);
        errorCodeList.add(5);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(checkZeiseiTkkkTkykHukaJyouken.getHtZeiseiTkkkTkykHukaJk(), false, "税制適格特約付加条件判定結果");
        exListEquals(checkZeiseiTkkkTkykHukaJyouken.getErrorCodeList(),errorCodeList,"エラーコードリスト取得結果");
    }

}
