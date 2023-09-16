package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SyoukenTkListSkRn;
import yuyu.def.db.id.PKZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.GenQZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.QZT_SyoukenTkListSkRn;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SyoukenTkListSkRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListSkRn}</td><td colspan="3">証券特殊処理明細リスト（新契約）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SyoukenTkListSkRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakitantnm zrnatesakitantnm}</td><td>（連携用）宛先担当室名(組織名)</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhozonkkn zrnhozonkkn}</td><td>（連携用）保存期間</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdwa zrntyouhyouymdwa}</td><td>（連携用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsagyoukbn zrnsagyoukbn}</td><td>（連携用）作業区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25 zrnyobiv25}</td><td>（連携用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SyoukenTkListSkRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou1 zrntksysyorinaiyou1}</td><td>（連携用）特殊処理内容１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou2 zrntksysyorinaiyou2}</td><td>（連携用）特殊処理内容２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou3 zrntksysyorinaiyou3}</td><td>（連携用）特殊処理内容３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou4 zrntksysyorinaiyou4}</td><td>（連携用）特殊処理内容４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou5 zrntksysyorinaiyou5}</td><td>（連携用）特殊処理内容５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou6 zrntksysyorinaiyou6}</td><td>（連携用）特殊処理内容６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou7 zrntksysyorinaiyou7}</td><td>（連携用）特殊処理内容７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou8 zrntksysyorinaiyou8}</td><td>（連携用）特殊処理内容８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou9 zrntksysyorinaiyou9}</td><td>（連携用）特殊処理内容９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou10 zrntksysyorinaiyou10}</td><td>（連携用）特殊処理内容１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou11 zrntksysyorinaiyou11}</td><td>（連携用）特殊処理内容１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou12 zrntksysyorinaiyou12}</td><td>（連携用）特殊処理内容１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou13 zrntksysyorinaiyou13}</td><td>（連携用）特殊処理内容１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksysyorinaiyou14 zrntksysyorinaiyou14}</td><td>（連携用）特殊処理内容１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikouupside zrnbikouupside}</td><td>（連携用）備考上段</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikoudownside zrnbikoudownside}</td><td>（連携用）備考下段</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanbunsyono zrnyakkanbunsyono}</td><td>（連携用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv21 zrnyobiv21}</td><td>（連携用）予備項目Ｖ２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListSkRn
 * @see     PKZT_SyoukenTkListSkRn
 * @see     QZT_SyoukenTkListSkRn
 * @see     GenQZT_SyoukenTkListSkRn
 */
