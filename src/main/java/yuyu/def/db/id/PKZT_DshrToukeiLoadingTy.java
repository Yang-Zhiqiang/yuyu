package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;
import yuyu.def.db.mapping.GenZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.GenQZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingTy;

/**
 * Ｄ支払統計ローディングＦテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DshrToukeiLoadingTy}</td><td colspan="3">Ｄ支払統計ローディングＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydshrym</td><td>（中継用）Ｄ支払年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakunendo</td><td>（中継用）契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaikigetu</td><td>（中継用）案内期月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyruikbn</td><td>（中継用）保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysegcd</td><td>（中継用）セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrriyuukbn</td><td>（中継用）支払理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaikbn</td><td>（中継用）案内区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduketorihouhoukbn</td><td>（中継用）Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetukbn</td><td>（中継用）消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikinhyj</td><td>（中継用）備金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskskbn</td><td>（中継用）作成区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrkensuu</td><td>（中継用）数理用件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysrhsys</td><td>（中継用）数理用保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoujigyounendod</td><td>（中継用）当事業年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoujigyounendohasseidrsk</td><td>（中継用）当事業年度発生Ｄ利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzenjigyounendomatudzndk</td><td>（中継用）前事業年度末Ｄ残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyokujigyounendod</td><td>（中継用）翌事業年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhushrtoujigyounendod</td><td>（中継用）不支払当事業年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_DshrToukeiLoadingTy
 * @see     GenZT_DshrToukeiLoadingTy
 * @see     QZT_DshrToukeiLoadingTy
 * @see     GenQZT_DshrToukeiLoadingTy
 */
public class PKZT_DshrToukeiLoadingTy extends AbstractExDBPrimaryKey<ZT_DshrToukeiLoadingTy, PKZT_DshrToukeiLoadingTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DshrToukeiLoadingTy() {
    }

    public PKZT_DshrToukeiLoadingTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_DshrToukeiLoadingTy> getEntityClass() {
        return ZT_DshrToukeiLoadingTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}