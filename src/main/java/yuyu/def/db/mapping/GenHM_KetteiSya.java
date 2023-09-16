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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.id.PKHM_KetteiSya;
import yuyu.def.db.meta.GenQHM_KetteiSya;
import yuyu.def.db.meta.QHM_KetteiSya;
import yuyu.def.db.type.UserType_C_ImusateirankKbn;
import yuyu.def.db.type.UserType_C_KnksateirankKbn;
import yuyu.def.db.type.UserType_C_MostenkenRankKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 決定者マスタ テーブルのマッピング情報クラスで、 {@link HM_KetteiSya} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_KetteiSya}</td><td colspan="3">決定者マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">{@link PKHM_KetteiSya ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetsyanm ketsyanm}</td><td>決定者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMostenkenrankkbn mostenkenrankkbn}</td><td>申込点検ランク区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MostenkenRankKbn}</td></tr>
 *  <tr><td>{@link #getKnksateirankkbn knksateirankkbn}</td><td>環境査定ランク区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KnksateirankKbn}</td></tr>
 *  <tr><td>{@link #getKnksateijygns knksateijygns}</td><td>環境査定上限Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getImusateirankkbn imusateirankkbn}</td><td>医務査定ランク区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ImusateirankKbn}</td></tr>
 *  <tr><td>{@link #getImusateijygns imusateijygns}</td><td>医務査定上限Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_KetteiSya
 * @see     PKHM_KetteiSya
 * @see     QHM_KetteiSya
 * @see     GenQHM_KetteiSya
 */
@MappedSuperclass
@Table(name=GenHM_KetteiSya.TABLE_NAME)
@IdClass(value=PKHM_KetteiSya.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_ImusateirankKbn", typeClass=UserType_C_ImusateirankKbn.class),
    @TypeDef(name="UserType_C_KnksateirankKbn", typeClass=UserType_C_KnksateirankKbn.class),
    @TypeDef(name="UserType_C_MostenkenRankKbn", typeClass=UserType_C_MostenkenRankKbn.class)
})
public abstract class GenHM_KetteiSya extends AbstractExDBEntity<HM_KetteiSya, PKHM_KetteiSya> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_KetteiSya";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String KETSYANM                 = "ketsyanm";
    public static final String MOSTENKENRANKKBN         = "mostenkenrankkbn";
    public static final String KNKSATEIRANKKBN          = "knksateirankkbn";
    public static final String KNKSATEIJYGNS            = "knksateijygns";
    public static final String IMUSATEIRANKKBN          = "imusateirankkbn";
    public static final String IMUSATEIJYGNS            = "imusateijygns";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHM_KetteiSya primaryKey;

    public GenHM_KetteiSya() {
        primaryKey = new PKHM_KetteiSya();
    }

    public GenHM_KetteiSya(String pKetsyacd) {
        primaryKey = new PKHM_KetteiSya(pKetsyacd);
    }

    @Transient
    @Override
    public PKHM_KetteiSya getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_KetteiSya> getMetaClass() {
        return QHM_KetteiSya.class;
    }

    @Id
    @Column(name=GenHM_KetteiSya.KETSYACD)
    @MaxLength(max=15)
    @AlphaDigit
    public String getKetsyacd() {
        return getPrimaryKey().getKetsyacd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetsyacd(String pKetsyacd) {
        getPrimaryKey().setKetsyacd(pKetsyacd);
    }

    private String palketsyacd;

    @Column(name=GenHM_KetteiSya.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private String ketsyanm;

    @Column(name=GenHM_KetteiSya.KETSYANM)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKetsyanm() {
        return ketsyanm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKetsyanm(String pKetsyanm) {
        ketsyanm = pKetsyanm;
    }

    private C_MostenkenRankKbn mostenkenrankkbn;

    @Type(type="UserType_C_MostenkenRankKbn")
    @Column(name=GenHM_KetteiSya.MOSTENKENRANKKBN)
    public C_MostenkenRankKbn getMostenkenrankkbn() {
        return mostenkenrankkbn;
    }

    public void setMostenkenrankkbn(C_MostenkenRankKbn pMostenkenrankkbn) {
        mostenkenrankkbn = pMostenkenrankkbn;
    }

    private C_KnksateirankKbn knksateirankkbn;

    @Type(type="UserType_C_KnksateirankKbn")
    @Column(name=GenHM_KetteiSya.KNKSATEIRANKKBN)
    public C_KnksateirankKbn getKnksateirankkbn() {
        return knksateirankkbn;
    }

    public void setKnksateirankkbn(C_KnksateirankKbn pKnksateirankkbn) {
        knksateirankkbn = pKnksateirankkbn;
    }

    private BizCurrency knksateijygns;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getKnksateijygns() {
        return knksateijygns;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKnksateijygns(BizCurrency pKnksateijygns) {
        knksateijygns = pKnksateijygns;
        knksateijygnsValue = null;
        knksateijygnsType  = null;
    }

    transient private BigDecimal knksateijygnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNKSATEIJYGNS, nullable=true)
    protected BigDecimal getKnksateijygnsValue() {
        if (knksateijygnsValue == null && knksateijygns != null) {
            if (knksateijygns.isOptional()) return null;
            return knksateijygns.absolute();
        }
        return knksateijygnsValue;
    }

    protected void setKnksateijygnsValue(BigDecimal value) {
        knksateijygnsValue = value;
        knksateijygns = Optional.fromNullable(toCurrencyType(knksateijygnsType))
            .transform(bizCurrencyTransformer(getKnksateijygnsValue()))
            .orNull();
    }

    transient private String knksateijygnsType = null;

    @Column(name=KNKSATEIJYGNS + "$", nullable=true)
    protected String getKnksateijygnsType() {
        if (knksateijygnsType == null && knksateijygns != null) return knksateijygns.getType().toString();
        if (knksateijygnsType == null && getKnksateijygnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'knksateijygns$' should not be NULL."));
        }
        return knksateijygnsType;
    }

    protected void setKnksateijygnsType(String type) {
        knksateijygnsType = type;
        knksateijygns = Optional.fromNullable(toCurrencyType(knksateijygnsType))
            .transform(bizCurrencyTransformer(getKnksateijygnsValue()))
            .orNull();
    }

    private C_ImusateirankKbn imusateirankkbn;

    @Type(type="UserType_C_ImusateirankKbn")
    @Column(name=GenHM_KetteiSya.IMUSATEIRANKKBN)
    public C_ImusateirankKbn getImusateirankkbn() {
        return imusateirankkbn;
    }

    public void setImusateirankkbn(C_ImusateirankKbn pImusateirankkbn) {
        imusateirankkbn = pImusateirankkbn;
    }

    private BizCurrency imusateijygns;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getImusateijygns() {
        return imusateijygns;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setImusateijygns(BizCurrency pImusateijygns) {
        imusateijygns = pImusateijygns;
        imusateijygnsValue = null;
        imusateijygnsType  = null;
    }

    transient private BigDecimal imusateijygnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IMUSATEIJYGNS, nullable=true)
    protected BigDecimal getImusateijygnsValue() {
        if (imusateijygnsValue == null && imusateijygns != null) {
            if (imusateijygns.isOptional()) return null;
            return imusateijygns.absolute();
        }
        return imusateijygnsValue;
    }

    protected void setImusateijygnsValue(BigDecimal value) {
        imusateijygnsValue = value;
        imusateijygns = Optional.fromNullable(toCurrencyType(imusateijygnsType))
            .transform(bizCurrencyTransformer(getImusateijygnsValue()))
            .orNull();
    }

    transient private String imusateijygnsType = null;

    @Column(name=IMUSATEIJYGNS + "$", nullable=true)
    protected String getImusateijygnsType() {
        if (imusateijygnsType == null && imusateijygns != null) return imusateijygns.getType().toString();
        if (imusateijygnsType == null && getImusateijygnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'imusateijygns$' should not be NULL."));
        }
        return imusateijygnsType;
    }

    protected void setImusateijygnsType(String type) {
        imusateijygnsType = type;
        imusateijygns = Optional.fromNullable(toCurrencyType(imusateijygnsType))
            .transform(bizCurrencyTransformer(getImusateijygnsValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHM_KetteiSya.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHM_KetteiSya.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}