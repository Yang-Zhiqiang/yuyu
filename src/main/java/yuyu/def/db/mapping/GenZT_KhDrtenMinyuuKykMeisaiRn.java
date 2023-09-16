package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.id.PKZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.GenQZT_KhDrtenMinyuuKykMeisaiRn;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiRn;

/**
 * 代理店未入契約明細テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KhDrtenMinyuuKykMeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhDrtenMinyuuKykMeisaiRn}</td><td colspan="3">代理店未入契約明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">{@link PKZT_KhDrtenMinyuuKykMeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_KhDrtenMinyuuKykMeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KhDrtenMinyuuKykMeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpjyuutouyymmwareki4keta zrnpjyuutouyymmwareki4keta}</td><td>（連携用）保険料充当年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuudrtennmkj zrnbosyuudrtennmkj}</td><td>（連携用）募集代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuujyutuymd zrnminyuujyutuymd}</td><td>（連携用）未入充当年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassinka zrnhassinka}</td><td>（連携用）発信課</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtnbsyunnmisyou zrndrtnbsyunnmisyou}</td><td>（連携用）代理店募集人名称（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbn zrnkydatkikbn}</td><td>（連携用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj35 zrnkyknmkj35}</td><td>（連携用）契約者名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgk zrnhrkgk}</td><td>（連携用）払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnknkimnyuuryu zrnknkimnyuuryu}</td><td>（連携用）今回未入理由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuuningyouhaiymd zrnbosyuuningyouhaiymd}</td><td>（連携用）募集人業廃年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknyukknmei zrnknyukknmei}</td><td>（連携用）金融機関名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknyykknstnmei zrnknyykknstnmei}</td><td>（連携用）金融機関支店名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaicd zrndantaicd}</td><td>（連携用）団体コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjdntnm zrnkjdntnm}</td><td>（連携用）漢字団体名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruimei zrnhknsyuruimei}</td><td>（連携用）保険種類名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbkofccd zrnbkofccd}</td><td>（連携用）バックオフィスコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhDrtenMinyuuKykMeisaiRn
 * @see     PKZT_KhDrtenMinyuuKykMeisaiRn
 * @see     QZT_KhDrtenMinyuuKykMeisaiRn
 * @see     GenQZT_KhDrtenMinyuuKykMeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_KhDrtenMinyuuKykMeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_KhDrtenMinyuuKykMeisaiRn.class)
public abstract class GenZT_KhDrtenMinyuuKykMeisaiRn extends AbstractExDBEntityForZDB<ZT_KhDrtenMinyuuKykMeisaiRn, PKZT_KhDrtenMinyuuKykMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KhDrtenMinyuuKykMeisaiRn";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNPJYUUTOUYYMMWAREKI4KETA = "zrnpjyuutouyymmwareki4keta";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNBOSYUUDRTENNMKJ       = "zrnbosyuudrtennmkj";
    public static final String ZRNMINYUUJYUTUYMD        = "zrnminyuujyutuymd";
    public static final String ZRNHASSINKA              = "zrnhassinka";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNDRTNBSYUNNMISYOU      = "zrndrtnbsyunnmisyou";
    public static final String ZRNKYDATKIKBN            = "zrnkydatkikbn";
    public static final String ZRNKYKNMKJ35             = "zrnkyknmkj35";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNHRKGK                 = "zrnhrkgk";
    public static final String ZRNKNKIMNYUURYU          = "zrnknkimnyuuryu";
    public static final String ZRNBOSYUUNINGYOUHAIYMD   = "zrnbosyuuningyouhaiymd";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNKNYUKKNMEI            = "zrnknyukknmei";
    public static final String ZRNKNYYKKNSTNMEI         = "zrnknyykknstnmei";
    public static final String ZRNDANTAICD              = "zrndantaicd";
    public static final String ZRNKJDNTNM               = "zrnkjdntnm";
    public static final String ZRNHKNSYURUIMEI          = "zrnhknsyuruimei";
    public static final String ZRNBKOFCCD               = "zrnbkofccd";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";

    private final PKZT_KhDrtenMinyuuKykMeisaiRn primaryKey;

    public GenZT_KhDrtenMinyuuKykMeisaiRn() {
        primaryKey = new PKZT_KhDrtenMinyuuKykMeisaiRn();
    }

    public GenZT_KhDrtenMinyuuKykMeisaiRn(
        String pZrnsyoriymd,
        String pZrnbsydrtencd,
        String pZrnsyono
    ) {
        primaryKey = new PKZT_KhDrtenMinyuuKykMeisaiRn(
            pZrnsyoriymd,
            pZrnbsydrtencd,
            pZrnsyono
        );
    }

    @Transient
    @Override
    public PKZT_KhDrtenMinyuuKykMeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KhDrtenMinyuuKykMeisaiRn> getMetaClass() {
        return QZT_KhDrtenMinyuuKykMeisaiRn.class;
    }

    @Id
    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return getPrimaryKey().getZrnsyoriymd();
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        getPrimaryKey().setZrnsyoriymd(pZrnsyoriymd);
    }

    @Id
    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    private String zrnbosyuunincd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }

    @Id
    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnpjyuutouyymmwareki4keta;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNPJYUUTOUYYMMWAREKI4KETA)
    public String getZrnpjyuutouyymmwareki4keta() {
        return zrnpjyuutouyymmwareki4keta;
    }

    public void setZrnpjyuutouyymmwareki4keta(String pZrnpjyuutouyymmwareki4keta) {
        zrnpjyuutouyymmwareki4keta = pZrnpjyuutouyymmwareki4keta;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrncifcd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnbosyuudrtennmkj;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNBOSYUUDRTENNMKJ)
    public String getZrnbosyuudrtennmkj() {
        return zrnbosyuudrtennmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnbosyuudrtennmkj(String pZrnbosyuudrtennmkj) {
        zrnbosyuudrtennmkj = pZrnbosyuudrtennmkj;
    }

    private String zrnminyuujyutuymd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNMINYUUJYUTUYMD)
    public String getZrnminyuujyutuymd() {
        return zrnminyuujyutuymd;
    }

    public void setZrnminyuujyutuymd(String pZrnminyuujyutuymd) {
        zrnminyuujyutuymd = pZrnminyuujyutuymd;
    }

    private String zrnhassinka;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNHASSINKA)
    public String getZrnhassinka() {
        return zrnhassinka;
    }

    @DataConvert("toMultiByte")
    public void setZrnhassinka(String pZrnhassinka) {
        zrnhassinka = pZrnhassinka;
    }

    private String zrnbsyym;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrndrtnbsyunnmisyou;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNDRTNBSYUNNMISYOU)
    public String getZrndrtnbsyunnmisyou() {
        return zrndrtnbsyunnmisyou;
    }

    @DataConvert("toMultiByte")
    public void setZrndrtnbsyunnmisyou(String pZrndrtnbsyunnmisyou) {
        zrndrtnbsyunnmisyou = pZrndrtnbsyunnmisyou;
    }

    private String zrnkydatkikbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKYDATKIKBN)
    public String getZrnkydatkikbn() {
        return zrnkydatkikbn;
    }

    public void setZrnkydatkikbn(String pZrnkydatkikbn) {
        zrnkydatkikbn = pZrnkydatkikbn;
    }

    private String zrnkyknmkj35;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKYKNMKJ35)
    public String getZrnkyknmkj35() {
        return zrnkyknmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj35(String pZrnkyknmkj35) {
        zrnkyknmkj35 = pZrnkyknmkj35;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private Long zrnhrkgk;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNHRKGK)
    public Long getZrnhrkgk() {
        return zrnhrkgk;
    }

    public void setZrnhrkgk(Long pZrnhrkgk) {
        zrnhrkgk = pZrnhrkgk;
    }

    private String zrnknkimnyuuryu;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKNKIMNYUURYU)
    public String getZrnknkimnyuuryu() {
        return zrnknkimnyuuryu;
    }

    public void setZrnknkimnyuuryu(String pZrnknkimnyuuryu) {
        zrnknkimnyuuryu = pZrnknkimnyuuryu;
    }

    private String zrnbosyuuningyouhaiymd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNBOSYUUNINGYOUHAIYMD)
    public String getZrnbosyuuningyouhaiymd() {
        return zrnbosyuuningyouhaiymd;
    }

    public void setZrnbosyuuningyouhaiymd(String pZrnbosyuuningyouhaiymd) {
        zrnbosyuuningyouhaiymd = pZrnbosyuuningyouhaiymd;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrnknyukknmei;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKNYUKKNMEI)
    public String getZrnknyukknmei() {
        return zrnknyukknmei;
    }

    public void setZrnknyukknmei(String pZrnknyukknmei) {
        zrnknyukknmei = pZrnknyukknmei;
    }

    private String zrnknyykknstnmei;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKNYYKKNSTNMEI)
    public String getZrnknyykknstnmei() {
        return zrnknyykknstnmei;
    }

    public void setZrnknyykknstnmei(String pZrnknyykknstnmei) {
        zrnknyykknstnmei = pZrnknyykknstnmei;
    }

    private String zrndantaicd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNDANTAICD)
    public String getZrndantaicd() {
        return zrndantaicd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndantaicd(String pZrndantaicd) {
        zrndantaicd = pZrndantaicd;
    }

    private String zrnkjdntnm;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNKJDNTNM)
    public String getZrnkjdntnm() {
        return zrnkjdntnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjdntnm(String pZrnkjdntnm) {
        zrnkjdntnm = pZrnkjdntnm;
    }

    private String zrnhknsyuruimei;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNHKNSYURUIMEI)
    public String getZrnhknsyuruimei() {
        return zrnhknsyuruimei;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknsyuruimei(String pZrnhknsyuruimei) {
        zrnhknsyuruimei = pZrnhknsyuruimei;
    }

    private String zrnbkofccd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNBKOFCCD)
    public String getZrnbkofccd() {
        return zrnbkofccd;
    }

    public void setZrnbkofccd(String pZrnbkofccd) {
        zrnbkofccd = pZrnbkofccd;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }
}