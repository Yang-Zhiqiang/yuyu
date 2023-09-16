package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_OuNnknShrRn;
import yuyu.def.db.id.PKZT_OuNnknShrRn;
import yuyu.def.db.meta.GenQZT_OuNnknShrRn;
import yuyu.def.db.meta.QZT_OuNnknShrRn;

/**
 * ＯＵ用年金支払テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_OuNnknShrRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_OuNnknShrRn}</td><td colspan="3">ＯＵ用年金支払テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_OuNnknShrRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaisosikicd zrnsiharaisosikicd}</td><td>（連携用）支払組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikohasseiymd zrnjikohasseiymd}</td><td>（連携用）事故発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntukigakunengakukbn zrntukigakunengakukbn}</td><td>（連携用）月額年額区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhnnkgk zrnkhnnkgk}</td><td>（連携用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunenkingaku zrnkeiyakunenkingaku}</td><td>（連携用）契約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkasannkgk zrnkasannkgk}</td><td>（連携用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnuwanosenenkingaku zrnuwanosenenkingaku}</td><td>（連携用）上乗せ年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsasihikisiharaigaku zrnsasihikisiharaigaku}</td><td>（連携用）差引支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiharainenkingaku zrnsiharainenkingaku}</td><td>（連携用）支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiboujikyuuhukingaku zrnsiboujikyuuhukingaku}</td><td>（連携用）死亡時給付金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiharaid zrnsiharaid}</td><td>（連携用）支払Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngensentyousyuuzeigaku zrngensentyousyuuzeigaku}</td><td>（連携用）源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonotasiharaikingaku zrnsonotasiharaikingaku}</td><td>（連携用）その他支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnttkekstkjyutukngk zrnttkekstkjyutukngk}</td><td>（連携用）立替貸付充当金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkingakurank zrnnenkingakurank}</td><td>（連携用）年金額ランク</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn zrnnksyuruikbn}</td><td>（連携用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorinaiyoukbn zrnsyorinaiyoukbn}</td><td>（連携用）処理内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsiharaihouhoukbn zrnnenkinsiharaihouhoukbn}</td><td>（連携用）年金支払方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinhanbaimeisyou zrnnenkinhanbaimeisyou}</td><td>（連携用）年金販売名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmotokeiyakusyouhinkbn zrnmotokeiyakusyouhinkbn}</td><td>（連携用）元契約商品区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrhasseiriyuukbn zrnnkshrhasseiriyuukbn}</td><td>（連携用）年金支払発生理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinhosyoukikan zrnnenkinhosyoukikan}</td><td>（連携用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkknsetymd zrnkknsetymd}</td><td>（連携用）基金設定日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokainenkinsiharaiymd zrnsyokainenkinsiharaiymd}</td><td>（連携用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjihihokensyaage zrnnksjihihokensyaage}</td><td>（連携用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyaseibetukbn zrndai2hihokensyaseibetukbn}</td><td>（連携用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjidai2hhknsyaage zrnnksjidai2hhknsyaage}</td><td>（連携用）年金開始時第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuketorininkbn zrnnkuketorininkbn}</td><td>（連携用）年金受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuktrnnhukusuuninzuu zrnnkuktrnnhukusuuninzuu}</td><td>（連携用）年金受取人複数人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhihokensyasibouymd zrnhihokensyasibouymd}</td><td>（連携用）被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyasibouymd zrndai2hihokensyasibouymd}</td><td>（連携用）第２被保険者死亡年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhoujinuketorininhyouji zrnhoujinuketorininhyouji}</td><td>（連携用）法人受取人表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnktouduketorihouhoukbn zrnnktouduketorihouhoukbn}</td><td>（連携用）年金当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntatekaearihyouji zrntatekaearihyouji}</td><td>（連携用）立替有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasitukearihyouji zrnkasitukearihyouji}</td><td>（連携用）貸付有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuarihyouji zrntokuyakuarihyouji}</td><td>（連携用）特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkzeiseitekikakutkykkbn zrnnkzeiseitekikakutkykkbn}</td><td>（連携用）年金税制適格特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaikaisuukbn zrnsiharaikaisuukbn}</td><td>（連携用）支払回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmotokykhrkhouhoukbn zrnmotokykhrkhouhoukbn}</td><td>（連携用）元契約払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisikakymd zrnseisikakymd}</td><td>（連携用）生死確認日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsegcd zrnsegcd}</td><td>（連携用）セグメントコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten1oyacd zrndairiten1oyacd}</td><td>（連携用）代理店１親コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten1oyakanjinm zrndairiten1oyakanjinm}</td><td>（連携用）代理店１親漢字名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten2oyacd zrndairiten2oyacd}</td><td>（連携用）代理店２親コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten2oyakanjinm zrndairiten2oyakanjinm}</td><td>（連携用）代理店２親漢字名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten1cd zrndairiten1cd}</td><td>（連携用）代理店１コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten1kanjinm zrndairiten1kanjinm}</td><td>（連携用）代理店１漢字名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin1cd zrnbosyuunin1cd}</td><td>（連携用）募集人１コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuu1kanjinm zrnbosyuu1kanjinm}</td><td>（連携用）募集人１漢字名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten2cd zrndairiten2cd}</td><td>（連携用）代理店２コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten2kanjinm zrndairiten2kanjinm}</td><td>（連携用）代理店２漢字名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin2cd zrnbosyuunin2cd}</td><td>（連携用）募集人２コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuu2kanjinm zrnbosyuu2kanjinm}</td><td>（連携用）募集人２漢字名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv71 zrnyobiv71}</td><td>（連携用）予備項目Ｖ７１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_OuNnknShrRn
 * @see     PKZT_OuNnknShrRn
 * @see     QZT_OuNnknShrRn
 * @see     GenQZT_OuNnknShrRn
 */
