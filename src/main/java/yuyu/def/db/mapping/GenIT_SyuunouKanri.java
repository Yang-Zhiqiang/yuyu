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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.db.entity.IT_SyuunouKanri;
import yuyu.def.db.id.PKIT_SyuunouKanri;
import yuyu.def.db.meta.GenQIT_SyuunouKanri;
import yuyu.def.db.meta.QIT_SyuunouKanri;
import yuyu.def.db.type.UserType_C_Syuudaikocd;

/**
 * 収納管理テーブル テーブルのマッピング情報クラスで、 {@link IT_SyuunouKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SyuunouKanri}</td><td colspan="3">収納管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">{@link PKIT_SyuunouKanri ○}</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">{@link PKIT_SyuunouKanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnnaikensuu annaikensuu}</td><td>案内件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAnnaigk annaigk}</td><td>案内金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHurizumikensuu hurizumikensuu}</td><td>振替済件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHurizumigk hurizumigk}</td><td>振替済金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHurihunokensuu hurihunokensuu}</td><td>振替不能件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHurihunogk hurihunogk}</td><td>振替不能金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyuunousyoriymd syuunousyoriymd}</td><td>収納処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SyuunouKanri
 * @see     PKIT_SyuunouKanri
 * @see     QIT_SyuunouKanri
 * @see     GenQIT_SyuunouKanri
 */
