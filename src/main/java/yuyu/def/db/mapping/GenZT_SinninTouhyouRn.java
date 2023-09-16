package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SinninTouhyouRn;
import yuyu.def.db.id.PKZT_SinninTouhyouRn;
import yuyu.def.db.meta.GenQZT_SinninTouhyouRn;
import yuyu.def.db.meta.QZT_SinninTouhyouRn;

/**
 * 信任投票データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SinninTouhyouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinninTouhyouRn}</td><td colspan="3">信任投票データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhokenkbn zrnhokenkbn}</td><td>（連携用）保険区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknaiyoukbn zrnkyknaiyoukbn}</td><td>（連携用）契約内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenkbnnys zrnhokenkbnnys}</td><td>（連携用）保険区分（名寄せ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuinmeinonys zrnsakuinmeinonys}</td><td>（連携用）索引名番号（名寄せ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainnm zrnsyainnm}</td><td>（連携用）社員名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjisyainnm zrnkanjisyainnm}</td><td>（連携用）漢字社員名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyainseiymd zrnsyainseiymd}</td><td>（連携用）社員生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitsinkaiadr zrnkanjitsinkaiadr}</td><td>（連携用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SinninTouhyouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsouhuhunoukbn zrnsouhuhunoukbn}</td><td>（連携用）送付不能区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaimitureigaihyj zrnnaimitureigaihyj}</td><td>（連携用）内密例外表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuukinsisya zrnsyuukinsisya}</td><td>（連携用）集金支社</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuukintntusycd zrnsyuukintntusycd}</td><td>（連携用）集金担当者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnokyakusamano zrnokyakusamano}</td><td>（連携用）お客様番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaibukojincd zrnnaibukojincd}</td><td>（連携用）内部個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenkbnsyainno zrnhokenkbnsyainno}</td><td>（連携用）保険区分（社員ＮＯ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuinmeinosyainno zrnsakuinmeinosyainno}</td><td>（連携用）索引名番号（社員ＮＯ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnprivacyhogoyouhyj zrnprivacyhogoyouhyj}</td><td>（連携用）プライバシー保護要表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigaitokoukykhyj zrnkaigaitokoukykhyj}</td><td>（連携用）海外渡航契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaibukbn zrnnaibukbn}</td><td>（連携用）内部区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktsnatkitkyktrkjtkbn zrnkyktsnatkitkyktrkjtkbn}</td><td>（連携用）契約通算扱特約登録状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalcardhkkbn zrnalcardhkkbn}</td><td>（連携用）ＡＬカード発行区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkbn zrnbsydrtenkbn}</td><td>（連携用）募集代理店区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvitkaiinno zrnvitkaiinno}</td><td>（連携用）Ｖｉｔ会員番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv60 zrnyobiv60}</td><td>（連携用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinninTouhyouRn
 * @see     PKZT_SinninTouhyouRn
 * @see     QZT_SinninTouhyouRn
 * @see     GenQZT_SinninTouhyouRn
 */
