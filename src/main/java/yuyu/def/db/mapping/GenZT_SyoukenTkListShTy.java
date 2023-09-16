package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SyoukenTkListShTy;
import yuyu.def.db.id.PKZT_SyoukenTkListShTy;
import yuyu.def.db.meta.GenQZT_SyoukenTkListShTy;
import yuyu.def.db.meta.QZT_SyoukenTkListShTy;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SyoukenTkListShTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListShTy}</td><td colspan="3">証券特殊処理明細リスト（再発行）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SyoukenTkListShTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakitantnm ztyatesakitantnm}</td><td>（中継用）宛先担当室名(組織名)</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhozonkkn ztyhozonkkn}</td><td>（中継用）保存期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdwa ztytyouhyouymdwa}</td><td>（中継用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv26 ztyyobiv26}</td><td>（中継用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SyoukenTkListShTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorinm ztysyorinm}</td><td>（中継用）処理名(機能名)</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorisyouninsyacd ztysyorisyouninsyacd}</td><td>（中継用）処理承認者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorisyouninsyanm ztysyorisyouninsyanm}</td><td>（中継用）処理承認者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo1 ztyjigosagyounaiyo1}</td><td>（中継用）事後作業内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo2 ztyjigosagyounaiyo2}</td><td>（中継用）事後作業内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo3 ztyjigosagyounaiyo3}</td><td>（中継用）事後作業内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo4 ztyjigosagyounaiyo4}</td><td>（中継用）事後作業内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo5 ztyjigosagyounaiyo5}</td><td>（中継用）事後作業内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo6 ztyjigosagyounaiyo6}</td><td>（中継用）事後作業内容６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo7 ztyjigosagyounaiyo7}</td><td>（中継用）事後作業内容７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo8 ztyjigosagyounaiyo8}</td><td>（中継用）事後作業内容８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo9 ztyjigosagyounaiyo9}</td><td>（中継用）事後作業内容９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo10 ztyjigosagyounaiyo10}</td><td>（中継用）事後作業内容１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo11 ztyjigosagyounaiyo11}</td><td>（中継用）事後作業内容１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo12 ztyjigosagyounaiyo12}</td><td>（中継用）事後作業内容１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo13 ztyjigosagyounaiyo13}</td><td>（中継用）事後作業内容１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo14 ztyjigosagyounaiyo14}</td><td>（中継用）事後作業内容１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo15 ztyjigosagyounaiyo15}</td><td>（中継用）事後作業内容１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigosagyounaiyo16 ztyjigosagyounaiyo16}</td><td>（中継用）事後作業内容１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv31 ztyyobiv31}</td><td>（中継用）予備項目Ｖ３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListShTy
 * @see     PKZT_SyoukenTkListShTy
 * @see     QZT_SyoukenTkListShTy
 * @see     GenQZT_SyoukenTkListShTy
 */