@MappedSuperclass
@Table(name=GenIT_SyuunouKanri.TABLE_NAME)
@IdClass(value=PKIT_SyuunouKanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class)
})
public abstract class GenIT_SyuunouKanri extends AbstractExDBEntity<IT_SyuunouKanri, PKIT_SyuunouKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SyuunouKanri";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String BANKCD                   = "bankcd";
    public static final String ANNAIKENSUU              = "annaikensuu";
    public static final String ANNAIGK                  = "annaigk";
    public static final String HURIZUMIKENSUU           = "hurizumikensuu";
    public static final String HURIZUMIGK               = "hurizumigk";
    public static final String HURIHUNOKENSUU           = "hurihunokensuu";
    public static final String HURIHUNOGK               = "hurihunogk";
    public static final String SYUUNOUSYORIYMD          = "syuunousyoriymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SyuunouKanri primaryKey;

    public GenIT_SyuunouKanri() {
        primaryKey = new PKIT_SyuunouKanri();
    }

    public GenIT_SyuunouKanri(C_Syuudaikocd pSyuudaikocd, BizDate pHurikaeymd) {
        primaryKey = new PKIT_SyuunouKanri(pSyuudaikocd, pHurikaeymd);
    }

    @Transient
    @Override
    public PKIT_SyuunouKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SyuunouKanri> getMetaClass() {
        return QIT_SyuunouKanri.class;
    }

    @Id
    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_SyuunouKanri.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return getPrimaryKey().getSyuudaikocd();
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        getPrimaryKey().setSyuudaikocd(pSyuudaikocd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_SyuunouKanri.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return getPrimaryKey().getHurikaeymd();
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        getPrimaryKey().setHurikaeymd(pHurikaeymd);
    }

    private String bankcd;

    @Column(name=GenIT_SyuunouKanri.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private Integer annaikensuu;

    @Column(name=GenIT_SyuunouKanri.ANNAIKENSUU)
    public Integer getAnnaikensuu() {
        return annaikensuu;
    }

    public void setAnnaikensuu(Integer pAnnaikensuu) {
        annaikensuu = pAnnaikensuu;
    }

    private BizCurrency annaigk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getAnnaigk() {
        return annaigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAnnaigk(BizCurrency pAnnaigk) {
        annaigk = pAnnaigk;
        annaigkValue = null;
        annaigkType  = null;
    }

    transient private BigDecimal annaigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ANNAIGK, nullable=true)
    protected BigDecimal getAnnaigkValue() {
        if (annaigkValue == null && annaigk != null) {
            if (annaigk.isOptional()) return null;
            return annaigk.absolute();
        }
        return annaigkValue;
    }

    protected void setAnnaigkValue(BigDecimal value) {
        annaigkValue = value;
        annaigk = Optional.fromNullable(toCurrencyType(annaigkType))
            .transform(bizCurrencyTransformer(getAnnaigkValue()))
            .orNull();
    }

    transient private String annaigkType = null;

    @Column(name=ANNAIGK + "$", nullable=true)
    protected String getAnnaigkType() {
        if (annaigkType == null && annaigk != null) return annaigk.getType().toString();
        if (annaigkType == null && getAnnaigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'annaigk$' should not be NULL."));
        }
        return annaigkType;
    }

    protected void setAnnaigkType(String type) {
        annaigkType = type;
        annaigk = Optional.fromNullable(toCurrencyType(annaigkType))
            .transform(bizCurrencyTransformer(getAnnaigkValue()))
            .orNull();
    }

    private Integer hurizumikensuu;

    @Column(name=GenIT_SyuunouKanri.HURIZUMIKENSUU)
    public Integer getHurizumikensuu() {
        return hurizumikensuu;
    }

    public void setHurizumikensuu(Integer pHurizumikensuu) {
        hurizumikensuu = pHurizumikensuu;
    }

    private BizCurrency hurizumigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHurizumigk() {
        return hurizumigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHurizumigk(BizCurrency pHurizumigk) {
        hurizumigk = pHurizumigk;
        hurizumigkValue = null;
        hurizumigkType  = null;
    }

    transient private BigDecimal hurizumigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HURIZUMIGK, nullable=true)
    protected BigDecimal getHurizumigkValue() {
        if (hurizumigkValue == null && hurizumigk != null) {
            if (hurizumigk.isOptional()) return null;
            return hurizumigk.absolute();
        }
        return hurizumigkValue;
    }

    protected void setHurizumigkValue(BigDecimal value) {
        hurizumigkValue = value;
        hurizumigk = Optional.fromNullable(toCurrencyType(hurizumigkType))
            .transform(bizCurrencyTransformer(getHurizumigkValue()))
            .orNull();
    }

    transient private String hurizumigkType = null;

    @Column(name=HURIZUMIGK + "$", nullable=true)
    protected String getHurizumigkType() {
        if (hurizumigkType == null && hurizumigk != null) return hurizumigk.getType().toString();
        if (hurizumigkType == null && getHurizumigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hurizumigk$' should not be NULL."));
        }
        return hurizumigkType;
    }

    protected void setHurizumigkType(String type) {
        hurizumigkType = type;
        hurizumigk = Optional.fromNullable(toCurrencyType(hurizumigkType))
            .transform(bizCurrencyTransformer(getHurizumigkValue()))
            .orNull();
    }

    private Integer hurihunokensuu;

    @Column(name=GenIT_SyuunouKanri.HURIHUNOKENSUU)
    public Integer getHurihunokensuu() {
        return hurihunokensuu;
    }

    public void setHurihunokensuu(Integer pHurihunokensuu) {
        hurihunokensuu = pHurihunokensuu;
    }

    private BizCurrency hurihunogk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHurihunogk() {
        return hurihunogk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHurihunogk(BizCurrency pHurihunogk) {
        hurihunogk = pHurihunogk;
        hurihunogkValue = null;
        hurihunogkType  = null;
    }

    transient private BigDecimal hurihunogkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HURIHUNOGK, nullable=true)
    protected BigDecimal getHurihunogkValue() {
        if (hurihunogkValue == null && hurihunogk != null) {
            if (hurihunogk.isOptional()) return null;
            return hurihunogk.absolute();
        }
        return hurihunogkValue;
    }

    protected void setHurihunogkValue(BigDecimal value) {
        hurihunogkValue = value;
        hurihunogk = Optional.fromNullable(toCurrencyType(hurihunogkType))
            .transform(bizCurrencyTransformer(getHurihunogkValue()))
            .orNull();
    }

    transient private String hurihunogkType = null;

    @Column(name=HURIHUNOGK + "$", nullable=true)
    protected String getHurihunogkType() {
        if (hurihunogkType == null && hurihunogk != null) return hurihunogk.getType().toString();
        if (hurihunogkType == null && getHurihunogkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hurihunogk$' should not be NULL."));
        }
        return hurihunogkType;
    }

    protected void setHurihunogkType(String type) {
        hurihunogkType = type;
        hurihunogk = Optional.fromNullable(toCurrencyType(hurihunogkType))
            .transform(bizCurrencyTransformer(getHurihunogkValue()))
            .orNull();
    }

    private BizDate syuunousyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SyuunouKanri.SYUUNOUSYORIYMD)
    public BizDate getSyuunousyoriymd() {
        return syuunousyoriymd;
    }

    public void setSyuunousyoriymd(BizDate pSyuunousyoriymd) {
        syuunousyoriymd = pSyuunousyoriymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SyuunouKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SyuunouKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SyuunouKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}