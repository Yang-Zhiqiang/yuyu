package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KessanYokukiPRn;
import yuyu.def.db.id.PKZT_KessanYokukiPRn;
import yuyu.def.db.meta.GenQZT_KessanYokukiPRn;
import yuyu.def.db.meta.QZT_KessanYokukiPRn;

/**
 * 決算用翌期Ｐテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KessanYokukiPRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanYokukiPRn}</td><td colspan="3">決算用翌期Ｐテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">{@link PKZT_KessanYokukiPRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KessanYokukiPRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennyknmonth zrnzennyknmonth}</td><td>（連携用）前回入金月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzenyuukinymd zrnzenyuukinymd}</td><td>（連携用）前回入金年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjidoukousinhyouji zrnjidoukousinhyouji}</td><td>（連携用）自動更新表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanhyouji zrntenkanhyouji}</td><td>（連携用）転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouikkatumnoshyouji zrnhosyouikkatumnoshyouji}</td><td>（連携用）保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobi01xv40 zrnyobi01xv40}</td><td>（連携用）予備０１＿Ｖ４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkkzkp zrntkkzkp}</td><td>（連携用）特約継続Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeizokuphurikaekngk zrnkeizokuphurikaekngk}</td><td>（連携用）継続Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeizokuphurikaekaisiym zrnkeizokuphurikaekaisiym}</td><td>（連携用）継続Ｐ振替開始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikomipannaisaikaiym zrnharaikomipannaisaikaiym}</td><td>（連携用）払込Ｐ案内再開年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkkzkkouryokukaisiymd zrntkkzkkouryokukaisiymd}</td><td>（連携用）特約継続効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykpjyuutouhoukbn zrnhrimngtkykpjyuutouhoukbn}</td><td>（連携用）払満後特約Ｐ充当方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjkitkpjytym zrnjkitkpjytym}</td><td>（連携用）次回特約Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrzugktkp zrnitijibrzugktkp}</td><td>（連携用）一時払増額特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnpazukarikingk zrnpazukarikingk}</td><td>（連携用）Ｐ預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennoukbn zrnzennoukbn}</td><td>（連携用）前納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukaisiymd zrnzennoukaisiymd}</td><td>（連携用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennounyuukinymd zrnzennounyuukinymd}</td><td>（連携用）前納入金年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokukipbunruicd zrnyokukipbunruicd}</td><td>（連携用）翌期Ｐ分類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd1 zrnmisyoricd1}</td><td>（連携用）未処理コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd2 zrnmisyoricd2}</td><td>（連携用）未処理コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd3 zrnmisyoricd3}</td><td>（連携用）未処理コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd4 zrnmisyoricd4}</td><td>（連携用）未処理コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd5 zrnmisyoricd5}</td><td>（連携用）未処理コード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd6 zrnmisyoricd6}</td><td>（連携用）未処理コード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd7 zrnmisyoricd7}</td><td>（連携用）未処理コード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd8 zrnmisyoricd8}</td><td>（連携用）未処理コード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd9 zrnmisyoricd9}</td><td>（連携用）未処理コード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyoricd10 zrnmisyoricd10}</td><td>（連携用）未処理コード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobi02xv39 zrnyobi02xv39}</td><td>（連携用）予備０２＿Ｖ３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakum zrnkeiyakum}</td><td>（連携用）契約月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrniktyknndp zrniktyknndp}</td><td>（連携用）一括払翌年度保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkigetumaenyknyknndp zrnkigetumaenyknyknndp}</td><td>（連携用）期月前入金翌年度保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyknndpkei zrnyknndpkei}</td><td>（連携用）翌年度保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobi03xn15 zrnyobi03xn15}</td><td>（連携用）予備０３＿Ｎ１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobi04xv23 zrnyobi04xv23}</td><td>（連携用）予備０４＿Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanYokukiPRn
 * @see     PKZT_KessanYokukiPRn
 * @see     QZT_KessanYokukiPRn
 * @see     GenQZT_KessanYokukiPRn
 */
