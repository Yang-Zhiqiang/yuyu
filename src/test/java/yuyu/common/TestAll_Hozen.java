package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.hozen.khcommon.CheckFatcaTest_exec;
import yuyu.common.hozen.khcommon.CheckMaxSStaniTest_exec;
import yuyu.common.hozen.khcommon.CheckMinSTest_exec;
import yuyu.common.hozen.khcommon.CheckNenreiHaniTest_exec;
import yuyu.common.hozen.khcommon.CheckProcessKaishiTest_exec;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiTest_exec;
import yuyu.common.hozen.khcommon.CheckYuuyokkngaiTest_exec;
import yuyu.common.hozen.khcommon.CommonSiwakeTest_exec;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTblTest_All;
import yuyu.common.hozen.khcommon.EditJimuRenrakuhyouTblTest_editBean;
import yuyu.common.hozen.khcommon.EditKhHenkouRirekiTblTest_All;
import yuyu.common.hozen.khcommon.EditKhMisslstTblTest_editBean;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiTblTest_All;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTblTest_exec;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTblTest_All;
import yuyu.common.hozen.khcommon.EditPdfHubiMikaiTest_exec;
import yuyu.common.hozen.khcommon.EditSeikyuusyoTblTest_editBean;
import yuyu.common.hozen.khcommon.EditSouhuannaiTblTest_editBean;
import yuyu.common.hozen.khcommon.EditSuiihyouTblTest_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTbltest_editTBL;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_all;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblTest_exec;
import yuyu.common.hozen.khcommon.HanteiSyoriKengenTest_exec;
import yuyu.common.hozen.khcommon.HanteiTetudukiTest_exec;
import yuyu.common.hozen.khcommon.KeisanCVTest_exec;
import yuyu.common.hozen.khcommon.KeisanHtyKeihiTest_exec;
import yuyu.common.hozen.khcommon.KeisanKhGensenTest_exec;
import yuyu.common.hozen.khcommon.KeisanKihrkPTest_exec;
import yuyu.common.hozen.khcommon.KeisanKoujyogakuTest_exce;
import yuyu.common.hozen.khcommon.KeisanSPTest_exec;
import yuyu.common.hozen.khcommon.KeisanSiharaibiTest_Exec;
import yuyu.common.hozen.khcommon.KeisanTienRisokuTest_exec;
import yuyu.common.hozen.khcommon.KhCheckKouzaTest_chkSoukinsakiKouza;
import yuyu.common.hozen.khcommon.PALBetuSakuinSyoukaiTest_exec;
import yuyu.common.hozen.khcommon.SetDenSimebiTest_Exec;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobiTest_exec;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisanTest_exec;
import yuyu.common.hozen.khcommon.TableMaintenanceUtilTest_backUp;
import yuyu.common.hozen.khcommon.TokujoSSakugenNaiyouKeisanTest_exec;
import yuyu.common.hozen.khcommon.WSuiihyouTest_exec;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiTest_exec;
import yuyu.common.hozen.koutei.KhProcessForwardTest_exec;
import yuyu.common.hozen.prereport.HozenPreReportOperateProcessTest_OperateProcess;
import yuyu.common.hozen.renkei.HozenWorklistViewValuesCreatorTest_create;
import yuyu.common.hozen.setuibean.SetBetukykTest_All;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_All;
import yuyu.common.hozen.setuibean.SetHihokensyaTest_All;
import yuyu.common.hozen.setuibean.SetHituyouSyoruiTest_All;
import yuyu.common.hozen.setuibean.SetHosyouTest_All;
import yuyu.common.hozen.setuibean.SetKeiyakusyaTest_All;
import yuyu.common.hozen.setuibean.SetKeizokuNkuktTest_All;
import yuyu.common.hozen.setuibean.SetKhTkshrSiharaiKouzaTest_All;
import yuyu.common.hozen.setuibean.SetKihonTest_All;
import yuyu.common.hozen.setuibean.SetNkuktTest_All;
import yuyu.common.hozen.setuibean.SetSbHenkanuktTest_All;
import yuyu.common.hozen.setuibean.SetSbHkuktTest_All;
import yuyu.common.hozen.setuibean.SetSiteiseikyuuTest_All;
import yuyu.common.hozen.setuibean.SetSonotaTkTest_All;
import yuyu.common.hozen.setuibean.SetTetudukityuuiTest_All;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiTest_exec;
import yuyu.common.hozen.setuibean.SetTuusinsakiTest_All;
import yuyu.common.hozen.syoruitoutyaku.HozenSyoruitoutyakuOperateProcessTest_All;

