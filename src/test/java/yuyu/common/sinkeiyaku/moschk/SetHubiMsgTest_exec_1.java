package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsijisyoyhKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ設定クラスのメソッド {@link SetHubiMsg#exec(C_KetsrhkosKbn, C_SpKeisanKahiKbn, C_HubisyubetusyousaiKbn, C_SyoruiCdKbn, String, MosnaiCheckParam, C_TknKbn, C_MsgKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHubiMsgTest_exec_1 {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SetHubiMsg setHubiMsg;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_不備メッセージ設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHubiMsgTest_exec_1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("テストデータ1", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(1010)
    public void testExec_A1() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = null;
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(1020)
    public void testExec_A2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(1030)
    public void testExec_A3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0023";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ＥＢＡ００２３", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(1040)
    public void testExec_A4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0023 証";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "証", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(1050)
    public void testExec_A5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0036 悲観排他制御を開始できませんでした。対象のデータはすでに処理が開始されています。";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "悲観排他制御を開始できませんでした。対象のデータはすでに処理が開始されています。",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(1060)
    public void testExec_A6() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "WAF0004 事業所の個別郵便番号が住所の郵便番号と重複しているため、登録できません。郵便番号：1012345　事業所名：あああ";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.WARNING;

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "事業所の個別郵便番号が住所の郵便番号と重複しているため、登録できません。郵便番号",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "：１０１２３４５　事業所名：あああ",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }
    @Test
    @TestOrder(2010)
    public void testExec_B1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.ARI, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getSrhhbkbn(), C_UmuKbn.NONE, "成立保留不備区分");
        exClassificationEquals(syoriCTL.getKhnhbkbn(), C_UmuKbn.NONE, "基本不備区分");
    }

    @Test
    @TestOrder(2020)
    public void testExec_B2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.KANOU;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getSrhhbkbn(), C_UmuKbn.ARI, "成立保留不備区分");
        exClassificationEquals(syoriCTL.getKhnhbkbn(), C_UmuKbn.NONE, "基本不備区分");
    }

    @Test
    @TestOrder(2030)
    public void testExec_B3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KIHON_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getSrhhbkbn(), C_UmuKbn.NONE, "成立保留不備区分");
        exClassificationEquals(syoriCTL.getKhnhbkbn(), C_UmuKbn.ARI, "基本不備区分");
    }

    @Test
    @TestOrder(2040)
    public void testExec_B4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.WARNING;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getSrhhbkbn(), C_UmuKbn.NONE, "成立保留不備区分");
        exClassificationEquals(syoriCTL.getKhnhbkbn(), C_UmuKbn.NONE, "基本不備区分");
    }

    @Test
    @TestOrder(2050)
    public void testExec_B5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KIHON_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getSrhhbkbn(), C_UmuKbn.NONE, "成立保留不備区分");
        exClassificationEquals(syoriCTL.getKhnhbkbn(), C_UmuKbn.NONE, "基本不備区分");
    }


    @Test
    @TestOrder(3010)
    @Transactional
    public void testExec_C1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.NONE;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.WF_HYOUSI;
        String message = "";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exNumericEquals(hubiMsgList.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsgList.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsgList.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgList.get(0).getMessageId(), "", "メッセージＩＤ");
        exStringEquals(hubiMsgList.get(0).getHubimsg(), "", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exClassificationEquals(hubiMsgList.get(0).getHituyousyoruicd(), C_SyoruiCdKbn.WF_HYOUSI, "必要書類コード区分");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinTime(), "20160715111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(3020)
    @Transactional
    public void testExec_C2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0014";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exNumericEquals(hubiMsgList.size(), 2, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsgList.get(1).getMosno(), "791112295", "申込番号");
        exNumericEquals(hubiMsgList.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgList.get(1).getMessageId(), "", "メッセージＩＤ");
        exStringEquals(hubiMsgList.get(1).getHubimsg(), "ＥＢＡ００１４", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgList.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.SSEIGENHUBI, "不備種別詳細区分");
        exClassificationEquals(hubiMsgList.get(1).getHituyousyoruicd(), C_SyoruiCdKbn.BLNK, "必要書類コード区分");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(1).getGyoumuKousinTime(), "20160715111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(3030)
    @Transactional
    public void testExec_C3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.TUUSANGENDOOVER;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0014 指";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exNumericEquals(hubiMsgList.size(), 3, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsgList.get(2).getMosno(), "791112303", "申込番号");
        exNumericEquals(hubiMsgList.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgList.get(2).getMessageId(), "EBA0014", "メッセージＩＤ");
        exStringEquals(hubiMsgList.get(2).getHubimsg(), "指", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgList.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.TUUSANGENDOOVER, "不備種別詳細区分");
        exClassificationEquals(hubiMsgList.get(2).getHituyousyoruicd(), C_SyoruiCdKbn.BLNK, "必要書類コード区分");
        exStringEquals(hubiMsgList.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(2).getGyoumuKousinTime(), "20160715111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(3040)
    @Transactional
    public void testExec_C4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KIHON_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SPHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0014 指定された条件に合致する帳票は存在しません。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exNumericEquals(hubiMsgList.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsgList.get(0).getMosno(), "791112311", "申込番号");
        exNumericEquals(hubiMsgList.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgList.get(0).getMessageId(), "KBA0014", "メッセージＩＤ");
        exStringEquals(hubiMsgList.get(0).getHubimsg(), "（特認済）指定された条件に合致する帳票は存在しません。", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.SPHUBI, "不備種別詳細区分");
        exClassificationEquals(hubiMsgList.get(0).getHituyousyoruicd(), C_SyoruiCdKbn.BLNK, "必要書類コード区分");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinTime(), "20160715111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(3050)
    @Transactional
    public void testExec_C5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.WARNING;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANHUKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SEIYMDHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EBA0014 指定された条件に合致する帳票は存在しません。";
        C_TknKbn tknKbn = C_TknKbn.KANOU;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exNumericEquals(hubiMsgList.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsgList.get(0).getMosno(), "791112329", "申込番号");
        exNumericEquals(hubiMsgList.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgList.get(0).getMessageId(), "TBA0014", "メッセージＩＤ");
        exStringEquals(hubiMsgList.get(0).getHubimsg(), "【特認可能】指定された条件に合致する帳票は存在しません。", "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsgList.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.SEIYMDHUBI, "不備種別詳細区分");
        exClassificationEquals(hubiMsgList.get(0).getHituyousyoruicd(), C_SyoruiCdKbn.BLNK, "必要書類コード区分");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(0).getGyoumuKousinTime(), "20160715111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(4010)
    @Transactional
    public void testExec_D1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.NONE, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.YOU, "決定指示書要否区分");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(0), "決定保留不備があるため、再決定が必要です。", "決定指示ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(0), "WHC0018", "決定指示ＭＳＧＩＤ");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧ件数");
    }

    @Test
    @TestOrder(4020)
    @Transactional
    public void testExec_D2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNotNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 1, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.NONE, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.YOU, "決定指示書要否区分");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(0), "決定保留不備があるため、再決定が必要です。", "決定指示ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(0), "WHC0018", "決定指示ＭＳＧＩＤ");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "条件付決定が取消されました。申込書入力にて契約内容を条件付前の状態に変更してください。", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(4030)
    @Transactional
    public void testExec_D3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 1, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.NONE, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.YOU, "決定指示書要否区分");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(0), "決定保留不備があるため、再決定が必要です。", "決定指示ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(0), "WHC0018", "決定指示ＭＳＧＩＤ");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "条件付決定が取消されました。申込書入力にて契約内容を条件付前の状態に変更してください。", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(4040)
    @Transactional
    public void testExec_D4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNotNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 3, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 2, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.NONE, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.YOU, "決定指示書要否区分");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(0), "決定保留不備があるため、再決定が必要です。", "決定指示ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(0), "WHC0018", "決定指示ＭＳＧＩＤ");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "条件付決定が取消されました。申込書入力にて契約内容を条件付前の状態に変更してください。", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(4050)
    @Transactional
    public void testExec_D5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.BLNK, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.HUYOU, "決定指示書要否区分");
        exNumericEquals(mosnaiCheckParam.getListKetteiSijiMsg().size(), 0, "決定指示ＭＳＧ件数");
        exNumericEquals(mosnaiCheckParam.getListKetteiSijiMsgId().size(), 0, "決定指示ＭＳＧＩＤ件数");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧ件数");
    }

    @Test
    @TestOrder(4060)
    @Transactional
    public void testExec_D6() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.SPKEISANKA;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = "EAC0007 抽出条件を設定してください。";
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.BLNK, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.HUYOU, "決定指示書要否区分");
        exNumericEquals(mosnaiCheckParam.getListKetteiSijiMsg().size(), 0, "決定指示ＭＳＧ件数");
        exNumericEquals(mosnaiCheckParam.getListKetteiSijiMsgId().size(), 0, "決定指示ＭＳＧＩＤ件数");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧ件数");
    }

    @Test
    @TestOrder(5010)
    @Transactional
    public void testExec_E1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.MISETTEI;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = null;
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000012");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180104160913824");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
    }

    @Test
    @TestOrder(5020)
    @Transactional
    public void testExec_E2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.MISETTEI;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = null;
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000020");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180104160913824");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANHUKA, "決定保留時ＳＰ計算可否区分");
    }

    @Test
    @TestOrder(5030)
    @Transactional
    public void testExec_E3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        C_SpKeisanKahiKbn spKeisanKahiKbn = C_SpKeisanKahiKbn.MISETTEI;
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn = C_HubisyubetusyousaiKbn.SSEIGENHUBI;
        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;
        String message = null;
        C_TknKbn tknKbn = C_TknKbn.SUMI;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("790000038");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180104160913824");

        setHubiMsg.exec(ketsrhkosKbn, spKeisanKahiKbn, hubisyubetusyousaiKbn, syoruiCdKbn, message, mosnaiCheckParam,
            tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");
    }

}