@MappedSuperclass
@Table(name=GenZT_SyoukenTkListSkRn.TABLE_NAME)
@IdClass(value=PKZT_SyoukenTkListSkRn.class)
public abstract class GenZT_SyoukenTkListSkRn extends AbstractExDBEntityForZDB<ZT_SyoukenTkListSkRn, PKZT_SyoukenTkListSkRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyoukenTkListSkRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNATESAKITANTNM         = "zrnatesakitantnm";
    public static final String ZRNHOZONKKN              = "zrnhozonkkn";
    public static final String ZRNTYOUHYOUYMDWA         = "zrntyouhyouymdwa";
    public static final String ZRNSAGYOUKBN             = "zrnsagyoukbn";
    public static final String ZRNYOBIV25               = "zrnyobiv25";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNTKSYSYORINAIYOU1      = "zrntksysyorinaiyou1";
    public static final String ZRNTKSYSYORINAIYOU2      = "zrntksysyorinaiyou2";
    public static final String ZRNTKSYSYORINAIYOU3      = "zrntksysyorinaiyou3";
    public static final String ZRNTKSYSYORINAIYOU4      = "zrntksysyorinaiyou4";
    public static final String ZRNTKSYSYORINAIYOU5      = "zrntksysyorinaiyou5";
    public static final String ZRNTKSYSYORINAIYOU6      = "zrntksysyorinaiyou6";
    public static final String ZRNTKSYSYORINAIYOU7      = "zrntksysyorinaiyou7";
    public static final String ZRNTKSYSYORINAIYOU8      = "zrntksysyorinaiyou8";
    public static final String ZRNTKSYSYORINAIYOU9      = "zrntksysyorinaiyou9";
    public static final String ZRNTKSYSYORINAIYOU10     = "zrntksysyorinaiyou10";
    public static final String ZRNTKSYSYORINAIYOU11     = "zrntksysyorinaiyou11";
    public static final String ZRNTKSYSYORINAIYOU12     = "zrntksysyorinaiyou12";
    public static final String ZRNTKSYSYORINAIYOU13     = "zrntksysyorinaiyou13";
    public static final String ZRNTKSYSYORINAIYOU14     = "zrntksysyorinaiyou14";
    public static final String ZRNBIKOUUPSIDE           = "zrnbikouupside";
    public static final String ZRNBIKOUDOWNSIDE         = "zrnbikoudownside";
    public static final String ZRNYAKKANBUNSYONO        = "zrnyakkanbunsyono";
    public static final String ZRNYOBIV21               = "zrnyobiv21";

    private final PKZT_SyoukenTkListSkRn primaryKey;

    public GenZT_SyoukenTkListSkRn() {
        primaryKey = new PKZT_SyoukenTkListSkRn();
    }

    public GenZT_SyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_SyoukenTkListSkRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SyoukenTkListSkRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyoukenTkListSkRn> getMetaClass() {
        return QZT_SyoukenTkListSkRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnatesakitantnm;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNATESAKITANTNM)
    public String getZrnatesakitantnm() {
        return zrnatesakitantnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakitantnm(String pZrnatesakitantnm) {
        zrnatesakitantnm = pZrnatesakitantnm;
    }

    private String zrnhozonkkn;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNHOZONKKN)
    public String getZrnhozonkkn() {
        return zrnhozonkkn;
    }

    @DataConvert("toMultiByte")
    public void setZrnhozonkkn(String pZrnhozonkkn) {
        zrnhozonkkn = pZrnhozonkkn;
    }

    private String zrntyouhyouymdwa;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTYOUHYOUYMDWA)
    public String getZrntyouhyouymdwa() {
        return zrntyouhyouymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdwa(String pZrntyouhyouymdwa) {
        zrntyouhyouymdwa = pZrntyouhyouymdwa;
    }

    private String zrnsagyoukbn;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNSAGYOUKBN)
    public String getZrnsagyoukbn() {
        return zrnsagyoukbn;
    }

    public void setZrnsagyoukbn(String pZrnsagyoukbn) {
        zrnsagyoukbn = pZrnsagyoukbn;
    }

    private String zrnyobiv25;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNYOBIV25)
    public String getZrnyobiv25() {
        return zrnyobiv25;
    }

    public void setZrnyobiv25(String pZrnyobiv25) {
        zrnyobiv25 = pZrnyobiv25;
    }

    @Id
    @Column(name=GenZT_SyoukenTkListSkRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrntksysyorinaiyou1;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU1)
    public String getZrntksysyorinaiyou1() {
        return zrntksysyorinaiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou1(String pZrntksysyorinaiyou1) {
        zrntksysyorinaiyou1 = pZrntksysyorinaiyou1;
    }

    private String zrntksysyorinaiyou2;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU2)
    public String getZrntksysyorinaiyou2() {
        return zrntksysyorinaiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou2(String pZrntksysyorinaiyou2) {
        zrntksysyorinaiyou2 = pZrntksysyorinaiyou2;
    }

    private String zrntksysyorinaiyou3;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU3)
    public String getZrntksysyorinaiyou3() {
        return zrntksysyorinaiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou3(String pZrntksysyorinaiyou3) {
        zrntksysyorinaiyou3 = pZrntksysyorinaiyou3;
    }

    private String zrntksysyorinaiyou4;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU4)
    public String getZrntksysyorinaiyou4() {
        return zrntksysyorinaiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou4(String pZrntksysyorinaiyou4) {
        zrntksysyorinaiyou4 = pZrntksysyorinaiyou4;
    }

    private String zrntksysyorinaiyou5;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU5)
    public String getZrntksysyorinaiyou5() {
        return zrntksysyorinaiyou5;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou5(String pZrntksysyorinaiyou5) {
        zrntksysyorinaiyou5 = pZrntksysyorinaiyou5;
    }

    private String zrntksysyorinaiyou6;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU6)
    public String getZrntksysyorinaiyou6() {
        return zrntksysyorinaiyou6;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou6(String pZrntksysyorinaiyou6) {
        zrntksysyorinaiyou6 = pZrntksysyorinaiyou6;
    }

    private String zrntksysyorinaiyou7;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU7)
    public String getZrntksysyorinaiyou7() {
        return zrntksysyorinaiyou7;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou7(String pZrntksysyorinaiyou7) {
        zrntksysyorinaiyou7 = pZrntksysyorinaiyou7;
    }

    private String zrntksysyorinaiyou8;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU8)
    public String getZrntksysyorinaiyou8() {
        return zrntksysyorinaiyou8;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou8(String pZrntksysyorinaiyou8) {
        zrntksysyorinaiyou8 = pZrntksysyorinaiyou8;
    }

    private String zrntksysyorinaiyou9;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU9)
    public String getZrntksysyorinaiyou9() {
        return zrntksysyorinaiyou9;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou9(String pZrntksysyorinaiyou9) {
        zrntksysyorinaiyou9 = pZrntksysyorinaiyou9;
    }

    private String zrntksysyorinaiyou10;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU10)
    public String getZrntksysyorinaiyou10() {
        return zrntksysyorinaiyou10;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou10(String pZrntksysyorinaiyou10) {
        zrntksysyorinaiyou10 = pZrntksysyorinaiyou10;
    }

    private String zrntksysyorinaiyou11;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU11)
    public String getZrntksysyorinaiyou11() {
        return zrntksysyorinaiyou11;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou11(String pZrntksysyorinaiyou11) {
        zrntksysyorinaiyou11 = pZrntksysyorinaiyou11;
    }

    private String zrntksysyorinaiyou12;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU12)
    public String getZrntksysyorinaiyou12() {
        return zrntksysyorinaiyou12;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou12(String pZrntksysyorinaiyou12) {
        zrntksysyorinaiyou12 = pZrntksysyorinaiyou12;
    }

    private String zrntksysyorinaiyou13;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU13)
    public String getZrntksysyorinaiyou13() {
        return zrntksysyorinaiyou13;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou13(String pZrntksysyorinaiyou13) {
        zrntksysyorinaiyou13 = pZrntksysyorinaiyou13;
    }

    private String zrntksysyorinaiyou14;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNTKSYSYORINAIYOU14)
    public String getZrntksysyorinaiyou14() {
        return zrntksysyorinaiyou14;
    }

    @DataConvert("toMultiByte")
    public void setZrntksysyorinaiyou14(String pZrntksysyorinaiyou14) {
        zrntksysyorinaiyou14 = pZrntksysyorinaiyou14;
    }

    private String zrnbikouupside;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNBIKOUUPSIDE)
    public String getZrnbikouupside() {
        return zrnbikouupside;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikouupside(String pZrnbikouupside) {
        zrnbikouupside = pZrnbikouupside;
    }

    private String zrnbikoudownside;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNBIKOUDOWNSIDE)
    public String getZrnbikoudownside() {
        return zrnbikoudownside;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikoudownside(String pZrnbikoudownside) {
        zrnbikoudownside = pZrnbikoudownside;
    }

    private String zrnyakkanbunsyono;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNYAKKANBUNSYONO)
    public String getZrnyakkanbunsyono() {
        return zrnyakkanbunsyono;
    }

    public void setZrnyakkanbunsyono(String pZrnyakkanbunsyono) {
        zrnyakkanbunsyono = pZrnyakkanbunsyono;
    }

    private String zrnyobiv21;

    @Column(name=GenZT_SyoukenTkListSkRn.ZRNYOBIV21)
    public String getZrnyobiv21() {
        return zrnyobiv21;
    }

    public void setZrnyobiv21(String pZrnyobiv21) {
        zrnyobiv21 = pZrnyobiv21;
    }
}