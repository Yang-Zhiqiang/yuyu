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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.db.id.PKHT_Tuusan;
import yuyu.def.db.meta.GenQHT_Tuusan;
import yuyu.def.db.meta.QHT_Tuusan;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 通算テーブル テーブルのマッピング情報クラスで、 {@link HT_Tuusan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Tuusan}</td><td colspan="3">通算テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_Tuusan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsnsibous tsnsibous}</td><td>通算総死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnninenmikeikas tsnninenmikeikas}</td><td>通算２年未経過総死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnninenkeikas tsnninenkeikas}</td><td>通算２年経過総死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnninenmikeikahtnkns tsnninenmikeikahtnkns}</td><td>通算２年未経過被転換死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnninenkeikadfp tsnninenkeikadfp}</td><td>通算２年経過ＤＦＰ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnketsibous tsnketsibous}</td><td>通算決定総死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnketsibous2 tsnketsibous2}</td><td>通算決定総死亡Ｓ２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnsoukktjituhsgk tsnsoukktjituhsgk}</td><td>通算総告知書実保障額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnkktjituhsgk1 tsnkktjituhsgk1}</td><td>通算告知書実保障額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnkktjituhsgk2 tsnkktjituhsgk2}</td><td>通算告知書実保障額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnkktitijibrsysnjs tsnkktitijibrsysnjs}</td><td>通算告知書一時払終身等除Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnnkgns tsnnkgns}</td><td>通算年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnmsnynenbtsousbus tsnmsnynenbtsousbus}</td><td>通算未成年用年齢別総死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnnenbtitijibrssbs tsnnenbtitijibrssbs}</td><td>通算年齢別一時払総死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnitijibrsysnp tsnitijibrsysnp}</td><td>通算一時払終身Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnsntktuukahijynsysns tsnsntktuukahijynsysns}</td><td>通算選択通貨建平準払終身Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykdrtentsns kykdrtentsns}</td><td>契約者同一代理店通算Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsnkaigomehrtkumukbn tsnkaigomehrtkumukbn}</td><td>通算介護前払特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Tuusan
 * @see     PKHT_Tuusan
 * @see     QHT_Tuusan
 * @see     GenQHT_Tuusan
 */
