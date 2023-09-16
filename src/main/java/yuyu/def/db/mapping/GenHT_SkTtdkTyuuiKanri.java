package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.id.PKHT_SkTtdkTyuuiKanri;
import yuyu.def.db.meta.GenQHT_SkTtdkTyuuiKanri;
import yuyu.def.db.meta.QHT_SkTtdkTyuuiKanri;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約手続注意管理テーブル テーブルのマッピング情報クラスで、 {@link HT_SkTtdkTyuuiKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkTtdkTyuuiKanri}</td><td colspan="3">新契約手続注意管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkTtdkTyuuiKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkeittdkkinkyuyouhikbn skeittdkkinkyuyouhikbn}</td><td>新契約手続緊急要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getSkeittdktyuuiyouhikbn skeittdktyuuiyouhikbn}</td><td>新契約手続注意要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkTtdkTyuuiKanri
 * @see     PKHT_SkTtdkTyuuiKanri
 * @see     QHT_SkTtdkTyuuiKanri
 * @see     GenQHT_SkTtdkTyuuiKanri
 */
@MappedSuperclass
@Table(name=GenHT_SkTtdkTyuuiKanri.TABLE_NAME)
@IdClass(value=PKHT_SkTtdkTyuuiKanri.class)
@TypeDefs({
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenHT_SkTtdkTyuuiKanri extends AbstractExDBEntity<HT_SkTtdkTyuuiKanri, PKHT_SkTtdkTyuuiKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkTtdkTyuuiKanri";
    public static final String MOSNO                    = "mosno";
    public static final String SKEITTDKKINKYUYOUHIKBN   = "skeittdkkinkyuyouhikbn";
    public static final String SKEITTDKTYUUIYOUHIKBN    = "skeittdktyuuiyouhikbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkTtdkTyuuiKanri primaryKey;

    public GenHT_SkTtdkTyuuiKanri() {
        primaryKey = new PKHT_SkTtdkTyuuiKanri();
    }

    public GenHT_SkTtdkTyuuiKanri(String pMosno) {
        primaryKey = new PKHT_SkTtdkTyuuiKanri(pMosno);
    }

    @Transient
    @Override
    public PKHT_SkTtdkTyuuiKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkTtdkTyuuiKanri> getMetaClass() {
        return QHT_SkTtdkTyuuiKanri.class;
    }

    @Id
    @Column(name=GenHT_SkTtdkTyuuiKanri.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private C_YouhiKbn skeittdkkinkyuyouhikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenHT_SkTtdkTyuuiKanri.SKEITTDKKINKYUYOUHIKBN)
    public C_YouhiKbn getSkeittdkkinkyuyouhikbn() {
        return skeittdkkinkyuyouhikbn;
    }

    public void setSkeittdkkinkyuyouhikbn(C_YouhiKbn pSkeittdkkinkyuyouhikbn) {
        skeittdkkinkyuyouhikbn = pSkeittdkkinkyuyouhikbn;
    }

    private C_YouhiKbn skeittdktyuuiyouhikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenHT_SkTtdkTyuuiKanri.SKEITTDKTYUUIYOUHIKBN)
    public C_YouhiKbn getSkeittdktyuuiyouhikbn() {
        return skeittdktyuuiyouhikbn;
    }

    public void setSkeittdktyuuiyouhikbn(C_YouhiKbn pSkeittdktyuuiyouhikbn) {
        skeittdktyuuiyouhikbn = pSkeittdktyuuiyouhikbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkTtdkTyuuiKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkTtdkTyuuiKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}