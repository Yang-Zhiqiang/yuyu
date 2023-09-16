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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.id.PKHT_SkLincTourokuInfo;
import yuyu.def.db.meta.GenQHT_SkLincTourokuInfo;
import yuyu.def.db.meta.QHT_SkLincTourokuInfo;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約ＬＩＮＣ登録情報テーブル テーブルのマッピング情報クラスで、 {@link HT_SkLincTourokuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincTourokuInfo}</td><td colspan="3">新契約ＬＩＮＣ登録情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkLincTourokuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanyuusyano kanyuusyano}</td><td>加入者番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknadrlinckn30 hhknadrlinckn30}</td><td>被保険者住所（ＬＩＮＣ用カナ）３０桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykadrlinckn30 kykadrlinckn30}</td><td>契約者住所（ＬＩＮＣ用カナ）３０桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkmousideymd trkmousideymd}</td><td>登録申出年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykytymd kykytymd}</td><td>契約予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSgnyung sgnyung}</td><td>災害入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSipnyung sipnyung}</td><td>疾病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSjnyung sjnyung}</td><td>成人病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyuinng sonotanyuinng}</td><td>その他入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHutuusb hutuusb}</td><td>普通死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSgsbksns sgsbksns}</td><td>災害死亡時加算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincTourokuInfo
 * @see     PKHT_SkLincTourokuInfo
 * @see     QHT_SkLincTourokuInfo
 * @see     GenQHT_SkLincTourokuInfo
 */
