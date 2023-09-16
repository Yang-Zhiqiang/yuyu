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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyuukeilvKbn;
import yuyu.def.db.entity.IT_KhUriageData;
import yuyu.def.db.id.PKIT_KhUriageData;
import yuyu.def.db.meta.GenQIT_KhUriageData;
import yuyu.def.db.meta.QIT_KhUriageData;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_SyuukeilvKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上データテーブル テーブルのマッピング情報クラスで、 {@link IT_KhUriageData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhUriageData}</td><td colspan="3">売上データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKIT_KhUriageData ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_KhUriageData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhUriageData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorikaisuu authorikaisuu}</td><td>オーソリ回数</td><td align="center">{@link PKIT_KhUriageData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardykkigen creditcardykkigen}</td><td>クレジットカード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuukeilvkbn syuukeilvkbn}</td><td>集計レベル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuukeilvKbn}</td></tr>
 *  <tr><td>{@link #getAuthorigk authorigk}</td><td>オーソリ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUriagegk uriagegk}</td><td>売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUriageymd uriageymd}</td><td>売上日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigousdicode hokensyuruikigousdicode}</td><td>保険種類記号世代コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigoukktkmk1 hknsyukigoukktkmk1}</td><td>保険種類記号拡張項目１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getHknsyukigoukktkmk2 hknsyukigoukktkmk2}</td><td>保険種類記号拡張項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigoukktkmk3 hknsyukigoukktkmk3}</td><td>保険種類記号拡張項目３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getKameitenno kameitenno}</td><td>加盟店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKameitennm25 kameitennm25}</td><td>加盟店名（２５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredittsryritu credittsryritu}</td><td>クレジット手数料率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhUriageData
 * @see     PKIT_KhUriageData
 * @see     QIT_KhUriageData
 * @see     GenQIT_KhUriageData
 */
@MappedSuperclass
@Table(name=GenIT_KhUriageData.TABLE_NAME)
@IdClass(value=PKIT_KhUriageData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_SyuukeilvKbn", typeClass=UserType_C_SyuukeilvKbn.class)
})
public abstract class GenIT_KhUriageData extends AbstractExDBEntity<IT_KhUriageData, PKIT_KhUriageData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhUriageData";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String AUTHORIKAISUU            = "authorikaisuu";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITCARDYKKIGEN        = "creditcardykkigen";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String SYUUKEILVKBN             = "syuukeilvkbn";
    public static final String AUTHORIGK                = "authorigk";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String URIAGEGK                 = "uriagegk";
    public static final String URIAGEYMD                = "uriageymd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HOKENSYURUIKIGOUSDICODE  = "hokensyuruikigousdicode";
    public static final String HKNSYUKIGOUKKTKMK1       = "hknsyukigoukktkmk1";
    public static final String HKNSYUKIGOUKKTKMK2       = "hknsyukigoukktkmk2";
    public static final String HKNSYUKIGOUKKTKMK3       = "hknsyukigoukktkmk3";
    public static final String KAMEITENNO               = "kameitenno";
    public static final String KAMEITENNM25             = "kameitennm25";
    public static final String CREDITTSRYRITU           = "credittsryritu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhUriageData primaryKey;

    public GenIT_KhUriageData() {
        primaryKey = new PKIT_KhUriageData();
    }

    public GenIT_KhUriageData(
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pSyono,
        Integer pAuthorikaisuu
    ) {
        primaryKey = new PKIT_KhUriageData(
            pAnsyuusyskbn,
            pSyoriYmd,
            pSyono,
            pAuthorikaisuu
        );
    }

    @Transient
    @Override
    public PKIT_KhUriageData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhUriageData> getMetaClass() {
        return QIT_KhUriageData.class;
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenIT_KhUriageData.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KhUriageData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_KhUriageData.SYONO)
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
    @Column(name=GenIT_KhUriageData.AUTHORIKAISUU)
    public Integer getAuthorikaisuu() {
        return getPrimaryKey().getAuthorikaisuu();
    }

    public void setAuthorikaisuu(Integer pAuthorikaisuu) {
        getPrimaryKey().setAuthorikaisuu(pAuthorikaisuu);
    }

    private String creditcardno1;

    @Column(name=GenIT_KhUriageData.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_KhUriageData.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_KhUriageData.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_KhUriageData.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String creditcardykkigen;

    @Column(name=GenIT_KhUriageData.CREDITCARDYKKIGEN)
    public String getCreditcardykkigen() {
        return creditcardykkigen;
    }

    public void setCreditcardykkigen(String pCreditcardykkigen) {
        creditcardykkigen = pCreditcardykkigen;
    }

    private String cardkaisyacd;

    @Column(name=GenIT_KhUriageData.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private C_SyuukeilvKbn syuukeilvkbn;

    @Type(type="UserType_C_SyuukeilvKbn")
    @Column(name=GenIT_KhUriageData.SYUUKEILVKBN)
    public C_SyuukeilvKbn getSyuukeilvkbn() {
        return syuukeilvkbn;
    }

    public void setSyuukeilvkbn(C_SyuukeilvKbn pSyuukeilvkbn) {
        syuukeilvkbn = pSyuukeilvkbn;
    }

    private BizCurrency authorigk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getAuthorigk() {
        return authorigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorigk(BizCurrency pAuthorigk) {
        authorigk = pAuthorigk;
        authorigkValue = null;
        authorigkType  = null;
    }

    transient private BigDecimal authorigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AUTHORIGK, nullable=true)
    protected BigDecimal getAuthorigkValue() {
        if (authorigkValue == null && authorigk != null) {
            if (authorigk.isOptional()) return null;
            return authorigk.absolute();
        }
        return authorigkValue;
    }

    protected void setAuthorigkValue(BigDecimal value) {
        authorigkValue = value;
        authorigk = Optional.fromNullable(toCurrencyType(authorigkType))
            .transform(bizCurrencyTransformer(getAuthorigkValue()))
            .orNull();
    }

    transient private String authorigkType = null;

    @Column(name=AUTHORIGK + "$", nullable=true)
    protected String getAuthorigkType() {
        if (authorigkType == null && authorigk != null) return authorigk.getType().toString();
        if (authorigkType == null && getAuthorigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'authorigk$' should not be NULL."));
        }
        return authorigkType;
    }

    protected void setAuthorigkType(String type) {
        authorigkType = type;
        authorigk = Optional.fromNullable(toCurrencyType(authorigkType))
            .transform(bizCurrencyTransformer(getAuthorigkValue()))
            .orNull();
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhUriageData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_KhUriageData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
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

    private BizDate uriageymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhUriageData.URIAGEYMD)
    public BizDate getUriageymd() {
        return uriageymd;
    }

    public void setUriageymd(BizDate pUriageymd) {
        uriageymd = pUriageymd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_KhUriageData.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String hknsyukigou;

    @Column(name=GenIT_KhUriageData.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String hokensyuruikigousdicode;

    @Column(name=GenIT_KhUriageData.HOKENSYURUIKIGOUSDICODE)
    public String getHokensyuruikigousdicode() {
        return hokensyuruikigousdicode;
    }

    @DataConvert("toSingleByte")
    public void setHokensyuruikigousdicode(String pHokensyuruikigousdicode) {
        hokensyuruikigousdicode = pHokensyuruikigousdicode;
    }

    private Long hknsyukigoukktkmk1;

    @Column(name=GenIT_KhUriageData.HKNSYUKIGOUKKTKMK1)
    public Long getHknsyukigoukktkmk1() {
        return hknsyukigoukktkmk1;
    }

    @DataConvert("toSingleByte")
    public void setHknsyukigoukktkmk1(Long pHknsyukigoukktkmk1) {
        hknsyukigoukktkmk1 = pHknsyukigoukktkmk1;
    }

    private String hknsyukigoukktkmk2;

    @Column(name=GenIT_KhUriageData.HKNSYUKIGOUKKTKMK2)
    public String getHknsyukigoukktkmk2() {
        return hknsyukigoukktkmk2;
    }

    @DataConvert("toSingleByte")
    public void setHknsyukigoukktkmk2(String pHknsyukigoukktkmk2) {
        hknsyukigoukktkmk2 = pHknsyukigoukktkmk2;
    }

    private Long hknsyukigoukktkmk3;

    @Column(name=GenIT_KhUriageData.HKNSYUKIGOUKKTKMK3)
    public Long getHknsyukigoukktkmk3() {
        return hknsyukigoukktkmk3;
    }

    @DataConvert("toSingleByte")
    public void setHknsyukigoukktkmk3(Long pHknsyukigoukktkmk3) {
        hknsyukigoukktkmk3 = pHknsyukigoukktkmk3;
    }

    private String kameitenno;

    @Column(name=GenIT_KhUriageData.KAMEITENNO)
    public String getKameitenno() {
        return kameitenno;
    }

    @DataConvert("toSingleByte")
    public void setKameitenno(String pKameitenno) {
        kameitenno = pKameitenno;
    }

    private String kameitennm25;

    @Column(name=GenIT_KhUriageData.KAMEITENNM25)
    public String getKameitennm25() {
        return kameitennm25;
    }

    @DataConvert("toSingleByte")
    public void setKameitennm25(String pKameitennm25) {
        kameitennm25 = pKameitennm25;
    }

    private Long credittsryritu;

    @Column(name=GenIT_KhUriageData.CREDITTSRYRITU)
    public Long getCredittsryritu() {
        return credittsryritu;
    }

    @DataConvert("toSingleByte")
    public void setCredittsryritu(Long pCredittsryritu) {
        credittsryritu = pCredittsryritu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhUriageData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhUriageData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhUriageData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}