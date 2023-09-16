package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.id.PKZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.GenQZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiRn;

/**
 * 郵政未入契約明細照会用Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_YuseiMinyuKykDtlSyokaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuseiMinyuKykDtlSyokaiRn}</td><td colspan="3">郵政未入契約明細照会用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsakuseiym zrnsakuseiym}</td><td>（連携用）作成年月</td><td align="center">{@link PKZT_YuseiMinyuKykDtlSyokaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_YuseiMinyuKykDtlSyokaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntntusycd zrntntusycd}</td><td>（連携用）担当者コード</td><td align="center">{@link PKZT_YuseiMinyuKykDtlSyokaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_YuseiMinyuKykDtlSyokaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpjyuutouyymmwareki4keta zrnpjyuutouyymmwareki4keta}</td><td>（連携用）保険料充当年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymwareki4keta zrnkykymwareki4keta}</td><td>（連携用）契約年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakinm zrnatesakinm}</td><td>（連携用）宛先名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuujyutuymdyofuri zrnminyuujyutuymdyofuri}</td><td>（連携用）未入充当年月（預振）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyuujyutuymdyofuriigi zrnminyuujyutuymdyofuriigi}</td><td>（連携用）未入充当年月（預振以外）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassinka zrnhassinka}</td><td>（連携用）発信課</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntelno15keta zrntelno15keta}</td><td>（連携用）電話番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyymwareki4keta zrnbsyymwareki4keta}</td><td>（連携用）募集年月（和暦）（４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntntusynm zrntntusynm}</td><td>（連携用）担当者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbnkj zrnkydatkikbnkj}</td><td>（連携用）共同扱区分（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj20 zrnkyknmkj20}</td><td>（連携用）契約者名（漢字）（２０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukj zrnhrkkaisuukj}</td><td>（連携用）払込回数（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokj zrnhrkkeirokj}</td><td>（連携用）払込経路（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnp11keta zrnp11keta}</td><td>（連携用）保険料（１１桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnknkimnyuuryukj zrnknkimnyuuryukj}</td><td>（連携用）今回未入理由（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaiminyuuji zrnjikaiminyuuji}</td><td>（連携用）次回未入時</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntntusygyouhaiinfo zrntntusygyouhaiinfo}</td><td>（連携用）担当者業廃情報</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirobtjhmidasi zrnhrkkeirobtjhmidasi}</td><td>（連携用）払込経路別情報見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirobtjh zrnhrkkeirobtjh}</td><td>（連携用）払込経路別情報</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruimei zrnhknsyuruimei}</td><td>（連携用）保険種類名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbkofccd zrnbkofccd}</td><td>（連携用）バックオフィスコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndbskyoteiymd zrndbskyoteiymd}</td><td>（連携用）ＤＢ削除予定年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv23 zrnyobiv23}</td><td>（連携用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuseiMinyuKykDtlSyokaiRn
 * @see     PKZT_YuseiMinyuKykDtlSyokaiRn
 * @see     QZT_YuseiMinyuKykDtlSyokaiRn
 * @see     GenQZT_YuseiMinyuKykDtlSyokaiRn
 */
