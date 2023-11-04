package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 新契約共通 新契約不備一覧（ＮＩＴ）編集の新契約不備一覧編集メソッド {@link EditSkHubiItiranNit#editSkHubiItiran((int, String, String, String, String))}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class EditSkHubiItiranNitTest_editSkHubiItiran {

    @Inject
    private EditSkHubiItiranNit editSkHubiItiranNit;

    @Test
    @TestOrder(10)
    public void testEditSkHubiItiran_A1() {

        int idx = 5;
        String skhubikoumoku = "";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, false, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");

    }

    @Test
    @TestOrder(20)
    public void testEditSkHubiItiran_A2() {

        int idx = 0;
        String skhubikoumoku = "";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";

        boolean keizokuEditKahi = true;
        for (int i = 0; i < 6; i++) {

            keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);
        }

        exBooleanEquals(keizokuEditKahi, false, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡１＞＞\r\n【区分】【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "＜＜不備連絡１＞＞\r\n【区分】【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "＜＜不備連絡１＞＞\r\n【区分】【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "＜＜不備連絡１＞＞\r\n【区分】【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "＜＜不備連絡１＞＞\r\n【区分】【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[4]");

    }

    @Test
    @TestOrder(30)
    public void testEditSkHubiItiran_A3() {

        int idx = 1;
        String skhubikoumoku = "連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、名義氏名　字体確認1";
        String skhubinaiyou = "名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認";
        String skseibisijinaiyou = "連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）";
        String skrenrakujikou = "記入もれ、フリガナ　記入もれ、生年月日　記入もれ、性別　記入もれ";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡２＞＞\r\n【区分】連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、"
            + "名義氏名　字体確認1【理由】名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、"
            + "性別　確認【依頼内容】連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）\r\n【連絡事項】記入もれ、フリガナ　記入もれ、生年月日　記入もれ、"
            + "性別　記入もれ", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(40)
    public void testEditSkHubiItiran_A4() {

        int idx = 2;
        String skhubikoumoku = "連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、名義氏名　字体確認１";
        String skhubinaiyou = "名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認";
        String skseibisijinaiyou = "連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）";
        String skrenrakujikou = "記入もれ、フリガナ　記入もれ、生年月日　記入もれ、性別　記入もれ１あ";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡３＞＞\r\n【区分】連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、"
            + "名義氏名　字体確認１【理由】名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、"
            + "性別　確認【依頼内容】連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）\r\n【連絡事項】記入もれ、フリガナ　記入もれ、生年月日　記入もれ、"
            + "性別　記入もれ１", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "あ", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(50)
    public void testEditSkHubiItiran_A5() {

        int idx = 3;
        String skhubikoumoku = "連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、名義氏名　字体確認1";
        String skhubinaiyou = "名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認";
        String skseibisijinaiyou = "連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）";
        String skrenrakujikou = "記入もれ1フリガナ　記入もれ、生年月日　記入もれ、性別　記入もれ";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡４＞＞\r\n【区分】連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、"
            + "名義氏名　字体確認1【理由】名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、"
            + "性別　確認【依頼内容】連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）\r\n【連絡事項】記入もれ1フリガナ　記入もれ、生年月日　記入もれ、"
            + "性別　記入もれ", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(60)
    public void testEditSkHubiItiran_A6() {

        int idx = 4;
        String skhubikoumoku = "連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、名義氏名　字体確認1、"
            + "アルファベット表示　確認（カナ）、名義氏名　字体確認（申込書≠補記）、連絡事項欄に記載のとおり、誤記入（年のみ）、"
            + "カナ表示　確認（１５文字超）、名義氏名　字体確認1、アルファベット表示　確認（カナ）、名義氏名　字体確認（申込書≠補記）、";
        String skhubinaiyou = "名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認、"
            + "名義氏名　字体確認（同時申込相違）、お仕事の内容　記入もれ、現住所　様方住所、名義氏名　字体確認、アルファベット表示　確認、"
            + "外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認、名義氏名　字体確認（同時申込相違）、お仕事の内容　記入もれ、"
            + "現住所　様方住所、名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認、"
            + "名義氏名　字体確認（同時申込相違）、お仕事の内容　記入もれ、現住所　様方住所";
        String skseibisijinaiyou = "連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）、名義氏名　字体確認（選択ＡＢＣ読み替え）、"
            + "お仕事の内容　記入もれ（会社員・公務員・役員）、現住所　記入もれ、電話番号　確認、連絡事項に記載のとおり（汎用入力）、"
            + "アルファベット表示　確認（カナ）、名義氏名　字体確認（選択ＡＢＣ読み替え）、お仕事の内容　記入もれ（会社員・公務員・役員）、"
            + "現住所　記入もれ、電話番号　確認、連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）、名義氏名　字体確認（選択ＡＢＣ読み替え）、"
            + "お仕事の内容　記入もれ（会社員・公務員・役員）、現住所　記入もれ、電話番号　確認";
        String skrenrakujikou = "記入もれフリガナ　記入もれ、生年月日　記入もれ、性別　記入もれ名義氏名　字体確認（選択ＡＢ漢字不可）、"
            + "名義氏名　字体確認（読み替え文字）、お仕事の内容　記入もれ（その他）、被保険者からみた続柄　確認、記入もれフリガナ　記入もれ、"
            + "生年月日　記入もれ、性別　記入もれ名義氏名　字体確認（選択ＡＢ漢字不可）、名義氏名　字体確認（読み替え文字）、"
            + "お仕事の内容　記入もれ（その他）、被保険者からみた続柄　確認、記入もれフリガナ　記入もれ、生年月日　記入もれ、"
            + "性別　記入もれ名義氏名　字体確認（選択ＡＢ漢字不可）、名義氏名　字体確認（読み替え文字）、お仕事の内容　記入もれ（その他）、被保険者からみた続柄　確認";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, false, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡５＞＞\r\n【区分】連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、"
            + "名義氏名　字体確認1、アルファベット表示　確認（カナ）、名義氏名　字体確認（申込書≠補記）、連絡事項欄に記載のとおり、誤記入（年のみ）、カナ表示　確認（１５文字超）、"
            + "名義氏名　字体確認1、アルファベット表示　確認（カナ）、名義氏名　字体確認（申込書≠補記）、【理由】名義氏名　字体確認、アルファベット", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、性別　確認、名義氏名　字体確認（同時申込相違）、"
            + "お仕事の内容　記入もれ、現住所　様方住所、名義氏名　字体確認、アルファベット表示　確認、外国人契約　確認、名義氏名　字体確認（同時申込相違）、"
            + "性別　確認、名義氏名　字体確認（同時申込相違）、お仕事の内容　記入もれ、現住所　様方住所、名義氏名　字体確認、アルファベット表示　確認、外国人契", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "約　確認、名義氏名　字体確認（同時申込相違）、性別　確認、名義氏名　字体確認（同時申込相違）、お仕事の内容　記入もれ、"
            + "現住所　様方住所【依頼内容】連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）、名義氏名　字体確認（選択ＡＢＣ読み替え）、"
            + "お仕事の内容　記入もれ（会社員・公務員・役員）、現住所　記入もれ、電話番号　確認、連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "（カナ）、名義氏名　字体確認（選択ＡＢＣ読み替え）、お仕事の内容　記入もれ（会社員・公務員・役員）、現住所　記入もれ、"
            + "電話番号　確認、連絡事項に記載のとおり（汎用入力）、アルファベット表示　確認（カナ）、名義氏名　字体確認（選択ＡＢＣ読み替え）、お仕事の内容　記入もれ（会社員・公務員・役員）、"
            + "現住所　記入もれ、電話番号　確認\r\n【連絡事項】記入もれフリガナ　記入もれ、生年月日　記入もれ、性別　記入も", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "れ名義氏名　字体確認（選択ＡＢ漢字不可）、名義氏名　字体確認（読み替え文字）、お仕事の内容　記入もれ（その他）、"
            + "被保険者からみた続柄　確認、記入もれフリガナ　記入もれ、生年月日　記入もれ、性別　記入もれ名義氏名　字体確認（選択ＡＢ漢字不可）、名義氏名　字体確認（読み替え文字）、"
            + "お仕事の内容　記入もれ（その他）、被保険者からみた続柄　確認、記入もれフリガナ　記入もれ、生年月日　記入もれ、性別　記入も", "不備状況配列[4]");
    }

    @Test
    @TestOrder(70)
    public void testEditSkHubiItiran_A7() {

        int idx = 0;
        String skhubikoumoku = "連絡事項欄に記載のとおり、誤記入（年のみ）、カ";
        String skhubinaiyou = "連絡事項欄に記載のとおり、誤記入（年のみ）1、カ";
        String skseibisijinaiyou = "連絡事項欄に記載のとおり、誤記入（年のみ1\r\n";
        String skrenrakujikou = "";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡１＞＞\r\n【区分】連絡事項欄に記載のとおり、誤記入（年のみ）、カ"
            + "【理由】連絡事項欄に記載のとおり、誤記入（年のみ）1、カ【依頼内容】連絡事項欄に記載のとおり、誤記入（年のみ1\r\n\r\n【連絡事項】", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(80)
    public void testEditSkHubiItiran_A8() {

        int idx = 1;
        String skhubikoumoku = "\r\n\r\n\r\n\r\n\r\n\r\n";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡２＞＞\r\n【区分】\r\n\r\n\r\n\r\n\r\n\r\n【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(90)
    public void testEditSkHubiItiran_A9() {

        int idx = 2;
        String skhubikoumoku = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡３＞＞\r\n【区分】\r\n\r\n\r\n\r\n\r\n\r\n\r\n【理由】【依頼内容】\r\n【連絡事項】", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(100)
    public void testEditSkHubiItiran_A10() {

        int idx = 3;
        String skhubikoumoku = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, true, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡４＞＞\r\n【区分】\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n【理由】【依頼内容】\r\n", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "【連絡事項】", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "", "不備状況配列[4]");
    }

    @Test
    @TestOrder(110)
    public void testEditSkHubiItiran_A11() {

        int idx = 0;
        String skhubikoumoku = "";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "あああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああいう";

        boolean keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(idx, skhubikoumoku, skhubinaiyou, skseibisijinaiyou, skrenrakujikou);

        exBooleanEquals(keizokuEditKahi, false, "継続編集可否");
        exNumericEquals(editSkHubiItiranNit.getHubijks().length,5, "不備状況配列件数");
        exStringEquals(editSkHubiItiranNit.getHubijks()[0], "＜＜不備連絡１＞＞\r\n【区分】【理由】【依頼内容】\r\n【連絡事項】"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ", "不備状況配列[0]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[1], "ああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ", "不備状況配列[1]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[2], "ああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ", "不備状況配列[2]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[3], "ああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ", "不備状況配列[3]");
        exStringEquals(editSkHubiItiranNit.getHubijks()[4], "ああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああ"
            + "あああああああああああああああああああああああああああああああああああああああああああああああああああああああああい", "不備状況配列[4]");
    }
}
