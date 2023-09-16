package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFTr;
import yuyu.def.db.id.PKZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.GenQZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFTr;

/**
 * 有効性確認結果Ｆテーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_YuukouKakKekkaFTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouKakKekkaFTr}</td><td colspan="3">有効性確認結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrrecordkbn ztrrecordkbn}</td><td>（取込用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv1 ztryobiv1}</td><td>（取込用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">{@link PKZT_YuukouKakKekkaFTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdbkeykugirimoji1 ztrdbkeykugirimoji1}</td><td>（取込用）ＤＢキー区切り文字１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdbkeykugirimoji2 ztrdbkeykugirimoji2}</td><td>（取込用）ＤＢキー区切り文字２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv32 ztryobiv32}</td><td>（取込用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcardno ztrcardno}</td><td>（取込用）カード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcardyuukoukigen ztrcardyuukoukigen}</td><td>（取込用）カード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryuukouhanteikekka ztryuukouhanteikekka}</td><td>（取込用）有効性判定結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv59 ztryobiv59}</td><td>（取込用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcreditkigyoucd ztrcreditkigyoucd}</td><td>（取込用）クレジット企業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv53 ztryobiv53}</td><td>（取込用）予備項目Ｖ５３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouKakKekkaFTr
 * @see     PKZT_YuukouKakKekkaFTr
 * @see     QZT_YuukouKakKekkaFTr
 * @see     GenQZT_YuukouKakKekkaFTr
 */
@MappedSuperclass
@Table(name=GenZT_YuukouKakKekkaFTr.TABLE_NAME)
@IdClass(value=PKZT_YuukouKakKekkaFTr.class)
public abstract class GenZT_YuukouKakKekkaFTr extends AbstractExDBEntity<ZT_YuukouKakKekkaFTr, PKZT_YuukouKakKekkaFTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YuukouKakKekkaFTr";
    public static final String ZTRRECORDKBN             = "ztrrecordkbn";
    public static final String ZTRYOBIV1                = "ztryobiv1";
    public static final String ZTRCREDITKESSAIYOUNO     = "ztrcreditkessaiyouno";
    public static final String ZTRDBKEYKUGIRIMOJI1      = "ztrdbkeykugirimoji1";
    public static final String ZTRDBKEYKUGIRIMOJI2      = "ztrdbkeykugirimoji2";
    public static final String ZTRYOBIV32               = "ztryobiv32";
    public static final String ZTRCARDNO                = "ztrcardno";
    public static final String ZTRCARDYUUKOUKIGEN       = "ztrcardyuukoukigen";
    public static final String ZTRYUUKOUHANTEIKEKKA     = "ztryuukouhanteikekka";
    public static final String ZTRYOBIV59               = "ztryobiv59";
    public static final String ZTRCREDITKIGYOUCD        = "ztrcreditkigyoucd";
    public static final String ZTRYOBIV53               = "ztryobiv53";

    private final PKZT_YuukouKakKekkaFTr primaryKey;

    public GenZT_YuukouKakKekkaFTr() {
        primaryKey = new PKZT_YuukouKakKekkaFTr();
    }

    public GenZT_YuukouKakKekkaFTr(String pZtrcreditkessaiyouno) {
        primaryKey = new PKZT_YuukouKakKekkaFTr(pZtrcreditkessaiyouno);
    }

    @Transient
    @Override
    public PKZT_YuukouKakKekkaFTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YuukouKakKekkaFTr> getMetaClass() {
        return QZT_YuukouKakKekkaFTr.class;
    }

    private String ztrrecordkbn;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRRECORDKBN)
    public String getZtrrecordkbn() {
        return ztrrecordkbn;
    }

    @DataConvert("toSingleByte")
    public void setZtrrecordkbn(String pZtrrecordkbn) {
        ztrrecordkbn = pZtrrecordkbn;
    }

    private String ztryobiv1;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRYOBIV1)
    public String getZtryobiv1() {
        return ztryobiv1;
    }

    public void setZtryobiv1(String pZtryobiv1) {
        ztryobiv1 = pZtryobiv1;
    }

    @Id
    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRCREDITKESSAIYOUNO)
    public String getZtrcreditkessaiyouno() {
        return getPrimaryKey().getZtrcreditkessaiyouno();
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        getPrimaryKey().setZtrcreditkessaiyouno(pZtrcreditkessaiyouno);
    }

    private String ztrdbkeykugirimoji1;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRDBKEYKUGIRIMOJI1)
    public String getZtrdbkeykugirimoji1() {
        return ztrdbkeykugirimoji1;
    }

    public void setZtrdbkeykugirimoji1(String pZtrdbkeykugirimoji1) {
        ztrdbkeykugirimoji1 = pZtrdbkeykugirimoji1;
    }

    private String ztrdbkeykugirimoji2;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRDBKEYKUGIRIMOJI2)
    public String getZtrdbkeykugirimoji2() {
        return ztrdbkeykugirimoji2;
    }

    public void setZtrdbkeykugirimoji2(String pZtrdbkeykugirimoji2) {
        ztrdbkeykugirimoji2 = pZtrdbkeykugirimoji2;
    }

    private String ztryobiv32;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRYOBIV32)
    public String getZtryobiv32() {
        return ztryobiv32;
    }

    public void setZtryobiv32(String pZtryobiv32) {
        ztryobiv32 = pZtryobiv32;
    }

    private String ztrcardno;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRCARDNO)
    public String getZtrcardno() {
        return ztrcardno;
    }

    public void setZtrcardno(String pZtrcardno) {
        ztrcardno = pZtrcardno;
    }

    private String ztrcardyuukoukigen;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRCARDYUUKOUKIGEN)
    public String getZtrcardyuukoukigen() {
        return ztrcardyuukoukigen;
    }

    @DataConvert("toSingleByte")
    public void setZtrcardyuukoukigen(String pZtrcardyuukoukigen) {
        ztrcardyuukoukigen = pZtrcardyuukoukigen;
    }

    private String ztryuukouhanteikekka;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRYUUKOUHANTEIKEKKA)
    public String getZtryuukouhanteikekka() {
        return ztryuukouhanteikekka;
    }

    @DataConvert("toSingleByte")
    public void setZtryuukouhanteikekka(String pZtryuukouhanteikekka) {
        ztryuukouhanteikekka = pZtryuukouhanteikekka;
    }

    private String ztryobiv59;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRYOBIV59)
    public String getZtryobiv59() {
        return ztryobiv59;
    }

    public void setZtryobiv59(String pZtryobiv59) {
        ztryobiv59 = pZtryobiv59;
    }

    private String ztrcreditkigyoucd;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRCREDITKIGYOUCD)
    public String getZtrcreditkigyoucd() {
        return ztrcreditkigyoucd;
    }

    @DataConvert("toSingleByte")
    public void setZtrcreditkigyoucd(String pZtrcreditkigyoucd) {
        ztrcreditkigyoucd = pZtrcreditkigyoucd;
    }

    private String ztryobiv53;

    @Column(name=GenZT_YuukouKakKekkaFTr.ZTRYOBIV53)
    public String getZtryobiv53() {
        return ztryobiv53;
    }

    public void setZtryobiv53(String pZtryobiv53) {
        ztryobiv53 = pZtryobiv53;
    }
}