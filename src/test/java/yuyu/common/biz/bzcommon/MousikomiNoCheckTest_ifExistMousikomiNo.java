package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.testinfr.AbstractTest;

/**
 * 申込番号チェックの申込番号存在チェック{@link MousikomiNoCheck#ifExistMousikomiNo(String)}テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class MousikomiNoCheckTest_ifExistMousikomiNo extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_申込番号チェック ";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoCheckTest_ifExistMousikomiNo.class, fileName, sheetName);
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
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

    }

    @Test
    public void testIfExistMousikomiNo_A1() {
        exBooleanEquals(MousikomiNoCheck.ifExistMousikomiNo("990000010"), false, "チェック結果");
    }

    @Test
    public void testIfExistMousikomiNo_A2() {
        exBooleanEquals(MousikomiNoCheck.ifExistMousikomiNo("980000038"), false, "チェック結果");
    }

    @Test
    public void testIfExistMousikomiNo_A3() {
        exBooleanEquals(MousikomiNoCheck.ifExistMousikomiNo("970000014"), true, "チェック結果");
    }

}
