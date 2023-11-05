package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ編集クラスのメソッド {@link HubiMsgEdit#getHubiMsgSourceData_1MousikomiNo(String)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class HubiMsgEditTest_getHubiMsgSourceData_1MousikomiNo_1 {

    private final static String mosNo1 = "791112220";

    private final static String fileName = "UT_SP_単体テスト仕様書_不備メッセージ編集";

    private final static String sheetName = "INデータ";

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HubiMsgEditTest_getHubiMsgSourceData_1MousikomiNo_1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testGetHubiMsgSourceData_1MousikomiNo_A1() {

        ArrayList<String> hubiMsgLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo1);

        exNumericEquals(hubiMsgLst.size(), 12, "結果リスト");
        exStringEquals(hubiMsgLst.get(0), "1 EAC0001 テスト不備メッセージ１", "編集結果");
        exStringEquals(hubiMsgLst.get(1), "2 EAC0002 テスト不備メッセージ２", "編集結果");
        exStringEquals(hubiMsgLst.get(2), "3 EAC0003 テスト不備メッセージ３", "編集結果");
        exStringEquals(hubiMsgLst.get(3), "1 TJA0001 テスト不備メッセージ４", "編集結果");
        exStringEquals(hubiMsgLst.get(4), "2 TJA0002 テスト不備メッセージ５", "編集結果");
        exStringEquals(hubiMsgLst.get(5), "3 TJA0003 テスト不備メッセージ６", "編集結果");
        exStringEquals(hubiMsgLst.get(6), "1 WJA0024 テスト不備メッセージ７", "編集結果");
        exStringEquals(hubiMsgLst.get(7), "2 WJA0025 テスト不備メッセージ８", "編集結果");
        exStringEquals(hubiMsgLst.get(8), "3 WJA0026 テスト不備メッセージ９", "編集結果");
        exStringEquals(hubiMsgLst.get(9), "1 KBC0001 テスト不備メッセージ１０", "編集結果");
        exStringEquals(hubiMsgLst.get(10), "2 KIA0001 テスト不備メッセージ１１", "編集結果");
        exStringEquals(hubiMsgLst.get(11), "3 KIC0001 テスト不備メッセージ１２", "編集結果");
    }

}