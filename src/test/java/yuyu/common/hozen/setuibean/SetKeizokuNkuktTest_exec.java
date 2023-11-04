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
import yuyu.def.classification.C_Tdk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 継続年金受取人情報設定のメソッド {@link SetKeizokuNkukt#exec(KhozenCommonParam, SetKeizokuNkuktExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKeizokuNkuktTest_exec {

    private final static String syoNo1 = "17806000013";

    private final static String syoNo2 = "17806000024";

    @Inject
    private SetKeizokuNkuktExecUiBeanParamImpl setKeizokuNkuktExecUiBeanParamImpl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_継続年金受取人情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKeizokuNkuktTest_exec.class, fileName, sheetName);
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

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKeizokuNkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetKeizokuNkuktExecUiBeanParamImpl.class);

        setKeizokuNkuktExecUiBeanParamImpl.setSyono(syoNo1);

        boolean keizokuNkukt =SetKeizokuNkukt.exec(khozenCommonParam, setKeizokuNkuktExecUiBeanParamImpl);

        exBooleanEquals(keizokuNkukt, true, "実行結果");

        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getSyono(), syoNo1, "証券番号");
        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknkuktnmkn(), "受取人名（カナ）", "継続年金受取人氏名（カナ）");
        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknkuktnmkj(), "受取人名（漢字）", "継続年金受取人氏名（漢字）");
        exDateEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknenkiuktseiymd(), BizDate.valueOf(20150101), "継続年金受取人生年月日");
        exClassificationEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknenkinukttdk(), C_Tdk.HGU, "継続年金受取人続柄");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKeizokuNkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetKeizokuNkuktExecUiBeanParamImpl.class);

        setKeizokuNkuktExecUiBeanParamImpl.setSyono(syoNo2);

        boolean keizokuNkukt =SetKeizokuNkukt.exec(khozenCommonParam, setKeizokuNkuktExecUiBeanParamImpl);

        exBooleanEquals(keizokuNkukt, true, "実行結果");

        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getSyono(), syoNo2, "証券番号");
        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknkuktnmkn(), "", "継続年金受取人氏名（カナ）");
        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknkuktnmkj(), "", "継続年金受取人氏名（漢字）");
        exDateEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknenkiuktseiymd(), null, "継続年金受取人生年月日");
        exClassificationEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknenkinukttdk(), C_Tdk.BLNK, "継続年金受取人続柄");
    }
}
