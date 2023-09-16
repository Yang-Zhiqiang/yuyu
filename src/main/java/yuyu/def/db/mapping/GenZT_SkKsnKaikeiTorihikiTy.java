package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.id.PKZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.meta.GenQZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiTy;

/**
 * 新契約決算用会計取引Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SkKsnKaikeiTorihikiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKsnKaikeiTorihikiTy}</td><td colspan="3">新契約決算用会計取引Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtylen ztylen}</td><td>（中継用）ＬＥＮ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaikeitani ztykaikeitani}</td><td>（中継用）会計単位</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysystemkbnnum ztysystemkbnnum}</td><td>（中継用）システム区分（数値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikiymd ztytorihikiymd}</td><td>（中継用）取引年月日</td><td align="center">{@link PKZT_SkKsnKaikeiTorihikiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikinon7 ztytorihikinon7}</td><td>（中継用）取引番号Ｎ７</td><td align="center">{@link PKZT_SkKsnKaikeiTorihikiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuryokubasyo ztynyuuryokubasyo}</td><td>（中継用）入力場所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuryokusyacd ztynyuuryokusyacd}</td><td>（中継用）入力者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymdn ztysyoriymdn}</td><td>（中継用）処理年月日（数値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimekirikbn ztysimekirikbn}</td><td>（中継用）締切区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykessankbn ztykessankbn}</td><td>（中継用）決算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaisyakantorihikikbn ztykaisyakantorihikikbn}</td><td>（中継用）会社間取引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytukekaekbn ztytukekaekbn}</td><td>（中継用）付替区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytablekosuu ztytablekosuu}</td><td>（中継用）テーブル個数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjyoukbnn ztykanjyoukbnn}</td><td>（中継用）勘定区分（数値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyakukbnn ztytaisyakukbnn}</td><td>（中継用）貸借区分（数値）</td><td align="center">{@link PKZT_SkKsnKaikeiTorihikiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjyoukamokucdn ztykanjyoukamokucdn}</td><td>（中継用）勘定科目コード（数値）</td><td align="center">{@link PKZT_SkKsnKaikeiTorihikiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitoubumon ztysuitoubumon}</td><td>（中継用）出納部門</td><td align="center">{@link PKZT_SkKsnKaikeiTorihikiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingaku ztykingaku}</td><td>（中継用）金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytekiyoucd ztytekiyoucd}</td><td>（中継用）摘要コード</td><td align="center">{@link PKZT_SkKsnKaikeiTorihikiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymeisaikanryoukbn ztymeisaikanryoukbn}</td><td>（中継用）明細完了区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKsnKaikeiTorihikiTy
 * @see     PKZT_SkKsnKaikeiTorihikiTy
 * @see     QZT_SkKsnKaikeiTorihikiTy
 * @see     GenQZT_SkKsnKaikeiTorihikiTy
 */
