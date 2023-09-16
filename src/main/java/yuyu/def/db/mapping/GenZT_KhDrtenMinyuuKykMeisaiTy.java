package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.id.PKZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.GenQZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiTy;

/**
 * 代理店未入契約明細テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KhDrtenMinyuuKykMeisaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhDrtenMinyuuKykMeisaiTy}</td><td colspan="3">代理店未入契約明細テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">{@link PKZT_KhDrtenMinyuuKykMeisaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_KhDrtenMinyuuKykMeisaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KhDrtenMinyuuKykMeisaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypjyuutouyymmwareki4keta ztypjyuutouyymmwareki4keta}</td><td>（中継用）保険料充当年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuudrtennmkj ztybosyuudrtennmkj}</td><td>（中継用）募集代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuujyutuymd ztyminyuujyutuymd}</td><td>（中継用）未入充当年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassinka ztyhassinka}</td><td>（中継用）発信課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtnbsyunnmisyou ztydrtnbsyunnmisyou}</td><td>（中継用）代理店募集人名称（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj35 ztykyknmkj35}</td><td>（中継用）契約者名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgk ztyhrkgk}</td><td>（中継用）払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyknkimnyuuryu ztyknkimnyuuryu}</td><td>（中継用）今回未入理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuuningyouhaiymd ztybosyuuningyouhaiymd}</td><td>（中継用）募集人業廃年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeyokinkbn ztykzhurikaeyokinkbn}</td><td>（中継用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekouzano ztykzhurikaekouzano}</td><td>（中継用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknyukknmei ztyknyukknmei}</td><td>（中継用）金融機関名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknyykknstnmei ztyknyykknstnmei}</td><td>（中継用）金融機関支店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaicd ztydantaicd}</td><td>（中継用）団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjdntnm ztykjdntnm}</td><td>（中継用）漢字団体名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty30ketahknsyuruimei zty30ketahknsyuruimei}</td><td>（中継用）３０桁保険種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybkofccd ztybkofccd}</td><td>（中継用）バックオフィスコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhDrtenMinyuuKykMeisaiTy
 * @see     PKZT_KhDrtenMinyuuKykMeisaiTy
 * @see     QZT_KhDrtenMinyuuKykMeisaiTy
 * @see     GenQZT_KhDrtenMinyuuKykMeisaiTy
 */
