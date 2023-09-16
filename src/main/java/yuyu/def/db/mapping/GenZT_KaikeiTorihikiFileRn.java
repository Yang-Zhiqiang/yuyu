package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileRn;
import yuyu.def.db.id.PKZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.GenQZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileRn;

/**
 * 会計取引ファイルテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KaikeiTorihikiFileRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KaikeiTorihikiFileRn}</td><td colspan="3">会計取引ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnlen zrnlen}</td><td>（連携用）ＬＥＮ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaikeitani zrnkaikeitani}</td><td>（連携用）会計単位</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsystemkbnnum zrnsystemkbnnum}</td><td>（連携用）システム区分（数値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikiymd zrntorihikiymd}</td><td>（連携用）取引年月日</td><td align="center">{@link PKZT_KaikeiTorihikiFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikinon7 zrntorihikinon7}</td><td>（連携用）取引番号Ｎ７</td><td align="center">{@link PKZT_KaikeiTorihikiFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuryokubasyo zrnnyuuryokubasyo}</td><td>（連携用）入力場所</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuryokusyacd zrnnyuuryokusyacd}</td><td>（連携用）入力者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymdn zrnsyoriymdn}</td><td>（連携用）処理年月日（数値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimekirikbn zrnsimekirikbn}</td><td>（連携用）締切区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessankbn zrnkessankbn}</td><td>（連携用）決算区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaisyakantorihikikbn zrnkaisyakantorihikikbn}</td><td>（連携用）会社間取引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntukekaekbn zrntukekaekbn}</td><td>（連携用）付替区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntablekosuu zrntablekosuu}</td><td>（連携用）テーブル個数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjyoukbnn zrnkanjyoukbnn}</td><td>（連携用）勘定区分（数値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyakukbnn zrntaisyakukbnn}</td><td>（連携用）貸借区分（数値）</td><td align="center">{@link PKZT_KaikeiTorihikiFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjyoukamokucdn zrnkanjyoukamokucdn}</td><td>（連携用）勘定科目コード（数値）</td><td align="center">{@link PKZT_KaikeiTorihikiFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitoubumon zrnsuitoubumon}</td><td>（連携用）出納部門</td><td align="center">{@link PKZT_KaikeiTorihikiFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingaku zrnkingaku}</td><td>（連携用）金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntekiyoucd zrntekiyoucd}</td><td>（連携用）摘要コード</td><td align="center">{@link PKZT_KaikeiTorihikiFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmeisaikanryoukbn zrnmeisaikanryoukbn}</td><td>（連携用）明細完了区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KaikeiTorihikiFileRn
 * @see     PKZT_KaikeiTorihikiFileRn
 * @see     QZT_KaikeiTorihikiFileRn
 * @see     GenQZT_KaikeiTorihikiFileRn
 */