@MappedSuperclass
@Table(name=GenZT_SkKsnKaikeiTorihikiTy.TABLE_NAME)
@IdClass(value=PKZT_SkKsnKaikeiTorihikiTy.class)
public abstract class GenZT_SkKsnKaikeiTorihikiTy extends AbstractExDBEntity<ZT_SkKsnKaikeiTorihikiTy, PKZT_SkKsnKaikeiTorihikiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkKsnKaikeiTorihikiTy";
    public static final String ZTYLEN                   = "ztylen";
    public static final String ZTYKAIKEITANI            = "ztykaikeitani";
    public static final String ZTYSYSTEMKBNNUM          = "ztysystemkbnnum";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYTORIHIKIYMD           = "ztytorihikiymd";
    public static final String ZTYTORIHIKINON7          = "ztytorihikinon7";
    public static final String ZTYNYUURYOKUBASYO        = "ztynyuuryokubasyo";
    public static final String ZTYNYUURYOKUSYACD        = "ztynyuuryokusyacd";
    public static final String ZTYSYORIYMDN             = "ztysyoriymdn";
    public static final String ZTYSIMEKIRIKBN           = "ztysimekirikbn";
    public static final String ZTYKESSANKBN             = "ztykessankbn";
    public static final String ZTYYOBIV20               = "ztyyobiv20";
    public static final String ZTYKAISYAKANTORIHIKIKBN  = "ztykaisyakantorihikikbn";
    public static final String ZTYTUKEKAEKBN            = "ztytukekaekbn";
    public static final String ZTYTABLEKOSUU            = "ztytablekosuu";
    public static final String ZTYKANJYOUKBNN           = "ztykanjyoukbnn";
    public static final String ZTYTAISYAKUKBNN          = "ztytaisyakukbnn";
    public static final String ZTYKANJYOUKAMOKUCDN      = "ztykanjyoukamokucdn";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYSUITOUBUMON           = "ztysuitoubumon";
    public static final String ZTYKINGAKU               = "ztykingaku";
    public static final String ZTYTEKIYOUCD             = "ztytekiyoucd";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYMEISAIKANRYOUKBN      = "ztymeisaikanryoukbn";

    private final PKZT_SkKsnKaikeiTorihikiTy primaryKey;

    public GenZT_SkKsnKaikeiTorihikiTy() {
        primaryKey = new PKZT_SkKsnKaikeiTorihikiTy();
    }

    public GenZT_SkKsnKaikeiTorihikiTy(
        String pZtytorihikiymd,
        String pZtytorihikinon7,
        String pZtytaisyakukbnn,
        String pZtykanjyoukamokucdn,
        String pZtysuitoubumon,
        String pZtytekiyoucd
    ) {
        primaryKey = new PKZT_SkKsnKaikeiTorihikiTy(
            pZtytorihikiymd,
            pZtytorihikinon7,
            pZtytaisyakukbnn,
            pZtykanjyoukamokucdn,
            pZtysuitoubumon,
            pZtytekiyoucd
        );
    }

    @Transient
    @Override
    public PKZT_SkKsnKaikeiTorihikiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkKsnKaikeiTorihikiTy> getMetaClass() {
        return QZT_SkKsnKaikeiTorihikiTy.class;
    }

    private String ztylen;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYLEN)
    public String getZtylen() {
        return ztylen;
    }

    public void setZtylen(String pZtylen) {
        ztylen = pZtylen;
    }

    private String ztykaikeitani;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYKAIKEITANI)
    public String getZtykaikeitani() {
        return ztykaikeitani;
    }

    public void setZtykaikeitani(String pZtykaikeitani) {
        ztykaikeitani = pZtykaikeitani;
    }

    private String ztysystemkbnnum;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYSYSTEMKBNNUM)
    public String getZtysystemkbnnum() {
        return ztysystemkbnnum;
    }

    public void setZtysystemkbnnum(String pZtysystemkbnnum) {
        ztysystemkbnnum = pZtysystemkbnnum;
    }

    private String ztysyoricd;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    @Id
    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYTORIHIKIYMD)
    public String getZtytorihikiymd() {
        return getPrimaryKey().getZtytorihikiymd();
    }

    public void setZtytorihikiymd(String pZtytorihikiymd) {
        getPrimaryKey().setZtytorihikiymd(pZtytorihikiymd);
    }

    @Id
    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYTORIHIKINON7)
    public String getZtytorihikinon7() {
        return getPrimaryKey().getZtytorihikinon7();
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZtytorihikinon7(String pZtytorihikinon7) {
        getPrimaryKey().setZtytorihikinon7(pZtytorihikinon7);
    }

    private String ztynyuuryokubasyo;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYNYUURYOKUBASYO)
    public String getZtynyuuryokubasyo() {
        return ztynyuuryokubasyo;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZtynyuuryokubasyo(String pZtynyuuryokubasyo) {
        ztynyuuryokubasyo = pZtynyuuryokubasyo;
    }

    private String ztynyuuryokusyacd;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYNYUURYOKUSYACD)
    public String getZtynyuuryokusyacd() {
        return ztynyuuryokusyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtynyuuryokusyacd(String pZtynyuuryokusyacd) {
        ztynyuuryokusyacd = pZtynyuuryokusyacd;
    }

    private String ztysyoriymdn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYSYORIYMDN)
    public String getZtysyoriymdn() {
        return ztysyoriymdn;
    }

    public void setZtysyoriymdn(String pZtysyoriymdn) {
        ztysyoriymdn = pZtysyoriymdn;
    }

    private String ztysimekirikbn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYSIMEKIRIKBN)
    public String getZtysimekirikbn() {
        return ztysimekirikbn;
    }

    public void setZtysimekirikbn(String pZtysimekirikbn) {
        ztysimekirikbn = pZtysimekirikbn;
    }

    private String ztykessankbn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYKESSANKBN)
    public String getZtykessankbn() {
        return ztykessankbn;
    }

    public void setZtykessankbn(String pZtykessankbn) {
        ztykessankbn = pZtykessankbn;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }

    private String ztykaisyakantorihikikbn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYKAISYAKANTORIHIKIKBN)
    public String getZtykaisyakantorihikikbn() {
        return ztykaisyakantorihikikbn;
    }

    public void setZtykaisyakantorihikikbn(String pZtykaisyakantorihikikbn) {
        ztykaisyakantorihikikbn = pZtykaisyakantorihikikbn;
    }

    private String ztytukekaekbn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYTUKEKAEKBN)
    public String getZtytukekaekbn() {
        return ztytukekaekbn;
    }

    public void setZtytukekaekbn(String pZtytukekaekbn) {
        ztytukekaekbn = pZtytukekaekbn;
    }

    private String ztytablekosuu;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYTABLEKOSUU)
    public String getZtytablekosuu() {
        return ztytablekosuu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtytablekosuu(String pZtytablekosuu) {
        ztytablekosuu = pZtytablekosuu;
    }

    private String ztykanjyoukbnn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYKANJYOUKBNN)
    public String getZtykanjyoukbnn() {
        return ztykanjyoukbnn;
    }

    public void setZtykanjyoukbnn(String pZtykanjyoukbnn) {
        ztykanjyoukbnn = pZtykanjyoukbnn;
    }

    @Id
    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYTAISYAKUKBNN)
    public String getZtytaisyakukbnn() {
        return getPrimaryKey().getZtytaisyakukbnn();
    }

    public void setZtytaisyakukbnn(String pZtytaisyakukbnn) {
        getPrimaryKey().setZtytaisyakukbnn(pZtytaisyakukbnn);
    }

    @Id
    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYKANJYOUKAMOKUCDN)
    public String getZtykanjyoukamokucdn() {
        return getPrimaryKey().getZtykanjyoukamokucdn();
    }

    public void setZtykanjyoukamokucdn(String pZtykanjyoukamokucdn) {
        getPrimaryKey().setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
    }

    private String ztyyobiv4;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    @Id
    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYSUITOUBUMON)
    public String getZtysuitoubumon() {
        return getPrimaryKey().getZtysuitoubumon();
    }

    public void setZtysuitoubumon(String pZtysuitoubumon) {
        getPrimaryKey().setZtysuitoubumon(pZtysuitoubumon);
    }

    private Long ztykingaku;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYKINGAKU)
    public Long getZtykingaku() {
        return ztykingaku;
    }

    public void setZtykingaku(Long pZtykingaku) {
        ztykingaku = pZtykingaku;
    }

    @Id
    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYTEKIYOUCD)
    public String getZtytekiyoucd() {
        return getPrimaryKey().getZtytekiyoucd();
    }

    public void setZtytekiyoucd(String pZtytekiyoucd) {
        getPrimaryKey().setZtytekiyoucd(pZtytekiyoucd);
    }

    private String ztyyobiv10;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztymeisaikanryoukbn;

    @Column(name=GenZT_SkKsnKaikeiTorihikiTy.ZTYMEISAIKANRYOUKBN)
    public String getZtymeisaikanryoukbn() {
        return ztymeisaikanryoukbn;
    }

    public void setZtymeisaikanryoukbn(String pZtymeisaikanryoukbn) {
        ztymeisaikanryoukbn = pZtymeisaikanryoukbn;
    }
}
