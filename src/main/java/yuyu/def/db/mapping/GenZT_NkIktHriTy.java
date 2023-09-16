package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkIktHriTy;
import yuyu.def.db.id.PKZT_NkIktHriTy;
import yuyu.def.db.meta.GenQZT_NkIktHriTy;
import yuyu.def.db.meta.QZT_NkIktHriTy;

/**
 * 年金一括払テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_NkIktHriTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkIktHriTy}</td><td colspan="3">年金一括払テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">{@link PKZT_NkIktHriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkbn ztynenkinkbn}</td><td>（中継用）年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsyu ztynenkinsyu}</td><td>（中継用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokainenkinsiharaiymd ztysyokainenkinsiharaiymd}</td><td>（中継用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhnnkgk ztykhnnkgk}</td><td>（中継用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkkaisigoyoteiriritukbn ztynkkaisigoyoteiriritukbn}</td><td>（中継用）年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaikaisuukbn ztysiharaikaisuukbn}</td><td>（中継用）支払回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkingaku ztykaimasinenkingaku}</td><td>（中継用）買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykasannkgk ztykasannkgk}</td><td>（中継用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyikkatubarainenkingaku ztyikkatubarainenkingaku}</td><td>（中継用）一括払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjihihokensyaage ztynksjihihokensyaage}</td><td>（中継用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinhosyoukikan ztynenkinhosyoukikan}</td><td>（中継用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn ztynksyuruikbn}</td><td>（中継用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvkisoyousgoyoteirrtkbn ztyvkisoyousgoyoteirrtkbn}</td><td>（中継用）Ｖ基礎用開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkigousedaikbn ztynenkinkigousedaikbn}</td><td>（中継用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrrthendounkyoteirrt ztyrrthendounkyoteirrt}</td><td>（中継用）利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyznnndhssitounendshrnkgk ztyznnndhssitounendshrnkgk}</td><td>（中継用）前年度発生当年度支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendhssitunndshrnkgk ztytounendhssitunndshrnkgk}</td><td>（中継用）当年度発生当年度支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x1 ztynksyuruikguyobi1x1}</td><td>（中継用）年金種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x2 ztynksyuruikguyobi1x2}</td><td>（中継用）年金種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x3 ztynksyuruikguyobi1x3}</td><td>（中継用）年金種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x4 ztynksyuruikguyobi1x4}</td><td>（中継用）年金種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x5 ztynksyuruikguyobi1x5}</td><td>（中継用）年金種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x6 ztynksyuruikguyobi1x6}</td><td>（中継用）年金種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x7 ztynksyuruikguyobi1x7}</td><td>（中継用）年金種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x8 ztynksyuruikguyobi1x8}</td><td>（中継用）年金種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x9 ztynksyuruikguyobi1x9}</td><td>（中継用）年金種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x10 ztynksyuruikguyobi1x10}</td><td>（中継用）年金種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x11 ztynksyuruikguyobi1x11}</td><td>（中継用）年金種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x12 ztynksyuruikguyobi1x12}</td><td>（中継用）年金種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x13 ztynksyuruikguyobi1x13}</td><td>（中継用）年金種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x14 ztynksyuruikguyobi1x14}</td><td>（中継用）年金種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x15 ztynksyuruikguyobi1x15}</td><td>（中継用）年金種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x1 ztynksyuruikguyobi2x1}</td><td>（中継用）年金種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x2 ztynksyuruikguyobi2x2}</td><td>（中継用）年金種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x3 ztynksyuruikguyobi2x3}</td><td>（中継用）年金種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x4 ztynksyuruikguyobi2x4}</td><td>（中継用）年金種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x5 ztynksyuruikguyobi2x5}</td><td>（中継用）年金種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x6 ztynksyuruikguyobi2x6}</td><td>（中継用）年金種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x7 ztynksyuruikguyobi2x7}</td><td>（中継用）年金種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x8 ztynksyuruikguyobi2x8}</td><td>（中継用）年金種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x9 ztynksyuruikguyobi2x9}</td><td>（中継用）年金種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x10 ztynksyuruikguyobi2x10}</td><td>（中継用）年金種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x1 ztynksyuruikguyobi3x1}</td><td>（中継用）年金種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x2 ztynksyuruikguyobi3x2}</td><td>（中継用）年金種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x3 ztynksyuruikguyobi3x3}</td><td>（中継用）年金種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x4 ztynksyuruikguyobi3x4}</td><td>（中継用）年金種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x5 ztynksyuruikguyobi3x5}</td><td>（中継用）年金種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x6 ztynksyuruikguyobi3x6}</td><td>（中継用）年金種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x7 ztynksyuruikguyobi3x7}</td><td>（中継用）年金種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x8 ztynksyuruikguyobi3x8}</td><td>（中継用）年金種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x9 ztynksyuruikguyobi3x9}</td><td>（中継用）年金種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x10 ztynksyuruikguyobi3x10}</td><td>（中継用）年金種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkhknhoutekiyouhyj ztynkhknhoutekiyouhyj}</td><td>（中継用）年金保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv25 ztyyobiv25}</td><td>（中継用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkIktHriTy
 * @see     PKZT_NkIktHriTy
 * @see     QZT_NkIktHriTy
 * @see     GenQZT_NkIktHriTy
 */
