package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.biz.bzcommon.BizEntityUtilTest_All;
import yuyu.common.biz.bzcommon.BizPropertyInitializerTest;
import yuyu.common.biz.bzcommon.BzGetAdrDataTest_All;
import yuyu.common.biz.bzcommon.BzGetBankDataTest_exec;
import yuyu.common.biz.bzcommon.BzGetDrateTest_exec;
import yuyu.common.biz.bzcommon.BzGetExecutableTasksTest_exec;
import yuyu.common.biz.bzcommon.BzGetImagePropsTest_exec;
import yuyu.common.biz.bzcommon.BzGetNenkinDrateTest_exec;
import yuyu.common.biz.bzcommon.BzGetNenkinPkisoVrateTest_exec;
import yuyu.common.biz.bzcommon.BzGetPrateTest_exec;
import yuyu.common.biz.bzcommon.BzGetProcessRecordTest_exec;
import yuyu.common.biz.bzcommon.BzGetSosikiDataTest_All;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoTest_exec;
import yuyu.common.biz.bzcommon.BzGetSousasyaSyozokuSosikiDataTest_exec;
import yuyu.common.biz.bzcommon.BzGetVrateTest_exec;
import yuyu.common.biz.bzcommon.BzProcessUpdateTest_exec;
import yuyu.common.biz.bzcommon.BzPutImageTest_exec;
import yuyu.common.biz.bzcommon.CheckKanaTest_All;
import yuyu.common.biz.bzcommon.CheckKinouModeKengenTest_all;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanaTest_All;
import yuyu.common.biz.bzcommon.DateFormatUtilTest_All;
import yuyu.common.biz.bzcommon.FilePathUtilTest_All;
import yuyu.common.biz.bzcommon.GetBankSitenNmTest_exec;
import yuyu.common.biz.bzcommon.GetKawaseRateTest_exec;
import yuyu.common.biz.bzcommon.KeisanTienrisokuTest_exec;
import yuyu.common.biz.bzcommon.MousikomiNoCheckTest_All;
import yuyu.common.biz.bzcommon.RayTmSosikiUtilTest;
import yuyu.common.biz.bzcommon.SaibanBizTest_All;
import yuyu.common.biz.bzcommon.SiTienRisokuKikanKeisanTest_exec;
import yuyu.common.biz.bzcommon.SyokenNoCheck_All;
import yuyu.common.biz.bzcommon.TuusanTest_exec;
import yuyu.common.biz.bzdairiten.BzChkAgYuukouTest_exec;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouHengakuTest_exec;
import yuyu.common.biz.bzdairiten.BzChkBsYuukouTest_exec;
import yuyu.common.biz.bzdairiten.BzGetAgHoujinsyougouTest_exec;
import yuyu.common.biz.bzdairiten.BzGetAgInfoJimusyoTest_exec;
import yuyu.common.biz.bzdairiten.BzGetAgInfoKinyuuKikanTest_exec;
import yuyu.common.biz.bzdairiten.BzGetAgInfoTest_exec;
import yuyu.common.biz.bzdairiten.BzGetAgKeyJimusyoTest_exec;
import yuyu.common.biz.bzdairiten.BzGetAgKeyKinyuuKikanTest_exec;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBstrknoTest_exec;
import yuyu.common.biz.bzdairiten.BzGetBsInfoKouinTest_exec;
import yuyu.common.biz.bzdairiten.BzGetBsInfoTest_exec;
import yuyu.common.biz.bzdairiten.BzGetBsKeyBstrknoTest_exec;
import yuyu.common.biz.bzdairiten.BzGetBsKeyKouinTest_exec;
import yuyu.common.biz.bzdairiten.BzGetBuntanInfoTest_All;
import yuyu.common.biz.bzfiledl.BzFileUploadUtilTest_exec;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGetTest_exec;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMqTest_All;
import yuyu.common.biz.bznayose.BzPalSyoumetujiyuuNameGetTest_exec;
import yuyu.common.biz.bznayose.BzSaibanNayoseTest_All;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqTest_exec;
import yuyu.common.biz.bznayose.BzTrksIraiMqTest_All;
import yuyu.common.biz.bznayose.BzTrksTjtIdouNaiyouSakujyoTest_exec;
import yuyu.common.biz.bznayose.BzYoukyuuNoKanriTblTuikaKousinTest_exec;
import yuyu.common.biz.bznayose.BzYoukyuuNoKanriTest_exec;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputTest_exec;
import yuyu.common.biz.kaikei.BzDenpyouDataSksTest_All;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksTest_All;
import yuyu.common.biz.kaikei.BzFbSoukinFileSksTest_creadFBsoukinfwairu;
import yuyu.common.biz.kaikei.BzFbSoukinTrkmHensyuTest_exec;
import yuyu.common.biz.kaikei.BzFurikaeDenpyouJouhouTest_All;
import yuyu.common.biz.kaikei.BzGkFbSoukinFileSksTest_creadGaikaFBSoukinFwairu;
import yuyu.common.biz.kaikei.BzGkFbSoukinTrkmHensyuTest_exec;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksTest_All;
import yuyu.common.biz.kaikei.BzKeiriDenDataSksKyoutuuTest_All;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutokuTest_exec;
import yuyu.common.biz.koutei.BzCommonLockProcessTest_all;
import yuyu.common.biz.koutei.BzContinueLockProcessTest_exec;
import yuyu.common.biz.koutei.BzEndProcessTest_exec;
import yuyu.common.biz.koutei.BzForceProcessForwardTest_exec;
import yuyu.common.biz.koutei.BzForceTaskStartTest_exec;
import yuyu.common.biz.koutei.BzGetProcessSummaryTest_exec;
import yuyu.common.biz.koutei.BzLockProcessTest_exec;
import yuyu.common.biz.koutei.BzOutputProcessRecordTest_exec;
import yuyu.common.biz.koutei.BzProcessCreateTest_exec;
import yuyu.common.biz.koutei.BzProcessForwardForBatchTest_exec;
import yuyu.common.biz.koutei.BzProcessForwardTest_exec;
import yuyu.common.biz.koutei.BzSetImageRelationTest_exec;
import yuyu.common.biz.koutei.BzTaskStartTest_exec;
import yuyu.common.biz.koutei.BzUnlockProcessTest_exec;
import yuyu.common.biz.koutei.GetProgressHistoryTest_exec;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfoTest_exec;
import yuyu.common.biz.koutei.GetSyoriOyakouteiInfoTest_exec;
import yuyu.common.biz.koutei.SetKouteiInfoTest_exec;
import yuyu.common.biz.koutei.SetKouteiKanriIdTest_exec;
import yuyu.common.biz.koutei.SetWariateHukaInfoTest_exec;
import yuyu.common.biz.koutei.UpdateJimustartymdTest_exec;
import yuyu.common.biz.prereport.GetQRCodeTest_All;
import yuyu.common.biz.report.ViewReportTest_All;
import yuyu.common.biz.syoruiitiran.CommonDispImageTest_all;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranTest_All;
import yuyu.common.biz.syoruitoutyaku.SyoruitoutyakuOperateProcessTest_exec;

