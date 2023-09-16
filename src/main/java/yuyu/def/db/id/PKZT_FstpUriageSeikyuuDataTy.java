package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.mapping.GenZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataTy;

/**
 * 初回保険料売上請求データテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_FstpUriageSeikyuuDataTy}</td><td colspan="3">初回保険料売上請求データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyrecordkbn</td><td>（中継用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyauthorikbn</td><td>（中継用）オーソリ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuriageseikyuutorihikicd</td><td>（中継用）売上請求取引コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv14</td><td>（中継用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuriagetaisyouym</td><td>（中継用）売上対象年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyuriageymd6keta ztyuriageymd6keta}</td><td>（中継用）売上年月日（６桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditkigyoucd</td><td>（中継用）クレジット企業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtycreditkessaiyouno ztycreditkessaiyouno}</td><td>（中継用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyrecordno ztyrecordno}</td><td>（中継用）レコード番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv3</td><td>（中継用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycardyuukoukigen</td><td>（中継用）カード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyseikyuukngk11keta ztyseikyuukngk11keta}</td><td>（中継用）請求金額（１１桁）</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv2</td><td>（中継用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditkaiinnokami6keta</td><td>（中継用）クレジット会員番号（上６桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditkaiinnosimo4keta</td><td>（中継用）クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuriageseikyuuerrorcd</td><td>（中継用）売上請求エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekekkacd</td><td>（中継用）振替結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfukusuukameitennokey</td><td>（中継用）複数加盟店番号設定キー情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_FstpUriageSeikyuuDataTy
 * @see     GenZT_FstpUriageSeikyuuDataTy
 * @see     QZT_FstpUriageSeikyuuDataTy
 * @see     GenQZT_FstpUriageSeikyuuDataTy
 */
public class PKZT_FstpUriageSeikyuuDataTy extends AbstractExDBPrimaryKey<ZT_FstpUriageSeikyuuDataTy, PKZT_FstpUriageSeikyuuDataTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_FstpUriageSeikyuuDataTy() {
    }

    public PKZT_FstpUriageSeikyuuDataTy(
        String pZtyuriageymd6keta,
        String pZtycreditkessaiyouno,
        String pZtysyono,
        String pZtyrecordno,
        Long pZtyseikyuukngk11keta
    ) {
        ztyuriageymd6keta = pZtyuriageymd6keta;
        ztycreditkessaiyouno = pZtycreditkessaiyouno;
        ztysyono = pZtysyono;
        ztyrecordno = pZtyrecordno;
        ztyseikyuukngk11keta = pZtyseikyuukngk11keta;
    }

    @Transient
    @Override
    public Class<ZT_FstpUriageSeikyuuDataTy> getEntityClass() {
        return ZT_FstpUriageSeikyuuDataTy.class;
    }

    private String ztyuriageymd6keta;

    public String getZtyuriageymd6keta() {
        return ztyuriageymd6keta;
    }

    public void setZtyuriageymd6keta(String pZtyuriageymd6keta) {
        ztyuriageymd6keta = pZtyuriageymd6keta;
    }
    private String ztycreditkessaiyouno;

    public String getZtycreditkessaiyouno() {
        return ztycreditkessaiyouno;
    }

    public void setZtycreditkessaiyouno(String pZtycreditkessaiyouno) {
        ztycreditkessaiyouno = pZtycreditkessaiyouno;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztyrecordno;

    public String getZtyrecordno() {
        return ztyrecordno;
    }

    public void setZtyrecordno(String pZtyrecordno) {
        ztyrecordno = pZtyrecordno;
    }
    private Long ztyseikyuukngk11keta;

    public Long getZtyseikyuukngk11keta() {
        return ztyseikyuukngk11keta;
    }

    public void setZtyseikyuukngk11keta(Long pZtyseikyuukngk11keta) {
        ztyseikyuukngk11keta = pZtyseikyuukngk11keta;
    }

}