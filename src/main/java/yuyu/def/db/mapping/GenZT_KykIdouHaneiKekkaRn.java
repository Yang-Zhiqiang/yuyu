package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.id.PKZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.GenQZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaRn;

/**
 * 普保Ⅱ契約異動反映結果テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KykIdouHaneiKekkaRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KykIdouHaneiKekkaRn}</td><td colspan="3">普保Ⅱ契約異動反映結果テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhuho2kyknokbn zrnhuho2kyknokbn}</td><td>（連携用）普保Ⅱ契約番号区分</td><td align="center">{@link PKZT_KykIdouHaneiKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kykno zrnhuho2kykno}</td><td>（連携用）普保Ⅱ契約番号</td><td align="center">{@link PKZT_KykIdouHaneiKekkaRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknaiyouhaneierrkbn zrnkyknaiyouhaneierrkbn}</td><td>（連携用）契約内容反映エラー区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnkijyuntyoukahyj zrntsnkijyuntyoukahyj}</td><td>（連携用）通算基準超過表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnayosehumeihyj zrnhhknnayosehumeihyj}</td><td>（連携用）被保険者名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknayosehumeihyj zrnkyknayosehumeihyj}</td><td>（連携用）契約者名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuktnayosehumeihyj zrnnkuktnayosehumeihyj}</td><td>（連携用）年金受取人名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidouhaneikekkayobi01 zrntjtidouhaneikekkayobi01}</td><td>（連携用）当日異動内容反映結果予備０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KykIdouHaneiKekkaRn
 * @see     PKZT_KykIdouHaneiKekkaRn
 * @see     QZT_KykIdouHaneiKekkaRn
 * @see     GenQZT_KykIdouHaneiKekkaRn
 */
@MappedSuperclass
@Table(name=GenZT_KykIdouHaneiKekkaRn.TABLE_NAME)
@IdClass(value=PKZT_KykIdouHaneiKekkaRn.class)
public abstract class GenZT_KykIdouHaneiKekkaRn extends AbstractExDBEntityForZDB<ZT_KykIdouHaneiKekkaRn, PKZT_KykIdouHaneiKekkaRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KykIdouHaneiKekkaRn";
    public static final String ZRNHUHO2KYKNOKBN         = "zrnhuho2kyknokbn";
    public static final String ZRNHUHO2KYKNO            = "zrnhuho2kykno";
    public static final String ZRNKYKNAIYOUHANEIERRKBN  = "zrnkyknaiyouhaneierrkbn";
    public static final String ZRNTSNKIJYUNTYOUKAHYJ    = "zrntsnkijyuntyoukahyj";
    public static final String ZRNHHKNNAYOSEHUMEIHYJ    = "zrnhhknnayosehumeihyj";
    public static final String ZRNKYKNAYOSEHUMEIHYJ     = "zrnkyknayosehumeihyj";
    public static final String ZRNNKUKTNAYOSEHUMEIHYJ   = "zrnnkuktnayosehumeihyj";
    public static final String ZRNTJTIDOUHANEIKEKKAYOBI01 = "zrntjtidouhaneikekkayobi01";

    private final PKZT_KykIdouHaneiKekkaRn primaryKey;

    public GenZT_KykIdouHaneiKekkaRn() {
        primaryKey = new PKZT_KykIdouHaneiKekkaRn();
    }

    public GenZT_KykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        primaryKey = new PKZT_KykIdouHaneiKekkaRn(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }

    @Transient
    @Override
    public PKZT_KykIdouHaneiKekkaRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KykIdouHaneiKekkaRn> getMetaClass() {
        return QZT_KykIdouHaneiKekkaRn.class;
    }

    @Id
    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNHUHO2KYKNOKBN)
    public String getZrnhuho2kyknokbn() {
        return getPrimaryKey().getZrnhuho2kyknokbn();
    }

    public void setZrnhuho2kyknokbn(String pZrnhuho2kyknokbn) {
        getPrimaryKey().setZrnhuho2kyknokbn(pZrnhuho2kyknokbn);
    }

    @Id
    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNHUHO2KYKNO)
    public String getZrnhuho2kykno() {
        return getPrimaryKey().getZrnhuho2kykno();
    }

    public void setZrnhuho2kykno(String pZrnhuho2kykno) {
        getPrimaryKey().setZrnhuho2kykno(pZrnhuho2kykno);
    }

    private String zrnkyknaiyouhaneierrkbn;

    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNKYKNAIYOUHANEIERRKBN)
    public String getZrnkyknaiyouhaneierrkbn() {
        return zrnkyknaiyouhaneierrkbn;
    }

    public void setZrnkyknaiyouhaneierrkbn(String pZrnkyknaiyouhaneierrkbn) {
        zrnkyknaiyouhaneierrkbn = pZrnkyknaiyouhaneierrkbn;
    }

    private String zrntsnkijyuntyoukahyj;

    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNTSNKIJYUNTYOUKAHYJ)
    public String getZrntsnkijyuntyoukahyj() {
        return zrntsnkijyuntyoukahyj;
    }

    public void setZrntsnkijyuntyoukahyj(String pZrntsnkijyuntyoukahyj) {
        zrntsnkijyuntyoukahyj = pZrntsnkijyuntyoukahyj;
    }

    private String zrnhhknnayosehumeihyj;

    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNHHKNNAYOSEHUMEIHYJ)
    public String getZrnhhknnayosehumeihyj() {
        return zrnhhknnayosehumeihyj;
    }

    public void setZrnhhknnayosehumeihyj(String pZrnhhknnayosehumeihyj) {
        zrnhhknnayosehumeihyj = pZrnhhknnayosehumeihyj;
    }

    private String zrnkyknayosehumeihyj;

    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNKYKNAYOSEHUMEIHYJ)
    public String getZrnkyknayosehumeihyj() {
        return zrnkyknayosehumeihyj;
    }

    public void setZrnkyknayosehumeihyj(String pZrnkyknayosehumeihyj) {
        zrnkyknayosehumeihyj = pZrnkyknayosehumeihyj;
    }

    private String zrnnkuktnayosehumeihyj;

    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNNKUKTNAYOSEHUMEIHYJ)
    public String getZrnnkuktnayosehumeihyj() {
        return zrnnkuktnayosehumeihyj;
    }

    public void setZrnnkuktnayosehumeihyj(String pZrnnkuktnayosehumeihyj) {
        zrnnkuktnayosehumeihyj = pZrnnkuktnayosehumeihyj;
    }

    private String zrntjtidouhaneikekkayobi01;

    @Column(name=GenZT_KykIdouHaneiKekkaRn.ZRNTJTIDOUHANEIKEKKAYOBI01)
    public String getZrntjtidouhaneikekkayobi01() {
        return zrntjtidouhaneikekkayobi01;
    }

    public void setZrntjtidouhaneikekkayobi01(String pZrntjtidouhaneikekkayobi01) {
        zrntjtidouhaneikekkayobi01 = pZrntjtidouhaneikekkayobi01;
    }
}