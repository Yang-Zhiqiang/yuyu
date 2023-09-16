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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.id.PKBT_HituyouSyoruiKanri;
import yuyu.def.db.meta.GenQBT_HituyouSyoruiKanri;
import yuyu.def.db.meta.QBT_HituyouSyoruiKanri;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 必要書類管理テーブル テーブルのマッピング情報クラスで、 {@link BT_HituyouSyoruiKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HituyouSyoruiKanri}</td><td colspan="3">必要書類管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKBT_HituyouSyoruiKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKBT_HituyouSyoruiKanri ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_HituyouSyoruiKanri
 * @see     PKBT_HituyouSyoruiKanri
 * @see     QBT_HituyouSyoruiKanri
 * @see     GenQBT_HituyouSyoruiKanri
 */
@MappedSuperclass
@Table(name=GenBT_HituyouSyoruiKanri.TABLE_NAME)
@IdClass(value=PKBT_HituyouSyoruiKanri.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenBT_HituyouSyoruiKanri extends AbstractExDBEntity<BT_HituyouSyoruiKanri, PKBT_HituyouSyoruiKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_HituyouSyoruiKanri";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_HituyouSyoruiKanri primaryKey;

    public GenBT_HituyouSyoruiKanri() {
        primaryKey = new PKBT_HituyouSyoruiKanri();
    }

    public GenBT_HituyouSyoruiKanri(String pKouteikanriid, C_SyoruiCdKbn pSyoruiCd) {
        primaryKey = new PKBT_HituyouSyoruiKanri(pKouteikanriid, pSyoruiCd);
    }

    @Transient
    @Override
    public PKBT_HituyouSyoruiKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_HituyouSyoruiKanri> getMetaClass() {
        return QBT_HituyouSyoruiKanri.class;
    }

    @Id
    @Column(name=GenBT_HituyouSyoruiKanri.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBT_HituyouSyoruiKanri.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_HituyouSyoruiKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_HituyouSyoruiKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}