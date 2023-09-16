package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.mapping.GenZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.GenQZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaTr;

/**
 * 口座振替収納結果Ｆテーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriSyuunouKekkaTr}</td><td colspan="3">口座振替収納結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyono ztrsyono}</td><td>（取込用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaebankcd</td><td>（取込用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaesitencd</td><td>（取込用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaeyokinkbn</td><td>（取込用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaekouzano</td><td>（取込用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhurikaeymd</td><td>（取込用）振替年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrrsgaku</td><td>（取込用）領収金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrjyuutouym ztrjyuutouym}</td><td>（取込用）充当年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrjyuutounensuu</td><td>（取込用）充当年数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrjyuutoutukisuu</td><td>（取込用）充当月数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdantaikobetukbn</td><td>（取込用）団体個別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrnyknaiyoukbn</td><td>（取込用）入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhrkkaisuukbn</td><td>（取込用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurikaetkbtannaihyj</td><td>（取込用）口座振替特別案内表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhurikaekekkakbn</td><td>（取込用）振替結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkzhurisyuudaikokbn</td><td>（取込用）口座振替収納代行会社区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv13</td><td>（取込用）予備項目Ｖ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriSyuunouKekkaTr
 * @see     GenZT_KzhuriSyuunouKekkaTr
 * @see     QZT_KzhuriSyuunouKekkaTr
 * @see     GenQZT_KzhuriSyuunouKekkaTr
 */
public class PKZT_KzhuriSyuunouKekkaTr extends AbstractExDBPrimaryKey<ZT_KzhuriSyuunouKekkaTr, PKZT_KzhuriSyuunouKekkaTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_KzhuriSyuunouKekkaTr() {
    }

    public PKZT_KzhuriSyuunouKekkaTr(String pZtrsyono, String pZtrjyuutouym) {
        ztrsyono = pZtrsyono;
        ztrjyuutouym = pZtrjyuutouym;
    }

    @Transient
    @Override
    public Class<ZT_KzhuriSyuunouKekkaTr> getEntityClass() {
        return ZT_KzhuriSyuunouKekkaTr.class;
    }

    private String ztrsyono;

    public String getZtrsyono() {
        return ztrsyono;
    }

    public void setZtrsyono(String pZtrsyono) {
        ztrsyono = pZtrsyono;
    }
    private String ztrjyuutouym;

    public String getZtrjyuutouym() {
        return ztrjyuutouym;
    }

    public void setZtrjyuutouym(String pZtrjyuutouym) {
        ztrjyuutouym = pZtrjyuutouym;
    }

}