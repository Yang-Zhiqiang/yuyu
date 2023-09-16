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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;
import yuyu.def.db.id.PKBM_ZennouKeikaRiritu;
import yuyu.def.db.meta.GenQBM_ZennouKeikaRiritu;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu;

/**
 * 前納経過利率マスタ テーブルのマッピング情報クラスで、 {@link BM_ZennouKeikaRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ZennouKeikaRiritu}</td><td colspan="3">前納経過利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKeikatukisuu keikatukisuu}</td><td>経過月数（２桁）</td><td align="center">{@link PKBM_ZennouKeikaRiritu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">{@link PKBM_ZennouKeikaRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">{@link PKBM_ZennouKeikaRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoukeikariritu zennoukeikariritu}</td><td>前納経過利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ZennouKeikaRiritu
 * @see     PKBM_ZennouKeikaRiritu
 * @see     QBM_ZennouKeikaRiritu
 * @see     GenQBM_ZennouKeikaRiritu
 */
@MappedSuperclass
@Table(name=GenBM_ZennouKeikaRiritu.TABLE_NAME)
@IdClass(value=PKBM_ZennouKeikaRiritu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ZennouKeikaRiritu extends AbstractExDBEntity<BM_ZennouKeikaRiritu, PKBM_ZennouKeikaRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ZennouKeikaRiritu";
    public static final String KEIKATUKISUU             = "keikatukisuu";
    public static final String TEKIYOUKKNFROM           = "tekiyoukknfrom";
    public static final String TEKIYOUKKNKTO            = "tekiyoukknkto";
    public static final String ZENNOUKEIKARIRITU        = "zennoukeikariritu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_ZennouKeikaRiritu primaryKey;

    public GenBM_ZennouKeikaRiritu() {
        primaryKey = new PKBM_ZennouKeikaRiritu();
    }

    public GenBM_ZennouKeikaRiritu(
        Integer pKeikatukisuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        primaryKey = new PKBM_ZennouKeikaRiritu(
            pKeikatukisuu,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

    @Transient
    @Override
    public PKBM_ZennouKeikaRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ZennouKeikaRiritu> getMetaClass() {
        return QBM_ZennouKeikaRiritu.class;
    }

    @Id
    @Column(name=GenBM_ZennouKeikaRiritu.KEIKATUKISUU)
    @Range(min="0", max="12")
    public Integer getKeikatukisuu() {
        return getPrimaryKey().getKeikatukisuu();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKeikatukisuu(Integer pKeikatukisuu) {
        getPrimaryKey().setKeikatukisuu(pKeikatukisuu);
    }

    @Id
    @Column(name=GenBM_ZennouKeikaRiritu.TEKIYOUKKNFROM)
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
    @Column(name=GenBM_ZennouKeikaRiritu.TEKIYOUKKNKTO)
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

    private BizNumber zennoukeikariritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ZennouKeikaRiritu.ZENNOUKEIKARIRITU)
    public BizNumber getZennoukeikariritu() {
        return zennoukeikariritu;
    }

    public void setZennoukeikariritu(BizNumber pZennoukeikariritu) {
        zennoukeikariritu = pZennoukeikariritu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_ZennouKeikaRiritu.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_ZennouKeikaRiritu.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_ZennouKeikaRiritu.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}