/**
 * 全メソッド（契約保全）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    // 契約保全 UiBean設定 継続年金受取人情報設定
    SetKeizokuNkuktTest_All.class,
    // 契約保全 契約保全共通 取扱年齢範囲チェック
    CheckNenreiHaniTest_exec.class,
    // 契約保全 UiBean設定 通信先情報設定UiBean
    SetTuusinsakiTest_All.class,
    // 契約保全 契約保全共通 商品単位更新後保険料計算
    SyouhntaniKousingoPkeisanTest_exec.class,
    // 契約保全 契約保全共通 既払込Ｐ計算
    KeisanKihrkPTest_exec.class,
    // 契約保全 契約保全共通 ミスリストTBL編集
    EditKhMisslstTblTest_editBean.class,
    // 契約保全 契約保全共通 代理店手数料情報TBL編集
    EditDairitenTesuuryouTblTest_All.class,
    // 契約保全 契約保全共通 控除証明書TBL編集
    EditKoujyoSyoumeiTblTest_All.class,
    // 契約保全 契約保全共通 手続注意判定
    HanteiTetudukiTest_exec.class,
    // 契約保全 UiBean設定 基本情報設定
    SetKihonTest_All.class,
    // 契約保全 UiBean設定 年金受取人情報設定
    SetNkuktTest_All.class,
    // 契約保全 契約保全共通 有効状態チェック
    CheckYuukouJyoutaiTest_exec.class,
    // 契約保全 契約保全共通 仕訳共通処理
    CommonSiwakeTest_exec.class,
    // 契約保全 UiBean設定 手続注意情報設定
    SetTetudukityuuiTest_All.class,
    // 契約保全 UiBean設定 契約者情報設定
    SetKeiyakusyaTest_All.class,
    // 契約保全 UiBean設定 定期支払金支払先口座情報設定
    SetKhTkshrSiharaiKouzaTest_All.class,
    // 契約保全 UiBean設定 その他特約特則設定
    SetSonotaTkTest_All.class,
    // 契約保全 契約保全共通 必要経費計算
    KeisanHtyKeihiTest_exec.class,
    // 契約保全 UiBean設定 被保険者情報設定
    SetHihokensyaTest_All.class,
    // 契約保全 契約保全共通 最低Ｓチェック
    CheckMinSTest_exec.class,
    // 契約保全 契約保全共通 最高ＳＳ単位チェック
    CheckMaxSStaniTest_exec.class,
    // 契約保全 UiBean設定 死亡保険金受取人情報設定
    SetSbHkuktTest_All.class,
    // 契約保全 契約保全共通 FATCA対象チェック
    CheckFatcaTest_exec.class,
    // I_契約保全 契約保全共通 契約商品履歴TBL編集
    EditKykSyhnRirekiTblTest_All.class,
    // I_契約保全 契約保全共通 送付案内TBL編集
    EditSouhuannaiTblTest_editBean.class,
    // I_契約保全 契約保全共通 手続履歴TBL編集
    EditTtdkRirekiTblTest_exec.class,
    // I_契約保全 UiBean設定 払込情報設定
    SetHaraikomiInfoTest_All.class,
    // I_契約保全 UiBean設定 必要書類設定
    SetHituyouSyoruiTest_All.class,
    // I_契約保全 UiBean設定 指定代理請求人情報設定
    SetSiteiseikyuuTest_All.class,
    // I_契約保全 契約保全共通 解約返戻金推移表作成
    WSuiihyouTest_exec.class,
    // I_契約保全 UiBean設定 死亡返還金受取人情報設定
    SetSbHenkanuktTest_All.class,
    // I_契約保全 契約保全共通 請求書TBL編集
    EditSeikyuusyoTblTest_editBean.class,
    // I_契約保全 工程 契約保全必要書類判定
    KhHituyousyoruiHanteiTest_exec.class,
    // I_契約保全 書類到着 契約保全書類到着時工程操作処理
    HozenSyoruitoutyakuOperateProcessTest_All.class,
    // I_契約保全 工程 契約保全工程遷移
    KhProcessForwardTest_exec.class,
    // I_契約保全 契約保全共通 変額積立金計算
    KeisanCVTest_exec.class,
    // I_契約保全 契約保全共通 源泉徴収額計算
    KeisanKhGensenTest_exec.class,
    // I_契約保全 契約保全共通 猶予期間外チェック
    CheckYuuyokkngaiTest_exec.class,
    // I_契約保全 契約保全共通 伝票締切日設定
    SetDenSimebiTest_Exec.class,
    // I_契約保全 契約保全共通 ＰＡＬ別口索引照会
    PALBetuSakuinSyoukaiTest_exec.class,
    // I_契約保全 契約保全共通 控除証明額計算
    KeisanKoujyogakuTest_exce.class,
    // I_契約保全 契約保全共通 SP計算
    KeisanSPTest_exec.class,
    // I_契約保全 UiBean設定 保障内容設定
    SetHosyouTest_All.class,
    // I_契約保全 契約保全共通 口座情報入力チェック
    KhCheckKouzaTest_chkSoukinsakiKouza.class,
    // I_契約保全 契約保全共通 処理権限判定
    HanteiSyoriKengenTest_exec.class,
    // I_契約保全 サブシステム連携 契約保全ワークリスト用表示情報生成
    HozenWorklistViewValuesCreatorTest_create.class,
    // I_契約保全 契約保全共通 事務連絡票TBL編集
    EditJimuRenrakuhyouTblTest_editBean.class,
    // 契約保全 契約保全共通 不備未解消リストPDF作成
    EditPdfHubiMikaiTest_exec.class,
    // 契約保全 契約保全共通 契約保全工程開始チェック
    CheckProcessKaishiTest_exec.class,
    // 契約保全 契約保全共通 控除証明内容TBL編集
    EditKoujyonaiyouTblTest_exec.class,
    // 契約保全 契約保全共通 特条保険金削減内容計算
    TokujoSSakugenNaiyouKeisanTest_exec.class,
    // 契約保全 帳票前処理 契約保全帳票作成前工程操作処理
    HozenPreReportOperateProcessTest_OperateProcess.class,
    // 契約保全 契約保全共通 支払遅延利息計算
    KeisanTienRisokuTest_exec.class,
    // 契約保全 契約保全共通 猶予期間満了日設定
    SetYuuyokknmanryobiTest_exec.class,
    // 契約保全 契約保全共通 契約保全変更履歴TBL編集
    EditKhHenkouRirekiTblTest_All.class,
    // 契約保全 UiBean設定 取扱注意設定
    SetToriatukaiTyuuiTest_exec.class,
    // 契約保全 契約保全共通 保険証券TBL編集
    EditSyoukenTbltest_editTBL.class,
    // 契約保全 契約保全共通 手続完了TBL編集
    EditTtdkKanryouTblTest_all.class,
    // 契約保全 契約保全共通 推移表ＴＢＬ編集
    EditSuiihyouTblTest_editTBL.class,
    // 契約保全 契約保全共通 支払日計算
    KeisanSiharaibiTest_Exec.class,
    // 契約保全 契約保全共通 テーブルメンテナンスユーティリティ
    TableMaintenanceUtilTest_backUp.class,
    // 契約保全 UiBean設定 別契約情報設定
    SetBetukykTest_All.class,

})
public class TestAll_Hozen {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
