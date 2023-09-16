package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_KsktkanKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincdatasousinKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_Lincsousinflg;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MosUktkErrKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_TyhysakuseiKbn;
import yuyu.def.classification.C_UktkakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.id.PKHT_SyoriCTL;
import yuyu.def.db.meta.GenQHT_SyoriCTL;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.db.type.UserType_C_AeoiKekkaKbn;
import yuyu.def.db.type.UserType_C_CreditTrkjkKbn;
import yuyu.def.db.type.UserType_C_CreditYuukoukakKbn;
import yuyu.def.db.type.UserType_C_FatcakakkekkaKbn;
import yuyu.def.db.type.UserType_C_HubikaisyoujoutaiKbn;
import yuyu.def.db.type.UserType_C_ImusateijyouKbn;
import yuyu.def.db.type.UserType_C_ImusateikaniyhKbn;
import yuyu.def.db.type.UserType_C_JimusrhKbn;
import yuyu.def.db.type.UserType_C_KetteiKbn;
import yuyu.def.db.type.UserType_C_Knkysatei1jiyhKbn;
import yuyu.def.db.type.UserType_C_Knkysatei2jiyhKbn;
import yuyu.def.db.type.UserType_C_KnkysateijyouKbn;
import yuyu.def.db.type.UserType_C_KoukankykKbn;
import yuyu.def.db.type.UserType_C_KouseiinkykKbn;
import yuyu.def.db.type.UserType_C_KsktkanKbn;
import yuyu.def.db.type.UserType_C_KykkakjkKbn;
import yuyu.def.db.type.UserType_C_LincdatasousinKbn;
import yuyu.def.db.type.UserType_C_LincgthtkekKbn;
import yuyu.def.db.type.UserType_C_LincjkKbn;
import yuyu.def.db.type.UserType_C_LinckknnjkKbn;
import yuyu.def.db.type.UserType_C_Lincsousinflg;
import yuyu.def.db.type.UserType_C_Mfrenflg;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_MosUktkErrKbn;
import yuyu.def.db.type.UserType_C_MostenkenjyouKbn;
import yuyu.def.db.type.UserType_C_MostenkenyhKbn;
import yuyu.def.db.type.UserType_C_NyuukinjyoutaiKbn;
import yuyu.def.db.type.UserType_C_SateijtKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SyssrhKbn;
import yuyu.def.db.type.UserType_C_TkhjnKbn;
import yuyu.def.db.type.UserType_C_TyhysakuseiKbn;
import yuyu.def.db.type.UserType_C_UktkakKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_UriagesousinKbn;
import yuyu.def.db.type.UserType_C_VrfjkKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 処理コントロールテーブル テーブルのマッピング情報クラスで、 {@link HT_SyoriCTL} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SyoriCTL}</td><td colspan="3">処理コントロールテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SyoriCTL ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaisyacd kaisyacd}</td><td>会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosuketukekbn mosuketukekbn}</td><td>申込受付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MosUketukeKbn}</td></tr>
 *  <tr><td>{@link #getMosuktkerrkbn mosuktkerrkbn}</td><td>申込受付エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MosUktkErrKbn}</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getMosnrkumu mosnrkumu}</td><td>申込書入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMosnrkvrfjkkbn mosnrkvrfjkkbn}</td><td>申込書入力ベリファイ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_VrfjkKbn}</td></tr>
 *  <tr><td>{@link #getMosnrkymd mosnrkymd}</td><td>申込書入力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKznrkumu kznrkumu}</td><td>口座情報入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKznrkhbumu kznrkhbumu}</td><td>口座情報入力不備有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKznrkvrfjkkbn kznrkvrfjkkbn}</td><td>口座情報入力ベリファイ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_VrfjkKbn}</td></tr>
 *  <tr><td>{@link #getDntnrkumu dntnrkumu}</td><td>団体承認書入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSdnnrkumu sdnnrkumu}</td><td>集団扱加入申込書入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktnrkumu kktnrkumu}</td><td>告知書入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktnrkhbumu kktnrkhbumu}</td><td>告知書入力不備有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktnrkvrfjkkbn kktnrkvrfjkkbn}</td><td>告知書入力ベリファイ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_VrfjkKbn}</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHjynrkumu hjynrkumu}</td><td>報状入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHjynrkhbumu hjynrkhbumu}</td><td>報状入力不備有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNyknnrkumu nyknnrkumu}</td><td>入金入力有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNyuukinjoutaikbn nyuukinjoutaikbn}</td><td>入金状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuukinjyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyknkwsratekijyunymd nyknkwsratekijyunymd}</td><td>入金用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyknkwsrate nyknkwsrate}</td><td>入金用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getAuthorikakymd authorikakymd}</td><td>オーソリ確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUriagesousinkbn uriagesousinkbn}</td><td>売上送信区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UriagesousinKbn}</td></tr>
 *  <tr><td>{@link #getCredittrkjkkbn credittrkjkkbn}</td><td>クレジットカード登録状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditTrkjkKbn}</td></tr>
 *  <tr><td>{@link #getCredityuukoukakkbn credityuukoukakkbn}</td><td>クレジットカード有効確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditYuukoukakKbn}</td></tr>
 *  <tr><td>{@link #getMostenken1jiyhkbn mostenken1jiyhkbn}</td><td>申込点検（１次）要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MostenkenyhKbn}</td></tr>
 *  <tr><td>{@link #getMostenken2jiyhkbn mostenken2jiyhkbn}</td><td>申込点検（２次）要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MostenkenyhKbn}</td></tr>
 *  <tr><td>{@link #getMostenken3jiyhkbn mostenken3jiyhkbn}</td><td>申込点検（３次）要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MostenkenyhKbn}</td></tr>
 *  <tr><td>{@link #getMostenkenrrkumu mostenkenrrkumu}</td><td>申込点検履歴有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMostenkenjoukbn mostenkenjoukbn}</td><td>申込点検状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MostenkenjyouKbn}</td></tr>
 *  <tr><td>{@link #getKnkysatei1jiyhkbn knkysatei1jiyhkbn}</td><td>環境査定（１次）要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Knkysatei1jiyhKbn}</td></tr>
 *  <tr><td>{@link #getKnkysatei2jiyhkbn knkysatei2jiyhkbn}</td><td>環境査定（２次）要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Knkysatei2jiyhKbn}</td></tr>
 *  <tr><td>{@link #getKnkysateirrkumu knkysateirrkumu}</td><td>環境査定履歴有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKnkysateijyoukbn knkysateijyoukbn}</td><td>環境査定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnkysateijyouKbn}</td></tr>
 *  <tr><td>{@link #getImusateikaniyhkbn imusateikaniyhkbn}</td><td>医務査定（簡易）要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ImusateikaniyhKbn}</td></tr>
 *  <tr><td>{@link #getImusateirrkumu imusateirrkumu}</td><td>医務査定履歴有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getImusateijyoukbn imusateijyoukbn}</td><td>医務査定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ImusateijyouKbn}</td></tr>
 *  <tr><td>{@link #getMihassinhubiumu mihassinhubiumu}</td><td>未発信不備有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHubikaisyoujoutaikbn hubikaisyoujoutaikbn}</td><td>不備解消状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HubikaisyoujoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKthhbkbn kthhbkbn}</td><td>決定保留不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSrhhbkbn srhhbkbn}</td><td>成立保留不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKhnhbkbn khnhbkbn}</td><td>基本不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykkakjkkbn kykkakjkkbn}</td><td>契約確認状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykkakjkKbn}</td></tr>
 *  <tr><td>{@link #getKetteikbn ketteikbn}</td><td>決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KetteiKbn}</td></tr>
 *  <tr><td>{@link #getSateijtkbn sateijtkbn}</td><td>査定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SateijtKbn}</td></tr>
 *  <tr><td>{@link #getSateizumiymd sateizumiymd}</td><td>査定済日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDoujimosumu doujimosumu}</td><td>同時申込有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPaldoujimosumu paldoujimosumu}</td><td>ＰＡＬ同時申込有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getRaydoujimosumu raydoujimosumu}</td><td>ＲＡＹ同時申込有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getLincgthtkekkbn lincgthtkekkbn}</td><td>ＬＩＮＣ該当判定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LincgthtkekKbn}</td></tr>
 *  <tr><td>{@link #getLincjkkbn lincjkkbn}</td><td>ＬＩＮＣ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LincjkKbn}</td></tr>
 *  <tr><td>{@link #getLincsousinflg lincsousinflg}</td><td>ＬＩＮＣ送信済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Lincsousinflg}</td></tr>
 *  <tr><td>{@link #getLinckknnjkkbn linckknnjkkbn}</td><td>ＬＩＮＣ確認状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LinckknnjkKbn}</td></tr>
 *  <tr><td>{@link #getLincdatasousinkbn lincdatasousinkbn}</td><td>ＬＩＮＣデータ送信区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LincdatasousinKbn}</td></tr>
 *  <tr><td>{@link #getUktkakkbn uktkakkbn}</td><td>受取人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkakKbn}</td></tr>
 *  <tr><td>{@link #getTkhjnkbn tkhjnkbn}</td><td>特定関係法人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkhjnKbn}</td></tr>
 *  <tr><td>{@link #getTktkhjnkakuninyouhikbn tktkhjnkakuninyouhikbn}</td><td>特定関係法人確認要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getKouseiinkykkbn kouseiinkykkbn}</td><td>構成員契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouseiinkykKbn}</td></tr>
 *  <tr><td>{@link #getKoukankykkbn koukankykkbn}</td><td>交換契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoukankykKbn}</td></tr>
 *  <tr><td>{@link #getFatcakakkekkakbn fatcakakkekkakbn}</td><td>ＦＡＴＣＡ確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcakakkekkaKbn}</td></tr>
 *  <tr><td>{@link #getAeoikekkakbn aeoikekkakbn}</td><td>ＡＥＯＩ結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoiKekkaKbn}</td></tr>
 *  <tr><td>{@link #getTkhsyouryakuumukbn tkhsyouryakuumukbn}</td><td>通計保留省略有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykksktkankbn kykksktkankbn}</td><td>契約者強制決定判定完了区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KsktkanKbn}</td></tr>
 *  <tr><td>{@link #getHhknksktkankbn hhknksktkankbn}</td><td>被保険者強制決定判定完了区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KsktkanKbn}</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMinyknkurikosiumu minyknkurikosiumu}</td><td>未入金繰越有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKettienkurikosiumu kettienkurikosiumu}</td><td>決定遅延繰越有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSrhkurikosiumu srhkurikosiumu}</td><td>成立保留繰越有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMfrenflg mfrenflg}</td><td>ＭＦ連動済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Mfrenflg}</td></tr>
 *  <tr><td>{@link #getMfrenymd mfrenymd}</td><td>ＭＦ連動日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJimusrhkbn jimusrhkbn}</td><td>事務成立保留区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JimusrhKbn}</td></tr>
 *  <tr><td>{@link #getSyssrhkbn syssrhkbn}</td><td>システム成立保留区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyssrhKbn}</td></tr>
 *  <tr><td>{@link #getAnnaisakuseikbn annaisakuseikbn}</td><td>送付案内作成状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhysakuseiKbn}</td></tr>
 *  <tr><td>{@link #getAnnaikaisuu annaikaisuu}</td><td>案内回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkbtkktumu tkbtkktumu}</td><td>特別告知有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKansyoutuutiyhkbn kansyoutuutiyhkbn}</td><td>勧奨通知作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getLastkossyoricd lastkossyoricd}</td><td>最終更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteirirituhenkourenrakuymd yoteirirituhenkourenrakuymd}</td><td>予定利率変更連絡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     HT_SyoriCTL
 * @see     PKHT_SyoriCTL
 * @see     QHT_SyoriCTL
 * @see     GenQHT_SyoriCTL
 */
@MappedSuperclass
@Table(name=GenHT_SyoriCTL.TABLE_NAME)
@IdClass(value=PKHT_SyoriCTL.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AeoiKekkaKbn", typeClass=UserType_C_AeoiKekkaKbn.class),
    @TypeDef(name="UserType_C_CreditTrkjkKbn", typeClass=UserType_C_CreditTrkjkKbn.class),
    @TypeDef(name="UserType_C_CreditYuukoukakKbn", typeClass=UserType_C_CreditYuukoukakKbn.class),
    @TypeDef(name="UserType_C_FatcakakkekkaKbn", typeClass=UserType_C_FatcakakkekkaKbn.class),
    @TypeDef(name="UserType_C_HubikaisyoujoutaiKbn", typeClass=UserType_C_HubikaisyoujoutaiKbn.class),
    @TypeDef(name="UserType_C_ImusateijyouKbn", typeClass=UserType_C_ImusateijyouKbn.class),
    @TypeDef(name="UserType_C_ImusateikaniyhKbn", typeClass=UserType_C_ImusateikaniyhKbn.class),
    @TypeDef(name="UserType_C_JimusrhKbn", typeClass=UserType_C_JimusrhKbn.class),
    @TypeDef(name="UserType_C_KetteiKbn", typeClass=UserType_C_KetteiKbn.class),
    @TypeDef(name="UserType_C_Knkysatei1jiyhKbn", typeClass=UserType_C_Knkysatei1jiyhKbn.class),
    @TypeDef(name="UserType_C_Knkysatei2jiyhKbn", typeClass=UserType_C_Knkysatei2jiyhKbn.class),
    @TypeDef(name="UserType_C_KnkysateijyouKbn", typeClass=UserType_C_KnkysateijyouKbn.class),
    @TypeDef(name="UserType_C_KoukankykKbn", typeClass=UserType_C_KoukankykKbn.class),
    @TypeDef(name="UserType_C_KouseiinkykKbn", typeClass=UserType_C_KouseiinkykKbn.class),
    @TypeDef(name="UserType_C_KsktkanKbn", typeClass=UserType_C_KsktkanKbn.class),
    @TypeDef(name="UserType_C_KykkakjkKbn", typeClass=UserType_C_KykkakjkKbn.class),
    @TypeDef(name="UserType_C_LincdatasousinKbn", typeClass=UserType_C_LincdatasousinKbn.class),
    @TypeDef(name="UserType_C_LincgthtkekKbn", typeClass=UserType_C_LincgthtkekKbn.class),
    @TypeDef(name="UserType_C_LincjkKbn", typeClass=UserType_C_LincjkKbn.class),
    @TypeDef(name="UserType_C_LinckknnjkKbn", typeClass=UserType_C_LinckknnjkKbn.class),
    @TypeDef(name="UserType_C_Lincsousinflg", typeClass=UserType_C_Lincsousinflg.class),
    @TypeDef(name="UserType_C_Mfrenflg", typeClass=UserType_C_Mfrenflg.class),
    @TypeDef(name="UserType_C_MosUketukeKbn", typeClass=UserType_C_MosUketukeKbn.class),
    @TypeDef(name="UserType_C_MosUktkErrKbn", typeClass=UserType_C_MosUktkErrKbn.class),
    @TypeDef(name="UserType_C_MostenkenjyouKbn", typeClass=UserType_C_MostenkenjyouKbn.class),
    @TypeDef(name="UserType_C_MostenkenyhKbn", typeClass=UserType_C_MostenkenyhKbn.class),
    @TypeDef(name="UserType_C_NyuukinjyoutaiKbn", typeClass=UserType_C_NyuukinjyoutaiKbn.class),
    @TypeDef(name="UserType_C_SateijtKbn", typeClass=UserType_C_SateijtKbn.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class),
    @TypeDef(name="UserType_C_SyssrhKbn", typeClass=UserType_C_SyssrhKbn.class),
    @TypeDef(name="UserType_C_TkhjnKbn", typeClass=UserType_C_TkhjnKbn.class),
    @TypeDef(name="UserType_C_TyhysakuseiKbn", typeClass=UserType_C_TyhysakuseiKbn.class),
    @TypeDef(name="UserType_C_UktkakKbn", typeClass=UserType_C_UktkakKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_UriagesousinKbn", typeClass=UserType_C_UriagesousinKbn.class),
    @TypeDef(name="UserType_C_VrfjkKbn", typeClass=UserType_C_VrfjkKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenHT_SyoriCTL extends AbstractExDBEntity<HT_SyoriCTL, PKHT_SyoriCTL> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SyoriCTL";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String KAISYACD                 = "kaisyacd";
    public static final String MOSUKETUKEKBN            = "mosuketukekbn";
    public static final String MOSUKTKERRKBN            = "mosuktkerrkbn";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String MOSNRKUMU                = "mosnrkumu";
    public static final String MOSNRKVRFJKKBN           = "mosnrkvrfjkkbn";
    public static final String MOSNRKYMD                = "mosnrkymd";
    public static final String KZNRKUMU                 = "kznrkumu";
    public static final String KZNRKHBUMU               = "kznrkhbumu";
    public static final String KZNRKVRFJKKBN            = "kznrkvrfjkkbn";
    public static final String DNTNRKUMU                = "dntnrkumu";
    public static final String SDNNRKUMU                = "sdnnrkumu";
    public static final String KKTNRKUMU                = "kktnrkumu";
    public static final String KKTNRKHBUMU              = "kktnrkhbumu";
    public static final String KKTNRKVRFJKKBN           = "kktnrkvrfjkkbn";
    public static final String KKTYMD                   = "kktymd";
    public static final String HJYNRKUMU                = "hjynrkumu";
    public static final String HJYNRKHBUMU              = "hjynrkhbumu";
    public static final String NYKNNRKUMU               = "nyknnrkumu";
    public static final String NYUUKINJOUTAIKBN         = "nyuukinjoutaikbn";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String NYKNKWSRATEKIJYUNYMD     = "nyknkwsratekijyunymd";
    public static final String NYKNKWSRATE              = "nyknkwsrate";
    public static final String AUTHORIKAKYMD            = "authorikakymd";
    public static final String URIAGESOUSINKBN          = "uriagesousinkbn";
    public static final String CREDITTRKJKKBN           = "credittrkjkkbn";
    public static final String CREDITYUUKOUKAKKBN       = "credityuukoukakkbn";
    public static final String MOSTENKEN1JIYHKBN        = "mostenken1jiyhkbn";
    public static final String MOSTENKEN2JIYHKBN        = "mostenken2jiyhkbn";
    public static final String MOSTENKEN3JIYHKBN        = "mostenken3jiyhkbn";
    public static final String MOSTENKENRRKUMU          = "mostenkenrrkumu";
    public static final String MOSTENKENJOUKBN          = "mostenkenjoukbn";
    public static final String KNKYSATEI1JIYHKBN        = "knkysatei1jiyhkbn";
    public static final String KNKYSATEI2JIYHKBN        = "knkysatei2jiyhkbn";
    public static final String KNKYSATEIRRKUMU          = "knkysateirrkumu";
    public static final String KNKYSATEIJYOUKBN         = "knkysateijyoukbn";
    public static final String IMUSATEIKANIYHKBN        = "imusateikaniyhkbn";
    public static final String IMUSATEIRRKUMU           = "imusateirrkumu";
    public static final String IMUSATEIJYOUKBN          = "imusateijyoukbn";
    public static final String MIHASSINHUBIUMU          = "mihassinhubiumu";
    public static final String HUBIKAISYOUJOUTAIKBN     = "hubikaisyoujoutaikbn";
    public static final String KTHHBKBN                 = "kthhbkbn";
    public static final String SRHHBKBN                 = "srhhbkbn";
    public static final String KHNHBKBN                 = "khnhbkbn";
    public static final String KYKKAKJKKBN              = "kykkakjkkbn";
    public static final String KETTEIKBN                = "ketteikbn";
    public static final String SATEIJTKBN               = "sateijtkbn";
    public static final String SATEIZUMIYMD             = "sateizumiymd";
    public static final String DOUJIMOSUMU              = "doujimosumu";
    public static final String PALDOUJIMOSUMU           = "paldoujimosumu";
    public static final String RAYDOUJIMOSUMU           = "raydoujimosumu";
    public static final String LINCGTHTKEKKBN           = "lincgthtkekkbn";
    public static final String LINCJKKBN                = "lincjkkbn";
    public static final String LINCSOUSINFLG            = "lincsousinflg";
    public static final String LINCKKNNJKKBN            = "linckknnjkkbn";
    public static final String LINCDATASOUSINKBN        = "lincdatasousinkbn";
    public static final String UKTKAKKBN                = "uktkakkbn";
    public static final String TKHJNKBN                 = "tkhjnkbn";
    public static final String TKTKHJNKAKUNINYOUHIKBN   = "tktkhjnkakuninyouhikbn";
    public static final String KOUSEIINKYKKBN           = "kouseiinkykkbn";
    public static final String KOUKANKYKKBN             = "koukankykkbn";
    public static final String FATCAKAKKEKKAKBN         = "fatcakakkekkakbn";
    public static final String AEOIKEKKAKBN             = "aeoikekkakbn";
    public static final String TKHSYOURYAKUUMUKBN       = "tkhsyouryakuumukbn";
    public static final String KYKKSKTKANKBN            = "kykksktkankbn";
    public static final String HHKNKSKTKANKBN           = "hhknksktkankbn";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String MINYKNKURIKOSIUMU        = "minyknkurikosiumu";
    public static final String KETTIENKURIKOSIUMU       = "kettienkurikosiumu";
    public static final String SRHKURIKOSIUMU           = "srhkurikosiumu";
    public static final String DAIMOSNO                 = "daimosno";
    public static final String MFRENFLG                 = "mfrenflg";
    public static final String MFRENYMD                 = "mfrenymd";
    public static final String JIMUSRHKBN               = "jimusrhkbn";
    public static final String SYSSRHKBN                = "syssrhkbn";
    public static final String ANNAISAKUSEIKBN          = "annaisakuseikbn";
    public static final String ANNAIKAISUU              = "annaikaisuu";
    public static final String TKBTKKTUMU               = "tkbtkktumu";
    public static final String KANSYOUTUUTIYHKBN        = "kansyoutuutiyhkbn";
    public static final String LASTKOSSYORICD           = "lastkossyoricd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String YOTEIRIRITUHENKOURENRAKUYMD = "yoteirirituhenkourenrakuymd";

    private final PKHT_SyoriCTL primaryKey;

    public GenHT_SyoriCTL() {
        primaryKey = new PKHT_SyoriCTL();
    }

    public GenHT_SyoriCTL(String pMosno) {
        primaryKey = new PKHT_SyoriCTL(pMosno);
    }

    @Transient
    @Override
    public PKHT_SyoriCTL getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SyoriCTL> getMetaClass() {
        return QHT_SyoriCTL.class;
    }

    @Id
    @Column(name=GenHT_SyoriCTL.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String syono;

    @Column(name=GenHT_SyoriCTL.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String kaisyacd;

    @Column(name=GenHT_SyoriCTL.KAISYACD)
    public String getKaisyacd() {
        return kaisyacd;
    }

    public void setKaisyacd(String pKaisyacd) {
        kaisyacd = pKaisyacd;
    }

    private C_MosUketukeKbn mosuketukekbn;

    @Type(type="UserType_C_MosUketukeKbn")
    @Column(name=GenHT_SyoriCTL.MOSUKETUKEKBN)
    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private C_MosUktkErrKbn mosuktkerrkbn;

    @Type(type="UserType_C_MosUktkErrKbn")
    @Column(name=GenHT_SyoriCTL.MOSUKTKERRKBN)
    public C_MosUktkErrKbn getMosuktkerrkbn() {
        return mosuktkerrkbn;
    }

    public void setMosuktkerrkbn(C_MosUktkErrKbn pMosuktkerrkbn) {
        mosuktkerrkbn = pMosuktkerrkbn;
    }

    private C_SkeijimuKbn skeijimukbn;

    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenHT_SyoriCTL.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_UmuKbn mosnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.MOSNRKUMU)
    public C_UmuKbn getMosnrkumu() {
        return mosnrkumu;
    }

    public void setMosnrkumu(C_UmuKbn pMosnrkumu) {
        mosnrkumu = pMosnrkumu;
    }

    private C_VrfjkKbn mosnrkvrfjkkbn;

    @Type(type="UserType_C_VrfjkKbn")
    @Column(name=GenHT_SyoriCTL.MOSNRKVRFJKKBN)
    public C_VrfjkKbn getMosnrkvrfjkkbn() {
        return mosnrkvrfjkkbn;
    }

    public void setMosnrkvrfjkkbn(C_VrfjkKbn pMosnrkvrfjkkbn) {
        mosnrkvrfjkkbn = pMosnrkvrfjkkbn;
    }

    private BizDate mosnrkymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.MOSNRKYMD)
    public BizDate getMosnrkymd() {
        return mosnrkymd;
    }

    public void setMosnrkymd(BizDate pMosnrkymd) {
        mosnrkymd = pMosnrkymd;
    }

    private C_UmuKbn kznrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KZNRKUMU)
    public C_UmuKbn getKznrkumu() {
        return kznrkumu;
    }

    public void setKznrkumu(C_UmuKbn pKznrkumu) {
        kznrkumu = pKznrkumu;
    }

    private C_UmuKbn kznrkhbumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KZNRKHBUMU)
    public C_UmuKbn getKznrkhbumu() {
        return kznrkhbumu;
    }

    public void setKznrkhbumu(C_UmuKbn pKznrkhbumu) {
        kznrkhbumu = pKznrkhbumu;
    }

    private C_VrfjkKbn kznrkvrfjkkbn;

    @Type(type="UserType_C_VrfjkKbn")
    @Column(name=GenHT_SyoriCTL.KZNRKVRFJKKBN)
    public C_VrfjkKbn getKznrkvrfjkkbn() {
        return kznrkvrfjkkbn;
    }

    public void setKznrkvrfjkkbn(C_VrfjkKbn pKznrkvrfjkkbn) {
        kznrkvrfjkkbn = pKznrkvrfjkkbn;
    }

    private C_UmuKbn dntnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.DNTNRKUMU)
    public C_UmuKbn getDntnrkumu() {
        return dntnrkumu;
    }

    public void setDntnrkumu(C_UmuKbn pDntnrkumu) {
        dntnrkumu = pDntnrkumu;
    }

    private C_UmuKbn sdnnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.SDNNRKUMU)
    public C_UmuKbn getSdnnrkumu() {
        return sdnnrkumu;
    }

    public void setSdnnrkumu(C_UmuKbn pSdnnrkumu) {
        sdnnrkumu = pSdnnrkumu;
    }

    private C_UmuKbn kktnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KKTNRKUMU)
    public C_UmuKbn getKktnrkumu() {
        return kktnrkumu;
    }

    public void setKktnrkumu(C_UmuKbn pKktnrkumu) {
        kktnrkumu = pKktnrkumu;
    }

    private C_UmuKbn kktnrkhbumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KKTNRKHBUMU)
    public C_UmuKbn getKktnrkhbumu() {
        return kktnrkhbumu;
    }

    public void setKktnrkhbumu(C_UmuKbn pKktnrkhbumu) {
        kktnrkhbumu = pKktnrkhbumu;
    }

    private C_VrfjkKbn kktnrkvrfjkkbn;

    @Type(type="UserType_C_VrfjkKbn")
    @Column(name=GenHT_SyoriCTL.KKTNRKVRFJKKBN)
    public C_VrfjkKbn getKktnrkvrfjkkbn() {
        return kktnrkvrfjkkbn;
    }

    public void setKktnrkvrfjkkbn(C_VrfjkKbn pKktnrkvrfjkkbn) {
        kktnrkvrfjkkbn = pKktnrkvrfjkkbn;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private C_UmuKbn hjynrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.HJYNRKUMU)
    public C_UmuKbn getHjynrkumu() {
        return hjynrkumu;
    }

    public void setHjynrkumu(C_UmuKbn pHjynrkumu) {
        hjynrkumu = pHjynrkumu;
    }

    private C_UmuKbn hjynrkhbumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.HJYNRKHBUMU)
    public C_UmuKbn getHjynrkhbumu() {
        return hjynrkhbumu;
    }

    public void setHjynrkhbumu(C_UmuKbn pHjynrkhbumu) {
        hjynrkhbumu = pHjynrkhbumu;
    }

    private C_UmuKbn nyknnrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.NYKNNRKUMU)
    public C_UmuKbn getNyknnrkumu() {
        return nyknnrkumu;
    }

    public void setNyknnrkumu(C_UmuKbn pNyknnrkumu) {
        nyknnrkumu = pNyknnrkumu;
    }

    private C_NyuukinjyoutaiKbn nyuukinjoutaikbn;

    @Type(type="UserType_C_NyuukinjyoutaiKbn")
    @Column(name=GenHT_SyoriCTL.NYUUKINJOUTAIKBN)
    public C_NyuukinjyoutaiKbn getNyuukinjoutaikbn() {
        return nyuukinjoutaikbn;
    }

    public void setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn pNyuukinjoutaikbn) {
        nyuukinjoutaikbn = pNyuukinjoutaikbn;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private BizDate nyknkwsratekijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.NYKNKWSRATEKIJYUNYMD)
    public BizDate getNyknkwsratekijyunymd() {
        return nyknkwsratekijyunymd;
    }

    public void setNyknkwsratekijyunymd(BizDate pNyknkwsratekijyunymd) {
        nyknkwsratekijyunymd = pNyknkwsratekijyunymd;
    }

    private BizNumber nyknkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SyoriCTL.NYKNKWSRATE)
    public BizNumber getNyknkwsrate() {
        return nyknkwsrate;
    }

    public void setNyknkwsrate(BizNumber pNyknkwsrate) {
        nyknkwsrate = pNyknkwsrate;
    }

    private BizDate authorikakymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.AUTHORIKAKYMD)
    @ValidDate
    public BizDate getAuthorikakymd() {
        return authorikakymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikakymd(BizDate pAuthorikakymd) {
        authorikakymd = pAuthorikakymd;
    }

    private C_UriagesousinKbn uriagesousinkbn;

    @Type(type="UserType_C_UriagesousinKbn")
    @Column(name=GenHT_SyoriCTL.URIAGESOUSINKBN)
    public C_UriagesousinKbn getUriagesousinkbn() {
        return uriagesousinkbn;
    }

    public void setUriagesousinkbn(C_UriagesousinKbn pUriagesousinkbn) {
        uriagesousinkbn = pUriagesousinkbn;
    }

    private C_CreditTrkjkKbn credittrkjkkbn;

    @Type(type="UserType_C_CreditTrkjkKbn")
    @Column(name=GenHT_SyoriCTL.CREDITTRKJKKBN)
    public C_CreditTrkjkKbn getCredittrkjkkbn() {
        return credittrkjkkbn;
    }

    public void setCredittrkjkkbn(C_CreditTrkjkKbn pCredittrkjkkbn) {
        credittrkjkkbn = pCredittrkjkkbn;
    }

    private C_CreditYuukoukakKbn credityuukoukakkbn;

    @Type(type="UserType_C_CreditYuukoukakKbn")
    @Column(name=GenHT_SyoriCTL.CREDITYUUKOUKAKKBN)
    public C_CreditYuukoukakKbn getCredityuukoukakkbn() {
        return credityuukoukakkbn;
    }

    public void setCredityuukoukakkbn(C_CreditYuukoukakKbn pCredityuukoukakkbn) {
        credityuukoukakkbn = pCredityuukoukakkbn;
    }

    private C_MostenkenyhKbn mostenken1jiyhkbn;

    @Type(type="UserType_C_MostenkenyhKbn")
    @Column(name=GenHT_SyoriCTL.MOSTENKEN1JIYHKBN)
    public C_MostenkenyhKbn getMostenken1jiyhkbn() {
        return mostenken1jiyhkbn;
    }

    public void setMostenken1jiyhkbn(C_MostenkenyhKbn pMostenken1jiyhkbn) {
        mostenken1jiyhkbn = pMostenken1jiyhkbn;
    }

    private C_MostenkenyhKbn mostenken2jiyhkbn;

    @Type(type="UserType_C_MostenkenyhKbn")
    @Column(name=GenHT_SyoriCTL.MOSTENKEN2JIYHKBN)
    public C_MostenkenyhKbn getMostenken2jiyhkbn() {
        return mostenken2jiyhkbn;
    }

    public void setMostenken2jiyhkbn(C_MostenkenyhKbn pMostenken2jiyhkbn) {
        mostenken2jiyhkbn = pMostenken2jiyhkbn;
    }

    private C_MostenkenyhKbn mostenken3jiyhkbn;

    @Type(type="UserType_C_MostenkenyhKbn")
    @Column(name=GenHT_SyoriCTL.MOSTENKEN3JIYHKBN)
    public C_MostenkenyhKbn getMostenken3jiyhkbn() {
        return mostenken3jiyhkbn;
    }

    public void setMostenken3jiyhkbn(C_MostenkenyhKbn pMostenken3jiyhkbn) {
        mostenken3jiyhkbn = pMostenken3jiyhkbn;
    }

    private C_UmuKbn mostenkenrrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.MOSTENKENRRKUMU)
    public C_UmuKbn getMostenkenrrkumu() {
        return mostenkenrrkumu;
    }

    public void setMostenkenrrkumu(C_UmuKbn pMostenkenrrkumu) {
        mostenkenrrkumu = pMostenkenrrkumu;
    }

    private C_MostenkenjyouKbn mostenkenjoukbn;

    @Type(type="UserType_C_MostenkenjyouKbn")
    @Column(name=GenHT_SyoriCTL.MOSTENKENJOUKBN)
    public C_MostenkenjyouKbn getMostenkenjoukbn() {
        return mostenkenjoukbn;
    }

    public void setMostenkenjoukbn(C_MostenkenjyouKbn pMostenkenjoukbn) {
        mostenkenjoukbn = pMostenkenjoukbn;
    }

    private C_Knkysatei1jiyhKbn knkysatei1jiyhkbn;

    @Type(type="UserType_C_Knkysatei1jiyhKbn")
    @Column(name=GenHT_SyoriCTL.KNKYSATEI1JIYHKBN)
    public C_Knkysatei1jiyhKbn getKnkysatei1jiyhkbn() {
        return knkysatei1jiyhkbn;
    }

    public void setKnkysatei1jiyhkbn(C_Knkysatei1jiyhKbn pKnkysatei1jiyhkbn) {
        knkysatei1jiyhkbn = pKnkysatei1jiyhkbn;
    }

    private C_Knkysatei2jiyhKbn knkysatei2jiyhkbn;

    @Type(type="UserType_C_Knkysatei2jiyhKbn")
    @Column(name=GenHT_SyoriCTL.KNKYSATEI2JIYHKBN)
    public C_Knkysatei2jiyhKbn getKnkysatei2jiyhkbn() {
        return knkysatei2jiyhkbn;
    }

    public void setKnkysatei2jiyhkbn(C_Knkysatei2jiyhKbn pKnkysatei2jiyhkbn) {
        knkysatei2jiyhkbn = pKnkysatei2jiyhkbn;
    }

    private C_UmuKbn knkysateirrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KNKYSATEIRRKUMU)
    public C_UmuKbn getKnkysateirrkumu() {
        return knkysateirrkumu;
    }

    public void setKnkysateirrkumu(C_UmuKbn pKnkysateirrkumu) {
        knkysateirrkumu = pKnkysateirrkumu;
    }

    private C_KnkysateijyouKbn knkysateijyoukbn;

    @Type(type="UserType_C_KnkysateijyouKbn")
    @Column(name=GenHT_SyoriCTL.KNKYSATEIJYOUKBN)
    public C_KnkysateijyouKbn getKnkysateijyoukbn() {
        return knkysateijyoukbn;
    }

    public void setKnkysateijyoukbn(C_KnkysateijyouKbn pKnkysateijyoukbn) {
        knkysateijyoukbn = pKnkysateijyoukbn;
    }

    private C_ImusateikaniyhKbn imusateikaniyhkbn;

    @Type(type="UserType_C_ImusateikaniyhKbn")
    @Column(name=GenHT_SyoriCTL.IMUSATEIKANIYHKBN)
    public C_ImusateikaniyhKbn getImusateikaniyhkbn() {
        return imusateikaniyhkbn;
    }

    public void setImusateikaniyhkbn(C_ImusateikaniyhKbn pImusateikaniyhkbn) {
        imusateikaniyhkbn = pImusateikaniyhkbn;
    }

    private C_UmuKbn imusateirrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.IMUSATEIRRKUMU)
    public C_UmuKbn getImusateirrkumu() {
        return imusateirrkumu;
    }

    public void setImusateirrkumu(C_UmuKbn pImusateirrkumu) {
        imusateirrkumu = pImusateirrkumu;
    }

    private C_ImusateijyouKbn imusateijyoukbn;

    @Type(type="UserType_C_ImusateijyouKbn")
    @Column(name=GenHT_SyoriCTL.IMUSATEIJYOUKBN)
    public C_ImusateijyouKbn getImusateijyoukbn() {
        return imusateijyoukbn;
    }

    public void setImusateijyoukbn(C_ImusateijyouKbn pImusateijyoukbn) {
        imusateijyoukbn = pImusateijyoukbn;
    }

    private C_UmuKbn mihassinhubiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.MIHASSINHUBIUMU)
    public C_UmuKbn getMihassinhubiumu() {
        return mihassinhubiumu;
    }

    public void setMihassinhubiumu(C_UmuKbn pMihassinhubiumu) {
        mihassinhubiumu = pMihassinhubiumu;
    }

    private C_HubikaisyoujoutaiKbn hubikaisyoujoutaikbn;

    @Type(type="UserType_C_HubikaisyoujoutaiKbn")
    @Column(name=GenHT_SyoriCTL.HUBIKAISYOUJOUTAIKBN)
    public C_HubikaisyoujoutaiKbn getHubikaisyoujoutaikbn() {
        return hubikaisyoujoutaikbn;
    }

    public void setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn pHubikaisyoujoutaikbn) {
        hubikaisyoujoutaikbn = pHubikaisyoujoutaikbn;
    }

    private C_UmuKbn kthhbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KTHHBKBN)
    public C_UmuKbn getKthhbkbn() {
        return kthhbkbn;
    }

    public void setKthhbkbn(C_UmuKbn pKthhbkbn) {
        kthhbkbn = pKthhbkbn;
    }

    private C_UmuKbn srhhbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.SRHHBKBN)
    public C_UmuKbn getSrhhbkbn() {
        return srhhbkbn;
    }

    public void setSrhhbkbn(C_UmuKbn pSrhhbkbn) {
        srhhbkbn = pSrhhbkbn;
    }

    private C_UmuKbn khnhbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KHNHBKBN)
    public C_UmuKbn getKhnhbkbn() {
        return khnhbkbn;
    }

    public void setKhnhbkbn(C_UmuKbn pKhnhbkbn) {
        khnhbkbn = pKhnhbkbn;
    }

    private C_KykkakjkKbn kykkakjkkbn;

    @Type(type="UserType_C_KykkakjkKbn")
    @Column(name=GenHT_SyoriCTL.KYKKAKJKKBN)
    public C_KykkakjkKbn getKykkakjkkbn() {
        return kykkakjkkbn;
    }

    public void setKykkakjkkbn(C_KykkakjkKbn pKykkakjkkbn) {
        kykkakjkkbn = pKykkakjkkbn;
    }

    private C_KetteiKbn ketteikbn;

    @Type(type="UserType_C_KetteiKbn")
    @Column(name=GenHT_SyoriCTL.KETTEIKBN)
    public C_KetteiKbn getKetteikbn() {
        return ketteikbn;
    }

    public void setKetteikbn(C_KetteiKbn pKetteikbn) {
        ketteikbn = pKetteikbn;
    }

    private C_SateijtKbn sateijtkbn;

    @Type(type="UserType_C_SateijtKbn")
    @Column(name=GenHT_SyoriCTL.SATEIJTKBN)
    public C_SateijtKbn getSateijtkbn() {
        return sateijtkbn;
    }

    public void setSateijtkbn(C_SateijtKbn pSateijtkbn) {
        sateijtkbn = pSateijtkbn;
    }

    private BizDate sateizumiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.SATEIZUMIYMD)
    public BizDate getSateizumiymd() {
        return sateizumiymd;
    }

    @Trim("both")
    public void setSateizumiymd(BizDate pSateizumiymd) {
        sateizumiymd = pSateizumiymd;
    }

    private C_UmuKbn doujimosumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.DOUJIMOSUMU)
    public C_UmuKbn getDoujimosumu() {
        return doujimosumu;
    }

    public void setDoujimosumu(C_UmuKbn pDoujimosumu) {
        doujimosumu = pDoujimosumu;
    }

    private C_UmuKbn paldoujimosumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.PALDOUJIMOSUMU)
    public C_UmuKbn getPaldoujimosumu() {
        return paldoujimosumu;
    }

    public void setPaldoujimosumu(C_UmuKbn pPaldoujimosumu) {
        paldoujimosumu = pPaldoujimosumu;
    }

    private C_UmuKbn raydoujimosumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.RAYDOUJIMOSUMU)
    public C_UmuKbn getRaydoujimosumu() {
        return raydoujimosumu;
    }

    public void setRaydoujimosumu(C_UmuKbn pRaydoujimosumu) {
        raydoujimosumu = pRaydoujimosumu;
    }

    private C_LincgthtkekKbn lincgthtkekkbn;

    @Type(type="UserType_C_LincgthtkekKbn")
    @Column(name=GenHT_SyoriCTL.LINCGTHTKEKKBN)
    public C_LincgthtkekKbn getLincgthtkekkbn() {
        return lincgthtkekkbn;
    }

    public void setLincgthtkekkbn(C_LincgthtkekKbn pLincgthtkekkbn) {
        lincgthtkekkbn = pLincgthtkekkbn;
    }

    private C_LincjkKbn lincjkkbn;

    @Type(type="UserType_C_LincjkKbn")
    @Column(name=GenHT_SyoriCTL.LINCJKKBN)
    public C_LincjkKbn getLincjkkbn() {
        return lincjkkbn;
    }

    public void setLincjkkbn(C_LincjkKbn pLincjkkbn) {
        lincjkkbn = pLincjkkbn;
    }

    private C_Lincsousinflg lincsousinflg;

    @Type(type="UserType_C_Lincsousinflg")
    @Column(name=GenHT_SyoriCTL.LINCSOUSINFLG)
    public C_Lincsousinflg getLincsousinflg() {
        return lincsousinflg;
    }

    public void setLincsousinflg(C_Lincsousinflg pLincsousinflg) {
        lincsousinflg = pLincsousinflg;
    }

    private C_LinckknnjkKbn linckknnjkkbn;

    @Type(type="UserType_C_LinckknnjkKbn")
    @Column(name=GenHT_SyoriCTL.LINCKKNNJKKBN)
    public C_LinckknnjkKbn getLinckknnjkkbn() {
        return linckknnjkkbn;
    }

    public void setLinckknnjkkbn(C_LinckknnjkKbn pLinckknnjkkbn) {
        linckknnjkkbn = pLinckknnjkkbn;
    }

    private C_LincdatasousinKbn lincdatasousinkbn;

    @Type(type="UserType_C_LincdatasousinKbn")
    @Column(name=GenHT_SyoriCTL.LINCDATASOUSINKBN)
    public C_LincdatasousinKbn getLincdatasousinkbn() {
        return lincdatasousinkbn;
    }

    public void setLincdatasousinkbn(C_LincdatasousinKbn pLincdatasousinkbn) {
        lincdatasousinkbn = pLincdatasousinkbn;
    }

    private C_UktkakKbn uktkakkbn;

    @Type(type="UserType_C_UktkakKbn")
    @Column(name=GenHT_SyoriCTL.UKTKAKKBN)
    public C_UktkakKbn getUktkakkbn() {
        return uktkakkbn;
    }

    public void setUktkakkbn(C_UktkakKbn pUktkakkbn) {
        uktkakkbn = pUktkakkbn;
    }

    private C_TkhjnKbn tkhjnkbn;

    @Type(type="UserType_C_TkhjnKbn")
    @Column(name=GenHT_SyoriCTL.TKHJNKBN)
    public C_TkhjnKbn getTkhjnkbn() {
        return tkhjnkbn;
    }

    public void setTkhjnkbn(C_TkhjnKbn pTkhjnkbn) {
        tkhjnkbn = pTkhjnkbn;
    }

    private C_YouhiKbn tktkhjnkakuninyouhikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenHT_SyoriCTL.TKTKHJNKAKUNINYOUHIKBN)
    public C_YouhiKbn getTktkhjnkakuninyouhikbn() {
        return tktkhjnkakuninyouhikbn;
    }

    public void setTktkhjnkakuninyouhikbn(C_YouhiKbn pTktkhjnkakuninyouhikbn) {
        tktkhjnkakuninyouhikbn = pTktkhjnkakuninyouhikbn;
    }

    private C_KouseiinkykKbn kouseiinkykkbn;

    @Type(type="UserType_C_KouseiinkykKbn")
    @Column(name=GenHT_SyoriCTL.KOUSEIINKYKKBN)
    public C_KouseiinkykKbn getKouseiinkykkbn() {
        return kouseiinkykkbn;
    }

    public void setKouseiinkykkbn(C_KouseiinkykKbn pKouseiinkykkbn) {
        kouseiinkykkbn = pKouseiinkykkbn;
    }

    private C_KoukankykKbn koukankykkbn;

    @Type(type="UserType_C_KoukankykKbn")
    @Column(name=GenHT_SyoriCTL.KOUKANKYKKBN)
    public C_KoukankykKbn getKoukankykkbn() {
        return koukankykkbn;
    }

    public void setKoukankykkbn(C_KoukankykKbn pKoukankykkbn) {
        koukankykkbn = pKoukankykkbn;
    }

    private C_FatcakakkekkaKbn fatcakakkekkakbn;

    @Type(type="UserType_C_FatcakakkekkaKbn")
    @Column(name=GenHT_SyoriCTL.FATCAKAKKEKKAKBN)
    public C_FatcakakkekkaKbn getFatcakakkekkakbn() {
        return fatcakakkekkakbn;
    }

    public void setFatcakakkekkakbn(C_FatcakakkekkaKbn pFatcakakkekkakbn) {
        fatcakakkekkakbn = pFatcakakkekkakbn;
    }

    private C_AeoiKekkaKbn aeoikekkakbn;

    @Type(type="UserType_C_AeoiKekkaKbn")
    @Column(name=GenHT_SyoriCTL.AEOIKEKKAKBN)
    public C_AeoiKekkaKbn getAeoikekkakbn() {
        return aeoikekkakbn;
    }

    public void setAeoikekkakbn(C_AeoiKekkaKbn pAeoikekkakbn) {
        aeoikekkakbn = pAeoikekkakbn;
    }

    private C_UmuKbn tkhsyouryakuumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.TKHSYOURYAKUUMUKBN)
    public C_UmuKbn getTkhsyouryakuumukbn() {
        return tkhsyouryakuumukbn;
    }

    public void setTkhsyouryakuumukbn(C_UmuKbn pTkhsyouryakuumukbn) {
        tkhsyouryakuumukbn = pTkhsyouryakuumukbn;
    }

    private C_KsktkanKbn kykksktkankbn;

    @Type(type="UserType_C_KsktkanKbn")
    @Column(name=GenHT_SyoriCTL.KYKKSKTKANKBN)
    public C_KsktkanKbn getKykksktkankbn() {
        return kykksktkankbn;
    }

    public void setKykksktkankbn(C_KsktkanKbn pKykksktkankbn) {
        kykksktkankbn = pKykksktkankbn;
    }

    private C_KsktkanKbn hhknksktkankbn;

    @Type(type="UserType_C_KsktkanKbn")
    @Column(name=GenHT_SyoriCTL.HHKNKSKTKANKBN)
    public C_KsktkanKbn getHhknksktkankbn() {
        return hhknksktkankbn;
    }

    public void setHhknksktkankbn(C_KsktkanKbn pHhknksktkankbn) {
        hhknksktkankbn = pHhknksktkankbn;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenHT_SyoriCTL.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private C_UmuKbn minyknkurikosiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.MINYKNKURIKOSIUMU)
    public C_UmuKbn getMinyknkurikosiumu() {
        return minyknkurikosiumu;
    }

    public void setMinyknkurikosiumu(C_UmuKbn pMinyknkurikosiumu) {
        minyknkurikosiumu = pMinyknkurikosiumu;
    }

    private C_UmuKbn kettienkurikosiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.KETTIENKURIKOSIUMU)
    public C_UmuKbn getKettienkurikosiumu() {
        return kettienkurikosiumu;
    }

    public void setKettienkurikosiumu(C_UmuKbn pKettienkurikosiumu) {
        kettienkurikosiumu = pKettienkurikosiumu;
    }

    private C_UmuKbn srhkurikosiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.SRHKURIKOSIUMU)
    public C_UmuKbn getSrhkurikosiumu() {
        return srhkurikosiumu;
    }

    public void setSrhkurikosiumu(C_UmuKbn pSrhkurikosiumu) {
        srhkurikosiumu = pSrhkurikosiumu;
    }

    private String daimosno;

    @Column(name=GenHT_SyoriCTL.DAIMOSNO)
    @MousikomiNo
    public String getDaimosno() {
        return daimosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }

    private C_Mfrenflg mfrenflg;

    @Type(type="UserType_C_Mfrenflg")
    @Column(name=GenHT_SyoriCTL.MFRENFLG)
    public C_Mfrenflg getMfrenflg() {
        return mfrenflg;
    }

    public void setMfrenflg(C_Mfrenflg pMfrenflg) {
        mfrenflg = pMfrenflg;
    }

    private BizDate mfrenymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.MFRENYMD)
    public BizDate getMfrenymd() {
        return mfrenymd;
    }

    public void setMfrenymd(BizDate pMfrenymd) {
        mfrenymd = pMfrenymd;
    }

    private C_JimusrhKbn jimusrhkbn;

    @Type(type="UserType_C_JimusrhKbn")
    @Column(name=GenHT_SyoriCTL.JIMUSRHKBN)
    public C_JimusrhKbn getJimusrhkbn() {
        return jimusrhkbn;
    }

    public void setJimusrhkbn(C_JimusrhKbn pJimusrhkbn) {
        jimusrhkbn = pJimusrhkbn;
    }

    private C_SyssrhKbn syssrhkbn;

    @Type(type="UserType_C_SyssrhKbn")
    @Column(name=GenHT_SyoriCTL.SYSSRHKBN)
    public C_SyssrhKbn getSyssrhkbn() {
        return syssrhkbn;
    }

    public void setSyssrhkbn(C_SyssrhKbn pSyssrhkbn) {
        syssrhkbn = pSyssrhkbn;
    }

    private C_TyhysakuseiKbn annaisakuseikbn;

    @Type(type="UserType_C_TyhysakuseiKbn")
    @Column(name=GenHT_SyoriCTL.ANNAISAKUSEIKBN)
    public C_TyhysakuseiKbn getAnnaisakuseikbn() {
        return annaisakuseikbn;
    }

    public void setAnnaisakuseikbn(C_TyhysakuseiKbn pAnnaisakuseikbn) {
        annaisakuseikbn = pAnnaisakuseikbn;
    }

    private Integer annaikaisuu;

    @Column(name=GenHT_SyoriCTL.ANNAIKAISUU)
    public Integer getAnnaikaisuu() {
        return annaikaisuu;
    }

    public void setAnnaikaisuu(Integer pAnnaikaisuu) {
        annaikaisuu = pAnnaikaisuu;
    }

    private C_UmuKbn tkbtkktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_SyoriCTL.TKBTKKTUMU)
    public C_UmuKbn getTkbtkktumu() {
        return tkbtkktumu;
    }

    public void setTkbtkktumu(C_UmuKbn pTkbtkktumu) {
        tkbtkktumu = pTkbtkktumu;
    }

    private C_YouhiKbn kansyoutuutiyhkbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenHT_SyoriCTL.KANSYOUTUUTIYHKBN)
    public C_YouhiKbn getKansyoutuutiyhkbn() {
        return kansyoutuutiyhkbn;
    }

    public void setKansyoutuutiyhkbn(C_YouhiKbn pKansyoutuutiyhkbn) {
        kansyoutuutiyhkbn = pKansyoutuutiyhkbn;
    }

    private String lastkossyoricd;

    @Column(name=GenHT_SyoriCTL.LASTKOSSYORICD)
    public String getLastkossyoricd() {
        return lastkossyoricd;
    }

    public void setLastkossyoricd(String pLastkossyoricd) {
        lastkossyoricd = pLastkossyoricd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SyoriCTL.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SyoriCTL.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate yoteirirituhenkourenrakuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SyoriCTL.YOTEIRIRITUHENKOURENRAKUYMD)
    @ValidDate
    public BizDate getYoteirirituhenkourenrakuymd() {
        return yoteirirituhenkourenrakuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteirirituhenkourenrakuymd(BizDate pYoteirirituhenkourenrakuymd) {
        yoteirirituhenkourenrakuymd = pYoteirirituhenkourenrakuymd;
    }
}