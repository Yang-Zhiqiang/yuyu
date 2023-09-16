package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriTy;
import yuyu.def.db.id.PKZT_SkKsnKubunKeiriTy;
import yuyu.def.db.meta.GenQZT_SkKsnKubunKeiriTy;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriTy;

/**
 * 新契約決算用区分経理Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SkKsnKubunKeiriTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKsnKubunKeiriTy}</td><td colspan="3">新契約決算用区分経理Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykaikeitani ztykaikeitani}</td><td>（中継用）会計単位</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysystemkbnnum ztysystemkbnnum}</td><td>（中継用）システム区分（数値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikiymd ztytorihikiymd}</td><td>（中継用）取引年月日</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikinon7 ztytorihikinon7}</td><td>（中継用）取引番号Ｎ７</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuryokubasyo ztynyuuryokubasyo}</td><td>（中継用）入力場所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuryokusyacd ztynyuuryokusyacd}</td><td>（中継用）入力者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymdn ztysyoriymdn}</td><td>（中継用）処理年月日（数値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykessankbn ztykessankbn}</td><td>（中継用）決算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyonlinesyorikbn ztyonlinesyorikbn}</td><td>（中継用）オンライン処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv28 ztyyobiv28}</td><td>（中継用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjyoukbnn ztykanjyoukbnn}</td><td>（中継用）勘定区分（数値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyakukbnn ztytaisyakukbnn}</td><td>（中継用）貸借区分（数値）</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjyoukamokucdn ztykanjyoukamokucdn}</td><td>（中継用）勘定科目コード（数値）</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitoubumoncd ztysuitoubumoncd}</td><td>（中継用）出納部門コード</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingaku ztykingaku}</td><td>（中継用）金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykizokusegment ztykizokusegment}</td><td>（中継用）帰属セグメント</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaitesegment ztyaitesegment}</td><td>（中継用）相手セグメント</td><td align="center">{@link PKZT_SkKsnKubunKeiriTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv23 ztyyobiv23}</td><td>（中継用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKsnKubunKeiriTy
 * @see     PKZT_SkKsnKubunKeiriTy
 * @see     QZT_SkKsnKubunKeiriTy
 * @see     GenQZT_SkKsnKubunKeiriTy
 */
