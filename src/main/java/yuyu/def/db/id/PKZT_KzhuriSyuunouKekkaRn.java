package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.mapping.GenZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.GenQZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaRn;

/**
 * 口座振替収納結果Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriSyuunouKekkaRn}</td><td colspan="3">口座振替収納結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikaeymd</td><td>（連携用）振替年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrsgaku</td><td>（連携用）領収金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnjyuutouym zrnjyuutouym}</td><td>（連携用）充当年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuutounensuu</td><td>（連携用）充当年数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuutoutukisuu</td><td>（連携用）充当月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaikobetukbn</td><td>（連携用）団体個別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknaiyoukbn</td><td>（連携用）入金内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaetkbtannaihyj</td><td>（連携用）口座振替特別案内表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekekkakbn</td><td>（連携用）振替結果区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurisyuudaikokbn</td><td>（連携用）口座振替収納代行会社区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv13</td><td>（連携用）予備項目Ｖ１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriSyuunouKekkaRn
 * @see     GenZT_KzhuriSyuunouKekkaRn
 * @see     QZT_KzhuriSyuunouKekkaRn
 * @see     GenQZT_KzhuriSyuunouKekkaRn
 */
public class PKZT_KzhuriSyuunouKekkaRn extends AbstractExDBPrimaryKey<ZT_KzhuriSyuunouKekkaRn, PKZT_KzhuriSyuunouKekkaRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KzhuriSyuunouKekkaRn() {
    }

    public PKZT_KzhuriSyuunouKekkaRn(String pZrnsyono, String pZrnjyuutouym) {
        zrnsyono = pZrnsyono;
        zrnjyuutouym = pZrnjyuutouym;
    }

    @Transient
    @Override
    public Class<ZT_KzhuriSyuunouKekkaRn> getEntityClass() {
        return ZT_KzhuriSyuunouKekkaRn.class;
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