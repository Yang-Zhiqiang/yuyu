package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KessanYokukiPTy;
import yuyu.def.db.mapping.GenZT_KessanYokukiPTy;
import yuyu.def.db.meta.GenQZT_KessanYokukiPTy;
import yuyu.def.db.meta.QZT_KessanYokukiPTy;

/**
 * 決算用翌期Ｐテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanYokukiPTy}</td><td colspan="3">決算用翌期Ｐテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x1</td><td>（中継用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x2</td><td>（中継用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x3</td><td>（中継用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x4</td><td>（中継用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x5</td><td>（中継用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x6</td><td>（中継用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x7</td><td>（中継用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x8</td><td>（中継用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x9</td><td>（中継用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x10</td><td>（中継用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x11</td><td>（中継用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x12</td><td>（中継用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x13</td><td>（中継用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x14</td><td>（中継用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x15</td><td>（中継用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x1</td><td>（中継用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x2</td><td>（中継用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x3</td><td>（中継用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x4</td><td>（中継用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x5</td><td>（中継用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x6</td><td>（中継用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x7</td><td>（中継用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x8</td><td>（中継用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x9</td><td>（中継用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x10</td><td>（中継用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x1</td><td>（中継用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x2</td><td>（中継用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x3</td><td>（中継用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x4</td><td>（中継用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x5</td><td>（中継用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x6</td><td>（中継用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x7</td><td>（中継用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x8</td><td>（中継用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x9</td><td>（中継用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x10</td><td>（中継用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetucd</td><td>（中継用）消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaipjyuutouym</td><td>（中継用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikomip</td><td>（中継用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennyknmonth</td><td>（中継用）前回入金月数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzenyuukinymd</td><td>（中継用）前回入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjidoukousinhyouji</td><td>（中継用）自動更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanhyouji</td><td>（中継用）転換表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouikkatumnoshyouji</td><td>（中継用）保障一括見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobi01xv40</td><td>（中継用）予備０１＿Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkkzkp</td><td>（中継用）特約継続Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeizokuphurikaekngk</td><td>（中継用）継続Ｐ振替金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeizokuphurikaekaisiym</td><td>（中継用）継続Ｐ振替開始年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikomipannaisaikaiym</td><td>（中継用）払込Ｐ案内再開年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkkzkkouryokukaisiymd</td><td>（中継用）特約継続効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrimngtkykpjyuutouhoukbn</td><td>（中継用）払満後特約Ｐ充当方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjkitkpjytym</td><td>（中継用）次回特約Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrzugktkp</td><td>（中継用）一時払増額特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztypazukarikingk</td><td>（中継用）Ｐ預り金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennoukbn</td><td>（中継用）前納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukaisiymd</td><td>（中継用）前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennounyuukinymd</td><td>（中継用）前納入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokukipbunruicd</td><td>（中継用）翌期Ｐ分類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd1</td><td>（中継用）未処理コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd2</td><td>（中継用）未処理コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd3</td><td>（中継用）未処理コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd4</td><td>（中継用）未処理コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd5</td><td>（中継用）未処理コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd6</td><td>（中継用）未処理コード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd7</td><td>（中継用）未処理コード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd8</td><td>（中継用）未処理コード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd9</td><td>（中継用）未処理コード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyoricd10</td><td>（中継用）未処理コード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobi02xv39</td><td>（中継用）予備０２＿Ｖ３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuurisyuruicd</td><td>（中継用）数理種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakunendo</td><td>（中継用）契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakum</td><td>（中継用）契約月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikatakbn</td><td>（中継用）払方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyiktyknndp</td><td>（中継用）一括払翌年度保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykigetumaenyknyknndp</td><td>（中継用）期月前入金翌年度保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyknndpkei</td><td>（中継用）翌年度保険料合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobi03xn15</td><td>（中継用）予備０３＿Ｎ１５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobi04xv23</td><td>（中継用）予備０４＿Ｖ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanYokukiPTy
 * @see     GenZT_KessanYokukiPTy
 * @see     QZT_KessanYokukiPTy
 * @see     GenQZT_KessanYokukiPTy
 */
public class PKZT_KessanYokukiPTy extends AbstractExDBPrimaryKey<ZT_KessanYokukiPTy, PKZT_KessanYokukiPTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KessanYokukiPTy() {
    }

    public PKZT_KessanYokukiPTy(String pZtykeijyouym, String pZtysyono) {
        ztykeijyouym = pZtykeijyouym;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_KessanYokukiPTy> getEntityClass() {
        return ZT_KessanYokukiPTy.class;
    }

    private String ztykeijyouym;

    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}