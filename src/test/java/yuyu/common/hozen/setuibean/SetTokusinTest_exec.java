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
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特伸情報設定クラスのメソッド {@link SetTokusin#exec(KhozenCommonParam,SetTokusinExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTokusinTest_exec {

    @Inject
    private SetTokusinExecUiBeanParamImpl setTokusinExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_特伸情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSonotaTkTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        setTokusinExecUiBeanParamImpl.setSyono("60806000011");
        setTokusinExecUiBeanParamImpl.setVtsumukbn(C_UmuKbn.NONE);
        setTokusinExecUiBeanParamImpl.setVtstokusinkbn(C_TokusinKbn.BLNK);

        boolean result = SetTokusin.exec(khozenCommonParam, setTokusinExecUiBeanParamImpl);

        exStringEquals(setTokusinExecUiBeanParamImpl.getSyono(), "60806000011", "証券番号");
        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtsumukbn(), C_UmuKbn.NONE, "（特伸情報）有無区分");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtshsgymd(), null, "被災害年月日");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtstokusinendymd(), null, "終了年月日");
        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtstokusinkbn(), C_TokusinKbn.BLNK, "特伸区分");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        setTokusinExecUiBeanParamImpl.setSyono("60806000022");
        setTokusinExecUiBeanParamImpl.setVtsumukbn(C_UmuKbn.NONE);
        setTokusinExecUiBeanParamImpl.setVtstokusinkbn(C_TokusinKbn.BLNK);

        boolean result = SetTokusin.exec(khozenCommonParam, setTokusinExecUiBeanParamImpl);

        exStringEquals(setTokusinExecUiBeanParamImpl.getSyono(), "60806000022", "証券番号");
        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtsumukbn(), C_UmuKbn.ARI, "（特伸情報）有無区分");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtshsgymd(), BizDate.valueOf(20181001), "被災害年月日");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtstokusinendymd(), BizDate.valueOf(20181031), "終了年月日");
        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtstokusinkbn(), C_TokusinKbn.HISAIGAI, "特伸区分");
        exBooleanEquals(result, true, "処理結果");
    }
}
