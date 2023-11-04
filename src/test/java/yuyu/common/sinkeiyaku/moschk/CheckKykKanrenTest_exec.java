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
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約者項目関連チェッククラスのメソッド {@link CheckKykKanren#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKykKanrenTest_exec {

    private final static String syoNo1 = "791112220";

    private final static String syoNo2 = "791112238";

    private final static String syoNo3 = "791112246";

    private final static String syoNo4 = "791112253";

    private final static String syoNo5 = "791112261";

    private final static String syoNo6 = "791112279";

    private final static String syoNo7 = "791112287";

    private final static String syoNo8 = "791112295";

    private final static String syoNo9 = "791112303";

    private final static String syoNo10 = "791112311";

    private final static String syoNo11 = "791112329";

    private final static String syoNo12 = "791112337";

    private final static String syoNo13 = "791112345";

    private final static String syoNo14 = "791112352";

    private final static String syoNo15 = "889800009";

    private final static String fileName = "UT_SP_単体テスト仕様書_契約者項目関連チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private CheckKykKanren checkKykKanren;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckKykKanrenTest_exec.class, fileName, sheetName);
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
    @Transactional
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo1);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0007", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者名（カナ）・契約者名（漢字）・契約者続柄は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo2);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0007", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者名（カナ）・契約者名（漢字）・契約者続柄は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo3);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約者名（カナ）・契約者名（漢字）・契約者続柄は不要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo4);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約者名（カナ）・契約者名（漢字）・契約者続柄は不要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo5);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約者名（カナ）・契約者名（漢字）・契約者続柄は不要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo6);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0124", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者名漢字化不可は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo7);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者名（カナ）・契約者名（漢字）・契約者続柄の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHA0452", "不備メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者と被保険者の性別を確認してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo8);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "契約者名（カナ）・契約者続柄の入力が必要です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo9);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112303", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者名（カナ）・契約者名（漢字）・契約者続柄の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo10);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo11);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112329", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者名（カナ）・契約者名（漢字）・契約者続柄の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(115)
    @Transactional
    public void testExec_A12() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo15);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "被保険者と契約者の性別を確認してください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo12);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo13);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_B3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo14);

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");

        checkKykKanren.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }


}
