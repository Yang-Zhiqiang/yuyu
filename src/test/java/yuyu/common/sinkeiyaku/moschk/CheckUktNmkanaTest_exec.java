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
 * 受取人名（カナ）チェッククラスのメソッド {@link CheckUktNmkana#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckUktNmkanaTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_受取人名（カナ）チェック";

    private final static String sheetName = "テストデータ";

    private final static String mosNo1 = "791112238";

    private final static String mosNo2 = "791112246";

    private final static String mosNo3 = "791112253";

    private final static String mosNo4 = "791112220";

    @Inject
    private CheckUktNmkana checkUktNmkana;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckUktNmkanaTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
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
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkUktNmkana.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkUktNmkana.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkUktNmkana.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkUktNmkana.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();


        exNumericEquals(hubiMsg.size(), 2, "不備メッセージ件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0046", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人名（カナ）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0046", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人名（カナ）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }
}