@MappedSuperclass
@Table(name=GenZT_SkKsnKubunKeiriTy.TABLE_NAME)
@IdClass(value=PKZT_SkKsnKubunKeiriTy.class)
public abstract class GenZT_SkKsnKubunKeiriTy extends AbstractExDBEntity<ZT_SkKsnKubunKeiriTy, PKZT_SkKsnKubunKeiriTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkKsnKubunKeiriTy";
    public static final String ZTYKAIKEITANI            = "ztykaikeitani";
    public static final String ZTYSYSTEMKBNNUM          = "ztysystemkbnnum";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYTORIHIKIYMD           = "ztytorihikiymd";
    public static final String ZTYTORIHIKINON7          = "ztytorihikinon7";
    public static final String ZTYNYUURYOKUBASYO        = "ztynyuuryokubasyo";
    public static final String ZTYNYUURYOKUSYACD        = "ztynyuuryokusyacd";
    public static final String ZTYSYORIYMDN             = "ztysyoriymdn";
    public static final String ZTYKESSANKBN             = "ztykessankbn";
    public static final String ZTYONLINESYORIKBN        = "ztyonlinesyorikbn";
    public static final String ZTYYOBIV28               = "ztyyobiv28";
    public static final String ZTYKANJYOUKBNN           = "ztykanjyoukbnn";
    public static final String ZTYTAISYAKUKBNN          = "ztytaisyakukbnn";
    public static final String ZTYKANJYOUKAMOKUCDN      = "ztykanjyoukamokucdn";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYSUITOUBUMONCD         = "ztysuitoubumoncd";
    public static final String ZTYKINGAKU               = "ztykingaku";
    public static final String ZTYKIZOKUSEGMENT         = "ztykizokusegment";
    public static final String ZTYAITESEGMENT           = "ztyaitesegment";
    public static final String ZTYYOBIV23               = "ztyyobiv23";

    private final PKZT_SkKsnKubunKeiriTy primaryKey;

    public GenZT_SkKsnKubunKeiriTy() {
        primaryKey = new PKZT_SkKsnKubunKeiriTy();
    }

    public GenZT_SkKsnKubunKeiriTy(
        String pZtytorihikiymd,
        String pZtytorihikinon7,
        String pZtytaisyakukbnn,
        String pZtykanjyoukamokucdn,
        String pZtysuitoubumoncd,
        String pZtykizokusegment,
        String pZtyaitesegment
    ) {
        primaryKey = new PKZT_SkKsnKubunKeiriTy(
            pZtytorihikiymd,
            pZtytorihikinon7,
            pZtytaisyakukbnn,
            pZtykanjyoukamokucdn,
            pZtysuitoubumoncd,
            pZtykizokusegment,
            pZtyaitesegment
        );
    }

    @Transient
    @Override
    public PKZT_SkKsnKubunKeiriTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkKsnKubunKeiriTy> getMetaClass() {
        return QZT_SkKsnKubunKeiriTy.class;
    }

    private String ztykaikeitani;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYKAIKEITANI)
    public String getZtykaikeitani() {
        return ztykaikeitani;
    }

    public void setZtykaikeitani(String pZtykaikeitani) {
        ztykaikeitani = pZtykaikeitani;
    }

    private String ztysystemkbnnum;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYSYSTEMKBNNUM)
    public String getZtysystemkbnnum() {
        return ztysystemkbnnum;
    }

    public void setZtysystemkbnnum(String pZtysystemkbnnum) {
        ztysystemkbnnum = pZtysystemkbnnum;
    }

    private String ztysyoricd;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYTORIHIKIYMD)
    public String getZtytorihikiymd() {
        return getPrimaryKey().getZtytorihikiymd();
    }

    public void setZtytorihikiymd(String pZtytorihikiymd) {
        getPrimaryKey().setZtytorihikiymd(pZtytorihikiymd);
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYTORIHIKINON7)
    public String getZtytorihikinon7() {
        return getPrimaryKey().getZtytorihikinon7();
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZtytorihikinon7(String pZtytorihikinon7) {
        getPrimaryKey().setZtytorihikinon7(pZtytorihikinon7);
    }

    private String ztynyuuryokubasyo;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYNYUURYOKUBASYO)
    public String getZtynyuuryokubasyo() {
        return ztynyuuryokubasyo;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZtynyuuryokubasyo(String pZtynyuuryokubasyo) {
        ztynyuuryokubasyo = pZtynyuuryokubasyo;
    }

    private String ztynyuuryokusyacd;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYNYUURYOKUSYACD)
    public String getZtynyuuryokusyacd() {
        return ztynyuuryokusyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtynyuuryokusyacd(String pZtynyuuryokusyacd) {
        ztynyuuryokusyacd = pZtynyuuryokusyacd;
    }

    private String ztysyoriymdn;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYSYORIYMDN)
    public String getZtysyoriymdn() {
        return ztysyoriymdn;
    }

    public void setZtysyoriymdn(String pZtysyoriymdn) {
        ztysyoriymdn = pZtysyoriymdn;
    }

    private String ztykessankbn;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYKESSANKBN)
    public String getZtykessankbn() {
        return ztykessankbn;
    }

    public void setZtykessankbn(String pZtykessankbn) {
        ztykessankbn = pZtykessankbn;
    }

    private String ztyonlinesyorikbn;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYONLINESYORIKBN)
    public String getZtyonlinesyorikbn() {
        return ztyonlinesyorikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyonlinesyorikbn(String pZtyonlinesyorikbn) {
        ztyonlinesyorikbn = pZtyonlinesyorikbn;
    }

    private String ztyyobiv28;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYYOBIV28)
    public String getZtyyobiv28() {
        return ztyyobiv28;
    }

    public void setZtyyobiv28(String pZtyyobiv28) {
        ztyyobiv28 = pZtyyobiv28;
    }

    private String ztykanjyoukbnn;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYKANJYOUKBNN)
    public String getZtykanjyoukbnn() {
        return ztykanjyoukbnn;
    }

    public void setZtykanjyoukbnn(String pZtykanjyoukbnn) {
        ztykanjyoukbnn = pZtykanjyoukbnn;
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYTAISYAKUKBNN)
    public String getZtytaisyakukbnn() {
        return getPrimaryKey().getZtytaisyakukbnn();
    }

    public void setZtytaisyakukbnn(String pZtytaisyakukbnn) {
        getPrimaryKey().setZtytaisyakukbnn(pZtytaisyakukbnn);
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYKANJYOUKAMOKUCDN)
    public String getZtykanjyoukamokucdn() {
        return getPrimaryKey().getZtykanjyoukamokucdn();
    }

    public void setZtykanjyoukamokucdn(String pZtykanjyoukamokucdn) {
        getPrimaryKey().setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
    }

    private String ztyyobiv4;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYSUITOUBUMONCD)
    public String getZtysuitoubumoncd() {
        return getPrimaryKey().getZtysuitoubumoncd();
    }

    public void setZtysuitoubumoncd(String pZtysuitoubumoncd) {
        getPrimaryKey().setZtysuitoubumoncd(pZtysuitoubumoncd);
    }

    private Long ztykingaku;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYKINGAKU)
    public Long getZtykingaku() {
        return ztykingaku;
    }

    public void setZtykingaku(Long pZtykingaku) {
        ztykingaku = pZtykingaku;
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYKIZOKUSEGMENT)
    public String getZtykizokusegment() {
        return getPrimaryKey().getZtykizokusegment();
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtykizokusegment(String pZtykizokusegment) {
        getPrimaryKey().setZtykizokusegment(pZtykizokusegment);
    }

    @Id
    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYAITESEGMENT)
    public String getZtyaitesegment() {
        return getPrimaryKey().getZtyaitesegment();
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyaitesegment(String pZtyaitesegment) {
        getPrimaryKey().setZtyaitesegment(pZtyaitesegment);
    }

    private String ztyyobiv23;

    @Column(name=GenZT_SkKsnKubunKeiriTy.ZTYYOBIV23)
    public String getZtyyobiv23() {
        return ztyyobiv23;
    }

    public void setZtyyobiv23(String pZtyyobiv23) {
        ztyyobiv23 = pZtyyobiv23;
    }
}
