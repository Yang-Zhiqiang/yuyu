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
 * オーソリ状況チェックのメソッド {@link CheckAuthoriJk#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckAuthoriJkTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791112253";

    private final static String mosNo5 = "791112261";

    private final static String mosNo6 = "791112279";

    private final static String mosNo7 = "791112287";

    private final static String mosNo8 = "791112295";

    private final static String mosNo9 = "791112303";

    private final static String fileName = "UT_SP_単体テスト仕様書_オーソリ状況チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckAuthoriJk checkAuthoriJk;

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
            testDataAndTblMap = testDataMaker.getInData(CheckAuthoriJkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

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
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0071", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "オーソリ状況がオーソリ依頼中です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0097", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "初回保険料のオーソリがＮＧとなっています。Ｈ２７．　５．２９までに入金が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0097", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "初回保険料のオーソリがＮＧとなっています。Ｈ２７．　５．２９までに入金が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0097", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "初回保険料のオーソリがＮＧとなっています。Ｈ２７．　６．３０までに入金が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0097", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "初回保険料のオーソリがＮＧとなっています。Ｈ２７．　７．３１までに入金が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkAuthoriJk.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

}
