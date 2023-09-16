package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_BAK_Suiihyou;
import yuyu.def.db.mapping.GenIT_BAK_Suiihyou;
import yuyu.def.db.meta.GenQIT_BAK_Suiihyou;
import yuyu.def.db.meta.QIT_BAK_Suiihyou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 推移表バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_Suiihyou}</td><td colspan="3">推移表バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeikanensuu keikanensuu}</td><td>経過年数</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>calcym</td><td>計算年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>mvatekijyoutaikbn</td><td>ＭＶＡ適用状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MvaTekiyoujyoutaiKbn C_MvaTekiyoujyoutaiKbn}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>sjkkktusirrtup</td><td>市場価格調整用利率（上昇）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtsame</td><td>市場価格調整用利率（同水準）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtdown</td><td>市場価格調整用利率（低下）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrthendouup</td><td>市場価格調整用利率変動幅（上）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrthendoudown</td><td>市場価格調整用利率変動幅（下）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyendaka</td><td>円換算適用為替レート（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyenkijyun</td><td>円換算適用為替レート（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyenyasu</td><td>円換算適用為替レート（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrategkyendaka</td><td>円換算適用為替レート変動額（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenknsnkwsrategkyenyasu</td><td>円換算適用為替レート変動額（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwup</td><td>ＭＶＡ適用解約返戻金額（上昇）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwsame</td><td>ＭＶＡ適用解約返戻金額（同水準）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwdown</td><td>ＭＶＡ適用解約返戻金額（低下）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyendaka</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyenkijyun</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyenyasu</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyendaka</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyenkijyun</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyenyasu</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyendaka</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyenkijyun</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyenyasu</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariptumitatekin</td><td>ＭＶＡ適用保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewsame</td><td>ＭＶＡ適用外解約返戻金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyendaka</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyenkijyun</td><td>ＭＶＡ適用外解約返戻金額（円貨）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyenyasu</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanoneptumitatekin</td><td>ＭＶＡ適用外保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mkhyouyensysnikougk</td><td>目標到達時円建終身保険移行特約目標額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tmttknzoukaritu1</td><td>積立金増加率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknzoukaritu2</td><td>積立金増加率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknzoukaritu3</td><td>積立金増加率３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtup2</td><td>市場価格調整用利率（上昇）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtsame2</td><td>市場価格調整用利率（同水準）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtdown2</td><td>市場価格調整用利率（低下）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrthendouup2</td><td>市場価格調整用利率変動幅（上）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrthendoudown2</td><td>市場価格調整用利率変動幅（下）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyendaka2</td><td>円換算適用為替レート（円高）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyenkijyun2</td><td>円換算適用為替レート（中央値）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyenyasu2</td><td>円換算適用為替レート（円安）２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrategkyendaka2</td><td>円換算適用為替レート変動額（円高）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenknsnkwsrategkyenyasu2</td><td>円換算適用為替レート変動額（円安）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwup2</td><td>ＭＶＡ適用解約返戻金額（上昇）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwsame2</td><td>ＭＶＡ適用解約返戻金額（同水準）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwdown2</td><td>ＭＶＡ適用解約返戻金額（低下）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyendaka2</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyenkijyun2</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyenyasu2</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyendaka2</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyenkijyun2</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyenyasu2</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyendaka2</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyenkijyun2</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyenyasu2</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariptumitatekin2</td><td>ＭＶＡ適用保険料積立金２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewsame2</td><td>ＭＶＡ適用外解約返戻金額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyendaka2</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円高）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyenkijyun2</td><td>ＭＶＡ適用外解約返戻金額（円貨）（中央値）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyenyasu2</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円安）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanoneptumitatekin2</td><td>ＭＶＡ適用外保険料積立金２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sjkkktusirrtup3</td><td>市場価格調整用利率（上昇）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtsame3</td><td>市場価格調整用利率（同水準）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrtdown3</td><td>市場価格調整用利率（低下）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrthendouup3</td><td>市場価格調整用利率変動幅（上）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sjkkktusirrthendoudown3</td><td>市場価格調整用利率変動幅（下）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyendaka3</td><td>円換算適用為替レート（円高）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyenkijyun3</td><td>円換算適用為替レート（中央値）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrateyenyasu3</td><td>円換算適用為替レート（円安）３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yenknsnkwsrategkyendaka3</td><td>円換算適用為替レート変動額（円高）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenknsnkwsrategkyenyasu3</td><td>円換算適用為替レート変動額（円安）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwup3</td><td>ＭＶＡ適用解約返戻金額（上昇）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwsame3</td><td>ＭＶＡ適用解約返戻金額（同水準）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwdown3</td><td>ＭＶＡ適用解約返戻金額（低下）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyendaka3</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyenkijyun3</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyenupyenyasu3</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyendaka3</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyenkijyun3</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyensameyenyasu3</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyendaka3</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyenkijyun3</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariwyendownyenyasu3</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaariptumitatekin3</td><td>ＭＶＡ適用保険料積立金３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewsame3</td><td>ＭＶＡ適用外解約返戻金額３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyendaka3</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円高）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyenkijyun3</td><td>ＭＶＡ適用外解約返戻金額（円貨）（中央値）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanonewyensameyenyasu3</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円安）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvanoneptumitatekin3</td><td>ＭＶＡ適用外保険料積立金３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tutmttknutiwake11</td><td>積立金内訳（１）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tutmttknutiwake21</td><td>積立金内訳（２）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tutmttknutiwake12</td><td>積立金内訳（１）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tutmttknutiwake22</td><td>積立金内訳（２）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tutmttknutiwake13</td><td>積立金内訳（１）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tutmttknutiwake23</td><td>積立金内訳（２）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sisuuupritu1</td><td>指数上昇率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisuuupritu2</td><td>指数上昇率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisuuupritu3</td><td>指数上昇率３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaeup1</td><td>ＭＶＡ適用積立金額（解約控除前）（上昇）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaeup2</td><td>ＭＶＡ適用積立金額（解約控除前）（上昇）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaeup3</td><td>ＭＶＡ適用積立金額（解約控除前）（上昇）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaesame1</td><td>ＭＶＡ適用積立金額（解約控除前）（同水準）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaesame2</td><td>ＭＶＡ適用積立金額（解約控除前）（同水準）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaesame3</td><td>ＭＶＡ適用積立金額（解約控除前）（同水準）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaedown1</td><td>ＭＶＡ適用積立金額（解約控除前）（低下）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaedown2</td><td>ＭＶＡ適用積立金額（解約控除前）（低下）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mvaaritmttkgkkykkjmaedown3</td><td>ＭＶＡ適用積立金額（解約控除前）（低下）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>suiihyousyubetu</td><td>推移表種別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkknmnryumukbn</td><td>払込期間満了有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ytirrtcalckijyunrrt1</td><td>予定利率計算基準利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ytirrtcalckijyunrrt2</td><td>予定利率計算基準利率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ytirrtcalckijyunrrt3</td><td>予定利率計算基準利率３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zennouzndkyen1</td><td>前納残高（円貨）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouzndkyen2</td><td>前納残高（円貨）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouzndkyen3</td><td>前納残高（円貨）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmpyen1</td><td>既払込保険料（円貨）１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmpyen2</td><td>既払込保険料（円貨）２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmpyen3</td><td>既払込保険料（円貨）３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmp1</td><td>既払込保険料１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmp2</td><td>既払込保険料２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmp3</td><td>既払込保険料３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouzndk1</td><td>前納残高１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakujuktrgk</td><td>解約時受取額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakujuktrgkyendaka</td><td>解約時受取額（円貨）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakujuktrgkyenkijyun</td><td>解約時受取額（円貨）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakujuktrgkyenyasu</td><td>解約時受取額（円貨）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_Suiihyou
 * @see     GenIT_BAK_Suiihyou
 * @see     QIT_BAK_Suiihyou
 * @see     GenQIT_BAK_Suiihyou
 */
public class PKIT_BAK_Suiihyou extends AbstractExDBPrimaryKey<IT_BAK_Suiihyou, PKIT_BAK_Suiihyou> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_Suiihyou() {
    }

    public PKIT_BAK_Suiihyou(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDate pTyouhyouymd,
        Integer pKeikanensuu
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        tyouhyouymd = pTyouhyouymd;
        keikanensuu = pKeikanensuu;
    }

    @Transient
    @Override
    public Class<IT_BAK_Suiihyou> getEntityClass() {
        return IT_BAK_Suiihyou.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }
    private Integer keikanensuu;

    public Integer getKeikanensuu() {
        return keikanensuu;
    }

    public void setKeikanensuu(Integer pKeikanensuu) {
        keikanensuu = pKeikanensuu;
    }

}