@MappedSuperclass
@Table(name=GenZT_NkIktHriTy.TABLE_NAME)
@IdClass(value=PKZT_NkIktHriTy.class)
public abstract class GenZT_NkIktHriTy extends AbstractExDBEntity<ZT_NkIktHriTy, PKZT_NkIktHriTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkIktHriTy";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYNENKINKBN             = "ztynenkinkbn";
    public static final String ZTYNENKINSYU             = "ztynenkinsyu";
    public static final String ZTYSYOKAINENKINSIHARAIYMD = "ztysyokainenkinsiharaiymd";
    public static final String ZTYKHNNKGK               = "ztykhnnkgk";
    public static final String ZTYNKKAISIGOYOTEIRIRITUKBN = "ztynkkaisigoyoteiriritukbn";
    public static final String ZTYSIHARAIKAISUUKBN      = "ztysiharaikaisuukbn";
    public static final String ZTYKAIMASINENKINGAKU     = "ztykaimasinenkingaku";
    public static final String ZTYKASANNKGK             = "ztykasannkgk";
    public static final String ZTYIKKATUBARAINENKINGAKU = "ztyikkatubarainenkingaku";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYNKSJIHIHOKENSYAAGE    = "ztynksjihihokensyaage";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYNENKINHOSYOUKIKAN     = "ztynenkinhosyoukikan";
    public static final String ZTYNKSYURUIKBN           = "ztynksyuruikbn";
    public static final String ZTYVKISOYOUSGOYOTEIRRTKBN = "ztyvkisoyousgoyoteirrtkbn";
    public static final String ZTYNENKINKIGOUSEDAIKBN   = "ztynenkinkigousedaikbn";
    public static final String ZTYRRTHENDOUNKYOTEIRRT   = "ztyrrthendounkyoteirrt";
    public static final String ZTYZNNNDHSSITOUNENDSHRNKGK = "ztyznnndhssitounendshrnkgk";
    public static final String ZTYTOUNENDHSSITUNNDSHRNKGK = "ztytounendhssitunndshrnkgk";
    public static final String ZTYNKSYURUIKGUYOBI1X1    = "ztynksyuruikguyobi1x1";
    public static final String ZTYNKSYURUIKGUYOBI1X2    = "ztynksyuruikguyobi1x2";
    public static final String ZTYNKSYURUIKGUYOBI1X3    = "ztynksyuruikguyobi1x3";
    public static final String ZTYNKSYURUIKGUYOBI1X4    = "ztynksyuruikguyobi1x4";
    public static final String ZTYNKSYURUIKGUYOBI1X5    = "ztynksyuruikguyobi1x5";
    public static final String ZTYNKSYURUIKGUYOBI1X6    = "ztynksyuruikguyobi1x6";
    public static final String ZTYNKSYURUIKGUYOBI1X7    = "ztynksyuruikguyobi1x7";
    public static final String ZTYNKSYURUIKGUYOBI1X8    = "ztynksyuruikguyobi1x8";
    public static final String ZTYNKSYURUIKGUYOBI1X9    = "ztynksyuruikguyobi1x9";
    public static final String ZTYNKSYURUIKGUYOBI1X10   = "ztynksyuruikguyobi1x10";
    public static final String ZTYNKSYURUIKGUYOBI1X11   = "ztynksyuruikguyobi1x11";
    public static final String ZTYNKSYURUIKGUYOBI1X12   = "ztynksyuruikguyobi1x12";
    public static final String ZTYNKSYURUIKGUYOBI1X13   = "ztynksyuruikguyobi1x13";
    public static final String ZTYNKSYURUIKGUYOBI1X14   = "ztynksyuruikguyobi1x14";
    public static final String ZTYNKSYURUIKGUYOBI1X15   = "ztynksyuruikguyobi1x15";
    public static final String ZTYNKSYURUIKGUYOBI2X1    = "ztynksyuruikguyobi2x1";
    public static final String ZTYNKSYURUIKGUYOBI2X2    = "ztynksyuruikguyobi2x2";
    public static final String ZTYNKSYURUIKGUYOBI2X3    = "ztynksyuruikguyobi2x3";
    public static final String ZTYNKSYURUIKGUYOBI2X4    = "ztynksyuruikguyobi2x4";
    public static final String ZTYNKSYURUIKGUYOBI2X5    = "ztynksyuruikguyobi2x5";
    public static final String ZTYNKSYURUIKGUYOBI2X6    = "ztynksyuruikguyobi2x6";
    public static final String ZTYNKSYURUIKGUYOBI2X7    = "ztynksyuruikguyobi2x7";
    public static final String ZTYNKSYURUIKGUYOBI2X8    = "ztynksyuruikguyobi2x8";
    public static final String ZTYNKSYURUIKGUYOBI2X9    = "ztynksyuruikguyobi2x9";
    public static final String ZTYNKSYURUIKGUYOBI2X10   = "ztynksyuruikguyobi2x10";
    public static final String ZTYNKSYURUIKGUYOBI3X1    = "ztynksyuruikguyobi3x1";
    public static final String ZTYNKSYURUIKGUYOBI3X2    = "ztynksyuruikguyobi3x2";
    public static final String ZTYNKSYURUIKGUYOBI3X3    = "ztynksyuruikguyobi3x3";
    public static final String ZTYNKSYURUIKGUYOBI3X4    = "ztynksyuruikguyobi3x4";
    public static final String ZTYNKSYURUIKGUYOBI3X5    = "ztynksyuruikguyobi3x5";
    public static final String ZTYNKSYURUIKGUYOBI3X6    = "ztynksyuruikguyobi3x6";
    public static final String ZTYNKSYURUIKGUYOBI3X7    = "ztynksyuruikguyobi3x7";
    public static final String ZTYNKSYURUIKGUYOBI3X8    = "ztynksyuruikguyobi3x8";
    public static final String ZTYNKSYURUIKGUYOBI3X9    = "ztynksyuruikguyobi3x9";
    public static final String ZTYNKSYURUIKGUYOBI3X10   = "ztynksyuruikguyobi3x10";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYNKHKNHOUTEKIYOUHYJ    = "ztynkhknhoutekiyouhyj";
    public static final String ZTYYOBIV25               = "ztyyobiv25";

    private final PKZT_NkIktHriTy primaryKey;

    public GenZT_NkIktHriTy() {
        primaryKey = new PKZT_NkIktHriTy();
    }

    public GenZT_NkIktHriTy(String pZtydatakanrino) {
        primaryKey = new PKZT_NkIktHriTy(pZtydatakanrino);
    }

    @Transient
    @Override
    public PKZT_NkIktHriTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkIktHriTy> getMetaClass() {
        return QZT_NkIktHriTy.class;
    }

    @Id
    @Column(name=GenZT_NkIktHriTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return getPrimaryKey().getZtydatakanrino();
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        getPrimaryKey().setZtydatakanrino(pZtydatakanrino);
    }

    private String ztynenkinkbn;

    @Column(name=GenZT_NkIktHriTy.ZTYNENKINKBN)
    public String getZtynenkinkbn() {
        return ztynenkinkbn;
    }

    public void setZtynenkinkbn(String pZtynenkinkbn) {
        ztynenkinkbn = pZtynenkinkbn;
    }

    private String ztynenkinsyu;

    @Column(name=GenZT_NkIktHriTy.ZTYNENKINSYU)
    public String getZtynenkinsyu() {
        return ztynenkinsyu;
    }

    public void setZtynenkinsyu(String pZtynenkinsyu) {
        ztynenkinsyu = pZtynenkinsyu;
    }

    private String ztysyokainenkinsiharaiymd;

    @Column(name=GenZT_NkIktHriTy.ZTYSYOKAINENKINSIHARAIYMD)
    public String getZtysyokainenkinsiharaiymd() {
        return ztysyokainenkinsiharaiymd;
    }

    public void setZtysyokainenkinsiharaiymd(String pZtysyokainenkinsiharaiymd) {
        ztysyokainenkinsiharaiymd = pZtysyokainenkinsiharaiymd;
    }

    private Long ztykhnnkgk;

    @Column(name=GenZT_NkIktHriTy.ZTYKHNNKGK)
    public Long getZtykhnnkgk() {
        return ztykhnnkgk;
    }

    public void setZtykhnnkgk(Long pZtykhnnkgk) {
        ztykhnnkgk = pZtykhnnkgk;
    }

    private String ztynkkaisigoyoteiriritukbn;

    @Column(name=GenZT_NkIktHriTy.ZTYNKKAISIGOYOTEIRIRITUKBN)
    public String getZtynkkaisigoyoteiriritukbn() {
        return ztynkkaisigoyoteiriritukbn;
    }

    public void setZtynkkaisigoyoteiriritukbn(String pZtynkkaisigoyoteiriritukbn) {
        ztynkkaisigoyoteiriritukbn = pZtynkkaisigoyoteiriritukbn;
    }

    private String ztysiharaikaisuukbn;

    @Column(name=GenZT_NkIktHriTy.ZTYSIHARAIKAISUUKBN)
    public String getZtysiharaikaisuukbn() {
        return ztysiharaikaisuukbn;
    }

    public void setZtysiharaikaisuukbn(String pZtysiharaikaisuukbn) {
        ztysiharaikaisuukbn = pZtysiharaikaisuukbn;
    }

    private Long ztykaimasinenkingaku;

    @Column(name=GenZT_NkIktHriTy.ZTYKAIMASINENKINGAKU)
    public Long getZtykaimasinenkingaku() {
        return ztykaimasinenkingaku;
    }

    public void setZtykaimasinenkingaku(Long pZtykaimasinenkingaku) {
        ztykaimasinenkingaku = pZtykaimasinenkingaku;
    }

    private Long ztykasannkgk;

    @Column(name=GenZT_NkIktHriTy.ZTYKASANNKGK)
    public Long getZtykasannkgk() {
        return ztykasannkgk;
    }

    public void setZtykasannkgk(Long pZtykasannkgk) {
        ztykasannkgk = pZtykasannkgk;
    }

    private Long ztyikkatubarainenkingaku;

    @Column(name=GenZT_NkIktHriTy.ZTYIKKATUBARAINENKINGAKU)
    public Long getZtyikkatubarainenkingaku() {
        return ztyikkatubarainenkingaku;
    }

    public void setZtyikkatubarainenkingaku(Long pZtyikkatubarainenkingaku) {
        ztyikkatubarainenkingaku = pZtyikkatubarainenkingaku;
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_NkIktHriTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztynksjihihokensyaage;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSJIHIHOKENSYAAGE)
    public String getZtynksjihihokensyaage() {
        return ztynksjihihokensyaage;
    }

    public void setZtynksjihihokensyaage(String pZtynksjihihokensyaage) {
        ztynksjihihokensyaage = pZtynksjihihokensyaage;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_NkIktHriTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztynknshry;

    @Column(name=GenZT_NkIktHriTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztynenkinhosyoukikan;

    @Column(name=GenZT_NkIktHriTy.ZTYNENKINHOSYOUKIKAN)
    public String getZtynenkinhosyoukikan() {
        return ztynenkinhosyoukikan;
    }

    public void setZtynenkinhosyoukikan(String pZtynenkinhosyoukikan) {
        ztynenkinhosyoukikan = pZtynenkinhosyoukikan;
    }

    private String ztynksyuruikbn;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKBN)
    public String getZtynksyuruikbn() {
        return ztynksyuruikbn;
    }

    public void setZtynksyuruikbn(String pZtynksyuruikbn) {
        ztynksyuruikbn = pZtynksyuruikbn;
    }

    private String ztyvkisoyousgoyoteirrtkbn;

    @Column(name=GenZT_NkIktHriTy.ZTYVKISOYOUSGOYOTEIRRTKBN)
    public String getZtyvkisoyousgoyoteirrtkbn() {
        return ztyvkisoyousgoyoteirrtkbn;
    }

    public void setZtyvkisoyousgoyoteirrtkbn(String pZtyvkisoyousgoyoteirrtkbn) {
        ztyvkisoyousgoyoteirrtkbn = pZtyvkisoyousgoyoteirrtkbn;
    }

    private String ztynenkinkigousedaikbn;

    @Column(name=GenZT_NkIktHriTy.ZTYNENKINKIGOUSEDAIKBN)
    public String getZtynenkinkigousedaikbn() {
        return ztynenkinkigousedaikbn;
    }

    public void setZtynenkinkigousedaikbn(String pZtynenkinkigousedaikbn) {
        ztynenkinkigousedaikbn = pZtynenkinkigousedaikbn;
    }

    private Double ztyrrthendounkyoteirrt;

    @Column(name=GenZT_NkIktHriTy.ZTYRRTHENDOUNKYOTEIRRT)
    public Double getZtyrrthendounkyoteirrt() {
        return ztyrrthendounkyoteirrt;
    }

    public void setZtyrrthendounkyoteirrt(Double pZtyrrthendounkyoteirrt) {
        ztyrrthendounkyoteirrt = pZtyrrthendounkyoteirrt;
    }

    private Long ztyznnndhssitounendshrnkgk;

    @Column(name=GenZT_NkIktHriTy.ZTYZNNNDHSSITOUNENDSHRNKGK)
    public Long getZtyznnndhssitounendshrnkgk() {
        return ztyznnndhssitounendshrnkgk;
    }

    public void setZtyznnndhssitounendshrnkgk(Long pZtyznnndhssitounendshrnkgk) {
        ztyznnndhssitounendshrnkgk = pZtyznnndhssitounendshrnkgk;
    }

    private Long ztytounendhssitunndshrnkgk;

    @Column(name=GenZT_NkIktHriTy.ZTYTOUNENDHSSITUNNDSHRNKGK)
    public Long getZtytounendhssitunndshrnkgk() {
        return ztytounendhssitunndshrnkgk;
    }

    public void setZtytounendhssitunndshrnkgk(Long pZtytounendhssitunndshrnkgk) {
        ztytounendhssitunndshrnkgk = pZtytounendhssitunndshrnkgk;
    }

    private String ztynksyuruikguyobi1x1;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X1)
    public String getZtynksyuruikguyobi1x1() {
        return ztynksyuruikguyobi1x1;
    }

    public void setZtynksyuruikguyobi1x1(String pZtynksyuruikguyobi1x1) {
        ztynksyuruikguyobi1x1 = pZtynksyuruikguyobi1x1;
    }

    private String ztynksyuruikguyobi1x2;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X2)
    public String getZtynksyuruikguyobi1x2() {
        return ztynksyuruikguyobi1x2;
    }

    public void setZtynksyuruikguyobi1x2(String pZtynksyuruikguyobi1x2) {
        ztynksyuruikguyobi1x2 = pZtynksyuruikguyobi1x2;
    }

    private String ztynksyuruikguyobi1x3;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X3)
    public String getZtynksyuruikguyobi1x3() {
        return ztynksyuruikguyobi1x3;
    }

    public void setZtynksyuruikguyobi1x3(String pZtynksyuruikguyobi1x3) {
        ztynksyuruikguyobi1x3 = pZtynksyuruikguyobi1x3;
    }

    private String ztynksyuruikguyobi1x4;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X4)
    public String getZtynksyuruikguyobi1x4() {
        return ztynksyuruikguyobi1x4;
    }

    public void setZtynksyuruikguyobi1x4(String pZtynksyuruikguyobi1x4) {
        ztynksyuruikguyobi1x4 = pZtynksyuruikguyobi1x4;
    }

    private String ztynksyuruikguyobi1x5;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X5)
    public String getZtynksyuruikguyobi1x5() {
        return ztynksyuruikguyobi1x5;
    }

    public void setZtynksyuruikguyobi1x5(String pZtynksyuruikguyobi1x5) {
        ztynksyuruikguyobi1x5 = pZtynksyuruikguyobi1x5;
    }

    private String ztynksyuruikguyobi1x6;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X6)
    public String getZtynksyuruikguyobi1x6() {
        return ztynksyuruikguyobi1x6;
    }

    public void setZtynksyuruikguyobi1x6(String pZtynksyuruikguyobi1x6) {
        ztynksyuruikguyobi1x6 = pZtynksyuruikguyobi1x6;
    }

    private String ztynksyuruikguyobi1x7;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X7)
    public String getZtynksyuruikguyobi1x7() {
        return ztynksyuruikguyobi1x7;
    }

    public void setZtynksyuruikguyobi1x7(String pZtynksyuruikguyobi1x7) {
        ztynksyuruikguyobi1x7 = pZtynksyuruikguyobi1x7;
    }

    private String ztynksyuruikguyobi1x8;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X8)
    public String getZtynksyuruikguyobi1x8() {
        return ztynksyuruikguyobi1x8;
    }

    public void setZtynksyuruikguyobi1x8(String pZtynksyuruikguyobi1x8) {
        ztynksyuruikguyobi1x8 = pZtynksyuruikguyobi1x8;
    }

    private String ztynksyuruikguyobi1x9;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X9)
    public String getZtynksyuruikguyobi1x9() {
        return ztynksyuruikguyobi1x9;
    }

    public void setZtynksyuruikguyobi1x9(String pZtynksyuruikguyobi1x9) {
        ztynksyuruikguyobi1x9 = pZtynksyuruikguyobi1x9;
    }

    private String ztynksyuruikguyobi1x10;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X10)
    public String getZtynksyuruikguyobi1x10() {
        return ztynksyuruikguyobi1x10;
    }

    public void setZtynksyuruikguyobi1x10(String pZtynksyuruikguyobi1x10) {
        ztynksyuruikguyobi1x10 = pZtynksyuruikguyobi1x10;
    }

    private String ztynksyuruikguyobi1x11;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X11)
    public String getZtynksyuruikguyobi1x11() {
        return ztynksyuruikguyobi1x11;
    }

    public void setZtynksyuruikguyobi1x11(String pZtynksyuruikguyobi1x11) {
        ztynksyuruikguyobi1x11 = pZtynksyuruikguyobi1x11;
    }

    private String ztynksyuruikguyobi1x12;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X12)
    public String getZtynksyuruikguyobi1x12() {
        return ztynksyuruikguyobi1x12;
    }

    public void setZtynksyuruikguyobi1x12(String pZtynksyuruikguyobi1x12) {
        ztynksyuruikguyobi1x12 = pZtynksyuruikguyobi1x12;
    }

    private String ztynksyuruikguyobi1x13;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X13)
    public String getZtynksyuruikguyobi1x13() {
        return ztynksyuruikguyobi1x13;
    }

    public void setZtynksyuruikguyobi1x13(String pZtynksyuruikguyobi1x13) {
        ztynksyuruikguyobi1x13 = pZtynksyuruikguyobi1x13;
    }

    private String ztynksyuruikguyobi1x14;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X14)
    public String getZtynksyuruikguyobi1x14() {
        return ztynksyuruikguyobi1x14;
    }

    public void setZtynksyuruikguyobi1x14(String pZtynksyuruikguyobi1x14) {
        ztynksyuruikguyobi1x14 = pZtynksyuruikguyobi1x14;
    }

    private String ztynksyuruikguyobi1x15;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI1X15)
    public String getZtynksyuruikguyobi1x15() {
        return ztynksyuruikguyobi1x15;
    }

    public void setZtynksyuruikguyobi1x15(String pZtynksyuruikguyobi1x15) {
        ztynksyuruikguyobi1x15 = pZtynksyuruikguyobi1x15;
    }

    private String ztynksyuruikguyobi2x1;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X1)
    public String getZtynksyuruikguyobi2x1() {
        return ztynksyuruikguyobi2x1;
    }

    public void setZtynksyuruikguyobi2x1(String pZtynksyuruikguyobi2x1) {
        ztynksyuruikguyobi2x1 = pZtynksyuruikguyobi2x1;
    }

    private String ztynksyuruikguyobi2x2;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X2)
    public String getZtynksyuruikguyobi2x2() {
        return ztynksyuruikguyobi2x2;
    }

    public void setZtynksyuruikguyobi2x2(String pZtynksyuruikguyobi2x2) {
        ztynksyuruikguyobi2x2 = pZtynksyuruikguyobi2x2;
    }

    private String ztynksyuruikguyobi2x3;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X3)
    public String getZtynksyuruikguyobi2x3() {
        return ztynksyuruikguyobi2x3;
    }

    public void setZtynksyuruikguyobi2x3(String pZtynksyuruikguyobi2x3) {
        ztynksyuruikguyobi2x3 = pZtynksyuruikguyobi2x3;
    }

    private String ztynksyuruikguyobi2x4;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X4)
    public String getZtynksyuruikguyobi2x4() {
        return ztynksyuruikguyobi2x4;
    }

    public void setZtynksyuruikguyobi2x4(String pZtynksyuruikguyobi2x4) {
        ztynksyuruikguyobi2x4 = pZtynksyuruikguyobi2x4;
    }

    private String ztynksyuruikguyobi2x5;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X5)
    public String getZtynksyuruikguyobi2x5() {
        return ztynksyuruikguyobi2x5;
    }

    public void setZtynksyuruikguyobi2x5(String pZtynksyuruikguyobi2x5) {
        ztynksyuruikguyobi2x5 = pZtynksyuruikguyobi2x5;
    }

    private String ztynksyuruikguyobi2x6;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X6)
    public String getZtynksyuruikguyobi2x6() {
        return ztynksyuruikguyobi2x6;
    }

    public void setZtynksyuruikguyobi2x6(String pZtynksyuruikguyobi2x6) {
        ztynksyuruikguyobi2x6 = pZtynksyuruikguyobi2x6;
    }

    private String ztynksyuruikguyobi2x7;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X7)
    public String getZtynksyuruikguyobi2x7() {
        return ztynksyuruikguyobi2x7;
    }

    public void setZtynksyuruikguyobi2x7(String pZtynksyuruikguyobi2x7) {
        ztynksyuruikguyobi2x7 = pZtynksyuruikguyobi2x7;
    }

    private String ztynksyuruikguyobi2x8;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X8)
    public String getZtynksyuruikguyobi2x8() {
        return ztynksyuruikguyobi2x8;
    }

    public void setZtynksyuruikguyobi2x8(String pZtynksyuruikguyobi2x8) {
        ztynksyuruikguyobi2x8 = pZtynksyuruikguyobi2x8;
    }

    private String ztynksyuruikguyobi2x9;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X9)
    public String getZtynksyuruikguyobi2x9() {
        return ztynksyuruikguyobi2x9;
    }

    public void setZtynksyuruikguyobi2x9(String pZtynksyuruikguyobi2x9) {
        ztynksyuruikguyobi2x9 = pZtynksyuruikguyobi2x9;
    }

    private String ztynksyuruikguyobi2x10;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI2X10)
    public String getZtynksyuruikguyobi2x10() {
        return ztynksyuruikguyobi2x10;
    }

    public void setZtynksyuruikguyobi2x10(String pZtynksyuruikguyobi2x10) {
        ztynksyuruikguyobi2x10 = pZtynksyuruikguyobi2x10;
    }

    private String ztynksyuruikguyobi3x1;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X1)
    public String getZtynksyuruikguyobi3x1() {
        return ztynksyuruikguyobi3x1;
    }

    public void setZtynksyuruikguyobi3x1(String pZtynksyuruikguyobi3x1) {
        ztynksyuruikguyobi3x1 = pZtynksyuruikguyobi3x1;
    }

    private String ztynksyuruikguyobi3x2;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X2)
    public String getZtynksyuruikguyobi3x2() {
        return ztynksyuruikguyobi3x2;
    }

    public void setZtynksyuruikguyobi3x2(String pZtynksyuruikguyobi3x2) {
        ztynksyuruikguyobi3x2 = pZtynksyuruikguyobi3x2;
    }

    private String ztynksyuruikguyobi3x3;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X3)
    public String getZtynksyuruikguyobi3x3() {
        return ztynksyuruikguyobi3x3;
    }

    public void setZtynksyuruikguyobi3x3(String pZtynksyuruikguyobi3x3) {
        ztynksyuruikguyobi3x3 = pZtynksyuruikguyobi3x3;
    }

    private String ztynksyuruikguyobi3x4;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X4)
    public String getZtynksyuruikguyobi3x4() {
        return ztynksyuruikguyobi3x4;
    }

    public void setZtynksyuruikguyobi3x4(String pZtynksyuruikguyobi3x4) {
        ztynksyuruikguyobi3x4 = pZtynksyuruikguyobi3x4;
    }

    private String ztynksyuruikguyobi3x5;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X5)
    public String getZtynksyuruikguyobi3x5() {
        return ztynksyuruikguyobi3x5;
    }

    public void setZtynksyuruikguyobi3x5(String pZtynksyuruikguyobi3x5) {
        ztynksyuruikguyobi3x5 = pZtynksyuruikguyobi3x5;
    }

    private String ztynksyuruikguyobi3x6;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X6)
    public String getZtynksyuruikguyobi3x6() {
        return ztynksyuruikguyobi3x6;
    }

    public void setZtynksyuruikguyobi3x6(String pZtynksyuruikguyobi3x6) {
        ztynksyuruikguyobi3x6 = pZtynksyuruikguyobi3x6;
    }

    private String ztynksyuruikguyobi3x7;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X7)
    public String getZtynksyuruikguyobi3x7() {
        return ztynksyuruikguyobi3x7;
    }

    public void setZtynksyuruikguyobi3x7(String pZtynksyuruikguyobi3x7) {
        ztynksyuruikguyobi3x7 = pZtynksyuruikguyobi3x7;
    }

    private String ztynksyuruikguyobi3x8;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X8)
    public String getZtynksyuruikguyobi3x8() {
        return ztynksyuruikguyobi3x8;
    }

    public void setZtynksyuruikguyobi3x8(String pZtynksyuruikguyobi3x8) {
        ztynksyuruikguyobi3x8 = pZtynksyuruikguyobi3x8;
    }

    private String ztynksyuruikguyobi3x9;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X9)
    public String getZtynksyuruikguyobi3x9() {
        return ztynksyuruikguyobi3x9;
    }

    public void setZtynksyuruikguyobi3x9(String pZtynksyuruikguyobi3x9) {
        ztynksyuruikguyobi3x9 = pZtynksyuruikguyobi3x9;
    }

    private String ztynksyuruikguyobi3x10;

    @Column(name=GenZT_NkIktHriTy.ZTYNKSYURUIKGUYOBI3X10)
    public String getZtynksyuruikguyobi3x10() {
        return ztynksyuruikguyobi3x10;
    }

    public void setZtynksyuruikguyobi3x10(String pZtynksyuruikguyobi3x10) {
        ztynksyuruikguyobi3x10 = pZtynksyuruikguyobi3x10;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_NkIktHriTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_NkIktHriTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztynkhknhoutekiyouhyj;

    @Column(name=GenZT_NkIktHriTy.ZTYNKHKNHOUTEKIYOUHYJ)
    public String getZtynkhknhoutekiyouhyj() {
        return ztynkhknhoutekiyouhyj;
    }

    public void setZtynkhknhoutekiyouhyj(String pZtynkhknhoutekiyouhyj) {
        ztynkhknhoutekiyouhyj = pZtynkhknhoutekiyouhyj;
    }

    private String ztyyobiv25;

    @Column(name=GenZT_NkIktHriTy.ZTYYOBIV25)
    public String getZtyyobiv25() {
        return ztyyobiv25;
    }

    public void setZtyyobiv25(String pZtyyobiv25) {
        ztyyobiv25 = pZtyyobiv25;
    }
}
