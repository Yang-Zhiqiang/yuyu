package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_UriageKekkaTr;
import yuyu.def.db.id.PKZT_UriageKekkaTr;
import yuyu.def.db.meta.GenQZT_UriageKekkaTr;
import yuyu.def.db.meta.QZT_UriageKekkaTr;

/**
 * 売上結果Ｆテーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_UriageKekkaTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_UriageKekkaTr}</td><td colspan="3">売上結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrrecordkbn ztrrecordkbn}</td><td>（取込用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrauthorikbn ztrauthorikbn}</td><td>（取込用）オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtruriageseikyuutorihikicd ztruriageseikyuutorihikicd}</td><td>（取込用）売上請求取引コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv14 ztryobiv14}</td><td>（取込用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtruriagetaisyouym ztruriagetaisyouym}</td><td>（取込用）売上対象年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtruriageymd6keta ztruriageymd6keta}</td><td>（取込用）売上年月日（６桁）</td><td align="center">{@link PKZT_UriageKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkigyoucd ztrcreditkigyoucd}</td><td>（取込用）クレジット企業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">{@link PKZT_UriageKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyono ztrsyono}</td><td>（取込用）証券番号</td><td align="center">{@link PKZT_UriageKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrecordno ztrrecordno}</td><td>（取込用）レコード番号</td><td align="center">{@link PKZT_UriageKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv3 ztryobiv3}</td><td>（取込用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcardyuukoukigen ztrcardyuukoukigen}</td><td>（取込用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseikyuukngk ztrseikyuukngk}</td><td>（取込用）請求金額</td><td align="center">{@link PKZT_UriageKekkaTr ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtryobiv5 ztryobiv5}</td><td>（取込用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkaiinnokami6keta ztrcreditkaiinnokami6keta}</td><td>（取込用）クレジット会員番号（上６桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv6 ztryobiv6}</td><td>（取込用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkaiinnosimo4keta ztrcreditkaiinnosimo4keta}</td><td>（取込用）クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtruriageseikyuuerrorcd ztruriageseikyuuerrorcd}</td><td>（取込用）売上請求エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhurikaekekkacd ztrhurikaekekkacd}</td><td>（取込用）振替結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrfukusuukameitennokey ztrfukusuukameitennokey}</td><td>（取込用）複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv1 ztryobiv1}</td><td>（取込用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_UriageKekkaTr
 * @see     PKZT_UriageKekkaTr
 * @see     QZT_UriageKekkaTr
 * @see     GenQZT_UriageKekkaTr
 */