@MappedSuperclass
@Table(name=GenZT_KaikeiTorihikiFileRn.TABLE_NAME)
@IdClass(value=PKZT_KaikeiTorihikiFileRn.class)
public abstract class GenZT_KaikeiTorihikiFileRn extends AbstractExDBEntityForZDB<ZT_KaikeiTorihikiFileRn, PKZT_KaikeiTorihikiFileRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KaikeiTorihikiFileRn";
    public static final String ZRNLEN                   = "zrnlen";
    public static final String ZRNKAIKEITANI            = "zrnkaikeitani";
    public static final String ZRNSYSTEMKBNNUM          = "zrnsystemkbnnum";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNTORIHIKIYMD           = "zrntorihikiymd";
    public static final String ZRNTORIHIKINON7          = "zrntorihikinon7";
    public static final String ZRNNYUURYOKUBASYO        = "zrnnyuuryokubasyo";
    public static final String ZRNNYUURYOKUSYACD        = "zrnnyuuryokusyacd";
    public static final String ZRNSYORIYMDN             = "zrnsyoriymdn";
    public static final String ZRNSIMEKIRIKBN           = "zrnsimekirikbn";
    public static final String ZRNKESSANKBN             = "zrnkessankbn";
    public static final String ZRNYOBIV20               = "zrnyobiv20";
    public static final String ZRNKAISYAKANTORIHIKIKBN  = "zrnkaisyakantorihikikbn";
    public static final String ZRNTUKEKAEKBN            = "zrntukekaekbn";
    public static final String ZRNTABLEKOSUU            = "zrntablekosuu";
    public static final String ZRNKANJYOUKBNN           = "zrnkanjyoukbnn";
    public static final String ZRNTAISYAKUKBNN          = "zrntaisyakukbnn";
    public static final String ZRNKANJYOUKAMOKUCDN      = "zrnkanjyoukamokucdn";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNSUITOUBUMON           = "zrnsuitoubumon";
    public static final String ZRNKINGAKU               = "zrnkingaku";
    public static final String ZRNTEKIYOUCD             = "zrntekiyoucd";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNMEISAIKANRYOUKBN      = "zrnmeisaikanryoukbn";

    private final PKZT_KaikeiTorihikiFileRn primaryKey;

    public GenZT_KaikeiTorihikiFileRn() {
        primaryKey = new PKZT_KaikeiTorihikiFileRn();
    }

    public GenZT_KaikeiTorihikiFileRn(
        String pZrntorihikiymd,
        String pZrntorihikinon7,
        String pZrntaisyakukbnn,
        String pZrnkanjyoukamokucdn,
        String pZrnsuitoubumon,
        String pZrntekiyoucd
    ) {
        primaryKey = new PKZT_KaikeiTorihikiFileRn(
            pZrntorihikiymd,
            pZrntorihikinon7,
            pZrntaisyakukbnn,
            pZrnkanjyoukamokucdn,
            pZrnsuitoubumon,
            pZrntekiyoucd
        );
    }

    @Transient
    @Override
    public PKZT_KaikeiTorihikiFileRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KaikeiTorihikiFileRn> getMetaClass() {
        return QZT_KaikeiTorihikiFileRn.class;
    }

    private String zrnlen;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNLEN)
    public String getZrnlen() {
        return zrnlen;
    }

    public void setZrnlen(String pZrnlen) {
        zrnlen = pZrnlen;
    }

    private String zrnkaikeitani;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNKAIKEITANI)
    public String getZrnkaikeitani() {
        return zrnkaikeitani;
    }

    public void setZrnkaikeitani(String pZrnkaikeitani) {
        zrnkaikeitani = pZrnkaikeitani;
    }

    private String zrnsystemkbnnum;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNSYSTEMKBNNUM)
    public String getZrnsystemkbnnum() {
        return zrnsystemkbnnum;
    }

    public void setZrnsystemkbnnum(String pZrnsystemkbnnum) {
        zrnsystemkbnnum = pZrnsystemkbnnum;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    @Id
    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNTORIHIKIYMD)
    public String getZrntorihikiymd() {
        return getPrimaryKey().getZrntorihikiymd();
    }

    public void setZrntorihikiymd(String pZrntorihikiymd) {
        getPrimaryKey().setZrntorihikiymd(pZrntorihikiymd);
    }

    @Id
    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNTORIHIKINON7)
    public String getZrntorihikinon7() {
        return getPrimaryKey().getZrntorihikinon7();
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrntorihikinon7(String pZrntorihikinon7) {
        getPrimaryKey().setZrntorihikinon7(pZrntorihikinon7);
    }

    private String zrnnyuuryokubasyo;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNNYUURYOKUBASYO)
    public String getZrnnyuuryokubasyo() {
        return zrnnyuuryokubasyo;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnnyuuryokubasyo(String pZrnnyuuryokubasyo) {
        zrnnyuuryokubasyo = pZrnnyuuryokubasyo;
    }

    private String zrnnyuuryokusyacd;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNNYUURYOKUSYACD)
    public String getZrnnyuuryokusyacd() {
        return zrnnyuuryokusyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnnyuuryokusyacd(String pZrnnyuuryokusyacd) {
        zrnnyuuryokusyacd = pZrnnyuuryokusyacd;
    }

    private String zrnsyoriymdn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNSYORIYMDN)
    public String getZrnsyoriymdn() {
        return zrnsyoriymdn;
    }

    public void setZrnsyoriymdn(String pZrnsyoriymdn) {
        zrnsyoriymdn = pZrnsyoriymdn;
    }

    private String zrnsimekirikbn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNSIMEKIRIKBN)
    public String getZrnsimekirikbn() {
        return zrnsimekirikbn;
    }

    public void setZrnsimekirikbn(String pZrnsimekirikbn) {
        zrnsimekirikbn = pZrnsimekirikbn;
    }

    private String zrnkessankbn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNKESSANKBN)
    public String getZrnkessankbn() {
        return zrnkessankbn;
    }

    public void setZrnkessankbn(String pZrnkessankbn) {
        zrnkessankbn = pZrnkessankbn;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }

    private String zrnkaisyakantorihikikbn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNKAISYAKANTORIHIKIKBN)
    public String getZrnkaisyakantorihikikbn() {
        return zrnkaisyakantorihikikbn;
    }

    public void setZrnkaisyakantorihikikbn(String pZrnkaisyakantorihikikbn) {
        zrnkaisyakantorihikikbn = pZrnkaisyakantorihikikbn;
    }

    private String zrntukekaekbn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNTUKEKAEKBN)
    public String getZrntukekaekbn() {
        return zrntukekaekbn;
    }

    public void setZrntukekaekbn(String pZrntukekaekbn) {
        zrntukekaekbn = pZrntukekaekbn;
    }

    private String zrntablekosuu;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNTABLEKOSUU)
    public String getZrntablekosuu() {
        return zrntablekosuu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntablekosuu(String pZrntablekosuu) {
        zrntablekosuu = pZrntablekosuu;
    }

    private String zrnkanjyoukbnn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNKANJYOUKBNN)
    public String getZrnkanjyoukbnn() {
        return zrnkanjyoukbnn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkanjyoukbnn(String pZrnkanjyoukbnn) {
        zrnkanjyoukbnn = pZrnkanjyoukbnn;
    }

    @Id
    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNTAISYAKUKBNN)
    public String getZrntaisyakukbnn() {
        return getPrimaryKey().getZrntaisyakukbnn();
    }

    public void setZrntaisyakukbnn(String pZrntaisyakukbnn) {
        getPrimaryKey().setZrntaisyakukbnn(pZrntaisyakukbnn);
    }

    @Id
    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNKANJYOUKAMOKUCDN)
    public String getZrnkanjyoukamokucdn() {
        return getPrimaryKey().getZrnkanjyoukamokucdn();
    }

    public void setZrnkanjyoukamokucdn(String pZrnkanjyoukamokucdn) {
        getPrimaryKey().setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
    }

    private String zrnyobiv4;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    @Id
    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNSUITOUBUMON)
    public String getZrnsuitoubumon() {
        return getPrimaryKey().getZrnsuitoubumon();
    }

    public void setZrnsuitoubumon(String pZrnsuitoubumon) {
        getPrimaryKey().setZrnsuitoubumon(pZrnsuitoubumon);
    }

    private Long zrnkingaku;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNKINGAKU)
    public Long getZrnkingaku() {
        return zrnkingaku;
    }

    public void setZrnkingaku(Long pZrnkingaku) {
        zrnkingaku = pZrnkingaku;
    }

    @Id
    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNTEKIYOUCD)
    public String getZrntekiyoucd() {
        return getPrimaryKey().getZrntekiyoucd();
    }

    public void setZrntekiyoucd(String pZrntekiyoucd) {
        getPrimaryKey().setZrntekiyoucd(pZrntekiyoucd);
    }

    private String zrnyobiv10;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrnmeisaikanryoukbn;

    @Column(name=GenZT_KaikeiTorihikiFileRn.ZRNMEISAIKANRYOUKBN)
    public String getZrnmeisaikanryoukbn() {
        return zrnmeisaikanryoukbn;
    }

    public void setZrnmeisaikanryoukbn(String pZrnmeisaikanryoukbn) {
        zrnmeisaikanryoukbn = pZrnmeisaikanryoukbn;
    }
}