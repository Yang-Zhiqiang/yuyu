package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.id.PKHT_MosnoKanri;
import yuyu.def.db.meta.GenQHT_MosnoKanri;
import yuyu.def.db.meta.QHT_MosnoKanri;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 申込番号管理テーブル テーブルのマッピング情報クラスで、 {@link HT_MosnoKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosnoKanri}</td><td colspan="3">申込番号管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno8keta mosno8keta}</td><td>申込番号（８桁）</td><td align="center">{@link PKHT_MosnoKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaibankahikbn saibankahikbn}</td><td>採番可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getMossykykyoteiymd mossykykyoteiymd}</td><td>申込消却予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSaibanymd saibanymd}</td><td>採番日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosnoKanri
 * @see     PKHT_MosnoKanri
 * @see     QHT_MosnoKanri
 * @see     GenQHT_MosnoKanri
 */
@MappedSuperclass
@Table(name=GenHT_MosnoKanri.TABLE_NAME)
@IdClass(value=PKHT_MosnoKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class)
})
public abstract class GenHT_MosnoKanri extends AbstractExDBEntity<HT_MosnoKanri, PKHT_MosnoKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MosnoKanri";
    public static final String MOSNO8KETA               = "mosno8keta";
    public static final String SAIBANKAHIKBN            = "saibankahikbn";
    public static final String MOSSYKYKYOTEIYMD         = "mossykykyoteiymd";
    public static final String SAIBANYMD                = "saibanymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MosnoKanri primaryKey;

    public GenHT_MosnoKanri() {
        primaryKey = new PKHT_MosnoKanri();
    }

    public GenHT_MosnoKanri(String pMosno8keta) {
        primaryKey = new PKHT_MosnoKanri(pMosno8keta);
    }

    @Transient
    @Override
    public PKHT_MosnoKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MosnoKanri> getMetaClass() {
        return QHT_MosnoKanri.class;
    }

    @Id
    @Column(name=GenHT_MosnoKanri.MOSNO8KETA)
    public String getMosno8keta() {
        return getPrimaryKey().getMosno8keta();
    }

    public void setMosno8keta(String pMosno8keta) {
        getPrimaryKey().setMosno8keta(pMosno8keta);
    }

    private C_KahiKbn saibankahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenHT_MosnoKanri.SAIBANKAHIKBN)
    public C_KahiKbn getSaibankahikbn() {
        return saibankahikbn;
    }

    public void setSaibankahikbn(C_KahiKbn pSaibankahikbn) {
        saibankahikbn = pSaibankahikbn;
    }

    private BizDate mossykykyoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosnoKanri.MOSSYKYKYOTEIYMD)
    public BizDate getMossykykyoteiymd() {
        return mossykykyoteiymd;
    }

    public void setMossykykyoteiymd(BizDate pMossykykyoteiymd) {
        mossykykyoteiymd = pMossykykyoteiymd;
    }

    private BizDate saibanymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosnoKanri.SAIBANYMD)
    public BizDate getSaibanymd() {
        return saibanymd;
    }

    public void setSaibanymd(BizDate pSaibanymd) {
        saibanymd = pSaibanymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MosnoKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MosnoKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}