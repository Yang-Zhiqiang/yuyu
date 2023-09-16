package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_NkHitAddInfoTy;
import yuyu.def.db.id.PKZT_NkHitAddInfoTy;
import yuyu.def.db.meta.GenQZT_NkHitAddInfoTy;
import yuyu.def.db.meta.QZT_NkHitAddInfoTy;

/**
 * 年金配当所要額追加情報反映テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_NkHitAddInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitAddInfoTy}</td><td colspan="3">年金配当所要額追加情報反映テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">{@link PKZT_NkHitAddInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyratekbn ztyratekbn}</td><td>（中継用）レート区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykariwariate4nenmae ztykariwariate4nenmae}</td><td>（中継用）仮割当（４年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate3nenmae ztykariwariate3nenmae}</td><td>（中継用）仮割当（３年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate2nenmae ztykariwariate2nenmae}</td><td>（中継用）仮割当（２年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariate1nenmae ztykariwariate1nenmae}</td><td>（中継用）仮割当（１年前）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv40 ztyyobiv40}</td><td>（中継用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitAddInfoTy
 * @see     PKZT_NkHitAddInfoTy
 * @see     QZT_NkHitAddInfoTy
 * @see     GenQZT_NkHitAddInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_NkHitAddInfoTy.TABLE_NAME)
@IdClass(value=PKZT_NkHitAddInfoTy.class)
public abstract class GenZT_NkHitAddInfoTy extends AbstractExDBEntity<ZT_NkHitAddInfoTy, PKZT_NkHitAddInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkHitAddInfoTy";
    public static final String ZTYNKSYOUSYONO           = "ztynksyousyono";
    public static final String ZTYRATEKBN               = "ztyratekbn";
    public static final String ZTYKARIWARIATE4NENMAE    = "ztykariwariate4nenmae";
    public static final String ZTYKARIWARIATE3NENMAE    = "ztykariwariate3nenmae";
    public static final String ZTYKARIWARIATE2NENMAE    = "ztykariwariate2nenmae";
    public static final String ZTYKARIWARIATE1NENMAE    = "ztykariwariate1nenmae";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIV40               = "ztyyobiv40";

    private final PKZT_NkHitAddInfoTy primaryKey;

    public GenZT_NkHitAddInfoTy() {
        primaryKey = new PKZT_NkHitAddInfoTy();
    }

    public GenZT_NkHitAddInfoTy(String pZtynksyousyono) {
        primaryKey = new PKZT_NkHitAddInfoTy(pZtynksyousyono);
    }

    @Transient
    @Override
    public PKZT_NkHitAddInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkHitAddInfoTy> getMetaClass() {
        return QZT_NkHitAddInfoTy.class;
    }

    @Id
    @Column(name=GenZT_NkHitAddInfoTy.ZTYNKSYOUSYONO)
    public String getZtynksyousyono() {
        return getPrimaryKey().getZtynksyousyono();
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        getPrimaryKey().setZtynksyousyono(pZtynksyousyono);
    }

    private String ztyratekbn;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYRATEKBN)
    public String getZtyratekbn() {
        return ztyratekbn;
    }

    public void setZtyratekbn(String pZtyratekbn) {
        ztyratekbn = pZtyratekbn;
    }

    private Long ztykariwariate4nenmae;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYKARIWARIATE4NENMAE)
    public Long getZtykariwariate4nenmae() {
        return ztykariwariate4nenmae;
    }

    public void setZtykariwariate4nenmae(Long pZtykariwariate4nenmae) {
        ztykariwariate4nenmae = pZtykariwariate4nenmae;
    }

    private Long ztykariwariate3nenmae;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYKARIWARIATE3NENMAE)
    public Long getZtykariwariate3nenmae() {
        return ztykariwariate3nenmae;
    }

    public void setZtykariwariate3nenmae(Long pZtykariwariate3nenmae) {
        ztykariwariate3nenmae = pZtykariwariate3nenmae;
    }

    private Long ztykariwariate2nenmae;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYKARIWARIATE2NENMAE)
    public Long getZtykariwariate2nenmae() {
        return ztykariwariate2nenmae;
    }

    public void setZtykariwariate2nenmae(Long pZtykariwariate2nenmae) {
        ztykariwariate2nenmae = pZtykariwariate2nenmae;
    }

    private Long ztykariwariate1nenmae;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYKARIWARIATE1NENMAE)
    public Long getZtykariwariate1nenmae() {
        return ztykariwariate1nenmae;
    }

    public void setZtykariwariate1nenmae(Long pZtykariwariate1nenmae) {
        ztykariwariate1nenmae = pZtykariwariate1nenmae;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztyyobiv40;

    @Column(name=GenZT_NkHitAddInfoTy.ZTYYOBIV40)
    public String getZtyyobiv40() {
        return ztyyobiv40;
    }

    public void setZtyyobiv40(String pZtyyobiv40) {
        ztyyobiv40 = pZtyyobiv40;
    }
}
