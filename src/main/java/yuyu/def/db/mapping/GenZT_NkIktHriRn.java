package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_NkIktHriRn;
import yuyu.def.db.id.PKZT_NkIktHriRn;
import yuyu.def.db.meta.GenQZT_NkIktHriRn;
import yuyu.def.db.meta.QZT_NkIktHriRn;

/**
 * 年金一括払テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NkIktHriRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkIktHriRn}</td><td colspan="3">年金一括払テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">{@link PKZT_NkIktHriRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokainenkinsiharaiymd zrnsyokainenkinsiharaiymd}</td><td>（連携用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhnnkgk zrnkhnnkgk}</td><td>（連携用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaikaisuukbn zrnsiharaikaisuukbn}</td><td>（連携用）支払回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkingaku zrnkaimasinenkingaku}</td><td>（連携用）買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkasannkgk zrnkasannkgk}</td><td>（連携用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnikkatubarainenkingaku zrnikkatubarainenkingaku}</td><td>（連携用）一括払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjihihokensyaage zrnnksjihihokensyaage}</td><td>（連携用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinhosyoukikan zrnnenkinhosyoukikan}</td><td>（連携用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn zrnnksyuruikbn}</td><td>（連携用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvkisoyousgoyoteirrtkbn zrnvkisoyousgoyoteirrtkbn}</td><td>（連携用）Ｖ基礎用開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrrthendounkyoteirrt zrnrrthendounkyoteirrt}</td><td>（連携用）利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnznnndhssitounendshrnkgk zrnznnndhssitounendshrnkgk}</td><td>（連携用）前年度発生当年度支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendhssitunndshrnkgk zrntounendhssitunndshrnkgk}</td><td>（連携用）当年度発生当年度支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x1 zrnnksyuruikguyobi1x1}</td><td>（連携用）年金種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x2 zrnnksyuruikguyobi1x2}</td><td>（連携用）年金種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x3 zrnnksyuruikguyobi1x3}</td><td>（連携用）年金種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x4 zrnnksyuruikguyobi1x4}</td><td>（連携用）年金種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x5 zrnnksyuruikguyobi1x5}</td><td>（連携用）年金種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x6 zrnnksyuruikguyobi1x6}</td><td>（連携用）年金種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x7 zrnnksyuruikguyobi1x7}</td><td>（連携用）年金種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x8 zrnnksyuruikguyobi1x8}</td><td>（連携用）年金種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x9 zrnnksyuruikguyobi1x9}</td><td>（連携用）年金種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x10 zrnnksyuruikguyobi1x10}</td><td>（連携用）年金種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x11 zrnnksyuruikguyobi1x11}</td><td>（連携用）年金種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x12 zrnnksyuruikguyobi1x12}</td><td>（連携用）年金種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x13 zrnnksyuruikguyobi1x13}</td><td>（連携用）年金種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x14 zrnnksyuruikguyobi1x14}</td><td>（連携用）年金種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x15 zrnnksyuruikguyobi1x15}</td><td>（連携用）年金種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x1 zrnnksyuruikguyobi2x1}</td><td>（連携用）年金種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x2 zrnnksyuruikguyobi2x2}</td><td>（連携用）年金種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x3 zrnnksyuruikguyobi2x3}</td><td>（連携用）年金種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x4 zrnnksyuruikguyobi2x4}</td><td>（連携用）年金種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x5 zrnnksyuruikguyobi2x5}</td><td>（連携用）年金種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x6 zrnnksyuruikguyobi2x6}</td><td>（連携用）年金種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x7 zrnnksyuruikguyobi2x7}</td><td>（連携用）年金種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x8 zrnnksyuruikguyobi2x8}</td><td>（連携用）年金種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x9 zrnnksyuruikguyobi2x9}</td><td>（連携用）年金種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x10 zrnnksyuruikguyobi2x10}</td><td>（連携用）年金種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x1 zrnnksyuruikguyobi3x1}</td><td>（連携用）年金種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x2 zrnnksyuruikguyobi3x2}</td><td>（連携用）年金種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x3 zrnnksyuruikguyobi3x3}</td><td>（連携用）年金種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x4 zrnnksyuruikguyobi3x4}</td><td>（連携用）年金種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x5 zrnnksyuruikguyobi3x5}</td><td>（連携用）年金種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x6 zrnnksyuruikguyobi3x6}</td><td>（連携用）年金種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x7 zrnnksyuruikguyobi3x7}</td><td>（連携用）年金種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x8 zrnnksyuruikguyobi3x8}</td><td>（連携用）年金種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x9 zrnnksyuruikguyobi3x9}</td><td>（連携用）年金種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x10 zrnnksyuruikguyobi3x10}</td><td>（連携用）年金種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkhknhoutekiyouhyj zrnnkhknhoutekiyouhyj}</td><td>（連携用）年金保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25 zrnyobiv25}</td><td>（連携用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkIktHriRn
 * @see     PKZT_NkIktHriRn
 * @see     QZT_NkIktHriRn
 * @see     GenQZT_NkIktHriRn
 */
