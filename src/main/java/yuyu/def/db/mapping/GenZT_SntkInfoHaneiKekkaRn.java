package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.id.PKZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.GenQZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaRn;

/**
 * 普保Ⅱ選択情報反映結果テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SntkInfoHaneiKekkaRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoHaneiKekkaRn}</td><td colspan="3">普保Ⅱ選択情報反映結果テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsntkinfono zrnsntkinfono}</td><td>（連携用）選択情報番号</td><td align="center">{@link PKZT_SntkInfoHaneiKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenno zrnrenno}</td><td>（連携用）連番</td><td align="center">{@link PKZT_SntkInfoHaneiKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfotourokusyskbn zrnsntkinfotourokusyskbn}</td><td>（連携用）選択情報登録システム区分</td><td align="center">{@link PKZT_SntkInfoHaneiKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kyknokbn zrnhuho2kyknokbn}</td><td>（連携用）普保Ⅱ契約番号区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kykno zrnhuho2kykno}</td><td>（連携用）普保Ⅱ契約番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfofsegkbn zrnsntkinfofsegkbn}</td><td>（連携用）選択情報ＦＳＥＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinfofkojinkbn zrnsntkinfofkojinkbn}</td><td>（連携用）選択情報Ｆ個人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketnaiyouarihyj zrndakuhiketnaiyouarihyj}</td><td>（連携用）諾否決定内容有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkktnaiyouarihyj zrnkktnaiyouarihyj}</td><td>（連携用）告知内容有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkijinaiyouarihyj zrnkijinaiyouarihyj}</td><td>（連携用）記事内容有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrarihyj zrnmrarihyj}</td><td>（連携用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoudosyougaiarihyj zrnkoudosyougaiarihyj}</td><td>（連携用）高度障害有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorikaijoarihyj zrntorikaijoarihyj}</td><td>（連携用）取消解除有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinjotourokuerrkbn zrnsntkinjotourokuerrkbn}</td><td>（連携用）選択情報登録エラー区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayosehumeihyj zrnnayosehumeihyj}</td><td>（連携用）名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntkinjohaneikekkayobi01 zrnsntkinjohaneikekkayobi01}</td><td>（連携用）選択情報反映結果予備０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoHaneiKekkaRn
 * @see     PKZT_SntkInfoHaneiKekkaRn
 * @see     QZT_SntkInfoHaneiKekkaRn
 * @see     GenQZT_SntkInfoHaneiKekkaRn
 */
