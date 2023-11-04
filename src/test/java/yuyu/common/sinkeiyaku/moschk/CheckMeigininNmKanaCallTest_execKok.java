package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * カナ名義人チェック呼出しクラスのメソッド {@link CheckMeigininNmKanaCall#execKok(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMeigininNmKanaCallTest_execKok {

    @Inject
    private CheckMeigininNmKanaCall checkMeigininNmKanaCall;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    private final static String mosNo6 = "791112279";

    private final static String mosNo7 = "791112287";

    private final static String mosNo8 = "791112295";

    private final static String fileName = "UT_SP_単体テスト仕様書_カナ名義人チェック呼出し";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckMeigininNmKanaCallTest_execKok.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExecKok_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        boolean result = checkMeigininNmKanaCall.execKok( mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0046", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "顧客名（カナ）が正しくありません。", "不備メッセージ");
        exBooleanEquals(result, false, "結果");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExecKok_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        boolean result = checkMeigininNmKanaCall.execKok(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");
        exBooleanEquals(result, true, "結果");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExecKok_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        boolean result = checkMeigininNmKanaCall.execKok(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");
        exBooleanEquals(result, true, "結果");
    }
}
