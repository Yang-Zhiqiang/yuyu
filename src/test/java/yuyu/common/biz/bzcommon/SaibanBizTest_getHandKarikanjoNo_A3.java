package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;

/**
 * 採番業務共通クラスのメソッド {@link SaibanBiz#getHandKarikanjoNo()} テスト用クラスです。<br />
 * ※テストケースA3<br />
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getHandKarikanjoNo_A3 {

    private final static String fileName = "UT_SP_単体テスト仕様書（共通）_採番業務共通";

    private final static String sheetName = "テストデータ_20170818";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaibanBizTest_getHandKarikanjoNo_A1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ_共通", testDataAndTblMap);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    public void testHandKarikanjoNo_A3() {
        long result = SaibanBiz.getHandKarikanjoNo();

        exNumericEquals(result, 99999, "結果");
    }

}
