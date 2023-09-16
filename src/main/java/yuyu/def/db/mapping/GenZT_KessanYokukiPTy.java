package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KessanYokukiPTy;
import yuyu.def.db.id.PKZT_KessanYokukiPTy;
import yuyu.def.db.meta.GenQZT_KessanYokukiPTy;
import yuyu.def.db.meta.QZT_KessanYokukiPTy;

/**
 * 決算用翌期Ｐテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KessanYokukiPTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanYokukiPTy}</td><td colspan="3">決算用翌期Ｐテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">{@link PKZT_KessanYokukiPTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KessanYokukiPTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennyknmonth ztyzennyknmonth}</td><td>（中継用）前回入金月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzenyuukinymd ztyzenyuukinymd}</td><td>（中継用）前回入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjidoukousinhyouji ztyjidoukousinhyouji}</td><td>（中継用）自動更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanhyouji ztytenkanhyouji}</td><td>（中継用）転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouikkatumnoshyouji ztyhosyouikkatumnoshyouji}</td><td>（中継用）保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobi01xv40 ztyyobi01xv40}</td><td>（中継用）予備０１＿Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkkzkp ztytkkzkp}</td><td>（中継用）特約継続Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeizokuphurikaekngk ztykeizokuphurikaekngk}</td><td>（中継用）継続Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeizokuphurikaekaisiym ztykeizokuphurikaekaisiym}</td><td>（中継用）継続Ｐ振替開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikomipannaisaikaiym ztyharaikomipannaisaikaiym}</td><td>（中継用）払込Ｐ案内再開年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkkzkkouryokukaisiymd ztytkkzkkouryokukaisiymd}</td><td>（中継用）特約継続効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykpjyuutouhoukbn ztyhrimngtkykpjyuutouhoukbn}</td><td>（中継用）払満後特約Ｐ充当方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjkitkpjytym ztyjkitkpjytym}</td><td>（中継用）次回特約Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrzugktkp ztyitijibrzugktkp}</td><td>（中継用）一時払増額特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtypazukarikingk ztypazukarikingk}</td><td>（中継用）Ｐ預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennoukbn ztyzennoukbn}</td><td>（中継用）前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukaisiymd ztyzennoukaisiymd}</td><td>（中継用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennounyuukinymd ztyzennounyuukinymd}</td><td>（中継用）前納入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokukipbunruicd ztyyokukipbunruicd}</td><td>（中継用）翌期Ｐ分類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd1 ztymisyoricd1}</td><td>（中継用）未処理コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd2 ztymisyoricd2}</td><td>（中継用）未処理コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd3 ztymisyoricd3}</td><td>（中継用）未処理コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd4 ztymisyoricd4}</td><td>（中継用）未処理コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd5 ztymisyoricd5}</td><td>（中継用）未処理コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd6 ztymisyoricd6}</td><td>（中継用）未処理コード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd7 ztymisyoricd7}</td><td>（中継用）未処理コード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd8 ztymisyoricd8}</td><td>（中継用）未処理コード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd9 ztymisyoricd9}</td><td>（中継用）未処理コード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyoricd10 ztymisyoricd10}</td><td>（中継用）未処理コード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobi02xv39 ztyyobi02xv39}</td><td>（中継用）予備０２＿Ｖ３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakum ztykeiyakum}</td><td>（中継用）契約月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyiktyknndp ztyiktyknndp}</td><td>（中継用）一括払翌年度保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykigetumaenyknyknndp ztykigetumaenyknyknndp}</td><td>（中継用）期月前入金翌年度保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyknndpkei ztyyknndpkei}</td><td>（中継用）翌年度保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobi03xn15 ztyyobi03xn15}</td><td>（中継用）予備０３＿Ｎ１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobi04xv23 ztyyobi04xv23}</td><td>（中継用）予備０４＿Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanYokukiPTy
 * @see     PKZT_KessanYokukiPTy
 * @see     QZT_KessanYokukiPTy
 * @see     GenQZT_KessanYokukiPTy
 */
