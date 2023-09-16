package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_OuNnknShrTy;
import yuyu.def.db.id.PKZT_OuNnknShrTy;
import yuyu.def.db.meta.GenQZT_OuNnknShrTy;
import yuyu.def.db.meta.QZT_OuNnknShrTy;

/**
 * ＯＵ用年金支払テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_OuNnknShrTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_OuNnknShrTy}</td><td colspan="3">ＯＵ用年金支払テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_OuNnknShrTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaisosikicd ztysiharaisosikicd}</td><td>（中継用）支払組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikohasseiymd ztyjikohasseiymd}</td><td>（中継用）事故発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytukigakunengakukbn ztytukigakunengakukbn}</td><td>（中継用）月額年額区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhnnkgk ztykhnnkgk}</td><td>（中継用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakunenkingaku ztykeiyakunenkingaku}</td><td>（中継用）契約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykasannkgk ztykasannkgk}</td><td>（中継用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyuwanosenenkingaku ztyuwanosenenkingaku}</td><td>（中継用）上乗せ年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysasihikisiharaigaku ztysasihikisiharaigaku}</td><td>（中継用）差引支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiharainenkingaku ztysiharainenkingaku}</td><td>（中継用）支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiboujikyuuhukingaku ztysiboujikyuuhukingaku}</td><td>（中継用）死亡時給付金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiharaid ztysiharaid}</td><td>（中継用）支払Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygensentyousyuuzeigaku ztygensentyousyuuzeigaku}</td><td>（中継用）源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonotasiharaikingaku ztysonotasiharaikingaku}</td><td>（中継用）その他支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyttkekstkjyutukngk ztyttkekstkjyutukngk}</td><td>（中継用）立替貸付充当金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkingakurank ztynenkingakurank}</td><td>（中継用）年金額ランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn ztynksyuruikbn}</td><td>（中継用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorinaiyoukbn ztysyorinaiyoukbn}</td><td>（中継用）処理内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsiharaihouhoukbn ztynenkinsiharaihouhoukbn}</td><td>（中継用）年金支払方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinhanbaimeisyou ztynenkinhanbaimeisyou}</td><td>（中継用）年金販売名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkbn ztynenkinkbn}</td><td>（中継用）年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsyu ztynenkinsyu}</td><td>（中継用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymotokeiyakusyouhinkbn ztymotokeiyakusyouhinkbn}</td><td>（中継用）元契約商品区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrhasseiriyuukbn ztynkshrhasseiriyuukbn}</td><td>（中継用）年金支払発生理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinhosyoukikan ztynenkinhosyoukikan}</td><td>（中継用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykknsetymd ztykknsetymd}</td><td>（中継用）基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokainenkinsiharaiymd ztysyokainenkinsiharaiymd}</td><td>（中継用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjihihokensyaage ztynksjihihokensyaage}</td><td>（中継用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyaseibetukbn ztydai2hihokensyaseibetukbn}</td><td>（中継用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjidai2hhknsyaage ztynksjidai2hhknsyaage}</td><td>（中継用）年金開始時第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkuketorininkbn ztynkuketorininkbn}</td><td>（中継用）年金受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkuktrnnhukusuuninzuu ztynkuktrnnhukusuuninzuu}</td><td>（中継用）年金受取人複数人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhihokensyasibouymd ztyhihokensyasibouymd}</td><td>（中継用）被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyasibouymd ztydai2hihokensyasibouymd}</td><td>（中継用）第２被保険者死亡年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhoujinuketorininhyouji ztyhoujinuketorininhyouji}</td><td>（中継用）法人受取人表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynktouduketorihouhoukbn ztynktouduketorihouhoukbn}</td><td>（中継用）年金当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytatekaearihyouji ztytatekaearihyouji}</td><td>（中継用）立替有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasitukearihyouji ztykasitukearihyouji}</td><td>（中継用）貸付有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuarihyouji ztytokuyakuarihyouji}</td><td>（中継用）特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkzeiseitekikakutkykkbn ztynkzeiseitekikakutkykkbn}</td><td>（中継用）年金税制適格特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaikaisuukbn ztysiharaikaisuukbn}</td><td>（中継用）支払回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymotokykhrkhouhoukbn ztymotokykhrkhouhoukbn}</td><td>（中継用）元契約払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisikakymd ztyseisikakymd}</td><td>（中継用）生死確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysegcd ztysegcd}</td><td>（中継用）セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkigousedaikbn ztynenkinkigousedaikbn}</td><td>（中継用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten1oyacd ztydairiten1oyacd}</td><td>（中継用）代理店１親コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten1oyakanjinm ztydairiten1oyakanjinm}</td><td>（中継用）代理店１親漢字名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten2oyacd ztydairiten2oyacd}</td><td>（中継用）代理店２親コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten2oyakanjinm ztydairiten2oyakanjinm}</td><td>（中継用）代理店２親漢字名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten1cd ztydairiten1cd}</td><td>（中継用）代理店１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten1kanjinm ztydairiten1kanjinm}</td><td>（中継用）代理店１漢字名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin1cd ztybosyuunin1cd}</td><td>（中継用）募集人１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuu1kanjinm ztybosyuu1kanjinm}</td><td>（中継用）募集人１漢字名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten2cd ztydairiten2cd}</td><td>（中継用）代理店２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten2kanjinm ztydairiten2kanjinm}</td><td>（中継用）代理店２漢字名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin2cd ztybosyuunin2cd}</td><td>（中継用）募集人２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuu2kanjinm ztybosyuu2kanjinm}</td><td>（中継用）募集人２漢字名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankcd ztybankcd}</td><td>（中継用）銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshitencd ztyshitencd}</td><td>（中継用）支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv71 ztyyobiv71}</td><td>（中継用）予備項目Ｖ７１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_OuNnknShrTy
 * @see     PKZT_OuNnknShrTy
 * @see     QZT_OuNnknShrTy
 * @see     GenQZT_OuNnknShrTy
 */
