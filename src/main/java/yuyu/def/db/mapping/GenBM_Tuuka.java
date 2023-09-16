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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_Tuuka;
import yuyu.def.db.id.PKBM_Tuuka;
import yuyu.def.db.meta.GenQBM_Tuuka;
import yuyu.def.db.meta.QBM_Tuuka;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 通貨マスタ テーブルのマッピング情報クラスで、 {@link BM_Tuuka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Tuuka}</td><td colspan="3">通貨マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_Tuuka ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSsketasuu ssketasuu}</td><td>小数桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuukasyumei tuukasyumei}</td><td>通貨種類正式名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyuryk tuukasyuryk}</td><td>通貨種類略称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Tuuka
 * @see     PKBM_Tuuka
 * @see     QBM_Tuuka
 * @see     GenQBM_Tuuka
 */
@MappedSuperclass
@Table(name=GenBM_Tuuka.TABLE_NAME)
@IdClass(value=PKBM_Tuuka.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_Tuuka extends AbstractExDBEntity<BM_Tuuka, PKBM_Tuuka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Tuuka";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SSKETASUU                = "ssketasuu";
    public static final String TUUKASYUMEI              = "tuukasyumei";
    public static final String TUUKASYURYK              = "tuukasyuryk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_Tuuka primaryKey;

    public GenBM_Tuuka() {
        primaryKey = new PKBM_Tuuka();
    }

    public GenBM_Tuuka(C_Tuukasyu pTuukasyu) {
        primaryKey = new PKBM_Tuuka(pTuukasyu);
    }

    @Transient
    @Override
    public PKBM_Tuuka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Tuuka> getMetaClass() {
        return QBM_Tuuka.class;
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_Tuuka.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    private Integer ssketasuu;

    @Column(name=GenBM_Tuuka.SSKETASUU)
    public Integer getSsketasuu() {
        return ssketasuu;
    }

    public void setSsketasuu(Integer pSsketasuu) {
        ssketasuu = pSsketasuu;
    }

    private String tuukasyumei;

    @Column(name=GenBM_Tuuka.TUUKASYUMEI)
    public String getTuukasyumei() {
        return tuukasyumei;
    }

    public void setTuukasyumei(String pTuukasyumei) {
        tuukasyumei = pTuukasyumei;
    }

    private String tuukasyuryk;

    @Column(name=GenBM_Tuuka.TUUKASYURYK)
    public String getTuukasyuryk() {
        return tuukasyuryk;
    }

    public void setTuukasyuryk(String pTuukasyuryk) {
        tuukasyuryk = pTuukasyuryk;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_Tuuka.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_Tuuka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_Tuuka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