@MappedSuperclass
@Table(name=GenZT_KessanYokukiPTy.TABLE_NAME)
@IdClass(value=PKZT_KessanYokukiPTy.class)
public abstract class GenZT_KessanYokukiPTy extends AbstractExDBEntity<ZT_KessanYokukiPTy, PKZT_KessanYokukiPTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KessanYokukiPTy";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYZENNYKNMONTH          = "ztyzennyknmonth";
    public static final String ZTYZENYUUKINYMD          = "ztyzenyuukinymd";
    public static final String ZTYJIDOUKOUSINHYOUJI     = "ztyjidoukousinhyouji";
    public static final String ZTYTENKANHYOUJI          = "ztytenkanhyouji";
    public static final String ZTYHOSYOUIKKATUMNOSHYOUJI = "ztyhosyouikkatumnoshyouji";
    public static final String ZTYYOBI01XV40            = "ztyyobi01xv40";
    public static final String ZTYTKKZKP                = "ztytkkzkp";
    public static final String ZTYKEIZOKUPHURIKAEKNGK   = "ztykeizokuphurikaekngk";
    public static final String ZTYKEIZOKUPHURIKAEKAISIYM = "ztykeizokuphurikaekaisiym";
    public static final String ZTYHARAIKOMIPANNAISAIKAIYM = "ztyharaikomipannaisaikaiym";
    public static final String ZTYTKKZKKOURYOKUKAISIYMD = "ztytkkzkkouryokukaisiymd";
    public static final String ZTYHRIMNGTKYKPJYUUTOUHOUKBN = "ztyhrimngtkykpjyuutouhoukbn";
    public static final String ZTYJKITKPJYTYM           = "ztyjkitkpjytym";
    public static final String ZTYITIJIBRZUGKTKP        = "ztyitijibrzugktkp";
    public static final String ZTYPAZUKARIKINGK         = "ztypazukarikingk";
    public static final String ZTYZENNOUKBN             = "ztyzennoukbn";
    public static final String ZTYZENNOUKAISIYMD        = "ztyzennoukaisiymd";
    public static final String ZTYZENNOUNYUUKINYMD      = "ztyzennounyuukinymd";
    public static final String ZTYYOKUKIPBUNRUICD       = "ztyyokukipbunruicd";
    public static final String ZTYMISYORICD1            = "ztymisyoricd1";
    public static final String ZTYMISYORICD2            = "ztymisyoricd2";
    public static final String ZTYMISYORICD3            = "ztymisyoricd3";
    public static final String ZTYMISYORICD4            = "ztymisyoricd4";
    public static final String ZTYMISYORICD5            = "ztymisyoricd5";
    public static final String ZTYMISYORICD6            = "ztymisyoricd6";
    public static final String ZTYMISYORICD7            = "ztymisyoricd7";
    public static final String ZTYMISYORICD8            = "ztymisyoricd8";
    public static final String ZTYMISYORICD9            = "ztymisyoricd9";
    public static final String ZTYMISYORICD10           = "ztymisyoricd10";
    public static final String ZTYYOBI02XV39            = "ztyyobi02xv39";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYKEIYAKUM              = "ztykeiyakum";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYIKTYKNNDP             = "ztyiktyknndp";
    public static final String ZTYKIGETUMAENYKNYKNNDP   = "ztykigetumaenyknyknndp";
    public static final String ZTYYKNNDPKEI             = "ztyyknndpkei";
    public static final String ZTYYOBI03XN15            = "ztyyobi03xn15";
    public static final String ZTYYOBI04XV23            = "ztyyobi04xv23";

    private final PKZT_KessanYokukiPTy primaryKey;

    public GenZT_KessanYokukiPTy() {
        primaryKey = new PKZT_KessanYokukiPTy();
    }

    public GenZT_KessanYokukiPTy(String pZtykeijyouym, String pZtysyono) {
        primaryKey = new PKZT_KessanYokukiPTy(pZtykeijyouym, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_KessanYokukiPTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KessanYokukiPTy> getMetaClass() {
        return QZT_KessanYokukiPTy.class;
    }

    @Id
    @Column(name=GenZT_KessanYokukiPTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return getPrimaryKey().getZtykeijyouym();
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        getPrimaryKey().setZtykeijyouym(pZtykeijyouym);
    }

    @Id
    @Column(name=GenZT_KessanYokukiPTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_KessanYokukiPTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private Long ztyharaikomip;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_KessanYokukiPTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztyzennyknmonth;

    @Column(name=GenZT_KessanYokukiPTy.ZTYZENNYKNMONTH)
    public Long getZtyzennyknmonth() {
        return ztyzennyknmonth;
    }

    public void setZtyzennyknmonth(Long pZtyzennyknmonth) {
        ztyzennyknmonth = pZtyzennyknmonth;
    }

    private String ztyzenyuukinymd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYZENYUUKINYMD)
    public String getZtyzenyuukinymd() {
        return ztyzenyuukinymd;
    }

    public void setZtyzenyuukinymd(String pZtyzenyuukinymd) {
        ztyzenyuukinymd = pZtyzenyuukinymd;
    }

    private String ztyjidoukousinhyouji;

    @Column(name=GenZT_KessanYokukiPTy.ZTYJIDOUKOUSINHYOUJI)
    public String getZtyjidoukousinhyouji() {
        return ztyjidoukousinhyouji;
    }

    public void setZtyjidoukousinhyouji(String pZtyjidoukousinhyouji) {
        ztyjidoukousinhyouji = pZtyjidoukousinhyouji;
    }

    private String ztytenkanhyouji;

    @Column(name=GenZT_KessanYokukiPTy.ZTYTENKANHYOUJI)
    public String getZtytenkanhyouji() {
        return ztytenkanhyouji;
    }

    public void setZtytenkanhyouji(String pZtytenkanhyouji) {
        ztytenkanhyouji = pZtytenkanhyouji;
    }

    private String ztyhosyouikkatumnoshyouji;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHOSYOUIKKATUMNOSHYOUJI)
    public String getZtyhosyouikkatumnoshyouji() {
        return ztyhosyouikkatumnoshyouji;
    }

    public void setZtyhosyouikkatumnoshyouji(String pZtyhosyouikkatumnoshyouji) {
        ztyhosyouikkatumnoshyouji = pZtyhosyouikkatumnoshyouji;
    }

    private String ztyyobi01xv40;

    @Column(name=GenZT_KessanYokukiPTy.ZTYYOBI01XV40)
    public String getZtyyobi01xv40() {
        return ztyyobi01xv40;
    }

    public void setZtyyobi01xv40(String pZtyyobi01xv40) {
        ztyyobi01xv40 = pZtyyobi01xv40;
    }

    private Long ztytkkzkp;

    @Column(name=GenZT_KessanYokukiPTy.ZTYTKKZKP)
    public Long getZtytkkzkp() {
        return ztytkkzkp;
    }

    public void setZtytkkzkp(Long pZtytkkzkp) {
        ztytkkzkp = pZtytkkzkp;
    }

    private Long ztykeizokuphurikaekngk;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKEIZOKUPHURIKAEKNGK)
    public Long getZtykeizokuphurikaekngk() {
        return ztykeizokuphurikaekngk;
    }

    public void setZtykeizokuphurikaekngk(Long pZtykeizokuphurikaekngk) {
        ztykeizokuphurikaekngk = pZtykeizokuphurikaekngk;
    }

    private String ztykeizokuphurikaekaisiym;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKEIZOKUPHURIKAEKAISIYM)
    public String getZtykeizokuphurikaekaisiym() {
        return ztykeizokuphurikaekaisiym;
    }

    public void setZtykeizokuphurikaekaisiym(String pZtykeizokuphurikaekaisiym) {
        ztykeizokuphurikaekaisiym = pZtykeizokuphurikaekaisiym;
    }

    private String ztyharaikomipannaisaikaiym;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHARAIKOMIPANNAISAIKAIYM)
    public String getZtyharaikomipannaisaikaiym() {
        return ztyharaikomipannaisaikaiym;
    }

    public void setZtyharaikomipannaisaikaiym(String pZtyharaikomipannaisaikaiym) {
        ztyharaikomipannaisaikaiym = pZtyharaikomipannaisaikaiym;
    }

    private String ztytkkzkkouryokukaisiymd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYTKKZKKOURYOKUKAISIYMD)
    public String getZtytkkzkkouryokukaisiymd() {
        return ztytkkzkkouryokukaisiymd;
    }

    public void setZtytkkzkkouryokukaisiymd(String pZtytkkzkkouryokukaisiymd) {
        ztytkkzkkouryokukaisiymd = pZtytkkzkkouryokukaisiymd;
    }

    private String ztyhrimngtkykpjyuutouhoukbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHRIMNGTKYKPJYUUTOUHOUKBN)
    public String getZtyhrimngtkykpjyuutouhoukbn() {
        return ztyhrimngtkykpjyuutouhoukbn;
    }

    public void setZtyhrimngtkykpjyuutouhoukbn(String pZtyhrimngtkykpjyuutouhoukbn) {
        ztyhrimngtkykpjyuutouhoukbn = pZtyhrimngtkykpjyuutouhoukbn;
    }

    private String ztyjkitkpjytym;

    @Column(name=GenZT_KessanYokukiPTy.ZTYJKITKPJYTYM)
    public String getZtyjkitkpjytym() {
        return ztyjkitkpjytym;
    }

    public void setZtyjkitkpjytym(String pZtyjkitkpjytym) {
        ztyjkitkpjytym = pZtyjkitkpjytym;
    }

    private Long ztyitijibrzugktkp;

    @Column(name=GenZT_KessanYokukiPTy.ZTYITIJIBRZUGKTKP)
    public Long getZtyitijibrzugktkp() {
        return ztyitijibrzugktkp;
    }

    public void setZtyitijibrzugktkp(Long pZtyitijibrzugktkp) {
        ztyitijibrzugktkp = pZtyitijibrzugktkp;
    }

    private Long ztypazukarikingk;

    @Column(name=GenZT_KessanYokukiPTy.ZTYPAZUKARIKINGK)
    public Long getZtypazukarikingk() {
        return ztypazukarikingk;
    }

    public void setZtypazukarikingk(Long pZtypazukarikingk) {
        ztypazukarikingk = pZtypazukarikingk;
    }

    private String ztyzennoukbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYZENNOUKBN)
    public String getZtyzennoukbn() {
        return ztyzennoukbn;
    }

    public void setZtyzennoukbn(String pZtyzennoukbn) {
        ztyzennoukbn = pZtyzennoukbn;
    }

    private String ztyzennoukaisiymd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYZENNOUKAISIYMD)
    public String getZtyzennoukaisiymd() {
        return ztyzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyzennoukaisiymd(String pZtyzennoukaisiymd) {
        ztyzennoukaisiymd = pZtyzennoukaisiymd;
    }

    private String ztyzennounyuukinymd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYZENNOUNYUUKINYMD)
    public String getZtyzennounyuukinymd() {
        return ztyzennounyuukinymd;
    }

    public void setZtyzennounyuukinymd(String pZtyzennounyuukinymd) {
        ztyzennounyuukinymd = pZtyzennounyuukinymd;
    }

    private String ztyyokukipbunruicd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYYOKUKIPBUNRUICD)
    public String getZtyyokukipbunruicd() {
        return ztyyokukipbunruicd;
    }

    public void setZtyyokukipbunruicd(String pZtyyokukipbunruicd) {
        ztyyokukipbunruicd = pZtyyokukipbunruicd;
    }

    private String ztymisyoricd1;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD1)
    public String getZtymisyoricd1() {
        return ztymisyoricd1;
    }

    public void setZtymisyoricd1(String pZtymisyoricd1) {
        ztymisyoricd1 = pZtymisyoricd1;
    }

    private String ztymisyoricd2;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD2)
    public String getZtymisyoricd2() {
        return ztymisyoricd2;
    }

    public void setZtymisyoricd2(String pZtymisyoricd2) {
        ztymisyoricd2 = pZtymisyoricd2;
    }

    private String ztymisyoricd3;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD3)
    public String getZtymisyoricd3() {
        return ztymisyoricd3;
    }

    public void setZtymisyoricd3(String pZtymisyoricd3) {
        ztymisyoricd3 = pZtymisyoricd3;
    }

    private String ztymisyoricd4;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD4)
    public String getZtymisyoricd4() {
        return ztymisyoricd4;
    }

    public void setZtymisyoricd4(String pZtymisyoricd4) {
        ztymisyoricd4 = pZtymisyoricd4;
    }

    private String ztymisyoricd5;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD5)
    public String getZtymisyoricd5() {
        return ztymisyoricd5;
    }

    public void setZtymisyoricd5(String pZtymisyoricd5) {
        ztymisyoricd5 = pZtymisyoricd5;
    }

    private String ztymisyoricd6;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD6)
    public String getZtymisyoricd6() {
        return ztymisyoricd6;
    }

    public void setZtymisyoricd6(String pZtymisyoricd6) {
        ztymisyoricd6 = pZtymisyoricd6;
    }

    private String ztymisyoricd7;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD7)
    public String getZtymisyoricd7() {
        return ztymisyoricd7;
    }

    public void setZtymisyoricd7(String pZtymisyoricd7) {
        ztymisyoricd7 = pZtymisyoricd7;
    }

    private String ztymisyoricd8;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD8)
    public String getZtymisyoricd8() {
        return ztymisyoricd8;
    }

    public void setZtymisyoricd8(String pZtymisyoricd8) {
        ztymisyoricd8 = pZtymisyoricd8;
    }

    private String ztymisyoricd9;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD9)
    public String getZtymisyoricd9() {
        return ztymisyoricd9;
    }

    public void setZtymisyoricd9(String pZtymisyoricd9) {
        ztymisyoricd9 = pZtymisyoricd9;
    }

    private String ztymisyoricd10;

    @Column(name=GenZT_KessanYokukiPTy.ZTYMISYORICD10)
    public String getZtymisyoricd10() {
        return ztymisyoricd10;
    }

    public void setZtymisyoricd10(String pZtymisyoricd10) {
        ztymisyoricd10 = pZtymisyoricd10;
    }

    private String ztyyobi02xv39;

    @Column(name=GenZT_KessanYokukiPTy.ZTYYOBI02XV39)
    public String getZtyyobi02xv39() {
        return ztyyobi02xv39;
    }

    public void setZtyyobi02xv39(String pZtyyobi02xv39) {
        ztyyobi02xv39 = pZtyyobi02xv39;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_KessanYokukiPTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztykeiyakum;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKEIYAKUM)
    public String getZtykeiyakum() {
        return ztykeiyakum;
    }

    public void setZtykeiyakum(String pZtykeiyakum) {
        ztykeiyakum = pZtykeiyakum;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_KessanYokukiPTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private Long ztyiktyknndp;

    @Column(name=GenZT_KessanYokukiPTy.ZTYIKTYKNNDP)
    public Long getZtyiktyknndp() {
        return ztyiktyknndp;
    }

    public void setZtyiktyknndp(Long pZtyiktyknndp) {
        ztyiktyknndp = pZtyiktyknndp;
    }

    private Long ztykigetumaenyknyknndp;

    @Column(name=GenZT_KessanYokukiPTy.ZTYKIGETUMAENYKNYKNNDP)
    public Long getZtykigetumaenyknyknndp() {
        return ztykigetumaenyknyknndp;
    }

    public void setZtykigetumaenyknyknndp(Long pZtykigetumaenyknyknndp) {
        ztykigetumaenyknyknndp = pZtykigetumaenyknyknndp;
    }

    private Long ztyyknndpkei;

    @Column(name=GenZT_KessanYokukiPTy.ZTYYKNNDPKEI)
    public Long getZtyyknndpkei() {
        return ztyyknndpkei;
    }

    public void setZtyyknndpkei(Long pZtyyknndpkei) {
        ztyyknndpkei = pZtyyknndpkei;
    }

    private Long ztyyobi03xn15;

    @Column(name=GenZT_KessanYokukiPTy.ZTYYOBI03XN15)
    public Long getZtyyobi03xn15() {
        return ztyyobi03xn15;
    }

    public void setZtyyobi03xn15(Long pZtyyobi03xn15) {
        ztyyobi03xn15 = pZtyyobi03xn15;
    }

    private String ztyyobi04xv23;

    @Column(name=GenZT_KessanYokukiPTy.ZTYYOBI04XV23)
    public String getZtyyobi04xv23() {
        return ztyyobi04xv23;
    }

    public void setZtyyobi04xv23(String pZtyyobi04xv23) {
        ztyyobi04xv23 = pZtyyobi04xv23;
    }
}