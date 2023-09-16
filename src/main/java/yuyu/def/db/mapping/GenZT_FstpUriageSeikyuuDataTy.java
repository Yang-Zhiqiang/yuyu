package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.id.PKZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataTy;

/**
 * 初回保険料売上請求データテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_FstpUriageSeikyuuDataTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_FstpUriageSeikyuuDataTy}</td><td colspan="3">初回保険料売上請求データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyauthorikbn ztyauthorikbn}</td><td>（中継用）オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuriageseikyuutorihikicd ztyuriageseikyuutorihikicd}</td><td>（中継用）売上請求取引コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv14 ztyyobiv14}</td><td>（中継用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuriagetaisyouym ztyuriagetaisyouym}</td><td>（中継用）売上対象年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuriageymd6keta ztyuriageymd6keta}</td><td>（中継用）売上年月日（６桁）</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditkigyoucd ztycreditkigyoucd}</td><td>（中継用）クレジット企業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditkessaiyouno ztycreditkessaiyouno}</td><td>（中継用）クレジットカード決済用番号</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordno ztyrecordno}</td><td>（中継用）レコード番号</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycardyuukoukigen ztycardyuukoukigen}</td><td>（中継用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuukngk11keta ztyseikyuukngk11keta}</td><td>（中継用）請求金額（１１桁）</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataTy ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditkaiinnokami6keta ztycreditkaiinnokami6keta}</td><td>（中継用）クレジット会員番号（上６桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditkaiinnosimo4keta ztycreditkaiinnosimo4keta}</td><td>（中継用）クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuriageseikyuuerrorcd ztyuriageseikyuuerrorcd}</td><td>（中継用）売上請求エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekekkacd ztyhurikaekekkacd}</td><td>（中継用）振替結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfukusuukameitennokey ztyfukusuukameitennokey}</td><td>（中継用）複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_FstpUriageSeikyuuDataTy
 * @see     PKZT_FstpUriageSeikyuuDataTy
 * @see     QZT_FstpUriageSeikyuuDataTy
 * @see     GenQZT_FstpUriageSeikyuuDataTy
 */
