package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.id.PKZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.GenQZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaTr;

/**
 * 普保Ⅱ契約異動反映結果テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_KykIdouHaneiKekkaTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KykIdouHaneiKekkaTr}</td><td colspan="3">普保Ⅱ契約異動反映結果テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrhuho2kyknokbn ztrhuho2kyknokbn}</td><td>（取込用）普保Ⅱ契約番号区分</td><td align="center">{@link PKZT_KykIdouHaneiKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhuho2kykno ztrhuho2kykno}</td><td>（取込用）普保Ⅱ契約番号</td><td align="center">{@link PKZT_KykIdouHaneiKekkaTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyknaiyouhaneierrkbn ztrkyknaiyouhaneierrkbn}</td><td>（取込用）契約内容反映エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtsnkijyuntyoukahyj ztrtsnkijyuntyoukahyj}</td><td>（取込用）通算基準超過表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknnayosehumeihyj ztrhhknnayosehumeihyj}</td><td>（取込用）被保険者名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyknayosehumeihyj ztrkyknayosehumeihyj}</td><td>（取込用）契約者名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrnkuktnayosehumeihyj ztrnkuktnayosehumeihyj}</td><td>（取込用）年金受取人名寄せ不明表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtjtidouhaneikekkayobi01 ztrtjtidouhaneikekkayobi01}</td><td>（取込用）当日異動内容反映結果予備０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KykIdouHaneiKekkaTr
 * @see     PKZT_KykIdouHaneiKekkaTr
 * @see     QZT_KykIdouHaneiKekkaTr
 * @see     GenQZT_KykIdouHaneiKekkaTr
 */
@MappedSuperclass
@Table(name=GenZT_KykIdouHaneiKekkaTr.TABLE_NAME)
@IdClass(value=PKZT_KykIdouHaneiKekkaTr.class)
public abstract class GenZT_KykIdouHaneiKekkaTr extends AbstractExDBEntity<ZT_KykIdouHaneiKekkaTr, PKZT_KykIdouHaneiKekkaTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KykIdouHaneiKekkaTr";
    public static final String ZTRHUHO2KYKNOKBN         = "ztrhuho2kyknokbn";
    public static final String ZTRHUHO2KYKNO            = "ztrhuho2kykno";
    public static final String ZTRKYKNAIYOUHANEIERRKBN  = "ztrkyknaiyouhaneierrkbn";
    public static final String ZTRTSNKIJYUNTYOUKAHYJ    = "ztrtsnkijyuntyoukahyj";
    public static final String ZTRHHKNNAYOSEHUMEIHYJ    = "ztrhhknnayosehumeihyj";
    public static final String ZTRKYKNAYOSEHUMEIHYJ     = "ztrkyknayosehumeihyj";
    public static final String ZTRNKUKTNAYOSEHUMEIHYJ   = "ztrnkuktnayosehumeihyj";
    public static final String ZTRTJTIDOUHANEIKEKKAYOBI01 = "ztrtjtidouhaneikekkayobi01";

    private final PKZT_KykIdouHaneiKekkaTr primaryKey;

    public GenZT_KykIdouHaneiKekkaTr() {
        primaryKey = new PKZT_KykIdouHaneiKekkaTr();
    }

    public GenZT_KykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno) {
        primaryKey = new PKZT_KykIdouHaneiKekkaTr(pZtrhuho2kyknokbn, pZtrhuho2kykno);
    }

    @Transient
    @Override
    public PKZT_KykIdouHaneiKekkaTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KykIdouHaneiKekkaTr> getMetaClass() {
        return QZT_KykIdouHaneiKekkaTr.class;
    }

    @Id
    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRHUHO2KYKNOKBN)
    public String getZtrhuho2kyknokbn() {
        return getPrimaryKey().getZtrhuho2kyknokbn();
    }

    public void setZtrhuho2kyknokbn(String pZtrhuho2kyknokbn) {
        getPrimaryKey().setZtrhuho2kyknokbn(pZtrhuho2kyknokbn);
    }

    @Id
    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRHUHO2KYKNO)
    public String getZtrhuho2kykno() {
        return getPrimaryKey().getZtrhuho2kykno();
    }

    public void setZtrhuho2kykno(String pZtrhuho2kykno) {
        getPrimaryKey().setZtrhuho2kykno(pZtrhuho2kykno);
    }

    private String ztrkyknaiyouhaneierrkbn;

    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRKYKNAIYOUHANEIERRKBN)
    public String getZtrkyknaiyouhaneierrkbn() {
        return ztrkyknaiyouhaneierrkbn;
    }

    public void setZtrkyknaiyouhaneierrkbn(String pZtrkyknaiyouhaneierrkbn) {
        ztrkyknaiyouhaneierrkbn = pZtrkyknaiyouhaneierrkbn;
    }

    private String ztrtsnkijyuntyoukahyj;

    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRTSNKIJYUNTYOUKAHYJ)
    public String getZtrtsnkijyuntyoukahyj() {
        return ztrtsnkijyuntyoukahyj;
    }

    public void setZtrtsnkijyuntyoukahyj(String pZtrtsnkijyuntyoukahyj) {
        ztrtsnkijyuntyoukahyj = pZtrtsnkijyuntyoukahyj;
    }

    private String ztrhhknnayosehumeihyj;

    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRHHKNNAYOSEHUMEIHYJ)
    public String getZtrhhknnayosehumeihyj() {
        return ztrhhknnayosehumeihyj;
    }

    public void setZtrhhknnayosehumeihyj(String pZtrhhknnayosehumeihyj) {
        ztrhhknnayosehumeihyj = pZtrhhknnayosehumeihyj;
    }

    private String ztrkyknayosehumeihyj;

    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRKYKNAYOSEHUMEIHYJ)
    public String getZtrkyknayosehumeihyj() {
        return ztrkyknayosehumeihyj;
    }

    public void setZtrkyknayosehumeihyj(String pZtrkyknayosehumeihyj) {
        ztrkyknayosehumeihyj = pZtrkyknayosehumeihyj;
    }

    private String ztrnkuktnayosehumeihyj;

    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRNKUKTNAYOSEHUMEIHYJ)
    public String getZtrnkuktnayosehumeihyj() {
        return ztrnkuktnayosehumeihyj;
    }

    public void setZtrnkuktnayosehumeihyj(String pZtrnkuktnayosehumeihyj) {
        ztrnkuktnayosehumeihyj = pZtrnkuktnayosehumeihyj;
    }

    private String ztrtjtidouhaneikekkayobi01;

    @Column(name=GenZT_KykIdouHaneiKekkaTr.ZTRTJTIDOUHANEIKEKKAYOBI01)
    public String getZtrtjtidouhaneikekkayobi01() {
        return ztrtjtidouhaneikekkayobi01;
    }

    public void setZtrtjtidouhaneikekkayobi01(String pZtrtjtidouhaneikekkayobi01) {
        ztrtjtidouhaneikekkayobi01 = pZtrtjtidouhaneikekkayobi01;
    }
}
