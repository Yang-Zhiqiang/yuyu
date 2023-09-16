package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.id.PKZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.GenQZT_DSeisanShrTysySyuseiTy;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiTy;

/**
 * Ｄ精算支払調書修正テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DSeisanShrTysySyuseiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DSeisanShrTysySyuseiTy}</td><td colspan="3">Ｄ精算支払調書修正テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DSeisanShrTysySyuseiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisandshrymd ztyseisandshrymd}</td><td>（中継用）精算Ｄ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisandkgk11 ztyseisandkgk11}</td><td>（中継用）精算Ｄ金額Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyouseidkgk11 ztytyouseidkgk11}</td><td>（中継用）調整Ｄ金額Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv19 ztyyobiv19}</td><td>（中継用）予備項目Ｖ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DSeisanShrTysySyuseiTy
 * @see     PKZT_DSeisanShrTysySyuseiTy
 * @see     QZT_DSeisanShrTysySyuseiTy
 * @see     GenQZT_DSeisanShrTysySyuseiTy
 */
@MappedSuperclass
@Table(name=GenZT_DSeisanShrTysySyuseiTy.TABLE_NAME)
@IdClass(value=PKZT_DSeisanShrTysySyuseiTy.class)
public abstract class GenZT_DSeisanShrTysySyuseiTy extends AbstractExDBEntity<ZT_DSeisanShrTysySyuseiTy, PKZT_DSeisanShrTysySyuseiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DSeisanShrTysySyuseiTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSEISANDSHRYMD         = "ztyseisandshrymd";
    public static final String ZTYSEISANDKGK11          = "ztyseisandkgk11";
    public static final String ZTYTYOUSEIDKGK11         = "ztytyouseidkgk11";
    public static final String ZTYYOBIV19               = "ztyyobiv19";

    private final PKZT_DSeisanShrTysySyuseiTy primaryKey;

    public GenZT_DSeisanShrTysySyuseiTy() {
        primaryKey = new PKZT_DSeisanShrTysySyuseiTy();
    }

    public GenZT_DSeisanShrTysySyuseiTy(String pZtysyono) {
        primaryKey = new PKZT_DSeisanShrTysySyuseiTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_DSeisanShrTysySyuseiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DSeisanShrTysySyuseiTy> getMetaClass() {
        return QZT_DSeisanShrTysySyuseiTy.class;
    }

    @Id
    @Column(name=GenZT_DSeisanShrTysySyuseiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyseisandshrymd;

    @Column(name=GenZT_DSeisanShrTysySyuseiTy.ZTYSEISANDSHRYMD)
    public String getZtyseisandshrymd() {
        return ztyseisandshrymd;
    }

    public void setZtyseisandshrymd(String pZtyseisandshrymd) {
        ztyseisandshrymd = pZtyseisandshrymd;
    }

    private Long ztyseisandkgk11;

    @Column(name=GenZT_DSeisanShrTysySyuseiTy.ZTYSEISANDKGK11)
    public Long getZtyseisandkgk11() {
        return ztyseisandkgk11;
    }

    public void setZtyseisandkgk11(Long pZtyseisandkgk11) {
        ztyseisandkgk11 = pZtyseisandkgk11;
    }

    private Long ztytyouseidkgk11;

    @Column(name=GenZT_DSeisanShrTysySyuseiTy.ZTYTYOUSEIDKGK11)
    public Long getZtytyouseidkgk11() {
        return ztytyouseidkgk11;
    }

    public void setZtytyouseidkgk11(Long pZtytyouseidkgk11) {
        ztytyouseidkgk11 = pZtytyouseidkgk11;
    }

    private String ztyyobiv19;

    @Column(name=GenZT_DSeisanShrTysySyuseiTy.ZTYYOBIV19)
    public String getZtyyobiv19() {
        return ztyyobiv19;
    }

    public void setZtyyobiv19(String pZtyyobiv19) {
        ztyyobiv19 = pZtyyobiv19;
    }
}