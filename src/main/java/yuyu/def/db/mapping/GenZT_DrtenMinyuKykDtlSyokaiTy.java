package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.id.PKZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiTy;

/**
 * 代理店未入契約明細照会用Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenMinyuKykDtlSyokaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMinyuKykDtlSyokaiTy}</td><td colspan="3">代理店未入契約明細照会用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysakuseiym ztysakuseiym}</td><td>（中継用）作成年月</td><td align="center">{@link PKZT_DrtenMinyuKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_DrtenMinyuKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusycd ztytntusycd}</td><td>（中継用）担当者コード</td><td align="center">{@link PKZT_DrtenMinyuKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DrtenMinyuKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypjyuutouyymmwareki4keta ztypjyuutouyymmwareki4keta}</td><td>（中継用）保険料充当年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymwareki4keta ztykykymwareki4keta}</td><td>（中継用）契約年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakinm ztyatesakinm}</td><td>（中継用）宛先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuujyutuymdyofuri ztyminyuujyutuymdyofuri}</td><td>（中継用）未入充当年月（預振）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyuujyutuymdyofuriigi ztyminyuujyutuymdyofuriigi}</td><td>（中継用）未入充当年月（預振以外）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassinka ztyhassinka}</td><td>（中継用）発信課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytelno15keta ztytelno15keta}</td><td>（中継用）電話番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyymwareki4keta ztybsyymwareki4keta}</td><td>（中継用）募集年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusynm ztytntusynm}</td><td>（中継用）担当者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbnkj ztykydatkikbnkj}</td><td>（中継用）共同扱区分（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj20 ztykyknmkj20}</td><td>（中継用）契約者名（漢字）（２０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukj ztyhrkkaisuukj}</td><td>（中継用）払込回数（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokj ztyhrkkeirokj}</td><td>（中継用）払込経路（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyp11keta ztyp11keta}</td><td>（中継用）保険料（１１桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyknkimnyuuryukj ztyknkimnyuuryukj}</td><td>（中継用）今回未入理由（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaiminyuuji ztyjikaiminyuuji}</td><td>（中継用）次回未入時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusygyouhaiinfo ztytntusygyouhaiinfo}</td><td>（中継用）担当者業廃情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirobtjhmidasi ztyhrkkeirobtjhmidasi}</td><td>（中継用）払込経路別情報見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirobtjh ztyhrkkeirobtjh}</td><td>（中継用）払込経路別情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruimei ztyhknsyuruimei}</td><td>（中継用）保険種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybkofccd ztybkofccd}</td><td>（中継用）バックオフィスコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydbskyoteiymd ztydbskyoteiymd}</td><td>（中継用）ＤＢ削除予定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMinyuKykDtlSyokaiTy
 * @see     PKZT_DrtenMinyuKykDtlSyokaiTy
 * @see     QZT_DrtenMinyuKykDtlSyokaiTy
 * @see     GenQZT_DrtenMinyuKykDtlSyokaiTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenMinyuKykDtlSyokaiTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenMinyuKykDtlSyokaiTy.class)
public abstract class GenZT_DrtenMinyuKykDtlSyokaiTy extends AbstractExDBEntity<ZT_DrtenMinyuKykDtlSyokaiTy, PKZT_DrtenMinyuKykDtlSyokaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenMinyuKykDtlSyokaiTy";
    public static final String ZTYSAKUSEIYM             = "ztysakuseiym";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYTNTUSYCD              = "ztytntusycd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYPJYUUTOUYYMMWAREKI4KETA = "ztypjyuutouyymmwareki4keta";
    public static final String ZTYKYKYMWAREKI4KETA      = "ztykykymwareki4keta";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYATESAKINM             = "ztyatesakinm";
    public static final String ZTYMINYUUJYUTUYMDYOFURI  = "ztyminyuujyutuymdyofuri";
    public static final String ZTYMINYUUJYUTUYMDYOFURIIGI = "ztyminyuujyutuymdyofuriigi";
    public static final String ZTYHASSINKA              = "ztyhassinka";
    public static final String ZTYTELNO15KETA           = "ztytelno15keta";
    public static final String ZTYBSYYMWAREKI4KETA      = "ztybsyymwareki4keta";
    public static final String ZTYTNTUSYNM              = "ztytntusynm";
    public static final String ZTYKYDATKIKBNKJ          = "ztykydatkikbnkj";
    public static final String ZTYKYKNMKJ20             = "ztykyknmkj20";
    public static final String ZTYHRKKAISUUKJ           = "ztyhrkkaisuukj";
    public static final String ZTYHRKKEIROKJ            = "ztyhrkkeirokj";
    public static final String ZTYP11KETA               = "ztyp11keta";
    public static final String ZTYKNKIMNYUURYUKJ        = "ztyknkimnyuuryukj";
    public static final String ZTYJIKAIMINYUUJI         = "ztyjikaiminyuuji";
    public static final String ZTYTNTUSYGYOUHAIINFO     = "ztytntusygyouhaiinfo";
    public static final String ZTYHRKKEIROBTJHMIDASI    = "ztyhrkkeirobtjhmidasi";
    public static final String ZTYHRKKEIROBTJH          = "ztyhrkkeirobtjh";
    public static final String ZTYHKNSYURUIMEI          = "ztyhknsyuruimei";
    public static final String ZTYBKOFCCD               = "ztybkofccd";
    public static final String ZTYDBSKYOTEIYMD          = "ztydbskyoteiymd";
    public static final String ZTYYOBIV24               = "ztyyobiv24";

    private final PKZT_DrtenMinyuKykDtlSyokaiTy primaryKey;

    public GenZT_DrtenMinyuKykDtlSyokaiTy() {
        primaryKey = new PKZT_DrtenMinyuKykDtlSyokaiTy();
    }

    public GenZT_DrtenMinyuKykDtlSyokaiTy(
        String pZtysakuseiym,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono
    ) {
        primaryKey = new PKZT_DrtenMinyuKykDtlSyokaiTy(
            pZtysakuseiym,
            pZtybsydrtencd,
            pZtytntusycd,
            pZtysyono
        );
    }

    @Transient
    @Override
    public PKZT_DrtenMinyuKykDtlSyokaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenMinyuKykDtlSyokaiTy> getMetaClass() {
        return QZT_DrtenMinyuKykDtlSyokaiTy.class;
    }

    @Id
    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYSAKUSEIYM)
    public String getZtysakuseiym() {
        return getPrimaryKey().getZtysakuseiym();
    }

    public void setZtysakuseiym(String pZtysakuseiym) {
        getPrimaryKey().setZtysakuseiym(pZtysakuseiym);
    }

    @Id
    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    @Id
    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYTNTUSYCD)
    public String getZtytntusycd() {
        return getPrimaryKey().getZtytntusycd();
    }

    public void setZtytntusycd(String pZtytntusycd) {
        getPrimaryKey().setZtytntusycd(pZtytntusycd);
    }

    @Id
    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztypjyuutouyymmwareki4keta;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYPJYUUTOUYYMMWAREKI4KETA)
    public String getZtypjyuutouyymmwareki4keta() {
        return ztypjyuutouyymmwareki4keta;
    }

    public void setZtypjyuutouyymmwareki4keta(String pZtypjyuutouyymmwareki4keta) {
        ztypjyuutouyymmwareki4keta = pZtypjyuutouyymmwareki4keta;
    }

    private String ztykykymwareki4keta;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYKYKYMWAREKI4KETA)
    public String getZtykykymwareki4keta() {
        return ztykykymwareki4keta;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtykykymwareki4keta(String pZtykykymwareki4keta) {
        ztykykymwareki4keta = pZtykykymwareki4keta;
    }

    private String ztycifcd;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztyatesakinm;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYATESAKINM)
    public String getZtyatesakinm() {
        return ztyatesakinm;
    }

    public void setZtyatesakinm(String pZtyatesakinm) {
        ztyatesakinm = pZtyatesakinm;
    }

    private String ztyminyuujyutuymdyofuri;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYMINYUUJYUTUYMDYOFURI)
    public String getZtyminyuujyutuymdyofuri() {
        return ztyminyuujyutuymdyofuri;
    }

    public void setZtyminyuujyutuymdyofuri(String pZtyminyuujyutuymdyofuri) {
        ztyminyuujyutuymdyofuri = pZtyminyuujyutuymdyofuri;
    }

    private String ztyminyuujyutuymdyofuriigi;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYMINYUUJYUTUYMDYOFURIIGI)
    public String getZtyminyuujyutuymdyofuriigi() {
        return ztyminyuujyutuymdyofuriigi;
    }

    public void setZtyminyuujyutuymdyofuriigi(String pZtyminyuujyutuymdyofuriigi) {
        ztyminyuujyutuymdyofuriigi = pZtyminyuujyutuymdyofuriigi;
    }

    private String ztyhassinka;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYHASSINKA)
    public String getZtyhassinka() {
        return ztyhassinka;
    }

    public void setZtyhassinka(String pZtyhassinka) {
        ztyhassinka = pZtyhassinka;
    }

    private String ztytelno15keta;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYTELNO15KETA)
    public String getZtytelno15keta() {
        return ztytelno15keta;
    }

    public void setZtytelno15keta(String pZtytelno15keta) {
        ztytelno15keta = pZtytelno15keta;
    }

    private String ztybsyymwareki4keta;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYBSYYMWAREKI4KETA)
    public String getZtybsyymwareki4keta() {
        return ztybsyymwareki4keta;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtybsyymwareki4keta(String pZtybsyymwareki4keta) {
        ztybsyymwareki4keta = pZtybsyymwareki4keta;
    }

    private String ztytntusynm;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYTNTUSYNM)
    public String getZtytntusynm() {
        return ztytntusynm;
    }

    public void setZtytntusynm(String pZtytntusynm) {
        ztytntusynm = pZtytntusynm;
    }

    private String ztykydatkikbnkj;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYKYDATKIKBNKJ)
    public String getZtykydatkikbnkj() {
        return ztykydatkikbnkj;
    }

    public void setZtykydatkikbnkj(String pZtykydatkikbnkj) {
        ztykydatkikbnkj = pZtykydatkikbnkj;
    }

    private String ztykyknmkj20;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYKYKNMKJ20)
    public String getZtykyknmkj20() {
        return ztykyknmkj20;
    }

    public void setZtykyknmkj20(String pZtykyknmkj20) {
        ztykyknmkj20 = pZtykyknmkj20;
    }

    private String ztyhrkkaisuukj;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYHRKKAISUUKJ)
    public String getZtyhrkkaisuukj() {
        return ztyhrkkaisuukj;
    }

    public void setZtyhrkkaisuukj(String pZtyhrkkaisuukj) {
        ztyhrkkaisuukj = pZtyhrkkaisuukj;
    }

    private String ztyhrkkeirokj;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYHRKKEIROKJ)
    public String getZtyhrkkeirokj() {
        return ztyhrkkeirokj;
    }

    public void setZtyhrkkeirokj(String pZtyhrkkeirokj) {
        ztyhrkkeirokj = pZtyhrkkeirokj;
    }

    private Long ztyp11keta;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYP11KETA)
    public Long getZtyp11keta() {
        return ztyp11keta;
    }

    public void setZtyp11keta(Long pZtyp11keta) {
        ztyp11keta = pZtyp11keta;
    }

    private String ztyknkimnyuuryukj;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYKNKIMNYUURYUKJ)
    public String getZtyknkimnyuuryukj() {
        return ztyknkimnyuuryukj;
    }

    public void setZtyknkimnyuuryukj(String pZtyknkimnyuuryukj) {
        ztyknkimnyuuryukj = pZtyknkimnyuuryukj;
    }

    private String ztyjikaiminyuuji;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYJIKAIMINYUUJI)
    public String getZtyjikaiminyuuji() {
        return ztyjikaiminyuuji;
    }

    public void setZtyjikaiminyuuji(String pZtyjikaiminyuuji) {
        ztyjikaiminyuuji = pZtyjikaiminyuuji;
    }

    private String ztytntusygyouhaiinfo;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYTNTUSYGYOUHAIINFO)
    public String getZtytntusygyouhaiinfo() {
        return ztytntusygyouhaiinfo;
    }

    public void setZtytntusygyouhaiinfo(String pZtytntusygyouhaiinfo) {
        ztytntusygyouhaiinfo = pZtytntusygyouhaiinfo;
    }

    private String ztyhrkkeirobtjhmidasi;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYHRKKEIROBTJHMIDASI)
    public String getZtyhrkkeirobtjhmidasi() {
        return ztyhrkkeirobtjhmidasi;
    }

    public void setZtyhrkkeirobtjhmidasi(String pZtyhrkkeirobtjhmidasi) {
        ztyhrkkeirobtjhmidasi = pZtyhrkkeirobtjhmidasi;
    }

    private String ztyhrkkeirobtjh;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYHRKKEIROBTJH)
    public String getZtyhrkkeirobtjh() {
        return ztyhrkkeirobtjh;
    }

    public void setZtyhrkkeirobtjh(String pZtyhrkkeirobtjh) {
        ztyhrkkeirobtjh = pZtyhrkkeirobtjh;
    }

    private String ztyhknsyuruimei;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYHKNSYURUIMEI)
    public String getZtyhknsyuruimei() {
        return ztyhknsyuruimei;
    }

    public void setZtyhknsyuruimei(String pZtyhknsyuruimei) {
        ztyhknsyuruimei = pZtyhknsyuruimei;
    }

    private String ztybkofccd;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYBKOFCCD)
    public String getZtybkofccd() {
        return ztybkofccd;
    }

    public void setZtybkofccd(String pZtybkofccd) {
        ztybkofccd = pZtybkofccd;
    }

    private String ztydbskyoteiymd;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYDBSKYOTEIYMD)
    public String getZtydbskyoteiymd() {
        return ztydbskyoteiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtydbskyoteiymd(String pZtydbskyoteiymd) {
        ztydbskyoteiymd = pZtydbskyoteiymd;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_DrtenMinyuKykDtlSyokaiTy.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }
}