@MappedSuperclass
@Table(name=GenZT_SyoukenTkListShTy.TABLE_NAME)
@IdClass(value=PKZT_SyoukenTkListShTy.class)
public abstract class GenZT_SyoukenTkListShTy extends AbstractExDBEntity<ZT_SyoukenTkListShTy, PKZT_SyoukenTkListShTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyoukenTkListShTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYATESAKITANTNM         = "ztyatesakitantnm";
    public static final String ZTYHOZONKKN              = "ztyhozonkkn";
    public static final String ZTYTYOUHYOUYMDWA         = "ztytyouhyouymdwa";
    public static final String ZTYYOBIV26               = "ztyyobiv26";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYSYORINM               = "ztysyorinm";
    public static final String ZTYSYORISYOUNINSYACD     = "ztysyorisyouninsyacd";
    public static final String ZTYSYORISYOUNINSYANM     = "ztysyorisyouninsyanm";
    public static final String ZTYJIGOSAGYOUNAIYO1      = "ztyjigosagyounaiyo1";
    public static final String ZTYJIGOSAGYOUNAIYO2      = "ztyjigosagyounaiyo2";
    public static final String ZTYJIGOSAGYOUNAIYO3      = "ztyjigosagyounaiyo3";
    public static final String ZTYJIGOSAGYOUNAIYO4      = "ztyjigosagyounaiyo4";
    public static final String ZTYJIGOSAGYOUNAIYO5      = "ztyjigosagyounaiyo5";
    public static final String ZTYJIGOSAGYOUNAIYO6      = "ztyjigosagyounaiyo6";
    public static final String ZTYJIGOSAGYOUNAIYO7      = "ztyjigosagyounaiyo7";
    public static final String ZTYJIGOSAGYOUNAIYO8      = "ztyjigosagyounaiyo8";
    public static final String ZTYJIGOSAGYOUNAIYO9      = "ztyjigosagyounaiyo9";
    public static final String ZTYJIGOSAGYOUNAIYO10     = "ztyjigosagyounaiyo10";
    public static final String ZTYJIGOSAGYOUNAIYO11     = "ztyjigosagyounaiyo11";
    public static final String ZTYJIGOSAGYOUNAIYO12     = "ztyjigosagyounaiyo12";
    public static final String ZTYJIGOSAGYOUNAIYO13     = "ztyjigosagyounaiyo13";
    public static final String ZTYJIGOSAGYOUNAIYO14     = "ztyjigosagyounaiyo14";
    public static final String ZTYJIGOSAGYOUNAIYO15     = "ztyjigosagyounaiyo15";
    public static final String ZTYJIGOSAGYOUNAIYO16     = "ztyjigosagyounaiyo16";
    public static final String ZTYYOBIV31               = "ztyyobiv31";

    private final PKZT_SyoukenTkListShTy primaryKey;

    public GenZT_SyoukenTkListShTy() {
        primaryKey = new PKZT_SyoukenTkListShTy();
    }

    public GenZT_SyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_SyoukenTkListShTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SyoukenTkListShTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyoukenTkListShTy> getMetaClass() {
        return QZT_SyoukenTkListShTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListShTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztyatesakitantnm;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYATESAKITANTNM)
    public String getZtyatesakitantnm() {
        return ztyatesakitantnm;
    }

    public void setZtyatesakitantnm(String pZtyatesakitantnm) {
        ztyatesakitantnm = pZtyatesakitantnm;
    }

    private String ztyhozonkkn;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYHOZONKKN)
    public String getZtyhozonkkn() {
        return ztyhozonkkn;
    }

    public void setZtyhozonkkn(String pZtyhozonkkn) {
        ztyhozonkkn = pZtyhozonkkn;
    }

    private String ztytyouhyouymdwa;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYTYOUHYOUYMDWA)
    public String getZtytyouhyouymdwa() {
        return ztytyouhyouymdwa;
    }

    public void setZtytyouhyouymdwa(String pZtytyouhyouymdwa) {
        ztytyouhyouymdwa = pZtytyouhyouymdwa;
    }

    private String ztyyobiv26;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYYOBIV26)
    public String getZtyyobiv26() {
        return ztyyobiv26;
    }

    public void setZtyyobiv26(String pZtyyobiv26) {
        ztyyobiv26 = pZtyyobiv26;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListShTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztykyknmkj;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztysyorinm;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYSYORINM)
    public String getZtysyorinm() {
        return ztysyorinm;
    }

    public void setZtysyorinm(String pZtysyorinm) {
        ztysyorinm = pZtysyorinm;
    }

    private String ztysyorisyouninsyacd;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYSYORISYOUNINSYACD)
    public String getZtysyorisyouninsyacd() {
        return ztysyorisyouninsyacd;
    }

    public void setZtysyorisyouninsyacd(String pZtysyorisyouninsyacd) {
        ztysyorisyouninsyacd = pZtysyorisyouninsyacd;
    }

    private String ztysyorisyouninsyanm;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYSYORISYOUNINSYANM)
    public String getZtysyorisyouninsyanm() {
        return ztysyorisyouninsyanm;
    }

    public void setZtysyorisyouninsyanm(String pZtysyorisyouninsyanm) {
        ztysyorisyouninsyanm = pZtysyorisyouninsyanm;
    }

    private String ztyjigosagyounaiyo1;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO1)
    public String getZtyjigosagyounaiyo1() {
        return ztyjigosagyounaiyo1;
    }

    public void setZtyjigosagyounaiyo1(String pZtyjigosagyounaiyo1) {
        ztyjigosagyounaiyo1 = pZtyjigosagyounaiyo1;
    }

    private String ztyjigosagyounaiyo2;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO2)
    public String getZtyjigosagyounaiyo2() {
        return ztyjigosagyounaiyo2;
    }

    public void setZtyjigosagyounaiyo2(String pZtyjigosagyounaiyo2) {
        ztyjigosagyounaiyo2 = pZtyjigosagyounaiyo2;
    }

    private String ztyjigosagyounaiyo3;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO3)
    public String getZtyjigosagyounaiyo3() {
        return ztyjigosagyounaiyo3;
    }

    public void setZtyjigosagyounaiyo3(String pZtyjigosagyounaiyo3) {
        ztyjigosagyounaiyo3 = pZtyjigosagyounaiyo3;
    }

    private String ztyjigosagyounaiyo4;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO4)
    public String getZtyjigosagyounaiyo4() {
        return ztyjigosagyounaiyo4;
    }

    public void setZtyjigosagyounaiyo4(String pZtyjigosagyounaiyo4) {
        ztyjigosagyounaiyo4 = pZtyjigosagyounaiyo4;
    }

    private String ztyjigosagyounaiyo5;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO5)
    public String getZtyjigosagyounaiyo5() {
        return ztyjigosagyounaiyo5;
    }

    public void setZtyjigosagyounaiyo5(String pZtyjigosagyounaiyo5) {
        ztyjigosagyounaiyo5 = pZtyjigosagyounaiyo5;
    }

    private String ztyjigosagyounaiyo6;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO6)
    public String getZtyjigosagyounaiyo6() {
        return ztyjigosagyounaiyo6;
    }

    public void setZtyjigosagyounaiyo6(String pZtyjigosagyounaiyo6) {
        ztyjigosagyounaiyo6 = pZtyjigosagyounaiyo6;
    }

    private String ztyjigosagyounaiyo7;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO7)
    public String getZtyjigosagyounaiyo7() {
        return ztyjigosagyounaiyo7;
    }

    public void setZtyjigosagyounaiyo7(String pZtyjigosagyounaiyo7) {
        ztyjigosagyounaiyo7 = pZtyjigosagyounaiyo7;
    }

    private String ztyjigosagyounaiyo8;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO8)
    public String getZtyjigosagyounaiyo8() {
        return ztyjigosagyounaiyo8;
    }

    public void setZtyjigosagyounaiyo8(String pZtyjigosagyounaiyo8) {
        ztyjigosagyounaiyo8 = pZtyjigosagyounaiyo8;
    }

    private String ztyjigosagyounaiyo9;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO9)
    public String getZtyjigosagyounaiyo9() {
        return ztyjigosagyounaiyo9;
    }

    public void setZtyjigosagyounaiyo9(String pZtyjigosagyounaiyo9) {
        ztyjigosagyounaiyo9 = pZtyjigosagyounaiyo9;
    }

    private String ztyjigosagyounaiyo10;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO10)
    public String getZtyjigosagyounaiyo10() {
        return ztyjigosagyounaiyo10;
    }

    public void setZtyjigosagyounaiyo10(String pZtyjigosagyounaiyo10) {
        ztyjigosagyounaiyo10 = pZtyjigosagyounaiyo10;
    }

    private String ztyjigosagyounaiyo11;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO11)
    public String getZtyjigosagyounaiyo11() {
        return ztyjigosagyounaiyo11;
    }

    public void setZtyjigosagyounaiyo11(String pZtyjigosagyounaiyo11) {
        ztyjigosagyounaiyo11 = pZtyjigosagyounaiyo11;
    }

    private String ztyjigosagyounaiyo12;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO12)
    public String getZtyjigosagyounaiyo12() {
        return ztyjigosagyounaiyo12;
    }

    public void setZtyjigosagyounaiyo12(String pZtyjigosagyounaiyo12) {
        ztyjigosagyounaiyo12 = pZtyjigosagyounaiyo12;
    }

    private String ztyjigosagyounaiyo13;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO13)
    public String getZtyjigosagyounaiyo13() {
        return ztyjigosagyounaiyo13;
    }

    public void setZtyjigosagyounaiyo13(String pZtyjigosagyounaiyo13) {
        ztyjigosagyounaiyo13 = pZtyjigosagyounaiyo13;
    }

    private String ztyjigosagyounaiyo14;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO14)
    public String getZtyjigosagyounaiyo14() {
        return ztyjigosagyounaiyo14;
    }

    public void setZtyjigosagyounaiyo14(String pZtyjigosagyounaiyo14) {
        ztyjigosagyounaiyo14 = pZtyjigosagyounaiyo14;
    }

    private String ztyjigosagyounaiyo15;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO15)
    public String getZtyjigosagyounaiyo15() {
        return ztyjigosagyounaiyo15;
    }

    public void setZtyjigosagyounaiyo15(String pZtyjigosagyounaiyo15) {
        ztyjigosagyounaiyo15 = pZtyjigosagyounaiyo15;
    }

    private String ztyjigosagyounaiyo16;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYJIGOSAGYOUNAIYO16)
    public String getZtyjigosagyounaiyo16() {
        return ztyjigosagyounaiyo16;
    }

    public void setZtyjigosagyounaiyo16(String pZtyjigosagyounaiyo16) {
        ztyjigosagyounaiyo16 = pZtyjigosagyounaiyo16;
    }

    private String ztyyobiv31;

    @Column(name=GenZT_SyoukenTkListShTy.ZTYYOBIV31)
    public String getZtyyobiv31() {
        return ztyyobiv31;
    }

    public void setZtyyobiv31(String pZtyyobiv31) {
        ztyyobiv31 = pZtyyobiv31;
    }
}