@MappedSuperclass
@Table(name=GenZT_UriageKekkaTr.TABLE_NAME)
@IdClass(value=PKZT_UriageKekkaTr.class)
public abstract class GenZT_UriageKekkaTr extends AbstractExDBEntity<ZT_UriageKekkaTr, PKZT_UriageKekkaTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_UriageKekkaTr";
    public static final String ZTRRECORDKBN             = "ztrrecordkbn";
    public static final String ZTRAUTHORIKBN            = "ztrauthorikbn";
    public static final String ZTRURIAGESEIKYUUTORIHIKICD = "ztruriageseikyuutorihikicd";
    public static final String ZTRYOBIV14               = "ztryobiv14";
    public static final String ZTRURIAGETAISYOUYM       = "ztruriagetaisyouym";
    public static final String ZTRURIAGEYMD6KETA        = "ztruriageymd6keta";
    public static final String ZTRCREDITKIGYOUCD        = "ztrcreditkigyoucd";
    public static final String ZTRCREDITKESSAIYOUNO     = "ztrcreditkessaiyouno";
    public static final String ZTRSYONO                 = "ztrsyono";
    public static final String ZTRRECORDNO              = "ztrrecordno";
    public static final String ZTRYOBIV3                = "ztryobiv3";
    public static final String ZTRCARDYUUKOUKIGEN       = "ztrcardyuukoukigen";
    public static final String ZTRSEIKYUUKNGK           = "ztrseikyuukngk";
    public static final String ZTRYOBIV5                = "ztryobiv5";
    public static final String ZTRCREDITKAIINNOKAMI6KETA = "ztrcreditkaiinnokami6keta";
    public static final String ZTRYOBIV6                = "ztryobiv6";
    public static final String ZTRCREDITKAIINNOSIMO4KETA = "ztrcreditkaiinnosimo4keta";
    public static final String ZTRURIAGESEIKYUUERRORCD  = "ztruriageseikyuuerrorcd";
    public static final String ZTRHURIKAEKEKKACD        = "ztrhurikaekekkacd";
    public static final String ZTRFUKUSUUKAMEITENNOKEY  = "ztrfukusuukameitennokey";
    public static final String ZTRYOBIV1                = "ztryobiv1";

    private final PKZT_UriageKekkaTr primaryKey;

    public GenZT_UriageKekkaTr() {
        primaryKey = new PKZT_UriageKekkaTr();
    }

    public GenZT_UriageKekkaTr(
        String pZtrsyono,
        String pZtrcreditkessaiyouno,
        String pZtruriageymd6keta,
        String pZtrrecordno,
        Long pZtrseikyuukngk
    ) {
        primaryKey = new PKZT_UriageKekkaTr(
            pZtrsyono,
            pZtrcreditkessaiyouno,
            pZtruriageymd6keta,
            pZtrrecordno,
            pZtrseikyuukngk
        );
    }

    @Transient
    @Override
    public PKZT_UriageKekkaTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_UriageKekkaTr> getMetaClass() {
        return QZT_UriageKekkaTr.class;
    }

    private String ztrrecordkbn;

    @Column(name=GenZT_UriageKekkaTr.ZTRRECORDKBN)
    public String getZtrrecordkbn() {
        return ztrrecordkbn;
    }

    @DataConvert("toSingleByte")
    public void setZtrrecordkbn(String pZtrrecordkbn) {
        ztrrecordkbn = pZtrrecordkbn;
    }

    private String ztrauthorikbn;

    @Column(name=GenZT_UriageKekkaTr.ZTRAUTHORIKBN)
    public String getZtrauthorikbn() {
        return ztrauthorikbn;
    }

    public void setZtrauthorikbn(String pZtrauthorikbn) {
        ztrauthorikbn = pZtrauthorikbn;
    }

    private String ztruriageseikyuutorihikicd;

    @Column(name=GenZT_UriageKekkaTr.ZTRURIAGESEIKYUUTORIHIKICD)
    public String getZtruriageseikyuutorihikicd() {
        return ztruriageseikyuutorihikicd;
    }

    public void setZtruriageseikyuutorihikicd(String pZtruriageseikyuutorihikicd) {
        ztruriageseikyuutorihikicd = pZtruriageseikyuutorihikicd;
    }

    private String ztryobiv14;

    @Column(name=GenZT_UriageKekkaTr.ZTRYOBIV14)
    public String getZtryobiv14() {
        return ztryobiv14;
    }

    public void setZtryobiv14(String pZtryobiv14) {
        ztryobiv14 = pZtryobiv14;
    }

    private String ztruriagetaisyouym;

    @Column(name=GenZT_UriageKekkaTr.ZTRURIAGETAISYOUYM)
    public String getZtruriagetaisyouym() {
        return ztruriagetaisyouym;
    }

    public void setZtruriagetaisyouym(String pZtruriagetaisyouym) {
        ztruriagetaisyouym = pZtruriagetaisyouym;
    }

    @Id
    @Column(name=GenZT_UriageKekkaTr.ZTRURIAGEYMD6KETA)
    public String getZtruriageymd6keta() {
        return getPrimaryKey().getZtruriageymd6keta();
    }

    @DataConvert("toSingleByte")
    public void setZtruriageymd6keta(String pZtruriageymd6keta) {
        getPrimaryKey().setZtruriageymd6keta(pZtruriageymd6keta);
    }

    private String ztrcreditkigyoucd;

    @Column(name=GenZT_UriageKekkaTr.ZTRCREDITKIGYOUCD)
    public String getZtrcreditkigyoucd() {
        return ztrcreditkigyoucd;
    }

    @DataConvert("toSingleByte")
    public void setZtrcreditkigyoucd(String pZtrcreditkigyoucd) {
        ztrcreditkigyoucd = pZtrcreditkigyoucd;
    }

    @Id
    @Column(name=GenZT_UriageKekkaTr.ZTRCREDITKESSAIYOUNO)
    public String getZtrcreditkessaiyouno() {
        return getPrimaryKey().getZtrcreditkessaiyouno();
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        getPrimaryKey().setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
    }

    @Id
    @Column(name=GenZT_UriageKekkaTr.ZTRSYONO)
    public String getZtrsyono() {
        return getPrimaryKey().getZtrsyono();
    }

    public void setZtrsyono(String pZtrsyono) {
        getPrimaryKey().setZtrsyono(pZtrsyono);
    }

    @Id
    @Column(name=GenZT_UriageKekkaTr.ZTRRECORDNO)
    public String getZtrrecordno() {
        return getPrimaryKey().getZtrrecordno();
    }

    public void setZtrrecordno(String pZtrrecordno) {
        getPrimaryKey().setZtrrecordno(pZtrrecordno);
    }

    private String ztryobiv3;

    @Column(name=GenZT_UriageKekkaTr.ZTRYOBIV3)
    public String getZtryobiv3() {
        return ztryobiv3;
    }

    public void setZtryobiv3(String pZtryobiv3) {
        ztryobiv3 = pZtryobiv3;
    }

    private String ztrcardyuukoukigen;

    @Column(name=GenZT_UriageKekkaTr.ZTRCARDYUUKOUKIGEN)
    public String getZtrcardyuukoukigen() {
        return ztrcardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZtrcardyuukoukigen(String pZtrcardyuukoukigen) {
        ztrcardyuukoukigen = pZtrcardyuukoukigen;
    }

    @Id
    @Column(name=GenZT_UriageKekkaTr.ZTRSEIKYUUKNGK)
    public Long getZtrseikyuukngk() {
        return getPrimaryKey().getZtrseikyuukngk();
    }

    public void setZtrseikyuukngk(Long pZtrseikyuukngk) {
        getPrimaryKey().setZtrseikyuukngk(pZtrseikyuukngk);
    }

    private String ztryobiv5;

    @Column(name=GenZT_UriageKekkaTr.ZTRYOBIV5)
    public String getZtryobiv5() {
        return ztryobiv5;
    }

    public void setZtryobiv5(String pZtryobiv5) {
        ztryobiv5 = pZtryobiv5;
    }

    private String ztrcreditkaiinnokami6keta;

    @Column(name=GenZT_UriageKekkaTr.ZTRCREDITKAIINNOKAMI6KETA)
    public String getZtrcreditkaiinnokami6keta() {
        return ztrcreditkaiinnokami6keta;
    }

    public void setZtrcreditkaiinnokami6keta(String pZtrcreditkaiinnokami6keta) {
        ztrcreditkaiinnokami6keta = pZtrcreditkaiinnokami6keta;
    }

    private String ztryobiv6;

    @Column(name=GenZT_UriageKekkaTr.ZTRYOBIV6)
    public String getZtryobiv6() {
        return ztryobiv6;
    }

    public void setZtryobiv6(String pZtryobiv6) {
        ztryobiv6 = pZtryobiv6;
    }

    private String ztrcreditkaiinnosimo4keta;

    @Column(name=GenZT_UriageKekkaTr.ZTRCREDITKAIINNOSIMO4KETA)
    public String getZtrcreditkaiinnosimo4keta() {
        return ztrcreditkaiinnosimo4keta;
    }

    public void setZtrcreditkaiinnosimo4keta(String pZtrcreditkaiinnosimo4keta) {
        ztrcreditkaiinnosimo4keta = pZtrcreditkaiinnosimo4keta;
    }

    private String ztruriageseikyuuerrorcd;

    @Column(name=GenZT_UriageKekkaTr.ZTRURIAGESEIKYUUERRORCD)
    public String getZtruriageseikyuuerrorcd() {
        return ztruriageseikyuuerrorcd;
    }

    public void setZtruriageseikyuuerrorcd(String pZtruriageseikyuuerrorcd) {
        ztruriageseikyuuerrorcd = pZtruriageseikyuuerrorcd;
    }

    private String ztrhurikaekekkacd;

    @Column(name=GenZT_UriageKekkaTr.ZTRHURIKAEKEKKACD)
    public String getZtrhurikaekekkacd() {
        return ztrhurikaekekkacd;
    }

    public void setZtrhurikaekekkacd(String pZtrhurikaekekkacd) {
        ztrhurikaekekkacd = pZtrhurikaekekkacd;
    }

    private String ztrfukusuukameitennokey;

    @Column(name=GenZT_UriageKekkaTr.ZTRFUKUSUUKAMEITENNOKEY)
    public String getZtrfukusuukameitennokey() {
        return ztrfukusuukameitennokey;
    }

    public void setZtrfukusuukameitennokey(String pZtrfukusuukameitennokey) {
        ztrfukusuukameitennokey = pZtrfukusuukameitennokey;
    }

    private String ztryobiv1;

    @Column(name=GenZT_UriageKekkaTr.ZTRYOBIV1)
    public String getZtryobiv1() {
        return ztryobiv1;
    }

    public void setZtryobiv1(String pZtryobiv1) {
        ztryobiv1 = pZtryobiv1;
    }
}