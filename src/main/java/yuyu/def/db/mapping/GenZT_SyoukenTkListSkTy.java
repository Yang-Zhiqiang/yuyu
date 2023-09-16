package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SyoukenTkListSkTy;
import yuyu.def.db.id.PKZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.GenQZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.QZT_SyoukenTkListSkTy;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SyoukenTkListSkTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListSkTy}</td><td colspan="3">証券特殊処理明細リスト（新契約）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SyoukenTkListSkTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakitantnm ztyatesakitantnm}</td><td>（中継用）宛先担当室名(組織名)</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhozonkkn ztyhozonkkn}</td><td>（中継用）保存期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdwa ztytyouhyouymdwa}</td><td>（中継用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysagyoukbn ztysagyoukbn}</td><td>（中継用）作業区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv25 ztyyobiv25}</td><td>（中継用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SyoukenTkListSkTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou1 ztytksysyorinaiyou1}</td><td>（中継用）特殊処理内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou2 ztytksysyorinaiyou2}</td><td>（中継用）特殊処理内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou3 ztytksysyorinaiyou3}</td><td>（中継用）特殊処理内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou4 ztytksysyorinaiyou4}</td><td>（中継用）特殊処理内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou5 ztytksysyorinaiyou5}</td><td>（中継用）特殊処理内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou6 ztytksysyorinaiyou6}</td><td>（中継用）特殊処理内容６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou7 ztytksysyorinaiyou7}</td><td>（中継用）特殊処理内容７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou8 ztytksysyorinaiyou8}</td><td>（中継用）特殊処理内容８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou9 ztytksysyorinaiyou9}</td><td>（中継用）特殊処理内容９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou10 ztytksysyorinaiyou10}</td><td>（中継用）特殊処理内容１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou11 ztytksysyorinaiyou11}</td><td>（中継用）特殊処理内容１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou12 ztytksysyorinaiyou12}</td><td>（中継用）特殊処理内容１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou13 ztytksysyorinaiyou13}</td><td>（中継用）特殊処理内容１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksysyorinaiyou14 ztytksysyorinaiyou14}</td><td>（中継用）特殊処理内容１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikouupside ztybikouupside}</td><td>（中継用）備考上段</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikoudownside ztybikoudownside}</td><td>（中継用）備考下段</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanbunsyono ztyyakkanbunsyono}</td><td>（中継用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv21 ztyyobiv21}</td><td>（中継用）予備項目Ｖ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListSkTy
 * @see     PKZT_SyoukenTkListSkTy
 * @see     QZT_SyoukenTkListSkTy
 * @see     GenQZT_SyoukenTkListSkTy
 */
