package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.mapping.GenZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.GenQZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiRn;

/**
 * 郵政未入契約明細照会用Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuseiMinyuKykDtlSyokaiRn}</td><td colspan="3">郵政未入契約明細照会用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsakuseiym zrnsakuseiym}</td><td>（連携用）作成年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntntusycd zrntntusycd}</td><td>（連携用）担当者コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpjyuutouyymmwareki4keta</td><td>（連携用）保険料充当年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymwareki4keta</td><td>（連携用）契約年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakinm</td><td>（連携用）宛先名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuujyutuymdyofuri</td><td>（連携用）未入充当年月（預振）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuujyutuymdyofuriigi</td><td>（連携用）未入充当年月（預振以外）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhassinka</td><td>（連携用）発信課</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntelno15keta</td><td>（連携用）電話番号（１５桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbsyymwareki4keta</td><td>（連携用）募集年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntntusynm</td><td>（連携用）担当者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkydatkikbnkj</td><td>（連携用）共同扱区分（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj20</td><td>（連携用）契約者名（漢字）（２０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhjnkykhyj</td><td>（連携用）法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukj</td><td>（連携用）払込回数（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokj</td><td>（連携用）払込経路（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnp11keta</td><td>（連携用）保険料（１１桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnknkimnyuuryukj</td><td>（連携用）今回未入理由（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnjikaiminyuuji</td><td>（連携用）次回未入時</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntntusygyouhaiinfo</td><td>（連携用）担当者業廃情報</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirobtjhmidasi</td><td>（連携用）払込経路別情報見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirobtjh</td><td>（連携用）払込経路別情報</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruimei</td><td>（連携用）保険種類名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbkofccd</td><td>（連携用）バックオフィスコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndbskyoteiymd</td><td>（連携用）ＤＢ削除予定年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv23</td><td>（連携用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuseiMinyuKykDtlSyokaiRn
 * @see     GenZT_YuseiMinyuKykDtlSyokaiRn
 * @see     QZT_YuseiMinyuKykDtlSyokaiRn
 * @see     GenQZT_YuseiMinyuKykDtlSyokaiRn
 */
public class PKZT_YuseiMinyuKykDtlSyokaiRn extends AbstractExDBPrimaryKey<ZT_YuseiMinyuKykDtlSyokaiRn, PKZT_YuseiMinyuKykDtlSyokaiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_YuseiMinyuKykDtlSyokaiRn() {
    }

    public PKZT_YuseiMinyuKykDtlSyokaiRn(
        String pZrnsakuseiym,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono
    ) {
        zrnsakuseiym = pZrnsakuseiym;
        zrnbsydrtencd = pZrnbsydrtencd;
        zrntntusycd = pZrntntusycd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_YuseiMinyuKykDtlSyokaiRn> getEntityClass() {
        return ZT_YuseiMinyuKykDtlSyokaiRn.class;
    }

    private String zrnsakuseiym;

    public String getZrnsakuseiym() {
        return zrnsakuseiym;
    }

    public void setZrnsakuseiym(String pZrnsakuseiym) {
        zrnsakuseiym = pZrnsakuseiym;
    }
    private String zrnbsydrtencd;

    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }
    private String zrntntusycd;

    public String getZrntntusycd() {
        return zrntntusycd;
    }

    public void setZrntntusycd(String pZrntntusycd) {
        zrntntusycd = pZrntntusycd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}