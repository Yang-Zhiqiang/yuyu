package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.mapping.GenZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.GenQZT_ZitkAzukarikinSrRendouRn;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouRn;

/**
 * 税適預り金数理連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZitkAzukarikinSrRendouRn}</td><td colspan="3">税適預り金数理連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyuukourecordlength</td><td>（連携用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnrdwarea</td><td>（連携用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjynbknkbn</td><td>（連携用）準備金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentcd</td><td>（連携用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntndmatuzndk</td><td>（連携用）当年度末残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyoteirisoku</td><td>（連携用）予定利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkeiyakunendo</td><td>（連携用）契約年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin4</td><td>（連携用）数理用予備項目Ｎ４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin8</td><td>（連携用）数理用予備項目Ｎ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv93</td><td>（連携用）予備項目Ｖ９３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntndmatuzndkgaika</td><td>（連携用）当年度末残高（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv3</td><td>（連携用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZitkAzukarikinSrRendouRn
 * @see     GenZT_ZitkAzukarikinSrRendouRn
 * @see     QZT_ZitkAzukarikinSrRendouRn
 * @see     GenQZT_ZitkAzukarikinSrRendouRn
 */
public class PKZT_ZitkAzukarikinSrRendouRn extends AbstractExDBPrimaryKey<ZT_ZitkAzukarikinSrRendouRn, PKZT_ZitkAzukarikinSrRendouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_ZitkAzukarikinSrRendouRn() {
    }

    public PKZT_ZitkAzukarikinSrRendouRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_ZitkAzukarikinSrRendouRn> getEntityClass() {
        return ZT_ZitkAzukarikinSrRendouRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}