@MappedSuperclass
@Table(name=GenZT_KhDrtenMinyuuKykMeisaiTy.TABLE_NAME)
@IdClass(value=PKZT_KhDrtenMinyuuKykMeisaiTy.class)
public abstract class GenZT_KhDrtenMinyuuKykMeisaiTy extends AbstractExDBEntity<ZT_KhDrtenMinyuuKykMeisaiTy, PKZT_KhDrtenMinyuuKykMeisaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KhDrtenMinyuuKykMeisaiTy";
    public static final String ZTYSYORIYMD              = "ztysyoriymd";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYBOSYUUNINCD           = "ztybosyuunincd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYPJYUUTOUYYMMWAREKI4KETA = "ztypjyuutouyymmwareki4keta";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYBOSYUUDRTENNMKJ       = "ztybosyuudrtennmkj";
    public static final String ZTYMINYUUJYUTUYMD        = "ztyminyuujyutuymd";
    public static final String ZTYHASSINKA              = "ztyhassinka";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYDRTNBSYUNNMISYOU      = "ztydrtnbsyunnmisyou";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYKYKNMKJ35             = "ztykyknmkj35";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYHRKGK                 = "ztyhrkgk";
    public static final String ZTYKNKIMNYUURYU          = "ztyknkimnyuuryu";
    public static final String ZTYBOSYUUNINGYOUHAIYMD   = "ztybosyuuningyouhaiymd";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKZHURIKAEYOKINKBN     = "ztykzhurikaeyokinkbn";
    public static final String ZTYKZHURIKAEKOUZANO      = "ztykzhurikaekouzano";
    public static final String ZTYKNYUKKNMEI            = "ztyknyukknmei";
    public static final String ZTYKNYYKKNSTNMEI         = "ztyknyykknstnmei";
    public static final String ZTYDANTAICD              = "ztydantaicd";
    public static final String ZTYKJDNTNM               = "ztykjdntnm";
    public static final String ZTY30KETAHKNSYURUIMEI    = "zty30ketahknsyuruimei";
    public static final String ZTYBKOFCCD               = "ztybkofccd";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";

    private final PKZT_KhDrtenMinyuuKykMeisaiTy primaryKey;

    public GenZT_KhDrtenMinyuuKykMeisaiTy() {
        primaryKey = new PKZT_KhDrtenMinyuuKykMeisaiTy();
    }

    public GenZT_KhDrtenMinyuuKykMeisaiTy(
        String pZtysyoriymd,
        String pZtybsydrtencd,
        String pZtysyono
    ) {
        primaryKey = new PKZT_KhDrtenMinyuuKykMeisaiTy(
            pZtysyoriymd,
            pZtybsydrtencd,
            pZtysyono
        );
    }

    @Transient
    @Override
    public PKZT_KhDrtenMinyuuKykMeisaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KhDrtenMinyuuKykMeisaiTy> getMetaClass() {
        return QZT_KhDrtenMinyuuKykMeisaiTy.class;
    }

    @Id
    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYSYORIYMD)
    public String getZtysyoriymd() {
        return getPrimaryKey().getZtysyoriymd();
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        getPrimaryKey().setZtysyoriymd(pZtysyoriymd);
    }

    @Id
    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    private String ztybosyuunincd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYBOSYUUNINCD)
    public String getZtybosyuunincd() {
        return ztybosyuunincd;
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        ztybosyuunincd = pZtybosyuunincd;
    }

    @Id
    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztypjyuutouyymmwareki4keta;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYPJYUUTOUYYMMWAREKI4KETA)
    public String getZtypjyuutouyymmwareki4keta() {
        return ztypjyuutouyymmwareki4keta;
    }

    public void setZtypjyuutouyymmwareki4keta(String pZtypjyuutouyymmwareki4keta) {
        ztypjyuutouyymmwareki4keta = pZtypjyuutouyymmwareki4keta;
    }

    private String ztykykymd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztycifcd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztybosyuudrtennmkj;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYBOSYUUDRTENNMKJ)
    public String getZtybosyuudrtennmkj() {
        return ztybosyuudrtennmkj;
    }

    public void setZtybosyuudrtennmkj(String pZtybosyuudrtennmkj) {
        ztybosyuudrtennmkj = pZtybosyuudrtennmkj;
    }

    private String ztyminyuujyutuymd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYMINYUUJYUTUYMD)
    public String getZtyminyuujyutuymd() {
        return ztyminyuujyutuymd;
    }

    public void setZtyminyuujyutuymd(String pZtyminyuujyutuymd) {
        ztyminyuujyutuymd = pZtyminyuujyutuymd;
    }

    private String ztyhassinka;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYHASSINKA)
    public String getZtyhassinka() {
        return ztyhassinka;
    }

    public void setZtyhassinka(String pZtyhassinka) {
        ztyhassinka = pZtyhassinka;
    }

    private String ztybsyym;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztydrtnbsyunnmisyou;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYDRTNBSYUNNMISYOU)
    public String getZtydrtnbsyunnmisyou() {
        return ztydrtnbsyunnmisyou;
    }

    public void setZtydrtnbsyunnmisyou(String pZtydrtnbsyunnmisyou) {
        ztydrtnbsyunnmisyou = pZtydrtnbsyunnmisyou;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztykyknmkj35;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKYKNMKJ35)
    public String getZtykyknmkj35() {
        return ztykyknmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZtykyknmkj35(String pZtykyknmkj35) {
        ztykyknmkj35 = pZtykyknmkj35;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private Long ztyhrkgk;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYHRKGK)
    public Long getZtyhrkgk() {
        return ztyhrkgk;
    }

    public void setZtyhrkgk(Long pZtyhrkgk) {
        ztyhrkgk = pZtyhrkgk;
    }

    private String ztyknkimnyuuryu;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKNKIMNYUURYU)
    public String getZtyknkimnyuuryu() {
        return ztyknkimnyuuryu;
    }

    public void setZtyknkimnyuuryu(String pZtyknkimnyuuryu) {
        ztyknkimnyuuryu = pZtyknkimnyuuryu;
    }

    private String ztybosyuuningyouhaiymd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYBOSYUUNINGYOUHAIYMD)
    public String getZtybosyuuningyouhaiymd() {
        return ztybosyuuningyouhaiymd;
    }

    public void setZtybosyuuningyouhaiymd(String pZtybosyuuningyouhaiymd) {
        ztybosyuuningyouhaiymd = pZtybosyuuningyouhaiymd;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykzhurikaeyokinkbn;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKZHURIKAEYOKINKBN)
    public String getZtykzhurikaeyokinkbn() {
        return ztykzhurikaeyokinkbn;
    }

    public void setZtykzhurikaeyokinkbn(String pZtykzhurikaeyokinkbn) {
        ztykzhurikaeyokinkbn = pZtykzhurikaeyokinkbn;
    }

    private String ztykzhurikaekouzano;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKZHURIKAEKOUZANO)
    public String getZtykzhurikaekouzano() {
        return ztykzhurikaekouzano;
    }

    public void setZtykzhurikaekouzano(String pZtykzhurikaekouzano) {
        ztykzhurikaekouzano = pZtykzhurikaekouzano;
    }

    private String ztyknyukknmei;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKNYUKKNMEI)
    public String getZtyknyukknmei() {
        return ztyknyukknmei;
    }

    public void setZtyknyukknmei(String pZtyknyukknmei) {
        ztyknyukknmei = pZtyknyukknmei;
    }

    private String ztyknyykknstnmei;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKNYYKKNSTNMEI)
    public String getZtyknyykknstnmei() {
        return ztyknyykknstnmei;
    }

    public void setZtyknyykknstnmei(String pZtyknyykknstnmei) {
        ztyknyykknstnmei = pZtyknyykknstnmei;
    }

    private String ztydantaicd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYDANTAICD)
    public String getZtydantaicd() {
        return ztydantaicd;
    }

    public void setZtydantaicd(String pZtydantaicd) {
        ztydantaicd = pZtydantaicd;
    }

    private String ztykjdntnm;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYKJDNTNM)
    public String getZtykjdntnm() {
        return ztykjdntnm;
    }

    public void setZtykjdntnm(String pZtykjdntnm) {
        ztykjdntnm = pZtykjdntnm;
    }

    private String zty30ketahknsyuruimei;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTY30KETAHKNSYURUIMEI)
    public String getZty30ketahknsyuruimei() {
        return zty30ketahknsyuruimei;
    }

    public void setZty30ketahknsyuruimei(String pZty30ketahknsyuruimei) {
        zty30ketahknsyuruimei = pZty30ketahknsyuruimei;
    }

    private String ztybkofccd;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYBKOFCCD)
    public String getZtybkofccd() {
        return ztybkofccd;
    }

    public void setZtybkofccd(String pZtybkofccd) {
        ztybkofccd = pZtybkofccd;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_KhDrtenMinyuuKykMeisaiTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }
}