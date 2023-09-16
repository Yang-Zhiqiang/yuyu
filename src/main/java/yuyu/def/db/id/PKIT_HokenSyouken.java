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
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.mapping.GenIT_HokenSyouken;
import yuyu.def.db.meta.GenQIT_HokenSyouken;
import yuyu.def.db.meta.QIT_HokenSyouken;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険証券テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HokenSyouken}</td><td colspan="3">保険証券テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinsaihkkbn</td><td>新規再発行区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsaihkKbn C_SinsaihkKbn}</td></tr>
 *  <tr><td>syoukensaihkkbn</td><td>証券再発行区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukensaihkKbn C_SyoukensaihkKbn}</td></tr>
 *  <tr><td>insizeishryouhikbn</td><td>印紙税支払要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InsizeiShryouhiKbn C_InsizeiShryouhiKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>koujyosyoumeiumukbn</td><td>控除証明書有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>suiihyouumukbn</td><td>推移表有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kanryoutuutiumukbn</td><td>完了通知有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktirasidouhuukbn</td><td>被保険者代理人チラシ同封区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dstirasidouhuukbn</td><td>ＤＳチラシ同封区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr><td>syotnshuyoupostumukbn</td><td>証券転送不要郵便有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd1</td><td>表示欄左メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd2</td><td>表示欄左メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd3</td><td>表示欄左メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd4</td><td>表示欄左メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd5</td><td>表示欄左メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd6</td><td>表示欄左メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd7</td><td>表示欄左メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd8</td><td>表示欄左メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd9</td><td>表示欄左メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd10</td><td>表示欄左メッセージコード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd11</td><td>表示欄左メッセージコード１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd12</td><td>表示欄左メッセージコード１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd13</td><td>表示欄左メッセージコード１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd14</td><td>表示欄左メッセージコード１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd15</td><td>表示欄左メッセージコード１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd16</td><td>表示欄左メッセージコード１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd17</td><td>表示欄左メッセージコード１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd18</td><td>表示欄左メッセージコード１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd19</td><td>表示欄左メッセージコード１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranhidarimsgcd20</td><td>表示欄左メッセージコード２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd1</td><td>表示欄右メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd2</td><td>表示欄右メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd3</td><td>表示欄右メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd4</td><td>表示欄右メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd5</td><td>表示欄右メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd6</td><td>表示欄右メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd7</td><td>表示欄右メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd8</td><td>表示欄右メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd9</td><td>表示欄右メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd10</td><td>表示欄右メッセージコード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd11</td><td>表示欄右メッセージコード１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd12</td><td>表示欄右メッセージコード１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd13</td><td>表示欄右メッセージコード１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd14</td><td>表示欄右メッセージコード１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd15</td><td>表示欄右メッセージコード１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd16</td><td>表示欄右メッセージコード１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd17</td><td>表示欄右メッセージコード１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd18</td><td>表示欄右メッセージコード１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd19</td><td>表示欄右メッセージコード１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiranmigiimsgcd20</td><td>表示欄右メッセージコード２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiransknnkaisiymd</td><td>表示欄責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujiranyoteiriritu</td><td>表示欄予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hyoujiransjkkktusirrt</td><td>表示欄市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syohakkouymd</td><td>証券発行年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hanbainm</td><td>販売名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seisikihknnm</td><td>正式保険名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouryokukaisiymd</td><td>効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkjkhukakbn</td><td>契約者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkjkhukakbn</td><td>被保険者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoukenuktmidasikbn1</td><td>（証券）受取人見出し区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn1</td><td>（証券）受取人区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm1</td><td>（証券）受取人名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari1</td><td>（証券）受取人分割割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn2</td><td>（証券）受取人見出し区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn2</td><td>（証券）受取人区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm2</td><td>（証券）受取人名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari2</td><td>（証券）受取人分割割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn3</td><td>（証券）受取人見出し区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn3</td><td>（証券）受取人区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm3</td><td>（証券）受取人名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari3</td><td>（証券）受取人分割割合３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn4</td><td>（証券）受取人見出し区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn4</td><td>（証券）受取人区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm4</td><td>（証券）受取人名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari4</td><td>（証券）受取人分割割合４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn5</td><td>（証券）受取人見出し区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn5</td><td>（証券）受取人区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm5</td><td>（証券）受取人名５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari5</td><td>（証券）受取人分割割合５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn6</td><td>（証券）受取人見出し区分６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn6</td><td>（証券）受取人区分６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm6</td><td>（証券）受取人名６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari6</td><td>（証券）受取人分割割合６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn7</td><td>（証券）受取人見出し区分７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn7</td><td>（証券）受取人区分７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm7</td><td>（証券）受取人名７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari7</td><td>（証券）受取人分割割合７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn8</td><td>（証券）受取人見出し区分８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn8</td><td>（証券）受取人区分８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm8</td><td>（証券）受取人名８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari8</td><td>（証券）受取人分割割合８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn9</td><td>（証券）受取人見出し区分９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn9</td><td>（証券）受取人区分９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm9</td><td>（証券）受取人名９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari9</td><td>（証券）受取人分割割合９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>syoukenuktmidasikbn10</td><td>（証券）受取人見出し区分１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktMidasiKbn C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>syoukenuktkbn10</td><td>（証券）受取人区分１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoukenUktKbn C_SyoukenUktKbn}</td></tr>
 *  <tr><td>syoukenuktnm10</td><td>（証券）受取人名１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoukenuktbnwari10</td><td>（証券）受取人分割割合１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>pmsgcd1</td><td>保険料メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmsgcd2</td><td>保険料メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pmsgcd3</td><td>保険料メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ptuukatype</td><td>保険料通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ptuuka</td><td>保険料通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ptokuyakumsgcd</td><td>保険料特約メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>phrkkknmidasikbn</td><td>保険料払込期間見出し区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkknmsgkbn</td><td>払込期間メッセージ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuumsgkbn</td><td>払込回数メッセージ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkitukimsgkbn</td><td>払込期月メッセージ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkhouhoumsgkbn</td><td>払込方法メッセージ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykrenban1</td><td>主契約特約連番１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn1</td><td>主契約特約メッセージ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn1</td><td>主契約特約保険金額メッセージ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn1</td><td>主契約特約保険期間メッセージ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype1</td><td>主契約特約保険金額通貨タイプ１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk1</td><td>主契約特約保険金額１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn1</td><td>主契約特約第１保険期間１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn1</td><td>主契約特約第２保険期間１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto1</td><td>主契約特約第１保険期間年月日（至）１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto1</td><td>主契約特約第２保険期間年月日（至）１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban2</td><td>主契約特約連番２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn2</td><td>主契約特約メッセージ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn2</td><td>主契約特約保険金額メッセージ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn2</td><td>主契約特約保険期間メッセージ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype2</td><td>主契約特約保険金額通貨タイプ２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk2</td><td>主契約特約保険金額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn2</td><td>主契約特約第１保険期間２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn2</td><td>主契約特約第２保険期間２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto2</td><td>主契約特約第１保険期間年月日（至）２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto2</td><td>主契約特約第２保険期間年月日（至）２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban3</td><td>主契約特約連番３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn3</td><td>主契約特約メッセージ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn3</td><td>主契約特約保険金額メッセージ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn3</td><td>主契約特約保険期間メッセージ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype3</td><td>主契約特約保険金額通貨タイプ３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk3</td><td>主契約特約保険金額３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn3</td><td>主契約特約第１保険期間３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn3</td><td>主契約特約第２保険期間３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto3</td><td>主契約特約第１保険期間年月日（至）３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto3</td><td>主契約特約第２保険期間年月日（至）３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban4</td><td>主契約特約連番４</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn4</td><td>主契約特約メッセージ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn4</td><td>主契約特約保険金額メッセージ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn4</td><td>主契約特約保険期間メッセージ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype4</td><td>主契約特約保険金額通貨タイプ４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk4</td><td>主契約特約保険金額４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn4</td><td>主契約特約第１保険期間４</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn4</td><td>主契約特約第２保険期間４</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto4</td><td>主契約特約第１保険期間年月日（至）４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto4</td><td>主契約特約第２保険期間年月日（至）４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban5</td><td>主契約特約連番５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn5</td><td>主契約特約メッセージ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn5</td><td>主契約特約保険金額メッセージ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn5</td><td>主契約特約保険期間メッセージ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype5</td><td>主契約特約保険金額通貨タイプ５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk5</td><td>主契約特約保険金額５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn5</td><td>主契約特約第１保険期間５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn5</td><td>主契約特約第２保険期間５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto5</td><td>主契約特約第１保険期間年月日（至）５</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto5</td><td>主契約特約第２保険期間年月日（至）５</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban6</td><td>主契約特約連番６</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn6</td><td>主契約特約メッセージ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn6</td><td>主契約特約保険金額メッセージ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn6</td><td>主契約特約保険期間メッセージ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype6</td><td>主契約特約保険金額通貨タイプ６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk6</td><td>主契約特約保険金額６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn6</td><td>主契約特約第１保険期間６</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn6</td><td>主契約特約第２保険期間６</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto6</td><td>主契約特約第１保険期間年月日（至）６</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto6</td><td>主契約特約第２保険期間年月日（至）６</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban7</td><td>主契約特約連番７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn7</td><td>主契約特約メッセージ区分７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn7</td><td>主契約特約保険金額メッセージ区分７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn7</td><td>主契約特約保険期間メッセージ区分７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype7</td><td>主契約特約保険金額通貨タイプ７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk7</td><td>主契約特約保険金額７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn7</td><td>主契約特約第１保険期間７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn7</td><td>主契約特約第２保険期間７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto7</td><td>主契約特約第１保険期間年月日（至）７</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto7</td><td>主契約特約第２保険期間年月日（至）７</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban8</td><td>主契約特約連番８</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn8</td><td>主契約特約メッセージ区分８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn8</td><td>主契約特約保険金額メッセージ区分８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn8</td><td>主契約特約保険期間メッセージ区分８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype8</td><td>主契約特約保険金額通貨タイプ８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk8</td><td>主契約特約保険金額８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn8</td><td>主契約特約第１保険期間８</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn8</td><td>主契約特約第２保険期間８</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto8</td><td>主契約特約第１保険期間年月日（至）８</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto8</td><td>主契約特約第２保険期間年月日（至）８</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban9</td><td>主契約特約連番９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn9</td><td>主契約特約メッセージ区分９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn9</td><td>主契約特約保険金額メッセージ区分９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn9</td><td>主契約特約保険期間メッセージ区分９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype9</td><td>主契約特約保険金額通貨タイプ９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk9</td><td>主契約特約保険金額９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn9</td><td>主契約特約第１保険期間９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn9</td><td>主契約特約第２保険期間９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto9</td><td>主契約特約第１保険期間年月日（至）９</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto9</td><td>主契約特約第２保険期間年月日（至）９</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukyktkykrenban10</td><td>主契約特約連番１０</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykmsgkbn10</td><td>主契約特約メッセージ区分１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkyksmsgkbn10</td><td>主契約特約保険金額メッセージ区分１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykhknkknmsgkbn10</td><td>主契約特約保険期間メッセージ区分１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukyktkykstuukatype10</td><td>主契約特約保険金額通貨タイプ１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukyktkykhknkngk10</td><td>主契約特約保険金額１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukyktkykdai1hknkkn10</td><td>主契約特約第１保険期間１０</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukyktkykdai2hknkkn10</td><td>主契約特約第２保険期間１０</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syutkdai1hknkknymdto10</td><td>主契約特約第１保険期間年月日（至）１０</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkdai2hknkknymdto10</td><td>主契約特約第２保険期間年月日（至）１０</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykniyustmsgcd1</td><td>契約内容欄下メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd2</td><td>契約内容欄下メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd3</td><td>契約内容欄下メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd4</td><td>契約内容欄下メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd5</td><td>契約内容欄下メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd6</td><td>契約内容欄下メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd7</td><td>契約内容欄下メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd8</td><td>契約内容欄下メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd9</td><td>契約内容欄下メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd10</td><td>契約内容欄下メッセージコード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd11</td><td>契約内容欄下メッセージコード１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd12</td><td>契約内容欄下メッセージコード１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd13</td><td>契約内容欄下メッセージコード１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd14</td><td>契約内容欄下メッセージコード１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustmsgcd15</td><td>契約内容欄下メッセージコード１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyustitjbrptuuktype</td><td>契約内容欄下一時払保険料通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kykniyustitjbrp</td><td>契約内容欄下一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>stnaiyouranmsgcd1</td><td>その他内容欄メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd2</td><td>その他内容欄メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd3</td><td>その他内容欄メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd4</td><td>その他内容欄メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd5</td><td>その他内容欄メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd6</td><td>その他内容欄メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd7</td><td>その他内容欄メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd8</td><td>その他内容欄メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd9</td><td>その他内容欄メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd10</td><td>その他内容欄メッセージコード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd11</td><td>その他内容欄メッセージコード１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd12</td><td>その他内容欄メッセージコード１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd13</td><td>その他内容欄メッセージコード１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd14</td><td>その他内容欄メッセージコード１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd15</td><td>その他内容欄メッセージコード１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd16</td><td>その他内容欄メッセージコード１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd17</td><td>その他内容欄メッセージコード１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd18</td><td>その他内容欄メッセージコード１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd19</td><td>その他内容欄メッセージコード１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stnaiyouranmsgcd20</td><td>その他内容欄メッセージコード２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sonotanyransiteituuka</td><td>その他内容欄指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sonotanyrannykntuktype</td><td>その他内容欄入金通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>sonotanyrannykntuukap</td><td>その他内容欄入金通貨保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotanyrannykntuukasyu</td><td>その他内容欄入金通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sonotanyranenkhrikmrate</td><td>その他内容欄円貨払込特約レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyranstigikwsrate</td><td>その他内容欄指定外通貨払込特約レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyrankjnkngktuktype</td><td>その他内容欄基準金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>sonotanyrankjnkngk</td><td>その他内容欄基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotanyrankjnkngkrate</td><td>その他内容欄基準金額換算レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyrankjnkngktuuka</td><td>その他内容欄基準金額通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sonotanyranpentuktype</td><td>その他内容欄保険料円換算通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>sonotanyranpenknsngk</td><td>その他内容欄保険料円換算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotanyranmkhwariai</td><td>その他内容欄目標到達割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyranytirrt</td><td>その他内容欄予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyransjkkktusirrt</td><td>その他内容欄市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>stnaiyourangaimsgcd</td><td>その他内容欄外メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsnmkj</td><td>送付先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tnknmissmsg</td><td>転換ミスメッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>errormsgcd</td><td>エラーメッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisyacd</td><td>支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhutusnrntousaadrmsgcd</td><td>同封通信欄当社住所メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhutusnrnsyono</td><td>同封通信欄証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>channelcd</td><td>チャネルコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Channelcd C_Channelcd}</td></tr>
 *  <tr><td>dairitenmidasikbn</td><td>代理店見出し区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtennm1kj</td><td>代理店名１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtennm2kj</td><td>代理店名２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisatumsgcd</td><td>挨拶メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ccmsgcd</td><td>コールセンターメッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hskmsgcd</td><td>補足メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hosyounymsgcd</td><td>保障内容メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hosyounyhihknsyameikanji</td><td>保障内容被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboumidasimsgcd</td><td>死亡保障見出しメッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboumidasimsgcd2</td><td>死亡保障見出しメッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknmsgcd1</td><td>死亡保障第１保険期間メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknmsgcd2</td><td>死亡保障第１保険期間メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknigimsgcd</td><td>死亡保障第１保険期間不慮以外Ｓ表メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknigimsgcd2</td><td>死亡保障第１保険期間不慮以外Ｓ表メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknhrsmsgcd</td><td>死亡保障第１保険期間不慮Ｓ表メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknhrsmsgcd2</td><td>死亡保障第１保険期間不慮Ｓ表メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkknsmrmsgcd</td><td>死亡保障第１保険期間Ｓ表丸印メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai2hknkknmsgcd1</td><td>死亡保障第２保険期間メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai2hknkknmsgcd2</td><td>死亡保障第２保険期間メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai2hknkknsmsgcd</td><td>死亡保障第２保険期間Ｓ表メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai2hknkknsmsgcd2</td><td>死亡保障第２保険期間Ｓ表メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai3hknkknmsgcd1</td><td>死亡保障第３保険期間メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai3hknkknmsgcd2</td><td>死亡保障第３保険期間メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboudai1hknkkn</td><td>死亡保障第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>siboudai1hknkknymdto</td><td>死亡保障第１保険期間年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sibouitjbrpyentuuktype</td><td>死亡保障一時払保険料相当円換算額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>sibouitjbrpyentuukgk</td><td>死亡保障一時払保険料相当円換算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>siboudai1kjnkngktuuktype</td><td>死亡保障第１基準金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siboudai1kjnkngk</td><td>死亡保障第１基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>siboudai2hknkkn</td><td>死亡保障第２保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>siboudai2hknkknymdto</td><td>死亡保障第２保険期間年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>siboudai2kjnkngktuuktype</td><td>死亡保障第２基準金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siboudai2kjnkngk</td><td>死亡保障第２基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>siboudai3kjnkngktuuktype</td><td>死亡保障第３基準金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>siboudai3kjnkngk</td><td>死亡保障第３基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skwsrateyendaka</td><td>第１死亡保険金額為替レート（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai1skwsrateyenkijyun</td><td>第１死亡保険金額為替レート（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai1skwsrateyenyasu</td><td>第１死亡保険金額為替レート（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>dai1skeikanensuu01</td><td>第１死亡保険金額経過年数０１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd01</td><td>第１死亡保険金額年単位応当年月日０１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype01</td><td>第１死亡保険金額通貨タイプ０１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s01</td><td>第１死亡保険金額０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu01</td><td>第１死亡保険金額（円貨）（円高）丸印有無０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu01</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu01</td><td>第１死亡保険金額（円貨）（円安）丸印有無０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype01</td><td>第１死亡保険金額（円貨）通貨タイプ０１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka01</td><td>第１死亡保険金額（円貨）（円高）０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun01</td><td>第１死亡保険金額（円貨）（中央値）０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu01</td><td>第１死亡保険金額（円貨）（円安）０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu02</td><td>第１死亡保険金額経過年数０２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd02</td><td>第１死亡保険金額年単位応当年月日０２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype02</td><td>第１死亡保険金額通貨タイプ０２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s02</td><td>第１死亡保険金額０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu02</td><td>第１死亡保険金額（円貨）（円高）丸印有無０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu02</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu02</td><td>第１死亡保険金額（円貨）（円安）丸印有無０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype02</td><td>第１死亡保険金額（円貨）通貨タイプ０２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka02</td><td>第１死亡保険金額（円貨）（円高）０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun02</td><td>第１死亡保険金額（円貨）（中央値）０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu02</td><td>第１死亡保険金額（円貨）（円安）０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu03</td><td>第１死亡保険金額経過年数０３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd03</td><td>第１死亡保険金額年単位応当年月日０３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype03</td><td>第１死亡保険金額通貨タイプ０３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s03</td><td>第１死亡保険金額０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu03</td><td>第１死亡保険金額（円貨）（円高）丸印有無０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu03</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu03</td><td>第１死亡保険金額（円貨）（円安）丸印有無０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype03</td><td>第１死亡保険金額（円貨）通貨タイプ０３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka03</td><td>第１死亡保険金額（円貨）（円高）０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun03</td><td>第１死亡保険金額（円貨）（中央値）０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu03</td><td>第１死亡保険金額（円貨）（円安）０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu04</td><td>第１死亡保険金額経過年数０４</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd04</td><td>第１死亡保険金額年単位応当年月日０４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype04</td><td>第１死亡保険金額通貨タイプ０４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s04</td><td>第１死亡保険金額０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu04</td><td>第１死亡保険金額（円貨）（円高）丸印有無０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu04</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu04</td><td>第１死亡保険金額（円貨）（円安）丸印有無０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype04</td><td>第１死亡保険金額（円貨）通貨タイプ０４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka04</td><td>第１死亡保険金額（円貨）（円高）０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun04</td><td>第１死亡保険金額（円貨）（中央値）０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu04</td><td>第１死亡保険金額（円貨）（円安）０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu05</td><td>第１死亡保険金額経過年数０５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd05</td><td>第１死亡保険金額年単位応当年月日０５</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype05</td><td>第１死亡保険金額通貨タイプ０５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s05</td><td>第１死亡保険金額０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu05</td><td>第１死亡保険金額（円貨）（円高）丸印有無０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu05</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu05</td><td>第１死亡保険金額（円貨）（円安）丸印有無０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype05</td><td>第１死亡保険金額（円貨）通貨タイプ０５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka05</td><td>第１死亡保険金額（円貨）（円高）０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun05</td><td>第１死亡保険金額（円貨）（中央値）０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu05</td><td>第１死亡保険金額（円貨）（円安）０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu06</td><td>第１死亡保険金額経過年数０６</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd06</td><td>第１死亡保険金額年単位応当年月日０６</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype06</td><td>第１死亡保険金額通貨タイプ０６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s06</td><td>第１死亡保険金額０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu06</td><td>第１死亡保険金額（円貨）（円高）丸印有無０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu06</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu06</td><td>第１死亡保険金額（円貨）（円安）丸印有無０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype06</td><td>第１死亡保険金額（円貨）通貨タイプ０６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka06</td><td>第１死亡保険金額（円貨）（円高）０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun06</td><td>第１死亡保険金額（円貨）（中央値）０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu06</td><td>第１死亡保険金額（円貨）（円安）０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu07</td><td>第１死亡保険金額経過年数０７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd07</td><td>第１死亡保険金額年単位応当年月日０７</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype07</td><td>第１死亡保険金額通貨タイプ０７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s07</td><td>第１死亡保険金額０７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu07</td><td>第１死亡保険金額（円貨）（円高）丸印有無０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu07</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu07</td><td>第１死亡保険金額（円貨）（円安）丸印有無０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype07</td><td>第１死亡保険金額（円貨）通貨タイプ０７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka07</td><td>第１死亡保険金額（円貨）（円高）０７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun07</td><td>第１死亡保険金額（円貨）（中央値）０７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu07</td><td>第１死亡保険金額（円貨）（円安）０７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu08</td><td>第１死亡保険金額経過年数０８</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd08</td><td>第１死亡保険金額年単位応当年月日０８</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype08</td><td>第１死亡保険金額通貨タイプ０８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s08</td><td>第１死亡保険金額０８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu08</td><td>第１死亡保険金額（円貨）（円高）丸印有無０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu08</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu08</td><td>第１死亡保険金額（円貨）（円安）丸印有無０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype08</td><td>第１死亡保険金額（円貨）通貨タイプ０８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka08</td><td>第１死亡保険金額（円貨）（円高）０８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun08</td><td>第１死亡保険金額（円貨）（中央値）０８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu08</td><td>第１死亡保険金額（円貨）（円安）０８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu09</td><td>第１死亡保険金額経過年数０９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd09</td><td>第１死亡保険金額年単位応当年月日０９</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype09</td><td>第１死亡保険金額通貨タイプ０９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s09</td><td>第１死亡保険金額０９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu09</td><td>第１死亡保険金額（円貨）（円高）丸印有無０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu09</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu09</td><td>第１死亡保険金額（円貨）（円安）丸印有無０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype09</td><td>第１死亡保険金額（円貨）通貨タイプ０９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka09</td><td>第１死亡保険金額（円貨）（円高）０９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun09</td><td>第１死亡保険金額（円貨）（中央値）０９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu09</td><td>第１死亡保険金額（円貨）（円安）０９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1skeikanensuu10</td><td>第１死亡保険金額経過年数１０</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1sibousnenoutouymd10</td><td>第１死亡保険金額年単位応当年月日１０</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dai1stuuktype10</td><td>第１死亡保険金額通貨タイプ１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1s10</td><td>第１死亡保険金額１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumu10</td><td>第１死亡保険金額（円貨）（円高）丸印有無１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkijyunumu10</td><td>第１死亡保険金額（円貨）（中央値）丸印有無１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumu10</td><td>第１死亡保険金額（円貨）（円安）丸印有無１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktype10</td><td>第１死亡保険金額（円貨）通貨タイプ１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendaka10</td><td>第１死亡保険金額（円貨）（円高）１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyun10</td><td>第１死亡保険金額（円貨）（中央値）１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasu10</td><td>第１死亡保険金額（円貨）（円安）１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1stuuktypehuryo</td><td>第１死亡保険金額通貨タイプ（不慮）</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1shuryo</td><td>第１死亡保険金額（不慮）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyendakaumuhuryo</td><td>第１死亡保険金額（円貨）（円高）丸印有無（不慮）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenkjnumuhuryo</td><td>第１死亡保険金額（円貨）（中央値）丸印有無（不慮）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syenyenyasuumuhuryo</td><td>第１死亡保険金額（円貨）（円安）丸印有無（不慮）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai1syentuuktypehuryo</td><td>第１死亡保険金額（円貨）通貨タイプ（不慮）</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai1syenyendakahuryo</td><td>第１死亡保険金額（円貨）（円高）（不慮）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenkijyunhuryo</td><td>第１死亡保険金額（円貨）（中央値）（不慮）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai1syenyenyasuhuryo</td><td>第１死亡保険金額（円貨）（円安）（不慮）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai2stuuktype</td><td>第２死亡保険金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai2s</td><td>第２死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai2syentuuktype</td><td>第２死亡保険金額（円貨）通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai2syenyendaka</td><td>第２死亡保険金額（円貨）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai2syenyenkijyun</td><td>第２死亡保険金額（円貨）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai2syenyenyasu</td><td>第２死亡保険金額（円貨）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai3stuuktype</td><td>第３死亡保険金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai3s</td><td>第３死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai3syentuuktype</td><td>第３死亡保険金額（円貨）通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dai3syenyendaka</td><td>第３死亡保険金額（円貨）（円高）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai3syenyenkijyun</td><td>第３死亡保険金額（円貨）（中央値）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dai3syenyenyasu</td><td>第３死亡保険金額（円貨）（円安）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sibouinjiptnkbn</td><td>死亡保障印字パターン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mkhyouyensysnikoumsgcd</td><td>目標到達時円建終身保険移行特約メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mkhyouyensysnikoumsgcd2</td><td>目標到達時円建終身保険移行特約メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mkhyouyensysnikoumsgcd3</td><td>目標到達時円建終身保険移行特約メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mkhyouyensysnikougktype</td><td>目標到達時円建終身保険移行特約目標額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>mkhyouyensysnikougk</td><td>目標到達時円建終身保険移行特約目標額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mkhyouyensysnikouwra</td><td>目標到達時円建終身保険移行特約目標割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrtkykmsgcd1</td><td>介護前払特約メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehrtkykmsgcd2</td><td>介護前払特約メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehrtkykmsgcdst1</td><td>介護前払特約メッセージコード表下１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehrtkykmsgcdst2</td><td>介護前払特約メッセージコード表下２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehruktgkumu</td><td>介護前払特約受取額一覧有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehrtkykkyktuuka</td><td>介護前払特約契約通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehrtkykstdmsgcd</td><td>介護前払特約指定代理メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaigomaehrjrugktype</td><td>介護前払受領額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen01</td><td>介護前払請求日時点被保険者年齢０１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn01</td><td>介護前払所定期間０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk01</td><td>介護前払受領額０１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen02</td><td>介護前払請求日時点被保険者年齢０２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn02</td><td>介護前払所定期間０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk02</td><td>介護前払受領額０２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen03</td><td>介護前払請求日時点被保険者年齢０３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn03</td><td>介護前払所定期間０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk03</td><td>介護前払受領額０３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen04</td><td>介護前払請求日時点被保険者年齢０４</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn04</td><td>介護前払所定期間０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk04</td><td>介護前払受領額０４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen05</td><td>介護前払請求日時点被保険者年齢０５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn05</td><td>介護前払所定期間０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk05</td><td>介護前払受領額０５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen06</td><td>介護前払請求日時点被保険者年齢０６</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn06</td><td>介護前払所定期間０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk06</td><td>介護前払受領額０６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen07</td><td>介護前払請求日時点被保険者年齢０７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn07</td><td>介護前払所定期間０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk07</td><td>介護前払受領額０７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen08</td><td>介護前払請求日時点被保険者年齢０８</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn08</td><td>介護前払所定期間０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk08</td><td>介護前払受領額０８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen09</td><td>介護前払請求日時点被保険者年齢０９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn09</td><td>介護前払所定期間０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk09</td><td>介護前払受領額０９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaigomaehrsikuhhknnen10</td><td>介護前払請求日時点被保険者年齢１０</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kaigomaehrstikkn10</td><td>介護前払所定期間１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaigomaehrjrugk10</td><td>介護前払受領額１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hutanhiyustmmsgcdue01</td><td>ご負担費用説明欄メッセージコード表上１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmmsgcdue02</td><td>ご負担費用説明欄メッセージコード表上２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmmsgcdue03</td><td>ご負担費用説明欄メッセージコード表上３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmmsgcdue04</td><td>ご負担費用説明欄メッセージコード表上４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmknsnhyuptn</td><td>ご負担費用説明欄換算費用パターン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmmsgcdst01</td><td>ご負担費用説明欄メッセージコード表下１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmmsgcdst02</td><td>ご負担費用説明欄メッセージコード表下２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmmsgcdst03</td><td>ご負担費用説明欄メッセージコード表下３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdstmmsgcd</td><td>指定代理請求特約説明欄メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fstpmsgcd</td><td>初回Ｐご確認欄メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fstphrkpkngkkeituuktype</td><td>初回Ｐご確認欄払込保険料合計通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>fstphrkpkngkkei</td><td>初回Ｐご確認欄払込保険料合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>fstponegaimsgcd</td><td>初回Ｐご確認欄お願いメッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dsmsgcd</td><td>スミセイダイレクトサービスメッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnhutaimsgcd1</td><td>商品付帯サービスメッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnhutaimsgcd2</td><td>商品付帯サービスメッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pyentuuktype</td><td>保険料円換算額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>pyen</td><td>保険料円換算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>toiawasesakihanyoumsgcd</td><td>問合せ先汎用メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>annaihanyoumsgcd</td><td>案内汎用メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd1</td><td>解約返戻金メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd2</td><td>解約返戻金メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd3</td><td>解約返戻金メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd1</td><td>解約返戻金注意事項メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd2</td><td>解約返戻金注意事項メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd3</td><td>解約返戻金注意事項メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd4</td><td>解約返戻金注意事項メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd5</td><td>解約返戻金注意事項メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>witijibrptuktype</td><td>解約返戻金一時払保険料通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>witijibrp</td><td>解約返戻金一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>wyenhrkgktuktype</td><td>解約返戻金円貨払込額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>wyenhrkgk</td><td>解約返戻金円貨払込額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>wyenitijibrptuktype</td><td>解約返戻金円換算一時払保険料通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>wyenitijibrp</td><td>解約返戻金円換算一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>koujyosyoumeimsgcd1</td><td>控除証明説明メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>koujyosyoumeimsgcd2</td><td>控除証明説明メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>koujyosyoumeimsgcd3</td><td>控除証明説明メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>koujyosyoumeihskmsgcd</td><td>控除証明補足メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkoujyosyoumeihskmsgcd</td><td>年間控除証明補足メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn1</td><td>特殊処理内容区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn2</td><td>特殊処理内容区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn3</td><td>特殊処理内容区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn4</td><td>特殊処理内容区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn5</td><td>特殊処理内容区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn6</td><td>特殊処理内容区分６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn7</td><td>特殊処理内容区分７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn8</td><td>特殊処理内容区分８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn9</td><td>特殊処理内容区分９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn10</td><td>特殊処理内容区分１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn11</td><td>特殊処理内容区分１１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn12</td><td>特殊処理内容区分１２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn13</td><td>特殊処理内容区分１３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn14</td><td>特殊処理内容区分１４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn15</td><td>特殊処理内容区分１５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn16</td><td>特殊処理内容区分１６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>tokusyusyorinaiyoukbn17</td><td>特殊処理内容区分１７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokusyuSyoriNaiyouKbn C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sonotanyrannkshrstartymd</td><td>その他内容欄年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sonotanyrannenkinkkn</td><td>その他内容欄年金期間</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyranyensysnhkhnkymd</td><td>その他内容欄円建終身保険変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sonotanyrantumitateriritu</td><td>その他内容欄積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyrantmttknzkrtjygn</td><td>その他内容欄積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyransetteibairitu</td><td>その他内容欄設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sonotanyrantmttkngktuktype</td><td>その他内容欄積立金額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sonotanyranteiritutmttkngk</td><td>その他内容欄定率積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotanyransisuutmttkngk</td><td>その他内容欄指数積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotanyransisuunm</td><td>その他内容欄指数名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kgmaehrtkdai1hknkknmnryymd</td><td>介護前払特約第１保険期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkmsgcd1</td><td>年金メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd2</td><td>年金メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd3</td><td>年金メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd4</td><td>年金メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd5</td><td>年金メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd6</td><td>年金メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd7</td><td>年金メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd8</td><td>年金メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd9</td><td>年金メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkmsgcd10</td><td>年金メッセージコード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd1</td><td>死亡給付金メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd2</td><td>死亡給付金メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd3</td><td>死亡給付金メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd4</td><td>死亡給付金メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd5</td><td>死亡給付金メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd6</td><td>死亡給付金メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd7</td><td>死亡給付金メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd8</td><td>死亡給付金メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd9</td><td>死亡給付金メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siboukyuuhukinmsgcd10</td><td>死亡給付金メッセージコード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkshrstartzenymd</td><td>年金支払開始日前日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mkhyouyennkhknhentktype</td><td>目標到達時円建年金保険変更特約目標額通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mkhyouyennkhknhentkmkhgk</td><td>目標到達時円建年金保険変更特約目標額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mkhyouyennkhknhentkmkhwari</td><td>目標到達時円建年金保険変更特約目標割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>haibunwarimsgcd1</td><td>配分割合メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haibunwarimsgcd2</td><td>配分割合メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haibunwarimsgcd3</td><td>配分割合メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teiritutmtthbnwr</td><td>定率積立部分配分割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisuutmtthbnwr</td><td>指数積立部分配分割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisuuannaimsg1</td><td>指数案内メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisuuannaimsg2</td><td>指数案内メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisuuannaimsg3</td><td>指数案内メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hutanhiyustmytijihiritu</td><td>ご負担費用説明欄予定維持費率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wmsgcd21</td><td>解約返戻金メッセージコード２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd22</td><td>解約返戻金メッセージコード２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd23</td><td>解約返戻金メッセージコード２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd31</td><td>解約返戻金メッセージコード３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd32</td><td>解約返戻金メッセージコード３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcd33</td><td>解約返戻金メッセージコード３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wmsgcdst1</td><td>解約返戻金メッセージコード表下１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd6</td><td>解約返戻金注意事項メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wtyuuijikoumsgcd7</td><td>解約返戻金注意事項メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>phrkktuki</td><td>保険料払込期月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakkanjyuryouhoukbn</td><td>約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YakkanJyuryouKbn C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>yakkanbunsyono</td><td>約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siorino</td><td>しおり番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sioriwebuktriannaimsgcd</td><td>しおりＷＥＢ受取案内メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sagyoukbn</td><td>作業区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisuuupkaisuu</td><td>指数上昇回数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sisuudownkaisuu</td><td>指数下落回数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     IT_HokenSyouken
 * @see     GenIT_HokenSyouken
 * @see     QIT_HokenSyouken
 * @see     GenQIT_HokenSyouken
 */
public class PKIT_HokenSyouken extends AbstractExDBPrimaryKey<IT_HokenSyouken, PKIT_HokenSyouken> {

    private static final long serialVersionUID = 1L;

    public PKIT_HokenSyouken() {
    }

    public PKIT_HokenSyouken(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<IT_HokenSyouken> getEntityClass() {
        return IT_HokenSyouken.class;
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
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

}