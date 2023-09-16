package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_UriageKekkaRn;
import yuyu.def.db.mapping.GenZT_UriageKekkaRn;
import yuyu.def.db.meta.GenQZT_UriageKekkaRn;
import yuyu.def.db.meta.QZT_UriageKekkaRn;

/**
 * 売上結果Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_UriageKekkaRn}</td><td colspan="3">売上結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnauthorikbn</td><td>（連携用）オーソリ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuriageseikyuutorihikicd</td><td>（連携用）売上請求取引コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv14</td><td>（連携用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuriagetaisyouym</td><td>（連携用）売上対象年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnuriageymd6keta zrnuriageymd6keta}</td><td>（連携用）売上年月日（６桁）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditkigyoucd</td><td>（連携用）クレジット企業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrecordno zrnrecordno}</td><td>（連携用）レコード番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv3</td><td>（連携用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardyuukoukigen</td><td>（連携用）カード有効期限</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnseikyuukngk zrnseikyuukngk}</td><td>（連携用）請求金額</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv5</td><td>（連携用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditkaiinnokami6keta</td><td>（連携用）クレジット会員番号（上６桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6</td><td>（連携用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditkaiinnosimo4keta</td><td>（連携用）クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuriageseikyuuerrorcd</td><td>（連携用）売上請求エラーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekekkacd</td><td>（連携用）振替結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfukusuukameitennokey</td><td>（連携用）複数加盟店番号設定キー情報</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_UriageKekkaRn
 * @see     GenZT_UriageKekkaRn
 * @see     QZT_UriageKekkaRn
 * @see     GenQZT_UriageKekkaRn
 */
public class PKZT_UriageKekkaRn extends AbstractExDBPrimaryKey<ZT_UriageKekkaRn, PKZT_UriageKekkaRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_UriageKekkaRn() {
    }

    public PKZT_UriageKekkaRn(
        String pZrnsyono,
        String pZrncreditkessaiyouno,
        String pZrnuriageymd6keta,
        String pZrnrecordno,
        Long pZrnseikyuukngk
    ) {
        zrnsyono = pZrnsyono;
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
        zrnuriageymd6keta = pZrnuriageymd6keta;
        zrnrecordno = pZrnrecordno;
        zrnseikyuukngk = pZrnseikyuukngk;
    }

    @Transient
    @Override
    public Class<ZT_UriageKekkaRn> getEntityClass() {
        return ZT_UriageKekkaRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrncreditkessaiyouno;

    public String getZrncreditkessaiyouno() {
        return zrncreditkessaiyouno;
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }
    private String zrnuriageymd6keta;

    public String getZrnuriageymd6keta() {
        return zrnuriageymd6keta;
    }

    public void setZrnuriageymd6keta(String pZrnuriageymd6keta) {
        zrnuriageymd6keta = pZrnuriageymd6keta;
    }
    private String zrnrecordno;

    public String getZrnrecordno() {
        return zrnrecordno;
    }

    public void setZrnrecordno(String pZrnrecordno) {
        zrnrecordno = pZrnrecordno;
    }
    private Long zrnseikyuukngk;

    public Long getZrnseikyuukngk() {
        return zrnseikyuukngk;
    }

    public void setZrnseikyuukngk(Long pZrnseikyuukngk) {
        zrnseikyuukngk = pZrnseikyuukngk;
    }

}