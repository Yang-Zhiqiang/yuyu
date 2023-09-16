package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.mapping.GenZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.GenQZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouTy;

/**
 * 税適預り金数理連動Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZitkAzukarikinSrRendouTy}</td><td colspan="3">税適預り金数理連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjynbknkbn</td><td>（中継用）準備金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentcd</td><td>（中継用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytndmatuzndk</td><td>（中継用）当年度末残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyoteirisoku</td><td>（中継用）予定利息</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeiyakunendo</td><td>（中継用）契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin4</td><td>（中継用）数理用予備項目Ｎ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8</td><td>（中継用）数理用予備項目Ｎ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv93</td><td>（中継用）予備項目Ｖ９３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytndmatuzndkgaika</td><td>（中継用）当年度末残高（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv3</td><td>（中継用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZitkAzukarikinSrRendouTy
 * @see     GenZT_ZitkAzukarikinSrRendouTy
 * @see     QZT_ZitkAzukarikinSrRendouTy
 * @see     GenQZT_ZitkAzukarikinSrRendouTy
 */
public class PKZT_ZitkAzukarikinSrRendouTy extends AbstractExDBPrimaryKey<ZT_ZitkAzukarikinSrRendouTy, PKZT_ZitkAzukarikinSrRendouTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_ZitkAzukarikinSrRendouTy() {
    }

    public PKZT_ZitkAzukarikinSrRendouTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_ZitkAzukarikinSrRendouTy> getEntityClass() {
        return ZT_ZitkAzukarikinSrRendouTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}