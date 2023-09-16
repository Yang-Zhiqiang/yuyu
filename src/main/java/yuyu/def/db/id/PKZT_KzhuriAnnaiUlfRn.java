package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.mapping.GenZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.GenQZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfRn;

/**
 * 口座振替案内ＵＬＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriAnnaiUlfRn}</td><td colspan="3">口座振替案内ＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaicd</td><td>（連携用）団体コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeannaikbn</td><td>（連携用）口座振替案内区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikaeymd</td><td>（連携用）振替年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrsgaku</td><td>（連携用）領収金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnjyuutouym zrnjyuutouym}</td><td>（連携用）充当年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuutounensuu</td><td>（連携用）充当年数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuutoutukisuu</td><td>（連携用）充当月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaikobetukbn</td><td>（連携用）団体個別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknaiyou</td><td>（連携用）入金内容</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaisosikicd</td><td>（連携用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaetkbtannaihyj</td><td>（連携用）口座振替特別案内表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkgk</td><td>（連携用）払込額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntsnsknewyno</td><td>（連携用）通信先新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsnsknewtikucd</td><td>（連携用）通信先新地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaikojincd</td><td>（連携用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikeisyouhinhyj</td><td>（連携用）提携商品表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmei</td><td>（連携用）口座名義人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeizokup</td><td>（連携用）継続保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrniktwaribikikgk</td><td>（連携用）一括割引額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkeizokupnaiyoukbn</td><td>（連携用）継続Ｐ内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhisaijiannaitsghyj</td><td>（連携用）被災時案内対象外表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaisyono</td><td>（連携用）代表証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurisyuudaikokbn</td><td>（連携用）口座振替収納代行会社区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriAnnaiUlfRn
 * @see     GenZT_KzhuriAnnaiUlfRn
 * @see     QZT_KzhuriAnnaiUlfRn
 * @see     GenQZT_KzhuriAnnaiUlfRn
 */
public class PKZT_KzhuriAnnaiUlfRn extends AbstractExDBPrimaryKey<ZT_KzhuriAnnaiUlfRn, PKZT_KzhuriAnnaiUlfRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KzhuriAnnaiUlfRn() {
    }

    public PKZT_KzhuriAnnaiUlfRn(String pZrnsyono, String pZrnjyuutouym) {
        zrnsyono = pZrnsyono;
        zrnjyuutouym = pZrnjyuutouym;
    }

    @Transient
    @Override
    public Class<ZT_KzhuriAnnaiUlfRn> getEntityClass() {
        return ZT_KzhuriAnnaiUlfRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnjyuutouym;

    public String getZrnjyuutouym() {
        return zrnjyuutouym;
    }

    public void setZrnjyuutouym(String pZrnjyuutouym) {
        zrnjyuutouym = pZrnjyuutouym;
    }

}