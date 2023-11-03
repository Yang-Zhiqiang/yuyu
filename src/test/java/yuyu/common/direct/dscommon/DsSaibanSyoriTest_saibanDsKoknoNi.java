package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
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
 * ＤＳ採番処理クラスのメソッド {@link DsSaibanSyori#dsSaibanSyoriKokno()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsSaibanSyoriTest_saibanDsKoknoNi {

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
            testDataAndTblMap = testDataMaker.getInData(DsSaibanSyoriTest_saibanDsKoknoNi.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testSaibanDsKoknoNi_A1() {

        try {
            dsSaibanSyori.saibanDsKokno();
        }catch (BizAppException e) {
            exStringEquals(e.getMessage(), "ＤＳ顧客番号採番処理中にエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }
}