@MappedSuperclass
@Table(name=GenZT_SinninTouhyouRn.TABLE_NAME)
@IdClass(value=PKZT_SinninTouhyouRn.class)
public abstract class GenZT_SinninTouhyouRn extends AbstractExDBEntityForZDB<ZT_SinninTouhyouRn, PKZT_SinninTouhyouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinninTouhyouRn";
    public static final String ZRNHOKENKBN              = "zrnhokenkbn";
    public static final String ZRNKYKNAIYOUKBN          = "zrnkyknaiyoukbn";
    public static final String ZRNHOKENKBNNYS           = "zrnhokenkbnnys";
    public static final String ZRNSAKUINMEINONYS        = "zrnsakuinmeinonys";
    public static final String ZRNSYAINNM               = "zrnsyainnm";
    public static final String ZRNKANJISYAINNM          = "zrnkanjisyainnm";
    public static final String ZRNSYAINSEIYMD           = "zrnsyainseiymd";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNKANJITSINKAIADR       = "zrnkanjitsinkaiadr";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNSOUHUHUNOUKBN         = "zrnsouhuhunoukbn";
    public static final String ZRNNAIMITUREIGAIHYJ      = "zrnnaimitureigaihyj";
    public static final String ZRNSYUUKINSISYA          = "zrnsyuukinsisya";
    public static final String ZRNSYUUKINTNTUSYCD       = "zrnsyuukintntusycd";
    public static final String ZRNOKYAKUSAMANO          = "zrnokyakusamano";
    public static final String ZRNNAIBUKOJINCD          = "zrnnaibukojincd";
    public static final String ZRNHOKENKBNSYAINNO       = "zrnhokenkbnsyainno";
    public static final String ZRNSAKUINMEINOSYAINNO    = "zrnsakuinmeinosyainno";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNPRIVACYHOGOYOUHYJ     = "zrnprivacyhogoyouhyj";
    public static final String ZRNKAIGAITOKOUKYKHYJ     = "zrnkaigaitokoukykhyj";
    public static final String ZRNNAIBUKBN              = "zrnnaibukbn";
    public static final String ZRNKYKTSNATKITKYKTRKJTKBN = "zrnkyktsnatkitkyktrkjtkbn";
    public static final String ZRNALCARDHKKBN           = "zrnalcardhkkbn";
    public static final String ZRNBSYDRTENKBN           = "zrnbsydrtenkbn";
    public static final String ZRNVITKAIINNO            = "zrnvitkaiinno";
    public static final String ZRNYOBIV60               = "zrnyobiv60";

    private final PKZT_SinninTouhyouRn primaryKey;

    public GenZT_SinninTouhyouRn() {
        primaryKey = new PKZT_SinninTouhyouRn();
    }

    public GenZT_SinninTouhyouRn(String pZrnsyono) {
        primaryKey = new PKZT_SinninTouhyouRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SinninTouhyouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinninTouhyouRn> getMetaClass() {
        return QZT_SinninTouhyouRn.class;
    }

    private String zrnhokenkbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNHOKENKBN)
    public String getZrnhokenkbn() {
        return zrnhokenkbn;
    }

    public void setZrnhokenkbn(String pZrnhokenkbn) {
        zrnhokenkbn = pZrnhokenkbn;
    }

    private String zrnkyknaiyoukbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNKYKNAIYOUKBN)
    public String getZrnkyknaiyoukbn() {
        return zrnkyknaiyoukbn;
    }

    public void setZrnkyknaiyoukbn(String pZrnkyknaiyoukbn) {
        zrnkyknaiyoukbn = pZrnkyknaiyoukbn;
    }

    private String zrnhokenkbnnys;

    @Column(name=GenZT_SinninTouhyouRn.ZRNHOKENKBNNYS)
    public String getZrnhokenkbnnys() {
        return zrnhokenkbnnys;
    }

    public void setZrnhokenkbnnys(String pZrnhokenkbnnys) {
        zrnhokenkbnnys = pZrnhokenkbnnys;
    }

    private String zrnsakuinmeinonys;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSAKUINMEINONYS)
    public String getZrnsakuinmeinonys() {
        return zrnsakuinmeinonys;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsakuinmeinonys(String pZrnsakuinmeinonys) {
        zrnsakuinmeinonys = pZrnsakuinmeinonys;
    }

    private String zrnsyainnm;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSYAINNM)
    public String getZrnsyainnm() {
        return zrnsyainnm;
    }

    public void setZrnsyainnm(String pZrnsyainnm) {
        zrnsyainnm = pZrnsyainnm;
    }

    private String zrnkanjisyainnm;

    @Column(name=GenZT_SinninTouhyouRn.ZRNKANJISYAINNM)
    public String getZrnkanjisyainnm() {
        return zrnkanjisyainnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjisyainnm(String pZrnkanjisyainnm) {
        zrnkanjisyainnm = pZrnkanjisyainnm;
    }

    private String zrnsyainseiymd;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSYAINSEIYMD)
    public String getZrnsyainseiymd() {
        return zrnsyainseiymd;
    }

    public void setZrnsyainseiymd(String pZrnsyainseiymd) {
        zrnsyainseiymd = pZrnsyainseiymd;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_SinninTouhyouRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnkanjitsinkaiadr;

    @Column(name=GenZT_SinninTouhyouRn.ZRNKANJITSINKAIADR)
    public String getZrnkanjitsinkaiadr() {
        return zrnkanjitsinkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitsinkaiadr(String pZrnkanjitsinkaiadr) {
        zrnkanjitsinkaiadr = pZrnkanjitsinkaiadr;
    }

    @Id
    @Column(name=GenZT_SinninTouhyouRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrnsouhuhunoukbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSOUHUHUNOUKBN)
    public String getZrnsouhuhunoukbn() {
        return zrnsouhuhunoukbn;
    }

    public void setZrnsouhuhunoukbn(String pZrnsouhuhunoukbn) {
        zrnsouhuhunoukbn = pZrnsouhuhunoukbn;
    }

    private String zrnnaimitureigaihyj;

    @Column(name=GenZT_SinninTouhyouRn.ZRNNAIMITUREIGAIHYJ)
    public String getZrnnaimitureigaihyj() {
        return zrnnaimitureigaihyj;
    }

    public void setZrnnaimitureigaihyj(String pZrnnaimitureigaihyj) {
        zrnnaimitureigaihyj = pZrnnaimitureigaihyj;
    }

    private String zrnsyuukinsisya;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSYUUKINSISYA)
    public String getZrnsyuukinsisya() {
        return zrnsyuukinsisya;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyuukinsisya(String pZrnsyuukinsisya) {
        zrnsyuukinsisya = pZrnsyuukinsisya;
    }

    private String zrnsyuukintntusycd;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSYUUKINTNTUSYCD)
    public String getZrnsyuukintntusycd() {
        return zrnsyuukintntusycd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsyuukintntusycd(String pZrnsyuukintntusycd) {
        zrnsyuukintntusycd = pZrnsyuukintntusycd;
    }

    private String zrnokyakusamano;

    @Column(name=GenZT_SinninTouhyouRn.ZRNOKYAKUSAMANO)
    public String getZrnokyakusamano() {
        return zrnokyakusamano;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnokyakusamano(String pZrnokyakusamano) {
        zrnokyakusamano = pZrnokyakusamano;
    }

    private String zrnnaibukojincd;

    @Column(name=GenZT_SinninTouhyouRn.ZRNNAIBUKOJINCD)
    public String getZrnnaibukojincd() {
        return zrnnaibukojincd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnnaibukojincd(String pZrnnaibukojincd) {
        zrnnaibukojincd = pZrnnaibukojincd;
    }

    private String zrnhokenkbnsyainno;

    @Column(name=GenZT_SinninTouhyouRn.ZRNHOKENKBNSYAINNO)
    public String getZrnhokenkbnsyainno() {
        return zrnhokenkbnsyainno;
    }

    public void setZrnhokenkbnsyainno(String pZrnhokenkbnsyainno) {
        zrnhokenkbnsyainno = pZrnhokenkbnsyainno;
    }

    private String zrnsakuinmeinosyainno;

    @Column(name=GenZT_SinninTouhyouRn.ZRNSAKUINMEINOSYAINNO)
    public String getZrnsakuinmeinosyainno() {
        return zrnsakuinmeinosyainno;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsakuinmeinosyainno(String pZrnsakuinmeinosyainno) {
        zrnsakuinmeinosyainno = pZrnsakuinmeinosyainno;
    }

    private String zrnbsyym;

    @Column(name=GenZT_SinninTouhyouRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnprivacyhogoyouhyj;

    @Column(name=GenZT_SinninTouhyouRn.ZRNPRIVACYHOGOYOUHYJ)
    public String getZrnprivacyhogoyouhyj() {
        return zrnprivacyhogoyouhyj;
    }

    public void setZrnprivacyhogoyouhyj(String pZrnprivacyhogoyouhyj) {
        zrnprivacyhogoyouhyj = pZrnprivacyhogoyouhyj;
    }

    private String zrnkaigaitokoukykhyj;

    @Column(name=GenZT_SinninTouhyouRn.ZRNKAIGAITOKOUKYKHYJ)
    public String getZrnkaigaitokoukykhyj() {
        return zrnkaigaitokoukykhyj;
    }

    public void setZrnkaigaitokoukykhyj(String pZrnkaigaitokoukykhyj) {
        zrnkaigaitokoukykhyj = pZrnkaigaitokoukykhyj;
    }

    private String zrnnaibukbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNNAIBUKBN)
    public String getZrnnaibukbn() {
        return zrnnaibukbn;
    }

    public void setZrnnaibukbn(String pZrnnaibukbn) {
        zrnnaibukbn = pZrnnaibukbn;
    }

    private String zrnkyktsnatkitkyktrkjtkbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNKYKTSNATKITKYKTRKJTKBN)
    public String getZrnkyktsnatkitkyktrkjtkbn() {
        return zrnkyktsnatkitkyktrkjtkbn;
    }

    public void setZrnkyktsnatkitkyktrkjtkbn(String pZrnkyktsnatkitkyktrkjtkbn) {
        zrnkyktsnatkitkyktrkjtkbn = pZrnkyktsnatkitkyktrkjtkbn;
    }

    private String zrnalcardhkkbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNALCARDHKKBN)
    public String getZrnalcardhkkbn() {
        return zrnalcardhkkbn;
    }

    public void setZrnalcardhkkbn(String pZrnalcardhkkbn) {
        zrnalcardhkkbn = pZrnalcardhkkbn;
    }

    private String zrnbsydrtenkbn;

    @Column(name=GenZT_SinninTouhyouRn.ZRNBSYDRTENKBN)
    public String getZrnbsydrtenkbn() {
        return zrnbsydrtenkbn;
    }

    public void setZrnbsydrtenkbn(String pZrnbsydrtenkbn) {
        zrnbsydrtenkbn = pZrnbsydrtenkbn;
    }

    private String zrnvitkaiinno;

    @Column(name=GenZT_SinninTouhyouRn.ZRNVITKAIINNO)
    public String getZrnvitkaiinno() {
        return zrnvitkaiinno;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnvitkaiinno(String pZrnvitkaiinno) {
        zrnvitkaiinno = pZrnvitkaiinno;
    }

    private String zrnyobiv60;

    @Column(name=GenZT_SinninTouhyouRn.ZRNYOBIV60)
    public String getZrnyobiv60() {
        return zrnyobiv60;
    }

    public void setZrnyobiv60(String pZrnyobiv60) {
        zrnyobiv60 = pZrnyobiv60;
    }
}