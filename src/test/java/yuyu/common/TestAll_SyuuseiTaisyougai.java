package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.base.format.BizDateFormatUtilTest_All;
import yuyu.common.base.format.DefaultDateFormatterTest_All;
import yuyu.common.base.format.FixedDateFormatterTest_All;
import yuyu.common.biz.bzcommon.BizDateUtilTest_All;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuTest_exec;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtilTest_convKbn;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtilTest_All;
import yuyu.common.biz.bzcommon.CheckDataSansyouTest_execCheck;
import yuyu.common.biz.bzcommon.CheckKanaNmTest_All;
import yuyu.common.biz.bzcommon.CheckKouzaNoTest_All;
import yuyu.common.biz.bzcommon.CheckTelNoTest_isCheckOK;
import yuyu.common.biz.bzcommon.EditSecurityKmTest_All;
import yuyu.common.biz.bzcommon.HenkanTuukaTest_All;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanTest_exec;
import yuyu.common.biz.bzcommon.MathUtilTest_powDecimal;
import yuyu.common.biz.bzcommon.SetHokenNenreiTest_exec;
import yuyu.common.biz.bzcommon.SetNenreiTest_exec;
import yuyu.common.biz.bzcommon.SkjStringUtilTest;
import yuyu.common.biz.bzcommon.TakeiyakuTuusanInfoParamTest_Properties;
import yuyu.common.biz.bzcommon.TuusanKeiyakuInfoParamTest_Properties;
import yuyu.common.biz.bznayose.PALKykKousinTorikesiTest_exec;
import yuyu.common.biz.interf.ConvKbnATest_getCodeCnv;
import yuyu.common.biz.interf.ConvKbnBTest_getCodeCnv;
import yuyu.common.biz.interf.ConvKbnCTest_getCodeCnv;
import yuyu.common.biz.interf.ConvZenSinkyouKbnTest_getCodeCnv;
import yuyu.common.biz.interf.DensouUriageKgHenkanTest_exec;
import yuyu.common.biz.koutei.BzWorkflowInfoTest_all;
import yuyu.common.biz.koutei.GetSyoruittykymdTest_All;
import yuyu.common.biz.koutei.SetProgressHistoryTest_exec;
import yuyu.common.direct.dscommon.DsKokyakunoScrambleSyoriTest_exec;
import yuyu.common.hozen.haitou.KeisanDTest_exec;
import yuyu.common.hozen.khcommon.CheckProcessKekkaTest_exec;
import yuyu.common.hozen.khcommon.JtKaisukeisanTest_exec;
import yuyu.common.hozen.khcommon.KeisanGaikaItijiSkHirituTest_exec;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiPTest_exec;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougkTest_exec;
import yuyu.common.hozen.khcommon.KeisanWKijunYMTest_exec;
import yuyu.common.hozen.khcommon.KhozenEditTest_All;
import yuyu.common.hozen.khcommon.SetKessanNensibiTest_Exec;
import yuyu.common.hozen.khcommon.SetManryoubiTest_exec;
import yuyu.common.hozen.khcommon.SetOutoubiTest_exec;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymdTest_exec;
import yuyu.common.hozen.khcommon.ShrKeisanMsyMkeiPTest_exec;
import yuyu.common.hozen.khcommon.SyouhnTaniKeisanMsyMkeiPTest_exec;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilTest_exec;
import yuyu.common.hozen.setuibean.SetKouzaInfoTest_init;
import yuyu.common.siharai.chksk.ChkSubGengakuTest_exec;
import yuyu.common.siharai.chksk.ChkSubGeninKbnTest_exec;
import yuyu.common.siharai.chksk.ChkSubHasanTousanTest_exec;
import yuyu.common.siharai.chksk.ChkSubHknKknTest_exec;
import yuyu.common.siharai.chksk.ChkSubHonninkakuninTest_exec;
import yuyu.common.siharai.chksk.ChkSubJisatuMensekiTest_exec;
import yuyu.common.siharai.chksk.ChkSubKaigaiSbTest_exec;
import yuyu.common.siharai.chksk.ChkSubKaigaiTest_exec;
import yuyu.common.siharai.chksk.ChkSubMeigihenkouTest_exec;
import yuyu.common.siharai.chksk.ChkSubSasiosaeTest_exec;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmdSateiTest_exec;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmdTest_exec;
import yuyu.common.siharai.chksk.ChkSubSousasyoukaiTest_exec;
import yuyu.common.siharai.chksk.ChkSubSyuhiYouTest_exec;
import yuyu.common.siharai.chksk.ChkSubTtdktyuuiTest_exec;
import yuyu.common.siharai.chksk.ChkSubUketorininTest_exec;
import yuyu.common.siharai.chksk.SiMsgHikisuuSetteiTest_exec;
import yuyu.common.siharai.chksk.SiSKNaiyouChkWarningmsgSetteiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKetteiHoryuuHubiBatchTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiTaikakuTest_hantei;
import yuyu.common.sinkeiyaku.moschk.SeihowebMosnaiCheckTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetSknnkaisiymdTest_exec;
import yuyu.common.sinkeiyaku.skcommon.CheckTkhjnTest_all;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcdTest_exec;
import yuyu.common.suuri.srcommon.SrDateUtilTest_All;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfoTest_exec;

