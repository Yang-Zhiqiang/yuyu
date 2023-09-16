package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.mapping.GenZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaTr;

/**
 * 初回保険料売上請求結果テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_FstpUriageSeikyuuKekkaTr}</td><td colspan="3">初回保険料売上請求結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrrecordkbn</td><td>（取込用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrauthorikbn</td><td>（取込用）オーソリ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztruriageseikyuutorihikicd</td><td>（取込用）売上請求取引コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv14</td><td>（取込用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztruriagetaisyouym</td><td>（取込用）売上対象年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtruriageymd6keta ztruriageymd6keta}</td><td>（取込用）売上年月日（６桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditkigyoucd</td><td>（取込用）クレジット企業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyono ztrsyono}</td><td>（取込用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrecordno ztrrecordno}</td><td>（取込用）レコード番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv3</td><td>（取込用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcardyuukoukigen</td><td>（取込用）カード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseikyuukngk ztrseikyuukngk}</td><td>（取込用）請求金額</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztryobiv5</td><td>（取込用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditkaiinnokami6keta</td><td>（取込用）クレジット会員番号（上６桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv6</td><td>（取込用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditkaiinnosimo4keta</td><td>（取込用）クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztruriageseikyuuerrorcd</td><td>（取込用）売上請求エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhurikaekekkacd</td><td>（取込用）振替結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrfukusuukameitennokey</td><td>（取込用）複数加盟店番号設定キー情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv1</td><td>（取込用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_FstpUriageSeikyuuKekkaTr
 * @see     GenZT_FstpUriageSeikyuuKekkaTr
 * @see     QZT_FstpUriageSeikyuuKekkaTr
 * @see     GenQZT_FstpUriageSeikyuuKekkaTr
 */
public class PKZT_FstpUriageSeikyuuKekkaTr extends AbstractExDBPrimaryKey<ZT_FstpUriageSeikyuuKekkaTr, PKZT_FstpUriageSeikyuuKekkaTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_FstpUriageSeikyuuKekkaTr() {
    }

    public PKZT_FstpUriageSeikyuuKekkaTr(
        String pZtruriageymd6keta,
        String pZtrcreditkessaiyouno,
        String pZtrsyono,
        String pZtrrecordno,
        Long pZtrseikyuukngk
    ) {
        ztruriageymd6keta = pZtruriageymd6keta;
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
        ztrsyono = pZtrsyono;
        ztrrecordno = pZtrrecordno;
        ztrseikyuukngk = pZtrseikyuukngk;
    }

    @Transient
    @Override
    public Class<ZT_FstpUriageSeikyuuKekkaTr> getEntityClass() {
        return ZT_FstpUriageSeikyuuKekkaTr.class;
    }

    private String ztruriageymd6keta;

    public String getZtruriageymd6keta() {
        return ztruriageymd6keta;
    }

    public void setZtruriageymd6keta(String pZtruriageymd6keta) {
        ztruriageymd6keta = pZtruriageymd6keta;
    }
    private String ztrcreditkessaiyouno;

    public String getZtrcreditkessaiyouno() {
        return ztrcreditkessaiyouno;
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
    }
    private String ztrsyono;

    public String getZtrsyono() {
        return ztrsyono;
    }

    public void setZtrsyono(String pZtrsyono) {
        ztrsyono = pZtrsyono;
    }
    private String ztrrecordno;

    public String getZtrrecordno() {
        return ztrrecordno;
    }

    public void setZtrrecordno(String pZtrrecordno) {
        ztrrecordno = pZtrrecordno;
    }
    private Long ztrseikyuukngk;

    public Long getZtrseikyuukngk() {
        return ztrseikyuukngk;
    }

    public void setZtrseikyuukngk(Long pZtrseikyuukngk) {
        ztrseikyuukngk = pZtrseikyuukngk;
    }

}