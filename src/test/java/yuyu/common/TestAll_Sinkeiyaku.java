package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.sinkeiyaku.koutei.SkProcessCreateTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHenkinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiKaisyouTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTourokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHurikomiNyuukinTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardImuSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKankyouSateiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninIraiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKeiyakuKakuninKekkaTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKetteiHoryuuHubiOnlineTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKyouseiHandTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExecTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTenkenTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardNyuukinNyuuryokuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardPaperlessMousikomiTest_kouteiSeni;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardSeirituHoryuuTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTeiseiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTokuninTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardYuukoukikanKeikaHanteiTest_exec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_all;
import yuyu.common.sinkeiyaku.moschk.AuthoriKakuninHanteiTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckAuthoriJkTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckDoujiMosTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckFatcaTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckFreeInsuranceTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckHatubaikknTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckHokenRyouYuukouKigenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckHrkKaisuuTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckHrkKeiroTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckHubiKanriTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckKirikaeTratkikknTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckKykKanrenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckKykSeiYmdKanrenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckKykSeibetuTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckLivHukaTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckMRKanrenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckMeigininNmKanaCallTest_all;
import yuyu.common.sinkeiyaku.moschk.CheckNnknTokuyakuTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckNyuukinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckPmentkKanrenTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSaiteiPTest_all;
import yuyu.common.sinkeiyaku.moschk.CheckSbUktHhknTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSeiYmdTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSeirituHoryuuTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSekininKaisikiTkTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSentakujyouhouTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckShiteiKeiyakubiTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSimeiKanaTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSkTuusanTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckSntkHouSyouhinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblCreditCardInfoTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblHoujyouTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblKokutisyoTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblKouzaJyouhouTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblNyuukinHenkinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblUketorininTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTelNoCallTest_all;
import yuyu.common.sinkeiyaku.moschk.CheckUktBnWariTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckUktNinzuuTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckUktNmkanaTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckYoteiKykYmdTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckZennouKanrenTest_exec;
import yuyu.common.sinkeiyaku.moschk.EditPrintFileTest_exec;
import yuyu.common.sinkeiyaku.moschk.GetUktYouFlgTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiKirikaeYuukouTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiKykKakuninTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiLINCTest_exec;
import yuyu.common.sinkeiyaku.moschk.HanteiZennouKaisuuTest_exec;
import yuyu.common.sinkeiyaku.moschk.JidouSetSyokikaTest_exec;
import yuyu.common.sinkeiyaku.moschk.KeisanSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.KetteiTest_exec;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParamTest_Properties;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckTest_exec;
import yuyu.common.sinkeiyaku.moschk.NayoseTest_exec;
import yuyu.common.sinkeiyaku.moschk.SateiKetteiJissiRuleHanteiTest_exec;
import yuyu.common.sinkeiyaku.moschk.SeirituTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetHutuuSibouSTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetKyuuhuNitigakuTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetSPTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetSateijtTest_exec;
import yuyu.common.sinkeiyaku.moschk.SetSyouhinSedaiTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumokuTest_All;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHenkiniraiTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHubiTyouhyouTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfTrksseikyuTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditPdfYoteirirtuTest_exec;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumokuTest_All;
import yuyu.common.sinkeiyaku.skcommon.EditTblAtukaisyaTest_exec;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenInfoTest_exec;
import yuyu.common.sinkeiyaku.skcommon.GetHknsyuruinmTest_all;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangkTest_exec;
import yuyu.common.sinkeiyaku.skcommon.GetLincTourokuSTest_exec;
import yuyu.common.sinkeiyaku.skcommon.GetMosGamenctrlTest_getGamenctrl;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosnoTest_All;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukeiTest_All;
import yuyu.common.sinkeiyaku.skcommon.GetSinkeiyakuGuidanceTest_exec;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuuiTest_All;
import yuyu.common.sinkeiyaku.skcommon.GetSyoruicdTest_All;
import yuyu.common.sinkeiyaku.skcommon.HanteiDoujiMosTest_All;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_All;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEditTest_All;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtilTest_getMosNo;
import yuyu.common.sinkeiyaku.skcommon.SaiDataSyutokuTest_findSaiData;
import yuyu.common.sinkeiyaku.skcommon.SaiDataTourokuTest_All;
import yuyu.common.sinkeiyaku.skcommon.SetMossykykyoteiymdTest_All;
import yuyu.common.sinkeiyaku.skcommon.SkMosMikakuteiInfoSksTest_All;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomiTest_all;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEditTest_all;
import yuyu.common.sinkeiyaku.skcommon.SmbcEditSintyokuDataTest_exec;
import yuyu.common.sinkeiyaku.skcommon.SmbcsintyokukanriCoolingoffTest_exec;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtilTest_all;
import yuyu.common.sinkeiyaku.skcommon.SyoukenNoUtilTest_getShokenNo;
import yuyu.common.sinkeiyaku.skcommon.TsRrkInfoTourokuTest_All;
import yuyu.common.sinkeiyaku.syoruitoutyaku.SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo;

