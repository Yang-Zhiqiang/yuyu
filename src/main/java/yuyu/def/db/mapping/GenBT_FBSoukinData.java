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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.id.PKBT_FBSoukinData;
import yuyu.def.db.meta.GenQBT_FBSoukinData;
import yuyu.def.db.meta.QBT_FBSoukinData;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_FbSoukinBatchKbn;
import yuyu.def.db.type.UserType_C_Gyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ＦＢ送金データテーブル テーブルのマッピング情報クラスで、 {@link BT_FBSoukinData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_FBSoukinData}</td><td colspan="3">ＦＢ送金データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">{@link PKBT_FBSoukinData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getGyoumucd gyoumucd}</td><td>業務コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Gyoumucd}</td></tr>
 *  <tr><td>{@link #getTantositucd tantositucd}</td><td>担当室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tantositucd}</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeirisyono keirisyono}</td><td>経理用証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukingk soukingk}</td><td>送金金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGaikataikagk gaikataikagk}</td><td>外貨対価額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSoukinkwsrate soukinkwsrate}</td><td>送金用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getFbsoukinbatchkbn fbsoukinbatchkbn}</td><td>ＦＢ送金バッチ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FbSoukinBatchKbn}</td></tr>
 * </table>
 * @see     BT_FBSoukinData
 * @see     PKBT_FBSoukinData
 * @see     QBT_FBSoukinData
 * @see     GenQBT_FBSoukinData
 */
@MappedSuperclass
@Table(name=GenBT_FBSoukinData.TABLE_NAME)
@IdClass(value=PKBT_FBSoukinData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_FbSoukinBatchKbn", typeClass=UserType_C_FbSoukinBatchKbn.class),
    @TypeDef(name="UserType_C_Gyoumucd", typeClass=UserType_C_Gyoumucd.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Tantositucd", typeClass=UserType_C_Tantositucd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenBT_FBSoukinData extends AbstractExDBEntity<BT_FBSoukinData, PKBT_FBSoukinData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_FBSoukinData";
    public static final String FBSOUKINDATASIKIBETUKEY  = "fbsoukindatasikibetukey";
    public static final String DENRENNO                 = "denrenno";
    public static final String EDANO                    = "edano";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String GYOUMUCD                 = "gyoumucd";
    public static final String TANTOSITUCD              = "tantositucd";
    public static final String SYORICD                  = "syoricd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DENYMD                   = "denymd";
    public static final String KEIRISYONO               = "keirisyono";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SOUKINGK                 = "soukingk";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String GAIKATAIKAGK             = "gaikataikagk";
    public static final String SOUKINKWSRATE            = "soukinkwsrate";
    public static final String FBSOUKINBATCHKBN         = "fbsoukinbatchkbn";

    private final PKBT_FBSoukinData primaryKey;

    public GenBT_FBSoukinData() {
        primaryKey = new PKBT_FBSoukinData();
    }

    public GenBT_FBSoukinData(String pFbsoukindatasikibetukey) {
        primaryKey = new PKBT_FBSoukinData(pFbsoukindatasikibetukey);
    }

    @Transient
    @Override
    public PKBT_FBSoukinData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_FBSoukinData> getMetaClass() {
        return QBT_FBSoukinData.class;
    }

    @Id
    @Column(name=GenBT_FBSoukinData.FBSOUKINDATASIKIBETUKEY)
    public String getFbsoukindatasikibetukey() {
        return getPrimaryKey().getFbsoukindatasikibetukey();
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        getPrimaryKey().setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
    }

    private String denrenno;

    @Column(name=GenBT_FBSoukinData.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Column(name=GenBT_FBSoukinData.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private C_DensysKbn densyskbn;

    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenBT_FBSoukinData.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private C_Gyoumucd gyoumucd;

    @Type(type="UserType_C_Gyoumucd")
    @Column(name=GenBT_FBSoukinData.GYOUMUCD)
    public C_Gyoumucd getGyoumucd() {
        return gyoumucd;
    }

    public void setGyoumucd(C_Gyoumucd pGyoumucd) {
        gyoumucd = pGyoumucd;
    }

    private C_Tantositucd tantositucd;

    @Type(type="UserType_C_Tantositucd")
    @Column(name=GenBT_FBSoukinData.TANTOSITUCD)
    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    public void setTantositucd(C_Tantositucd pTantositucd) {
        tantositucd = pTantositucd;
    }

    private String syoricd;

    @Column(name=GenBT_FBSoukinData.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Column(name=GenBT_FBSoukinData.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenBT_FBSoukinData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDate denymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_FBSoukinData.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private String keirisyono;

    @Column(name=GenBT_FBSoukinData.KEIRISYONO)
    public String getKeirisyono() {
        return keirisyono;
    }

    public void setKeirisyono(String pKeirisyono) {
        keirisyono = pKeirisyono;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenBT_FBSoukinData.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenBT_FBSoukinData.BANKCD)
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

    private String sitencd;

    @Column(name=GenBT_FBSoukinData.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenBT_FBSoukinData.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenBT_FBSoukinData.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private String kzmeiginmkn;

    @Column(name=GenBT_FBSoukinData.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private BizCurrency soukingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSoukingk() {
        return soukingk;
    }

    public void setSoukingk(BizCurrency pSoukingk) {
        soukingk = pSoukingk;
        soukingkValue = null;
        soukingkType  = null;
    }

    transient private BigDecimal soukingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SOUKINGK, nullable=true)
    protected BigDecimal getSoukingkValue() {
        if (soukingkValue == null && soukingk != null) {
            if (soukingk.isOptional()) return null;
            return soukingk.absolute();
        }
        return soukingkValue;
    }

    protected void setSoukingkValue(BigDecimal value) {
        soukingkValue = value;
        soukingk = Optional.fromNullable(toCurrencyType(soukingkType))
            .transform(bizCurrencyTransformer(getSoukingkValue()))
            .orNull();
    }

    transient private String soukingkType = null;

    @Column(name=SOUKINGK + "$", nullable=true)
    protected String getSoukingkType() {
        if (soukingkType == null && soukingk != null) return soukingk.getType().toString();
        if (soukingkType == null && getSoukingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'soukingk$' should not be NULL."));
        }
        return soukingkType;
    }

    protected void setSoukingkType(String type) {
        soukingkType = type;
        soukingk = Optional.fromNullable(toCurrencyType(soukingkType))
            .transform(bizCurrencyTransformer(getSoukingkValue()))
            .orNull();
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_FBSoukinData.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency gaikataikagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikataikagk() {
        return gaikataikagk;
    }

    public void setGaikataikagk(BizCurrency pGaikataikagk) {
        gaikataikagk = pGaikataikagk;
        gaikataikagkValue = null;
        gaikataikagkType  = null;
    }

    transient private BigDecimal gaikataikagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKATAIKAGK, nullable=true)
    protected BigDecimal getGaikataikagkValue() {
        if (gaikataikagkValue == null && gaikataikagk != null) {
            if (gaikataikagk.isOptional()) return null;
            return gaikataikagk.absolute();
        }
        return gaikataikagkValue;
    }

    protected void setGaikataikagkValue(BigDecimal value) {
        gaikataikagkValue = value;
        gaikataikagk = Optional.fromNullable(toCurrencyType(gaikataikagkType))
            .transform(bizCurrencyTransformer(getGaikataikagkValue()))
            .orNull();
    }

    transient private String gaikataikagkType = null;

    @Column(name=GAIKATAIKAGK + "$", nullable=true)
    protected String getGaikataikagkType() {
        if (gaikataikagkType == null && gaikataikagk != null) return gaikataikagk.getType().toString();
        if (gaikataikagkType == null && getGaikataikagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikataikagk$' should not be NULL."));
        }
        return gaikataikagkType;
    }

    protected void setGaikataikagkType(String type) {
        gaikataikagkType = type;
        gaikataikagk = Optional.fromNullable(toCurrencyType(gaikataikagkType))
            .transform(bizCurrencyTransformer(getGaikataikagkValue()))
            .orNull();
    }

    private BizNumber soukinkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenBT_FBSoukinData.SOUKINKWSRATE)
    public BizNumber getSoukinkwsrate() {
        return soukinkwsrate;
    }

    public void setSoukinkwsrate(BizNumber pSoukinkwsrate) {
        soukinkwsrate = pSoukinkwsrate;
    }

    private C_FbSoukinBatchKbn fbsoukinbatchkbn;

    @Type(type="UserType_C_FbSoukinBatchKbn")
    @Column(name=GenBT_FBSoukinData.FBSOUKINBATCHKBN)
    public C_FbSoukinBatchKbn getFbsoukinbatchkbn() {
        return fbsoukinbatchkbn;
    }

    public void setFbsoukinbatchkbn(C_FbSoukinBatchKbn pFbsoukinbatchkbn) {
        fbsoukinbatchkbn = pFbsoukinbatchkbn;
    }
}