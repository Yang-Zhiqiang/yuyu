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
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.id.PKBM_Segment;
import yuyu.def.db.meta.GenQBM_Segment;
import yuyu.def.db.meta.QBM_Segment;
import yuyu.def.db.type.UserType_C_Segcd;

/**
 * セグメントマスタ テーブルのマッピング情報クラスで、 {@link BM_Segment} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Segment}</td><td colspan="3">セグメントマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">{@link PKBM_Segment ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSegnm segnm}</td><td>セグメント名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Segment
 * @see     PKBM_Segment
 * @see     QBM_Segment
 * @see     GenQBM_Segment
 */
@MappedSuperclass
@Table(name=GenBM_Segment.TABLE_NAME)
@IdClass(value=PKBM_Segment.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class)
})
public abstract class GenBM_Segment extends AbstractExDBEntity<BM_Segment, PKBM_Segment> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Segment";
    public static final String SEGCD                    = "segcd";
    public static final String SEGNM                    = "segnm";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_Segment primaryKey;

    public GenBM_Segment() {
        primaryKey = new PKBM_Segment();
    }

    public GenBM_Segment(C_Segcd pSegcd) {
        primaryKey = new PKBM_Segment(pSegcd);
    }

    @Transient
    @Override
    public PKBM_Segment getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Segment> getMetaClass() {
        return QBM_Segment.class;
    }

    @Id
    @Type(type="UserType_C_Segcd")
    @Column(name=GenBM_Segment.SEGCD)
    public C_Segcd getSegcd() {
        return getPrimaryKey().getSegcd();
    }

    public void setSegcd(C_Segcd pSegcd) {
        getPrimaryKey().setSegcd(pSegcd);
    }

    private String segnm;

    @Column(name=GenBM_Segment.SEGNM)
    public String getSegnm() {
        return segnm;
    }

    public void setSegnm(String pSegnm) {
        segnm = pSegnm;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_Segment.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_Segment.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}