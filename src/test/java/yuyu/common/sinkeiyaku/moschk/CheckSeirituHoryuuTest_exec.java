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
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 成立保留チェッククラスのメソッド {@link CheckSeirituHoryuu#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckSeirituHoryuuTest_exec {

    @Inject
    private CheckSeirituHoryuu checkSeirituHoryuu;

    private final static String mosNo1 = "861110005";
    private final static String mosNo2 = "861110013";
    private final static String mosNo3 = "861110021";
    private final static String mosNo5 = "861110047";
    private final static String mosNo6 = "861110054";
    private final static String mosNo8 = "861110070";
    private final static String mosNo9 = "861110088";
    private final static String mosNo10 = "861110096";
    private final static String mosNo12 = "861110104";
    private final static String mosNo13 = "861110112";
    private final static String mosNo15 = "861110138";
    private final static String mosNo16 = "861110146";
    private final static String mosNo17 = "861110153";
    private final static String mosNo18 = "861110161";
    private final static String mosNo22 = "861110203";
    private final static String mosNo23 = "861110211";
    private final static String mosNo24 = "861110229";
    private final static String mosNo25 = "861110237";
    private final static String mosNo26 = "861110245";
    private final static String mosNo27 = "861110252";
    private final static String mosNo28 = "861110260";
    private final static String mosNo29 = "861110278";
    private final static String mosNo30 = "861110286";
    private final static String mosNo31 = "870000791";
    private final static String mosNo32 = "870001070";
    private final static String mosNo33 = "870001088";
    private final static String mosNo34 = "870001112";
    private final static String mosNo35 = "870001120";
    private final static String mosNo36 = "870001138";
    private final static String mosNo37 = "870001146";
    private final static String mosNo38 = "870001153";
    private final static String mosNo39 = "870001161";
    private final static String mosNo40 = "870001179";
    private final static String mosNo41 = "860000074";
    private final static String mosNo42 = "860000066";
    private final static String mosNo43 = "860000058";

    private final static String fileName = "UT_SP_単体テスト仕様書_成立保留チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSeirituHoryuuTest_exec.class, fileName, sheetName);
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
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo1, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "WHA1003", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "成立保留希望入力があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_B1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo2, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0180", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "告知書入力に不備コメントがあります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);

        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_C1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo3, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0181", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "報状入力に不備コメントがあります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_C2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_F1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo6, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0144", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ＬＩＮＣ照会中契約です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_F2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo9, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0045", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ＬＩＮＣ確認結果の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_F3() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo16);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo16, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0143", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ＬＩＮＣ照会送信待ち契約です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_F4() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo17);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_F5() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo18);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(111)
    public void testExec_F6() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo43);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20150610161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo43, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC0144", "不備メッセージ");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "ＬＩＮＣ照会中契約です。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_G1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 3, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo5, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1121", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "払込経路がクレジットカード扱いの場合、" +
            "１，０００万円以上は取り扱えません。払込経路を口座振替扱いに変更してください。",
            "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(1).getMosno(), mosNo5, "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "EHC1122", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "初回保険料払込経路がクレジットカード扱いの場合、"
            + "併徴額１，０００万円以上の一括要Ｐ併徴特認はできません。"
            + "一括要Ｐ省略特認するか、初回保険料払込経路を口座振替扱いに変更してください。",
            "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");

        exStringEquals(hubiMsgLst.get(2).getMosno(), mosNo5, "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "EHC1124", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "クレジットカードが登録されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_G2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_G3() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo15);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_G4() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo22);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_G5() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo23);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_G6() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo24);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(173)
    public void testExec_G7() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo42);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_H1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo25);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo25, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1123", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "クレジットカードが有効ではありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_H2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo26);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_H3() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo27);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo27, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1124", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "クレジットカードが登録されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_H4() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo28);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo28, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1124", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "クレジットカードが登録されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_H5() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo29);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo29, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1124", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "クレジットカードが登録されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_H6() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo30);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_I1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo31);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo31, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1125", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "オーソリ確認日が入力されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_I2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo32);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_I3() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo33);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_I4() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo34);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_I5() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo35);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_J1() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo36);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 1, "不備メッセージリスト件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo36, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EHC1126", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "カードブランドが入力されていません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191210161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_J2() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo37);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_J3() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo38);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_J4() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo39);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_J5() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo40);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_J6() {
        MosnaiCheckParam pMP = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo41);

        pMP.setDataSyoriControl(syoriCTL);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20191210161400000");
        checkSeirituHoryuu.exec(pMP);

        List<HT_HubiMsg> hubiMsgLst = pMP.getListHubiMsg();

        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージリスト件数");
    }
}
