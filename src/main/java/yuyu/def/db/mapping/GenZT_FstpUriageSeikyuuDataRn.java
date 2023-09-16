package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.id.PKZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataRn;

/**
 * 初回保険料売上請求データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_FstpUriageSeikyuuDataRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_FstpUriageSeikyuuDataRn}</td><td colspan="3">初回保険料売上請求データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnauthorikbn zrnauthorikbn}</td><td>（連携用）オーソリ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuriageseikyuutorihikicd zrnuriageseikyuutorihikicd}</td><td>（連携用）売上請求取引コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuriagetaisyouym zrnuriagetaisyouym}</td><td>（連携用）売上対象年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuriageymd6keta zrnuriageymd6keta}</td><td>（連携用）売上年月日（６桁）</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkigyoucd zrncreditkigyoucd}</td><td>（連携用）クレジット企業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordno zrnrecordno}</td><td>（連携用）レコード番号</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardyuukoukigen zrncardyuukoukigen}</td><td>（連携用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuukngk11keta zrnseikyuukngk11keta}</td><td>（連携用）請求金額（１１桁）</td><td align="center">{@link PKZT_FstpUriageSeikyuuDataRn ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkaiinnokami6keta zrncreditkaiinnokami6keta}</td><td>（連携用）クレジット会員番号（上６桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkaiinnosimo4keta zrncreditkaiinnosimo4keta}</td><td>（連携用）クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuriageseikyuuerrorcd zrnuriageseikyuuerrorcd}</td><td>（連携用）売上請求エラーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekekkacd zrnhurikaekekkacd}</td><td>（連携用）振替結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfukusuukameitennokey zrnfukusuukameitennokey}</td><td>（連携用）複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_FstpUriageSeikyuuDataRn
 * @see     PKZT_FstpUriageSeikyuuDataRn
 * @see     QZT_FstpUriageSeikyuuDataRn
 * @see     GenQZT_FstpUriageSeikyuuDataRn
 */
