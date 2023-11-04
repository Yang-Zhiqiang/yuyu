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
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 受取人分割割合チェッククラスのメソッド {@link CheckUktBnWari#exec(MosnaiCheckParam, List<HT_Uketorinin>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckUktBnWariTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_受取人分割割合チェック";

    private final static String sheetName = "テストデータ";

    private final static String syoNo1 = "791112220";

    private final static String syoNo2 = "791112238";

    private final static String syoNo3 = "791112246";

    private final static String syoNo4 = "791112253";

    private final static String syoNo5 = "791112261";

    @Inject
    private CheckUktBnWari checkUktBnWari;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckUktBnWariTest_exec.class, fileName, sheetName);
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
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo1);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkUktBnWari.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0008", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人の分割割合が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo2);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkUktBnWari.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo3);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkUktBnWari.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo4);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkUktBnWari.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo5);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkUktBnWari.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

}
