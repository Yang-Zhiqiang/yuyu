package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DirectMailDataRn;
import yuyu.def.db.id.PKZT_DirectMailDataRn;
import yuyu.def.db.meta.GenQZT_DirectMailDataRn;
import yuyu.def.db.meta.QZT_DirectMailDataRn;

/**
 * ダイレクトメールデータテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DirectMailDataRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DirectMailDataRn}</td><td colspan="3">ダイレクトメールデータテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhokenkbnnys zrnhokenkbnnys}</td><td>（連携用）保険区分（名寄せ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuinmeinonys zrnsakuinmeinonys}</td><td>（連携用）索引名番号（名寄せ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainnm zrnsyainnm}</td><td>（連携用）社員名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainseiymd zrnsyainseiymd}</td><td>（連携用）社員生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjisyainnm zrnkanjisyainnm}</td><td>（連携用）漢字社員名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaimitureigaihyj zrnnaimitureigaihyj}</td><td>（連携用）内密例外表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtenhyj zrndrtenhyj}</td><td>（連携用）代理店表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DirectMailDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitsinkaiadr zrnkanjitsinkaiadr}</td><td>（連携用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsouhuhunoukbn zrnsouhuhunoukbn}</td><td>（連携用）送付不能区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknnm zrnhknnm}</td><td>（連携用）保険名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenhousiki zrnnenhousiki}</td><td>（連携用）年齢方式</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkarihyj zrnkzktrkarihyj}</td><td>（連携用）ご家族登録有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatkioybsydrtencd zrnaatkioybsydrtencd}</td><td>（連携用）Ａ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkioybsydrtencd zrnbatkioybsydrtencd}</td><td>（連携用）Ｂ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x1 zrnyobiv250x1}</td><td>（連携用）予備項目Ｖ２５０＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x2 zrnyobiv250x2}</td><td>（連携用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x3 zrnyobiv250x3}</td><td>（連携用）予備項目Ｖ２５０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x4 zrnyobiv250x4}</td><td>（連携用）予備項目Ｖ２５０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x5 zrnyobiv250x5}</td><td>（連携用）予備項目Ｖ２５０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x6 zrnyobiv250x6}</td><td>（連携用）予備項目Ｖ２５０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x7 zrnyobiv250x7}</td><td>（連携用）予備項目Ｖ２５０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x8 zrnyobiv250x8}</td><td>（連携用）予備項目Ｖ２５０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x9 zrnyobiv250x9}</td><td>（連携用）予備項目Ｖ２５０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x10 zrnyobiv250x10}</td><td>（連携用）予備項目Ｖ２５０＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x11 zrnyobiv250x11}</td><td>（連携用）予備項目Ｖ２５０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x12 zrnyobiv250x12}</td><td>（連携用）予備項目Ｖ２５０＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x13 zrnyobiv250x13}</td><td>（連携用）予備項目Ｖ２５０＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x14 zrnyobiv250x14}</td><td>（連携用）予備項目Ｖ２５０＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv122 zrnyobiv122}</td><td>（連携用）予備項目Ｖ１２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DirectMailDataRn
 * @see     PKZT_DirectMailDataRn
 * @see     QZT_DirectMailDataRn
 * @see     GenQZT_DirectMailDataRn
 */
