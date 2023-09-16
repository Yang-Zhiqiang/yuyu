package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.id.PKZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.GenQZT_SntkInfoHaneiKekkaTr;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaTr;

/**
 * 普保Ⅱ選択情報反映結果テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_SntkInfoHaneiKekkaTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SntkInfoHaneiKekkaTr}</td><td colspan="3">普保Ⅱ選択情報反映結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrsntkinfono ztrsntkinfono}</td><td>（取込用）選択情報番号</td><td align="center">{@link PKZT_SntkInfoHaneiKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenno ztrrenno}</td><td>（取込用）連番</td><td align="center">{@link PKZT_SntkInfoHaneiKekkaTr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrsntkinfotourokusyskbn ztrsntkinfotourokusyskbn}</td><td>（取込用）選択情報登録システム区分</td><td align="center">{@link PKZT_SntkInfoHaneiKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhuho2kyknokbn ztrhuho2kyknokbn}</td><td>（取込用）普保Ⅱ契約番号区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhuho2kykno ztrhuho2kykno}</td><td>（取込用）普保Ⅱ契約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsntkinfofsegkbn ztrsntkinfofsegkbn}</td><td>（取込用）選択情報ＦＳＥＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsntkinfofkojinkbn ztrsntkinfofkojinkbn}</td><td>（取込用）選択情報Ｆ個人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdakuhiketnaiyouarihyj ztrdakuhiketnaiyouarihyj}</td><td>（取込用）諾否決定内容有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkktnaiyouarihyj ztrkktnaiyouarihyj}</td><td>（取込用）告知内容有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkijinaiyouarihyj ztrkijinaiyouarihyj}</td><td>（取込用）記事内容有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrmrarihyj ztrmrarihyj}</td><td>（取込用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkoudosyougaiarihyj ztrkoudosyougaiarihyj}</td><td>（取込用）高度障害有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtorikaijoarihyj ztrtorikaijoarihyj}</td><td>（取込用）取消解除有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsntkinjotourokuerrkbn ztrsntkinjotourokuerrkbn}</td><td>（取込用）選択情報登録エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrnayosehumeihyj ztrnayosehumeihyj}</td><td>（取込用）名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsntkinjohaneikekkayobi01 ztrsntkinjohaneikekkayobi01}</td><td>（取込用）選択情報反映結果予備０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SntkInfoHaneiKekkaTr
 * @see     PKZT_SntkInfoHaneiKekkaTr
 * @see     QZT_SntkInfoHaneiKekkaTr
 * @see     GenQZT_SntkInfoHaneiKekkaTr
 */
