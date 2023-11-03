package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ設定クラスのメソッド {@link SetHubiMsg#exec(String, String, C_SekmossakuseiErroutKbn, MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHubiMsgTest_exec_6 {

    @Inject
    private SetHubiMsg setHubiMsg;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        String messageUpper = "";
        String messageLower = "メールアドレスが未入力です。";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.NONE;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "メールアドレスが未入力です。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "";
        String messageLower = "悲観排他制御を開始できませんでした。対象のデータはすでに処理が開始されています。";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.GAMEN;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "悲観排他制御を開始できませんでした。対象のデータはすでに処理が開始されています。",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "";
        String messageLower = "別の担当者によりアップロードされた代理店データが含まれているため、処理できません。　代理店コード=1102001";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.ERRORSHEET;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.ERRORSHEET, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "別の担当者によりアップロードされた代理店データが含まれているため、処理できません",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "。　代理店コード＝１１０２００１", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "";
        String messageLower = "３大疾病保障特約　死亡時に給付金支払が発生する可能性があります。死亡連絡時は請求書類送付の要否について確認してください。ああああああああああいいいいいいいいいい";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.SONOTA;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.SONOTA, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "３大疾病保障特約　死亡時に給付金支払が発生する可能性があります。死亡連絡時は請求",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "書類送付の要否について確認してください。ああああああああああいいいいいいいいいい",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "";
        String messageLower = "３大疾病保障特約　死亡時に給付金支払が発生する可能性があります。死亡連絡時は請求書類送付の要否について確認してください。ああああああああああいいいいいいいいいいう";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.SONOTA;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.SONOTA, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "３大疾病保障特約　死亡時に給付金支払が発生する可能性があります。死亡連絡時は請求",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "書類送付の要否について確認してください。ああああああああああいいいいいいいいいい",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "ＰＡＬあて照会不可のため反社・選択情報が確認できません。索引照会で確認してください";
        String messageLower = "";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.SONOTA;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.SONOTA, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "ＰＡＬあて照会不可のため反社・選択情報が確認できません。索引照会で確認してくださ",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "ＰＡＬでの索引照会不可のため別契約が確認できません。索引照会で確認してください。";
        String messageLower = "受取人と被保険者が異なります。指定代理請求特約解約手続の要否を確認して下さい。";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.SONOTA;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.SONOTA, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "ＰＡＬでの索引照会不可のため別契約が確認できません。索引照会で確認してください。",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "受取人と被保険者が異なります。指定代理請求特約解約手続の要否を確認して下さい。",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        String messageUpper = "受取人と被保険者が異なります。指定代理請求特約解約手続の要否を確認して下さい。";
        String messageLower = "ＰＡＬあて照会不可のため反社・選択情報が確認できません。索引照会で確認してください";
        C_SekmossakuseiErroutKbn sekmossakuseiErroutKbn = C_SekmossakuseiErroutKbn.SONOTA;

        setHubiMsg.exec(messageUpper, messageLower, sekmossakuseiErroutKbn, mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.SONOTA, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "受取人と被保険者が異なります。指定代理請求特約解約手続の要否を確認して下さい。",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "ＰＡＬあて照会不可のため反社・選択情報が確認できません。索引照会で確認してくださ",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }
}
