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
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 脱退情報設定クラスのメソッド {@link SetDattai#exec(KhozenCommonParam,SetDattaiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetDattaiTest_exec {

    @Inject
    private SetDattaiExecUiBeanParamImpl setDattaiExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_脱退情報設定";

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
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        setDattaiExecUiBeanParamImpl.setSyono("60806000011");
        setDattaiExecUiBeanParamImpl.setVdtumukbn(C_UmuKbn.NONE);
        setDattaiExecUiBeanParamImpl.setVdtdattairiyuukbn(C_DattairiyuuKbn.BLNK);
        SetDattai setDattai = new SetDattai();
        boolean result = setDattai.exec(khozenCommonParam, setDattaiExecUiBeanParamImpl);

        exStringEquals(setDattaiExecUiBeanParamImpl.getSyono(), "60806000011", "証券番号");
        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtumukbn(), C_UmuKbn.NONE, "（脱退情報）有無区分");
        exDateEquals(setDattaiExecUiBeanParamImpl.getVdtdattaisyoriymd(), null, "脱退処理日");
        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtdattairiyuukbn(), C_DattairiyuuKbn.BLNK, "脱退理由区分");
        exStringEquals(setDattaiExecUiBeanParamImpl.getVdtcomment(), null, "コメント");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        setDattaiExecUiBeanParamImpl.setSyono("60806000022");

        SetDattai setDattai = new SetDattai();
        boolean result = setDattai.exec(khozenCommonParam, setDattaiExecUiBeanParamImpl);

        exStringEquals(setDattaiExecUiBeanParamImpl.getSyono(), "60806000022", "証券番号");
        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtumukbn(), C_UmuKbn.ARI, "（脱退情報）有無区分");
        exDateEquals(setDattaiExecUiBeanParamImpl.getVdtdattaisyoriymd(), BizDate.valueOf(20181019), "脱退処理日");
        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtdattairiyuukbn(), C_DattairiyuuKbn.CSSKOUHURIIRHUBI, "脱退理由区分");
        exStringEquals(setDattaiExecUiBeanParamImpl.getVdtcomment(), "コメント（１２４桁）コメント（１２４桁）", "コメント");
        exBooleanEquals(result, true, "処理結果");
    }
}
