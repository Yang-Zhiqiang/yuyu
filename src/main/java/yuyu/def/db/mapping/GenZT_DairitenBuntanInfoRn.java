package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.db.id.PKZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.GenQZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.QZT_DairitenBuntanInfoRn;

/**
 * 代理店手数料分担情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DairitenBuntanInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenBuntanInfoRn}</td><td colspan="3">代理店手数料分担情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">{@link PKZT_DairitenBuntanInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitensyouhincd zrndairitensyouhincd}</td><td>（連携用）代理店商品コード</td><td align="center">{@link PKZT_DairitenBuntanInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntesuuryoubuntandrtencd zrntesuuryoubuntandrtencd}</td><td>（連携用）手数料分担相手代理店コード</td><td align="center">{@link PKZT_DairitenBuntanInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntesuuryoubuntanstartym zrntesuuryoubuntanstartym}</td><td>（連携用）手数料分担開始年月</td><td align="center">{@link PKZT_DairitenBuntanInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntesuuryoubuntanendym zrntesuuryoubuntanendym}</td><td>（連携用）手数料分担終了年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntesuuryoubuntanwariai zrntesuuryoubuntanwariai}</td><td>（連携用）手数料分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv67 zrnyobiv67}</td><td>（連携用）予備項目Ｖ６７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenBuntanInfoRn
 * @see     PKZT_DairitenBuntanInfoRn
 * @see     QZT_DairitenBuntanInfoRn
 * @see     GenQZT_DairitenBuntanInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_DairitenBuntanInfoRn.TABLE_NAME)
@IdClass(value=PKZT_DairitenBuntanInfoRn.class)
public abstract class GenZT_DairitenBuntanInfoRn extends AbstractExDBEntityForZDB<ZT_DairitenBuntanInfoRn, PKZT_DairitenBuntanInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DairitenBuntanInfoRn";
    public static final String ZRNDAIRITENCD            = "zrndairitencd";
    public static final String ZRNDAIRITENSYOUHINCD     = "zrndairitensyouhincd";
    public static final String ZRNTESUURYOUBUNTANDRTENCD = "zrntesuuryoubuntandrtencd";
    public static final String ZRNTESUURYOUBUNTANSTARTYM = "zrntesuuryoubuntanstartym";
    public static final String ZRNTESUURYOUBUNTANENDYM  = "zrntesuuryoubuntanendym";
    public static final String ZRNTESUURYOUBUNTANWARIAI = "zrntesuuryoubuntanwariai";
    public static final String ZRNYOBIV67               = "zrnyobiv67";

    private final PKZT_DairitenBuntanInfoRn primaryKey;

    public GenZT_DairitenBuntanInfoRn() {
        primaryKey = new PKZT_DairitenBuntanInfoRn();
    }

    public GenZT_DairitenBuntanInfoRn(
        String pZrndairitencd,
        String pZrndairitensyouhincd,
        String pZrntesuuryoubuntandrtencd,
        String pZrntesuuryoubuntanstartym
    ) {
        primaryKey = new PKZT_DairitenBuntanInfoRn(
            pZrndairitencd,
            pZrndairitensyouhincd,
            pZrntesuuryoubuntandrtencd,
            pZrntesuuryoubuntanstartym
        );
    }

    @Transient
    @Override
    public PKZT_DairitenBuntanInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DairitenBuntanInfoRn> getMetaClass() {
        return QZT_DairitenBuntanInfoRn.class;
    }

    @Id
    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNDAIRITENCD)
    public String getZrndairitencd() {
        return getPrimaryKey().getZrndairitencd();
    }

    public void setZrndairitencd(String pZrndairitencd) {
        getPrimaryKey().setZrndairitencd(pZrndairitencd);
    }

    @Id
    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNDAIRITENSYOUHINCD)
    public String getZrndairitensyouhincd() {
        return getPrimaryKey().getZrndairitensyouhincd();
    }

    public void setZrndairitensyouhincd(String pZrndairitensyouhincd) {
        getPrimaryKey().setZrndairitensyouhincd(pZrndairitensyouhincd);
    }

    @Id
    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNTESUURYOUBUNTANDRTENCD)
    public String getZrntesuuryoubuntandrtencd() {
        return getPrimaryKey().getZrntesuuryoubuntandrtencd();
    }

    public void setZrntesuuryoubuntandrtencd(String pZrntesuuryoubuntandrtencd) {
        getPrimaryKey().setZrntesuuryoubuntandrtencd(pZrntesuuryoubuntandrtencd);
    }

    @Id
    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNTESUURYOUBUNTANSTARTYM)
    public String getZrntesuuryoubuntanstartym() {
        return getPrimaryKey().getZrntesuuryoubuntanstartym();
    }

    public void setZrntesuuryoubuntanstartym(String pZrntesuuryoubuntanstartym) {
        getPrimaryKey().setZrntesuuryoubuntanstartym(pZrntesuuryoubuntanstartym);
    }

    private String zrntesuuryoubuntanendym;

    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNTESUURYOUBUNTANENDYM)
    public String getZrntesuuryoubuntanendym() {
        return zrntesuuryoubuntanendym;
    }

    public void setZrntesuuryoubuntanendym(String pZrntesuuryoubuntanendym) {
        zrntesuuryoubuntanendym = pZrntesuuryoubuntanendym;
    }

    private Long zrntesuuryoubuntanwariai;

    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNTESUURYOUBUNTANWARIAI)
    public Long getZrntesuuryoubuntanwariai() {
        return zrntesuuryoubuntanwariai;
    }

    public void setZrntesuuryoubuntanwariai(Long pZrntesuuryoubuntanwariai) {
        zrntesuuryoubuntanwariai = pZrntesuuryoubuntanwariai;
    }

    private String zrnyobiv67;

    @Column(name=GenZT_DairitenBuntanInfoRn.ZRNYOBIV67)
    public String getZrnyobiv67() {
        return zrnyobiv67;
    }

    public void setZrnyobiv67(String pZrnyobiv67) {
        zrnyobiv67 = pZrnyobiv67;
    }
}