@RunWith(Suite.class)
@SuiteClasses({

    /*****************************************************
     *  Junit対応前、正常に動ける機能                    *
     ****************************************************/

    /** ------------------- 数理------------------------------ */
    // 数理 数理共通 特定時点商品情報取得
    SrGetTokutejitenSyohnInfoTest_exec.class,
    // 数理 数理共通 日付ユーティリティ
    SrDateUtilTest_All.class,

    /** ------------------- 保険金給付金支払------------------ */
    // 保険金給付金支払 請求内容チェック 減額チェック
    ChkSubGengakuTest_exec.class,
    // 保険金給付金支払 請求内容チェック 原因区分チェック
    ChkSubGeninKbnTest_exec.class,
    // 保険金給付金支払 請求内容チェック 破産および倒産チェック
    ChkSubHasanTousanTest_exec.class,
    // 保険金給付金支払 請求内容チェック 保険期間チェック
    ChkSubHknKknTest_exec.class,
    // 保険金給付金支払 請求内容チェック 本人確認チェック
    ChkSubHonninkakuninTest_exec.class,
    // 保険金給付金支払 請求内容チェック 自殺免責チェック
    ChkSubJisatuMensekiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 海外チェック
    ChkSubKaigaiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 海外死亡チェック
    ChkSubKaigaiSbTest_exec.class,
    // 保険金給付金支払 請求内容チェック 名義変更チェック
    ChkSubMeigihenkouTest_exec.class,
    // 保険金給付金支払 請求内容チェック 差押チェック
    ChkSubSasiosaeTest_exec.class,
    // 保険金給付金支払 請求内容チェック 責任開始日チェック
    ChkSubSknnKaisiYmdTest_exec.class,
    // 保険金給付金支払 請求内容チェック 査定項目＿責任開始日チェック
    ChkSubSknnKaisiYmdSateiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 捜査照会チェック
    ChkSubSousasyoukaiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 守秘要チェック
    ChkSubSyuhiYouTest_exec.class,
    // 保険金給付金支払 請求内容チェック 手続注意チェック
    ChkSubTtdktyuuiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 受取人チェック
    ChkSubUketorininTest_exec.class,
    // 保険金給付金支払 請求内容チェック メッセージ引数設定処理
    SiMsgHikisuuSetteiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 請求内容チェック警告メッセージ設定
    SiSKNaiyouChkWarningmsgSetteiTest_exec.class,

    /** ------------------- 契約保全-------------------------- */
    // 契約保全 契約保全共通 契約保全工程結果入力チェック
    CheckProcessKekkaTest_exec.class,
    // 契約保全 契約保全共通 配当金計算
    KeisanDTest_exec.class,
    // 契約保全 契約保全共通 未収Ｐ・未経過Ｐ計算
    KeisanMsyMkeiPTest_exec.class,
    // 契約保全 契約保全共通 ターゲット特約目標額計算
    KeisanTargetMokuhyougkTest_exec.class,
    // 契約保全 契約保全共通 解約返戻金計算基準年月設定
    KeisanWKijunYMTest_exec.class,
    // 契約保全 契約保全共通 契約保全文字列編集
    KhozenEditTest_All.class,
    // 契約保全 契約保全共通 証券発行日設定
    SetSyokenhakkouymdTest_exec.class,
    // 契約保全 契約保全共通 （支払）未収Ｐ・未経過Ｐ計算
    ShrKeisanMsyMkeiPTest_exec.class,
    // 契約保全 UiBean設定 契約保全区分パターン設定
    SetKhKbnPatternUtilTest_exec.class,
    // 契約保全 UiBean設定 口座情報設定
    SetKouzaInfoTest_init.class,
    // 契約保全 契約保全共通 （商品単位）未収Ｐ・未経過Ｐ計算
    SyouhnTaniKeisanMsyMkeiPTest_exec.class,
    // 契約保全 契約保全共通 外貨終身一時払用予定新契約比率計算
    KeisanGaikaItijiSkHirituTest_exec.class,
    // 契約保全 契約保全共通 充当回数計算
    JtKaisukeisanTest_exec.class,
    // 契約保全 契約保全共通 決算年始日設定
    SetKessanNensibiTest_Exec.class,
    // 契約保全 契約保全共通 期間満了日設定
    SetManryoubiTest_exec.class,
    // 契約保全 契約保全共通 直前直後応当日設定
    SetOutoubiTest_exec.class,

    /** ------------------- ベースパッケージ------------------ */
    // ベースパッケージ フォーマット BizDateを各処理のフォーマットに従って系変換処理
    BizDateFormatUtilTest_All.class,
    // ベースパッケージ フォーマット 個別指定書式用日付編集
    FixedDateFormatterTest_All.class,
    // ベースパッケージ フォーマット 標準書式用日付編集
    DefaultDateFormatterTest_All.class,

    /** ------------------- 業務共通-------------------------- */
    // 業務共通 共通 日付ユーティリティ
    BizDateUtilTest_All.class,
    // 業務共通 共通 住所桁数チェック
    BzChkAdrKetasuuTest_exec.class,
    // 業務共通 共通 区分変換処理
    BzKbnHenkanUtilTest_convKbn.class,
    // 業務共通 共通 連携項目変換用ユーティリティ
    BzRenkeiHenkanUtilTest_All.class,
    // 業務共通 共通 データ参照権限チェック
    CheckDataSansyouTest_execCheck.class,
    // 業務共通 共通 口座番号チェック
    CheckKouzaNoTest_All.class,
    // 業務共通 共通 電話番号チェック
    CheckTelNoTest_isCheckOK.class,
    // 業務共通 共通 セキュリティ項目編集
    EditSecurityKmTest_All.class,
    // 業務共通 共通 通貨変換処理
    HenkanTuukaTest_All.class,
    // 業務共通 共通 通貨換算計算
    KeisanGaikakanzanTest_exec.class,
    // 業務共通 共通 計算ユーティリティ
    MathUtilTest_powDecimal.class,
    // 業務共通 共通 保険年齢設定
    SetHokenNenreiTest_exec.class,
    // 業務共通 共通 年齢設定
    SetNenreiTest_exec.class,
    // 業務共通 共通 SKJ関連のチェック、置換を行うクラス
    SkjStringUtilTest.class,
    // 業務共通 共通 他契約通算情報パラメータ
    TakeiyakuTuusanInfoParamTest_Properties.class,
    // 業務共通 共通 通算用契約情報パラメータ
    TuusanKeiyakuInfoParamTest_Properties.class,
    // 業務共通 共通 カナ名チェック
    CheckKanaNmTest_All.class,
    // 業務共通 名寄せ ＰＡＬ契約更新取消処理クラス
    PALKykKousinTorikesiTest_exec.class,
    // 業務共通 インターフェイス 区分変換クラスＡ
    ConvKbnATest_getCodeCnv.class,
    // 業務共通 インターフェイス 区分変換クラスＢ
    ConvKbnBTest_getCodeCnv.class,
    // 業務共通 インターフェイス 区分変換クラスＣ
    ConvKbnCTest_getCodeCnv.class,
    // 業務共通 インターフェイス 区分変換クラス（全信協用）
    ConvZenSinkyouKbnTest_getCodeCnv.class,
    // 業務共通 インターフェイス 伝送用売上金額変換処理
    DensouUriageKgHenkanTest_exec.class,
    // 業務共通 工程 業務用ワークフロー情報
    BzWorkflowInfoTest_all.class,
    // 業務共通 工程 書類到着日取得
    GetSyoruittykymdTest_All.class,
    // 業務共通 工程 進捗履歴情報設定
    SetProgressHistoryTest_exec.class,

    /** ------------------- ダイレクトサービス---------------- */
    // ダイレクトサービス ダイレクトサービス共通 ＤＳ顧客番号スクランブル化処理
    DsKokyakunoScrambleSyoriTest_exec.class,

    /** ------------------- 新契約---------------------------- */
    // 新契約 申込内容チェック 体格判定
    HanteiTaikakuTest_hantei.class,
    // 新契約 申込内容チェック 生保Ｗｅｂ申込内容チェック
    SeihowebMosnaiCheckTest_exec.class,
    // 新契約 申込内容チェック 責任開始日設定
    SetSknnkaisiymdTest_exec.class,
    // 新契約 新契約共通 特定関係法人チェック
    CheckTkhjnTest_all.class,
    // 新契約 新契約共通 チャネルコード変換
    ConvertChannelcdTest_exec.class,
    // 新契約 工程 新契約工程遷移（決定保留不備）_バッチ用
    SkProcessForwardKetteiHoryuuHubiBatchTest_exec.class,

})
public class TestAll_SyuuseiTaisyougai {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