@MappedSuperclass
@Table(name=GenZT_DirectMailDataRn.TABLE_NAME)
@IdClass(value=PKZT_DirectMailDataRn.class)
public abstract class GenZT_DirectMailDataRn extends AbstractExDBEntityForZDB<ZT_DirectMailDataRn, PKZT_DirectMailDataRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DirectMailDataRn";
    public static final String ZRNHOKENKBNNYS           = "zrnhokenkbnnys";
    public static final String ZRNSAKUINMEINONYS        = "zrnsakuinmeinonys";
    public static final String ZRNSYAINNM               = "zrnsyainnm";
    public static final String ZRNSYAINSEIYMD           = "zrnsyainseiymd";
    public static final String ZRNKANJISYAINNM          = "zrnkanjisyainnm";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNNAIMITUREIGAIHYJ      = "zrnnaimitureigaihyj";
    public static final String ZRNDRTENHYJ              = "zrndrtenhyj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKANJITSINKAIADR       = "zrnkanjitsinkaiadr";
    public static final String ZRNSOUHUHUNOUKBN         = "zrnsouhuhunoukbn";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNHKNNM                 = "zrnhknnm";
    public static final String ZRNNENHOUSIKI            = "zrnnenhousiki";
    public static final String ZRNKZKTRKARIHYJ          = "zrnkzktrkarihyj";
    public static final String ZRNAATKIOYBSYDRTENCD     = "zrnaatkioybsydrtencd";
    public static final String ZRNBATKIOYBSYDRTENCD     = "zrnbatkioybsydrtencd";
    public static final String ZRNYOBIV250X1            = "zrnyobiv250x1";
    public static final String ZRNYOBIV250X2            = "zrnyobiv250x2";
    public static final String ZRNYOBIV250X3            = "zrnyobiv250x3";
    public static final String ZRNYOBIV250X4            = "zrnyobiv250x4";
    public static final String ZRNYOBIV250X5            = "zrnyobiv250x5";
    public static final String ZRNYOBIV250X6            = "zrnyobiv250x6";
    public static final String ZRNYOBIV250X7            = "zrnyobiv250x7";
    public static final String ZRNYOBIV250X8            = "zrnyobiv250x8";
    public static final String ZRNYOBIV250X9            = "zrnyobiv250x9";
    public static final String ZRNYOBIV250X10           = "zrnyobiv250x10";
    public static final String ZRNYOBIV250X11           = "zrnyobiv250x11";
    public static final String ZRNYOBIV250X12           = "zrnyobiv250x12";
    public static final String ZRNYOBIV250X13           = "zrnyobiv250x13";
    public static final String ZRNYOBIV250X14           = "zrnyobiv250x14";
    public static final String ZRNYOBIV122              = "zrnyobiv122";

    private final PKZT_DirectMailDataRn primaryKey;

    public GenZT_DirectMailDataRn() {
        primaryKey = new PKZT_DirectMailDataRn();
    }

    public GenZT_DirectMailDataRn(String pZrnsyono) {
        primaryKey = new PKZT_DirectMailDataRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_DirectMailDataRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DirectMailDataRn> getMetaClass() {
        return QZT_DirectMailDataRn.class;
    }

    private String zrnhokenkbnnys;

    @Column(name=GenZT_DirectMailDataRn.ZRNHOKENKBNNYS)
    public String getZrnhokenkbnnys() {
        return zrnhokenkbnnys;
    }

    public void setZrnhokenkbnnys(String pZrnhokenkbnnys) {
        zrnhokenkbnnys = pZrnhokenkbnnys;
    }

    private String zrnsakuinmeinonys;

    @Column(name=GenZT_DirectMailDataRn.ZRNSAKUINMEINONYS)
    public String getZrnsakuinmeinonys() {
        return zrnsakuinmeinonys;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsakuinmeinonys(String pZrnsakuinmeinonys) {
        zrnsakuinmeinonys = pZrnsakuinmeinonys;
    }

    private String zrnsyainnm;

    @Column(name=GenZT_DirectMailDataRn.ZRNSYAINNM)
    public String getZrnsyainnm() {
        return zrnsyainnm;
    }

    public void setZrnsyainnm(String pZrnsyainnm) {
        zrnsyainnm = pZrnsyainnm;
    }

    private String zrnsyainseiymd;

    @Column(name=GenZT_DirectMailDataRn.ZRNSYAINSEIYMD)
    public String getZrnsyainseiymd() {
        return zrnsyainseiymd;
    }

    public void setZrnsyainseiymd(String pZrnsyainseiymd) {
        zrnsyainseiymd = pZrnsyainseiymd;
    }

    private String zrnkanjisyainnm;

    @Column(name=GenZT_DirectMailDataRn.ZRNKANJISYAINNM)
    public String getZrnkanjisyainnm() {
        return zrnkanjisyainnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjisyainnm(String pZrnkanjisyainnm) {
        zrnkanjisyainnm = pZrnkanjisyainnm;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_DirectMailDataRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnnaimitureigaihyj;

    @Column(name=GenZT_DirectMailDataRn.ZRNNAIMITUREIGAIHYJ)
    public String getZrnnaimitureigaihyj() {
        return zrnnaimitureigaihyj;
    }

    public void setZrnnaimitureigaihyj(String pZrnnaimitureigaihyj) {
        zrnnaimitureigaihyj = pZrnnaimitureigaihyj;
    }

    private String zrndrtenhyj;

    @Column(name=GenZT_DirectMailDataRn.ZRNDRTENHYJ)
    public String getZrndrtenhyj() {
        return zrndrtenhyj;
    }

    public void setZrndrtenhyj(String pZrndrtenhyj) {
        zrndrtenhyj = pZrndrtenhyj;
    }

    @Id
    @Column(name=GenZT_DirectMailDataRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnkanjitsinkaiadr;

    @Column(name=GenZT_DirectMailDataRn.ZRNKANJITSINKAIADR)
    public String getZrnkanjitsinkaiadr() {
        return zrnkanjitsinkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitsinkaiadr(String pZrnkanjitsinkaiadr) {
        zrnkanjitsinkaiadr = pZrnkanjitsinkaiadr;
    }

    private String zrnsouhuhunoukbn;

    @Column(name=GenZT_DirectMailDataRn.ZRNSOUHUHUNOUKBN)
    public String getZrnsouhuhunoukbn() {
        return zrnsouhuhunoukbn;
    }

    public void setZrnsouhuhunoukbn(String pZrnsouhuhunoukbn) {
        zrnsouhuhunoukbn = pZrnsouhuhunoukbn;
    }

    private String zrnbsyym;

    @Column(name=GenZT_DirectMailDataRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnhknnm;

    @Column(name=GenZT_DirectMailDataRn.ZRNHKNNM)
    public String getZrnhknnm() {
        return zrnhknnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknnm(String pZrnhknnm) {
        zrnhknnm = pZrnhknnm;
    }

    private String zrnnenhousiki;

    @Column(name=GenZT_DirectMailDataRn.ZRNNENHOUSIKI)
    public String getZrnnenhousiki() {
        return zrnnenhousiki;
    }

    public void setZrnnenhousiki(String pZrnnenhousiki) {
        zrnnenhousiki = pZrnnenhousiki;
    }

    private String zrnkzktrkarihyj;

    @Column(name=GenZT_DirectMailDataRn.ZRNKZKTRKARIHYJ)
    public String getZrnkzktrkarihyj() {
        return zrnkzktrkarihyj;
    }

    public void setZrnkzktrkarihyj(String pZrnkzktrkarihyj) {
        zrnkzktrkarihyj = pZrnkzktrkarihyj;
    }

    private String zrnaatkioybsydrtencd;

    @Column(name=GenZT_DirectMailDataRn.ZRNAATKIOYBSYDRTENCD)
    public String getZrnaatkioybsydrtencd() {
        return zrnaatkioybsydrtencd;
    }

    public void setZrnaatkioybsydrtencd(String pZrnaatkioybsydrtencd) {
        zrnaatkioybsydrtencd = pZrnaatkioybsydrtencd;
    }

    private String zrnbatkioybsydrtencd;

    @Column(name=GenZT_DirectMailDataRn.ZRNBATKIOYBSYDRTENCD)
    public String getZrnbatkioybsydrtencd() {
        return zrnbatkioybsydrtencd;
    }

    public void setZrnbatkioybsydrtencd(String pZrnbatkioybsydrtencd) {
        zrnbatkioybsydrtencd = pZrnbatkioybsydrtencd;
    }

    private String zrnyobiv250x1;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X1)
    public String getZrnyobiv250x1() {
        return zrnyobiv250x1;
    }

    public void setZrnyobiv250x1(String pZrnyobiv250x1) {
        zrnyobiv250x1 = pZrnyobiv250x1;
    }

    private String zrnyobiv250x2;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X2)
    public String getZrnyobiv250x2() {
        return zrnyobiv250x2;
    }

    public void setZrnyobiv250x2(String pZrnyobiv250x2) {
        zrnyobiv250x2 = pZrnyobiv250x2;
    }

    private String zrnyobiv250x3;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X3)
    public String getZrnyobiv250x3() {
        return zrnyobiv250x3;
    }

    public void setZrnyobiv250x3(String pZrnyobiv250x3) {
        zrnyobiv250x3 = pZrnyobiv250x3;
    }

    private String zrnyobiv250x4;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X4)
    public String getZrnyobiv250x4() {
        return zrnyobiv250x4;
    }

    public void setZrnyobiv250x4(String pZrnyobiv250x4) {
        zrnyobiv250x4 = pZrnyobiv250x4;
    }

    private String zrnyobiv250x5;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X5)
    public String getZrnyobiv250x5() {
        return zrnyobiv250x5;
    }

    public void setZrnyobiv250x5(String pZrnyobiv250x5) {
        zrnyobiv250x5 = pZrnyobiv250x5;
    }

    private String zrnyobiv250x6;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X6)
    public String getZrnyobiv250x6() {
        return zrnyobiv250x6;
    }

    public void setZrnyobiv250x6(String pZrnyobiv250x6) {
        zrnyobiv250x6 = pZrnyobiv250x6;
    }

    private String zrnyobiv250x7;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X7)
    public String getZrnyobiv250x7() {
        return zrnyobiv250x7;
    }

    public void setZrnyobiv250x7(String pZrnyobiv250x7) {
        zrnyobiv250x7 = pZrnyobiv250x7;
    }

    private String zrnyobiv250x8;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X8)
    public String getZrnyobiv250x8() {
        return zrnyobiv250x8;
    }

    public void setZrnyobiv250x8(String pZrnyobiv250x8) {
        zrnyobiv250x8 = pZrnyobiv250x8;
    }

    private String zrnyobiv250x9;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X9)
    public String getZrnyobiv250x9() {
        return zrnyobiv250x9;
    }

    public void setZrnyobiv250x9(String pZrnyobiv250x9) {
        zrnyobiv250x9 = pZrnyobiv250x9;
    }

    private String zrnyobiv250x10;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X10)
    public String getZrnyobiv250x10() {
        return zrnyobiv250x10;
    }

    public void setZrnyobiv250x10(String pZrnyobiv250x10) {
        zrnyobiv250x10 = pZrnyobiv250x10;
    }

    private String zrnyobiv250x11;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X11)
    public String getZrnyobiv250x11() {
        return zrnyobiv250x11;
    }

    public void setZrnyobiv250x11(String pZrnyobiv250x11) {
        zrnyobiv250x11 = pZrnyobiv250x11;
    }

    private String zrnyobiv250x12;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X12)
    public String getZrnyobiv250x12() {
        return zrnyobiv250x12;
    }

    public void setZrnyobiv250x12(String pZrnyobiv250x12) {
        zrnyobiv250x12 = pZrnyobiv250x12;
    }

    private String zrnyobiv250x13;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X13)
    public String getZrnyobiv250x13() {
        return zrnyobiv250x13;
    }

    public void setZrnyobiv250x13(String pZrnyobiv250x13) {
        zrnyobiv250x13 = pZrnyobiv250x13;
    }

    private String zrnyobiv250x14;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV250X14)
    public String getZrnyobiv250x14() {
        return zrnyobiv250x14;
    }

    public void setZrnyobiv250x14(String pZrnyobiv250x14) {
        zrnyobiv250x14 = pZrnyobiv250x14;
    }

    private String zrnyobiv122;

    @Column(name=GenZT_DirectMailDataRn.ZRNYOBIV122)
    public String getZrnyobiv122() {
        return zrnyobiv122;
    }

    public void setZrnyobiv122(String pZrnyobiv122) {
        zrnyobiv122 = pZrnyobiv122;
    }
}