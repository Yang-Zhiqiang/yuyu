package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.mapping.GenZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiTy;

/**
 * 代理店未入契約明細照会用Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMinyuKykDtlSyokaiTy}</td><td colspan="3">代理店未入契約明細照会用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysakuseiym ztysakuseiym}</td><td>（中継用）作成年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytntusycd ztytntusycd}</td><td>（中継用）担当者コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypjyuutouyymmwareki4keta</td><td>（中継用）保険料充当年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymwareki4keta</td><td>（中継用）契約年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakinm</td><td>（中継用）宛先名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuujyutuymdyofuri</td><td>（中継用）未入充当年月（預振）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuujyutuymdyofuriigi</td><td>（中継用）未入充当年月（預振以外）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassinka</td><td>（中継用）発信課</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytelno15keta</td><td>（中継用）電話番号（１５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyymwareki4keta</td><td>（中継用）募集年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytntusynm</td><td>（中継用）担当者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkikbnkj</td><td>（中継用）共同扱区分（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj20</td><td>（中継用）契約者名（漢字）（２０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukj</td><td>（中継用）払込回数（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokj</td><td>（中継用）払込経路（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyp11keta</td><td>（中継用）保険料（１１桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyknkimnyuuryukj</td><td>（中継用）今回未入理由（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaiminyuuji</td><td>（中継用）次回未入時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytntusygyouhaiinfo</td><td>（中継用）担当者業廃情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirobtjhmidasi</td><td>（中継用）払込経路別情報見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirobtjh</td><td>（中継用）払込経路別情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruimei</td><td>（中継用）保険種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybkofccd</td><td>（中継用）バックオフィスコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydbskyoteiymd</td><td>（中継用）ＤＢ削除予定年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv24</td><td>（中継用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMinyuKykDtlSyokaiTy
 * @see     GenZT_DrtenMinyuKykDtlSyokaiTy
 * @see     QZT_DrtenMinyuKykDtlSyokaiTy
 * @see     GenQZT_DrtenMinyuKykDtlSyokaiTy
 */
public class PKZT_DrtenMinyuKykDtlSyokaiTy extends AbstractExDBPrimaryKey<ZT_DrtenMinyuKykDtlSyokaiTy, PKZT_DrtenMinyuKykDtlSyokaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenMinyuKykDtlSyokaiTy() {
    }

    public PKZT_DrtenMinyuKykDtlSyokaiTy(
        String pZtysakuseiym,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono
    ) {
        ztysakuseiym = pZtysakuseiym;
        ztybsydrtencd = pZtybsydrtencd;
        ztytntusycd = pZtytntusycd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_DrtenMinyuKykDtlSyokaiTy> getEntityClass() {
        return ZT_DrtenMinyuKykDtlSyokaiTy.class;
    }

    private String ztysakuseiym;

    public String getZtysakuseiym() {
        return ztysakuseiym;
    }

    public void setZtysakuseiym(String pZtysakuseiym) {
        ztysakuseiym = pZtysakuseiym;
    }
    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztytntusycd;

    public String getZtytntusycd() {
        return ztytntusycd;
    }

    public void setZtytntusycd(String pZtytntusycd) {
        ztytntusycd = pZtytntusycd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}