package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SinninTouhyouTy;
import yuyu.def.db.id.PKZT_SinninTouhyouTy;
import yuyu.def.db.meta.GenQZT_SinninTouhyouTy;
import yuyu.def.db.meta.QZT_SinninTouhyouTy;

/**
 * 信任投票データテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SinninTouhyouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinninTouhyouTy}</td><td colspan="3">信任投票データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyhokenkbn ztyhokenkbn}</td><td>（中継用）保険区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknaiyoukbn ztykyknaiyoukbn}</td><td>（中継用）契約内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenkbnnys ztyhokenkbnnys}</td><td>（中継用）保険区分（名寄せ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuinmeinonys ztysakuinmeinonys}</td><td>（中継用）索引名番号（名寄せ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainnm ztysyainnm}</td><td>（中継用）社員名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjisyainnm ztykanjisyainnm}</td><td>（中継用）漢字社員名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyainseiymd ztysyainseiymd}</td><td>（中継用）社員生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SinninTouhyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysouhuhunoukbn ztysouhuhunoukbn}</td><td>（中継用）送付不能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaimitureigaihyj ztynaimitureigaihyj}</td><td>（中継用）内密例外表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuukinsisya ztysyuukinsisya}</td><td>（中継用）集金支社</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuukintntusycd ztysyuukintntusycd}</td><td>（中継用）集金担当者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyokyakusamano ztyokyakusamano}</td><td>（中継用）お客様番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaibukojincd ztynaibukojincd}</td><td>（中継用）内部個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenkbnsyainno ztyhokenkbnsyainno}</td><td>（中継用）保険区分（社員ＮＯ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuinmeinosyainno ztysakuinmeinosyainno}</td><td>（中継用）索引名番号（社員ＮＯ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyprivacyhogoyouhyj ztyprivacyhogoyouhyj}</td><td>（中継用）プライバシー保護要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigaitokoukykhyj ztykaigaitokoukykhyj}</td><td>（中継用）海外渡航契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaibukbn ztynaibukbn}</td><td>（中継用）内部区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktsnatkitkyktrkjtkbn ztykyktsnatkitkyktrkjtkbn}</td><td>（中継用）契約通算扱特約登録状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalcardhkkbn ztyalcardhkkbn}</td><td>（中継用）ＡＬカード発行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkbn ztybsydrtenkbn}</td><td>（中継用）募集代理店区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitkaiinno ztyvitkaiinno}</td><td>（中継用）Ｖｉｔ会員番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv60 ztyyobiv60}</td><td>（中継用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinninTouhyouTy
 * @see     PKZT_SinninTouhyouTy
 * @see     QZT_SinninTouhyouTy
 * @see     GenQZT_SinninTouhyouTy
 */
