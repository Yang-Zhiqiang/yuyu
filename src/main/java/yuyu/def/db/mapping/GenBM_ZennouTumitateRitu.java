package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ZennouTumitateRitu;
import yuyu.def.db.id.PKBM_ZennouTumitateRitu;
import yuyu.def.db.meta.GenQBM_ZennouTumitateRitu;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu;

/**
 * 前納積立率マスタ テーブルのマッピング情報クラスで、 {@link BM_ZennouTumitateRitu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ZennouTumitateRitu}</td><td colspan="3">前納積立率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">{@link PKBM_ZennouTumitateRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">{@link PKBM_ZennouTumitateRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoutumitateritu zennoutumitateritu}</td><td>前納積立率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ZennouTumitateRitu
 * @see     PKBM_ZennouTumitateRitu
 * @see     QBM_ZennouTumitateRitu
 * @see     GenQBM_ZennouTumitateRitu
 */
@MappedSuperclass
@Table(name=GenBM_ZennouTumitateRitu.TABLE_NAME)
@IdClass(value=PKBM_ZennouTumitateRitu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ZennouTumitateRitu extends AbstractExDBEntity<BM_ZennouTumitateRitu, PKBM_ZennouTumitateRitu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ZennouTumitateRitu";
    public static final String TEKIYOUKKNFROM           = "tekiyoukknfrom";
    public static final String TEKIYOUKKNKTO            = "tekiyoukknkto";
    public static final String ZENNOUTUMITATERITU       = "zennoutumitateritu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_ZennouTumitateRitu primaryKey;

    public GenBM_ZennouTumitateRitu() {
        primaryKey = new PKBM_ZennouTumitateRitu();
    }

    public GenBM_ZennouTumitateRitu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        primaryKey = new PKBM_ZennouTumitateRitu(pTekiyoukknfrom, pTekiyoukknkto);
    }

    @Transient
    @Override
    public PKBM_ZennouTumitateRitu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ZennouTumitateRitu> getMetaClass() {
        return QBM_ZennouTumitateRitu.class;
    }

    @Id
    @Column(name=GenBM_ZennouTumitateRitu.TEKIYOUKKNFROM)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknfrom() {
        return getPrimaryKey().getTekiyoukknfrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknfrom(String pTekiyoukknfrom) {
        getPrimaryKey().setTekiyoukknfrom(pTekiyoukknfrom);
    }

    @Id
    @Column(name=GenBM_ZennouTumitateRitu.TEKIYOUKKNKTO)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknkto() {
        return getPrimaryKey().getTekiyoukknkto();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknkto(String pTekiyoukknkto) {
        getPrimaryKey().setTekiyoukknkto(pTekiyoukknkto);
    }

    private BizNumber zennoutumitateritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ZennouTumitateRitu.ZENNOUTUMITATERITU)
    public BizNumber getZennoutumitateritu() {
        return zennoutumitateritu;
    }

    public void setZennoutumitateritu(BizNumber pZennoutumitateritu) {
        zennoutumitateritu = pZennoutumitateritu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_ZennouTumitateRitu.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_ZennouTumitateRitu.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_ZennouTumitateRitu.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}