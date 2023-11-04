package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.def.base.manager.BaseDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ採番処理クラスのメソッド {@link DsSaibanSyori#dsSaibanSyoriHenkouSikibetukey()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsSaibanSyoriTest_saibanDsHenkouSikibetukey {

    @Inject
    private DsSaibanSyori dsSaibanSyori;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ採番処理";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsSaibanSyoriTest_saibanDsHenkouSikibetukey.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ009", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test
    @TestOrder(10)
    public void testSaibanDsHenkouSikibetukey_A1() {

        String result = dsSaibanSyori.saibanDsHenkouSikibetukey();

        exStringEquals(result, "000000000000000001", "ＤＳ変更識別キー");
    }
}