@MappedSuperclass
@Table(name=GenZT_OuNnknShrTy.TABLE_NAME)
@IdClass(value=PKZT_OuNnknShrTy.class)
public abstract class GenZT_OuNnknShrTy extends AbstractExDBEntity<ZT_OuNnknShrTy, PKZT_OuNnknShrTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_OuNnknShrTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYKIJYUNYM              = "ztykijyunym";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYNKSYOUSYONO           = "ztynksyousyono";
    public static final String ZTYSIHARAISOSIKICD       = "ztysiharaisosikicd";
    public static final String ZTYJIKOHASSEIYMD         = "ztyjikohasseiymd";
    public static final String ZTYTUKIGAKUNENGAKUKBN    = "ztytukigakunengakukbn";
    public static final String ZTYKHNNKGK               = "ztykhnnkgk";
    public static final String ZTYKEIYAKUNENKINGAKU     = "ztykeiyakunenkingaku";
    public static final String ZTYKASANNKGK             = "ztykasannkgk";
    public static final String ZTYUWANOSENENKINGAKU     = "ztyuwanosenenkingaku";
    public static final String ZTYSASIHIKISIHARAIGAKU   = "ztysasihikisiharaigaku";
    public static final String ZTYSIHARAINENKINGAKU     = "ztysiharainenkingaku";
    public static final String ZTYSIBOUJIKYUUHUKINGAKU  = "ztysiboujikyuuhukingaku";
    public static final String ZTYSIHARAID              = "ztysiharaid";
    public static final String ZTYGENSENTYOUSYUUZEIGAKU = "ztygensentyousyuuzeigaku";
    public static final String ZTYSONOTASIHARAIKINGAKU  = "ztysonotasiharaikingaku";
    public static final String ZTYTTKEKSTKJYUTUKNGK     = "ztyttkekstkjyutukngk";
    public static final String ZTYNENKINGAKURANK        = "ztynenkingakurank";
    public static final String ZTYNKSYURUIKBN           = "ztynksyuruikbn";
    public static final String ZTYSYORINAIYOUKBN        = "ztysyorinaiyoukbn";
    public static final String ZTYNENKINSIHARAIHOUHOUKBN = "ztynenkinsiharaihouhoukbn";
    public static final String ZTYNENKINHANBAIMEISYOU   = "ztynenkinhanbaimeisyou";
    public static final String ZTYNENKINKBN             = "ztynenkinkbn";
    public static final String ZTYNENKINSYU             = "ztynenkinsyu";
    public static final String ZTYMOTOKEIYAKUSYOUHINKBN = "ztymotokeiyakusyouhinkbn";
    public static final String ZTYNKSHRHASSEIRIYUUKBN   = "ztynkshrhasseiriyuukbn";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYNENKINHOSYOUKIKAN     = "ztynenkinhosyoukikan";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYKKNSETYMD             = "ztykknsetymd";
    public static final String ZTYSYOKAINENKINSIHARAIYMD = "ztysyokainenkinsiharaiymd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYNKSJIHIHOKENSYAAGE    = "ztynksjihihokensyaage";
    public static final String ZTYDAI2HIHOKENSYASEIBETUKBN = "ztydai2hihokensyaseibetukbn";
    public static final String ZTYNKSJIDAI2HHKNSYAAGE   = "ztynksjidai2hhknsyaage";
    public static final String ZTYNKUKETORININKBN       = "ztynkuketorininkbn";
    public static final String ZTYNKUKTRNNHUKUSUUNINZUU = "ztynkuktrnnhukusuuninzuu";
    public static final String ZTYHIHOKENSYASIBOUYMD    = "ztyhihokensyasibouymd";
    public static final String ZTYDAI2HIHOKENSYASIBOUYMD = "ztydai2hihokensyasibouymd";
    public static final String ZTYHOUJINUKETORININHYOUJI = "ztyhoujinuketorininhyouji";
    public static final String ZTYNKTOUDUKETORIHOUHOUKBN = "ztynktouduketorihouhoukbn";
    public static final String ZTYTATEKAEARIHYOUJI      = "ztytatekaearihyouji";
    public static final String ZTYKASITUKEARIHYOUJI     = "ztykasitukearihyouji";
    public static final String ZTYTOKUYAKUARIHYOUJI     = "ztytokuyakuarihyouji";
    public static final String ZTYNKZEISEITEKIKAKUTKYKKBN = "ztynkzeiseitekikakutkykkbn";
    public static final String ZTYSIHARAIKAISUUKBN      = "ztysiharaikaisuukbn";
    public static final String ZTYMOTOKYKHRKHOUHOUKBN   = "ztymotokykhrkhouhoukbn";
    public static final String ZTYSEISIKAKYMD           = "ztyseisikakymd";
    public static final String ZTYSEGCD                 = "ztysegcd";
    public static final String ZTYNENKINKIGOUSEDAIKBN   = "ztynenkinkigousedaikbn";
    public static final String ZTYDAIRITEN1OYACD        = "ztydairiten1oyacd";
    public static final String ZTYDAIRITEN1OYAKANJINM   = "ztydairiten1oyakanjinm";
    public static final String ZTYDAIRITEN2OYACD        = "ztydairiten2oyacd";
    public static final String ZTYDAIRITEN2OYAKANJINM   = "ztydairiten2oyakanjinm";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYDAIRITEN1CD           = "ztydairiten1cd";
    public static final String ZTYDAIRITEN1KANJINM      = "ztydairiten1kanjinm";
    public static final String ZTYBOSYUUNIN1CD          = "ztybosyuunin1cd";
    public static final String ZTYBOSYUU1KANJINM        = "ztybosyuu1kanjinm";
    public static final String ZTYDAIRITEN2CD           = "ztydairiten2cd";
    public static final String ZTYDAIRITEN2KANJINM      = "ztydairiten2kanjinm";
    public static final String ZTYBOSYUUNIN2CD          = "ztybosyuunin2cd";
    public static final String ZTYBOSYUU2KANJINM        = "ztybosyuu2kanjinm";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYBANKCD                = "ztybankcd";
    public static final String ZTYSHITENCD              = "ztyshitencd";
    public static final String ZTYYOBIV71               = "ztyyobiv71";

    private final PKZT_OuNnknShrTy primaryKey;

    public GenZT_OuNnknShrTy() {
        primaryKey = new PKZT_OuNnknShrTy();
    }

    public GenZT_OuNnknShrTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_OuNnknShrTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_OuNnknShrTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_OuNnknShrTy> getMetaClass() {
        return QZT_OuNnknShrTy.class;
    }

    @Id
    @Column(name=GenZT_OuNnknShrTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztykijyunym;

    @Column(name=GenZT_OuNnknShrTy.ZTYKIJYUNYM)
    public String getZtykijyunym() {
        return ztykijyunym;
    }

    public void setZtykijyunym(String pZtykijyunym) {
        ztykijyunym = pZtykijyunym;
    }

    private String ztysyoricd;

    @Column(name=GenZT_OuNnknShrTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztydenymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztynksyousyono;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKSYOUSYONO)
    public String getZtynksyousyono() {
        return ztynksyousyono;
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

    private String ztysiharaisosikicd;

    @Column(name=GenZT_OuNnknShrTy.ZTYSIHARAISOSIKICD)
    public String getZtysiharaisosikicd() {
        return ztysiharaisosikicd;
    }

    public void setZtysiharaisosikicd(String pZtysiharaisosikicd) {
        ztysiharaisosikicd = pZtysiharaisosikicd;
    }

    private String ztyjikohasseiymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYJIKOHASSEIYMD)
    public String getZtyjikohasseiymd() {
        return ztyjikohasseiymd;
    }

    public void setZtyjikohasseiymd(String pZtyjikohasseiymd) {
        ztyjikohasseiymd = pZtyjikohasseiymd;
    }

    private String ztytukigakunengakukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYTUKIGAKUNENGAKUKBN)
    public String getZtytukigakunengakukbn() {
        return ztytukigakunengakukbn;
    }

    public void setZtytukigakunengakukbn(String pZtytukigakunengakukbn) {
        ztytukigakunengakukbn = pZtytukigakunengakukbn;
    }

    private Long ztykhnnkgk;

    @Column(name=GenZT_OuNnknShrTy.ZTYKHNNKGK)
    public Long getZtykhnnkgk() {
        return ztykhnnkgk;
    }

    public void setZtykhnnkgk(Long pZtykhnnkgk) {
        ztykhnnkgk = pZtykhnnkgk;
    }

    private Long ztykeiyakunenkingaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYKEIYAKUNENKINGAKU)
    public Long getZtykeiyakunenkingaku() {
        return ztykeiyakunenkingaku;
    }

    public void setZtykeiyakunenkingaku(Long pZtykeiyakunenkingaku) {
        ztykeiyakunenkingaku = pZtykeiyakunenkingaku;
    }

    private Long ztykasannkgk;

    @Column(name=GenZT_OuNnknShrTy.ZTYKASANNKGK)
    public Long getZtykasannkgk() {
        return ztykasannkgk;
    }

    public void setZtykasannkgk(Long pZtykasannkgk) {
        ztykasannkgk = pZtykasannkgk;
    }

    private Long ztyuwanosenenkingaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYUWANOSENENKINGAKU)
    public Long getZtyuwanosenenkingaku() {
        return ztyuwanosenenkingaku;
    }

    public void setZtyuwanosenenkingaku(Long pZtyuwanosenenkingaku) {
        ztyuwanosenenkingaku = pZtyuwanosenenkingaku;
    }

    private Long ztysasihikisiharaigaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYSASIHIKISIHARAIGAKU)
    public Long getZtysasihikisiharaigaku() {
        return ztysasihikisiharaigaku;
    }

    public void setZtysasihikisiharaigaku(Long pZtysasihikisiharaigaku) {
        ztysasihikisiharaigaku = pZtysasihikisiharaigaku;
    }

    private Long ztysiharainenkingaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYSIHARAINENKINGAKU)
    public Long getZtysiharainenkingaku() {
        return ztysiharainenkingaku;
    }

    public void setZtysiharainenkingaku(Long pZtysiharainenkingaku) {
        ztysiharainenkingaku = pZtysiharainenkingaku;
    }

    private Long ztysiboujikyuuhukingaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYSIBOUJIKYUUHUKINGAKU)
    public Long getZtysiboujikyuuhukingaku() {
        return ztysiboujikyuuhukingaku;
    }

    public void setZtysiboujikyuuhukingaku(Long pZtysiboujikyuuhukingaku) {
        ztysiboujikyuuhukingaku = pZtysiboujikyuuhukingaku;
    }

    private Long ztysiharaid;

    @Column(name=GenZT_OuNnknShrTy.ZTYSIHARAID)
    public Long getZtysiharaid() {
        return ztysiharaid;
    }

    public void setZtysiharaid(Long pZtysiharaid) {
        ztysiharaid = pZtysiharaid;
    }

    private Long ztygensentyousyuuzeigaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYGENSENTYOUSYUUZEIGAKU)
    public Long getZtygensentyousyuuzeigaku() {
        return ztygensentyousyuuzeigaku;
    }

    public void setZtygensentyousyuuzeigaku(Long pZtygensentyousyuuzeigaku) {
        ztygensentyousyuuzeigaku = pZtygensentyousyuuzeigaku;
    }

    private Long ztysonotasiharaikingaku;

    @Column(name=GenZT_OuNnknShrTy.ZTYSONOTASIHARAIKINGAKU)
    public Long getZtysonotasiharaikingaku() {
        return ztysonotasiharaikingaku;
    }

    public void setZtysonotasiharaikingaku(Long pZtysonotasiharaikingaku) {
        ztysonotasiharaikingaku = pZtysonotasiharaikingaku;
    }

    private Long ztyttkekstkjyutukngk;

    @Column(name=GenZT_OuNnknShrTy.ZTYTTKEKSTKJYUTUKNGK)
    public Long getZtyttkekstkjyutukngk() {
        return ztyttkekstkjyutukngk;
    }

    public void setZtyttkekstkjyutukngk(Long pZtyttkekstkjyutukngk) {
        ztyttkekstkjyutukngk = pZtyttkekstkjyutukngk;
    }

    private String ztynenkingakurank;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINGAKURANK)
    public String getZtynenkingakurank() {
        return ztynenkingakurank;
    }

    public void setZtynenkingakurank(String pZtynenkingakurank) {
        ztynenkingakurank = pZtynenkingakurank;
    }

    private String ztynksyuruikbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKSYURUIKBN)
    public String getZtynksyuruikbn() {
        return ztynksyuruikbn;
    }

    public void setZtynksyuruikbn(String pZtynksyuruikbn) {
        ztynksyuruikbn = pZtynksyuruikbn;
    }

    private String ztysyorinaiyoukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYSYORINAIYOUKBN)
    public String getZtysyorinaiyoukbn() {
        return ztysyorinaiyoukbn;
    }

    public void setZtysyorinaiyoukbn(String pZtysyorinaiyoukbn) {
        ztysyorinaiyoukbn = pZtysyorinaiyoukbn;
    }

    private String ztynenkinsiharaihouhoukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINSIHARAIHOUHOUKBN)
    public String getZtynenkinsiharaihouhoukbn() {
        return ztynenkinsiharaihouhoukbn;
    }

    public void setZtynenkinsiharaihouhoukbn(String pZtynenkinsiharaihouhoukbn) {
        ztynenkinsiharaihouhoukbn = pZtynenkinsiharaihouhoukbn;
    }

    private String ztynenkinhanbaimeisyou;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINHANBAIMEISYOU)
    public String getZtynenkinhanbaimeisyou() {
        return ztynenkinhanbaimeisyou;
    }

    public void setZtynenkinhanbaimeisyou(String pZtynenkinhanbaimeisyou) {
        ztynenkinhanbaimeisyou = pZtynenkinhanbaimeisyou;
    }

    private String ztynenkinkbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINKBN)
    public String getZtynenkinkbn() {
        return ztynenkinkbn;
    }

    public void setZtynenkinkbn(String pZtynenkinkbn) {
        ztynenkinkbn = pZtynenkinkbn;
    }

    private String ztynenkinsyu;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINSYU)
    public String getZtynenkinsyu() {
        return ztynenkinsyu;
    }

    public void setZtynenkinsyu(String pZtynenkinsyu) {
        ztynenkinsyu = pZtynenkinsyu;
    }

    private String ztymotokeiyakusyouhinkbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYMOTOKEIYAKUSYOUHINKBN)
    public String getZtymotokeiyakusyouhinkbn() {
        return ztymotokeiyakusyouhinkbn;
    }

    public void setZtymotokeiyakusyouhinkbn(String pZtymotokeiyakusyouhinkbn) {
        ztymotokeiyakusyouhinkbn = pZtymotokeiyakusyouhinkbn;
    }

    private String ztynkshrhasseiriyuukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKSHRHASSEIRIYUUKBN)
    public String getZtynkshrhasseiriyuukbn() {
        return ztynkshrhasseiriyuukbn;
    }

    public void setZtynkshrhasseiriyuukbn(String pZtynkshrhasseiriyuukbn) {
        ztynkshrhasseiriyuukbn = pZtynkshrhasseiriyuukbn;
    }

    private String ztynknshry;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztynenkinhosyoukikan;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINHOSYOUKIKAN)
    public String getZtynenkinhosyoukikan() {
        return ztynenkinhosyoukikan;
    }

    public void setZtynenkinhosyoukikan(String pZtynenkinhosyoukikan) {
        ztynenkinhosyoukikan = pZtynenkinhosyoukikan;
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztykknsetymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYKKNSETYMD)
    public String getZtykknsetymd() {
        return ztykknsetymd;
    }

    public void setZtykknsetymd(String pZtykknsetymd) {
        ztykknsetymd = pZtykknsetymd;
    }

    private String ztysyokainenkinsiharaiymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYSYOKAINENKINSIHARAIYMD)
    public String getZtysyokainenkinsiharaiymd() {
        return ztysyokainenkinsiharaiymd;
    }

    public void setZtysyokainenkinsiharaiymd(String pZtysyokainenkinsiharaiymd) {
        ztysyokainenkinsiharaiymd = pZtysyokainenkinsiharaiymd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztynksjihihokensyaage;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKSJIHIHOKENSYAAGE)
    public String getZtynksjihihokensyaage() {
        return ztynksjihihokensyaage;
    }

    public void setZtynksjihihokensyaage(String pZtynksjihihokensyaage) {
        ztynksjihihokensyaage = pZtynksjihihokensyaage;
    }

    private String ztydai2hihokensyaseibetukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAI2HIHOKENSYASEIBETUKBN)
    public String getZtydai2hihokensyaseibetukbn() {
        return ztydai2hihokensyaseibetukbn;
    }

    public void setZtydai2hihokensyaseibetukbn(String pZtydai2hihokensyaseibetukbn) {
        ztydai2hihokensyaseibetukbn = pZtydai2hihokensyaseibetukbn;
    }

    private String ztynksjidai2hhknsyaage;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKSJIDAI2HHKNSYAAGE)
    public String getZtynksjidai2hhknsyaage() {
        return ztynksjidai2hhknsyaage;
    }

    public void setZtynksjidai2hhknsyaage(String pZtynksjidai2hhknsyaage) {
        ztynksjidai2hhknsyaage = pZtynksjidai2hhknsyaage;
    }

    private String ztynkuketorininkbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKUKETORININKBN)
    public String getZtynkuketorininkbn() {
        return ztynkuketorininkbn;
    }

    public void setZtynkuketorininkbn(String pZtynkuketorininkbn) {
        ztynkuketorininkbn = pZtynkuketorininkbn;
    }

    private Long ztynkuktrnnhukusuuninzuu;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKUKTRNNHUKUSUUNINZUU)
    public Long getZtynkuktrnnhukusuuninzuu() {
        return ztynkuktrnnhukusuuninzuu;
    }

    public void setZtynkuktrnnhukusuuninzuu(Long pZtynkuktrnnhukusuuninzuu) {
        ztynkuktrnnhukusuuninzuu = pZtynkuktrnnhukusuuninzuu;
    }

    private String ztyhihokensyasibouymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYHIHOKENSYASIBOUYMD)
    public String getZtyhihokensyasibouymd() {
        return ztyhihokensyasibouymd;
    }

    public void setZtyhihokensyasibouymd(String pZtyhihokensyasibouymd) {
        ztyhihokensyasibouymd = pZtyhihokensyasibouymd;
    }

    private String ztydai2hihokensyasibouymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAI2HIHOKENSYASIBOUYMD)
    public String getZtydai2hihokensyasibouymd() {
        return ztydai2hihokensyasibouymd;
    }

    public void setZtydai2hihokensyasibouymd(String pZtydai2hihokensyasibouymd) {
        ztydai2hihokensyasibouymd = pZtydai2hihokensyasibouymd;
    }

    private String ztyhoujinuketorininhyouji;

    @Column(name=GenZT_OuNnknShrTy.ZTYHOUJINUKETORININHYOUJI)
    public String getZtyhoujinuketorininhyouji() {
        return ztyhoujinuketorininhyouji;
    }

    public void setZtyhoujinuketorininhyouji(String pZtyhoujinuketorininhyouji) {
        ztyhoujinuketorininhyouji = pZtyhoujinuketorininhyouji;
    }

    private String ztynktouduketorihouhoukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKTOUDUKETORIHOUHOUKBN)
    public String getZtynktouduketorihouhoukbn() {
        return ztynktouduketorihouhoukbn;
    }

    public void setZtynktouduketorihouhoukbn(String pZtynktouduketorihouhoukbn) {
        ztynktouduketorihouhoukbn = pZtynktouduketorihouhoukbn;
    }

    private String ztytatekaearihyouji;

    @Column(name=GenZT_OuNnknShrTy.ZTYTATEKAEARIHYOUJI)
    public String getZtytatekaearihyouji() {
        return ztytatekaearihyouji;
    }

    public void setZtytatekaearihyouji(String pZtytatekaearihyouji) {
        ztytatekaearihyouji = pZtytatekaearihyouji;
    }

    private String ztykasitukearihyouji;

    @Column(name=GenZT_OuNnknShrTy.ZTYKASITUKEARIHYOUJI)
    public String getZtykasitukearihyouji() {
        return ztykasitukearihyouji;
    }

    public void setZtykasitukearihyouji(String pZtykasitukearihyouji) {
        ztykasitukearihyouji = pZtykasitukearihyouji;
    }

    private String ztytokuyakuarihyouji;

    @Column(name=GenZT_OuNnknShrTy.ZTYTOKUYAKUARIHYOUJI)
    public String getZtytokuyakuarihyouji() {
        return ztytokuyakuarihyouji;
    }

    public void setZtytokuyakuarihyouji(String pZtytokuyakuarihyouji) {
        ztytokuyakuarihyouji = pZtytokuyakuarihyouji;
    }

    private String ztynkzeiseitekikakutkykkbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNKZEISEITEKIKAKUTKYKKBN)
    public String getZtynkzeiseitekikakutkykkbn() {
        return ztynkzeiseitekikakutkykkbn;
    }

    public void setZtynkzeiseitekikakutkykkbn(String pZtynkzeiseitekikakutkykkbn) {
        ztynkzeiseitekikakutkykkbn = pZtynkzeiseitekikakutkykkbn;
    }

    private String ztysiharaikaisuukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYSIHARAIKAISUUKBN)
    public String getZtysiharaikaisuukbn() {
        return ztysiharaikaisuukbn;
    }

    public void setZtysiharaikaisuukbn(String pZtysiharaikaisuukbn) {
        ztysiharaikaisuukbn = pZtysiharaikaisuukbn;
    }

    private String ztymotokykhrkhouhoukbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYMOTOKYKHRKHOUHOUKBN)
    public String getZtymotokykhrkhouhoukbn() {
        return ztymotokykhrkhouhoukbn;
    }

    public void setZtymotokykhrkhouhoukbn(String pZtymotokykhrkhouhoukbn) {
        ztymotokykhrkhouhoukbn = pZtymotokykhrkhouhoukbn;
    }

    private String ztyseisikakymd;

    @Column(name=GenZT_OuNnknShrTy.ZTYSEISIKAKYMD)
    public String getZtyseisikakymd() {
        return ztyseisikakymd;
    }

    public void setZtyseisikakymd(String pZtyseisikakymd) {
        ztyseisikakymd = pZtyseisikakymd;
    }

    private String ztysegcd;

    @Column(name=GenZT_OuNnknShrTy.ZTYSEGCD)
    public String getZtysegcd() {
        return ztysegcd;
    }

    public void setZtysegcd(String pZtysegcd) {
        ztysegcd = pZtysegcd;
    }

    private String ztynenkinkigousedaikbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYNENKINKIGOUSEDAIKBN)
    public String getZtynenkinkigousedaikbn() {
        return ztynenkinkigousedaikbn;
    }

    public void setZtynenkinkigousedaikbn(String pZtynenkinkigousedaikbn) {
        ztynenkinkigousedaikbn = pZtynenkinkigousedaikbn;
    }

    private String ztydairiten1oyacd;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN1OYACD)
    public String getZtydairiten1oyacd() {
        return ztydairiten1oyacd;
    }

    public void setZtydairiten1oyacd(String pZtydairiten1oyacd) {
        ztydairiten1oyacd = pZtydairiten1oyacd;
    }

    private String ztydairiten1oyakanjinm;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN1OYAKANJINM)
    public String getZtydairiten1oyakanjinm() {
        return ztydairiten1oyakanjinm;
    }

    public void setZtydairiten1oyakanjinm(String pZtydairiten1oyakanjinm) {
        ztydairiten1oyakanjinm = pZtydairiten1oyakanjinm;
    }

    private String ztydairiten2oyacd;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN2OYACD)
    public String getZtydairiten2oyacd() {
        return ztydairiten2oyacd;
    }

    public void setZtydairiten2oyacd(String pZtydairiten2oyacd) {
        ztydairiten2oyacd = pZtydairiten2oyacd;
    }

    private String ztydairiten2oyakanjinm;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN2OYAKANJINM)
    public String getZtydairiten2oyakanjinm() {
        return ztydairiten2oyakanjinm;
    }

    public void setZtydairiten2oyakanjinm(String pZtydairiten2oyakanjinm) {
        ztydairiten2oyakanjinm = pZtydairiten2oyakanjinm;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_OuNnknShrTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztydairiten1cd;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN1CD)
    public String getZtydairiten1cd() {
        return ztydairiten1cd;
    }

    public void setZtydairiten1cd(String pZtydairiten1cd) {
        ztydairiten1cd = pZtydairiten1cd;
    }

    private String ztydairiten1kanjinm;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN1KANJINM)
    public String getZtydairiten1kanjinm() {
        return ztydairiten1kanjinm;
    }

    public void setZtydairiten1kanjinm(String pZtydairiten1kanjinm) {
        ztydairiten1kanjinm = pZtydairiten1kanjinm;
    }

    private String ztybosyuunin1cd;

    @Column(name=GenZT_OuNnknShrTy.ZTYBOSYUUNIN1CD)
    public String getZtybosyuunin1cd() {
        return ztybosyuunin1cd;
    }

    public void setZtybosyuunin1cd(String pZtybosyuunin1cd) {
        ztybosyuunin1cd = pZtybosyuunin1cd;
    }

    private String ztybosyuu1kanjinm;

    @Column(name=GenZT_OuNnknShrTy.ZTYBOSYUU1KANJINM)
    public String getZtybosyuu1kanjinm() {
        return ztybosyuu1kanjinm;
    }

    public void setZtybosyuu1kanjinm(String pZtybosyuu1kanjinm) {
        ztybosyuu1kanjinm = pZtybosyuu1kanjinm;
    }

    private String ztydairiten2cd;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN2CD)
    public String getZtydairiten2cd() {
        return ztydairiten2cd;
    }

    public void setZtydairiten2cd(String pZtydairiten2cd) {
        ztydairiten2cd = pZtydairiten2cd;
    }

    private String ztydairiten2kanjinm;

    @Column(name=GenZT_OuNnknShrTy.ZTYDAIRITEN2KANJINM)
    public String getZtydairiten2kanjinm() {
        return ztydairiten2kanjinm;
    }

    public void setZtydairiten2kanjinm(String pZtydairiten2kanjinm) {
        ztydairiten2kanjinm = pZtydairiten2kanjinm;
    }

    private String ztybosyuunin2cd;

    @Column(name=GenZT_OuNnknShrTy.ZTYBOSYUUNIN2CD)
    public String getZtybosyuunin2cd() {
        return ztybosyuunin2cd;
    }

    public void setZtybosyuunin2cd(String pZtybosyuunin2cd) {
        ztybosyuunin2cd = pZtybosyuunin2cd;
    }

    private String ztybosyuu2kanjinm;

    @Column(name=GenZT_OuNnknShrTy.ZTYBOSYUU2KANJINM)
    public String getZtybosyuu2kanjinm() {
        return ztybosyuu2kanjinm;
    }

    public void setZtybosyuu2kanjinm(String pZtybosyuu2kanjinm) {
        ztybosyuu2kanjinm = pZtybosyuu2kanjinm;
    }

    private String ztycifcd;

    @Column(name=GenZT_OuNnknShrTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztybankcd;

    @Column(name=GenZT_OuNnknShrTy.ZTYBANKCD)
    public String getZtybankcd() {
        return ztybankcd;
    }

    public void setZtybankcd(String pZtybankcd) {
        ztybankcd = pZtybankcd;
    }

    private String ztyshitencd;

    @Column(name=GenZT_OuNnknShrTy.ZTYSHITENCD)
    public String getZtyshitencd() {
        return ztyshitencd;
    }

    public void setZtyshitencd(String pZtyshitencd) {
        ztyshitencd = pZtyshitencd;
    }

    private String ztyyobiv71;

    @Column(name=GenZT_OuNnknShrTy.ZTYYOBIV71)
    public String getZtyyobiv71() {
        return ztyyobiv71;
    }

    public void setZtyyobiv71(String pZtyyobiv71) {
        ztyyobiv71 = pZtyyobiv71;
    }
}
