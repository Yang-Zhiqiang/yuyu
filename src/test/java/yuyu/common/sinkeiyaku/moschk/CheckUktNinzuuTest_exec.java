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
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 受取人人数整合性チェッククラスのメソッド {@link CheckUktNinzuu#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckUktNinzuuTest_exec {

    private final static String syoNo1 = "791112220";

    private final static String syoNo2 = "791112238";

    private final static String syoNo3 = "791112246";

    private final static String syoNo4 = "791112253";

    private final static String syoNo5 = "791112261";

    private final static String syoNo6 = "791112279";


    private final static String fileName = "UT_SP_単体テスト仕様書_受取人人数整合性チェック";

    private final static String sheetName = "テストデータ";


    @Inject
    private CheckUktNinzuu CheckUktNinzuu;

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
            testDataAndTblMap = testDataMaker.getInData(CheckUktNinzuuTest_exec.class, fileName, sheetName);
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

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150625131313000");
        CheckUktNinzuu.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0184", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "申込点検で死亡受取人の確認結果が入力されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150625131313000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150625131313000");
        CheckUktNinzuu.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");

        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0184", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "申込点検で死亡受取人の確認結果が入力されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150625131313000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150625131313000");
        CheckUktNinzuu.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsg.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0191", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不要な死亡受取人の確認結果が入力されています。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150625131313000", "業務用更新時間");

    }
    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo4);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150625131313000");
        CheckUktNinzuu.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_B2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo5);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150625131313000");
        CheckUktNinzuu.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo6);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150625131313000");
        CheckUktNinzuu.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

}
