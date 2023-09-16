package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.id.PKIT_Suiihyou;
import yuyu.def.db.meta.GenQIT_Suiihyou;
import yuyu.def.db.meta.QIT_Suiihyou;
import yuyu.def.db.type.UserType_C_MvaTekiyoujyoutaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 推移表テーブル テーブルのマッピング情報クラスで、 {@link IT_Suiihyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_Suiihyou}</td><td colspan="3">推移表テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_Suiihyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_Suiihyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_Suiihyou ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeikanensuu keikanensuu}</td><td>経過年数</td><td align="center">{@link PKIT_Suiihyou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCalcym calcym}</td><td>計算年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMvatekijyoutaikbn mvatekijyoutaikbn}</td><td>ＭＶＡ適用状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MvaTekiyoujyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtup sjkkktusirrtup}</td><td>市場価格調整用利率（上昇）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtsame sjkkktusirrtsame}</td><td>市場価格調整用利率（同水準）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtdown sjkkktusirrtdown}</td><td>市場価格調整用利率（低下）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrthendouup sjkkktusirrthendouup}</td><td>市場価格調整用利率変動幅（上）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrthendoudown sjkkktusirrthendoudown}</td><td>市場価格調整用利率変動幅（下）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyendaka yenknsnkwsrateyendaka}</td><td>円換算適用為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyenkijyun yenknsnkwsrateyenkijyun}</td><td>円換算適用為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyenyasu yenknsnkwsrateyenyasu}</td><td>円換算適用為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrategkyendaka yenknsnkwsrategkyendaka}</td><td>円換算適用為替レート変動額（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrategkyenyasu yenknsnkwsrategkyenyasu}</td><td>円換算適用為替レート変動額（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwup mvaariwup}</td><td>ＭＶＡ適用解約返戻金額（上昇）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwsame mvaariwsame}</td><td>ＭＶＡ適用解約返戻金額（同水準）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwdown mvaariwdown}</td><td>ＭＶＡ適用解約返戻金額（低下）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyendaka mvaariwyenupyendaka}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyenkijyun mvaariwyenupyenkijyun}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyenyasu mvaariwyenupyenyasu}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyendaka mvaariwyensameyendaka}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyenkijyun mvaariwyensameyenkijyun}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyenyasu mvaariwyensameyenyasu}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyendaka mvaariwyendownyendaka}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyenkijyun mvaariwyendownyenkijyun}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyenyasu mvaariwyendownyenyasu}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariptumitatekin mvaariptumitatekin}</td><td>ＭＶＡ適用保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewsame mvanonewsame}</td><td>ＭＶＡ適用外解約返戻金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyendaka mvanonewyensameyendaka}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyenkijyun mvanonewyensameyenkijyun}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyenyasu mvanonewyensameyenyasu}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanoneptumitatekin mvanoneptumitatekin}</td><td>ＭＶＡ適用外保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikougk mkhyouyensysnikougk}</td><td>目標到達時円建終身保険移行特約目標額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritu1 tmttknzoukaritu1}</td><td>積立金増加率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritu2 tmttknzoukaritu2}</td><td>積立金増加率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTmttknzoukaritu3 tmttknzoukaritu3}</td><td>積立金増加率３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtup2 sjkkktusirrtup2}</td><td>市場価格調整用利率（上昇）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtsame2 sjkkktusirrtsame2}</td><td>市場価格調整用利率（同水準）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtdown2 sjkkktusirrtdown2}</td><td>市場価格調整用利率（低下）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrthendouup2 sjkkktusirrthendouup2}</td><td>市場価格調整用利率変動幅（上）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrthendoudown2 sjkkktusirrthendoudown2}</td><td>市場価格調整用利率変動幅（下）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyendaka2 yenknsnkwsrateyendaka2}</td><td>円換算適用為替レート（円高）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyenkijyun2 yenknsnkwsrateyenkijyun2}</td><td>円換算適用為替レート（中央値）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyenyasu2 yenknsnkwsrateyenyasu2}</td><td>円換算適用為替レート（円安）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrategkyendaka2 yenknsnkwsrategkyendaka2}</td><td>円換算適用為替レート変動額（円高）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrategkyenyasu2 yenknsnkwsrategkyenyasu2}</td><td>円換算適用為替レート変動額（円安）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwup2 mvaariwup2}</td><td>ＭＶＡ適用解約返戻金額（上昇）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwsame2 mvaariwsame2}</td><td>ＭＶＡ適用解約返戻金額（同水準）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwdown2 mvaariwdown2}</td><td>ＭＶＡ適用解約返戻金額（低下）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyendaka2 mvaariwyenupyendaka2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyenkijyun2 mvaariwyenupyenkijyun2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyenyasu2 mvaariwyenupyenyasu2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyendaka2 mvaariwyensameyendaka2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyenkijyun2 mvaariwyensameyenkijyun2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyenyasu2 mvaariwyensameyenyasu2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyendaka2 mvaariwyendownyendaka2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyenkijyun2 mvaariwyendownyenkijyun2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyenyasu2 mvaariwyendownyenyasu2}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariptumitatekin2 mvaariptumitatekin2}</td><td>ＭＶＡ適用保険料積立金２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewsame2 mvanonewsame2}</td><td>ＭＶＡ適用外解約返戻金額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyendaka2 mvanonewyensameyendaka2}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円高）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyenkijyun2 mvanonewyensameyenkijyun2}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（中央値）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyenyasu2 mvanonewyensameyenyasu2}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円安）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanoneptumitatekin2 mvanoneptumitatekin2}</td><td>ＭＶＡ適用外保険料積立金２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtup3 sjkkktusirrtup3}</td><td>市場価格調整用利率（上昇）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtsame3 sjkkktusirrtsame3}</td><td>市場価格調整用利率（同水準）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrtdown3 sjkkktusirrtdown3}</td><td>市場価格調整用利率（低下）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrthendouup3 sjkkktusirrthendouup3}</td><td>市場価格調整用利率変動幅（上）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSjkkktusirrthendoudown3 sjkkktusirrthendoudown3}</td><td>市場価格調整用利率変動幅（下）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyendaka3 yenknsnkwsrateyendaka3}</td><td>円換算適用為替レート（円高）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyenkijyun3 yenknsnkwsrateyenkijyun3}</td><td>円換算適用為替レート（中央値）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrateyenyasu3 yenknsnkwsrateyenyasu3}</td><td>円換算適用為替レート（円安）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrategkyendaka3 yenknsnkwsrategkyendaka3}</td><td>円換算適用為替レート変動額（円高）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenknsnkwsrategkyenyasu3 yenknsnkwsrategkyenyasu3}</td><td>円換算適用為替レート変動額（円安）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwup3 mvaariwup3}</td><td>ＭＶＡ適用解約返戻金額（上昇）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwsame3 mvaariwsame3}</td><td>ＭＶＡ適用解約返戻金額（同水準）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwdown3 mvaariwdown3}</td><td>ＭＶＡ適用解約返戻金額（低下）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyendaka3 mvaariwyenupyendaka3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyenkijyun3 mvaariwyenupyenkijyun3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyenupyenyasu3 mvaariwyenupyenyasu3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyendaka3 mvaariwyensameyendaka3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyenkijyun3 mvaariwyensameyenkijyun3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyensameyenyasu3 mvaariwyensameyenyasu3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyendaka3 mvaariwyendownyendaka3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyenkijyun3 mvaariwyendownyenkijyun3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariwyendownyenyasu3 mvaariwyendownyenyasu3}</td><td>ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaariptumitatekin3 mvaariptumitatekin3}</td><td>ＭＶＡ適用保険料積立金３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewsame3 mvanonewsame3}</td><td>ＭＶＡ適用外解約返戻金額３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyendaka3 mvanonewyensameyendaka3}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円高）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyenkijyun3 mvanonewyensameyenkijyun3}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（中央値）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanonewyensameyenyasu3 mvanonewyensameyenyasu3}</td><td>ＭＶＡ適用外解約返戻金額（円貨）（円安）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvanoneptumitatekin3 mvanoneptumitatekin3}</td><td>ＭＶＡ適用外保険料積立金３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTutmttknutiwake11 tutmttknutiwake11}</td><td>積立金内訳（１）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTutmttknutiwake21 tutmttknutiwake21}</td><td>積立金内訳（２）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTutmttknutiwake12 tutmttknutiwake12}</td><td>積立金内訳（１）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTutmttknutiwake22 tutmttknutiwake22}</td><td>積立金内訳（２）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTutmttknutiwake13 tutmttknutiwake13}</td><td>積立金内訳（１）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTutmttknutiwake23 tutmttknutiwake23}</td><td>積立金内訳（２）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSisuuupritu1 sisuuupritu1}</td><td>指数上昇率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisuuupritu2 sisuuupritu2}</td><td>指数上昇率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisuuupritu3 sisuuupritu3}</td><td>指数上昇率３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaeup1 mvaaritmttkgkkykkjmaeup1}</td><td>ＭＶＡ適用積立金額（解約控除前）（上昇）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaeup2 mvaaritmttkgkkykkjmaeup2}</td><td>ＭＶＡ適用積立金額（解約控除前）（上昇）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaeup3 mvaaritmttkgkkykkjmaeup3}</td><td>ＭＶＡ適用積立金額（解約控除前）（上昇）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaesame1 mvaaritmttkgkkykkjmaesame1}</td><td>ＭＶＡ適用積立金額（解約控除前）（同水準）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaesame2 mvaaritmttkgkkykkjmaesame2}</td><td>ＭＶＡ適用積立金額（解約控除前）（同水準）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaesame3 mvaaritmttkgkkykkjmaesame3}</td><td>ＭＶＡ適用積立金額（解約控除前）（同水準）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaedown1 mvaaritmttkgkkykkjmaedown1}</td><td>ＭＶＡ適用積立金額（解約控除前）（低下）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaedown2 mvaaritmttkgkkykkjmaedown2}</td><td>ＭＶＡ適用積立金額（解約控除前）（低下）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMvaaritmttkgkkykkjmaedown3 mvaaritmttkgkkykkjmaedown3}</td><td>ＭＶＡ適用積立金額（解約控除前）（低下）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSuiihyousyubetu suiihyousyubetu}</td><td>推移表種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkknmnryumukbn hrkkknmnryumukbn}</td><td>払込期間満了有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYtirrtcalckijyunrrt1 ytirrtcalckijyunrrt1}</td><td>予定利率計算基準利率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYtirrtcalckijyunrrt2 ytirrtcalckijyunrrt2}</td><td>予定利率計算基準利率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYtirrtcalckijyunrrt3 ytirrtcalckijyunrrt3}</td><td>予定利率計算基準利率３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZennouzndkyen1 zennouzndkyen1}</td><td>前納残高（円貨）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouzndkyen2 zennouzndkyen2}</td><td>前納残高（円貨）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouzndkyen3 zennouzndkyen3}</td><td>前納残高（円貨）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmpyen1 kihrkmpyen1}</td><td>既払込保険料（円貨）１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmpyen2 kihrkmpyen2}</td><td>既払込保険料（円貨）２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmpyen3 kihrkmpyen3}</td><td>既払込保険料（円貨）３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmp1 kihrkmp1}</td><td>既払込保険料１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmp2 kihrkmp2}</td><td>既払込保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmp3 kihrkmp3}</td><td>既払込保険料３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouzndk1 zennouzndk1}</td><td>前納残高１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakujuktrgk kaiyakujuktrgk}</td><td>解約時受取額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakujuktrgkyendaka kaiyakujuktrgkyendaka}</td><td>解約時受取額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakujuktrgkyenkijyun kaiyakujuktrgkyenkijyun}</td><td>解約時受取額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakujuktrgkyenyasu kaiyakujuktrgkyenyasu}</td><td>解約時受取額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_Suiihyou
 * @see     PKIT_Suiihyou
 * @see     QIT_Suiihyou
 * @see     GenQIT_Suiihyou
 */
