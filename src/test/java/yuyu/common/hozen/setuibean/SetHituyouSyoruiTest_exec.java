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
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 必要書類設定クラスのメソッド {@link SetHituyouSyorui#exec(KhozenCommonParam,SetHituyouSyoruiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHituyouSyoruiTest_exec {

    @Inject
    private SetHituyouSyoruiExecUiBeanParamImpl setHituyouSyoruiExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_必要書類設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHituyouSyoruiTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllKhHituyouSyorui());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {


        boolean result = SetHituyouSyorui.exec(khozenCommonParam, setHituyouSyoruiExecUiBeanParamImpl);

        exStringEquals(setHituyouSyoruiExecUiBeanParamImpl.getVhtysdisphtysyorui(), "", "（必要書類情報）必要書類メッセージ");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        khozenCommonParam.setFunctionId("khmeigihenkou");

        setHituyouSyoruiExecUiBeanParamImpl.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYK);

        setHituyouSyoruiExecUiBeanParamImpl.setHrkkaisuu(C_Hrkkaisuu.TUKI);


        boolean result = SetHituyouSyorui.exec(khozenCommonParam, setHituyouSyoruiExecUiBeanParamImpl);

        exStringEquals(setHituyouSyoruiExecUiBeanParamImpl.getVhtysdisphtysyorui(), "必要書類１", "（必要書類情報）必要書類メッセージ");
        exBooleanEquals(result, true, "処理結果");
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {

        khozenCommonParam.setFunctionId("khmeigihenkou");

        setHituyouSyoruiExecUiBeanParamImpl.setMeigihnkjiyuu(C_Meigihnkjiyuu.KYKSB);

        setHituyouSyoruiExecUiBeanParamImpl.setHrkkaisuu(C_Hrkkaisuu.HALFY);


        setHituyouSyoruiExecUiBeanParamImpl.setDaisennintdkumukbn(C_UmuKbn.ARI);


        boolean result = SetHituyouSyorui.exec(khozenCommonParam, setHituyouSyoruiExecUiBeanParamImpl);

        exStringEquals(setHituyouSyoruiExecUiBeanParamImpl.getVhtysdisphtysyorui(), "必要書類２<br/>必要書類３", "（必要書類情報）必要書類メッセージ");
        exBooleanEquals(result, true, "処理結果");
    }
}
