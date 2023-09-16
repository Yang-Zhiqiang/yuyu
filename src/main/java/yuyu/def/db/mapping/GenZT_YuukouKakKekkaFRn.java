package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFRn;
import yuyu.def.db.id.PKZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.GenQZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFRn;

/**
 * 有効性確認結果Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_YuukouKakKekkaFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouKakKekkaFRn}</td><td colspan="3">有効性確認結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">{@link PKZT_YuukouKakKekkaFRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndbkeykugirimoji1 zrndbkeykugirimoji1}</td><td>（連携用）ＤＢキー区切り文字１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndbkeykugirimoji2 zrndbkeykugirimoji2}</td><td>（連携用）ＤＢキー区切り文字２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv32 zrnyobiv32}</td><td>（連携用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardno zrncardno}</td><td>（連携用）カード番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardyuukoukigen zrncardyuukoukigen}</td><td>（連携用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuukouhanteikekka zrnyuukouhanteikekka}</td><td>（連携用）有効性判定結果</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv59 zrnyobiv59}</td><td>（連携用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditkigyoucd zrncreditkigyoucd}</td><td>（連携用）クレジット企業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv53 zrnyobiv53}</td><td>（連携用）予備項目Ｖ５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouKakKekkaFRn
 * @see     PKZT_YuukouKakKekkaFRn
 * @see     QZT_YuukouKakKekkaFRn
 * @see     GenQZT_YuukouKakKekkaFRn
 */
@MappedSuperclass
@Table(name=GenZT_YuukouKakKekkaFRn.TABLE_NAME)
@IdClass(value=PKZT_YuukouKakKekkaFRn.class)
public abstract class GenZT_YuukouKakKekkaFRn extends AbstractExDBEntityForZDB<ZT_YuukouKakKekkaFRn, PKZT_YuukouKakKekkaFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YuukouKakKekkaFRn";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNCREDITKESSAIYOUNO     = "zrncreditkessaiyouno";
    public static final String ZRNDBKEYKUGIRIMOJI1      = "zrndbkeykugirimoji1";
    public static final String ZRNDBKEYKUGIRIMOJI2      = "zrndbkeykugirimoji2";
    public static final String ZRNYOBIV32               = "zrnyobiv32";
    public static final String ZRNCARDNO                = "zrncardno";
    public static final String ZRNCARDYUUKOUKIGEN       = "zrncardyuukoukigen";
    public static final String ZRNYUUKOUHANTEIKEKKA     = "zrnyuukouhanteikekka";
    public static final String ZRNYOBIV59               = "zrnyobiv59";
    public static final String ZRNCREDITKIGYOUCD        = "zrncreditkigyoucd";
    public static final String ZRNYOBIV53               = "zrnyobiv53";

    private final PKZT_YuukouKakKekkaFRn primaryKey;

    public GenZT_YuukouKakKekkaFRn() {
        primaryKey = new PKZT_YuukouKakKekkaFRn();
    }

    public GenZT_YuukouKakKekkaFRn(String pZrncreditkessaiyouno) {
        primaryKey = new PKZT_YuukouKakKekkaFRn(pZrncreditkessaiyouno);
    }

    @Transient
    @Override
    public PKZT_YuukouKakKekkaFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YuukouKakKekkaFRn> getMetaClass() {
        return QZT_YuukouKakKekkaFRn.class;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    @Id
    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNCREDITKESSAIYOUNO)
    public String getZrncreditkessaiyouno() {
        return getPrimaryKey().getZrncreditkessaiyouno();
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        getPrimaryKey().setZrncreditkessaiyouno(pZrncreditkessaiyouno);
    }

    private String zrndbkeykugirimoji1;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNDBKEYKUGIRIMOJI1)
    public String getZrndbkeykugirimoji1() {
        return zrndbkeykugirimoji1;
    }

    public void setZrndbkeykugirimoji1(String pZrndbkeykugirimoji1) {
        zrndbkeykugirimoji1 = pZrndbkeykugirimoji1;
    }

    private String zrndbkeykugirimoji2;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNDBKEYKUGIRIMOJI2)
    public String getZrndbkeykugirimoji2() {
        return zrndbkeykugirimoji2;
    }

    public void setZrndbkeykugirimoji2(String pZrndbkeykugirimoji2) {
        zrndbkeykugirimoji2 = pZrndbkeykugirimoji2;
    }

    private String zrnyobiv32;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNYOBIV32)
    public String getZrnyobiv32() {
        return zrnyobiv32;
    }

    public void setZrnyobiv32(String pZrnyobiv32) {
        zrnyobiv32 = pZrnyobiv32;
    }

    private String zrncardno;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNCARDNO)
    public String getZrncardno() {
        return zrncardno;
    }

    public void setZrncardno(String pZrncardno) {
        zrncardno = pZrncardno;
    }

    private String zrncardyuukoukigen;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNCARDYUUKOUKIGEN)
    public String getZrncardyuukoukigen() {
        return zrncardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZrncardyuukoukigen(String pZrncardyuukoukigen) {
        zrncardyuukoukigen = pZrncardyuukoukigen;
    }

    private String zrnyuukouhanteikekka;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNYUUKOUHANTEIKEKKA)
    public String getZrnyuukouhanteikekka() {
        return zrnyuukouhanteikekka;
    }

    @DataConvert("toSingleByte")
    public void setZrnyuukouhanteikekka(String pZrnyuukouhanteikekka) {
        zrnyuukouhanteikekka = pZrnyuukouhanteikekka;
    }

    private String zrnyobiv59;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNYOBIV59)
    public String getZrnyobiv59() {
        return zrnyobiv59;
    }

    public void setZrnyobiv59(String pZrnyobiv59) {
        zrnyobiv59 = pZrnyobiv59;
    }

    private String zrncreditkigyoucd;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNCREDITKIGYOUCD)
    public String getZrncreditkigyoucd() {
        return zrncreditkigyoucd;
    }

    @DataConvert("toSingleByte")
    public void setZrncreditkigyoucd(String pZrncreditkigyoucd) {
        zrncreditkigyoucd = pZrncreditkigyoucd;
    }

    private String zrnyobiv53;

    @Column(name=GenZT_YuukouKakKekkaFRn.ZRNYOBIV53)
    public String getZrnyobiv53() {
        return zrnyobiv53;
    }

    public void setZrnyobiv53(String pZrnyobiv53) {
        zrnyobiv53 = pZrnyobiv53;
    }
}