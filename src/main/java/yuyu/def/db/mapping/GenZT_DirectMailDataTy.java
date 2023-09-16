package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DirectMailDataTy;
import yuyu.def.db.id.PKZT_DirectMailDataTy;
import yuyu.def.db.meta.GenQZT_DirectMailDataTy;
import yuyu.def.db.meta.QZT_DirectMailDataTy;

/**
 * ダイレクトメールデータテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DirectMailDataTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DirectMailDataTy}</td><td colspan="3">ダイレクトメールデータテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyhokenkbnnys ztyhokenkbnnys}</td><td>（中継用）保険区分（名寄せ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuinmeinonys ztysakuinmeinonys}</td><td>（中継用）索引名番号（名寄せ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainnm ztysyainnm}</td><td>（中継用）社員名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainseiymd ztysyainseiymd}</td><td>（中継用）社員生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjisyainnm ztykanjisyainnm}</td><td>（中継用）漢字社員名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaimitureigaihyj ztynaimitureigaihyj}</td><td>（中継用）内密例外表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtenhyj ztydrtenhyj}</td><td>（中継用）代理店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DirectMailDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysouhuhunoukbn ztysouhuhunoukbn}</td><td>（中継用）送付不能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknnm ztyhknnm}</td><td>（中継用）保険名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenhousiki ztynenhousiki}</td><td>（中継用）年齢方式</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkarihyj ztykzktrkarihyj}</td><td>（中継用）ご家族登録有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatkioybsydrtencd ztyaatkioybsydrtencd}</td><td>（中継用）Ａ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkioybsydrtencd ztybatkioybsydrtencd}</td><td>（中継用）Ｂ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x1 ztyyobiv250x1}</td><td>（中継用）予備項目Ｖ２５０＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x2 ztyyobiv250x2}</td><td>（中継用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x3 ztyyobiv250x3}</td><td>（中継用）予備項目Ｖ２５０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x4 ztyyobiv250x4}</td><td>（中継用）予備項目Ｖ２５０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x5 ztyyobiv250x5}</td><td>（中継用）予備項目Ｖ２５０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x6 ztyyobiv250x6}</td><td>（中継用）予備項目Ｖ２５０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x7 ztyyobiv250x7}</td><td>（中継用）予備項目Ｖ２５０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x8 ztyyobiv250x8}</td><td>（中継用）予備項目Ｖ２５０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x9 ztyyobiv250x9}</td><td>（中継用）予備項目Ｖ２５０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x10 ztyyobiv250x10}</td><td>（中継用）予備項目Ｖ２５０＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x11 ztyyobiv250x11}</td><td>（中継用）予備項目Ｖ２５０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x12 ztyyobiv250x12}</td><td>（中継用）予備項目Ｖ２５０＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x13 ztyyobiv250x13}</td><td>（中継用）予備項目Ｖ２５０＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x14 ztyyobiv250x14}</td><td>（中継用）予備項目Ｖ２５０＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv122 ztyyobiv122}</td><td>（中継用）予備項目Ｖ１２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DirectMailDataTy
 * @see     PKZT_DirectMailDataTy
 * @see     QZT_DirectMailDataTy
 * @see     GenQZT_DirectMailDataTy
 */
