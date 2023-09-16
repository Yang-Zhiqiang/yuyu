package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KubunKeiriFileRn;
import yuyu.def.db.id.PKZT_KubunKeiriFileRn;
import yuyu.def.db.meta.GenQZT_KubunKeiriFileRn;
import yuyu.def.db.meta.QZT_KubunKeiriFileRn;

/**
 * 区分経理ファイルテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KubunKeiriFileRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KubunKeiriFileRn}</td><td colspan="3">区分経理ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkaikeitani zrnkaikeitani}</td><td>（連携用）会計単位</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsystemkbnnum zrnsystemkbnnum}</td><td>（連携用）システム区分（数値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikiymd zrntorihikiymd}</td><td>（連携用）取引年月日</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikinon7 zrntorihikinon7}</td><td>（連携用）取引番号Ｎ７</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuryokubasyo zrnnyuuryokubasyo}</td><td>（連携用）入力場所</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuryokusyacd zrnnyuuryokusyacd}</td><td>（連携用）入力者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymdn zrnsyoriymdn}</td><td>（連携用）処理年月日（数値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessankbn zrnkessankbn}</td><td>（連携用）決算区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnonlinesyorikbn zrnonlinesyorikbn}</td><td>（連携用）オンライン処理区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv28 zrnyobiv28}</td><td>（連携用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjyoukbnn zrnkanjyoukbnn}</td><td>（連携用）勘定区分（数値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyakukbnn zrntaisyakukbnn}</td><td>（連携用）貸借区分（数値）</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjyoukamokucdn zrnkanjyoukamokucdn}</td><td>（連携用）勘定科目コード（数値）</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitoubumoncd zrnsuitoubumoncd}</td><td>（連携用）出納部門コード</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingaku zrnkingaku}</td><td>（連携用）金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkizokusegment zrnkizokusegment}</td><td>（連携用）帰属セグメント</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaitesegment zrnaitesegment}</td><td>（連携用）相手セグメント</td><td align="center">{@link PKZT_KubunKeiriFileRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv23 zrnyobiv23}</td><td>（連携用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KubunKeiriFileRn
 * @see     PKZT_KubunKeiriFileRn
 * @see     QZT_KubunKeiriFileRn
 * @see     GenQZT_KubunKeiriFileRn
 */
