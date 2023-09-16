package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KessanYokukiP;
import yuyu.def.db.mapping.GenIT_KessanYokukiP;
import yuyu.def.db.meta.GenQIT_KessanYokukiP;
import yuyu.def.db.meta.QIT_KessanYokukiP;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 決算用翌期Ｐテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KessanYokukiP}</td><td colspan="3">決算用翌期Ｐテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeijyouym keijyouym}</td><td>計上年月</td><td align="center">○</td><td align="center">N</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigousdkbn1keta</td><td>保険種類記号世代区分（１桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x1</td><td>保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x2</td><td>保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x3</td><td>保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x4</td><td>保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x5</td><td>保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x6</td><td>保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x7</td><td>保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x8</td><td>保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x9</td><td>保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x10</td><td>保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x11</td><td>保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x12</td><td>保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x13</td><td>保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x14</td><td>保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi1x15</td><td>保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x1</td><td>保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x2</td><td>保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x3</td><td>保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x4</td><td>保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x5</td><td>保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x6</td><td>保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x7</td><td>保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x8</td><td>保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x9</td><td>保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi2x10</td><td>保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x1</td><td>保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x2</td><td>保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x3</td><td>保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x4</td><td>保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x5</td><td>保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x6</td><td>保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x7</td><td>保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x8</td><td>保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x9</td><td>保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruikigouyobi3x10</td><td>保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>annaihuyouriyuukbn</td><td>案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoumetucd</td><td>消滅コード</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>haraikomip</td><td>払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukykp</td><td>主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennyknmonth</td><td>前回入金月数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zenyuukinymd</td><td>前回入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jidoukousinhyouji</td><td>自動更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tenkanhyouji</td><td>転換表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hosyouikkatumnoshyouji</td><td>保障一括見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yobi01xv40</td><td>予備０１＿Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkkzkp</td><td>特約継続Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>keizokuphurikaekngk</td><td>継続Ｐ振替金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>keizokuphurikaekaisiym</td><td>継続Ｐ振替開始年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>haraikomipannaisaikaiym</td><td>払込Ｐ案内再開年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>tkkzkkouryokukaisiymd</td><td>特約継続効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrimngtkykpjyuutouhoukbn</td><td>払満後特約Ｐ充当方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jkitkpjytym</td><td>次回特約Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>itijibrzugktkp</td><td>一時払増額特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>pazukarikingk</td><td>Ｐ預り金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zennoukbn</td><td>前納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennoukaisiymd</td><td>前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennounyuukinymd</td><td>前納入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yokukipbunruicd</td><td>翌期Ｐ分類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd1</td><td>未処理コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd2</td><td>未処理コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd3</td><td>未処理コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd4</td><td>未処理コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd5</td><td>未処理コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd6</td><td>未処理コード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd7</td><td>未処理コード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd8</td><td>未処理コード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd9</td><td>未処理コード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyoricd10</td><td>未処理コード１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yobi02xv39</td><td>予備０２＿Ｖ３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeiriyousegmentkbn</td><td>区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeiriyourgnbnskkbn</td><td>区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>suurisyuruicd</td><td>数理種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>kyknendo</td><td>契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keiyakum</td><td>契約月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haraikatakbn</td><td>払方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>iktyknndp</td><td>一括払翌年度保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kigetumaenyknyknndp</td><td>期月前入金翌年度保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yknndpkei</td><td>翌年度保険料合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yobi03xn13</td><td>予備０３＿Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yobi04xv23</td><td>予備０４＿Ｖ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KessanYokukiP
 * @see     GenIT_KessanYokukiP
 * @see     QIT_KessanYokukiP
 * @see     GenQIT_KessanYokukiP
 */
public class PKIT_KessanYokukiP extends AbstractExDBPrimaryKey<IT_KessanYokukiP, PKIT_KessanYokukiP> {

    private static final long serialVersionUID = 1L;

    public PKIT_KessanYokukiP() {
    }

    public PKIT_KessanYokukiP(
        String pKbnkey,
        BizDateYM pKeijyouym,
        String pSyono
    ) {
        kbnkey = pKbnkey;
        keijyouym = pKeijyouym;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_KessanYokukiP> getEntityClass() {
        return IT_KessanYokukiP.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private BizDateYM keijyouym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getKeijyouym() {
        return keijyouym;
    }

    public void setKeijyouym(BizDateYM pKeijyouym) {
        keijyouym = pKeijyouym;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}