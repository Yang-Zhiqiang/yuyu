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
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.id.PKBM_SikinIdouGroup;
import yuyu.def.db.meta.GenQBM_SikinIdouGroup;
import yuyu.def.db.meta.QBM_SikinIdouGroup;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;

/**
 * 資金移動グループマスタ テーブルのマッピング情報クラスで、 {@link BM_SikinIdouGroup} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SikinIdouGroup}</td><td colspan="3">資金移動グループマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">{@link PKBM_SikinIdouGroup ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSikinidougroupkbn sikinidougroupkbn}</td><td>資金移動グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SikinidougroupKbn}</td></tr>
 * </table>
 * @see     BM_SikinIdouGroup
 * @see     PKBM_SikinIdouGroup
 * @see     QBM_SikinIdouGroup
 * @see     GenQBM_SikinIdouGroup
 */
@MappedSuperclass
@Table(name=GenBM_SikinIdouGroup.TABLE_NAME)
@IdClass(value=PKBM_SikinIdouGroup.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SikinidougroupKbn", typeClass=UserType_C_SikinidougroupKbn.class)
})
public abstract class GenBM_SikinIdouGroup extends AbstractExDBEntity<BM_SikinIdouGroup, PKBM_SikinIdouGroup> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SikinIdouGroup";
    public static final String SEGCD                    = "segcd";
    public static final String SIKINIDOUGROUPKBN        = "sikinidougroupkbn";

    private final PKBM_SikinIdouGroup primaryKey;

    public GenBM_SikinIdouGroup() {
        primaryKey = new PKBM_SikinIdouGroup();
    }

    public GenBM_SikinIdouGroup(C_Segcd pSegcd) {
        primaryKey = new PKBM_SikinIdouGroup(pSegcd);
    }

    @Transient
    @Override
    public PKBM_SikinIdouGroup getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SikinIdouGroup> getMetaClass() {
        return QBM_SikinIdouGroup.class;
    }

    @Id
    @Type(type="UserType_C_Segcd")
    @Column(name=GenBM_SikinIdouGroup.SEGCD)
    public C_Segcd getSegcd() {
        return getPrimaryKey().getSegcd();
    }

    public void setSegcd(C_Segcd pSegcd) {
        getPrimaryKey().setSegcd(pSegcd);
    }

    private C_SikinidougroupKbn sikinidougroupkbn;

    @Type(type="UserType_C_SikinidougroupKbn")
    @Column(name=GenBM_SikinIdouGroup.SIKINIDOUGROUPKBN)
    public C_SikinidougroupKbn getSikinidougroupkbn() {
        return sikinidougroupkbn;
    }

    public void setSikinidougroupkbn(C_SikinidougroupKbn pSikinidougroupkbn) {
        sikinidougroupkbn = pSikinidougroupkbn;
    }
}