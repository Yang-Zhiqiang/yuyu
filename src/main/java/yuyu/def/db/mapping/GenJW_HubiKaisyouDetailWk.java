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
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.db.id.PKJW_HubiKaisyouDetailWk;
import yuyu.def.db.meta.GenQJW_HubiKaisyouDetailWk;
import yuyu.def.db.meta.QJW_HubiKaisyouDetailWk;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払不備解消詳細ワークテーブル テーブルのマッピング情報クラスで、 {@link JW_HubiKaisyouDetailWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JW_HubiKaisyouDetailWk}</td><td colspan="3">支払不備解消詳細ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKJW_HubiKaisyouDetailWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKJW_HubiKaisyouDetailWk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHubikaisyouumukbn hubikaisyouumukbn}</td><td>不備解消有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JW_HubiKaisyouDetailWk
 * @see     PKJW_HubiKaisyouDetailWk
 * @see     QJW_HubiKaisyouDetailWk
 * @see     GenQJW_HubiKaisyouDetailWk
 */
@MappedSuperclass
@Table(name=GenJW_HubiKaisyouDetailWk.TABLE_NAME)
@IdClass(value=PKJW_HubiKaisyouDetailWk.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJW_HubiKaisyouDetailWk extends AbstractExDBEntity<JW_HubiKaisyouDetailWk, PKJW_HubiKaisyouDetailWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JW_HubiKaisyouDetailWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String HUBIKAISYOUUMUKBN        = "hubikaisyouumukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJW_HubiKaisyouDetailWk primaryKey;

    public GenJW_HubiKaisyouDetailWk() {
        primaryKey = new PKJW_HubiKaisyouDetailWk();
    }

    public GenJW_HubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        primaryKey = new PKJW_HubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
    }

    @Transient
    @Override
    public PKJW_HubiKaisyouDetailWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJW_HubiKaisyouDetailWk> getMetaClass() {
        return QJW_HubiKaisyouDetailWk.class;
    }

    @Id
    @Column(name=GenJW_HubiKaisyouDetailWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    @Id
    @Column(name=GenJW_HubiKaisyouDetailWk.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private C_UmuKbn hubikaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJW_HubiKaisyouDetailWk.HUBIKAISYOUUMUKBN)
    public C_UmuKbn getHubikaisyouumukbn() {
        return hubikaisyouumukbn;
    }

    public void setHubikaisyouumukbn(C_UmuKbn pHubikaisyouumukbn) {
        hubikaisyouumukbn = pHubikaisyouumukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJW_HubiKaisyouDetailWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJW_HubiKaisyouDetailWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
