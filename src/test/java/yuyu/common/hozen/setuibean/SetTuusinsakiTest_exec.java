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
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通信先情報設定クラスのメソッド {@link SetTuusinsaki#exec(KhozenCommonParam,SetTuusinsakiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTuusinsakiTest_exec {

    @Inject
    private SetTuusinsakiExecUiBeanParamImpl setTuusinsakiExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_通信先情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetTuusinsakiTest_exec.class, fileName, sheetName);
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

        setTuusinsakiExecUiBeanParamImpl.setSyono("12806345672");


        boolean result = SetTuusinsaki.exec(khozenCommonParam, setTuusinsakiExecUiBeanParamImpl);

        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getSyono(), "12806345672", "証券番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinyno(), "1234567", "（通信先情報）通信先郵便番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr1kj(), "山田", "（通信先情報）通信先住所１（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr2kj(), "銀座", "（通信先情報）通信先住所２（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsinadr3kj(), "新区", "（通信先情報）通信先住所３（漢字）");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtssktsintelno(), "0550-123-456", "（通信先情報）通信先電話番号");
        exStringEquals(setTuusinsakiExecUiBeanParamImpl.getVtsskdai2tsintelno(), "0551-123-456", "（通信先情報）第２通信先電話番号");
        exBooleanEquals(result, true, "処理結果");
    }

}
