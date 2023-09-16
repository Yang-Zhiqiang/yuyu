package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SyoukenTkListShRn;
import yuyu.def.db.id.PKZT_SyoukenTkListShRn;
import yuyu.def.db.meta.GenQZT_SyoukenTkListShRn;
import yuyu.def.db.meta.QZT_SyoukenTkListShRn;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SyoukenTkListShRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListShRn}</td><td colspan="3">証券特殊処理明細リスト（再発行）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SyoukenTkListShRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakitantnm zrnatesakitantnm}</td><td>（連携用）宛先担当室名(組織名)</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhozonkkn zrnhozonkkn}</td><td>（連携用）保存期間</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdwa zrntyouhyouymdwa}</td><td>（連携用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26 zrnyobiv26}</td><td>（連携用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SyoukenTkListShRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorinm zrnsyorinm}</td><td>（連携用）処理名(機能名)</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorisyouninsyacd zrnsyorisyouninsyacd}</td><td>（連携用）処理承認者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorisyouninsyanm zrnsyorisyouninsyanm}</td><td>（連携用）処理承認者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo1 zrnjigosagyounaiyo1}</td><td>（連携用）事後作業内容１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo2 zrnjigosagyounaiyo2}</td><td>（連携用）事後作業内容２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo3 zrnjigosagyounaiyo3}</td><td>（連携用）事後作業内容３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo4 zrnjigosagyounaiyo4}</td><td>（連携用）事後作業内容４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo5 zrnjigosagyounaiyo5}</td><td>（連携用）事後作業内容５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo6 zrnjigosagyounaiyo6}</td><td>（連携用）事後作業内容６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo7 zrnjigosagyounaiyo7}</td><td>（連携用）事後作業内容７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo8 zrnjigosagyounaiyo8}</td><td>（連携用）事後作業内容８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo9 zrnjigosagyounaiyo9}</td><td>（連携用）事後作業内容９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo10 zrnjigosagyounaiyo10}</td><td>（連携用）事後作業内容１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo11 zrnjigosagyounaiyo11}</td><td>（連携用）事後作業内容１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo12 zrnjigosagyounaiyo12}</td><td>（連携用）事後作業内容１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo13 zrnjigosagyounaiyo13}</td><td>（連携用）事後作業内容１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo14 zrnjigosagyounaiyo14}</td><td>（連携用）事後作業内容１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo15 zrnjigosagyounaiyo15}</td><td>（連携用）事後作業内容１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigosagyounaiyo16 zrnjigosagyounaiyo16}</td><td>（連携用）事後作業内容１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv31 zrnyobiv31}</td><td>（連携用）予備項目Ｖ３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListShRn
 * @see     PKZT_SyoukenTkListShRn
 * @see     QZT_SyoukenTkListShRn
 * @see     GenQZT_SyoukenTkListShRn
 */
