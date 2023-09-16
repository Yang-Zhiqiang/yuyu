package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.id.PKHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.GenQHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.QHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 新契約不備連絡内容マスタ テーブルのマッピング情報クラスで、 {@link HM_SkHubiRenrakuNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHubiRenrakuNaiyou}</td><td colspan="3">新契約不備連絡内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkhubirenrakunaiyoucd skhubirenrakunaiyoucd}</td><td>新契約不備連絡内容コード</td><td align="center">{@link PKHM_SkHubiRenrakuNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubirenrakunaiyou skhubirenrakunaiyou}</td><td>新契約不備連絡内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyoubunflg tyoubunflg}</td><td>長文フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     HM_SkHubiRenrakuNaiyou
 * @see     PKHM_SkHubiRenrakuNaiyou
 * @see     QHM_SkHubiRenrakuNaiyou
 * @see     GenQHM_SkHubiRenrakuNaiyou
 */
@MappedSuperclass
@Table(name=GenHM_SkHubiRenrakuNaiyou.TABLE_NAME)
@IdClass(value=PKHM_SkHubiRenrakuNaiyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHM_SkHubiRenrakuNaiyou extends AbstractExDBEntity<HM_SkHubiRenrakuNaiyou, PKHM_SkHubiRenrakuNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkHubiRenrakuNaiyou";
    public static final String SKHUBIRENRAKUNAIYOUCD    = "skhubirenrakunaiyoucd";
    public static final String SKHUBIRENRAKUNAIYOU      = "skhubirenrakunaiyou";
    public static final String TYOUBUNFLG               = "tyoubunflg";

    private final PKHM_SkHubiRenrakuNaiyou primaryKey;

    public GenHM_SkHubiRenrakuNaiyou() {
        primaryKey = new PKHM_SkHubiRenrakuNaiyou();
    }

    public GenHM_SkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd) {
        primaryKey = new PKHM_SkHubiRenrakuNaiyou(pSkhubirenrakunaiyoucd);
    }

    @Transient
    @Override
    public PKHM_SkHubiRenrakuNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkHubiRenrakuNaiyou> getMetaClass() {
        return QHM_SkHubiRenrakuNaiyou.class;
    }

    @Id
    @Column(name=GenHM_SkHubiRenrakuNaiyou.SKHUBIRENRAKUNAIYOUCD)
    public String getSkhubirenrakunaiyoucd() {
        return getPrimaryKey().getSkhubirenrakunaiyoucd();
    }

    public void setSkhubirenrakunaiyoucd(String pSkhubirenrakunaiyoucd) {
        getPrimaryKey().setSkhubirenrakunaiyoucd(pSkhubirenrakunaiyoucd);
    }

    private String skhubirenrakunaiyou;

    @Column(name=GenHM_SkHubiRenrakuNaiyou.SKHUBIRENRAKUNAIYOU)
    public String getSkhubirenrakunaiyou() {
        return skhubirenrakunaiyou;
    }

    public void setSkhubirenrakunaiyou(String pSkhubirenrakunaiyou) {
        skhubirenrakunaiyou = pSkhubirenrakunaiyou;
    }

    private C_UmuKbn tyoubunflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHM_SkHubiRenrakuNaiyou.TYOUBUNFLG)
    public C_UmuKbn getTyoubunflg() {
        return tyoubunflg;
    }

    public void setTyoubunflg(C_UmuKbn pTyoubunflg) {
        tyoubunflg = pTyoubunflg;
    }
}
