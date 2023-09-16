package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_OuNnknShrRn;
import yuyu.def.db.mapping.GenZT_OuNnknShrRn;
import yuyu.def.db.meta.GenQZT_OuNnknShrRn;
import yuyu.def.db.meta.QZT_OuNnknShrRn;

/**
 * ＯＵ用年金支払テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_OuNnknShrRn}</td><td colspan="3">ＯＵ用年金支払テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnkijyunym</td><td>（連携用）基準年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenymd</td><td>（連携用）伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyousyono</td><td>（連携用）年金証書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiharaisosikicd</td><td>（連携用）支払組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikohasseiymd</td><td>（連携用）事故発生日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntukigakunengakukbn</td><td>（連携用）月額年額区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhnnkgk</td><td>（連携用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkeiyakunenkingaku</td><td>（連携用）契約年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkasannkgk</td><td>（連携用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnuwanosenenkingaku</td><td>（連携用）上乗せ年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsasihikisiharaigaku</td><td>（連携用）差引支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiharainenkingaku</td><td>（連携用）支払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiboujikyuuhukingaku</td><td>（連携用）死亡時給付金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiharaid</td><td>（連携用）支払Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngensentyousyuuzeigaku</td><td>（連携用）源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonotasiharaikingaku</td><td>（連携用）その他支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnttkekstkjyutukngk</td><td>（連携用）立替貸付充当金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkingakurank</td><td>（連携用）年金額ランク</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn</td><td>（連携用）年金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorinaiyoukbn</td><td>（連携用）処理内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsiharaihouhoukbn</td><td>（連携用）年金支払方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinhanbaimeisyou</td><td>（連携用）年金販売名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkbn</td><td>（連携用）年金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsyu</td><td>（連携用）年金種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmotokeiyakusyouhinkbn</td><td>（連携用）元契約商品区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrhasseiriyuukbn</td><td>（連携用）年金支払発生理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknshry</td><td>（連携用）年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinhosyoukikan</td><td>（連携用）年金保証期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuymd</td><td>（連携用）契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkknsetymd</td><td>（連携用）基金設定日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokainenkinsiharaiymd</td><td>（連携用）初回年金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjihihokensyaage</td><td>（連携用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyaseibetukbn</td><td>（連携用）第２被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjidai2hhknsyaage</td><td>（連携用）年金開始時第２被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuketorininkbn</td><td>（連携用）年金受取人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuktrnnhukusuuninzuu</td><td>（連携用）年金受取人複数人数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhihokensyasibouymd</td><td>（連携用）被保険者死亡日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyasibouymd</td><td>（連携用）第２被保険者死亡年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhoujinuketorininhyouji</td><td>（連携用）法人受取人表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnktouduketorihouhoukbn</td><td>（連携用）年金当Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntatekaearihyouji</td><td>（連携用）立替有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasitukearihyouji</td><td>（連携用）貸付有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakuarihyouji</td><td>（連携用）特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkzeiseitekikakutkykkbn</td><td>（連携用）年金税制適格特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiharaikaisuukbn</td><td>（連携用）支払回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmotokykhrkhouhoukbn</td><td>（連携用）元契約払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisikakymd</td><td>（連携用）生死確認日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsegcd</td><td>（連携用）セグメントコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkigousedaikbn</td><td>（連携用）年金記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten1oyacd</td><td>（連携用）代理店１親コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten1oyakanjinm</td><td>（連携用）代理店１親漢字名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndairiten2oyacd</td><td>（連携用）代理店２親コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten2oyakanjinm</td><td>（連携用）代理店２親漢字名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbsudirtnatkikeitaikbn</td><td>（連携用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten1cd</td><td>（連携用）代理店１コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten1kanjinm</td><td>（連携用）代理店１漢字名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin1cd</td><td>（連携用）募集人１コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuu1kanjinm</td><td>（連携用）募集人１漢字名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndairiten2cd</td><td>（連携用）代理店２コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairiten2kanjinm</td><td>（連携用）代理店２漢字名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunin2cd</td><td>（連携用）募集人２コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuu2kanjinm</td><td>（連携用）募集人２漢字名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbankcd</td><td>（連携用）銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshitencd</td><td>（連携用）支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv71</td><td>（連携用）予備項目Ｖ７１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_OuNnknShrRn
 * @see     GenZT_OuNnknShrRn
 * @see     QZT_OuNnknShrRn
 * @see     GenQZT_OuNnknShrRn
 */
public class PKZT_OuNnknShrRn extends AbstractExDBPrimaryKey<ZT_OuNnknShrRn, PKZT_OuNnknShrRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_OuNnknShrRn() {
    }

    public PKZT_OuNnknShrRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_OuNnknShrRn> getEntityClass() {
        return ZT_OuNnknShrRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}