@MappedSuperclass
@Table(name=GenIT_Suiihyou.TABLE_NAME)
@IdClass(value=PKIT_Suiihyou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_MvaTekiyoujyoutaiKbn", typeClass=UserType_C_MvaTekiyoujyoutaiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_Suiihyou extends AbstractExDBEntity<IT_Suiihyou, PKIT_Suiihyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_Suiihyou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String KEIKANENSUU              = "keikanensuu";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String CALCYM                   = "calcym";
    public static final String MVATEKIJYOUTAIKBN        = "mvatekijyoutaikbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SJKKKTUSIRRTUP           = "sjkkktusirrtup";
    public static final String SJKKKTUSIRRTSAME         = "sjkkktusirrtsame";
    public static final String SJKKKTUSIRRTDOWN         = "sjkkktusirrtdown";
    public static final String SJKKKTUSIRRTHENDOUUP     = "sjkkktusirrthendouup";
    public static final String SJKKKTUSIRRTHENDOUDOWN   = "sjkkktusirrthendoudown";
    public static final String YENKNSNKWSRATEYENDAKA    = "yenknsnkwsrateyendaka";
    public static final String YENKNSNKWSRATEYENKIJYUN  = "yenknsnkwsrateyenkijyun";
    public static final String YENKNSNKWSRATEYENYASU    = "yenknsnkwsrateyenyasu";
    public static final String YENKNSNKWSRATEGKYENDAKA  = "yenknsnkwsrategkyendaka";
    public static final String YENKNSNKWSRATEGKYENYASU  = "yenknsnkwsrategkyenyasu";
    public static final String MVAARIWUP                = "mvaariwup";
    public static final String MVAARIWSAME              = "mvaariwsame";
    public static final String MVAARIWDOWN              = "mvaariwdown";
    public static final String MVAARIWYENUPYENDAKA      = "mvaariwyenupyendaka";
    public static final String MVAARIWYENUPYENKIJYUN    = "mvaariwyenupyenkijyun";
    public static final String MVAARIWYENUPYENYASU      = "mvaariwyenupyenyasu";
    public static final String MVAARIWYENSAMEYENDAKA    = "mvaariwyensameyendaka";
    public static final String MVAARIWYENSAMEYENKIJYUN  = "mvaariwyensameyenkijyun";
    public static final String MVAARIWYENSAMEYENYASU    = "mvaariwyensameyenyasu";
    public static final String MVAARIWYENDOWNYENDAKA    = "mvaariwyendownyendaka";
    public static final String MVAARIWYENDOWNYENKIJYUN  = "mvaariwyendownyenkijyun";
    public static final String MVAARIWYENDOWNYENYASU    = "mvaariwyendownyenyasu";
    public static final String MVAARIPTUMITATEKIN       = "mvaariptumitatekin";
    public static final String MVANONEWSAME             = "mvanonewsame";
    public static final String MVANONEWYENSAMEYENDAKA   = "mvanonewyensameyendaka";
    public static final String MVANONEWYENSAMEYENKIJYUN = "mvanonewyensameyenkijyun";
    public static final String MVANONEWYENSAMEYENYASU   = "mvanonewyensameyenyasu";
    public static final String MVANONEPTUMITATEKIN      = "mvanoneptumitatekin";
    public static final String MKHYOUYENSYSNIKOUGK      = "mkhyouyensysnikougk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String TMTTKNZOUKARITU1         = "tmttknzoukaritu1";
    public static final String TMTTKNZOUKARITU2         = "tmttknzoukaritu2";
    public static final String TMTTKNZOUKARITU3         = "tmttknzoukaritu3";
    public static final String SJKKKTUSIRRTUP2          = "sjkkktusirrtup2";
    public static final String SJKKKTUSIRRTSAME2        = "sjkkktusirrtsame2";
    public static final String SJKKKTUSIRRTDOWN2        = "sjkkktusirrtdown2";
    public static final String SJKKKTUSIRRTHENDOUUP2    = "sjkkktusirrthendouup2";
    public static final String SJKKKTUSIRRTHENDOUDOWN2  = "sjkkktusirrthendoudown2";
    public static final String YENKNSNKWSRATEYENDAKA2   = "yenknsnkwsrateyendaka2";
    public static final String YENKNSNKWSRATEYENKIJYUN2 = "yenknsnkwsrateyenkijyun2";
    public static final String YENKNSNKWSRATEYENYASU2   = "yenknsnkwsrateyenyasu2";
    public static final String YENKNSNKWSRATEGKYENDAKA2 = "yenknsnkwsrategkyendaka2";
    public static final String YENKNSNKWSRATEGKYENYASU2 = "yenknsnkwsrategkyenyasu2";
    public static final String MVAARIWUP2               = "mvaariwup2";
    public static final String MVAARIWSAME2             = "mvaariwsame2";
    public static final String MVAARIWDOWN2             = "mvaariwdown2";
    public static final String MVAARIWYENUPYENDAKA2     = "mvaariwyenupyendaka2";
    public static final String MVAARIWYENUPYENKIJYUN2   = "mvaariwyenupyenkijyun2";
    public static final String MVAARIWYENUPYENYASU2     = "mvaariwyenupyenyasu2";
    public static final String MVAARIWYENSAMEYENDAKA2   = "mvaariwyensameyendaka2";
    public static final String MVAARIWYENSAMEYENKIJYUN2 = "mvaariwyensameyenkijyun2";
    public static final String MVAARIWYENSAMEYENYASU2   = "mvaariwyensameyenyasu2";
    public static final String MVAARIWYENDOWNYENDAKA2   = "mvaariwyendownyendaka2";
    public static final String MVAARIWYENDOWNYENKIJYUN2 = "mvaariwyendownyenkijyun2";
    public static final String MVAARIWYENDOWNYENYASU2   = "mvaariwyendownyenyasu2";
    public static final String MVAARIPTUMITATEKIN2      = "mvaariptumitatekin2";
    public static final String MVANONEWSAME2            = "mvanonewsame2";
    public static final String MVANONEWYENSAMEYENDAKA2  = "mvanonewyensameyendaka2";
    public static final String MVANONEWYENSAMEYENKIJYUN2 = "mvanonewyensameyenkijyun2";
    public static final String MVANONEWYENSAMEYENYASU2  = "mvanonewyensameyenyasu2";
    public static final String MVANONEPTUMITATEKIN2     = "mvanoneptumitatekin2";
    public static final String SJKKKTUSIRRTUP3          = "sjkkktusirrtup3";
    public static final String SJKKKTUSIRRTSAME3        = "sjkkktusirrtsame3";
    public static final String SJKKKTUSIRRTDOWN3        = "sjkkktusirrtdown3";
    public static final String SJKKKTUSIRRTHENDOUUP3    = "sjkkktusirrthendouup3";
    public static final String SJKKKTUSIRRTHENDOUDOWN3  = "sjkkktusirrthendoudown3";
    public static final String YENKNSNKWSRATEYENDAKA3   = "yenknsnkwsrateyendaka3";
    public static final String YENKNSNKWSRATEYENKIJYUN3 = "yenknsnkwsrateyenkijyun3";
    public static final String YENKNSNKWSRATEYENYASU3   = "yenknsnkwsrateyenyasu3";
    public static final String YENKNSNKWSRATEGKYENDAKA3 = "yenknsnkwsrategkyendaka3";
    public static final String YENKNSNKWSRATEGKYENYASU3 = "yenknsnkwsrategkyenyasu3";
    public static final String MVAARIWUP3               = "mvaariwup3";
    public static final String MVAARIWSAME3             = "mvaariwsame3";
    public static final String MVAARIWDOWN3             = "mvaariwdown3";
    public static final String MVAARIWYENUPYENDAKA3     = "mvaariwyenupyendaka3";
    public static final String MVAARIWYENUPYENKIJYUN3   = "mvaariwyenupyenkijyun3";
    public static final String MVAARIWYENUPYENYASU3     = "mvaariwyenupyenyasu3";
    public static final String MVAARIWYENSAMEYENDAKA3   = "mvaariwyensameyendaka3";
    public static final String MVAARIWYENSAMEYENKIJYUN3 = "mvaariwyensameyenkijyun3";
    public static final String MVAARIWYENSAMEYENYASU3   = "mvaariwyensameyenyasu3";
    public static final String MVAARIWYENDOWNYENDAKA3   = "mvaariwyendownyendaka3";
    public static final String MVAARIWYENDOWNYENKIJYUN3 = "mvaariwyendownyenkijyun3";
    public static final String MVAARIWYENDOWNYENYASU3   = "mvaariwyendownyenyasu3";
    public static final String MVAARIPTUMITATEKIN3      = "mvaariptumitatekin3";
    public static final String MVANONEWSAME3            = "mvanonewsame3";
    public static final String MVANONEWYENSAMEYENDAKA3  = "mvanonewyensameyendaka3";
    public static final String MVANONEWYENSAMEYENKIJYUN3 = "mvanonewyensameyenkijyun3";
    public static final String MVANONEWYENSAMEYENYASU3  = "mvanonewyensameyenyasu3";
    public static final String MVANONEPTUMITATEKIN3     = "mvanoneptumitatekin3";
    public static final String TUTMTTKNUTIWAKE11        = "tutmttknutiwake11";
    public static final String TUTMTTKNUTIWAKE21        = "tutmttknutiwake21";
    public static final String TUTMTTKNUTIWAKE12        = "tutmttknutiwake12";
    public static final String TUTMTTKNUTIWAKE22        = "tutmttknutiwake22";
    public static final String TUTMTTKNUTIWAKE13        = "tutmttknutiwake13";
    public static final String TUTMTTKNUTIWAKE23        = "tutmttknutiwake23";
    public static final String SISUUUPRITU1             = "sisuuupritu1";
    public static final String SISUUUPRITU2             = "sisuuupritu2";
    public static final String SISUUUPRITU3             = "sisuuupritu3";
    public static final String MVAARITMTTKGKKYKKJMAEUP1 = "mvaaritmttkgkkykkjmaeup1";
    public static final String MVAARITMTTKGKKYKKJMAEUP2 = "mvaaritmttkgkkykkjmaeup2";
    public static final String MVAARITMTTKGKKYKKJMAEUP3 = "mvaaritmttkgkkykkjmaeup3";
    public static final String MVAARITMTTKGKKYKKJMAESAME1 = "mvaaritmttkgkkykkjmaesame1";
    public static final String MVAARITMTTKGKKYKKJMAESAME2 = "mvaaritmttkgkkykkjmaesame2";
    public static final String MVAARITMTTKGKKYKKJMAESAME3 = "mvaaritmttkgkkykkjmaesame3";
    public static final String MVAARITMTTKGKKYKKJMAEDOWN1 = "mvaaritmttkgkkykkjmaedown1";
    public static final String MVAARITMTTKGKKYKKJMAEDOWN2 = "mvaaritmttkgkkykkjmaedown2";
    public static final String MVAARITMTTKGKKYKKJMAEDOWN3 = "mvaaritmttkgkkykkjmaedown3";
    public static final String SUIIHYOUSYUBETU          = "suiihyousyubetu";
    public static final String HRKKKNMNRYUMUKBN         = "hrkkknmnryumukbn";
    public static final String YTIRRTCALCKIJYUNRRT1     = "ytirrtcalckijyunrrt1";
    public static final String YTIRRTCALCKIJYUNRRT2     = "ytirrtcalckijyunrrt2";
    public static final String YTIRRTCALCKIJYUNRRT3     = "ytirrtcalckijyunrrt3";
    public static final String ZENNOUZNDKYEN1           = "zennouzndkyen1";
    public static final String ZENNOUZNDKYEN2           = "zennouzndkyen2";
    public static final String ZENNOUZNDKYEN3           = "zennouzndkyen3";
    public static final String KIHRKMPYEN1              = "kihrkmpyen1";
    public static final String KIHRKMPYEN2              = "kihrkmpyen2";
    public static final String KIHRKMPYEN3              = "kihrkmpyen3";
    public static final String KIHRKMP1                 = "kihrkmp1";
    public static final String KIHRKMP2                 = "kihrkmp2";
    public static final String KIHRKMP3                 = "kihrkmp3";
    public static final String ZENNOUZNDK1              = "zennouzndk1";
    public static final String KAIYAKUJUKTRGK           = "kaiyakujuktrgk";
    public static final String KAIYAKUJUKTRGKYENDAKA    = "kaiyakujuktrgkyendaka";
    public static final String KAIYAKUJUKTRGKYENKIJYUN  = "kaiyakujuktrgkyenkijyun";
    public static final String KAIYAKUJUKTRGKYENYASU    = "kaiyakujuktrgkyenyasu";

    private final PKIT_Suiihyou primaryKey;

    public GenIT_Suiihyou() {
        primaryKey = new PKIT_Suiihyou();
    }

    public GenIT_Suiihyou(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd,
        Integer pKeikanensuu
    ) {
        primaryKey = new PKIT_Suiihyou(
            pKbnkey,
            pSyono,
            pTyouhyouymd,
            pKeikanensuu
        );
    }

    @Transient
    @Override
    public PKIT_Suiihyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_Suiihyou> getMetaClass() {
        return QIT_Suiihyou.class;
    }

    @Id
    @Column(name=GenIT_Suiihyou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_Suiihyou.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_Suiihyou.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    @Id
    @Column(name=GenIT_Suiihyou.KEIKANENSUU)
    public Integer getKeikanensuu() {
        return getPrimaryKey().getKeikanensuu();
    }

    public void setKeikanensuu(Integer pKeikanensuu) {
        getPrimaryKey().setKeikanensuu(pKeikanensuu);
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Suiihyou.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private BizDateYM calcym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_Suiihyou.CALCYM)
    public BizDateYM getCalcym() {
        return calcym;
    }

    public void setCalcym(BizDateYM pCalcym) {
        calcym = pCalcym;
    }

    private C_MvaTekiyoujyoutaiKbn mvatekijyoutaikbn;

    @Type(type="UserType_C_MvaTekiyoujyoutaiKbn")
    @Column(name=GenIT_Suiihyou.MVATEKIJYOUTAIKBN)
    public C_MvaTekiyoujyoutaiKbn getMvatekijyoutaikbn() {
        return mvatekijyoutaikbn;
    }

    public void setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn pMvatekijyoutaikbn) {
        mvatekijyoutaikbn = pMvatekijyoutaikbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_Suiihyou.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizNumber sjkkktusirrtup;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTUP)
    public BizNumber getSjkkktusirrtup() {
        return sjkkktusirrtup;
    }

    public void setSjkkktusirrtup(BizNumber pSjkkktusirrtup) {
        sjkkktusirrtup = pSjkkktusirrtup;
    }

    private BizNumber sjkkktusirrtsame;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTSAME)
    public BizNumber getSjkkktusirrtsame() {
        return sjkkktusirrtsame;
    }

    public void setSjkkktusirrtsame(BizNumber pSjkkktusirrtsame) {
        sjkkktusirrtsame = pSjkkktusirrtsame;
    }

    private BizNumber sjkkktusirrtdown;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTDOWN)
    public BizNumber getSjkkktusirrtdown() {
        return sjkkktusirrtdown;
    }

    public void setSjkkktusirrtdown(BizNumber pSjkkktusirrtdown) {
        sjkkktusirrtdown = pSjkkktusirrtdown;
    }

    private BizNumber sjkkktusirrthendouup;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTHENDOUUP)
    public BizNumber getSjkkktusirrthendouup() {
        return sjkkktusirrthendouup;
    }

    public void setSjkkktusirrthendouup(BizNumber pSjkkktusirrthendouup) {
        sjkkktusirrthendouup = pSjkkktusirrthendouup;
    }

    private BizNumber sjkkktusirrthendoudown;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTHENDOUDOWN)
    public BizNumber getSjkkktusirrthendoudown() {
        return sjkkktusirrthendoudown;
    }

    public void setSjkkktusirrthendoudown(BizNumber pSjkkktusirrthendoudown) {
        sjkkktusirrthendoudown = pSjkkktusirrthendoudown;
    }

    private BizNumber yenknsnkwsrateyendaka;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENDAKA)
    public BizNumber getYenknsnkwsrateyendaka() {
        return yenknsnkwsrateyendaka;
    }

    public void setYenknsnkwsrateyendaka(BizNumber pYenknsnkwsrateyendaka) {
        yenknsnkwsrateyendaka = pYenknsnkwsrateyendaka;
    }

    private BizNumber yenknsnkwsrateyenkijyun;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENKIJYUN)
    public BizNumber getYenknsnkwsrateyenkijyun() {
        return yenknsnkwsrateyenkijyun;
    }

    public void setYenknsnkwsrateyenkijyun(BizNumber pYenknsnkwsrateyenkijyun) {
        yenknsnkwsrateyenkijyun = pYenknsnkwsrateyenkijyun;
    }

    private BizNumber yenknsnkwsrateyenyasu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENYASU)
    public BizNumber getYenknsnkwsrateyenyasu() {
        return yenknsnkwsrateyenyasu;
    }

    public void setYenknsnkwsrateyenyasu(BizNumber pYenknsnkwsrateyenyasu) {
        yenknsnkwsrateyenyasu = pYenknsnkwsrateyenyasu;
    }

    private BizCurrency yenknsnkwsrategkyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenknsnkwsrategkyendaka() {
        return yenknsnkwsrategkyendaka;
    }

    public void setYenknsnkwsrategkyendaka(BizCurrency pYenknsnkwsrategkyendaka) {
        yenknsnkwsrategkyendaka = pYenknsnkwsrategkyendaka;
        yenknsnkwsrategkyendakaValue = null;
        yenknsnkwsrategkyendakaType  = null;
    }

    transient private BigDecimal yenknsnkwsrategkyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKNSNKWSRATEGKYENDAKA, nullable=true)
    protected BigDecimal getYenknsnkwsrategkyendakaValue() {
        if (yenknsnkwsrategkyendakaValue == null && yenknsnkwsrategkyendaka != null) {
            if (yenknsnkwsrategkyendaka.isOptional()) return null;
            return yenknsnkwsrategkyendaka.absolute();
        }
        return yenknsnkwsrategkyendakaValue;
    }

    protected void setYenknsnkwsrategkyendakaValue(BigDecimal value) {
        yenknsnkwsrategkyendakaValue = value;
        yenknsnkwsrategkyendaka = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyendakaType))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyendakaValue()))
            .orNull();
    }

    transient private String yenknsnkwsrategkyendakaType = null;

    @Column(name=YENKNSNKWSRATEGKYENDAKA + "$", nullable=true)
    protected String getYenknsnkwsrategkyendakaType() {
        if (yenknsnkwsrategkyendakaType == null && yenknsnkwsrategkyendaka != null) return yenknsnkwsrategkyendaka.getType().toString();
        if (yenknsnkwsrategkyendakaType == null && getYenknsnkwsrategkyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenknsnkwsrategkyendaka$' should not be NULL."));
        }
        return yenknsnkwsrategkyendakaType;
    }

    protected void setYenknsnkwsrategkyendakaType(String type) {
        yenknsnkwsrategkyendakaType = type;
        yenknsnkwsrategkyendaka = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyendakaType))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyendakaValue()))
            .orNull();
    }

    private BizCurrency yenknsnkwsrategkyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenknsnkwsrategkyenyasu() {
        return yenknsnkwsrategkyenyasu;
    }

    public void setYenknsnkwsrategkyenyasu(BizCurrency pYenknsnkwsrategkyenyasu) {
        yenknsnkwsrategkyenyasu = pYenknsnkwsrategkyenyasu;
        yenknsnkwsrategkyenyasuValue = null;
        yenknsnkwsrategkyenyasuType  = null;
    }

    transient private BigDecimal yenknsnkwsrategkyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKNSNKWSRATEGKYENYASU, nullable=true)
    protected BigDecimal getYenknsnkwsrategkyenyasuValue() {
        if (yenknsnkwsrategkyenyasuValue == null && yenknsnkwsrategkyenyasu != null) {
            if (yenknsnkwsrategkyenyasu.isOptional()) return null;
            return yenknsnkwsrategkyenyasu.absolute();
        }
        return yenknsnkwsrategkyenyasuValue;
    }

    protected void setYenknsnkwsrategkyenyasuValue(BigDecimal value) {
        yenknsnkwsrategkyenyasuValue = value;
        yenknsnkwsrategkyenyasu = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyenyasuType))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyenyasuValue()))
            .orNull();
    }

    transient private String yenknsnkwsrategkyenyasuType = null;

    @Column(name=YENKNSNKWSRATEGKYENYASU + "$", nullable=true)
    protected String getYenknsnkwsrategkyenyasuType() {
        if (yenknsnkwsrategkyenyasuType == null && yenknsnkwsrategkyenyasu != null) return yenknsnkwsrategkyenyasu.getType().toString();
        if (yenknsnkwsrategkyenyasuType == null && getYenknsnkwsrategkyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenknsnkwsrategkyenyasu$' should not be NULL."));
        }
        return yenknsnkwsrategkyenyasuType;
    }

    protected void setYenknsnkwsrategkyenyasuType(String type) {
        yenknsnkwsrategkyenyasuType = type;
        yenknsnkwsrategkyenyasu = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyenyasuType))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyenyasuValue()))
            .orNull();
    }

    private BizCurrency mvaariwup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwup() {
        return mvaariwup;
    }

    public void setMvaariwup(BizCurrency pMvaariwup) {
        mvaariwup = pMvaariwup;
        mvaariwupValue = null;
        mvaariwupType  = null;
    }

    transient private BigDecimal mvaariwupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWUP, nullable=true)
    protected BigDecimal getMvaariwupValue() {
        if (mvaariwupValue == null && mvaariwup != null) {
            if (mvaariwup.isOptional()) return null;
            return mvaariwup.absolute();
        }
        return mvaariwupValue;
    }

    protected void setMvaariwupValue(BigDecimal value) {
        mvaariwupValue = value;
        mvaariwup = Optional.fromNullable(toCurrencyType(mvaariwupType))
            .transform(bizCurrencyTransformer(getMvaariwupValue()))
            .orNull();
    }

    transient private String mvaariwupType = null;

    @Column(name=MVAARIWUP + "$", nullable=true)
    protected String getMvaariwupType() {
        if (mvaariwupType == null && mvaariwup != null) return mvaariwup.getType().toString();
        if (mvaariwupType == null && getMvaariwupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwup$' should not be NULL."));
        }
        return mvaariwupType;
    }

    protected void setMvaariwupType(String type) {
        mvaariwupType = type;
        mvaariwup = Optional.fromNullable(toCurrencyType(mvaariwupType))
            .transform(bizCurrencyTransformer(getMvaariwupValue()))
            .orNull();
    }

    private BizCurrency mvaariwsame;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwsame() {
        return mvaariwsame;
    }

    public void setMvaariwsame(BizCurrency pMvaariwsame) {
        mvaariwsame = pMvaariwsame;
        mvaariwsameValue = null;
        mvaariwsameType  = null;
    }

    transient private BigDecimal mvaariwsameValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWSAME, nullable=true)
    protected BigDecimal getMvaariwsameValue() {
        if (mvaariwsameValue == null && mvaariwsame != null) {
            if (mvaariwsame.isOptional()) return null;
            return mvaariwsame.absolute();
        }
        return mvaariwsameValue;
    }

    protected void setMvaariwsameValue(BigDecimal value) {
        mvaariwsameValue = value;
        mvaariwsame = Optional.fromNullable(toCurrencyType(mvaariwsameType))
            .transform(bizCurrencyTransformer(getMvaariwsameValue()))
            .orNull();
    }

    transient private String mvaariwsameType = null;

    @Column(name=MVAARIWSAME + "$", nullable=true)
    protected String getMvaariwsameType() {
        if (mvaariwsameType == null && mvaariwsame != null) return mvaariwsame.getType().toString();
        if (mvaariwsameType == null && getMvaariwsameValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwsame$' should not be NULL."));
        }
        return mvaariwsameType;
    }

    protected void setMvaariwsameType(String type) {
        mvaariwsameType = type;
        mvaariwsame = Optional.fromNullable(toCurrencyType(mvaariwsameType))
            .transform(bizCurrencyTransformer(getMvaariwsameValue()))
            .orNull();
    }

    private BizCurrency mvaariwdown;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwdown() {
        return mvaariwdown;
    }

    public void setMvaariwdown(BizCurrency pMvaariwdown) {
        mvaariwdown = pMvaariwdown;
        mvaariwdownValue = null;
        mvaariwdownType  = null;
    }

    transient private BigDecimal mvaariwdownValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWDOWN, nullable=true)
    protected BigDecimal getMvaariwdownValue() {
        if (mvaariwdownValue == null && mvaariwdown != null) {
            if (mvaariwdown.isOptional()) return null;
            return mvaariwdown.absolute();
        }
        return mvaariwdownValue;
    }

    protected void setMvaariwdownValue(BigDecimal value) {
        mvaariwdownValue = value;
        mvaariwdown = Optional.fromNullable(toCurrencyType(mvaariwdownType))
            .transform(bizCurrencyTransformer(getMvaariwdownValue()))
            .orNull();
    }

    transient private String mvaariwdownType = null;

    @Column(name=MVAARIWDOWN + "$", nullable=true)
    protected String getMvaariwdownType() {
        if (mvaariwdownType == null && mvaariwdown != null) return mvaariwdown.getType().toString();
        if (mvaariwdownType == null && getMvaariwdownValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwdown$' should not be NULL."));
        }
        return mvaariwdownType;
    }

    protected void setMvaariwdownType(String type) {
        mvaariwdownType = type;
        mvaariwdown = Optional.fromNullable(toCurrencyType(mvaariwdownType))
            .transform(bizCurrencyTransformer(getMvaariwdownValue()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyendaka() {
        return mvaariwyenupyendaka;
    }

    public void setMvaariwyenupyendaka(BizCurrency pMvaariwyenupyendaka) {
        mvaariwyenupyendaka = pMvaariwyenupyendaka;
        mvaariwyenupyendakaValue = null;
        mvaariwyenupyendakaType  = null;
    }

    transient private BigDecimal mvaariwyenupyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENDAKA, nullable=true)
    protected BigDecimal getMvaariwyenupyendakaValue() {
        if (mvaariwyenupyendakaValue == null && mvaariwyenupyendaka != null) {
            if (mvaariwyenupyendaka.isOptional()) return null;
            return mvaariwyenupyendaka.absolute();
        }
        return mvaariwyenupyendakaValue;
    }

    protected void setMvaariwyenupyendakaValue(BigDecimal value) {
        mvaariwyenupyendakaValue = value;
        mvaariwyenupyendaka = Optional.fromNullable(toCurrencyType(mvaariwyenupyendakaType))
            .transform(bizCurrencyTransformer(getMvaariwyenupyendakaValue()))
            .orNull();
    }

    transient private String mvaariwyenupyendakaType = null;

    @Column(name=MVAARIWYENUPYENDAKA + "$", nullable=true)
    protected String getMvaariwyenupyendakaType() {
        if (mvaariwyenupyendakaType == null && mvaariwyenupyendaka != null) return mvaariwyenupyendaka.getType().toString();
        if (mvaariwyenupyendakaType == null && getMvaariwyenupyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyendaka$' should not be NULL."));
        }
        return mvaariwyenupyendakaType;
    }

    protected void setMvaariwyenupyendakaType(String type) {
        mvaariwyenupyendakaType = type;
        mvaariwyenupyendaka = Optional.fromNullable(toCurrencyType(mvaariwyenupyendakaType))
            .transform(bizCurrencyTransformer(getMvaariwyenupyendakaValue()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyenkijyun() {
        return mvaariwyenupyenkijyun;
    }

    public void setMvaariwyenupyenkijyun(BizCurrency pMvaariwyenupyenkijyun) {
        mvaariwyenupyenkijyun = pMvaariwyenupyenkijyun;
        mvaariwyenupyenkijyunValue = null;
        mvaariwyenupyenkijyunType  = null;
    }

    transient private BigDecimal mvaariwyenupyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENKIJYUN, nullable=true)
    protected BigDecimal getMvaariwyenupyenkijyunValue() {
        if (mvaariwyenupyenkijyunValue == null && mvaariwyenupyenkijyun != null) {
            if (mvaariwyenupyenkijyun.isOptional()) return null;
            return mvaariwyenupyenkijyun.absolute();
        }
        return mvaariwyenupyenkijyunValue;
    }

    protected void setMvaariwyenupyenkijyunValue(BigDecimal value) {
        mvaariwyenupyenkijyunValue = value;
        mvaariwyenupyenkijyun = Optional.fromNullable(toCurrencyType(mvaariwyenupyenkijyunType))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenkijyunValue()))
            .orNull();
    }

    transient private String mvaariwyenupyenkijyunType = null;

    @Column(name=MVAARIWYENUPYENKIJYUN + "$", nullable=true)
    protected String getMvaariwyenupyenkijyunType() {
        if (mvaariwyenupyenkijyunType == null && mvaariwyenupyenkijyun != null) return mvaariwyenupyenkijyun.getType().toString();
        if (mvaariwyenupyenkijyunType == null && getMvaariwyenupyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyenkijyun$' should not be NULL."));
        }
        return mvaariwyenupyenkijyunType;
    }

    protected void setMvaariwyenupyenkijyunType(String type) {
        mvaariwyenupyenkijyunType = type;
        mvaariwyenupyenkijyun = Optional.fromNullable(toCurrencyType(mvaariwyenupyenkijyunType))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenkijyunValue()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyenyasu() {
        return mvaariwyenupyenyasu;
    }

    public void setMvaariwyenupyenyasu(BizCurrency pMvaariwyenupyenyasu) {
        mvaariwyenupyenyasu = pMvaariwyenupyenyasu;
        mvaariwyenupyenyasuValue = null;
        mvaariwyenupyenyasuType  = null;
    }

    transient private BigDecimal mvaariwyenupyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENYASU, nullable=true)
    protected BigDecimal getMvaariwyenupyenyasuValue() {
        if (mvaariwyenupyenyasuValue == null && mvaariwyenupyenyasu != null) {
            if (mvaariwyenupyenyasu.isOptional()) return null;
            return mvaariwyenupyenyasu.absolute();
        }
        return mvaariwyenupyenyasuValue;
    }

    protected void setMvaariwyenupyenyasuValue(BigDecimal value) {
        mvaariwyenupyenyasuValue = value;
        mvaariwyenupyenyasu = Optional.fromNullable(toCurrencyType(mvaariwyenupyenyasuType))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenyasuValue()))
            .orNull();
    }

    transient private String mvaariwyenupyenyasuType = null;

    @Column(name=MVAARIWYENUPYENYASU + "$", nullable=true)
    protected String getMvaariwyenupyenyasuType() {
        if (mvaariwyenupyenyasuType == null && mvaariwyenupyenyasu != null) return mvaariwyenupyenyasu.getType().toString();
        if (mvaariwyenupyenyasuType == null && getMvaariwyenupyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyenyasu$' should not be NULL."));
        }
        return mvaariwyenupyenyasuType;
    }

    protected void setMvaariwyenupyenyasuType(String type) {
        mvaariwyenupyenyasuType = type;
        mvaariwyenupyenyasu = Optional.fromNullable(toCurrencyType(mvaariwyenupyenyasuType))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenyasuValue()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyendaka() {
        return mvaariwyensameyendaka;
    }

    public void setMvaariwyensameyendaka(BizCurrency pMvaariwyensameyendaka) {
        mvaariwyensameyendaka = pMvaariwyensameyendaka;
        mvaariwyensameyendakaValue = null;
        mvaariwyensameyendakaType  = null;
    }

    transient private BigDecimal mvaariwyensameyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENDAKA, nullable=true)
    protected BigDecimal getMvaariwyensameyendakaValue() {
        if (mvaariwyensameyendakaValue == null && mvaariwyensameyendaka != null) {
            if (mvaariwyensameyendaka.isOptional()) return null;
            return mvaariwyensameyendaka.absolute();
        }
        return mvaariwyensameyendakaValue;
    }

    protected void setMvaariwyensameyendakaValue(BigDecimal value) {
        mvaariwyensameyendakaValue = value;
        mvaariwyensameyendaka = Optional.fromNullable(toCurrencyType(mvaariwyensameyendakaType))
            .transform(bizCurrencyTransformer(getMvaariwyensameyendakaValue()))
            .orNull();
    }

    transient private String mvaariwyensameyendakaType = null;

    @Column(name=MVAARIWYENSAMEYENDAKA + "$", nullable=true)
    protected String getMvaariwyensameyendakaType() {
        if (mvaariwyensameyendakaType == null && mvaariwyensameyendaka != null) return mvaariwyensameyendaka.getType().toString();
        if (mvaariwyensameyendakaType == null && getMvaariwyensameyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyendaka$' should not be NULL."));
        }
        return mvaariwyensameyendakaType;
    }

    protected void setMvaariwyensameyendakaType(String type) {
        mvaariwyensameyendakaType = type;
        mvaariwyensameyendaka = Optional.fromNullable(toCurrencyType(mvaariwyensameyendakaType))
            .transform(bizCurrencyTransformer(getMvaariwyensameyendakaValue()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyenkijyun() {
        return mvaariwyensameyenkijyun;
    }

    public void setMvaariwyensameyenkijyun(BizCurrency pMvaariwyensameyenkijyun) {
        mvaariwyensameyenkijyun = pMvaariwyensameyenkijyun;
        mvaariwyensameyenkijyunValue = null;
        mvaariwyensameyenkijyunType  = null;
    }

    transient private BigDecimal mvaariwyensameyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENKIJYUN, nullable=true)
    protected BigDecimal getMvaariwyensameyenkijyunValue() {
        if (mvaariwyensameyenkijyunValue == null && mvaariwyensameyenkijyun != null) {
            if (mvaariwyensameyenkijyun.isOptional()) return null;
            return mvaariwyensameyenkijyun.absolute();
        }
        return mvaariwyensameyenkijyunValue;
    }

    protected void setMvaariwyensameyenkijyunValue(BigDecimal value) {
        mvaariwyensameyenkijyunValue = value;
        mvaariwyensameyenkijyun = Optional.fromNullable(toCurrencyType(mvaariwyensameyenkijyunType))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenkijyunValue()))
            .orNull();
    }

    transient private String mvaariwyensameyenkijyunType = null;

    @Column(name=MVAARIWYENSAMEYENKIJYUN + "$", nullable=true)
    protected String getMvaariwyensameyenkijyunType() {
        if (mvaariwyensameyenkijyunType == null && mvaariwyensameyenkijyun != null) return mvaariwyensameyenkijyun.getType().toString();
        if (mvaariwyensameyenkijyunType == null && getMvaariwyensameyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyenkijyun$' should not be NULL."));
        }
        return mvaariwyensameyenkijyunType;
    }

    protected void setMvaariwyensameyenkijyunType(String type) {
        mvaariwyensameyenkijyunType = type;
        mvaariwyensameyenkijyun = Optional.fromNullable(toCurrencyType(mvaariwyensameyenkijyunType))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenkijyunValue()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyenyasu() {
        return mvaariwyensameyenyasu;
    }

    public void setMvaariwyensameyenyasu(BizCurrency pMvaariwyensameyenyasu) {
        mvaariwyensameyenyasu = pMvaariwyensameyenyasu;
        mvaariwyensameyenyasuValue = null;
        mvaariwyensameyenyasuType  = null;
    }

    transient private BigDecimal mvaariwyensameyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENYASU, nullable=true)
    protected BigDecimal getMvaariwyensameyenyasuValue() {
        if (mvaariwyensameyenyasuValue == null && mvaariwyensameyenyasu != null) {
            if (mvaariwyensameyenyasu.isOptional()) return null;
            return mvaariwyensameyenyasu.absolute();
        }
        return mvaariwyensameyenyasuValue;
    }

    protected void setMvaariwyensameyenyasuValue(BigDecimal value) {
        mvaariwyensameyenyasuValue = value;
        mvaariwyensameyenyasu = Optional.fromNullable(toCurrencyType(mvaariwyensameyenyasuType))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenyasuValue()))
            .orNull();
    }

    transient private String mvaariwyensameyenyasuType = null;

    @Column(name=MVAARIWYENSAMEYENYASU + "$", nullable=true)
    protected String getMvaariwyensameyenyasuType() {
        if (mvaariwyensameyenyasuType == null && mvaariwyensameyenyasu != null) return mvaariwyensameyenyasu.getType().toString();
        if (mvaariwyensameyenyasuType == null && getMvaariwyensameyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyenyasu$' should not be NULL."));
        }
        return mvaariwyensameyenyasuType;
    }

    protected void setMvaariwyensameyenyasuType(String type) {
        mvaariwyensameyenyasuType = type;
        mvaariwyensameyenyasu = Optional.fromNullable(toCurrencyType(mvaariwyensameyenyasuType))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenyasuValue()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyendaka() {
        return mvaariwyendownyendaka;
    }

    public void setMvaariwyendownyendaka(BizCurrency pMvaariwyendownyendaka) {
        mvaariwyendownyendaka = pMvaariwyendownyendaka;
        mvaariwyendownyendakaValue = null;
        mvaariwyendownyendakaType  = null;
    }

    transient private BigDecimal mvaariwyendownyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENDAKA, nullable=true)
    protected BigDecimal getMvaariwyendownyendakaValue() {
        if (mvaariwyendownyendakaValue == null && mvaariwyendownyendaka != null) {
            if (mvaariwyendownyendaka.isOptional()) return null;
            return mvaariwyendownyendaka.absolute();
        }
        return mvaariwyendownyendakaValue;
    }

    protected void setMvaariwyendownyendakaValue(BigDecimal value) {
        mvaariwyendownyendakaValue = value;
        mvaariwyendownyendaka = Optional.fromNullable(toCurrencyType(mvaariwyendownyendakaType))
            .transform(bizCurrencyTransformer(getMvaariwyendownyendakaValue()))
            .orNull();
    }

    transient private String mvaariwyendownyendakaType = null;

    @Column(name=MVAARIWYENDOWNYENDAKA + "$", nullable=true)
    protected String getMvaariwyendownyendakaType() {
        if (mvaariwyendownyendakaType == null && mvaariwyendownyendaka != null) return mvaariwyendownyendaka.getType().toString();
        if (mvaariwyendownyendakaType == null && getMvaariwyendownyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyendaka$' should not be NULL."));
        }
        return mvaariwyendownyendakaType;
    }

    protected void setMvaariwyendownyendakaType(String type) {
        mvaariwyendownyendakaType = type;
        mvaariwyendownyendaka = Optional.fromNullable(toCurrencyType(mvaariwyendownyendakaType))
            .transform(bizCurrencyTransformer(getMvaariwyendownyendakaValue()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyenkijyun() {
        return mvaariwyendownyenkijyun;
    }

    public void setMvaariwyendownyenkijyun(BizCurrency pMvaariwyendownyenkijyun) {
        mvaariwyendownyenkijyun = pMvaariwyendownyenkijyun;
        mvaariwyendownyenkijyunValue = null;
        mvaariwyendownyenkijyunType  = null;
    }

    transient private BigDecimal mvaariwyendownyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENKIJYUN, nullable=true)
    protected BigDecimal getMvaariwyendownyenkijyunValue() {
        if (mvaariwyendownyenkijyunValue == null && mvaariwyendownyenkijyun != null) {
            if (mvaariwyendownyenkijyun.isOptional()) return null;
            return mvaariwyendownyenkijyun.absolute();
        }
        return mvaariwyendownyenkijyunValue;
    }

    protected void setMvaariwyendownyenkijyunValue(BigDecimal value) {
        mvaariwyendownyenkijyunValue = value;
        mvaariwyendownyenkijyun = Optional.fromNullable(toCurrencyType(mvaariwyendownyenkijyunType))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenkijyunValue()))
            .orNull();
    }

    transient private String mvaariwyendownyenkijyunType = null;

    @Column(name=MVAARIWYENDOWNYENKIJYUN + "$", nullable=true)
    protected String getMvaariwyendownyenkijyunType() {
        if (mvaariwyendownyenkijyunType == null && mvaariwyendownyenkijyun != null) return mvaariwyendownyenkijyun.getType().toString();
        if (mvaariwyendownyenkijyunType == null && getMvaariwyendownyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyenkijyun$' should not be NULL."));
        }
        return mvaariwyendownyenkijyunType;
    }

    protected void setMvaariwyendownyenkijyunType(String type) {
        mvaariwyendownyenkijyunType = type;
        mvaariwyendownyenkijyun = Optional.fromNullable(toCurrencyType(mvaariwyendownyenkijyunType))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenkijyunValue()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyenyasu() {
        return mvaariwyendownyenyasu;
    }

    public void setMvaariwyendownyenyasu(BizCurrency pMvaariwyendownyenyasu) {
        mvaariwyendownyenyasu = pMvaariwyendownyenyasu;
        mvaariwyendownyenyasuValue = null;
        mvaariwyendownyenyasuType  = null;
    }

    transient private BigDecimal mvaariwyendownyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENYASU, nullable=true)
    protected BigDecimal getMvaariwyendownyenyasuValue() {
        if (mvaariwyendownyenyasuValue == null && mvaariwyendownyenyasu != null) {
            if (mvaariwyendownyenyasu.isOptional()) return null;
            return mvaariwyendownyenyasu.absolute();
        }
        return mvaariwyendownyenyasuValue;
    }

    protected void setMvaariwyendownyenyasuValue(BigDecimal value) {
        mvaariwyendownyenyasuValue = value;
        mvaariwyendownyenyasu = Optional.fromNullable(toCurrencyType(mvaariwyendownyenyasuType))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenyasuValue()))
            .orNull();
    }

    transient private String mvaariwyendownyenyasuType = null;

    @Column(name=MVAARIWYENDOWNYENYASU + "$", nullable=true)
    protected String getMvaariwyendownyenyasuType() {
        if (mvaariwyendownyenyasuType == null && mvaariwyendownyenyasu != null) return mvaariwyendownyenyasu.getType().toString();
        if (mvaariwyendownyenyasuType == null && getMvaariwyendownyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyenyasu$' should not be NULL."));
        }
        return mvaariwyendownyenyasuType;
    }

    protected void setMvaariwyendownyenyasuType(String type) {
        mvaariwyendownyenyasuType = type;
        mvaariwyendownyenyasu = Optional.fromNullable(toCurrencyType(mvaariwyendownyenyasuType))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenyasuValue()))
            .orNull();
    }

    private BizCurrency mvaariptumitatekin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariptumitatekin() {
        return mvaariptumitatekin;
    }

    public void setMvaariptumitatekin(BizCurrency pMvaariptumitatekin) {
        mvaariptumitatekin = pMvaariptumitatekin;
        mvaariptumitatekinValue = null;
        mvaariptumitatekinType  = null;
    }

    transient private BigDecimal mvaariptumitatekinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIPTUMITATEKIN, nullable=true)
    protected BigDecimal getMvaariptumitatekinValue() {
        if (mvaariptumitatekinValue == null && mvaariptumitatekin != null) {
            if (mvaariptumitatekin.isOptional()) return null;
            return mvaariptumitatekin.absolute();
        }
        return mvaariptumitatekinValue;
    }

    protected void setMvaariptumitatekinValue(BigDecimal value) {
        mvaariptumitatekinValue = value;
        mvaariptumitatekin = Optional.fromNullable(toCurrencyType(mvaariptumitatekinType))
            .transform(bizCurrencyTransformer(getMvaariptumitatekinValue()))
            .orNull();
    }

    transient private String mvaariptumitatekinType = null;

    @Column(name=MVAARIPTUMITATEKIN + "$", nullable=true)
    protected String getMvaariptumitatekinType() {
        if (mvaariptumitatekinType == null && mvaariptumitatekin != null) return mvaariptumitatekin.getType().toString();
        if (mvaariptumitatekinType == null && getMvaariptumitatekinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariptumitatekin$' should not be NULL."));
        }
        return mvaariptumitatekinType;
    }

    protected void setMvaariptumitatekinType(String type) {
        mvaariptumitatekinType = type;
        mvaariptumitatekin = Optional.fromNullable(toCurrencyType(mvaariptumitatekinType))
            .transform(bizCurrencyTransformer(getMvaariptumitatekinValue()))
            .orNull();
    }

    private BizCurrency mvanonewsame;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewsame() {
        return mvanonewsame;
    }

    public void setMvanonewsame(BizCurrency pMvanonewsame) {
        mvanonewsame = pMvanonewsame;
        mvanonewsameValue = null;
        mvanonewsameType  = null;
    }

    transient private BigDecimal mvanonewsameValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWSAME, nullable=true)
    protected BigDecimal getMvanonewsameValue() {
        if (mvanonewsameValue == null && mvanonewsame != null) {
            if (mvanonewsame.isOptional()) return null;
            return mvanonewsame.absolute();
        }
        return mvanonewsameValue;
    }

    protected void setMvanonewsameValue(BigDecimal value) {
        mvanonewsameValue = value;
        mvanonewsame = Optional.fromNullable(toCurrencyType(mvanonewsameType))
            .transform(bizCurrencyTransformer(getMvanonewsameValue()))
            .orNull();
    }

    transient private String mvanonewsameType = null;

    @Column(name=MVANONEWSAME + "$", nullable=true)
    protected String getMvanonewsameType() {
        if (mvanonewsameType == null && mvanonewsame != null) return mvanonewsame.getType().toString();
        if (mvanonewsameType == null && getMvanonewsameValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewsame$' should not be NULL."));
        }
        return mvanonewsameType;
    }

    protected void setMvanonewsameType(String type) {
        mvanonewsameType = type;
        mvanonewsame = Optional.fromNullable(toCurrencyType(mvanonewsameType))
            .transform(bizCurrencyTransformer(getMvanonewsameValue()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyendaka() {
        return mvanonewyensameyendaka;
    }

    public void setMvanonewyensameyendaka(BizCurrency pMvanonewyensameyendaka) {
        mvanonewyensameyendaka = pMvanonewyensameyendaka;
        mvanonewyensameyendakaValue = null;
        mvanonewyensameyendakaType  = null;
    }

    transient private BigDecimal mvanonewyensameyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENDAKA, nullable=true)
    protected BigDecimal getMvanonewyensameyendakaValue() {
        if (mvanonewyensameyendakaValue == null && mvanonewyensameyendaka != null) {
            if (mvanonewyensameyendaka.isOptional()) return null;
            return mvanonewyensameyendaka.absolute();
        }
        return mvanonewyensameyendakaValue;
    }

    protected void setMvanonewyensameyendakaValue(BigDecimal value) {
        mvanonewyensameyendakaValue = value;
        mvanonewyensameyendaka = Optional.fromNullable(toCurrencyType(mvanonewyensameyendakaType))
            .transform(bizCurrencyTransformer(getMvanonewyensameyendakaValue()))
            .orNull();
    }

    transient private String mvanonewyensameyendakaType = null;

    @Column(name=MVANONEWYENSAMEYENDAKA + "$", nullable=true)
    protected String getMvanonewyensameyendakaType() {
        if (mvanonewyensameyendakaType == null && mvanonewyensameyendaka != null) return mvanonewyensameyendaka.getType().toString();
        if (mvanonewyensameyendakaType == null && getMvanonewyensameyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyendaka$' should not be NULL."));
        }
        return mvanonewyensameyendakaType;
    }

    protected void setMvanonewyensameyendakaType(String type) {
        mvanonewyensameyendakaType = type;
        mvanonewyensameyendaka = Optional.fromNullable(toCurrencyType(mvanonewyensameyendakaType))
            .transform(bizCurrencyTransformer(getMvanonewyensameyendakaValue()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyenkijyun() {
        return mvanonewyensameyenkijyun;
    }

    public void setMvanonewyensameyenkijyun(BizCurrency pMvanonewyensameyenkijyun) {
        mvanonewyensameyenkijyun = pMvanonewyensameyenkijyun;
        mvanonewyensameyenkijyunValue = null;
        mvanonewyensameyenkijyunType  = null;
    }

    transient private BigDecimal mvanonewyensameyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENKIJYUN, nullable=true)
    protected BigDecimal getMvanonewyensameyenkijyunValue() {
        if (mvanonewyensameyenkijyunValue == null && mvanonewyensameyenkijyun != null) {
            if (mvanonewyensameyenkijyun.isOptional()) return null;
            return mvanonewyensameyenkijyun.absolute();
        }
        return mvanonewyensameyenkijyunValue;
    }

    protected void setMvanonewyensameyenkijyunValue(BigDecimal value) {
        mvanonewyensameyenkijyunValue = value;
        mvanonewyensameyenkijyun = Optional.fromNullable(toCurrencyType(mvanonewyensameyenkijyunType))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenkijyunValue()))
            .orNull();
    }

    transient private String mvanonewyensameyenkijyunType = null;

    @Column(name=MVANONEWYENSAMEYENKIJYUN + "$", nullable=true)
    protected String getMvanonewyensameyenkijyunType() {
        if (mvanonewyensameyenkijyunType == null && mvanonewyensameyenkijyun != null) return mvanonewyensameyenkijyun.getType().toString();
        if (mvanonewyensameyenkijyunType == null && getMvanonewyensameyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyenkijyun$' should not be NULL."));
        }
        return mvanonewyensameyenkijyunType;
    }

    protected void setMvanonewyensameyenkijyunType(String type) {
        mvanonewyensameyenkijyunType = type;
        mvanonewyensameyenkijyun = Optional.fromNullable(toCurrencyType(mvanonewyensameyenkijyunType))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenkijyunValue()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyenyasu() {
        return mvanonewyensameyenyasu;
    }

    public void setMvanonewyensameyenyasu(BizCurrency pMvanonewyensameyenyasu) {
        mvanonewyensameyenyasu = pMvanonewyensameyenyasu;
        mvanonewyensameyenyasuValue = null;
        mvanonewyensameyenyasuType  = null;
    }

    transient private BigDecimal mvanonewyensameyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENYASU, nullable=true)
    protected BigDecimal getMvanonewyensameyenyasuValue() {
        if (mvanonewyensameyenyasuValue == null && mvanonewyensameyenyasu != null) {
            if (mvanonewyensameyenyasu.isOptional()) return null;
            return mvanonewyensameyenyasu.absolute();
        }
        return mvanonewyensameyenyasuValue;
    }

    protected void setMvanonewyensameyenyasuValue(BigDecimal value) {
        mvanonewyensameyenyasuValue = value;
        mvanonewyensameyenyasu = Optional.fromNullable(toCurrencyType(mvanonewyensameyenyasuType))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenyasuValue()))
            .orNull();
    }

    transient private String mvanonewyensameyenyasuType = null;

    @Column(name=MVANONEWYENSAMEYENYASU + "$", nullable=true)
    protected String getMvanonewyensameyenyasuType() {
        if (mvanonewyensameyenyasuType == null && mvanonewyensameyenyasu != null) return mvanonewyensameyenyasu.getType().toString();
        if (mvanonewyensameyenyasuType == null && getMvanonewyensameyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyenyasu$' should not be NULL."));
        }
        return mvanonewyensameyenyasuType;
    }

    protected void setMvanonewyensameyenyasuType(String type) {
        mvanonewyensameyenyasuType = type;
        mvanonewyensameyenyasu = Optional.fromNullable(toCurrencyType(mvanonewyensameyenyasuType))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenyasuValue()))
            .orNull();
    }

    private BizCurrency mvanoneptumitatekin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanoneptumitatekin() {
        return mvanoneptumitatekin;
    }

    public void setMvanoneptumitatekin(BizCurrency pMvanoneptumitatekin) {
        mvanoneptumitatekin = pMvanoneptumitatekin;
        mvanoneptumitatekinValue = null;
        mvanoneptumitatekinType  = null;
    }

    transient private BigDecimal mvanoneptumitatekinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEPTUMITATEKIN, nullable=true)
    protected BigDecimal getMvanoneptumitatekinValue() {
        if (mvanoneptumitatekinValue == null && mvanoneptumitatekin != null) {
            if (mvanoneptumitatekin.isOptional()) return null;
            return mvanoneptumitatekin.absolute();
        }
        return mvanoneptumitatekinValue;
    }

    protected void setMvanoneptumitatekinValue(BigDecimal value) {
        mvanoneptumitatekinValue = value;
        mvanoneptumitatekin = Optional.fromNullable(toCurrencyType(mvanoneptumitatekinType))
            .transform(bizCurrencyTransformer(getMvanoneptumitatekinValue()))
            .orNull();
    }

    transient private String mvanoneptumitatekinType = null;

    @Column(name=MVANONEPTUMITATEKIN + "$", nullable=true)
    protected String getMvanoneptumitatekinType() {
        if (mvanoneptumitatekinType == null && mvanoneptumitatekin != null) return mvanoneptumitatekin.getType().toString();
        if (mvanoneptumitatekinType == null && getMvanoneptumitatekinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanoneptumitatekin$' should not be NULL."));
        }
        return mvanoneptumitatekinType;
    }

    protected void setMvanoneptumitatekinType(String type) {
        mvanoneptumitatekinType = type;
        mvanoneptumitatekin = Optional.fromNullable(toCurrencyType(mvanoneptumitatekinType))
            .transform(bizCurrencyTransformer(getMvanoneptumitatekinValue()))
            .orNull();
    }

    private BizCurrency mkhyouyensysnikougk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMkhyouyensysnikougk() {
        return mkhyouyensysnikougk;
    }

    public void setMkhyouyensysnikougk(BizCurrency pMkhyouyensysnikougk) {
        mkhyouyensysnikougk = pMkhyouyensysnikougk;
        mkhyouyensysnikougkValue = null;
        mkhyouyensysnikougkType  = null;
    }

    transient private BigDecimal mkhyouyensysnikougkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MKHYOUYENSYSNIKOUGK, nullable=true)
    protected BigDecimal getMkhyouyensysnikougkValue() {
        if (mkhyouyensysnikougkValue == null && mkhyouyensysnikougk != null) {
            if (mkhyouyensysnikougk.isOptional()) return null;
            return mkhyouyensysnikougk.absolute();
        }
        return mkhyouyensysnikougkValue;
    }

    protected void setMkhyouyensysnikougkValue(BigDecimal value) {
        mkhyouyensysnikougkValue = value;
        mkhyouyensysnikougk = Optional.fromNullable(toCurrencyType(mkhyouyensysnikougkType))
            .transform(bizCurrencyTransformer(getMkhyouyensysnikougkValue()))
            .orNull();
    }

    transient private String mkhyouyensysnikougkType = null;

    @Column(name=MKHYOUYENSYSNIKOUGK + "$", nullable=true)
    protected String getMkhyouyensysnikougkType() {
        if (mkhyouyensysnikougkType == null && mkhyouyensysnikougk != null) return mkhyouyensysnikougk.getType().toString();
        if (mkhyouyensysnikougkType == null && getMkhyouyensysnikougkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mkhyouyensysnikougk$' should not be NULL."));
        }
        return mkhyouyensysnikougkType;
    }

    protected void setMkhyouyensysnikougkType(String type) {
        mkhyouyensysnikougkType = type;
        mkhyouyensysnikougk = Optional.fromNullable(toCurrencyType(mkhyouyensysnikougkType))
            .transform(bizCurrencyTransformer(getMkhyouyensysnikougkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_Suiihyou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_Suiihyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_Suiihyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizNumber tmttknzoukaritu1;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.TMTTKNZOUKARITU1)
    public BizNumber getTmttknzoukaritu1() {
        return tmttknzoukaritu1;
    }

    public void setTmttknzoukaritu1(BizNumber pTmttknzoukaritu1) {
        tmttknzoukaritu1 = pTmttknzoukaritu1;
    }

    private BizNumber tmttknzoukaritu2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.TMTTKNZOUKARITU2)
    public BizNumber getTmttknzoukaritu2() {
        return tmttknzoukaritu2;
    }

    public void setTmttknzoukaritu2(BizNumber pTmttknzoukaritu2) {
        tmttknzoukaritu2 = pTmttknzoukaritu2;
    }

    private BizNumber tmttknzoukaritu3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.TMTTKNZOUKARITU3)
    public BizNumber getTmttknzoukaritu3() {
        return tmttknzoukaritu3;
    }

    public void setTmttknzoukaritu3(BizNumber pTmttknzoukaritu3) {
        tmttknzoukaritu3 = pTmttknzoukaritu3;
    }

    private BizNumber sjkkktusirrtup2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTUP2)
    public BizNumber getSjkkktusirrtup2() {
        return sjkkktusirrtup2;
    }

    public void setSjkkktusirrtup2(BizNumber pSjkkktusirrtup2) {
        sjkkktusirrtup2 = pSjkkktusirrtup2;
    }

    private BizNumber sjkkktusirrtsame2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTSAME2)
    public BizNumber getSjkkktusirrtsame2() {
        return sjkkktusirrtsame2;
    }

    public void setSjkkktusirrtsame2(BizNumber pSjkkktusirrtsame2) {
        sjkkktusirrtsame2 = pSjkkktusirrtsame2;
    }

    private BizNumber sjkkktusirrtdown2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTDOWN2)
    public BizNumber getSjkkktusirrtdown2() {
        return sjkkktusirrtdown2;
    }

    public void setSjkkktusirrtdown2(BizNumber pSjkkktusirrtdown2) {
        sjkkktusirrtdown2 = pSjkkktusirrtdown2;
    }

    private BizNumber sjkkktusirrthendouup2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTHENDOUUP2)
    public BizNumber getSjkkktusirrthendouup2() {
        return sjkkktusirrthendouup2;
    }

    public void setSjkkktusirrthendouup2(BizNumber pSjkkktusirrthendouup2) {
        sjkkktusirrthendouup2 = pSjkkktusirrthendouup2;
    }

    private BizNumber sjkkktusirrthendoudown2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTHENDOUDOWN2)
    public BizNumber getSjkkktusirrthendoudown2() {
        return sjkkktusirrthendoudown2;
    }

    public void setSjkkktusirrthendoudown2(BizNumber pSjkkktusirrthendoudown2) {
        sjkkktusirrthendoudown2 = pSjkkktusirrthendoudown2;
    }

    private BizNumber yenknsnkwsrateyendaka2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENDAKA2)
    public BizNumber getYenknsnkwsrateyendaka2() {
        return yenknsnkwsrateyendaka2;
    }

    public void setYenknsnkwsrateyendaka2(BizNumber pYenknsnkwsrateyendaka2) {
        yenknsnkwsrateyendaka2 = pYenknsnkwsrateyendaka2;
    }

    private BizNumber yenknsnkwsrateyenkijyun2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENKIJYUN2)
    public BizNumber getYenknsnkwsrateyenkijyun2() {
        return yenknsnkwsrateyenkijyun2;
    }

    public void setYenknsnkwsrateyenkijyun2(BizNumber pYenknsnkwsrateyenkijyun2) {
        yenknsnkwsrateyenkijyun2 = pYenknsnkwsrateyenkijyun2;
    }

    private BizNumber yenknsnkwsrateyenyasu2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENYASU2)
    public BizNumber getYenknsnkwsrateyenyasu2() {
        return yenknsnkwsrateyenyasu2;
    }

    public void setYenknsnkwsrateyenyasu2(BizNumber pYenknsnkwsrateyenyasu2) {
        yenknsnkwsrateyenyasu2 = pYenknsnkwsrateyenyasu2;
    }

    private BizCurrency yenknsnkwsrategkyendaka2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenknsnkwsrategkyendaka2() {
        return yenknsnkwsrategkyendaka2;
    }

    public void setYenknsnkwsrategkyendaka2(BizCurrency pYenknsnkwsrategkyendaka2) {
        yenknsnkwsrategkyendaka2 = pYenknsnkwsrategkyendaka2;
        yenknsnkwsrategkyendaka2Value = null;
        yenknsnkwsrategkyendaka2Type  = null;
    }

    transient private BigDecimal yenknsnkwsrategkyendaka2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKNSNKWSRATEGKYENDAKA2, nullable=true)
    protected BigDecimal getYenknsnkwsrategkyendaka2Value() {
        if (yenknsnkwsrategkyendaka2Value == null && yenknsnkwsrategkyendaka2 != null) {
            if (yenknsnkwsrategkyendaka2.isOptional()) return null;
            return yenknsnkwsrategkyendaka2.absolute();
        }
        return yenknsnkwsrategkyendaka2Value;
    }

    protected void setYenknsnkwsrategkyendaka2Value(BigDecimal value) {
        yenknsnkwsrategkyendaka2Value = value;
        yenknsnkwsrategkyendaka2 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyendaka2Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyendaka2Value()))
            .orNull();
    }

    transient private String yenknsnkwsrategkyendaka2Type = null;

    @Column(name=YENKNSNKWSRATEGKYENDAKA2 + "$", nullable=true)
    protected String getYenknsnkwsrategkyendaka2Type() {
        if (yenknsnkwsrategkyendaka2Type == null && yenknsnkwsrategkyendaka2 != null) return yenknsnkwsrategkyendaka2.getType().toString();
        if (yenknsnkwsrategkyendaka2Type == null && getYenknsnkwsrategkyendaka2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenknsnkwsrategkyendaka2$' should not be NULL."));
        }
        return yenknsnkwsrategkyendaka2Type;
    }

    protected void setYenknsnkwsrategkyendaka2Type(String type) {
        yenknsnkwsrategkyendaka2Type = type;
        yenknsnkwsrategkyendaka2 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyendaka2Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyendaka2Value()))
            .orNull();
    }

    private BizCurrency yenknsnkwsrategkyenyasu2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenknsnkwsrategkyenyasu2() {
        return yenknsnkwsrategkyenyasu2;
    }

    public void setYenknsnkwsrategkyenyasu2(BizCurrency pYenknsnkwsrategkyenyasu2) {
        yenknsnkwsrategkyenyasu2 = pYenknsnkwsrategkyenyasu2;
        yenknsnkwsrategkyenyasu2Value = null;
        yenknsnkwsrategkyenyasu2Type  = null;
    }

    transient private BigDecimal yenknsnkwsrategkyenyasu2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKNSNKWSRATEGKYENYASU2, nullable=true)
    protected BigDecimal getYenknsnkwsrategkyenyasu2Value() {
        if (yenknsnkwsrategkyenyasu2Value == null && yenknsnkwsrategkyenyasu2 != null) {
            if (yenknsnkwsrategkyenyasu2.isOptional()) return null;
            return yenknsnkwsrategkyenyasu2.absolute();
        }
        return yenknsnkwsrategkyenyasu2Value;
    }

    protected void setYenknsnkwsrategkyenyasu2Value(BigDecimal value) {
        yenknsnkwsrategkyenyasu2Value = value;
        yenknsnkwsrategkyenyasu2 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyenyasu2Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyenyasu2Value()))
            .orNull();
    }

    transient private String yenknsnkwsrategkyenyasu2Type = null;

    @Column(name=YENKNSNKWSRATEGKYENYASU2 + "$", nullable=true)
    protected String getYenknsnkwsrategkyenyasu2Type() {
        if (yenknsnkwsrategkyenyasu2Type == null && yenknsnkwsrategkyenyasu2 != null) return yenknsnkwsrategkyenyasu2.getType().toString();
        if (yenknsnkwsrategkyenyasu2Type == null && getYenknsnkwsrategkyenyasu2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenknsnkwsrategkyenyasu2$' should not be NULL."));
        }
        return yenknsnkwsrategkyenyasu2Type;
    }

    protected void setYenknsnkwsrategkyenyasu2Type(String type) {
        yenknsnkwsrategkyenyasu2Type = type;
        yenknsnkwsrategkyenyasu2 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyenyasu2Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyenyasu2Value()))
            .orNull();
    }

    private BizCurrency mvaariwup2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwup2() {
        return mvaariwup2;
    }

    public void setMvaariwup2(BizCurrency pMvaariwup2) {
        mvaariwup2 = pMvaariwup2;
        mvaariwup2Value = null;
        mvaariwup2Type  = null;
    }

    transient private BigDecimal mvaariwup2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWUP2, nullable=true)
    protected BigDecimal getMvaariwup2Value() {
        if (mvaariwup2Value == null && mvaariwup2 != null) {
            if (mvaariwup2.isOptional()) return null;
            return mvaariwup2.absolute();
        }
        return mvaariwup2Value;
    }

    protected void setMvaariwup2Value(BigDecimal value) {
        mvaariwup2Value = value;
        mvaariwup2 = Optional.fromNullable(toCurrencyType(mvaariwup2Type))
            .transform(bizCurrencyTransformer(getMvaariwup2Value()))
            .orNull();
    }

    transient private String mvaariwup2Type = null;

    @Column(name=MVAARIWUP2 + "$", nullable=true)
    protected String getMvaariwup2Type() {
        if (mvaariwup2Type == null && mvaariwup2 != null) return mvaariwup2.getType().toString();
        if (mvaariwup2Type == null && getMvaariwup2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwup2$' should not be NULL."));
        }
        return mvaariwup2Type;
    }

    protected void setMvaariwup2Type(String type) {
        mvaariwup2Type = type;
        mvaariwup2 = Optional.fromNullable(toCurrencyType(mvaariwup2Type))
            .transform(bizCurrencyTransformer(getMvaariwup2Value()))
            .orNull();
    }

    private BizCurrency mvaariwsame2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwsame2() {
        return mvaariwsame2;
    }

    public void setMvaariwsame2(BizCurrency pMvaariwsame2) {
        mvaariwsame2 = pMvaariwsame2;
        mvaariwsame2Value = null;
        mvaariwsame2Type  = null;
    }

    transient private BigDecimal mvaariwsame2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWSAME2, nullable=true)
    protected BigDecimal getMvaariwsame2Value() {
        if (mvaariwsame2Value == null && mvaariwsame2 != null) {
            if (mvaariwsame2.isOptional()) return null;
            return mvaariwsame2.absolute();
        }
        return mvaariwsame2Value;
    }

    protected void setMvaariwsame2Value(BigDecimal value) {
        mvaariwsame2Value = value;
        mvaariwsame2 = Optional.fromNullable(toCurrencyType(mvaariwsame2Type))
            .transform(bizCurrencyTransformer(getMvaariwsame2Value()))
            .orNull();
    }

    transient private String mvaariwsame2Type = null;

    @Column(name=MVAARIWSAME2 + "$", nullable=true)
    protected String getMvaariwsame2Type() {
        if (mvaariwsame2Type == null && mvaariwsame2 != null) return mvaariwsame2.getType().toString();
        if (mvaariwsame2Type == null && getMvaariwsame2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwsame2$' should not be NULL."));
        }
        return mvaariwsame2Type;
    }

    protected void setMvaariwsame2Type(String type) {
        mvaariwsame2Type = type;
        mvaariwsame2 = Optional.fromNullable(toCurrencyType(mvaariwsame2Type))
            .transform(bizCurrencyTransformer(getMvaariwsame2Value()))
            .orNull();
    }

    private BizCurrency mvaariwdown2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwdown2() {
        return mvaariwdown2;
    }

    public void setMvaariwdown2(BizCurrency pMvaariwdown2) {
        mvaariwdown2 = pMvaariwdown2;
        mvaariwdown2Value = null;
        mvaariwdown2Type  = null;
    }

    transient private BigDecimal mvaariwdown2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWDOWN2, nullable=true)
    protected BigDecimal getMvaariwdown2Value() {
        if (mvaariwdown2Value == null && mvaariwdown2 != null) {
            if (mvaariwdown2.isOptional()) return null;
            return mvaariwdown2.absolute();
        }
        return mvaariwdown2Value;
    }

    protected void setMvaariwdown2Value(BigDecimal value) {
        mvaariwdown2Value = value;
        mvaariwdown2 = Optional.fromNullable(toCurrencyType(mvaariwdown2Type))
            .transform(bizCurrencyTransformer(getMvaariwdown2Value()))
            .orNull();
    }

    transient private String mvaariwdown2Type = null;

    @Column(name=MVAARIWDOWN2 + "$", nullable=true)
    protected String getMvaariwdown2Type() {
        if (mvaariwdown2Type == null && mvaariwdown2 != null) return mvaariwdown2.getType().toString();
        if (mvaariwdown2Type == null && getMvaariwdown2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwdown2$' should not be NULL."));
        }
        return mvaariwdown2Type;
    }

    protected void setMvaariwdown2Type(String type) {
        mvaariwdown2Type = type;
        mvaariwdown2 = Optional.fromNullable(toCurrencyType(mvaariwdown2Type))
            .transform(bizCurrencyTransformer(getMvaariwdown2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyendaka2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyendaka2() {
        return mvaariwyenupyendaka2;
    }

    public void setMvaariwyenupyendaka2(BizCurrency pMvaariwyenupyendaka2) {
        mvaariwyenupyendaka2 = pMvaariwyenupyendaka2;
        mvaariwyenupyendaka2Value = null;
        mvaariwyenupyendaka2Type  = null;
    }

    transient private BigDecimal mvaariwyenupyendaka2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENDAKA2, nullable=true)
    protected BigDecimal getMvaariwyenupyendaka2Value() {
        if (mvaariwyenupyendaka2Value == null && mvaariwyenupyendaka2 != null) {
            if (mvaariwyenupyendaka2.isOptional()) return null;
            return mvaariwyenupyendaka2.absolute();
        }
        return mvaariwyenupyendaka2Value;
    }

    protected void setMvaariwyenupyendaka2Value(BigDecimal value) {
        mvaariwyenupyendaka2Value = value;
        mvaariwyenupyendaka2 = Optional.fromNullable(toCurrencyType(mvaariwyenupyendaka2Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyendaka2Value()))
            .orNull();
    }

    transient private String mvaariwyenupyendaka2Type = null;

    @Column(name=MVAARIWYENUPYENDAKA2 + "$", nullable=true)
    protected String getMvaariwyenupyendaka2Type() {
        if (mvaariwyenupyendaka2Type == null && mvaariwyenupyendaka2 != null) return mvaariwyenupyendaka2.getType().toString();
        if (mvaariwyenupyendaka2Type == null && getMvaariwyenupyendaka2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyendaka2$' should not be NULL."));
        }
        return mvaariwyenupyendaka2Type;
    }

    protected void setMvaariwyenupyendaka2Type(String type) {
        mvaariwyenupyendaka2Type = type;
        mvaariwyenupyendaka2 = Optional.fromNullable(toCurrencyType(mvaariwyenupyendaka2Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyendaka2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyenkijyun2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyenkijyun2() {
        return mvaariwyenupyenkijyun2;
    }

    public void setMvaariwyenupyenkijyun2(BizCurrency pMvaariwyenupyenkijyun2) {
        mvaariwyenupyenkijyun2 = pMvaariwyenupyenkijyun2;
        mvaariwyenupyenkijyun2Value = null;
        mvaariwyenupyenkijyun2Type  = null;
    }

    transient private BigDecimal mvaariwyenupyenkijyun2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENKIJYUN2, nullable=true)
    protected BigDecimal getMvaariwyenupyenkijyun2Value() {
        if (mvaariwyenupyenkijyun2Value == null && mvaariwyenupyenkijyun2 != null) {
            if (mvaariwyenupyenkijyun2.isOptional()) return null;
            return mvaariwyenupyenkijyun2.absolute();
        }
        return mvaariwyenupyenkijyun2Value;
    }

    protected void setMvaariwyenupyenkijyun2Value(BigDecimal value) {
        mvaariwyenupyenkijyun2Value = value;
        mvaariwyenupyenkijyun2 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenkijyun2Value()))
            .orNull();
    }

    transient private String mvaariwyenupyenkijyun2Type = null;

    @Column(name=MVAARIWYENUPYENKIJYUN2 + "$", nullable=true)
    protected String getMvaariwyenupyenkijyun2Type() {
        if (mvaariwyenupyenkijyun2Type == null && mvaariwyenupyenkijyun2 != null) return mvaariwyenupyenkijyun2.getType().toString();
        if (mvaariwyenupyenkijyun2Type == null && getMvaariwyenupyenkijyun2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyenkijyun2$' should not be NULL."));
        }
        return mvaariwyenupyenkijyun2Type;
    }

    protected void setMvaariwyenupyenkijyun2Type(String type) {
        mvaariwyenupyenkijyun2Type = type;
        mvaariwyenupyenkijyun2 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenkijyun2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyenyasu2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyenyasu2() {
        return mvaariwyenupyenyasu2;
    }

    public void setMvaariwyenupyenyasu2(BizCurrency pMvaariwyenupyenyasu2) {
        mvaariwyenupyenyasu2 = pMvaariwyenupyenyasu2;
        mvaariwyenupyenyasu2Value = null;
        mvaariwyenupyenyasu2Type  = null;
    }

    transient private BigDecimal mvaariwyenupyenyasu2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENYASU2, nullable=true)
    protected BigDecimal getMvaariwyenupyenyasu2Value() {
        if (mvaariwyenupyenyasu2Value == null && mvaariwyenupyenyasu2 != null) {
            if (mvaariwyenupyenyasu2.isOptional()) return null;
            return mvaariwyenupyenyasu2.absolute();
        }
        return mvaariwyenupyenyasu2Value;
    }

    protected void setMvaariwyenupyenyasu2Value(BigDecimal value) {
        mvaariwyenupyenyasu2Value = value;
        mvaariwyenupyenyasu2 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenyasu2Value()))
            .orNull();
    }

    transient private String mvaariwyenupyenyasu2Type = null;

    @Column(name=MVAARIWYENUPYENYASU2 + "$", nullable=true)
    protected String getMvaariwyenupyenyasu2Type() {
        if (mvaariwyenupyenyasu2Type == null && mvaariwyenupyenyasu2 != null) return mvaariwyenupyenyasu2.getType().toString();
        if (mvaariwyenupyenyasu2Type == null && getMvaariwyenupyenyasu2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyenyasu2$' should not be NULL."));
        }
        return mvaariwyenupyenyasu2Type;
    }

    protected void setMvaariwyenupyenyasu2Type(String type) {
        mvaariwyenupyenyasu2Type = type;
        mvaariwyenupyenyasu2 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenyasu2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyendaka2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyendaka2() {
        return mvaariwyensameyendaka2;
    }

    public void setMvaariwyensameyendaka2(BizCurrency pMvaariwyensameyendaka2) {
        mvaariwyensameyendaka2 = pMvaariwyensameyendaka2;
        mvaariwyensameyendaka2Value = null;
        mvaariwyensameyendaka2Type  = null;
    }

    transient private BigDecimal mvaariwyensameyendaka2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENDAKA2, nullable=true)
    protected BigDecimal getMvaariwyensameyendaka2Value() {
        if (mvaariwyensameyendaka2Value == null && mvaariwyensameyendaka2 != null) {
            if (mvaariwyensameyendaka2.isOptional()) return null;
            return mvaariwyensameyendaka2.absolute();
        }
        return mvaariwyensameyendaka2Value;
    }

    protected void setMvaariwyensameyendaka2Value(BigDecimal value) {
        mvaariwyensameyendaka2Value = value;
        mvaariwyensameyendaka2 = Optional.fromNullable(toCurrencyType(mvaariwyensameyendaka2Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyendaka2Value()))
            .orNull();
    }

    transient private String mvaariwyensameyendaka2Type = null;

    @Column(name=MVAARIWYENSAMEYENDAKA2 + "$", nullable=true)
    protected String getMvaariwyensameyendaka2Type() {
        if (mvaariwyensameyendaka2Type == null && mvaariwyensameyendaka2 != null) return mvaariwyensameyendaka2.getType().toString();
        if (mvaariwyensameyendaka2Type == null && getMvaariwyensameyendaka2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyendaka2$' should not be NULL."));
        }
        return mvaariwyensameyendaka2Type;
    }

    protected void setMvaariwyensameyendaka2Type(String type) {
        mvaariwyensameyendaka2Type = type;
        mvaariwyensameyendaka2 = Optional.fromNullable(toCurrencyType(mvaariwyensameyendaka2Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyendaka2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyenkijyun2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyenkijyun2() {
        return mvaariwyensameyenkijyun2;
    }

    public void setMvaariwyensameyenkijyun2(BizCurrency pMvaariwyensameyenkijyun2) {
        mvaariwyensameyenkijyun2 = pMvaariwyensameyenkijyun2;
        mvaariwyensameyenkijyun2Value = null;
        mvaariwyensameyenkijyun2Type  = null;
    }

    transient private BigDecimal mvaariwyensameyenkijyun2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENKIJYUN2, nullable=true)
    protected BigDecimal getMvaariwyensameyenkijyun2Value() {
        if (mvaariwyensameyenkijyun2Value == null && mvaariwyensameyenkijyun2 != null) {
            if (mvaariwyensameyenkijyun2.isOptional()) return null;
            return mvaariwyensameyenkijyun2.absolute();
        }
        return mvaariwyensameyenkijyun2Value;
    }

    protected void setMvaariwyensameyenkijyun2Value(BigDecimal value) {
        mvaariwyensameyenkijyun2Value = value;
        mvaariwyensameyenkijyun2 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenkijyun2Value()))
            .orNull();
    }

    transient private String mvaariwyensameyenkijyun2Type = null;

    @Column(name=MVAARIWYENSAMEYENKIJYUN2 + "$", nullable=true)
    protected String getMvaariwyensameyenkijyun2Type() {
        if (mvaariwyensameyenkijyun2Type == null && mvaariwyensameyenkijyun2 != null) return mvaariwyensameyenkijyun2.getType().toString();
        if (mvaariwyensameyenkijyun2Type == null && getMvaariwyensameyenkijyun2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyenkijyun2$' should not be NULL."));
        }
        return mvaariwyensameyenkijyun2Type;
    }

    protected void setMvaariwyensameyenkijyun2Type(String type) {
        mvaariwyensameyenkijyun2Type = type;
        mvaariwyensameyenkijyun2 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenkijyun2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyenyasu2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyenyasu2() {
        return mvaariwyensameyenyasu2;
    }

    public void setMvaariwyensameyenyasu2(BizCurrency pMvaariwyensameyenyasu2) {
        mvaariwyensameyenyasu2 = pMvaariwyensameyenyasu2;
        mvaariwyensameyenyasu2Value = null;
        mvaariwyensameyenyasu2Type  = null;
    }

    transient private BigDecimal mvaariwyensameyenyasu2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENYASU2, nullable=true)
    protected BigDecimal getMvaariwyensameyenyasu2Value() {
        if (mvaariwyensameyenyasu2Value == null && mvaariwyensameyenyasu2 != null) {
            if (mvaariwyensameyenyasu2.isOptional()) return null;
            return mvaariwyensameyenyasu2.absolute();
        }
        return mvaariwyensameyenyasu2Value;
    }

    protected void setMvaariwyensameyenyasu2Value(BigDecimal value) {
        mvaariwyensameyenyasu2Value = value;
        mvaariwyensameyenyasu2 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenyasu2Value()))
            .orNull();
    }

    transient private String mvaariwyensameyenyasu2Type = null;

    @Column(name=MVAARIWYENSAMEYENYASU2 + "$", nullable=true)
    protected String getMvaariwyensameyenyasu2Type() {
        if (mvaariwyensameyenyasu2Type == null && mvaariwyensameyenyasu2 != null) return mvaariwyensameyenyasu2.getType().toString();
        if (mvaariwyensameyenyasu2Type == null && getMvaariwyensameyenyasu2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyenyasu2$' should not be NULL."));
        }
        return mvaariwyensameyenyasu2Type;
    }

    protected void setMvaariwyensameyenyasu2Type(String type) {
        mvaariwyensameyenyasu2Type = type;
        mvaariwyensameyenyasu2 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenyasu2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyendaka2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyendaka2() {
        return mvaariwyendownyendaka2;
    }

    public void setMvaariwyendownyendaka2(BizCurrency pMvaariwyendownyendaka2) {
        mvaariwyendownyendaka2 = pMvaariwyendownyendaka2;
        mvaariwyendownyendaka2Value = null;
        mvaariwyendownyendaka2Type  = null;
    }

    transient private BigDecimal mvaariwyendownyendaka2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENDAKA2, nullable=true)
    protected BigDecimal getMvaariwyendownyendaka2Value() {
        if (mvaariwyendownyendaka2Value == null && mvaariwyendownyendaka2 != null) {
            if (mvaariwyendownyendaka2.isOptional()) return null;
            return mvaariwyendownyendaka2.absolute();
        }
        return mvaariwyendownyendaka2Value;
    }

    protected void setMvaariwyendownyendaka2Value(BigDecimal value) {
        mvaariwyendownyendaka2Value = value;
        mvaariwyendownyendaka2 = Optional.fromNullable(toCurrencyType(mvaariwyendownyendaka2Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyendaka2Value()))
            .orNull();
    }

    transient private String mvaariwyendownyendaka2Type = null;

    @Column(name=MVAARIWYENDOWNYENDAKA2 + "$", nullable=true)
    protected String getMvaariwyendownyendaka2Type() {
        if (mvaariwyendownyendaka2Type == null && mvaariwyendownyendaka2 != null) return mvaariwyendownyendaka2.getType().toString();
        if (mvaariwyendownyendaka2Type == null && getMvaariwyendownyendaka2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyendaka2$' should not be NULL."));
        }
        return mvaariwyendownyendaka2Type;
    }

    protected void setMvaariwyendownyendaka2Type(String type) {
        mvaariwyendownyendaka2Type = type;
        mvaariwyendownyendaka2 = Optional.fromNullable(toCurrencyType(mvaariwyendownyendaka2Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyendaka2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyenkijyun2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyenkijyun2() {
        return mvaariwyendownyenkijyun2;
    }

    public void setMvaariwyendownyenkijyun2(BizCurrency pMvaariwyendownyenkijyun2) {
        mvaariwyendownyenkijyun2 = pMvaariwyendownyenkijyun2;
        mvaariwyendownyenkijyun2Value = null;
        mvaariwyendownyenkijyun2Type  = null;
    }

    transient private BigDecimal mvaariwyendownyenkijyun2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENKIJYUN2, nullable=true)
    protected BigDecimal getMvaariwyendownyenkijyun2Value() {
        if (mvaariwyendownyenkijyun2Value == null && mvaariwyendownyenkijyun2 != null) {
            if (mvaariwyendownyenkijyun2.isOptional()) return null;
            return mvaariwyendownyenkijyun2.absolute();
        }
        return mvaariwyendownyenkijyun2Value;
    }

    protected void setMvaariwyendownyenkijyun2Value(BigDecimal value) {
        mvaariwyendownyenkijyun2Value = value;
        mvaariwyendownyenkijyun2 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenkijyun2Value()))
            .orNull();
    }

    transient private String mvaariwyendownyenkijyun2Type = null;

    @Column(name=MVAARIWYENDOWNYENKIJYUN2 + "$", nullable=true)
    protected String getMvaariwyendownyenkijyun2Type() {
        if (mvaariwyendownyenkijyun2Type == null && mvaariwyendownyenkijyun2 != null) return mvaariwyendownyenkijyun2.getType().toString();
        if (mvaariwyendownyenkijyun2Type == null && getMvaariwyendownyenkijyun2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyenkijyun2$' should not be NULL."));
        }
        return mvaariwyendownyenkijyun2Type;
    }

    protected void setMvaariwyendownyenkijyun2Type(String type) {
        mvaariwyendownyenkijyun2Type = type;
        mvaariwyendownyenkijyun2 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenkijyun2Value()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyenyasu2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyenyasu2() {
        return mvaariwyendownyenyasu2;
    }

    public void setMvaariwyendownyenyasu2(BizCurrency pMvaariwyendownyenyasu2) {
        mvaariwyendownyenyasu2 = pMvaariwyendownyenyasu2;
        mvaariwyendownyenyasu2Value = null;
        mvaariwyendownyenyasu2Type  = null;
    }

    transient private BigDecimal mvaariwyendownyenyasu2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENYASU2, nullable=true)
    protected BigDecimal getMvaariwyendownyenyasu2Value() {
        if (mvaariwyendownyenyasu2Value == null && mvaariwyendownyenyasu2 != null) {
            if (mvaariwyendownyenyasu2.isOptional()) return null;
            return mvaariwyendownyenyasu2.absolute();
        }
        return mvaariwyendownyenyasu2Value;
    }

    protected void setMvaariwyendownyenyasu2Value(BigDecimal value) {
        mvaariwyendownyenyasu2Value = value;
        mvaariwyendownyenyasu2 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenyasu2Value()))
            .orNull();
    }

    transient private String mvaariwyendownyenyasu2Type = null;

    @Column(name=MVAARIWYENDOWNYENYASU2 + "$", nullable=true)
    protected String getMvaariwyendownyenyasu2Type() {
        if (mvaariwyendownyenyasu2Type == null && mvaariwyendownyenyasu2 != null) return mvaariwyendownyenyasu2.getType().toString();
        if (mvaariwyendownyenyasu2Type == null && getMvaariwyendownyenyasu2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyenyasu2$' should not be NULL."));
        }
        return mvaariwyendownyenyasu2Type;
    }

    protected void setMvaariwyendownyenyasu2Type(String type) {
        mvaariwyendownyenyasu2Type = type;
        mvaariwyendownyenyasu2 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenyasu2Value()))
            .orNull();
    }

    private BizCurrency mvaariptumitatekin2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariptumitatekin2() {
        return mvaariptumitatekin2;
    }

    public void setMvaariptumitatekin2(BizCurrency pMvaariptumitatekin2) {
        mvaariptumitatekin2 = pMvaariptumitatekin2;
        mvaariptumitatekin2Value = null;
        mvaariptumitatekin2Type  = null;
    }

    transient private BigDecimal mvaariptumitatekin2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIPTUMITATEKIN2, nullable=true)
    protected BigDecimal getMvaariptumitatekin2Value() {
        if (mvaariptumitatekin2Value == null && mvaariptumitatekin2 != null) {
            if (mvaariptumitatekin2.isOptional()) return null;
            return mvaariptumitatekin2.absolute();
        }
        return mvaariptumitatekin2Value;
    }

    protected void setMvaariptumitatekin2Value(BigDecimal value) {
        mvaariptumitatekin2Value = value;
        mvaariptumitatekin2 = Optional.fromNullable(toCurrencyType(mvaariptumitatekin2Type))
            .transform(bizCurrencyTransformer(getMvaariptumitatekin2Value()))
            .orNull();
    }

    transient private String mvaariptumitatekin2Type = null;

    @Column(name=MVAARIPTUMITATEKIN2 + "$", nullable=true)
    protected String getMvaariptumitatekin2Type() {
        if (mvaariptumitatekin2Type == null && mvaariptumitatekin2 != null) return mvaariptumitatekin2.getType().toString();
        if (mvaariptumitatekin2Type == null && getMvaariptumitatekin2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariptumitatekin2$' should not be NULL."));
        }
        return mvaariptumitatekin2Type;
    }

    protected void setMvaariptumitatekin2Type(String type) {
        mvaariptumitatekin2Type = type;
        mvaariptumitatekin2 = Optional.fromNullable(toCurrencyType(mvaariptumitatekin2Type))
            .transform(bizCurrencyTransformer(getMvaariptumitatekin2Value()))
            .orNull();
    }

    private BizCurrency mvanonewsame2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewsame2() {
        return mvanonewsame2;
    }

    public void setMvanonewsame2(BizCurrency pMvanonewsame2) {
        mvanonewsame2 = pMvanonewsame2;
        mvanonewsame2Value = null;
        mvanonewsame2Type  = null;
    }

    transient private BigDecimal mvanonewsame2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWSAME2, nullable=true)
    protected BigDecimal getMvanonewsame2Value() {
        if (mvanonewsame2Value == null && mvanonewsame2 != null) {
            if (mvanonewsame2.isOptional()) return null;
            return mvanonewsame2.absolute();
        }
        return mvanonewsame2Value;
    }

    protected void setMvanonewsame2Value(BigDecimal value) {
        mvanonewsame2Value = value;
        mvanonewsame2 = Optional.fromNullable(toCurrencyType(mvanonewsame2Type))
            .transform(bizCurrencyTransformer(getMvanonewsame2Value()))
            .orNull();
    }

    transient private String mvanonewsame2Type = null;

    @Column(name=MVANONEWSAME2 + "$", nullable=true)
    protected String getMvanonewsame2Type() {
        if (mvanonewsame2Type == null && mvanonewsame2 != null) return mvanonewsame2.getType().toString();
        if (mvanonewsame2Type == null && getMvanonewsame2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewsame2$' should not be NULL."));
        }
        return mvanonewsame2Type;
    }

    protected void setMvanonewsame2Type(String type) {
        mvanonewsame2Type = type;
        mvanonewsame2 = Optional.fromNullable(toCurrencyType(mvanonewsame2Type))
            .transform(bizCurrencyTransformer(getMvanonewsame2Value()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyendaka2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyendaka2() {
        return mvanonewyensameyendaka2;
    }

    public void setMvanonewyensameyendaka2(BizCurrency pMvanonewyensameyendaka2) {
        mvanonewyensameyendaka2 = pMvanonewyensameyendaka2;
        mvanonewyensameyendaka2Value = null;
        mvanonewyensameyendaka2Type  = null;
    }

    transient private BigDecimal mvanonewyensameyendaka2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENDAKA2, nullable=true)
    protected BigDecimal getMvanonewyensameyendaka2Value() {
        if (mvanonewyensameyendaka2Value == null && mvanonewyensameyendaka2 != null) {
            if (mvanonewyensameyendaka2.isOptional()) return null;
            return mvanonewyensameyendaka2.absolute();
        }
        return mvanonewyensameyendaka2Value;
    }

    protected void setMvanonewyensameyendaka2Value(BigDecimal value) {
        mvanonewyensameyendaka2Value = value;
        mvanonewyensameyendaka2 = Optional.fromNullable(toCurrencyType(mvanonewyensameyendaka2Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyendaka2Value()))
            .orNull();
    }

    transient private String mvanonewyensameyendaka2Type = null;

    @Column(name=MVANONEWYENSAMEYENDAKA2 + "$", nullable=true)
    protected String getMvanonewyensameyendaka2Type() {
        if (mvanonewyensameyendaka2Type == null && mvanonewyensameyendaka2 != null) return mvanonewyensameyendaka2.getType().toString();
        if (mvanonewyensameyendaka2Type == null && getMvanonewyensameyendaka2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyendaka2$' should not be NULL."));
        }
        return mvanonewyensameyendaka2Type;
    }

    protected void setMvanonewyensameyendaka2Type(String type) {
        mvanonewyensameyendaka2Type = type;
        mvanonewyensameyendaka2 = Optional.fromNullable(toCurrencyType(mvanonewyensameyendaka2Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyendaka2Value()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyenkijyun2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyenkijyun2() {
        return mvanonewyensameyenkijyun2;
    }

    public void setMvanonewyensameyenkijyun2(BizCurrency pMvanonewyensameyenkijyun2) {
        mvanonewyensameyenkijyun2 = pMvanonewyensameyenkijyun2;
        mvanonewyensameyenkijyun2Value = null;
        mvanonewyensameyenkijyun2Type  = null;
    }

    transient private BigDecimal mvanonewyensameyenkijyun2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENKIJYUN2, nullable=true)
    protected BigDecimal getMvanonewyensameyenkijyun2Value() {
        if (mvanonewyensameyenkijyun2Value == null && mvanonewyensameyenkijyun2 != null) {
            if (mvanonewyensameyenkijyun2.isOptional()) return null;
            return mvanonewyensameyenkijyun2.absolute();
        }
        return mvanonewyensameyenkijyun2Value;
    }

    protected void setMvanonewyensameyenkijyun2Value(BigDecimal value) {
        mvanonewyensameyenkijyun2Value = value;
        mvanonewyensameyenkijyun2 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenkijyun2Value()))
            .orNull();
    }

    transient private String mvanonewyensameyenkijyun2Type = null;

    @Column(name=MVANONEWYENSAMEYENKIJYUN2 + "$", nullable=true)
    protected String getMvanonewyensameyenkijyun2Type() {
        if (mvanonewyensameyenkijyun2Type == null && mvanonewyensameyenkijyun2 != null) return mvanonewyensameyenkijyun2.getType().toString();
        if (mvanonewyensameyenkijyun2Type == null && getMvanonewyensameyenkijyun2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyenkijyun2$' should not be NULL."));
        }
        return mvanonewyensameyenkijyun2Type;
    }

    protected void setMvanonewyensameyenkijyun2Type(String type) {
        mvanonewyensameyenkijyun2Type = type;
        mvanonewyensameyenkijyun2 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenkijyun2Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenkijyun2Value()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyenyasu2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyenyasu2() {
        return mvanonewyensameyenyasu2;
    }

    public void setMvanonewyensameyenyasu2(BizCurrency pMvanonewyensameyenyasu2) {
        mvanonewyensameyenyasu2 = pMvanonewyensameyenyasu2;
        mvanonewyensameyenyasu2Value = null;
        mvanonewyensameyenyasu2Type  = null;
    }

    transient private BigDecimal mvanonewyensameyenyasu2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENYASU2, nullable=true)
    protected BigDecimal getMvanonewyensameyenyasu2Value() {
        if (mvanonewyensameyenyasu2Value == null && mvanonewyensameyenyasu2 != null) {
            if (mvanonewyensameyenyasu2.isOptional()) return null;
            return mvanonewyensameyenyasu2.absolute();
        }
        return mvanonewyensameyenyasu2Value;
    }

    protected void setMvanonewyensameyenyasu2Value(BigDecimal value) {
        mvanonewyensameyenyasu2Value = value;
        mvanonewyensameyenyasu2 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenyasu2Value()))
            .orNull();
    }

    transient private String mvanonewyensameyenyasu2Type = null;

    @Column(name=MVANONEWYENSAMEYENYASU2 + "$", nullable=true)
    protected String getMvanonewyensameyenyasu2Type() {
        if (mvanonewyensameyenyasu2Type == null && mvanonewyensameyenyasu2 != null) return mvanonewyensameyenyasu2.getType().toString();
        if (mvanonewyensameyenyasu2Type == null && getMvanonewyensameyenyasu2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyenyasu2$' should not be NULL."));
        }
        return mvanonewyensameyenyasu2Type;
    }

    protected void setMvanonewyensameyenyasu2Type(String type) {
        mvanonewyensameyenyasu2Type = type;
        mvanonewyensameyenyasu2 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenyasu2Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenyasu2Value()))
            .orNull();
    }

    private BizCurrency mvanoneptumitatekin2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanoneptumitatekin2() {
        return mvanoneptumitatekin2;
    }

    public void setMvanoneptumitatekin2(BizCurrency pMvanoneptumitatekin2) {
        mvanoneptumitatekin2 = pMvanoneptumitatekin2;
        mvanoneptumitatekin2Value = null;
        mvanoneptumitatekin2Type  = null;
    }

    transient private BigDecimal mvanoneptumitatekin2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEPTUMITATEKIN2, nullable=true)
    protected BigDecimal getMvanoneptumitatekin2Value() {
        if (mvanoneptumitatekin2Value == null && mvanoneptumitatekin2 != null) {
            if (mvanoneptumitatekin2.isOptional()) return null;
            return mvanoneptumitatekin2.absolute();
        }
        return mvanoneptumitatekin2Value;
    }

    protected void setMvanoneptumitatekin2Value(BigDecimal value) {
        mvanoneptumitatekin2Value = value;
        mvanoneptumitatekin2 = Optional.fromNullable(toCurrencyType(mvanoneptumitatekin2Type))
            .transform(bizCurrencyTransformer(getMvanoneptumitatekin2Value()))
            .orNull();
    }

    transient private String mvanoneptumitatekin2Type = null;

    @Column(name=MVANONEPTUMITATEKIN2 + "$", nullable=true)
    protected String getMvanoneptumitatekin2Type() {
        if (mvanoneptumitatekin2Type == null && mvanoneptumitatekin2 != null) return mvanoneptumitatekin2.getType().toString();
        if (mvanoneptumitatekin2Type == null && getMvanoneptumitatekin2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanoneptumitatekin2$' should not be NULL."));
        }
        return mvanoneptumitatekin2Type;
    }

    protected void setMvanoneptumitatekin2Type(String type) {
        mvanoneptumitatekin2Type = type;
        mvanoneptumitatekin2 = Optional.fromNullable(toCurrencyType(mvanoneptumitatekin2Type))
            .transform(bizCurrencyTransformer(getMvanoneptumitatekin2Value()))
            .orNull();
    }

    private BizNumber sjkkktusirrtup3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTUP3)
    public BizNumber getSjkkktusirrtup3() {
        return sjkkktusirrtup3;
    }

    public void setSjkkktusirrtup3(BizNumber pSjkkktusirrtup3) {
        sjkkktusirrtup3 = pSjkkktusirrtup3;
    }

    private BizNumber sjkkktusirrtsame3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTSAME3)
    public BizNumber getSjkkktusirrtsame3() {
        return sjkkktusirrtsame3;
    }

    public void setSjkkktusirrtsame3(BizNumber pSjkkktusirrtsame3) {
        sjkkktusirrtsame3 = pSjkkktusirrtsame3;
    }

    private BizNumber sjkkktusirrtdown3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTDOWN3)
    public BizNumber getSjkkktusirrtdown3() {
        return sjkkktusirrtdown3;
    }

    public void setSjkkktusirrtdown3(BizNumber pSjkkktusirrtdown3) {
        sjkkktusirrtdown3 = pSjkkktusirrtdown3;
    }

    private BizNumber sjkkktusirrthendouup3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTHENDOUUP3)
    public BizNumber getSjkkktusirrthendouup3() {
        return sjkkktusirrthendouup3;
    }

    public void setSjkkktusirrthendouup3(BizNumber pSjkkktusirrthendouup3) {
        sjkkktusirrthendouup3 = pSjkkktusirrthendouup3;
    }

    private BizNumber sjkkktusirrthendoudown3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SJKKKTUSIRRTHENDOUDOWN3)
    public BizNumber getSjkkktusirrthendoudown3() {
        return sjkkktusirrthendoudown3;
    }

    public void setSjkkktusirrthendoudown3(BizNumber pSjkkktusirrthendoudown3) {
        sjkkktusirrthendoudown3 = pSjkkktusirrthendoudown3;
    }

    private BizNumber yenknsnkwsrateyendaka3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENDAKA3)
    public BizNumber getYenknsnkwsrateyendaka3() {
        return yenknsnkwsrateyendaka3;
    }

    public void setYenknsnkwsrateyendaka3(BizNumber pYenknsnkwsrateyendaka3) {
        yenknsnkwsrateyendaka3 = pYenknsnkwsrateyendaka3;
    }

    private BizNumber yenknsnkwsrateyenkijyun3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENKIJYUN3)
    public BizNumber getYenknsnkwsrateyenkijyun3() {
        return yenknsnkwsrateyenkijyun3;
    }

    public void setYenknsnkwsrateyenkijyun3(BizNumber pYenknsnkwsrateyenkijyun3) {
        yenknsnkwsrateyenkijyun3 = pYenknsnkwsrateyenkijyun3;
    }

    private BizNumber yenknsnkwsrateyenyasu3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YENKNSNKWSRATEYENYASU3)
    public BizNumber getYenknsnkwsrateyenyasu3() {
        return yenknsnkwsrateyenyasu3;
    }

    public void setYenknsnkwsrateyenyasu3(BizNumber pYenknsnkwsrateyenyasu3) {
        yenknsnkwsrateyenyasu3 = pYenknsnkwsrateyenyasu3;
    }

    private BizCurrency yenknsnkwsrategkyendaka3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenknsnkwsrategkyendaka3() {
        return yenknsnkwsrategkyendaka3;
    }

    public void setYenknsnkwsrategkyendaka3(BizCurrency pYenknsnkwsrategkyendaka3) {
        yenknsnkwsrategkyendaka3 = pYenknsnkwsrategkyendaka3;
        yenknsnkwsrategkyendaka3Value = null;
        yenknsnkwsrategkyendaka3Type  = null;
    }

    transient private BigDecimal yenknsnkwsrategkyendaka3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKNSNKWSRATEGKYENDAKA3, nullable=true)
    protected BigDecimal getYenknsnkwsrategkyendaka3Value() {
        if (yenknsnkwsrategkyendaka3Value == null && yenknsnkwsrategkyendaka3 != null) {
            if (yenknsnkwsrategkyendaka3.isOptional()) return null;
            return yenknsnkwsrategkyendaka3.absolute();
        }
        return yenknsnkwsrategkyendaka3Value;
    }

    protected void setYenknsnkwsrategkyendaka3Value(BigDecimal value) {
        yenknsnkwsrategkyendaka3Value = value;
        yenknsnkwsrategkyendaka3 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyendaka3Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyendaka3Value()))
            .orNull();
    }

    transient private String yenknsnkwsrategkyendaka3Type = null;

    @Column(name=YENKNSNKWSRATEGKYENDAKA3 + "$", nullable=true)
    protected String getYenknsnkwsrategkyendaka3Type() {
        if (yenknsnkwsrategkyendaka3Type == null && yenknsnkwsrategkyendaka3 != null) return yenknsnkwsrategkyendaka3.getType().toString();
        if (yenknsnkwsrategkyendaka3Type == null && getYenknsnkwsrategkyendaka3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenknsnkwsrategkyendaka3$' should not be NULL."));
        }
        return yenknsnkwsrategkyendaka3Type;
    }

    protected void setYenknsnkwsrategkyendaka3Type(String type) {
        yenknsnkwsrategkyendaka3Type = type;
        yenknsnkwsrategkyendaka3 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyendaka3Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyendaka3Value()))
            .orNull();
    }

    private BizCurrency yenknsnkwsrategkyenyasu3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenknsnkwsrategkyenyasu3() {
        return yenknsnkwsrategkyenyasu3;
    }

    public void setYenknsnkwsrategkyenyasu3(BizCurrency pYenknsnkwsrategkyenyasu3) {
        yenknsnkwsrategkyenyasu3 = pYenknsnkwsrategkyenyasu3;
        yenknsnkwsrategkyenyasu3Value = null;
        yenknsnkwsrategkyenyasu3Type  = null;
    }

    transient private BigDecimal yenknsnkwsrategkyenyasu3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKNSNKWSRATEGKYENYASU3, nullable=true)
    protected BigDecimal getYenknsnkwsrategkyenyasu3Value() {
        if (yenknsnkwsrategkyenyasu3Value == null && yenknsnkwsrategkyenyasu3 != null) {
            if (yenknsnkwsrategkyenyasu3.isOptional()) return null;
            return yenknsnkwsrategkyenyasu3.absolute();
        }
        return yenknsnkwsrategkyenyasu3Value;
    }

    protected void setYenknsnkwsrategkyenyasu3Value(BigDecimal value) {
        yenknsnkwsrategkyenyasu3Value = value;
        yenknsnkwsrategkyenyasu3 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyenyasu3Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyenyasu3Value()))
            .orNull();
    }

    transient private String yenknsnkwsrategkyenyasu3Type = null;

    @Column(name=YENKNSNKWSRATEGKYENYASU3 + "$", nullable=true)
    protected String getYenknsnkwsrategkyenyasu3Type() {
        if (yenknsnkwsrategkyenyasu3Type == null && yenknsnkwsrategkyenyasu3 != null) return yenknsnkwsrategkyenyasu3.getType().toString();
        if (yenknsnkwsrategkyenyasu3Type == null && getYenknsnkwsrategkyenyasu3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenknsnkwsrategkyenyasu3$' should not be NULL."));
        }
        return yenknsnkwsrategkyenyasu3Type;
    }

    protected void setYenknsnkwsrategkyenyasu3Type(String type) {
        yenknsnkwsrategkyenyasu3Type = type;
        yenknsnkwsrategkyenyasu3 = Optional.fromNullable(toCurrencyType(yenknsnkwsrategkyenyasu3Type))
            .transform(bizCurrencyTransformer(getYenknsnkwsrategkyenyasu3Value()))
            .orNull();
    }

    private BizCurrency mvaariwup3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwup3() {
        return mvaariwup3;
    }

    public void setMvaariwup3(BizCurrency pMvaariwup3) {
        mvaariwup3 = pMvaariwup3;
        mvaariwup3Value = null;
        mvaariwup3Type  = null;
    }

    transient private BigDecimal mvaariwup3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWUP3, nullable=true)
    protected BigDecimal getMvaariwup3Value() {
        if (mvaariwup3Value == null && mvaariwup3 != null) {
            if (mvaariwup3.isOptional()) return null;
            return mvaariwup3.absolute();
        }
        return mvaariwup3Value;
    }

    protected void setMvaariwup3Value(BigDecimal value) {
        mvaariwup3Value = value;
        mvaariwup3 = Optional.fromNullable(toCurrencyType(mvaariwup3Type))
            .transform(bizCurrencyTransformer(getMvaariwup3Value()))
            .orNull();
    }

    transient private String mvaariwup3Type = null;

    @Column(name=MVAARIWUP3 + "$", nullable=true)
    protected String getMvaariwup3Type() {
        if (mvaariwup3Type == null && mvaariwup3 != null) return mvaariwup3.getType().toString();
        if (mvaariwup3Type == null && getMvaariwup3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwup3$' should not be NULL."));
        }
        return mvaariwup3Type;
    }

    protected void setMvaariwup3Type(String type) {
        mvaariwup3Type = type;
        mvaariwup3 = Optional.fromNullable(toCurrencyType(mvaariwup3Type))
            .transform(bizCurrencyTransformer(getMvaariwup3Value()))
            .orNull();
    }

    private BizCurrency mvaariwsame3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwsame3() {
        return mvaariwsame3;
    }

    public void setMvaariwsame3(BizCurrency pMvaariwsame3) {
        mvaariwsame3 = pMvaariwsame3;
        mvaariwsame3Value = null;
        mvaariwsame3Type  = null;
    }

    transient private BigDecimal mvaariwsame3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWSAME3, nullable=true)
    protected BigDecimal getMvaariwsame3Value() {
        if (mvaariwsame3Value == null && mvaariwsame3 != null) {
            if (mvaariwsame3.isOptional()) return null;
            return mvaariwsame3.absolute();
        }
        return mvaariwsame3Value;
    }

    protected void setMvaariwsame3Value(BigDecimal value) {
        mvaariwsame3Value = value;
        mvaariwsame3 = Optional.fromNullable(toCurrencyType(mvaariwsame3Type))
            .transform(bizCurrencyTransformer(getMvaariwsame3Value()))
            .orNull();
    }

    transient private String mvaariwsame3Type = null;

    @Column(name=MVAARIWSAME3 + "$", nullable=true)
    protected String getMvaariwsame3Type() {
        if (mvaariwsame3Type == null && mvaariwsame3 != null) return mvaariwsame3.getType().toString();
        if (mvaariwsame3Type == null && getMvaariwsame3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwsame3$' should not be NULL."));
        }
        return mvaariwsame3Type;
    }

    protected void setMvaariwsame3Type(String type) {
        mvaariwsame3Type = type;
        mvaariwsame3 = Optional.fromNullable(toCurrencyType(mvaariwsame3Type))
            .transform(bizCurrencyTransformer(getMvaariwsame3Value()))
            .orNull();
    }

    private BizCurrency mvaariwdown3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwdown3() {
        return mvaariwdown3;
    }

    public void setMvaariwdown3(BizCurrency pMvaariwdown3) {
        mvaariwdown3 = pMvaariwdown3;
        mvaariwdown3Value = null;
        mvaariwdown3Type  = null;
    }

    transient private BigDecimal mvaariwdown3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWDOWN3, nullable=true)
    protected BigDecimal getMvaariwdown3Value() {
        if (mvaariwdown3Value == null && mvaariwdown3 != null) {
            if (mvaariwdown3.isOptional()) return null;
            return mvaariwdown3.absolute();
        }
        return mvaariwdown3Value;
    }

    protected void setMvaariwdown3Value(BigDecimal value) {
        mvaariwdown3Value = value;
        mvaariwdown3 = Optional.fromNullable(toCurrencyType(mvaariwdown3Type))
            .transform(bizCurrencyTransformer(getMvaariwdown3Value()))
            .orNull();
    }

    transient private String mvaariwdown3Type = null;

    @Column(name=MVAARIWDOWN3 + "$", nullable=true)
    protected String getMvaariwdown3Type() {
        if (mvaariwdown3Type == null && mvaariwdown3 != null) return mvaariwdown3.getType().toString();
        if (mvaariwdown3Type == null && getMvaariwdown3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwdown3$' should not be NULL."));
        }
        return mvaariwdown3Type;
    }

    protected void setMvaariwdown3Type(String type) {
        mvaariwdown3Type = type;
        mvaariwdown3 = Optional.fromNullable(toCurrencyType(mvaariwdown3Type))
            .transform(bizCurrencyTransformer(getMvaariwdown3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyendaka3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyendaka3() {
        return mvaariwyenupyendaka3;
    }

    public void setMvaariwyenupyendaka3(BizCurrency pMvaariwyenupyendaka3) {
        mvaariwyenupyendaka3 = pMvaariwyenupyendaka3;
        mvaariwyenupyendaka3Value = null;
        mvaariwyenupyendaka3Type  = null;
    }

    transient private BigDecimal mvaariwyenupyendaka3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENDAKA3, nullable=true)
    protected BigDecimal getMvaariwyenupyendaka3Value() {
        if (mvaariwyenupyendaka3Value == null && mvaariwyenupyendaka3 != null) {
            if (mvaariwyenupyendaka3.isOptional()) return null;
            return mvaariwyenupyendaka3.absolute();
        }
        return mvaariwyenupyendaka3Value;
    }

    protected void setMvaariwyenupyendaka3Value(BigDecimal value) {
        mvaariwyenupyendaka3Value = value;
        mvaariwyenupyendaka3 = Optional.fromNullable(toCurrencyType(mvaariwyenupyendaka3Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyendaka3Value()))
            .orNull();
    }

    transient private String mvaariwyenupyendaka3Type = null;

    @Column(name=MVAARIWYENUPYENDAKA3 + "$", nullable=true)
    protected String getMvaariwyenupyendaka3Type() {
        if (mvaariwyenupyendaka3Type == null && mvaariwyenupyendaka3 != null) return mvaariwyenupyendaka3.getType().toString();
        if (mvaariwyenupyendaka3Type == null && getMvaariwyenupyendaka3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyendaka3$' should not be NULL."));
        }
        return mvaariwyenupyendaka3Type;
    }

    protected void setMvaariwyenupyendaka3Type(String type) {
        mvaariwyenupyendaka3Type = type;
        mvaariwyenupyendaka3 = Optional.fromNullable(toCurrencyType(mvaariwyenupyendaka3Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyendaka3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyenkijyun3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyenkijyun3() {
        return mvaariwyenupyenkijyun3;
    }

    public void setMvaariwyenupyenkijyun3(BizCurrency pMvaariwyenupyenkijyun3) {
        mvaariwyenupyenkijyun3 = pMvaariwyenupyenkijyun3;
        mvaariwyenupyenkijyun3Value = null;
        mvaariwyenupyenkijyun3Type  = null;
    }

    transient private BigDecimal mvaariwyenupyenkijyun3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENKIJYUN3, nullable=true)
    protected BigDecimal getMvaariwyenupyenkijyun3Value() {
        if (mvaariwyenupyenkijyun3Value == null && mvaariwyenupyenkijyun3 != null) {
            if (mvaariwyenupyenkijyun3.isOptional()) return null;
            return mvaariwyenupyenkijyun3.absolute();
        }
        return mvaariwyenupyenkijyun3Value;
    }

    protected void setMvaariwyenupyenkijyun3Value(BigDecimal value) {
        mvaariwyenupyenkijyun3Value = value;
        mvaariwyenupyenkijyun3 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenkijyun3Value()))
            .orNull();
    }

    transient private String mvaariwyenupyenkijyun3Type = null;

    @Column(name=MVAARIWYENUPYENKIJYUN3 + "$", nullable=true)
    protected String getMvaariwyenupyenkijyun3Type() {
        if (mvaariwyenupyenkijyun3Type == null && mvaariwyenupyenkijyun3 != null) return mvaariwyenupyenkijyun3.getType().toString();
        if (mvaariwyenupyenkijyun3Type == null && getMvaariwyenupyenkijyun3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyenkijyun3$' should not be NULL."));
        }
        return mvaariwyenupyenkijyun3Type;
    }

    protected void setMvaariwyenupyenkijyun3Type(String type) {
        mvaariwyenupyenkijyun3Type = type;
        mvaariwyenupyenkijyun3 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenkijyun3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyenupyenyasu3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyenupyenyasu3() {
        return mvaariwyenupyenyasu3;
    }

    public void setMvaariwyenupyenyasu3(BizCurrency pMvaariwyenupyenyasu3) {
        mvaariwyenupyenyasu3 = pMvaariwyenupyenyasu3;
        mvaariwyenupyenyasu3Value = null;
        mvaariwyenupyenyasu3Type  = null;
    }

    transient private BigDecimal mvaariwyenupyenyasu3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENUPYENYASU3, nullable=true)
    protected BigDecimal getMvaariwyenupyenyasu3Value() {
        if (mvaariwyenupyenyasu3Value == null && mvaariwyenupyenyasu3 != null) {
            if (mvaariwyenupyenyasu3.isOptional()) return null;
            return mvaariwyenupyenyasu3.absolute();
        }
        return mvaariwyenupyenyasu3Value;
    }

    protected void setMvaariwyenupyenyasu3Value(BigDecimal value) {
        mvaariwyenupyenyasu3Value = value;
        mvaariwyenupyenyasu3 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenyasu3Value()))
            .orNull();
    }

    transient private String mvaariwyenupyenyasu3Type = null;

    @Column(name=MVAARIWYENUPYENYASU3 + "$", nullable=true)
    protected String getMvaariwyenupyenyasu3Type() {
        if (mvaariwyenupyenyasu3Type == null && mvaariwyenupyenyasu3 != null) return mvaariwyenupyenyasu3.getType().toString();
        if (mvaariwyenupyenyasu3Type == null && getMvaariwyenupyenyasu3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyenupyenyasu3$' should not be NULL."));
        }
        return mvaariwyenupyenyasu3Type;
    }

    protected void setMvaariwyenupyenyasu3Type(String type) {
        mvaariwyenupyenyasu3Type = type;
        mvaariwyenupyenyasu3 = Optional.fromNullable(toCurrencyType(mvaariwyenupyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvaariwyenupyenyasu3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyendaka3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyendaka3() {
        return mvaariwyensameyendaka3;
    }

    public void setMvaariwyensameyendaka3(BizCurrency pMvaariwyensameyendaka3) {
        mvaariwyensameyendaka3 = pMvaariwyensameyendaka3;
        mvaariwyensameyendaka3Value = null;
        mvaariwyensameyendaka3Type  = null;
    }

    transient private BigDecimal mvaariwyensameyendaka3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENDAKA3, nullable=true)
    protected BigDecimal getMvaariwyensameyendaka3Value() {
        if (mvaariwyensameyendaka3Value == null && mvaariwyensameyendaka3 != null) {
            if (mvaariwyensameyendaka3.isOptional()) return null;
            return mvaariwyensameyendaka3.absolute();
        }
        return mvaariwyensameyendaka3Value;
    }

    protected void setMvaariwyensameyendaka3Value(BigDecimal value) {
        mvaariwyensameyendaka3Value = value;
        mvaariwyensameyendaka3 = Optional.fromNullable(toCurrencyType(mvaariwyensameyendaka3Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyendaka3Value()))
            .orNull();
    }

    transient private String mvaariwyensameyendaka3Type = null;

    @Column(name=MVAARIWYENSAMEYENDAKA3 + "$", nullable=true)
    protected String getMvaariwyensameyendaka3Type() {
        if (mvaariwyensameyendaka3Type == null && mvaariwyensameyendaka3 != null) return mvaariwyensameyendaka3.getType().toString();
        if (mvaariwyensameyendaka3Type == null && getMvaariwyensameyendaka3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyendaka3$' should not be NULL."));
        }
        return mvaariwyensameyendaka3Type;
    }

    protected void setMvaariwyensameyendaka3Type(String type) {
        mvaariwyensameyendaka3Type = type;
        mvaariwyensameyendaka3 = Optional.fromNullable(toCurrencyType(mvaariwyensameyendaka3Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyendaka3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyenkijyun3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyenkijyun3() {
        return mvaariwyensameyenkijyun3;
    }

    public void setMvaariwyensameyenkijyun3(BizCurrency pMvaariwyensameyenkijyun3) {
        mvaariwyensameyenkijyun3 = pMvaariwyensameyenkijyun3;
        mvaariwyensameyenkijyun3Value = null;
        mvaariwyensameyenkijyun3Type  = null;
    }

    transient private BigDecimal mvaariwyensameyenkijyun3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENKIJYUN3, nullable=true)
    protected BigDecimal getMvaariwyensameyenkijyun3Value() {
        if (mvaariwyensameyenkijyun3Value == null && mvaariwyensameyenkijyun3 != null) {
            if (mvaariwyensameyenkijyun3.isOptional()) return null;
            return mvaariwyensameyenkijyun3.absolute();
        }
        return mvaariwyensameyenkijyun3Value;
    }

    protected void setMvaariwyensameyenkijyun3Value(BigDecimal value) {
        mvaariwyensameyenkijyun3Value = value;
        mvaariwyensameyenkijyun3 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenkijyun3Value()))
            .orNull();
    }

    transient private String mvaariwyensameyenkijyun3Type = null;

    @Column(name=MVAARIWYENSAMEYENKIJYUN3 + "$", nullable=true)
    protected String getMvaariwyensameyenkijyun3Type() {
        if (mvaariwyensameyenkijyun3Type == null && mvaariwyensameyenkijyun3 != null) return mvaariwyensameyenkijyun3.getType().toString();
        if (mvaariwyensameyenkijyun3Type == null && getMvaariwyensameyenkijyun3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyenkijyun3$' should not be NULL."));
        }
        return mvaariwyensameyenkijyun3Type;
    }

    protected void setMvaariwyensameyenkijyun3Type(String type) {
        mvaariwyensameyenkijyun3Type = type;
        mvaariwyensameyenkijyun3 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenkijyun3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyensameyenyasu3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyensameyenyasu3() {
        return mvaariwyensameyenyasu3;
    }

    public void setMvaariwyensameyenyasu3(BizCurrency pMvaariwyensameyenyasu3) {
        mvaariwyensameyenyasu3 = pMvaariwyensameyenyasu3;
        mvaariwyensameyenyasu3Value = null;
        mvaariwyensameyenyasu3Type  = null;
    }

    transient private BigDecimal mvaariwyensameyenyasu3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENSAMEYENYASU3, nullable=true)
    protected BigDecimal getMvaariwyensameyenyasu3Value() {
        if (mvaariwyensameyenyasu3Value == null && mvaariwyensameyenyasu3 != null) {
            if (mvaariwyensameyenyasu3.isOptional()) return null;
            return mvaariwyensameyenyasu3.absolute();
        }
        return mvaariwyensameyenyasu3Value;
    }

    protected void setMvaariwyensameyenyasu3Value(BigDecimal value) {
        mvaariwyensameyenyasu3Value = value;
        mvaariwyensameyenyasu3 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenyasu3Value()))
            .orNull();
    }

    transient private String mvaariwyensameyenyasu3Type = null;

    @Column(name=MVAARIWYENSAMEYENYASU3 + "$", nullable=true)
    protected String getMvaariwyensameyenyasu3Type() {
        if (mvaariwyensameyenyasu3Type == null && mvaariwyensameyenyasu3 != null) return mvaariwyensameyenyasu3.getType().toString();
        if (mvaariwyensameyenyasu3Type == null && getMvaariwyensameyenyasu3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyensameyenyasu3$' should not be NULL."));
        }
        return mvaariwyensameyenyasu3Type;
    }

    protected void setMvaariwyensameyenyasu3Type(String type) {
        mvaariwyensameyenyasu3Type = type;
        mvaariwyensameyenyasu3 = Optional.fromNullable(toCurrencyType(mvaariwyensameyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvaariwyensameyenyasu3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyendaka3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyendaka3() {
        return mvaariwyendownyendaka3;
    }

    public void setMvaariwyendownyendaka3(BizCurrency pMvaariwyendownyendaka3) {
        mvaariwyendownyendaka3 = pMvaariwyendownyendaka3;
        mvaariwyendownyendaka3Value = null;
        mvaariwyendownyendaka3Type  = null;
    }

    transient private BigDecimal mvaariwyendownyendaka3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENDAKA3, nullable=true)
    protected BigDecimal getMvaariwyendownyendaka3Value() {
        if (mvaariwyendownyendaka3Value == null && mvaariwyendownyendaka3 != null) {
            if (mvaariwyendownyendaka3.isOptional()) return null;
            return mvaariwyendownyendaka3.absolute();
        }
        return mvaariwyendownyendaka3Value;
    }

    protected void setMvaariwyendownyendaka3Value(BigDecimal value) {
        mvaariwyendownyendaka3Value = value;
        mvaariwyendownyendaka3 = Optional.fromNullable(toCurrencyType(mvaariwyendownyendaka3Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyendaka3Value()))
            .orNull();
    }

    transient private String mvaariwyendownyendaka3Type = null;

    @Column(name=MVAARIWYENDOWNYENDAKA3 + "$", nullable=true)
    protected String getMvaariwyendownyendaka3Type() {
        if (mvaariwyendownyendaka3Type == null && mvaariwyendownyendaka3 != null) return mvaariwyendownyendaka3.getType().toString();
        if (mvaariwyendownyendaka3Type == null && getMvaariwyendownyendaka3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyendaka3$' should not be NULL."));
        }
        return mvaariwyendownyendaka3Type;
    }

    protected void setMvaariwyendownyendaka3Type(String type) {
        mvaariwyendownyendaka3Type = type;
        mvaariwyendownyendaka3 = Optional.fromNullable(toCurrencyType(mvaariwyendownyendaka3Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyendaka3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyenkijyun3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyenkijyun3() {
        return mvaariwyendownyenkijyun3;
    }

    public void setMvaariwyendownyenkijyun3(BizCurrency pMvaariwyendownyenkijyun3) {
        mvaariwyendownyenkijyun3 = pMvaariwyendownyenkijyun3;
        mvaariwyendownyenkijyun3Value = null;
        mvaariwyendownyenkijyun3Type  = null;
    }

    transient private BigDecimal mvaariwyendownyenkijyun3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENKIJYUN3, nullable=true)
    protected BigDecimal getMvaariwyendownyenkijyun3Value() {
        if (mvaariwyendownyenkijyun3Value == null && mvaariwyendownyenkijyun3 != null) {
            if (mvaariwyendownyenkijyun3.isOptional()) return null;
            return mvaariwyendownyenkijyun3.absolute();
        }
        return mvaariwyendownyenkijyun3Value;
    }

    protected void setMvaariwyendownyenkijyun3Value(BigDecimal value) {
        mvaariwyendownyenkijyun3Value = value;
        mvaariwyendownyenkijyun3 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenkijyun3Value()))
            .orNull();
    }

    transient private String mvaariwyendownyenkijyun3Type = null;

    @Column(name=MVAARIWYENDOWNYENKIJYUN3 + "$", nullable=true)
    protected String getMvaariwyendownyenkijyun3Type() {
        if (mvaariwyendownyenkijyun3Type == null && mvaariwyendownyenkijyun3 != null) return mvaariwyendownyenkijyun3.getType().toString();
        if (mvaariwyendownyenkijyun3Type == null && getMvaariwyendownyenkijyun3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyenkijyun3$' should not be NULL."));
        }
        return mvaariwyendownyenkijyun3Type;
    }

    protected void setMvaariwyendownyenkijyun3Type(String type) {
        mvaariwyendownyenkijyun3Type = type;
        mvaariwyendownyenkijyun3 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenkijyun3Value()))
            .orNull();
    }

    private BizCurrency mvaariwyendownyenyasu3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariwyendownyenyasu3() {
        return mvaariwyendownyenyasu3;
    }

    public void setMvaariwyendownyenyasu3(BizCurrency pMvaariwyendownyenyasu3) {
        mvaariwyendownyenyasu3 = pMvaariwyendownyenyasu3;
        mvaariwyendownyenyasu3Value = null;
        mvaariwyendownyenyasu3Type  = null;
    }

    transient private BigDecimal mvaariwyendownyenyasu3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIWYENDOWNYENYASU3, nullable=true)
    protected BigDecimal getMvaariwyendownyenyasu3Value() {
        if (mvaariwyendownyenyasu3Value == null && mvaariwyendownyenyasu3 != null) {
            if (mvaariwyendownyenyasu3.isOptional()) return null;
            return mvaariwyendownyenyasu3.absolute();
        }
        return mvaariwyendownyenyasu3Value;
    }

    protected void setMvaariwyendownyenyasu3Value(BigDecimal value) {
        mvaariwyendownyenyasu3Value = value;
        mvaariwyendownyenyasu3 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenyasu3Value()))
            .orNull();
    }

    transient private String mvaariwyendownyenyasu3Type = null;

    @Column(name=MVAARIWYENDOWNYENYASU3 + "$", nullable=true)
    protected String getMvaariwyendownyenyasu3Type() {
        if (mvaariwyendownyenyasu3Type == null && mvaariwyendownyenyasu3 != null) return mvaariwyendownyenyasu3.getType().toString();
        if (mvaariwyendownyenyasu3Type == null && getMvaariwyendownyenyasu3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariwyendownyenyasu3$' should not be NULL."));
        }
        return mvaariwyendownyenyasu3Type;
    }

    protected void setMvaariwyendownyenyasu3Type(String type) {
        mvaariwyendownyenyasu3Type = type;
        mvaariwyendownyenyasu3 = Optional.fromNullable(toCurrencyType(mvaariwyendownyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvaariwyendownyenyasu3Value()))
            .orNull();
    }

    private BizCurrency mvaariptumitatekin3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaariptumitatekin3() {
        return mvaariptumitatekin3;
    }

    public void setMvaariptumitatekin3(BizCurrency pMvaariptumitatekin3) {
        mvaariptumitatekin3 = pMvaariptumitatekin3;
        mvaariptumitatekin3Value = null;
        mvaariptumitatekin3Type  = null;
    }

    transient private BigDecimal mvaariptumitatekin3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARIPTUMITATEKIN3, nullable=true)
    protected BigDecimal getMvaariptumitatekin3Value() {
        if (mvaariptumitatekin3Value == null && mvaariptumitatekin3 != null) {
            if (mvaariptumitatekin3.isOptional()) return null;
            return mvaariptumitatekin3.absolute();
        }
        return mvaariptumitatekin3Value;
    }

    protected void setMvaariptumitatekin3Value(BigDecimal value) {
        mvaariptumitatekin3Value = value;
        mvaariptumitatekin3 = Optional.fromNullable(toCurrencyType(mvaariptumitatekin3Type))
            .transform(bizCurrencyTransformer(getMvaariptumitatekin3Value()))
            .orNull();
    }

    transient private String mvaariptumitatekin3Type = null;

    @Column(name=MVAARIPTUMITATEKIN3 + "$", nullable=true)
    protected String getMvaariptumitatekin3Type() {
        if (mvaariptumitatekin3Type == null && mvaariptumitatekin3 != null) return mvaariptumitatekin3.getType().toString();
        if (mvaariptumitatekin3Type == null && getMvaariptumitatekin3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaariptumitatekin3$' should not be NULL."));
        }
        return mvaariptumitatekin3Type;
    }

    protected void setMvaariptumitatekin3Type(String type) {
        mvaariptumitatekin3Type = type;
        mvaariptumitatekin3 = Optional.fromNullable(toCurrencyType(mvaariptumitatekin3Type))
            .transform(bizCurrencyTransformer(getMvaariptumitatekin3Value()))
            .orNull();
    }

    private BizCurrency mvanonewsame3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewsame3() {
        return mvanonewsame3;
    }

    public void setMvanonewsame3(BizCurrency pMvanonewsame3) {
        mvanonewsame3 = pMvanonewsame3;
        mvanonewsame3Value = null;
        mvanonewsame3Type  = null;
    }

    transient private BigDecimal mvanonewsame3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWSAME3, nullable=true)
    protected BigDecimal getMvanonewsame3Value() {
        if (mvanonewsame3Value == null && mvanonewsame3 != null) {
            if (mvanonewsame3.isOptional()) return null;
            return mvanonewsame3.absolute();
        }
        return mvanonewsame3Value;
    }

    protected void setMvanonewsame3Value(BigDecimal value) {
        mvanonewsame3Value = value;
        mvanonewsame3 = Optional.fromNullable(toCurrencyType(mvanonewsame3Type))
            .transform(bizCurrencyTransformer(getMvanonewsame3Value()))
            .orNull();
    }

    transient private String mvanonewsame3Type = null;

    @Column(name=MVANONEWSAME3 + "$", nullable=true)
    protected String getMvanonewsame3Type() {
        if (mvanonewsame3Type == null && mvanonewsame3 != null) return mvanonewsame3.getType().toString();
        if (mvanonewsame3Type == null && getMvanonewsame3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewsame3$' should not be NULL."));
        }
        return mvanonewsame3Type;
    }

    protected void setMvanonewsame3Type(String type) {
        mvanonewsame3Type = type;
        mvanonewsame3 = Optional.fromNullable(toCurrencyType(mvanonewsame3Type))
            .transform(bizCurrencyTransformer(getMvanonewsame3Value()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyendaka3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyendaka3() {
        return mvanonewyensameyendaka3;
    }

    public void setMvanonewyensameyendaka3(BizCurrency pMvanonewyensameyendaka3) {
        mvanonewyensameyendaka3 = pMvanonewyensameyendaka3;
        mvanonewyensameyendaka3Value = null;
        mvanonewyensameyendaka3Type  = null;
    }

    transient private BigDecimal mvanonewyensameyendaka3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENDAKA3, nullable=true)
    protected BigDecimal getMvanonewyensameyendaka3Value() {
        if (mvanonewyensameyendaka3Value == null && mvanonewyensameyendaka3 != null) {
            if (mvanonewyensameyendaka3.isOptional()) return null;
            return mvanonewyensameyendaka3.absolute();
        }
        return mvanonewyensameyendaka3Value;
    }

    protected void setMvanonewyensameyendaka3Value(BigDecimal value) {
        mvanonewyensameyendaka3Value = value;
        mvanonewyensameyendaka3 = Optional.fromNullable(toCurrencyType(mvanonewyensameyendaka3Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyendaka3Value()))
            .orNull();
    }

    transient private String mvanonewyensameyendaka3Type = null;

    @Column(name=MVANONEWYENSAMEYENDAKA3 + "$", nullable=true)
    protected String getMvanonewyensameyendaka3Type() {
        if (mvanonewyensameyendaka3Type == null && mvanonewyensameyendaka3 != null) return mvanonewyensameyendaka3.getType().toString();
        if (mvanonewyensameyendaka3Type == null && getMvanonewyensameyendaka3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyendaka3$' should not be NULL."));
        }
        return mvanonewyensameyendaka3Type;
    }

    protected void setMvanonewyensameyendaka3Type(String type) {
        mvanonewyensameyendaka3Type = type;
        mvanonewyensameyendaka3 = Optional.fromNullable(toCurrencyType(mvanonewyensameyendaka3Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyendaka3Value()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyenkijyun3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyenkijyun3() {
        return mvanonewyensameyenkijyun3;
    }

    public void setMvanonewyensameyenkijyun3(BizCurrency pMvanonewyensameyenkijyun3) {
        mvanonewyensameyenkijyun3 = pMvanonewyensameyenkijyun3;
        mvanonewyensameyenkijyun3Value = null;
        mvanonewyensameyenkijyun3Type  = null;
    }

    transient private BigDecimal mvanonewyensameyenkijyun3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENKIJYUN3, nullable=true)
    protected BigDecimal getMvanonewyensameyenkijyun3Value() {
        if (mvanonewyensameyenkijyun3Value == null && mvanonewyensameyenkijyun3 != null) {
            if (mvanonewyensameyenkijyun3.isOptional()) return null;
            return mvanonewyensameyenkijyun3.absolute();
        }
        return mvanonewyensameyenkijyun3Value;
    }

    protected void setMvanonewyensameyenkijyun3Value(BigDecimal value) {
        mvanonewyensameyenkijyun3Value = value;
        mvanonewyensameyenkijyun3 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenkijyun3Value()))
            .orNull();
    }

    transient private String mvanonewyensameyenkijyun3Type = null;

    @Column(name=MVANONEWYENSAMEYENKIJYUN3 + "$", nullable=true)
    protected String getMvanonewyensameyenkijyun3Type() {
        if (mvanonewyensameyenkijyun3Type == null && mvanonewyensameyenkijyun3 != null) return mvanonewyensameyenkijyun3.getType().toString();
        if (mvanonewyensameyenkijyun3Type == null && getMvanonewyensameyenkijyun3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyenkijyun3$' should not be NULL."));
        }
        return mvanonewyensameyenkijyun3Type;
    }

    protected void setMvanonewyensameyenkijyun3Type(String type) {
        mvanonewyensameyenkijyun3Type = type;
        mvanonewyensameyenkijyun3 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenkijyun3Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenkijyun3Value()))
            .orNull();
    }

    private BizCurrency mvanonewyensameyenyasu3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanonewyensameyenyasu3() {
        return mvanonewyensameyenyasu3;
    }

    public void setMvanonewyensameyenyasu3(BizCurrency pMvanonewyensameyenyasu3) {
        mvanonewyensameyenyasu3 = pMvanonewyensameyenyasu3;
        mvanonewyensameyenyasu3Value = null;
        mvanonewyensameyenyasu3Type  = null;
    }

    transient private BigDecimal mvanonewyensameyenyasu3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEWYENSAMEYENYASU3, nullable=true)
    protected BigDecimal getMvanonewyensameyenyasu3Value() {
        if (mvanonewyensameyenyasu3Value == null && mvanonewyensameyenyasu3 != null) {
            if (mvanonewyensameyenyasu3.isOptional()) return null;
            return mvanonewyensameyenyasu3.absolute();
        }
        return mvanonewyensameyenyasu3Value;
    }

    protected void setMvanonewyensameyenyasu3Value(BigDecimal value) {
        mvanonewyensameyenyasu3Value = value;
        mvanonewyensameyenyasu3 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenyasu3Value()))
            .orNull();
    }

    transient private String mvanonewyensameyenyasu3Type = null;

    @Column(name=MVANONEWYENSAMEYENYASU3 + "$", nullable=true)
    protected String getMvanonewyensameyenyasu3Type() {
        if (mvanonewyensameyenyasu3Type == null && mvanonewyensameyenyasu3 != null) return mvanonewyensameyenyasu3.getType().toString();
        if (mvanonewyensameyenyasu3Type == null && getMvanonewyensameyenyasu3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanonewyensameyenyasu3$' should not be NULL."));
        }
        return mvanonewyensameyenyasu3Type;
    }

    protected void setMvanonewyensameyenyasu3Type(String type) {
        mvanonewyensameyenyasu3Type = type;
        mvanonewyensameyenyasu3 = Optional.fromNullable(toCurrencyType(mvanonewyensameyenyasu3Type))
            .transform(bizCurrencyTransformer(getMvanonewyensameyenyasu3Value()))
            .orNull();
    }

    private BizCurrency mvanoneptumitatekin3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvanoneptumitatekin3() {
        return mvanoneptumitatekin3;
    }

    public void setMvanoneptumitatekin3(BizCurrency pMvanoneptumitatekin3) {
        mvanoneptumitatekin3 = pMvanoneptumitatekin3;
        mvanoneptumitatekin3Value = null;
        mvanoneptumitatekin3Type  = null;
    }

    transient private BigDecimal mvanoneptumitatekin3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVANONEPTUMITATEKIN3, nullable=true)
    protected BigDecimal getMvanoneptumitatekin3Value() {
        if (mvanoneptumitatekin3Value == null && mvanoneptumitatekin3 != null) {
            if (mvanoneptumitatekin3.isOptional()) return null;
            return mvanoneptumitatekin3.absolute();
        }
        return mvanoneptumitatekin3Value;
    }

    protected void setMvanoneptumitatekin3Value(BigDecimal value) {
        mvanoneptumitatekin3Value = value;
        mvanoneptumitatekin3 = Optional.fromNullable(toCurrencyType(mvanoneptumitatekin3Type))
            .transform(bizCurrencyTransformer(getMvanoneptumitatekin3Value()))
            .orNull();
    }

    transient private String mvanoneptumitatekin3Type = null;

    @Column(name=MVANONEPTUMITATEKIN3 + "$", nullable=true)
    protected String getMvanoneptumitatekin3Type() {
        if (mvanoneptumitatekin3Type == null && mvanoneptumitatekin3 != null) return mvanoneptumitatekin3.getType().toString();
        if (mvanoneptumitatekin3Type == null && getMvanoneptumitatekin3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvanoneptumitatekin3$' should not be NULL."));
        }
        return mvanoneptumitatekin3Type;
    }

    protected void setMvanoneptumitatekin3Type(String type) {
        mvanoneptumitatekin3Type = type;
        mvanoneptumitatekin3 = Optional.fromNullable(toCurrencyType(mvanoneptumitatekin3Type))
            .transform(bizCurrencyTransformer(getMvanoneptumitatekin3Value()))
            .orNull();
    }

    private BizCurrency tutmttknutiwake11;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutmttknutiwake11() {
        return tutmttknutiwake11;
    }

    public void setTutmttknutiwake11(BizCurrency pTutmttknutiwake11) {
        tutmttknutiwake11 = pTutmttknutiwake11;
        tutmttknutiwake11Value = null;
        tutmttknutiwake11Type  = null;
    }

    transient private BigDecimal tutmttknutiwake11Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTMTTKNUTIWAKE11, nullable=true)
    protected BigDecimal getTutmttknutiwake11Value() {
        if (tutmttknutiwake11Value == null && tutmttknutiwake11 != null) {
            if (tutmttknutiwake11.isOptional()) return null;
            return tutmttknutiwake11.absolute();
        }
        return tutmttknutiwake11Value;
    }

    protected void setTutmttknutiwake11Value(BigDecimal value) {
        tutmttknutiwake11Value = value;
        tutmttknutiwake11 = Optional.fromNullable(toCurrencyType(tutmttknutiwake11Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake11Value()))
            .orNull();
    }

    transient private String tutmttknutiwake11Type = null;

    @Column(name=TUTMTTKNUTIWAKE11 + "$", nullable=true)
    protected String getTutmttknutiwake11Type() {
        if (tutmttknutiwake11Type == null && tutmttknutiwake11 != null) return tutmttknutiwake11.getType().toString();
        if (tutmttknutiwake11Type == null && getTutmttknutiwake11Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutmttknutiwake11$' should not be NULL."));
        }
        return tutmttknutiwake11Type;
    }

    protected void setTutmttknutiwake11Type(String type) {
        tutmttknutiwake11Type = type;
        tutmttknutiwake11 = Optional.fromNullable(toCurrencyType(tutmttknutiwake11Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake11Value()))
            .orNull();
    }

    private BizCurrency tutmttknutiwake21;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutmttknutiwake21() {
        return tutmttknutiwake21;
    }

    public void setTutmttknutiwake21(BizCurrency pTutmttknutiwake21) {
        tutmttknutiwake21 = pTutmttknutiwake21;
        tutmttknutiwake21Value = null;
        tutmttknutiwake21Type  = null;
    }

    transient private BigDecimal tutmttknutiwake21Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTMTTKNUTIWAKE21, nullable=true)
    protected BigDecimal getTutmttknutiwake21Value() {
        if (tutmttknutiwake21Value == null && tutmttknutiwake21 != null) {
            if (tutmttknutiwake21.isOptional()) return null;
            return tutmttknutiwake21.absolute();
        }
        return tutmttknutiwake21Value;
    }

    protected void setTutmttknutiwake21Value(BigDecimal value) {
        tutmttknutiwake21Value = value;
        tutmttknutiwake21 = Optional.fromNullable(toCurrencyType(tutmttknutiwake21Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake21Value()))
            .orNull();
    }

    transient private String tutmttknutiwake21Type = null;

    @Column(name=TUTMTTKNUTIWAKE21 + "$", nullable=true)
    protected String getTutmttknutiwake21Type() {
        if (tutmttknutiwake21Type == null && tutmttknutiwake21 != null) return tutmttknutiwake21.getType().toString();
        if (tutmttknutiwake21Type == null && getTutmttknutiwake21Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutmttknutiwake21$' should not be NULL."));
        }
        return tutmttknutiwake21Type;
    }

    protected void setTutmttknutiwake21Type(String type) {
        tutmttknutiwake21Type = type;
        tutmttknutiwake21 = Optional.fromNullable(toCurrencyType(tutmttknutiwake21Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake21Value()))
            .orNull();
    }

    private BizCurrency tutmttknutiwake12;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutmttknutiwake12() {
        return tutmttknutiwake12;
    }

    public void setTutmttknutiwake12(BizCurrency pTutmttknutiwake12) {
        tutmttknutiwake12 = pTutmttknutiwake12;
        tutmttknutiwake12Value = null;
        tutmttknutiwake12Type  = null;
    }

    transient private BigDecimal tutmttknutiwake12Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTMTTKNUTIWAKE12, nullable=true)
    protected BigDecimal getTutmttknutiwake12Value() {
        if (tutmttknutiwake12Value == null && tutmttknutiwake12 != null) {
            if (tutmttknutiwake12.isOptional()) return null;
            return tutmttknutiwake12.absolute();
        }
        return tutmttknutiwake12Value;
    }

    protected void setTutmttknutiwake12Value(BigDecimal value) {
        tutmttknutiwake12Value = value;
        tutmttknutiwake12 = Optional.fromNullable(toCurrencyType(tutmttknutiwake12Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake12Value()))
            .orNull();
    }

    transient private String tutmttknutiwake12Type = null;

    @Column(name=TUTMTTKNUTIWAKE12 + "$", nullable=true)
    protected String getTutmttknutiwake12Type() {
        if (tutmttknutiwake12Type == null && tutmttknutiwake12 != null) return tutmttknutiwake12.getType().toString();
        if (tutmttknutiwake12Type == null && getTutmttknutiwake12Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutmttknutiwake12$' should not be NULL."));
        }
        return tutmttknutiwake12Type;
    }

    protected void setTutmttknutiwake12Type(String type) {
        tutmttknutiwake12Type = type;
        tutmttknutiwake12 = Optional.fromNullable(toCurrencyType(tutmttknutiwake12Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake12Value()))
            .orNull();
    }

    private BizCurrency tutmttknutiwake22;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutmttknutiwake22() {
        return tutmttknutiwake22;
    }

    public void setTutmttknutiwake22(BizCurrency pTutmttknutiwake22) {
        tutmttknutiwake22 = pTutmttknutiwake22;
        tutmttknutiwake22Value = null;
        tutmttknutiwake22Type  = null;
    }

    transient private BigDecimal tutmttknutiwake22Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTMTTKNUTIWAKE22, nullable=true)
    protected BigDecimal getTutmttknutiwake22Value() {
        if (tutmttknutiwake22Value == null && tutmttknutiwake22 != null) {
            if (tutmttknutiwake22.isOptional()) return null;
            return tutmttknutiwake22.absolute();
        }
        return tutmttknutiwake22Value;
    }

    protected void setTutmttknutiwake22Value(BigDecimal value) {
        tutmttknutiwake22Value = value;
        tutmttknutiwake22 = Optional.fromNullable(toCurrencyType(tutmttknutiwake22Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake22Value()))
            .orNull();
    }

    transient private String tutmttknutiwake22Type = null;

    @Column(name=TUTMTTKNUTIWAKE22 + "$", nullable=true)
    protected String getTutmttknutiwake22Type() {
        if (tutmttknutiwake22Type == null && tutmttknutiwake22 != null) return tutmttknutiwake22.getType().toString();
        if (tutmttknutiwake22Type == null && getTutmttknutiwake22Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutmttknutiwake22$' should not be NULL."));
        }
        return tutmttknutiwake22Type;
    }

    protected void setTutmttknutiwake22Type(String type) {
        tutmttknutiwake22Type = type;
        tutmttknutiwake22 = Optional.fromNullable(toCurrencyType(tutmttknutiwake22Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake22Value()))
            .orNull();
    }

    private BizCurrency tutmttknutiwake13;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutmttknutiwake13() {
        return tutmttknutiwake13;
    }

    public void setTutmttknutiwake13(BizCurrency pTutmttknutiwake13) {
        tutmttknutiwake13 = pTutmttknutiwake13;
        tutmttknutiwake13Value = null;
        tutmttknutiwake13Type  = null;
    }

    transient private BigDecimal tutmttknutiwake13Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTMTTKNUTIWAKE13, nullable=true)
    protected BigDecimal getTutmttknutiwake13Value() {
        if (tutmttknutiwake13Value == null && tutmttknutiwake13 != null) {
            if (tutmttknutiwake13.isOptional()) return null;
            return tutmttknutiwake13.absolute();
        }
        return tutmttknutiwake13Value;
    }

    protected void setTutmttknutiwake13Value(BigDecimal value) {
        tutmttknutiwake13Value = value;
        tutmttknutiwake13 = Optional.fromNullable(toCurrencyType(tutmttknutiwake13Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake13Value()))
            .orNull();
    }

    transient private String tutmttknutiwake13Type = null;

    @Column(name=TUTMTTKNUTIWAKE13 + "$", nullable=true)
    protected String getTutmttknutiwake13Type() {
        if (tutmttknutiwake13Type == null && tutmttknutiwake13 != null) return tutmttknutiwake13.getType().toString();
        if (tutmttknutiwake13Type == null && getTutmttknutiwake13Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutmttknutiwake13$' should not be NULL."));
        }
        return tutmttknutiwake13Type;
    }

    protected void setTutmttknutiwake13Type(String type) {
        tutmttknutiwake13Type = type;
        tutmttknutiwake13 = Optional.fromNullable(toCurrencyType(tutmttknutiwake13Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake13Value()))
            .orNull();
    }

    private BizCurrency tutmttknutiwake23;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutmttknutiwake23() {
        return tutmttknutiwake23;
    }

    public void setTutmttknutiwake23(BizCurrency pTutmttknutiwake23) {
        tutmttknutiwake23 = pTutmttknutiwake23;
        tutmttknutiwake23Value = null;
        tutmttknutiwake23Type  = null;
    }

    transient private BigDecimal tutmttknutiwake23Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTMTTKNUTIWAKE23, nullable=true)
    protected BigDecimal getTutmttknutiwake23Value() {
        if (tutmttknutiwake23Value == null && tutmttknutiwake23 != null) {
            if (tutmttknutiwake23.isOptional()) return null;
            return tutmttknutiwake23.absolute();
        }
        return tutmttknutiwake23Value;
    }

    protected void setTutmttknutiwake23Value(BigDecimal value) {
        tutmttknutiwake23Value = value;
        tutmttknutiwake23 = Optional.fromNullable(toCurrencyType(tutmttknutiwake23Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake23Value()))
            .orNull();
    }

    transient private String tutmttknutiwake23Type = null;

    @Column(name=TUTMTTKNUTIWAKE23 + "$", nullable=true)
    protected String getTutmttknutiwake23Type() {
        if (tutmttknutiwake23Type == null && tutmttknutiwake23 != null) return tutmttknutiwake23.getType().toString();
        if (tutmttknutiwake23Type == null && getTutmttknutiwake23Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutmttknutiwake23$' should not be NULL."));
        }
        return tutmttknutiwake23Type;
    }

    protected void setTutmttknutiwake23Type(String type) {
        tutmttknutiwake23Type = type;
        tutmttknutiwake23 = Optional.fromNullable(toCurrencyType(tutmttknutiwake23Type))
            .transform(bizCurrencyTransformer(getTutmttknutiwake23Value()))
            .orNull();
    }

    private BizNumber sisuuupritu1;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SISUUUPRITU1)
    public BizNumber getSisuuupritu1() {
        return sisuuupritu1;
    }

    public void setSisuuupritu1(BizNumber pSisuuupritu1) {
        sisuuupritu1 = pSisuuupritu1;
    }

    private BizNumber sisuuupritu2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SISUUUPRITU2)
    public BizNumber getSisuuupritu2() {
        return sisuuupritu2;
    }

    public void setSisuuupritu2(BizNumber pSisuuupritu2) {
        sisuuupritu2 = pSisuuupritu2;
    }

    private BizNumber sisuuupritu3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.SISUUUPRITU3)
    public BizNumber getSisuuupritu3() {
        return sisuuupritu3;
    }

    public void setSisuuupritu3(BizNumber pSisuuupritu3) {
        sisuuupritu3 = pSisuuupritu3;
    }

    private BizCurrency mvaaritmttkgkkykkjmaeup1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaeup1() {
        return mvaaritmttkgkkykkjmaeup1;
    }

    public void setMvaaritmttkgkkykkjmaeup1(BizCurrency pMvaaritmttkgkkykkjmaeup1) {
        mvaaritmttkgkkykkjmaeup1 = pMvaaritmttkgkkykkjmaeup1;
        mvaaritmttkgkkykkjmaeup1Value = null;
        mvaaritmttkgkkykkjmaeup1Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaeup1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAEUP1, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaeup1Value() {
        if (mvaaritmttkgkkykkjmaeup1Value == null && mvaaritmttkgkkykkjmaeup1 != null) {
            if (mvaaritmttkgkkykkjmaeup1.isOptional()) return null;
            return mvaaritmttkgkkykkjmaeup1.absolute();
        }
        return mvaaritmttkgkkykkjmaeup1Value;
    }

    protected void setMvaaritmttkgkkykkjmaeup1Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaeup1Value = value;
        mvaaritmttkgkkykkjmaeup1 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaeup1Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaeup1Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaeup1Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAEUP1 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaeup1Type() {
        if (mvaaritmttkgkkykkjmaeup1Type == null && mvaaritmttkgkkykkjmaeup1 != null) return mvaaritmttkgkkykkjmaeup1.getType().toString();
        if (mvaaritmttkgkkykkjmaeup1Type == null && getMvaaritmttkgkkykkjmaeup1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaeup1$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaeup1Type;
    }

    protected void setMvaaritmttkgkkykkjmaeup1Type(String type) {
        mvaaritmttkgkkykkjmaeup1Type = type;
        mvaaritmttkgkkykkjmaeup1 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaeup1Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaeup1Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaeup2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaeup2() {
        return mvaaritmttkgkkykkjmaeup2;
    }

    public void setMvaaritmttkgkkykkjmaeup2(BizCurrency pMvaaritmttkgkkykkjmaeup2) {
        mvaaritmttkgkkykkjmaeup2 = pMvaaritmttkgkkykkjmaeup2;
        mvaaritmttkgkkykkjmaeup2Value = null;
        mvaaritmttkgkkykkjmaeup2Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaeup2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAEUP2, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaeup2Value() {
        if (mvaaritmttkgkkykkjmaeup2Value == null && mvaaritmttkgkkykkjmaeup2 != null) {
            if (mvaaritmttkgkkykkjmaeup2.isOptional()) return null;
            return mvaaritmttkgkkykkjmaeup2.absolute();
        }
        return mvaaritmttkgkkykkjmaeup2Value;
    }

    protected void setMvaaritmttkgkkykkjmaeup2Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaeup2Value = value;
        mvaaritmttkgkkykkjmaeup2 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaeup2Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaeup2Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaeup2Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAEUP2 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaeup2Type() {
        if (mvaaritmttkgkkykkjmaeup2Type == null && mvaaritmttkgkkykkjmaeup2 != null) return mvaaritmttkgkkykkjmaeup2.getType().toString();
        if (mvaaritmttkgkkykkjmaeup2Type == null && getMvaaritmttkgkkykkjmaeup2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaeup2$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaeup2Type;
    }

    protected void setMvaaritmttkgkkykkjmaeup2Type(String type) {
        mvaaritmttkgkkykkjmaeup2Type = type;
        mvaaritmttkgkkykkjmaeup2 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaeup2Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaeup2Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaeup3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaeup3() {
        return mvaaritmttkgkkykkjmaeup3;
    }

    public void setMvaaritmttkgkkykkjmaeup3(BizCurrency pMvaaritmttkgkkykkjmaeup3) {
        mvaaritmttkgkkykkjmaeup3 = pMvaaritmttkgkkykkjmaeup3;
        mvaaritmttkgkkykkjmaeup3Value = null;
        mvaaritmttkgkkykkjmaeup3Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaeup3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAEUP3, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaeup3Value() {
        if (mvaaritmttkgkkykkjmaeup3Value == null && mvaaritmttkgkkykkjmaeup3 != null) {
            if (mvaaritmttkgkkykkjmaeup3.isOptional()) return null;
            return mvaaritmttkgkkykkjmaeup3.absolute();
        }
        return mvaaritmttkgkkykkjmaeup3Value;
    }

    protected void setMvaaritmttkgkkykkjmaeup3Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaeup3Value = value;
        mvaaritmttkgkkykkjmaeup3 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaeup3Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaeup3Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaeup3Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAEUP3 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaeup3Type() {
        if (mvaaritmttkgkkykkjmaeup3Type == null && mvaaritmttkgkkykkjmaeup3 != null) return mvaaritmttkgkkykkjmaeup3.getType().toString();
        if (mvaaritmttkgkkykkjmaeup3Type == null && getMvaaritmttkgkkykkjmaeup3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaeup3$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaeup3Type;
    }

    protected void setMvaaritmttkgkkykkjmaeup3Type(String type) {
        mvaaritmttkgkkykkjmaeup3Type = type;
        mvaaritmttkgkkykkjmaeup3 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaeup3Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaeup3Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaesame1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaesame1() {
        return mvaaritmttkgkkykkjmaesame1;
    }

    public void setMvaaritmttkgkkykkjmaesame1(BizCurrency pMvaaritmttkgkkykkjmaesame1) {
        mvaaritmttkgkkykkjmaesame1 = pMvaaritmttkgkkykkjmaesame1;
        mvaaritmttkgkkykkjmaesame1Value = null;
        mvaaritmttkgkkykkjmaesame1Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaesame1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAESAME1, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaesame1Value() {
        if (mvaaritmttkgkkykkjmaesame1Value == null && mvaaritmttkgkkykkjmaesame1 != null) {
            if (mvaaritmttkgkkykkjmaesame1.isOptional()) return null;
            return mvaaritmttkgkkykkjmaesame1.absolute();
        }
        return mvaaritmttkgkkykkjmaesame1Value;
    }

    protected void setMvaaritmttkgkkykkjmaesame1Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaesame1Value = value;
        mvaaritmttkgkkykkjmaesame1 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaesame1Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaesame1Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaesame1Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAESAME1 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaesame1Type() {
        if (mvaaritmttkgkkykkjmaesame1Type == null && mvaaritmttkgkkykkjmaesame1 != null) return mvaaritmttkgkkykkjmaesame1.getType().toString();
        if (mvaaritmttkgkkykkjmaesame1Type == null && getMvaaritmttkgkkykkjmaesame1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaesame1$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaesame1Type;
    }

    protected void setMvaaritmttkgkkykkjmaesame1Type(String type) {
        mvaaritmttkgkkykkjmaesame1Type = type;
        mvaaritmttkgkkykkjmaesame1 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaesame1Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaesame1Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaesame2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaesame2() {
        return mvaaritmttkgkkykkjmaesame2;
    }

    public void setMvaaritmttkgkkykkjmaesame2(BizCurrency pMvaaritmttkgkkykkjmaesame2) {
        mvaaritmttkgkkykkjmaesame2 = pMvaaritmttkgkkykkjmaesame2;
        mvaaritmttkgkkykkjmaesame2Value = null;
        mvaaritmttkgkkykkjmaesame2Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaesame2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAESAME2, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaesame2Value() {
        if (mvaaritmttkgkkykkjmaesame2Value == null && mvaaritmttkgkkykkjmaesame2 != null) {
            if (mvaaritmttkgkkykkjmaesame2.isOptional()) return null;
            return mvaaritmttkgkkykkjmaesame2.absolute();
        }
        return mvaaritmttkgkkykkjmaesame2Value;
    }

    protected void setMvaaritmttkgkkykkjmaesame2Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaesame2Value = value;
        mvaaritmttkgkkykkjmaesame2 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaesame2Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaesame2Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaesame2Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAESAME2 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaesame2Type() {
        if (mvaaritmttkgkkykkjmaesame2Type == null && mvaaritmttkgkkykkjmaesame2 != null) return mvaaritmttkgkkykkjmaesame2.getType().toString();
        if (mvaaritmttkgkkykkjmaesame2Type == null && getMvaaritmttkgkkykkjmaesame2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaesame2$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaesame2Type;
    }

    protected void setMvaaritmttkgkkykkjmaesame2Type(String type) {
        mvaaritmttkgkkykkjmaesame2Type = type;
        mvaaritmttkgkkykkjmaesame2 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaesame2Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaesame2Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaesame3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaesame3() {
        return mvaaritmttkgkkykkjmaesame3;
    }

    public void setMvaaritmttkgkkykkjmaesame3(BizCurrency pMvaaritmttkgkkykkjmaesame3) {
        mvaaritmttkgkkykkjmaesame3 = pMvaaritmttkgkkykkjmaesame3;
        mvaaritmttkgkkykkjmaesame3Value = null;
        mvaaritmttkgkkykkjmaesame3Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaesame3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAESAME3, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaesame3Value() {
        if (mvaaritmttkgkkykkjmaesame3Value == null && mvaaritmttkgkkykkjmaesame3 != null) {
            if (mvaaritmttkgkkykkjmaesame3.isOptional()) return null;
            return mvaaritmttkgkkykkjmaesame3.absolute();
        }
        return mvaaritmttkgkkykkjmaesame3Value;
    }

    protected void setMvaaritmttkgkkykkjmaesame3Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaesame3Value = value;
        mvaaritmttkgkkykkjmaesame3 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaesame3Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaesame3Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaesame3Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAESAME3 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaesame3Type() {
        if (mvaaritmttkgkkykkjmaesame3Type == null && mvaaritmttkgkkykkjmaesame3 != null) return mvaaritmttkgkkykkjmaesame3.getType().toString();
        if (mvaaritmttkgkkykkjmaesame3Type == null && getMvaaritmttkgkkykkjmaesame3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaesame3$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaesame3Type;
    }

    protected void setMvaaritmttkgkkykkjmaesame3Type(String type) {
        mvaaritmttkgkkykkjmaesame3Type = type;
        mvaaritmttkgkkykkjmaesame3 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaesame3Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaesame3Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaedown1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaedown1() {
        return mvaaritmttkgkkykkjmaedown1;
    }

    public void setMvaaritmttkgkkykkjmaedown1(BizCurrency pMvaaritmttkgkkykkjmaedown1) {
        mvaaritmttkgkkykkjmaedown1 = pMvaaritmttkgkkykkjmaedown1;
        mvaaritmttkgkkykkjmaedown1Value = null;
        mvaaritmttkgkkykkjmaedown1Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaedown1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAEDOWN1, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaedown1Value() {
        if (mvaaritmttkgkkykkjmaedown1Value == null && mvaaritmttkgkkykkjmaedown1 != null) {
            if (mvaaritmttkgkkykkjmaedown1.isOptional()) return null;
            return mvaaritmttkgkkykkjmaedown1.absolute();
        }
        return mvaaritmttkgkkykkjmaedown1Value;
    }

    protected void setMvaaritmttkgkkykkjmaedown1Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaedown1Value = value;
        mvaaritmttkgkkykkjmaedown1 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaedown1Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaedown1Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaedown1Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAEDOWN1 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaedown1Type() {
        if (mvaaritmttkgkkykkjmaedown1Type == null && mvaaritmttkgkkykkjmaedown1 != null) return mvaaritmttkgkkykkjmaedown1.getType().toString();
        if (mvaaritmttkgkkykkjmaedown1Type == null && getMvaaritmttkgkkykkjmaedown1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaedown1$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaedown1Type;
    }

    protected void setMvaaritmttkgkkykkjmaedown1Type(String type) {
        mvaaritmttkgkkykkjmaedown1Type = type;
        mvaaritmttkgkkykkjmaedown1 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaedown1Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaedown1Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaedown2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaedown2() {
        return mvaaritmttkgkkykkjmaedown2;
    }

    public void setMvaaritmttkgkkykkjmaedown2(BizCurrency pMvaaritmttkgkkykkjmaedown2) {
        mvaaritmttkgkkykkjmaedown2 = pMvaaritmttkgkkykkjmaedown2;
        mvaaritmttkgkkykkjmaedown2Value = null;
        mvaaritmttkgkkykkjmaedown2Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaedown2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAEDOWN2, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaedown2Value() {
        if (mvaaritmttkgkkykkjmaedown2Value == null && mvaaritmttkgkkykkjmaedown2 != null) {
            if (mvaaritmttkgkkykkjmaedown2.isOptional()) return null;
            return mvaaritmttkgkkykkjmaedown2.absolute();
        }
        return mvaaritmttkgkkykkjmaedown2Value;
    }

    protected void setMvaaritmttkgkkykkjmaedown2Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaedown2Value = value;
        mvaaritmttkgkkykkjmaedown2 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaedown2Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaedown2Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaedown2Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAEDOWN2 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaedown2Type() {
        if (mvaaritmttkgkkykkjmaedown2Type == null && mvaaritmttkgkkykkjmaedown2 != null) return mvaaritmttkgkkykkjmaedown2.getType().toString();
        if (mvaaritmttkgkkykkjmaedown2Type == null && getMvaaritmttkgkkykkjmaedown2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaedown2$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaedown2Type;
    }

    protected void setMvaaritmttkgkkykkjmaedown2Type(String type) {
        mvaaritmttkgkkykkjmaedown2Type = type;
        mvaaritmttkgkkykkjmaedown2 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaedown2Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaedown2Value()))
            .orNull();
    }

    private BizCurrency mvaaritmttkgkkykkjmaedown3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMvaaritmttkgkkykkjmaedown3() {
        return mvaaritmttkgkkykkjmaedown3;
    }

    public void setMvaaritmttkgkkykkjmaedown3(BizCurrency pMvaaritmttkgkkykkjmaedown3) {
        mvaaritmttkgkkykkjmaedown3 = pMvaaritmttkgkkykkjmaedown3;
        mvaaritmttkgkkykkjmaedown3Value = null;
        mvaaritmttkgkkykkjmaedown3Type  = null;
    }

    transient private BigDecimal mvaaritmttkgkkykkjmaedown3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MVAARITMTTKGKKYKKJMAEDOWN3, nullable=true)
    protected BigDecimal getMvaaritmttkgkkykkjmaedown3Value() {
        if (mvaaritmttkgkkykkjmaedown3Value == null && mvaaritmttkgkkykkjmaedown3 != null) {
            if (mvaaritmttkgkkykkjmaedown3.isOptional()) return null;
            return mvaaritmttkgkkykkjmaedown3.absolute();
        }
        return mvaaritmttkgkkykkjmaedown3Value;
    }

    protected void setMvaaritmttkgkkykkjmaedown3Value(BigDecimal value) {
        mvaaritmttkgkkykkjmaedown3Value = value;
        mvaaritmttkgkkykkjmaedown3 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaedown3Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaedown3Value()))
            .orNull();
    }

    transient private String mvaaritmttkgkkykkjmaedown3Type = null;

    @Column(name=MVAARITMTTKGKKYKKJMAEDOWN3 + "$", nullable=true)
    protected String getMvaaritmttkgkkykkjmaedown3Type() {
        if (mvaaritmttkgkkykkjmaedown3Type == null && mvaaritmttkgkkykkjmaedown3 != null) return mvaaritmttkgkkykkjmaedown3.getType().toString();
        if (mvaaritmttkgkkykkjmaedown3Type == null && getMvaaritmttkgkkykkjmaedown3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mvaaritmttkgkkykkjmaedown3$' should not be NULL."));
        }
        return mvaaritmttkgkkykkjmaedown3Type;
    }

    protected void setMvaaritmttkgkkykkjmaedown3Type(String type) {
        mvaaritmttkgkkykkjmaedown3Type = type;
        mvaaritmttkgkkykkjmaedown3 = Optional.fromNullable(toCurrencyType(mvaaritmttkgkkykkjmaedown3Type))
            .transform(bizCurrencyTransformer(getMvaaritmttkgkkykkjmaedown3Value()))
            .orNull();
    }

    private String suiihyousyubetu;

    @Column(name=GenIT_Suiihyou.SUIIHYOUSYUBETU)
    public String getSuiihyousyubetu() {
        return suiihyousyubetu;
    }

    public void setSuiihyousyubetu(String pSuiihyousyubetu) {
        suiihyousyubetu = pSuiihyousyubetu;
    }

    private C_UmuKbn hrkkknmnryumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_Suiihyou.HRKKKNMNRYUMUKBN)
    public C_UmuKbn getHrkkknmnryumukbn() {
        return hrkkknmnryumukbn;
    }

    public void setHrkkknmnryumukbn(C_UmuKbn pHrkkknmnryumukbn) {
        hrkkknmnryumukbn = pHrkkknmnryumukbn;
    }

    private BizNumber ytirrtcalckijyunrrt1;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YTIRRTCALCKIJYUNRRT1)
    public BizNumber getYtirrtcalckijyunrrt1() {
        return ytirrtcalckijyunrrt1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYtirrtcalckijyunrrt1(BizNumber pYtirrtcalckijyunrrt1) {
        ytirrtcalckijyunrrt1 = pYtirrtcalckijyunrrt1;
    }

    private BizNumber ytirrtcalckijyunrrt2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YTIRRTCALCKIJYUNRRT2)
    public BizNumber getYtirrtcalckijyunrrt2() {
        return ytirrtcalckijyunrrt2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYtirrtcalckijyunrrt2(BizNumber pYtirrtcalckijyunrrt2) {
        ytirrtcalckijyunrrt2 = pYtirrtcalckijyunrrt2;
    }

    private BizNumber ytirrtcalckijyunrrt3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_Suiihyou.YTIRRTCALCKIJYUNRRT3)
    public BizNumber getYtirrtcalckijyunrrt3() {
        return ytirrtcalckijyunrrt3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYtirrtcalckijyunrrt3(BizNumber pYtirrtcalckijyunrrt3) {
        ytirrtcalckijyunrrt3 = pYtirrtcalckijyunrrt3;
    }

    private BizCurrency zennouzndkyen1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouzndkyen1() {
        return zennouzndkyen1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZennouzndkyen1(BizCurrency pZennouzndkyen1) {
        zennouzndkyen1 = pZennouzndkyen1;
        zennouzndkyen1Value = null;
        zennouzndkyen1Type  = null;
    }

    transient private BigDecimal zennouzndkyen1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUZNDKYEN1, nullable=true)
    protected BigDecimal getZennouzndkyen1Value() {
        if (zennouzndkyen1Value == null && zennouzndkyen1 != null) {
            if (zennouzndkyen1.isOptional()) return null;
            return zennouzndkyen1.absolute();
        }
        return zennouzndkyen1Value;
    }

    protected void setZennouzndkyen1Value(BigDecimal value) {
        zennouzndkyen1Value = value;
        zennouzndkyen1 = Optional.fromNullable(toCurrencyType(zennouzndkyen1Type))
            .transform(bizCurrencyTransformer(getZennouzndkyen1Value()))
            .orNull();
    }

    transient private String zennouzndkyen1Type = null;

    @Column(name=ZENNOUZNDKYEN1 + "$", nullable=true)
    protected String getZennouzndkyen1Type() {
        if (zennouzndkyen1Type == null && zennouzndkyen1 != null) return zennouzndkyen1.getType().toString();
        if (zennouzndkyen1Type == null && getZennouzndkyen1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouzndkyen1$' should not be NULL."));
        }
        return zennouzndkyen1Type;
    }

    protected void setZennouzndkyen1Type(String type) {
        zennouzndkyen1Type = type;
        zennouzndkyen1 = Optional.fromNullable(toCurrencyType(zennouzndkyen1Type))
            .transform(bizCurrencyTransformer(getZennouzndkyen1Value()))
            .orNull();
    }

    private BizCurrency zennouzndkyen2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouzndkyen2() {
        return zennouzndkyen2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZennouzndkyen2(BizCurrency pZennouzndkyen2) {
        zennouzndkyen2 = pZennouzndkyen2;
        zennouzndkyen2Value = null;
        zennouzndkyen2Type  = null;
    }

    transient private BigDecimal zennouzndkyen2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUZNDKYEN2, nullable=true)
    protected BigDecimal getZennouzndkyen2Value() {
        if (zennouzndkyen2Value == null && zennouzndkyen2 != null) {
            if (zennouzndkyen2.isOptional()) return null;
            return zennouzndkyen2.absolute();
        }
        return zennouzndkyen2Value;
    }

    protected void setZennouzndkyen2Value(BigDecimal value) {
        zennouzndkyen2Value = value;
        zennouzndkyen2 = Optional.fromNullable(toCurrencyType(zennouzndkyen2Type))
            .transform(bizCurrencyTransformer(getZennouzndkyen2Value()))
            .orNull();
    }

    transient private String zennouzndkyen2Type = null;

    @Column(name=ZENNOUZNDKYEN2 + "$", nullable=true)
    protected String getZennouzndkyen2Type() {
        if (zennouzndkyen2Type == null && zennouzndkyen2 != null) return zennouzndkyen2.getType().toString();
        if (zennouzndkyen2Type == null && getZennouzndkyen2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouzndkyen2$' should not be NULL."));
        }
        return zennouzndkyen2Type;
    }

    protected void setZennouzndkyen2Type(String type) {
        zennouzndkyen2Type = type;
        zennouzndkyen2 = Optional.fromNullable(toCurrencyType(zennouzndkyen2Type))
            .transform(bizCurrencyTransformer(getZennouzndkyen2Value()))
            .orNull();
    }

    private BizCurrency zennouzndkyen3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouzndkyen3() {
        return zennouzndkyen3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZennouzndkyen3(BizCurrency pZennouzndkyen3) {
        zennouzndkyen3 = pZennouzndkyen3;
        zennouzndkyen3Value = null;
        zennouzndkyen3Type  = null;
    }

    transient private BigDecimal zennouzndkyen3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUZNDKYEN3, nullable=true)
    protected BigDecimal getZennouzndkyen3Value() {
        if (zennouzndkyen3Value == null && zennouzndkyen3 != null) {
            if (zennouzndkyen3.isOptional()) return null;
            return zennouzndkyen3.absolute();
        }
        return zennouzndkyen3Value;
    }

    protected void setZennouzndkyen3Value(BigDecimal value) {
        zennouzndkyen3Value = value;
        zennouzndkyen3 = Optional.fromNullable(toCurrencyType(zennouzndkyen3Type))
            .transform(bizCurrencyTransformer(getZennouzndkyen3Value()))
            .orNull();
    }

    transient private String zennouzndkyen3Type = null;

    @Column(name=ZENNOUZNDKYEN3 + "$", nullable=true)
    protected String getZennouzndkyen3Type() {
        if (zennouzndkyen3Type == null && zennouzndkyen3 != null) return zennouzndkyen3.getType().toString();
        if (zennouzndkyen3Type == null && getZennouzndkyen3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouzndkyen3$' should not be NULL."));
        }
        return zennouzndkyen3Type;
    }

    protected void setZennouzndkyen3Type(String type) {
        zennouzndkyen3Type = type;
        zennouzndkyen3 = Optional.fromNullable(toCurrencyType(zennouzndkyen3Type))
            .transform(bizCurrencyTransformer(getZennouzndkyen3Value()))
            .orNull();
    }

    private BizCurrency kihrkmpyen1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmpyen1() {
        return kihrkmpyen1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmpyen1(BizCurrency pKihrkmpyen1) {
        kihrkmpyen1 = pKihrkmpyen1;
        kihrkmpyen1Value = null;
        kihrkmpyen1Type  = null;
    }

    transient private BigDecimal kihrkmpyen1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMPYEN1, nullable=true)
    protected BigDecimal getKihrkmpyen1Value() {
        if (kihrkmpyen1Value == null && kihrkmpyen1 != null) {
            if (kihrkmpyen1.isOptional()) return null;
            return kihrkmpyen1.absolute();
        }
        return kihrkmpyen1Value;
    }

    protected void setKihrkmpyen1Value(BigDecimal value) {
        kihrkmpyen1Value = value;
        kihrkmpyen1 = Optional.fromNullable(toCurrencyType(kihrkmpyen1Type))
            .transform(bizCurrencyTransformer(getKihrkmpyen1Value()))
            .orNull();
    }

    transient private String kihrkmpyen1Type = null;

    @Column(name=KIHRKMPYEN1 + "$", nullable=true)
    protected String getKihrkmpyen1Type() {
        if (kihrkmpyen1Type == null && kihrkmpyen1 != null) return kihrkmpyen1.getType().toString();
        if (kihrkmpyen1Type == null && getKihrkmpyen1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmpyen1$' should not be NULL."));
        }
        return kihrkmpyen1Type;
    }

    protected void setKihrkmpyen1Type(String type) {
        kihrkmpyen1Type = type;
        kihrkmpyen1 = Optional.fromNullable(toCurrencyType(kihrkmpyen1Type))
            .transform(bizCurrencyTransformer(getKihrkmpyen1Value()))
            .orNull();
    }

    private BizCurrency kihrkmpyen2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmpyen2() {
        return kihrkmpyen2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmpyen2(BizCurrency pKihrkmpyen2) {
        kihrkmpyen2 = pKihrkmpyen2;
        kihrkmpyen2Value = null;
        kihrkmpyen2Type  = null;
    }

    transient private BigDecimal kihrkmpyen2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMPYEN2, nullable=true)
    protected BigDecimal getKihrkmpyen2Value() {
        if (kihrkmpyen2Value == null && kihrkmpyen2 != null) {
            if (kihrkmpyen2.isOptional()) return null;
            return kihrkmpyen2.absolute();
        }
        return kihrkmpyen2Value;
    }

    protected void setKihrkmpyen2Value(BigDecimal value) {
        kihrkmpyen2Value = value;
        kihrkmpyen2 = Optional.fromNullable(toCurrencyType(kihrkmpyen2Type))
            .transform(bizCurrencyTransformer(getKihrkmpyen2Value()))
            .orNull();
    }

    transient private String kihrkmpyen2Type = null;

    @Column(name=KIHRKMPYEN2 + "$", nullable=true)
    protected String getKihrkmpyen2Type() {
        if (kihrkmpyen2Type == null && kihrkmpyen2 != null) return kihrkmpyen2.getType().toString();
        if (kihrkmpyen2Type == null && getKihrkmpyen2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmpyen2$' should not be NULL."));
        }
        return kihrkmpyen2Type;
    }

    protected void setKihrkmpyen2Type(String type) {
        kihrkmpyen2Type = type;
        kihrkmpyen2 = Optional.fromNullable(toCurrencyType(kihrkmpyen2Type))
            .transform(bizCurrencyTransformer(getKihrkmpyen2Value()))
            .orNull();
    }

    private BizCurrency kihrkmpyen3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmpyen3() {
        return kihrkmpyen3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmpyen3(BizCurrency pKihrkmpyen3) {
        kihrkmpyen3 = pKihrkmpyen3;
        kihrkmpyen3Value = null;
        kihrkmpyen3Type  = null;
    }

    transient private BigDecimal kihrkmpyen3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMPYEN3, nullable=true)
    protected BigDecimal getKihrkmpyen3Value() {
        if (kihrkmpyen3Value == null && kihrkmpyen3 != null) {
            if (kihrkmpyen3.isOptional()) return null;
            return kihrkmpyen3.absolute();
        }
        return kihrkmpyen3Value;
    }

    protected void setKihrkmpyen3Value(BigDecimal value) {
        kihrkmpyen3Value = value;
        kihrkmpyen3 = Optional.fromNullable(toCurrencyType(kihrkmpyen3Type))
            .transform(bizCurrencyTransformer(getKihrkmpyen3Value()))
            .orNull();
    }

    transient private String kihrkmpyen3Type = null;

    @Column(name=KIHRKMPYEN3 + "$", nullable=true)
    protected String getKihrkmpyen3Type() {
        if (kihrkmpyen3Type == null && kihrkmpyen3 != null) return kihrkmpyen3.getType().toString();
        if (kihrkmpyen3Type == null && getKihrkmpyen3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmpyen3$' should not be NULL."));
        }
        return kihrkmpyen3Type;
    }

    protected void setKihrkmpyen3Type(String type) {
        kihrkmpyen3Type = type;
        kihrkmpyen3 = Optional.fromNullable(toCurrencyType(kihrkmpyen3Type))
            .transform(bizCurrencyTransformer(getKihrkmpyen3Value()))
            .orNull();
    }

    private BizCurrency kihrkmp1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmp1() {
        return kihrkmp1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmp1(BizCurrency pKihrkmp1) {
        kihrkmp1 = pKihrkmp1;
        kihrkmp1Value = null;
        kihrkmp1Type  = null;
    }

    transient private BigDecimal kihrkmp1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMP1, nullable=true)
    protected BigDecimal getKihrkmp1Value() {
        if (kihrkmp1Value == null && kihrkmp1 != null) {
            if (kihrkmp1.isOptional()) return null;
            return kihrkmp1.absolute();
        }
        return kihrkmp1Value;
    }

    protected void setKihrkmp1Value(BigDecimal value) {
        kihrkmp1Value = value;
        kihrkmp1 = Optional.fromNullable(toCurrencyType(kihrkmp1Type))
            .transform(bizCurrencyTransformer(getKihrkmp1Value()))
            .orNull();
    }

    transient private String kihrkmp1Type = null;

    @Column(name=KIHRKMP1 + "$", nullable=true)
    protected String getKihrkmp1Type() {
        if (kihrkmp1Type == null && kihrkmp1 != null) return kihrkmp1.getType().toString();
        if (kihrkmp1Type == null && getKihrkmp1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmp1$' should not be NULL."));
        }
        return kihrkmp1Type;
    }

    protected void setKihrkmp1Type(String type) {
        kihrkmp1Type = type;
        kihrkmp1 = Optional.fromNullable(toCurrencyType(kihrkmp1Type))
            .transform(bizCurrencyTransformer(getKihrkmp1Value()))
            .orNull();
    }

    private BizCurrency kihrkmp2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmp2() {
        return kihrkmp2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmp2(BizCurrency pKihrkmp2) {
        kihrkmp2 = pKihrkmp2;
        kihrkmp2Value = null;
        kihrkmp2Type  = null;
    }

    transient private BigDecimal kihrkmp2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMP2, nullable=true)
    protected BigDecimal getKihrkmp2Value() {
        if (kihrkmp2Value == null && kihrkmp2 != null) {
            if (kihrkmp2.isOptional()) return null;
            return kihrkmp2.absolute();
        }
        return kihrkmp2Value;
    }

    protected void setKihrkmp2Value(BigDecimal value) {
        kihrkmp2Value = value;
        kihrkmp2 = Optional.fromNullable(toCurrencyType(kihrkmp2Type))
            .transform(bizCurrencyTransformer(getKihrkmp2Value()))
            .orNull();
    }

    transient private String kihrkmp2Type = null;

    @Column(name=KIHRKMP2 + "$", nullable=true)
    protected String getKihrkmp2Type() {
        if (kihrkmp2Type == null && kihrkmp2 != null) return kihrkmp2.getType().toString();
        if (kihrkmp2Type == null && getKihrkmp2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmp2$' should not be NULL."));
        }
        return kihrkmp2Type;
    }

    protected void setKihrkmp2Type(String type) {
        kihrkmp2Type = type;
        kihrkmp2 = Optional.fromNullable(toCurrencyType(kihrkmp2Type))
            .transform(bizCurrencyTransformer(getKihrkmp2Value()))
            .orNull();
    }

    private BizCurrency kihrkmp3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmp3() {
        return kihrkmp3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmp3(BizCurrency pKihrkmp3) {
        kihrkmp3 = pKihrkmp3;
        kihrkmp3Value = null;
        kihrkmp3Type  = null;
    }

    transient private BigDecimal kihrkmp3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMP3, nullable=true)
    protected BigDecimal getKihrkmp3Value() {
        if (kihrkmp3Value == null && kihrkmp3 != null) {
            if (kihrkmp3.isOptional()) return null;
            return kihrkmp3.absolute();
        }
        return kihrkmp3Value;
    }

    protected void setKihrkmp3Value(BigDecimal value) {
        kihrkmp3Value = value;
        kihrkmp3 = Optional.fromNullable(toCurrencyType(kihrkmp3Type))
            .transform(bizCurrencyTransformer(getKihrkmp3Value()))
            .orNull();
    }

    transient private String kihrkmp3Type = null;

    @Column(name=KIHRKMP3 + "$", nullable=true)
    protected String getKihrkmp3Type() {
        if (kihrkmp3Type == null && kihrkmp3 != null) return kihrkmp3.getType().toString();
        if (kihrkmp3Type == null && getKihrkmp3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmp3$' should not be NULL."));
        }
        return kihrkmp3Type;
    }

    protected void setKihrkmp3Type(String type) {
        kihrkmp3Type = type;
        kihrkmp3 = Optional.fromNullable(toCurrencyType(kihrkmp3Type))
            .transform(bizCurrencyTransformer(getKihrkmp3Value()))
            .orNull();
    }

    private BizCurrency zennouzndk1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouzndk1() {
        return zennouzndk1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZennouzndk1(BizCurrency pZennouzndk1) {
        zennouzndk1 = pZennouzndk1;
        zennouzndk1Value = null;
        zennouzndk1Type  = null;
    }

    transient private BigDecimal zennouzndk1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUZNDK1, nullable=true)
    protected BigDecimal getZennouzndk1Value() {
        if (zennouzndk1Value == null && zennouzndk1 != null) {
            if (zennouzndk1.isOptional()) return null;
            return zennouzndk1.absolute();
        }
        return zennouzndk1Value;
    }

    protected void setZennouzndk1Value(BigDecimal value) {
        zennouzndk1Value = value;
        zennouzndk1 = Optional.fromNullable(toCurrencyType(zennouzndk1Type))
            .transform(bizCurrencyTransformer(getZennouzndk1Value()))
            .orNull();
    }

    transient private String zennouzndk1Type = null;

    @Column(name=ZENNOUZNDK1 + "$", nullable=true)
    protected String getZennouzndk1Type() {
        if (zennouzndk1Type == null && zennouzndk1 != null) return zennouzndk1.getType().toString();
        if (zennouzndk1Type == null && getZennouzndk1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouzndk1$' should not be NULL."));
        }
        return zennouzndk1Type;
    }

    protected void setZennouzndk1Type(String type) {
        zennouzndk1Type = type;
        zennouzndk1 = Optional.fromNullable(toCurrencyType(zennouzndk1Type))
            .transform(bizCurrencyTransformer(getZennouzndk1Value()))
            .orNull();
    }

    private BizCurrency kaiyakujuktrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakujuktrgk() {
        return kaiyakujuktrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakujuktrgk(BizCurrency pKaiyakujuktrgk) {
        kaiyakujuktrgk = pKaiyakujuktrgk;
        kaiyakujuktrgkValue = null;
        kaiyakujuktrgkType  = null;
    }

    transient private BigDecimal kaiyakujuktrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUJUKTRGK, nullable=true)
    protected BigDecimal getKaiyakujuktrgkValue() {
        if (kaiyakujuktrgkValue == null && kaiyakujuktrgk != null) {
            if (kaiyakujuktrgk.isOptional()) return null;
            return kaiyakujuktrgk.absolute();
        }
        return kaiyakujuktrgkValue;
    }

    protected void setKaiyakujuktrgkValue(BigDecimal value) {
        kaiyakujuktrgkValue = value;
        kaiyakujuktrgk = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkValue()))
            .orNull();
    }

    transient private String kaiyakujuktrgkType = null;

    @Column(name=KAIYAKUJUKTRGK + "$", nullable=true)
    protected String getKaiyakujuktrgkType() {
        if (kaiyakujuktrgkType == null && kaiyakujuktrgk != null) return kaiyakujuktrgk.getType().toString();
        if (kaiyakujuktrgkType == null && getKaiyakujuktrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakujuktrgk$' should not be NULL."));
        }
        return kaiyakujuktrgkType;
    }

    protected void setKaiyakujuktrgkType(String type) {
        kaiyakujuktrgkType = type;
        kaiyakujuktrgk = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkValue()))
            .orNull();
    }

    private BizCurrency kaiyakujuktrgkyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakujuktrgkyendaka() {
        return kaiyakujuktrgkyendaka;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakujuktrgkyendaka(BizCurrency pKaiyakujuktrgkyendaka) {
        kaiyakujuktrgkyendaka = pKaiyakujuktrgkyendaka;
        kaiyakujuktrgkyendakaValue = null;
        kaiyakujuktrgkyendakaType  = null;
    }

    transient private BigDecimal kaiyakujuktrgkyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUJUKTRGKYENDAKA, nullable=true)
    protected BigDecimal getKaiyakujuktrgkyendakaValue() {
        if (kaiyakujuktrgkyendakaValue == null && kaiyakujuktrgkyendaka != null) {
            if (kaiyakujuktrgkyendaka.isOptional()) return null;
            return kaiyakujuktrgkyendaka.absolute();
        }
        return kaiyakujuktrgkyendakaValue;
    }

    protected void setKaiyakujuktrgkyendakaValue(BigDecimal value) {
        kaiyakujuktrgkyendakaValue = value;
        kaiyakujuktrgkyendaka = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkyendakaType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkyendakaValue()))
            .orNull();
    }

    transient private String kaiyakujuktrgkyendakaType = null;

    @Column(name=KAIYAKUJUKTRGKYENDAKA + "$", nullable=true)
    protected String getKaiyakujuktrgkyendakaType() {
        if (kaiyakujuktrgkyendakaType == null && kaiyakujuktrgkyendaka != null) return kaiyakujuktrgkyendaka.getType().toString();
        if (kaiyakujuktrgkyendakaType == null && getKaiyakujuktrgkyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakujuktrgkyendaka$' should not be NULL."));
        }
        return kaiyakujuktrgkyendakaType;
    }

    protected void setKaiyakujuktrgkyendakaType(String type) {
        kaiyakujuktrgkyendakaType = type;
        kaiyakujuktrgkyendaka = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkyendakaType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkyendakaValue()))
            .orNull();
    }

    private BizCurrency kaiyakujuktrgkyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakujuktrgkyenkijyun() {
        return kaiyakujuktrgkyenkijyun;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakujuktrgkyenkijyun(BizCurrency pKaiyakujuktrgkyenkijyun) {
        kaiyakujuktrgkyenkijyun = pKaiyakujuktrgkyenkijyun;
        kaiyakujuktrgkyenkijyunValue = null;
        kaiyakujuktrgkyenkijyunType  = null;
    }

    transient private BigDecimal kaiyakujuktrgkyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUJUKTRGKYENKIJYUN, nullable=true)
    protected BigDecimal getKaiyakujuktrgkyenkijyunValue() {
        if (kaiyakujuktrgkyenkijyunValue == null && kaiyakujuktrgkyenkijyun != null) {
            if (kaiyakujuktrgkyenkijyun.isOptional()) return null;
            return kaiyakujuktrgkyenkijyun.absolute();
        }
        return kaiyakujuktrgkyenkijyunValue;
    }

    protected void setKaiyakujuktrgkyenkijyunValue(BigDecimal value) {
        kaiyakujuktrgkyenkijyunValue = value;
        kaiyakujuktrgkyenkijyun = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkyenkijyunType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkyenkijyunValue()))
            .orNull();
    }

    transient private String kaiyakujuktrgkyenkijyunType = null;

    @Column(name=KAIYAKUJUKTRGKYENKIJYUN + "$", nullable=true)
    protected String getKaiyakujuktrgkyenkijyunType() {
        if (kaiyakujuktrgkyenkijyunType == null && kaiyakujuktrgkyenkijyun != null) return kaiyakujuktrgkyenkijyun.getType().toString();
        if (kaiyakujuktrgkyenkijyunType == null && getKaiyakujuktrgkyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakujuktrgkyenkijyun$' should not be NULL."));
        }
        return kaiyakujuktrgkyenkijyunType;
    }

    protected void setKaiyakujuktrgkyenkijyunType(String type) {
        kaiyakujuktrgkyenkijyunType = type;
        kaiyakujuktrgkyenkijyun = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkyenkijyunType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkyenkijyunValue()))
            .orNull();
    }

    private BizCurrency kaiyakujuktrgkyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakujuktrgkyenyasu() {
        return kaiyakujuktrgkyenyasu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakujuktrgkyenyasu(BizCurrency pKaiyakujuktrgkyenyasu) {
        kaiyakujuktrgkyenyasu = pKaiyakujuktrgkyenyasu;
        kaiyakujuktrgkyenyasuValue = null;
        kaiyakujuktrgkyenyasuType  = null;
    }

    transient private BigDecimal kaiyakujuktrgkyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUJUKTRGKYENYASU, nullable=true)
    protected BigDecimal getKaiyakujuktrgkyenyasuValue() {
        if (kaiyakujuktrgkyenyasuValue == null && kaiyakujuktrgkyenyasu != null) {
            if (kaiyakujuktrgkyenyasu.isOptional()) return null;
            return kaiyakujuktrgkyenyasu.absolute();
        }
        return kaiyakujuktrgkyenyasuValue;
    }

    protected void setKaiyakujuktrgkyenyasuValue(BigDecimal value) {
        kaiyakujuktrgkyenyasuValue = value;
        kaiyakujuktrgkyenyasu = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkyenyasuType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkyenyasuValue()))
            .orNull();
    }

    transient private String kaiyakujuktrgkyenyasuType = null;

    @Column(name=KAIYAKUJUKTRGKYENYASU + "$", nullable=true)
    protected String getKaiyakujuktrgkyenyasuType() {
        if (kaiyakujuktrgkyenyasuType == null && kaiyakujuktrgkyenyasu != null) return kaiyakujuktrgkyenyasu.getType().toString();
        if (kaiyakujuktrgkyenyasuType == null && getKaiyakujuktrgkyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakujuktrgkyenyasu$' should not be NULL."));
        }
        return kaiyakujuktrgkyenyasuType;
    }

    protected void setKaiyakujuktrgkyenyasuType(String type) {
        kaiyakujuktrgkyenyasuType = type;
        kaiyakujuktrgkyenyasu = Optional.fromNullable(toCurrencyType(kaiyakujuktrgkyenyasuType))
            .transform(bizCurrencyTransformer(getKaiyakujuktrgkyenyasuValue()))
            .orNull();
    }
}