@MappedSuperclass
@Table(name=GenZT_SntkInfoHaneiKekkaTr.TABLE_NAME)
@IdClass(value=PKZT_SntkInfoHaneiKekkaTr.class)
public abstract class GenZT_SntkInfoHaneiKekkaTr extends AbstractExDBEntity<ZT_SntkInfoHaneiKekkaTr, PKZT_SntkInfoHaneiKekkaTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SntkInfoHaneiKekkaTr";
    public static final String ZTRSNTKINFONO            = "ztrsntkinfono";
    public static final String ZTRRENNO                 = "ztrrenno";
    public static final String ZTRSNTKINFOTOUROKUSYSKBN = "ztrsntkinfotourokusyskbn";
    public static final String ZTRHUHO2KYKNOKBN         = "ztrhuho2kyknokbn";
    public static final String ZTRHUHO2KYKNO            = "ztrhuho2kykno";
    public static final String ZTRSNTKINFOFSEGKBN       = "ztrsntkinfofsegkbn";
    public static final String ZTRSNTKINFOFKOJINKBN     = "ztrsntkinfofkojinkbn";
    public static final String ZTRDAKUHIKETNAIYOUARIHYJ = "ztrdakuhiketnaiyouarihyj";
    public static final String ZTRKKTNAIYOUARIHYJ       = "ztrkktnaiyouarihyj";
    public static final String ZTRKIJINAIYOUARIHYJ      = "ztrkijinaiyouarihyj";
    public static final String ZTRMRARIHYJ              = "ztrmrarihyj";
    public static final String ZTRKOUDOSYOUGAIARIHYJ    = "ztrkoudosyougaiarihyj";
    public static final String ZTRTORIKAIJOARIHYJ       = "ztrtorikaijoarihyj";
    public static final String ZTRSNTKINJOTOUROKUERRKBN = "ztrsntkinjotourokuerrkbn";
    public static final String ZTRNAYOSEHUMEIHYJ        = "ztrnayosehumeihyj";
    public static final String ZTRSNTKINJOHANEIKEKKAYOBI01 = "ztrsntkinjohaneikekkayobi01";

    private final PKZT_SntkInfoHaneiKekkaTr primaryKey;

    public GenZT_SntkInfoHaneiKekkaTr() {
        primaryKey = new PKZT_SntkInfoHaneiKekkaTr();
    }

    public GenZT_SntkInfoHaneiKekkaTr(
        String pZtrsntkinfono,
        Integer pZtrrenno,
        String pZtrsntkinfotourokusyskbn
    ) {
        primaryKey = new PKZT_SntkInfoHaneiKekkaTr(
            pZtrsntkinfono,
            pZtrrenno,
            pZtrsntkinfotourokusyskbn
        );
    }

    @Transient
    @Override
    public PKZT_SntkInfoHaneiKekkaTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SntkInfoHaneiKekkaTr> getMetaClass() {
        return QZT_SntkInfoHaneiKekkaTr.class;
    }

    @Id
    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRSNTKINFONO)
    public String getZtrsntkinfono() {
        return getPrimaryKey().getZtrsntkinfono();
    }

    public void setZtrsntkinfono(String pZtrsntkinfono) {
        getPrimaryKey().setZtrsntkinfono(pZtrsntkinfono);
    }

    @Id
    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRRENNO)
    public Integer getZtrrenno() {
        return getPrimaryKey().getZtrrenno();
    }

    public void setZtrrenno(Integer pZtrrenno) {
        getPrimaryKey().setZtrrenno(pZtrrenno);
    }

    @Id
    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRSNTKINFOTOUROKUSYSKBN)
    public String getZtrsntkinfotourokusyskbn() {
        return getPrimaryKey().getZtrsntkinfotourokusyskbn();
    }

    public void setZtrsntkinfotourokusyskbn(String pZtrsntkinfotourokusyskbn) {
        getPrimaryKey().setZtrsntkinfotourokusyskbn(pZtrsntkinfotourokusyskbn);
    }

    private String ztrhuho2kyknokbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRHUHO2KYKNOKBN)
    public String getZtrhuho2kyknokbn() {
        return ztrhuho2kyknokbn;
    }

    public void setZtrhuho2kyknokbn(String pZtrhuho2kyknokbn) {
        ztrhuho2kyknokbn = pZtrhuho2kyknokbn;
    }

    private String ztrhuho2kykno;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRHUHO2KYKNO)
    public String getZtrhuho2kykno() {
        return ztrhuho2kykno;
    }

    public void setZtrhuho2kykno(String pZtrhuho2kykno) {
        ztrhuho2kykno = pZtrhuho2kykno;
    }

    private String ztrsntkinfofsegkbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRSNTKINFOFSEGKBN)
    public String getZtrsntkinfofsegkbn() {
        return ztrsntkinfofsegkbn;
    }

    public void setZtrsntkinfofsegkbn(String pZtrsntkinfofsegkbn) {
        ztrsntkinfofsegkbn = pZtrsntkinfofsegkbn;
    }

    private String ztrsntkinfofkojinkbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRSNTKINFOFKOJINKBN)
    public String getZtrsntkinfofkojinkbn() {
        return ztrsntkinfofkojinkbn;
    }

    public void setZtrsntkinfofkojinkbn(String pZtrsntkinfofkojinkbn) {
        ztrsntkinfofkojinkbn = pZtrsntkinfofkojinkbn;
    }

    private String ztrdakuhiketnaiyouarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRDAKUHIKETNAIYOUARIHYJ)
    public String getZtrdakuhiketnaiyouarihyj() {
        return ztrdakuhiketnaiyouarihyj;
    }

    public void setZtrdakuhiketnaiyouarihyj(String pZtrdakuhiketnaiyouarihyj) {
        ztrdakuhiketnaiyouarihyj = pZtrdakuhiketnaiyouarihyj;
    }

    private String ztrkktnaiyouarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRKKTNAIYOUARIHYJ)
    public String getZtrkktnaiyouarihyj() {
        return ztrkktnaiyouarihyj;
    }

    public void setZtrkktnaiyouarihyj(String pZtrkktnaiyouarihyj) {
        ztrkktnaiyouarihyj = pZtrkktnaiyouarihyj;
    }

    private String ztrkijinaiyouarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRKIJINAIYOUARIHYJ)
    public String getZtrkijinaiyouarihyj() {
        return ztrkijinaiyouarihyj;
    }

    public void setZtrkijinaiyouarihyj(String pZtrkijinaiyouarihyj) {
        ztrkijinaiyouarihyj = pZtrkijinaiyouarihyj;
    }

    private String ztrmrarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRMRARIHYJ)
    public String getZtrmrarihyj() {
        return ztrmrarihyj;
    }

    public void setZtrmrarihyj(String pZtrmrarihyj) {
        ztrmrarihyj = pZtrmrarihyj;
    }

    private String ztrkoudosyougaiarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRKOUDOSYOUGAIARIHYJ)
    public String getZtrkoudosyougaiarihyj() {
        return ztrkoudosyougaiarihyj;
    }

    public void setZtrkoudosyougaiarihyj(String pZtrkoudosyougaiarihyj) {
        ztrkoudosyougaiarihyj = pZtrkoudosyougaiarihyj;
    }

    private String ztrtorikaijoarihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRTORIKAIJOARIHYJ)
    public String getZtrtorikaijoarihyj() {
        return ztrtorikaijoarihyj;
    }

    public void setZtrtorikaijoarihyj(String pZtrtorikaijoarihyj) {
        ztrtorikaijoarihyj = pZtrtorikaijoarihyj;
    }

    private String ztrsntkinjotourokuerrkbn;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRSNTKINJOTOUROKUERRKBN)
    public String getZtrsntkinjotourokuerrkbn() {
        return ztrsntkinjotourokuerrkbn;
    }

    public void setZtrsntkinjotourokuerrkbn(String pZtrsntkinjotourokuerrkbn) {
        ztrsntkinjotourokuerrkbn = pZtrsntkinjotourokuerrkbn;
    }

    private String ztrnayosehumeihyj;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRNAYOSEHUMEIHYJ)
    public String getZtrnayosehumeihyj() {
        return ztrnayosehumeihyj;
    }

    public void setZtrnayosehumeihyj(String pZtrnayosehumeihyj) {
        ztrnayosehumeihyj = pZtrnayosehumeihyj;
    }

    private String ztrsntkinjohaneikekkayobi01;

    @Column(name=GenZT_SntkInfoHaneiKekkaTr.ZTRSNTKINJOHANEIKEKKAYOBI01)
    public String getZtrsntkinjohaneikekkayobi01() {
        return ztrsntkinjohaneikekkayobi01;
    }

    public void setZtrsntkinjohaneikekkayobi01(String pZtrsntkinjohaneikekkayobi01) {
        ztrsntkinjohaneikekkayobi01 = pZtrsntkinjohaneikekkayobi01;
    }
}
