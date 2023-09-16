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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_SyuukeilvKbn;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.classification.C_UriagetorihikiKbn;
import yuyu.def.db.entity.IT_KhUriageKekkaData;
import yuyu.def.db.id.PKIT_KhUriageKekkaData;
import yuyu.def.db.meta.GenQIT_KhUriageKekkaData;
import yuyu.def.db.meta.QIT_KhUriageKekkaData;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_SyuukeilvKbn;
import yuyu.def.db.type.UserType_C_UriagekekkaKbn;
import yuyu.def.db.type.UserType_C_UriagetorihikiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上結果データテーブル テーブルのマッピング情報クラスで、 {@link IT_KhUriageKekkaData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhUriageKekkaData}</td><td colspan="3">売上結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKIT_KhUriageKekkaData ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getUriagekekkadatarenno uriagekekkadatarenno}</td><td>売上結果データ連番</td><td align="center">{@link PKIT_KhUriageKekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyuukeilvkbn syuukeilvkbn}</td><td>集計レベル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuukeilvKbn}</td></tr>
 *  <tr><td>{@link #getUriagetorihikikbn uriagetorihikikbn}</td><td>売上取引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UriagetorihikiKbn}</td></tr>
 *  <tr><td>{@link #getUriageymd uriageymd}</td><td>売上日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUriagegk uriagegk}</td><td>売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeisoukin zeisoukin}</td><td>税・送金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUriagegoukei uriagegoukei}</td><td>売上合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyouninno syouninno}</td><td>承認番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardykkigen creditcardykkigen}</td><td>クレジットカード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagekekkakbn uriagekekkakbn}</td><td>売上結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UriagekekkaKbn}</td></tr>
 *  <tr><td>{@link #getCreditbrerrorcd creditbrerrorcd}</td><td>クレジット払エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Creditbrerrorcd}</td></tr>
 *  <tr><td>{@link #getAuthorikaisuu authorikaisuu}</td><td>オーソリ回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhUriageKekkaData
 * @see     PKIT_KhUriageKekkaData
 * @see     QIT_KhUriageKekkaData
 * @see     GenQIT_KhUriageKekkaData
 */
@MappedSuperclass
@Table(name=GenIT_KhUriageKekkaData.TABLE_NAME)
@IdClass(value=PKIT_KhUriageKekkaData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_Creditbrerrorcd", typeClass=UserType_C_Creditbrerrorcd.class),
    @TypeDef(name="UserType_C_SyuukeilvKbn", typeClass=UserType_C_SyuukeilvKbn.class),
    @TypeDef(name="UserType_C_UriagekekkaKbn", typeClass=UserType_C_UriagekekkaKbn.class),
    @TypeDef(name="UserType_C_UriagetorihikiKbn", typeClass=UserType_C_UriagetorihikiKbn.class)
})
public abstract class GenIT_KhUriageKekkaData extends AbstractExDBEntity<IT_KhUriageKekkaData, PKIT_KhUriageKekkaData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhUriageKekkaData";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String URIAGEKEKKADATARENNO     = "uriagekekkadatarenno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String SYUUKEILVKBN             = "syuukeilvkbn";
    public static final String URIAGETORIHIKIKBN        = "uriagetorihikikbn";
    public static final String URIAGEYMD                = "uriageymd";
    public static final String URIAGEGK                 = "uriagegk";
    public static final String ZEISOUKIN                = "zeisoukin";
    public static final String URIAGEGOUKEI             = "uriagegoukei";
    public static final String SYOUNINNO                = "syouninno";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITCARDYKKIGEN        = "creditcardykkigen";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String URIAGEKEKKAKBN           = "uriagekekkakbn";
    public static final String CREDITBRERRORCD          = "creditbrerrorcd";
    public static final String AUTHORIKAISUU            = "authorikaisuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhUriageKekkaData primaryKey;

    public GenIT_KhUriageKekkaData() {
        primaryKey = new PKIT_KhUriageKekkaData();
    }

    public GenIT_KhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pUriagekekkadatarenno) {
        primaryKey = new PKIT_KhUriageKekkaData(pAnsyuusyskbn, pUriagekekkadatarenno);
    }

    @Transient
    @Override
    public PKIT_KhUriageKekkaData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhUriageKekkaData> getMetaClass() {
        return QIT_KhUriageKekkaData.class;
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenIT_KhUriageKekkaData.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Column(name=GenIT_KhUriageKekkaData.URIAGEKEKKADATARENNO)
    public String getUriagekekkadatarenno() {
        return getPrimaryKey().getUriagekekkadatarenno();
    }

    public void setUriagekekkadatarenno(String pUriagekekkadatarenno) {
        getPrimaryKey().setUriagekekkadatarenno(pUriagekekkadatarenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhUriageKekkaData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syono;

    @Column(name=GenIT_KhUriageKekkaData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhUriageKekkaData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_KhUriageKekkaData.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_KhUriageKekkaData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private C_SyuukeilvKbn syuukeilvkbn;

    @Type(type="UserType_C_SyuukeilvKbn")
    @Column(name=GenIT_KhUriageKekkaData.SYUUKEILVKBN)
    public C_SyuukeilvKbn getSyuukeilvkbn() {
        return syuukeilvkbn;
    }

    public void setSyuukeilvkbn(C_SyuukeilvKbn pSyuukeilvkbn) {
        syuukeilvkbn = pSyuukeilvkbn;
    }

    private C_UriagetorihikiKbn uriagetorihikikbn;

    @Type(type="UserType_C_UriagetorihikiKbn")
    @Column(name=GenIT_KhUriageKekkaData.URIAGETORIHIKIKBN)
    public C_UriagetorihikiKbn getUriagetorihikikbn() {
        return uriagetorihikikbn;
    }

    public void setUriagetorihikikbn(C_UriagetorihikiKbn pUriagetorihikikbn) {
        uriagetorihikikbn = pUriagetorihikikbn;
    }

    private BizDate uriageymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhUriageKekkaData.URIAGEYMD)
    public BizDate getUriageymd() {
        return uriageymd;
    }

    public void setUriageymd(BizDate pUriageymd) {
        uriageymd = pUriageymd;
    }

    private BizCurrency uriagegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUriagegk() {
        return uriagegk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUriagegk(BizCurrency pUriagegk) {
        uriagegk = pUriagegk;
        uriagegkValue = null;
        uriagegkType  = null;
    }

    transient private BigDecimal uriagegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=URIAGEGK, nullable=true)
    protected BigDecimal getUriagegkValue() {
        if (uriagegkValue == null && uriagegk != null) {
            if (uriagegk.isOptional()) return null;
            return uriagegk.absolute();
        }
        return uriagegkValue;
    }

    protected void setUriagegkValue(BigDecimal value) {
        uriagegkValue = value;
        uriagegk = Optional.fromNullable(toCurrencyType(uriagegkType))
            .transform(bizCurrencyTransformer(getUriagegkValue()))
            .orNull();
    }

    transient private String uriagegkType = null;

    @Column(name=URIAGEGK + "$", nullable=true)
    protected String getUriagegkType() {
        if (uriagegkType == null && uriagegk != null) return uriagegk.getType().toString();
        if (uriagegkType == null && getUriagegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'uriagegk$' should not be NULL."));
        }
        return uriagegkType;
    }

    protected void setUriagegkType(String type) {
        uriagegkType = type;
        uriagegk = Optional.fromNullable(toCurrencyType(uriagegkType))
            .transform(bizCurrencyTransformer(getUriagegkValue()))
            .orNull();
    }

    private BizCurrency zeisoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZeisoukin() {
        return zeisoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZeisoukin(BizCurrency pZeisoukin) {
        zeisoukin = pZeisoukin;
        zeisoukinValue = null;
        zeisoukinType  = null;
    }

    transient private BigDecimal zeisoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZEISOUKIN, nullable=true)
    protected BigDecimal getZeisoukinValue() {
        if (zeisoukinValue == null && zeisoukin != null) {
            if (zeisoukin.isOptional()) return null;
            return zeisoukin.absolute();
        }
        return zeisoukinValue;
    }

    protected void setZeisoukinValue(BigDecimal value) {
        zeisoukinValue = value;
        zeisoukin = Optional.fromNullable(toCurrencyType(zeisoukinType))
            .transform(bizCurrencyTransformer(getZeisoukinValue()))
            .orNull();
    }

    transient private String zeisoukinType = null;

    @Column(name=ZEISOUKIN + "$", nullable=true)
    protected String getZeisoukinType() {
        if (zeisoukinType == null && zeisoukin != null) return zeisoukin.getType().toString();
        if (zeisoukinType == null && getZeisoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zeisoukin$' should not be NULL."));
        }
        return zeisoukinType;
    }

    protected void setZeisoukinType(String type) {
        zeisoukinType = type;
        zeisoukin = Optional.fromNullable(toCurrencyType(zeisoukinType))
            .transform(bizCurrencyTransformer(getZeisoukinValue()))
            .orNull();
    }

    private BizCurrency uriagegoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getUriagegoukei() {
        return uriagegoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUriagegoukei(BizCurrency pUriagegoukei) {
        uriagegoukei = pUriagegoukei;
        uriagegoukeiValue = null;
        uriagegoukeiType  = null;
    }

    transient private BigDecimal uriagegoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=URIAGEGOUKEI, nullable=true)
    protected BigDecimal getUriagegoukeiValue() {
        if (uriagegoukeiValue == null && uriagegoukei != null) {
            if (uriagegoukei.isOptional()) return null;
            return uriagegoukei.absolute();
        }
        return uriagegoukeiValue;
    }

    protected void setUriagegoukeiValue(BigDecimal value) {
        uriagegoukeiValue = value;
        uriagegoukei = Optional.fromNullable(toCurrencyType(uriagegoukeiType))
            .transform(bizCurrencyTransformer(getUriagegoukeiValue()))
            .orNull();
    }

    transient private String uriagegoukeiType = null;

    @Column(name=URIAGEGOUKEI + "$", nullable=true)
    protected String getUriagegoukeiType() {
        if (uriagegoukeiType == null && uriagegoukei != null) return uriagegoukei.getType().toString();
        if (uriagegoukeiType == null && getUriagegoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'uriagegoukei$' should not be NULL."));
        }
        return uriagegoukeiType;
    }

    protected void setUriagegoukeiType(String type) {
        uriagegoukeiType = type;
        uriagegoukei = Optional.fromNullable(toCurrencyType(uriagegoukeiType))
            .transform(bizCurrencyTransformer(getUriagegoukeiValue()))
            .orNull();
    }

    private String syouninno;

    @Column(name=GenIT_KhUriageKekkaData.SYOUNINNO)
    @MaxLength(max=6)
    @Digit
    public String getSyouninno() {
        return syouninno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyouninno(String pSyouninno) {
        syouninno = pSyouninno;
    }

    private String creditcardno1;

    @Column(name=GenIT_KhUriageKekkaData.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_KhUriageKekkaData.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_KhUriageKekkaData.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_KhUriageKekkaData.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String creditcardykkigen;

    @Column(name=GenIT_KhUriageKekkaData.CREDITCARDYKKIGEN)
    public String getCreditcardykkigen() {
        return creditcardykkigen;
    }

    public void setCreditcardykkigen(String pCreditcardykkigen) {
        creditcardykkigen = pCreditcardykkigen;
    }

    private String cardkaisyacd;

    @Column(name=GenIT_KhUriageKekkaData.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private C_UriagekekkaKbn uriagekekkakbn;

    @Type(type="UserType_C_UriagekekkaKbn")
    @Column(name=GenIT_KhUriageKekkaData.URIAGEKEKKAKBN)
    public C_UriagekekkaKbn getUriagekekkakbn() {
        return uriagekekkakbn;
    }

    public void setUriagekekkakbn(C_UriagekekkaKbn pUriagekekkakbn) {
        uriagekekkakbn = pUriagekekkakbn;
    }

    private C_Creditbrerrorcd creditbrerrorcd;

    @Type(type="UserType_C_Creditbrerrorcd")
    @Column(name=GenIT_KhUriageKekkaData.CREDITBRERRORCD)
    public C_Creditbrerrorcd getCreditbrerrorcd() {
        return creditbrerrorcd;
    }

    public void setCreditbrerrorcd(C_Creditbrerrorcd pCreditbrerrorcd) {
        creditbrerrorcd = pCreditbrerrorcd;
    }

    private Integer authorikaisuu;

    @Column(name=GenIT_KhUriageKekkaData.AUTHORIKAISUU)
    public Integer getAuthorikaisuu() {
        return authorikaisuu;
    }

    public void setAuthorikaisuu(Integer pAuthorikaisuu) {
        authorikaisuu = pAuthorikaisuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhUriageKekkaData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhUriageKekkaData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhUriageKekkaData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}