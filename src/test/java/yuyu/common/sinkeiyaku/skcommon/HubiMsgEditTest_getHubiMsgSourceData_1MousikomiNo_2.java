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
import yuyu.def.classification.C_HubiSyoriKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ編集クラスのメソッド {@link HubiMsgEdit#getHubiMsgSourceData_1MousikomiNo(String, C_HubiSyoriKbn)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class HubiMsgEditTest_getHubiMsgSourceData_1MousikomiNo_2 {

    private final static String mosNo1 = "791112238";

    private final static String mosNo2 = "791112246";

    private final static String mosNo3 = "791112253";

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
            testDataAndTblMap = testDataMaker.getInData(HubiMsgEditTest_getHubiMsgSourceData_1MousikomiNo_2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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
    public void testGetHubiMsgSourceData_1SyoukenNo_A1() {

        ArrayList<String> hubiMsgLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo1, C_HubiSyoriKbn.SYOUKAI);

        exNumericEquals(hubiMsgLst.size(), 1, "結果リスト");
        exStringEquals(hubiMsgLst.get(0), "1 EAC0001 テスト不備メッセージ１", "編集結果");
    }

    @Test
    @TestOrder(20)
    public void testGetHubiMsgSourceData_1SyoukenNo_A2() {

        ArrayList<String> hubiMsgLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo2, C_HubiSyoriKbn.SYOUKAI);

        exNumericEquals(hubiMsgLst.size(), 1, "結果リスト");
        exStringEquals(hubiMsgLst.get(0), " EAC0001 ", "編集結果");
    }

    @Test
    @TestOrder(30)
    public void testGetHubiMsgSourceData_1SyoukenNo_A3() {

        ArrayList<String> hubiMsgLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo3, C_HubiSyoriKbn.SYOUKAI);

        exNumericEquals(hubiMsgLst.size(), 0, "結果リスト");
    }
}