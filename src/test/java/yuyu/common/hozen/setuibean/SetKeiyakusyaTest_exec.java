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
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tdk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約者情報設定のメソッド {@link SetKeiyakusya#exec(KhozenCommonParam, SetKeiyakusyaExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKeiyakusyaTest_exec {

    private final static String syoNo1 = "12806345672";

    @Inject
    private SetKeiyakusyaExecUiBeanParamImpl setKeiyakusyaExecUiBeanParamImpl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約者情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKeiyakusyaTest_exec.class, fileName, sheetName);
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
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        setKeiyakusyaExecUiBeanParamImpl = SWAKInjector.getInstance(SetKeiyakusyaExecUiBeanParamImpl.class);


        setKeiyakusyaExecUiBeanParamImpl.setSyono(syoNo1);


        boolean keiyakusya = SetKeiyakusya.exec(khozenCommonParam, setKeiyakusyaExecUiBeanParamImpl);

        exBooleanEquals(keiyakusya, true, "実行結果");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getSyono(), syoNo1, "証券番号");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkn(), "カナ", "契約者名（カナ）");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkj(), "山田", "契約者名（漢字）");

        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyknmkjkhukakbn(), C_KjkhukaKbn.KJKHUKA, "契約者名漢字化不可区分");
        exDateEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskykseiymd(), BizDate.valueOf(20151219), "契約者生年月日");
        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskyksei(), C_Kyksei.HJNKYK, "契約者性別");
        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykskkkyktdk(), C_Tdk.HGU, "契約管理契約者続柄");

        exClassificationEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndaiykkbn(), C_HjndaiykKbn.RIJITYOU, "法人代表者役職区分");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndaiyknm(), "理事長", "法人代表者役職名");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndainmkn(), "ヤマダ", "法人代表者名（カナ）");

        exStringEquals(setKeiyakusyaExecUiBeanParamImpl.getVkykshjndainmkj(), "理事長　山田", "法人代表者名（漢字）");
    }
}