@MappedSuperclass
@Table(name=GenZT_FstpUriageSeikyuuDataRn.TABLE_NAME)
@IdClass(value=PKZT_FstpUriageSeikyuuDataRn.class)
public abstract class GenZT_FstpUriageSeikyuuDataRn extends AbstractExDBEntityForZDB<ZT_FstpUriageSeikyuuDataRn, PKZT_FstpUriageSeikyuuDataRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_FstpUriageSeikyuuDataRn";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNAUTHORIKBN            = "zrnauthorikbn";
    public static final String ZRNURIAGESEIKYUUTORIHIKICD = "zrnuriageseikyuutorihikicd";
    public static final String ZRNYOBIV14               = "zrnyobiv14";
    public static final String ZRNURIAGETAISYOUYM       = "zrnuriagetaisyouym";
    public static final String ZRNURIAGEYMD6KETA        = "zrnuriageymd6keta";
    public static final String ZRNCREDITKIGYOUCD        = "zrncreditkigyoucd";
    public static final String ZRNCREDITKESSAIYOUNO     = "zrncreditkessaiyouno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNRECORDNO              = "zrnrecordno";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNCARDYUUKOUKIGEN       = "zrncardyuukoukigen";
    public static final String ZRNSEIKYUUKNGK11KETA     = "zrnseikyuukngk11keta";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNCREDITKAIINNOKAMI6KETA = "zrncreditkaiinnokami6keta";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNCREDITKAIINNOSIMO4KETA = "zrncreditkaiinnosimo4keta";
    public static final String ZRNURIAGESEIKYUUERRORCD  = "zrnuriageseikyuuerrorcd";
    public static final String ZRNHURIKAEKEKKACD        = "zrnhurikaekekkacd";
    public static final String ZRNFUKUSUUKAMEITENNOKEY  = "zrnfukusuukameitennokey";
    public static final String ZRNYOBIV1                = "zrnyobiv1";

    private final PKZT_FstpUriageSeikyuuDataRn primaryKey;

    public GenZT_FstpUriageSeikyuuDataRn() {
        primaryKey = new PKZT_FstpUriageSeikyuuDataRn();
    }

    public GenZT_FstpUriageSeikyuuDataRn(
        String pZrnuriageymd6keta,
        String pZrncreditkessaiyouno,
        String pZrnsyono,
        String pZrnrecordno,
        Long pZrnseikyuukngk11keta
    ) {
        primaryKey = new PKZT_FstpUriageSeikyuuDataRn(
            pZrnuriageymd6keta,
            pZrncreditkessaiyouno,
            pZrnsyono,
            pZrnrecordno,
            pZrnseikyuukngk11keta
        );
    }

    @Transient
    @Override
    public PKZT_FstpUriageSeikyuuDataRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_FstpUriageSeikyuuDataRn> getMetaClass() {
        return QZT_FstpUriageSeikyuuDataRn.class;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnauthorikbn;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNAUTHORIKBN)
    public String getZrnauthorikbn() {
        return zrnauthorikbn;
    }

    public void setZrnauthorikbn(String pZrnauthorikbn) {
        zrnauthorikbn = pZrnauthorikbn;
    }

    private String zrnuriageseikyuutorihikicd;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNURIAGESEIKYUUTORIHIKICD)
    public String getZrnuriageseikyuutorihikicd() {
        return zrnuriageseikyuutorihikicd;
    }

    public void setZrnuriageseikyuutorihikicd(String pZrnuriageseikyuutorihikicd) {
        zrnuriageseikyuutorihikicd = pZrnuriageseikyuutorihikicd;
    }

    private String zrnyobiv14;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }

    private String zrnuriagetaisyouym;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNURIAGETAISYOUYM)
    public String getZrnuriagetaisyouym() {
        return zrnuriagetaisyouym;
    }

    public void setZrnuriagetaisyouym(String pZrnuriagetaisyouym) {
        zrnuriagetaisyouym = pZrnuriagetaisyouym;
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNURIAGEYMD6KETA)
    public String getZrnuriageymd6keta() {
        return getPrimaryKey().getZrnuriageymd6keta();
    }

    @DataConvert("toSingleByte")
    public void setZrnuriageymd6keta(String pZrnuriageymd6keta) {
        getPrimaryKey().setZrnuriageymd6keta(pZrnuriageymd6keta);
    }

    private String zrncreditkigyoucd;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNCREDITKIGYOUCD)
    public String getZrncreditkigyoucd() {
        return zrncreditkigyoucd;
    }

    @DataConvert("toSingleByte")
    public void setZrncreditkigyoucd(String pZrncreditkigyoucd) {
        zrncreditkigyoucd = pZrncreditkigyoucd;
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNCREDITKESSAIYOUNO)
    public String getZrncreditkessaiyouno() {
        return getPrimaryKey().getZrncreditkessaiyouno();
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        getPrimaryKey().setZrncreditkessaiyouno(pZrncreditkessaiyouno);
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNRECORDNO)
    public String getZrnrecordno() {
        return getPrimaryKey().getZrnrecordno();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnrecordno(String pZrnrecordno) {
        getPrimaryKey().setZrnrecordno(pZrnrecordno);
    }

    private String zrnyobiv3;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrncardyuukoukigen;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNCARDYUUKOUKIGEN)
    public String getZrncardyuukoukigen() {
        return zrncardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZrncardyuukoukigen(String pZrncardyuukoukigen) {
        zrncardyuukoukigen = pZrncardyuukoukigen;
    }

    @Id
    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNSEIKYUUKNGK11KETA)
    public Long getZrnseikyuukngk11keta() {
        return getPrimaryKey().getZrnseikyuukngk11keta();
    }

    public void setZrnseikyuukngk11keta(Long pZrnseikyuukngk11keta) {
        getPrimaryKey().setZrnseikyuukngk11keta(pZrnseikyuukngk11keta);
    }

    private String zrnyobiv2;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrncreditkaiinnokami6keta;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNCREDITKAIINNOKAMI6KETA)
    public String getZrncreditkaiinnokami6keta() {
        return zrncreditkaiinnokami6keta;
    }

    public void setZrncreditkaiinnokami6keta(String pZrncreditkaiinnokami6keta) {
        zrncreditkaiinnokami6keta = pZrncreditkaiinnokami6keta;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrncreditkaiinnosimo4keta;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNCREDITKAIINNOSIMO4KETA)
    public String getZrncreditkaiinnosimo4keta() {
        return zrncreditkaiinnosimo4keta;
    }

    public void setZrncreditkaiinnosimo4keta(String pZrncreditkaiinnosimo4keta) {
        zrncreditkaiinnosimo4keta = pZrncreditkaiinnosimo4keta;
    }

    private String zrnuriageseikyuuerrorcd;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNURIAGESEIKYUUERRORCD)
    public String getZrnuriageseikyuuerrorcd() {
        return zrnuriageseikyuuerrorcd;
    }

    public void setZrnuriageseikyuuerrorcd(String pZrnuriageseikyuuerrorcd) {
        zrnuriageseikyuuerrorcd = pZrnuriageseikyuuerrorcd;
    }

    private String zrnhurikaekekkacd;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNHURIKAEKEKKACD)
    public String getZrnhurikaekekkacd() {
        return zrnhurikaekekkacd;
    }

    public void setZrnhurikaekekkacd(String pZrnhurikaekekkacd) {
        zrnhurikaekekkacd = pZrnhurikaekekkacd;
    }

    private String zrnfukusuukameitennokey;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNFUKUSUUKAMEITENNOKEY)
    public String getZrnfukusuukameitennokey() {
        return zrnfukusuukameitennokey;
    }

    public void setZrnfukusuukameitennokey(String pZrnfukusuukameitennokey) {
        zrnfukusuukameitennokey = pZrnfukusuukameitennokey;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_FstpUriageSeikyuuDataRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }
}