@MappedSuperclass
@Table(name=GenZT_DirectMailDataTy.TABLE_NAME)
@IdClass(value=PKZT_DirectMailDataTy.class)
public abstract class GenZT_DirectMailDataTy extends AbstractExDBEntity<ZT_DirectMailDataTy, PKZT_DirectMailDataTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DirectMailDataTy";
    public static final String ZTYHOKENKBNNYS           = "ztyhokenkbnnys";
    public static final String ZTYSAKUINMEINONYS        = "ztysakuinmeinonys";
    public static final String ZTYSYAINNM               = "ztysyainnm";
    public static final String ZTYSYAINSEIYMD           = "ztysyainseiymd";
    public static final String ZTYKANJISYAINNM          = "ztykanjisyainnm";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYNAIMITUREIGAIHYJ      = "ztynaimitureigaihyj";
    public static final String ZTYDRTENHYJ              = "ztydrtenhyj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYSOUHUHUNOUKBN         = "ztysouhuhunoukbn";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYHKNNM                 = "ztyhknnm";
    public static final String ZTYNENHOUSIKI            = "ztynenhousiki";
    public static final String ZTYKZKTRKARIHYJ          = "ztykzktrkarihyj";
    public static final String ZTYAATKIOYBSYDRTENCD     = "ztyaatkioybsydrtencd";
    public static final String ZTYBATKIOYBSYDRTENCD     = "ztybatkioybsydrtencd";
    public static final String ZTYYOBIV250X1            = "ztyyobiv250x1";
    public static final String ZTYYOBIV250X2            = "ztyyobiv250x2";
    public static final String ZTYYOBIV250X3            = "ztyyobiv250x3";
    public static final String ZTYYOBIV250X4            = "ztyyobiv250x4";
    public static final String ZTYYOBIV250X5            = "ztyyobiv250x5";
    public static final String ZTYYOBIV250X6            = "ztyyobiv250x6";
    public static final String ZTYYOBIV250X7            = "ztyyobiv250x7";
    public static final String ZTYYOBIV250X8            = "ztyyobiv250x8";
    public static final String ZTYYOBIV250X9            = "ztyyobiv250x9";
    public static final String ZTYYOBIV250X10           = "ztyyobiv250x10";
    public static final String ZTYYOBIV250X11           = "ztyyobiv250x11";
    public static final String ZTYYOBIV250X12           = "ztyyobiv250x12";
    public static final String ZTYYOBIV250X13           = "ztyyobiv250x13";
    public static final String ZTYYOBIV250X14           = "ztyyobiv250x14";
    public static final String ZTYYOBIV122              = "ztyyobiv122";

    private final PKZT_DirectMailDataTy primaryKey;

    public GenZT_DirectMailDataTy() {
        primaryKey = new PKZT_DirectMailDataTy();
    }

    public GenZT_DirectMailDataTy(String pZtysyono) {
        primaryKey = new PKZT_DirectMailDataTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_DirectMailDataTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DirectMailDataTy> getMetaClass() {
        return QZT_DirectMailDataTy.class;
    }

    private String ztyhokenkbnnys;

    @Column(name=GenZT_DirectMailDataTy.ZTYHOKENKBNNYS)
    public String getZtyhokenkbnnys() {
        return ztyhokenkbnnys;
    }

    public void setZtyhokenkbnnys(String pZtyhokenkbnnys) {
        ztyhokenkbnnys = pZtyhokenkbnnys;
    }

    private String ztysakuinmeinonys;

    @Column(name=GenZT_DirectMailDataTy.ZTYSAKUINMEINONYS)
    public String getZtysakuinmeinonys() {
        return ztysakuinmeinonys;
    }

    public void setZtysakuinmeinonys(String pZtysakuinmeinonys) {
        ztysakuinmeinonys = pZtysakuinmeinonys;
    }

    private String ztysyainnm;

    @Column(name=GenZT_DirectMailDataTy.ZTYSYAINNM)
    public String getZtysyainnm() {
        return ztysyainnm;
    }

    public void setZtysyainnm(String pZtysyainnm) {
        ztysyainnm = pZtysyainnm;
    }

    private String ztysyainseiymd;

    @Column(name=GenZT_DirectMailDataTy.ZTYSYAINSEIYMD)
    public String getZtysyainseiymd() {
        return ztysyainseiymd;
    }

    public void setZtysyainseiymd(String pZtysyainseiymd) {
        ztysyainseiymd = pZtysyainseiymd;
    }

    private String ztykanjisyainnm;

    @Column(name=GenZT_DirectMailDataTy.ZTYKANJISYAINNM)
    public String getZtykanjisyainnm() {
        return ztykanjisyainnm;
    }

    public void setZtykanjisyainnm(String pZtykanjisyainnm) {
        ztykanjisyainnm = pZtykanjisyainnm;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_DirectMailDataTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztynaimitureigaihyj;

    @Column(name=GenZT_DirectMailDataTy.ZTYNAIMITUREIGAIHYJ)
    public String getZtynaimitureigaihyj() {
        return ztynaimitureigaihyj;
    }

    public void setZtynaimitureigaihyj(String pZtynaimitureigaihyj) {
        ztynaimitureigaihyj = pZtynaimitureigaihyj;
    }

    private String ztydrtenhyj;

    @Column(name=GenZT_DirectMailDataTy.ZTYDRTENHYJ)
    public String getZtydrtenhyj() {
        return ztydrtenhyj;
    }

    public void setZtydrtenhyj(String pZtydrtenhyj) {
        ztydrtenhyj = pZtydrtenhyj;
    }

    @Id
    @Column(name=GenZT_DirectMailDataTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_DirectMailDataTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    private String ztysouhuhunoukbn;

    @Column(name=GenZT_DirectMailDataTy.ZTYSOUHUHUNOUKBN)
    public String getZtysouhuhunoukbn() {
        return ztysouhuhunoukbn;
    }

    public void setZtysouhuhunoukbn(String pZtysouhuhunoukbn) {
        ztysouhuhunoukbn = pZtysouhuhunoukbn;
    }

    private String ztybsyym;

    @Column(name=GenZT_DirectMailDataTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyhknnm;

    @Column(name=GenZT_DirectMailDataTy.ZTYHKNNM)
    public String getZtyhknnm() {
        return ztyhknnm;
    }

    public void setZtyhknnm(String pZtyhknnm) {
        ztyhknnm = pZtyhknnm;
    }

    private String ztynenhousiki;

    @Column(name=GenZT_DirectMailDataTy.ZTYNENHOUSIKI)
    public String getZtynenhousiki() {
        return ztynenhousiki;
    }

    public void setZtynenhousiki(String pZtynenhousiki) {
        ztynenhousiki = pZtynenhousiki;
    }

    private String ztykzktrkarihyj;

    @Column(name=GenZT_DirectMailDataTy.ZTYKZKTRKARIHYJ)
    public String getZtykzktrkarihyj() {
        return ztykzktrkarihyj;
    }

    public void setZtykzktrkarihyj(String pZtykzktrkarihyj) {
        ztykzktrkarihyj = pZtykzktrkarihyj;
    }

    private String ztyaatkioybsydrtencd;

    @Column(name=GenZT_DirectMailDataTy.ZTYAATKIOYBSYDRTENCD)
    public String getZtyaatkioybsydrtencd() {
        return ztyaatkioybsydrtencd;
    }

    public void setZtyaatkioybsydrtencd(String pZtyaatkioybsydrtencd) {
        ztyaatkioybsydrtencd = pZtyaatkioybsydrtencd;
    }

    private String ztybatkioybsydrtencd;

    @Column(name=GenZT_DirectMailDataTy.ZTYBATKIOYBSYDRTENCD)
    public String getZtybatkioybsydrtencd() {
        return ztybatkioybsydrtencd;
    }

    public void setZtybatkioybsydrtencd(String pZtybatkioybsydrtencd) {
        ztybatkioybsydrtencd = pZtybatkioybsydrtencd;
    }

    private String ztyyobiv250x1;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X1)
    public String getZtyyobiv250x1() {
        return ztyyobiv250x1;
    }

    public void setZtyyobiv250x1(String pZtyyobiv250x1) {
        ztyyobiv250x1 = pZtyyobiv250x1;
    }

    private String ztyyobiv250x2;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X2)
    public String getZtyyobiv250x2() {
        return ztyyobiv250x2;
    }

    public void setZtyyobiv250x2(String pZtyyobiv250x2) {
        ztyyobiv250x2 = pZtyyobiv250x2;
    }

    private String ztyyobiv250x3;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X3)
    public String getZtyyobiv250x3() {
        return ztyyobiv250x3;
    }

    public void setZtyyobiv250x3(String pZtyyobiv250x3) {
        ztyyobiv250x3 = pZtyyobiv250x3;
    }

    private String ztyyobiv250x4;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X4)
    public String getZtyyobiv250x4() {
        return ztyyobiv250x4;
    }

    public void setZtyyobiv250x4(String pZtyyobiv250x4) {
        ztyyobiv250x4 = pZtyyobiv250x4;
    }

    private String ztyyobiv250x5;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X5)
    public String getZtyyobiv250x5() {
        return ztyyobiv250x5;
    }

    public void setZtyyobiv250x5(String pZtyyobiv250x5) {
        ztyyobiv250x5 = pZtyyobiv250x5;
    }

    private String ztyyobiv250x6;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X6)
    public String getZtyyobiv250x6() {
        return ztyyobiv250x6;
    }

    public void setZtyyobiv250x6(String pZtyyobiv250x6) {
        ztyyobiv250x6 = pZtyyobiv250x6;
    }

    private String ztyyobiv250x7;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X7)
    public String getZtyyobiv250x7() {
        return ztyyobiv250x7;
    }

    public void setZtyyobiv250x7(String pZtyyobiv250x7) {
        ztyyobiv250x7 = pZtyyobiv250x7;
    }

    private String ztyyobiv250x8;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X8)
    public String getZtyyobiv250x8() {
        return ztyyobiv250x8;
    }

    public void setZtyyobiv250x8(String pZtyyobiv250x8) {
        ztyyobiv250x8 = pZtyyobiv250x8;
    }

    private String ztyyobiv250x9;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X9)
    public String getZtyyobiv250x9() {
        return ztyyobiv250x9;
    }

    public void setZtyyobiv250x9(String pZtyyobiv250x9) {
        ztyyobiv250x9 = pZtyyobiv250x9;
    }

    private String ztyyobiv250x10;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X10)
    public String getZtyyobiv250x10() {
        return ztyyobiv250x10;
    }

    public void setZtyyobiv250x10(String pZtyyobiv250x10) {
        ztyyobiv250x10 = pZtyyobiv250x10;
    }

    private String ztyyobiv250x11;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X11)
    public String getZtyyobiv250x11() {
        return ztyyobiv250x11;
    }

    public void setZtyyobiv250x11(String pZtyyobiv250x11) {
        ztyyobiv250x11 = pZtyyobiv250x11;
    }

    private String ztyyobiv250x12;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X12)
    public String getZtyyobiv250x12() {
        return ztyyobiv250x12;
    }

    public void setZtyyobiv250x12(String pZtyyobiv250x12) {
        ztyyobiv250x12 = pZtyyobiv250x12;
    }

    private String ztyyobiv250x13;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X13)
    public String getZtyyobiv250x13() {
        return ztyyobiv250x13;
    }

    public void setZtyyobiv250x13(String pZtyyobiv250x13) {
        ztyyobiv250x13 = pZtyyobiv250x13;
    }

    private String ztyyobiv250x14;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV250X14)
    public String getZtyyobiv250x14() {
        return ztyyobiv250x14;
    }

    public void setZtyyobiv250x14(String pZtyyobiv250x14) {
        ztyyobiv250x14 = pZtyyobiv250x14;
    }

    private String ztyyobiv122;

    @Column(name=GenZT_DirectMailDataTy.ZTYYOBIV122)
    public String getZtyyobiv122() {
        return ztyyobiv122;
    }

    public void setZtyyobiv122(String pZtyyobiv122) {
        ztyyobiv122 = pZtyyobiv122;
    }
}