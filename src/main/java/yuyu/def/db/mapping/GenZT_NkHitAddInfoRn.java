package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkHitAddInfoRn;
import yuyu.def.db.id.PKZT_NkHitAddInfoRn;
import yuyu.def.db.meta.GenQZT_NkHitAddInfoRn;
import yuyu.def.db.meta.QZT_NkHitAddInfoRn;

/**
 * 年金配当所要額追加情報反映テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NkHitAddInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitAddInfoRn}</td><td colspan="3">年金配当所要額追加情報反映テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">{@link PKZT_NkHitAddInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnratekbn zrnratekbn}</td><td>（連携用）レート区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkariwariate4nenmae zrnkariwariate4nenmae}</td><td>（連携用）仮割当（４年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate3nenmae zrnkariwariate3nenmae}</td><td>（連携用）仮割当（３年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate2nenmae zrnkariwariate2nenmae}</td><td>（連携用）仮割当（２年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkariwariate1nenmae zrnkariwariate1nenmae}</td><td>（連携用）仮割当（１年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv40 zrnyobiv40}</td><td>（連携用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitAddInfoRn
 * @see     PKZT_NkHitAddInfoRn
 * @see     QZT_NkHitAddInfoRn
 * @see     GenQZT_NkHitAddInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_NkHitAddInfoRn.TABLE_NAME)
@IdClass(value=PKZT_NkHitAddInfoRn.class)
public abstract class GenZT_NkHitAddInfoRn extends AbstractExDBEntityForZDB<ZT_NkHitAddInfoRn, PKZT_NkHitAddInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkHitAddInfoRn";
    public static final String ZRNNKSYOUSYONO           = "zrnnksyousyono";
    public static final String ZRNRATEKBN               = "zrnratekbn";
    public static final String ZRNKARIWARIATE4NENMAE    = "zrnkariwariate4nenmae";
    public static final String ZRNKARIWARIATE3NENMAE    = "zrnkariwariate3nenmae";
    public static final String ZRNKARIWARIATE2NENMAE    = "zrnkariwariate2nenmae";
    public static final String ZRNKARIWARIATE1NENMAE    = "zrnkariwariate1nenmae";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIV40               = "zrnyobiv40";

    private final PKZT_NkHitAddInfoRn primaryKey;

    public GenZT_NkHitAddInfoRn() {
        primaryKey = new PKZT_NkHitAddInfoRn();
    }

    public GenZT_NkHitAddInfoRn(String pZrnnksyousyono) {
        primaryKey = new PKZT_NkHitAddInfoRn(pZrnnksyousyono);
    }

    @Transient
    @Override
    public PKZT_NkHitAddInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkHitAddInfoRn> getMetaClass() {
        return QZT_NkHitAddInfoRn.class;
    }

    @Id
    @Column(name=GenZT_NkHitAddInfoRn.ZRNNKSYOUSYONO)
    public String getZrnnksyousyono() {
        return getPrimaryKey().getZrnnksyousyono();
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        getPrimaryKey().setZrnnksyousyono(pZrnnksyousyono);
    }

    private String zrnratekbn;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNRATEKBN)
    public String getZrnratekbn() {
        return zrnratekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnratekbn(String pZrnratekbn) {
        zrnratekbn = pZrnratekbn;
    }

    private Long zrnkariwariate4nenmae;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNKARIWARIATE4NENMAE)
    public Long getZrnkariwariate4nenmae() {
        return zrnkariwariate4nenmae;
    }

    public void setZrnkariwariate4nenmae(Long pZrnkariwariate4nenmae) {
        zrnkariwariate4nenmae = pZrnkariwariate4nenmae;
    }

    private Long zrnkariwariate3nenmae;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNKARIWARIATE3NENMAE)
    public Long getZrnkariwariate3nenmae() {
        return zrnkariwariate3nenmae;
    }

    public void setZrnkariwariate3nenmae(Long pZrnkariwariate3nenmae) {
        zrnkariwariate3nenmae = pZrnkariwariate3nenmae;
    }

    private Long zrnkariwariate2nenmae;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNKARIWARIATE2NENMAE)
    public Long getZrnkariwariate2nenmae() {
        return zrnkariwariate2nenmae;
    }

    public void setZrnkariwariate2nenmae(Long pZrnkariwariate2nenmae) {
        zrnkariwariate2nenmae = pZrnkariwariate2nenmae;
    }

    private Long zrnkariwariate1nenmae;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNKARIWARIATE1NENMAE)
    public Long getZrnkariwariate1nenmae() {
        return zrnkariwariate1nenmae;
    }

    public void setZrnkariwariate1nenmae(Long pZrnkariwariate1nenmae) {
        zrnkariwariate1nenmae = pZrnkariwariate1nenmae;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrnyobiv40;

    @Column(name=GenZT_NkHitAddInfoRn.ZRNYOBIV40)
    public String getZrnyobiv40() {
        return zrnyobiv40;
    }

    public void setZrnyobiv40(String pZrnyobiv40) {
        zrnyobiv40 = pZrnyobiv40;
    }
}