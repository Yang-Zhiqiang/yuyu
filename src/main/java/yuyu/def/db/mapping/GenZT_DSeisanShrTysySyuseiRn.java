package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.id.PKZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.GenQZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiRn;

/**
 * Ｄ精算支払調書修正テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DSeisanShrTysySyuseiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DSeisanShrTysySyuseiRn}</td><td colspan="3">Ｄ精算支払調書修正テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DSeisanShrTysySyuseiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisandshrymd zrnseisandshrymd}</td><td>（連携用）精算Ｄ支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisandkgk11 zrnseisandkgk11}</td><td>（連携用）精算Ｄ金額Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyouseidkgk11 zrntyouseidkgk11}</td><td>（連携用）調整Ｄ金額Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv19 zrnyobiv19}</td><td>（連携用）予備項目Ｖ１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DSeisanShrTysySyuseiRn
 * @see     PKZT_DSeisanShrTysySyuseiRn
 * @see     QZT_DSeisanShrTysySyuseiRn
 * @see     GenQZT_DSeisanShrTysySyuseiRn
 */
@MappedSuperclass
@Table(name=GenZT_DSeisanShrTysySyuseiRn.TABLE_NAME)
@IdClass(value=PKZT_DSeisanShrTysySyuseiRn.class)
public abstract class GenZT_DSeisanShrTysySyuseiRn extends AbstractExDBEntityForZDB<ZT_DSeisanShrTysySyuseiRn, PKZT_DSeisanShrTysySyuseiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DSeisanShrTysySyuseiRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSEISANDSHRYMD         = "zrnseisandshrymd";
    public static final String ZRNSEISANDKGK11          = "zrnseisandkgk11";
    public static final String ZRNTYOUSEIDKGK11         = "zrntyouseidkgk11";
    public static final String ZRNYOBIV19               = "zrnyobiv19";

    private final PKZT_DSeisanShrTysySyuseiRn primaryKey;

    public GenZT_DSeisanShrTysySyuseiRn() {
        primaryKey = new PKZT_DSeisanShrTysySyuseiRn();
    }

    public GenZT_DSeisanShrTysySyuseiRn(String pZrnsyono) {
        primaryKey = new PKZT_DSeisanShrTysySyuseiRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_DSeisanShrTysySyuseiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DSeisanShrTysySyuseiRn> getMetaClass() {
        return QZT_DSeisanShrTysySyuseiRn.class;
    }

    @Id
    @Column(name=GenZT_DSeisanShrTysySyuseiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnseisandshrymd;

    @Column(name=GenZT_DSeisanShrTysySyuseiRn.ZRNSEISANDSHRYMD)
    public String getZrnseisandshrymd() {
        return zrnseisandshrymd;
    }

    public void setZrnseisandshrymd(String pZrnseisandshrymd) {
        zrnseisandshrymd = pZrnseisandshrymd;
    }

    private Long zrnseisandkgk11;

    @Column(name=GenZT_DSeisanShrTysySyuseiRn.ZRNSEISANDKGK11)
    public Long getZrnseisandkgk11() {
        return zrnseisandkgk11;
    }

    public void setZrnseisandkgk11(Long pZrnseisandkgk11) {
        zrnseisandkgk11 = pZrnseisandkgk11;
    }

    private Long zrntyouseidkgk11;

    @Column(name=GenZT_DSeisanShrTysySyuseiRn.ZRNTYOUSEIDKGK11)
    public Long getZrntyouseidkgk11() {
        return zrntyouseidkgk11;
    }

    public void setZrntyouseidkgk11(Long pZrntyouseidkgk11) {
        zrntyouseidkgk11 = pZrntyouseidkgk11;
    }

    private String zrnyobiv19;

    @Column(name=GenZT_DSeisanShrTysySyuseiRn.ZRNYOBIV19)
    public String getZrnyobiv19() {
        return zrnyobiv19;
    }

    public void setZrnyobiv19(String pZrnyobiv19) {
        zrnyobiv19 = pZrnyobiv19;
    }
}