@MappedSuperclass
@Table(name=GenHT_SkLincTourokuInfo.TABLE_NAME)
@IdClass(value=PKHT_SkLincTourokuInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class)
})
public abstract class GenHT_SkLincTourokuInfo extends AbstractExDBEntity<HT_SkLincTourokuInfo, PKHT_SkLincTourokuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkLincTourokuInfo";
    public static final String MOSNO                    = "mosno";
    public static final String KANYUUSYANO              = "kanyuusyano";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNADRLINCKN30          = "hhknadrlinckn30";
    public static final String KYKKBN                   = "kykkbn";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKSEI                   = "kyksei";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKADRLINCKN30           = "kykadrlinckn30";
    public static final String TRKMOUSIDEYMD            = "trkmousideymd";
    public static final String KYKYTYMD                 = "kykytymd";
    public static final String SGNYUNG                  = "sgnyung";
    public static final String SIPNYUNG                 = "sipnyung";
    public static final String SJNYUNG                  = "sjnyung";
    public static final String SONOTANYUINNG            = "sonotanyuinng";
    public static final String HUTUUSB                  = "hutuusb";
    public static final String SGSBKSNS                 = "sgsbksns";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkLincTourokuInfo primaryKey;

    public GenHT_SkLincTourokuInfo() {
        primaryKey = new PKHT_SkLincTourokuInfo();
    }

    public GenHT_SkLincTourokuInfo(String pMosno) {
        primaryKey = new PKHT_SkLincTourokuInfo(pMosno);
    }

    @Transient
    @Override
    public PKHT_SkLincTourokuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkLincTourokuInfo> getMetaClass() {
        return QHT_SkLincTourokuInfo.class;
    }

    @Id
    @Column(name=GenHT_SkLincTourokuInfo.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private Long kanyuusyano;

    @Column(name=GenHT_SkLincTourokuInfo.KANYUUSYANO)
    public Long getKanyuusyano() {
        return kanyuusyano;
    }

    public void setKanyuusyano(Long pKanyuusyano) {
        kanyuusyano = pKanyuusyano;
    }

    private String hhknnmkn;

    @Column(name=GenHT_SkLincTourokuInfo.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenHT_SkLincTourokuInfo.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenHT_SkLincTourokuInfo.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincTourokuInfo.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private String hhknadrlinckn30;

    @Column(name=GenHT_SkLincTourokuInfo.HHKNADRLINCKN30)
    public String getHhknadrlinckn30() {
        return hhknadrlinckn30;
    }

    public void setHhknadrlinckn30(String pHhknadrlinckn30) {
        hhknadrlinckn30 = pHhknadrlinckn30;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenHT_SkLincTourokuInfo.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private String kyknmkn;

    @Column(name=GenHT_SkLincTourokuInfo.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenHT_SkLincTourokuInfo.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenHT_SkLincTourokuInfo.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincTourokuInfo.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private String kykadrlinckn30;

    @Column(name=GenHT_SkLincTourokuInfo.KYKADRLINCKN30)
    public String getKykadrlinckn30() {
        return kykadrlinckn30;
    }

    public void setKykadrlinckn30(String pKykadrlinckn30) {
        kykadrlinckn30 = pKykadrlinckn30;
    }

    private BizDate trkmousideymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincTourokuInfo.TRKMOUSIDEYMD)
    public BizDate getTrkmousideymd() {
        return trkmousideymd;
    }

    public void setTrkmousideymd(BizDate pTrkmousideymd) {
        trkmousideymd = pTrkmousideymd;
    }

    private BizDate kykytymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincTourokuInfo.KYKYTYMD)
    public BizDate getKykytymd() {
        return kykytymd;
    }

    public void setKykytymd(BizDate pKykytymd) {
        kykytymd = pKykytymd;
    }

    private BizCurrency sgnyung;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSgnyung() {
        return sgnyung;
    }

    public void setSgnyung(BizCurrency pSgnyung) {
        sgnyung = pSgnyung;
        sgnyungValue = null;
        sgnyungType  = null;
    }

    transient private BigDecimal sgnyungValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGNYUNG, nullable=true)
    protected BigDecimal getSgnyungValue() {
        if (sgnyungValue == null && sgnyung != null) {
            if (sgnyung.isOptional()) return null;
            return sgnyung.absolute();
        }
        return sgnyungValue;
    }

    protected void setSgnyungValue(BigDecimal value) {
        sgnyungValue = value;
        sgnyung = Optional.fromNullable(toCurrencyType(sgnyungType))
            .transform(bizCurrencyTransformer(getSgnyungValue()))
            .orNull();
    }

    transient private String sgnyungType = null;

    @Column(name=SGNYUNG + "$", nullable=true)
    protected String getSgnyungType() {
        if (sgnyungType == null && sgnyung != null) return sgnyung.getType().toString();
        if (sgnyungType == null && getSgnyungValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sgnyung$' should not be NULL."));
        }
        return sgnyungType;
    }

    protected void setSgnyungType(String type) {
        sgnyungType = type;
        sgnyung = Optional.fromNullable(toCurrencyType(sgnyungType))
            .transform(bizCurrencyTransformer(getSgnyungValue()))
            .orNull();
    }

    private BizCurrency sipnyung;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSipnyung() {
        return sipnyung;
    }

    public void setSipnyung(BizCurrency pSipnyung) {
        sipnyung = pSipnyung;
        sipnyungValue = null;
        sipnyungType  = null;
    }

    transient private BigDecimal sipnyungValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIPNYUNG, nullable=true)
    protected BigDecimal getSipnyungValue() {
        if (sipnyungValue == null && sipnyung != null) {
            if (sipnyung.isOptional()) return null;
            return sipnyung.absolute();
        }
        return sipnyungValue;
    }

    protected void setSipnyungValue(BigDecimal value) {
        sipnyungValue = value;
        sipnyung = Optional.fromNullable(toCurrencyType(sipnyungType))
            .transform(bizCurrencyTransformer(getSipnyungValue()))
            .orNull();
    }

    transient private String sipnyungType = null;

    @Column(name=SIPNYUNG + "$", nullable=true)
    protected String getSipnyungType() {
        if (sipnyungType == null && sipnyung != null) return sipnyung.getType().toString();
        if (sipnyungType == null && getSipnyungValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sipnyung$' should not be NULL."));
        }
        return sipnyungType;
    }

    protected void setSipnyungType(String type) {
        sipnyungType = type;
        sipnyung = Optional.fromNullable(toCurrencyType(sipnyungType))
            .transform(bizCurrencyTransformer(getSipnyungValue()))
            .orNull();
    }

    private BizCurrency sjnyung;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSjnyung() {
        return sjnyung;
    }

    public void setSjnyung(BizCurrency pSjnyung) {
        sjnyung = pSjnyung;
        sjnyungValue = null;
        sjnyungType  = null;
    }

    transient private BigDecimal sjnyungValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SJNYUNG, nullable=true)
    protected BigDecimal getSjnyungValue() {
        if (sjnyungValue == null && sjnyung != null) {
            if (sjnyung.isOptional()) return null;
            return sjnyung.absolute();
        }
        return sjnyungValue;
    }

    protected void setSjnyungValue(BigDecimal value) {
        sjnyungValue = value;
        sjnyung = Optional.fromNullable(toCurrencyType(sjnyungType))
            .transform(bizCurrencyTransformer(getSjnyungValue()))
            .orNull();
    }

    transient private String sjnyungType = null;

    @Column(name=SJNYUNG + "$", nullable=true)
    protected String getSjnyungType() {
        if (sjnyungType == null && sjnyung != null) return sjnyung.getType().toString();
        if (sjnyungType == null && getSjnyungValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sjnyung$' should not be NULL."));
        }
        return sjnyungType;
    }

    protected void setSjnyungType(String type) {
        sjnyungType = type;
        sjnyung = Optional.fromNullable(toCurrencyType(sjnyungType))
            .transform(bizCurrencyTransformer(getSjnyungValue()))
            .orNull();
    }

    private BizCurrency sonotanyuinng;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyuinng() {
        return sonotanyuinng;
    }

    public void setSonotanyuinng(BizCurrency pSonotanyuinng) {
        sonotanyuinng = pSonotanyuinng;
        sonotanyuinngValue = null;
        sonotanyuinngType  = null;
    }

    transient private BigDecimal sonotanyuinngValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYUINNG, nullable=true)
    protected BigDecimal getSonotanyuinngValue() {
        if (sonotanyuinngValue == null && sonotanyuinng != null) {
            if (sonotanyuinng.isOptional()) return null;
            return sonotanyuinng.absolute();
        }
        return sonotanyuinngValue;
    }

    protected void setSonotanyuinngValue(BigDecimal value) {
        sonotanyuinngValue = value;
        sonotanyuinng = Optional.fromNullable(toCurrencyType(sonotanyuinngType))
            .transform(bizCurrencyTransformer(getSonotanyuinngValue()))
            .orNull();
    }

    transient private String sonotanyuinngType = null;

    @Column(name=SONOTANYUINNG + "$", nullable=true)
    protected String getSonotanyuinngType() {
        if (sonotanyuinngType == null && sonotanyuinng != null) return sonotanyuinng.getType().toString();
        if (sonotanyuinngType == null && getSonotanyuinngValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyuinng$' should not be NULL."));
        }
        return sonotanyuinngType;
    }

    protected void setSonotanyuinngType(String type) {
        sonotanyuinngType = type;
        sonotanyuinng = Optional.fromNullable(toCurrencyType(sonotanyuinngType))
            .transform(bizCurrencyTransformer(getSonotanyuinngValue()))
            .orNull();
    }

    private BizCurrency hutuusb;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHutuusb() {
        return hutuusb;
    }

    public void setHutuusb(BizCurrency pHutuusb) {
        hutuusb = pHutuusb;
        hutuusbValue = null;
        hutuusbType  = null;
    }

    transient private BigDecimal hutuusbValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HUTUUSB, nullable=true)
    protected BigDecimal getHutuusbValue() {
        if (hutuusbValue == null && hutuusb != null) {
            if (hutuusb.isOptional()) return null;
            return hutuusb.absolute();
        }
        return hutuusbValue;
    }

    protected void setHutuusbValue(BigDecimal value) {
        hutuusbValue = value;
        hutuusb = Optional.fromNullable(toCurrencyType(hutuusbType))
            .transform(bizCurrencyTransformer(getHutuusbValue()))
            .orNull();
    }

    transient private String hutuusbType = null;

    @Column(name=HUTUUSB + "$", nullable=true)
    protected String getHutuusbType() {
        if (hutuusbType == null && hutuusb != null) return hutuusb.getType().toString();
        if (hutuusbType == null && getHutuusbValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hutuusb$' should not be NULL."));
        }
        return hutuusbType;
    }

    protected void setHutuusbType(String type) {
        hutuusbType = type;
        hutuusb = Optional.fromNullable(toCurrencyType(hutuusbType))
            .transform(bizCurrencyTransformer(getHutuusbValue()))
            .orNull();
    }

    private BizCurrency sgsbksns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSgsbksns() {
        return sgsbksns;
    }

    public void setSgsbksns(BizCurrency pSgsbksns) {
        sgsbksns = pSgsbksns;
        sgsbksnsValue = null;
        sgsbksnsType  = null;
    }

    transient private BigDecimal sgsbksnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGSBKSNS, nullable=true)
    protected BigDecimal getSgsbksnsValue() {
        if (sgsbksnsValue == null && sgsbksns != null) {
            if (sgsbksns.isOptional()) return null;
            return sgsbksns.absolute();
        }
        return sgsbksnsValue;
    }

    protected void setSgsbksnsValue(BigDecimal value) {
        sgsbksnsValue = value;
        sgsbksns = Optional.fromNullable(toCurrencyType(sgsbksnsType))
            .transform(bizCurrencyTransformer(getSgsbksnsValue()))
            .orNull();
    }

    transient private String sgsbksnsType = null;

    @Column(name=SGSBKSNS + "$", nullable=true)
    protected String getSgsbksnsType() {
        if (sgsbksnsType == null && sgsbksns != null) return sgsbksns.getType().toString();
        if (sgsbksnsType == null && getSgsbksnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sgsbksns$' should not be NULL."));
        }
        return sgsbksnsType;
    }

    protected void setSgsbksnsType(String type) {
        sgsbksnsType = type;
        sgsbksns = Optional.fromNullable(toCurrencyType(sgsbksnsType))
            .transform(bizCurrencyTransformer(getSgsbksnsValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkLincTourokuInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkLincTourokuInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}