@MappedSuperclass
@Table(name=GenZT_FstpUriageSeikyuuDataTy.TABLE_NAME)
@IdClass(value=PKZT_FstpUriageSeikyuuDataTy.class)
public abstract class GenZT_FstpUriageSeikyuuDataTy extends AbstractExDBEntity<ZT_FstpUriageSeikyuuDataTy, PKZT_FstpUriageSeikyuuDataTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_FstpUriageSeikyuuDataTy";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYAUTHORIKBN            = "ztyauthorikbn";
    public static final String ZTYURIAGESEIKYUUTORIHIKICD = "ztyuriageseikyuutorihikicd";
    public static final String ZTYYOBIV14               = "ztyyobiv14";
    public static final String ZTYURIAGETAISYOUYM       = "ztyuriagetaisyouym";
    public static final String ZTYURIAGEYMD6KETA        = "ztyuriageymd6keta";
    public static final String ZTYCREDITKIGYOUCD        = "ztycreditkigyoucd";
    public static final String ZTYCREDITKESSAIYOUNO     = "ztycreditkessaiyouno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYRECORDNO              = "ztyrecordno";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYCARDYUUKOUKIGEN       = "ztycardyuukoukigen";
    public static final String ZTYSEIKYUUKNGK11KETA     = "ztyseikyuukngk11keta";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYCREDITKAIINNOKAMI6KETA = "ztycreditkaiinnokami6keta";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYCREDITKAIINNOSIMO4KETA = "ztycreditkaiinnosimo4keta";
    public static final String ZTYURIAGESEIKYUUERRORCD  = "ztyuriageseikyuuerrorcd";
    public static final String ZTYHURIKAEKEKKACD        = "ztyhurikaekekkacd";
    public static final String ZTYFUKUSUUKAMEITENNOKEY  = "ztyfukusuukameitennokey";
    public static final String ZTYYOBIV1                = "ztyyobiv1";

    private final PKZT_FstpUriageSeikyuuDataTy primaryKey;

    public GenZT_FstpUriageSeikyuuDataTy() {
        primaryKey = new PKZT_FstpUriageSeikyuuDataTy();
    }

    public GenZT_FstpUriageSeikyuuDataTy(
        String pZtyuriageymd6keta,
        String pZtycreditkessaiyouno,
        String pZtysyono,
        String pZtyrecordno,
        Long pZtyseikyuukngk11keta
    ) {
        primaryKey = new PKZT_FstpUriageSeikyuuDataTy(
            pZtyuriageymd6keta,
            pZtycreditkessaiyouno,
            pZtysyono,
            pZtyrecordno,
            pZtyseikyuukngk11keta
        );
    }

    @Transient
    @Override
    public PKZT_FstpUriageSeikyuuDataTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_FstpUriageSeikyuuDataTy> getMetaClass() {
        return QZT_FstpUriageSeikyuuDataTy.class;
    }

    private String ztyrecordkbn;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztyauthorikbn;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYAUTHORIKBN)
    public String getZtyauthorikbn() {
        return ztyauthorikbn;
    }

    public void setZtyauthorikbn(String pZtyauthorikbn) {
        ztyauthorikbn = pZtyauthorikbn;
    }

    private String ztyuriageseikyuutorihikicd;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYURIAGESEIKYUUTORIHIKICD)
    public String getZtyuriageseikyuutorihikicd() {
        return ztyuriageseikyuutorihikicd;
    }

    @DataConvert("toSingleByte")
    public void setZtyuriageseikyuutorihikicd(String pZtyuriageseikyuutorihikicd) {
        ztyuriageseikyuutorihikicd = pZtyuriageseikyuutorihikicd;
    }

    private String ztyyobiv14;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }

    private String ztyuriagetaisyouym;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYURIAGETAISYOUYM)
    public String getZtyuriagetaisyouym() {
        return ztyuriagetaisyouym;
    }

    public void setZtyuriagetaisyouym(String pZtyuriagetaisyouym) {
        ztyuriagetaisyouym = pZtyuriagetaisyouym;
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYURIAGEYMD6KETA)
    public String getZtyuriageymd6keta() {
        return getPrimaryKey().getZtyuriageymd6keta();
    }

    @DataConvert("toSingleByte")
    public void setZtyuriageymd6keta(String pZtyuriageymd6keta) {
        getPrimaryKey().setZtyuriageymd6keta(pZtyuriageymd6keta);
    }

    private String ztycreditkigyoucd;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYCREDITKIGYOUCD)
    public String getZtycreditkigyoucd() {
        return ztycreditkigyoucd;
    }

    @DataConvert("toSingleByte")
    public void setZtycreditkigyoucd(String pZtycreditkigyoucd) {
        ztycreditkigyoucd = pZtycreditkigyoucd;
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYCREDITKESSAIYOUNO)
    public String getZtycreditkessaiyouno() {
        return getPrimaryKey().getZtycreditkessaiyouno();
    }

    public void setZtycreditkessaiyouno(String pZtycreditkessaiyouno) {
        getPrimaryKey().setZtycreditkessaiyouno(pZtycreditkessaiyouno);
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYRECORDNO)
    public String getZtyrecordno() {
        return getPrimaryKey().getZtyrecordno();
    }

    public void setZtyrecordno(String pZtyrecordno) {
        getPrimaryKey().setZtyrecordno(pZtyrecordno);
    }

    private String ztyyobiv3;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztycardyuukoukigen;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYCARDYUUKOUKIGEN)
    public String getZtycardyuukoukigen() {
        return ztycardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZtycardyuukoukigen(String pZtycardyuukoukigen) {
        ztycardyuukoukigen = pZtycardyuukoukigen;
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYSEIKYUUKNGK11KETA)
    public Long getZtyseikyuukngk11keta() {
        return getPrimaryKey().getZtyseikyuukngk11keta();
    }

    public void setZtyseikyuukngk11keta(Long pZtyseikyuukngk11keta) {
        getPrimaryKey().setZtyseikyuukngk11keta(pZtyseikyuukngk11keta);
    }

    private String ztyyobiv2;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztycreditkaiinnokami6keta;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYCREDITKAIINNOKAMI6KETA)
    public String getZtycreditkaiinnokami6keta() {
        return ztycreditkaiinnokami6keta;
    }

    public void setZtycreditkaiinnokami6keta(String pZtycreditkaiinnokami6keta) {
        ztycreditkaiinnokami6keta = pZtycreditkaiinnokami6keta;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztycreditkaiinnosimo4keta;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYCREDITKAIINNOSIMO4KETA)
    public String getZtycreditkaiinnosimo4keta() {
        return ztycreditkaiinnosimo4keta;
    }

    public void setZtycreditkaiinnosimo4keta(String pZtycreditkaiinnosimo4keta) {
        ztycreditkaiinnosimo4keta = pZtycreditkaiinnosimo4keta;
    }

    private String ztyuriageseikyuuerrorcd;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYURIAGESEIKYUUERRORCD)
    public String getZtyuriageseikyuuerrorcd() {
        return ztyuriageseikyuuerrorcd;
    }

    @DataConvert("toSingleByte")
    public void setZtyuriageseikyuuerrorcd(String pZtyuriageseikyuuerrorcd) {
        ztyuriageseikyuuerrorcd = pZtyuriageseikyuuerrorcd;
    }

    private String ztyhurikaekekkacd;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYHURIKAEKEKKACD)
    public String getZtyhurikaekekkacd() {
        return ztyhurikaekekkacd;
    }

    public void setZtyhurikaekekkacd(String pZtyhurikaekekkacd) {
        ztyhurikaekekkacd = pZtyhurikaekekkacd;
    }

    private String ztyfukusuukameitennokey;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYFUKUSUUKAMEITENNOKEY)
    public String getZtyfukusuukameitennokey() {
        return ztyfukusuukameitennokey;
    }

    public void setZtyfukusuukameitennokey(String pZtyfukusuukameitennokey) {
        ztyfukusuukameitennokey = pZtyfukusuukameitennokey;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_FstpUriageSeikyuuDataTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }
}