@MappedSuperclass
@Table(name=GenZT_KessanYokukiPRn.TABLE_NAME)
@IdClass(value=PKZT_KessanYokukiPRn.class)
public abstract class GenZT_KessanYokukiPRn extends AbstractExDBEntityForZDB<ZT_KessanYokukiPRn, PKZT_KessanYokukiPRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KessanYokukiPRn";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNZENNYKNMONTH          = "zrnzennyknmonth";
    public static final String ZRNZENYUUKINYMD          = "zrnzenyuukinymd";
    public static final String ZRNJIDOUKOUSINHYOUJI     = "zrnjidoukousinhyouji";
    public static final String ZRNTENKANHYOUJI          = "zrntenkanhyouji";
    public static final String ZRNHOSYOUIKKATUMNOSHYOUJI = "zrnhosyouikkatumnoshyouji";
    public static final String ZRNYOBI01XV40            = "zrnyobi01xv40";
    public static final String ZRNTKKZKP                = "zrntkkzkp";
    public static final String ZRNKEIZOKUPHURIKAEKNGK   = "zrnkeizokuphurikaekngk";
    public static final String ZRNKEIZOKUPHURIKAEKAISIYM = "zrnkeizokuphurikaekaisiym";
    public static final String ZRNHARAIKOMIPANNAISAIKAIYM = "zrnharaikomipannaisaikaiym";
    public static final String ZRNTKKZKKOURYOKUKAISIYMD = "zrntkkzkkouryokukaisiymd";
    public static final String ZRNHRIMNGTKYKPJYUUTOUHOUKBN = "zrnhrimngtkykpjyuutouhoukbn";
    public static final String ZRNJKITKPJYTYM           = "zrnjkitkpjytym";
    public static final String ZRNITIJIBRZUGKTKP        = "zrnitijibrzugktkp";
    public static final String ZRNPAZUKARIKINGK         = "zrnpazukarikingk";
    public static final String ZRNZENNOUKBN             = "zrnzennoukbn";
    public static final String ZRNZENNOUKAISIYMD        = "zrnzennoukaisiymd";
    public static final String ZRNZENNOUNYUUKINYMD      = "zrnzennounyuukinymd";
    public static final String ZRNYOKUKIPBUNRUICD       = "zrnyokukipbunruicd";
    public static final String ZRNMISYORICD1            = "zrnmisyoricd1";
    public static final String ZRNMISYORICD2            = "zrnmisyoricd2";
    public static final String ZRNMISYORICD3            = "zrnmisyoricd3";
    public static final String ZRNMISYORICD4            = "zrnmisyoricd4";
    public static final String ZRNMISYORICD5            = "zrnmisyoricd5";
    public static final String ZRNMISYORICD6            = "zrnmisyoricd6";
    public static final String ZRNMISYORICD7            = "zrnmisyoricd7";
    public static final String ZRNMISYORICD8            = "zrnmisyoricd8";
    public static final String ZRNMISYORICD9            = "zrnmisyoricd9";
    public static final String ZRNMISYORICD10           = "zrnmisyoricd10";
    public static final String ZRNYOBI02XV39            = "zrnyobi02xv39";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNKEIYAKUM              = "zrnkeiyakum";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNIKTYKNNDP             = "zrniktyknndp";
    public static final String ZRNKIGETUMAENYKNYKNNDP   = "zrnkigetumaenyknyknndp";
    public static final String ZRNYKNNDPKEI             = "zrnyknndpkei";
    public static final String ZRNYOBI03XN15            = "zrnyobi03xn15";
    public static final String ZRNYOBI04XV23            = "zrnyobi04xv23";

    private final PKZT_KessanYokukiPRn primaryKey;

    public GenZT_KessanYokukiPRn() {
        primaryKey = new PKZT_KessanYokukiPRn();
    }

    public GenZT_KessanYokukiPRn(String pZrnkeijyouym, String pZrnsyono) {
        primaryKey = new PKZT_KessanYokukiPRn(pZrnkeijyouym, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_KessanYokukiPRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KessanYokukiPRn> getMetaClass() {
        return QZT_KessanYokukiPRn.class;
    }

    @Id
    @Column(name=GenZT_KessanYokukiPRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return getPrimaryKey().getZrnkeijyouym();
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        getPrimaryKey().setZrnkeijyouym(pZrnkeijyouym);
    }

    @Id
    @Column(name=GenZT_KessanYokukiPRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_KessanYokukiPRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_KessanYokukiPRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrnzennyknmonth;

    @Column(name=GenZT_KessanYokukiPRn.ZRNZENNYKNMONTH)
    public Long getZrnzennyknmonth() {
        return zrnzennyknmonth;
    }

    public void setZrnzennyknmonth(Long pZrnzennyknmonth) {
        zrnzennyknmonth = pZrnzennyknmonth;
    }

    private String zrnzenyuukinymd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNZENYUUKINYMD)
    public String getZrnzenyuukinymd() {
        return zrnzenyuukinymd;
    }

    public void setZrnzenyuukinymd(String pZrnzenyuukinymd) {
        zrnzenyuukinymd = pZrnzenyuukinymd;
    }

    private String zrnjidoukousinhyouji;

    @Column(name=GenZT_KessanYokukiPRn.ZRNJIDOUKOUSINHYOUJI)
    public String getZrnjidoukousinhyouji() {
        return zrnjidoukousinhyouji;
    }

    public void setZrnjidoukousinhyouji(String pZrnjidoukousinhyouji) {
        zrnjidoukousinhyouji = pZrnjidoukousinhyouji;
    }

    private String zrntenkanhyouji;

    @Column(name=GenZT_KessanYokukiPRn.ZRNTENKANHYOUJI)
    public String getZrntenkanhyouji() {
        return zrntenkanhyouji;
    }

    public void setZrntenkanhyouji(String pZrntenkanhyouji) {
        zrntenkanhyouji = pZrntenkanhyouji;
    }

    private String zrnhosyouikkatumnoshyouji;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHOSYOUIKKATUMNOSHYOUJI)
    public String getZrnhosyouikkatumnoshyouji() {
        return zrnhosyouikkatumnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyouikkatumnoshyouji(String pZrnhosyouikkatumnoshyouji) {
        zrnhosyouikkatumnoshyouji = pZrnhosyouikkatumnoshyouji;
    }

    private String zrnyobi01xv40;

    @Column(name=GenZT_KessanYokukiPRn.ZRNYOBI01XV40)
    public String getZrnyobi01xv40() {
        return zrnyobi01xv40;
    }

    public void setZrnyobi01xv40(String pZrnyobi01xv40) {
        zrnyobi01xv40 = pZrnyobi01xv40;
    }

    private Long zrntkkzkp;

    @Column(name=GenZT_KessanYokukiPRn.ZRNTKKZKP)
    public Long getZrntkkzkp() {
        return zrntkkzkp;
    }

    public void setZrntkkzkp(Long pZrntkkzkp) {
        zrntkkzkp = pZrntkkzkp;
    }

    private Long zrnkeizokuphurikaekngk;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKEIZOKUPHURIKAEKNGK)
    public Long getZrnkeizokuphurikaekngk() {
        return zrnkeizokuphurikaekngk;
    }

    public void setZrnkeizokuphurikaekngk(Long pZrnkeizokuphurikaekngk) {
        zrnkeizokuphurikaekngk = pZrnkeizokuphurikaekngk;
    }

    private String zrnkeizokuphurikaekaisiym;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKEIZOKUPHURIKAEKAISIYM)
    public String getZrnkeizokuphurikaekaisiym() {
        return zrnkeizokuphurikaekaisiym;
    }

    public void setZrnkeizokuphurikaekaisiym(String pZrnkeizokuphurikaekaisiym) {
        zrnkeizokuphurikaekaisiym = pZrnkeizokuphurikaekaisiym;
    }

    private String zrnharaikomipannaisaikaiym;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHARAIKOMIPANNAISAIKAIYM)
    public String getZrnharaikomipannaisaikaiym() {
        return zrnharaikomipannaisaikaiym;
    }

    public void setZrnharaikomipannaisaikaiym(String pZrnharaikomipannaisaikaiym) {
        zrnharaikomipannaisaikaiym = pZrnharaikomipannaisaikaiym;
    }

    private String zrntkkzkkouryokukaisiymd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNTKKZKKOURYOKUKAISIYMD)
    public String getZrntkkzkkouryokukaisiymd() {
        return zrntkkzkkouryokukaisiymd;
    }

    public void setZrntkkzkkouryokukaisiymd(String pZrntkkzkkouryokukaisiymd) {
        zrntkkzkkouryokukaisiymd = pZrntkkzkkouryokukaisiymd;
    }

    private String zrnhrimngtkykpjyuutouhoukbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHRIMNGTKYKPJYUUTOUHOUKBN)
    public String getZrnhrimngtkykpjyuutouhoukbn() {
        return zrnhrimngtkykpjyuutouhoukbn;
    }

    public void setZrnhrimngtkykpjyuutouhoukbn(String pZrnhrimngtkykpjyuutouhoukbn) {
        zrnhrimngtkykpjyuutouhoukbn = pZrnhrimngtkykpjyuutouhoukbn;
    }

    private String zrnjkitkpjytym;

    @Column(name=GenZT_KessanYokukiPRn.ZRNJKITKPJYTYM)
    public String getZrnjkitkpjytym() {
        return zrnjkitkpjytym;
    }

    public void setZrnjkitkpjytym(String pZrnjkitkpjytym) {
        zrnjkitkpjytym = pZrnjkitkpjytym;
    }

    private Long zrnitijibrzugktkp;

    @Column(name=GenZT_KessanYokukiPRn.ZRNITIJIBRZUGKTKP)
    public Long getZrnitijibrzugktkp() {
        return zrnitijibrzugktkp;
    }

    public void setZrnitijibrzugktkp(Long pZrnitijibrzugktkp) {
        zrnitijibrzugktkp = pZrnitijibrzugktkp;
    }

    private Long zrnpazukarikingk;

    @Column(name=GenZT_KessanYokukiPRn.ZRNPAZUKARIKINGK)
    public Long getZrnpazukarikingk() {
        return zrnpazukarikingk;
    }

    public void setZrnpazukarikingk(Long pZrnpazukarikingk) {
        zrnpazukarikingk = pZrnpazukarikingk;
    }

    private String zrnzennoukbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNZENNOUKBN)
    public String getZrnzennoukbn() {
        return zrnzennoukbn;
    }

    public void setZrnzennoukbn(String pZrnzennoukbn) {
        zrnzennoukbn = pZrnzennoukbn;
    }

    private String zrnzennoukaisiymd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNZENNOUKAISIYMD)
    public String getZrnzennoukaisiymd() {
        return zrnzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnzennoukaisiymd(String pZrnzennoukaisiymd) {
        zrnzennoukaisiymd = pZrnzennoukaisiymd;
    }

    private String zrnzennounyuukinymd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNZENNOUNYUUKINYMD)
    public String getZrnzennounyuukinymd() {
        return zrnzennounyuukinymd;
    }

    public void setZrnzennounyuukinymd(String pZrnzennounyuukinymd) {
        zrnzennounyuukinymd = pZrnzennounyuukinymd;
    }

    private String zrnyokukipbunruicd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNYOKUKIPBUNRUICD)
    public String getZrnyokukipbunruicd() {
        return zrnyokukipbunruicd;
    }

    public void setZrnyokukipbunruicd(String pZrnyokukipbunruicd) {
        zrnyokukipbunruicd = pZrnyokukipbunruicd;
    }

    private String zrnmisyoricd1;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD1)
    public String getZrnmisyoricd1() {
        return zrnmisyoricd1;
    }

    public void setZrnmisyoricd1(String pZrnmisyoricd1) {
        zrnmisyoricd1 = pZrnmisyoricd1;
    }

    private String zrnmisyoricd2;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD2)
    public String getZrnmisyoricd2() {
        return zrnmisyoricd2;
    }

    public void setZrnmisyoricd2(String pZrnmisyoricd2) {
        zrnmisyoricd2 = pZrnmisyoricd2;
    }

    private String zrnmisyoricd3;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD3)
    public String getZrnmisyoricd3() {
        return zrnmisyoricd3;
    }

    public void setZrnmisyoricd3(String pZrnmisyoricd3) {
        zrnmisyoricd3 = pZrnmisyoricd3;
    }

    private String zrnmisyoricd4;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD4)
    public String getZrnmisyoricd4() {
        return zrnmisyoricd4;
    }

    public void setZrnmisyoricd4(String pZrnmisyoricd4) {
        zrnmisyoricd4 = pZrnmisyoricd4;
    }

    private String zrnmisyoricd5;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD5)
    public String getZrnmisyoricd5() {
        return zrnmisyoricd5;
    }

    public void setZrnmisyoricd5(String pZrnmisyoricd5) {
        zrnmisyoricd5 = pZrnmisyoricd5;
    }

    private String zrnmisyoricd6;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD6)
    public String getZrnmisyoricd6() {
        return zrnmisyoricd6;
    }

    public void setZrnmisyoricd6(String pZrnmisyoricd6) {
        zrnmisyoricd6 = pZrnmisyoricd6;
    }

    private String zrnmisyoricd7;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD7)
    public String getZrnmisyoricd7() {
        return zrnmisyoricd7;
    }

    public void setZrnmisyoricd7(String pZrnmisyoricd7) {
        zrnmisyoricd7 = pZrnmisyoricd7;
    }

    private String zrnmisyoricd8;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD8)
    public String getZrnmisyoricd8() {
        return zrnmisyoricd8;
    }

    public void setZrnmisyoricd8(String pZrnmisyoricd8) {
        zrnmisyoricd8 = pZrnmisyoricd8;
    }

    private String zrnmisyoricd9;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD9)
    public String getZrnmisyoricd9() {
        return zrnmisyoricd9;
    }

    public void setZrnmisyoricd9(String pZrnmisyoricd9) {
        zrnmisyoricd9 = pZrnmisyoricd9;
    }

    private String zrnmisyoricd10;

    @Column(name=GenZT_KessanYokukiPRn.ZRNMISYORICD10)
    public String getZrnmisyoricd10() {
        return zrnmisyoricd10;
    }

    public void setZrnmisyoricd10(String pZrnmisyoricd10) {
        zrnmisyoricd10 = pZrnmisyoricd10;
    }

    private String zrnyobi02xv39;

    @Column(name=GenZT_KessanYokukiPRn.ZRNYOBI02XV39)
    public String getZrnyobi02xv39() {
        return zrnyobi02xv39;
    }

    public void setZrnyobi02xv39(String pZrnyobi02xv39) {
        zrnyobi02xv39 = pZrnyobi02xv39;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_KessanYokukiPRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private String zrnkeiyakum;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKEIYAKUM)
    public String getZrnkeiyakum() {
        return zrnkeiyakum;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkeiyakum(String pZrnkeiyakum) {
        zrnkeiyakum = pZrnkeiyakum;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_KessanYokukiPRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private Long zrniktyknndp;

    @Column(name=GenZT_KessanYokukiPRn.ZRNIKTYKNNDP)
    public Long getZrniktyknndp() {
        return zrniktyknndp;
    }

    public void setZrniktyknndp(Long pZrniktyknndp) {
        zrniktyknndp = pZrniktyknndp;
    }

    private Long zrnkigetumaenyknyknndp;

    @Column(name=GenZT_KessanYokukiPRn.ZRNKIGETUMAENYKNYKNNDP)
    public Long getZrnkigetumaenyknyknndp() {
        return zrnkigetumaenyknyknndp;
    }

    public void setZrnkigetumaenyknyknndp(Long pZrnkigetumaenyknyknndp) {
        zrnkigetumaenyknyknndp = pZrnkigetumaenyknyknndp;
    }

    private Long zrnyknndpkei;

    @Column(name=GenZT_KessanYokukiPRn.ZRNYKNNDPKEI)
    public Long getZrnyknndpkei() {
        return zrnyknndpkei;
    }

    public void setZrnyknndpkei(Long pZrnyknndpkei) {
        zrnyknndpkei = pZrnyknndpkei;
    }

    private Long zrnyobi03xn15;

    @Column(name=GenZT_KessanYokukiPRn.ZRNYOBI03XN15)
    public Long getZrnyobi03xn15() {
        return zrnyobi03xn15;
    }

    public void setZrnyobi03xn15(Long pZrnyobi03xn15) {
        zrnyobi03xn15 = pZrnyobi03xn15;
    }

    private String zrnyobi04xv23;

    @Column(name=GenZT_KessanYokukiPRn.ZRNYOBI04XV23)
    public String getZrnyobi04xv23() {
        return zrnyobi04xv23;
    }

    public void setZrnyobi04xv23(String pZrnyobi04xv23) {
        zrnyobi04xv23 = pZrnyobi04xv23;
    }
}