@MappedSuperclass
@Table(name=GenHT_Tuusan.TABLE_NAME)
@IdClass(value=PKHT_Tuusan.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHT_Tuusan extends AbstractExDBEntity<HT_Tuusan, PKHT_Tuusan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_Tuusan";
    public static final String MOSNO                    = "mosno";
    public static final String TSNSIBOUS                = "tsnsibous";
    public static final String TSNNINENMIKEIKAS         = "tsnninenmikeikas";
    public static final String TSNNINENKEIKAS           = "tsnninenkeikas";
    public static final String TSNNINENMIKEIKAHTNKNS    = "tsnninenmikeikahtnkns";
    public static final String TSNNINENKEIKADFP         = "tsnninenkeikadfp";
    public static final String TSNKETSIBOUS             = "tsnketsibous";
    public static final String TSNKETSIBOUS2            = "tsnketsibous2";
    public static final String TSNSOUKKTJITUHSGK        = "tsnsoukktjituhsgk";
    public static final String TSNKKTJITUHSGK1          = "tsnkktjituhsgk1";
    public static final String TSNKKTJITUHSGK2          = "tsnkktjituhsgk2";
    public static final String TSNKKTITIJIBRSYSNJS      = "tsnkktitijibrsysnjs";
    public static final String TSNNKGNS                 = "tsnnkgns";
    public static final String TSNMSNYNENBTSOUSBUS      = "tsnmsnynenbtsousbus";
    public static final String TSNNENBTITIJIBRSSBS      = "tsnnenbtitijibrssbs";
    public static final String TSNITIJIBRSYSNP          = "tsnitijibrsysnp";
    public static final String TSNSNTKTUUKAHIJYNSYSNS   = "tsnsntktuukahijynsysns";
    public static final String KYKDRTENTSNS             = "kykdrtentsns";
    public static final String TSNKAIGOMEHRTKUMUKBN     = "tsnkaigomehrtkumukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_Tuusan primaryKey;

    public GenHT_Tuusan() {
        primaryKey = new PKHT_Tuusan();
    }

    public GenHT_Tuusan(String pMosno) {
        primaryKey = new PKHT_Tuusan(pMosno);
    }

    @Transient
    @Override
    public PKHT_Tuusan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_Tuusan> getMetaClass() {
        return QHT_Tuusan.class;
    }

    @Id
    @Column(name=GenHT_Tuusan.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private BizCurrency tsnsibous;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnsibous() {
        return tsnsibous;
    }

    public void setTsnsibous(BizCurrency pTsnsibous) {
        tsnsibous = pTsnsibous;
        tsnsibousValue = null;
        tsnsibousType  = null;
    }

    transient private BigDecimal tsnsibousValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNSIBOUS, nullable=true)
    protected BigDecimal getTsnsibousValue() {
        if (tsnsibousValue == null && tsnsibous != null) {
            if (tsnsibous.isOptional()) return null;
            return tsnsibous.absolute();
        }
        return tsnsibousValue;
    }

    protected void setTsnsibousValue(BigDecimal value) {
        tsnsibousValue = value;
        tsnsibous = Optional.fromNullable(toCurrencyType(tsnsibousType))
            .transform(bizCurrencyTransformer(getTsnsibousValue()))
            .orNull();
    }

    transient private String tsnsibousType = null;

    @Column(name=TSNSIBOUS + "$", nullable=true)
    protected String getTsnsibousType() {
        if (tsnsibousType == null && tsnsibous != null) return tsnsibous.getType().toString();
        if (tsnsibousType == null && getTsnsibousValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnsibous$' should not be NULL."));
        }
        return tsnsibousType;
    }

    protected void setTsnsibousType(String type) {
        tsnsibousType = type;
        tsnsibous = Optional.fromNullable(toCurrencyType(tsnsibousType))
            .transform(bizCurrencyTransformer(getTsnsibousValue()))
            .orNull();
    }

    private BizCurrency tsnninenmikeikas;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnninenmikeikas() {
        return tsnninenmikeikas;
    }

    public void setTsnninenmikeikas(BizCurrency pTsnninenmikeikas) {
        tsnninenmikeikas = pTsnninenmikeikas;
        tsnninenmikeikasValue = null;
        tsnninenmikeikasType  = null;
    }

    transient private BigDecimal tsnninenmikeikasValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNNINENMIKEIKAS, nullable=true)
    protected BigDecimal getTsnninenmikeikasValue() {
        if (tsnninenmikeikasValue == null && tsnninenmikeikas != null) {
            if (tsnninenmikeikas.isOptional()) return null;
            return tsnninenmikeikas.absolute();
        }
        return tsnninenmikeikasValue;
    }

    protected void setTsnninenmikeikasValue(BigDecimal value) {
        tsnninenmikeikasValue = value;
        tsnninenmikeikas = Optional.fromNullable(toCurrencyType(tsnninenmikeikasType))
            .transform(bizCurrencyTransformer(getTsnninenmikeikasValue()))
            .orNull();
    }

    transient private String tsnninenmikeikasType = null;

    @Column(name=TSNNINENMIKEIKAS + "$", nullable=true)
    protected String getTsnninenmikeikasType() {
        if (tsnninenmikeikasType == null && tsnninenmikeikas != null) return tsnninenmikeikas.getType().toString();
        if (tsnninenmikeikasType == null && getTsnninenmikeikasValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnninenmikeikas$' should not be NULL."));
        }
        return tsnninenmikeikasType;
    }

    protected void setTsnninenmikeikasType(String type) {
        tsnninenmikeikasType = type;
        tsnninenmikeikas = Optional.fromNullable(toCurrencyType(tsnninenmikeikasType))
            .transform(bizCurrencyTransformer(getTsnninenmikeikasValue()))
            .orNull();
    }

    private BizCurrency tsnninenkeikas;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnninenkeikas() {
        return tsnninenkeikas;
    }

    public void setTsnninenkeikas(BizCurrency pTsnninenkeikas) {
        tsnninenkeikas = pTsnninenkeikas;
        tsnninenkeikasValue = null;
        tsnninenkeikasType  = null;
    }

    transient private BigDecimal tsnninenkeikasValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNNINENKEIKAS, nullable=true)
    protected BigDecimal getTsnninenkeikasValue() {
        if (tsnninenkeikasValue == null && tsnninenkeikas != null) {
            if (tsnninenkeikas.isOptional()) return null;
            return tsnninenkeikas.absolute();
        }
        return tsnninenkeikasValue;
    }

    protected void setTsnninenkeikasValue(BigDecimal value) {
        tsnninenkeikasValue = value;
        tsnninenkeikas = Optional.fromNullable(toCurrencyType(tsnninenkeikasType))
            .transform(bizCurrencyTransformer(getTsnninenkeikasValue()))
            .orNull();
    }

    transient private String tsnninenkeikasType = null;

    @Column(name=TSNNINENKEIKAS + "$", nullable=true)
    protected String getTsnninenkeikasType() {
        if (tsnninenkeikasType == null && tsnninenkeikas != null) return tsnninenkeikas.getType().toString();
        if (tsnninenkeikasType == null && getTsnninenkeikasValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnninenkeikas$' should not be NULL."));
        }
        return tsnninenkeikasType;
    }

    protected void setTsnninenkeikasType(String type) {
        tsnninenkeikasType = type;
        tsnninenkeikas = Optional.fromNullable(toCurrencyType(tsnninenkeikasType))
            .transform(bizCurrencyTransformer(getTsnninenkeikasValue()))
            .orNull();
    }

    private BizCurrency tsnninenmikeikahtnkns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnninenmikeikahtnkns() {
        return tsnninenmikeikahtnkns;
    }

    public void setTsnninenmikeikahtnkns(BizCurrency pTsnninenmikeikahtnkns) {
        tsnninenmikeikahtnkns = pTsnninenmikeikahtnkns;
        tsnninenmikeikahtnknsValue = null;
        tsnninenmikeikahtnknsType  = null;
    }

    transient private BigDecimal tsnninenmikeikahtnknsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNNINENMIKEIKAHTNKNS, nullable=true)
    protected BigDecimal getTsnninenmikeikahtnknsValue() {
        if (tsnninenmikeikahtnknsValue == null && tsnninenmikeikahtnkns != null) {
            if (tsnninenmikeikahtnkns.isOptional()) return null;
            return tsnninenmikeikahtnkns.absolute();
        }
        return tsnninenmikeikahtnknsValue;
    }

    protected void setTsnninenmikeikahtnknsValue(BigDecimal value) {
        tsnninenmikeikahtnknsValue = value;
        tsnninenmikeikahtnkns = Optional.fromNullable(toCurrencyType(tsnninenmikeikahtnknsType))
            .transform(bizCurrencyTransformer(getTsnninenmikeikahtnknsValue()))
            .orNull();
    }

    transient private String tsnninenmikeikahtnknsType = null;

    @Column(name=TSNNINENMIKEIKAHTNKNS + "$", nullable=true)
    protected String getTsnninenmikeikahtnknsType() {
        if (tsnninenmikeikahtnknsType == null && tsnninenmikeikahtnkns != null) return tsnninenmikeikahtnkns.getType().toString();
        if (tsnninenmikeikahtnknsType == null && getTsnninenmikeikahtnknsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnninenmikeikahtnkns$' should not be NULL."));
        }
        return tsnninenmikeikahtnknsType;
    }

    protected void setTsnninenmikeikahtnknsType(String type) {
        tsnninenmikeikahtnknsType = type;
        tsnninenmikeikahtnkns = Optional.fromNullable(toCurrencyType(tsnninenmikeikahtnknsType))
            .transform(bizCurrencyTransformer(getTsnninenmikeikahtnknsValue()))
            .orNull();
    }

    private BizCurrency tsnninenkeikadfp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnninenkeikadfp() {
        return tsnninenkeikadfp;
    }

    public void setTsnninenkeikadfp(BizCurrency pTsnninenkeikadfp) {
        tsnninenkeikadfp = pTsnninenkeikadfp;
        tsnninenkeikadfpValue = null;
        tsnninenkeikadfpType  = null;
    }

    transient private BigDecimal tsnninenkeikadfpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNNINENKEIKADFP, nullable=true)
    protected BigDecimal getTsnninenkeikadfpValue() {
        if (tsnninenkeikadfpValue == null && tsnninenkeikadfp != null) {
            if (tsnninenkeikadfp.isOptional()) return null;
            return tsnninenkeikadfp.absolute();
        }
        return tsnninenkeikadfpValue;
    }

    protected void setTsnninenkeikadfpValue(BigDecimal value) {
        tsnninenkeikadfpValue = value;
        tsnninenkeikadfp = Optional.fromNullable(toCurrencyType(tsnninenkeikadfpType))
            .transform(bizCurrencyTransformer(getTsnninenkeikadfpValue()))
            .orNull();
    }

    transient private String tsnninenkeikadfpType = null;

    @Column(name=TSNNINENKEIKADFP + "$", nullable=true)
    protected String getTsnninenkeikadfpType() {
        if (tsnninenkeikadfpType == null && tsnninenkeikadfp != null) return tsnninenkeikadfp.getType().toString();
        if (tsnninenkeikadfpType == null && getTsnninenkeikadfpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnninenkeikadfp$' should not be NULL."));
        }
        return tsnninenkeikadfpType;
    }

    protected void setTsnninenkeikadfpType(String type) {
        tsnninenkeikadfpType = type;
        tsnninenkeikadfp = Optional.fromNullable(toCurrencyType(tsnninenkeikadfpType))
            .transform(bizCurrencyTransformer(getTsnninenkeikadfpValue()))
            .orNull();
    }

    private BizCurrency tsnketsibous;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnketsibous() {
        return tsnketsibous;
    }

    public void setTsnketsibous(BizCurrency pTsnketsibous) {
        tsnketsibous = pTsnketsibous;
        tsnketsibousValue = null;
        tsnketsibousType  = null;
    }

    transient private BigDecimal tsnketsibousValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNKETSIBOUS, nullable=true)
    protected BigDecimal getTsnketsibousValue() {
        if (tsnketsibousValue == null && tsnketsibous != null) {
            if (tsnketsibous.isOptional()) return null;
            return tsnketsibous.absolute();
        }
        return tsnketsibousValue;
    }

    protected void setTsnketsibousValue(BigDecimal value) {
        tsnketsibousValue = value;
        tsnketsibous = Optional.fromNullable(toCurrencyType(tsnketsibousType))
            .transform(bizCurrencyTransformer(getTsnketsibousValue()))
            .orNull();
    }

    transient private String tsnketsibousType = null;

    @Column(name=TSNKETSIBOUS + "$", nullable=true)
    protected String getTsnketsibousType() {
        if (tsnketsibousType == null && tsnketsibous != null) return tsnketsibous.getType().toString();
        if (tsnketsibousType == null && getTsnketsibousValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnketsibous$' should not be NULL."));
        }
        return tsnketsibousType;
    }

    protected void setTsnketsibousType(String type) {
        tsnketsibousType = type;
        tsnketsibous = Optional.fromNullable(toCurrencyType(tsnketsibousType))
            .transform(bizCurrencyTransformer(getTsnketsibousValue()))
            .orNull();
    }

    private BizCurrency tsnketsibous2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnketsibous2() {
        return tsnketsibous2;
    }

    public void setTsnketsibous2(BizCurrency pTsnketsibous2) {
        tsnketsibous2 = pTsnketsibous2;
        tsnketsibous2Value = null;
        tsnketsibous2Type  = null;
    }

    transient private BigDecimal tsnketsibous2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNKETSIBOUS2, nullable=true)
    protected BigDecimal getTsnketsibous2Value() {
        if (tsnketsibous2Value == null && tsnketsibous2 != null) {
            if (tsnketsibous2.isOptional()) return null;
            return tsnketsibous2.absolute();
        }
        return tsnketsibous2Value;
    }

    protected void setTsnketsibous2Value(BigDecimal value) {
        tsnketsibous2Value = value;
        tsnketsibous2 = Optional.fromNullable(toCurrencyType(tsnketsibous2Type))
            .transform(bizCurrencyTransformer(getTsnketsibous2Value()))
            .orNull();
    }

    transient private String tsnketsibous2Type = null;

    @Column(name=TSNKETSIBOUS2 + "$", nullable=true)
    protected String getTsnketsibous2Type() {
        if (tsnketsibous2Type == null && tsnketsibous2 != null) return tsnketsibous2.getType().toString();
        if (tsnketsibous2Type == null && getTsnketsibous2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnketsibous2$' should not be NULL."));
        }
        return tsnketsibous2Type;
    }

    protected void setTsnketsibous2Type(String type) {
        tsnketsibous2Type = type;
        tsnketsibous2 = Optional.fromNullable(toCurrencyType(tsnketsibous2Type))
            .transform(bizCurrencyTransformer(getTsnketsibous2Value()))
            .orNull();
    }

    private BizCurrency tsnsoukktjituhsgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnsoukktjituhsgk() {
        return tsnsoukktjituhsgk;
    }

    public void setTsnsoukktjituhsgk(BizCurrency pTsnsoukktjituhsgk) {
        tsnsoukktjituhsgk = pTsnsoukktjituhsgk;
        tsnsoukktjituhsgkValue = null;
        tsnsoukktjituhsgkType  = null;
    }

    transient private BigDecimal tsnsoukktjituhsgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNSOUKKTJITUHSGK, nullable=true)
    protected BigDecimal getTsnsoukktjituhsgkValue() {
        if (tsnsoukktjituhsgkValue == null && tsnsoukktjituhsgk != null) {
            if (tsnsoukktjituhsgk.isOptional()) return null;
            return tsnsoukktjituhsgk.absolute();
        }
        return tsnsoukktjituhsgkValue;
    }

    protected void setTsnsoukktjituhsgkValue(BigDecimal value) {
        tsnsoukktjituhsgkValue = value;
        tsnsoukktjituhsgk = Optional.fromNullable(toCurrencyType(tsnsoukktjituhsgkType))
            .transform(bizCurrencyTransformer(getTsnsoukktjituhsgkValue()))
            .orNull();
    }

    transient private String tsnsoukktjituhsgkType = null;

    @Column(name=TSNSOUKKTJITUHSGK + "$", nullable=true)
    protected String getTsnsoukktjituhsgkType() {
        if (tsnsoukktjituhsgkType == null && tsnsoukktjituhsgk != null) return tsnsoukktjituhsgk.getType().toString();
        if (tsnsoukktjituhsgkType == null && getTsnsoukktjituhsgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnsoukktjituhsgk$' should not be NULL."));
        }
        return tsnsoukktjituhsgkType;
    }

    protected void setTsnsoukktjituhsgkType(String type) {
        tsnsoukktjituhsgkType = type;
        tsnsoukktjituhsgk = Optional.fromNullable(toCurrencyType(tsnsoukktjituhsgkType))
            .transform(bizCurrencyTransformer(getTsnsoukktjituhsgkValue()))
            .orNull();
    }

    private BizCurrency tsnkktjituhsgk1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnkktjituhsgk1() {
        return tsnkktjituhsgk1;
    }

    public void setTsnkktjituhsgk1(BizCurrency pTsnkktjituhsgk1) {
        tsnkktjituhsgk1 = pTsnkktjituhsgk1;
        tsnkktjituhsgk1Value = null;
        tsnkktjituhsgk1Type  = null;
    }

    transient private BigDecimal tsnkktjituhsgk1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNKKTJITUHSGK1, nullable=true)
    protected BigDecimal getTsnkktjituhsgk1Value() {
        if (tsnkktjituhsgk1Value == null && tsnkktjituhsgk1 != null) {
            if (tsnkktjituhsgk1.isOptional()) return null;
            return tsnkktjituhsgk1.absolute();
        }
        return tsnkktjituhsgk1Value;
    }

    protected void setTsnkktjituhsgk1Value(BigDecimal value) {
        tsnkktjituhsgk1Value = value;
        tsnkktjituhsgk1 = Optional.fromNullable(toCurrencyType(tsnkktjituhsgk1Type))
            .transform(bizCurrencyTransformer(getTsnkktjituhsgk1Value()))
            .orNull();
    }

    transient private String tsnkktjituhsgk1Type = null;

    @Column(name=TSNKKTJITUHSGK1 + "$", nullable=true)
    protected String getTsnkktjituhsgk1Type() {
        if (tsnkktjituhsgk1Type == null && tsnkktjituhsgk1 != null) return tsnkktjituhsgk1.getType().toString();
        if (tsnkktjituhsgk1Type == null && getTsnkktjituhsgk1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnkktjituhsgk1$' should not be NULL."));
        }
        return tsnkktjituhsgk1Type;
    }

    protected void setTsnkktjituhsgk1Type(String type) {
        tsnkktjituhsgk1Type = type;
        tsnkktjituhsgk1 = Optional.fromNullable(toCurrencyType(tsnkktjituhsgk1Type))
            .transform(bizCurrencyTransformer(getTsnkktjituhsgk1Value()))
            .orNull();
    }

    private BizCurrency tsnkktjituhsgk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnkktjituhsgk2() {
        return tsnkktjituhsgk2;
    }

    public void setTsnkktjituhsgk2(BizCurrency pTsnkktjituhsgk2) {
        tsnkktjituhsgk2 = pTsnkktjituhsgk2;
        tsnkktjituhsgk2Value = null;
        tsnkktjituhsgk2Type  = null;
    }

    transient private BigDecimal tsnkktjituhsgk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNKKTJITUHSGK2, nullable=true)
    protected BigDecimal getTsnkktjituhsgk2Value() {
        if (tsnkktjituhsgk2Value == null && tsnkktjituhsgk2 != null) {
            if (tsnkktjituhsgk2.isOptional()) return null;
            return tsnkktjituhsgk2.absolute();
        }
        return tsnkktjituhsgk2Value;
    }

    protected void setTsnkktjituhsgk2Value(BigDecimal value) {
        tsnkktjituhsgk2Value = value;
        tsnkktjituhsgk2 = Optional.fromNullable(toCurrencyType(tsnkktjituhsgk2Type))
            .transform(bizCurrencyTransformer(getTsnkktjituhsgk2Value()))
            .orNull();
    }

    transient private String tsnkktjituhsgk2Type = null;

    @Column(name=TSNKKTJITUHSGK2 + "$", nullable=true)
    protected String getTsnkktjituhsgk2Type() {
        if (tsnkktjituhsgk2Type == null && tsnkktjituhsgk2 != null) return tsnkktjituhsgk2.getType().toString();
        if (tsnkktjituhsgk2Type == null && getTsnkktjituhsgk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnkktjituhsgk2$' should not be NULL."));
        }
        return tsnkktjituhsgk2Type;
    }

    protected void setTsnkktjituhsgk2Type(String type) {
        tsnkktjituhsgk2Type = type;
        tsnkktjituhsgk2 = Optional.fromNullable(toCurrencyType(tsnkktjituhsgk2Type))
            .transform(bizCurrencyTransformer(getTsnkktjituhsgk2Value()))
            .orNull();
    }

    private BizCurrency tsnkktitijibrsysnjs;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnkktitijibrsysnjs() {
        return tsnkktitijibrsysnjs;
    }

    public void setTsnkktitijibrsysnjs(BizCurrency pTsnkktitijibrsysnjs) {
        tsnkktitijibrsysnjs = pTsnkktitijibrsysnjs;
        tsnkktitijibrsysnjsValue = null;
        tsnkktitijibrsysnjsType  = null;
    }

    transient private BigDecimal tsnkktitijibrsysnjsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNKKTITIJIBRSYSNJS, nullable=true)
    protected BigDecimal getTsnkktitijibrsysnjsValue() {
        if (tsnkktitijibrsysnjsValue == null && tsnkktitijibrsysnjs != null) {
            if (tsnkktitijibrsysnjs.isOptional()) return null;
            return tsnkktitijibrsysnjs.absolute();
        }
        return tsnkktitijibrsysnjsValue;
    }

    protected void setTsnkktitijibrsysnjsValue(BigDecimal value) {
        tsnkktitijibrsysnjsValue = value;
        tsnkktitijibrsysnjs = Optional.fromNullable(toCurrencyType(tsnkktitijibrsysnjsType))
            .transform(bizCurrencyTransformer(getTsnkktitijibrsysnjsValue()))
            .orNull();
    }

    transient private String tsnkktitijibrsysnjsType = null;

    @Column(name=TSNKKTITIJIBRSYSNJS + "$", nullable=true)
    protected String getTsnkktitijibrsysnjsType() {
        if (tsnkktitijibrsysnjsType == null && tsnkktitijibrsysnjs != null) return tsnkktitijibrsysnjs.getType().toString();
        if (tsnkktitijibrsysnjsType == null && getTsnkktitijibrsysnjsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnkktitijibrsysnjs$' should not be NULL."));
        }
        return tsnkktitijibrsysnjsType;
    }

    protected void setTsnkktitijibrsysnjsType(String type) {
        tsnkktitijibrsysnjsType = type;
        tsnkktitijibrsysnjs = Optional.fromNullable(toCurrencyType(tsnkktitijibrsysnjsType))
            .transform(bizCurrencyTransformer(getTsnkktitijibrsysnjsValue()))
            .orNull();
    }

    private BizCurrency tsnnkgns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnnkgns() {
        return tsnnkgns;
    }

    public void setTsnnkgns(BizCurrency pTsnnkgns) {
        tsnnkgns = pTsnnkgns;
        tsnnkgnsValue = null;
        tsnnkgnsType  = null;
    }

    transient private BigDecimal tsnnkgnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNNKGNS, nullable=true)
    protected BigDecimal getTsnnkgnsValue() {
        if (tsnnkgnsValue == null && tsnnkgns != null) {
            if (tsnnkgns.isOptional()) return null;
            return tsnnkgns.absolute();
        }
        return tsnnkgnsValue;
    }

    protected void setTsnnkgnsValue(BigDecimal value) {
        tsnnkgnsValue = value;
        tsnnkgns = Optional.fromNullable(toCurrencyType(tsnnkgnsType))
            .transform(bizCurrencyTransformer(getTsnnkgnsValue()))
            .orNull();
    }

    transient private String tsnnkgnsType = null;

    @Column(name=TSNNKGNS + "$", nullable=true)
    protected String getTsnnkgnsType() {
        if (tsnnkgnsType == null && tsnnkgns != null) return tsnnkgns.getType().toString();
        if (tsnnkgnsType == null && getTsnnkgnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnnkgns$' should not be NULL."));
        }
        return tsnnkgnsType;
    }

    protected void setTsnnkgnsType(String type) {
        tsnnkgnsType = type;
        tsnnkgns = Optional.fromNullable(toCurrencyType(tsnnkgnsType))
            .transform(bizCurrencyTransformer(getTsnnkgnsValue()))
            .orNull();
    }

    private BizCurrency tsnmsnynenbtsousbus;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnmsnynenbtsousbus() {
        return tsnmsnynenbtsousbus;
    }

    public void setTsnmsnynenbtsousbus(BizCurrency pTsnmsnynenbtsousbus) {
        tsnmsnynenbtsousbus = pTsnmsnynenbtsousbus;
        tsnmsnynenbtsousbusValue = null;
        tsnmsnynenbtsousbusType  = null;
    }

    transient private BigDecimal tsnmsnynenbtsousbusValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNMSNYNENBTSOUSBUS, nullable=true)
    protected BigDecimal getTsnmsnynenbtsousbusValue() {
        if (tsnmsnynenbtsousbusValue == null && tsnmsnynenbtsousbus != null) {
            if (tsnmsnynenbtsousbus.isOptional()) return null;
            return tsnmsnynenbtsousbus.absolute();
        }
        return tsnmsnynenbtsousbusValue;
    }

    protected void setTsnmsnynenbtsousbusValue(BigDecimal value) {
        tsnmsnynenbtsousbusValue = value;
        tsnmsnynenbtsousbus = Optional.fromNullable(toCurrencyType(tsnmsnynenbtsousbusType))
            .transform(bizCurrencyTransformer(getTsnmsnynenbtsousbusValue()))
            .orNull();
    }

    transient private String tsnmsnynenbtsousbusType = null;

    @Column(name=TSNMSNYNENBTSOUSBUS + "$", nullable=true)
    protected String getTsnmsnynenbtsousbusType() {
        if (tsnmsnynenbtsousbusType == null && tsnmsnynenbtsousbus != null) return tsnmsnynenbtsousbus.getType().toString();
        if (tsnmsnynenbtsousbusType == null && getTsnmsnynenbtsousbusValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnmsnynenbtsousbus$' should not be NULL."));
        }
        return tsnmsnynenbtsousbusType;
    }

    protected void setTsnmsnynenbtsousbusType(String type) {
        tsnmsnynenbtsousbusType = type;
        tsnmsnynenbtsousbus = Optional.fromNullable(toCurrencyType(tsnmsnynenbtsousbusType))
            .transform(bizCurrencyTransformer(getTsnmsnynenbtsousbusValue()))
            .orNull();
    }

    private BizCurrency tsnnenbtitijibrssbs;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnnenbtitijibrssbs() {
        return tsnnenbtitijibrssbs;
    }

    public void setTsnnenbtitijibrssbs(BizCurrency pTsnnenbtitijibrssbs) {
        tsnnenbtitijibrssbs = pTsnnenbtitijibrssbs;
        tsnnenbtitijibrssbsValue = null;
        tsnnenbtitijibrssbsType  = null;
    }

    transient private BigDecimal tsnnenbtitijibrssbsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNNENBTITIJIBRSSBS, nullable=true)
    protected BigDecimal getTsnnenbtitijibrssbsValue() {
        if (tsnnenbtitijibrssbsValue == null && tsnnenbtitijibrssbs != null) {
            if (tsnnenbtitijibrssbs.isOptional()) return null;
            return tsnnenbtitijibrssbs.absolute();
        }
        return tsnnenbtitijibrssbsValue;
    }

    protected void setTsnnenbtitijibrssbsValue(BigDecimal value) {
        tsnnenbtitijibrssbsValue = value;
        tsnnenbtitijibrssbs = Optional.fromNullable(toCurrencyType(tsnnenbtitijibrssbsType))
            .transform(bizCurrencyTransformer(getTsnnenbtitijibrssbsValue()))
            .orNull();
    }

    transient private String tsnnenbtitijibrssbsType = null;

    @Column(name=TSNNENBTITIJIBRSSBS + "$", nullable=true)
    protected String getTsnnenbtitijibrssbsType() {
        if (tsnnenbtitijibrssbsType == null && tsnnenbtitijibrssbs != null) return tsnnenbtitijibrssbs.getType().toString();
        if (tsnnenbtitijibrssbsType == null && getTsnnenbtitijibrssbsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnnenbtitijibrssbs$' should not be NULL."));
        }
        return tsnnenbtitijibrssbsType;
    }

    protected void setTsnnenbtitijibrssbsType(String type) {
        tsnnenbtitijibrssbsType = type;
        tsnnenbtitijibrssbs = Optional.fromNullable(toCurrencyType(tsnnenbtitijibrssbsType))
            .transform(bizCurrencyTransformer(getTsnnenbtitijibrssbsValue()))
            .orNull();
    }

    private BizCurrency tsnitijibrsysnp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnitijibrsysnp() {
        return tsnitijibrsysnp;
    }

    public void setTsnitijibrsysnp(BizCurrency pTsnitijibrsysnp) {
        tsnitijibrsysnp = pTsnitijibrsysnp;
        tsnitijibrsysnpValue = null;
        tsnitijibrsysnpType  = null;
    }

    transient private BigDecimal tsnitijibrsysnpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNITIJIBRSYSNP, nullable=true)
    protected BigDecimal getTsnitijibrsysnpValue() {
        if (tsnitijibrsysnpValue == null && tsnitijibrsysnp != null) {
            if (tsnitijibrsysnp.isOptional()) return null;
            return tsnitijibrsysnp.absolute();
        }
        return tsnitijibrsysnpValue;
    }

    protected void setTsnitijibrsysnpValue(BigDecimal value) {
        tsnitijibrsysnpValue = value;
        tsnitijibrsysnp = Optional.fromNullable(toCurrencyType(tsnitijibrsysnpType))
            .transform(bizCurrencyTransformer(getTsnitijibrsysnpValue()))
            .orNull();
    }

    transient private String tsnitijibrsysnpType = null;

    @Column(name=TSNITIJIBRSYSNP + "$", nullable=true)
    protected String getTsnitijibrsysnpType() {
        if (tsnitijibrsysnpType == null && tsnitijibrsysnp != null) return tsnitijibrsysnp.getType().toString();
        if (tsnitijibrsysnpType == null && getTsnitijibrsysnpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnitijibrsysnp$' should not be NULL."));
        }
        return tsnitijibrsysnpType;
    }

    protected void setTsnitijibrsysnpType(String type) {
        tsnitijibrsysnpType = type;
        tsnitijibrsysnp = Optional.fromNullable(toCurrencyType(tsnitijibrsysnpType))
            .transform(bizCurrencyTransformer(getTsnitijibrsysnpValue()))
            .orNull();
    }

    private BizCurrency tsnsntktuukahijynsysns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnsntktuukahijynsysns() {
        return tsnsntktuukahijynsysns;
    }

    public void setTsnsntktuukahijynsysns(BizCurrency pTsnsntktuukahijynsysns) {
        tsnsntktuukahijynsysns = pTsnsntktuukahijynsysns;
        tsnsntktuukahijynsysnsValue = null;
        tsnsntktuukahijynsysnsType  = null;
    }

    transient private BigDecimal tsnsntktuukahijynsysnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNSNTKTUUKAHIJYNSYSNS, nullable=true)
    protected BigDecimal getTsnsntktuukahijynsysnsValue() {
        if (tsnsntktuukahijynsysnsValue == null && tsnsntktuukahijynsysns != null) {
            if (tsnsntktuukahijynsysns.isOptional()) return null;
            return tsnsntktuukahijynsysns.absolute();
        }
        return tsnsntktuukahijynsysnsValue;
    }

    protected void setTsnsntktuukahijynsysnsValue(BigDecimal value) {
        tsnsntktuukahijynsysnsValue = value;
        tsnsntktuukahijynsysns = Optional.fromNullable(toCurrencyType(tsnsntktuukahijynsysnsType))
            .transform(bizCurrencyTransformer(getTsnsntktuukahijynsysnsValue()))
            .orNull();
    }

    transient private String tsnsntktuukahijynsysnsType = null;

    @Column(name=TSNSNTKTUUKAHIJYNSYSNS + "$", nullable=true)
    protected String getTsnsntktuukahijynsysnsType() {
        if (tsnsntktuukahijynsysnsType == null && tsnsntktuukahijynsysns != null) return tsnsntktuukahijynsysns.getType().toString();
        if (tsnsntktuukahijynsysnsType == null && getTsnsntktuukahijynsysnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnsntktuukahijynsysns$' should not be NULL."));
        }
        return tsnsntktuukahijynsysnsType;
    }

    protected void setTsnsntktuukahijynsysnsType(String type) {
        tsnsntktuukahijynsysnsType = type;
        tsnsntktuukahijynsysns = Optional.fromNullable(toCurrencyType(tsnsntktuukahijynsysnsType))
            .transform(bizCurrencyTransformer(getTsnsntktuukahijynsysnsValue()))
            .orNull();
    }

    private BizCurrency kykdrtentsns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKykdrtentsns() {
        return kykdrtentsns;
    }

    public void setKykdrtentsns(BizCurrency pKykdrtentsns) {
        kykdrtentsns = pKykdrtentsns;
        kykdrtentsnsValue = null;
        kykdrtentsnsType  = null;
    }

    transient private BigDecimal kykdrtentsnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKDRTENTSNS, nullable=true)
    protected BigDecimal getKykdrtentsnsValue() {
        if (kykdrtentsnsValue == null && kykdrtentsns != null) {
            if (kykdrtentsns.isOptional()) return null;
            return kykdrtentsns.absolute();
        }
        return kykdrtentsnsValue;
    }

    protected void setKykdrtentsnsValue(BigDecimal value) {
        kykdrtentsnsValue = value;
        kykdrtentsns = Optional.fromNullable(toCurrencyType(kykdrtentsnsType))
            .transform(bizCurrencyTransformer(getKykdrtentsnsValue()))
            .orNull();
    }

    transient private String kykdrtentsnsType = null;

    @Column(name=KYKDRTENTSNS + "$", nullable=true)
    protected String getKykdrtentsnsType() {
        if (kykdrtentsnsType == null && kykdrtentsns != null) return kykdrtentsns.getType().toString();
        if (kykdrtentsnsType == null && getKykdrtentsnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kykdrtentsns$' should not be NULL."));
        }
        return kykdrtentsnsType;
    }

    protected void setKykdrtentsnsType(String type) {
        kykdrtentsnsType = type;
        kykdrtentsns = Optional.fromNullable(toCurrencyType(kykdrtentsnsType))
            .transform(bizCurrencyTransformer(getKykdrtentsnsValue()))
            .orNull();
    }

    private C_UmuKbn tsnkaigomehrtkumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_Tuusan.TSNKAIGOMEHRTKUMUKBN)
    public C_UmuKbn getTsnkaigomehrtkumukbn() {
        return tsnkaigomehrtkumukbn;
    }

    public void setTsnkaigomehrtkumukbn(C_UmuKbn pTsnkaigomehrtkumukbn) {
        tsnkaigomehrtkumukbn = pTsnkaigomehrtkumukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_Tuusan.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_Tuusan.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}