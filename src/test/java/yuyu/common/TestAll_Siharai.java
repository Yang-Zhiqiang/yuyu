package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.siharai.chksk.ChkSubDoujiSeikyuuSyoriTest_exec;
import yuyu.common.siharai.chksk.ChkSubHansyaTest_exec;
import yuyu.common.siharai.chksk.ChkSubHigaitouTest_exec;
import yuyu.common.siharai.chksk.ChkSubHusyounosiTest_exec;
import yuyu.common.siharai.chksk.ChkSubKijyunYmdTest_exec;
import yuyu.common.siharai.chksk.ChkSubMrInfoTest_exec;
import yuyu.common.siharai.chksk.ChkSubNenkinSkTest_exec;
import yuyu.common.siharai.chksk.ChkSubShskInfoTest_exec;
import yuyu.common.siharai.chksk.ChkSubSinkensyaInfoTest_exec;
import yuyu.common.siharai.chksk.ChkSubSinsaTyuuiTest_exec;
import yuyu.common.siharai.chksk.ChkSubSkSyoruiTest_exec;
import yuyu.common.siharai.chksk.ChkSubSksInfoTest_exec;
import yuyu.common.siharai.chksk.ChkSubSksyaInfoTest_exec;
import yuyu.common.siharai.chksk.ChkSubStknsetTest_exec;
import yuyu.common.siharai.chksk.ChkSubSyoumetuTest_exec;
import yuyu.common.siharai.chksk.ChkSubhassoKbnTest_exec;
import yuyu.common.siharai.chksk.SiSKNaiyouChkkekkaSetteiTest_exec;
import yuyu.common.siharai.chksk.SiSateiKmkChkkekkaSetteiTest_exec;
import yuyu.common.siharai.koutei.SiGetSyoruittykymdTest_exec;
import yuyu.common.siharai.koutei.SiProcessForwardTest_exec;
import yuyu.common.siharai.prereport.SiharaiPreReportOperateProcessTest_operateProcess;
import yuyu.common.siharai.renkei.SiharaiWorklistViewValuesCreatorTest_create;
import yuyu.common.siharai.sicommon.BetuskSyorityuChkTest_exec;
import yuyu.common.siharai.sicommon.CalcHkHtykeihiTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkTest_exec;
import yuyu.common.siharai.sicommon.DouituSyonoStyChkTest_exec;
import yuyu.common.siharai.sicommon.EditRrkTest_exec;
import yuyu.common.siharai.sicommon.EditSateiRrkTblTest_exec;
import yuyu.common.siharai.sicommon.EditSiharaiRirekiTblTest_exec;
import yuyu.common.siharai.sicommon.HanteiSateiRankTest_exec;
import yuyu.common.siharai.sicommon.SateiKekkaNyuuryokuChkTest_exec;
import yuyu.common.siharai.sicommon.SetteiDoujiSkInfoTest_exec;
import yuyu.common.siharai.sicommon.SetteiShrhousiteiKbnTest_exec;
import yuyu.common.siharai.sicommon.SiCommonSiwakeTest_exec;
import yuyu.common.siharai.sicommon.SiEditFbTest_exec;
import yuyu.common.siharai.sicommon.SiKinouModeSetteiTest_exec;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditDaihyousennintodokeTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditEnkaryuuiTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditHubiTeiseisyoTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditHubiteiseisyosouhuannaiTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditJikojyokyouhoukokusyoTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditKakuniniraisyoTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditMynumberCTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditSeikyuusyoTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditSeisankinhurikomiiraisyoTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyoTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditSouhuannaiTest_exec;
import yuyu.common.siharai.syoruitoutyaku.SiharaiSyoruitoutyakuOperateProcessTest_all;

