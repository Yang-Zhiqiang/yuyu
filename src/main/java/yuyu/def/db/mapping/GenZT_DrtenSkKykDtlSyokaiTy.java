package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.id.PKZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiTy;

/**
 * 代理店失効契約明細照会用Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenSkKykDtlSyokaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenSkKykDtlSyokaiTy}</td><td colspan="3">代理店失効契約明細照会用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysakuseiym ztysakuseiym}</td><td>（中継用）作成年月</td><td align="center">{@link PKZT_DrtenSkKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">{@link PKZT_DrtenSkKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusycd ztytntusycd}</td><td>（中継用）担当者コード</td><td align="center">{@link PKZT_DrtenSkKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DrtenSkKykDtlSyokaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymwareki4keta ztykykymwareki4keta}</td><td>（中継用）契約年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakinm ztyatesakinm}</td><td>（中継用）宛先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassinka ztyhassinka}</td><td>（中継用）発信課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytelno15keta ztytelno15keta}</td><td>（中継用）電話番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyymwareki4keta ztybsyymwareki4keta}</td><td>（中継用）募集年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusynm ztytntusynm}</td><td>（中継用）担当者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbnkj ztykydatkikbnkj}</td><td>（中継用）共同扱区分（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj20 ztykyknmkj20}</td><td>（中継用）契約者名（漢字）（２０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskymdwareki ztyskymdwareki}</td><td>（中継用）失効年月日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukj ztyhrkkaisuukj}</td><td>（中継用）払込回数（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokj ztyhrkkeirokj}</td><td>（中継用）払込経路（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyp11keta ztyp11keta}</td><td>（中継用）保険料（１１桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyskhr ztyskhr}</td><td>（中継用）失効時返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjizensyoukaiyouhyj ztyjizensyoukaiyouhyj}</td><td>（中継用）事前照会要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytntusygyouhaiinfo ztytntusygyouhaiinfo}</td><td>（中継用）担当者業廃情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirobtjhmidasi ztyhrkkeirobtjhmidasi}</td><td>（中継用）払込経路別情報見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirobtjh ztyhrkkeirobtjh}</td><td>（中継用）払込経路別情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruimei ztyhknsyuruimei}</td><td>（中継用）保険種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybkofccd ztybkofccd}</td><td>（中継用）バックオフィスコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydbskyoteiymd ztydbskyoteiymd}</td><td>（中継用）ＤＢ削除予定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyukaisuu ztyminyukaisuu}</td><td>（中継用）未入回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitkaiinno ztyvitkaiinno}</td><td>（中継用）Ｖｉｔ会員番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitkykym ztyvitkykym}</td><td>（中継用）Ｖｉｔ契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitskymd ztyvitskymd}</td><td>（中継用）Ｖｉｔ失効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvithrkkaisuu ztyvithrkkaisuu}</td><td>（中継用）Ｖｉｔ払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvithrkkeiro ztyvithrkkeiro}</td><td>（中継用）Ｖｉｔ払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzkomivitriyoury ztyzkomivitriyoury}</td><td>（中継用）税込Ｖｉｔ利用料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyvitnyknkaisuu ztyvitnyknkaisuu}</td><td>（中継用）Ｖｉｔ入金回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitbikou ztyvitbikou}</td><td>（中継用）Ｖｉｔ備考</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv25 ztyyobiv25}</td><td>（中継用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenSkKykDtlSyokaiTy
 * @see     PKZT_DrtenSkKykDtlSyokaiTy
 * @see     QZT_DrtenSkKykDtlSyokaiTy
 * @see     GenQZT_DrtenSkKykDtlSyokaiTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenSkKykDtlSyokaiTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenSkKykDtlSyokaiTy.class)
public abstract class GenZT_DrtenSkKykDtlSyokaiTy extends AbstractExDBEntityForZDB<ZT_DrtenSkKykDtlSyokaiTy, PKZT_DrtenSkKykDtlSyokaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenSkKykDtlSyokaiTy";
    public static final String ZTYSAKUSEIYM             = "ztysakuseiym";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYTNTUSYCD              = "ztytntusycd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKYKYMWAREKI4KETA      = "ztykykymwareki4keta";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYATESAKINM             = "ztyatesakinm";
    public static final String ZTYHASSINKA              = "ztyhassinka";
    public static final String ZTYTELNO15KETA           = "ztytelno15keta";
    public static final String ZTYBSYYMWAREKI4KETA      = "ztybsyymwareki4keta";
    public static final String ZTYTNTUSYNM              = "ztytntusynm";
    public static final String ZTYKYDATKIKBNKJ          = "ztykydatkikbnkj";
    public static final String ZTYKYKNMKJ20             = "ztykyknmkj20";
    public static final String ZTYSKYMDWAREKI           = "ztyskymdwareki";
    public static final String ZTYHRKKAISUUKJ           = "ztyhrkkaisuukj";
    public static final String ZTYHRKKEIROKJ            = "ztyhrkkeirokj";
    public static final String ZTYP11KETA               = "ztyp11keta";
    public static final String ZTYSKHR                  = "ztyskhr";
    public static final String ZTYJIZENSYOUKAIYOUHYJ    = "ztyjizensyoukaiyouhyj";
    public static final String ZTYTNTUSYGYOUHAIINFO     = "ztytntusygyouhaiinfo";
    public static final String ZTYHRKKEIROBTJHMIDASI    = "ztyhrkkeirobtjhmidasi";
    public static final String ZTYHRKKEIROBTJH          = "ztyhrkkeirobtjh";
    public static final String ZTYHKNSYURUIMEI          = "ztyhknsyuruimei";
    public static final String ZTYBKOFCCD               = "ztybkofccd";
    public static final String ZTYDBSKYOTEIYMD          = "ztydbskyoteiymd";
    public static final String ZTYMINYUKAISUU           = "ztyminyukaisuu";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYVITKAIINNO            = "ztyvitkaiinno";
    public static final String ZTYVITKYKYM              = "ztyvitkykym";
    public static final String ZTYVITSKYMD              = "ztyvitskymd";
    public static final String ZTYVITHRKKAISUU          = "ztyvithrkkaisuu";
    public static final String ZTYVITHRKKEIRO           = "ztyvithrkkeiro";
    public static final String ZTYZKOMIVITRIYOURY       = "ztyzkomivitriyoury";
    public static final String ZTYVITNYKNKAISUU         = "ztyvitnyknkaisuu";
    public static final String ZTYVITBIKOU              = "ztyvitbikou";
    public static final String ZTYYOBIV25               = "ztyyobiv25";

    private final PKZT_DrtenSkKykDtlSyokaiTy primaryKey;

    public GenZT_DrtenSkKykDtlSyokaiTy() {
        primaryKey = new PKZT_DrtenSkKykDtlSyokaiTy();
    }

    public GenZT_DrtenSkKykDtlSyokaiTy(
        String pZtysakuseiym,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono
    ) {
        primaryKey = new PKZT_DrtenSkKykDtlSyokaiTy(
            pZtysakuseiym,
            pZtybsydrtencd,
            pZtytntusycd,
            pZtysyono
        );
    }

    @Transient
    @Override
    public PKZT_DrtenSkKykDtlSyokaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenSkKykDtlSyokaiTy> getMetaClass() {
        return QZT_DrtenSkKykDtlSyokaiTy.class;
    }

    @Id
    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYSAKUSEIYM)
    public String getZtysakuseiym() {
        return getPrimaryKey().getZtysakuseiym();
    }

    public void setZtysakuseiym(String pZtysakuseiym) {
        getPrimaryKey().setZtysakuseiym(pZtysakuseiym);
    }

    @Id
    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return getPrimaryKey().getZtybsydrtencd();
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        getPrimaryKey().setZtybsydrtencd(pZtybsydrtencd);
    }

    @Id
    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYTNTUSYCD)
    public String getZtytntusycd() {
        return getPrimaryKey().getZtytntusycd();
    }

    public void setZtytntusycd(String pZtytntusycd) {
        getPrimaryKey().setZtytntusycd(pZtytntusycd);
    }

    @Id
    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztykykymwareki4keta;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYKYKYMWAREKI4KETA)
    public String getZtykykymwareki4keta() {
        return ztykykymwareki4keta;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtykykymwareki4keta(String pZtykykymwareki4keta) {
        ztykykymwareki4keta = pZtykykymwareki4keta;
    }

    private String ztycifcd;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztyatesakinm;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYATESAKINM)
    public String getZtyatesakinm() {
        return ztyatesakinm;
    }

    public void setZtyatesakinm(String pZtyatesakinm) {
        ztyatesakinm = pZtyatesakinm;
    }

    private String ztyhassinka;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYHASSINKA)
    public String getZtyhassinka() {
        return ztyhassinka;
    }

    public void setZtyhassinka(String pZtyhassinka) {
        ztyhassinka = pZtyhassinka;
    }

    private String ztytelno15keta;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYTELNO15KETA)
    public String getZtytelno15keta() {
        return ztytelno15keta;
    }

    public void setZtytelno15keta(String pZtytelno15keta) {
        ztytelno15keta = pZtytelno15keta;
    }

    private String ztybsyymwareki4keta;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYBSYYMWAREKI4KETA)
    public String getZtybsyymwareki4keta() {
        return ztybsyymwareki4keta;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtybsyymwareki4keta(String pZtybsyymwareki4keta) {
        ztybsyymwareki4keta = pZtybsyymwareki4keta;
    }

    private String ztytntusynm;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYTNTUSYNM)
    public String getZtytntusynm() {
        return ztytntusynm;
    }

    public void setZtytntusynm(String pZtytntusynm) {
        ztytntusynm = pZtytntusynm;
    }

    private String ztykydatkikbnkj;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYKYDATKIKBNKJ)
    public String getZtykydatkikbnkj() {
        return ztykydatkikbnkj;
    }

    public void setZtykydatkikbnkj(String pZtykydatkikbnkj) {
        ztykydatkikbnkj = pZtykydatkikbnkj;
    }

    private String ztykyknmkj20;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYKYKNMKJ20)
    public String getZtykyknmkj20() {
        return ztykyknmkj20;
    }

    public void setZtykyknmkj20(String pZtykyknmkj20) {
        ztykyknmkj20 = pZtykyknmkj20;
    }

    private String ztyskymdwareki;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYSKYMDWAREKI)
    public String getZtyskymdwareki() {
        return ztyskymdwareki;
    }

    public void setZtyskymdwareki(String pZtyskymdwareki) {
        ztyskymdwareki = pZtyskymdwareki;
    }

    private String ztyhrkkaisuukj;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYHRKKAISUUKJ)
    public String getZtyhrkkaisuukj() {
        return ztyhrkkaisuukj;
    }

    public void setZtyhrkkaisuukj(String pZtyhrkkaisuukj) {
        ztyhrkkaisuukj = pZtyhrkkaisuukj;
    }

    private String ztyhrkkeirokj;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYHRKKEIROKJ)
    public String getZtyhrkkeirokj() {
        return ztyhrkkeirokj;
    }

    public void setZtyhrkkeirokj(String pZtyhrkkeirokj) {
        ztyhrkkeirokj = pZtyhrkkeirokj;
    }

    private Long ztyp11keta;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYP11KETA)
    public Long getZtyp11keta() {
        return ztyp11keta;
    }

    public void setZtyp11keta(Long pZtyp11keta) {
        ztyp11keta = pZtyp11keta;
    }

    private Long ztyskhr;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYSKHR)
    public Long getZtyskhr() {
        return ztyskhr;
    }

    public void setZtyskhr(Long pZtyskhr) {
        ztyskhr = pZtyskhr;
    }

    private String ztyjizensyoukaiyouhyj;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYJIZENSYOUKAIYOUHYJ)
    public String getZtyjizensyoukaiyouhyj() {
        return ztyjizensyoukaiyouhyj;
    }

    public void setZtyjizensyoukaiyouhyj(String pZtyjizensyoukaiyouhyj) {
        ztyjizensyoukaiyouhyj = pZtyjizensyoukaiyouhyj;
    }

    private String ztytntusygyouhaiinfo;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYTNTUSYGYOUHAIINFO)
    public String getZtytntusygyouhaiinfo() {
        return ztytntusygyouhaiinfo;
    }

    public void setZtytntusygyouhaiinfo(String pZtytntusygyouhaiinfo) {
        ztytntusygyouhaiinfo = pZtytntusygyouhaiinfo;
    }

    private String ztyhrkkeirobtjhmidasi;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYHRKKEIROBTJHMIDASI)
    public String getZtyhrkkeirobtjhmidasi() {
        return ztyhrkkeirobtjhmidasi;
    }

    public void setZtyhrkkeirobtjhmidasi(String pZtyhrkkeirobtjhmidasi) {
        ztyhrkkeirobtjhmidasi = pZtyhrkkeirobtjhmidasi;
    }

    private String ztyhrkkeirobtjh;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYHRKKEIROBTJH)
    public String getZtyhrkkeirobtjh() {
        return ztyhrkkeirobtjh;
    }

    public void setZtyhrkkeirobtjh(String pZtyhrkkeirobtjh) {
        ztyhrkkeirobtjh = pZtyhrkkeirobtjh;
    }

    private String ztyhknsyuruimei;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYHKNSYURUIMEI)
    public String getZtyhknsyuruimei() {
        return ztyhknsyuruimei;
    }

    public void setZtyhknsyuruimei(String pZtyhknsyuruimei) {
        ztyhknsyuruimei = pZtyhknsyuruimei;
    }

    private String ztybkofccd;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYBKOFCCD)
    public String getZtybkofccd() {
        return ztybkofccd;
    }

    public void setZtybkofccd(String pZtybkofccd) {
        ztybkofccd = pZtybkofccd;
    }

    private String ztydbskyoteiymd;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYDBSKYOTEIYMD)
    public String getZtydbskyoteiymd() {
        return ztydbskyoteiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtydbskyoteiymd(String pZtydbskyoteiymd) {
        ztydbskyoteiymd = pZtydbskyoteiymd;
    }

    private String ztyminyukaisuu;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYMINYUKAISUU)
    public String getZtyminyukaisuu() {
        return ztyminyukaisuu;
    }

    public void setZtyminyukaisuu(String pZtyminyukaisuu) {
        ztyminyukaisuu = pZtyminyukaisuu;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztyvitkaiinno;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITKAIINNO)
    public String getZtyvitkaiinno() {
        return ztyvitkaiinno;
    }

    public void setZtyvitkaiinno(String pZtyvitkaiinno) {
        ztyvitkaiinno = pZtyvitkaiinno;
    }

    private String ztyvitkykym;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITKYKYM)
    public String getZtyvitkykym() {
        return ztyvitkykym;
    }

    public void setZtyvitkykym(String pZtyvitkykym) {
        ztyvitkykym = pZtyvitkykym;
    }

    private String ztyvitskymd;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITSKYMD)
    public String getZtyvitskymd() {
        return ztyvitskymd;
    }

    public void setZtyvitskymd(String pZtyvitskymd) {
        ztyvitskymd = pZtyvitskymd;
    }

    private String ztyvithrkkaisuu;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITHRKKAISUU)
    public String getZtyvithrkkaisuu() {
        return ztyvithrkkaisuu;
    }

    public void setZtyvithrkkaisuu(String pZtyvithrkkaisuu) {
        ztyvithrkkaisuu = pZtyvithrkkaisuu;
    }

    private String ztyvithrkkeiro;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITHRKKEIRO)
    public String getZtyvithrkkeiro() {
        return ztyvithrkkeiro;
    }

    public void setZtyvithrkkeiro(String pZtyvithrkkeiro) {
        ztyvithrkkeiro = pZtyvithrkkeiro;
    }

    private Long ztyzkomivitriyoury;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYZKOMIVITRIYOURY)
    public Long getZtyzkomivitriyoury() {
        return ztyzkomivitriyoury;
    }

    public void setZtyzkomivitriyoury(Long pZtyzkomivitriyoury) {
        ztyzkomivitriyoury = pZtyzkomivitriyoury;
    }

    private String ztyvitnyknkaisuu;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITNYKNKAISUU)
    public String getZtyvitnyknkaisuu() {
        return ztyvitnyknkaisuu;
    }

    public void setZtyvitnyknkaisuu(String pZtyvitnyknkaisuu) {
        ztyvitnyknkaisuu = pZtyvitnyknkaisuu;
    }

    private String ztyvitbikou;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYVITBIKOU)
    public String getZtyvitbikou() {
        return ztyvitbikou;
    }

    public void setZtyvitbikou(String pZtyvitbikou) {
        ztyvitbikou = pZtyvitbikou;
    }

    private String ztyyobiv25;

    @Column(name=GenZT_DrtenSkKykDtlSyokaiTy.ZTYYOBIV25)
    public String getZtyyobiv25() {
        return ztyyobiv25;
    }

    public void setZtyyobiv25(String pZtyyobiv25) {
        ztyyobiv25 = pZtyyobiv25;
    }
}