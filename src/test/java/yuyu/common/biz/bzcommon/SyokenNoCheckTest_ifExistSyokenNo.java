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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.AbstractTest;

/**
 * 証券番号チェックの証券番号存在チェック{@link SyokenNoCheck#ifExistSyokenNo(String)}テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SyokenNoCheckTest_ifExistSyokenNo extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_証券番号チェック";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyokenNoCheckTest_ifExistSyokenNo.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllSyonokanri());

    }

    @Test
    public void testIfExistSyokenNo_A1() {
        exBooleanEquals(SyokenNoCheck.ifExistSyokenNo("66808123459"), false, "チェック結果");
    }

    @Test
    public void testIfExistSyokenNo_A2() {
        exBooleanEquals(SyokenNoCheck.ifExistSyokenNo("66808654328"), true, "チェック結果");
    }

}