/**
 * 全メソッド（保険金給付金支払）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    /** 2017/8/22 */
    // 保険金給付金支払 請求内容チェック 請求者情報チェック
    ChkSubSksyaInfoTest_exec.class,
    // 保険金給付金支払 請求内容チェック ＭＲ情報チェック
    ChkSubMrInfoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書の送付案内編集
    EditHubiteiseisyosouhuannaiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 手続履歴TBL編集
    EditRrkTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 保険金給付金機能モード設定
    SiKinouModeSetteiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 保険金給付金ＦＢ送金データTBL編集
    SiEditFbTest_exec.class,
    // 保険金給付金支払 工程 支払書類到着日取得
    SiGetSyoruittykymdTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書編集
    EditEnkaryuuiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 事故状況報告書編集
    SiharaiWorklistViewValuesCreatorTest_create.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 マイナンバー申告書（Ｃ票）編集
    BetuskSyorityuChkTest_exec.class,
    // 保険金給付金支払 請求内容チェック 不詳の死チェック
    ChkSubDoujiSeikyuuSyoriTest_exec.class,
    // 保険金給付金支払 請求内容チェック 非該当チェック
    ChkSubSinkensyaInfoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 確認依頼書編集
    EditKakuniniraisyoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 同一証券番号進捗チェック
    DouituSyonoStyChkTest_exec.class,
    // 保険金給付金支払 請求内容チェック 質権設定チェック
    ChkSubStknsetTest_exec.class,
    // 保険金給付金支払 請求内容チェック 消滅チェック
    ChkSubSyoumetuTest_exec.class,
    // 保険金給付金支払 請求内容チェック 送付先情報チェック
    ChkSubShskInfoTest_exec.class,
    // 保険金給付金支払 請求内容チェック 請求内容チェック結果設定処理
    SiSKNaiyouChkkekkaSetteiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 支払履歴TBL編集
    EditSiharaiRirekiTblTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 査定承認履歴TBL編集
    EditSateiRrkTblTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 同時請求情報設定
    SetteiDoujiSkInfoTest_exec.class,
    // 保険金給付金支払 請求内容チェック 審査注意チェック
    ChkSubSinsaTyuuiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書編集
    EditHubiTeiseisyoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 事故状況報告書編集
    EditJikojyokyouhoukokusyoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 マイナンバー申告書（Ｃ票）編集
    EditMynumberCTest_exec.class,
    // 保険金給付金支払 請求内容チェック 不詳の死チェック
    ChkSubHusyounosiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 非該当チェック
    ChkSubHigaitouTest_exec.class,
    // 保険金給付金支払 請求内容チェック 年金請求チェック
    ChkSubNenkinSkTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 送付案内編集
    EditSouhuannaiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 支払方法指定区分設定
    SetteiShrhousiteiKbnTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 保険金給付金仕訳共通処理
    SiCommonSiwakeTest_exec.class,
    // 保険金給付金支払 帳票前処理 保険金給付金支払帳票作成前工程操作処理
    SiharaiPreReportOperateProcessTest_operateProcess.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 代表選任届編集
    EditDaihyousennintodokeTest_exec.class,
    // 保険金給付金支払 請求内容チェック 発送区分チェック
    ChkSubhassoKbnTest_exec.class,
    // 保険金給付金支払 請求内容チェック 反社チェック
    ChkSubHansyaTest_exec.class,
    // 保険金給付金支払 請求内容チェック 基準日チェック
    ChkSubKijyunYmdTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 査定ランク判定
    HanteiSateiRankTest_exec.class,
    // 保険金給付金支払 請求内容チェック 送金先情報チェック
    ChkSubSksInfoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 査定結果入力チェッククラス
    SateiKekkaNyuuryokuChkTest_exec.class,
    // 保険金給付金支払 工程 支払工程遷移
    SiProcessForwardTest_exec.class,
    // 保険金給付金支払 請求内容チェック 査定項目チェック結果設定処理
    SiSateiKmkChkkekkaSetteiTest_exec.class,
    // 保険金給付金支払 請求内容チェック 請求書類チェック
    ChkSubSkSyoruiTest_exec.class,
    // 保険金給付金支払 書類到着 保険金給付金支払書類到着時工程操作処理
    SiharaiSyoruitoutyakuOperateProcessTest_all.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 請求書編集
    EditSeikyuusyoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 精算金振込依頼書編集
    EditSeisankinhurikomiiraisyoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 保険金必要経費計算
    CalcHkHtykeihiTest_exec.class,
    // 保険金給付金支払 保険金給付金支払帳票編集 支払明細書編集
    EditSiharaimeisaisyoTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 支払金額計算
    SiSiharaiKingakuKeisanTest_exec.class,
    // 保険金給付金支払 保険金給付金支払共通 保険金額計算
    CalcHkShrKngkTest_exec.class

})
public class TestAll_Siharai {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