@MappedSuperclass
@Table(name=GenZT_OuNnknShrRn.TABLE_NAME)
@IdClass(value=PKZT_OuNnknShrRn.class)
public abstract class GenZT_OuNnknShrRn extends AbstractExDBEntityForZDB<ZT_OuNnknShrRn, PKZT_OuNnknShrRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_OuNnknShrRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNKIJYUNYM              = "zrnkijyunym";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNNKSYOUSYONO           = "zrnnksyousyono";
    public static final String ZRNSIHARAISOSIKICD       = "zrnsiharaisosikicd";
    public static final String ZRNJIKOHASSEIYMD         = "zrnjikohasseiymd";
    public static final String ZRNTUKIGAKUNENGAKUKBN    = "zrntukigakunengakukbn";
    public static final String ZRNKHNNKGK               = "zrnkhnnkgk";
    public static final String ZRNKEIYAKUNENKINGAKU     = "zrnkeiyakunenkingaku";
    public static final String ZRNKASANNKGK             = "zrnkasannkgk";
    public static final String ZRNUWANOSENENKINGAKU     = "zrnuwanosenenkingaku";
    public static final String ZRNSASIHIKISIHARAIGAKU   = "zrnsasihikisiharaigaku";
    public static final String ZRNSIHARAINENKINGAKU     = "zrnsiharainenkingaku";
    public static final String ZRNSIBOUJIKYUUHUKINGAKU  = "zrnsiboujikyuuhukingaku";
    public static final String ZRNSIHARAID              = "zrnsiharaid";
    public static final String ZRNGENSENTYOUSYUUZEIGAKU = "zrngensentyousyuuzeigaku";
    public static final String ZRNSONOTASIHARAIKINGAKU  = "zrnsonotasiharaikingaku";
    public static final String ZRNTTKEKSTKJYUTUKNGK     = "zrnttkekstkjyutukngk";
    public static final String ZRNNENKINGAKURANK        = "zrnnenkingakurank";
    public static final String ZRNNKSYURUIKBN           = "zrnnksyuruikbn";
    public static final String ZRNSYORINAIYOUKBN        = "zrnsyorinaiyoukbn";
    public static final String ZRNNENKINSIHARAIHOUHOUKBN = "zrnnenkinsiharaihouhoukbn";
    public static final String ZRNNENKINHANBAIMEISYOU   = "zrnnenkinhanbaimeisyou";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNMOTOKEIYAKUSYOUHINKBN = "zrnmotokeiyakusyouhinkbn";
    public static final String ZRNNKSHRHASSEIRIYUUKBN   = "zrnnkshrhasseiriyuukbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNENKINHOSYOUKIKAN     = "zrnnenkinhosyoukikan";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNKKNSETYMD             = "zrnkknsetymd";
    public static final String ZRNSYOKAINENKINSIHARAIYMD = "zrnsyokainenkinsiharaiymd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNNKSJIHIHOKENSYAAGE    = "zrnnksjihihokensyaage";
    public static final String ZRNDAI2HIHOKENSYASEIBETUKBN = "zrndai2hihokensyaseibetukbn";
    public static final String ZRNNKSJIDAI2HHKNSYAAGE   = "zrnnksjidai2hhknsyaage";
    public static final String ZRNNKUKETORININKBN       = "zrnnkuketorininkbn";
    public static final String ZRNNKUKTRNNHUKUSUUNINZUU = "zrnnkuktrnnhukusuuninzuu";
    public static final String ZRNHIHOKENSYASIBOUYMD    = "zrnhihokensyasibouymd";
    public static final String ZRNDAI2HIHOKENSYASIBOUYMD = "zrndai2hihokensyasibouymd";
    public static final String ZRNHOUJINUKETORININHYOUJI = "zrnhoujinuketorininhyouji";
    public static final String ZRNNKTOUDUKETORIHOUHOUKBN = "zrnnktouduketorihouhoukbn";
    public static final String ZRNTATEKAEARIHYOUJI      = "zrntatekaearihyouji";
    public static final String ZRNKASITUKEARIHYOUJI     = "zrnkasitukearihyouji";
    public static final String ZRNTOKUYAKUARIHYOUJI     = "zrntokuyakuarihyouji";
    public static final String ZRNNKZEISEITEKIKAKUTKYKKBN = "zrnnkzeiseitekikakutkykkbn";
    public static final String ZRNSIHARAIKAISUUKBN      = "zrnsiharaikaisuukbn";
    public static final String ZRNMOTOKYKHRKHOUHOUKBN   = "zrnmotokykhrkhouhoukbn";
    public static final String ZRNSEISIKAKYMD           = "zrnseisikakymd";
    public static final String ZRNSEGCD                 = "zrnsegcd";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNDAIRITEN1OYACD        = "zrndairiten1oyacd";
    public static final String ZRNDAIRITEN1OYAKANJINM   = "zrndairiten1oyakanjinm";
    public static final String ZRNDAIRITEN2OYACD        = "zrndairiten2oyacd";
    public static final String ZRNDAIRITEN2OYAKANJINM   = "zrndairiten2oyakanjinm";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNDAIRITEN1CD           = "zrndairiten1cd";
    public static final String ZRNDAIRITEN1KANJINM      = "zrndairiten1kanjinm";
    public static final String ZRNBOSYUUNIN1CD          = "zrnbosyuunin1cd";
    public static final String ZRNBOSYUU1KANJINM        = "zrnbosyuu1kanjinm";
    public static final String ZRNDAIRITEN2CD           = "zrndairiten2cd";
    public static final String ZRNDAIRITEN2KANJINM      = "zrndairiten2kanjinm";
    public static final String ZRNBOSYUUNIN2CD          = "zrnbosyuunin2cd";
    public static final String ZRNBOSYUU2KANJINM        = "zrnbosyuu2kanjinm";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNBANKCD                = "zrnbankcd";
    public static final String ZRNSHITENCD              = "zrnshitencd";
    public static final String ZRNYOBIV71               = "zrnyobiv71";

    private final PKZT_OuNnknShrRn primaryKey;

    public GenZT_OuNnknShrRn() {
        primaryKey = new PKZT_OuNnknShrRn();
    }

    public GenZT_OuNnknShrRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_OuNnknShrRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_OuNnknShrRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_OuNnknShrRn> getMetaClass() {
        return QZT_OuNnknShrRn.class;
    }

    @Id
    @Column(name=GenZT_OuNnknShrRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnkijyunym;

    @Column(name=GenZT_OuNnknShrRn.ZRNKIJYUNYM)
    public String getZrnkijyunym() {
        return zrnkijyunym;
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        zrnkijyunym = pZrnkijyunym;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_OuNnknShrRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrndenymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    private String zrnnksyousyono;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKSYOUSYONO)
    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

    private String zrnsiharaisosikicd;

    @Column(name=GenZT_OuNnknShrRn.ZRNSIHARAISOSIKICD)
    public String getZrnsiharaisosikicd() {
        return zrnsiharaisosikicd;
    }

    public void setZrnsiharaisosikicd(String pZrnsiharaisosikicd) {
        zrnsiharaisosikicd = pZrnsiharaisosikicd;
    }

    private String zrnjikohasseiymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNJIKOHASSEIYMD)
    public String getZrnjikohasseiymd() {
        return zrnjikohasseiymd;
    }

    public void setZrnjikohasseiymd(String pZrnjikohasseiymd) {
        zrnjikohasseiymd = pZrnjikohasseiymd;
    }

    private String zrntukigakunengakukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNTUKIGAKUNENGAKUKBN)
    public String getZrntukigakunengakukbn() {
        return zrntukigakunengakukbn;
    }

    public void setZrntukigakunengakukbn(String pZrntukigakunengakukbn) {
        zrntukigakunengakukbn = pZrntukigakunengakukbn;
    }

    private Long zrnkhnnkgk;

    @Column(name=GenZT_OuNnknShrRn.ZRNKHNNKGK)
    public Long getZrnkhnnkgk() {
        return zrnkhnnkgk;
    }

    public void setZrnkhnnkgk(Long pZrnkhnnkgk) {
        zrnkhnnkgk = pZrnkhnnkgk;
    }

    private Long zrnkeiyakunenkingaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNKEIYAKUNENKINGAKU)
    public Long getZrnkeiyakunenkingaku() {
        return zrnkeiyakunenkingaku;
    }

    public void setZrnkeiyakunenkingaku(Long pZrnkeiyakunenkingaku) {
        zrnkeiyakunenkingaku = pZrnkeiyakunenkingaku;
    }

    private Long zrnkasannkgk;

    @Column(name=GenZT_OuNnknShrRn.ZRNKASANNKGK)
    public Long getZrnkasannkgk() {
        return zrnkasannkgk;
    }

    public void setZrnkasannkgk(Long pZrnkasannkgk) {
        zrnkasannkgk = pZrnkasannkgk;
    }

    private Long zrnuwanosenenkingaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNUWANOSENENKINGAKU)
    public Long getZrnuwanosenenkingaku() {
        return zrnuwanosenenkingaku;
    }

    public void setZrnuwanosenenkingaku(Long pZrnuwanosenenkingaku) {
        zrnuwanosenenkingaku = pZrnuwanosenenkingaku;
    }

    private Long zrnsasihikisiharaigaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNSASIHIKISIHARAIGAKU)
    public Long getZrnsasihikisiharaigaku() {
        return zrnsasihikisiharaigaku;
    }

    public void setZrnsasihikisiharaigaku(Long pZrnsasihikisiharaigaku) {
        zrnsasihikisiharaigaku = pZrnsasihikisiharaigaku;
    }

    private Long zrnsiharainenkingaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNSIHARAINENKINGAKU)
    public Long getZrnsiharainenkingaku() {
        return zrnsiharainenkingaku;
    }

    public void setZrnsiharainenkingaku(Long pZrnsiharainenkingaku) {
        zrnsiharainenkingaku = pZrnsiharainenkingaku;
    }

    private Long zrnsiboujikyuuhukingaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNSIBOUJIKYUUHUKINGAKU)
    public Long getZrnsiboujikyuuhukingaku() {
        return zrnsiboujikyuuhukingaku;
    }

    public void setZrnsiboujikyuuhukingaku(Long pZrnsiboujikyuuhukingaku) {
        zrnsiboujikyuuhukingaku = pZrnsiboujikyuuhukingaku;
    }

    private Long zrnsiharaid;

    @Column(name=GenZT_OuNnknShrRn.ZRNSIHARAID)
    public Long getZrnsiharaid() {
        return zrnsiharaid;
    }

    public void setZrnsiharaid(Long pZrnsiharaid) {
        zrnsiharaid = pZrnsiharaid;
    }

    private Long zrngensentyousyuuzeigaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNGENSENTYOUSYUUZEIGAKU)
    public Long getZrngensentyousyuuzeigaku() {
        return zrngensentyousyuuzeigaku;
    }

    public void setZrngensentyousyuuzeigaku(Long pZrngensentyousyuuzeigaku) {
        zrngensentyousyuuzeigaku = pZrngensentyousyuuzeigaku;
    }

    private Long zrnsonotasiharaikingaku;

    @Column(name=GenZT_OuNnknShrRn.ZRNSONOTASIHARAIKINGAKU)
    public Long getZrnsonotasiharaikingaku() {
        return zrnsonotasiharaikingaku;
    }

    public void setZrnsonotasiharaikingaku(Long pZrnsonotasiharaikingaku) {
        zrnsonotasiharaikingaku = pZrnsonotasiharaikingaku;
    }

    private Long zrnttkekstkjyutukngk;

    @Column(name=GenZT_OuNnknShrRn.ZRNTTKEKSTKJYUTUKNGK)
    public Long getZrnttkekstkjyutukngk() {
        return zrnttkekstkjyutukngk;
    }

    public void setZrnttkekstkjyutukngk(Long pZrnttkekstkjyutukngk) {
        zrnttkekstkjyutukngk = pZrnttkekstkjyutukngk;
    }

    private String zrnnenkingakurank;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINGAKURANK)
    public String getZrnnenkingakurank() {
        return zrnnenkingakurank;
    }

    public void setZrnnenkingakurank(String pZrnnenkingakurank) {
        zrnnenkingakurank = pZrnnenkingakurank;
    }

    private String zrnnksyuruikbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKSYURUIKBN)
    public String getZrnnksyuruikbn() {
        return zrnnksyuruikbn;
    }

    public void setZrnnksyuruikbn(String pZrnnksyuruikbn) {
        zrnnksyuruikbn = pZrnnksyuruikbn;
    }

    private String zrnsyorinaiyoukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNSYORINAIYOUKBN)
    public String getZrnsyorinaiyoukbn() {
        return zrnsyorinaiyoukbn;
    }

    public void setZrnsyorinaiyoukbn(String pZrnsyorinaiyoukbn) {
        zrnsyorinaiyoukbn = pZrnsyorinaiyoukbn;
    }

    private String zrnnenkinsiharaihouhoukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINSIHARAIHOUHOUKBN)
    public String getZrnnenkinsiharaihouhoukbn() {
        return zrnnenkinsiharaihouhoukbn;
    }

    public void setZrnnenkinsiharaihouhoukbn(String pZrnnenkinsiharaihouhoukbn) {
        zrnnenkinsiharaihouhoukbn = pZrnnenkinsiharaihouhoukbn;
    }

    private String zrnnenkinhanbaimeisyou;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINHANBAIMEISYOU)
    public String getZrnnenkinhanbaimeisyou() {
        return zrnnenkinhanbaimeisyou;
    }

    @DataConvert("toMultiByte")
    public void setZrnnenkinhanbaimeisyou(String pZrnnenkinhanbaimeisyou) {
        zrnnenkinhanbaimeisyou = pZrnnenkinhanbaimeisyou;
    }

    private String zrnnenkinkbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return zrnnenkinkbn;
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        zrnnenkinkbn = pZrnnenkinkbn;
    }

    private String zrnnenkinsyu;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return zrnnenkinsyu;
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        zrnnenkinsyu = pZrnnenkinsyu;
    }

    private String zrnmotokeiyakusyouhinkbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNMOTOKEIYAKUSYOUHINKBN)
    public String getZrnmotokeiyakusyouhinkbn() {
        return zrnmotokeiyakusyouhinkbn;
    }

    public void setZrnmotokeiyakusyouhinkbn(String pZrnmotokeiyakusyouhinkbn) {
        zrnmotokeiyakusyouhinkbn = pZrnmotokeiyakusyouhinkbn;
    }

    private String zrnnkshrhasseiriyuukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKSHRHASSEIRIYUUKBN)
    public String getZrnnkshrhasseiriyuukbn() {
        return zrnnkshrhasseiriyuukbn;
    }

    public void setZrnnkshrhasseiriyuukbn(String pZrnnkshrhasseiriyuukbn) {
        zrnnkshrhasseiriyuukbn = pZrnnkshrhasseiriyuukbn;
    }

    private String zrnnknshry;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnnenkinhosyoukikan;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINHOSYOUKIKAN)
    public String getZrnnenkinhosyoukikan() {
        return zrnnenkinhosyoukikan;
    }

    public void setZrnnenkinhosyoukikan(String pZrnnenkinhosyoukikan) {
        zrnnenkinhosyoukikan = pZrnnenkinhosyoukikan;
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnkknsetymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNKKNSETYMD)
    public String getZrnkknsetymd() {
        return zrnkknsetymd;
    }

    public void setZrnkknsetymd(String pZrnkknsetymd) {
        zrnkknsetymd = pZrnkknsetymd;
    }

    private String zrnsyokainenkinsiharaiymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNSYOKAINENKINSIHARAIYMD)
    public String getZrnsyokainenkinsiharaiymd() {
        return zrnsyokainenkinsiharaiymd;
    }

    public void setZrnsyokainenkinsiharaiymd(String pZrnsyokainenkinsiharaiymd) {
        zrnsyokainenkinsiharaiymd = pZrnsyokainenkinsiharaiymd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnnksjihihokensyaage;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKSJIHIHOKENSYAAGE)
    public String getZrnnksjihihokensyaage() {
        return zrnnksjihihokensyaage;
    }

    public void setZrnnksjihihokensyaage(String pZrnnksjihihokensyaage) {
        zrnnksjihihokensyaage = pZrnnksjihihokensyaage;
    }

    private String zrndai2hihokensyaseibetukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAI2HIHOKENSYASEIBETUKBN)
    public String getZrndai2hihokensyaseibetukbn() {
        return zrndai2hihokensyaseibetukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyaseibetukbn(String pZrndai2hihokensyaseibetukbn) {
        zrndai2hihokensyaseibetukbn = pZrndai2hihokensyaseibetukbn;
    }

    private String zrnnksjidai2hhknsyaage;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKSJIDAI2HHKNSYAAGE)
    public String getZrnnksjidai2hhknsyaage() {
        return zrnnksjidai2hhknsyaage;
    }

    public void setZrnnksjidai2hhknsyaage(String pZrnnksjidai2hhknsyaage) {
        zrnnksjidai2hhknsyaage = pZrnnksjidai2hhknsyaage;
    }

    private String zrnnkuketorininkbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKUKETORININKBN)
    public String getZrnnkuketorininkbn() {
        return zrnnkuketorininkbn;
    }

    public void setZrnnkuketorininkbn(String pZrnnkuketorininkbn) {
        zrnnkuketorininkbn = pZrnnkuketorininkbn;
    }

    private Long zrnnkuktrnnhukusuuninzuu;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKUKTRNNHUKUSUUNINZUU)
    public Long getZrnnkuktrnnhukusuuninzuu() {
        return zrnnkuktrnnhukusuuninzuu;
    }

    public void setZrnnkuktrnnhukusuuninzuu(Long pZrnnkuktrnnhukusuuninzuu) {
        zrnnkuktrnnhukusuuninzuu = pZrnnkuktrnnhukusuuninzuu;
    }

    private String zrnhihokensyasibouymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNHIHOKENSYASIBOUYMD)
    public String getZrnhihokensyasibouymd() {
        return zrnhihokensyasibouymd;
    }

    public void setZrnhihokensyasibouymd(String pZrnhihokensyasibouymd) {
        zrnhihokensyasibouymd = pZrnhihokensyasibouymd;
    }

    private String zrndai2hihokensyasibouymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAI2HIHOKENSYASIBOUYMD)
    public String getZrndai2hihokensyasibouymd() {
        return zrndai2hihokensyasibouymd;
    }

    public void setZrndai2hihokensyasibouymd(String pZrndai2hihokensyasibouymd) {
        zrndai2hihokensyasibouymd = pZrndai2hihokensyasibouymd;
    }

    private String zrnhoujinuketorininhyouji;

    @Column(name=GenZT_OuNnknShrRn.ZRNHOUJINUKETORININHYOUJI)
    public String getZrnhoujinuketorininhyouji() {
        return zrnhoujinuketorininhyouji;
    }

    public void setZrnhoujinuketorininhyouji(String pZrnhoujinuketorininhyouji) {
        zrnhoujinuketorininhyouji = pZrnhoujinuketorininhyouji;
    }

    private String zrnnktouduketorihouhoukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKTOUDUKETORIHOUHOUKBN)
    public String getZrnnktouduketorihouhoukbn() {
        return zrnnktouduketorihouhoukbn;
    }

    public void setZrnnktouduketorihouhoukbn(String pZrnnktouduketorihouhoukbn) {
        zrnnktouduketorihouhoukbn = pZrnnktouduketorihouhoukbn;
    }

    private String zrntatekaearihyouji;

    @Column(name=GenZT_OuNnknShrRn.ZRNTATEKAEARIHYOUJI)
    public String getZrntatekaearihyouji() {
        return zrntatekaearihyouji;
    }

    public void setZrntatekaearihyouji(String pZrntatekaearihyouji) {
        zrntatekaearihyouji = pZrntatekaearihyouji;
    }

    private String zrnkasitukearihyouji;

    @Column(name=GenZT_OuNnknShrRn.ZRNKASITUKEARIHYOUJI)
    public String getZrnkasitukearihyouji() {
        return zrnkasitukearihyouji;
    }

    public void setZrnkasitukearihyouji(String pZrnkasitukearihyouji) {
        zrnkasitukearihyouji = pZrnkasitukearihyouji;
    }

    private String zrntokuyakuarihyouji;

    @Column(name=GenZT_OuNnknShrRn.ZRNTOKUYAKUARIHYOUJI)
    public String getZrntokuyakuarihyouji() {
        return zrntokuyakuarihyouji;
    }

    public void setZrntokuyakuarihyouji(String pZrntokuyakuarihyouji) {
        zrntokuyakuarihyouji = pZrntokuyakuarihyouji;
    }

    private String zrnnkzeiseitekikakutkykkbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNKZEISEITEKIKAKUTKYKKBN)
    public String getZrnnkzeiseitekikakutkykkbn() {
        return zrnnkzeiseitekikakutkykkbn;
    }

    public void setZrnnkzeiseitekikakutkykkbn(String pZrnnkzeiseitekikakutkykkbn) {
        zrnnkzeiseitekikakutkykkbn = pZrnnkzeiseitekikakutkykkbn;
    }

    private String zrnsiharaikaisuukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNSIHARAIKAISUUKBN)
    public String getZrnsiharaikaisuukbn() {
        return zrnsiharaikaisuukbn;
    }

    public void setZrnsiharaikaisuukbn(String pZrnsiharaikaisuukbn) {
        zrnsiharaikaisuukbn = pZrnsiharaikaisuukbn;
    }

    private String zrnmotokykhrkhouhoukbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNMOTOKYKHRKHOUHOUKBN)
    public String getZrnmotokykhrkhouhoukbn() {
        return zrnmotokykhrkhouhoukbn;
    }

    public void setZrnmotokykhrkhouhoukbn(String pZrnmotokykhrkhouhoukbn) {
        zrnmotokykhrkhouhoukbn = pZrnmotokykhrkhouhoukbn;
    }

    private String zrnseisikakymd;

    @Column(name=GenZT_OuNnknShrRn.ZRNSEISIKAKYMD)
    public String getZrnseisikakymd() {
        return zrnseisikakymd;
    }

    public void setZrnseisikakymd(String pZrnseisikakymd) {
        zrnseisikakymd = pZrnseisikakymd;
    }

    private String zrnsegcd;

    @Column(name=GenZT_OuNnknShrRn.ZRNSEGCD)
    public String getZrnsegcd() {
        return zrnsegcd;
    }

    public void setZrnsegcd(String pZrnsegcd) {
        zrnsegcd = pZrnsegcd;
    }

    private String zrnnenkinkigousedaikbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return zrnnenkinkigousedaikbn;
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
    }

    private String zrndairiten1oyacd;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN1OYACD)
    public String getZrndairiten1oyacd() {
        return zrndairiten1oyacd;
    }

    public void setZrndairiten1oyacd(String pZrndairiten1oyacd) {
        zrndairiten1oyacd = pZrndairiten1oyacd;
    }

    private String zrndairiten1oyakanjinm;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN1OYAKANJINM)
    public String getZrndairiten1oyakanjinm() {
        return zrndairiten1oyakanjinm;
    }

    @DataConvert("toMultiByte")
    public void setZrndairiten1oyakanjinm(String pZrndairiten1oyakanjinm) {
        zrndairiten1oyakanjinm = pZrndairiten1oyakanjinm;
    }

    private String zrndairiten2oyacd;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN2OYACD)
    public String getZrndairiten2oyacd() {
        return zrndairiten2oyacd;
    }

    public void setZrndairiten2oyacd(String pZrndairiten2oyacd) {
        zrndairiten2oyacd = pZrndairiten2oyacd;
    }

    private String zrndairiten2oyakanjinm;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN2OYAKANJINM)
    public String getZrndairiten2oyakanjinm() {
        return zrndairiten2oyakanjinm;
    }

    @DataConvert("toMultiByte")
    public void setZrndairiten2oyakanjinm(String pZrndairiten2oyakanjinm) {
        zrndairiten2oyakanjinm = pZrndairiten2oyakanjinm;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_OuNnknShrRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrndairiten1cd;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN1CD)
    public String getZrndairiten1cd() {
        return zrndairiten1cd;
    }

    public void setZrndairiten1cd(String pZrndairiten1cd) {
        zrndairiten1cd = pZrndairiten1cd;
    }

    private String zrndairiten1kanjinm;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN1KANJINM)
    public String getZrndairiten1kanjinm() {
        return zrndairiten1kanjinm;
    }

    @DataConvert("toMultiByte")
    public void setZrndairiten1kanjinm(String pZrndairiten1kanjinm) {
        zrndairiten1kanjinm = pZrndairiten1kanjinm;
    }

    private String zrnbosyuunin1cd;

    @Column(name=GenZT_OuNnknShrRn.ZRNBOSYUUNIN1CD)
    public String getZrnbosyuunin1cd() {
        return zrnbosyuunin1cd;
    }

    public void setZrnbosyuunin1cd(String pZrnbosyuunin1cd) {
        zrnbosyuunin1cd = pZrnbosyuunin1cd;
    }

    private String zrnbosyuu1kanjinm;

    @Column(name=GenZT_OuNnknShrRn.ZRNBOSYUU1KANJINM)
    public String getZrnbosyuu1kanjinm() {
        return zrnbosyuu1kanjinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnbosyuu1kanjinm(String pZrnbosyuu1kanjinm) {
        zrnbosyuu1kanjinm = pZrnbosyuu1kanjinm;
    }

    private String zrndairiten2cd;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN2CD)
    public String getZrndairiten2cd() {
        return zrndairiten2cd;
    }

    public void setZrndairiten2cd(String pZrndairiten2cd) {
        zrndairiten2cd = pZrndairiten2cd;
    }

    private String zrndairiten2kanjinm;

    @Column(name=GenZT_OuNnknShrRn.ZRNDAIRITEN2KANJINM)
    public String getZrndairiten2kanjinm() {
        return zrndairiten2kanjinm;
    }

    @DataConvert("toMultiByte")
    public void setZrndairiten2kanjinm(String pZrndairiten2kanjinm) {
        zrndairiten2kanjinm = pZrndairiten2kanjinm;
    }

    private String zrnbosyuunin2cd;

    @Column(name=GenZT_OuNnknShrRn.ZRNBOSYUUNIN2CD)
    public String getZrnbosyuunin2cd() {
        return zrnbosyuunin2cd;
    }

    public void setZrnbosyuunin2cd(String pZrnbosyuunin2cd) {
        zrnbosyuunin2cd = pZrnbosyuunin2cd;
    }

    private String zrnbosyuu2kanjinm;

    @Column(name=GenZT_OuNnknShrRn.ZRNBOSYUU2KANJINM)
    public String getZrnbosyuu2kanjinm() {
        return zrnbosyuu2kanjinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnbosyuu2kanjinm(String pZrnbosyuu2kanjinm) {
        zrnbosyuu2kanjinm = pZrnbosyuu2kanjinm;
    }

    private String zrncifcd;

    @Column(name=GenZT_OuNnknShrRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnbankcd;

    @Column(name=GenZT_OuNnknShrRn.ZRNBANKCD)
    public String getZrnbankcd() {
        return zrnbankcd;
    }

    public void setZrnbankcd(String pZrnbankcd) {
        zrnbankcd = pZrnbankcd;
    }

    private String zrnshitencd;

    @Column(name=GenZT_OuNnknShrRn.ZRNSHITENCD)
    public String getZrnshitencd() {
        return zrnshitencd;
    }

    public void setZrnshitencd(String pZrnshitencd) {
        zrnshitencd = pZrnshitencd;
    }

    private String zrnyobiv71;

    @Column(name=GenZT_OuNnknShrRn.ZRNYOBIV71)
    public String getZrnyobiv71() {
        return zrnyobiv71;
    }

    public void setZrnyobiv71(String pZrnyobiv71) {
        zrnyobiv71 = pZrnyobiv71;
    }
}