@MappedSuperclass
@Table(name=GenZT_SyoukenTkListShRn.TABLE_NAME)
@IdClass(value=PKZT_SyoukenTkListShRn.class)
public abstract class GenZT_SyoukenTkListShRn extends AbstractExDBEntityForZDB<ZT_SyoukenTkListShRn, PKZT_SyoukenTkListShRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyoukenTkListShRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNATESAKITANTNM         = "zrnatesakitantnm";
    public static final String ZRNHOZONKKN              = "zrnhozonkkn";
    public static final String ZRNTYOUHYOUYMDWA         = "zrntyouhyouymdwa";
    public static final String ZRNYOBIV26               = "zrnyobiv26";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNSYORINM               = "zrnsyorinm";
    public static final String ZRNSYORISYOUNINSYACD     = "zrnsyorisyouninsyacd";
    public static final String ZRNSYORISYOUNINSYANM     = "zrnsyorisyouninsyanm";
    public static final String ZRNJIGOSAGYOUNAIYO1      = "zrnjigosagyounaiyo1";
    public static final String ZRNJIGOSAGYOUNAIYO2      = "zrnjigosagyounaiyo2";
    public static final String ZRNJIGOSAGYOUNAIYO3      = "zrnjigosagyounaiyo3";
    public static final String ZRNJIGOSAGYOUNAIYO4      = "zrnjigosagyounaiyo4";
    public static final String ZRNJIGOSAGYOUNAIYO5      = "zrnjigosagyounaiyo5";
    public static final String ZRNJIGOSAGYOUNAIYO6      = "zrnjigosagyounaiyo6";
    public static final String ZRNJIGOSAGYOUNAIYO7      = "zrnjigosagyounaiyo7";
    public static final String ZRNJIGOSAGYOUNAIYO8      = "zrnjigosagyounaiyo8";
    public static final String ZRNJIGOSAGYOUNAIYO9      = "zrnjigosagyounaiyo9";
    public static final String ZRNJIGOSAGYOUNAIYO10     = "zrnjigosagyounaiyo10";
    public static final String ZRNJIGOSAGYOUNAIYO11     = "zrnjigosagyounaiyo11";
    public static final String ZRNJIGOSAGYOUNAIYO12     = "zrnjigosagyounaiyo12";
    public static final String ZRNJIGOSAGYOUNAIYO13     = "zrnjigosagyounaiyo13";
    public static final String ZRNJIGOSAGYOUNAIYO14     = "zrnjigosagyounaiyo14";
    public static final String ZRNJIGOSAGYOUNAIYO15     = "zrnjigosagyounaiyo15";
    public static final String ZRNJIGOSAGYOUNAIYO16     = "zrnjigosagyounaiyo16";
    public static final String ZRNYOBIV31               = "zrnyobiv31";

    private final PKZT_SyoukenTkListShRn primaryKey;

    public GenZT_SyoukenTkListShRn() {
        primaryKey = new PKZT_SyoukenTkListShRn();
    }

    public GenZT_SyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_SyoukenTkListShRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SyoukenTkListShRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyoukenTkListShRn> getMetaClass() {
        return QZT_SyoukenTkListShRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListShRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnatesakitantnm;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNATESAKITANTNM)
    public String getZrnatesakitantnm() {
        return zrnatesakitantnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakitantnm(String pZrnatesakitantnm) {
        zrnatesakitantnm = pZrnatesakitantnm;
    }

    private String zrnhozonkkn;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNHOZONKKN)
    public String getZrnhozonkkn() {
        return zrnhozonkkn;
    }

    @DataConvert("toMultiByte")
    public void setZrnhozonkkn(String pZrnhozonkkn) {
        zrnhozonkkn = pZrnhozonkkn;
    }

    private String zrntyouhyouymdwa;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNTYOUHYOUYMDWA)
    public String getZrntyouhyouymdwa() {
        return zrntyouhyouymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdwa(String pZrntyouhyouymdwa) {
        zrntyouhyouymdwa = pZrntyouhyouymdwa;
    }

    private String zrnyobiv26;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNYOBIV26)
    public String getZrnyobiv26() {
        return zrnyobiv26;
    }

    public void setZrnyobiv26(String pZrnyobiv26) {
        zrnyobiv26 = pZrnyobiv26;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListShRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnsyorinm;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNSYORINM)
    public String getZrnsyorinm() {
        return zrnsyorinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyorinm(String pZrnsyorinm) {
        zrnsyorinm = pZrnsyorinm;
    }

    private String zrnsyorisyouninsyacd;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNSYORISYOUNINSYACD)
    public String getZrnsyorisyouninsyacd() {
        return zrnsyorisyouninsyacd;
    }

    public void setZrnsyorisyouninsyacd(String pZrnsyorisyouninsyacd) {
        zrnsyorisyouninsyacd = pZrnsyorisyouninsyacd;
    }

    private String zrnsyorisyouninsyanm;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNSYORISYOUNINSYANM)
    public String getZrnsyorisyouninsyanm() {
        return zrnsyorisyouninsyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyorisyouninsyanm(String pZrnsyorisyouninsyanm) {
        zrnsyorisyouninsyanm = pZrnsyorisyouninsyanm;
    }

    private String zrnjigosagyounaiyo1;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO1)
    public String getZrnjigosagyounaiyo1() {
        return zrnjigosagyounaiyo1;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo1(String pZrnjigosagyounaiyo1) {
        zrnjigosagyounaiyo1 = pZrnjigosagyounaiyo1;
    }

    private String zrnjigosagyounaiyo2;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO2)
    public String getZrnjigosagyounaiyo2() {
        return zrnjigosagyounaiyo2;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo2(String pZrnjigosagyounaiyo2) {
        zrnjigosagyounaiyo2 = pZrnjigosagyounaiyo2;
    }

    private String zrnjigosagyounaiyo3;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO3)
    public String getZrnjigosagyounaiyo3() {
        return zrnjigosagyounaiyo3;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo3(String pZrnjigosagyounaiyo3) {
        zrnjigosagyounaiyo3 = pZrnjigosagyounaiyo3;
    }

    private String zrnjigosagyounaiyo4;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO4)
    public String getZrnjigosagyounaiyo4() {
        return zrnjigosagyounaiyo4;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo4(String pZrnjigosagyounaiyo4) {
        zrnjigosagyounaiyo4 = pZrnjigosagyounaiyo4;
    }

    private String zrnjigosagyounaiyo5;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO5)
    public String getZrnjigosagyounaiyo5() {
        return zrnjigosagyounaiyo5;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo5(String pZrnjigosagyounaiyo5) {
        zrnjigosagyounaiyo5 = pZrnjigosagyounaiyo5;
    }

    private String zrnjigosagyounaiyo6;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO6)
    public String getZrnjigosagyounaiyo6() {
        return zrnjigosagyounaiyo6;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo6(String pZrnjigosagyounaiyo6) {
        zrnjigosagyounaiyo6 = pZrnjigosagyounaiyo6;
    }

    private String zrnjigosagyounaiyo7;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO7)
    public String getZrnjigosagyounaiyo7() {
        return zrnjigosagyounaiyo7;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo7(String pZrnjigosagyounaiyo7) {
        zrnjigosagyounaiyo7 = pZrnjigosagyounaiyo7;
    }

    private String zrnjigosagyounaiyo8;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO8)
    public String getZrnjigosagyounaiyo8() {
        return zrnjigosagyounaiyo8;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo8(String pZrnjigosagyounaiyo8) {
        zrnjigosagyounaiyo8 = pZrnjigosagyounaiyo8;
    }

    private String zrnjigosagyounaiyo9;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO9)
    public String getZrnjigosagyounaiyo9() {
        return zrnjigosagyounaiyo9;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo9(String pZrnjigosagyounaiyo9) {
        zrnjigosagyounaiyo9 = pZrnjigosagyounaiyo9;
    }

    private String zrnjigosagyounaiyo10;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO10)
    public String getZrnjigosagyounaiyo10() {
        return zrnjigosagyounaiyo10;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo10(String pZrnjigosagyounaiyo10) {
        zrnjigosagyounaiyo10 = pZrnjigosagyounaiyo10;
    }

    private String zrnjigosagyounaiyo11;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO11)
    public String getZrnjigosagyounaiyo11() {
        return zrnjigosagyounaiyo11;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo11(String pZrnjigosagyounaiyo11) {
        zrnjigosagyounaiyo11 = pZrnjigosagyounaiyo11;
    }

    private String zrnjigosagyounaiyo12;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO12)
    public String getZrnjigosagyounaiyo12() {
        return zrnjigosagyounaiyo12;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo12(String pZrnjigosagyounaiyo12) {
        zrnjigosagyounaiyo12 = pZrnjigosagyounaiyo12;
    }

    private String zrnjigosagyounaiyo13;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO13)
    public String getZrnjigosagyounaiyo13() {
        return zrnjigosagyounaiyo13;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo13(String pZrnjigosagyounaiyo13) {
        zrnjigosagyounaiyo13 = pZrnjigosagyounaiyo13;
    }

    private String zrnjigosagyounaiyo14;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO14)
    public String getZrnjigosagyounaiyo14() {
        return zrnjigosagyounaiyo14;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo14(String pZrnjigosagyounaiyo14) {
        zrnjigosagyounaiyo14 = pZrnjigosagyounaiyo14;
    }

    private String zrnjigosagyounaiyo15;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO15)
    public String getZrnjigosagyounaiyo15() {
        return zrnjigosagyounaiyo15;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo15(String pZrnjigosagyounaiyo15) {
        zrnjigosagyounaiyo15 = pZrnjigosagyounaiyo15;
    }

    private String zrnjigosagyounaiyo16;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNJIGOSAGYOUNAIYO16)
    public String getZrnjigosagyounaiyo16() {
        return zrnjigosagyounaiyo16;
    }

    @DataConvert("toMultiByte")
    public void setZrnjigosagyounaiyo16(String pZrnjigosagyounaiyo16) {
        zrnjigosagyounaiyo16 = pZrnjigosagyounaiyo16;
    }

    private String zrnyobiv31;

    @Column(name=GenZT_SyoukenTkListShRn.ZRNYOBIV31)
    public String getZrnyobiv31() {
        return zrnyobiv31;
    }

    public void setZrnyobiv31(String pZrnyobiv31) {
        zrnyobiv31 = pZrnyobiv31;
    }
}