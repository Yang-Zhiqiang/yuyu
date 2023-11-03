package yuyu.common.hozen.setuibean;

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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 被保険者情報設定クラスのメソッド {@link SetHihokensya#exec(KhozenCommonParam,SetHihokensyaExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHihokensyaTest_exec {

    @Inject
    private SetHihokensyaExecUiBeanParamImpl setHihokensyaExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_被保険者情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHihokensyaTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        setHihokensyaExecUiBeanParamImpl.setSyono("12806345672");

        boolean result = SetHihokensya.exec(khozenCommonParam, setHihokensyaExecUiBeanParamImpl);

        exStringEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkn(), "カナ", "（被保険者情報）被保険者名（カナ）");
        exStringEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkj(), "山田", "（被保険者情報）被保険者名（漢字）");
        exClassificationEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkjkhukakbn(), C_KjkhukaKbn.KJKHUKA, "（被保険者情報）被保険者名漢字化不可区分");
        exDateEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknseiymd(), BizDate.valueOf("20151222"), "（被保険者情報）被保険者生年月日");
        exClassificationEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknsei(), C_Hhknsei.MALE, "（被保険者情報）被保険者性別");
        exBooleanEquals(result, true, "処理結果");
    }

}
