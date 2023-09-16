package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_OuNnknShrTy;
import yuyu.def.db.mapping.GenZT_OuNnknShrTy;
import yuyu.def.db.meta.GenQZT_OuNnknShrTy;
import yuyu.def.db.meta.QZT_OuNnknShrTy;

/**
 * ＯＵ用年金支払テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_OuNnknShrTy}</td><td colspan="3">ＯＵ用年金支払テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykijyunym</td><td>（中継用）基準年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenymd</td><td>（中継用）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyousyono</td><td>（中継用）年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaisosikicd</td><td>（中継用）支払組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikohasseiymd</td><td>（中継用）事故発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytukigakunengakukbn</td><td>（中継用）月額年額区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhnnkgk</td><td>（中継用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeiyakunenkingaku</td><td>（中継用）契約年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykasannkgk</td><td>（中継用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyuwanosenenkingaku</td><td>（中継用）上乗せ年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysasihikisiharaigaku</td><td>（中継用）差引支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiharainenkingaku</td><td>（中継用）支払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiboujikyuuhukingaku</td><td>（中継用）死亡時給付金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiharaid</td><td>（中継用）支払Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygensentyousyuuzeigaku</td><td>（中継用）源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonotasiharaikingaku</td><td>（中継用）その他支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyttkekstkjyutukngk</td><td>（中継用）立替貸付充当金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkingakurank</td><td>（中継用）年金額ランク</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn</td><td>（中継用）年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorinaiyoukbn</td><td>（中継用）処理内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsiharaihouhoukbn</td><td>（中継用）年金支払方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinhanbaimeisyou</td><td>（中継用）年金販売名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkbn</td><td>（中継用）年金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsyu</td><td>（中継用）年金種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymotokeiyakusyouhinkbn</td><td>（中継用）元契約商品区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrhasseiriyuukbn</td><td>（中継用）年金支払発生理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshry</td><td>（中継用）年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinhosyoukikan</td><td>（中継用）年金保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykknsetymd</td><td>（中継用）基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokainenkinsiharaiymd</td><td>（中継用）初回年金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksjihihokensyaage</td><td>（中継用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyaseibetukbn</td><td>（中継用）第２被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksjidai2hhknsyaage</td><td>（中継用）年金開始時第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkuketorininkbn</td><td>（中継用）年金受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkuktrnnhukusuuninzuu</td><td>（中継用）年金受取人複数人数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhihokensyasibouymd</td><td>（中継用）被保険者死亡日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyasibouymd</td><td>（中継用）第２被保険者死亡年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhoujinuketorininhyouji</td><td>（中継用）法人受取人表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynktouduketorihouhoukbn</td><td>（中継用）年金当Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytatekaearihyouji</td><td>（中継用）立替有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasitukearihyouji</td><td>（中継用）貸付有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakuarihyouji</td><td>（中継用）特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkzeiseitekikakutkykkbn</td><td>（中継用）年金税制適格特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaikaisuukbn</td><td>（中継用）支払回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymotokykhrkhouhoukbn</td><td>（中継用）元契約払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisikakymd</td><td>（中継用）生死確認日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysegcd</td><td>（中継用）セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkigousedaikbn</td><td>（中継用）年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten1oyacd</td><td>（中継用）代理店１親コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten1oyakanjinm</td><td>（中継用）代理店１親漢字名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten2oyacd</td><td>（中継用）代理店２親コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten2oyakanjinm</td><td>（中継用）代理店２親漢字名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten1cd</td><td>（中継用）代理店１コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten1kanjinm</td><td>（中継用）代理店１漢字名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin1cd</td><td>（中継用）募集人１コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuu1kanjinm</td><td>（中継用）募集人１漢字名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten2cd</td><td>（中継用）代理店２コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairiten2kanjinm</td><td>（中継用）代理店２漢字名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunin2cd</td><td>（中継用）募集人２コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuu2kanjinm</td><td>（中継用）募集人２漢字名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankcd</td><td>（中継用）銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshitencd</td><td>（中継用）支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv71</td><td>（中継用）予備項目Ｖ７１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_OuNnknShrTy
 * @see     GenZT_OuNnknShrTy
 * @see     QZT_OuNnknShrTy
 * @see     GenQZT_OuNnknShrTy
 */
public class PKZT_OuNnknShrTy extends AbstractExDBPrimaryKey<ZT_OuNnknShrTy, PKZT_OuNnknShrTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_OuNnknShrTy() {
    }

    public PKZT_OuNnknShrTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_OuNnknShrTy> getEntityClass() {
        return ZT_OuNnknShrTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}