@MappedSuperclass
@Table(name=GenZT_SinninTouhyouTy.TABLE_NAME)
@IdClass(value=PKZT_SinninTouhyouTy.class)
public abstract class GenZT_SinninTouhyouTy extends AbstractExDBEntity<ZT_SinninTouhyouTy, PKZT_SinninTouhyouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinninTouhyouTy";
    public static final String ZTYHOKENKBN              = "ztyhokenkbn";
    public static final String ZTYKYKNAIYOUKBN          = "ztykyknaiyoukbn";
    public static final String ZTYHOKENKBNNYS           = "ztyhokenkbnnys";
    public static final String ZTYSAKUINMEINONYS        = "ztysakuinmeinonys";
    public static final String ZTYSYAINNM               = "ztysyainnm";
    public static final String ZTYKANJISYAINNM          = "ztykanjisyainnm";
    public static final String ZTYSYAINSEIYMD           = "ztysyainseiymd";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYSOUHUHUNOUKBN         = "ztysouhuhunoukbn";
    public static final String ZTYNAIMITUREIGAIHYJ      = "ztynaimitureigaihyj";
    public static final String ZTYSYUUKINSISYA          = "ztysyuukinsisya";
    public static final String ZTYSYUUKINTNTUSYCD       = "ztysyuukintntusycd";
    public static final String ZTYOKYAKUSAMANO          = "ztyokyakusamano";
    public static final String ZTYNAIBUKOJINCD          = "ztynaibukojincd";
    public static final String ZTYHOKENKBNSYAINNO       = "ztyhokenkbnsyainno";
    public static final String ZTYSAKUINMEINOSYAINNO    = "ztysakuinmeinosyainno";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYPRIVACYHOGOYOUHYJ     = "ztyprivacyhogoyouhyj";
    public static final String ZTYKAIGAITOKOUKYKHYJ     = "ztykaigaitokoukykhyj";
    public static final String ZTYNAIBUKBN              = "ztynaibukbn";
    public static final String ZTYKYKTSNATKITKYKTRKJTKBN = "ztykyktsnatkitkyktrkjtkbn";
    public static final String ZTYALCARDHKKBN           = "ztyalcardhkkbn";
    public static final String ZTYBSYDRTENKBN           = "ztybsydrtenkbn";
    public static final String ZTYVITKAIINNO            = "ztyvitkaiinno";
    public static final String ZTYYOBIV60               = "ztyyobiv60";

    private final PKZT_SinninTouhyouTy primaryKey;

    public GenZT_SinninTouhyouTy() {
        primaryKey = new PKZT_SinninTouhyouTy();
    }

    public GenZT_SinninTouhyouTy(String pZtysyono) {
        primaryKey = new PKZT_SinninTouhyouTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SinninTouhyouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinninTouhyouTy> getMetaClass() {
        return QZT_SinninTouhyouTy.class;
    }

    private String ztyhokenkbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYHOKENKBN)
    public String getZtyhokenkbn() {
        return ztyhokenkbn;
    }

    public void setZtyhokenkbn(String pZtyhokenkbn) {
        ztyhokenkbn = pZtyhokenkbn;
    }

    private String ztykyknaiyoukbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYKYKNAIYOUKBN)
    public String getZtykyknaiyoukbn() {
        return ztykyknaiyoukbn;
    }

    public void setZtykyknaiyoukbn(String pZtykyknaiyoukbn) {
        ztykyknaiyoukbn = pZtykyknaiyoukbn;
    }

    private String ztyhokenkbnnys;

    @Column(name=GenZT_SinninTouhyouTy.ZTYHOKENKBNNYS)
    public String getZtyhokenkbnnys() {
        return ztyhokenkbnnys;
    }

    public void setZtyhokenkbnnys(String pZtyhokenkbnnys) {
        ztyhokenkbnnys = pZtyhokenkbnnys;
    }

    private String ztysakuinmeinonys;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSAKUINMEINONYS)
    public String getZtysakuinmeinonys() {
        return ztysakuinmeinonys;
    }

    public void setZtysakuinmeinonys(String pZtysakuinmeinonys) {
        ztysakuinmeinonys = pZtysakuinmeinonys;
    }

    private String ztysyainnm;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSYAINNM)
    public String getZtysyainnm() {
        return ztysyainnm;
    }

    public void setZtysyainnm(String pZtysyainnm) {
        ztysyainnm = pZtysyainnm;
    }

    private String ztykanjisyainnm;

    @Column(name=GenZT_SinninTouhyouTy.ZTYKANJISYAINNM)
    public String getZtykanjisyainnm() {
        return ztykanjisyainnm;
    }

    public void setZtykanjisyainnm(String pZtykanjisyainnm) {
        ztykanjisyainnm = pZtykanjisyainnm;
    }

    private String ztysyainseiymd;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSYAINSEIYMD)
    public String getZtysyainseiymd() {
        return ztysyainseiymd;
    }

    public void setZtysyainseiymd(String pZtysyainseiymd) {
        ztysyainseiymd = pZtysyainseiymd;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_SinninTouhyouTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_SinninTouhyouTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    @Id
    @Column(name=GenZT_SinninTouhyouTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztysouhuhunoukbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSOUHUHUNOUKBN)
    public String getZtysouhuhunoukbn() {
        return ztysouhuhunoukbn;
    }

    public void setZtysouhuhunoukbn(String pZtysouhuhunoukbn) {
        ztysouhuhunoukbn = pZtysouhuhunoukbn;
    }

    private String ztynaimitureigaihyj;

    @Column(name=GenZT_SinninTouhyouTy.ZTYNAIMITUREIGAIHYJ)
    public String getZtynaimitureigaihyj() {
        return ztynaimitureigaihyj;
    }

    public void setZtynaimitureigaihyj(String pZtynaimitureigaihyj) {
        ztynaimitureigaihyj = pZtynaimitureigaihyj;
    }

    private String ztysyuukinsisya;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSYUUKINSISYA)
    public String getZtysyuukinsisya() {
        return ztysyuukinsisya;
    }

    public void setZtysyuukinsisya(String pZtysyuukinsisya) {
        ztysyuukinsisya = pZtysyuukinsisya;
    }

    private String ztysyuukintntusycd;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSYUUKINTNTUSYCD)
    public String getZtysyuukintntusycd() {
        return ztysyuukintntusycd;
    }

    public void setZtysyuukintntusycd(String pZtysyuukintntusycd) {
        ztysyuukintntusycd = pZtysyuukintntusycd;
    }

    private String ztyokyakusamano;

    @Column(name=GenZT_SinninTouhyouTy.ZTYOKYAKUSAMANO)
    public String getZtyokyakusamano() {
        return ztyokyakusamano;
    }

    public void setZtyokyakusamano(String pZtyokyakusamano) {
        ztyokyakusamano = pZtyokyakusamano;
    }

    private String ztynaibukojincd;

    @Column(name=GenZT_SinninTouhyouTy.ZTYNAIBUKOJINCD)
    public String getZtynaibukojincd() {
        return ztynaibukojincd;
    }

    public void setZtynaibukojincd(String pZtynaibukojincd) {
        ztynaibukojincd = pZtynaibukojincd;
    }

    private String ztyhokenkbnsyainno;

    @Column(name=GenZT_SinninTouhyouTy.ZTYHOKENKBNSYAINNO)
    public String getZtyhokenkbnsyainno() {
        return ztyhokenkbnsyainno;
    }

    public void setZtyhokenkbnsyainno(String pZtyhokenkbnsyainno) {
        ztyhokenkbnsyainno = pZtyhokenkbnsyainno;
    }

    private String ztysakuinmeinosyainno;

    @Column(name=GenZT_SinninTouhyouTy.ZTYSAKUINMEINOSYAINNO)
    public String getZtysakuinmeinosyainno() {
        return ztysakuinmeinosyainno;
    }

    public void setZtysakuinmeinosyainno(String pZtysakuinmeinosyainno) {
        ztysakuinmeinosyainno = pZtysakuinmeinosyainno;
    }

    private String ztybsyym;

    @Column(name=GenZT_SinninTouhyouTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyprivacyhogoyouhyj;

    @Column(name=GenZT_SinninTouhyouTy.ZTYPRIVACYHOGOYOUHYJ)
    public String getZtyprivacyhogoyouhyj() {
        return ztyprivacyhogoyouhyj;
    }

    public void setZtyprivacyhogoyouhyj(String pZtyprivacyhogoyouhyj) {
        ztyprivacyhogoyouhyj = pZtyprivacyhogoyouhyj;
    }

    private String ztykaigaitokoukykhyj;

    @Column(name=GenZT_SinninTouhyouTy.ZTYKAIGAITOKOUKYKHYJ)
    public String getZtykaigaitokoukykhyj() {
        return ztykaigaitokoukykhyj;
    }

    public void setZtykaigaitokoukykhyj(String pZtykaigaitokoukykhyj) {
        ztykaigaitokoukykhyj = pZtykaigaitokoukykhyj;
    }

    private String ztynaibukbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYNAIBUKBN)
    public String getZtynaibukbn() {
        return ztynaibukbn;
    }

    public void setZtynaibukbn(String pZtynaibukbn) {
        ztynaibukbn = pZtynaibukbn;
    }

    private String ztykyktsnatkitkyktrkjtkbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYKYKTSNATKITKYKTRKJTKBN)
    public String getZtykyktsnatkitkyktrkjtkbn() {
        return ztykyktsnatkitkyktrkjtkbn;
    }

    public void setZtykyktsnatkitkyktrkjtkbn(String pZtykyktsnatkitkyktrkjtkbn) {
        ztykyktsnatkitkyktrkjtkbn = pZtykyktsnatkitkyktrkjtkbn;
    }

    private String ztyalcardhkkbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYALCARDHKKBN)
    public String getZtyalcardhkkbn() {
        return ztyalcardhkkbn;
    }

    public void setZtyalcardhkkbn(String pZtyalcardhkkbn) {
        ztyalcardhkkbn = pZtyalcardhkkbn;
    }

    private String ztybsydrtenkbn;

    @Column(name=GenZT_SinninTouhyouTy.ZTYBSYDRTENKBN)
    public String getZtybsydrtenkbn() {
        return ztybsydrtenkbn;
    }

    public void setZtybsydrtenkbn(String pZtybsydrtenkbn) {
        ztybsydrtenkbn = pZtybsydrtenkbn;
    }

    private String ztyvitkaiinno;

    @Column(name=GenZT_SinninTouhyouTy.ZTYVITKAIINNO)
    public String getZtyvitkaiinno() {
        return ztyvitkaiinno;
    }

    public void setZtyvitkaiinno(String pZtyvitkaiinno) {
        ztyvitkaiinno = pZtyvitkaiinno;
    }

    private String ztyyobiv60;

    @Column(name=GenZT_SinninTouhyouTy.ZTYYOBIV60)
    public String getZtyyobiv60() {
        return ztyyobiv60;
    }

    public void setZtyyobiv60(String pZtyyobiv60) {
        ztyyobiv60 = pZtyyobiv60;
    }
}