@MappedSuperclass
@Table(name=GenZT_SyoukenTkListSkTy.TABLE_NAME)
@IdClass(value=PKZT_SyoukenTkListSkTy.class)
public abstract class GenZT_SyoukenTkListSkTy extends AbstractExDBEntity<ZT_SyoukenTkListSkTy, PKZT_SyoukenTkListSkTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyoukenTkListSkTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYATESAKITANTNM         = "ztyatesakitantnm";
    public static final String ZTYHOZONKKN              = "ztyhozonkkn";
    public static final String ZTYTYOUHYOUYMDWA         = "ztytyouhyouymdwa";
    public static final String ZTYSAGYOUKBN             = "ztysagyoukbn";
    public static final String ZTYYOBIV25               = "ztyyobiv25";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYTKSYSYORINAIYOU1      = "ztytksysyorinaiyou1";
    public static final String ZTYTKSYSYORINAIYOU2      = "ztytksysyorinaiyou2";
    public static final String ZTYTKSYSYORINAIYOU3      = "ztytksysyorinaiyou3";
    public static final String ZTYTKSYSYORINAIYOU4      = "ztytksysyorinaiyou4";
    public static final String ZTYTKSYSYORINAIYOU5      = "ztytksysyorinaiyou5";
    public static final String ZTYTKSYSYORINAIYOU6      = "ztytksysyorinaiyou6";
    public static final String ZTYTKSYSYORINAIYOU7      = "ztytksysyorinaiyou7";
    public static final String ZTYTKSYSYORINAIYOU8      = "ztytksysyorinaiyou8";
    public static final String ZTYTKSYSYORINAIYOU9      = "ztytksysyorinaiyou9";
    public static final String ZTYTKSYSYORINAIYOU10     = "ztytksysyorinaiyou10";
    public static final String ZTYTKSYSYORINAIYOU11     = "ztytksysyorinaiyou11";
    public static final String ZTYTKSYSYORINAIYOU12     = "ztytksysyorinaiyou12";
    public static final String ZTYTKSYSYORINAIYOU13     = "ztytksysyorinaiyou13";
    public static final String ZTYTKSYSYORINAIYOU14     = "ztytksysyorinaiyou14";
    public static final String ZTYBIKOUUPSIDE           = "ztybikouupside";
    public static final String ZTYBIKOUDOWNSIDE         = "ztybikoudownside";
    public static final String ZTYYAKKANBUNSYONO        = "ztyyakkanbunsyono";
    public static final String ZTYYOBIV21               = "ztyyobiv21";

    private final PKZT_SyoukenTkListSkTy primaryKey;

    public GenZT_SyoukenTkListSkTy() {
        primaryKey = new PKZT_SyoukenTkListSkTy();
    }

    public GenZT_SyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_SyoukenTkListSkTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SyoukenTkListSkTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyoukenTkListSkTy> getMetaClass() {
        return QZT_SyoukenTkListSkTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztyatesakitantnm;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYATESAKITANTNM)
    public String getZtyatesakitantnm() {
        return ztyatesakitantnm;
    }

    public void setZtyatesakitantnm(String pZtyatesakitantnm) {
        ztyatesakitantnm = pZtyatesakitantnm;
    }

    private String ztyhozonkkn;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYHOZONKKN)
    public String getZtyhozonkkn() {
        return ztyhozonkkn;
    }

    public void setZtyhozonkkn(String pZtyhozonkkn) {
        ztyhozonkkn = pZtyhozonkkn;
    }

    private String ztytyouhyouymdwa;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTYOUHYOUYMDWA)
    public String getZtytyouhyouymdwa() {
        return ztytyouhyouymdwa;
    }

    public void setZtytyouhyouymdwa(String pZtytyouhyouymdwa) {
        ztytyouhyouymdwa = pZtytyouhyouymdwa;
    }

    private String ztysagyoukbn;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYSAGYOUKBN)
    public String getZtysagyoukbn() {
        return ztysagyoukbn;
    }

    public void setZtysagyoukbn(String pZtysagyoukbn) {
        ztysagyoukbn = pZtysagyoukbn;
    }

    private String ztyyobiv25;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYYOBIV25)
    public String getZtyyobiv25() {
        return ztyyobiv25;
    }

    public void setZtyyobiv25(String pZtyyobiv25) {
        ztyyobiv25 = pZtyyobiv25;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListSkTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztytksysyorinaiyou1;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU1)
    public String getZtytksysyorinaiyou1() {
        return ztytksysyorinaiyou1;
    }

    public void setZtytksysyorinaiyou1(String pZtytksysyorinaiyou1) {
        ztytksysyorinaiyou1 = pZtytksysyorinaiyou1;
    }

    private String ztytksysyorinaiyou2;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU2)
    public String getZtytksysyorinaiyou2() {
        return ztytksysyorinaiyou2;
    }

    public void setZtytksysyorinaiyou2(String pZtytksysyorinaiyou2) {
        ztytksysyorinaiyou2 = pZtytksysyorinaiyou2;
    }

    private String ztytksysyorinaiyou3;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU3)
    public String getZtytksysyorinaiyou3() {
        return ztytksysyorinaiyou3;
    }

    public void setZtytksysyorinaiyou3(String pZtytksysyorinaiyou3) {
        ztytksysyorinaiyou3 = pZtytksysyorinaiyou3;
    }

    private String ztytksysyorinaiyou4;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU4)
    public String getZtytksysyorinaiyou4() {
        return ztytksysyorinaiyou4;
    }

    public void setZtytksysyorinaiyou4(String pZtytksysyorinaiyou4) {
        ztytksysyorinaiyou4 = pZtytksysyorinaiyou4;
    }

    private String ztytksysyorinaiyou5;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU5)
    public String getZtytksysyorinaiyou5() {
        return ztytksysyorinaiyou5;
    }

    public void setZtytksysyorinaiyou5(String pZtytksysyorinaiyou5) {
        ztytksysyorinaiyou5 = pZtytksysyorinaiyou5;
    }

    private String ztytksysyorinaiyou6;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU6)
    public String getZtytksysyorinaiyou6() {
        return ztytksysyorinaiyou6;
    }

    public void setZtytksysyorinaiyou6(String pZtytksysyorinaiyou6) {
        ztytksysyorinaiyou6 = pZtytksysyorinaiyou6;
    }

    private String ztytksysyorinaiyou7;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU7)
    public String getZtytksysyorinaiyou7() {
        return ztytksysyorinaiyou7;
    }

    public void setZtytksysyorinaiyou7(String pZtytksysyorinaiyou7) {
        ztytksysyorinaiyou7 = pZtytksysyorinaiyou7;
    }

    private String ztytksysyorinaiyou8;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU8)
    public String getZtytksysyorinaiyou8() {
        return ztytksysyorinaiyou8;
    }

    public void setZtytksysyorinaiyou8(String pZtytksysyorinaiyou8) {
        ztytksysyorinaiyou8 = pZtytksysyorinaiyou8;
    }

    private String ztytksysyorinaiyou9;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU9)
    public String getZtytksysyorinaiyou9() {
        return ztytksysyorinaiyou9;
    }

    public void setZtytksysyorinaiyou9(String pZtytksysyorinaiyou9) {
        ztytksysyorinaiyou9 = pZtytksysyorinaiyou9;
    }

    private String ztytksysyorinaiyou10;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU10)
    public String getZtytksysyorinaiyou10() {
        return ztytksysyorinaiyou10;
    }

    public void setZtytksysyorinaiyou10(String pZtytksysyorinaiyou10) {
        ztytksysyorinaiyou10 = pZtytksysyorinaiyou10;
    }

    private String ztytksysyorinaiyou11;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU11)
    public String getZtytksysyorinaiyou11() {
        return ztytksysyorinaiyou11;
    }

    public void setZtytksysyorinaiyou11(String pZtytksysyorinaiyou11) {
        ztytksysyorinaiyou11 = pZtytksysyorinaiyou11;
    }

    private String ztytksysyorinaiyou12;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU12)
    public String getZtytksysyorinaiyou12() {
        return ztytksysyorinaiyou12;
    }

    public void setZtytksysyorinaiyou12(String pZtytksysyorinaiyou12) {
        ztytksysyorinaiyou12 = pZtytksysyorinaiyou12;
    }

    private String ztytksysyorinaiyou13;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU13)
    public String getZtytksysyorinaiyou13() {
        return ztytksysyorinaiyou13;
    }

    public void setZtytksysyorinaiyou13(String pZtytksysyorinaiyou13) {
        ztytksysyorinaiyou13 = pZtytksysyorinaiyou13;
    }

    private String ztytksysyorinaiyou14;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYTKSYSYORINAIYOU14)
    public String getZtytksysyorinaiyou14() {
        return ztytksysyorinaiyou14;
    }

    public void setZtytksysyorinaiyou14(String pZtytksysyorinaiyou14) {
        ztytksysyorinaiyou14 = pZtytksysyorinaiyou14;
    }

    private String ztybikouupside;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYBIKOUUPSIDE)
    public String getZtybikouupside() {
        return ztybikouupside;
    }

    public void setZtybikouupside(String pZtybikouupside) {
        ztybikouupside = pZtybikouupside;
    }

    private String ztybikoudownside;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYBIKOUDOWNSIDE)
    public String getZtybikoudownside() {
        return ztybikoudownside;
    }

    public void setZtybikoudownside(String pZtybikoudownside) {
        ztybikoudownside = pZtybikoudownside;
    }

    private String ztyyakkanbunsyono;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYYAKKANBUNSYONO)
    public String getZtyyakkanbunsyono() {
        return ztyyakkanbunsyono;
    }

    public void setZtyyakkanbunsyono(String pZtyyakkanbunsyono) {
        ztyyakkanbunsyono = pZtyyakkanbunsyono;
    }

    private String ztyyobiv21;

    @Column(name=GenZT_SyoukenTkListSkTy.ZTYYOBIV21)
    public String getZtyyobiv21() {
        return ztyyobiv21;
    }

    public void setZtyyobiv21(String pZtyyobiv21) {
        ztyyobiv21 = pZtyyobiv21;
    }
}