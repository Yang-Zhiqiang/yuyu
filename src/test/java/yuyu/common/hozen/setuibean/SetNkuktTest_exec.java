package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金受取人情報設定クラスのメソッド {@link SetNkukt#exec(KhozenCommonParam,SetNkuktExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetNkuktTest_exec {

    @Inject
    private SetNkuktExecUiBeanParamImpl setNkuktExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書_年金受取人情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetNkuktTest_exec.class, fileName, sheetName);
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
    @Transactional
    public void testExec_A1() {

        setNkuktExecUiBeanParamImpl.setSyono("12806345672");
        boolean result = SetNkukt.exec(khozenCommonParam, setNkuktExecUiBeanParamImpl);

        exStringEquals(setNkuktExecUiBeanParamImpl.getSyono(), "12806345672", "証券番号");
        exClassificationEquals(setNkuktExecUiBeanParamImpl.getVnkuknenkinuktkbn(), C_UktKbn.BLNK, "（年金受取人情報）年金受取人区分");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        setNkuktExecUiBeanParamImpl.setSyono("12806345683");
        boolean result = SetNkukt.exec(khozenCommonParam, setNkuktExecUiBeanParamImpl);

        exStringEquals(setNkuktExecUiBeanParamImpl.getSyono(), "12806345683", "証券番号");
        exClassificationEquals(setNkuktExecUiBeanParamImpl.getVnkuknenkinuktkbn(), C_UktKbn.HHKN, "（年金受取人情報）年金受取人区分");
        exBooleanEquals(result, true, "処理結果");
    }
}