@MappedSuperclass
@Table(name=GenZT_YuseiMinyuKykDtlSyokaiRn.TABLE_NAME)
@IdClass(value=PKZT_YuseiMinyuKykDtlSyokaiRn.class)
public abstract class GenZT_YuseiMinyuKykDtlSyokaiRn extends AbstractExDBEntityForZDB<ZT_YuseiMinyuKykDtlSyokaiRn, PKZT_YuseiMinyuKykDtlSyokaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YuseiMinyuKykDtlSyokaiRn";
    public static final String ZRNSAKUSEIYM             = "zrnsakuseiym";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNTNTUSYCD              = "zrntntusycd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNPJYUUTOUYYMMWAREKI4KETA = "zrnpjyuutouyymmwareki4keta";
    public static final String ZRNKYKYMWAREKI4KETA      = "zrnkykymwareki4keta";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNATESAKINM             = "zrnatesakinm";
    public static final String ZRNMINYUUJYUTUYMDYOFURI  = "zrnminyuujyutuymdyofuri";
    public static final String ZRNMINYUUJYUTUYMDYOFURIIGI = "zrnminyuujyutuymdyofuriigi";
    public static final String ZRNHASSINKA              = "zrnhassinka";
    public static final String ZRNTELNO15KETA           = "zrntelno15keta";
    public static final String ZRNBSYYMWAREKI4KETA      = "zrnbsyymwareki4keta";
    public static final String ZRNTNTUSYNM              = "zrntntusynm";
    public static final String ZRNKYDATKIKBNKJ          = "zrnkydatkikbnkj";
    public static final String ZRNKYKNMKJ20             = "zrnkyknmkj20";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNHRKKAISUUKJ           = "zrnhrkkaisuukj";
    public static final String ZRNHRKKEIROKJ            = "zrnhrkkeirokj";
    public static final String ZRNP11KETA               = "zrnp11keta";
    public static final String ZRNKNKIMNYUURYUKJ        = "zrnknkimnyuuryukj";
    public static final String ZRNJIKAIMINYUUJI         = "zrnjikaiminyuuji";
    public static final String ZRNTNTUSYGYOUHAIINFO     = "zrntntusygyouhaiinfo";
    public static final String ZRNHRKKEIROBTJHMIDASI    = "zrnhrkkeirobtjhmidasi";
    public static final String ZRNHRKKEIROBTJH          = "zrnhrkkeirobtjh";
    public static final String ZRNHKNSYURUIMEI          = "zrnhknsyuruimei";
    public static final String ZRNBKOFCCD               = "zrnbkofccd";
    public static final String ZRNDBSKYOTEIYMD          = "zrndbskyoteiymd";
    public static final String ZRNYOBIV23               = "zrnyobiv23";

    private final PKZT_YuseiMinyuKykDtlSyokaiRn primaryKey;

    public GenZT_YuseiMinyuKykDtlSyokaiRn() {
        primaryKey = new PKZT_YuseiMinyuKykDtlSyokaiRn();
    }

    public GenZT_YuseiMinyuKykDtlSyokaiRn(
        String pZrnsakuseiym,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono
    ) {
        primaryKey = new PKZT_YuseiMinyuKykDtlSyokaiRn(
            pZrnsakuseiym,
            pZrnbsydrtencd,
            pZrntntusycd,
            pZrnsyono
        );
    }

    @Transient
    @Override
    public PKZT_YuseiMinyuKykDtlSyokaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YuseiMinyuKykDtlSyokaiRn> getMetaClass() {
        return QZT_YuseiMinyuKykDtlSyokaiRn.class;
    }

    @Id
    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNSAKUSEIYM)
    public String getZrnsakuseiym() {
        return getPrimaryKey().getZrnsakuseiym();
    }

    public void setZrnsakuseiym(String pZrnsakuseiym) {
        getPrimaryKey().setZrnsakuseiym(pZrnsakuseiym);
    }

    @Id
    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    @Id
    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNTNTUSYCD)
    public String getZrntntusycd() {
        return getPrimaryKey().getZrntntusycd();
    }

    public void setZrntntusycd(String pZrntntusycd) {
        getPrimaryKey().setZrntntusycd(pZrntntusycd);
    }

    @Id
    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnpjyuutouyymmwareki4keta;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNPJYUUTOUYYMMWAREKI4KETA)
    public String getZrnpjyuutouyymmwareki4keta() {
        return zrnpjyuutouyymmwareki4keta;
    }

    public void setZrnpjyuutouyymmwareki4keta(String pZrnpjyuutouyymmwareki4keta) {
        zrnpjyuutouyymmwareki4keta = pZrnpjyuutouyymmwareki4keta;
    }

    private String zrnkykymwareki4keta;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNKYKYMWAREKI4KETA)
    public String getZrnkykymwareki4keta() {
        return zrnkykymwareki4keta;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkykymwareki4keta(String pZrnkykymwareki4keta) {
        zrnkykymwareki4keta = pZrnkykymwareki4keta;
    }

    private String zrncifcd;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnatesakinm;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNATESAKINM)
    public String getZrnatesakinm() {
        return zrnatesakinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakinm(String pZrnatesakinm) {
        zrnatesakinm = pZrnatesakinm;
    }

    private String zrnminyuujyutuymdyofuri;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNMINYUUJYUTUYMDYOFURI)
    public String getZrnminyuujyutuymdyofuri() {
        return zrnminyuujyutuymdyofuri;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuujyutuymdyofuri(String pZrnminyuujyutuymdyofuri) {
        zrnminyuujyutuymdyofuri = pZrnminyuujyutuymdyofuri;
    }

    private String zrnminyuujyutuymdyofuriigi;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNMINYUUJYUTUYMDYOFURIIGI)
    public String getZrnminyuujyutuymdyofuriigi() {
        return zrnminyuujyutuymdyofuriigi;
    }

    @DataConvert("toMultiByte")
    public void setZrnminyuujyutuymdyofuriigi(String pZrnminyuujyutuymdyofuriigi) {
        zrnminyuujyutuymdyofuriigi = pZrnminyuujyutuymdyofuriigi;
    }

    private String zrnhassinka;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHASSINKA)
    public String getZrnhassinka() {
        return zrnhassinka;
    }

    @DataConvert("toMultiByte")
    public void setZrnhassinka(String pZrnhassinka) {
        zrnhassinka = pZrnhassinka;
    }

    private String zrntelno15keta;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNTELNO15KETA)
    public String getZrntelno15keta() {
        return zrntelno15keta;
    }

    @DataConvert("toMultiByte")
    public void setZrntelno15keta(String pZrntelno15keta) {
        zrntelno15keta = pZrntelno15keta;
    }

    private String zrnbsyymwareki4keta;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNBSYYMWAREKI4KETA)
    public String getZrnbsyymwareki4keta() {
        return zrnbsyymwareki4keta;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnbsyymwareki4keta(String pZrnbsyymwareki4keta) {
        zrnbsyymwareki4keta = pZrnbsyymwareki4keta;
    }

    private String zrntntusynm;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNTNTUSYNM)
    public String getZrntntusynm() {
        return zrntntusynm;
    }

    @DataConvert("toMultiByte")
    public void setZrntntusynm(String pZrntntusynm) {
        zrntntusynm = pZrntntusynm;
    }

    private String zrnkydatkikbnkj;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNKYDATKIKBNKJ)
    public String getZrnkydatkikbnkj() {
        return zrnkydatkikbnkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkydatkikbnkj(String pZrnkydatkikbnkj) {
        zrnkydatkikbnkj = pZrnkydatkikbnkj;
    }

    private String zrnkyknmkj20;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNKYKNMKJ20)
    public String getZrnkyknmkj20() {
        return zrnkyknmkj20;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj20(String pZrnkyknmkj20) {
        zrnkyknmkj20 = pZrnkyknmkj20;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnhrkkaisuukj;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHRKKAISUUKJ)
    public String getZrnhrkkaisuukj() {
        return zrnhrkkaisuukj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkaisuukj(String pZrnhrkkaisuukj) {
        zrnhrkkaisuukj = pZrnhrkkaisuukj;
    }

    private String zrnhrkkeirokj;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHRKKEIROKJ)
    public String getZrnhrkkeirokj() {
        return zrnhrkkeirokj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkeirokj(String pZrnhrkkeirokj) {
        zrnhrkkeirokj = pZrnhrkkeirokj;
    }

    private Long zrnp11keta;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNP11KETA)
    public Long getZrnp11keta() {
        return zrnp11keta;
    }

    public void setZrnp11keta(Long pZrnp11keta) {
        zrnp11keta = pZrnp11keta;
    }

    private String zrnknkimnyuuryukj;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNKNKIMNYUURYUKJ)
    public String getZrnknkimnyuuryukj() {
        return zrnknkimnyuuryukj;
    }

    @DataConvert("toMultiByte")
    public void setZrnknkimnyuuryukj(String pZrnknkimnyuuryukj) {
        zrnknkimnyuuryukj = pZrnknkimnyuuryukj;
    }

    private String zrnjikaiminyuuji;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNJIKAIMINYUUJI)
    public String getZrnjikaiminyuuji() {
        return zrnjikaiminyuuji;
    }

    @DataConvert("toMultiByte")
    public void setZrnjikaiminyuuji(String pZrnjikaiminyuuji) {
        zrnjikaiminyuuji = pZrnjikaiminyuuji;
    }

    private String zrntntusygyouhaiinfo;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNTNTUSYGYOUHAIINFO)
    public String getZrntntusygyouhaiinfo() {
        return zrntntusygyouhaiinfo;
    }

    @DataConvert("toMultiByte")
    public void setZrntntusygyouhaiinfo(String pZrntntusygyouhaiinfo) {
        zrntntusygyouhaiinfo = pZrntntusygyouhaiinfo;
    }

    private String zrnhrkkeirobtjhmidasi;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHRKKEIROBTJHMIDASI)
    public String getZrnhrkkeirobtjhmidasi() {
        return zrnhrkkeirobtjhmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkeirobtjhmidasi(String pZrnhrkkeirobtjhmidasi) {
        zrnhrkkeirobtjhmidasi = pZrnhrkkeirobtjhmidasi;
    }

    private String zrnhrkkeirobtjh;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHRKKEIROBTJH)
    public String getZrnhrkkeirobtjh() {
        return zrnhrkkeirobtjh;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkeirobtjh(String pZrnhrkkeirobtjh) {
        zrnhrkkeirobtjh = pZrnhrkkeirobtjh;
    }

    private String zrnhknsyuruimei;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNHKNSYURUIMEI)
    public String getZrnhknsyuruimei() {
        return zrnhknsyuruimei;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknsyuruimei(String pZrnhknsyuruimei) {
        zrnhknsyuruimei = pZrnhknsyuruimei;
    }

    private String zrnbkofccd;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNBKOFCCD)
    public String getZrnbkofccd() {
        return zrnbkofccd;
    }

    public void setZrnbkofccd(String pZrnbkofccd) {
        zrnbkofccd = pZrnbkofccd;
    }

    private String zrndbskyoteiymd;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNDBSKYOTEIYMD)
    public String getZrndbskyoteiymd() {
        return zrndbskyoteiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndbskyoteiymd(String pZrndbskyoteiymd) {
        zrndbskyoteiymd = pZrndbskyoteiymd;
    }

    private String zrnyobiv23;

    @Column(name=GenZT_YuseiMinyuKykDtlSyokaiRn.ZRNYOBIV23)
    public String getZrnyobiv23() {
        return zrnyobiv23;
    }

    public void setZrnyobiv23(String pZrnyobiv23) {
        zrnyobiv23 = pZrnyobiv23;
    }
}