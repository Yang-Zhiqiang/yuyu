package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.mapping.GenZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.GenQZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiTy;

/**
 * Ｄ精算支払調書修正テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DSeisanShrTysySyuseiTy}</td><td colspan="3">Ｄ精算支払調書修正テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisandshrymd</td><td>（中継用）精算Ｄ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisandkgk11</td><td>（中継用）精算Ｄ金額Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytyouseidkgk11</td><td>（中継用）調整Ｄ金額Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv19</td><td>（中継用）予備項目Ｖ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DSeisanShrTysySyuseiTy
 * @see     GenZT_DSeisanShrTysySyuseiTy
 * @see     QZT_DSeisanShrTysySyuseiTy
 * @see     GenQZT_DSeisanShrTysySyuseiTy
 */
public class PKZT_DSeisanShrTysySyuseiTy extends AbstractExDBPrimaryKey<ZT_DSeisanShrTysySyuseiTy, PKZT_DSeisanShrTysySyuseiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DSeisanShrTysySyuseiTy() {
    }

    public PKZT_DSeisanShrTysySyuseiTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_DSeisanShrTysySyuseiTy> getEntityClass() {
        return ZT_DSeisanShrTysySyuseiTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}