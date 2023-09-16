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
import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;
import yuyu.def.db.id.PKIW_KhHubiKaisyouDetailWk;
import yuyu.def.db.meta.GenQIW_KhHubiKaisyouDetailWk;
import yuyu.def.db.meta.QIW_KhHubiKaisyouDetailWk;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備解消詳細ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhHubiKaisyouDetailWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHubiKaisyouDetailWk}</td><td colspan="3">契約保全不備解消詳細ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhHubiKaisyouDetailWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIW_KhHubiKaisyouDetailWk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHubikaisyouumukbn hubikaisyouumukbn}</td><td>不備解消有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhHubiKaisyouDetailWk
 * @see     PKIW_KhHubiKaisyouDetailWk
 * @see     QIW_KhHubiKaisyouDetailWk
 * @see     GenQIW_KhHubiKaisyouDetailWk
 */
@MappedSuperclass
@Table(name=GenIW_KhHubiKaisyouDetailWk.TABLE_NAME)
@IdClass(value=PKIW_KhHubiKaisyouDetailWk.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIW_KhHubiKaisyouDetailWk extends AbstractExDBEntity<IW_KhHubiKaisyouDetailWk, PKIW_KhHubiKaisyouDetailWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhHubiKaisyouDetailWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String HUBIKAISYOUUMUKBN        = "hubikaisyouumukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhHubiKaisyouDetailWk primaryKey;

    public GenIW_KhHubiKaisyouDetailWk() {
        primaryKey = new PKIW_KhHubiKaisyouDetailWk();
    }

    public GenIW_KhHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        primaryKey = new PKIW_KhHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
    }

    @Transient
    @Override
    public PKIW_KhHubiKaisyouDetailWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhHubiKaisyouDetailWk> getMetaClass() {
        return QIW_KhHubiKaisyouDetailWk.class;
    }

    @Id
    @Column(name=GenIW_KhHubiKaisyouDetailWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    @Id
    @Column(name=GenIW_KhHubiKaisyouDetailWk.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private C_UmuKbn hubikaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_KhHubiKaisyouDetailWk.HUBIKAISYOUUMUKBN)
    public C_UmuKbn getHubikaisyouumukbn() {
        return hubikaisyouumukbn;
    }

    public void setHubikaisyouumukbn(C_UmuKbn pHubikaisyouumukbn) {
        hubikaisyouumukbn = pHubikaisyouumukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhHubiKaisyouDetailWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhHubiKaisyouDetailWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhHubiKaisyouDetailWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
