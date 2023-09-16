package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkIktHriRn;
import yuyu.def.db.mapping.GenZT_NkIktHriRn;
import yuyu.def.db.meta.GenQZT_NkIktHriRn;
import yuyu.def.db.meta.QZT_NkIktHriRn;

/**
 * 年金一括払テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkIktHriRn}</td><td colspan="3">年金一括払テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkbn</td><td>（連携用）年金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsyu</td><td>（連携用）年金種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokainenkinsiharaiymd</td><td>（連携用）初回年金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhnnkgk</td><td>（連携用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnkkaisigoyoteiriritukbn</td><td>（連携用）年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiharaikaisuukbn</td><td>（連携用）支払回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkingaku</td><td>（連携用）買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkasannkgk</td><td>（連携用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnikkatubarainenkingaku</td><td>（連携用）一括払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkeiyakuymd</td><td>（連携用）契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjihihokensyaage</td><td>（連携用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknshry</td><td>（連携用）年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinhosyoukikan</td><td>（連携用）年金保証期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn</td><td>（連携用）年金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvkisoyousgoyoteirrtkbn</td><td>（連携用）Ｖ基礎用開始後予定利率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkigousedaikbn</td><td>（連携用）年金記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrrthendounkyoteirrt</td><td>（連携用）利率変動年金予定利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnznnndhssitounendshrnkgk</td><td>（連携用）前年度発生当年度支払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntounendhssitunndshrnkgk</td><td>（連携用）当年度発生当年度支払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x1</td><td>（連携用）年金種類記号予備１＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x2</td><td>（連携用）年金種類記号予備１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x3</td><td>（連携用）年金種類記号予備１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x4</td><td>（連携用）年金種類記号予備１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x5</td><td>（連携用）年金種類記号予備１＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x6</td><td>（連携用）年金種類記号予備１＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x7</td><td>（連携用）年金種類記号予備１＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x8</td><td>（連携用）年金種類記号予備１＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x9</td><td>（連携用）年金種類記号予備１＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x10</td><td>（連携用）年金種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x11</td><td>（連携用）年金種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x12</td><td>（連携用）年金種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x13</td><td>（連携用）年金種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x14</td><td>（連携用）年金種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x15</td><td>（連携用）年金種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x1</td><td>（連携用）年金種類記号予備２＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x2</td><td>（連携用）年金種類記号予備２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x3</td><td>（連携用）年金種類記号予備２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x4</td><td>（連携用）年金種類記号予備２＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x5</td><td>（連携用）年金種類記号予備２＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x6</td><td>（連携用）年金種類記号予備２＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x7</td><td>（連携用）年金種類記号予備２＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x8</td><td>（連携用）年金種類記号予備２＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x9</td><td>（連携用）年金種類記号予備２＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x10</td><td>（連携用）年金種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x1</td><td>（連携用）年金種類記号予備３＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x2</td><td>（連携用）年金種類記号予備３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x3</td><td>（連携用）年金種類記号予備３＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x4</td><td>（連携用）年金種類記号予備３＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x5</td><td>（連携用）年金種類記号予備３＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x6</td><td>（連携用）年金種類記号予備３＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x7</td><td>（連携用）年金種類記号予備３＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x8</td><td>（連携用）年金種類記号予備３＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x9</td><td>（連携用）年金種類記号予備３＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x10</td><td>（連携用）年金種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnentysihyj</td><td>（連携用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukeitaikbn</td><td>（連携用）募集形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkhknhoutekiyouhyj</td><td>（連携用）年金保険法適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv25</td><td>（連携用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkIktHriRn
 * @see     GenZT_NkIktHriRn
 * @see     QZT_NkIktHriRn
 * @see     GenQZT_NkIktHriRn
 */
public class PKZT_NkIktHriRn extends AbstractExDBPrimaryKey<ZT_NkIktHriRn, PKZT_NkIktHriRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkIktHriRn() {
    }

    public PKZT_NkIktHriRn(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    @Transient
    @Override
    public Class<ZT_NkIktHriRn> getEntityClass() {
        return ZT_NkIktHriRn.class;
    }

    private String zrndatakanrino;

    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

}