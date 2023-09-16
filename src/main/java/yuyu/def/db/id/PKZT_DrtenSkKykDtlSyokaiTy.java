package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.mapping.GenZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiTy;

/**
 * 代理店失効契約明細照会用Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenSkKykDtlSyokaiTy}</td><td colspan="3">代理店失効契約明細照会用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysakuseiym ztysakuseiym}</td><td>（中継用）作成年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytntusycd ztytntusycd}</td><td>（中継用）担当者コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymwareki4keta</td><td>（中継用）契約年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakinm</td><td>（中継用）宛先名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassinka</td><td>（中継用）発信課</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytelno15keta</td><td>（中継用）電話番号（１５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyymwareki4keta</td><td>（中継用）募集年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytntusynm</td><td>（中継用）担当者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkikbnkj</td><td>（中継用）共同扱区分（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj20</td><td>（中継用）契約者名（漢字）（２０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskymdwareki</td><td>（中継用）失効年月日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukj</td><td>（中継用）払込回数（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokj</td><td>（中継用）払込経路（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyp11keta</td><td>（中継用）保険料（１１桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyskhr</td><td>（中継用）失効時返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyjizensyoukaiyouhyj</td><td>（中継用）事前照会要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytntusygyouhaiinfo</td><td>（中継用）担当者業廃情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirobtjhmidasi</td><td>（中継用）払込経路別情報見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirobtjh</td><td>（中継用）払込経路別情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruimei</td><td>（中継用）保険種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybkofccd</td><td>（中継用）バックオフィスコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydbskyoteiymd</td><td>（中継用）ＤＢ削除予定年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyukaisuu</td><td>（中継用）未入回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaipjyuutouym</td><td>（中継用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvitkaiinno</td><td>（中継用）Ｖｉｔ会員番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvitkykym</td><td>（中継用）Ｖｉｔ契約年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvitskymd</td><td>（中継用）Ｖｉｔ失効年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvithrkkaisuu</td><td>（中継用）Ｖｉｔ払込回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvithrkkeiro</td><td>（中継用）Ｖｉｔ払込経路</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzkomivitriyoury</td><td>（中継用）税込Ｖｉｔ利用料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyvitnyknkaisuu</td><td>（中継用）Ｖｉｔ入金回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvitbikou</td><td>（中継用）Ｖｉｔ備考</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv25</td><td>（中継用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenSkKykDtlSyokaiTy
 * @see     GenZT_DrtenSkKykDtlSyokaiTy
 * @see     QZT_DrtenSkKykDtlSyokaiTy
 * @see     GenQZT_DrtenSkKykDtlSyokaiTy
 */
public class PKZT_DrtenSkKykDtlSyokaiTy extends AbstractExDBPrimaryKey<ZT_DrtenSkKykDtlSyokaiTy, PKZT_DrtenSkKykDtlSyokaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenSkKykDtlSyokaiTy() {
    }

    public PKZT_DrtenSkKykDtlSyokaiTy(
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
    public Class<ZT_DrtenSkKykDtlSyokaiTy> getEntityClass() {
        return ZT_DrtenSkKykDtlSyokaiTy.class;
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