@MappedSuperclass
@Table(name=GenZT_NkIktHriRn.TABLE_NAME)
@IdClass(value=PKZT_NkIktHriRn.class)
public abstract class GenZT_NkIktHriRn extends AbstractExDBEntityForZDB<ZT_NkIktHriRn, PKZT_NkIktHriRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkIktHriRn";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNSYOKAINENKINSIHARAIYMD = "zrnsyokainenkinsiharaiymd";
    public static final String ZRNKHNNKGK               = "zrnkhnnkgk";
    public static final String ZRNNKKAISIGOYOTEIRIRITUKBN = "zrnnkkaisigoyoteiriritukbn";
    public static final String ZRNSIHARAIKAISUUKBN      = "zrnsiharaikaisuukbn";
    public static final String ZRNKAIMASINENKINGAKU     = "zrnkaimasinenkingaku";
    public static final String ZRNKASANNKGK             = "zrnkasannkgk";
    public static final String ZRNIKKATUBARAINENKINGAKU = "zrnikkatubarainenkingaku";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNNKSJIHIHOKENSYAAGE    = "zrnnksjihihokensyaage";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNENKINHOSYOUKIKAN     = "zrnnenkinhosyoukikan";
    public static final String ZRNNKSYURUIKBN           = "zrnnksyuruikbn";
    public static final String ZRNVKISOYOUSGOYOTEIRRTKBN = "zrnvkisoyousgoyoteirrtkbn";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNRRTHENDOUNKYOTEIRRT   = "zrnrrthendounkyoteirrt";
    public static final String ZRNZNNNDHSSITOUNENDSHRNKGK = "zrnznnndhssitounendshrnkgk";
    public static final String ZRNTOUNENDHSSITUNNDSHRNKGK = "zrntounendhssitunndshrnkgk";
    public static final String ZRNNKSYURUIKGUYOBI1X1    = "zrnnksyuruikguyobi1x1";
    public static final String ZRNNKSYURUIKGUYOBI1X2    = "zrnnksyuruikguyobi1x2";
    public static final String ZRNNKSYURUIKGUYOBI1X3    = "zrnnksyuruikguyobi1x3";
    public static final String ZRNNKSYURUIKGUYOBI1X4    = "zrnnksyuruikguyobi1x4";
    public static final String ZRNNKSYURUIKGUYOBI1X5    = "zrnnksyuruikguyobi1x5";
    public static final String ZRNNKSYURUIKGUYOBI1X6    = "zrnnksyuruikguyobi1x6";
    public static final String ZRNNKSYURUIKGUYOBI1X7    = "zrnnksyuruikguyobi1x7";
    public static final String ZRNNKSYURUIKGUYOBI1X8    = "zrnnksyuruikguyobi1x8";
    public static final String ZRNNKSYURUIKGUYOBI1X9    = "zrnnksyuruikguyobi1x9";
    public static final String ZRNNKSYURUIKGUYOBI1X10   = "zrnnksyuruikguyobi1x10";
    public static final String ZRNNKSYURUIKGUYOBI1X11   = "zrnnksyuruikguyobi1x11";
    public static final String ZRNNKSYURUIKGUYOBI1X12   = "zrnnksyuruikguyobi1x12";
    public static final String ZRNNKSYURUIKGUYOBI1X13   = "zrnnksyuruikguyobi1x13";
    public static final String ZRNNKSYURUIKGUYOBI1X14   = "zrnnksyuruikguyobi1x14";
    public static final String ZRNNKSYURUIKGUYOBI1X15   = "zrnnksyuruikguyobi1x15";
    public static final String ZRNNKSYURUIKGUYOBI2X1    = "zrnnksyuruikguyobi2x1";
    public static final String ZRNNKSYURUIKGUYOBI2X2    = "zrnnksyuruikguyobi2x2";
    public static final String ZRNNKSYURUIKGUYOBI2X3    = "zrnnksyuruikguyobi2x3";
    public static final String ZRNNKSYURUIKGUYOBI2X4    = "zrnnksyuruikguyobi2x4";
    public static final String ZRNNKSYURUIKGUYOBI2X5    = "zrnnksyuruikguyobi2x5";
    public static final String ZRNNKSYURUIKGUYOBI2X6    = "zrnnksyuruikguyobi2x6";
    public static final String ZRNNKSYURUIKGUYOBI2X7    = "zrnnksyuruikguyobi2x7";
    public static final String ZRNNKSYURUIKGUYOBI2X8    = "zrnnksyuruikguyobi2x8";
    public static final String ZRNNKSYURUIKGUYOBI2X9    = "zrnnksyuruikguyobi2x9";
    public static final String ZRNNKSYURUIKGUYOBI2X10   = "zrnnksyuruikguyobi2x10";
    public static final String ZRNNKSYURUIKGUYOBI3X1    = "zrnnksyuruikguyobi3x1";
    public static final String ZRNNKSYURUIKGUYOBI3X2    = "zrnnksyuruikguyobi3x2";
    public static final String ZRNNKSYURUIKGUYOBI3X3    = "zrnnksyuruikguyobi3x3";
    public static final String ZRNNKSYURUIKGUYOBI3X4    = "zrnnksyuruikguyobi3x4";
    public static final String ZRNNKSYURUIKGUYOBI3X5    = "zrnnksyuruikguyobi3x5";
    public static final String ZRNNKSYURUIKGUYOBI3X6    = "zrnnksyuruikguyobi3x6";
    public static final String ZRNNKSYURUIKGUYOBI3X7    = "zrnnksyuruikguyobi3x7";
    public static final String ZRNNKSYURUIKGUYOBI3X8    = "zrnnksyuruikguyobi3x8";
    public static final String ZRNNKSYURUIKGUYOBI3X9    = "zrnnksyuruikguyobi3x9";
    public static final String ZRNNKSYURUIKGUYOBI3X10   = "zrnnksyuruikguyobi3x10";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNNKHKNHOUTEKIYOUHYJ    = "zrnnkhknhoutekiyouhyj";
    public static final String ZRNYOBIV25               = "zrnyobiv25";

    private final PKZT_NkIktHriRn primaryKey;

    public GenZT_NkIktHriRn() {
        primaryKey = new PKZT_NkIktHriRn();
    }

    public GenZT_NkIktHriRn(String pZrndatakanrino) {
        primaryKey = new PKZT_NkIktHriRn(pZrndatakanrino);
    }

    @Transient
    @Override
    public PKZT_NkIktHriRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkIktHriRn> getMetaClass() {
        return QZT_NkIktHriRn.class;
    }

    @Id
    @Column(name=GenZT_NkIktHriRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return getPrimaryKey().getZrndatakanrino();
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        getPrimaryKey().setZrndatakanrino(pZrndatakanrino);
    }

    private String zrnnenkinkbn;

    @Column(name=GenZT_NkIktHriRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return zrnnenkinkbn;
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        zrnnenkinkbn = pZrnnenkinkbn;
    }

    private String zrnnenkinsyu;

    @Column(name=GenZT_NkIktHriRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return zrnnenkinsyu;
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        zrnnenkinsyu = pZrnnenkinsyu;
    }

    private String zrnsyokainenkinsiharaiymd;

    @Column(name=GenZT_NkIktHriRn.ZRNSYOKAINENKINSIHARAIYMD)
    public String getZrnsyokainenkinsiharaiymd() {
        return zrnsyokainenkinsiharaiymd;
    }

    public void setZrnsyokainenkinsiharaiymd(String pZrnsyokainenkinsiharaiymd) {
        zrnsyokainenkinsiharaiymd = pZrnsyokainenkinsiharaiymd;
    }

    private Long zrnkhnnkgk;

    @Column(name=GenZT_NkIktHriRn.ZRNKHNNKGK)
    public Long getZrnkhnnkgk() {
        return zrnkhnnkgk;
    }

    public void setZrnkhnnkgk(Long pZrnkhnnkgk) {
        zrnkhnnkgk = pZrnkhnnkgk;
    }

    private String zrnnkkaisigoyoteiriritukbn;

    @Column(name=GenZT_NkIktHriRn.ZRNNKKAISIGOYOTEIRIRITUKBN)
    public String getZrnnkkaisigoyoteiriritukbn() {
        return zrnnkkaisigoyoteiriritukbn;
    }

    public void setZrnnkkaisigoyoteiriritukbn(String pZrnnkkaisigoyoteiriritukbn) {
        zrnnkkaisigoyoteiriritukbn = pZrnnkkaisigoyoteiriritukbn;
    }

    private String zrnsiharaikaisuukbn;

    @Column(name=GenZT_NkIktHriRn.ZRNSIHARAIKAISUUKBN)
    public String getZrnsiharaikaisuukbn() {
        return zrnsiharaikaisuukbn;
    }

    public void setZrnsiharaikaisuukbn(String pZrnsiharaikaisuukbn) {
        zrnsiharaikaisuukbn = pZrnsiharaikaisuukbn;
    }

    private Long zrnkaimasinenkingaku;

    @Column(name=GenZT_NkIktHriRn.ZRNKAIMASINENKINGAKU)
    public Long getZrnkaimasinenkingaku() {
        return zrnkaimasinenkingaku;
    }

    public void setZrnkaimasinenkingaku(Long pZrnkaimasinenkingaku) {
        zrnkaimasinenkingaku = pZrnkaimasinenkingaku;
    }

    private Long zrnkasannkgk;

    @Column(name=GenZT_NkIktHriRn.ZRNKASANNKGK)
    public Long getZrnkasannkgk() {
        return zrnkasannkgk;
    }

    public void setZrnkasannkgk(Long pZrnkasannkgk) {
        zrnkasannkgk = pZrnkasannkgk;
    }

    private Long zrnikkatubarainenkingaku;

    @Column(name=GenZT_NkIktHriRn.ZRNIKKATUBARAINENKINGAKU)
    public Long getZrnikkatubarainenkingaku() {
        return zrnikkatubarainenkingaku;
    }

    public void setZrnikkatubarainenkingaku(Long pZrnikkatubarainenkingaku) {
        zrnikkatubarainenkingaku = pZrnikkatubarainenkingaku;
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_NkIktHriRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnnksjihihokensyaage;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSJIHIHOKENSYAAGE)
    public String getZrnnksjihihokensyaage() {
        return zrnnksjihihokensyaage;
    }

    public void setZrnnksjihihokensyaage(String pZrnnksjihihokensyaage) {
        zrnnksjihihokensyaage = pZrnnksjihihokensyaage;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_NkIktHriRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnnknshry;

    @Column(name=GenZT_NkIktHriRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnnenkinhosyoukikan;

    @Column(name=GenZT_NkIktHriRn.ZRNNENKINHOSYOUKIKAN)
    public String getZrnnenkinhosyoukikan() {
        return zrnnenkinhosyoukikan;
    }

    public void setZrnnenkinhosyoukikan(String pZrnnenkinhosyoukikan) {
        zrnnenkinhosyoukikan = pZrnnenkinhosyoukikan;
    }

    private String zrnnksyuruikbn;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKBN)
    public String getZrnnksyuruikbn() {
        return zrnnksyuruikbn;
    }

    public void setZrnnksyuruikbn(String pZrnnksyuruikbn) {
        zrnnksyuruikbn = pZrnnksyuruikbn;
    }

    private String zrnvkisoyousgoyoteirrtkbn;

    @Column(name=GenZT_NkIktHriRn.ZRNVKISOYOUSGOYOTEIRRTKBN)
    public String getZrnvkisoyousgoyoteirrtkbn() {
        return zrnvkisoyousgoyoteirrtkbn;
    }

    public void setZrnvkisoyousgoyoteirrtkbn(String pZrnvkisoyousgoyoteirrtkbn) {
        zrnvkisoyousgoyoteirrtkbn = pZrnvkisoyousgoyoteirrtkbn;
    }

    private String zrnnenkinkigousedaikbn;

    @Column(name=GenZT_NkIktHriRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return zrnnenkinkigousedaikbn;
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
    }

    private Double zrnrrthendounkyoteirrt;

    @Column(name=GenZT_NkIktHriRn.ZRNRRTHENDOUNKYOTEIRRT)
    public Double getZrnrrthendounkyoteirrt() {
        return zrnrrthendounkyoteirrt;
    }

    public void setZrnrrthendounkyoteirrt(Double pZrnrrthendounkyoteirrt) {
        zrnrrthendounkyoteirrt = pZrnrrthendounkyoteirrt;
    }

    private Long zrnznnndhssitounendshrnkgk;

    @Column(name=GenZT_NkIktHriRn.ZRNZNNNDHSSITOUNENDSHRNKGK)
    public Long getZrnznnndhssitounendshrnkgk() {
        return zrnznnndhssitounendshrnkgk;
    }

    public void setZrnznnndhssitounendshrnkgk(Long pZrnznnndhssitounendshrnkgk) {
        zrnznnndhssitounendshrnkgk = pZrnznnndhssitounendshrnkgk;
    }

    private Long zrntounendhssitunndshrnkgk;

    @Column(name=GenZT_NkIktHriRn.ZRNTOUNENDHSSITUNNDSHRNKGK)
    public Long getZrntounendhssitunndshrnkgk() {
        return zrntounendhssitunndshrnkgk;
    }

    public void setZrntounendhssitunndshrnkgk(Long pZrntounendhssitunndshrnkgk) {
        zrntounendhssitunndshrnkgk = pZrntounendhssitunndshrnkgk;
    }

    private String zrnnksyuruikguyobi1x1;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X1)
    public String getZrnnksyuruikguyobi1x1() {
        return zrnnksyuruikguyobi1x1;
    }

    public void setZrnnksyuruikguyobi1x1(String pZrnnksyuruikguyobi1x1) {
        zrnnksyuruikguyobi1x1 = pZrnnksyuruikguyobi1x1;
    }

    private String zrnnksyuruikguyobi1x2;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X2)
    public String getZrnnksyuruikguyobi1x2() {
        return zrnnksyuruikguyobi1x2;
    }

    public void setZrnnksyuruikguyobi1x2(String pZrnnksyuruikguyobi1x2) {
        zrnnksyuruikguyobi1x2 = pZrnnksyuruikguyobi1x2;
    }

    private String zrnnksyuruikguyobi1x3;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X3)
    public String getZrnnksyuruikguyobi1x3() {
        return zrnnksyuruikguyobi1x3;
    }

    public void setZrnnksyuruikguyobi1x3(String pZrnnksyuruikguyobi1x3) {
        zrnnksyuruikguyobi1x3 = pZrnnksyuruikguyobi1x3;
    }

    private String zrnnksyuruikguyobi1x4;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X4)
    public String getZrnnksyuruikguyobi1x4() {
        return zrnnksyuruikguyobi1x4;
    }

    public void setZrnnksyuruikguyobi1x4(String pZrnnksyuruikguyobi1x4) {
        zrnnksyuruikguyobi1x4 = pZrnnksyuruikguyobi1x4;
    }

    private String zrnnksyuruikguyobi1x5;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X5)
    public String getZrnnksyuruikguyobi1x5() {
        return zrnnksyuruikguyobi1x5;
    }

    public void setZrnnksyuruikguyobi1x5(String pZrnnksyuruikguyobi1x5) {
        zrnnksyuruikguyobi1x5 = pZrnnksyuruikguyobi1x5;
    }

    private String zrnnksyuruikguyobi1x6;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X6)
    public String getZrnnksyuruikguyobi1x6() {
        return zrnnksyuruikguyobi1x6;
    }

    public void setZrnnksyuruikguyobi1x6(String pZrnnksyuruikguyobi1x6) {
        zrnnksyuruikguyobi1x6 = pZrnnksyuruikguyobi1x6;
    }

    private String zrnnksyuruikguyobi1x7;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X7)
    public String getZrnnksyuruikguyobi1x7() {
        return zrnnksyuruikguyobi1x7;
    }

    public void setZrnnksyuruikguyobi1x7(String pZrnnksyuruikguyobi1x7) {
        zrnnksyuruikguyobi1x7 = pZrnnksyuruikguyobi1x7;
    }

    private String zrnnksyuruikguyobi1x8;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X8)
    public String getZrnnksyuruikguyobi1x8() {
        return zrnnksyuruikguyobi1x8;
    }

    public void setZrnnksyuruikguyobi1x8(String pZrnnksyuruikguyobi1x8) {
        zrnnksyuruikguyobi1x8 = pZrnnksyuruikguyobi1x8;
    }

    private String zrnnksyuruikguyobi1x9;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X9)
    public String getZrnnksyuruikguyobi1x9() {
        return zrnnksyuruikguyobi1x9;
    }

    public void setZrnnksyuruikguyobi1x9(String pZrnnksyuruikguyobi1x9) {
        zrnnksyuruikguyobi1x9 = pZrnnksyuruikguyobi1x9;
    }

    private String zrnnksyuruikguyobi1x10;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X10)
    public String getZrnnksyuruikguyobi1x10() {
        return zrnnksyuruikguyobi1x10;
    }

    public void setZrnnksyuruikguyobi1x10(String pZrnnksyuruikguyobi1x10) {
        zrnnksyuruikguyobi1x10 = pZrnnksyuruikguyobi1x10;
    }

    private String zrnnksyuruikguyobi1x11;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X11)
    public String getZrnnksyuruikguyobi1x11() {
        return zrnnksyuruikguyobi1x11;
    }

    public void setZrnnksyuruikguyobi1x11(String pZrnnksyuruikguyobi1x11) {
        zrnnksyuruikguyobi1x11 = pZrnnksyuruikguyobi1x11;
    }

    private String zrnnksyuruikguyobi1x12;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X12)
    public String getZrnnksyuruikguyobi1x12() {
        return zrnnksyuruikguyobi1x12;
    }

    public void setZrnnksyuruikguyobi1x12(String pZrnnksyuruikguyobi1x12) {
        zrnnksyuruikguyobi1x12 = pZrnnksyuruikguyobi1x12;
    }

    private String zrnnksyuruikguyobi1x13;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X13)
    public String getZrnnksyuruikguyobi1x13() {
        return zrnnksyuruikguyobi1x13;
    }

    public void setZrnnksyuruikguyobi1x13(String pZrnnksyuruikguyobi1x13) {
        zrnnksyuruikguyobi1x13 = pZrnnksyuruikguyobi1x13;
    }

    private String zrnnksyuruikguyobi1x14;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X14)
    public String getZrnnksyuruikguyobi1x14() {
        return zrnnksyuruikguyobi1x14;
    }

    public void setZrnnksyuruikguyobi1x14(String pZrnnksyuruikguyobi1x14) {
        zrnnksyuruikguyobi1x14 = pZrnnksyuruikguyobi1x14;
    }

    private String zrnnksyuruikguyobi1x15;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI1X15)
    public String getZrnnksyuruikguyobi1x15() {
        return zrnnksyuruikguyobi1x15;
    }

    public void setZrnnksyuruikguyobi1x15(String pZrnnksyuruikguyobi1x15) {
        zrnnksyuruikguyobi1x15 = pZrnnksyuruikguyobi1x15;
    }

    private String zrnnksyuruikguyobi2x1;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X1)
    public String getZrnnksyuruikguyobi2x1() {
        return zrnnksyuruikguyobi2x1;
    }

    public void setZrnnksyuruikguyobi2x1(String pZrnnksyuruikguyobi2x1) {
        zrnnksyuruikguyobi2x1 = pZrnnksyuruikguyobi2x1;
    }

    private String zrnnksyuruikguyobi2x2;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X2)
    public String getZrnnksyuruikguyobi2x2() {
        return zrnnksyuruikguyobi2x2;
    }

    public void setZrnnksyuruikguyobi2x2(String pZrnnksyuruikguyobi2x2) {
        zrnnksyuruikguyobi2x2 = pZrnnksyuruikguyobi2x2;
    }

    private String zrnnksyuruikguyobi2x3;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X3)
    public String getZrnnksyuruikguyobi2x3() {
        return zrnnksyuruikguyobi2x3;
    }

    public void setZrnnksyuruikguyobi2x3(String pZrnnksyuruikguyobi2x3) {
        zrnnksyuruikguyobi2x3 = pZrnnksyuruikguyobi2x3;
    }

    private String zrnnksyuruikguyobi2x4;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X4)
    public String getZrnnksyuruikguyobi2x4() {
        return zrnnksyuruikguyobi2x4;
    }

    public void setZrnnksyuruikguyobi2x4(String pZrnnksyuruikguyobi2x4) {
        zrnnksyuruikguyobi2x4 = pZrnnksyuruikguyobi2x4;
    }

    private String zrnnksyuruikguyobi2x5;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X5)
    public String getZrnnksyuruikguyobi2x5() {
        return zrnnksyuruikguyobi2x5;
    }

    public void setZrnnksyuruikguyobi2x5(String pZrnnksyuruikguyobi2x5) {
        zrnnksyuruikguyobi2x5 = pZrnnksyuruikguyobi2x5;
    }

    private String zrnnksyuruikguyobi2x6;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X6)
    public String getZrnnksyuruikguyobi2x6() {
        return zrnnksyuruikguyobi2x6;
    }

    public void setZrnnksyuruikguyobi2x6(String pZrnnksyuruikguyobi2x6) {
        zrnnksyuruikguyobi2x6 = pZrnnksyuruikguyobi2x6;
    }

    private String zrnnksyuruikguyobi2x7;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X7)
    public String getZrnnksyuruikguyobi2x7() {
        return zrnnksyuruikguyobi2x7;
    }

    public void setZrnnksyuruikguyobi2x7(String pZrnnksyuruikguyobi2x7) {
        zrnnksyuruikguyobi2x7 = pZrnnksyuruikguyobi2x7;
    }

    private String zrnnksyuruikguyobi2x8;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X8)
    public String getZrnnksyuruikguyobi2x8() {
        return zrnnksyuruikguyobi2x8;
    }

    public void setZrnnksyuruikguyobi2x8(String pZrnnksyuruikguyobi2x8) {
        zrnnksyuruikguyobi2x8 = pZrnnksyuruikguyobi2x8;
    }

    private String zrnnksyuruikguyobi2x9;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X9)
    public String getZrnnksyuruikguyobi2x9() {
        return zrnnksyuruikguyobi2x9;
    }

    public void setZrnnksyuruikguyobi2x9(String pZrnnksyuruikguyobi2x9) {
        zrnnksyuruikguyobi2x9 = pZrnnksyuruikguyobi2x9;
    }

    private String zrnnksyuruikguyobi2x10;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI2X10)
    public String getZrnnksyuruikguyobi2x10() {
        return zrnnksyuruikguyobi2x10;
    }

    public void setZrnnksyuruikguyobi2x10(String pZrnnksyuruikguyobi2x10) {
        zrnnksyuruikguyobi2x10 = pZrnnksyuruikguyobi2x10;
    }

    private String zrnnksyuruikguyobi3x1;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X1)
    public String getZrnnksyuruikguyobi3x1() {
        return zrnnksyuruikguyobi3x1;
    }

    public void setZrnnksyuruikguyobi3x1(String pZrnnksyuruikguyobi3x1) {
        zrnnksyuruikguyobi3x1 = pZrnnksyuruikguyobi3x1;
    }

    private String zrnnksyuruikguyobi3x2;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X2)
    public String getZrnnksyuruikguyobi3x2() {
        return zrnnksyuruikguyobi3x2;
    }

    public void setZrnnksyuruikguyobi3x2(String pZrnnksyuruikguyobi3x2) {
        zrnnksyuruikguyobi3x2 = pZrnnksyuruikguyobi3x2;
    }

    private String zrnnksyuruikguyobi3x3;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X3)
    public String getZrnnksyuruikguyobi3x3() {
        return zrnnksyuruikguyobi3x3;
    }

    public void setZrnnksyuruikguyobi3x3(String pZrnnksyuruikguyobi3x3) {
        zrnnksyuruikguyobi3x3 = pZrnnksyuruikguyobi3x3;
    }

    private String zrnnksyuruikguyobi3x4;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X4)
    public String getZrnnksyuruikguyobi3x4() {
        return zrnnksyuruikguyobi3x4;
    }

    public void setZrnnksyuruikguyobi3x4(String pZrnnksyuruikguyobi3x4) {
        zrnnksyuruikguyobi3x4 = pZrnnksyuruikguyobi3x4;
    }

    private String zrnnksyuruikguyobi3x5;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X5)
    public String getZrnnksyuruikguyobi3x5() {
        return zrnnksyuruikguyobi3x5;
    }

    public void setZrnnksyuruikguyobi3x5(String pZrnnksyuruikguyobi3x5) {
        zrnnksyuruikguyobi3x5 = pZrnnksyuruikguyobi3x5;
    }

    private String zrnnksyuruikguyobi3x6;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X6)
    public String getZrnnksyuruikguyobi3x6() {
        return zrnnksyuruikguyobi3x6;
    }

    public void setZrnnksyuruikguyobi3x6(String pZrnnksyuruikguyobi3x6) {
        zrnnksyuruikguyobi3x6 = pZrnnksyuruikguyobi3x6;
    }

    private String zrnnksyuruikguyobi3x7;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X7)
    public String getZrnnksyuruikguyobi3x7() {
        return zrnnksyuruikguyobi3x7;
    }

    public void setZrnnksyuruikguyobi3x7(String pZrnnksyuruikguyobi3x7) {
        zrnnksyuruikguyobi3x7 = pZrnnksyuruikguyobi3x7;
    }

    private String zrnnksyuruikguyobi3x8;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X8)
    public String getZrnnksyuruikguyobi3x8() {
        return zrnnksyuruikguyobi3x8;
    }

    public void setZrnnksyuruikguyobi3x8(String pZrnnksyuruikguyobi3x8) {
        zrnnksyuruikguyobi3x8 = pZrnnksyuruikguyobi3x8;
    }

    private String zrnnksyuruikguyobi3x9;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X9)
    public String getZrnnksyuruikguyobi3x9() {
        return zrnnksyuruikguyobi3x9;
    }

    public void setZrnnksyuruikguyobi3x9(String pZrnnksyuruikguyobi3x9) {
        zrnnksyuruikguyobi3x9 = pZrnnksyuruikguyobi3x9;
    }

    private String zrnnksyuruikguyobi3x10;

    @Column(name=GenZT_NkIktHriRn.ZRNNKSYURUIKGUYOBI3X10)
    public String getZrnnksyuruikguyobi3x10() {
        return zrnnksyuruikguyobi3x10;
    }

    public void setZrnnksyuruikguyobi3x10(String pZrnnksyuruikguyobi3x10) {
        zrnnksyuruikguyobi3x10 = pZrnnksyuruikguyobi3x10;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_NkIktHriRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_NkIktHriRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnnkhknhoutekiyouhyj;

    @Column(name=GenZT_NkIktHriRn.ZRNNKHKNHOUTEKIYOUHYJ)
    public String getZrnnkhknhoutekiyouhyj() {
        return zrnnkhknhoutekiyouhyj;
    }

    public void setZrnnkhknhoutekiyouhyj(String pZrnnkhknhoutekiyouhyj) {
        zrnnkhknhoutekiyouhyj = pZrnnkhknhoutekiyouhyj;
    }

    private String zrnyobiv25;

    @Column(name=GenZT_NkIktHriRn.ZRNYOBIV25)
    public String getZrnyobiv25() {
        return zrnyobiv25;
    }

    public void setZrnyobiv25(String pZrnyobiv25) {
        zrnyobiv25 = pZrnyobiv25;
    }
}