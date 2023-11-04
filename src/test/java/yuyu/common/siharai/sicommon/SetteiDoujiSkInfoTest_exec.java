package yuyu.common.siharai.sicommon;

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
import yuyu.common.siharai.siview.SiSetUiBeanSetSkKihonKanriUiBeanParam;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 同時請求情報設定のメソッド{@link SetteiDoujiSkInfo#exec(String,String,SiSetUiBeanSetSkKihonKanriUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetteiDoujiSkInfoTest_exec {
    @Inject
    private SetteiDoujiSkInfo setteiDoujiSkInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_同時請求情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetteiDoujiSkInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getSkKihon("SN001", "11810111299"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        SiSetUiBeanSetSkKihonKanriUiBeanParamImpl siSetUiBeanSetSkKihonKanriUiBeanParam = SWAKInjector
            .getInstance(SiSetUiBeanSetSkKihonKanriUiBeanParamImpl.class);
        boolean result = setteiDoujiSkInfo.exec(null, "11810111299", siSetUiBeanSetSkKihonKanriUiBeanParam);
        exBooleanEquals(result, false, "戻り値");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        SiSetUiBeanSetSkKihonKanriUiBeanParamImpl siSetUiBeanSetSkKihonKanriUiBeanParam = SWAKInjector
            .getInstance(SiSetUiBeanSetSkKihonKanriUiBeanParamImpl.class);
        boolean result = setteiDoujiSkInfo.exec("SN001", null, siSetUiBeanSetSkKihonKanriUiBeanParam);
        exBooleanEquals(result, false, "戻り値");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        boolean result = setteiDoujiSkInfo.exec("SN001", "11810111299", null);
        exBooleanEquals(result, false, "戻り値");
    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        SiSetUiBeanSetSkKihonKanriUiBeanParamImpl siSetUiBeanSetSkKihonKanriUiBeanParam = SWAKInjector
            .getInstance(SiSetUiBeanSetSkKihonKanriUiBeanParamImpl.class);
        boolean result = setteiDoujiSkInfo.exec("SN001", "11810111299", siSetUiBeanSetSkKihonKanriUiBeanParam);
        exBooleanEquals(result, false, "戻り値");
    }

    @Test
    @TestOrder(40)
    public void testExec_B2() {
        SiSetUiBeanSetSkKihonKanriUiBeanParamImpl siSetUiBeanSetSkKihonKanriUiBeanParam = SWAKInjector
            .getInstance(SiSetUiBeanSetSkKihonKanriUiBeanParamImpl.class);
        boolean result = setteiDoujiSkInfo.exec("SN001", "11810111303", siSetUiBeanSetSkKihonKanriUiBeanParam);
        exBooleanEquals(result, true, "戻り値");

    }
}