@MappedSuperclass
@Table(name=GenZT_SntkInfoHaneiKekkaRn.TABLE_NAME)
@IdClass(value=PKZT_SntkInfoHaneiKekkaRn.class)
public abstract class GenZT_SntkInfoHaneiKekkaRn extends AbstractExDBEntityForZDB<ZT_SntkInfoHaneiKekkaRn, PKZT_SntkInfoHaneiKekkaRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SntkInfoHaneiKekkaRn";
    public static final String ZRNSNTKINFONO            = "zrnsntkinfono";
    public static final String ZRNRENNO                 = "zrnrenno";
    public static final String ZRNSNTKINFOTOUROKUSYSKBN = "zrnsntkinfotourokusyskbn";
    public static final String ZRNHUHO2KYKNOKBN         = "zrnhuho2kyknokbn";
    public static final String ZRNHUHO2KYKNO            = "zrnhuho2kykno";
    public static final String ZRNSNTKINFOFSEGKBN       = "zrnsntkinfofsegkbn";
    public static final String ZRNSNTKINFOFKOJINKBN     = "zrnsntkinfofkojinkbn";
    public static final String ZRNDAKUHIKETNAIYOUARIHYJ = "zrndakuhiketnaiyouarihyj";
    public static final String ZRNKKTNAIYOUARIHYJ       = "zrnkktnaiyouarihyj";
    public static final String ZRNKIJINAIYOUARIHYJ      = "zrnkijinaiyouarihyj";
    public static final String ZRNMRARIHYJ              = "zrnmrarihyj";
    public static final String ZRNKOUDOSYOUGAIARIHYJ    = "zrnkoudosyougaiarihyj";
    public static final String ZRNTORIKAIJOARIHYJ       = "zrntorikaijoarihyj";
    public static final String ZRNSNTKINJOTOUROKUERRKBN = "zrnsntkinjotourokuerrkbn";
    public static final String ZRNNAYOSEHUMEIHYJ        = "zrnnayosehumeihyj";
    public static final String ZRNSNTKINJOHANEIKEKKAYOBI01 = "zrnsntkinjohaneikekkayobi01";

    private final PKZT_SntkInfoHaneiKekkaRn primaryKey;

    public GenZT_SntkInfoHaneiKekkaRn() {
        primaryKey = new PKZT_SntkInfoHaneiKekkaRn();
    }

    public GenZT_SntkInfoHaneiKekkaRn(
        String pZrnsntkinfono,
        String pZrnrenno,
        String pZrnsntkinfotourokusyskbn
    ) {
        primaryKey = new PKZT_SntkInfoHaneiKekkaRn(
            pZrnsntkinfono,
            pZrnrenno,
            pZrnsntkinfotourokusyskbn
        );
    }

    @Transient
    @Override
    public PKZT_SntkInfoHaneiKekkaRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SntkInfoHaneiKekkaRn> getMetaClass() {
        return QZT_SntkInfoHaneiKekkaRn.class;
    }

    @Id
    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNSNTKINFONO)
    public String getZrnsntkinfono() {
        return getPrimaryKey().getZrnsntkinfono();
    }

    public void setZrnsntkinfono(String pZrnsntkinfono) {
        getPrimaryKey().setZrnsntkinfono(pZrnsntkinfono);
    }

    @Id
    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNRENNO)
    public String getZrnrenno() {
        return getPrimaryKey().getZrnrenno();
    }

    public void setZrnrenno(String pZrnrenno) {
        getPrimaryKey().setZrnrenno(pZrnrenno);
    }

    @Id
    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNSNTKINFOTOUROKUSYSKBN)
    public String getZrnsntkinfotourokusyskbn() {
        return getPrimaryKey().getZrnsntkinfotourokusyskbn();
    }

    public void setZrnsntkinfotourokusyskbn(String pZrnsntkinfotourokusyskbn) {
        getPrimaryKey().setZrnsntkinfotourokusyskbn(pZrnsntkinfotourokusyskbn);
    }

    private String zrnhuho2kyknokbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNHUHO2KYKNOKBN)
    public String getZrnhuho2kyknokbn() {
        return zrnhuho2kyknokbn;
    }

    public void setZrnhuho2kyknokbn(String pZrnhuho2kyknokbn) {
        zrnhuho2kyknokbn = pZrnhuho2kyknokbn;
    }

    private String zrnhuho2kykno;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNHUHO2KYKNO)
    public String getZrnhuho2kykno() {
        return zrnhuho2kykno;
    }

    public void setZrnhuho2kykno(String pZrnhuho2kykno) {
        zrnhuho2kykno = pZrnhuho2kykno;
    }

    private String zrnsntkinfofsegkbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNSNTKINFOFSEGKBN)
    public String getZrnsntkinfofsegkbn() {
        return zrnsntkinfofsegkbn;
    }

    public void setZrnsntkinfofsegkbn(String pZrnsntkinfofsegkbn) {
        zrnsntkinfofsegkbn = pZrnsntkinfofsegkbn;
    }

    private String zrnsntkinfofkojinkbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNSNTKINFOFKOJINKBN)
    public String getZrnsntkinfofkojinkbn() {
        return zrnsntkinfofkojinkbn;
    }

    public void setZrnsntkinfofkojinkbn(String pZrnsntkinfofkojinkbn) {
        zrnsntkinfofkojinkbn = pZrnsntkinfofkojinkbn;
    }

    private String zrndakuhiketnaiyouarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNDAKUHIKETNAIYOUARIHYJ)
    public String getZrndakuhiketnaiyouarihyj() {
        return zrndakuhiketnaiyouarihyj;
    }

    public void setZrndakuhiketnaiyouarihyj(String pZrndakuhiketnaiyouarihyj) {
        zrndakuhiketnaiyouarihyj = pZrndakuhiketnaiyouarihyj;
    }

    private String zrnkktnaiyouarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNKKTNAIYOUARIHYJ)
    public String getZrnkktnaiyouarihyj() {
        return zrnkktnaiyouarihyj;
    }

    public void setZrnkktnaiyouarihyj(String pZrnkktnaiyouarihyj) {
        zrnkktnaiyouarihyj = pZrnkktnaiyouarihyj;
    }

    private String zrnkijinaiyouarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNKIJINAIYOUARIHYJ)
    public String getZrnkijinaiyouarihyj() {
        return zrnkijinaiyouarihyj;
    }

    public void setZrnkijinaiyouarihyj(String pZrnkijinaiyouarihyj) {
        zrnkijinaiyouarihyj = pZrnkijinaiyouarihyj;
    }

    private String zrnmrarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNMRARIHYJ)
    public String getZrnmrarihyj() {
        return zrnmrarihyj;
    }

    public void setZrnmrarihyj(String pZrnmrarihyj) {
        zrnmrarihyj = pZrnmrarihyj;
    }

    private String zrnkoudosyougaiarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNKOUDOSYOUGAIARIHYJ)
    public String getZrnkoudosyougaiarihyj() {
        return zrnkoudosyougaiarihyj;
    }

    public void setZrnkoudosyougaiarihyj(String pZrnkoudosyougaiarihyj) {
        zrnkoudosyougaiarihyj = pZrnkoudosyougaiarihyj;
    }

    private String zrntorikaijoarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNTORIKAIJOARIHYJ)
    public String getZrntorikaijoarihyj() {
        return zrntorikaijoarihyj;
    }

    public void setZrntorikaijoarihyj(String pZrntorikaijoarihyj) {
        zrntorikaijoarihyj = pZrntorikaijoarihyj;
    }

    private String zrnsntkinjotourokuerrkbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNSNTKINJOTOUROKUERRKBN)
    public String getZrnsntkinjotourokuerrkbn() {
        return zrnsntkinjotourokuerrkbn;
    }

    public void setZrnsntkinjotourokuerrkbn(String pZrnsntkinjotourokuerrkbn) {
        zrnsntkinjotourokuerrkbn = pZrnsntkinjotourokuerrkbn;
    }

    private String zrnnayosehumeihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNNAYOSEHUMEIHYJ)
    public String getZrnnayosehumeihyj() {
        return zrnnayosehumeihyj;
    }

    public void setZrnnayosehumeihyj(String pZrnnayosehumeihyj) {
        zrnnayosehumeihyj = pZrnnayosehumeihyj;
    }

    private String zrnsntkinjohaneikekkayobi01;

    @Column(name=GenZT_SntkInfoHaneiKekkaRn.ZRNSNTKINJOHANEIKEKKAYOBI01)
    public String getZrnsntkinjohaneikekkayobi01() {
        return zrnsntkinjohaneikekkayobi01;
    }

    public void setZrnsntkinjohaneikekkayobi01(String pZrnsntkinjohaneikekkayobi01) {
        zrnsntkinjohaneikekkayobi01 = pZrnsntkinjohaneikekkayobi01;
    }
}