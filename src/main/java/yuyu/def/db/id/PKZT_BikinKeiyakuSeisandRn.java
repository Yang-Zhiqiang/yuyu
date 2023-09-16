package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.mapping.GenZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.meta.GenQZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandRn;

/**
 * 備金契約精算ＤＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BikinKeiyakuSeisandRn}</td><td colspan="3">備金契約精算ＤＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyuukourecordlength</td><td>（連携用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnrdwarea</td><td>（連携用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikinkbn</td><td>（連携用）備金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikinnendokbn</td><td>（連携用）備金年度区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisand</td><td>（連携用）精算Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntumitaterisoku</td><td>（連携用）積立利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyuruicd1</td><td>（連携用）種類コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuruicd3</td><td>（連携用）種類コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrkijyunym</td><td>（連携用）数理用基準年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentkbn</td><td>（連携用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyourgnbnskkbn</td><td>（連携用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuruicd2</td><td>（連携用）種類コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkariwariatedganrikin</td><td>（連携用）仮割当Ｄ元利金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariatedrisoku</td><td>（連携用）仮割当Ｄ利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakusyuruicdv2</td><td>（連携用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakunendo</td><td>（連携用）契約年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaihyouyoteiriritu</td><td>（連携用）代表予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnharaikatakbn</td><td>（連携用）払方区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv32</td><td>（連携用）予備項目Ｖ３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_BikinKeiyakuSeisandRn
 * @see     GenZT_BikinKeiyakuSeisandRn
 * @see     QZT_BikinKeiyakuSeisandRn
 * @see     GenQZT_BikinKeiyakuSeisandRn
 */
public class PKZT_BikinKeiyakuSeisandRn extends AbstractExDBPrimaryKey<ZT_BikinKeiyakuSeisandRn, PKZT_BikinKeiyakuSeisandRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_BikinKeiyakuSeisandRn() {
    }

    public PKZT_BikinKeiyakuSeisandRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_BikinKeiyakuSeisandRn> getEntityClass() {
        return ZT_BikinKeiyakuSeisandRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}