@MappedSuperclass
@Table(name=GenZT_KubunKeiriFileRn.TABLE_NAME)
@IdClass(value=PKZT_KubunKeiriFileRn.class)
public abstract class GenZT_KubunKeiriFileRn extends AbstractExDBEntityForZDB<ZT_KubunKeiriFileRn, PKZT_KubunKeiriFileRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KubunKeiriFileRn";
    public static final String ZRNKAIKEITANI            = "zrnkaikeitani";
    public static final String ZRNSYSTEMKBNNUM          = "zrnsystemkbnnum";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNTORIHIKIYMD           = "zrntorihikiymd";
    public static final String ZRNTORIHIKINON7          = "zrntorihikinon7";
    public static final String ZRNNYUURYOKUBASYO        = "zrnnyuuryokubasyo";
    public static final String ZRNNYUURYOKUSYACD        = "zrnnyuuryokusyacd";
    public static final String ZRNSYORIYMDN             = "zrnsyoriymdn";
    public static final String ZRNKESSANKBN             = "zrnkessankbn";
    public static final String ZRNONLINESYORIKBN        = "zrnonlinesyorikbn";
    public static final String ZRNYOBIV28               = "zrnyobiv28";
    public static final String ZRNKANJYOUKBNN           = "zrnkanjyoukbnn";
    public static final String ZRNTAISYAKUKBNN          = "zrntaisyakukbnn";
    public static final String ZRNKANJYOUKAMOKUCDN      = "zrnkanjyoukamokucdn";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNSUITOUBUMONCD         = "zrnsuitoubumoncd";
    public static final String ZRNKINGAKU               = "zrnkingaku";
    public static final String ZRNKIZOKUSEGMENT         = "zrnkizokusegment";
    public static final String ZRNAITESEGMENT           = "zrnaitesegment";
    public static final String ZRNYOBIV23               = "zrnyobiv23";

    private final PKZT_KubunKeiriFileRn primaryKey;

    public GenZT_KubunKeiriFileRn() {
        primaryKey = new PKZT_KubunKeiriFileRn();
    }

    public GenZT_KubunKeiriFileRn(
        String pZrntorihikiymd,
        String pZrntorihikinon7,
        String pZrntaisyakukbnn,
        String pZrnkanjyoukamokucdn,
        String pZrnsuitoubumoncd,
        String pZrnkizokusegment,
        String pZrnaitesegment
    ) {
        primaryKey = new PKZT_KubunKeiriFileRn(
            pZrntorihikiymd,
            pZrntorihikinon7,
            pZrntaisyakukbnn,
            pZrnkanjyoukamokucdn,
            pZrnsuitoubumoncd,
            pZrnkizokusegment,
            pZrnaitesegment
        );
    }

    @Transient
    @Override
    public PKZT_KubunKeiriFileRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KubunKeiriFileRn> getMetaClass() {
        return QZT_KubunKeiriFileRn.class;
    }

    private String zrnkaikeitani;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNKAIKEITANI)
    public String getZrnkaikeitani() {
        return zrnkaikeitani;
    }

    public void setZrnkaikeitani(String pZrnkaikeitani) {
        zrnkaikeitani = pZrnkaikeitani;
    }

    private String zrnsystemkbnnum;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNSYSTEMKBNNUM)
    public String getZrnsystemkbnnum() {
        return zrnsystemkbnnum;
    }

    public void setZrnsystemkbnnum(String pZrnsystemkbnnum) {
        zrnsystemkbnnum = pZrnsystemkbnnum;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNTORIHIKIYMD)
    public String getZrntorihikiymd() {
        return getPrimaryKey().getZrntorihikiymd();
    }

    public void setZrntorihikiymd(String pZrntorihikiymd) {
        getPrimaryKey().setZrntorihikiymd(pZrntorihikiymd);
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNTORIHIKINON7)
    public String getZrntorihikinon7() {
        return getPrimaryKey().getZrntorihikinon7();
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrntorihikinon7(String pZrntorihikinon7) {
        getPrimaryKey().setZrntorihikinon7(pZrntorihikinon7);
    }

    private String zrnnyuuryokubasyo;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNNYUURYOKUBASYO)
    public String getZrnnyuuryokubasyo() {
        return zrnnyuuryokubasyo;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnnyuuryokubasyo(String pZrnnyuuryokubasyo) {
        zrnnyuuryokubasyo = pZrnnyuuryokubasyo;
    }

    private String zrnnyuuryokusyacd;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNNYUURYOKUSYACD)
    public String getZrnnyuuryokusyacd() {
        return zrnnyuuryokusyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnnyuuryokusyacd(String pZrnnyuuryokusyacd) {
        zrnnyuuryokusyacd = pZrnnyuuryokusyacd;
    }

    private String zrnsyoriymdn;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNSYORIYMDN)
    public String getZrnsyoriymdn() {
        return zrnsyoriymdn;
    }

    public void setZrnsyoriymdn(String pZrnsyoriymdn) {
        zrnsyoriymdn = pZrnsyoriymdn;
    }

    private String zrnkessankbn;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNKESSANKBN)
    public String getZrnkessankbn() {
        return zrnkessankbn;
    }

    public void setZrnkessankbn(String pZrnkessankbn) {
        zrnkessankbn = pZrnkessankbn;
    }

    private String zrnonlinesyorikbn;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNONLINESYORIKBN)
    public String getZrnonlinesyorikbn() {
        return zrnonlinesyorikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnonlinesyorikbn(String pZrnonlinesyorikbn) {
        zrnonlinesyorikbn = pZrnonlinesyorikbn;
    }

    private String zrnyobiv28;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNYOBIV28)
    public String getZrnyobiv28() {
        return zrnyobiv28;
    }

    public void setZrnyobiv28(String pZrnyobiv28) {
        zrnyobiv28 = pZrnyobiv28;
    }

    private String zrnkanjyoukbnn;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNKANJYOUKBNN)
    public String getZrnkanjyoukbnn() {
        return zrnkanjyoukbnn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkanjyoukbnn(String pZrnkanjyoukbnn) {
        zrnkanjyoukbnn = pZrnkanjyoukbnn;
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNTAISYAKUKBNN)
    public String getZrntaisyakukbnn() {
        return getPrimaryKey().getZrntaisyakukbnn();
    }

    public void setZrntaisyakukbnn(String pZrntaisyakukbnn) {
        getPrimaryKey().setZrntaisyakukbnn(pZrntaisyakukbnn);
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNKANJYOUKAMOKUCDN)
    public String getZrnkanjyoukamokucdn() {
        return getPrimaryKey().getZrnkanjyoukamokucdn();
    }

    public void setZrnkanjyoukamokucdn(String pZrnkanjyoukamokucdn) {
        getPrimaryKey().setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
    }

    private String zrnyobiv4;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNSUITOUBUMONCD)
    public String getZrnsuitoubumoncd() {
        return getPrimaryKey().getZrnsuitoubumoncd();
    }

    public void setZrnsuitoubumoncd(String pZrnsuitoubumoncd) {
        getPrimaryKey().setZrnsuitoubumoncd(pZrnsuitoubumoncd);
    }

    private Long zrnkingaku;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNKINGAKU)
    public Long getZrnkingaku() {
        return zrnkingaku;
    }

    public void setZrnkingaku(Long pZrnkingaku) {
        zrnkingaku = pZrnkingaku;
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNKIZOKUSEGMENT)
    public String getZrnkizokusegment() {
        return getPrimaryKey().getZrnkizokusegment();
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkizokusegment(String pZrnkizokusegment) {
        getPrimaryKey().setZrnkizokusegment(pZrnkizokusegment);
    }

    @Id
    @Column(name=GenZT_KubunKeiriFileRn.ZRNAITESEGMENT)
    public String getZrnaitesegment() {
        return getPrimaryKey().getZrnaitesegment();
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnaitesegment(String pZrnaitesegment) {
        getPrimaryKey().setZrnaitesegment(pZrnaitesegment);
    }

    private String zrnyobiv23;

    @Column(name=GenZT_KubunKeiriFileRn.ZRNYOBIV23)
    public String getZrnyobiv23() {
        return zrnyobiv23;
    }

    public void setZrnyobiv23(String pZrnyobiv23) {
        zrnyobiv23 = pZrnyobiv23;
    }
}