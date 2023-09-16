package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingRn;
import yuyu.def.db.mapping.GenZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.GenQZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingRn;

/**
 * Ｄ支払統計ローディングＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DshrToukeiLoadingRn}</td><td colspan="3">Ｄ支払統計ローディングＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyuukourecordlength</td><td>（連携用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnrdwarea</td><td>（連携用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndshrym</td><td>（連携用）Ｄ支払年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakunendo</td><td>（連携用）契約年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaikigetu</td><td>（連携用）案内期月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyruikbn</td><td>（連携用）保険種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsegcd</td><td>（連携用）セグメントコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrriyuukbn</td><td>（連携用）支払理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaikbn</td><td>（連携用）案内区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduketorihouhoukbn</td><td>（連携用）Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetukbn</td><td>（連携用）消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikinhyj</td><td>（連携用）備金表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskskbn</td><td>（連携用）作成区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrkensuu</td><td>（連携用）数理用件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsrhsys</td><td>（連携用）数理用保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoujigyounendod</td><td>（連携用）当事業年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoujigyounendohasseidrsk</td><td>（連携用）当事業年度発生Ｄ利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzenjigyounendomatudzndk</td><td>（連携用）前事業年度末Ｄ残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyokujigyounendod</td><td>（連携用）翌事業年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhushrtoujigyounendod</td><td>（連携用）不支払当事業年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_DshrToukeiLoadingRn
 * @see     GenZT_DshrToukeiLoadingRn
 * @see     QZT_DshrToukeiLoadingRn
 * @see     GenQZT_DshrToukeiLoadingRn
 */
public class PKZT_DshrToukeiLoadingRn extends AbstractExDBPrimaryKey<ZT_DshrToukeiLoadingRn, PKZT_DshrToukeiLoadingRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DshrToukeiLoadingRn() {
    }

    public PKZT_DshrToukeiLoadingRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_DshrToukeiLoadingRn> getEntityClass() {
        return ZT_DshrToukeiLoadingRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}