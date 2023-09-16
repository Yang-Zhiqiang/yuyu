package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_MinusUriageKykDtlList;
import yuyu.def.db.id.PKIT_MinusUriageKykDtlList;
import yuyu.def.db.meta.GenQIT_MinusUriageKykDtlList;
import yuyu.def.db.meta.QIT_MinusUriageKykDtlList;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * マイナス売上契約明細リストテーブル テーブルのマッピング情報クラスで、 {@link IT_MinusUriageKykDtlList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_MinusUriageKykDtlList}</td><td colspan="3">マイナス売上契約明細リストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_MinusUriageKykDtlList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_MinusUriageKykDtlList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">{@link PKIT_MinusUriageKykDtlList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_MinusUriageKykDtlList ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCredituriagegk credituriagegk}</td><td>クレジットカード売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_MinusUriageKykDtlList
 * @see     PKIT_MinusUriageKykDtlList
 * @see     QIT_MinusUriageKykDtlList
 * @see     GenQIT_MinusUriageKykDtlList
 */
@MappedSuperclass
@Table(name=GenIT_MinusUriageKykDtlList.TABLE_NAME)
@IdClass(value=PKIT_MinusUriageKykDtlList.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class)
})
public abstract class GenIT_MinusUriageKykDtlList extends AbstractExDBEntity<IT_MinusUriageKykDtlList, PKIT_MinusUriageKykDtlList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_MinusUriageKykDtlList";
    public static final String SYONO                    = "syono";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String URIAGENENGAPPI           = "uriagenengappi";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String CREDITURIAGEGK           = "credituriagegk";
    public static final String KINOUID                  = "kinouId";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_MinusUriageKykDtlList primaryKey;

    public GenIT_MinusUriageKykDtlList() {
        primaryKey = new PKIT_MinusUriageKykDtlList();
    }

    public GenIT_MinusUriageKykDtlList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_MinusUriageKykDtlList(
            pSyono,
            pCreditkessaiyouno,
            pUriagenengappi,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_MinusUriageKykDtlList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_MinusUriageKykDtlList> getMetaClass() {
        return QIT_MinusUriageKykDtlList.class;
    }

    @Id
    @Column(name=GenIT_MinusUriageKykDtlList.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_MinusUriageKykDtlList.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_MinusUriageKykDtlList.URIAGENENGAPPI)
    public BizDate getUriagenengappi() {
        return getPrimaryKey().getUriagenengappi();
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        getPrimaryKey().setUriagenengappi(pUriagenengappi);
    }

    @Id
    @Column(name=GenIT_MinusUriageKykDtlList.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_MinusUriageKykDtlList.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_MinusUriageKykDtlList.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizCurrency credituriagegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCredituriagegk() {
        return credituriagegk;
    }

    public void setCredituriagegk(BizCurrency pCredituriagegk) {
        credituriagegk = pCredituriagegk;
        credituriagegkValue = null;
        credituriagegkType  = null;
    }

    transient private BigDecimal credituriagegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CREDITURIAGEGK, nullable=true)
    protected BigDecimal getCredituriagegkValue() {
        if (credituriagegkValue == null && credituriagegk != null) {
            if (credituriagegk.isOptional()) return null;
            return credituriagegk.absolute();
        }
        return credituriagegkValue;
    }

    protected void setCredituriagegkValue(BigDecimal value) {
        credituriagegkValue = value;
        credituriagegk = Optional.fromNullable(toCurrencyType(credituriagegkType))
            .transform(bizCurrencyTransformer(getCredituriagegkValue()))
            .orNull();
    }

    transient private String credituriagegkType = null;

    @Column(name=CREDITURIAGEGK + "$", nullable=true)
    protected String getCredituriagegkType() {
        if (credituriagegkType == null && credituriagegk != null) return credituriagegk.getType().toString();
        if (credituriagegkType == null && getCredituriagegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'credituriagegk$' should not be NULL."));
        }
        return credituriagegkType;
    }

    protected void setCredituriagegkType(String type) {
        credituriagegkType = type;
        credituriagegk = Optional.fromNullable(toCurrencyType(credituriagegkType))
            .transform(bizCurrencyTransformer(getCredituriagegkValue()))
            .orNull();
    }

    private String kinouId;

    @Column(name=GenIT_MinusUriageKykDtlList.KINOUID)
    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_MinusUriageKykDtlList.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_MinusUriageKykDtlList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_MinusUriageKykDtlList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}