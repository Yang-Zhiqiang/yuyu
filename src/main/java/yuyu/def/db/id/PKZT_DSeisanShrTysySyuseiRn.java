package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.mapping.GenZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.GenQZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiRn;

/**
 * Ｄ精算支払調書修正テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DSeisanShrTysySyuseiRn}</td><td colspan="3">Ｄ精算支払調書修正テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisandshrymd</td><td>（連携用）精算Ｄ支払年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisandkgk11</td><td>（連携用）精算Ｄ金額Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntyouseidkgk11</td><td>（連携用）調整Ｄ金額Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv19</td><td>（連携用）予備項目Ｖ１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DSeisanShrTysySyuseiRn
 * @see     GenZT_DSeisanShrTysySyuseiRn
 * @see     QZT_DSeisanShrTysySyuseiRn
 * @see     GenQZT_DSeisanShrTysySyuseiRn
 */
public class PKZT_DSeisanShrTysySyuseiRn extends AbstractExDBPrimaryKey<ZT_DSeisanShrTysySyuseiRn, PKZT_DSeisanShrTysySyuseiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DSeisanShrTysySyuseiRn() {
    }

    public PKZT_DSeisanShrTysySyuseiRn(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_DSeisanShrTysySyuseiRn> getEntityClass() {
        return ZT_DSeisanShrTysySyuseiRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}