/**
 * 全メソッド（新契約）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    // H_新契約 新契約共通 SMBC進捗管理データ編集
    SmbcEditSintyokuDataTest_exec.class,
    // H_新契約 新契約共通 SMBC進捗管理データ作成クーリングオフ
    SmbcsintyokukanriCoolingoffTest_exec.class,
    // H_新契約 新契約共通 商品属性ユーティリティ
    SyouhinUtilTest_all.class,
    // H_新契約 新契約共通 証券番号自動採番
    SyoukenNoUtilTest_getShokenNo.class,
    // H_新契約 新契約共通 訂正履歴情報登録
    TsRrkInfoTourokuTest_All.class,
    // H_新契約 申込内容チェック ＭＲ関連チェック
    CheckMRKanrenTest_exec.class,
    // H_新契約 申込内容チェック 年金支払特約チェック
    CheckNnknTokuyakuTest_exec.class,
    // H_新契約 申込内容チェック 入金チェック
    CheckNyuukinTest_exec.class,
    // H_新契約 申込内容チェック 保険料免除特約関連チェック
    CheckPmentkKanrenTest_exec.class,
    // H_新契約 申込内容チェック 最低Pチェック
    CheckSaiteiPTest_all.class,
    // H_新契約 申込内容チェック 死亡受取人≠被保険者チェック
    CheckSbUktHhknTest_exec.class,
    // H_新契約 申込内容チェック 成立保留チェック
    CheckSeirituHoryuuTest_exec.class,
    // H_新契約 申込内容チェック 生年月日範囲チェック
    CheckSeiYmdTest_exec.class,
    // 新契約 申込内容チェック 不備管理チェック
    CheckHubiKanriTest_exec.class,
    // 新契約 申込内容チェック 商品切替取扱期間チェック
    CheckKirikaeTratkikknTest_exec.class,
    // 新契約 申込内容チェック 契約者項目関連チェック
    CheckKykKanrenTest_exec.class,
    // 新契約 申込内容チェック 契約者性別チェック
    CheckKykSeibetuTest_exec.class,
    // 新契約 申込内容チェック 契約者生年月日関連チェック
    CheckKykSeiYmdKanrenTest_exec.class,
    // 新契約 申込内容チェック リビングニーズ付加有無チェック
    CheckLivHukaTest_exec.class,
    // 新契約 申込内容チェック カナ名義人チェック呼出し
    CheckMeigininNmKanaCallTest_all.class,
    // 新契約 申込内容チェック 受取人分割割合チェック
    CheckUktBnWariTest_exec.class,
    // 新契約 申込内容チェック 受取人人数整合性チェック
    CheckUktNinzuuTest_exec.class,
    // 新契約 申込内容チェック 受取人名（カナ）チェック
    CheckUktNmkanaTest_exec.class,
    // 新契約 申込内容チェック 前納関連チェック
    CheckZennouKanrenTest_exec.class,
    // 新契約 申込内容チェック 切替契約有効判定
    HanteiKirikaeYuukouTest_exec.class,
    // 新契約 申込内容チェック オーソリ確認判定
    AuthoriKakuninHanteiTest_exec.class,
    // 新契約 申込内容チェック オーソリ状況チェック
    CheckAuthoriJkTest_exec.class,
    // 新契約 申込内容チェック 同時申込チェック
    CheckDoujiMosTest_exec.class,
    // 新契約 申込内容チェック ＦＡＴＣＡチェック
    CheckFatcaTest_exec.class,
    // 新契約 申込内容チェック フリーインシュアランスチェック
    CheckFreeInsuranceTest_exec.class,
    // 新契約 申込内容チェック 発売期間チェック
    CheckHatubaikknTest_exec.class,
    // 新契約 申込内容チェック 払込回数チェック
    CheckHrkKaisuuTest_exec.class,
    // 新契約 申込内容チェック 責任開始期特約付加チェック
    CheckSekininKaisikiTkTest_exec.class,
    // 新契約 申込内容チェック 選択情報チェック
    CheckSentakujyouhouTest_exec.class,
    // 新契約 申込内容チェック 指定契約日チェック
    CheckShiteiKeiyakubiTest_exec.class,
    // 新契約 申込内容チェック 氏名カナ入力チェック
    CheckSimeiKanaTest_exec.class,
    // 新契約 申込内容チェック 新契約通算チェック
    CheckSkTuusanTest_exec.class,
    // 新契約 申込内容チェック 氏名カナ入力チェック
    CheckSntkHouSyouhinTest_exec.class,
    // 新契約 申込内容チェック 受取人要フラグ取得
    GetUktYouFlgTest_exec.class,
    // 新契約 申込内容チェック 査定・決定実施ルール判定
    SateiKetteiJissiRuleHanteiTest_exec.class,
    // 新契約 申込内容チェック 成立処理
    SeirituTest_exec.class,
    // 新契約 新契約共通 新契約手続注意情報取得
    GetSkTtdkTyuuiTest_All.class,
    // 新契約 新契約共通 差異データ登録
    SaiDataTourokuTest_All.class,
    // 新契約 新契約共通 申込消却予定日設定
    SetMossykykyoteiymdTest_All.class,
    // 新契約 新契約共通 新契約申込未確定情報作成
    SkMosMikakuteiInfoSksTest_All.class,
    // 新契約 新契約共通 新契約書類取込前処理
    SkPreSyoruiTorikomiTest_all.class,
    // 新契約 申込内容チェック SP設定
    SetSPTest_exec.class,
    // 新契約 新契約共通 ＰＡＬ連携項目編集
    EditPalRenkeiKoumokuTest_All.class,
    // 新契約 新契約共通 返金依頼書ＰＤＦ作成
    EditPdfHenkiniraiTest_exec.class,
    // 新契約 新契約共通 不備帳票ＰＤＦ作成
    EditPdfHubiTyouhyouTest_exec.class,
    // 新契約 新契約共通 ＬＩＮＣ登録S（日額）取得
    GetLincTourokuSTest_exec.class,
    //  H_新契約 申込内容チェック 口座情報TBLチェック
    CheckTblKouzaJyouhouTest_exec.class,
    //  H_新契約 申込内容チェック 入金TBL・返金TBLチェック
    CheckTblNyuukinHenkinTest_exec.class,
    //  H_新契約 申込内容チェック 電話番号チェック呼出し
    CheckTelNoCallTest_all.class,
    //  H_新契約 申込内容チェック 申込内容チェック
    MosnaiCheckTest_exec.class,
    //  H_新契約 申込内容チェック 普通死亡Ｓ設定
    SetHutuuSibouSTest_exec.class,
    //  H_新契約 申込内容チェック 給付日額設定
    SetKyuuhuNitigakuTest_exec.class,
    //  H_新契約 申込内容チェック 査定状態設定
    SetSateijtTest_exec.class,
    //  H_新契約 申込内容チェック 商品世代番号設定
    SetSyouhinSedaiTest_exec.class,
    //  H_新契約 新契約共通 取消請求書PDF作成
    EditPdfTrksseikyuTest_exec.class,
    //  H_新契約 新契約共通 書類コード取得
    GetSyoruicdTest_All.class,
    //  H_新契約 新契約共通 返金
    HenkinTest_All.class,
    //  H_新契約 新契約共通 不備メッセージ編集
    HubiMsgEditTest_All.class,
    //  H_新契約 新契約共通 申込番号採番
    MousikomiNoUtilTest_getMosNo.class,
    //  H_新契約 新契約共通 差異データ取得
    SaiDataSyutokuTest_findSaiData.class,
    // H_新契約 申込内容チェック 報状TBLチェック
    CheckTblHoujyouTest_exec.class,
    // H_新契約 申込内容チェック 帳票ファイル編集
    EditPrintFileTest_exec.class,
    // H_新契約 申込内容チェック 自動設定項目初期化
    JidouSetSyokikaTest_exec.class,
    // H_新契約 申込内容チェック SP計算
    KeisanSPTest_exec.class,
    // H_新契約 申込内容チェック 申込内容チェック用パラメータ
    MosnaiCheckParamTest_Properties.class,
    // H_新契約 新契約共通 同時申込判定
    HanteiDoujiMosTest_All.class,
    // H_新契約 工程 新契約工程遷移（返金入力）
    SkProcessForwardHenkinNyuuryokuTest_exec.class,
    // H_新契約 工程 新契約工程遷移（環境査定）
    SkProcessForwardKankyouSateiTest_exec.class,
    // H_新契約 工程 新契約工程遷移（契約確認結果入力）
    SkProcessForwardKeiyakuKakuninKekkaTest_exec.class,
    // H_新契約 工程 新契約工程遷移（決定保留不備）_オンライン用
    SkProcessForwardKetteiHoryuuHubiOnlineTest_exec.class,
    // H_新契約 工程 新契約工程遷移（有効期間経過契約判定処理）
    SkProcessForwardYuukoukikanKeikaHanteiTest_exec.class,
    // H_新契約 申込内容チェック 受取人TBLチェック
    CheckTblUketorininTest_exec.class,
    // H_新契約 申込内容チェック 契約確認該当判定
    HanteiKykKakuninTest_exec.class,
    // H_新契約 申込内容チェック LINC該当判定
    HanteiLINCTest_exec.class,
    // H_新契約 申込内容チェック 前納回数判定
    HanteiZennouKaisuuTest_exec.class,
    // H_新契約 申込内容チェック 決定処理
    KetteiTest_exec.class,
    // H_新契約 工程 新契約工程遷移（新契約不備解消）
    SkProcessForwardHubiKaisyouTest_exec.class,
    // H_新契約 工程 新契約工程遷移（医務査定）
    SkProcessForwardImuSateiTest_exec.class,
    // H_新契約 工程 新契約工程遷移（告知書入力）
    SkProcessForwardKokutisyoNyuuryokuTest_exec.class,
    // H_新契約 工程 新契約工程遷移（申込書入力）
    SkProcessForwardMousikomisyoNyuuryokuTest_exec.class,
    // H_新契約 工程 新契約工程遷移（申込点検）
    SkProcessForwardMousikomiTenkenTest_exec.class,
    // H_新契約 工程 新契約工程遷移（申込取消）
    SkProcessForwardMousikomiTorikesiTest_exec.class,
    // H_新契約 工程 新契約工程遷移（入金入力）
    SkProcessForwardNyuukinNyuuryokuTest_exec.class,
    // H_新契約 工程 新契約工程遷移（当日成立取消）
    SkProcessForwardToujituSeirituTorikesiTest_exec.class,
    /** 2017/9/25 */
    // H_新契約 新契約共通 新契約当日異動内容編集
    SkToujituIdounaiyouEditTest_all.class,
    // H_新契約 申込内容チェック 払込経路チェック
    CheckHrkKeiroTest_exec.class,
    // H_新契約 申込内容チェック SPチェック
    CheckSPTest_exec.class,
    // H_新契約 申込内容チェック クレジットカード情報TBLチェック
    CheckTblCreditCardInfoTest_exec.class,
    // H_新契約 申込内容チェック 告知書TBLチェック
    CheckTblKokutisyoTest_exec.class,
    // H_新契約 申込内容チェック 予定契約日チェック
    CheckYoteiKykYmdTest_exec.class,
    // H_新契約 申込内容チェック 名寄せ処理
    NayoseTest_exec.class,
    // H_新契約 申込内容チェック 基礎項目設定
    SetKisoKoumokuTest_exec.class,
    // H_新契約 新契約共通 予定利率変更連絡票PDF作成
    EditPdfYoteirirtuTest_exec.class,
    // H_新契約 新契約共通 生保Ｗｅｂ連携項目編集
    EditSeihoWebRenkeiKoumokuTest_All.class,
    // H_新契約 新契約共通 扱者TBL編集
    EditTblAtukaisyaTest_exec.class,
    // H_新契約 新契約共通 代理店情報取得
    GetDairitenInfoTest_exec.class,
    // H_新契約 新契約共通 保険種類名取得
    GetHknsyuruinmTest_all.class,
    // H_新契約 新契約共通 規定チェック用円換算金額取得
    GetKiteiCheckYenkansangkTest_exec.class,
    // H_新契約 新契約共通 申込書入力画面制御リスト取得
    GetMosGamenctrlTest_getGamenctrl.class,
    // H_新契約 新契約共通 相手申込番号ワーニングＭＳＧ取得
    GetMsgAitemosnoTest_All.class,
    // H_新契約 新契約共通 領収金額合計取得
    GetRsgakukeiTest_All.class,
    // H_新契約 新契約共通 新契約ガイダンス取得
    GetSinkeiyakuGuidanceTest_exec.class,
    // H_新契約 工程 新契約工程作成
    SkProcessCreateTest_exec.class,
    // H_新契約 工程 新契約工程遷移（新契約不備登録）
    SkProcessForwardHubiTourokuTest_exec.class,
    // H_新契約 工程 新契約工程遷移（振込入金処理）
    SkProcessForwardHurikomiNyuukinTest_exec.class,
    // H_新契約 工程 新契約工程遷移（契約確認依頼入力）
    SkProcessForwardKeiyakuKakuninIraiTest_exec.class,
    // H_新契約 工程 新契約工程遷移（強制ハンド決定入力）
    SkProcessForwardKyouseiHandTest_exec.class,
    // H_新契約 工程 新契約工程遷移（申込内容チェック実行）
    SkProcessForwardMoschkExecTest_exec.class,
    // H_新契約 工程 新契約工程遷移（ペーパーレス申込入力）
    SkProcessForwardPaperlessMousikomiTest_kouteiSeni.class,
    // H_新契約 工程 新契約工程遷移（成立保留処理）
    SkProcessForwardSeirituHoryuuTest_exec.class,
    // H_新契約 工程 新契約工程遷移（変更訂正）
    SkProcessForwardTeiseiTest_exec.class,
    // H_新契約 工程 新契約工程遷移（特認処理）
    SkProcessForwardTokuninTest_exec.class,
    // H_新契約 工程 新契約工程情報更新
    SkProcessUpdateTest_all.class,
    // H_新契約 書類到着 新契約書類到着時管理情報取得処理
    SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo.class,
    // H_新契約 申込内容チェック 保険料有効期限チェック(再対応要)
    CheckHokenRyouYuukouKigenTest_exec.class,

})
public class TestAll_Sinkeiyaku {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