/**
 * 全メソッド（業務共通）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    // B_業務共通 名寄せ PALあて契約内容反映（MQ）
    BzKykNaiyouHaneiMqTest_All.class,
    // 業務共通 共通 業務共通工程履歴取得
    BzGetProcessRecordTest_exec.class,
    // 業務共通 共通 年金開始後Ｄレート取得
    BzGetNenkinDrateTest_exec.class,
    // 業務共通 共通 年金開始後Ｐ基礎Ｖレート取得
    BzGetNenkinPkisoVrateTest_exec.class,
    // 業務共通 共通 業務共通工程情報更新
    BzProcessUpdateTest_exec.class,
    // 業務共通 共通 Ｄレート取得
    BzGetDrateTest_exec.class,
    // 業務共通 共通 Ｐレート取得
    BzGetPrateTest_exec.class,
    // 業務共通 共通 代理店コード取得（金融機関指定）
    BzGetAgKeyKinyuuKikanTest_exec.class,
    // B_業務共通 共通 業務共通実行可能タスク情報取得
    BzGetExecutableTasksTest_exec.class,
    // B_業務共通 共通 Ｖレート取得
    BzGetVrateTest_exec.class,
    // B_業務共通 共通 為替レート取得
    GetKawaseRateTest_exec.class,
    // B_業務共通 共通 遅延利息計算
    KeisanTienrisokuTest_exec.class,
    // B_業務共通 共通 申込番号チェック
    MousikomiNoCheckTest_All.class,
    // B_業務共通 共通 証券番号チェック
    SyokenNoCheck_All.class,
    // B_業務共通 共通 通算処理クラス
    TuusanTest_exec.class,
    // B_業務共通 名寄せ 別口契約情報取得
    BetukutiKeiyakuInfoGetTest_exec.class,
    // B_業務共通 名寄せ ＰＡＬ消滅事由名称取得
    BzPalSyoumetujiyuuNameGetTest_exec.class,
    // B_業務共通 名寄せ PALあて索引通算照会（MQ）
    BzSakuinTsnSyoukaiMqTest_exec.class,
    // 業務共通 共通 QRコード値取得処理
    GetQRCodeTest_All.class,
    // 業務共通 代理店 代理店法人商号取得
    BzGetAgHoujinsyougouTest_exec.class,
    // 業務共通 代理店 代理店情報取得（代理店コード指定）
    BzGetAgInfoTest_exec.class,
    // 業務共通 代理店 代理店情報取得（親代理店、事務所指定）
    BzGetAgInfoJimusyoTest_exec.class,
    // 業務共通 代理店 代理店コード取得（親代理店、事務所指定）
    BzGetAgKeyJimusyoTest_exec.class,
    // 業務共通 代理店 募集人コード取得（行員コード指定）
    BzGetBsKeyKouinTest_exec.class,
    // 業務共通 代理店 募集人コード取得（募集人登録番号指定）
    BzGetBsKeyBstrknoTest_exec.class,
    // 業務共通 代理店 募集人情報取得（募集人コード指定）
    BzGetBsInfoTest_exec.class,
    // 業務共通 代理店 募集人情報取得（行員コード指定）
    BzGetBsInfoKouinTest_exec.class,
    // 業務共通 代理店 募集人情報取得（募集人登録番号指定）
    BzGetBsInfoBstrknoTest_exec.class,
    // 業務共通 経理・会計 伝票データ作成
    BzDenpyouDataSksTest_All.class,
    // 業務共通 経理・会計 ＦＢ送金ファイル作成
    BzFbSoukinFileSksTest_creadFBsoukinfwairu.class,
    // 業務共通 経理・会計 ＦＢ送金データ取込編集
    BzFbSoukinTrkmHensyuTest_exec.class,
    // 業務共通 経理・会計 外貨ＦＢ送金ファイル作成
    BzGkFbSoukinFileSksTest_creadGaikaFBSoukinFwairu.class,
    // 業務共通 経理・会計 ＦＢ送金データ作成
    BzFbSoukinDataSksTest_All.class,
    // 業務共通 工程 業務共通工程履歴出力
    BzOutputProcessRecordTest_exec.class,
    // 業務共通 工程 工程ロック共通処理
    BzCommonLockProcessTest_all.class,
    // 業務共通 工程 業務共通工程遷移
    BzProcessForwardTest_exec.class,
    // 業務共通 工程 業務共通イメージ関連設定
    BzSetImageRelationTest_exec.class,
    // B_業務共通 代理店 代理店有効性チェック
    BzChkAgYuukouTest_exec.class,
    // B_業務共通 代理店 募集人有効性チェック
    BzChkBsYuukouTest_exec.class,
    // B_業務共通 代理店 募集人変額保険資格有効性チェック
    BzChkBsYuukouHengakuTest_exec.class,
    // B_業務共通 代理店 代理店情報取得（金融機関指定）
    BzGetAgInfoKinyuuKikanTest_exec.class,
    // B_業務共通 代理店 分担情報取得
    BzGetBuntanInfoTest_All.class,
    // B_業務共通 工程 業務共通タスク開始
    BzTaskStartTest_exec.class,
    // B_業務共通 工程 業務共通工程ロック解除
    BzUnlockProcessTest_exec.class,
    // B_業務共通 工程 工程情報表示設定
    SetKouteiInfoTest_exec.class,
    // B_業務共通 工程 工程管理ＩＤ設定
    SetKouteiKanriIdTest_exec.class,
    // B_業務共通 名寄せ 取消用当日異動内容削除
    BzTrksTjtIdouNaiyouSakujyoTest_exec.class,
    // B_業務共通 名寄せ 要求通番管理テーブル追加更新
    BzYoukyuuNoKanriTblTuikaKousinTest_exec.class,
    // B_業務共通 工程 業務共通工程遷移（バッチ用）
    BzProcessForwardForBatchTest_exec.class,
    // B_業務共通 工程 処理中子工程情報取得
    GetSyoriKokouteiInfoTest_exec.class,
    // B_業務共通 工程 割当不可情報設定
    SetWariateHukaInfoTest_exec.class,
    // B_業務共通 工程 事務開始日更新
    UpdateJimustartymdTest_exec.class,
    // B_業務共通 共通 銀行名支店名取得
    GetBankSitenNmTest_exec.class,
    // B_業務共通 共通 端末設置組織コードに関するユーティリティ
    RayTmSosikiUtilTest.class,
    // B_業務共通 共通 採番業務共通
    SaibanBizTest_All.class,
    // B_業務共通 共通 遅延利息期間計算
    SiTienRisokuKikanKeisanTest_exec.class,
    // B_業務共通 工程 処理中親工程情報取得
    GetSyoriOyakouteiInfoTest_exec.class,
    // B_業務共通 代理店 エンティティユーティリティ
    BizEntityUtilTest_All.class,
    // B_業務共通 代理店 エンティティ初期化
    BizPropertyInitializerTest.class,
    // B_業務共通 代理店 住所情報取得
    BzGetAdrDataTest_All.class,
    // B_業務共通 代理店 銀行情報取得
    BzGetBankDataTest_exec.class,
    // B_業務共通 代理店 業務共通イメージプロパティ取得
    BzGetImagePropsTest_exec.class,
    // B_業務共通 代理店 組織情報取得
    BzGetSosikiDataTest_All.class,
    // B_業務共通 代理店 組織窓口情報取得
    BzGetSosikiMadogutiInfoTest_exec.class,
    // B_業務共通 代理店 操作者所属組織情報取得
    BzGetSousasyaSyozokuSosikiDataTest_exec.class,
    // B_業務共通 代理店 業務共通イメージ登録
    BzPutImageTest_exec.class,
    // B_業務共通 代理店 カナ入力チェック
    CheckKanaTest_All.class,
    // B_業務共通 工程 機能モード権限チェック
    CheckKinouModeKengenTest_all.class,
    // B_業務共通 代理店 カナ名義人チェック
    CheckMeigininNmKanaTest_All.class,
    // B_業務共通 代理店 日付フォーマットユーティリティ
    DateFormatUtilTest_All.class,
    // B_業務共通 代理店 ファイル、フォルダのパスに関連する処理を行うユーティリティ
    FilePathUtilTest_All.class,
    // B_業務共通 ファイルダウンロード ファイルアップロードユーティリティ
    BzFileUploadUtilTest_exec.class,
    // B_業務共通 名寄せ PALあて取消依頼（MQ）クラス
    BzTrksIraiMqTest_All.class,
    // B_業務共通 名寄せ 要求通番発番
    BzYoukyuuNoKanriTest_exec.class,
    // B_業務共通 WEBサービスアクセスログ出力 WEBサービスアクセスログ出力
    WebServiceAccesslogOutputTest_exec.class,
    // B_業務共通 経理・会計 振替伝票情報
    BzFurikaeDenpyouJouhouTest_All.class,
    // B_業務共通 経理・会計 外貨ＦＢ送金データ作成
    BzGkfbSoukinDataSksTest_All.class,
    // B_業務共通 経理・会計 外貨ＦＢ送金データ取込編集
    BzGkFbSoukinTrkmHensyuTest_exec.class,
    // B_業務共通 経理・会計 経理伝票データ作成共通処理
    BzKeiriDenDataSksKyoutuuTest_All.class,
    // B_業務共通 経理・会計 支払伝票日付取得
    BzShiharaiDenpyouDateShutokuTest_exec.class,
    // B_業務共通 工程 業務共通工程ロック継続
    BzContinueLockProcessTest_exec.class,
    // B_業務共通 工程 業務共通工程終了
    BzEndProcessTest_exec.class,
    // B_業務共通 工程 業務共通強制工程遷移
    BzForceProcessForwardTest_exec.class,
    // B_業務共通 工程 業務共通強制タスク開始
    BzForceTaskStartTest_exec.class,
    // B_業務共通 工程 業務共通工程サマリ取得
    BzGetProcessSummaryTest_exec.class,
    // B_業務共通 工程 業務共通工程ロック開始
    BzLockProcessTest_exec.class,
    // B_業務共通 工程 業務共通工程作成
    BzProcessCreateTest_exec.class,
    // B_業務共通 工程 進捗履歴情報取得
    GetProgressHistoryTest_exec.class,
    // B_業務共通 帳票出力 帳票表示用の各種データ編集
    ViewReportTest_All.class,
    // B_業務共通 書類情報一覧 イメージ表示共通
    CommonDispImageTest_all.class,
    // B_業務共通 書類情報一覧 書類情報一覧設定
    SetSyoruiInfoItiranTest_All.class,
    // B_業務共通 書類到着 書類到着時工程操作処理
    SyoruitoutyakuOperateProcessTest_exec.class,
    // B_業務共通 名寄せ 採番名寄せ
    BzSaibanNayoseTest_All.class,

})
public class TestAll_Biz {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
